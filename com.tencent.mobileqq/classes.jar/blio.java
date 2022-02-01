import android.app.Activity;
import android.content.BroadcastReceiver;
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
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.shortvideo.filter.QQLowLightFilter;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.CosFunHelper;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.ae.AEBaseCameraUnit.5;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.ae.camera.AEVideoCaptureResult;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.AEKitInitListener;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.CaptureListener;
import dov.com.qq.im.ae.camera.core.AECameraManager;
import dov.com.qq.im.ae.camera.core.AECameraManager.CameraManagerListener;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.play.PlayDownloadManagerWrap;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import mqq.app.BaseActivity;
import org.jetbrains.annotations.NotNull;

public abstract class blio
  extends blic
  implements AECameraGLSurfaceView.AEKitInitListener, AECameraGLSurfaceView.CaptureListener
{
  protected static final LinkedList<Integer> a;
  protected volatile SurfaceTexture a;
  public Handler a;
  public View a;
  protected ViewStub a;
  protected LinearLayout a;
  protected RelativeLayout a;
  public blit a;
  protected bmbp a;
  public bmcb a;
  protected bnbh a;
  public bnbo a;
  public bnbp a;
  protected CameraFocusView a;
  protected LocalMediaInfo a;
  protected AEVideoCaptureResult a;
  public AECameraGLSurfaceView a;
  public AECameraManager a;
  protected AEVideoStoryTopBarViewModel.Ratio a;
  public AECaptureMode a;
  public AbsAECaptureButton a;
  public final String a;
  public boolean a;
  protected AECaptureMode[] a;
  public AECaptureMode b;
  protected volatile boolean b;
  protected int c;
  protected volatile boolean c;
  protected int d = 11;
  
  static
  {
    jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  }
  
  public blio()
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager = new AECameraManager();
    this.jdField_a_of_type_Bmbp = new bmbp();
    this.jdField_a_of_type_Bnbh = new bnbh(10000, 100, 2);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    bmbx.b(this.jdField_a_of_type_JavaLangString, "[AEBaseCameraUnit] + BEGIN");
    bmbx.a(this.jdField_a_of_type_JavaLangString, "unitConstructor--fake");
    bmbx.b(this.jdField_a_of_type_JavaLangString, "[AEBaseCameraUnit] + END");
  }
  
  public blio(bnbp parambnbp, bnbo parambnbo)
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager = new AECameraManager();
    this.jdField_a_of_type_Bmbp = new bmbp();
    this.jdField_a_of_type_Bnbh = new bnbh(10000, 100, 2);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    bmbx.b(this.jdField_a_of_type_JavaLangString, "[AEBaseCameraUnit] + BEGIN");
    this.jdField_a_of_type_Bnbp = parambnbp;
    this.jdField_a_of_type_Bnbo = parambnbo;
    this.jdField_a_of_type_Blit = a();
  }
  
  private AudioCapture a(blno paramblno)
  {
    return new AudioCapture(paramblno.jdField_a_of_type_JavaLangString, 1, CodecParam.mAudioSampleRate, CodecParam.mAudioChannel, CodecParam.mAudioFormat, this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView, this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.getCameraHandler());
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
  
  private void v()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAEKitInitListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setIsVoiceNeedEncode(e());
    blno localblno = a();
    if (this.jdField_a_of_type_Blit.d()) {}
    for (AudioCapture localAudioCapture = a(localblno);; localAudioCapture = null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.init(localblno, localAudioCapture);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setBeautyEnable(this.jdField_a_of_type_Blit.c());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setFaceEffectEnable(this.jdField_a_of_type_Blit.e());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setFilterEnable(this.jdField_a_of_type_Blit.f());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setSharpFaceEnable(this.jdField_a_of_type_Blit.a());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setPreExtractFrame(f());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setUseVideoOrientation(this.jdField_a_of_type_Blit.h());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.init(localblno);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setAudioCapture(localAudioCapture);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setDarkModeEnable(this.jdField_a_of_type_Blit.i());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setDarkModeListener(a());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setDarkModeChecker(a());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setCameraManagerListener(a());
      return;
    }
  }
  
  protected int a()
  {
    return 2131558516;
  }
  
  public Activity a()
  {
    if (this.jdField_a_of_type_Bnbp == null) {
      return null;
    }
    return this.jdField_a_of_type_Bnbp.a();
  }
  
  protected abstract BroadcastReceiver a();
  
  protected IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction(AEResInfo.AE_RES_BASE_PACKAGE.resPrefix);
    localIntentFilter.addAction(AEResInfo.AE_RES_ADDITIONAL_PACKAGE.resPrefix);
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
  
  @NotNull
  protected babf a()
  {
    return new babf();
  }
  
  protected abstract babg a();
  
  protected blit a()
  {
    return c();
  }
  
  protected blno a()
  {
    return bnxr.a().a(this.jdField_a_of_type_Blit);
  }
  
  protected abstract AECameraManager.CameraManagerListener a();
  
  public AECaptureMode a(int paramInt)
  {
    return AECaptureMode.NORMAL;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.isEffectAvailable())
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "capturePhotoByCameraProxy");
      blrg.a.jdField_b_of_type_Boolean = false;
      t();
    }
    for (;;)
    {
      g();
      return;
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "capturePhotoByAEKit");
      blrg.a.jdField_b_of_type_Boolean = true;
      s();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.changeCamera(paramInt, new blip(this));
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    c(false);
    this.jdField_c_of_type_Boolean = c();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = ((AEVideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
      this.jdField_c_of_type_Int = paramBundle.getInt("KEY_IDENTITY_CODE_SAVE");
      bmbx.b(this.jdField_a_of_type_JavaLangString, "onCreate, restore from background, ID=" + this.jdField_c_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bmbp.a();
      bmay.a();
      if (!jdField_a_of_type_JavaUtilLinkedList.contains(Integer.valueOf(this.jdField_c_of_type_Int))) {
        jdField_a_of_type_JavaUtilLinkedList.push(Integer.valueOf(this.jdField_c_of_type_Int));
      }
      a().registerReceiver(a(), a());
      bmbx.b(this.jdField_a_of_type_JavaLangString, "onCreate, ID=" + this.jdField_c_of_type_Int + ", sUnitStack=" + jdField_a_of_type_JavaUtilLinkedList);
      return;
      this.jdField_c_of_type_Int = (jdField_a_of_type_JavaUtilLinkedList.size() + 1);
      bmbx.b(this.jdField_a_of_type_JavaLangString, "onCreate, new created, ID=" + this.jdField_c_of_type_Int);
    }
  }
  
  protected void a(String paramString)
  {
    bmau.a().a(paramString);
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramBoolean)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 23)
      {
        Activity localActivity = a();
        bool1 = bool2;
        if (!Settings.System.canWrite(localActivity))
        {
          bfur.a(localActivity, null, null);
          bool1 = false;
        }
      }
    }
    if (bool1) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.switchFlash(paramBoolean);
    }
    return bool1;
  }
  
  public AECaptureMode[] a(int paramInt)
  {
    return new AECaptureMode[] { AECaptureMode.NORMAL, AECaptureMode.PLAY, AECaptureMode.GIF };
  }
  
  protected int b()
  {
    return AEVideoStoryTopBarViewModel.Ratio.FULL.code;
  }
  
  public blit b()
  {
    if (this.jdField_a_of_type_Blit == null) {
      this.jdField_a_of_type_Blit = a();
    }
    return this.jdField_a_of_type_Blit;
  }
  
  protected abstract void b();
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putSerializable("KEY_VIDEO_RESULT", this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
    paramBundle.putInt("KEY_IDENTITY_CODE_SAVE", this.jdField_c_of_type_Int);
    bmbx.b(this.jdField_a_of_type_JavaLangString, "onSaveInstanceState---destroyed in background, ID=" + this.jdField_c_of_type_Int);
  }
  
  protected abstract boolean b();
  
  protected blit c()
  {
    bliv localbliv = new bliv();
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
      int k = localIntent.getExtras().getInt("VIDEO_STORY_FROM_TYPE", blvr.a.a());
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
      this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = a(i5);
      this.jdField_a_of_type_DovComQqImAeModeAECaptureMode = a(i5);
      boolean bool9 = a().getIntent().getBooleanExtra("key_has_countdown", false);
      int i6 = b();
      int i7 = localIntent.getIntExtra("PeakConstants.ARG_FORCE_CAMERA", 0);
      localbliv.e(k).a(bool1).c(bool4).b(j).e(bool2).a(i).d(bool5).f(bool3).b(bool6).l(i4).k(n).c(i1).d(m).f(i2).g(i3).h(bool8).g(bool7).i(bool9).j(i5).a(this.jdField_a_of_type_DovComQqImAeModeAECaptureMode).a(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode).a(localSessionWrap).a(str).i(i6).h(i7);
    }
    return localbliv.a();
  }
  
  protected abstract void c();
  
  protected void c(boolean paramBoolean)
  {
    bhlx.a(BaseApplicationImpl.getContext(), paramBoolean, 5);
    apoh.a(BaseApplicationImpl.getContext(), 2, paramBoolean);
  }
  
  protected boolean c()
  {
    if (Build.VERSION.SDK_INT < 23) {
      bmbx.b(this.jdField_a_of_type_JavaLangString, "checkPermission---below android6.0, no need check");
    }
    int i;
    int j;
    boolean bool;
    do
    {
      return true;
      Activity localActivity = a();
      i = localActivity.checkSelfPermission("android.permission.CAMERA");
      j = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
      bool = PermissionUtils.isStorePermissionEnable(localActivity);
      bmbx.b(this.jdField_a_of_type_JavaLangString, "checkPermission, camera: " + i + " audio: " + j + ", storage=" + bool);
    } while ((i == 0) && (j == 0) && (bool));
    return false;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onPause();
    k();
    d(false);
  }
  
  public void d(boolean paramBoolean)
  {
    bmbx.b(this.jdField_a_of_type_JavaLangString, "closeCamera");
    if (!d())
    {
      bmbx.d(this.jdField_a_of_type_JavaLangString, "closeCamera---EXIT, not called by the top unit");
      return;
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.stopCamera(paramBoolean);
  }
  
  protected boolean d()
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilLinkedList.peek();
    return (localInteger != null) && (localInteger.intValue() == this.jdField_c_of_type_Int);
  }
  
  public void e()
  {
    super.e();
    a().unregisterReceiver(a());
    d(true);
    GLGestureProxy.getInstance().removeAllListener();
    PlayDownloadManagerWrap.getInstance().clearObserver();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onDestroy();
    bltp.a().b();
    CosFunHelper.setCountDownListener(null);
    c(true);
    if (d())
    {
      jdField_a_of_type_JavaUtilLinkedList.pop();
      bmbx.b(this.jdField_a_of_type_JavaLangString, "onDestroy, is on top, ID=" + this.jdField_c_of_type_Int);
    }
    for (;;)
    {
      bmbx.b(this.jdField_a_of_type_JavaLangString, "onDestroy, ID=" + this.jdField_c_of_type_Int + ", sUnitStack=" + jdField_a_of_type_JavaUtilLinkedList);
      return;
      bmbx.b(this.jdField_a_of_type_JavaLangString, "onDestroy, is NOT on top, ID=" + this.jdField_c_of_type_Int);
    }
  }
  
  protected void e(boolean paramBoolean)
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
  
  protected boolean e()
  {
    return true;
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onResume();
    k();
    d(false);
    this.jdField_c_of_type_Boolean = c();
    q();
  }
  
  protected boolean f()
  {
    return true;
  }
  
  public abstract void g();
  
  public void h()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.toggleCamera(new bliq(this));
  }
  
  protected void i()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363576));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363574));
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364156));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377879));
  }
  
  protected void j()
  {
    AECaptureMode.NORMAL.setHasCountDown(this.jdField_a_of_type_Blit.j());
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.fromCode(this.jdField_a_of_type_Blit.h());
    this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = this.jdField_a_of_type_Blit.a();
    v();
    b();
  }
  
  public void k()
  {
    bmbx.b(this.jdField_a_of_type_JavaLangString, "stopPreview");
    if (!d())
    {
      bmbx.d(this.jdField_a_of_type_JavaLangString, "stopPreview---EXIT, not called by the top unit");
      return;
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.cameraStopPreview();
  }
  
  public void l()
  {
    bmbx.b(this.jdField_a_of_type_JavaLangString, "tryStartPreview---ENTER");
    if (!d())
    {
      bmbx.d(this.jdField_a_of_type_JavaLangString, "tryStartPreview---EXIT, not called by the top unit");
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      bmbx.d(this.jdField_a_of_type_JavaLangString, "tryStartPreview---EXIT, activity not resumed");
      return;
    }
    Object localObject = this.jdField_b_of_type_DovComQqImAeModeAECaptureMode;
    if ((localObject == null) || (!((AECaptureMode)localObject).shouldStartCamera()))
    {
      bmbx.d(this.jdField_a_of_type_JavaLangString, "tryStartPreview---EXIT, not right mode: " + localObject);
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null)
    {
      bmbx.d(this.jdField_a_of_type_JavaLangString, "tryStartPreview---EXIT, mPreviewTexture is NULL");
      return;
    }
    if (bmbw.a() == null)
    {
      bmbx.d(this.jdField_a_of_type_JavaLangString, "tryStartPreview---EXIT, mMaxPreviewSize is NULL");
      return;
    }
    localObject = bmbw.a((AECaptureMode)localObject, bmbw.a(), this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setCameraManagerListener(a());
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.startCameraPreview(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, (akur)localObject);
    bmbx.b(this.jdField_a_of_type_JavaLangString, "tryStartPreview---EXIT, normal");
  }
  
  public void m()
  {
    bmbx.b(this.jdField_a_of_type_JavaLangString, "tryOpenCamera---ENTER");
    if (!d())
    {
      bmbx.d(this.jdField_a_of_type_JavaLangString, "tryOpenCamera---EXIT, not called by the top unit");
      return;
    }
    AECaptureMode localAECaptureMode = this.jdField_b_of_type_DovComQqImAeModeAECaptureMode;
    if ((localAECaptureMode == null) || (!localAECaptureMode.shouldStartCamera()))
    {
      bmbx.d(this.jdField_a_of_type_JavaLangString, "tryOpenCamera---EXIT, not right mode: " + localAECaptureMode);
      return;
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.openCamera(new blir(this));
  }
  
  public void onAEKitInited()
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "onAEKitInited: thread = " + Thread.currentThread().getName());
  }
  
  protected void q()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      m();
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      r();
      return;
    }
    u();
  }
  
  protected void r()
  {
    if (Build.VERSION.SDK_INT < 23) {
      break label8;
    }
    label8:
    while (!(this.jdField_a_of_type_Bnbp.a() instanceof BaseActivity)) {
      return;
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_Bnbp.a();
    int i;
    label51:
    int j;
    if (localBaseActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (localBaseActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label176;
      }
      j = 1;
      label64:
      if (PermissionUtils.isStorePermissionEnable(localBaseActivity)) {
        break label181;
      }
    }
    label176:
    label181:
    for (int k = 1;; k = 0)
    {
      LinkedList localLinkedList = new LinkedList();
      if (i != 0) {
        localLinkedList.add("android.permission.CAMERA");
      }
      if (j != 0) {
        localLinkedList.add("android.permission.RECORD_AUDIO");
      }
      if (k != 0)
      {
        localLinkedList.add("android.permission.READ_EXTERNAL_STORAGE");
        localLinkedList.add("android.permission.WRITE_EXTERNAL_STORAGE");
      }
      if (localLinkedList.size() <= 0) {
        break;
      }
      localBaseActivity.requestPermissions(this, 1, (String[])localLinkedList.toArray(new String[0]));
      return;
      i = 0;
      break label51;
      j = 0;
      break label64;
    }
  }
  
  public void reportFirstFrameShown()
  {
    bmbc localbmbc = bmbc.a();
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isSupportCamera2()) {}
    for (int i = 2;; i = 1)
    {
      localbmbc.f(i);
      return;
    }
  }
  
  protected void s()
  {
    int i = 0;
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFlashEnabled())
    {
      i = 1500;
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.turnFlash(a(), true);
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.capturePhotoByAEKit(i);
  }
  
  protected void t()
  {
    akur localakur;
    Object localObject;
    boolean bool;
    if ((this.jdField_b_of_type_DovComQqImAeModeAECaptureMode != null) && (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera()) && (bmbw.a() != null))
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFlashEnabled()) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.turnFlash(a(), true);
      }
      localakur = bmbw.a(this.jdField_b_of_type_DovComQqImAeModeAECaptureMode, bmbw.a(), this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
      localObject = this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getCaptureDir() + "/" + System.currentTimeMillis() + ".jpg";
      FileUtils.createFileIfNotExits((String)localObject);
      localObject = new File((String)localObject);
      bool = this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFrontCamera();
      if (!this.jdField_a_of_type_Blit.g()) {
        break label166;
      }
    }
    label166:
    for (int i = babd.c(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.getActivityOrientation());; i = 0)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.capturePhoto((File)localObject, i, bool, new blis(this), localakur);
      return;
    }
  }
  
  public void u()
  {
    Activity localActivity = this.jdField_a_of_type_Bnbp.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (this.jdField_a_of_type_Bmcb == null) {
      this.jdField_a_of_type_Bmcb = new bmcb(localActivity);
    }
    this.jdField_a_of_type_Bmcb.a(new AEBaseCameraUnit.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blio
 * JD-Core Version:    0.7.0.1
 */