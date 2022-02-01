package com.tencent.aelight.camera.ae.biz.circle;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.album.data.AEAlbumImageModel;
import com.tencent.aelight.camera.ae.album.data.AEAlbumMediaBaseModel;
import com.tencent.aelight.camera.ae.album.data.AEPhotoCropInfoWrapper;
import com.tencent.aelight.camera.ae.biz.circle.adapter.PicPreviewMoveAdapter;
import com.tencent.aelight.camera.ae.biz.circle.adapter.RecomAutoTemplateAdapter;
import com.tencent.aelight.camera.ae.biz.circle.helper.PicDragHelperCallback;
import com.tencent.aelight.camera.ae.biz.circle.helper.PicItemDecoration;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.arch.AEEditorBaseFragment;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.clip.image.EditorPicInfo;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.data.DataProcessor;
import com.tencent.aelight.camera.aeeditor.module.params.ParamFactory;
import com.tencent.aelight.camera.aeeditor.module.params.VideoParamStrategy;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.tavcut.session.config.SessionConfig;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qcircle.tavcut.view.TAVCutVideoView;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.ModelExtKt;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.effect.MusicModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.template.MediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.light.LightMediaTemplateModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import java.io.File;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AECircleAutoTemplateMidPageFragment
  extends AEEditorBaseFragment
{
  View a;
  private MoviePlayer f;
  private TAVCutVideoSession g;
  private ArrayList<String> h = new ArrayList();
  private HashMap<String, LocalMediaInfo> i = new HashMap();
  private TextView j;
  private TextView k;
  private ArrayList<LocalMediaInfo> l = new ArrayList();
  
  private int a(ArrayList<String> paramArrayList)
  {
    int n = 0;
    int m = 0;
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      for (;;)
      {
        n = m;
        if (!paramArrayList.hasNext()) {
          break;
        }
        String str = (String)paramArrayList.next();
        if (!TextUtils.isEmpty(URLConnection.getFileNameMap().getContentTypeFor(str))) {
          m += 1;
        }
      }
    }
    return n;
  }
  
  private Bundle a(Bundle paramBundle, ArrayList<String> paramArrayList)
  {
    MetaMaterial localMetaMaterial = i();
    paramBundle.putSerializable("ae_album_selected_media_models", b(paramArrayList));
    paramBundle.putString("editor_video_template_id", localMetaMaterial.id);
    return paramBundle;
  }
  
  public static EditorPicInfo a(@android.support.annotation.NonNull String paramString)
  {
    EditorPicInfo localEditorPicInfo = new EditorPicInfo();
    Size localSize = BitmapUtil.getImageSize(paramString);
    localEditorPicInfo.picPath = paramString;
    localEditorPicInfo.originPicWidth = localSize.getWidth();
    localEditorPicInfo.originPicHeight = localSize.getHeight();
    if ((localEditorPicInfo.originPicHeight != 0.0D) && (localEditorPicInfo.originPicWidth != 0.0D))
    {
      double d = localEditorPicInfo.originPicWidth * 1.0D / localEditorPicInfo.originPicHeight;
      if (d <= 0.333333343267441D)
      {
        localEditorPicInfo.x = 0.0D;
        localEditorPicInfo.y = ((localEditorPicInfo.originPicHeight - localEditorPicInfo.originPicWidth / 0.333333343267441D) * 1.0D / 2.0D / localEditorPicInfo.originPicHeight);
        localEditorPicInfo.w = 1.0D;
        localEditorPicInfo.h = (localEditorPicInfo.originPicWidth / 0.333333343267441D * 1.0D / localEditorPicInfo.originPicHeight);
        return localEditorPicInfo;
      }
      if (d >= 1.777777791023254D)
      {
        localEditorPicInfo.x = ((localEditorPicInfo.originPicWidth - localEditorPicInfo.originPicHeight * 1.777777791023254D) * 1.0D / 2.0D / localEditorPicInfo.originPicWidth);
        localEditorPicInfo.y = 0.0D;
        localEditorPicInfo.w = (localEditorPicInfo.originPicHeight * 1.777777791023254D * 1.0D / localEditorPicInfo.originPicWidth);
        localEditorPicInfo.h = 1.0D;
        return localEditorPicInfo;
      }
      localEditorPicInfo.x = 0.0D;
      localEditorPicInfo.y = 0.0D;
      localEditorPicInfo.w = 1.0D;
      localEditorPicInfo.h = 1.0D;
      return localEditorPicInfo;
    }
    localEditorPicInfo.x = 0.0D;
    localEditorPicInfo.y = 0.0D;
    localEditorPicInfo.w = 1.0D;
    localEditorPicInfo.h = 1.0D;
    return localEditorPicInfo;
  }
  
  private void a(int paramInt)
  {
    Object localObject1 = getArguments().getString("key_qcircle_mid_page_clustering_id");
    Object localObject5 = RecomAutoTemplateAdapter.a(this.l);
    Object localObject6 = i().id;
    if (paramInt != 1) {
      if ((paramInt != 2) && (paramInt != 3))
      {
        if (paramInt == 11)
        {
          localObject1 = "";
          localObject2 = localObject1;
          localObject3 = localObject2;
          localObject4 = localObject3;
          localObject5 = localObject4;
          localObject6 = localObject5;
          m = 2;
          break label230;
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.h.size());
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(a(this.h));
        ((StringBuilder)localObject3).append("");
        String str = ((StringBuilder)localObject3).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.h.size() - a(this.h));
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        m = 2;
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = str;
        break label230;
      }
    }
    Object localObject4 = localObject1;
    localObject1 = "";
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    int m = 1;
    label230:
    AEReportUtils.a("", paramInt, m, (String)localObject1, (String)localObject2, (String)localObject3, "", localObject4, (String)localObject5, (String)localObject6);
  }
  
  public static void a(Context paramContext, TAVCutVideoSession paramTAVCutVideoSession, VideoParamStrategy paramVideoParamStrategy, MediaModel paramMediaModel, MoviePlayer paramMoviePlayer, TAVCutVideoView paramTAVCutVideoView)
  {
    QLog.i("AECircleAutoTemplateMidPageFragment", 1, "Start format Video");
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFit);
    localSessionConfig.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    localSessionConfig.setMaxIntermediateRenderSize(paramVideoParamStrategy.a());
    paramTAVCutVideoSession.setSessionConfig(localSessionConfig);
    paramVideoParamStrategy = paramMediaModel;
    if (paramMediaModel == null) {
      paramVideoParamStrategy = new MediaModel();
    }
    paramTAVCutVideoSession.setMediaModel(paramVideoParamStrategy);
    if (paramMoviePlayer != null) {
      paramTAVCutVideoSession.addPlayer(paramMoviePlayer);
    }
    if (paramTAVCutVideoView != null) {
      paramTAVCutVideoSession.setTAVCutVideoView(paramTAVCutVideoView);
    }
    paramTAVCutVideoSession.init(paramContext);
    if (ModelExtKt.isLightTemplate(paramVideoParamStrategy)) {
      paramTAVCutVideoSession.setTemplate(4, new File(paramVideoParamStrategy.getMediaTemplateModel().getLightMediaTemplateModel().getFilePath()).getParent(), true, new String[] { "template.json" });
    } else {
      paramTAVCutVideoSession.setTemplate(2, "assets://camera/template", true, false, new String[] { "template.json" });
    }
    QLog.i("AECircleAutoTemplateMidPageFragment", 1, "Finish format Video");
  }
  
  private void a(View paramView)
  {
    RecyclerView localRecyclerView = (RecyclerView)paramView.findViewById(2063991406);
    Object localObject = new LinearLayoutManager(paramView.getContext());
    ((LinearLayoutManager)localObject).setOrientation(0);
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localRecyclerView.addItemDecoration(new PicItemDecoration(8));
    localObject = new PicPreviewMoveAdapter(paramView.getContext(), this.i);
    ((PicPreviewMoveAdapter)localObject).a(this.h);
    ((PicPreviewMoveAdapter)localObject).a = "AutoTemplateMidPage";
    ((PicPreviewMoveAdapter)localObject).a(new AECircleAutoTemplateMidPageFragment.1(this, (PicPreviewMoveAdapter)localObject, paramView));
    localRecyclerView.setAdapter((RecyclerView.Adapter)localObject);
    PicDragHelperCallback localPicDragHelperCallback = new PicDragHelperCallback((PicPreviewMoveAdapter)localObject, null);
    localPicDragHelperCallback.a(1.2F);
    localPicDragHelperCallback.b(0.9F);
    localPicDragHelperCallback.a(new AECircleAutoTemplateMidPageFragment.2(this, (PicPreviewMoveAdapter)localObject, paramView));
    new ItemTouchHelper(localPicDragHelperCallback).attachToRecyclerView(localRecyclerView);
  }
  
  private void a(MetaMaterial paramMetaMaterial)
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      if (paramMetaMaterial == null) {
        return;
      }
      localObject = ((TAVCutVideoSession)localObject).getMediaModel().getMediaEffectModel().getMusicModel();
      if (localObject != null)
      {
        ((MusicModel)localObject).setVolume(1.0F);
        ((MusicModel)localObject).setBgmVolume(1.0F);
      }
      this.g.setTemplate(4, MetaMaterialKt.j(paramMetaMaterial), true, new String[] { "template.json" });
      if (paramMetaMaterial != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("apply template finish");
        ((StringBuilder)localObject).append(paramMetaMaterial.id);
        AEQLog.b("AECircleAutoTemplateMidPageFragment", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private ArrayList<AEAlbumMediaBaseModel> b(ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      Object localObject = new AEPhotoCropInfoWrapper();
      ((AEPhotoCropInfoWrapper)localObject).a = a(str);
      localObject = new AEAlbumImageModel(str, ((AEPhotoCropInfoWrapper)localObject).a);
      ((AEAlbumImageModel)localObject).setOriginPath(str);
      localArrayList.add(localObject);
    }
    return localArrayList;
  }
  
  private void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    g();
    Object localObject1 = this.g;
    if (localObject1 != null)
    {
      ((TAVCutVideoSession)localObject1).release();
      this.g = null;
    }
    this.g = new TAVCutVideoSession();
    if (this.h != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("contains ");
      ((StringBuilder)localObject1).append(this.h.size());
      ((StringBuilder)localObject1).append(" photos;");
      QLog.i("AECircleAutoTemplateMidPageFragment", 1, ((StringBuilder)localObject1).toString());
    }
    localObject1 = b(this.h);
    Object localObject2 = new MediaResourceModel();
    ((MediaResourceModel)localObject2).setVideos(DataProcessor.a((List)localObject1));
    localObject1 = new MediaModel();
    ((MediaModel)localObject1).setMediaResourceModel((MediaResourceModel)localObject2);
    localObject2 = ParamFactory.b();
    paramView = (TAVCutVideoView)paramView.findViewById(2063990899);
    paramView.setOnClickListener(new AECircleAutoTemplateMidPageFragment.3(this));
    a(getActivity(), this.g, (VideoParamStrategy)localObject2, (MediaModel)localObject1, this.f, paramView);
    paramView = this.f;
    if (paramView != null) {
      paramView.play();
    }
    a(i());
  }
  
  private void c(View paramView)
  {
    this.j = ((TextView)paramView.findViewById(2063991559));
    this.j.setOnClickListener(new AECircleAutoTemplateMidPageFragment.4(this));
    this.k = ((TextView)paramView.findViewById(2063991558));
    h();
    ((TextView)paramView.findViewById(2063990897)).setOnClickListener(new AECircleAutoTemplateMidPageFragment.5(this));
    ((ImageView)paramView.findViewById(2063991173)).setOnClickListener(new AECircleAutoTemplateMidPageFragment.6(this));
  }
  
  private void f()
  {
    this.l = ((ArrayList)getArguments().getSerializable("key_qcircle_mid_page_photo_info"));
    Object localObject = this.l;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
        this.i.put(localLocalMediaInfo.path, localLocalMediaInfo);
        this.h.add(localLocalMediaInfo.path);
      }
    }
  }
  
  private void g()
  {
    MoviePlayer localMoviePlayer = this.f;
    if (localMoviePlayer != null)
    {
      localMoviePlayer.release();
      this.f = null;
    }
    this.f = new MoviePlayer();
    this.f.setLoopPlay(true);
    this.f.setBackColor(getResources().getColor(2063794181));
  }
  
  private void h()
  {
    TextView localTextView = this.j;
    StringBuilder localStringBuilder;
    if (localTextView != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("下一步(");
      localStringBuilder.append(this.h.size());
      localStringBuilder.append(")");
      localTextView.setText(localStringBuilder.toString());
    }
    localTextView = this.k;
    if (localTextView != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("已为你智能推荐");
      localStringBuilder.append(this.h.size());
      localStringBuilder.append("个内容");
      localTextView.setText(localStringBuilder.toString());
    }
  }
  
  private MetaMaterial i()
  {
    if (getArguments() != null) {
      return (MetaMaterial)getArguments().getSerializable("key_qcircle_mid_page_template_info");
    }
    return null;
  }
  
  private void j()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      ((MoviePlayer)localObject).release();
      this.f = null;
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((TAVCutVideoSession)localObject).release();
      this.g = null;
    }
    AEQLog.b("AECircleAutoTemplateMidPageFragment", "Release Tav finish");
  }
  
  public String a()
  {
    return "AutoTemplateMidPage";
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2064056506, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    AEQLog.b("AECircleAutoTemplateMidPageFragment", "onDestroy");
    super.onDestroy();
    j();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onHidden: ");
    localStringBuilder.append(paramBoolean);
    AEQLog.b("AECircleAutoTemplateMidPageFragment", localStringBuilder.toString());
    if (paramBoolean)
    {
      j();
      return;
    }
    b(this.a);
    a(1);
  }
  
  public void onPause()
  {
    super.onPause();
    AEQLog.b("AECircleAutoTemplateMidPageFragment", "onPause");
    j();
  }
  
  public void onResume()
  {
    super.onResume();
    AEQLog.b("AECircleAutoTemplateMidPageFragment", "onResume");
    b(this.a);
    a(1);
  }
  
  public void onViewCreated(@androidx.annotation.NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    f();
    c(paramView);
    a(paramView);
    b(paramView);
    this.a = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleAutoTemplateMidPageFragment
 * JD-Core Version:    0.7.0.1
 */