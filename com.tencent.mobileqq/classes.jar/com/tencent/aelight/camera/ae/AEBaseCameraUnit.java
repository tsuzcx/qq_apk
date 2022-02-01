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
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
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
  protected static final LinkedList<Integer> s = new LinkedList();
  protected boolean A;
  protected volatile boolean B;
  protected volatile boolean C;
  protected Handler D;
  protected final String a;
  protected IQIMCameraContainer b;
  protected ICameraEntrance c;
  protected AECameraManager d;
  protected AECaptureAudioUtil e;
  protected AECameraErrorDialog f;
  protected View g;
  protected AECameraGLSurfaceView h;
  protected AbsAECaptureButton i;
  protected ViewStub j;
  protected CameraFocusView k;
  protected volatile SurfaceTexture l;
  protected LinearLayout m;
  protected RelativeLayout n;
  protected AEVideoCaptureResult o;
  protected AEPhotoCaptureResult p;
  protected LocalMediaInfo q;
  protected CaptureEntranceParams r;
  protected int t;
  protected AECaptureMode u;
  protected AECaptureMode[] v;
  protected AEVideoStoryTopBarViewModel.Ratio w;
  protected AECaptureMode x;
  protected int y;
  protected AECameraConfig z;
  
  public AEBaseCameraUnit()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Performance2]");
    localStringBuilder.append(getClass().getSimpleName());
    this.a = localStringBuilder.toString();
    this.d = new AECameraManager();
    this.e = new AECaptureAudioUtil();
    this.r = new CaptureEntranceParams(10000, 100, 2);
    this.x = null;
    this.y = 11;
    this.B = false;
    this.C = false;
    this.D = new Handler(Looper.getMainLooper());
    AEQLog.b(this.a, "[AEBaseCameraUnit] + BEGIN");
    AEQLog.a(this.a, "unitConstructor--fake");
    AEQLog.b(this.a, "[AEBaseCameraUnit] + END");
  }
  
  public AEBaseCameraUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Performance2]");
    localStringBuilder.append(getClass().getSimpleName());
    this.a = localStringBuilder.toString();
    this.d = new AECameraManager();
    this.e = new AECaptureAudioUtil();
    this.r = new CaptureEntranceParams(10000, 100, 2);
    this.x = null;
    this.y = 11;
    this.B = false;
    this.C = false;
    this.D = new Handler(Looper.getMainLooper());
    AEQLog.b(this.a, "[AEBaseCameraUnit] + BEGIN");
    this.b = paramIQIMCameraContainer;
    this.c = paramICameraEntrance;
    AEDashboardUtil.a(s().getIntent());
    AEDashboardUtil.e();
    this.z = t();
  }
  
  private void N()
  {
    this.h.setAEKitInitListener(this);
    this.h.setIsVoiceNeedEncode(E());
    AECaptureParam localAECaptureParam = G();
    AudioCapture localAudioCapture;
    if (this.z.g()) {
      localAudioCapture = a(localAECaptureParam);
    } else {
      localAudioCapture = null;
    }
    this.h.init(localAECaptureParam, localAudioCapture, this.z);
    this.h.setBeautyEnable(this.z.f());
    this.h.setFaceEffectEnable(this.z.h());
    this.h.setFilterEnable(this.z.i());
    this.h.setSharpFaceEnable(this.z.d());
    this.h.setPreExtractFrame(J());
    this.h.setUseVideoOrientation(this.z.r());
    this.d.init(localAECaptureParam);
    this.d.setAudioCapture(localAudioCapture);
    this.d.setDarkModeEnable(this.z.z());
    this.d.setDarkModeListener(f());
    this.d.setDarkModeChecker(q());
    this.d.setCameraManagerListener(e());
  }
  
  private AudioCapture a(AECaptureParam paramAECaptureParam)
  {
    return new AudioCapture(paramAECaptureParam.a, 1, CodecParam.mAudioSampleRate, CodecParam.mAudioChannel, CodecParam.mAudioFormat, this.h, null);
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
  
  public void A()
  {
    AEQLog.b(this.a, "tryStartPreview---ENTER");
    if (!y())
    {
      AEQLog.d(this.a, "tryStartPreview---EXIT, not called by the top unit");
      return;
    }
    if (!this.A)
    {
      AEQLog.d(this.a, "tryStartPreview---EXIT, activity not resumed");
      return;
    }
    Object localObject = this.x;
    if ((localObject != null) && (((AECaptureMode)localObject).shouldStartCamera()))
    {
      if (this.l == null)
      {
        AEQLog.d(this.a, "tryStartPreview---EXIT, mPreviewTexture is NULL");
        return;
      }
      if (AEPreviewSizeUtil.a() == null)
      {
        AEQLog.d(this.a, "tryStartPreview---EXIT, mMaxPreviewSize is NULL");
        return;
      }
      if (!M()) {
        this.w = AEVideoStoryTopBarViewModel.Ratio.fromCode(AECameraPrefsUtil.a().b("sp_key_ae_camera_ratio", AEVideoStoryTopBarViewModel.Ratio.FULL.code, 0));
      }
      str = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryStartPreview---EXIT,mCurrentRatio");
      localStringBuilder.append(this.w);
      AEQLog.a(str, localStringBuilder.toString());
      localObject = AEPreviewSizeUtil.a((AECaptureMode)localObject, AEPreviewSizeUtil.a(), this.w);
      this.d.setCameraManagerListener(e());
      this.d.startCameraPreview(this.l, (Size)localObject);
      AEQLog.b(this.a, "tryStartPreview---EXIT, normal");
      return;
    }
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryStartPreview---EXIT, not right mode: ");
    localStringBuilder.append(localObject);
    AEQLog.d(str, localStringBuilder.toString());
  }
  
  public void B()
  {
    AEQLog.b(this.a, "tryOpenCamera---ENTER");
    if (!y())
    {
      AEQLog.d(this.a, "tryOpenCamera---EXIT, not called by the top unit");
      return;
    }
    AECaptureMode localAECaptureMode = this.x;
    if ((localAECaptureMode != null) && (localAECaptureMode.shouldStartCamera()))
    {
      this.d.openCamera(new AEBaseCameraUnit.3(this));
      return;
    }
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryOpenCamera---EXIT, not right mode: ");
    localStringBuilder.append(localAECaptureMode);
    AEQLog.d(str, localStringBuilder.toString());
  }
  
  protected void C()
  {
    if (this.C)
    {
      B();
      return;
    }
    if (!this.B)
    {
      this.B = true;
      D();
      return;
    }
    K();
  }
  
  protected void D()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    if ((this.b.getActivity() instanceof BaseActivity))
    {
      BaseActivity localBaseActivity = (BaseActivity)this.b.getActivity();
      int i1;
      if (localBaseActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i2;
      if (localBaseActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      boolean bool = PermissionUtils.isStorePermissionEnable(localBaseActivity);
      LinkedList localLinkedList = new LinkedList();
      if (i1 != 0) {
        localLinkedList.add("android.permission.CAMERA");
      }
      if (i2 != 0) {
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
  
  protected boolean E()
  {
    return true;
  }
  
  protected IntentFilter F()
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
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_AGE.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_GAZE.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_HAND.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_SEG_HAIR.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_SEG_SKY.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_SEG_HEAD.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_SCENE.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_BODY.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_BODY_3D.resPrefix);
    localIntentFilter.addAction(AEResInfo.LIGHT_RES_BUNDLE_EMOTION.resPrefix);
    return localIntentFilter;
  }
  
  protected AECaptureParam G()
  {
    return DovSVParamManager.a().a(this.z);
  }
  
  protected void H()
  {
    int i1;
    if (this.d.isFlashEnabled())
    {
      i1 = 1500;
      this.d.turnFlash(s(), true);
    }
    else
    {
      i1 = 0;
    }
    this.h.capturePhotoByAEKit(i1);
  }
  
  protected void I()
  {
    Object localObject1 = this.x;
    if ((localObject1 != null) && (((AECaptureMode)localObject1).shouldStartCamera()) && (AEPreviewSizeUtil.a() != null))
    {
      if (this.d.isFlashEnabled()) {
        this.d.turnFlash(s(), true);
      }
      localObject1 = AEPreviewSizeUtil.a(this.x, AEPreviewSizeUtil.a(), this.w);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.h.getCaptureDir());
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append(System.currentTimeMillis());
      ((StringBuilder)localObject2).append(".jpg");
      localObject2 = ((StringBuilder)localObject2).toString();
      FileUtils.createFileIfNotExits((String)localObject2);
      localObject2 = new File((String)localObject2);
      this.d.isFrontCamera();
      int i1;
      if (this.z.p()) {
        i1 = CaptureUtil.c(this.d.getActivityOrientation());
      } else {
        i1 = 0;
      }
      this.d.capturePhoto((File)localObject2, i1, new AEBaseCameraUnit.4(this), (Size)localObject1);
    }
  }
  
  protected boolean J()
  {
    return true;
  }
  
  protected void K()
  {
    Activity localActivity = this.b.getActivity();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      if (this.f == null) {
        this.f = new AECameraErrorDialog(localActivity);
      }
      this.f.a(new AEBaseCameraUnit.5(this));
    }
  }
  
  public boolean L()
  {
    return AECameraEntryManager.p(s().getIntent());
  }
  
  public boolean M()
  {
    return AECameraEntryManager.o(s().getIntent());
  }
  
  protected abstract BroadcastReceiver a();
  
  public AECaptureMode a(int paramInt)
  {
    return AECaptureMode.NORMAL;
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    a(false);
    this.C = r();
    if (paramBundle != null)
    {
      this.o = ((AEVideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
      this.t = paramBundle.getInt("KEY_IDENTITY_CODE_SAVE");
      paramBundle = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate, restore from background, ID=");
      localStringBuilder.append(this.t);
      AEQLog.b(paramBundle, localStringBuilder.toString());
    }
    else
    {
      this.t = (s.size() + 1);
      paramBundle = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate, new created, ID=");
      localStringBuilder.append(this.t);
      AEQLog.b(paramBundle, localStringBuilder.toString());
    }
    this.e.a();
    AECameraGetInfoClient.b();
    if (!s.contains(Integer.valueOf(this.t))) {
      s.push(Integer.valueOf(this.t));
    }
    s().registerReceiver(a(), F());
    paramBundle = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate, ID=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", sUnitStack=");
    localStringBuilder.append(s);
    AEQLog.b(paramBundle, localStringBuilder.toString());
  }
  
  protected void a(String paramString)
  {
    AELaunchRecorder.d().a(paramString);
  }
  
  protected void a(boolean paramBoolean)
  {
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), paramBoolean, 5);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, paramBoolean);
  }
  
  public void b()
  {
    if (this.h.captureByCameraProxy())
    {
      QLog.i(this.a, 1, "onCaptureButtonPhoto---capturePhotoByCameraProxy");
      AEDashboardUtil.a.p = false;
      I();
    }
    else
    {
      QLog.i(this.a, 1, "conCaptureButtonPhoto---apturePhotoByAEKit");
      AEDashboardUtil.a.p = true;
      H();
    }
    i();
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putSerializable("KEY_VIDEO_RESULT", this.o);
    paramBundle.putInt("KEY_IDENTITY_CODE_SAVE", this.t);
    paramBundle = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSaveInstanceState---destroyed in background, ID=");
    localStringBuilder.append(this.t);
    AEQLog.b(paramBundle, localStringBuilder.toString());
  }
  
  public void b(boolean paramBoolean)
  {
    AEQLog.b(this.a, "closeCamera");
    if (!y())
    {
      AEQLog.d(this.a, "closeCamera---EXIT, not called by the top unit");
      return;
    }
    this.d.stopCamera(paramBoolean);
  }
  
  public AECaptureMode[] b(int paramInt)
  {
    return new AECaptureMode[] { AECaptureMode.NORMAL, AECaptureMode.PLAY, AECaptureMode.GIF };
  }
  
  protected abstract void c();
  
  public void c(boolean paramBoolean)
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
  
  protected abstract void d();
  
  public boolean d(boolean paramBoolean)
  {
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 23))
    {
      Activity localActivity = s();
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
      this.d.switchFlash(paramBoolean);
    }
    return bool;
  }
  
  protected abstract AECameraManager.CameraManagerListener e();
  
  protected abstract DarkModeChecker.DarkModeListener f();
  
  protected abstract void g();
  
  protected abstract boolean h();
  
  public abstract void i();
  
  public View j()
  {
    a("unitInflateView-begin");
    this.g = s().getLayoutInflater().inflate(n(), null, false);
    a("unitInflateView-end");
    p();
    x();
    return this.g;
  }
  
  public void k()
  {
    super.k();
    this.A = true;
    this.h.onResume();
    z();
    b(false);
    this.C = r();
    C();
  }
  
  public void l()
  {
    super.l();
    this.A = false;
    this.h.onPause();
    z();
    b(false);
  }
  
  public void m()
  {
    super.m();
    s().unregisterReceiver(a());
    b(true);
    GLGestureProxy.getInstance().removeAllListener();
    PlayDownloadManagerWrap.getInstance().clearObserver();
    this.h.onDestroy();
    WatermarkDataManager.a().b();
    CosFunHelper.setCountDownListener(null);
    a(true);
    if (y())
    {
      s.pop();
      str = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy, is on top, ID=");
      localStringBuilder.append(this.t);
      AEQLog.b(str, localStringBuilder.toString());
    }
    else
    {
      str = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy, is NOT on top, ID=");
      localStringBuilder.append(this.t);
      AEQLog.b(str, localStringBuilder.toString());
    }
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy, ID=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", sUnitStack=");
    localStringBuilder.append(s);
    AEQLog.b(str, localStringBuilder.toString());
  }
  
  protected int n()
  {
    return 2064056394;
  }
  
  public void o()
  {
    if (AECameraEntryManager.q(s().getIntent()))
    {
      AEQLog.a(this.a, "can not toggle Camera in ar cake mode");
      return;
    }
    this.d.toggleCamera(new AEBaseCameraUnit.2(this));
  }
  
  public void onAEKitInited()
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAEKitInited: thread = ");
    localStringBuilder.append(Thread.currentThread().getName());
    Log.d(str, localStringBuilder.toString());
  }
  
  protected void p()
  {
    this.m = ((LinearLayout)this.g.findViewById(2063990908));
    this.n = ((RelativeLayout)this.g.findViewById(2063990907));
    this.h = ((AECameraGLSurfaceView)this.g.findViewById(2063990947));
    this.j = ((ViewStub)this.g.findViewById(2063991434));
  }
  
  @NotNull
  protected DarkModeChecker q()
  {
    return new DarkModeChecker();
  }
  
  protected boolean r()
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      AEQLog.b(this.a, "checkPermission---below android6.0, no need check");
      return true;
    }
    Object localObject = s();
    int i1 = ((Activity)localObject).checkSelfPermission("android.permission.CAMERA");
    int i2 = ((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO");
    boolean bool = PermissionUtils.isStorePermissionEnable((Context)localObject);
    localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkPermission, camera: ");
    localStringBuilder.append(i1);
    localStringBuilder.append(" audio: ");
    localStringBuilder.append(i2);
    localStringBuilder.append(", storage=");
    localStringBuilder.append(bool);
    AEQLog.b((String)localObject, localStringBuilder.toString());
    return (i1 == 0) && (i2 == 0) && (bool);
  }
  
  public void reportFirstFrameShown()
  {
    AEBaseDataReporter localAEBaseDataReporter = AEBaseDataReporter.a();
    int i1;
    if (this.d.isSupportCamera2()) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    localAEBaseDataReporter.d(i1);
  }
  
  public Activity s()
  {
    IQIMCameraContainer localIQIMCameraContainer = this.b;
    if (localIQIMCameraContainer == null) {
      return null;
    }
    return localIQIMCameraContainer.getActivity();
  }
  
  protected AECameraConfig t()
  {
    return v();
  }
  
  public AECameraConfig u()
  {
    if (this.z == null) {
      this.z = t();
    }
    return this.z;
  }
  
  protected AECameraConfig v()
  {
    AECameraConfig.Builder localBuilder = new AECameraConfig.Builder();
    Intent localIntent = s().getIntent();
    if ((localIntent != null) && (localIntent.getExtras() != null))
    {
      boolean bool1 = localIntent.getExtras().getBoolean("PeakConstants.ARG_AUDIO", true);
      int i1 = localIntent.getExtras().getInt("ARG_CAPTURE_MAX_DURATION", -1);
      boolean bool2 = localIntent.getExtras().getBoolean("PeakConstants.ARG_SUPPORT_FILTER", true);
      boolean bool3 = localIntent.getExtras().getBoolean("PeakConstants.ARG_SUPPORT_DD", true);
      boolean bool4 = localIntent.getExtras().getBoolean("PeakConstants.ARG_BEAUTY", true);
      boolean bool5 = localIntent.getExtras().getBoolean("PeakConstants.ARG_SHARP_FACE", true);
      boolean bool6 = localIntent.getExtras().getBoolean("PeakConstants.ARG_ALBUM", true);
      int i2 = localIntent.getExtras().getInt("ARG_DEFAULT_OPEN_PANEL", -1);
      int i3 = localIntent.getExtras().getInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
      int i4 = localIntent.getExtras().getInt("edit_video_way", 0);
      int i5 = localIntent.getExtras().getInt("entrance_type", 120);
      int i6 = localIntent.getExtras().getInt("extra.busi_type", 14);
      SessionWrap localSessionWrap = (SessionWrap)localIntent.getParcelableExtra("ARG_SESSION_INFO");
      String str = localIntent.getStringExtra("ARG_AIO_CLASS");
      int i7 = localIntent.getExtras().getInt("key_camera_photo_edit_type", -1);
      int i8 = localIntent.getExtras().getInt("key_camera_video_edit_type", -1);
      int i9 = localIntent.getExtras().getInt("ability_flag", -1);
      int i10 = localIntent.getIntExtra("AECAMERA_MODE", 200);
      boolean bool7 = localIntent.getBooleanExtra("key_camera_use_video_orientation", true);
      boolean bool8 = localIntent.getBooleanExtra("key_camera_auto_rotate", true);
      this.v = b(i10);
      this.u = a(i10);
      boolean bool9 = s().getIntent().getBooleanExtra("key_has_countdown", false);
      int i11 = w();
      int i12 = localIntent.getIntExtra("PeakConstants.ARG_FORCE_CAMERA", 0);
      int i13 = localIntent.getIntExtra("key_camera_result_code", -1);
      localBuilder.f(i3).a(i13).a(bool1).c(bool4).c(i2).e(bool2).b(i1).d(bool5).f(bool3).b(bool6).m(i9).l(i5).d(i6).e(i4).g(i7).h(i8).h(bool8).g(bool7).i(bool9).k(i10).a(this.u).a(this.v).a(localSessionWrap).a(str).j(i11).i(i12);
    }
    return localBuilder.a();
  }
  
  protected int w()
  {
    return AEVideoStoryTopBarViewModel.Ratio.FULL.code;
  }
  
  protected void x()
  {
    AECaptureMode.NORMAL.setHasCountDown(this.z.A());
    this.w = AEVideoStoryTopBarViewModel.Ratio.fromCode(this.z.t());
    this.x = this.z.x();
    N();
    c();
    d();
  }
  
  protected boolean y()
  {
    Integer localInteger = (Integer)s.peek();
    return (localInteger != null) && (localInteger.intValue() == this.t);
  }
  
  public void z()
  {
    AEQLog.b(this.a, "stopPreview");
    if (!y())
    {
      AEQLog.d(this.a, "stopPreview---EXIT, not called by the top unit");
      return;
    }
    this.d.cameraStopPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEBaseCameraUnit
 * JD-Core Version:    0.7.0.1
 */