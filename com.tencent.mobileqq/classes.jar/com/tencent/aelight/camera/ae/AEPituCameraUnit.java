package com.tencent.aelight.camera.ae;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.MainThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager.MaterialInnerEffectListener;
import com.tencent.aelight.camera.ae.biz.circle.AECircleMultiUnit;
import com.tencent.aelight.camera.ae.camera.AECaptureParam;
import com.tencent.aelight.camera.ae.camera.core.AECameraBroadcastReceiver;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEEffectListener;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEGLSurfaceListener;
import com.tencent.aelight.camera.ae.camera.core.AECameraManager;
import com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraManagerListener;
import com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraOpenCallback;
import com.tencent.aelight.camera.ae.camera.core.AEFilterManagerHolder;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.FilterPagerViewStubHolder;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil.ABTestInfo;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil.BinaryInfo;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.IDebugInfoCallback;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel.AEARCakePanelListener;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyConfigModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderView;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautySecondaryConfigModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBottomPanelViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AECosmeticsTypeViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AECosmeticsViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEFilterProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel.AEMaterialPanelListener;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModelFactory;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkPanel.AEWaterMarkPanelListener;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautyAndFilterPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEBeautyPanelConfigHolder;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEBeautyPanelConfigUtil;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYBeautyAndFilterPanelViewStubHolder;
import com.tencent.aelight.camera.ae.camera.ui.tips.AETipsViewController;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.config.CameraOperationHelper;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEGiftMaterialConfigParser;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.download.AEDownloadMaterialRunnable;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.font.AEFontManager;
import com.tencent.aelight.camera.ae.gesture.CameraProviderViewGesture;
import com.tencent.aelight.camera.ae.gesture.CameraTriggerGesture;
import com.tencent.aelight.camera.ae.gif.AEStoryGIFPreviewActivity;
import com.tencent.aelight.camera.ae.gif.AEVideoStoryGIFTplViewModel;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.perf.AELaunchRecorder;
import com.tencent.aelight.camera.ae.qipc.AECameraGetInfoClient;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.report.AEBeautyReportParam;
import com.tencent.aelight.camera.ae.report_datong.AECameraDaTongHelper;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.AECaptureAudioUtil;
import com.tencent.aelight.camera.ae.util.AEPreviewSizeUtil;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;
import com.tencent.aelight.camera.ae.util.DovSVParamManager;
import com.tencent.aelight.camera.ae.util.MediaCodecDPC;
import com.tencent.aelight.camera.ae.util.PicChooseJumpUtil;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.ae.view.AEPituCameraCaptureButtonLayout;
import com.tencent.aelight.camera.ae.view.AEPituCameraCaptureButtonLayout.PituCaptureButtonListener;
import com.tencent.aelight.camera.aebase.AECaptureContext;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aebase.ShortVideoProcessUtil;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.aeeditor.module.params.ParamsUtil;
import com.tencent.aelight.camera.aioeditor.CaptureReportUtil;
import com.tencent.aelight.camera.aioeditor.QIMCaptureVarManager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.OnResourceDownloadListener;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.view.GLVideoClipUtil;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncControl;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.aelight.camera.aioeditor.capture.view.PressScaleAnimDelegate;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.utils.MediaUtil;
import com.tencent.aelight.camera.aioeditor.setting.CaptureEntranceParams;
import com.tencent.aelight.camera.aioeditor.setting.CapturePicParams;
import com.tencent.aelight.camera.aioeditor.setting.CapturePicParams.CapturePicParamsBuilder;
import com.tencent.aelight.camera.aioeditor.setting.ICameraEntrance;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishFileManager;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishVideoSegment;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.qqstory.api.IAsyncControl;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.aelight.camera.third.ReporterForLightSdk;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.editor.params.EditLocalPhotoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.filter.QQFilterRenderManagerHolder;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJDeliverUGCUtils;
import com.tencent.mobileqq.musicpendant.Base64;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraFocusGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraFocusGesture.FocusGestureListener;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraSwitchGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraSwitchGesture.CameraSwitchGestureListener;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraViewPagerGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraZoomGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraZoomGesture.ZoomGestureListener;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker.DarkModeListener;
import com.tencent.mobileqq.richmedia.capture.util.ReportUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.facedetect.GenderType;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.CosFunHelper;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import dov.com.qq.im.ae.current.SessionWrap;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.light.bean.WMElement;
import org.light.listener.IOnClickWatermarkListener;
import org.light.report.LightReportManager;

@TargetApi(9)
public class AEPituCameraUnit
  extends AEBaseCameraUnit
  implements View.OnClickListener, View.OnTouchListener, AEFilterManager.MaterialInnerEffectListener, AECameraGLSurfaceView.AEEffectListener, AEVideoStoryDashboardPart.IDebugInfoCallback, AEPituCameraCaptureButtonLayout.PituCaptureButtonListener, VideoFilterTools.OnResourceDownloadListener, MediaScanner.OnMediaInfoScannerListener, DarkModeChecker.DarkModeListener
{
  private static boolean E = true;
  public static boolean ad = false;
  public static boolean am = false;
  private int F;
  private int G;
  private Bitmap H = null;
  protected AEFilterManager I;
  protected final AECameraManager.CameraManagerListener J = new AEPituCameraUnit.1(this);
  protected CameraZoomGesture K;
  protected CameraFocusGesture L;
  protected CameraSwitchGesture M;
  protected CameraProviderViewGesture N;
  protected CameraTriggerGesture O;
  protected CameraViewPagerGesture P;
  protected GestureDetector Q;
  protected AECaptureController R;
  protected VideoStoryCapturePartManager S;
  protected AEMaterialPanel.AEMaterialPanelListener T = new AEPituCameraUnit.2(this);
  protected AEWaterMarkPanel.AEWaterMarkPanelListener U = new AEPituCameraUnit.3(this);
  protected AEARCakePanel.AEARCakePanelListener V = new AEPituCameraUnit.4(this);
  protected CameraFocusGesture.FocusGestureListener W = new AEPituCameraUnit.5(this);
  protected CameraZoomGesture.ZoomGestureListener X = new AEPituCameraUnit.6(this);
  protected CameraSwitchGesture.CameraSwitchGestureListener Y = new AEPituCameraUnit.7(this);
  protected final AECameraGLSurfaceView.AEGLSurfaceListener Z = new AEPituCameraUnit.8(this);
  private AEVideoStoryCaptureModeViewModel aA;
  private AEVideoStoryStateViewModel aB;
  private BeautyAndFilterPanel aC;
  private AECompoundButton aD;
  private AECompoundButton aE;
  private ImageView aF;
  private AEPituCameraUnit.ViewStubHoldersViewModel aG;
  private AECosmeticsTypeViewModel aH;
  private Runnable aI;
  private IOnClickWatermarkListener aJ;
  private boolean aK;
  private boolean aL;
  private boolean aM;
  private View aN;
  private AEBeautyProviderViewModel aO;
  private AECosmeticsViewModel aP;
  private AEProviderViewModel aQ;
  private AEFilterProviderViewModel aR;
  protected boolean aa = false;
  protected int ab = 0;
  protected int ac = 0;
  public boolean ae;
  protected View af;
  protected AEMaterialViewModel ag;
  protected AEBottomPanelViewModel ah;
  protected AEMaterialPanel ai;
  protected AEWaterMarkPanel aj;
  protected AEARCakePanel ak;
  protected FilterPagerViewStubHolder al;
  public boolean an = false;
  protected AEVideoStoryTopBarViewModel ao;
  private List<Runnable> ap;
  private HashMap<String, String> aq;
  private AETipsViewController ar;
  private AECameraBroadcastReceiver as = new AECameraBroadcastReceiver(this);
  private long at = 0L;
  private long au = -1L;
  private boolean av = false;
  private boolean aw = false;
  private CountDownLatch ax = new CountDownLatch(1);
  private boolean ay = false;
  private boolean az = AEThemeUtil.b();
  
  public AEPituCameraUnit()
  {
    AEQLog.b(this.a, "[AEPituCameraUnit] + BEGIN");
    AEQLog.a(this.a, "unitConstructor--fake");
    AEQLog.b(this.a, "[AEPituCameraUnit] + END");
  }
  
  public AEPituCameraUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    AEQLog.b(this.a, "[AEPituCameraUnit] + BEGIN");
    long l = System.currentTimeMillis();
    AELaunchRecorder.d().a("unitConstructor-begin");
    paramIQIMCameraContainer = this.a;
    paramICameraEntrance = new StringBuilder();
    paramICameraEntrance.append("AEPituCameraUnit: cameraConfig.getFrom() =");
    paramICameraEntrance.append(this.z.u());
    Log.d(paramIQIMCameraContainer, paramICameraEntrance.toString());
    this.y = 11;
    if (AECameraEntry.J.b(this.z.u()))
    {
      this.y = 1;
      this.r = new CaptureEntranceParams(10000, 100, 15);
    }
    else if (M())
    {
      this.y = 13;
      this.r = new CaptureEntranceParams(10023, this.z.j(), this.z.a());
    }
    else if (!AECameraEntry.e.b(this.z.u()))
    {
      this.y = this.z.v().intValue();
      this.r = new CaptureEntranceParams(this.b.getActivity().getIntent().getIntExtra("edit_video_type", 10002), this.z.j(), this.z.a());
    }
    else
    {
      this.y = 1;
    }
    AEQLog.b(this.a, "[AEPituCameraUnit] submit unit init");
    V();
    N();
    paramIQIMCameraContainer = this.a;
    paramICameraEntrance = new StringBuilder();
    paramICameraEntrance.append("[AEPituCameraUnit] + END, time cost = ");
    paramICameraEntrance.append(System.currentTimeMillis() - l);
    AEQLog.b(paramIQIMCameraContainer, paramICameraEntrance.toString());
  }
  
  private void N()
  {
    ReporterForLightSdk.a().a(this.z.u());
    LightReportManager.setReporter(ReporterForLightSdk.a());
    AEQLog.b(this.a, "initReporterForLightSdk---success");
  }
  
  private void O()
  {
    if ((this.aN != null) && (this.b != null))
    {
      if (this.b.getActivity() != null)
      {
        if (!AECameraEntryManager.o(this.b.getActivity().getIntent())) {
          return;
        }
        VideoReport.setPageId(this.aN, "pg_xsj_shooting_page");
        VideoReport.setPageParams(this.aN, new QCircleDTParamBuilder().buildPageParams(this.a));
        String str = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportDaTongRegister  subPage: ");
        localStringBuilder.append(this.a);
        QLog.i(str, 1, localStringBuilder.toString());
      }
      return;
    }
    QLog.e(this.a, 1, "reportDaTongRegister  view == null || mContainer == null");
  }
  
  private int P()
  {
    int i = AEPreviewSizeUtil.b();
    int j = ImmersiveUtils.getStatusBarHeight(s());
    int k = s().getResources().getDimensionPixelSize(2063859721);
    if (i == 1)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getSurfaceTopMargin] long screen:");
      i = j + k;
      localStringBuilder.append(i);
      AEQLog.a(str, localStringBuilder.toString());
      return i;
    }
    AEQLog.a(this.a, "[getSurfaceTopMargin]:0");
    return 0;
  }
  
  private void Q()
  {
    if (this.z.u() != AECameraEntry.x.a())
    {
      String str = s().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
      if (AECameraEntry.a(this.z.u()).c()) {
        AEBaseReportParam.a().a(this.z.u(), str);
      }
      str = s().getIntent().getStringExtra("intent_key_uid_for_report");
      AEBaseReportParam.a().c(str);
      AEBaseReportParam.a().a(true);
      AEBaseReportParam.a().d();
      AEBaseReportParam.a().b();
      AEBaseReportParam.a().d(CameraOperationHelper.a());
      AEBaseReportParam.a().e(CameraOperationHelper.b());
      AEBaseReportParam.a().a(ParamsUtil.b());
    }
    AEBaseDataReporter.a().ak();
    if (AECameraEntry.e.b(this.z.u())) {
      StoryReportor.a("check_Android", AECameraEntry.e.a(), 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
    }
  }
  
  private long R()
  {
    long l;
    try
    {
      l = Utils.c();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      l = 9223372036854775807L;
    }
    l >>>= 20;
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("available size = ");
    localStringBuilder.append(l);
    localStringBuilder.append("M");
    QLog.d(str, 4, localStringBuilder.toString());
    return l / 30L;
  }
  
  private void T()
  {
    if (this.d != null)
    {
      float f = this.d.getHorizontalViewAngle();
      int j = c(this.d.getSelectedCamera());
      int i = j;
      if (j != 0)
      {
        i = j;
        if (j != 1) {
          i = 0;
        }
      }
      if (f != -1.0F) {
        this.h.updateCameraDeviceConfig(f, i);
      }
    }
  }
  
  private void U()
  {
    if ((aA()) && (!AEGiftMaterialConfigParser.a)) {
      this.ar.h();
    }
  }
  
  private int a(AEBeautyConfigModel paramAEBeautyConfigModel)
  {
    if (paramAEBeautyConfigModel.i().isEmpty()) {
      return AEProviderViewModel.a(paramAEBeautyConfigModel);
    }
    int i = AEProviderViewModel.a(paramAEBeautyConfigModel);
    return AEProviderViewModel.a((AEBeautySecondaryConfigModel)paramAEBeautyConfigModel.i().get(i));
  }
  
  private Intent a(Activity paramActivity, PublishParam paramPublishParam, Intent paramIntent)
  {
    paramActivity = ((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).generateReadInJoyIntent(paramActivity, paramIntent);
    if (paramPublishParam != null)
    {
      paramActivity.putExtra(PublishParam.a, paramPublishParam);
      paramActivity.putExtra("arg_video_duration", paramPublishParam.j);
      paramActivity.putExtra("arg_video_path", paramPublishParam.t);
      paramActivity.putExtra("arg_video_cover", paramPublishParam.c);
      paramActivity.putExtra("arg_video_width", paramPublishParam.h);
      paramActivity.putExtra("arg_video_height", paramPublishParam.i);
    }
    return paramActivity;
  }
  
  private AECaptureMode a(AECaptureMode[] paramArrayOfAECaptureMode, int paramInt)
  {
    String str = s().getIntent().getStringExtra("KEY_CURRENT_TAB");
    int i;
    if (TextUtils.isEmpty(str))
    {
      i = s().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", -1);
      if ((paramInt == 201) && (AECameraEntry.c.a() == i)) {
        return AECaptureMode.PLAY;
      }
      if ((paramInt == 204) && (AECameraEntryManager.c(i))) {
        str = AECameraPrefsUtil.a().b("app_alg_entrance_qzone_id_from833", "", 4);
      } else {
        str = null;
      }
    }
    Object localObject2 = AECaptureMode.fromName(str);
    if (localObject2 != null)
    {
      i = paramArrayOfAECaptureMode.length;
      paramInt = 0;
      while (paramInt < i)
      {
        if (paramArrayOfAECaptureMode[paramInt] == localObject2)
        {
          paramInt = 1;
          break label141;
        }
        paramInt += 1;
      }
    }
    paramInt = 0;
    label141:
    Object localObject1 = localObject2;
    if (paramInt == 0)
    {
      localObject1 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getFirstModeAccordingABTest], get invalid mode=");
      localStringBuilder.append(localObject2);
      AEQLog.d((String)localObject1, localStringBuilder.toString());
      localObject1 = paramArrayOfAECaptureMode[0];
    }
    paramArrayOfAECaptureMode = this.a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[getFirstModeAccordingABTest], ABTest name=");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(", real picked mode=");
    ((StringBuilder)localObject2).append(localObject1);
    AEQLog.b(paramArrayOfAECaptureMode, ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, PublishParam paramPublishParam)
  {
    Intent localIntent = new Intent(s(), SplashActivity.class);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
    localIntent.putExtra("PhotoConst.SEND_FLAG", true);
    localIntent.putExtra(PublishParam.a, paramPublishParam);
    localIntent.addFlags(603979776);
    localIntent.putExtra("open_chatfragment", true);
    localIntent.putExtra("open_chatfragment_fromphoto", true);
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("widgetinfo", paramString2);
    }
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1050);
    paramString1 = localIntent.getStringExtra("key_camera_material_name");
    paramString2 = this.a;
    paramPublishParam = new StringBuilder();
    paramPublishParam.append("send photo---takeSameName=");
    paramPublishParam.append(paramString1);
    AEQLog.b(paramString2, paramPublishParam.toString());
    localIntent.putExtra("uin", this.z.B().a);
    localIntent.putExtra("uintype", this.z.B().c);
    paramActivity.startActivity(localIntent);
    paramActivity.finish();
  }
  
  private void a(AEBeautyConfigModel paramAEBeautyConfigModel, boolean paramBoolean)
  {
    if (paramAEBeautyConfigModel == null) {
      return;
    }
    Object localObject1 = AEProviderViewModel.b(paramAEBeautyConfigModel);
    if (localObject1 == null) {
      return;
    }
    String str1 = ((AEBeautySecondaryConfigModel)localObject1).b();
    String str2 = ((AEBeautySecondaryConfigModel)localObject1).d();
    int n = AEPituCameraUnit.60.a[paramAEBeautyConfigModel.a().ordinal()];
    int i = 2;
    int m = 0;
    int j = 0;
    int k = 0;
    if (n != 1)
    {
      if (n != 2)
      {
        if (n != 3)
        {
          if (n != 4) {
            return;
          }
          i = k;
          if (((AEBeautySecondaryConfigModel)localObject1).j()) {
            i = a(paramAEBeautyConfigModel);
          }
          localObject2 = this.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("lightSDK redCheek");
          localStringBuilder.append(str1);
          localStringBuilder.append(",");
          localStringBuilder.append(str2);
          localStringBuilder.append(",");
          localStringBuilder.append(i);
          AEQLog.b((String)localObject2, localStringBuilder.toString());
          this.h.openFaceThinEnable(((AEBeautySecondaryConfigModel)localObject1).c());
          this.h.setBeautyOrTransformLevel(paramAEBeautyConfigModel.a(), i);
          return;
        }
        i = m;
        if (((AEBeautySecondaryConfigModel)localObject1).j()) {
          i = a(paramAEBeautyConfigModel);
        }
        localObject1 = this.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("lightSDK soft");
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append(str2);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append(i);
        AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
        if (paramBoolean)
        {
          this.h.setBeautyOrTransformLevel(paramAEBeautyConfigModel.a(), i);
          return;
        }
        this.h.openAndUpdateBasicSoftLight(str2, i);
        this.h.openBeautyEnable(true);
        return;
      }
      j = a(paramAEBeautyConfigModel);
      i = j;
      if ("red_check_ri_chang_male".equals(((AEBeautySecondaryConfigModel)localObject1).c())) {
        i = (int)(j * 0.6F);
      }
      if (!((AEBeautySecondaryConfigModel)localObject1).j()) {
        i = 0;
      }
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("lightSDK redCheek");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(i);
      AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
      if (paramBoolean)
      {
        this.h.setBeautyOrTransformLevel(paramAEBeautyConfigModel.a(), i);
        return;
      }
      this.h.openAndUpdateBasicMultiply(str2, i);
      this.h.openBeautyEnable(true);
      return;
    }
    if ("lipstick_shanhu_male".equals(((AEBeautySecondaryConfigModel)localObject1).c())) {
      i = 0;
    }
    if (((AEBeautySecondaryConfigModel)localObject1).j()) {
      j = a(paramAEBeautyConfigModel);
    }
    localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("lightSDK lips");
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append(",");
    ((StringBuilder)localObject2).append(str2);
    ((StringBuilder)localObject2).append(",");
    ((StringBuilder)localObject2).append(j);
    ((StringBuilder)localObject2).append(",");
    ((StringBuilder)localObject2).append(i);
    AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
    if (paramBoolean)
    {
      this.h.setBeautyOrTransformLevel(paramAEBeautyConfigModel.a(), j);
      return;
    }
    this.h.openAndUpdateBasicLips(str2, j, i);
    this.h.openBeautyEnable(true);
  }
  
  private void a(@Nullable AECaptureMode paramAECaptureMode1, @NonNull AECaptureMode paramAECaptureMode2)
  {
    this.x = paramAECaptureMode2;
    if (paramAECaptureMode1 == paramAECaptureMode2) {
      return;
    }
    if ((paramAECaptureMode1 == AECaptureMode.GIF) && (paramAECaptureMode2 == AECaptureMode.NORMAL)) {
      this.h.switchSegment(true);
    }
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onCaptureModeChanged---from ");
    ((StringBuilder)localObject2).append(paramAECaptureMode1);
    ((StringBuilder)localObject2).append(" to ");
    ((StringBuilder)localObject2).append(paramAECaptureMode2);
    AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
    b(paramAECaptureMode1, paramAECaptureMode2);
    localObject1 = this.L;
    if (localObject1 != null) {
      ((CameraFocusGesture)localObject1).a();
    }
    localObject1 = this.x;
    localObject2 = AECaptureMode.GIF;
    boolean bool2 = false;
    boolean bool1;
    if (localObject1 == localObject2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    AEBaseReportParam.a().b(bool1);
    if (this.h != null) {
      this.h.setIsGIFMode(bool1);
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.31(this));
    localObject1 = this.al;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (this.x == AECaptureMode.NORMAL) {
        bool1 = true;
      }
      ((FilterPagerViewStubHolder)localObject1).c(bool1);
    }
    if (Y())
    {
      localObject1 = this.aP;
      if (localObject1 != null) {
        ((AECosmeticsViewModel)localObject1).a(paramAECaptureMode2);
      }
    }
    if (!this.x.shouldStartCamera())
    {
      if ((this.I != null) && (paramAECaptureMode2 == AECaptureMode.PLAY))
      {
        AEQLog.b(this.a, "change to PLAY, setStickerPause");
        this.I.setStickerPause(true);
      }
      paramAECaptureMode1 = this.ar;
      if (paramAECaptureMode1 != null) {
        paramAECaptureMode1.c();
      }
      GLGestureProxy.getInstance().removeListener(this.N);
      GLGestureProxy.getInstance().removeListener(this.P);
      GLGestureProxy.getInstance().removeListener(this.K);
      GLGestureProxy.getInstance().removeListener(this.O);
      GLGestureProxy.getInstance().removeListener(this.L);
      GLGestureProxy.getInstance().removeListener(this.M);
      return;
    }
    if ((this.I != null) && (paramAECaptureMode1 == AECaptureMode.PLAY))
    {
      AEQLog.b(this.a, "change from PLAY, setStickerResume");
      this.I.setStickerResume(true);
    }
    if (!GLGestureProxy.getInstance().hasListener(this.N)) {
      GLGestureProxy.getInstance().addListener(this.N);
    }
    if (!GLGestureProxy.getInstance().hasListener(this.P)) {
      GLGestureProxy.getInstance().addListener(this.P);
    }
    if (!GLGestureProxy.getInstance().hasListener(this.O)) {
      GLGestureProxy.getInstance().addListener(this.O);
    }
    if (!GLGestureProxy.getInstance().hasListener(this.K)) {
      GLGestureProxy.getInstance().addListener(this.K);
    }
    if (!GLGestureProxy.getInstance().hasListener(this.O)) {
      GLGestureProxy.getInstance().addListener(this.O);
    }
    if (!GLGestureProxy.getInstance().hasListener(this.L)) {
      GLGestureProxy.getInstance().addListener(this.L);
    }
    if (!GLGestureProxy.getInstance().hasListener(this.M)) {
      GLGestureProxy.getInstance().addListener(this.M);
    }
  }
  
  private void a(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    int i = this.z.q();
    if (i != -2)
    {
      if (i != 0)
      {
        Object localObject;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              paramAEPhotoCaptureResult = this.a;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("sendPhotoEndByConfig---unknown type: ");
              ((StringBuilder)localObject).append(i);
              AEQLog.d(paramAEPhotoCaptureResult, ((StringBuilder)localObject).toString());
            }
          }
          else {
            this.S.b(262148, new Object[] { paramAEPhotoCaptureResult, this.z.v(), Integer.valueOf(this.z.a()) });
          }
        }
        else
        {
          localObject = new CapturePicParams.CapturePicParamsBuilder(this.d.getSelectedCamera()).a(this.z.B()).a(this.z.m()).a(1).a();
          this.r.a((CapturePicParams)localObject);
          this.S.b(262148, new Object[] { paramAEPhotoCaptureResult, this.r, this.z.v() });
          return;
        }
      }
      this.S.b(262148, new Object[] { paramAEPhotoCaptureResult });
      return;
    }
    this.S.b(262148, new Object[] { paramAEPhotoCaptureResult });
  }
  
  private void a(LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable)
  {
    av();
    if (paramLazyLoadAnimationDrawable == null) {
      return;
    }
    this.aI = new AEPituCameraUnit.32(this);
    this.D.post(new AEPituCameraUnit.33(this, paramLazyLoadAnimationDrawable));
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject = new LocalMediaInfo();
    ((LocalMediaInfo)localObject).mMimeType = "pic";
    localObject = new EditVideoParams(-1, 1387, new EditLocalPhotoSource(paramString1, (LocalMediaInfo)localObject), null);
    GenerateContext localGenerateContext = new GenerateContext((EditVideoParams)localObject);
    localGenerateContext.p = PublishFileManager.a(2);
    localGenerateContext.l = new GeneratePicArgs(((EditVideoParams)localObject).e.a());
    localGenerateContext.d.thumbPath = paramString1;
    Stream.of(localGenerateContext).map(new ThreadOffFunction(this.a, 2)).map(new PublishVideoSegment((EditVideoParams)localObject)).subscribe(c(paramString1, paramString2));
  }
  
  private void a(String paramString1, String paramString2, long paramLong)
  {
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("publishVideoToAioChat---path=");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append(", widgetInfo=");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append(", duration=");
    ((StringBuilder)localObject2).append(paramLong);
    AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = s();
    if ((!TextUtils.isEmpty(paramString1)) && (paramLong > 0L))
    {
      localObject2 = new Intent((Context)localObject1, SendVideoActivity.class);
      ((Intent)localObject2).putExtra("file_send_path", paramString1);
      ((Intent)localObject2).putExtra("file_send_size", new File(paramString1).length());
      ((Intent)localObject2).putExtra("file_send_duration", paramLong);
      ((Intent)localObject2).putExtra("uin", this.z.B().a);
      ((Intent)localObject2).putExtra("uintype", this.z.B().c);
      ((Intent)localObject2).putExtra("file_source", "album");
      ((Intent)localObject2).putExtra("start_init_activity_after_sended", false);
      if (!TextUtils.isEmpty(paramString2)) {
        ((Intent)localObject2).putExtra("widgetinfo", paramString2);
      }
      ((Activity)localObject1).startActivity((Intent)localObject2);
      ((Activity)localObject1).finish();
    }
  }
  
  private boolean a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if ((paramAEMaterialMetaData != null) && (paramAEMaterialMetaData.w))
    {
      paramAEMaterialMetaData = this.I;
      if ((paramAEMaterialMetaData != null) && (paramAEMaterialMetaData.wmGetEditableWMElements() != null) && (this.I.wmGetEditableWMElements().size() > 0)) {
        return true;
      }
    }
    return false;
  }
  
  private void aM()
  {
    if (this.I != null)
    {
      if ((!this.aK) && (!this.aL) && (!this.aM))
      {
        AEQLog.b(this.a, "checkSetOnClickWatermarkListener--PASS, no panel is showing");
        this.I.wmSetOnClickWatermarkListener(this.aJ);
        return;
      }
      AEQLog.b(this.a, "checkSetOnClickWatermarkListener--FAIL, some panel is showing");
      this.I.wmSetOnClickWatermarkListener(null);
    }
  }
  
  private boolean aN()
  {
    return (!this.aL) && (!this.aK) && (!this.aM);
  }
  
  private void aO()
  {
    this.aq = null;
  }
  
  private String aP()
  {
    if (M()) {
      return AECameraPrefsUtil.a().b("circle_camera_ad_activity_id", "", 4);
    }
    return AECameraPrefsUtil.a().b("camera_ad_activity_id", "", 4);
  }
  
  private String aQ()
  {
    return AECameraPrefsUtil.a().b("camera_ad_pendent_activity_id", "", 4);
  }
  
  private void aR()
  {
    if ((this.k == null) && (this.j != null)) {
      this.k = ((CameraFocusView)this.j.inflate());
    }
  }
  
  private void aS()
  {
    Object localObject = (List)this.aO.a().getValue();
    if (localObject == null)
    {
      AEQLog.d(this.a, "clearBeautyEffect error viewModels null.");
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AEBeautyConfigModel localAEBeautyConfigModel = (AEBeautyConfigModel)((Iterator)localObject).next();
      this.h.setBeautyOrTransformLevel(localAEBeautyConfigModel.a(), 0);
    }
  }
  
  private void aT()
  {
    Object localObject = (List)this.aO.a().getValue();
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      b((AEBeautyConfigModel)((Iterator)localObject).next(), false);
    }
  }
  
  private void b(AEBeautyConfigModel paramAEBeautyConfigModel, boolean paramBoolean)
  {
    int i = a(paramAEBeautyConfigModel);
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("beautyData = ");
    ((StringBuilder)localObject2).append(paramAEBeautyConfigModel.b());
    ((StringBuilder)localObject2).append(", adjustValue = ");
    ((StringBuilder)localObject2).append(i);
    QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    if (!paramAEBeautyConfigModel.i().isEmpty()) {
      a(paramAEBeautyConfigModel, paramBoolean);
    }
    localObject1 = this.h;
    localObject2 = paramAEBeautyConfigModel.a();
    if (!paramAEBeautyConfigModel.h()) {
      i = 0;
    }
    ((AECameraGLSurfaceView)localObject1).setBeautyOrTransformLevel((BeautyRealConfig.TYPE)localObject2, i);
  }
  
  private void b(@Nullable AECaptureMode paramAECaptureMode1, @NonNull AECaptureMode paramAECaptureMode2)
  {
    if ((paramAECaptureMode1 != null) && (paramAECaptureMode1.shouldStartCamera())) {
      z();
    }
    if (!paramAECaptureMode2.shouldStartCamera())
    {
      b(false);
      return;
    }
    int i;
    if (this.z.s() == 0) {
      i = CameraHelper.a();
    } else {
      i = this.z.s();
    }
    if (paramAECaptureMode2 == AECaptureMode.GIF) {
      i = 1;
    }
    if (!this.A)
    {
      this.d.setSelectedCamera(i);
      return;
    }
    if (!this.C) {
      return;
    }
    this.d.changeCamera(i, new AEPituCameraUnit.47(this));
  }
  
  private void b(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    Object localObject = s().getIntent();
    if (AECameraEntryManager.o((Intent)localObject))
    {
      this.S.b(262148, new Object[] { paramAEPhotoCaptureResult });
      return;
    }
    if ((!AECameraEntryManager.k((Intent)localObject)) && (!AECameraEntryManager.q((Intent)localObject)))
    {
      if (AECameraEntryManager.s((Intent)localObject))
      {
        i(true);
        this.S.b(262148, new Object[] { paramAEPhotoCaptureResult, this.r, Integer.valueOf(this.y) });
        return;
      }
      this.S.b(262148, new Object[] { paramAEPhotoCaptureResult, this.z.v(), Integer.valueOf(14) });
      return;
    }
    localObject = new CapturePicParams.CapturePicParamsBuilder(this.d.getSelectedCamera()).a(this.z.B()).a(this.z.m()).a(1).b(((Intent)localObject).getIntExtra("qq_sub_business_id", -1)).a();
    this.r.a((CapturePicParams)localObject);
    this.S.b(262148, new Object[] { paramAEPhotoCaptureResult, this.r, Integer.valueOf(this.y) });
  }
  
  private int c(int paramInt)
  {
    return paramInt - 1;
  }
  
  private SimpleObserver<GenerateContext> c(String paramString1, String paramString2)
  {
    return new AEPituCameraUnit.18(this, paramString1, paramString2);
  }
  
  protected boolean E()
  {
    return M();
  }
  
  protected AECaptureParam G()
  {
    Intent localIntent = s().getIntent();
    boolean bool = AECameraEntryManager.n(localIntent);
    int i = 2;
    int j = 1;
    if (bool)
    {
      if (!localIntent.getBooleanExtra("key_camera_prefer_id", false))
      {
        i = j;
        if (CameraUtils.d()) {}
      }
      else
      {
        i = 2;
      }
    }
    else
    {
      if (AECameraEntryManager.p(localIntent)) {
        i = 1;
      }
      if (this.z.s() == 0) {
        i = CameraHelper.b(i);
      } else {
        i = this.z.s();
      }
      if ((this.u == AECaptureMode.GIF) && (CameraUtils.d())) {
        i = j;
      }
    }
    if (MediaCodecDPC.s())
    {
      com.tencent.mobileqq.activity.richmedia.FlowCameraConstant.b = i;
      return DovSVParamManager.a().a(this.b.getActivity(), i);
    }
    return DovSVParamManager.a().a(this.z);
  }
  
  protected boolean J()
  {
    return AECameraEntryManager.k(this.z.u());
  }
  
  public boolean M()
  {
    return AECameraEntryManager.o(s().getIntent());
  }
  
  protected void S()
  {
    if (this.ay) {
      return;
    }
    this.ay = true;
    AEQLog.b(this.a, "actionAfterFirstFrame");
    int i = this.b.getActivity().getIntent().getIntExtra("edit_video_type", 10002);
    ((IAsyncControl)QRoute.api(IAsyncControl.class)).startAsyncStep(CaptureAsyncControl.d, new Object[] { this, Integer.valueOf(i) });
    if ((!this.av) && (!aA()))
    {
      this.av = true;
      ThreadManager.getSubThreadHandler().post(new AEDownloadMaterialRunnable());
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.20(this));
  }
  
  protected void V()
  {
    ThreadManager.excute(new AEPituCameraUnit.9(this), 16, null, true);
  }
  
  @NotNull
  protected void W()
  {
    if (!this.x.shouldStartCamera())
    {
      aF();
      if (M())
      {
        ViewStub localViewStub = (ViewStub)this.g.findViewById(2063991433);
        if (localViewStub != null)
        {
          localViewStub.inflate();
          AEQLog.b(this.a, "AEPartAction--inflate bottom");
        }
      }
      this.S.a();
      int i = this.F;
      if ((i > 0) && (this.G > 0)) {
        this.S.b(851973, new Object[] { Arrays.asList(new Integer[] { Integer.valueOf(i), Integer.valueOf(this.G) }) });
      }
    }
  }
  
  protected VideoStoryCapturePartManager X()
  {
    return new VideoStoryCapturePartManager(this.b.getActivity(), this.g, this);
  }
  
  protected boolean Y()
  {
    return AEDashboardUtil.d();
  }
  
  public boolean Z()
  {
    return this.x == AECaptureMode.GIF;
  }
  
  protected BroadcastReceiver a()
  {
    return this.as;
  }
  
  public AECaptureMode a(int paramInt)
  {
    AECaptureMode localAECaptureMode = AECaptureMode.NORMAL;
    switch (paramInt)
    {
    default: 
      localAECaptureMode = AECaptureMode.NORMAL;
      break;
    case 208: 
      localAECaptureMode = AECaptureMode.ARCAKE;
      break;
    case 207: 
      localAECaptureMode = AECaptureMode.PLAY;
      break;
    case 206: 
      localAECaptureMode = AECaptureMode.PLAY;
      break;
    case 205: 
      localAECaptureMode = AECaptureMode.NORMAL;
      break;
    case 204: 
      localAECaptureMode = a(this.v, paramInt);
      break;
    case 202: 
    case 203: 
      localAECaptureMode = AECaptureMode.GIF;
      break;
    case 201: 
      localAECaptureMode = a(this.v, paramInt);
    }
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initCaptureModesAndFirstMode---initialMode=");
    localStringBuilder.append(localAECaptureMode);
    localStringBuilder.append(", initialCModes=");
    localStringBuilder.append(Arrays.toString(this.v));
    AEQLog.b(str, localStringBuilder.toString());
    return localAECaptureMode;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.14(this));
    this.R.e();
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.d(this.a, "notifyPreviewSizeChanged: ");
    this.F = paramInt1;
    this.G = paramInt2;
    VideoStoryCapturePartManager localVideoStoryCapturePartManager = this.S;
    if (localVideoStoryCapturePartManager != null) {
      localVideoStoryCapturePartManager.b(851973, new Object[] { Arrays.asList(new Integer[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }) });
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onActivityResult:requestCode=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" resultCode=");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(" data=");
      ((StringBuilder)localObject2).append(paramIntent);
      ((StringBuilder)localObject2).append(" publishStoryFlag=");
      ((StringBuilder)localObject2).append(ad);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.b.getActivity();
    ReportUtil.a((Activity)localObject2, paramInt1, paramInt2);
    boolean bool2 = true;
    boolean bool1 = true;
    boolean bool3 = false;
    if ((localObject2 != null) && (!((Activity)localObject2).isFinishing()))
    {
      if (paramInt1 == 1024)
      {
        if (paramInt2 == -1)
        {
          ((Activity)localObject2).setResult(-1, paramIntent);
          ((Activity)localObject2).finish();
        }
        return;
      }
      if ((paramInt1 != 1026) && (paramInt1 != 1027))
      {
        Object localObject3;
        String str;
        StringBuilder localStringBuilder;
        if ((paramInt1 == 1025) && (paramInt2 == -1) && (paramIntent != null))
        {
          localObject1 = paramIntent.getStringExtra("file_send_path");
          localObject3 = paramIntent.getStringExtra("widgetinfo");
          bool3 = paramIntent.getBooleanExtra("file_send_is_photo", false);
          str = this.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onActivityResult---H5 result back, isPhoto=");
          localStringBuilder.append(bool3);
          AEQLog.b(str, localStringBuilder.toString());
          if (!bool3)
          {
            a((String)localObject1, (String)localObject3, paramIntent.getLongExtra("file_send_duration", -1L));
            return;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            a((String)localObject1, (String)localObject3);
            return;
          }
        }
        if ((paramInt1 == 10013) && (paramInt2 == -1) && (paramIntent != null))
        {
          localObject1 = (PublishParam)paramIntent.getParcelableExtra(PublishParam.a);
          localObject3 = (QimMusicPlayer)QIMManager.a().d(8);
          if (localObject3 != null) {
            ((QimMusicPlayer)localObject3).e();
          }
          ((Activity)localObject2).startActivityForResult(a((Activity)localObject2, (PublishParam)localObject1, paramIntent), 111);
          ((Activity)localObject2).setResult(paramInt2, paramIntent);
          ((Activity)localObject2).finish();
          return;
        }
        if (paramInt1 == 111)
        {
          ((Activity)localObject2).setResult(paramInt2, paramIntent);
          ((Activity)localObject2).finish();
          return;
        }
        AEQLog.a(this.a, String.format("onActivityResult, requestCode=%d, resultCode=%d, data=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent }));
        if (paramInt1 == 10020)
        {
          if (paramInt2 == -1)
          {
            ((Activity)localObject2).setResult(paramInt2, paramIntent);
            ((Activity)localObject2).finish();
          }
          return;
        }
        if ((paramIntent == null) && (paramInt2 == 0) && (ad))
        {
          ad = false;
          return;
        }
        if ((paramInt2 == -1) && ((paramInt1 == 10006) || (paramInt1 == 1012))) {
          this.R.i();
        }
        localObject1 = null;
        if (paramInt2 == 0) {
          QQFilterRenderManagerHolder.a(null);
        }
        if ((paramIntent != null) && (this.z.B() != null)) {
          paramIntent.putExtra("PhotoConst.SEND_SESSION_INFO", this.z.B().a());
        }
        if ((paramInt1 == 1012) && (paramInt2 == -1))
        {
          if (paramIntent != null) {
            localObject1 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
          } else {
            localObject1 = "";
          }
          if ((paramIntent == null) || (!paramIntent.getBooleanExtra("input_full_screen_mode", false))) {
            bool1 = false;
          }
          if (paramIntent != null)
          {
            paramIntent.putExtra("input_full_screen_mode_result", (String)localObject1);
            paramIntent.putExtra("input_full_screen_mode", bool1);
            ((Activity)localObject2).setResult(-1, paramIntent);
          }
          else
          {
            paramIntent = new Intent();
            paramIntent.putExtra("input_full_screen_mode_result", (String)localObject1);
            paramIntent.putExtra("input_full_screen_mode", bool1);
            ((Activity)localObject2).setResult(-1, paramIntent);
          }
          ((Activity)localObject2).finish();
          return;
        }
        if ((paramInt1 == 10000) && (paramInt2 == -1))
        {
          localObject3 = s().getIntent();
          if (localObject3 != null) {
            localObject1 = ((Intent)localObject3).getStringExtra("KEY_SEND_ARK_MSG_ID");
          }
          localObject3 = this.z.B();
          str = this.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onActivityResult: edit video finish, arkId=");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(", session is null=");
          if (localObject3 == null) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          localStringBuilder.append(bool1);
          AEQLog.b(str, localStringBuilder.toString());
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (localObject3 != null))
          {
            ((Activity)localObject2).finish();
            return;
          }
          ShortVideoProcessUtil.a(this.b.getActivity(), paramIntent, this.c);
          return;
        }
        this.S.a(paramInt1, paramInt2, paramIntent);
        return;
      }
      this.S.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramIntent = this.a;
      bool1 = bool3;
      if (localObject2 == null) {
        bool1 = true;
      }
      QLog.d(paramIntent, 2, new Object[] { "activity is finishing, ", Boolean.valueOf(bool1) });
    }
  }
  
  protected void a(int paramInt, AEFilterManager paramAEFilterManager)
  {
    VideoStoryCapturePartManager localVideoStoryCapturePartManager = this.S;
    if (localVideoStoryCapturePartManager != null) {
      localVideoStoryCapturePartManager.b(196617, new Object[] { Integer.valueOf(paramInt), paramAEFilterManager });
    }
  }
  
  public void a(int paramInt1, Object paramObject, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return;
        }
        AEQLog.b(this.a, "update light camera effect with cosmetics");
        this.h.updateFenGeAlpha(paramInt2);
        VideoReport.setPageParams(s(), "ae_cosmetic_value", Integer.valueOf(paramInt2));
        return;
      }
      AEQLog.b(this.a, "update light camera effect with beauty");
      if ((paramObject instanceof AEBeautyConfigModel))
      {
        b((AEBeautyConfigModel)paramObject, paramBoolean);
        VideoReport.setPageParams(s(), "ae_beauty_value", "");
      }
    }
    else
    {
      AEQLog.b(this.a, "update light camera effect with filter");
      this.h.updateLutAlpha(paramInt2);
      VideoReport.setPageParams(s(), "ae_filter_value", Integer.valueOf(paramInt2));
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = (AEMaterialManager)AEQIMManager.a().b(1);
    if ((localObject != null) && (paramInt >= 0))
    {
      ((AEMaterialManager)localObject).a(false);
      localObject = ((AEMaterialManager)localObject).a(paramInt, paramString, M());
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("entry dynamics: aeMaterialMetaData");
      localStringBuilder.append(localObject);
      AEQLog.a(str, localStringBuilder.toString());
      if (localObject == null)
      {
        QQToast.makeText(s(), 2064187418, 1).show();
        return;
      }
      if (TextUtils.isEmpty(((AEMaterialMetaData)localObject).m)) {
        AEQLog.a(this.a, "entry dynamics: category is exit but id is null");
      }
      AEBaseReportParam.a().a(paramString, aQ());
      AECircleMultiUnit.a(false, s());
      am().a(true, 150);
      this.S.b(327683, new Object[] { localObject });
      this.S.b(196612, new Object[0]);
      return;
    }
    QQToast.makeText(s(), 2064187418, 1).show();
  }
  
  protected void a(long paramLong)
  {
    Intent localIntent = new Intent(s(), AEStoryGIFPreviewActivity.class);
    localIntent.putExtra("KEY_PREVIEW_SOURCE_PATH", this.o.videoMp4FilePath);
    localIntent.putExtra("KEY_AVAILABLE_EMO_COUNT", paramLong);
    Object localObject = (AEVideoStoryGIFTplViewModel)AEViewModelProviders.a(this).get(AEVideoStoryGIFTplViewModel.class);
    AEMaterialWrapper localAEMaterialWrapper = (AEMaterialWrapper)((AEVideoStoryGIFTplViewModel)localObject).b().getValue();
    boolean bool2 = true;
    if (localAEMaterialWrapper != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localIntent.putExtra("KEY_MATERIAL_APPLIED", bool1);
    if (localAEMaterialWrapper != null) {
      localIntent.putExtra("ARG_GIF_MATERIAL_ID", localAEMaterialWrapper.a);
    }
    localIntent.putExtra("KEY_AVAILABLE_SAVENAME", (String)((AEVideoStoryGIFTplViewModel)localObject).c().getValue());
    localIntent.putExtra("ARG_SESSION_INFO", this.z.B());
    localObject = (String)((AEVideoStoryGIFTplViewModel)localObject).d().getValue();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localIntent.putExtra("KEY_FONT_ID", (String)localObject);
    }
    localObject = s().getIntent();
    boolean bool1 = bool2;
    if (!AECameraEntryManager.k((Intent)localObject)) {
      if (AECameraEntryManager.l((Intent)localObject)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    localIntent.putExtra("ARG_GIF_SEND_TO_AIO", bool1);
    localObject = s();
    if (localObject != null)
    {
      localIntent.putExtra("AECAMERA_MODE", this.z.w());
      localIntent.putExtra("VIDEO_STORY_FROM_TYPE", this.z.u());
      ((Activity)localObject).startActivityForResult(localIntent, 101);
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    paramIntent = paramIntent.getExtras();
    if ((paramIntent != null) && (paramIntent.containsKey("FROM_FLAG_BACK_FROM_QUDONG_TO_AIO")))
    {
      AEQLog.b(this.a, "onNewIntent---back from qu dong");
      String str = paramIntent.getString("file_send_path");
      if (!TextUtils.isEmpty(str)) {
        a(str, paramIntent.getString("widgetinfo", ""), ShortVideoUtils.getDuration(str));
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if ((this.i != null) && ((this.i instanceof AEPituCameraCaptureButtonLayout))) {
      ((AEPituCameraCaptureButtonLayout)this.i).a(paramMotionEvent);
    }
  }
  
  public void a(AECaptureMode paramAECaptureMode)
  {
    this.x = paramAECaptureMode;
  }
  
  public void a(AECompoundButton paramAECompoundButton)
  {
    if (paramAECompoundButton == null) {
      return;
    }
    Object localObject = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    ((RotateAnimation)localObject).setDuration(200L);
    paramAECompoundButton.startAnimation((Animation)localObject);
    PressScaleAnimDelegate.a(this.aD.getForegroundView(), 200L, null);
    if (paramAECompoundButton != null) {
      if (this.d.isFrontCamera()) {
        paramAECompoundButton.setContentDescription(this.aD.getResources().getString(2064187699));
      } else {
        paramAECompoundButton.setContentDescription(this.aD.getResources().getString(2064187700));
      }
    }
    if (!Z())
    {
      AEBaseDataReporter.a().N();
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("【Change Camera】:isFrontCamera:");
      localStringBuilder.append(this.d.isFrontCamera());
      AEQLog.b((String)localObject, localStringBuilder.toString());
    }
    o();
    if (M()) {
      AEReportUtils.b(13, null);
    }
    AECameraDaTongHelper.a.a(paramAECompoundButton, null);
  }
  
  protected void a(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    if (!this.A) {
      return;
    }
    if (paramAEVideoCaptureResult.videoFrameCount < aD())
    {
      if (QLog.isColorLevel())
      {
        paramAEVideoCaptureResult = this.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onVideoCaptured. videoFrameCount = ");
        ((StringBuilder)localObject).append(this.o.videoFrameCount);
        ((StringBuilder)localObject).append(" ; minFrameCount = ");
        ((StringBuilder)localObject).append(aD());
        QLog.d(paramAEVideoCaptureResult, 2, ((StringBuilder)localObject).toString());
      }
      an();
      return;
    }
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【GIF Capture】during time:");
    localStringBuilder.append(paramAEVideoCaptureResult.finishTimeMs - paramAEVideoCaptureResult.startTimeMs);
    localStringBuilder.append("ms");
    AEQLog.b((String)localObject, localStringBuilder.toString());
    AEBaseReportParam.a().b(5L);
    AEBaseDataReporter.a().ap();
    long l = R();
    if (l > 0L)
    {
      a(l);
      return;
    }
    paramAEVideoCaptureResult = BaseApplicationImpl.getContext();
    if (paramAEVideoCaptureResult != null) {
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.50(this, paramAEVideoCaptureResult));
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    ThreadManager.getUIHandler().post(new -..Lambda.AEPituCameraUnit.y3PlI2Ls943X4l8yOawbAqzEAp8(this, paramRunnable));
  }
  
  public void a(@NonNull List<AEDashboardUtil.BinaryInfo> paramList, @NonNull List<AEDashboardUtil.ABTestInfo> paramList1)
  {
    this.S.b(720897, new Object[] { paramList, paramList1 });
  }
  
  public void a(boolean paramBoolean, View paramView)
  {
    if (!this.aa)
    {
      if (paramView == null) {
        return;
      }
      Object localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bClosedByCustom");
      localStringBuilder.append(this.an);
      AEQLog.a((String)localObject, localStringBuilder.toString());
      if (this.x == AECaptureMode.GIF)
      {
        AEQLog.b(this.a, "【Dark Mode】in gif show off");
        paramView.setVisibility(8);
        return;
      }
      localObject = this.aB;
      if ((localObject == null) || (!((AEVideoStoryStateViewModel)localObject).h()))
      {
        localObject = this.ah;
        if ((localObject == null) || (!((AEBottomPanelViewModel)localObject).c())) {}
      }
      else
      {
        AEQLog.b(this.a, "【Dark Mode】in panel show off ");
        paramView.setVisibility(8);
        return;
      }
      if (paramBoolean)
      {
        if (!this.an)
        {
          paramView.setVisibility(0);
          paramView.setSelected(true);
          c(true);
          this.an = false;
          AEQLog.b(this.a, "【Dark Mode】Start");
        }
      }
      else
      {
        paramView.setVisibility(8);
        paramView.setSelected(false);
        c(false);
        this.an = false;
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if (paramInt == 4) {
      ak();
    }
    return super.a(paramInt, paramKeyEvent, paramBoolean);
  }
  
  public boolean aA()
  {
    return AECameraEntryManager.q(s().getIntent());
  }
  
  public void aB()
  {
    Object localObject = this.ar;
    if (localObject != null) {
      ((AETipsViewController)localObject).d();
    }
    localObject = this.aD;
    if (localObject != null) {
      ((AECompoundButton)localObject).setVisibility(8);
    }
    AECircleMultiUnit.a(false, s());
    this.aB.a().postValue(Boolean.valueOf(false));
  }
  
  protected void aC()
  {
    this.N = new CameraProviderViewGesture();
    this.N.a(this.ai);
    this.N.a(this.aj);
    this.N.a(this.ak);
    this.N.a(this.g);
    this.N.a(new AEPituCameraUnit.48(this));
    this.N.a(new AEPituCameraUnit.49(this));
    this.K = new CameraZoomGesture(this.X);
    AECameraGLSurfaceView localAECameraGLSurfaceView = this.h;
    int i;
    if (M()) {
      i = P();
    } else {
      i = 0;
    }
    this.O = new CameraTriggerGesture(localAECameraGLSurfaceView, i);
    this.L = new CameraFocusGesture(s(), this.W);
    this.M = new CameraSwitchGesture(this.h.getContext(), this.Y);
  }
  
  protected long aD()
  {
    return 5L;
  }
  
  public boolean aE()
  {
    try
    {
      int i = this.ab;
      boolean bool = true;
      if (i == 1) {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @MainThread
  protected void aF()
  {
    AEQLog.b(this.a, "setCaptureModeViewModel---");
    AEVideoStoryCaptureModeViewModel localAEVideoStoryCaptureModeViewModel = (AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this).get(AEVideoStoryCaptureModeViewModel.class);
    localAEVideoStoryCaptureModeViewModel.a.setValue(new AECaptureModeChangingEvent(null, this.z.x(), 1));
    localAEVideoStoryCaptureModeViewModel.b.setValue(this.z.y());
  }
  
  public void aG()
  {
    this.R.a();
  }
  
  protected void aH()
  {
    LiuHaiUtils.a(this.m, this.n, ViewUtils.dip2px(1.0F));
    aI();
  }
  
  protected void aI()
  {
    Object localObject = s();
    if (ScreenUtil.getRealHeight((Context)localObject) / ScreenUtil.getRealWidth((Context)localObject) >= 2.0F)
    {
      this.n.setVisibility(8);
      this.m.setVisibility(8);
      if (!AECameraEntryManager.g(this.z.u())) {
        a((Activity)localObject);
      }
    }
    if ((Build.MODEL.contains("Pixel 2")) && (Build.VERSION.SDK_INT >= 16))
    {
      localObject = ((Activity)localObject).getWindow().getDecorView();
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() & 0xFFFFFFFB);
    }
    localObject = this.af;
    if (localObject != null)
    {
      localObject = ((View)localObject).getViewTreeObserver();
      if (((ViewTreeObserver)localObject).isAlive()) {
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(new AEPituCameraUnit.55(this));
      }
    }
  }
  
  public HashMap<String, String> aJ()
  {
    return this.aq;
  }
  
  public Bitmap aK()
  {
    Bitmap localBitmap = this.H;
    if ((localBitmap != null) && (localBitmap.isRecycled())) {
      return null;
    }
    return this.H;
  }
  
  public void aL()
  {
    if (this.aQ != null) {
      return;
    }
    AEQLog.b(this.a, "init beautyViewModel start...");
    this.aR = ((AEFilterProviderViewModel)AEViewModelProviders.a(this).get(AEFilterProviderViewModel.class));
    this.aO = ((AEBeautyProviderViewModel)AEViewModelProviders.a(this).get(AEBeautyProviderViewModel.class));
    this.aP = ((AECosmeticsViewModel)AEViewModelProviders.a(this).get(AECosmeticsViewModel.class));
    this.aQ = ((AEProviderViewModel)AEViewModelProviders.a(this, new AEProviderViewModelFactory(this.aO, this.aP, this.aR)).get(AEProviderViewModel.class));
    this.aQ.d().observe(this, new AEPituCameraUnit.57(this));
    this.aO.i().observe(this, new AEPituCameraUnit.58(this));
    if (Y()) {
      this.aQ.c().observe(this, new AEPituCameraUnit.59(this));
    }
  }
  
  public void aa()
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCaptureButtonVideoStop: thread = ");
    localStringBuilder.append(Thread.currentThread().getName());
    Log.d(str, localStringBuilder.toString());
    this.h.stopCaptureVideo();
    this.d.stopRecordVideo();
    this.aa = false;
    this.aB.e().postValue(Boolean.valueOf(false));
    ((CaptureComboManager)QIMManager.a(5)).a(false);
    e(0);
  }
  
  public boolean ab()
  {
    return true;
  }
  
  public void ac()
  {
    aB();
  }
  
  public void ad()
  {
    this.aa = true;
    this.aB.e().postValue(Boolean.valueOf(true));
    this.h.resetMaterialWhenRecord();
    if ((this.d.isFlashEnabled()) && (this.x != AECaptureMode.GIF)) {
      this.d.turnFlash(s(), true);
    }
    this.h.startCaptureVideo();
    if (!this.d.isFrontCamera()) {
      this.d.setFocusModeRecording();
    }
    ((CaptureComboManager)QIMManager.a(5)).a(true);
  }
  
  public void ae()
  {
    this.S.b(786435, new Object[0]);
  }
  
  public void af()
  {
    an();
  }
  
  protected boolean ag()
  {
    return (this.z != null) && (this.z.q() != -1);
  }
  
  public void ah()
  {
    QIMCaptureVarManager localQIMCaptureVarManager = (QIMCaptureVarManager)QIMManager.a(13);
    if (AECameraEntry.e.b(this.z.u()))
    {
      localQIMCaptureVarManager.b(14);
      return;
    }
    localQIMCaptureVarManager.b(this.r.c);
  }
  
  public void ai()
  {
    AEQLog.b(this.a, "onActivityStart");
    super.ai();
    Object localObject = this.S;
    if (localObject != null) {
      ((VideoStoryCapturePartManager)localObject).d();
    }
    this.au = System.currentTimeMillis();
    if (aA()) {
      AEBaseDataReporter.a().j();
    }
    if (Y())
    {
      AEBeautyReportParam.a().a(this);
      AEBaseDataReporter.a().b(new HashMap(AEBeautyReportParam.a().b()));
    }
    else
    {
      AEBaseDataReporter.a().J();
    }
    if (QLog.isDevelopLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityStart, ID=");
      localStringBuilder.append(this.t);
      AEQLog.a((String)localObject, localStringBuilder.toString());
    }
  }
  
  public void aj()
  {
    AEQLog.b(this.a, "onActivityStop");
    super.aj();
    this.S.e();
    AEBaseDataReporter.a().c(this.au);
    if (QLog.isDevelopLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityStop, ID=");
      localStringBuilder.append(this.t);
      AEQLog.a(str, localStringBuilder.toString());
    }
  }
  
  public boolean ak()
  {
    Object localObject = this.R;
    if (localObject == null) {
      return false;
    }
    if (((AECaptureController)localObject).j()) {
      return false;
    }
    if ((this.S.a(589824)) && (((Boolean)this.S.a(589826, new Object[0])).booleanValue()))
    {
      AEQLog.a(this.a, "WaterMark editor need hide");
      this.S.b(589826, new Object[0]);
      return true;
    }
    this.R.g();
    this.R.i();
    if (M())
    {
      localObject = s().getIntent();
      String str1 = ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      String str2 = ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      if (str1 != null)
      {
        ((Intent)localObject).setClassName(str2, str1);
        ((Intent)localObject).removeExtra("PhotoConst.PHOTO_PATHS");
        ((Intent)localObject).removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
        ((Intent)localObject).addFlags(603979776);
        if (!((Intent)localObject).getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false))
        {
          s().startActivity((Intent)localObject);
        }
        else
        {
          ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_NAME");
          str2 = ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_APK");
          String str3 = ((Intent)localObject).getStringExtra("PhotoConst.UIN");
          if ("qzone_plugin.apk".equals(str2))
          {
            QzonePluginProxyActivity.setActivityNameToIntent((Intent)localObject, str1);
            QZoneHelper.launchQZone(s(), str3, (Intent)localObject, 2);
          }
        }
      }
    }
    this.b.b();
    AEBaseDataReporter.a().K();
    AEQLog.b(this.a, "【Click】onBackPressed");
    return true;
  }
  
  public void al()
  {
    super.al();
  }
  
  public AECaptureController am()
  {
    if (this.R == null) {
      this.R = new AECaptureController(this.g, this);
    }
    return this.R;
  }
  
  protected void an()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.19(this));
  }
  
  protected void ao()
  {
    if (ap())
    {
      as();
      return;
    }
    if (aq()) {
      ar();
    }
  }
  
  protected boolean ap()
  {
    return (this.z.c() == 101) && (this.z.f()) && (this.z.d()) && (this.z.i());
  }
  
  protected boolean aq()
  {
    return (this.z.c() == 101) && (this.z.h());
  }
  
  protected void ar()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", false);
    s().sendBroadcast(localIntent);
    this.S.b(131076, new Object[0]);
  }
  
  protected void as()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", true);
    s().sendBroadcast(localIntent);
    this.S.b(131077, new Object[0]);
  }
  
  protected void at()
  {
    this.ag = ((AEMaterialViewModel)AEViewModelProviders.a(this).get(AEMaterialViewModel.class));
    this.aG = ((AEPituCameraUnit.ViewStubHoldersViewModel)AEViewModelProviders.a(this).get(AEPituCameraUnit.ViewStubHoldersViewModel.class));
    this.aH = ((AECosmeticsTypeViewModel)AEViewModelProviders.a(this).get(AECosmeticsTypeViewModel.class));
    ((AEFilterProviderViewModel)AEViewModelProviders.a(this).get(AEFilterProviderViewModel.class)).a().observe(this, new AEPituCameraUnit.21(this));
    this.ag.a().observe(this, new -..Lambda.AEPituCameraUnit.T4YGLcgg5ArobYWPMkbYy1VOhcM(this));
    this.aA = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this).get(AEVideoStoryCaptureModeViewModel.class));
    this.aA.a.observe(this, new AEPituCameraUnit.22(this));
    this.aP = ((AECosmeticsViewModel)AEViewModelProviders.a(this).get(AECosmeticsViewModel.class));
    this.aP.b().observe(this, new AEPituCameraUnit.23(this));
    this.aB = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this).get(AEVideoStoryStateViewModel.class));
    this.ao = ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this).get(AEVideoStoryTopBarViewModel.class));
    this.ao.a(this.d.isFrontCamera());
    this.ao.a.observe(this, new AEPituCameraUnit.24(this));
    this.aB.e().observe(this, new AEPituCameraUnit.25(this));
    this.aB.d().observe(this, new AEPituCameraUnit.26(this));
    this.aB.b().observe(this, new AEPituCameraUnit.27(this));
    this.aB.c().observe(this, new AEPituCameraUnit.28(this));
    this.ah = ((AEBottomPanelViewModel)AEViewModelProviders.a(this).get(AEBottomPanelViewModel.class));
    this.ah.a().observe(this, new AEPituCameraUnit.29(this));
    if (Y()) {
      aL();
    }
  }
  
  public void au()
  {
    if (this.aD != null) {
      if (CameraUtils.d()) {
        this.aD.setVisibility(0);
      } else {
        this.aD.setVisibility(4);
      }
    }
    AECompoundButton localAECompoundButton;
    if (GLVideoClipUtil.a())
    {
      localAECompoundButton = this.aE;
      if (localAECompoundButton != null) {
        localAECompoundButton.setVisibility(0);
      }
    }
    else
    {
      localAECompoundButton = this.aE;
      if ((localAECompoundButton != null) && (this.an))
      {
        localAECompoundButton.setVisibility(0);
        this.aE.setSelected(false);
      }
    }
    g(true);
    AEBaseReportParam.a().O();
    AEBaseDataReporter.a().aj();
    if ((!this.aA.c()) && (this.i != null)) {
      this.i.setVisibility(0);
    }
    if (aN()) {
      AECircleMultiUnit.a(true, s());
    }
    this.aB.a().postValue(Boolean.valueOf(true));
  }
  
  protected void av()
  {
    if (this.aI != null)
    {
      this.D.removeCallbacks(this.aI);
      this.aI = null;
    }
    if (this.aF != null) {
      this.D.post(new AEPituCameraUnit.34(this));
    }
  }
  
  public List<WMElement> aw()
  {
    AEFilterManager localAEFilterManager = this.I;
    if (localAEFilterManager == null) {
      return Collections.emptyList();
    }
    return localAEFilterManager.wmGetEditableWMElements();
  }
  
  public void ax()
  {
    this.b.getActivity().onBackPressed();
  }
  
  public void ay()
  {
    s().getIntent().removeExtra("widgetinfo");
    PicChooseJumpUtil.a(s());
  }
  
  protected void az()
  {
    AECircleMultiUnit.a(false, s());
    this.aB.a().postValue(Boolean.valueOf(false));
  }
  
  public void b(String paramString)
  {
    AEMaterialManager localAEMaterialManager = (AEMaterialManager)AEQIMManager.a().b(1);
    if ((localAEMaterialManager != null) && (!TextUtils.isEmpty(paramString)))
    {
      AEBaseReportParam.a().a(paramString, aP());
      localAEMaterialManager.a(false);
      paramString = localAEMaterialManager.a(paramString, M());
      if (paramString == null)
      {
        Toast.makeText(s(), 2064187418, 1).show();
        return;
      }
      AECircleMultiUnit.a(false, s());
      am().a(true, 150);
      this.S.b(327683, new Object[] { paramString });
      this.S.b(196612, new Object[0]);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (this.h != null) {
      this.h.setBundlePath(paramString1, paramString2);
    }
  }
  
  public AECaptureMode[] b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      localObject = new AECaptureMode[1];
      localObject[0] = AECaptureMode.NORMAL;
      break;
    case 208: 
      localObject = AECaptureMode.ARCAKE;
      break;
    case 207: 
      localObject = new AECaptureMode[2];
      localObject[0] = AECaptureMode.PLAY;
      localObject[1] = AECaptureMode.GIF;
      break;
    case 206: 
      localObject = new AECaptureMode[1];
      localObject[0] = AECaptureMode.PLAY;
      break;
    case 205: 
      localObject = new AECaptureMode[2];
      localObject[0] = AECaptureMode.NORMAL;
      localObject[1] = AECaptureMode.GIF;
      break;
    case 204: 
      localObject = new AECaptureMode[2];
      localObject[0] = AECaptureMode.NORMAL;
      localObject[1] = AECaptureMode.PLAY;
      break;
    case 202: 
    case 203: 
      localObject = new AECaptureMode[1];
      localObject[0] = AECaptureMode.GIF;
      break;
    }
    Object localObject = new AECaptureMode[3];
    localObject[0] = AECaptureMode.NORMAL;
    localObject[1] = AECaptureMode.PLAY;
    localObject[2] = AECaptureMode.GIF;
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initCaptureModesAndFirstMode---initialMode=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", initialCModes=");
    localStringBuilder.append(Arrays.toString((Object[])localObject));
    AEQLog.b(str, localStringBuilder.toString());
    return localObject;
  }
  
  protected void c()
  {
    this.h.setAECaptureController(am());
    this.h.setAeGLSurfaceListener(this.Z);
    this.h.setCaptureListener(this);
    this.h.setFaceEffectListener(this);
    this.h.setStickerInnerLutFilterListener(this);
    this.h.setRecommendTextCallback(new AEPituCameraUnit.51(this));
    if (MediaCodecDPC.s())
    {
      this.h.setDynamicResolutionMode(true);
      this.d.setDynamicResolutionMode(true);
    }
    else
    {
      this.h.setDynamicResolutionMode(false);
      this.d.setDynamicResolutionMode(false);
    }
    if (AEDashboardUtil.f()) {
      this.h.debugInfoCallback = this;
    }
    if (M()) {
      this.h.setAeEditMaterialSelectedListener(new AEPituCameraUnit.52(this));
    }
  }
  
  protected void d()
  {
    this.h.setGenderTypeListener(new AEPituCameraUnit.53(this));
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    Object localObject = this.b.getActivity();
    int i;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool = PermissionUtils.isStorePermissionEnable((Context)localObject);
    localObject = new LinkedList();
    if (i != 0)
    {
      ((List)localObject).add("android.permission.CAMERA");
      AEQLog.b(this.a, "【Camera Permission】denied");
    }
    if (j != 0)
    {
      ((List)localObject).add("android.permission.RECORD_AUDIO");
      AEQLog.b(this.a, "【Audio Permission】denied");
    }
    if ((bool ^ true))
    {
      ((List)localObject).add("android.permission.READ_EXTERNAL_STORAGE");
      ((List)localObject).add("android.permission.WRITE_EXTERNAL_STORAGE");
      AEQLog.b(this.a, "【External Storage Permission】denied");
    }
    localObject = DialogUtil.a((String[])((List)localObject).toArray(new String[0]));
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.41(this, (String)localObject));
  }
  
  protected AECameraManager.CameraManagerListener e()
  {
    return this.J;
  }
  
  public void e(int paramInt)
  {
    Object localObject = this.g.findViewById(2063991103);
    if ((localObject instanceof VideoFilterViewPager))
    {
      ((VideoFilterViewPager)localObject).setVisibility(paramInt);
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("yes to domVideoFilterViewPager setVisibility: ");
      localStringBuilder.append(paramInt);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
  }
  
  protected DarkModeChecker.DarkModeListener f()
  {
    return this;
  }
  
  public void f(int paramInt)
  {
    try
    {
      this.ab = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void g()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.40(this));
  }
  
  public void g(int paramInt)
  {
    try
    {
      this.ac = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.i == null) {
      return;
    }
    if (paramBoolean)
    {
      this.S.b(327687, new Object[0]);
      return;
    }
    this.S.b(327688, new Object[0]);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    AEQLog.b(this.a, "【Camera / Audio / Storage Permission】grant");
    this.C = true;
    if (this.A) {
      B();
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResourceDownload isOnlineRes: ");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (!am)
    {
      am = true;
      this.b.getActivity().runOnUiThread(new AEPituCameraUnit.38(this));
      return;
    }
    this.b.getActivity().runOnUiThread(new AEPituCameraUnit.39(this));
  }
  
  protected boolean h()
  {
    if (this.x == AECaptureMode.GIF) {
      return false;
    }
    return AECameraEntryManager.n(s().getIntent()) ^ true;
  }
  
  public void i()
  {
    AEQLog.b(this.a, "onPhotoCaptureStart---");
    az();
    if (this.i != null) {
      this.i.setVisibility(8);
    }
    this.S.b(196609, new Object[0]);
    this.S.b(262147, new Object[0]);
  }
  
  public void i(boolean paramBoolean) {}
  
  public View j()
  {
    this.aN = super.j();
    this.R = am();
    this.S = X();
    ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this).get(AEVideoStoryTopBarViewModel.class)).a.setValue(this.w);
    aH();
    W();
    at();
    aC();
    Object localObject1 = this.ai;
    if (localObject1 != null)
    {
      ((AEMaterialPanel)localObject1).setMaterialPanelListener(this.T);
      this.ai.setVisibility(8);
    }
    localObject1 = this.aj;
    if (localObject1 != null) {
      ((AEWaterMarkPanel)localObject1).setMaterialPanelListener(this.U);
    }
    localObject1 = this.ak;
    if (localObject1 != null) {
      ((AEARCakePanel)localObject1).setMaterialPanelListener(this.V, aA());
    }
    this.ar = new AETipsViewController(this.g, this.S);
    boolean bool;
    if (!AECameraEntryManager.p(s().getIntent()))
    {
      this.al = new FilterPagerViewStubHolder((ViewStub)this.g.findViewById(2063991439));
      this.aG.b.postValue(this.al);
      localObject1 = this.al;
      if (this.x == AECaptureMode.NORMAL) {
        bool = true;
      } else {
        bool = false;
      }
      ((FilterPagerViewStubHolder)localObject1).a(bool);
    }
    DYAEBeautyPanelConfigHolder.a(DYAEBeautyPanelConfigUtil.a());
    if (Y()) {
      localObject1 = new DYBeautyAndFilterPanelViewStubHolder((ViewStub)this.g.findViewById(2063991459));
    } else {
      localObject1 = new BeautyAndFilterPanelViewStubHolder((ViewStub)this.g.findViewById(2063991431));
    }
    this.aC = ((BeautyAndFilterPanel)localObject1);
    this.aG.a.setValue(this.aC);
    CosFunHelper.setCountDownListener(new AEPituCameraUnit.13(this));
    this.aC.a(this.N);
    localObject1 = this.al;
    if (localObject1 != null) {
      this.P = ((FilterPagerViewStubHolder)localObject1).d();
    }
    if ((this.m != null) && (this.m.getVisibility() == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onCreateView needLiuHaiTop:");
      ((StringBuilder)localObject2).append(bool);
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    localObject1 = s().getIntent().getStringExtra("key_guide_image");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = Base64.b(((String)localObject1).substring(22));
      localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
      if (BitmapUtils.isLegal((Bitmap)localObject1))
      {
        localObject2 = (ImageView)this.g.findViewById(2063990909);
        ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
        ((ImageView)localObject2).setVisibility(0);
      }
    }
    localObject1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (localObject1 != null)
    {
      localObject2 = (IFriendDataService)AECaptureContext.a().getRuntimeService(IFriendDataService.class, "all");
      if (localObject2 != null)
      {
        localObject1 = ((IFriendDataService)localObject2).getFriend((String)localObject1, true);
        if (localObject1 != null)
        {
          localObject2 = this.aH.a();
          if (((Friends)localObject1).gender == 1) {
            localObject1 = GenderType.MALE;
          } else {
            localObject1 = GenderType.FEMALE;
          }
          ((MutableLiveData)localObject2).postValue(Integer.valueOf(((GenderType)localObject1).value));
        }
      }
    }
    AEQLog.b(this.a, "[UnitAsyncInit] before await");
    try
    {
      this.ax.await(1000L, TimeUnit.MILLISECONDS);
    }
    catch (InterruptedException localInterruptedException)
    {
      localObject2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UnitAsyncInit] await interrupt exp: ");
      localStringBuilder.append(localInterruptedException.getMessage());
      AEQLog.d((String)localObject2, localStringBuilder.toString());
    }
    AEQLog.b(this.a, "[UnitAsyncInit] after await");
    O();
    return this.aN;
  }
  
  public void k()
  {
    AEQLog.b(this.a, "onActivityResume");
    this.A = true;
    if (ad)
    {
      AEQLog.d(this.a, "onActivityResume---publishStoryFlag is true, activity will finish soon, fast return");
      return;
    }
    ReporterForLightSdk.a().a(this.z.u());
    super.k();
    this.d.refreshDarkModeTimer();
    aM();
    GLGestureProxy.getInstance().addListener(this.N);
    GLGestureProxy.getInstance().addListener(this.P);
    GLGestureProxy.getInstance().addListener(this.K);
    GLGestureProxy.getInstance().addListener(this.O);
    GLGestureProxy.getInstance().addListener(this.L);
    GLGestureProxy.getInstance().addListener(this.M);
    this.R.h();
    if (this.aw)
    {
      if (this.i != null) {
        this.i.i();
      }
      au();
      f(false);
    }
    Object localObject = this.S;
    if (localObject != null) {
      ((VideoStoryCapturePartManager)localObject).b();
    }
    ah();
    g(false);
    AEMaterialManager.b = true;
    if (QLog.isDevelopLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityResume, ID=");
      localStringBuilder.append(this.t);
      AEQLog.a((String)localObject, localStringBuilder.toString());
    }
    if (M())
    {
      localObject = null;
      if (AEMaterialManager.n() != null)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("ext2", AEMaterialManager.n().m);
      }
      AEReportUtils.a(1, (HashMap)localObject);
    }
  }
  
  public void l()
  {
    AEQLog.b(this.a, "onActivityPause");
    super.l();
    GLGestureProxy.getInstance().removeListener(this.N);
    GLGestureProxy.getInstance().removeListener(this.P);
    GLGestureProxy.getInstance().removeListener(this.K);
    GLGestureProxy.getInstance().removeListener(this.O);
    GLGestureProxy.getInstance().removeListener(this.L);
    GLGestureProxy.getInstance().removeListener(this.M);
    Object localObject = this.al;
    if (localObject != null) {
      ((FilterPagerViewStubHolder)localObject).e();
    }
    if (this.i != null) {
      this.i.j();
    }
    this.R.g();
    this.S.c();
    AEMaterialManager.b = false;
    if (QLog.isDevelopLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityPause, ID=");
      localStringBuilder.append(this.t);
      AEQLog.a((String)localObject, localStringBuilder.toString());
    }
  }
  
  public void m()
  {
    super.m();
    aO();
    if (AEDashboardUtil.f()) {
      this.h.debugInfoCallback = null;
    }
    this.S.f();
    Object localObject = this.al;
    if (localObject != null) {
      ((FilterPagerViewStubHolder)localObject).f();
    }
    this.e.b();
    AEBaseReportParam.a().aa();
    AEBaseReportParam.a().a(false);
    AECameraGetInfoClient.c();
    if ((s() != null) && (AECameraEntryManager.n(s().getIntent()))) {
      this.d.setSelectedCamera(CameraHelper.a());
    }
    localObject = (AEMaterialManager)AEQIMManager.a(1);
    ((AEMaterialManager)localObject).a();
    ((AEMaterialManager)localObject).l();
    localObject = this.R;
    if (localObject != null) {
      ((AECaptureController)localObject).d();
    }
    localObject = this.I;
    if (localObject != null)
    {
      ((AEFilterManager)localObject).wmSetOnClickWatermarkListener(null);
      this.I.wmSetOnlineUsrCountDelegate("watermark.qq.online", null);
    }
    if (aA()) {
      AEARCakeMaterialManager.a().a(null);
    }
  }
  
  protected int n()
  {
    if (M()) {
      return 2064056394;
    }
    return 2064056392;
  }
  
  public void notifyEnableLutType(int paramInt)
  {
    boolean bool2 = true;
    if (paramInt == 1000)
    {
      f(1);
      localObject = this.S;
      if (localObject != null) {
        ((VideoStoryCapturePartManager)localObject).b(196609, new Object[0]);
      }
    }
    else
    {
      f(0);
    }
    Object localObject = AEFilterManagerHolder.getAEFilterManager();
    boolean bool1;
    if (localObject != null)
    {
      if (paramInt != 1000) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((AEFilterProcessTex)localObject).a = bool1;
      if (paramInt == 1000) {
        ((AEFilterProcessTex)localObject).n();
      }
    }
    localObject = this.R;
    if (localObject != null)
    {
      if (paramInt != 1000) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      ((AECaptureController)localObject).c = bool1;
    }
  }
  
  public void notifyEnableMeshType(int paramInt)
  {
    if (paramInt == 2001) {
      paramInt = 4;
    } else {
      paramInt = 3;
    }
    g(paramInt);
  }
  
  public void onAEKitInited()
  {
    super.onAEKitInited();
    if (!Y())
    {
      int i = AEBeautyProviderView.getBeautyFeature();
      int j = AEBeautyProviderView.getSharpFaceFeature();
      this.R.a(i);
      this.R.b(j);
    }
    this.D.post(new AEPituCameraUnit.12(this));
    AEFontManager.a().b();
  }
  
  public void onAssetProcessingData(HashMap<String, String> paramHashMap)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAssetProcessingData: ");
    localStringBuilder.append(paramHashMap);
    AEQLog.a(str, localStringBuilder.toString());
    if ((paramHashMap != null) && (paramHashMap.containsKey("lightasset.behaviour.report")))
    {
      str = (String)paramHashMap.get("lightasset.behaviour.report");
      AEBaseDataReporter.a().v(str);
    }
    this.aq = paramHashMap;
  }
  
  public void onCaptureError(int paramInt)
  {
    this.aa = false;
    this.aB.e().postValue(Boolean.valueOf(false));
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCaptureError. errorCode = ");
    localStringBuilder.append(paramInt);
    AEQLog.a(str, localStringBuilder.toString(), new Throwable());
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.54(this, paramInt));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2063991250: 
    case 2131437676: 
      s().getIntent().removeExtra("widgetinfo");
      return;
    case 2063991009: 
      paramView = this.aE;
      if (paramView == null) {
        return;
      }
      PressScaleAnimDelegate.a(paramView.getForegroundView(), 200L, null);
      boolean bool = this.aE.isSelected();
      int i = 1;
      bool ^= true;
      this.aE.setSelected(bool);
      c(bool);
      if (!bool) {
        this.an = true;
      } else {
        this.an = false;
      }
      ReportUtil.a(bool);
      if (!bool) {
        i = 2;
      }
      CaptureReportUtil.a(i);
      return;
    case 2063990965: 
      a(this.aD);
      return;
    }
    PressScaleAnimDelegate.a(paramView, 200L, null);
    ax();
  }
  
  public void onDetectStateChange(boolean paramBoolean1, boolean paramBoolean2)
  {
    AETipsViewController localAETipsViewController = this.ar;
    if (localAETipsViewController != null) {
      localAETipsViewController.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public void onDeviceNotSupportMaterial()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.56(this));
  }
  
  public void onHideNormalTip()
  {
    AEQLog.a(this.a, "onHideNormalTip: ");
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.43(this));
  }
  
  public void onHidePagTip()
  {
    AEQLog.a(this.a, "onHidePagTip: ");
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.45(this));
  }
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    this.aa = false;
    this.aB.e().postValue(Boolean.valueOf(false));
    if (!paramBoolean)
    {
      onCaptureError(101);
      return;
    }
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onVideoCaptured] videoInfo = ");
    localStringBuilder.append(paramLocalMediaInfo.mDuration);
    AEQLog.b(str, localStringBuilder.toString());
    AEBaseReportParam.a().b(2L);
    AEBaseDataReporter.a().d(paramLocalMediaInfo.mDuration);
    if (Y())
    {
      AEBeautyReportParam.a().a(this);
      AEBaseDataReporter.a().a(new HashMap(AEBeautyReportParam.a().b()));
    }
    else
    {
      AEBaseDataReporter.a().d(paramLocalMediaInfo.mDuration);
    }
    i(false);
    this.S.b(196609, new Object[0]);
    this.S.b(262146, new Object[] { this.o, paramLocalMediaInfo, Integer.valueOf(this.y), this.r, this.S.a(196610, new Object[0]) });
  }
  
  public void onPhotoCaptured(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    this.p = paramAEPhotoCaptureResult;
    AEBaseReportParam.a().b(1L);
    if (Y())
    {
      AEBeautyReportParam.a().a(this);
      AEBaseDataReporter.a().a(new HashMap(AEBeautyReportParam.a().b()));
    }
    else
    {
      AEBaseDataReporter.a().d(-1L);
    }
    AEQLog.b(this.a, "onPhotoCaptured---【Type】Photo");
    Object localObject1 = this.I;
    if (localObject1 != null)
    {
      localObject1 = ((AEFilterManager)localObject1).wmGetEditableWMElements();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WMElement)((Iterator)localObject1).next();
          if ("CHECK_IN".equals(((WMElement)localObject2).type)) {
            ((WMElement)localObject2).doCheckIn();
          }
        }
      }
    }
    boolean bool = ag();
    localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onPhotoCaptured---hasDefinedPhotoEditType=");
    ((StringBuilder)localObject2).append(bool);
    AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
    if (bool) {
      a(paramAEPhotoCaptureResult);
    } else {
      b(paramAEPhotoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.17(this));
  }
  
  public void onRequestChangeCamera(int paramInt, @NonNull AECameraManager.CameraOpenCallback paramCameraOpenCallback)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRequestChangeCamera---which=");
    localStringBuilder.append(paramInt);
    AEQLog.b(str, localStringBuilder.toString());
    if (this.d != null)
    {
      this.d.changeCamera(paramInt, new AEPituCameraUnit.46(this, paramCameraOpenCallback));
      return;
    }
    paramCameraOpenCallback.onOpenResult(paramInt, false);
  }
  
  public void onSelectFaceEffect(VideoMaterial paramVideoMaterial)
  {
    av();
    aO();
    if (!Z()) {
      if (paramVideoMaterial == null)
      {
        AEBaseReportParam.a().f("none");
        AEBaseReportParam.a().g("");
        AEBaseReportParam.a().h("");
      }
      else
      {
        AEBaseReportParam.a().f(paramVideoMaterial.getId());
      }
    }
    if ((paramVideoMaterial != null) && (paramVideoMaterial.isWatermarkMaterial()) && (this.I != null))
    {
      AEQLog.a(this.a, "onSelectFaceEffect: wmSetOnlineUsrCountDelegate");
      this.I.wmSetOnlineUsrCountDelegate("watermark.qq.online", new AEPituCameraUnit.35(this));
    }
    if ((paramVideoMaterial != null) && (paramVideoMaterial.isEditableWatermark()) && (!Z())) {
      s().runOnUiThread(new AEPituCameraUnit.36(this, paramVideoMaterial));
    } else {
      s().runOnUiThread(new AEPituCameraUnit.37(this, paramVideoMaterial));
    }
    AETipsViewController localAETipsViewController = this.ar;
    if (localAETipsViewController != null) {
      localAETipsViewController.a(paramVideoMaterial);
    }
  }
  
  public void onSetFilterProcess(AEFilterProcessTex paramAEFilterProcessTex)
  {
    if (paramAEFilterProcessTex != null)
    {
      AETipsViewController localAETipsViewController = this.ar;
      if (localAETipsViewController != null) {
        paramAEFilterProcessTex.a(localAETipsViewController.a());
      }
    }
    if (paramAEFilterProcessTex != null)
    {
      this.I = paramAEFilterProcessTex.h();
      return;
    }
    this.I = null;
  }
  
  public void onShowNormalTip(String paramString1, String paramString2, int paramInt)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onShowNormalTip: tip=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", icon=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(paramInt);
    AEQLog.a(str, localStringBuilder.toString());
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.42(this, paramString1, paramString2, paramInt));
  }
  
  public void onShowPagTip(String paramString, int paramInt)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onShowPagTip: pagPath=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(paramInt);
    AEQLog.a(str, localStringBuilder.toString());
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.44(this, paramString, paramInt));
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.Q;
    if (paramView != null) {
      paramView.onTouchEvent(paramMotionEvent);
    }
    if (this.i != null) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, this.i.getCaptureBtn(), this.h);
    }
    return true;
  }
  
  public void onVideoCaptureStart()
  {
    aB();
    e(8);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.15(this));
    this.S.b(196609, new Object[0]);
    this.S.b(262145, new Object[0]);
  }
  
  public void onVideoCaptured(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    this.o = paramAEVideoCaptureResult;
    this.o.finishTimeMs = System.currentTimeMillis();
    if (Z())
    {
      a(paramAEVideoCaptureResult);
    }
    else
    {
      int i = 500;
      if (this.y == 13) {
        i = 2000;
      }
      if (MediaUtil.a(paramAEVideoCaptureResult.videoMp4FilePath) < i)
      {
        this.aa = false;
        this.aB.e().postValue(Boolean.valueOf(false));
        an();
        return;
      }
      this.q = new LocalMediaInfo();
      this.q.path = paramAEVideoCaptureResult.videoMp4FilePath;
      this.q.mMimeType = "video";
      MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(this, this.q);
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.16(this));
  }
  
  protected void p()
  {
    super.p();
    this.af = this.g.findViewById(2063991108);
    this.ai = ((AEMaterialPanel)this.g.findViewById(2063991338));
    this.aj = ((AEWaterMarkPanel)this.g.findViewById(2063991339));
    this.ak = ((AEARCakePanel)this.g.findViewById(2063991337));
  }
  
  protected int w()
  {
    if (M())
    {
      int i = AEPreviewSizeUtil.b();
      if (i == 1) {
        this.w = AEVideoStoryTopBarViewModel.Ratio.R_4_3;
      } else if (i == 2) {
        this.w = AEVideoStoryTopBarViewModel.Ratio.R_4_3;
      } else {
        this.w = AEVideoStoryTopBarViewModel.Ratio.FULL;
      }
      ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this).get(AEVideoStoryTopBarViewModel.class)).a.setValue(this.w);
    }
    else if (Y())
    {
      this.w = AEVideoStoryTopBarViewModel.Ratio.fromCode(AECameraPrefsUtil.a().b("sp_key_ae_camera_ratio", AEVideoStoryTopBarViewModel.Ratio.FULL.code, 0));
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("adjustRatio defaultRatio : ");
      localStringBuilder.append(this.w);
      AEQLog.a(str, localStringBuilder.toString());
    }
    else
    {
      this.w = AEVideoStoryTopBarViewModel.Ratio.FULL;
    }
    return this.w.code;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit
 * JD-Core Version:    0.7.0.1
 */