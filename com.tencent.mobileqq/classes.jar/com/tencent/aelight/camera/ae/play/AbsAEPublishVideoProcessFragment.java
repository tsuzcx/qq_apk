package com.tencent.aelight.camera.ae.play;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.AEKitForQQ;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.aeeditor.AEEditorProcessManager;
import com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment;
import com.tencent.aelight.camera.aeeditor.module.params.ParamFactory;
import com.tencent.aelight.camera.aeeditor.module.params.VideoParamStrategy;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tavcut.TAVCut;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsAEPublishVideoProcessFragment
  extends PublicBaseFragment
{
  private static final String TAG = "AbsAEPublishVideoProces";
  private Dialog mLoadingDialog;
  protected MoviePlayer mMoviePlayer;
  protected String missionId;
  protected TAVCutVideoSession tavCutVideoSession;
  protected TAVCutVideoView tavCutVideoView;
  private VideoParamStrategy videoParam = ParamFactory.a();
  
  private String getMissionId()
  {
    Log.d("AbsAEPublishVideoProces", "missionId尝试获取");
    Bundle localBundle = getArguments();
    String str1;
    if (getBaseActivity().getIntent().getExtras() != null) {
      str1 = getBaseActivity().getIntent().getStringExtra("key_ae_video_mission_id");
    } else {
      str1 = "";
    }
    String str2 = str1;
    if (StringUtil.a(str1))
    {
      str2 = str1;
      if (localBundle != null)
      {
        str2 = str1;
        if (localBundle.containsKey("key_ae_video_mission_id")) {
          str2 = localBundle.getString("key_ae_video_mission_id");
        }
      }
    }
    return str2;
  }
  
  private void initTavCutAndPlayer()
  {
    Log.d("AbsAEPublishVideoProces", "initTavCutAndPlayer: 开始初始化tavcutsession、moviePlayer");
    MediaModel localMediaModel = AEEditorProcessManager.a().a(this.missionId);
    if ((!StringUtil.a(this.missionId)) && (!isMediaModelBroken(localMediaModel)))
    {
      localObject = ((MediaClipModel)localMediaModel.getMediaResourceModel().getVideos().get(0)).getResource();
      this.mMoviePlayer = new MoviePlayer();
      this.mMoviePlayer.setLoopPlay(true);
      this.mMoviePlayer.setBackColor(getPlayerBackColor());
      this.tavCutVideoSession = new TAVCutVideoSession();
      SessionConfig localSessionConfig = new SessionConfig();
      localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
      localSessionConfig.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
      localSessionConfig.setMaxIntermediateRenderSize(this.videoParam.a());
      String str = this.missionId;
      if ((str != null) && (str.startsWith("multi_video_")))
      {
        AEEditorVideoEditFragment.a(getBaseActivity(), this.tavCutVideoSession, this.videoParam, localMediaModel, this.mMoviePlayer, this.tavCutVideoView);
        this.tavCutVideoSession.restoreStickersWithLyric(new ArrayList(localMediaModel.getMediaEffectModel().getStickerModelList()));
      }
      else
      {
        this.tavCutVideoSession.setSessionConfig(localSessionConfig);
        this.tavCutVideoSession.setVideoPath(((VideoResourceModel)localObject).getPath());
        this.tavCutVideoSession.setMediaModel(localMediaModel);
        this.tavCutVideoSession.addPlayer(this.mMoviePlayer);
        this.tavCutVideoSession.setTAVCutVideoView(this.tavCutVideoView);
        this.tavCutVideoSession.init(getBaseActivity());
        this.tavCutVideoSession.setClip(Long.valueOf(((VideoResourceModel)localObject).getSelectTimeStart()), Long.valueOf(((VideoResourceModel)localObject).getSelectTimeDuration()), true);
      }
      this.tavCutVideoSession.setStickerTouchEnable(false);
      customizeBindingData((VideoResourceModel)localObject);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("missionId异常！合成model损坏：");
    ((StringBuilder)localObject).append(isMediaModelBroken(localMediaModel));
    Log.e("AbsAEPublishVideoProces", ((StringBuilder)localObject).toString());
    QQToast.a(getBaseActivity(), "视频合成信息异常", 0).a();
  }
  
  private boolean isMediaModelBroken(MediaModel paramMediaModel)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("检查损坏：mediaModel = ");
    localStringBuilder.append(paramMediaModel);
    Log.e("AbsAEPublishVideoProces", localStringBuilder.toString());
    boolean bool2 = true;
    if (paramMediaModel != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("损坏原因：videos.size = 0 ");
      if (paramMediaModel.getMediaResourceModel().getVideos().size() == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      Log.e("AbsAEPublishVideoProces", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("损坏原因：video == null ");
      if (paramMediaModel.getMediaResourceModel().getVideos().get(0) == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      Log.e("AbsAEPublishVideoProces", localStringBuilder.toString());
    }
    boolean bool1 = bool2;
    if (paramMediaModel != null)
    {
      bool1 = bool2;
      if (paramMediaModel.getMediaResourceModel().getVideos().size() != 0)
      {
        if (paramMediaModel.getMediaResourceModel().getVideos().get(0) == null) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  abstract void bindViews(View paramView);
  
  abstract void customizeBindingData(VideoResourceModel paramVideoResourceModel);
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      getBaseActivity().setResult(0);
      getBaseActivity().finish();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected abstract int getLayoutId();
  
  protected String getMediaPath()
  {
    Log.d("AbsAEPublishVideoProces", "MediaPath尝试获取");
    Bundle localBundle = getArguments();
    String str1;
    if (getBaseActivity().getIntent().getExtras() != null) {
      str1 = getBaseActivity().getIntent().getStringExtra("key_video_media_path");
    } else {
      str1 = "";
    }
    String str2 = str1;
    if (StringUtil.a(str1))
    {
      str2 = str1;
      if (localBundle != null)
      {
        str2 = str1;
        if (localBundle.containsKey("key_video_media_path")) {
          str2 = localBundle.getString("key_video_media_path");
        }
      }
    }
    return str2;
  }
  
  protected int getMediaPosition()
  {
    Log.d("AbsAEPublishVideoProces", "mediaPosition尝试获取");
    Bundle localBundle = getArguments();
    int i;
    if (getBaseActivity().getIntent().getExtras() != null) {
      i = getBaseActivity().getIntent().getIntExtra("key_video_media_position", -1);
    } else {
      i = 0;
    }
    int j = i;
    if (i == -1)
    {
      j = i;
      if (localBundle != null)
      {
        j = i;
        if (localBundle.containsKey("key_video_media_position")) {
          j = localBundle.getInt("key_video_media_position", 0);
        }
      }
    }
    return j;
  }
  
  protected int getPlayerBackColor()
  {
    return getResources().getColor(2063925309);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if ((getBaseActivity() != null) && (!getBaseActivity().isFinishing()))
    {
      getBaseActivity().setResult(0);
      getBaseActivity().finish();
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.missionId = getMissionId();
    AEKitForQQ.a();
    FeatureManager.Features.YT_COMMON.init();
    FeatureManager.Features.PTU_TOOLS.init();
    FeatureManager.Features.PTU_ALGO.init();
    FeatureManager.Features.LIGHT_SDK.init();
    FeatureManager.Features.IMAGE_ALGO.init();
    TAVCut.initTAVCut(getBaseActivity(), FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), AEResUtil.g(), new AbsAEPublishVideoProcessFragment.1(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false);
  }
  
  public void onFinish()
  {
    this.mMoviePlayer.release();
    this.tavCutVideoSession.release();
    super.onFinish();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    bindViews(paramView);
    initTavCutAndPlayer();
  }
  
  protected void showLoading(boolean paramBoolean)
  {
    if (!getBaseActivity().isFinishing())
    {
      if (paramBoolean)
      {
        if (this.mLoadingDialog == null)
        {
          this.mLoadingDialog = new Dialog(getBaseActivity(), 2131756189);
          this.mLoadingDialog.setCancelable(false);
          this.mLoadingDialog.setCanceledOnTouchOutside(false);
          this.mLoadingDialog.setContentView(2131559561);
          ((TextView)this.mLoadingDialog.findViewById(2131372646)).setText("正在保存封面...");
        }
        this.mLoadingDialog.show();
        return;
      }
      Dialog localDialog = this.mLoadingDialog;
      if ((localDialog != null) && (localDialog.isShowing())) {
        this.mLoadingDialog.dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AbsAEPublishVideoProcessFragment
 * JD-Core Version:    0.7.0.1
 */