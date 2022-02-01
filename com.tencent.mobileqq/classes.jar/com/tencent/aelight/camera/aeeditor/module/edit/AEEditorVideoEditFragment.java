package com.tencent.aelight.camera.aeeditor.module.edit;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
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
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutSession;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.session.callback.StickerLyricCallback;
import com.tencent.tavcut.session.callback.StickerOperationCallback;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavcut.util.Util;
import com.tencent.tavcut.util.VideoUtil;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import com.tencent.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.ModelExtKt;
import com.tencent.weseevideo.model.data.MusicData;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.MusicModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import com.tencent.weseevideo.model.effect.SubtitleModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import com.tencent.weseevideo.model.template.MediaTemplateModel;
import com.tencent.weseevideo.model.template.light.LightMediaTemplateModel;
import com.tencent.weseevideo.model.template.light.LightTemplate;
import com.tencent.weseevideo.model.template.movie.MovieSegmentModel;
import common.config.service.QzoneConfig;
import dov.com.qq.im.aeeditor.module.autotemplate.AEAutoTemplateRet;
import feedcloud.FeedCloudCommon.Entry;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.light.LightAsset;

public class AEEditorVideoEditFragment
  extends AEEditorCommonEditFragment
  implements AEEditorAIFilterManager.AIFilterObserver, AEEditorFilterControlPanel.FilterControlListener, AEEditorLyricPanelDialog.OperationCallback, AEEditorMusicHelper.MusicDownloadCallback, AEEditorMusicPanel.OperationCallback, AEEditorMusicVolumePanelDialog.OperationCallback, VideoEditToolBar.VideoToolBarListener, IVideoOnRestore, VSDispatchObserver.onVSRspCallBack<CLIENT.StSmartMatchMusicRsp>, FrameVideoHelper.GetFrameByteArrayListener, StickerLyricCallback
{
  private static final int jdField_c_of_type_Int = ;
  private static final String jdField_c_of_type_JavaLangString = "AEEditorVideoEditFragment";
  public static boolean h;
  protected float a;
  protected long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected MetaMaterial a;
  protected AIFilterDataCache a;
  protected VideoAIFilterResult a;
  private AEEditorAutoTemplatePanel jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel;
  private AEEditorMusicControlPanel jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel;
  private AEVideoEditViewModel jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEVideoEditViewModel;
  protected AEEditorMusicAdapter.AEEditorMusicInfo a;
  protected VideoParamStrategy a;
  protected AEEditorQcircleBubbleView a;
  private VsMusicItemInfo jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  protected Size a;
  protected MoviePlayer a;
  protected TAVCutVideoSession a;
  protected TAVCutVideoView a;
  protected MusicData a;
  private SubtitleModel jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel;
  protected MediaResourceModel a;
  private Float jdField_a_of_type_JavaLangFloat;
  private Integer jdField_a_of_type_JavaLangInteger = null;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new AEEditorVideoEditFragment.15(this);
  private HashMap<Integer, Float> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<MediaClipModel> jdField_a_of_type_JavaUtilList;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private CopyOnWriteArrayList<String> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  protected float b;
  private long jdField_b_of_type_Long;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected AEEditorMusicAdapter.AEEditorMusicInfo b;
  protected AEEditorQcircleBubbleView b;
  protected Size b;
  protected MediaResourceModel b;
  private Integer jdField_b_of_type_JavaLangInteger = null;
  private final Runnable jdField_b_of_type_JavaLangRunnable = new AEEditorVideoEditFragment.16(this);
  protected String b;
  protected ArrayList<String> b;
  private CopyOnWriteArrayList<String> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  protected boolean c;
  private int jdField_d_of_type_Int = -1;
  private String jdField_d_of_type_JavaLangString;
  protected boolean d;
  private String e;
  protected boolean e;
  private String f;
  protected boolean f;
  private String g;
  protected boolean g;
  private String h;
  private boolean i = false;
  private boolean j = false;
  
  static
  {
    File localFile = new File(AEEditorPath.EDITOR.CACHE.jdField_c_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    jdField_h_of_type_Boolean = false;
  }
  
  public AEEditorVideoEditFragment()
  {
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = null;
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = null;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 0.8F;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = null;
    this.jdField_b_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = null;
    this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = null;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterAIFilterDataCache = new AIFilterDataCache();
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsVideoParamStrategy = ParamFactory.a();
    this.jdField_h_of_type_JavaLangString = "";
  }
  
  private void S()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new AEEditorVideoEditFragment.1(this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void T()
  {
    a(2064122808, "SP_KEY_RED_POINT_TIME_STAMP", false);
    a(2064122255, "SP_KEY_RED_POINT_TIME_STAMP", false);
    a(2064122257, "SP_KEY_RED_POINT_TIME_STAMP", false);
    a(2064122259, "SP_KEY_RED_POINT_TIME_STAMP", false);
  }
  
  private void U()
  {
    l();
    n();
  }
  
  private void V()
  {
    MoviePlayer localMoviePlayer = this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
    if (localMoviePlayer == null) {
      return;
    }
    if (!localMoviePlayer.isPlaying())
    {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
      return;
    }
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
  }
  
  private void W()
  {
    Bundle localBundle = getArguments();
    localBundle.putBoolean("ae_editor_is_light_model", ModelExtKt.isLightTemplate(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel()));
    if (ModelExtKt.isLightTemplate(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel()))
    {
      MediaResourceModel localMediaResourceModel = a(this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel);
      getArguments().putSerializable("resource_model", localMediaResourceModel);
    }
    else
    {
      getArguments().putSerializable("resource_model", this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel);
    }
    a().a(this, a(), localBundle);
  }
  
  private void X()
  {
    AEBaseReportParam.a().a().i = 0;
    AEBaseDataReporter.a().q();
  }
  
  private void Y()
  {
    boolean bool;
    if ((d()) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.getVisibility() == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (jdField_h_of_type_Boolean)
    {
      j(bool);
      return;
    }
    if (bool) {
      Z();
    }
  }
  
  private void Z()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorQcircleBubbleView == null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorQcircleBubbleView = new AEEditorQcircleBubbleView(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView.post(new AEEditorVideoEditFragment.13(this));
  }
  
  private int a(@NonNull String paramString)
  {
    paramString = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  private int a(boolean paramBoolean1, boolean paramBoolean2)
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
  
  public static Size a(TAVCutVideoSession paramTAVCutVideoSession)
  {
    if (paramTAVCutVideoSession != null) {
      return paramTAVCutVideoSession.getExportMaxMediaSize();
    }
    return new Size(720, 1080);
  }
  
  @Nullable
  private ArrayList<String> a(@Nullable VideoAIFilterResult paramVideoAIFilterResult)
  {
    if (paramVideoAIFilterResult != null)
    {
      if (CollectionUtils.isEmpty(paramVideoAIFilterResult.jdField_a_of_type_JavaUtilList)) {
        return null;
      }
      Object localObject = new LinkedList(paramVideoAIFilterResult.jdField_a_of_type_JavaUtilList);
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
  
  private List<StickerModel> a()
  {
    MediaModel localMediaModel = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel();
    if (localMediaModel != null) {
      return localMediaModel.getMediaEffectModel().getStickerModelList();
    }
    return new ArrayList();
  }
  
  private List<AEEditorMusicAdapter.AEEditorMusicInfo> a(@NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, int paramInt1, int paramInt2)
  {
    if (paramAEEditorMusicInfo.a()) {
      return null;
    }
    List localList = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.a();
    int m = 0;
    Iterator localIterator = localList.iterator();
    AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo;
    do
    {
      k = m;
      if (!localIterator.hasNext()) {
        break;
      }
      localAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)localIterator.next();
    } while ((localAEEditorMusicInfo == null) || (localAEEditorMusicInfo.a()) || (paramAEEditorMusicInfo.jdField_c_of_type_Int == 1) || (paramAEEditorMusicInfo.jdField_c_of_type_Int == 0) || (!paramAEEditorMusicInfo.a().equals(localAEEditorMusicInfo.a())));
    localAEEditorMusicInfo.jdField_a_of_type_Int = paramInt1;
    localAEEditorMusicInfo.jdField_b_of_type_Int = paramInt2;
    int k = 1;
    if (k != 0) {
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
    paramVideoParamStrategy.setDeleteIconResId(2064056472);
    paramVideoParamStrategy.setEditIconResId(2064056471);
    paramVideoParamStrategy.setZoomIconResId(2064056473);
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
    paramVideoParamStrategy.setDeleteIconResId(2064056472);
    paramVideoParamStrategy.setEditIconResId(2064056471);
    paramVideoParamStrategy.setZoomIconResId(2064056473);
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
    jdField_h_of_type_Boolean = paramTAVCutVideoSession.correctMediaResource(jdField_c_of_type_Int);
    if (ModelExtKt.isLightTemplate(paramVideoParamStrategy))
    {
      paramTAVCutVideoSession.setTemplate(4, new File(paramVideoParamStrategy.getMediaTemplateModel().getLightMediaTemplateModel().getFilePath()).getParent(), true, new String[] { "template.json" });
      return;
    }
    paramTAVCutVideoSession.setTemplate(2, "assets://camera/template", true, false, new String[] { "template.json" });
  }
  
  private void a(@Nullable AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo)
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null) {
      return;
    }
    if ((paramAEEditorMusicInfo != null) && (this.jdField_d_of_type_Boolean))
    {
      if (paramAEEditorMusicInfo.jdField_c_of_type_Int == 3) {
        return;
      }
      String str = AEEditorMusicHelper.a(paramAEEditorMusicInfo);
      boolean bool = AEEditorMusicHelper.a(str);
      if (this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData != null)
      {
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(0.0F);
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.setBgmPlayed(false, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
      }
      if (bool)
      {
        paramAEEditorMusicInfo.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = AEEditorMusicHelper.a(str, a(paramAEEditorMusicInfo.a()), paramAEEditorMusicInfo.b());
        a(this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_Boolean ^ true);
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
          i(true);
        }
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.setBgmPlayed(true, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
        return;
      }
      if ((getActivity() != null) && (MobileQQ.sMobileQQ.peekAppRuntime() != null))
      {
        if (paramAEEditorMusicInfo.jdField_a_of_type_Int == 1)
        {
          str = jdField_c_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[updateSoundAndMusicConfig], editorMusicInfo=");
          localStringBuilder.append(paramAEEditorMusicInfo);
          localStringBuilder.append(", downloadStatus=STATUS_DOWNLOADING");
          AEQLog.b(str, localStringBuilder.toString());
          return;
        }
        paramAEEditorMusicInfo.jdField_a_of_type_Int = 1;
        ThreadManager.excute(new AEEditorMusicHelper.MusicDownloadRunnable(MobileQQ.sMobileQQ.peekAppRuntime(), paramAEEditorMusicInfo, paramAEEditorMusicInfo.b(), str, this), 128, null, true);
        return;
      }
      AEQLog.b(jdField_c_of_type_JavaLangString, "[updateSoundAndMusicConfig], activity=null OR appInterface=null");
      return;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setMainVolume(this.jdField_a_of_type_Float);
    if (this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData != null) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(0.0F);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.setBgmPlayed(false, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
  }
  
  private void a(@NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, boolean paramBoolean)
  {
    int k;
    if (paramBoolean) {
      k = 2;
    } else {
      k = 0;
    }
    paramAEEditorMusicInfo = a(paramAEEditorMusicInfo, k, 0);
    if (paramAEEditorMusicInfo != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.a(paramAEEditorMusicInfo);
    }
  }
  
  private void a(@NonNull VsMusicItemInfo paramVsMusicItemInfo)
  {
    AEQLog.b(jdField_c_of_type_JavaLangString, "[requestDetailedMusicInfo]");
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = null;
    if (TextUtils.isEmpty(paramVsMusicItemInfo.mSongMid)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramVsMusicItemInfo.mSongMid);
    AEEditorMusicHelper.a(localArrayList, new AEEditorVideoEditFragment.23(this, paramVsMusicItemInfo));
  }
  
  private void a(@NonNull AEAutoTemplateRet paramAEAutoTemplateRet)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView = new AEEditorLoadingView(getActivity());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView.setLoadingListener(new AEEditorVideoEditFragment.9(this, paramAEAutoTemplateRet));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView.a(2);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView);
  }
  
  private void a(@NonNull String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = AEEditorMusicHelper.a(paramString, paramInt1, paramInt2);
    a(this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData, paramFloat1, paramFloat2, paramBoolean);
  }
  
  private void a(@NonNull String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(paramInt));
      return;
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(paramInt));
    }
  }
  
  private void a(String paramString1, String paramString2, LocalMediaInfo paramLocalMediaInfo)
  {
    if (getActivity() == null)
    {
      AEQLog.d(jdField_c_of_type_JavaLangString, "activity is null.");
      return;
    }
    Intent localIntent = new Intent();
    Object localObject1 = a();
    localIntent.putExtra("ae_editor_video_flag", true);
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", paramLocalMediaInfo);
    localIntent.putExtra("ae_editor_video_path", paramString1);
    localIntent.putExtra("ae_editor_video_thumb_path", paramString2);
    localIntent.putExtra("ae_editor_video_export_size_height", ((Size)localObject1).getHeight());
    localIntent.putExtra("ae_editor_video_export_size_width", ((Size)localObject1).getWidth());
    Object localObject2 = AEBaseReportParam.a().a();
    boolean bool = TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString);
    String str2 = "none";
    if (bool) {
      paramString1 = "none";
    } else {
      paramString1 = this.jdField_f_of_type_JavaLangString;
    }
    if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
      paramString2 = "none";
    } else {
      paramString2 = this.jdField_g_of_type_JavaLangString;
    }
    paramLocalMediaInfo = this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
    if (paramLocalMediaInfo == null) {
      paramLocalMediaInfo = "none";
    } else {
      paramLocalMediaInfo = paramLocalMediaInfo.id;
    }
    if (localObject2 == null) {
      localObject1 = "none";
    } else {
      localObject1 = ((AEEditReportData)localObject2).jdField_d_of_type_JavaLangString;
    }
    if (localObject2 == null) {
      localObject2 = "none";
    } else {
      localObject2 = ((AEEditReportData)localObject2).jdField_e_of_type_JavaLangString;
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
    paramString1 = a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterVideoAIFilterResult);
    if (!CollectionUtils.isEmpty(this.jdField_b_of_type_JavaUtilArrayList)) {
      localIntent.putStringArrayListExtra("ae_editor_video_text_cache", this.jdField_b_of_type_JavaUtilArrayList);
    } else if (!CollectionUtils.isEmpty(paramString1)) {
      localIntent.putStringArrayListExtra("ae_editor_video_text_cache", paramString1);
    }
    AEBaseReportParam.a().n();
    localIntent.putExtra("editorFrom", this.jdField_d_of_type_Int);
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
  }
  
  private boolean a(String paramString)
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
  
  private void aa()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel() != null)
    {
      AEBaseReportParam.a().a().jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList().size();
      Object localObject2 = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList();
      int k = 0;
      a((List)localObject2, 0);
      a((List)localObject2);
      Object localObject1 = AEBaseReportParam.a().a();
      if (localObject1 == null) {
        localObject1 = "none";
      } else {
        localObject1 = ((AEEditReportData)localObject1).jdField_d_of_type_JavaLangString;
      }
      Object localObject4 = new StringBuilder();
      Object localObject3 = new StringBuilder();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (StickerModel)((Iterator)localObject2).next();
        if ((this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel != null) && (localObject5 != null)) {
          if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a(((StickerModel)localObject5).getMaterialId()) == null)
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
      localObject3 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
      if ((localObject3 != null) && (((AEEditorMusicAdapter.AEEditorMusicInfo)localObject3).a() != null)) {
        localObject3 = String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a().mMusicName);
      } else {
        localObject3 = "none";
      }
      localObject4 = this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
      if (localObject4 != null) {
        localObject4 = ((MetaMaterial)localObject4).id;
      } else {
        localObject4 = "none";
      }
      int m = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaResourceModel().getVideos().size();
      if (this.jdField_a_of_type_Float != 0.0F) {
        k = 1;
      }
      this.jdField_f_of_type_JavaLangString = ((String)localObject2);
      this.jdField_g_of_type_JavaLangString = ((String)localObject5);
      if (TextUtils.isEmpty((CharSequence)localObject5)) {
        localObject5 = "none";
      }
      AEReportUtils.a("", String.valueOf(m), String.valueOf(k), (String)localObject5, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4);
    }
    AEBaseDataReporter.a().p();
  }
  
  private void ab()
  {
    if (this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel == null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
      if (localObject1 != null)
      {
        Object localObject2 = ((AEEditorMusicAdapter.AEEditorMusicInfo)localObject1).d();
        if (!a((String)localObject2)) {
          return;
        }
        localObject1 = new SubtitleModel();
        ((SubtitleModel)localObject1).setAssetFilePath("ae_editor_lyric_default.pag");
        Size localSize = VideoUtil.getVideoSize(this.jdField_e_of_type_JavaLangString);
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
        ((SubtitleModel)localObject1).setLyricFormatIsQRC(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.e().equals("QRC"));
        ((SubtitleModel)localObject1).setMusicStartTime(a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a()));
        localObject2 = AEEditorResourceManager.a().a("font_runyuan75w", 0);
        if ((!TextUtils.isEmpty((CharSequence)((android.util.Pair)localObject2).first)) && (new File((String)((android.util.Pair)localObject2).first).exists())) {
          ((SubtitleModel)localObject1).setFontPath((String)((android.util.Pair)localObject2).first);
        }
        this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel = ((SubtitleModel)localObject1);
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addSticker(this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel);
        return;
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
    if (localObject1 != null)
    {
      localObject1 = ((AEEditorMusicAdapter.AEEditorMusicInfo)localObject1).d();
      if (!a((String)localObject1)) {
        return;
      }
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyric((String)localObject1);
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyricFormatIsQRC(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.e().equals("QRC"));
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setMusicStartTime(a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a()));
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addSticker(this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel);
  }
  
  private void ac()
  {
    TAVCutVideoSession localTAVCutVideoSession = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
    if (localTAVCutVideoSession == null) {
      return;
    }
    a(localTAVCutVideoSession.saveLyricSticker());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.deleteLyricSticker();
  }
  
  private void ad()
  {
    TAVCutVideoSession localTAVCutVideoSession = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
    if (localTAVCutVideoSession == null) {
      return;
    }
    localTAVCutVideoSession.setMainVolume(this.jdField_a_of_type_Float);
    if (this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData != null)
    {
      localTAVCutVideoSession = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
      float f1;
      if (this.jdField_d_of_type_Boolean) {
        f1 = this.jdField_b_of_type_Float;
      } else {
        f1 = 0.0F;
      }
      localTAVCutVideoSession.setBgmVolume(f1);
    }
  }
  
  private void ae()
  {
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel = ((MediaResourceModel)getArguments().getSerializable("resource_model"));
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)getArguments().getSerializable("ae_album_selected_media_models"));
    try
    {
      if (this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel == null)
      {
        this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel = new MediaResourceModel();
        this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel.setVideos(DataProcessor.a(this.jdField_a_of_type_JavaUtilArrayList));
      }
      this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel = this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel.deepCopy();
      if (this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel.getVideos().size() > 0)
      {
        this.jdField_d_of_type_JavaLangString = ((MediaClipModel)this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel.getVideos().get(0)).getResource().getPath();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void af()
  {
    this.jdField_b_of_type_JavaLangString = f();
  }
  
  private void ag()
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList().clear();
    AEEditorAutoTemplatePanel localAEEditorAutoTemplatePanel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel;
    if (localAEEditorAutoTemplatePanel != null) {
      localAEEditorAutoTemplatePanel.d();
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a();
    }
    U();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel = ((AEEditorMusicControlPanel)paramView.findViewById(2064122444));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.setMusicListOperationCallback(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.setMusicLyricOperationCallback(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.setMusicVolumeOperationCallback(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.setAutoTemplateMode(false, false);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.setOriginSoundOn(g());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel = ((AEEditorAutoTemplatePanel)paramView.findViewById(2064121969));
    if (getArguments() != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.setEntrance(getArguments().getInt("ae_video_editor_entrance_id", 0));
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.setToastValidListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.a().observe(getViewLifecycleOwner(), new AEEditorVideoEditFragment.2(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.b().observe(getViewLifecycleOwner(), new AEEditorVideoEditFragment.3(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.b().postValue(Boolean.valueOf(false));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122677));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AEEditorVideoEditFragment.4(this));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2064122553);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new AEEditorVideoEditFragment.5(this));
    i(true);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122678));
    ((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.jdField_b_of_type_AndroidWidgetTextView, false);
    Size localSize = VideoUtil.getVideoSize(this.jdField_e_of_type_JavaLangString);
    if ((localSize != null) && (localSize.getHeight() != 0))
    {
      if (localSize.getWidth() / localSize.getHeight() > 1.0F) {
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122675));
      } else {
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122674));
      }
    }
    else {
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122674));
    }
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = ((TAVCutVideoView)paramView.findViewById(2064122676));
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView.setOnClickListener(new AEEditorVideoEditFragment.6(this));
    paramView = new GestureDetector(paramView.getContext(), new AEEditorVideoEditFragment.7(this));
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView.setOnTouchListener(new AEEditorVideoEditFragment.8(this, paramView));
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
      if (localObject != null)
      {
        localObject = ((AEEditorMusicAdapter.AEEditorMusicInfo)localObject).d();
        if (!a((String)localObject)) {
          return;
        }
        this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyric((String)localObject);
        this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyricFormatIsQRC(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.e().equals("QRC"));
        this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setMusicStartTime(paramInt);
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addSticker(this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel);
      }
    }
  }
  
  private boolean g()
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
  
  private boolean h()
  {
    return (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("AEEditorMultiCutFragment"));
  }
  
  private void i(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setSelected(paramBoolean);
    }
  }
  
  private boolean i()
  {
    return (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("AEEditorImageEdit"));
  }
  
  private void j(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentAelightCameraAeeditorViewAEEditorQcircleBubbleView == null) {
      this.jdField_b_of_type_ComTencentAelightCameraAeeditorViewAEEditorQcircleBubbleView = new AEEditorQcircleBubbleView(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView.post(new AEEditorVideoEditFragment.14(this, paramBoolean));
  }
  
  public void A()
  {
    s();
    a(-1);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.clearAEKitModel();
    AEBaseReportParam.a().a().jdField_d_of_type_JavaLangString = "none";
    AEBaseReportParam.a().a().jdField_a_of_type_Float = -1.0F;
  }
  
  public void B() {}
  
  public void C() {}
  
  public void D() {}
  
  public void E()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.a();
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      ad();
    }
    AEBaseDataReporter.a().r();
  }
  
  protected void F()
  {
    SilentVideoAIFilterProxy localSilentVideoAIFilterProxy = new SilentVideoAIFilterProxy(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
    localSilentVideoAIFilterProxy.a(new AEEditorVideoEditFragment.17(this));
    AEEditorAIFilterManager.a().a(getActivity(), localSilentVideoAIFilterProxy);
  }
  
  public void G()
  {
    String str;
    if (!TextUtils.isEmpty(AEBaseReportParam.a().a().jdField_a_of_type_JavaLangString)) {
      str = AEBaseReportParam.a().a().jdField_a_of_type_JavaLangString;
    } else {
      str = "";
    }
    AEEditorMusicHelper.a(getActivity(), str);
    AEBaseDataReporter.a().v();
  }
  
  public void H()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar != null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar.setTitle(HardCodeUtil.a(2064515108));
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar.d();
      a(true);
    }
  }
  
  public void I()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar != null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar.setTitle(b());
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar.c();
      a(false);
    }
  }
  
  public void J()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.e();
  }
  
  public void K() {}
  
  public void L()
  {
    MoviePlayer localMoviePlayer = this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
    if (localMoviePlayer != null) {
      localMoviePlayer.pause();
    }
  }
  
  public void M()
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo != null) && (this.jdField_a_of_type_JavaLangInteger != null))
    {
      AEEditorLyricProgressCalculator.a().b(this.jdField_a_of_type_JavaLangInteger.intValue(), Math.min(this.jdField_a_of_type_JavaLangInteger.intValue() + this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.b()));
      a(AEEditorMusicHelper.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo), this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.b(), this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_Boolean ^ true);
      if (this.j)
      {
        ac();
        d(this.jdField_a_of_type_JavaLangInteger.intValue());
      }
      return;
    }
    MoviePlayer localMoviePlayer = this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
    if (localMoviePlayer != null) {
      localMoviePlayer.play();
    }
  }
  
  public void N()
  {
    AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
    if (localAEEditorMusicInfo != null)
    {
      if (this.jdField_a_of_type_JavaLangInteger == null) {
        return;
      }
      a(AEEditorMusicHelper.a(localAEEditorMusicInfo), a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a()), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.b(), this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_Boolean ^ true);
      if (this.j)
      {
        ac();
        ab();
      }
      this.jdField_a_of_type_JavaLangInteger = null;
      this.jdField_b_of_type_JavaLangInteger = null;
    }
  }
  
  public void O()
  {
    AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
    if (localAEEditorMusicInfo != null)
    {
      if (this.jdField_a_of_type_JavaLangInteger == null) {
        return;
      }
      a(localAEEditorMusicInfo.a(), this.jdField_a_of_type_JavaLangInteger.intValue(), true);
      a(AEEditorMusicHelper.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo), this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.b(), this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_Boolean ^ true);
      if (this.j)
      {
        ac();
        ab();
      }
      this.jdField_a_of_type_JavaLangInteger = null;
      this.jdField_b_of_type_JavaLangInteger = null;
    }
  }
  
  public void P()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar != null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar.d();
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar.setTitle(HardCodeUtil.a(2064515130));
      a(true);
    }
  }
  
  public void Q()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar != null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar.c();
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTopbarAEEditorTopBar.setTitle(b());
      a(false);
    }
  }
  
  protected void R()
  {
    x();
    Object localObject = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
    if (localObject != null)
    {
      ((TAVCutVideoSession)localObject).release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = null;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    localObject = new MediaModel();
    ((MediaModel)localObject).setMediaResourceModel(this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel);
    a(getActivity(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsVideoParamStrategy, (MediaModel)localObject, this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer, this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setStickerLyricCallback(this);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setStickerOperationCallback(a());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEVideoEditViewModel.a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
    ThreadManager.excute(new AEEditorVideoEditFragment.29(this), 16, null, true);
    af();
    this.jdField_a_of_type_ComTencentTavcutBeanSize = a();
  }
  
  public int a()
  {
    return 2064318589;
  }
  
  protected AEEditorFilterControlPanel.FilterControlListener a()
  {
    return this;
  }
  
  protected FilterChangedComparator a()
  {
    return new AEEditorVideoEditFragment.12(this);
  }
  
  protected AEEditorStickerPart.AEEditorTextDialogListener a()
  {
    return new AEEditorVideoEditFragment.18(this);
  }
  
  protected LocalMediaInfo a(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    while (k < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(((AEAlbumMediaBaseModel)this.jdField_a_of_type_JavaUtilArrayList.get(k)).getOriginPath());
      k += 1;
    }
    String str = jdField_c_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createLocalMediaInfo... originPathList:");
    localStringBuilder.append(localArrayList);
    AEQLog.b(str, localStringBuilder.toString());
    return AELocalMediaInfoUtil.a(localArrayList, "", a().getHeight(), a().getWidth(), paramString1, paramString2, paramString3);
  }
  
  protected Size a()
  {
    if (ModelExtKt.isLightTemplate(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel()))
    {
      LightAsset localLightAsset = LightAsset.Load(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaTemplateModel().getLightMediaTemplateModel().getFilePath(), 100);
      this.jdField_b_of_type_ComTencentTavcutBeanSize = new Size(localLightAsset.width(), localLightAsset.height());
    }
    else
    {
      this.jdField_b_of_type_ComTencentTavcutBeanSize = a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
    }
    return this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsVideoParamStrategy.a(this.jdField_b_of_type_ComTencentTavcutBeanSize);
  }
  
  protected TAVCutSession a()
  {
    return this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
  }
  
  public StickerOperationCallback a()
  {
    return new AEEditorVideoEditFragment.11(this);
  }
  
  protected MediaResourceModel a(MediaResourceModel paramMediaResourceModel)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaBuilderOutput();
    if (localObject != null)
    {
      MediaResourceModel localMediaResourceModel = new MediaResourceModel();
      localObject = ((MediaBuilderOutput)localObject).getLightTemplate().getLightSegments().iterator();
      if (((Iterator)localObject).hasNext())
      {
        Iterator localIterator1 = ((MovieSegmentModel)((Iterator)localObject).next()).getVideoResourceModels().iterator();
        while (localIterator1.hasNext())
        {
          VideoResourceModel localVideoResourceModel = (VideoResourceModel)localIterator1.next();
          Iterator localIterator2 = paramMediaResourceModel.getVideos().iterator();
          while (localIterator2.hasNext())
          {
            MediaClipModel localMediaClipModel = (MediaClipModel)localIterator2.next();
            if ((localMediaClipModel.getResource().getPath() != null) && (localMediaClipModel.getResource().getPath().equals(localVideoResourceModel.getPath())))
            {
              localMediaClipModel = localMediaClipModel.deepCopy();
              localMediaClipModel.setResource(localVideoResourceModel);
              localMediaResourceModel.getVideos().add(localMediaClipModel);
            }
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
  
  public void a()
  {
    if (getArguments() != null)
    {
      getArguments().clear();
      getArguments().putSerializable("resource_model", this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel);
    }
  }
  
  public void a(float paramFloat)
  {
    boolean bool;
    if (paramFloat > 0.0F) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_c_of_type_Boolean = bool;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.a(this.jdField_a_of_type_Float);
    AEBaseReportParam.a().a().jdField_a_of_type_Int = a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
    ad();
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setEffectStrength(paramFloat);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), Float.valueOf(paramFloat));
    AEBaseReportParam.a().a().jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.a(paramInt1, paramInt2);
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt1);
    this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(paramInt2);
  }
  
  public void a(int paramInt, @Nullable MetaMaterial paramMetaMaterial)
  {
    a(paramInt);
  }
  
  public void a(int paramInt, AIFilterResult paramAIFilterResult)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.26(this, paramAIFilterResult));
    }
    Object localObject1;
    Object localObject2;
    if (paramInt == 0)
    {
      AEQLog.b(jdField_c_of_type_JavaLangString, "onAIFilterApplySuccess");
    }
    else
    {
      localObject1 = jdField_c_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onAIFilterAppliedFailed:");
      ((StringBuilder)localObject2).append(paramInt);
      AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
      ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.27(this));
    }
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.28(this));
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      if (paramAIFilterResult == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterAIFilterDataCache.a(this.jdField_e_of_type_JavaLangString, paramAIFilterResult);
      this.jdField_b_of_type_JavaUtilArrayList = a(paramAIFilterResult);
      localObject1 = (VideoAIFilterResult)paramAIFilterResult;
      if (localObject1 != null)
      {
        a((VideoAIFilterResult)localObject1);
        a(new String[] { "智能滤镜label", ((VideoAIFilterResult)localObject1).jdField_a_of_type_JavaLangString, "智能滤镜errCode", String.valueOf(paramInt) });
        localObject2 = NewEnhanceCategories.newEnhanceTypes.iterator();
        paramAIFilterResult = "none";
        while (((Iterator)localObject2).hasNext())
        {
          NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)((Iterator)localObject2).next();
          if (localNewEnhanceCategories.serverLabel.equals(((VideoAIFilterResult)localObject1).jdField_a_of_type_JavaLangString)) {
            paramAIFilterResult = localNewEnhanceCategories.filterType;
          }
        }
        localObject1 = AEBaseReportParam.a().a();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("effect_aieffect_");
        ((StringBuilder)localObject2).append(paramAIFilterResult);
        ((AEEditReportData)localObject1).jdField_d_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
        AEBaseReportParam.a().a().jdField_a_of_type_Float = -1.0F;
        this.jdField_h_of_type_JavaLangString = "effect_aieffect";
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
      String str = (String)paramPair.second;
      if (((Integer)paramPair.first).intValue() == 1)
      {
        if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.a(str)) {
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditWidgetsAEEditorCheckGroupView.a(2064122551);
        }
      }
      else {
        super.a(paramPair);
      }
    }
  }
  
  public void a(MetaMaterial paramMetaMaterial)
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null)
    {
      AEQLog.d(jdField_c_of_type_JavaLangString, "tavVideoSession is null.");
      return;
    }
    this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = paramMetaMaterial;
    this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel = this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel.deepCopy();
    Object localObject = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getMusicModel();
    boolean bool = false;
    if (paramMetaMaterial == null)
    {
      ((MusicModel)localObject).setVolume(0.5F);
      ((MusicModel)localObject).setBgmVolume(0.5F);
      ((MusicModel)localObject).setMetaDataBean(null);
      ((MusicModel)localObject).setUserMetaDataBean(null);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTemplate(2, "assets://camera/template", true, new String[] { "template.json" });
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaResourceModel().setVideos(this.jdField_a_of_type_JavaUtilList);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.setAutoTemplateMode(false, false);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.setHasTemplate(false);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    else
    {
      if (!ModelExtKt.isLightTemplate(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel()))
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaResourceModel().getVideos().iterator();
        while (localIterator.hasNext())
        {
          MediaClipModel localMediaClipModel = (MediaClipModel)localIterator.next();
          this.jdField_a_of_type_JavaUtilList.add(localMediaClipModel.deepCopy());
        }
      }
      ((MusicModel)localObject).setVolume(1.0F);
      ((MusicModel)localObject).setBgmVolume(1.0F);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTemplate(4, MetaMaterialKt.e(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial), true, new String[] { "template.json" });
      if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getMusicModel().getMetaDataBean() != null) {
        bool = true;
      }
      if (bool)
      {
        this.jdField_d_of_type_Boolean = true;
        this.jdField_b_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = AEEditorMusicAdapter.AEEditorMusicInfo.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
        this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = new MusicData();
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.setBgmPlayed(true, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(0.5F);
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setMainVolume(0.0F);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.setAutoTemplateMode(true, bool);
      this.jdField_a_of_type_JavaLangFloat = Float.valueOf(1.0F);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.a(paramMetaMaterial);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.setHasTemplate(true);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    localObject = AEQCircleReport.a();
    if (paramMetaMaterial == null) {
      paramMetaMaterial = "null_template";
    } else {
      paramMetaMaterial = paramMetaMaterial.id;
    }
    ((AEQCircleReport)localObject).a(paramMetaMaterial, QCircleConstants.KEY_VIDEO, "0");
  }
  
  protected void a(@NonNull VideoAIFilterResult paramVideoAIFilterResult)
  {
    TAVCutVideoSession localTAVCutVideoSession = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
    if (localTAVCutVideoSession == null)
    {
      AEQLog.d(jdField_c_of_type_JavaLangString, "tavVideoSession is null.");
      return;
    }
    localTAVCutVideoSession.resetAEKitModelForAI(paramVideoAIFilterResult.jdField_b_of_type_JavaLangString, 0.8F, paramVideoAIFilterResult.jdField_a_of_type_JavaUtilHashMap, 0, 0.0F);
    AEQCircleReport.a().a(QCircleConstants.KEY_AIVIDEOCONFIG, QCircleConstants.KEY_VIDEO, QCircleConstants.KEY_NETWORK, "0");
  }
  
  public void a(@Nullable AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, int paramInt)
  {
    if (paramAEEditorMusicInfo != null)
    {
      if (paramAEEditorMusicInfo.a()) {
        return;
      }
      this.jdField_d_of_type_Boolean = true;
      this.jdField_b_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = paramAEEditorMusicInfo;
      AEBaseReportParam.a().a().jdField_a_of_type_Int = a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
      AEBaseReportParam.a().a().jdField_e_of_type_JavaLangString = paramAEEditorMusicInfo.a();
      AEBaseReportParam.a().a().jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.jdField_b_of_type_Boolean;
      AEBaseReportParam.a().a().jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.jdField_d_of_type_Int;
      AEBaseReportParam.a().a().jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.b();
      AEBaseDataReporter.a().t();
      AEReportUtils.l(paramAEEditorMusicInfo.a());
      List localList = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.a();
      Iterator localIterator = localList.iterator();
      int k = 0;
      while (localIterator.hasNext())
      {
        AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)localIterator.next();
        if ((localAEEditorMusicInfo != null) && (!localAEEditorMusicInfo.a()) && (localAEEditorMusicInfo.jdField_c_of_type_Int != 1) && (localAEEditorMusicInfo.jdField_c_of_type_Int != 0)) {
          if (paramAEEditorMusicInfo.a().equals(localAEEditorMusicInfo.a()))
          {
            localAEEditorMusicInfo.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = localAEEditorMusicInfo;
            paramAEEditorMusicInfo = localAEEditorMusicInfo;
            k = 1;
          }
          else
          {
            localAEEditorMusicInfo.jdField_a_of_type_Boolean = false;
          }
        }
      }
      int m = paramInt;
      if (k == 0)
      {
        paramAEEditorMusicInfo.jdField_a_of_type_Boolean = true;
        k = localList.size() - 1;
        if (paramInt > k)
        {
          m = k + 1;
          localList.add(paramAEEditorMusicInfo);
        }
        else
        {
          localList.add(paramInt, paramAEEditorMusicInfo);
          m = paramInt;
        }
      }
      a(paramAEEditorMusicInfo.a(), paramAEEditorMusicInfo.a(), false);
      if (paramAEEditorMusicInfo.jdField_c_of_type_Int == 3)
      {
        if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.restoreTemplateMusic(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float))
        {
          this.jdField_b_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = AEEditorMusicAdapter.AEEditorMusicInfo.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
          this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = new MusicData();
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.setBgmPlayed(true, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
        }
      }
      else {
        a(paramAEEditorMusicInfo);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.a(localList);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.a(m);
    }
  }
  
  public void a(@NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, boolean paramBoolean, @NonNull String paramString)
  {
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.24(this, paramAEEditorMusicInfo, paramBoolean, paramString));
  }
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    if ((paramBoolean) && (paramStSmartMatchMusicRsp != null) && (!CollectionUtils.isEmpty(paramStSmartMatchMusicRsp.vecMusic.get())))
    {
      if ((paramStSmartMatchMusicRsp.extInfo != null) && (paramStSmartMatchMusicRsp.extInfo.mapInfo.size() != 0))
      {
        paramBaseRequest = paramStSmartMatchMusicRsp.extInfo.mapInfo.get().iterator();
        while (paramBaseRequest.hasNext())
        {
          paramString = (COMM.Entry)paramBaseRequest.next();
          if ((paramString != null) && (paramString.key.get().equals("CommonInfo"))) {
            AEBaseReportParam.a().a().jdField_f_of_type_JavaLangString = paramString.value.get();
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel != null)
      {
        paramBaseRequest = AEEditorMusicHelper.a(paramStSmartMatchMusicRsp.vecMusic.get());
        paramString = AEEditorMusicHelper.b(paramBaseRequest);
        List localList = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.a();
        paramStSmartMatchMusicRsp = new LinkedList();
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
        AEBaseReportParam.a().a().jdField_g_of_type_JavaLangString = paramBaseRequest;
        int n = 0;
        int k = 0;
        int m;
        for (;;)
        {
          m = n;
          if (k >= localList.size()) {
            break;
          }
          paramBaseRequest = (AEEditorMusicAdapter.AEEditorMusicInfo)localList.get(k);
          if ((paramBaseRequest != null) && (!paramBaseRequest.a()) && (paramBaseRequest.jdField_c_of_type_Int != 0))
          {
            paramStSmartMatchMusicRsp.add(paramBaseRequest);
            localHashMap.put(paramBaseRequest.a(), paramBaseRequest);
          }
          k += 1;
        }
        while (m < paramString.size())
        {
          paramBaseRequest = (AEEditorMusicAdapter.AEEditorMusicInfo)paramString.get(m);
          if ((paramBaseRequest != null) && (!paramBaseRequest.a()) && (localHashMap.get(paramBaseRequest.a()) == null)) {
            paramStSmartMatchMusicRsp.add(paramBaseRequest);
          }
          m += 1;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.a(paramStSmartMatchMusicRsp);
      }
      return;
    }
    AEQLog.d(jdField_c_of_type_JavaLangString, "[VSDispatchObserver.onVSRspCallBack.onReceive], music - request music list failed");
  }
  
  protected void a(@NonNull MusicData paramMusicData, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    TAVCutVideoSession localTAVCutVideoSession = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
    if (localTAVCutVideoSession != null)
    {
      a(localTAVCutVideoSession.saveLyricSticker());
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmMusic(paramMusicData, paramFloat1, paramFloat2, paramBoolean);
    }
    paramMusicData = this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
    if ((paramMusicData != null) && (paramBoolean))
    {
      paramMusicData.seekToTime(CMTime.fromMs(0L));
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
    }
  }
  
  protected void a(SubtitleModel paramSubtitleModel)
  {
    SubtitleModel localSubtitleModel = this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel;
    if ((localSubtitleModel != null) && (paramSubtitleModel != null))
    {
      localSubtitleModel.setAssetFilePath(paramSubtitleModel.getAssetFilePath());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setCenterX(paramSubtitleModel.getCenterX());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setCenterY(paramSubtitleModel.getCenterY());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setRotate(paramSubtitleModel.getRotate());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setScale(paramSubtitleModel.getScale());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setMaxScale(paramSubtitleModel.getMaxScale());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setMinScale(paramSubtitleModel.getMinScale());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLoopStart(paramSubtitleModel.getLoopStart());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLoopEnd(paramSubtitleModel.getLoopEnd());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLoopType(paramSubtitleModel.getLoopType());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyric(paramSubtitleModel.getLyric());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setLyricFormatIsQRC(paramSubtitleModel.getLyricFormatIsQRC());
      this.jdField_a_of_type_ComTencentWeseevideoModelEffectSubtitleModel.setMusicStartTime(paramSubtitleModel.getMusicStartTime());
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a(paramString);
    }
  }
  
  protected void a(@NonNull String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AEEditorMusicHelper.a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession, this);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    LocalMediaInfo localLocalMediaInfo = AELocalMediaInfoUtil.a(a(paramString1, paramString2, paramString3), getArguments().getString("material_id"), getArguments().getString("material_topic"), getArguments().getString("key_camera_material_name"), getArguments().getInt("ae_editor_is_show_take_same"), this.jdField_h_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
    if (localObject != null)
    {
      a(localLocalMediaInfo, ((TAVCutVideoSession)localObject).getMediaModel().getMediaEffectModel().getStickerModelList());
      localObject = e();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!localLocalMediaInfo.mHashTagList.contains(localObject))) {
        localLocalMediaInfo.mHashTagList.add(localObject);
      }
    }
    AEEditorProcessManager localAEEditorProcessManager = AEEditorProcessManager.a();
    String str1 = localLocalMediaInfo.materialID;
    String str2 = localLocalMediaInfo.materialName;
    String str3 = localLocalMediaInfo.filterID;
    String str4 = localLocalMediaInfo.scheme;
    int k = localLocalMediaInfo.showCircleTakeSame;
    String str5 = this.jdField_e_of_type_JavaLangString;
    localObject = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
    if (localObject == null) {
      localObject = new MediaModel();
    } else {
      localObject = ((TAVCutVideoSession)localObject).getMediaModel();
    }
    localAEEditorProcessManager.a(str1, str2, str3, str4, k, paramString3, str5, paramString1, paramString2, (MediaModel)localObject, localLocalMediaInfo.mKuolieId, localLocalMediaInfo.mKuolieCenterX, localLocalMediaInfo.mKuolieCenterY, localLocalMediaInfo.mKuolieWidthScale, localLocalMediaInfo.mKuolieHeightScale, localLocalMediaInfo.mKuolieRotate);
    if (getActivity() == null)
    {
      AEQLog.d(jdField_c_of_type_JavaLangString, "activity is null.");
      return;
    }
    a(paramString1, paramString2, localLocalMediaInfo);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial == null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2064122562: 
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel, 8);
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel, 8);
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel, 0);
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel, 8);
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel, 8);
      localAEEditorMusicControlPanel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel;
      if (localAEEditorMusicControlPanel != null) {
        localAEEditorMusicControlPanel.b();
      }
      if (!paramBoolean) {
        n();
      }
      AEReportUtils.d(false);
      a(2064122257, "SP_KEY_RED_POINT_TIME_STAMP", true);
      return;
    case 2064122558: 
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel, 8);
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel, 8);
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel, 8);
      l();
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel, 8);
      n();
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel, 0);
      AEReportUtils.l();
      return;
    case 2064122555: 
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel, 8);
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel, 0);
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel, 8);
      l();
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel, 8);
      n();
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel, 8);
      localAEEditorMusicControlPanel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel;
      if (localAEEditorMusicControlPanel != null) {
        localAEEditorMusicControlPanel.b();
      }
      AEReportUtils.c(false);
      a(2064122255, "SP_KEY_RED_POINT_TIME_STAMP", true);
      return;
    case 2064122551: 
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel, 0);
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel, 8);
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel, 8);
      l();
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel, 8);
      n();
      ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel, 8);
      localAEEditorMusicControlPanel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel;
      if (localAEEditorMusicControlPanel != null) {
        localAEEditorMusicControlPanel.b();
      }
      AEReportUtils.i();
      a(2064122808, "SP_KEY_RED_POINT_TIME_STAMP", true);
      return;
    }
    ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel, 8);
    ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel, 8);
    ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel, 8);
    ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel, 0);
    ViewUtils.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel, 8);
    AEEditorMusicControlPanel localAEEditorMusicControlPanel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel;
    if (localAEEditorMusicControlPanel != null) {
      localAEEditorMusicControlPanel.b();
    }
    if (!paramBoolean) {
      l();
    }
    a(2064122259, "SP_KEY_RED_POINT_TIME_STAMP", true);
  }
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      int k;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null) && (FlowCameraConstant.jdField_a_of_type_Int != 2)) {
        k = 1;
      } else {
        k = 0;
      }
      AEEditorMusicHelper.a(paramArrayList, WatermarkDataManager.a().a(), paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, k, this);
      return;
    }
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.22(this));
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    MoviePlayer localMoviePlayer;
    if (paramBoolean1)
    {
      if (this.i)
      {
        localMoviePlayer = this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
        if ((localMoviePlayer != null) && (!localMoviePlayer.isPlaying()))
        {
          if (paramBoolean2) {
            this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.seekToTime(CMTime.fromMs(0L));
          }
          this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
        }
      }
    }
    else
    {
      localMoviePlayer = this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
      if ((localMoviePlayer != null) && (localMoviePlayer.isPlaying()))
      {
        this.i = true;
        this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
        return;
      }
      this.i = false;
    }
  }
  
  public boolean a()
  {
    AEBaseDataReporter.a().x();
    if (this.jdField_b_of_type_JavaLangString.equals(f()))
    {
      getArguments().putSerializable("resource_model", this.jdField_a_of_type_ComTencentWeseevideoModelResourceMediaResourceModel);
      v();
      return false;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.applyCurrentSticker();
    Object localObject = getActivity();
    localObject = DialogUtil.a((Context)localObject, 230).setTitle(HardCodeUtil.a(2064515180)).setMessage(((Context)localObject).getString(2064515182)).setPositiveButton(((Context)localObject).getString(2064515181), new AEEditorVideoEditFragment.31(this)).setNegativeButton(((Context)localObject).getString(2064515117), new AEEditorVideoEditFragment.30(this));
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
  
  public boolean a(int paramInt, MetaMaterial paramMetaMaterial)
  {
    AEBaseReportParam.a().a().jdField_d_of_type_JavaLangString = paramMetaMaterial.id;
    AEBaseReportParam.a().a().jdField_a_of_type_Float = -1.0F;
    return true;
  }
  
  protected int b()
  {
    return -1;
  }
  
  public String b()
  {
    return HardCodeUtil.a(2064515154);
  }
  
  public void b(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.b(this.jdField_b_of_type_Float);
    ad();
  }
  
  public void b(int paramInt)
  {
    MoviePlayer localMoviePlayer = this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
    if (localMoviePlayer != null)
    {
      localMoviePlayer.seekToTime(new CMTime(paramInt, 1000));
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
    }
  }
  
  public void b(int paramInt, MetaMaterial paramMetaMaterial)
  {
    s();
    a(paramInt);
    Object localObject = AEEditorResourceManager.a().b(paramMetaMaterial);
    float f2 = FilterMetaMaterialKt.a(paramMetaMaterial);
    float f1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      f1 = ((Float)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).floatValue();
    } else {
      f1 = f2;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(f1);
    float f3 = FilterMetaMaterialKt.b(paramMetaMaterial);
    Map localMap = FilterMetaMaterialKt.a(paramMetaMaterial);
    String str = AEEditorResourceManager.a().d(paramMetaMaterial);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.resetAEKitModel(f1, (String)localObject, f3, localMap, str);
    AEBaseReportParam.a().a().jdField_d_of_type_JavaLangString = paramMetaMaterial.id;
    AEBaseReportParam.a().a().jdField_a_of_type_Float = f2;
    this.jdField_h_of_type_JavaLangString = paramMetaMaterial.id;
    localObject = AEQCircleReport.a();
    if (paramMetaMaterial == null) {
      paramMetaMaterial = "";
    } else {
      paramMetaMaterial = paramMetaMaterial.id;
    }
    ((AEQCircleReport)localObject).a(paramMetaMaterial, QCircleConstants.KEY_PIC, "0");
  }
  
  public void b(MetaMaterial paramMetaMaterial)
  {
    if (paramMetaMaterial != null) {
      a(paramMetaMaterial);
    }
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
  
  public boolean b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAifilterAIFilterDataCache.a(this.jdField_e_of_type_JavaLangString);
    boolean bool;
    if ((localObject instanceof VideoAIFilterResult))
    {
      AEQLog.b(jdField_c_of_type_JavaLangString, "onAIFilterRequest: has cache");
      bool = ((VideoAIFilterResult)localObject).jdField_a_of_type_Boolean;
    }
    else
    {
      bool = true;
    }
    if (bool)
    {
      q();
      localObject = new MultiVideoAIFilterProxy(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
      ((VideoAIFilterProxy)localObject).a(this);
      AEEditorAIFilterManager.a().a(getActivity(), (AIFilterProxyBase)localObject);
    }
    else
    {
      a(AEEditorFilterControlPanel.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.setSelectedIndex(AEEditorFilterControlPanel.jdField_a_of_type_Int, true);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.resetAEKitModelForAI(((AIFilterResult)localObject).b(), 0.8F, ((AIFilterResult)localObject).a(), 0, 0.0F);
      a(new String[] { "智能滤镜label", ((AIFilterResult)localObject).a(), "智能滤镜errCode", "0" });
      AEQCircleReport.a().a(QCircleConstants.KEY_AIVIDEOCONFIG, QCircleConstants.KEY_PIC, QCircleConstants.KEY_CACHE, "0");
    }
    return !bool;
  }
  
  protected void c()
  {
    this.jdField_e_of_type_JavaLangString = g();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo == null) {
      return;
    }
    AEEditorLyricProgressCalculator localAEEditorLyricProgressCalculator = AEEditorLyricProgressCalculator.a();
    long l = paramInt;
    localAEEditorLyricProgressCalculator.b(l, Math.min(this.jdField_a_of_type_Long + l, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.b()));
    a(AEEditorMusicHelper.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo), paramInt, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.b(), this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_Boolean ^ true);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.b(paramInt);
    int k = (int)(l + this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.a(paramInt, k);
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(k);
    if (this.j)
    {
      ac();
      d(this.jdField_a_of_type_JavaLangInteger.intValue());
    }
  }
  
  public void c(boolean paramBoolean)
  {
    a(paramBoolean);
  }
  
  protected String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("multi_video_");
    localStringBuilder.append(System.currentTimeMillis());
    return localStringBuilder.toString();
  }
  
  protected void d()
  {
    AEEditorAIFilterManager.a().a();
  }
  
  protected void d(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  protected String e()
  {
    if ((TextUtils.isEmpty("")) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel != null))
    {
      localObject1 = this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
      if (localObject1 != null)
      {
        localObject2 = MetaMaterialKt.b((MetaMaterial)localObject1);
        break label35;
      }
    }
    Object localObject2 = "";
    label35:
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel != null) {
        localObject1 = a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList(), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel.a());
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextControlPanel != null) {
        localObject2 = a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList(), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextViewModel.a());
      }
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel != null) {
        localObject1 = a(this.jdField_h_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleFilterAEEditorFilterControlPanel.a());
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
  
  protected void e() {}
  
  public void e(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    AEBaseReportParam.a().a().jdField_a_of_type_Int = a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
    List localList = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.a();
    if (CollectionUtils.isEmpty(localList)) {
      return;
    }
    int i1;
    if (paramBoolean)
    {
      localObject1 = this.jdField_b_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
      if ((localObject1 != null) && (!((AEEditorMusicAdapter.AEEditorMusicInfo)localObject1).a()))
      {
        localObject1 = null;
        int k = 0;
        int n = 0;
        for (int m = 0;; m = i2)
        {
          localObject2 = localObject1;
          i2 = n;
          i1 = m;
          if (k >= localList.size()) {
            break;
          }
          AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo = (AEEditorMusicAdapter.AEEditorMusicInfo)localList.get(k);
          localObject2 = localObject1;
          i1 = n;
          i2 = m;
          if (localAEEditorMusicInfo != null)
          {
            localObject2 = localObject1;
            i1 = n;
            i2 = m;
            if (!localAEEditorMusicInfo.a())
            {
              localObject2 = localObject1;
              i1 = n;
              i2 = m;
              if (localAEEditorMusicInfo.jdField_c_of_type_Int != 1) {
                if (localAEEditorMusicInfo.jdField_c_of_type_Int == 0)
                {
                  localObject2 = localObject1;
                  i1 = n;
                  i2 = m;
                }
                else if (this.jdField_b_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a().equals(localAEEditorMusicInfo.a()))
                {
                  localAEEditorMusicInfo.jdField_a_of_type_Boolean = true;
                  i2 = k;
                  localObject2 = localAEEditorMusicInfo;
                  i1 = 1;
                }
                else
                {
                  localAEEditorMusicInfo.jdField_a_of_type_Boolean = false;
                  i2 = m;
                  i1 = n;
                  localObject2 = localObject1;
                }
              }
            }
          }
          k += 1;
          localObject1 = localObject2;
          n = i1;
        }
      }
      Object localObject2 = null;
      int i2 = 0;
      i1 = 0;
      if (i2 != 0)
      {
        this.jdField_b_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = localObject2;
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = localObject2;
      }
      else
      {
        this.jdField_b_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = null;
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = ((AEEditorMusicAdapter.AEEditorMusicInfo)localList.get(1));
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.jdField_a_of_type_Boolean = true;
      AEBaseReportParam.a().a().jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a();
      AEBaseReportParam.a().a().jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.jdField_b_of_type_Boolean;
      AEBaseReportParam.a().a().jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.jdField_d_of_type_Int;
      AEBaseReportParam.a().a().jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.b();
      AEBaseDataReporter.a().t();
    }
    else
    {
      this.jdField_b_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = null;
      localObject1 = localList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((AEEditorMusicAdapter.AEEditorMusicInfo)((Iterator)localObject1).next()).jdField_a_of_type_Boolean = false;
      }
      AEBaseReportParam.a().a().jdField_e_of_type_JavaLangString = "none";
      AEBaseReportParam.a().a().jdField_a_of_type_Boolean = false;
      AEBaseReportParam.a().a().jdField_b_of_type_Int = -1;
      AEBaseReportParam.a().a().jdField_c_of_type_Int = -1;
      i1 = 0;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
    if (localObject1 != null) {
      a(((AEEditorMusicAdapter.AEEditorMusicInfo)localObject1).a(), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a(), false);
    }
    a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.a(localList);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.a(i1);
    }
  }
  
  protected String f()
  {
    TAVCutVideoSession localTAVCutVideoSession = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
    if ((localTAVCutVideoSession != null) && (localTAVCutVideoSession.getMediaModel() != null) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString() != null)) {
      return Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString());
    }
    return "";
  }
  
  protected void f()
  {
    k();
    X();
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.a(paramBoolean);
  }
  
  public boolean f()
  {
    List localList = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList();
    int k = 0;
    while (k < localList.size())
    {
      if ((((StickerModel)localList.get(k)).getInteractive() > 0) && (((StickerModel)localList.get(k)).getMaterialId().startsWith("qiukuolie"))) {
        return true;
      }
      k += 1;
    }
    return false;
  }
  
  protected String g()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  protected void g()
  {
    m();
  }
  
  public void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
      if (localAEEditorMusicInfo != null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel.a(localAEEditorMusicInfo, Integer.valueOf(a(localAEEditorMusicInfo.a())), (int)this.jdField_a_of_type_Long, this.jdField_f_of_type_Boolean);
        this.jdField_f_of_type_Boolean = false;
        return;
      }
    }
    QQToast.a(getActivity(), 2064515176, 0).a();
  }
  
  protected void h()
  {
    TAVCutVideoSession localTAVCutVideoSession = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
    if (localTAVCutVideoSession != null) {
      localTAVCutVideoSession.applyCurrentSticker();
    }
  }
  
  public void h(boolean paramBoolean)
  {
    this.j = paramBoolean;
    if (paramBoolean)
    {
      AEEditorMusicAdapter.AEEditorMusicInfo localAEEditorMusicInfo = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
      if (localAEEditorMusicInfo != null) {
        if (!a(localAEEditorMusicInfo.d())) {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        } else {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        }
      }
      ab();
      return;
    }
    ac();
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void i()
  {
    ThreadManager.getUIHandler().post(new AEEditorVideoEditFragment.19(this));
    Object localObject1 = AEEditorPath.EDITOR.FILES.jdField_e_of_type_JavaLangString;
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new File(this.jdField_e_of_type_JavaLangString);
    String str = d();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(File.separator);
    ((StringBuilder)localObject3).append("output_");
    ((StringBuilder)localObject3).append(str);
    ((StringBuilder)localObject3).append("_");
    ((StringBuilder)localObject3).append(VideoFilterTools.a(((File)localObject2).getName()));
    ((StringBuilder)localObject3).append(".jpg");
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append(File.separator);
    ((StringBuilder)localObject4).append("output_");
    ((StringBuilder)localObject4).append(str);
    ((StringBuilder)localObject4).append("_");
    ((StringBuilder)localObject4).append(VideoFilterTools.a(((File)localObject2).getName()));
    ((StringBuilder)localObject4).append(".mp4");
    localObject4 = ((StringBuilder)localObject4).toString();
    aa();
    localObject1 = null;
    if (getActivity().getIntent() != null) {
      localObject1 = (HashMap)getActivity().getIntent().getSerializableExtra("PeakConstants.selectedMediaInfoHashMap.recovery");
    }
    AEEditorVideoRecord localAEEditorVideoRecord = AEEditorVideoRecord.a();
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    localObject2 = this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
    if (localObject2 == null) {
      localObject2 = "";
    } else {
      localObject2 = ((MetaMaterial)localObject2).id;
    }
    localAEEditorVideoRecord.a(localArrayList, (HashMap)localObject1, (String)localObject2, this.jdField_h_of_type_JavaLangString, 2);
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      localObject1 = new TAVCutVideoSession();
      a(BaseApplicationImpl.getContext(), (TAVCutVideoSession)localObject1, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsVideoParamStrategy, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel(), null, null);
      ((TAVCutVideoSession)localObject1).applyCurrentSticker();
      long l = 1000L;
      if (((TAVCutVideoSession)localObject1).getDuration().getValue() > 2000L) {
        l = 2000L;
      }
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).P_EXPORT_START(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT1(), "cover"), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT2(), this.jdField_e_of_type_JavaLangString), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT3(), (String)localObject3), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).KEY_RET_CODE(), "0") }));
      ((TAVCutVideoSession)localObject1).getEffectVideoFrame(l, 1080, new AEEditorVideoEditFragment.20(this, (TAVCutVideoSession)localObject1, (String)localObject3, (String)localObject4, str));
      return;
    }
    a((String)localObject4, (String)localObject3, str);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).P_EXPORT_END(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT1(), "noCover"), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT2(), this.jdField_e_of_type_JavaLangString), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT3(), (String)localObject3), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).KEY_RET_CODE(), "0") }));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AEQLog.b(jdField_c_of_type_JavaLangString, "onCreate");
    super.onCreate(paramBundle);
    AEEditorMusicHelper.a(getActivity());
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      this.jdField_d_of_type_Int = getActivity().getIntent().getIntExtra("editorFrom", -1);
      paramBundle = (HashMap)getActivity().getIntent().getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        paramBundle = paramBundle.entrySet().iterator();
        while (paramBundle.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramBundle.next();
          if (localEntry.getValue() != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)localEntry.getValue());
          }
        }
      }
    }
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    paramBundle = AEBaseReportParam.a().a();
    int k;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null) {
      k = 0;
    } else {
      k = 1;
    }
    paramBundle.jdField_e_of_type_Int = k;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEVideoEditViewModel = ((AEVideoEditViewModel)AEViewModelProviders.a(getActivity()).get(AEVideoEditViewModel.class));
    ae();
  }
  
  public void onDeleteSticker()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
    if (localObject != null) {
      a(((TAVCutVideoSession)localObject).saveLyricSticker());
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel;
    if (localObject != null) {
      ((AEEditorMusicControlPanel)localObject).f();
    }
  }
  
  public void onDestroyView()
  {
    AEQLog.b(jdField_c_of_type_JavaLangString, "onDestroyView");
    super.onDestroyView();
    if (getArguments() != null) {
      getArguments().clear();
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleControlpanelAEEditorMusicControlPanel;
    if (localObject != null) {
      ((AEEditorMusicControlPanel)localObject).c();
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    localObject = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
    if (localObject != null) {
      ((TAVCutVideoSession)localObject).release();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 0.8F;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = null;
    this.jdField_b_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = null;
    this.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = null;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo = null;
    this.jdField_f_of_type_Boolean = false;
    T();
  }
  
  public void onDetach()
  {
    super.onDetach();
    AEEditorVideoRecord.a().b();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (!paramBoolean)
    {
      AEBaseDataReporter.a().y();
      a(true, true);
      this.jdField_f_of_type_Boolean = true;
      if ((h()) && (getArguments() != null))
      {
        try
        {
          if ((MediaResourceModel)getArguments().getSerializable("resource_model") != null) {
            this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel = ((MediaResourceModel)getArguments().getSerializable("resource_model")).deepCopy();
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        try
        {
          this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().setMediaResourceModel(this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel);
          this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.correctMediaResource(jdField_c_of_type_Int);
          this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.updateTemplateComposition(true);
          this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.restoreStickersWithLyric(new ArrayList(a()));
          this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setMainVolume(this.jdField_a_of_type_Float);
          this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setBgmVolume(this.jdField_b_of_type_Float);
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        this.jdField_a_of_type_Long = (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeSeconds() * 1000L);
      }
      else if ((i()) && (getArguments() != null) && (QzoneConfig.isOpenFunctionSavePicToVideo()) && (getArguments().getBoolean("key_is_need_update_source_path", false)))
      {
        ae();
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().setMediaResourceModel(this.jdField_b_of_type_ComTencentWeseevideoModelResourceMediaResourceModel);
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setStickerLyricCallback(this);
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setStickerOperationCallback(a());
        FragmentActivity localFragmentActivity = getActivity();
        TAVCutVideoSession localTAVCutVideoSession = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
        a(localFragmentActivity, localTAVCutVideoSession, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsVideoParamStrategy, localTAVCutVideoSession.getMediaModel());
        af();
      }
      AEReportUtils.t();
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.a(3);
      return;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setStickerOperationCallback(null);
    d(false);
  }
  
  public void onPause()
  {
    super.onPause();
    AEQLog.b(jdField_c_of_type_JavaLangString, "onPause");
    if (!this.jdField_g_of_type_Boolean) {
      d(false);
    }
  }
  
  public void onResume()
  {
    AEQLog.b(jdField_c_of_type_JavaLangString, "onResume");
    super.onResume();
    if (!this.jdField_g_of_type_Boolean)
    {
      AEBaseDataReporter.a().y();
      d(true);
      VsMusicItemInfo localVsMusicItemInfo = this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo;
      if (localVsMusicItemInfo != null) {
        a(localVsMusicItemInfo);
      }
      AEReportUtils.t();
    }
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle = a().a();
    if ((paramBundle != null) && (paramBundle == this))
    {
      paramBundle = null;
      if (getActivity().getIntent() != null) {
        paramBundle = (HashMap)getActivity().getIntent().getSerializableExtra("PeakConstants.selectedMediaInfoHashMap.recovery");
      }
      AEEditorVideoRecord localAEEditorVideoRecord = AEEditorVideoRecord.a();
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      Object localObject = this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = ((MetaMaterial)localObject).id;
      }
      localAEEditorVideoRecord.a(localArrayList, paramBundle, (String)localObject, this.jdField_h_of_type_JavaLangString, 1);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AEQLog.b(jdField_c_of_type_JavaLangString, "onViewCreated");
    b(paramView);
    super.onViewCreated(paramView, paramBundle);
    R();
    j();
    S();
    AEBaseReportParam.a().a().jdField_e_of_type_JavaLangString = "none";
    AEBaseReportParam.a().a().jdField_a_of_type_Boolean = false;
    AEBaseReportParam.a().a().jdField_b_of_type_Int = -1;
    AEBaseReportParam.a().a().jdField_c_of_type_Int = -1;
    AEBaseReportParam.a().a().jdField_a_of_type_Int = a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
    AEBaseReportParam.a().a().jdField_f_of_type_JavaLangString = "none";
    AEBaseReportParam.a().a().jdField_g_of_type_JavaLangString = "none";
    paramBundle = VideoUtil.getVideoSize(this.jdField_e_of_type_JavaLangString);
    a(this.jdField_e_of_type_JavaLangString, paramBundle.getWidth(), paramBundle.getHeight(), this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L);
    a(new String[] { "设备级别", ParamsUtil.a(), "视频最大预览尺寸", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsVideoParamStrategy.a()), "视频原始尺寸", String.format("width=%d, height=%d", new Object[] { Integer.valueOf(this.jdField_b_of_type_ComTencentTavcutBeanSize.getWidth()), Integer.valueOf(this.jdField_b_of_type_ComTencentTavcutBeanSize.getHeight()) }), "视频导出尺寸", String.format("width=%d, height=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutBeanSize.getWidth()), Integer.valueOf(this.jdField_a_of_type_ComTencentTavcutBeanSize.getHeight()) }), "视频导出码率", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsVideoParamStrategy.b()), "视频导出帧率", String.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleParamsVideoParamStrategy.c()) });
    if (AEEditorResourceManager.a().b()) {
      F();
    }
    Y();
    a(paramView.findViewById(2064122551));
    AEEditorVideoRecord.a().a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession, getArguments());
    AEEditorVideoRecord.a().a(this);
  }
  
  public void s_()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorLoadingView.a();
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, "资源下载中，请稍后再试", 0).a();
  }
  
  public void t()
  {
    super.t();
    AEReportUtils.n();
  }
  
  public void v()
  {
    AEEditorVideoRecord.a().a();
  }
  
  public void x()
  {
    MoviePlayer localMoviePlayer = this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
    if (localMoviePlayer != null)
    {
      localMoviePlayer.release();
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = null;
    }
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = new MoviePlayer();
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setLoopPlay(true);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setBackColor(getResources().getColor(2063925253));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.addPlayerListener(new AEEditorVideoEditFragment.10(this));
  }
  
  public void y()
  {
    getActivity().getIntent().putExtra("startTimeEdit", this.jdField_b_of_type_Long * 1000L);
    getActivity().getIntent().putExtra("endTimeEdit", (this.jdField_b_of_type_Long + this.jdField_a_of_type_Long) * 1000L);
    Intent localIntent = getActivity().getIntent();
    Float localFloat = this.jdField_a_of_type_JavaLangFloat;
    float f1;
    if (localFloat != null) {
      f1 = localFloat.floatValue();
    } else {
      f1 = 1.0F;
    }
    localIntent.putExtra("endSpeedEdit", f1);
    AEBaseDataReporter.a().a(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() / 1000L);
    W();
  }
  
  public void z()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEEditorAutoTemplatePanel.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment
 * JD-Core Version:    0.7.0.1
 */