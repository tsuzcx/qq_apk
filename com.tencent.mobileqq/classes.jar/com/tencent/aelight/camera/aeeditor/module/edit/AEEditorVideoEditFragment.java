package com.tencent.aelight.camera.aeeditor.module.edit;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.album.data.AEAlbumMediaBaseModel;
import com.tencent.aelight.camera.ae.album.data.AEAlbumVideoModel;
import com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkDataManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.report.AEEditReportData;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.AEEditorModuleManager;
import com.tencent.aelight.camera.aeeditor.AEEditorPath.EDITOR.CACHE;
import com.tencent.aelight.camera.aeeditor.AEEditorPath.EDITOR.FILES;
import com.tencent.aelight.camera.aeeditor.AEEditorProcessManager;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorAIFilterManager;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorAIFilterManager.AIFilterObserver;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterDataCache;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterProxyBase;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterResult;
import com.tencent.aelight.camera.aeeditor.module.aifilter.MultiVideoAIFilterProxy;
import com.tencent.aelight.camera.aeeditor.module.aifilter.SilentVideoAIFilterProxy;
import com.tencent.aelight.camera.aeeditor.module.aifilter.VideoAIFilterProxy;
import com.tencent.aelight.camera.aeeditor.module.aifilter.VideoAIFilterResult;
import com.tencent.aelight.camera.aeeditor.module.autotemplate.AEAutoTemplateRet;
import com.tencent.aelight.camera.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel;
import com.tencent.aelight.camera.aeeditor.module.controlpanel.AEEditorMusicControlPanel;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.data.DataProcessor;
import com.tencent.aelight.camera.aeeditor.module.edit.widgets.AEEditorCheckGroupView;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel.FilterControlListener;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.aeeditor.module.filter.FilterChangedComparator;
import com.tencent.aelight.camera.aeeditor.module.filter.FilterMetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricPanelDialog.OperationCallback;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricProgressCalculator;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicAdapter.AEEditorMusicInfo;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper.MusicDownloadCallback;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper.MusicDownloadRunnable;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicPanel.OperationCallback;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicVolumePanelDialog.OperationCallback;
import com.tencent.aelight.camera.aeeditor.module.params.ParamFactory;
import com.tencent.aelight.camera.aeeditor.module.params.ParamsUtil;
import com.tencent.aelight.camera.aeeditor.module.params.VideoParamStrategy;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerControlPanel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerPart.AEEditorTextDialogListener;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextViewModel;
import com.tencent.aelight.camera.aeeditor.module.toolbar.VideoEditToolBar.VideoToolBarListener;
import com.tencent.aelight.camera.aeeditor.module.topbar.AEEditorTopBar;
import com.tencent.aelight.camera.aeeditor.record.AEEditorVideoRecord;
import com.tencent.aelight.camera.aeeditor.record.IVideoOnRestore;
import com.tencent.aelight.camera.aeeditor.util.AELocalMediaInfoUtil;
import com.tencent.aelight.camera.aeeditor.util.AEQCircleReport;
import com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView;
import com.tencent.aelight.camera.aeeditor.view.AEEditorQcircleBubbleView;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.video.FrameVideoHelper.GetFrameByteArrayListener;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.qcircle.tavcut.session.TAVCutSession;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.tavcut.session.callback.StickerLyricCallback;
import com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback;
import com.tencent.qcircle.tavcut.session.config.SessionConfig;
import com.tencent.qcircle.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.qcircle.tavcut.util.Util;
import com.tencent.qcircle.tavcut.util.VideoUtil;
import com.tencent.qcircle.tavcut.view.TAVCutVideoView;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.ModelExtKt;
import com.tencent.qcircle.weseevideo.model.data.MusicData;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.effect.MusicModel;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import com.tencent.qcircle.weseevideo.model.effect.SubtitleModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.qcircle.weseevideo.model.template.MediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.light.LightMediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.light.LightTemplate;
import com.tencent.qcircle.weseevideo.model.template.movie.MovieSegmentModel;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.light.LightAsset;
import qqcircle.QQCircleSmartMatchMusic.SmartMatchMusicRsp;

public class AEEditorVideoEditFragment
  extends AEEditorCommonEditFragment
  implements AEEditorAIFilterManager.AIFilterObserver, AEEditorFilterControlPanel.FilterControlListener, AEEditorLyricPanelDialog.OperationCallback, AEEditorMusicHelper.MusicDownloadCallback, AEEditorMusicPanel.OperationCallback, AEEditorMusicVolumePanelDialog.OperationCallback, VideoEditToolBar.VideoToolBarListener, IVideoOnRestore, VSDispatchObserver.onVSRspCallBack<QQCircleSmartMatchMusic.SmartMatchMusicRsp>, FrameVideoHelper.GetFrameByteArrayListener, StickerLyricCallback
{
  public static boolean Y = false;
  private static final String Z = "AEEditorVideoEditFragment";
  private static final int aa = ;
  protected MediaResourceModel A;
  protected TAVCutVideoSession B;
  protected TAVCutVideoView C = null;
  protected MoviePlayer D = null;
  protected long E;
  protected Size F;
  protected Size G;
  protected boolean H = true;
  protected boolean I = false;
  protected float J = 1.0F;
  protected float K = 0.8F;
  protected AEEditorMusicAdapter.AEEditorMusicInfo L = null;
  protected AEEditorMusicAdapter.AEEditorMusicInfo M = null;
  protected MusicData N = null;
  protected boolean O = true;
  protected boolean P = false;
  protected AIFilterDataCache Q = new AIFilterDataCache();
  protected ArrayList<String> R;
  protected MetaMaterial S;
  protected boolean T = false;
  protected VideoParamStrategy U = ParamFactory.b();
  protected String V;
  protected AEEditorQcircleBubbleView W;
  protected AEEditorQcircleBubbleView X;
  private HashMap<Integer, Float> aA = new HashMap();
  private int aB = -1;
  private LocalMediaInfo aC;
  private String aD = "";
  private SubtitleModel aE;
  private boolean aF = false;
  private Float aG;
  private String aH = "";
  private volatile boolean aI = false;
  private final Runnable aJ = new AEEditorVideoEditFragment.15(this);
  private final Runnable aK = new AEEditorVideoEditFragment.16(this);
  private List<MediaClipModel> ab;
  private String ac;
  private AEVideoEditViewModel ad;
  private AEEditorAutoTemplatePanel ae;
  private AEEditorMusicControlPanel af;
  private ImageView ag;
  private TextView ah;
  private TextView ai;
  private View aj;
  private CopyOnWriteArrayList<String> ak;
  private CopyOnWriteArrayList<String> al;
  private boolean am = false;
  private boolean an = false;
  private String ao;
  private String ap;
  private long aq;
  private Integer ar = null;
  private Integer as = null;
  private Map<String, Integer> at = new HashMap();
  private BroadcastReceiver au;
  private VsMusicItemInfo av;
  private Intent aw;
  private String ax;
  private String ay;
  private Boolean az = Boolean.valueOf(false);
  protected MediaResourceModel z;
  
  static
  {
    File localFile = new File(AEEditorPath.EDITOR.CACHE.c);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public static Size a(TAVCutVideoSession paramTAVCutVideoSession)
  {
    if (paramTAVCutVideoSession != null) {
      return paramTAVCutVideoSession.getExportMaxMediaSize();
    }
    return new Size(720, 1080);
  }
  
  private List<AEEditorMusicAdapter.AEEditorMusicInfo> a(@NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, int paramInt1, int paramInt2)
  {
    if (paramAEEditorMusicInfo.a()) {
      return null;
    }
    List localList = this.af.getBackgroundMusicData();
    int j = 0;
    Iterator localIterator = localList.iterator();
    AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo;
    do
    {
      i = j;
      if (!localIterator.hasNext()) {
        break;
      }
      localAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)localIterator.next();
    } while ((localAEEditorMusicInfo == null) || (localAEEditorMusicInfo.a()) || (paramAEEditorMusicInfo.f == 1) || (paramAEEditorMusicInfo.f == 0) || (!paramAEEditorMusicInfo.c().equals(localAEEditorMusicInfo.c())));
    localAEEditorMusicInfo.d = paramInt1;
    localAEEditorMusicInfo.e = paramInt2;
    int i = 1;
    if (i != 0) {
      return localList;
    }
    return null;
  }
  
  public static void a(Context paramContext, TAVCutVideoSession paramTAVCutVideoSession, VideoParamStrategy paramVideoParamStrategy, MediaModel paramMediaModel)
  {
    paramContext = new SessionConfig();
    paramContext.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFit);
    paramContext.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    paramContext.setMaxIntermediateRenderSize(paramVideoParamStrategy.a());
    paramVideoParamStrategy = new StickerEditViewIconConfig();
    paramVideoParamStrategy.setDeleteIconResId(2063925440);
    paramVideoParamStrategy.setEditIconResId(2063925439);
    paramVideoParamStrategy.setZoomIconResId(2063925441);
    paramContext.setStickerEditViewIconConfig(paramVideoParamStrategy);
    paramTAVCutVideoSession.setSessionConfig(paramContext);
    if (ModelExtKt.isLightTemplate(paramMediaModel))
    {
      paramTAVCutVideoSession.setTemplate(4, new File(paramMediaModel.getMediaTemplateModel().getLightMediaTemplateModel().getFilePath()).getParent(), true, new String[] { "template.json" });
      return;
    }
    paramTAVCutVideoSession.setTemplate(2, "assets://camera/template", true, new String[] { "template.json" });
  }
  
  public static void a(Context paramContext, TAVCutVideoSession paramTAVCutVideoSession, VideoParamStrategy paramVideoParamStrategy, MediaModel paramMediaModel, MoviePlayer paramMoviePlayer, TAVCutVideoView paramTAVCutVideoView)
  {
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFit);
    localSessionConfig.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    localSessionConfig.setMaxIntermediateRenderSize(paramVideoParamStrategy.a());
    paramVideoParamStrategy = new StickerEditViewIconConfig();
    paramVideoParamStrategy.setDeleteIconResId(2063925440);
    paramVideoParamStrategy.setEditIconResId(2063925439);
    paramVideoParamStrategy.setZoomIconResId(2063925441);
    localSessionConfig.setStickerEditViewIconConfig(paramVideoParamStrategy);
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
    Y = paramTAVCutVideoSession.correctMediaResource(aa);
    if (ModelExtKt.isLightTemplate(paramVideoParamStrategy))
    {
      paramTAVCutVideoSession.setTemplate(4, new File(paramVideoParamStrategy.getMediaTemplateModel().getLightMediaTemplateModel().getFilePath()).getParent(), true, new String[] { "template.json" });
      return;
    }
    paramTAVCutVideoSession.setTemplate(2, "assets://camera/template", true, false, new String[] { "template.json" });
  }
  
  private void a(@NonNull AEAutoTemplateRet paramAEAutoTemplateRet)
  {
    if (this.i == null) {
      return;
    }
    this.i.removeAllViews();
    this.j = new AEEditorLoadingView(getActivity());
    this.j.setLoadingListener(new AEEditorVideoEditFragment.9(this, paramAEAutoTemplateRet));
    this.j.a(2);
    this.i.addView(this.j);
  }
  
  private void a(@NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 0;
    }
    paramAEEditorMusicInfo = a(paramAEEditorMusicInfo, i, 0);
    if (paramAEEditorMusicInfo != null) {
      this.af.a(paramAEEditorMusicInfo);
    }
  }
  
  private void a(@NonNull VsMusicItemInfo paramVsMusicItemInfo, boolean paramBoolean)
  {
    AEQLog.b(Z, "[requestDetailedMusicInfo]");
    this.av = null;
    if (TextUtils.isEmpty(paramVsMusicItemInfo.mSongMid)) {
      return;
    }
    if ((this.af != null) && (AEEditorMusicHelper.a(paramVsMusicItemInfo)))
    {
      if (paramBoolean)
      {
        this.af.a(new AEEditorMusicAdapter.AEEditorMusicInfo(paramVsMusicItemInfo, false, 2));
        return;
      }
      a(new AEEditorMusicAdapter.AEEditorMusicInfo(paramVsMusicItemInfo, false, 2));
    }
  }
  
  private void a(@NonNull String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.N = AEEditorMusicHelper.a(paramString, paramInt1, paramInt2);
    a(this.N, paramFloat1, paramFloat2, paramBoolean);
  }
  
  private void a(@NonNull String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.at.put(paramString, Integer.valueOf(paramInt));
      return;
    }
    if (!this.at.containsKey(paramString)) {
      this.at.put(paramString, Integer.valueOf(paramInt));
    }
  }
  
  private void a(String paramString1, String paramString2, LocalMediaInfo paramLocalMediaInfo)
  {
    if (getActivity() == null)
    {
      AEQLog.d(Z, "activity is null.");
      return;
    }
    Intent localIntent = new Intent();
    Object localObject1 = ah();
    localIntent.putExtra("ae_editor_video_flag", true);
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", paramLocalMediaInfo);
    localIntent.putExtra("ae_editor_video_path", paramString1);
    localIntent.putExtra("ae_editor_video_thumb_path", paramString2);
    localIntent.putExtra("ae_editor_video_export_size_height", ((Size)localObject1).getHeight());
    localIntent.putExtra("ae_editor_video_export_size_width", ((Size)localObject1).getWidth());
    Object localObject2 = AEBaseReportParam.a().n();
    boolean bool = TextUtils.isEmpty(this.ax);
    String str2 = "none";
    if (bool) {
      paramString1 = "none";
    } else {
      paramString1 = this.ax;
    }
    if (TextUtils.isEmpty(this.ay)) {
      paramString2 = "none";
    } else {
      paramString2 = this.ay;
    }
    paramLocalMediaInfo = this.S;
    if (paramLocalMediaInfo == null) {
      paramLocalMediaInfo = "none";
    } else {
      paramLocalMediaInfo = paramLocalMediaInfo.id;
    }
    if (localObject2 == null) {
      localObject1 = "none";
    } else {
      localObject1 = ((AEEditReportData)localObject2).l;
    }
    if (localObject2 == null) {
      localObject2 = "none";
    } else {
      localObject2 = ((AEEditReportData)localObject2).n;
    }
    String str1;
    if (getArguments() == null) {
      str1 = "none";
    } else {
      str1 = getArguments().getString("guajian_id");
    }
    if (getArguments() != null) {
      str2 = getArguments().getString("water_mark_id");
    }
    localIntent.putExtra("key_image_sucai_info", new AEEditorVideoEditFragment.21(this, str2, str1, (String)localObject1, paramString1, paramString2, (String)localObject2, paramLocalMediaInfo));
    if (AEEditorAIFilterManager.a().a == null)
    {
      AEQLog.b(Z, "finishWithResult... silentVideoAIFilterProxy == null");
      if (!CollectionUtils.isEmpty(this.R)) {
        localIntent.putStringArrayListExtra("ae_editor_video_text_cache", this.R);
      }
    }
    else
    {
      paramString1 = b(AEEditorAIFilterManager.a().a.f());
      if (!CollectionUtils.isEmpty(this.R)) {
        localIntent.putStringArrayListExtra("ae_editor_video_text_cache", this.R);
      } else if (!CollectionUtils.isEmpty(paramString1)) {
        localIntent.putStringArrayListExtra("ae_editor_video_text_cache", paramString1);
      }
      this.aI = true;
    }
    AEBaseReportParam.a().ab();
    localIntent.putExtra("editorFrom", this.aB);
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
  }
  
  private void aA()
  {
    if (this.aE == null)
    {
      localObject1 = this.L;
      if (localObject1 != null)
      {
        Object localObject2 = ((AEEditorMusicAdapter.AEEditorMusicInfo)localObject1).h();
        if (!b((String)localObject2)) {
          return;
        }
        localObject1 = new SubtitleModel();
        ((SubtitleModel)localObject1).setAssetFilePath("ae_editor_lyric_default.pag");
        Size localSize = VideoUtil.getVideoSize(this.ao);
        if ((localSize != null) && (localSize.getHeight() != 0))
        {
          if (localSize.getWidth() / localSize.getHeight() > 1.0F)
          {
            ((SubtitleModel)localObject1).setCenterX(0.5F);
            ((SubtitleModel)localObject1).setCenterY(0.83F);
            ((SubtitleModel)localObject1).setScale(0.5F);
          }
          else
          {
            ((SubtitleModel)localObject1).setCenterX(0.5F);
            ((SubtitleModel)localObject1).setCenterY(0.91F);
            ((SubtitleModel)localObject1).setScale(0.8F);
          }
        }
        else
        {
          ((SubtitleModel)localObject1).setCenterX(0.5F);
          ((SubtitleModel)localObject1).setCenterY(0.91F);
          ((SubtitleModel)localObject1).setScale(0.8F);
        }
        ((SubtitleModel)localObject1).setMaxScale(2.0F);
        ((SubtitleModel)localObject1).setMinScale(0.5F);
        ((SubtitleModel)localObject1).setLoopStart(0L);
        ((SubtitleModel)localObject1).setLoopEnd(60000L);
        ((SubtitleModel)localObject1).setLoopType(1);
        ((SubtitleModel)localObject1).setLyric((String)localObject2);
        ((SubtitleModel)localObject1).setLyricFormatIsQRC(this.L.i().equals("QRC"));
        ((SubtitleModel)localObject1).setMusicStartTime(c(this.L.c()));
        localObject2 = AEEditorResourceManager.a().b("font_runyuan75w", 0);
        if ((!TextUtils.isEmpty((CharSequence)((android.util.Pair)localObject2).first)) && (new File((String)((android.util.Pair)localObject2).first).exists())) {
          ((SubtitleModel)localObject1).setFontPath((String)((android.util.Pair)localObject2).first);
        }
        this.aE = ((SubtitleModel)localObject1);
        this.B.addSticker(this.aE);
        return;
      }
    }
    Object localObject1 = this.L;
    if (localObject1 != null)
    {
      localObject1 = ((AEEditorMusicAdapter.AEEditorMusicInfo)localObject1).h();
      if (!b((String)localObject1)) {
        return;
      }
      this.aE.setLyric((String)localObject1);
      this.aE.setLyricFormatIsQRC(this.L.i().equals("QRC"));
      this.aE.setMusicStartTime(c(this.L.c()));
    }
    this.B.addSticker(this.aE);
  }
  
  private void aB()
  {
    TAVCutVideoSession localTAVCutVideoSession = this.B;
    if (localTAVCutVideoSession == null) {
      return;
    }
    a(localTAVCutVideoSession.saveLyricSticker());
    this.B.deleteLyricSticker();
  }
  
  private void aC()
  {
    TAVCutVideoSession localTAVCutVideoSession = this.B;
    if (localTAVCutVideoSession == null) {
      return;
    }
    localTAVCutVideoSession.setMainVolume(this.J);
    if (this.N != null)
    {
      localTAVCutVideoSession = this.B;
      float f;
      if (this.I) {
        f = this.K;
      } else {
        f = 0.0F;
      }
      localTAVCutVideoSession.setBgmVolume(f);
    }
  }
  
  private void aD()
  {
    this.z = ((MediaResourceModel)getArguments().getSerializable("resource_model"));
    this.x = ((ArrayList)getArguments().getSerializable("ae_album_selected_media_models"));
    try
    {
      if (this.z == null)
      {
        this.z = new MediaResourceModel();
        this.z.setVideos(DataProcessor.a(this.x));
      }
      this.A = this.z.deepCopy();
      if (this.A.getVideos().size() > 0)
      {
        this.ac = ((MediaClipModel)this.A.getVideos().get(0)).getResource().getPath();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void aE()
  {
    this.V = af();
  }
  
  private void aF()
  {
    aD();
    this.x = ((ArrayList)getArguments().getSerializable("ae_album_selected_media_models"));
    getArguments().getString("editor_video_template_id");
    if (this.x != null)
    {
      this.A = new MediaResourceModel();
      this.A.setVideos(DataProcessor.a(this.x));
    }
    this.B.getMediaModel().setMediaResourceModel(this.A);
    this.B.setStickerLyricCallback(this);
    this.B.setStickerOperationCallback(O());
    FragmentActivity localFragmentActivity = getActivity();
    TAVCutVideoSession localTAVCutVideoSession = this.B;
    a(localFragmentActivity, localTAVCutVideoSession, this.U, localTAVCutVideoSession.getMediaModel());
  }
  
  private void aG()
  {
    this.B.getMediaModel().getMediaEffectModel().getStickerModelList().clear();
    AEEditorAutoTemplatePanel localAEEditorAutoTemplatePanel = this.ae;
    if (localAEEditorAutoTemplatePanel != null) {
      localAEEditorAutoTemplatePanel.d();
    }
    if (this.g != null) {
      this.g.a();
    }
    aE();
    ar();
  }
  
  private List<StickerModel> aH()
  {
    MediaModel localMediaModel = this.B.getMediaModel();
    if (localMediaModel != null) {
      return localMediaModel.getMediaEffectModel().getStickerModelList();
    }
    return new ArrayList();
  }
  
  private boolean aI()
  {
    return (this.b != null) && (this.b.equals("AEEditorMultiCutFragment"));
  }
  
  private boolean aJ()
  {
    return (this.b != null) && (this.b.equals("AEEditorImageEdit"));
  }
  
  private boolean aK()
  {
    return (this.b != null) && (this.b.equals("AutoTemplateMidPage"));
  }
  
  private void al()
  {
    this.au = new AEEditorVideoEditFragment.1(this);
    IntentFilter localIntentFilter = new IntentFilter("action_dispatch_music_event");
    BaseApplicationImpl.getApplication().registerReceiver(this.au, localIntentFilter);
  }
  
  private void am()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.av;
    if (localVsMusicItemInfo == null) {
      return;
    }
    a(localVsMusicItemInfo, true);
  }
  
  private void an()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.av;
    if (localVsMusicItemInfo == null) {
      return;
    }
    a(localVsMusicItemInfo, true);
  }
  
  private void ao()
  {
    VsMusicItemInfo localVsMusicItemInfo = this.av;
    if (localVsMusicItemInfo == null) {
      return;
    }
    a(localVsMusicItemInfo, false);
  }
  
  private boolean ap()
  {
    Object localObject = getArguments();
    if ((localObject != null) && (((Bundle)localObject).containsKey("ae_album_selected_media_models")))
    {
      localObject = ((Bundle)localObject).getSerializable("ae_album_selected_media_models");
      if ((localObject instanceof ArrayList))
      {
        localObject = (ArrayList)localObject;
        if (localObject != null)
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            if ((((Iterator)localObject).next() instanceof AEAlbumVideoModel)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  private void aq()
  {
    a(2063991582, "SP_KEY_RED_POINT_TIME_STAMP", false);
    a(2063991129, "SP_KEY_RED_POINT_TIME_STAMP", false);
    a(2063991131, "SP_KEY_RED_POINT_TIME_STAMP", false);
    a(2063991133, "SP_KEY_RED_POINT_TIME_STAMP", false);
  }
  
  private void ar()
  {
    v();
    x();
  }
  
  private void as()
  {
    MoviePlayer localMoviePlayer = this.D;
    if (localMoviePlayer == null) {
      return;
    }
    if (!localMoviePlayer.isPlaying())
    {
      this.D.play();
      return;
    }
    this.D.pause();
  }
  
  private void at()
  {
    Bundle localBundle = getArguments();
    localBundle.putBoolean("ae_editor_is_light_model", ModelExtKt.isLightTemplate(this.B.getMediaModel()));
    if (ModelExtKt.isLightTemplate(this.B.getMediaModel()))
    {
      MediaResourceModel localMediaResourceModel = a(this.A);
      getArguments().putSerializable("resource_model", localMediaResourceModel);
    }
    else
    {
      getArguments().putSerializable("resource_model", this.A);
    }
    b().a(this, a(), localBundle);
    if (getArguments() != null) {
      getArguments().putBoolean("ae_video_editor_entrance_mid_page", false);
    }
  }
  
  private void au()
  {
    AEBaseReportParam.a().n().F = 0;
    AEBaseDataReporter.a().r();
  }
  
  private void av()
  {
    boolean bool;
    if ((K()) && (this.ae.getVisibility() == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (Y)
    {
      j(bool);
      return;
    }
    if (bool) {
      aw();
    }
  }
  
  private void aw()
  {
    if (this.W == null) {
      this.W = new AEEditorQcircleBubbleView(this.o);
    }
    this.C.post(new AEEditorVideoEditFragment.13(this));
  }
  
  @NotNull
  private HashMap<String, ArrayList<String>> ax()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = b(AEEditorAIFilterManager.a().a.f());
    Object localObject2;
    if (!CollectionUtils.isEmpty(this.R))
    {
      localHashMap.put(this.ap, this.R);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[QcirclePublish]");
      ((StringBuilder)localObject1).append(Z);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[finishWithResult], cachedFilterText=");
      ((StringBuilder)localObject2).append(this.R);
      AEQLog.a((String)localObject1, ((StringBuilder)localObject2).toString());
      return localHashMap;
    }
    if (!CollectionUtils.isEmpty((Collection)localObject1))
    {
      localHashMap.put(this.ap, localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[QcirclePublish]");
      ((StringBuilder)localObject2).append(Z);
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[finishWithResult], silentFilterText=");
      localStringBuilder.append(localObject1);
      AEQLog.a((String)localObject2, localStringBuilder.toString());
    }
    return localHashMap;
  }
  
  private void ay()
  {
    if (this.B.getMediaModel() != null)
    {
      AEBaseReportParam.a().n().s = this.B.getMediaModel().getMediaEffectModel().getStickerModelList().size();
      Object localObject2 = this.B.getMediaModel().getMediaEffectModel().getStickerModelList();
      int i = 0;
      a((List)localObject2, 0);
      a((List)localObject2);
      Object localObject1 = AEBaseReportParam.a().n();
      if (localObject1 == null) {
        localObject1 = "none";
      } else {
        localObject1 = ((AEEditReportData)localObject1).l;
      }
      Object localObject4 = new StringBuilder();
      Object localObject3 = new StringBuilder();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (StickerModel)((Iterator)localObject2).next();
        if ((this.w != null) && (localObject5 != null)) {
          if (this.w.a(((StickerModel)localObject5).getMaterialId()) == null)
          {
            if (!((StringBuilder)localObject4).toString().equals("")) {
              ((StringBuilder)localObject4).append(",");
            }
            ((StringBuilder)localObject4).append(((StickerModel)localObject5).getMaterialId());
          }
          else
          {
            if (!((StringBuilder)localObject3).toString().equals("")) {
              ((StringBuilder)localObject3).append(",");
            }
            ((StringBuilder)localObject3).append(((StickerModel)localObject5).getMaterialId());
          }
        }
      }
      localObject2 = new String((StringBuilder)localObject4);
      Object localObject5 = new String((StringBuilder)localObject3);
      if (((String)localObject2).isEmpty()) {
        localObject2 = "none";
      }
      localObject3 = this.L;
      if ((localObject3 != null) && (((AEEditorMusicAdapter.AEEditorMusicInfo)localObject3).b() != null)) {
        localObject3 = String.valueOf(this.L.b().mMusicName);
      } else {
        localObject3 = "none";
      }
      localObject4 = this.S;
      if (localObject4 != null) {
        localObject4 = ((MetaMaterial)localObject4).id;
      } else {
        localObject4 = "none";
      }
      int j = this.B.getMediaModel().getMediaResourceModel().getVideos().size();
      if (this.J != 0.0F) {
        i = 1;
      }
      this.ax = ((String)localObject2);
      this.ay = ((String)localObject5);
      if (TextUtils.isEmpty((CharSequence)localObject5)) {
        localObject5 = "none";
      }
      AEReportUtils.a("", String.valueOf(j), String.valueOf(i), (String)localObject5, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4);
    }
    AEBaseDataReporter.a().q();
  }
  
  private Intent az()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    QZoneHelper.addSource(localIntent);
    localIntent.putExtra("videoclipduration", (int)this.E);
    return localIntent;
  }
  
  private int b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        return 3;
      }
      return 2;
    }
    if (paramBoolean2) {
      return 1;
    }
    return 0;
  }
  
  @Nullable
  private ArrayList<String> b(@Nullable VideoAIFilterResult paramVideoAIFilterResult)
  {
    if (paramVideoAIFilterResult != null)
    {
      if (CollectionUtils.isEmpty(paramVideoAIFilterResult.c)) {
        return null;
      }
      Object localObject = new LinkedList(paramVideoAIFilterResult.c);
      if ((((List)localObject).size() > 0) && (((List)localObject).get(0) != null)) {
        paramVideoAIFilterResult = ((YoutuResultItem)((List)localObject).get(0)).Label;
      } else {
        paramVideoAIFilterResult = null;
      }
      if ((((List)localObject).size() > 1) && (((List)localObject).get(1) != null)) {
        localObject = ((YoutuResultItem)((List)localObject).get(1)).Label;
      } else {
        localObject = null;
      }
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(paramVideoAIFilterResult)) {
        localArrayList.add(paramVideoAIFilterResult);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localArrayList.add(localObject);
      }
      if (CollectionUtils.isEmpty(localArrayList)) {
        return null;
      }
      return localArrayList;
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    if (this.aE != null)
    {
      Object localObject = this.L;
      if (localObject != null)
      {
        localObject = ((AEEditorMusicAdapter.AEEditorMusicInfo)localObject).h();
        if (!b((String)localObject)) {
          return;
        }
        this.aE.setLyric((String)localObject);
        this.aE.setLyricFormatIsQRC(this.L.i().equals("QRC"));
        this.aE.setMusicStartTime(paramInt);
        this.B.addSticker(this.aE);
      }
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void b(View paramView)
  {
    this.af = ((AEEditorMusicControlPanel)paramView.findViewById(2063991272));
    this.af.setMusicListOperationCallback(this);
    this.af.setMusicLyricOperationCallback(this);
    this.af.setMusicVolumeOperationCallback(this);
    this.af.setAutoTemplateMode(false, false);
    this.af.setOriginSoundOn(ap());
    this.ae = ((AEEditorAutoTemplatePanel)paramView.findViewById(2063990898));
    if (getArguments() != null) {
      this.ae.setEntrance(getArguments().getInt("ae_video_editor_entrance_id", 0));
    }
    this.ae.setToastValidListener(this);
    this.ae.getAutoTemplateRetLiveData().observe(getViewLifecycleOwner(), new AEEditorVideoEditFragment.2(this));
    Object localObject = (MetaMaterial)getArguments().getSerializable("AE_AUTO_TEMPLATE_DOWNLOADED_MATERIAL");
    this.ae.a((MetaMaterial)localObject);
    this.ae.getRecommendReloadLiveData().observe(getViewLifecycleOwner(), new AEEditorVideoEditFragment.3(this));
    this.ae.getRecommendReloadLiveData().postValue(Boolean.valueOf(false));
    this.ag = ((ImageView)paramView.findViewById(2063991475));
    this.ag.setOnClickListener(new AEEditorVideoEditFragment.4(this));
    this.aj = paramView.findViewById(2063991370);
    this.aj.setOnClickListener(new AEEditorVideoEditFragment.5(this));
    i(true);
    this.ah = ((TextView)paramView.findViewById(2063991476));
    ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.ah, false);
    localObject = VideoUtil.getVideoSize(this.ao);
    if ((localObject != null) && (((Size)localObject).getHeight() != 0))
    {
      if (((Size)localObject).getWidth() / ((Size)localObject).getHeight() > 1.0F) {
        this.ai = ((TextView)paramView.findViewById(2063991473));
      } else {
        this.ai = ((TextView)paramView.findViewById(2063991472));
      }
    }
    else {
      this.ai = ((TextView)paramView.findViewById(2063991472));
    }
    this.C = ((TAVCutVideoView)paramView.findViewById(2063991474));
    this.C.setOnClickListener(new AEEditorVideoEditFragment.6(this));
    paramView = new GestureDetector(paramView.getContext(), new AEEditorVideoEditFragment.7(this));
    this.C.setOnTouchListener(new AEEditorVideoEditFragment.8(this, paramView));
  }
  
  private boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if ((!paramString.equals("[00:00:00]此歌曲为没有填词的纯音乐，请您欣赏")) && (paramString.length() != 0))
    {
      if (paramString.equals(" ")) {
        return false;
      }
      return paramString.contains("[00:");
    }
    return false;
  }
  
  private int c(@NonNull String paramString)
  {
    paramString = (Integer)this.at.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  private void c(AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo)
  {
    Intent localIntent = this.aw;
    if ((localIntent != null) && (localIntent.hasExtra("clipStartTime")))
    {
      this.ar = Integer.valueOf(this.aw.getIntExtra("clipStartTime", 0));
      a(paramAEEditorMusicInfo.c(), this.ar.intValue(), true);
    }
  }
  
  private void d(@Nullable AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo)
  {
    if (this.B == null) {
      return;
    }
    boolean bool1 = false;
    boolean bool2 = true;
    float f1;
    float f2;
    if ((paramAEEditorMusicInfo != null) && (this.I))
    {
      if (paramAEEditorMusicInfo.f == 3) {
        return;
      }
      String str = AEEditorMusicHelper.a(paramAEEditorMusicInfo);
      bool2 = AEEditorMusicHelper.a(str);
      if (this.N != null)
      {
        this.B.setBgmVolume(0.0F);
        this.af.setBgmPlayed(false, this.L);
      }
      if (bool2)
      {
        paramAEEditorMusicInfo.d = 2;
        this.N = AEEditorMusicHelper.a(str, c(paramAEEditorMusicInfo.c()), paramAEEditorMusicInfo.f());
        if (this.aw != null) {
          b(paramAEEditorMusicInfo);
        }
        paramAEEditorMusicInfo = this.N;
        f1 = this.J;
        f2 = this.K;
        if ((!this.q) || (this.aw != null)) {
          bool1 = true;
        }
        a(paramAEEditorMusicInfo, f1, f2, bool1);
        this.aw = null;
        if ((!this.q) && (this.ag.getVisibility() == 0)) {
          i(true);
        }
        this.af.setBgmPlayed(true, this.L);
        return;
      }
      if ((getActivity() != null) && (MobileQQ.sMobileQQ.peekAppRuntime() != null))
      {
        if (paramAEEditorMusicInfo.d == 1)
        {
          str = Z;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[updateSoundAndMusicConfig], editorMusicInfo=");
          localStringBuilder.append(paramAEEditorMusicInfo);
          localStringBuilder.append(", downloadStatus=STATUS_DOWNLOADING");
          AEQLog.b(str, localStringBuilder.toString());
          return;
        }
        paramAEEditorMusicInfo.d = 1;
        ThreadManager.excute(new AEEditorMusicHelper.MusicDownloadRunnable(MobileQQ.sMobileQQ.peekAppRuntime(), paramAEEditorMusicInfo, paramAEEditorMusicInfo.d(), str, this), 128, null, true);
        return;
      }
      AEQLog.b(Z, "[updateSoundAndMusicConfig], activity=null OR appInterface=null");
      return;
    }
    this.B.setMainVolume(this.J);
    if (this.N != null)
    {
      this.B.setBgmVolume(0.0F);
      f1 = this.J;
      f2 = this.K;
      bool1 = bool2;
      if (this.q) {
        if (this.aw != null) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      a(null, f1, f2, bool1);
    }
    this.af.setBgmPlayed(false, this.L);
  }
  
  private void i(boolean paramBoolean)
  {
    ImageView localImageView = this.ag;
    if (localImageView != null) {
      localImageView.setSelected(paramBoolean);
    }
  }
  
  private void j(boolean paramBoolean)
  {
    if (this.X == null) {
      this.X = new AEEditorQcircleBubbleView(this.o);
    }
    this.C.post(new AEEditorVideoEditFragment.14(this, paramBoolean));
  }
  
  protected FilterChangedComparator C()
  {
    return new AEEditorVideoEditFragment.12(this);
  }
  
  public void E()
  {
    super.E();
    AEReportUtils.m();
  }
  
  public void G()
  {
    AEEditorVideoRecord.a().b();
  }
  
  public void N()
  {
    MoviePlayer localMoviePlayer = this.D;
    if (localMoviePlayer != null)
    {
      localMoviePlayer.release();
      this.D = null;
    }
    this.D = new MoviePlayer();
    this.D.setLoopPlay(true);
    this.D.setBackColor(getResources().getColor(2063794181));
    this.D.addPlayerListener(new AEEditorVideoEditFragment.10(this));
  }
  
  public StickerOperationCallback O()
  {
    return new AEEditorVideoEditFragment.11(this);
  }
  
  public void P()
  {
    getActivity().getIntent().putExtra("startTimeEdit", this.aq * 1000L);
    getActivity().getIntent().putExtra("endTimeEdit", (this.aq + this.E) * 1000L);
    Intent localIntent = getActivity().getIntent();
    Float localFloat = this.aG;
    float f;
    if (localFloat != null) {
      f = localFloat.floatValue();
    } else {
      f = 1.0F;
    }
    localIntent.putExtra("endSpeedEdit", f);
    AEBaseDataReporter.a().a(this.B.getDuration().getTimeUs() / 1000L);
    at();
  }
  
  public void Q()
  {
    D();
    a(-1);
    this.B.clearAEKitModel();
    AEBaseReportParam.a().n().l = "none";
    AEBaseReportParam.a().n().m = -1.0F;
  }
  
  public void R() {}
  
  public void S() {}
  
  public void T() {}
  
  public boolean U()
  {
    List localList = this.B.getMediaModel().getMediaEffectModel().getStickerModelList();
    int i = 0;
    while (i < localList.size())
    {
      if ((((StickerModel)localList.get(i)).getInteractive() > 0) && (((StickerModel)localList.get(i)).getMaterialId().startsWith("qiukuolie"))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void V()
  {
    this.ae.c();
  }
  
  public void W()
  {
    this.af.a();
    if (this.O)
    {
      this.O = false;
      aC();
    }
    AEBaseDataReporter.a().s();
  }
  
  protected void X()
  {
    AEEditorAIFilterManager.a().a(getActivity(), this.B, new AEEditorVideoEditFragment.17(this));
  }
  
  protected String Y()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("multi_video_");
    localStringBuilder.append(System.currentTimeMillis());
    return localStringBuilder.toString();
  }
  
  protected String Z()
  {
    if ((TextUtils.isEmpty("")) && (this.ae != null))
    {
      localObject1 = this.S;
      if (localObject1 != null)
      {
        localObject2 = MetaMaterialKt.c((MetaMaterial)localObject1);
        break label35;
      }
    }
    Object localObject2 = "";
    label35:
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (this.h != null) {
        localObject1 = a(this.B.getMediaModel().getMediaEffectModel().getStickerModelList(), this.h.getStickerMaterials());
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (this.k != null) {
        localObject2 = a(this.B.getMediaModel().getMediaEffectModel().getStickerModelList(), this.w.j());
      }
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (this.g != null) {
        localObject1 = a(this.aD, this.g.getFilterMaterials());
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      Bundle localBundle = getArguments();
      localObject2 = localObject1;
      if (localBundle != null) {
        localObject2 = localBundle.getString("key_image_to_multi_video_hashtag", "");
      }
    }
    return localObject2;
  }
  
  protected MediaResourceModel a(MediaResourceModel paramMediaResourceModel)
  {
    Object localObject = this.B.getMediaBuilderOutput();
    if (localObject != null)
    {
      MediaResourceModel localMediaResourceModel = new MediaResourceModel();
      localObject = ((MediaBuilderOutput)localObject).getLightTemplate();
      int i = 0;
      localObject = ((LightTemplate)localObject).getLightSegments().iterator();
      if (((Iterator)localObject).hasNext())
      {
        Iterator localIterator = ((MovieSegmentModel)((Iterator)localObject).next()).getVideoResourceModels().iterator();
        int j = i;
        for (;;)
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
          VideoResourceModel localVideoResourceModel = (VideoResourceModel)localIterator.next();
          if (paramMediaResourceModel.getVideos().size() > j)
          {
            MediaClipModel localMediaClipModel1 = (MediaClipModel)paramMediaResourceModel.getVideos().get(j);
            if ((localMediaClipModel1.getResource().getPath() != null) && (localMediaClipModel1.getResource().getPath().equals(localVideoResourceModel.getPath())))
            {
              MediaClipModel localMediaClipModel2 = localMediaClipModel1.deepCopy();
              if (localVideoResourceModel.getSpeed() != localMediaClipModel1.getResource().getSpeed()) {
                localVideoResourceModel.setScaleDuration(((float)localVideoResourceModel.getScaleDuration() / localMediaClipModel1.getResource().getSpeed()));
              }
              localMediaClipModel2.setResource(localVideoResourceModel);
              localMediaResourceModel.getVideos().add(localMediaClipModel2);
            }
            j += 1;
          }
        }
      }
      return localMediaResourceModel;
    }
    return paramMediaResourceModel;
  }
  
  public String a()
  {
    return "AEEditorVideoEdit";
  }
  
  public void a(float paramFloat)
  {
    boolean bool;
    if (paramFloat > 0.0F) {
      bool = true;
    } else {
      bool = false;
    }
    this.H = bool;
    this.J = paramFloat;
    this.af.a(this.J);
    AEBaseReportParam.a().n().o = b(this.H, this.I);
    aC();
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.B.setEffectStrength(paramFloat);
    this.aA.put(Integer.valueOf(paramInt), Float.valueOf(paramFloat));
    AEBaseReportParam.a().n().m = paramFloat;
  }
  
  public void a(int paramInt, @Nullable MetaMaterial paramMetaMaterial)
  {
    a(paramInt);
  }
  
  public void a(int paramInt, AIFilterResult paramAIFilterResult)
  {
    if (this.j != null) {
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.26(this, paramAIFilterResult));
    }
    Object localObject1;
    Object localObject2;
    if (paramInt == 0)
    {
      AEQLog.b(Z, "onAIFilterApplySuccess");
    }
    else
    {
      localObject1 = Z;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onAIFilterAppliedFailed:");
      ((StringBuilder)localObject2).append(paramInt);
      AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.27(this));
    }
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.28(this));
    if (this.B != null)
    {
      if (paramAIFilterResult == null) {
        return;
      }
      this.Q.a(this.ao, paramAIFilterResult);
      this.R = a(paramAIFilterResult);
      localObject1 = (VideoAIFilterResult)paramAIFilterResult;
      if (localObject1 != null)
      {
        a((VideoAIFilterResult)localObject1);
        a(new String[] { "智能滤镜label", ((VideoAIFilterResult)localObject1).d, "智能滤镜errCode", String.valueOf(paramInt) });
        localObject2 = NewEnhanceCategories.newEnhanceTypes.iterator();
        paramAIFilterResult = "none";
        while (((Iterator)localObject2).hasNext())
        {
          NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)((Iterator)localObject2).next();
          if (localNewEnhanceCategories.serverLabel.equals(((VideoAIFilterResult)localObject1).d)) {
            paramAIFilterResult = localNewEnhanceCategories.filterType;
          }
        }
        localObject1 = AEBaseReportParam.a().n();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("effect_aieffect_");
        ((StringBuilder)localObject2).append(paramAIFilterResult);
        ((AEEditReportData)localObject1).l = ((StringBuilder)localObject2).toString();
        AEBaseReportParam.a().n().m = -1.0F;
        this.aD = "effect_aieffect";
      }
    }
  }
  
  protected void a(androidx.core.util.Pair<Integer, String> paramPair)
  {
    if ((paramPair != null) && (paramPair.first != null))
    {
      if (paramPair.second == null) {
        return;
      }
      this.az = Boolean.valueOf(true);
      String str = (String)paramPair.second;
      if (((Integer)paramPair.first).intValue() == 1)
      {
        if (this.ae.b(str)) {
          this.l.a(2063991368);
        }
      }
      else {
        super.a(paramPair);
      }
    }
  }
  
  public void a(MetaMaterial paramMetaMaterial)
  {
    if (this.B == null)
    {
      AEQLog.d(Z, "tavVideoSession is null.");
      return;
    }
    this.S = paramMetaMaterial;
    this.A = this.z.deepCopy();
    Object localObject = this.B.getMediaModel().getMediaEffectModel().getMusicModel();
    boolean bool = false;
    Iterator localIterator1;
    MediaClipModel localMediaClipModel1;
    if (paramMetaMaterial == null)
    {
      ((MusicModel)localObject).setVolume(0.5F);
      ((MusicModel)localObject).setBgmVolume(0.5F);
      ((MusicModel)localObject).setMetaDataBean(null);
      ((MusicModel)localObject).setUserMetaDataBean(null);
      if (this.ab != null)
      {
        localObject = new ArrayList();
        localIterator1 = this.B.getMediaModel().getMediaResourceModel().getVideos().iterator();
        while (localIterator1.hasNext())
        {
          localMediaClipModel1 = (MediaClipModel)localIterator1.next();
          Iterator localIterator2 = this.ab.iterator();
          while (localIterator2.hasNext())
          {
            MediaClipModel localMediaClipModel2 = (MediaClipModel)localIterator2.next();
            if (localMediaClipModel2.getUniqueId() == localMediaClipModel1.getUniqueId())
            {
              ((ArrayList)localObject).add(localMediaClipModel2.deepCopy());
              i = 1;
              break label205;
            }
          }
          int i = 0;
          label205:
          if (i == 0)
          {
            localMediaClipModel1.getResource().setCutTimeStart(0L);
            localMediaClipModel1.getResource().setSelectTimeStartUs(0L);
            localMediaClipModel1.getResource().setScaleDuration(localMediaClipModel1.getResource().getSourceTimeDuration());
            localMediaClipModel1.getResource().setSelectTimeDurationUs(localMediaClipModel1.getResource().getSourceTimeDurationUs());
            ((ArrayList)localObject).add(localMediaClipModel1.deepCopy());
          }
        }
        this.ab = ((List)localObject);
        this.B.getMediaModel().getMediaResourceModel().setVideos((List)localObject);
        this.A = this.B.getMediaModel().getMediaResourceModel();
      }
      this.B.setTemplate(2, "assets://camera/template", true, new String[] { "template.json" });
      this.af.setAutoTemplateMode(false, false);
      this.ae.setHasTemplate(false);
      this.aj.setVisibility(0);
    }
    else
    {
      if (!ModelExtKt.isLightTemplate(this.B.getMediaModel()))
      {
        this.ab = new ArrayList();
        localIterator1 = this.B.getMediaModel().getMediaResourceModel().getVideos().iterator();
        while (localIterator1.hasNext())
        {
          localMediaClipModel1 = (MediaClipModel)localIterator1.next();
          this.ab.add(localMediaClipModel1.deepCopy());
        }
      }
      if (this.ab != null)
      {
        this.B.getMediaModel().getMediaResourceModel().setVideos(this.ab);
        this.A = this.B.getMediaModel().getMediaResourceModel();
      }
      ((MusicModel)localObject).setVolume(1.0F);
      ((MusicModel)localObject).setBgmVolume(1.0F);
      this.B.setTemplate(4, MetaMaterialKt.j(this.S), true, new String[] { "template.json" });
      if (this.B.getMediaModel().getMediaEffectModel().getMusicModel().getMetaDataBean() != null) {
        bool = true;
      }
      if (bool)
      {
        this.I = true;
        this.M = this.L;
        this.L = AEEditorMusicAdapter.AEEditorMusicInfo.b;
        this.N = new MusicData();
        this.af.setBgmPlayed(true, this.L);
        this.B.setBgmVolume(0.5F);
        this.B.setMainVolume(0.0F);
      }
      this.af.setAutoTemplateMode(true, bool);
      this.aG = Float.valueOf(1.0F);
      this.ae.b(paramMetaMaterial);
      this.ae.setHasTemplate(true);
    }
    localObject = AEQCircleReport.a();
    if (paramMetaMaterial == null) {
      paramMetaMaterial = "null_template";
    } else {
      paramMetaMaterial = paramMetaMaterial.id;
    }
    ((AEQCircleReport)localObject).a(paramMetaMaterial, QCircleConstants.x, "0");
  }
  
  protected void a(@NonNull VideoAIFilterResult paramVideoAIFilterResult)
  {
    TAVCutVideoSession localTAVCutVideoSession = this.B;
    if (localTAVCutVideoSession == null)
    {
      AEQLog.d(Z, "tavVideoSession is null.");
      return;
    }
    localTAVCutVideoSession.resetAEKitModelForAI(paramVideoAIFilterResult.e, 0.8F, paramVideoAIFilterResult.i, 0, 0.0F);
    AEQCircleReport.a().a(QCircleConstants.C, QCircleConstants.x, QCircleConstants.A, "0");
  }
  
  public void a(@Nullable AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo)
  {
    String str = AEEditorMusicHelper.a(paramAEEditorMusicInfo);
    if (AEEditorMusicHelper.a(str)) {
      return;
    }
    if ((getActivity() != null) && (MobileQQ.sMobileQQ.peekAppRuntime() != null))
    {
      if (paramAEEditorMusicInfo.d == 1)
      {
        str = Z;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[startCacheDownloadMusic], editorMusicInfo=");
        localStringBuilder.append(paramAEEditorMusicInfo);
        localStringBuilder.append(", downloadStatus=STATUS_DOWNLOADING");
        AEQLog.b(str, localStringBuilder.toString());
        return;
      }
      paramAEEditorMusicInfo.d = 1;
      ThreadManager.excute(new AEEditorMusicHelper.MusicDownloadRunnable(MobileQQ.sMobileQQ.peekAppRuntime(), paramAEEditorMusicInfo, paramAEEditorMusicInfo.d(), str, new AEEditorVideoEditFragment.23(this)), 128, null, true);
      return;
    }
    AEQLog.b(Z, "[startCacheDownloadMusic], activity=null OR appInterface=null");
  }
  
  public void a(@Nullable AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, int paramInt)
  {
    if (paramAEEditorMusicInfo != null)
    {
      if (paramAEEditorMusicInfo.a()) {
        return;
      }
      this.I = true;
      this.M = this.L;
      this.L = paramAEEditorMusicInfo;
      AEBaseReportParam.a().n().o = b(this.H, this.I);
      AEBaseReportParam.a().n().n = paramAEEditorMusicInfo.c();
      AEBaseReportParam.a().n().p = this.L.g;
      AEBaseReportParam.a().n().q = this.L.h;
      AEBaseReportParam.a().n().r = this.L.f();
      AEBaseDataReporter.a().u();
      AEReportUtils.k(paramAEEditorMusicInfo.c());
      List localList = this.af.getBackgroundMusicData();
      Iterator localIterator = localList.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)localIterator.next();
        if ((localAEEditorMusicInfo != null) && (!localAEEditorMusicInfo.a()) && (localAEEditorMusicInfo.f != 1) && (localAEEditorMusicInfo.f != 0)) {
          if (paramAEEditorMusicInfo.c().equals(localAEEditorMusicInfo.c()))
          {
            localAEEditorMusicInfo.c = true;
            this.L = localAEEditorMusicInfo;
            paramAEEditorMusicInfo = localAEEditorMusicInfo;
            i = 1;
          }
          else
          {
            localAEEditorMusicInfo.c = false;
          }
        }
      }
      int j = paramInt;
      if (i == 0)
      {
        paramAEEditorMusicInfo.c = true;
        i = localList.size() - 1;
        if (paramInt > i)
        {
          j = i + 1;
          localList.add(paramAEEditorMusicInfo);
        }
        else
        {
          localList.add(paramInt, paramAEEditorMusicInfo);
          j = paramInt;
        }
      }
      a(paramAEEditorMusicInfo.c(), paramAEEditorMusicInfo.e(), false);
      c(paramAEEditorMusicInfo);
      if (paramAEEditorMusicInfo.f == 3)
      {
        if (this.B.restoreTemplateMusic(this.J, this.K))
        {
          this.M = this.L;
          this.L = AEEditorMusicAdapter.AEEditorMusicInfo.b;
          this.N = new MusicData();
          this.af.setBgmPlayed(true, this.L);
        }
      }
      else {
        d(paramAEEditorMusicInfo);
      }
      this.af.a(localList);
      this.af.a(j);
    }
  }
  
  public void a(@NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, boolean paramBoolean, @NonNull String paramString)
  {
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.24(this, paramAEEditorMusicInfo, paramBoolean, paramString));
  }
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSmartMatchMusic.SmartMatchMusicRsp paramSmartMatchMusicRsp)
  {
    if ((paramBoolean) && (paramSmartMatchMusicRsp != null) && (!CollectionUtils.isEmpty(paramSmartMatchMusicRsp.musicListInfo.get())))
    {
      if ((paramSmartMatchMusicRsp.extInfo != null) && (paramSmartMatchMusicRsp.extInfo.mapInfo.size() != 0))
      {
        paramBaseRequest = paramSmartMatchMusicRsp.extInfo.mapInfo.get().iterator();
        while (paramBaseRequest.hasNext())
        {
          paramString = (FeedCloudCommon.Entry)paramBaseRequest.next();
          if ((paramString != null) && (paramString.key.get().equals("CommonInfo"))) {
            AEBaseReportParam.a().n().y = paramString.value.get();
          }
        }
      }
      if (this.af != null)
      {
        paramBaseRequest = AEEditorMusicHelper.a(paramSmartMatchMusicRsp.musicListInfo.get());
        paramString = AEEditorMusicHelper.b(paramBaseRequest);
        List localList = this.af.getBackgroundMusicData();
        paramSmartMatchMusicRsp = new LinkedList();
        HashMap localHashMap = new HashMap();
        Iterator localIterator = paramBaseRequest.iterator();
        paramBaseRequest = "";
        while (localIterator.hasNext())
        {
          VsMusicItemInfo localVsMusicItemInfo = (VsMusicItemInfo)localIterator.next();
          StringBuilder localStringBuilder;
          if (!TextUtils.isEmpty(paramBaseRequest))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramBaseRequest);
            localStringBuilder.append(",");
            localStringBuilder.append(localVsMusicItemInfo.mSongMid);
            paramBaseRequest = localStringBuilder.toString();
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramBaseRequest);
            localStringBuilder.append(localVsMusicItemInfo.mSongMid);
            paramBaseRequest = localStringBuilder.toString();
          }
        }
        AEBaseReportParam.a().n().z = paramBaseRequest;
        int k = 0;
        int i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= localList.size()) {
            break;
          }
          paramBaseRequest = (AEEditorMusicAdapter.AEEditorMusicInfo)localList.get(i);
          if ((paramBaseRequest != null) && (!paramBaseRequest.a()) && (paramBaseRequest.f != 0))
          {
            paramSmartMatchMusicRsp.add(paramBaseRequest);
            localHashMap.put(paramBaseRequest.c(), paramBaseRequest);
          }
          i += 1;
        }
        while (j < paramString.size())
        {
          paramBaseRequest = (AEEditorMusicAdapter.AEEditorMusicInfo)paramString.get(j);
          if ((paramBaseRequest != null) && (!paramBaseRequest.a()) && (localHashMap.get(paramBaseRequest.c()) == null)) {
            paramSmartMatchMusicRsp.add(paramBaseRequest);
          }
          j += 1;
        }
        this.af.a(paramSmartMatchMusicRsp);
      }
      return;
    }
    AEQLog.d(Z, "[VSDispatchObserver.onVSRspCallBack.onReceive], music - request music list failed");
  }
  
  protected void a(MusicData paramMusicData, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    TAVCutVideoSession localTAVCutVideoSession = this.B;
    if (localTAVCutVideoSession != null)
    {
      a(localTAVCutVideoSession.saveLyricSticker());
      this.B.setBgmMusic(paramMusicData, paramFloat1, paramFloat2, paramBoolean);
    }
    paramMusicData = this.D;
    if ((paramMusicData != null) && (paramBoolean))
    {
      paramMusicData.seekToTime(CMTime.fromMs(0L));
      this.D.play();
    }
  }
  
  protected void a(SubtitleModel paramSubtitleModel)
  {
    SubtitleModel localSubtitleModel = this.aE;
    if ((localSubtitleModel != null) && (paramSubtitleModel != null))
    {
      localSubtitleModel.setAssetFilePath(paramSubtitleModel.getAssetFilePath());
      this.aE.setCenterX(paramSubtitleModel.getCenterX());
      this.aE.setCenterY(paramSubtitleModel.getCenterY());
      this.aE.setRotate(paramSubtitleModel.getRotate());
      this.aE.setScale(paramSubtitleModel.getScale());
      this.aE.setMaxScale(paramSubtitleModel.getMaxScale());
      this.aE.setMinScale(paramSubtitleModel.getMinScale());
      this.aE.setLoopStart(paramSubtitleModel.getLoopStart());
      this.aE.setLoopEnd(paramSubtitleModel.getLoopEnd());
      this.aE.setLoopType(paramSubtitleModel.getLoopType());
      this.aE.setLyric(paramSubtitleModel.getLyric());
      this.aE.setLyricFormatIsQRC(paramSubtitleModel.getLyricFormatIsQRC());
      this.aE.setMusicStartTime(paramSubtitleModel.getMusicStartTime());
    }
  }
  
  public void a(String paramString)
  {
    if (this.g != null) {
      this.g.a(paramString);
    }
  }
  
  protected void a(@NonNull String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AEEditorMusicHelper.a(this.B, this);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    LocalMediaInfo localLocalMediaInfo = AELocalMediaInfoUtil.a(b(paramString1, paramString2, paramString3), getArguments().getString("material_id"), getArguments().getString("material_topic"), getArguments().getString("key_camera_material_name"), getArguments().getInt("ae_editor_is_show_take_same"), this.aD);
    Object localObject = this.B;
    if (localObject != null)
    {
      a(localLocalMediaInfo, ((TAVCutVideoSession)localObject).getMediaModel().getMediaEffectModel().getStickerModelList());
      localObject = Z();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!localLocalMediaInfo.mHashTagList.contains(localObject))) {
        localLocalMediaInfo.mHashTagList.add(localObject);
      }
    }
    AEEditorProcessManager localAEEditorProcessManager = AEEditorProcessManager.a();
    String str1 = localLocalMediaInfo.materialID;
    String str2 = localLocalMediaInfo.materialName;
    String str3 = localLocalMediaInfo.filterID;
    String str4 = localLocalMediaInfo.scheme;
    int i = localLocalMediaInfo.showCircleTakeSame;
    String str5 = this.ao;
    localObject = this.B;
    if (localObject == null) {
      localObject = new MediaModel();
    } else {
      localObject = ((TAVCutVideoSession)localObject).getMediaModel();
    }
    localAEEditorProcessManager.a(str1, str2, str3, str4, i, paramString3, str5, paramString1, paramString2, (MediaModel)localObject, localLocalMediaInfo.mKuolieId, localLocalMediaInfo.mKuolieCenterX, localLocalMediaInfo.mKuolieCenterY, localLocalMediaInfo.mKuolieWidthScale, localLocalMediaInfo.mKuolieHeightScale, localLocalMediaInfo.mKuolieRotate);
    if (getActivity() == null)
    {
      AEQLog.d(Z, "activity is null.");
      return;
    }
    a(paramString1, paramString2, localLocalMediaInfo);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ag.setVisibility(4);
      this.ah.setVisibility(4);
      this.aj.setVisibility(4);
      return;
    }
    this.ag.setVisibility(0);
    this.ah.setVisibility(0);
    this.aj.setVisibility(0);
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2063991380: 
      ViewUtils.setVisible(this.ae, 8);
      ViewUtils.setVisible(this.g, 8);
      ViewUtils.setVisible(this.h, 0);
      ViewUtils.setVisible(this.k, 8);
      ViewUtils.setVisible(this.af, 8);
      localAEEditorMusicControlPanel = this.af;
      if (localAEEditorMusicControlPanel != null) {
        localAEEditorMusicControlPanel.b();
      }
      if (!paramBoolean) {
        x();
      }
      AEReportUtils.c(false);
      a(2063991131, "SP_KEY_RED_POINT_TIME_STAMP", true);
      return;
    case 2063991375: 
      ViewUtils.setVisible(this.ae, 8);
      ViewUtils.setVisible(this.g, 8);
      ViewUtils.setVisible(this.h, 8);
      v();
      ViewUtils.setVisible(this.k, 8);
      x();
      ViewUtils.setVisible(this.af, 0);
      AEReportUtils.k();
      return;
    case 2063991372: 
      ViewUtils.setVisible(this.ae, 8);
      ViewUtils.setVisible(this.g, 0);
      ViewUtils.setVisible(this.h, 8);
      v();
      ViewUtils.setVisible(this.k, 8);
      x();
      ViewUtils.setVisible(this.af, 8);
      localAEEditorMusicControlPanel = this.af;
      if (localAEEditorMusicControlPanel != null) {
        localAEEditorMusicControlPanel.b();
      }
      AEReportUtils.b(false);
      a(2063991129, "SP_KEY_RED_POINT_TIME_STAMP", true);
      return;
    case 2063991368: 
      ViewUtils.setVisible(this.ae, 0);
      ViewUtils.setVisible(this.g, 8);
      ViewUtils.setVisible(this.h, 8);
      v();
      ViewUtils.setVisible(this.k, 8);
      x();
      ViewUtils.setVisible(this.af, 8);
      localAEEditorMusicControlPanel = this.af;
      if (localAEEditorMusicControlPanel != null) {
        localAEEditorMusicControlPanel.b();
      }
      AEReportUtils.h();
      a(2063991582, "SP_KEY_RED_POINT_TIME_STAMP", true);
      return;
    }
    ViewUtils.setVisible(this.ae, 8);
    ViewUtils.setVisible(this.g, 8);
    ViewUtils.setVisible(this.h, 8);
    ViewUtils.setVisible(this.k, 0);
    ViewUtils.setVisible(this.af, 8);
    AEEditorMusicControlPanel localAEEditorMusicControlPanel = this.af;
    if (localAEEditorMusicControlPanel != null) {
      localAEEditorMusicControlPanel.b();
    }
    if (!paramBoolean) {
      v();
    }
    a(2063991133, "SP_KEY_RED_POINT_TIME_STAMP", true);
  }
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      if (this.aC != null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      int i;
      if ((this.aC == null) && (FlowCameraConstant.b != 2)) {
        i = 1;
      } else {
        i = 0;
      }
      AEEditorMusicHelper.a(paramArrayList, WatermarkDataManager.a().c(), paramBoolean, this.aC, i, this);
      return;
    }
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.22(this));
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    MoviePlayer localMoviePlayer;
    if (paramBoolean1)
    {
      if (this.am)
      {
        localMoviePlayer = this.D;
        if ((localMoviePlayer != null) && (!localMoviePlayer.isPlaying()))
        {
          if (paramBoolean2) {
            this.D.seekToTime(CMTime.fromMs(0L));
          }
          this.D.play();
        }
      }
    }
    else
    {
      localMoviePlayer = this.D;
      if ((localMoviePlayer != null) && (localMoviePlayer.isPlaying()))
      {
        this.am = true;
        this.D.pause();
        return;
      }
      this.am = false;
    }
  }
  
  public void aa()
  {
    d(false);
    this.an = true;
    String str;
    if (!TextUtils.isEmpty(AEBaseReportParam.a().n().d)) {
      str = AEBaseReportParam.a().n().d;
    } else {
      str = "";
    }
    Intent localIntent = az();
    AEEditorMusicHelper.a(getActivity(), str, localIntent);
    AEBaseDataReporter.a().w();
  }
  
  public void ab()
  {
    if (this.f != null)
    {
      this.f.setTitle(HardCodeUtil.a(2064187450));
      this.f.d();
      a(true);
    }
  }
  
  public void ac()
  {
    if (this.f != null)
    {
      this.f.setTitle(h());
      this.f.c();
      a(false);
    }
  }
  
  public void ad()
  {
    this.af.e();
  }
  
  public void ae() {}
  
  protected String af()
  {
    TAVCutVideoSession localTAVCutVideoSession = this.B;
    if ((localTAVCutVideoSession != null) && (localTAVCutVideoSession.getMediaModel() != null) && (this.B.getMediaModel().toString() != null)) {
      return Util.md5(this.B.getMediaModel().toString());
    }
    return "";
  }
  
  protected void ag()
  {
    N();
    Object localObject = this.B;
    if (localObject != null)
    {
      ((TAVCutVideoSession)localObject).release();
      this.B = null;
    }
    this.B = new TAVCutVideoSession();
    localObject = new MediaModel();
    ((MediaModel)localObject).setMediaResourceModel(this.A);
    a(getActivity(), this.B, this.U, (MediaModel)localObject, this.D, this.C);
    this.B.setStickerLyricCallback(this);
    this.B.setStickerOperationCallback(O());
    this.ad.a(this.B);
    ThreadManager.excute(new AEEditorVideoEditFragment.29(this), 16, null, true);
    aE();
    this.F = ah();
  }
  
  protected Size ah()
  {
    if (ModelExtKt.isLightTemplate(this.B.getMediaModel()))
    {
      LightAsset localLightAsset = LightAsset.Load(this.B.getMediaModel().getMediaTemplateModel().getLightMediaTemplateModel().getFilePath(), 100);
      this.G = new Size(localLightAsset.width(), localLightAsset.height());
    }
    else
    {
      this.G = a(this.B);
    }
    return this.U.a(this.G);
  }
  
  protected String ai()
  {
    return this.ac;
  }
  
  public void ar_()
  {
    if (this.j != null) {
      this.j.a();
    }
    QQToast.makeText(this.o, "资源下载中，请稍后再试", 0).show();
  }
  
  protected LocalMediaInfo b(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.x.size())
    {
      localArrayList.add(((AEAlbumMediaBaseModel)this.x.get(i)).getOriginPath());
      i += 1;
    }
    String str = Z;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createLocalMediaInfo... originPathList:");
    localStringBuilder.append(localArrayList);
    AEQLog.b(str, localStringBuilder.toString());
    return AELocalMediaInfoUtil.a(localArrayList, "", ah().getHeight(), ah().getWidth(), paramString1, paramString2, paramString3);
  }
  
  public void b(float paramFloat)
  {
    this.K = paramFloat;
    this.af.b(this.K);
    aC();
  }
  
  public void b(MetaMaterial paramMetaMaterial)
  {
    if (paramMetaMaterial != null) {
      a(paramMetaMaterial);
    }
  }
  
  public void b(AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_dispatch_music_event");
    localIntent.putExtra("event", "KTribeDownloadMusicSuccessWhenMediaPlay");
    localIntent.putExtra("cacheMusicMid", paramAEEditorMusicInfo.c());
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  public void b(@NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.25(this, paramInt, paramAEEditorMusicInfo));
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    a(paramBoolean);
  }
  
  public boolean b(int paramInt, MetaMaterial paramMetaMaterial)
  {
    AEBaseReportParam.a().n().l = paramMetaMaterial.id;
    AEBaseReportParam.a().n().m = -1.0F;
    return true;
  }
  
  public void c(int paramInt, MetaMaterial paramMetaMaterial)
  {
    D();
    a(paramInt);
    Object localObject = AEEditorResourceManager.a().c(paramMetaMaterial);
    float f2 = FilterMetaMaterialKt.j(paramMetaMaterial);
    float f1;
    if (this.aA.containsKey(Integer.valueOf(paramInt))) {
      f1 = ((Float)this.aA.get(Integer.valueOf(paramInt))).floatValue();
    } else {
      f1 = f2;
    }
    this.g.setSeekBarValue(f1);
    float f3 = FilterMetaMaterialKt.n(paramMetaMaterial);
    Map localMap = FilterMetaMaterialKt.p(paramMetaMaterial);
    String str = AEEditorResourceManager.a().e(paramMetaMaterial);
    this.B.resetAEKitModel(f1, (String)localObject, f3, localMap, str);
    AEBaseReportParam.a().n().l = paramMetaMaterial.id;
    AEBaseReportParam.a().n().m = f2;
    this.aD = paramMetaMaterial.id;
    localObject = AEQCircleReport.a();
    if (paramMetaMaterial == null) {
      paramMetaMaterial = "";
    } else {
      paramMetaMaterial = paramMetaMaterial.id;
    }
    ((AEQCircleReport)localObject).a(paramMetaMaterial, QCircleConstants.y, "0");
  }
  
  public void c(boolean paramBoolean)
  {
    a(paramBoolean);
  }
  
  public boolean c()
  {
    AEBaseDataReporter.a().y();
    if ((!this.V.equals(af())) && (!this.aH.equals(af())))
    {
      this.B.applyCurrentSticker();
      Object localObject = getActivity();
      localObject = DialogUtil.a((Context)localObject, 230).setTitle(HardCodeUtil.a(2064187526)).setMessage(((Context)localObject).getString(2064187528)).setPositiveButton(((Context)localObject).getString(2064187527), new AEEditorVideoEditFragment.33(this)).setNegativeButton(((Context)localObject).getString(2064187459), new AEEditorVideoEditFragment.32(this));
      if (localObject != null) {
        try
        {
          if (!((QQCustomDialog)localObject).isShowing()) {
            ((QQCustomDialog)localObject).show();
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
      return true;
    }
    getArguments().putSerializable("resource_model", this.z);
    G();
    return false;
  }
  
  public boolean c(int paramInt)
  {
    Object localObject = this.Q.a(this.ao);
    boolean bool;
    if ((localObject instanceof VideoAIFilterResult))
    {
      AEQLog.b(Z, "onAIFilterRequest: has cache");
      bool = ((VideoAIFilterResult)localObject).a;
    }
    else
    {
      bool = true;
    }
    if (bool)
    {
      A();
      localObject = new MultiVideoAIFilterProxy(this.B);
      ((VideoAIFilterProxy)localObject).a(this);
      AEEditorAIFilterManager.a().a(getActivity(), (AIFilterProxyBase)localObject);
    }
    else
    {
      a(AEEditorFilterControlPanel.a);
      this.g.setSelectedIndex(AEEditorFilterControlPanel.a, true);
      this.B.resetAEKitModelForAI(((AIFilterResult)localObject).b(), 0.8F, ((AIFilterResult)localObject).d(), 0, 0.0F);
      a(new String[] { "智能滤镜label", ((AIFilterResult)localObject).a(), "智能滤镜errCode", "0" });
      AEQCircleReport.a().a(QCircleConstants.C, QCircleConstants.y, QCircleConstants.z, "0");
    }
    return !bool;
  }
  
  public void d()
  {
    if (getArguments() != null)
    {
      getArguments().clear();
      getArguments().putSerializable("resource_model", this.z);
    }
  }
  
  protected void d(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public void e(boolean paramBoolean)
  {
    this.I = paramBoolean;
    AEBaseReportParam.a().n().o = b(this.H, this.I);
    List localList = this.af.getBackgroundMusicData();
    if (CollectionUtils.isEmpty(localList)) {
      return;
    }
    int m;
    if (paramBoolean)
    {
      localObject1 = this.M;
      if ((localObject1 != null) && (!((AEEditorMusicAdapter.AEEditorMusicInfo)localObject1).a()))
      {
        localObject1 = null;
        int i = 0;
        int k = 0;
        for (int j = 0;; j = n)
        {
          localObject2 = localObject1;
          n = k;
          m = j;
          if (i >= localList.size()) {
            break;
          }
          AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)localList.get(i);
          localObject2 = localObject1;
          m = k;
          n = j;
          if (localAEEditorMusicInfo != null)
          {
            localObject2 = localObject1;
            m = k;
            n = j;
            if (!localAEEditorMusicInfo.a())
            {
              localObject2 = localObject1;
              m = k;
              n = j;
              if (localAEEditorMusicInfo.f != 1) {
                if (localAEEditorMusicInfo.f == 0)
                {
                  localObject2 = localObject1;
                  m = k;
                  n = j;
                }
                else if (this.M.c().equals(localAEEditorMusicInfo.c()))
                {
                  localAEEditorMusicInfo.c = true;
                  n = i;
                  localObject2 = localAEEditorMusicInfo;
                  m = 1;
                }
                else
                {
                  localAEEditorMusicInfo.c = false;
                  n = j;
                  m = k;
                  localObject2 = localObject1;
                }
              }
            }
          }
          i += 1;
          localObject1 = localObject2;
          k = m;
        }
      }
      Object localObject2 = null;
      int n = 0;
      m = 0;
      if (n != 0)
      {
        this.M = localObject2;
        this.L = localObject2;
      }
      else
      {
        this.M = null;
        this.L = ((AEEditorMusicAdapter.AEEditorMusicInfo)localList.get(1));
      }
      this.L.c = true;
      AEBaseReportParam.a().n().n = this.L.c();
      AEBaseReportParam.a().n().p = this.L.g;
      AEBaseReportParam.a().n().q = this.L.h;
      AEBaseReportParam.a().n().r = this.L.f();
      AEBaseDataReporter.a().u();
    }
    else
    {
      this.M = this.L;
      this.L = null;
      localObject1 = localList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((AEEditorMusicAdapter.AEEditorMusicInfo)((Iterator)localObject1).next()).c = false;
      }
      AEBaseReportParam.a().n().n = "none";
      AEBaseReportParam.a().n().p = false;
      AEBaseReportParam.a().n().q = -1;
      AEBaseReportParam.a().n().r = -1;
      m = 0;
    }
    Object localObject1 = this.L;
    if (localObject1 != null) {
      a(((AEEditorMusicAdapter.AEEditorMusicInfo)localObject1).c(), this.L.e(), false);
    }
    d(this.L);
    this.af.a(localList);
    if (paramBoolean) {
      this.af.a(m);
    }
  }
  
  protected void f()
  {
    this.ao = ai();
  }
  
  public void f(boolean paramBoolean)
  {
    this.af.a(paramBoolean);
  }
  
  public int g()
  {
    return 2064056461;
  }
  
  public void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo = this.L;
      if (localAEEditorMusicInfo != null)
      {
        this.af.a(localAEEditorMusicInfo, Integer.valueOf(c(localAEEditorMusicInfo.c())), (int)this.E, this.P);
        this.P = false;
        return;
      }
    }
    QQToast.makeText(getActivity(), 2064187518, 0).show();
  }
  
  public String h()
  {
    return HardCodeUtil.a(2064187496);
  }
  
  public void h(boolean paramBoolean)
  {
    this.aF = paramBoolean;
    if (paramBoolean)
    {
      AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo = this.L;
      if (localAEEditorMusicInfo != null) {
        if (!b(localAEEditorMusicInfo.h())) {
          this.ai.setVisibility(0);
        } else {
          this.ai.setVisibility(4);
        }
      }
      aA();
      return;
    }
    aB();
    this.ai.setVisibility(4);
  }
  
  protected AEEditorFilterControlPanel.FilterControlListener i()
  {
    return this;
  }
  
  protected AEEditorStickerPart.AEEditorTextDialogListener j()
  {
    return new AEEditorVideoEditFragment.18(this);
  }
  
  protected void k()
  {
    AEEditorAIFilterManager.a().b();
  }
  
  protected void l() {}
  
  protected void m()
  {
    u();
    au();
  }
  
  protected void n()
  {
    w();
  }
  
  protected void o()
  {
    TAVCutVideoSession localTAVCutVideoSession = this.B;
    if (localTAVCutVideoSession != null) {
      localTAVCutVideoSession.applyCurrentSticker();
    }
  }
  
  public void onClickCancelBtn()
  {
    AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo = this.L;
    if (localAEEditorMusicInfo != null)
    {
      if (this.ar == null) {
        return;
      }
      a(AEEditorMusicHelper.a(localAEEditorMusicInfo), c(this.L.c()), this.L.f(), this.J, this.K, this.q ^ true);
      if (this.aF)
      {
        aB();
        aA();
      }
      this.ar = null;
      this.as = null;
    }
  }
  
  public void onClickConfirmBtn()
  {
    AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo = this.L;
    if (localAEEditorMusicInfo != null)
    {
      if (this.ar == null) {
        return;
      }
      a(localAEEditorMusicInfo.c(), this.ar.intValue(), true);
      a(AEEditorMusicHelper.a(this.L), this.ar.intValue(), this.L.f(), this.J, this.K, this.q ^ true);
      if (this.aF)
      {
        aB();
        aA();
      }
      this.ar = null;
      this.as = null;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AEQLog.b(Z, "onCreate");
    super.onCreate(paramBundle);
    AEEditorMusicHelper.a(getActivity());
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      this.aB = getActivity().getIntent().getIntExtra("editorFrom", -1);
      paramBundle = (HashMap)getActivity().getIntent().getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        paramBundle = paramBundle.entrySet().iterator();
        while (paramBundle.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramBundle.next();
          if (localEntry.getValue() != null) {
            this.aC = ((LocalMediaInfo)localEntry.getValue());
          }
        }
      }
    }
    this.al = new CopyOnWriteArrayList();
    this.ak = new CopyOnWriteArrayList();
    paramBundle = AEBaseReportParam.a().n();
    int i;
    if (this.aC != null) {
      i = 0;
    } else {
      i = 1;
    }
    paramBundle.u = i;
    this.ad = ((AEVideoEditViewModel)AEViewModelProviders.a(getActivity()).get(AEVideoEditViewModel.class));
    aD();
  }
  
  public void onDeleteSticker()
  {
    Object localObject = this.B;
    if (localObject != null) {
      a(((TAVCutVideoSession)localObject).saveLyricSticker());
    }
    localObject = this.af;
    if (localObject != null) {
      ((AEEditorMusicControlPanel)localObject).f();
    }
  }
  
  public void onDestroyView()
  {
    AEQLog.b(Z, "onDestroyView");
    super.onDestroyView();
    if (getArguments() != null) {
      getArguments().clear();
    }
    Object localObject = this.af;
    if (localObject != null) {
      ((AEEditorMusicControlPanel)localObject).c();
    }
    if (this.au != null) {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.au);
    }
    localObject = this.B;
    if (localObject != null) {
      ((TAVCutVideoSession)localObject).release();
    }
    this.aA.clear();
    this.H = true;
    this.I = false;
    this.J = 1.0F;
    this.K = 0.8F;
    this.L = null;
    this.M = null;
    this.N = null;
    this.at.clear();
    this.O = true;
    this.av = null;
    this.P = false;
    aq();
    localObject = this.ae;
    if (localObject != null) {
      ((AEEditorAutoTemplatePanel)localObject).e();
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    AEEditorVideoRecord.a().c();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    this.T = paramBoolean;
    if (!paramBoolean)
    {
      AEBaseDataReporter.a().z();
      a(true, true);
      paramBoolean = getArguments().getBoolean("ae_video_editor_entrance_mid_page", false);
      this.P = true;
      AEReportUtils.s();
      if ((aI()) && (getArguments() != null))
      {
        try
        {
          if ((MediaResourceModel)getArguments().getSerializable("resource_model") != null) {
            this.A = ((MediaResourceModel)getArguments().getSerializable("resource_model")).deepCopy();
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        try
        {
          this.B.getMediaModel().setMediaResourceModel(this.A);
          this.B.correctMediaResource(aa);
          this.B.updateTemplateComposition(true);
          this.B.restoreStickersWithLyric(new ArrayList(aH()));
          this.B.setMainVolume(this.J);
          this.B.setBgmVolume(this.K);
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        this.E = (this.B.getDuration().getTimeSeconds() * 1000L);
      }
      else if ((aJ()) && (getArguments() != null) && (QzoneConfig.isOpenFunctionSavePicToVideo()))
      {
        if (getArguments().getBoolean("key_is_need_update_source_path", false))
        {
          aD();
          this.B.getMediaModel().setMediaResourceModel(this.A);
          this.B.setStickerLyricCallback(this);
          this.B.setStickerOperationCallback(O());
          FragmentActivity localFragmentActivity = getActivity();
          TAVCutVideoSession localTAVCutVideoSession = this.B;
          a(localFragmentActivity, localTAVCutVideoSession, this.U, localTAVCutVideoSession.getMediaModel());
          aE();
        }
      }
      else
      {
        if ((aK()) && (getArguments() != null))
        {
          aF();
          this.ae.a(getArguments().getString("editor_video_template_id"));
          this.ae.setSchemeStatus(Boolean.valueOf(true));
          getView().postDelayed(new AEEditorVideoEditFragment.30(this), 1000L);
          aE();
          return;
        }
        if ((Boolean.valueOf(paramBoolean).booleanValue()) && (getArguments() != null))
        {
          aF();
          this.ae.a(getArguments().getString("editor_video_template_id"));
          this.ae.setSchemeStatus(Boolean.valueOf(true));
          getView().postDelayed(new AEEditorVideoEditFragment.31(this), 1000L);
          aE();
          return;
        }
      }
      this.ae.a(3);
      return;
    }
    d(false);
  }
  
  public void onIndicatorDragged(int paramInt)
  {
    MoviePlayer localMoviePlayer = this.D;
    if (localMoviePlayer != null)
    {
      localMoviePlayer.seekToTime(new CMTime(paramInt, 1000));
      this.D.play();
    }
  }
  
  public void onLyricPanelHide()
  {
    if (this.f != null)
    {
      this.f.c();
      this.f.setTitle(h());
      a(false);
    }
  }
  
  public void onLyricPanelShow()
  {
    if (this.f != null)
    {
      this.f.d();
      this.f.setTitle(HardCodeUtil.a(2064187472));
      a(true);
    }
  }
  
  public void onMusicWaveMoveEnd()
  {
    if ((this.L != null) && (this.ar != null))
    {
      AEEditorLyricProgressCalculator.a().b(this.ar.intValue(), Math.min(this.ar.intValue() + this.E, this.L.f()));
      a(AEEditorMusicHelper.a(this.L), this.ar.intValue(), this.L.f(), this.J, this.K, this.q ^ true);
      if (this.aF)
      {
        aB();
        b(this.ar.intValue());
      }
      return;
    }
    MoviePlayer localMoviePlayer = this.D;
    if (localMoviePlayer != null) {
      localMoviePlayer.play();
    }
  }
  
  public void onMusicWaveMoveStart()
  {
    MoviePlayer localMoviePlayer = this.D;
    if (localMoviePlayer != null) {
      localMoviePlayer.pause();
    }
  }
  
  public void onMusicWaveMoving(int paramInt1, int paramInt2)
  {
    this.af.a(paramInt1, paramInt2);
    this.ar = Integer.valueOf(paramInt1);
    this.as = Integer.valueOf(paramInt2);
  }
  
  public void onPause()
  {
    super.onPause();
    AEQLog.b(Z, "onPause");
    if (!this.T)
    {
      MoviePlayer localMoviePlayer = this.D;
      if (localMoviePlayer != null) {
        localMoviePlayer.pause();
      }
    }
  }
  
  public void onResetMusicRangeToRecommend(int paramInt)
  {
    if (this.L == null) {
      return;
    }
    AEEditorLyricProgressCalculator localAEEditorLyricProgressCalculator = AEEditorLyricProgressCalculator.a();
    long l = paramInt;
    localAEEditorLyricProgressCalculator.b(l, Math.min(this.E + l, this.L.f()));
    a(AEEditorMusicHelper.a(this.L), paramInt, this.L.f(), this.J, this.K, this.q ^ true);
    this.af.b(paramInt);
    int i = (int)(l + this.E);
    this.af.a(paramInt, i);
    this.ar = Integer.valueOf(paramInt);
    this.as = Integer.valueOf(i);
    if (this.aF)
    {
      aB();
      b(this.ar.intValue());
    }
  }
  
  public void onResume()
  {
    AEQLog.b(Z, "onResume");
    super.onResume();
    if (!this.T)
    {
      AEBaseDataReporter.a().z();
      Object localObject = this.D;
      if (localObject != null) {
        ((MoviePlayer)localObject).play();
      }
      localObject = this.av;
      if (localObject != null) {
        a((VsMusicItemInfo)localObject, true);
      }
      AEReportUtils.s();
    }
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle = b().a();
    if ((paramBundle != null) && (paramBundle == this))
    {
      paramBundle = null;
      if (getActivity().getIntent() != null) {
        paramBundle = (HashMap)getActivity().getIntent().getSerializableExtra("PeakConstants.selectedMediaInfoHashMap.recovery");
      }
      AEEditorVideoRecord localAEEditorVideoRecord = AEEditorVideoRecord.a();
      ArrayList localArrayList = this.x;
      Object localObject = this.S;
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = ((MetaMaterial)localObject).id;
      }
      localAEEditorVideoRecord.a(localArrayList, paramBundle, (String)localObject, this.aD, 1);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AEQLog.b(Z, "onViewCreated");
    b(paramView);
    super.onViewCreated(paramView, paramBundle);
    ag();
    t();
    al();
    AEBaseReportParam.a().n().n = "none";
    AEBaseReportParam.a().n().p = false;
    AEBaseReportParam.a().n().q = -1;
    AEBaseReportParam.a().n().r = -1;
    AEBaseReportParam.a().n().o = b(this.H, this.I);
    AEBaseReportParam.a().n().y = "none";
    AEBaseReportParam.a().n().z = "none";
    paramBundle = VideoUtil.getVideoSize(this.ao);
    a(this.ao, paramBundle.getWidth(), paramBundle.getHeight(), this.aq, this.B.getDuration().getTimeUs() / 1000L);
    a(new String[] { "设备级别", ParamsUtil.a(), "视频最大预览尺寸", String.valueOf(this.U.a()), "视频原始尺寸", String.format("width=%d, height=%d", new Object[] { Integer.valueOf(this.G.getWidth()), Integer.valueOf(this.G.getHeight()) }), "视频导出尺寸", String.format("width=%d, height=%d", new Object[] { Integer.valueOf(this.F.getWidth()), Integer.valueOf(this.F.getHeight()) }), "视频导出码率", String.valueOf(this.U.b()), "视频导出帧率", String.valueOf(this.U.c()) });
    if (AEEditorResourceManager.a().m()) {
      X();
    }
    av();
    a(paramView.findViewById(2063991368));
    AEEditorVideoRecord.a().a(this.B, getArguments(), this.w, this.v);
    AEEditorVideoRecord.a().a(this);
  }
  
  protected TAVCutSession p()
  {
    return this.B;
  }
  
  protected int q()
  {
    return -1;
  }
  
  public void r()
  {
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.19(this));
    Object localObject1 = AEEditorPath.EDITOR.FILES.e;
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new File(this.ao);
    String str = Y();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(File.separator);
    ((StringBuilder)localObject3).append("output_");
    ((StringBuilder)localObject3).append(str);
    ((StringBuilder)localObject3).append("_");
    ((StringBuilder)localObject3).append(VideoFilterTools.d(((File)localObject2).getName()));
    ((StringBuilder)localObject3).append(".jpg");
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append(File.separator);
    ((StringBuilder)localObject4).append("output_");
    ((StringBuilder)localObject4).append(str);
    ((StringBuilder)localObject4).append("_");
    ((StringBuilder)localObject4).append(VideoFilterTools.d(((File)localObject2).getName()));
    ((StringBuilder)localObject4).append(".mp4");
    localObject4 = ((StringBuilder)localObject4).toString();
    this.ap = ((String)localObject4);
    ay();
    localObject1 = null;
    if (getActivity().getIntent() != null) {
      localObject1 = (HashMap)getActivity().getIntent().getSerializableExtra("PeakConstants.selectedMediaInfoHashMap.recovery");
    }
    AEEditorVideoRecord localAEEditorVideoRecord = AEEditorVideoRecord.a();
    ArrayList localArrayList = this.x;
    localObject2 = this.S;
    if (localObject2 == null) {
      localObject2 = "";
    } else {
      localObject2 = ((MetaMaterial)localObject2).id;
    }
    localAEEditorVideoRecord.a(localArrayList, (HashMap)localObject1, (String)localObject2, this.aD, 2);
    if (this.D.isPlaying()) {
      this.D.pause();
    }
    if (this.B != null)
    {
      localObject1 = new TAVCutVideoSession();
      a(BaseApplicationImpl.getContext(), (TAVCutVideoSession)localObject1, this.U, this.B.getMediaModel(), null, null);
      ((TAVCutVideoSession)localObject1).applyCurrentSticker();
      long l = 1000L;
      if (((TAVCutVideoSession)localObject1).getDuration().getValue() > 2000L) {
        l = 2000L;
      }
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).pExportStart(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext1(), "cover"), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext2(), this.ao), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext3(), (String)localObject3), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).keyRetCode(), "0") }));
      ((TAVCutVideoSession)localObject1).getEffectVideoFrame(l, 1080, new AEEditorVideoEditFragment.20(this, (TAVCutVideoSession)localObject1, (String)localObject3, (String)localObject4, str));
      return;
    }
    a((String)localObject4, (String)localObject3, str);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).pExportEnd(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext1(), "noCover"), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext2(), this.ao), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext3(), (String)localObject3), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).keyRetCode(), "0") }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment
 * JD-Core Version:    0.7.0.1
 */