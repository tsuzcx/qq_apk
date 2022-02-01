package com.tencent.aelight.camera.ae;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.camera.AECaptureParam;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEKitInitListener;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.CaptureListener;
import com.tencent.aelight.camera.ae.camera.core.AECameraManager;
import com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraManagerListener;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkDataManager;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.perf.AELaunchRecorder;
import com.tencent.aelight.camera.ae.play.PlayDownloadManagerWrap;
import com.tencent.aelight.camera.ae.qipc.AECameraGetInfoClient;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.util.AECaptureAudioUtil;
import com.tencent.aelight.camera.ae.util.AEPreviewSizeUtil;
import com.tencent.aelight.camera.ae.util.DovSVParamManager;
import com.tencent.aelight.camera.ae.view.AECameraErrorDialog;
import com.tencent.aelight.camera.aebase.QIMCameraLifeCycleBaseUnit;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.aioeditor.setting.CaptureEntranceParams;
import com.tencent.aelight.camera.aioeditor.setting.ICameraEntrance;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker;
import com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker.DarkModeListener;
import com.tencent.mobileqq.shortvideo.filter.QQLowLightFilter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.audio.AudioCapture;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.CosFunHelper;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.ae.current.SessionWrap;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import mqq.app.BaseActivity;
import org.jetbrains.annotations.NotNull;

public abstract class AEBaseCameraUnit
  extends QIMCameraLifeCycleBaseUnit
  implements IBaseCameraUnit, AECameraGLSurfaceView.AEKitInitListener, AECameraGLSurfaceView.CaptureListener
{
  protected static final LinkedList<Integer> a;
  protected int a;
  protected volatile SurfaceTexture a;
  protected Handler a;
  protected View a;
  protected ViewStub a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected AECameraConfig a;
  protected AECameraGLSurfaceView a;
  protected AECameraManager a;
  protected AEVideoStoryTopBarViewModel.Ratio a;
  protected AECaptureMode a;
  protected AECaptureAudioUtil a;
  protected AECameraErrorDialog a;
  protected AbsAECaptureButton a;
  protected CaptureEntranceParams a;
  protected ICameraEntrance a;
  protected IQIMCameraContainer a;
  protected AEPhotoCaptureResult a;
  protected AEVideoCaptureResult a;
  protected CameraFocusView a;
  protected LocalMediaInfo a;
  protected final String a;
  protected boolean a;
  protected AECaptureMode[] a;
  protected int b;
  protected AECaptureMode b;
  protected volatile boolean b;
  protected volatile boolean c;
  
  static
  {
    jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  }
  
  public AEBaseCameraUnit()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Performance2]");
    localStringBuilder.append(getClass().getSimpleName());
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager = new AECameraManager();
    this.jdField_a_of_type_ComTencentAelightCameraAeUtilAECaptureAudioUtil = new AECaptureAudioUtil();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureEntranceParams = new CaptureEntranceParams(10000, 100, 2);
    this.jdField_b_of_type_ComTencentAelightCameraAeModeAECaptureMode = null;
    this.jdField_b_of_type_Int = 11;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "[AEBaseCameraUnit] + BEGIN");
    AEQLog.a(this.jdField_a_of_type_JavaLangString, "unitConstructor--fake");
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "[AEBaseCameraUnit] + END");
  }
  
  public AEBaseCameraUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Performance2]");
    localStringBuilder.append(getClass().getSimpleName());
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager = new AECameraManager();
    this.jdField_a_of_type_ComTencentAelightCameraAeUtilAECaptureAudioUtil = new AECaptureAudioUtil();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingCaptureEntranceParams = new CaptureEntranceParams(10000, 100, 2);
    this.jdField_b_of_type_ComTencentAelightCameraAeModeAECaptureMode = null;
    this.jdField_b_of_type_Int = 11;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "[AEBaseCameraUnit] + BEGIN");
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer = paramIQIMCameraContainer;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingICameraEntrance = paramICameraEntrance;
    this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig = a();
  }
  
  private AudioCapture a(AECaptureParam paramAECaptureParam)
  {
    return new AudioCapture(paramAECaptureParam.jdField_a_of_type_JavaLangString, 1, CodecParam.mAudioSampleRate, CodecParam.mAudioChannel, CodecParam.mAudioFormat, this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView, null);
  }
  
  protected static void a(Activity paramActivity)
  {
    paramActivity.getWindow().clearFlags(2048);
    paramActivity.getWindow().addFlags(1024);
    paramActivity.getWindow().addFlags(256);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity = paramActivity.getWindow().getDecorView();
      paramActivity.setSystemUiVisibility(paramActivity.getSystemUiVisibility() | 0x4);
    }
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setAEKitInitListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setIsVoiceNeedEncode(d());
    AECaptureParam localAECaptureParam = a();
    AudioCapture localAudioCapture;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.d()) {
      localAudioCapture = a(localAECaptureParam);
    } else {
      localAudioCapture = null;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.init(localAECaptureParam, localAudioCapture);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setBeautyEnable(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.c());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setFaceEffectEnable(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.e());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setFilterEnable(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.f());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setSharpFaceEnable(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.a());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setPreExtractFrame(e());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setUseVideoOrientation(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.h());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.init(localAECaptureParam);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.setAudioCapture(localAudioCapture);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.setDarkModeEnable(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.i());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.setDarkModeListener(a());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.setDarkModeChecker(a());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.setCameraManagerListener(a());
  }
  
  protected int a()
  {
    return 2064318523;
  }
  
  public Activity a()
  {
    IQIMCameraContainer localIQIMCameraContainer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer;
    if (localIQIMCameraContainer == null) {
      return null;
    }
    return localIQIMCameraContainer.a();
  }
  
  protected abstract BroadcastReceiver a();
  
  protected IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction(AEResInfo.AE_RES_BASE_PACKAGE.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BASE_PACKAGE.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_3DMM.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_ACE3D.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_CAT.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_DEPTH.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_GENDER.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_HAND.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_SEG_HAIR.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_SEG_SKY.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_SEG_HEAD.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_SCENE.resPrefix);
    return localIntentFilter;
  }
  
  public View a()
  {
    a("unitInflateView-begin");
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(a(), null, false);
    a("unitInflateView-end");
    i();
    j();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected AECameraConfig a()
  {
    return c();
  }
  
  protected AECaptureParam a()
  {
    return DovSVParamManager.a().a(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig);
  }
  
  protected abstract AECameraManager.CameraManagerListener a();
  
  public AECaptureMode a(int paramInt)
  {
    return AECaptureMode.NORMAL;
  }
  
  protected abstract DarkModeChecker.DarkModeListener a();
  
  @NotNull
  protected DarkModeChecker a()
  {
    return new DarkModeChecker();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.captureByCameraProxy())
    {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "capturePhotoByCameraProxy");
      AEDashboardUtil.a.jdField_b_of_type_Boolean = false;
      q();
    }
    else
    {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "capturePhotoByAEKit");
      AEDashboardUtil.a.jdField_b_of_type_Boolean = true;
      p();
    }
    d();
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    a(false);
    this.c = b();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEVideoCaptureResult = ((AEVideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
      this.jdField_a_of_type_Int = paramBundle.getInt("KEY_IDENTITY_CODE_SAVE");
      paramBundle = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate, restore from background, ID=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      AEQLog.b(paramBundle, localStringBuilder.toString());
    }
    else
    {
      this.jdField_a_of_type_Int = (jdField_a_of_type_JavaUtilLinkedList.size() + 1);
      paramBundle = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate, new created, ID=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      AEQLog.b(paramBundle, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeUtilAECaptureAudioUtil.a();
    AECameraGetInfoClient.a();
    if (!jdField_a_of_type_JavaUtilLinkedList.contains(Integer.valueOf(this.jdField_a_of_type_Int))) {
      jdField_a_of_type_JavaUtilLinkedList.push(Integer.valueOf(this.jdField_a_of_type_Int));
    }
    a().registerReceiver(a(), a());
    paramBundle = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate, ID=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", sUnitStack=");
    localStringBuilder.append(jdField_a_of_type_JavaUtilLinkedList);
    AEQLog.b(paramBundle, localStringBuilder.toString());
  }
  
  protected void a(String paramString)
  {
    AELaunchRecorder.a().a(paramString);
  }
  
  protected void a(boolean paramBoolean)
  {
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), paramBoolean, 5);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, paramBoolean);
  }
  
  protected abstract boolean a();
  
  public boolean a(boolean paramBoolean)
  {
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 23))
    {
      Activity localActivity = a();
      if (!Settings.System.canWrite(localActivity))
      {
        DialogUtil.a(localActivity, null, null);
        bool = false;
        break label38;
      }
    }
    boolean bool = true;
    label38:
    if (bool) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.switchFlash(paramBoolean);
    }
    return bool;
  }
  
  public AECaptureMode[] a(int paramInt)
  {
    return new AECaptureMode[] { AECaptureMode.NORMAL, AECaptureMode.PLAY, AECaptureMode.GIF };
  }
  
  protected int b()
  {
    return AEVideoStoryTopBarViewModel.Ratio.FULL.code;
  }
  
  public AECameraConfig b()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig == null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig = a();
    }
    return this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig;
  }
  
  protected abstract void b();
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putSerializable("KEY_VIDEO_RESULT", this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEVideoCaptureResult);
    paramBundle.putInt("KEY_IDENTITY_CODE_SAVE", this.jdField_a_of_type_Int);
    paramBundle = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveInstanceState---destroyed in background, ID=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    AEQLog.b(paramBundle, localStringBuilder.toString());
  }
  
  public void b(boolean paramBoolean)
  {
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "closeCamera");
    if (!c())
    {
      AEQLog.d(this.jdField_a_of_type_JavaLangString, "closeCamera---EXIT, not called by the top unit");
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.stopCamera(paramBoolean);
  }
  
  protected boolean b()
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      AEQLog.b(this.jdField_a_of_type_JavaLangString, "checkPermission---below android6.0, no need check");
      return true;
    }
    Object localObject = a();
    int i = ((Activity)localObject).checkSelfPermission("android.permission.CAMERA");
    int j = ((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO");
    boolean bool = PermissionUtils.isStorePermissionEnable((Context)localObject);
    localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkPermission, camera: ");
    localStringBuilder.append(i);
    localStringBuilder.append(" audio: ");
    localStringBuilder.append(j);
    localStringBuilder.append(", storage=");
    localStringBuilder.append(bool);
    AEQLog.b((String)localObject, localStringBuilder.toString());
    return (i == 0) && (j == 0) && (bool);
  }
  
  protected AECameraConfig c()
  {
    AECameraConfig.Builder localBuilder = new AECameraConfig.Builder();
    Intent localIntent = a().getIntent();
    if ((localIntent != null) && (localIntent.getExtras() != null))
    {
      boolean bool1 = localIntent.getExtras().getBoolean("PeakConstants.ARG_AUDIO", true);
      int i = localIntent.getExtras().getInt("ARG_CAPTURE_MAX_DURATION", -1);
      boolean bool2 = localIntent.getExtras().getBoolean("PeakConstants.ARG_SUPPORT_FILTER", true);
      boolean bool3 = localIntent.getExtras().getBoolean("PeakConstants.ARG_SUPPORT_DD", true);
      boolean bool4 = localIntent.getExtras().getBoolean("PeakConstants.ARG_BEAUTY", true);
      boolean bool5 = localIntent.getExtras().getBoolean("PeakConstants.ARG_SHARP_FACE", true);
      boolean bool6 = localIntent.getExtras().getBoolean("PeakConstants.ARG_ALBUM", true);
      int j = localIntent.getExtras().getInt("ARG_DEFAULT_OPEN_PANEL", -1);
      int k = localIntent.getExtras().getInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
      int m = localIntent.getExtras().getInt("edit_video_way", 0);
      int n = localIntent.getExtras().getInt("entrance_type", 120);
      int i1 = localIntent.getExtras().getInt("extra.busi_type", 14);
      SessionWrap localSessionWrap = (SessionWrap)localIntent.getParcelableExtra("ARG_SESSION_INFO");
      String str = localIntent.getStringExtra("ARG_AIO_CLASS");
      int i2 = localIntent.getExtras().getInt("key_camera_photo_edit_type", -1);
      int i3 = localIntent.getExtras().getInt("key_camera_video_edit_type", -1);
      int i4 = localIntent.getExtras().getInt("ability_flag", -1);
      int i5 = localIntent.getIntExtra("AECAMERA_MODE", 200);
      boolean bool7 = localIntent.getBooleanExtra("key_camera_use_video_orientation", true);
      boolean bool8 = localIntent.getBooleanExtra("key_camera_auto_rotate", true);
      this.jdField_a_of_type_ArrayOfComTencentAelightCameraAeModeAECaptureMode = a(i5);
      this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode = a(i5);
      boolean bool9 = a().getIntent().getBooleanExtra("key_has_countdown", false);
      int i6 = b();
      int i7 = localIntent.getIntExtra("PeakConstants.ARG_FORCE_CAMERA", 0);
      int i8 = localIntent.getIntExtra("key_camera_result_code", -1);
      localBuilder.f(k).a(i8).a(bool1).c(bool4).c(j).e(bool2).b(i).d(bool5).f(bool3).b(bool6).m(i4).l(n).d(i1).e(m).g(i2).h(i3).h(bool8).g(bool7).i(bool9).k(i5).a(this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode).a(this.jdField_a_of_type_ArrayOfComTencentAelightCameraAeModeAECaptureMode).a(localSessionWrap).a(str).j(i6).i(i7);
    }
    return localBuilder.a();
  }
  
  protected abstract void c();
  
  protected void c(boolean paramBoolean)
  {
    try
    {
      QQLowLightFilter.enableNightMode(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected boolean c()
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilLinkedList.peek();
    return (localInteger != null) && (localInteger.intValue() == this.jdField_a_of_type_Int);
  }
  
  public abstract void d();
  
  protected boolean d()
  {
    return true;
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.onResume();
    k();
    b(false);
    this.c = b();
    n();
  }
  
  protected boolean e()
  {
    return true;
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.onPause();
    k();
    b(false);
  }
  
  public void g()
  {
    super.g();
    a().unregisterReceiver(a());
    b(true);
    GLGestureProxy.getInstance().removeAllListener();
    PlayDownloadManagerWrap.getInstance().clearObserver();
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.onDestroy();
    WatermarkDataManager.a().a();
    CosFunHelper.setCountDownListener(null);
    a(true);
    if (c())
    {
      jdField_a_of_type_JavaUtilLinkedList.pop();
      str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy, is on top, ID=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      AEQLog.b(str, localStringBuilder.toString());
    }
    else
    {
      str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy, is NOT on top, ID=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      AEQLog.b(str, localStringBuilder.toString());
    }
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy, ID=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", sUnitStack=");
    localStringBuilder.append(jdField_a_of_type_JavaUtilLinkedList);
    AEQLog.b(str, localStringBuilder.toString());
  }
  
  public void h()
  {
    if (AECameraEntryManager.l(a().getIntent()))
    {
      AEQLog.a(this.jdField_a_of_type_JavaLangString, "can not toggle Camera in ar cake mode");
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.toggleCamera(new AEBaseCameraUnit.2(this));
  }
  
  protected void i()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2064121981));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2064121980));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2064122016));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2064122647));
  }
  
  protected void j()
  {
    AECaptureMode.NORMAL.setHasCountDown(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.j());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.fromCode(this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.h());
    this.jdField_b_of_type_ComTencentAelightCameraAeModeAECaptureMode = this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.a();
    s();
    b();
  }
  
  public void k()
  {
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "stopPreview");
    if (!c())
    {
      AEQLog.d(this.jdField_a_of_type_JavaLangString, "stopPreview---EXIT, not called by the top unit");
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.cameraStopPreview();
  }
  
  public void l()
  {
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "tryStartPreview---ENTER");
    if (!c())
    {
      AEQLog.d(this.jdField_a_of_type_JavaLangString, "tryStartPreview---EXIT, not called by the top unit");
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      AEQLog.d(this.jdField_a_of_type_JavaLangString, "tryStartPreview---EXIT, activity not resumed");
      return;
    }
    Object localObject = this.jdField_b_of_type_ComTencentAelightCameraAeModeAECaptureMode;
    if ((localObject != null) && (((AECaptureMode)localObject).shouldStartCamera()))
    {
      if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null)
      {
        AEQLog.d(this.jdField_a_of_type_JavaLangString, "tryStartPreview---EXIT, mPreviewTexture is NULL");
        return;
      }
      if (AEPreviewSizeUtil.a() == null)
      {
        AEQLog.d(this.jdField_a_of_type_JavaLangString, "tryStartPreview---EXIT, mMaxPreviewSize is NULL");
        return;
      }
      localObject = AEPreviewSizeUtil.a((AECaptureMode)localObject, AEPreviewSizeUtil.a(), this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.setCameraManagerListener(a());
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.startCameraPreview(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, (Size)localObject);
      AEQLog.b(this.jdField_a_of_type_JavaLangString, "tryStartPreview---EXIT, normal");
      return;
    }
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryStartPreview---EXIT, not right mode: ");
    localStringBuilder.append(localObject);
    AEQLog.d(str, localStringBuilder.toString());
  }
  
  public void m()
  {
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "tryOpenCamera---ENTER");
    if (!c())
    {
      AEQLog.d(this.jdField_a_of_type_JavaLangString, "tryOpenCamera---EXIT, not called by the top unit");
      return;
    }
    AECaptureMode localAECaptureMode = this.jdField_b_of_type_ComTencentAelightCameraAeModeAECaptureMode;
    if ((localAECaptureMode != null) && (localAECaptureMode.shouldStartCamera()))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.openCamera(new AEBaseCameraUnit.3(this));
      return;
    }
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryOpenCamera---EXIT, not right mode: ");
    localStringBuilder.append(localAECaptureMode);
    AEQLog.d(str, localStringBuilder.toString());
  }
  
  protected void n()
  {
    if (this.c)
    {
      m();
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      o();
      return;
    }
    r();
  }
  
  protected void o()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a() instanceof BaseActivity))
    {
      BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a();
      int i;
      if (localBaseActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (localBaseActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
        j = 1;
      } else {
        j = 0;
      }
      boolean bool = PermissionUtils.isStorePermissionEnable(localBaseActivity);
      LinkedList localLinkedList = new LinkedList();
      if (i != 0) {
        localLinkedList.add("android.permission.CAMERA");
      }
      if (j != 0) {
        localLinkedList.add("android.permission.RECORD_AUDIO");
      }
      if ((bool ^ true))
      {
        localLinkedList.add("android.permission.READ_EXTERNAL_STORAGE");
        localLinkedList.add("android.permission.WRITE_EXTERNAL_STORAGE");
      }
      if (localLinkedList.size() > 0) {
        localBaseActivity.requestPermissions(this, 1, (String[])localLinkedList.toArray(new String[0]));
      }
    }
  }
  
  public void onAEKitInited()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAEKitInited: thread = ");
    localStringBuilder.append(Thread.currentThread().getName());
    Log.d(str, localStringBuilder.toString());
  }
  
  protected void p()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.isFlashEnabled())
    {
      i = 1500;
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.turnFlash(a(), true);
    }
    else
    {
      i = 0;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.capturePhotoByAEKit(i);
  }
  
  protected void q()
  {
    Object localObject1 = this.jdField_b_of_type_ComTencentAelightCameraAeModeAECaptureMode;
    if ((localObject1 != null) && (((AECaptureMode)localObject1).shouldStartCamera()) && (AEPreviewSizeUtil.a() != null))
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.isFlashEnabled()) {
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.turnFlash(a(), true);
      }
      localObject1 = AEPreviewSizeUtil.a(this.jdField_b_of_type_ComTencentAelightCameraAeModeAECaptureMode, AEPreviewSizeUtil.a(), this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.getCaptureDir());
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append(System.currentTimeMillis());
      ((StringBuilder)localObject2).append(".jpg");
      localObject2 = ((StringBuilder)localObject2).toString();
      FileUtils.createFileIfNotExits((String)localObject2);
      localObject2 = new File((String)localObject2);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.isFrontCamera();
      int i;
      if (this.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.g()) {
        i = CaptureUtil.c(this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.getActivityOrientation());
      } else {
        i = 0;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.capturePhoto((File)localObject2, i, new AEBaseCameraUnit.4(this), (Size)localObject1);
    }
  }
  
  protected void r()
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAeViewAECameraErrorDialog == null) {
        this.jdField_a_of_type_ComTencentAelightCameraAeViewAECameraErrorDialog = new AECameraErrorDialog(localActivity);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECameraErrorDialog.a(new AEBaseCameraUnit.5(this));
    }
  }
  
  public void reportFirstFrameShown()
  {
    AEBaseDataReporter localAEBaseDataReporter = AEBaseDataReporter.a();
    int i;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraManager.isSupportCamera2()) {
      i = 2;
    } else {
      i = 1;
    }
    localAEBaseDataReporter.c(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEBaseCameraUnit
 * JD-Core Version:    0.7.0.1
 */