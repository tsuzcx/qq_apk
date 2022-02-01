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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.MainThread;
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
import com.tencent.aelight.camera.ae.camera.core.AEFilterManagerHolder;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.FilterPagerViewStubHolder;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil.ABTestInfo;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil.BinaryInfo;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.IDebugInfoCallback;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel.AEARCakePanelListener;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderView;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel.AEMaterialPanelListener;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkPanel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkPanel.AEWaterMarkPanelListener;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder;
import com.tencent.aelight.camera.ae.camera.ui.tips.AETipsViewController;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.config.CameraOperationHelper;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.download.AEARCakeDownloadMaterialRunnable;
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
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aebase.ShortVideoProcessUtil;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.aioeditor.CaptureReportUtil;
import com.tencent.aelight.camera.aioeditor.QIMCaptureVarManager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
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
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.qqstory.api.IAsyncControl;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.filter.QQFilterRenderManagerHolder;
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
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.filter.CosFunHelper;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import dov.com.qq.im.ae.current.SessionWrap;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.light.bean.WMElement;
import org.light.listener.IOnClickWatermarkListener;

@TargetApi(9)
public class AEPituCameraUnit
  extends AEBaseCameraUnit
  implements View.OnClickListener, View.OnTouchListener, AEFilterManager.MaterialInnerEffectListener, AECameraGLSurfaceView.AEEffectListener, AEVideoStoryDashboardPart.IDebugInfoCallback, AEPituCameraCaptureButtonLayout.PituCaptureButtonListener, VideoFilterTools.OnResourceDownloadListener, MediaScanner.OnMediaInfoScannerListener, DarkModeChecker.DarkModeListener
{
  public static boolean f = false;
  public static boolean g = false;
  private long jdField_a_of_type_Long = 0L;
  protected GestureDetector a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected AEFilterManager a;
  private AEPituCameraUnit.ViewStubHoldersViewModel jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit$ViewStubHoldersViewModel;
  private AECameraBroadcastReceiver jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraBroadcastReceiver = new AECameraBroadcastReceiver(this);
  protected final AECameraGLSurfaceView.AEGLSurfaceListener a;
  protected final AECameraManager.CameraManagerListener a;
  protected AECaptureController a;
  protected FilterPagerViewStubHolder a;
  protected AEARCakePanel.AEARCakePanelListener a;
  protected AEARCakePanel a;
  protected AEMaterialPanel.AEMaterialPanelListener a;
  protected AEMaterialPanel a;
  protected AEWaterMarkPanel.AEWaterMarkPanelListener a;
  protected AEWaterMarkPanel a;
  private BeautyAndFilterPanelViewStubHolder jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelBeautyAndFilterPanelViewStubHolder;
  private AETipsViewController jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsAETipsViewController;
  protected CameraProviderViewGesture a;
  protected CameraTriggerGesture a;
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel;
  private AEVideoStoryStateViewModel jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel;
  protected VideoStoryCapturePartManager a;
  private AECompoundButton jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton;
  protected CameraFocusGesture.FocusGestureListener a;
  protected CameraFocusGesture a;
  protected CameraSwitchGesture.CameraSwitchGestureListener a;
  protected CameraSwitchGesture a;
  protected CameraViewPagerGesture a;
  protected CameraZoomGesture.ZoomGestureListener a;
  protected CameraZoomGesture a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  private IOnClickWatermarkListener jdField_a_of_type_OrgLightListenerIOnClickWatermarkListener;
  private long jdField_b_of_type_Long = -1L;
  protected View b;
  private AECompoundButton jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton;
  protected int c;
  private View c;
  protected int d;
  private boolean d;
  private int e;
  protected boolean e;
  private int f;
  private boolean h;
  private boolean i = false;
  private boolean j = false;
  private boolean k = AEThemeUtil.a();
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o = false;
  
  public AEPituCameraUnit()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager$CameraManagerListener = new AEPituCameraUnit.1(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener = new AEPituCameraUnit.2(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener = new AEPituCameraUnit.3(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener = new AEPituCameraUnit.4(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture$FocusGestureListener = new AEPituCameraUnit.5(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture$ZoomGestureListener = new AEPituCameraUnit.6(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture$CameraSwitchGestureListener = new AEPituCameraUnit.7(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView$AEGLSurfaceListener = new AEPituCameraUnit.8(this);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "[AEPituCameraUnit] + BEGIN");
    AEQLog.a(this.jdField_a_of_type_JavaLangString, "unitConstructor--fake");
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "[AEPituCameraUnit] + END");
  }
  
  public AEPituCameraUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager$CameraManagerListener = new AEPituCameraUnit.1(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener = new AEPituCameraUnit.2(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener = new AEPituCameraUnit.3(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener = new AEPituCameraUnit.4(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture$FocusGestureListener = new AEPituCameraUnit.5(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture$ZoomGestureListener = new AEPituCameraUnit.6(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture$CameraSwitchGestureListener = new AEPituCameraUnit.7(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView$AEGLSurfaceListener = new AEPituCameraUnit.8(this);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "[AEPituCameraUnit] + BEGIN");
    long l1 = System.currentTimeMillis();
    AELaunchRecorder.a().a("unitConstructor-begin");
    paramIQIMCameraContainer = this.jdField_a_of_type_JavaLangString;
    paramICameraEntrance = new StringBuilder();
    paramICameraEntrance.append("AEPituCameraUnit: cameraConfig.getFrom() =");
    paramICameraEntrance.append(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.i());
    Log.d(paramIQIMCameraContainer, paramICameraEntrance.toString());
    this.jdField_b_of_type_Int = 11;
    if (AECameraEntry.J.a(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.i()))
    {
      this.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureEntranceParams = new CaptureEntranceParams(10000, 100, 15);
    }
    else if (l())
    {
      this.jdField_b_of_type_Int = 13;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureEntranceParams = new CaptureEntranceParams(10023, this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.d(), this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.a());
    }
    else if (!AECameraEntry.e.a(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.i()))
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.b().intValue();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureEntranceParams = new CaptureEntranceParams(this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().getIntent().getIntExtra("edit_video_type", 10002), this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.d(), this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.a());
    }
    else
    {
      this.jdField_b_of_type_Int = 1;
    }
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "[AEPituCameraUnit] submit unit init");
    A();
    paramIQIMCameraContainer = this.jdField_a_of_type_JavaLangString;
    paramICameraEntrance = new StringBuilder();
    paramICameraEntrance.append("[AEPituCameraUnit] + END, time cost = ");
    paramICameraEntrance.append(System.currentTimeMillis() - l1);
    AEQLog.b(paramIQIMCameraContainer, paramICameraEntrance.toString());
  }
  
  private Intent a(Activity paramActivity, PublishParam paramPublishParam, Intent paramIntent)
  {
    paramActivity = ((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).generateReadInJoyIntent(paramActivity, paramIntent);
    if (paramPublishParam != null)
    {
      paramActivity.putExtra(PublishParam.jdField_a_of_type_JavaLangString, paramPublishParam);
      paramActivity.putExtra("arg_video_duration", paramPublishParam.jdField_a_of_type_Long);
      paramActivity.putExtra("arg_video_path", paramPublishParam.j);
      paramActivity.putExtra("arg_video_cover", paramPublishParam.c);
      paramActivity.putExtra("arg_video_width", paramPublishParam.jdField_a_of_type_Int);
      paramActivity.putExtra("arg_video_height", paramPublishParam.jdField_b_of_type_Int);
    }
    return paramActivity;
  }
  
  private AECaptureMode a(AECaptureMode[] paramArrayOfAECaptureMode, int paramInt)
  {
    String str = a().getIntent().getStringExtra("KEY_CURRENT_TAB");
    int i1;
    if (TextUtils.isEmpty(str))
    {
      i1 = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", -1);
      if ((paramInt == 201) && (AECameraEntry.c.a() == i1)) {
        return AECaptureMode.PLAY;
      }
      if ((paramInt == 204) && (AECameraEntryManager.c(i1))) {
        str = AECameraPrefsUtil.a().a("app_alg_entrance_qzone_id_from833", "", 4);
      } else {
        str = null;
      }
    }
    Object localObject2 = AECaptureMode.fromName(str);
    if (localObject2 != null)
    {
      i1 = paramArrayOfAECaptureMode.length;
      paramInt = 0;
      while (paramInt < i1)
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
      localObject1 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getFirstModeAccordingABTest], get invalid mode=");
      localStringBuilder.append(localObject2);
      AEQLog.d((String)localObject1, localStringBuilder.toString());
      localObject1 = paramArrayOfAECaptureMode[0];
    }
    paramArrayOfAECaptureMode = this.jdField_a_of_type_JavaLangString;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[getFirstModeAccordingABTest], ABTest name=");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(", real picked mode=");
    ((StringBuilder)localObject2).append(localObject1);
    AEQLog.b(paramArrayOfAECaptureMode, ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  private String a()
  {
    if (l()) {
      return AECameraPrefsUtil.a().a("circle_camera_ad_activity_id", "", 4);
    }
    return AECameraPrefsUtil.a().a("camera_ad_activity_id", "", 4);
  }
  
  private void a(@Nullable AECaptureMode paramAECaptureMode1, @NonNull AECaptureMode paramAECaptureMode2)
  {
    this.jdField_b_of_type_ComTencentAelightCameraAeModeAECaptureMode = paramAECaptureMode2;
    if (paramAECaptureMode1 == paramAECaptureMode2) {
      return;
    }
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCaptureModeChanged---from ");
    localStringBuilder.append(paramAECaptureMode1);
    localStringBuilder.append(" to ");
    localStringBuilder.append(paramAECaptureMode2);
    AEQLog.b(str, localStringBuilder.toString());
    b(paramAECaptureMode1, paramAECaptureMode2);
    paramAECaptureMode1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture;
    if (paramAECaptureMode1 != null) {
      paramAECaptureMode1.a();
    }
    paramAECaptureMode1 = this.jdField_b_of_type_ComTencentAelightCameraAeModeAECaptureMode;
    paramAECaptureMode2 = AECaptureMode.GIF;
    boolean bool2 = true;
    boolean bool1;
    if (paramAECaptureMode1 == paramAECaptureMode2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    AEBaseReportParam.a().b(bool1);
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setIsGIFMode(bool1);
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.26(this));
    paramAECaptureMode1 = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiFilterPagerViewStubHolder;
    if (this.jdField_b_of_type_ComTencentAelightCameraAeModeAECaptureMode == AECaptureMode.NORMAL) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    paramAECaptureMode1.c(bool1);
    if (!this.jdField_b_of_type_ComTencentAelightCameraAeModeAECaptureMode.shouldStartCamera())
    {
      paramAECaptureMode1 = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsAETipsViewController;
      if (paramAECaptureMode1 != null) {
        paramAECaptureMode1.b();
      }
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraProviderViewGesture);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraTriggerGesture);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture);
      return;
    }
    if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraProviderViewGesture)) {
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraProviderViewGesture);
    }
    if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture)) {
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture);
    }
    if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraTriggerGesture)) {
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraTriggerGesture);
    }
    if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture)) {
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture);
    }
    if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraTriggerGesture)) {
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraTriggerGesture);
    }
    if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture)) {
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture);
    }
    if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture)) {
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture);
    }
  }
  
  private void a(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    int i1 = this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.f();
    if (i1 != -2)
    {
      if (i1 != 0)
      {
        Object localObject;
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3)
            {
              paramAEPhotoCaptureResult = this.jdField_a_of_type_JavaLangString;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("sendPhotoEndByConfig---unknown type: ");
              ((StringBuilder)localObject).append(i1);
              AEQLog.d(paramAEPhotoCaptureResult, ((StringBuilder)localObject).toString());
            }
          }
          else {
            this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(262148, new Object[] { paramAEPhotoCaptureResult, this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.b(), Integer.valueOf(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.a()) });
          }
        }
        else
        {
          localObject = new CapturePicParams.CapturePicParamsBuilder(this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.getSelectedCamera()).a(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.a()).a(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.a()).a(1).a();
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureEntranceParams.a((CapturePicParams)localObject);
          this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(262148, new Object[] { paramAEPhotoCaptureResult, this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureEntranceParams, this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.b() });
          return;
        }
      }
      this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(262148, new Object[] { paramAEPhotoCaptureResult });
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(262148, new Object[] { paramAEPhotoCaptureResult });
  }
  
  private void a(LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable)
  {
    S();
    if (paramLazyLoadAnimationDrawable == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable = new AEPituCameraUnit.27(this);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.28(this, paramLazyLoadAnimationDrawable));
  }
  
  private boolean a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if ((paramAEMaterialMetaData != null) && (paramAEMaterialMetaData.jdField_c_of_type_Boolean))
    {
      paramAEMaterialMetaData = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
      if ((paramAEMaterialMetaData != null) && (paramAEMaterialMetaData.wmGetEditableWMElements() != null) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.wmGetEditableWMElements().size() > 0)) {
        return true;
      }
    }
    return false;
  }
  
  private long b()
  {
    long l1;
    try
    {
      l1 = Utils.b();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      l1 = 9223372036854775807L;
    }
    l1 >>>= 20;
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("available size = ");
    localStringBuilder.append(l1);
    localStringBuilder.append("M");
    QLog.d(str, 4, localStringBuilder.toString());
    return l1 / 30L;
  }
  
  private String b()
  {
    return AECameraPrefsUtil.a().a("camera_ad_pendent_activity_id", "", 4);
  }
  
  private void b(@Nullable AECaptureMode paramAECaptureMode1, @NonNull AECaptureMode paramAECaptureMode2)
  {
    if ((paramAECaptureMode1 != null) && (paramAECaptureMode1.shouldStartCamera())) {
      k();
    }
    if (!paramAECaptureMode2.shouldStartCamera())
    {
      b(false);
      return;
    }
    int i1;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.g() == 0) {
      i1 = CameraHelper.a();
    } else {
      i1 = this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.g();
    }
    if (paramAECaptureMode2 == AECaptureMode.GIF) {
      i1 = 1;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.setSelectedCamera(i1);
      return;
    }
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.changeCamera(i1, new AEPituCameraUnit.41(this));
  }
  
  private void b(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    Object localObject = a().getIntent();
    if (AECameraEntryManager.k((Intent)localObject))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(262148, new Object[] { paramAEPhotoCaptureResult });
      return;
    }
    if ((!AECameraEntryManager.g((Intent)localObject)) && (!AECameraEntryManager.l((Intent)localObject)))
    {
      if (AECameraEntryManager.n((Intent)localObject))
      {
        h(true);
        this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(262148, new Object[] { paramAEPhotoCaptureResult, this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureEntranceParams, Integer.valueOf(this.jdField_b_of_type_Int) });
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(262148, new Object[] { paramAEPhotoCaptureResult, this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.b(), Integer.valueOf(14) });
      return;
    }
    localObject = new CapturePicParams.CapturePicParamsBuilder(this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.getSelectedCamera()).a(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.a()).a(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.a()).a(1).b(((Intent)localObject).getIntExtra("qq_sub_business_id", -1)).a();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureEntranceParams.a((CapturePicParams)localObject);
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(262148, new Object[] { paramAEPhotoCaptureResult, this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureEntranceParams, Integer.valueOf(this.jdField_b_of_type_Int) });
  }
  
  private int c()
  {
    int i1 = AEPreviewSizeUtil.a();
    int i2 = ImmersiveUtils.getStatusBarHeight(a());
    int i3 = a().getResources().getDimensionPixelSize(2063990794);
    if (i1 == 1)
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getSurfaceTopMargin] long screen:");
      i1 = i2 + i3;
      localStringBuilder.append(i1);
      AEQLog.a(str, localStringBuilder.toString());
      return i1;
    }
    AEQLog.a(this.jdField_a_of_type_JavaLangString, "[getSurfaceTopMargin]:0");
    return 0;
  }
  
  private void i(boolean paramBoolean)
  {
    AECompoundButton localAECompoundButton;
    if (paramBoolean)
    {
      if (!this.o)
      {
        localAECompoundButton = this.jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton;
        if (localAECompoundButton != null)
        {
          localAECompoundButton.setVisibility(0);
          this.jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton.setSelected(true);
        }
        c(true);
        this.o = false;
        AEQLog.b(this.jdField_a_of_type_JavaLangString, "【Dark Mode】Start");
      }
    }
    else
    {
      localAECompoundButton = this.jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton;
      if (localAECompoundButton != null)
      {
        localAECompoundButton.setVisibility(8);
        this.jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton.setSelected(false);
      }
      c(false);
      this.o = false;
    }
  }
  
  private boolean o()
  {
    return (!this.m) && (!this.l) && (!this.n);
  }
  
  private void s()
  {
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer != null))
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a() != null)
      {
        if (!AECameraEntryManager.k(this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().getIntent())) {
          return;
        }
        VideoReport.setPageId(this.jdField_c_of_type_AndroidViewView, "pg_xsj_shooting_page");
        VideoReport.setPageParams(this.jdField_c_of_type_AndroidViewView, new QCircleDTParamBuilder().buildPageParams(this.jdField_a_of_type_JavaLangString));
        String str = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportDaTongRegister  subPage: ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        QLog.i(str, 1, localStringBuilder.toString());
      }
      return;
    }
    QLog.e(this.jdField_a_of_type_JavaLangString, 1, "reportDaTongRegister  view == null || mContainer == null");
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.i() != AECameraEntry.x.a())
    {
      String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
      if (AECameraEntry.a(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.i()).a()) {
        AEBaseReportParam.a().a(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.i(), str);
      }
      str = a().getIntent().getStringExtra("intent_key_uid_for_report");
      AEBaseReportParam.a().c(str);
      AEBaseReportParam.a().a(true);
      AEBaseReportParam.a().b();
      AEBaseReportParam.a().a();
      AEBaseReportParam.a().d(CameraOperationHelper.a(a()));
    }
    AEBaseDataReporter.a().af();
    if (AECameraEntry.e.a(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.i())) {
      StoryReportor.a("check_Android", AECameraEntry.e.a(), 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager != null)
    {
      float f1 = this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.getHorizontalViewAngle();
      if (f1 != -1.0F) {
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.updateCameraHorizontalViewAngle(f1);
      }
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      if ((!this.l) && (!this.m) && (!this.n))
      {
        AEQLog.b(this.jdField_a_of_type_JavaLangString, "checkSetOnClickWatermarkListener--PASS, no panel is showing");
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.wmSetOnClickWatermarkListener(this.jdField_a_of_type_OrgLightListenerIOnClickWatermarkListener);
        return;
      }
      AEQLog.b(this.jdField_a_of_type_JavaLangString, "checkSetOnClickWatermarkListener--FAIL, some panel is showing");
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.wmSetOnClickWatermarkListener(null);
    }
  }
  
  private void w()
  {
    this.jdField_a_of_type_JavaUtilHashMap = null;
  }
  
  private void y()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView == null) && (this.jdField_a_of_type_AndroidViewViewStub != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = ((CameraFocusView)this.jdField_a_of_type_AndroidViewViewStub.inflate());
    }
  }
  
  protected void A()
  {
    ThreadManager.excute(new AEPituCameraUnit.9(this), 16, null, true);
  }
  
  @NotNull
  protected void B()
  {
    if (!this.jdField_b_of_type_ComTencentAelightCameraAeModeAECaptureMode.shouldStartCamera())
    {
      Y();
      if (l())
      {
        ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2064122646);
        if (localViewStub != null)
        {
          localViewStub.inflate();
          AEQLog.b(this.jdField_a_of_type_JavaLangString, "AEPartAction--inflate bottom");
        }
      }
      this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a();
      int i1 = this.jdField_e_of_type_Int;
      if ((i1 > 0) && (this.jdField_f_of_type_Int > 0)) {
        this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(851973, new Object[] { Arrays.asList(new Integer[] { Integer.valueOf(i1), Integer.valueOf(this.jdField_f_of_type_Int) }) });
      }
    }
  }
  
  public void C()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCaptureButtonVideoStop: thread = ");
    localStringBuilder.append(Thread.currentThread().getName());
    Log.d(str, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.stopCaptureVideo();
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.stopRecordVideo();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.e().postValue(Boolean.valueOf(false));
    ((CaptureComboManager)QIMManager.a(5)).a(false);
    c(0);
  }
  
  public void D()
  {
    W();
  }
  
  public void E()
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.e().postValue(Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.resetMaterialWhenRecord();
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.isFlashEnabled()) && (this.jdField_b_of_type_ComTencentAelightCameraAeModeAECaptureMode != AECaptureMode.GIF)) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.turnFlash(a(), true);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.startCaptureVideo();
    if (!this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.isFrontCamera()) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.setFocusModeRecording();
    }
    ((CaptureComboManager)QIMManager.a(5)).a(true);
  }
  
  public void F()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(786435, new Object[0]);
  }
  
  public void G()
  {
    M();
  }
  
  public void H()
  {
    QIMCaptureVarManager localQIMCaptureVarManager = (QIMCaptureVarManager)QIMManager.a(13);
    if (AECameraEntry.e.a(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.i()))
    {
      localQIMCaptureVarManager.b(14);
      return;
    }
    localQIMCaptureVarManager.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureEntranceParams.jdField_c_of_type_Int);
  }
  
  public void I()
  {
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "onActivityStart");
    super.I();
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager;
    if (localObject != null) {
      ((VideoStoryCapturePartManager)localObject).d();
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    AEBaseDataReporter.a().I();
    if (m()) {
      AEBaseDataReporter.a().i();
    }
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityStart, ID=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      AEQLog.a((String)localObject, localStringBuilder.toString());
    }
  }
  
  public void J()
  {
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "onActivityStop");
    super.J();
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.e();
    AEBaseDataReporter.a().c(this.jdField_b_of_type_Long);
    if (QLog.isDevelopLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityStop, ID=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      AEQLog.a(str, localStringBuilder.toString());
    }
  }
  
  public void K()
  {
    super.K();
  }
  
  protected void L()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton;
    if (localObject != null) {
      PressScaleAnimDelegate.a(((AECompoundButton)localObject).a(), 200L, null);
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton != null) {
      if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.isFrontCamera())
      {
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton;
        ((AECompoundButton)localObject).setContentDescription(((AECompoundButton)localObject).getResources().getString(2064515412));
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton;
        ((AECompoundButton)localObject).setContentDescription(((AECompoundButton)localObject).getResources().getString(2064515413));
      }
    }
    if (!f())
    {
      AEBaseDataReporter.a().M();
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("【Change Camera】:isFrontCamera:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.isFrontCamera());
      AEQLog.b((String)localObject, localStringBuilder.toString());
    }
    h();
    if (l()) {
      AEReportUtils.b(13, null);
    }
  }
  
  protected void M()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.17(this));
  }
  
  protected void N()
  {
    if (j())
    {
      P();
      return;
    }
    if (k()) {
      O();
    }
  }
  
  protected void O()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", false);
    a().sendBroadcast(localIntent);
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(131076, new Object[0]);
  }
  
  protected void P()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", true);
    a().sendBroadcast(localIntent);
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(131077, new Object[0]);
  }
  
  protected void Q()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit$ViewStubHoldersViewModel = ((AEPituCameraUnit.ViewStubHoldersViewModel)AEViewModelProviders.a(this).get(AEPituCameraUnit.ViewStubHoldersViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this).get(AEVideoStoryCaptureModeViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.a.observe(this, new AEPituCameraUnit.20(this));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this).get(AEVideoStoryStateViewModel.class));
    ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this).get(AEVideoStoryTopBarViewModel.class)).a.observe(this, new AEPituCameraUnit.21(this));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.e().observe(this, new AEPituCameraUnit.22(this));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.d().observe(this, new AEPituCameraUnit.23(this));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.b().observe(this, new AEPituCameraUnit.24(this));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.c().observe(this, new AEPituCameraUnit.25(this));
  }
  
  public void R()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton != null) {
      if (CameraUtils.d()) {
        this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.setVisibility(0);
      } else {
        this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton.setVisibility(4);
      }
    }
    AECompoundButton localAECompoundButton;
    if (GLVideoClipUtil.a())
    {
      localAECompoundButton = this.jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton;
      if (localAECompoundButton != null) {
        localAECompoundButton.setVisibility(0);
      }
    }
    else
    {
      localAECompoundButton = this.jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton;
      if ((localAECompoundButton != null) && (this.o))
      {
        localAECompoundButton.setVisibility(0);
        this.jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton.setSelected(false);
      }
    }
    f(true);
    AEBaseReportParam.a().j();
    AEBaseDataReporter.a().ae();
    if ((!this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.c()) && (this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton != null)) {
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton.setVisibility(0);
    }
    if (o()) {
      AECircleMultiUnit.a(true, a());
    }
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.a().postValue(Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(851971, new Object[0]);
  }
  
  protected void S()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.29(this));
    }
  }
  
  public void T()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().onBackPressed();
  }
  
  public void U()
  {
    a().getIntent().removeExtra("widgetinfo");
    PicChooseJumpUtil.a(a());
  }
  
  protected void V()
  {
    AECircleMultiUnit.a(false, a());
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.a().postValue(Boolean.valueOf(false));
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(851972, new Object[0]);
  }
  
  public void W()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsAETipsViewController;
    if (localObject != null) {
      ((AETipsViewController)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeViewAECompoundButton;
    if (localObject != null) {
      ((AECompoundButton)localObject).setVisibility(8);
    }
    AECircleMultiUnit.a(false, a());
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.a().postValue(Boolean.valueOf(false));
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(851972, new Object[0]);
  }
  
  protected void X()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraProviderViewGesture = new CameraProviderViewGesture();
    this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraProviderViewGesture.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel);
    this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraProviderViewGesture.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel);
    this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraProviderViewGesture.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel);
    this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraProviderViewGesture.a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraProviderViewGesture.a(new AEPituCameraUnit.42(this));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture = new CameraZoomGesture(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture$ZoomGestureListener);
    AECameraGLSurfaceView localAECameraGLSurfaceView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView;
    int i1;
    if (l()) {
      i1 = c();
    } else {
      i1 = 0;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraTriggerGesture = new CameraTriggerGesture(localAECameraGLSurfaceView, i1);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture = new CameraFocusGesture(a(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture$FocusGestureListener);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture = new CameraSwitchGesture(this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.getContext(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture$CameraSwitchGestureListener);
  }
  
  @MainThread
  protected void Y()
  {
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "setCaptureModeViewModel---");
    AEVideoStoryCaptureModeViewModel localAEVideoStoryCaptureModeViewModel = (AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this).get(AEVideoStoryCaptureModeViewModel.class);
    localAEVideoStoryCaptureModeViewModel.a.setValue(new AECaptureModeChangingEvent(null, this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.a(), 1));
    localAEVideoStoryCaptureModeViewModel.b.setValue(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.a());
  }
  
  public void Z()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.a();
  }
  
  protected int a()
  {
    if (l()) {
      return 2064318523;
    }
    return 2064318522;
  }
  
  protected long a()
  {
    return 5L;
  }
  
  protected BroadcastReceiver a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraBroadcastReceiver;
  }
  
  public View a()
  {
    this.jdField_c_of_type_AndroidViewView = super.a();
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController = a();
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager = new VideoStoryCapturePartManager(this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a(), this.jdField_a_of_type_AndroidViewView, this);
    ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this).get(AEVideoStoryTopBarViewModel.class)).a.setValue(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
    aa();
    B();
    Q();
    X();
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel;
    if (localObject1 != null)
    {
      ((AEMaterialPanel)localObject1).setMaterialPanelListener(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel.setVisibility(8);
    }
    localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel;
    if (localObject1 != null) {
      ((AEWaterMarkPanel)localObject1).setMaterialPanelListener(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener);
    }
    localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel;
    if (localObject1 != null) {
      ((AEARCakePanel)localObject1).setMaterialPanelListener(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel$AEARCakePanelListener, m());
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(a(), new AEPituCameraUnit.AEGestureListener(this), null, true);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsAETipsViewController = new AETipsViewController(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiFilterPagerViewStubHolder = new FilterPagerViewStubHolder((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2064122652));
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit$ViewStubHoldersViewModel.b.postValue(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiFilterPagerViewStubHolder);
    localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiFilterPagerViewStubHolder;
    boolean bool;
    if (this.jdField_b_of_type_ComTencentAelightCameraAeModeAECaptureMode == AECaptureMode.NORMAL) {
      bool = true;
    } else {
      bool = false;
    }
    ((FilterPagerViewStubHolder)localObject1).a(bool);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelBeautyAndFilterPanelViewStubHolder = new BeautyAndFilterPanelViewStubHolder((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2064122644));
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit$ViewStubHoldersViewModel.a.setValue(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelBeautyAndFilterPanelViewStubHolder);
    CosFunHelper.setCountDownListener(new AEPituCameraUnit.12(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelBeautyAndFilterPanelViewStubHolder.a(this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraProviderViewGesture);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiFilterPagerViewStubHolder.a();
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onCreateView needLiuHaiTop:");
      ((StringBuilder)localObject2).append(bool);
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    localObject1 = a().getIntent().getStringExtra("key_guide_image");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = Base64.a(((String)localObject1).substring(22));
      localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
      if (BitmapUtils.isLegal((Bitmap)localObject1))
      {
        localObject2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2064121982);
        ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
        ((ImageView)localObject2).setVisibility(0);
      }
    }
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "[UnitAsyncInit] before await");
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await(1000L, TimeUnit.MILLISECONDS);
    }
    catch (InterruptedException localInterruptedException)
    {
      localObject2 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UnitAsyncInit] await interrupt exp: ");
      localStringBuilder.append(localInterruptedException.getMessage());
      AEQLog.d((String)localObject2, localStringBuilder.toString());
    }
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "[UnitAsyncInit] after await");
    s();
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  protected AECaptureParam a()
  {
    Intent localIntent = a().getIntent();
    boolean bool = AECameraEntryManager.j(localIntent);
    int i2 = 1;
    int i1;
    if (bool)
    {
      if (!localIntent.getBooleanExtra("key_camera_prefer_id", false))
      {
        i1 = i2;
        if (CameraUtils.d()) {}
      }
      else
      {
        i1 = 2;
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.g() == 0) {
        i1 = CameraHelper.a();
      } else {
        i1 = this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.g();
      }
      if ((this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode == AECaptureMode.GIF) && (CameraUtils.d())) {
        i1 = i2;
      }
    }
    if (MediaCodecDPC.m()) {
      return DovSVParamManager.a().a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a(), i1);
    }
    return DovSVParamManager.a().a(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig);
  }
  
  protected AECameraManager.CameraManagerListener a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager$CameraManagerListener;
  }
  
  public AECaptureController a()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController == null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController = new AECaptureController(this.jdField_a_of_type_AndroidViewView, this);
    }
    return this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController;
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
      localAECaptureMode = a(this.jdField_a_of_type_ArrayOfComTencentAelightCameraAeModeAECaptureMode, paramInt);
      break;
    case 202: 
    case 203: 
      localAECaptureMode = AECaptureMode.GIF;
      break;
    case 201: 
      localAECaptureMode = a(this.jdField_a_of_type_ArrayOfComTencentAelightCameraAeModeAECaptureMode, paramInt);
    }
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initCaptureModesAndFirstMode---initialMode=");
    localStringBuilder.append(localAECaptureMode);
    localStringBuilder.append(", initialCModes=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfComTencentAelightCameraAeModeAECaptureMode));
    AEQLog.b(str, localStringBuilder.toString());
    return localAECaptureMode;
  }
  
  protected DarkModeChecker.DarkModeListener a()
  {
    return this;
  }
  
  public HashMap<String, String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public List<WMElement> a()
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager == null) {
      return Collections.emptyList();
    }
    return localAEFilterManager.wmGetEditableWMElements();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.13(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.e();
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "notifyPreviewSizeChanged: ");
    this.jdField_e_of_type_Int = paramInt1;
    this.jdField_f_of_type_Int = paramInt2;
    VideoStoryCapturePartManager localVideoStoryCapturePartManager = this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager;
    if (localVideoStoryCapturePartManager != null) {
      localVideoStoryCapturePartManager.a(851973, new Object[] { Arrays.asList(new Integer[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }) });
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onActivityResult:requestCode=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" resultCode=");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(" data=");
      ((StringBuilder)localObject2).append(paramIntent);
      ((StringBuilder)localObject2).append(" publishStoryFlag=");
      ((StringBuilder)localObject2).append(jdField_f_of_type_Boolean);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a();
    ReportUtil.a((Activity)localObject2, paramInt1, paramInt2);
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
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
        if ((paramInt1 == 1025) && (paramInt2 == -1) && (paramIntent != null))
        {
          localObject1 = paramIntent.getStringExtra("file_send_path");
          long l1 = paramIntent.getLongExtra("file_send_duration", -1L);
          localObject3 = paramIntent.getStringExtra("widgetinfo");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (l1 > 0L))
          {
            paramIntent = new Intent((Context)localObject2, SendVideoActivity.class);
            paramIntent.putExtra("file_send_path", (String)localObject1);
            paramIntent.putExtra("file_send_size", new File((String)localObject1).length());
            paramIntent.putExtra("file_send_duration", l1);
            paramIntent.putExtra("uin", this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.a().jdField_a_of_type_JavaLangString);
            paramIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.a().jdField_a_of_type_Int);
            paramIntent.putExtra("file_source", "album");
            paramIntent.putExtra("start_init_activity_after_sended", false);
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              paramIntent.putExtra("widgetinfo", (String)localObject3);
            }
            ((Activity)localObject2).startActivity(paramIntent);
            ((Activity)localObject2).finish();
            return;
          }
        }
        if ((paramInt1 == 10013) && (paramInt2 == -1) && (paramIntent != null))
        {
          localObject1 = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
          localObject3 = (QimMusicPlayer)QIMManager.a().c(8);
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
        AEQLog.a(this.jdField_a_of_type_JavaLangString, String.format("onActivityResult, requestCode=%d, resultCode=%d, data=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent }));
        if (paramInt1 == 10020)
        {
          if (paramInt2 == -1)
          {
            ((Activity)localObject2).setResult(paramInt2, paramIntent);
            ((Activity)localObject2).finish();
          }
          return;
        }
        if ((paramIntent == null) && (paramInt2 == 0) && (jdField_f_of_type_Boolean))
        {
          jdField_f_of_type_Boolean = false;
          return;
        }
        if ((paramInt2 == -1) && ((paramInt1 == 10006) || (paramInt1 == 1012))) {
          this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.i();
        }
        localObject1 = null;
        if (paramInt2 == 0) {
          QQFilterRenderManagerHolder.a(null);
        }
        if ((paramIntent != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.a() != null)) {
          paramIntent.putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.a().a());
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
          localObject3 = a().getIntent();
          if (localObject3 != null) {
            localObject1 = ((Intent)localObject3).getStringExtra("KEY_SEND_ARK_MSG_ID");
          }
          localObject3 = this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.a();
          String str = this.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onActivityResult: edit video finish, arkId=");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(", session is null=");
          if (localObject3 == null) {
            bool1 = bool3;
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
          ShortVideoProcessUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a(), paramIntent, this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingICameraEntrance);
          return;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(paramInt1, paramInt2, paramIntent);
        return;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramIntent = this.jdField_a_of_type_JavaLangString;
      bool1 = bool2;
      if (localObject2 == null) {
        bool1 = true;
      }
      QLog.d(paramIntent, 2, new Object[] { "activity is finishing, ", Boolean.valueOf(bool1) });
    }
  }
  
  protected void a(int paramInt, AEFilterManager paramAEFilterManager)
  {
    VideoStoryCapturePartManager localVideoStoryCapturePartManager = this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager;
    if (localVideoStoryCapturePartManager != null) {
      localVideoStoryCapturePartManager.a(196617, new Object[] { Integer.valueOf(paramInt), paramAEFilterManager });
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = (AEMaterialManager)AEQIMManager.a().b(1);
    if ((localObject != null) && (paramInt >= 0))
    {
      ((AEMaterialManager)localObject).a(false);
      localObject = ((AEMaterialManager)localObject).a(paramInt, paramString, l());
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("entry dynamics: aeMaterialMetaData");
      localStringBuilder.append(localObject);
      AEQLog.a(str, localStringBuilder.toString());
      if (localObject == null)
      {
        QQToast.a(a(), 2064515088, 1).a();
        return;
      }
      if (TextUtils.isEmpty(((AEMaterialMetaData)localObject).k)) {
        AEQLog.a(this.jdField_a_of_type_JavaLangString, "entry dynamics: category is exit but id is null");
      }
      AEBaseReportParam.a().a(paramString, b());
      AECircleMultiUnit.a(false, a());
      a().a(true, 150);
      this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(327683, new Object[] { localObject });
      this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(196612, new Object[0]);
      return;
    }
    QQToast.a(a(), 2064515088, 1).a();
  }
  
  protected void a(long paramLong)
  {
    Intent localIntent = new Intent(a(), AEStoryGIFPreviewActivity.class);
    localIntent.putExtra("KEY_PREVIEW_SOURCE_PATH", this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEVideoCaptureResult.videoMp4FilePath);
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
      localIntent.putExtra("ARG_GIF_MATERIAL_ID", localAEMaterialWrapper.jdField_a_of_type_JavaLangString);
    }
    localIntent.putExtra("KEY_AVAILABLE_SAVENAME", (String)((AEVideoStoryGIFTplViewModel)localObject).c().getValue());
    localIntent.putExtra("ARG_SESSION_INFO", this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.a());
    localObject = (String)((AEVideoStoryGIFTplViewModel)localObject).d().getValue();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localIntent.putExtra("KEY_FONT_ID", (String)localObject);
    }
    localObject = a().getIntent();
    boolean bool1 = bool2;
    if (!AECameraEntryManager.g((Intent)localObject)) {
      if (AECameraEntryManager.h((Intent)localObject)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    localIntent.putExtra("ARG_GIF_SEND_TO_AIO", bool1);
    localObject = a();
    if (localObject != null)
    {
      localIntent.putExtra("AECAMERA_MODE", this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.j());
      localIntent.putExtra("VIDEO_STORY_FROM_TYPE", this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.i());
      ((Activity)localObject).startActivityForResult(localIntent, 101);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    AEQLog.a(this.jdField_a_of_type_JavaLangString, "[AE Profiler] AEPituCameraUnit onCreate");
    long l1 = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    AEBaseReportParam.a().c(l1);
    super.a(paramBundle);
    jdField_f_of_type_Boolean = false;
    VideoFilterTools.a().b(false);
    this.jdField_a_of_type_OrgLightListenerIOnClickWatermarkListener = new AEPituCameraUnit.10(this);
    if (m())
    {
      AEQLog.a(this.jdField_a_of_type_JavaLangString, "[arcake] AEPituCameraUnit onCreate~~~~");
      ThreadManager.getSubThreadHandler().post(new AEARCakeDownloadMaterialRunnable());
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton != null) && ((this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton instanceof AEPituCameraCaptureButtonLayout))) {
      ((AEPituCameraCaptureButtonLayout)this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton).a(paramMotionEvent);
    }
  }
  
  public void a(AECaptureMode paramAECaptureMode)
  {
    this.jdField_b_of_type_ComTencentAelightCameraAeModeAECaptureMode = paramAECaptureMode;
  }
  
  protected void a(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramAEVideoCaptureResult.videoFrameCount < a())
    {
      if (QLog.isColorLevel())
      {
        paramAEVideoCaptureResult = this.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onVideoCaptured. videoFrameCount = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEVideoCaptureResult.videoFrameCount);
        ((StringBuilder)localObject).append(" ; minFrameCount = ");
        ((StringBuilder)localObject).append(a());
        QLog.d(paramAEVideoCaptureResult, 2, ((StringBuilder)localObject).toString());
      }
      M();
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【GIF Capture】during time:");
    localStringBuilder.append(paramAEVideoCaptureResult.finishTimeMs - paramAEVideoCaptureResult.startTimeMs);
    localStringBuilder.append("ms");
    AEQLog.b((String)localObject, localStringBuilder.toString());
    AEBaseReportParam.a().b(5L);
    AEBaseDataReporter.a().ak();
    long l1 = b();
    if (l1 > 0L)
    {
      a(l1);
      return;
    }
    paramAEVideoCaptureResult = BaseApplicationImpl.getContext();
    if (paramAEVideoCaptureResult != null) {
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.43(this, paramAEVideoCaptureResult));
    }
  }
  
  public void a(@NonNull List<AEDashboardUtil.BinaryInfo> paramList, @NonNull List<AEDashboardUtil.ABTestInfo> paramList1)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(720897, new Object[] { paramList, paramList1 });
  }
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected boolean a()
  {
    if (this.jdField_b_of_type_ComTencentAelightCameraAeModeAECaptureMode == AECaptureMode.GIF) {
      return false;
    }
    return AECameraEntryManager.j(a().getIntent()) ^ true;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if (paramInt == 4) {
      i();
    }
    return super.a(paramInt, paramKeyEvent, paramBoolean);
  }
  
  public AECaptureMode[] a(int paramInt)
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
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initCaptureModesAndFirstMode---initialMode=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode);
    localStringBuilder.append(", initialCModes=");
    localStringBuilder.append(Arrays.toString((Object[])localObject));
    AEQLog.b(str, localStringBuilder.toString());
    return localObject;
  }
  
  protected void aa()
  {
    LiuHaiUtils.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, ViewUtils.a(1.0F));
    ab();
  }
  
  protected void ab()
  {
    Object localObject = a();
    if (ScreenUtil.getRealHeight((Context)localObject) / ScreenUtil.getRealWidth((Context)localObject) >= 2.0F)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (!AECameraEntryManager.g(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.i())) {
        a((Activity)localObject);
      }
    }
    if ((Build.MODEL.contains("Pixel 2")) && (Build.VERSION.SDK_INT >= 16))
    {
      localObject = ((Activity)localObject).getWindow().getDecorView();
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() & 0xFFFFFFFB);
    }
    localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject != null)
    {
      localObject = ((View)localObject).getViewTreeObserver();
      if (((ViewTreeObserver)localObject).isAlive()) {
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(new AEPituCameraUnit.47(this));
      }
    }
  }
  
  protected int b()
  {
    if (l())
    {
      int i1 = AEPreviewSizeUtil.a();
      if (i1 == 1) {
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.R_4_3;
      } else if (i1 == 2) {
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.R_4_3;
      } else {
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.FULL;
      }
      ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this).get(AEVideoStoryTopBarViewModel.class)).a.setValue(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
    }
    else
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.FULL;
    }
    return this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio.code;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setAECaptureController(a());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setAeGLSurfaceListener(this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView$AEGLSurfaceListener);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setCaptureListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setFaceEffectListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setStickerInnerLutFilterListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setRecommendTextCallback(new AEPituCameraUnit.44(this));
    if (MediaCodecDPC.m())
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(true);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.setDynamicResolutionMode(true);
    }
    else
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(false);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.setDynamicResolutionMode(false);
    }
    if (AEDashboardUtil.a()) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.debugInfoCallback = this;
    }
    if (l()) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setAeEditMaterialSelectedListener(new AEPituCameraUnit.45(this));
    }
  }
  
  public void b(String paramString)
  {
    AEMaterialManager localAEMaterialManager = (AEMaterialManager)AEQIMManager.a().b(1);
    if ((localAEMaterialManager != null) && (!TextUtils.isEmpty(paramString)))
    {
      AEBaseReportParam.a().a(paramString, a());
      localAEMaterialManager.a(false);
      paramString = localAEMaterialManager.a(paramString, l());
      if (paramString == null)
      {
        Toast.makeText(a(), 2064515088, 1).show();
        return;
      }
      AECircleMultiUnit.a(false, a());
      a().a(true, 150);
      this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(327683, new Object[] { paramString });
      this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(196612, new Object[0]);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setBundlePath(paramString1, paramString2);
    }
  }
  
  protected void c()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.35(this));
  }
  
  public void c(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2064122221);
    if ((localObject instanceof VideoFilterViewPager))
    {
      ((VideoFilterViewPager)localObject).setVisibility(paramInt);
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("yes to domVideoFilterViewPager setVisibility: ");
      localStringBuilder.append(paramInt);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  public void d()
  {
    V();
    if (this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(196609, new Object[0]);
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(262147, new Object[0]);
  }
  
  public void d(int paramInt)
  {
    try
    {
      this.jdField_c_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
  }
  
  protected boolean d()
  {
    return l();
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a();
    int i1;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    boolean bool = PermissionUtils.isStorePermissionEnable((Context)localObject);
    localObject = new LinkedList();
    if (i1 != 0)
    {
      ((List)localObject).add("android.permission.CAMERA");
      AEQLog.b(this.jdField_a_of_type_JavaLangString, "【Camera Permission】denied");
    }
    if (i2 != 0)
    {
      ((List)localObject).add("android.permission.RECORD_AUDIO");
      AEQLog.b(this.jdField_a_of_type_JavaLangString, "【Audio Permission】denied");
    }
    if ((bool ^ true))
    {
      ((List)localObject).add("android.permission.READ_EXTERNAL_STORAGE");
      ((List)localObject).add("android.permission.WRITE_EXTERNAL_STORAGE");
      AEQLog.b(this.jdField_a_of_type_JavaLangString, "【External Storage Permission】denied");
    }
    localObject = DialogUtil.a((String[])((List)localObject).toArray(new String[0]));
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.36(this, (String)localObject));
  }
  
  public void e()
  {
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "onActivityResume");
    this.jdField_a_of_type_Boolean = true;
    if (jdField_f_of_type_Boolean)
    {
      AEQLog.d(this.jdField_a_of_type_JavaLangString, "onActivityResume---publishStoryFlag is true, activity will finish soon, fast return");
      return;
    }
    super.e();
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.refreshDarkModeTimer();
    v();
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraProviderViewGesture);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraTriggerGesture);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.h();
    if (this.i)
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton.k();
      }
      R();
      e(false);
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager;
    if (localObject != null) {
      ((VideoStoryCapturePartManager)localObject).b();
    }
    H();
    f(false);
    AEMaterialManager.b = true;
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityResume, ID=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      AEQLog.a((String)localObject, localStringBuilder.toString());
    }
    if (l())
    {
      localObject = null;
      if (AEMaterialManager.a() != null)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("ext2", AEMaterialManager.a().k);
      }
      AEReportUtils.a(1, (HashMap)localObject);
    }
  }
  
  public void e(int paramInt)
  {
    try
    {
      this.jdField_d_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (this.jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.19(this));
  }
  
  protected boolean e()
  {
    return AECameraEntryManager.j(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.i());
  }
  
  public void f()
  {
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "onActivityPause");
    super.f();
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraProviderViewGesture);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraTriggerGesture);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture);
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiFilterPagerViewStubHolder;
    if (localObject != null) {
      ((FilterPagerViewStubHolder)localObject).b();
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton.l();
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.g();
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.c();
    AEMaterialManager.b = false;
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityPause, ID=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      AEQLog.a((String)localObject, localStringBuilder.toString());
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(327687, new Object[0]);
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(327688, new Object[0]);
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_ComTencentAelightCameraAeModeAECaptureMode == AECaptureMode.GIF;
  }
  
  public void g()
  {
    super.g();
    w();
    if (AEDashboardUtil.a()) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.debugInfoCallback = null;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.f();
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiFilterPagerViewStubHolder;
    if (localObject != null) {
      ((FilterPagerViewStubHolder)localObject).c();
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeUtilAECaptureAudioUtil.b();
    AEBaseReportParam.a().m();
    AEBaseReportParam.a().a(false);
    AECameraGetInfoClient.b();
    if ((a() != null) && (AECameraEntryManager.j(a().getIntent()))) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.setSelectedCamera(CameraHelper.a());
    }
    localObject = (AEMaterialManager)AEQIMManager.a(1);
    ((AEMaterialManager)localObject).a();
    ((AEMaterialManager)localObject).g();
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController;
    if (localObject != null) {
      ((AECaptureController)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localObject != null)
    {
      ((AEFilterManager)localObject).wmSetOnClickWatermarkListener(null);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.wmSetOnlineUsrCountDelegate("watermark.qq.online", null);
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResourceDownload isOnlineRes: ");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (!g)
    {
      g = true;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().runOnUiThread(new AEPituCameraUnit.33(this));
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().runOnUiThread(new AEPituCameraUnit.34(this));
  }
  
  public boolean g()
  {
    return true;
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "【Camera / Audio / Storage Permission】grant");
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Boolean) {
      m();
    }
  }
  
  public void h(boolean paramBoolean) {}
  
  protected boolean h()
  {
    return (this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.f() != -1);
  }
  
  protected void i()
  {
    super.i();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2064122226);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2064122519));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEWaterMarkPanel = ((AEWaterMarkPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2064122520));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel = ((AEARCakePanel)this.jdField_a_of_type_AndroidViewView.findViewById(2064122518));
  }
  
  public boolean i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController;
    if (localObject == null) {
      return false;
    }
    if (((AECaptureController)localObject).a()) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(589824)) && (((Boolean)this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(589826, new Object[0])).booleanValue()))
    {
      AEQLog.a(this.jdField_a_of_type_JavaLangString, "WaterMark editor need hide");
      this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(589826, new Object[0]);
      return true;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.g();
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.i();
    if (l())
    {
      localObject = a().getIntent();
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
          a().startActivity((Intent)localObject);
        }
        else
        {
          ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_NAME");
          str2 = ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_APK");
          String str3 = ((Intent)localObject).getStringExtra("PhotoConst.UIN");
          if ("qzone_plugin.apk".equals(str2))
          {
            QzonePluginProxyActivity.setActivityNameToIntent((Intent)localObject, str1);
            QZoneHelper.launchQZone(a(), str3, (Intent)localObject, 2);
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a();
    AEBaseDataReporter.a().J();
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "【Click】onBackPressed");
    return true;
  }
  
  protected boolean j()
  {
    return (this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.c() == 101) && (this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.c()) && (this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.a()) && (this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.f());
  }
  
  protected boolean k()
  {
    return (this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.c() == 101) && (this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.e());
  }
  
  public boolean l()
  {
    return AECameraEntryManager.k(a().getIntent());
  }
  
  public boolean m()
  {
    return AECameraEntryManager.l(a().getIntent());
  }
  
  public boolean n()
  {
    try
    {
      int i1 = this.jdField_c_of_type_Int;
      boolean bool = true;
      if (i1 == 1) {
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
  
  public void notifyEnableLutType(int paramInt)
  {
    boolean bool2 = true;
    if (paramInt == 1000)
    {
      d(1);
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager;
      if (localObject != null) {
        ((VideoStoryCapturePartManager)localObject).a(196609, new Object[0]);
      }
    }
    else
    {
      d(0);
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
      ((AEFilterProcessTex)localObject).jdField_a_of_type_Boolean = bool1;
      if (paramInt == 1000) {
        ((AEFilterProcessTex)localObject).f();
      }
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController;
    if (localObject != null)
    {
      if (paramInt != 1000) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      ((AECaptureController)localObject).jdField_a_of_type_Boolean = bool1;
    }
  }
  
  public void notifyEnableMeshType(int paramInt)
  {
    if (paramInt == 2001) {
      paramInt = 4;
    } else {
      paramInt = 3;
    }
    e(paramInt);
  }
  
  public void onAEKitInited()
  {
    super.onAEKitInited();
    int i1 = AEBeautyProviderView.a();
    int i2 = AEBeautyProviderView.b();
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.a(i1);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.b(i2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.11(this));
    AEFontManager.a().a();
  }
  
  public void onAssetProcessingData(HashMap<String, String> paramHashMap)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAssetProcessingData: ");
    localStringBuilder.append(paramHashMap);
    AEQLog.a(str, localStringBuilder.toString());
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public void onCaptureError(int paramInt)
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.e().postValue(Boolean.valueOf(false));
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCaptureError. errorCode = ");
    localStringBuilder.append(paramInt);
    AEQLog.a(str, localStringBuilder.toString(), new Throwable());
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.46(this, paramInt));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2064122376: 
    case 2131370408: 
      a().getIntent().removeExtra("widgetinfo");
      return;
    case 2064122095: 
      paramView = this.jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton;
      if (paramView == null) {
        return;
      }
      PressScaleAnimDelegate.a(paramView.a(), 200L, null);
      boolean bool = this.jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton.isSelected();
      int i1 = 1;
      bool ^= true;
      this.jdField_b_of_type_ComTencentAelightCameraAeViewAECompoundButton.setSelected(bool);
      c(bool);
      if (!bool) {
        this.o = true;
      } else {
        this.o = false;
      }
      ReportUtil.a(bool);
      if (!bool) {
        i1 = 2;
      }
      CaptureReportUtil.a(i1);
      return;
    case 2064122036: 
      L();
      return;
    }
    PressScaleAnimDelegate.a(paramView, 200L, null);
    T();
  }
  
  public void onDetectStateChange(boolean paramBoolean1, boolean paramBoolean2)
  {
    AETipsViewController localAETipsViewController = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsAETipsViewController;
    if (localAETipsViewController != null) {
      localAETipsViewController.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public void onDeviceNotSupportMaterial()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.48(this));
  }
  
  public void onHideNormalTip()
  {
    AEQLog.a(this.jdField_a_of_type_JavaLangString, "onHideNormalTip: ");
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.38(this));
  }
  
  public void onHidePagTip()
  {
    AEQLog.a(this.jdField_a_of_type_JavaLangString, "onHidePagTip: ");
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.40(this));
  }
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.e().postValue(Boolean.valueOf(false));
    if (!paramBoolean)
    {
      onCaptureError(101);
      return;
    }
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onVideoCaptured] videoInfo = ");
    localStringBuilder.append(paramLocalMediaInfo.mDuration);
    AEQLog.b(str, localStringBuilder.toString());
    AEBaseReportParam.a().b(2L);
    AEBaseDataReporter.a().d(paramLocalMediaInfo.mDuration);
    h(false);
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(196609, new Object[0]);
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(262146, new Object[] { this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEVideoCaptureResult, paramLocalMediaInfo, Integer.valueOf(this.jdField_b_of_type_Int), this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureEntranceParams, this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(196610, new Object[0]) });
  }
  
  public void onPhotoCaptured(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEPhotoCaptureResult = paramAEPhotoCaptureResult;
    AEBaseReportParam.a().b(1L);
    AEBaseDataReporter.a().d(-1L);
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "【Type】Photo");
    Object localObject = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localObject != null)
    {
      localObject = ((AEFilterManager)localObject).wmGetEditableWMElements();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          WMElement localWMElement = (WMElement)((Iterator)localObject).next();
          if ("CHECK_IN".equals(localWMElement.type)) {
            localWMElement.doCheckIn();
          }
        }
      }
    }
    if (h()) {
      a(paramAEPhotoCaptureResult);
    } else {
      b(paramAEPhotoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.16(this));
  }
  
  public void onSelectFaceEffect(VideoMaterial paramVideoMaterial)
  {
    S();
    w();
    if (!f()) {
      if (paramVideoMaterial == null) {
        AEBaseReportParam.a().e("none");
      } else {
        AEBaseReportParam.a().e(paramVideoMaterial.getId());
      }
    }
    if ((paramVideoMaterial != null) && (paramVideoMaterial.isWatermarkMaterial()) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null))
    {
      AEQLog.a(this.jdField_a_of_type_JavaLangString, "onSelectFaceEffect: wmSetOnlineUsrCountDelegate");
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.wmSetOnlineUsrCountDelegate("watermark.qq.online", new AEPituCameraUnit.30(this));
    }
    if ((paramVideoMaterial != null) && (paramVideoMaterial.isEditableWatermark()) && (!f())) {
      a().runOnUiThread(new AEPituCameraUnit.31(this, paramVideoMaterial));
    } else {
      a().runOnUiThread(new AEPituCameraUnit.32(this, paramVideoMaterial));
    }
    AETipsViewController localAETipsViewController = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsAETipsViewController;
    if (localAETipsViewController != null) {
      localAETipsViewController.a(paramVideoMaterial);
    }
  }
  
  public void onSetFilterProcess(AEFilterProcessTex paramAEFilterProcessTex)
  {
    if (paramAEFilterProcessTex != null)
    {
      AETipsViewController localAETipsViewController = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTipsAETipsViewController;
      if (localAETipsViewController != null) {
        paramAEFilterProcessTex.a(localAETipsViewController.a());
      }
    }
    if (paramAEFilterProcessTex != null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = paramAEFilterProcessTex.a();
      return;
    }
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = null;
  }
  
  public void onShowNormalTip(String paramString1, String paramString2, int paramInt)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onShowNormalTip: tip=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", icon=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(paramInt);
    AEQLog.a(str, localStringBuilder.toString());
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.37(this, paramString1, paramString2, paramInt));
  }
  
  public void onShowPagTip(String paramString, int paramInt)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onShowPagTip: pagPath=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(paramInt);
    AEQLog.a(str, localStringBuilder.toString());
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.39(this, paramString, paramInt));
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    if (this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton != null) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton.a(), this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView);
    }
    return true;
  }
  
  public void onVideoCaptureStart()
  {
    W();
    c(8);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.14(this));
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(196609, new Object[0]);
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(262145, new Object[0]);
  }
  
  public void onVideoCaptured(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEVideoCaptureResult = paramAEVideoCaptureResult;
    this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEVideoCaptureResult.finishTimeMs = System.currentTimeMillis();
    if (f())
    {
      a(paramAEVideoCaptureResult);
    }
    else
    {
      int i1 = 500;
      if (this.jdField_b_of_type_Int == 13) {
        i1 = 2000;
      }
      if (MediaUtil.a(paramAEVideoCaptureResult.videoMp4FilePath) < i1)
      {
        this.jdField_e_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.e().postValue(Boolean.valueOf(false));
        M();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = paramAEVideoCaptureResult.videoMp4FilePath;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
      MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(this, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.15(this));
  }
  
  protected void x()
  {
    if (this.j) {
      return;
    }
    this.j = true;
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "actionAfterFirstFrame");
    int i1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().getIntent().getIntExtra("edit_video_type", 10002);
    ((IAsyncControl)QRoute.api(IAsyncControl.class)).startAsyncStep(CaptureAsyncControl.jdField_a_of_type_JavaLangString, new Object[] { this, Integer.valueOf(i1) });
    if ((!this.jdField_d_of_type_Boolean) && (!m()))
    {
      this.jdField_d_of_type_Boolean = true;
      ThreadManager.getSubThreadHandler().post(new AEDownloadMaterialRunnable());
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.18(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit
 * JD-Core Version:    0.7.0.1
 */