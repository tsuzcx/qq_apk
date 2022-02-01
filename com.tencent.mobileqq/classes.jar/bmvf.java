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
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.play.PlayDownloadManagerWrap;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import mqq.app.BaseActivity;
import org.jetbrains.annotations.NotNull;

public abstract class bmvf
  extends bmut
  implements AECameraGLSurfaceView.AEKitInitListener, AECameraGLSurfaceView.CaptureListener
{
  protected static final LinkedList<Integer> a;
  protected volatile SurfaceTexture a;
  public Handler a;
  public View a;
  protected ViewStub a;
  protected LinearLayout a;
  protected RelativeLayout a;
  public bmvr a;
  protected bnay a;
  protected bnqz a;
  public bnrs a;
  protected boqz a;
  public borg a;
  public borh a;
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
  
  public bmvf()
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager = new AECameraManager();
    this.jdField_a_of_type_Bnqz = new bnqz();
    this.jdField_a_of_type_Boqz = new boqz(10000, 100, 2);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    bnrh.b(this.jdField_a_of_type_JavaLangString, "[AEBaseCameraUnit] + BEGIN");
    bnrh.a(this.jdField_a_of_type_JavaLangString, "unitConstructor--fake");
    bnrh.b(this.jdField_a_of_type_JavaLangString, "[AEBaseCameraUnit] + END");
  }
  
  public bmvf(borh paramborh, borg paramborg)
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager = new AECameraManager();
    this.jdField_a_of_type_Bnqz = new bnqz();
    this.jdField_a_of_type_Boqz = new boqz(10000, 100, 2);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    bnrh.b(this.jdField_a_of_type_JavaLangString, "[AEBaseCameraUnit] + BEGIN");
    this.jdField_a_of_type_Borh = paramborh;
    this.jdField_a_of_type_Borg = paramborg;
    this.jdField_a_of_type_Bmvr = a();
  }
  
  private AudioCapture a(bnax parambnax)
  {
    return new AudioCapture(parambnax.jdField_a_of_type_JavaLangString, 1, CodecParam.mAudioSampleRate, CodecParam.mAudioChannel, CodecParam.mAudioFormat, this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView, this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.getCameraHandler());
  }
  
  private void a()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAEKitInitListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setIsVoiceNeedEncode(a());
    bnax localbnax = a();
    if (this.jdField_a_of_type_Bmvr.d()) {}
    for (AudioCapture localAudioCapture = a(localbnax);; localAudioCapture = null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.init(localbnax, localAudioCapture);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setBeautyEnable(this.jdField_a_of_type_Bmvr.c());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setFaceEffectEnable(this.jdField_a_of_type_Bmvr.e());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setFilterEnable(this.jdField_a_of_type_Bmvr.f());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setSharpFaceEnable(this.jdField_a_of_type_Bmvr.a());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setPreExtractFrame(f());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setUseVideoOrientation(this.jdField_a_of_type_Bmvr.h());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.init(localbnax);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setAudioCapture(localAudioCapture);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setDarkModeEnable(this.jdField_a_of_type_Bmvr.i());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setDarkModeListener(a());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setDarkModeChecker(a());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setCameraManagerListener(a());
      return;
    }
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
  
  protected int a()
  {
    return 2131558527;
  }
  
  public Activity a()
  {
    if (this.jdField_a_of_type_Borh == null) {
      return null;
    }
    return this.jdField_a_of_type_Borh.a();
  }
  
  protected abstract BroadcastReceiver a();
  
  protected IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction(bnkt.jdField_b_of_type_Bnkt.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(bnkt.c.jdField_b_of_type_JavaLangString);
    return localIntentFilter;
  }
  
  public View a()
  {
    a("unitInflateView-begin");
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(a(), null, false);
    a("unitInflateView-end");
    p();
    q();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  @NotNull
  protected bbho a()
  {
    return new bbho();
  }
  
  protected abstract bbhp a();
  
  protected bmvr a()
  {
    return c();
  }
  
  protected bnax a()
  {
    return bpnj.a().a(this.jdField_a_of_type_Bmvr);
  }
  
  protected abstract AECameraManager.CameraManagerListener a();
  
  public AECaptureMode a(int paramInt)
  {
    return AECaptureMode.NORMAL;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.changeCamera(paramInt, new bmvg(this));
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    c(false);
    this.jdField_c_of_type_Boolean = d();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = ((AEVideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
      this.jdField_c_of_type_Int = paramBundle.getInt("KEY_IDENTITY_CODE_SAVE");
      bnrh.b(this.jdField_a_of_type_JavaLangString, "onCreate, restore from background, ID=" + this.jdField_c_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bnqz.a();
      bnqi.a();
      if (!jdField_a_of_type_JavaUtilLinkedList.contains(Integer.valueOf(this.jdField_c_of_type_Int))) {
        jdField_a_of_type_JavaUtilLinkedList.push(Integer.valueOf(this.jdField_c_of_type_Int));
      }
      a().registerReceiver(a(), a());
      bnrh.b(this.jdField_a_of_type_JavaLangString, "onCreate, ID=" + this.jdField_c_of_type_Int + ", sUnitStack=" + jdField_a_of_type_JavaUtilLinkedList);
      return;
      this.jdField_c_of_type_Int = (jdField_a_of_type_JavaUtilLinkedList.size() + 1);
      bnrh.b(this.jdField_a_of_type_JavaLangString, "onCreate, new created, ID=" + this.jdField_c_of_type_Int);
    }
  }
  
  protected void a(String paramString)
  {
    bnqe.a().a(paramString);
  }
  
  protected boolean a()
  {
    return true;
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
          bhdj.a(localActivity, null, null);
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
  
  public bmvr b()
  {
    if (this.jdField_a_of_type_Bmvr == null) {
      this.jdField_a_of_type_Bmvr = a();
    }
    return this.jdField_a_of_type_Bmvr;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onPause();
    r();
    d(false);
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putSerializable("KEY_VIDEO_RESULT", this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
    paramBundle.putInt("KEY_IDENTITY_CODE_SAVE", this.jdField_c_of_type_Int);
    bnrh.b(this.jdField_a_of_type_JavaLangString, "onSaveInstanceState---destroyed in background, ID=" + this.jdField_c_of_type_Int);
  }
  
  protected bmvr c()
  {
    bmvt localbmvt = new bmvt();
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
      int k = localIntent.getExtras().getInt("VIDEO_STORY_FROM_TYPE", bnlb.a.a());
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
      int i8 = localIntent.getIntExtra("key_camera_result_code", -1);
      localbmvt.f(k).a(i8).a(bool1).c(bool4).c(j).e(bool2).b(i).d(bool5).f(bool3).b(bool6).m(i4).l(n).d(i1).e(m).g(i2).h(i3).h(bool8).g(bool7).i(bool9).k(i5).a(this.jdField_a_of_type_DovComQqImAeModeAECaptureMode).a(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode).a(localSessionWrap).a(str).j(i6).i(i7);
    }
    return localbmvt.a();
  }
  
  public void c()
  {
    super.c();
    a().unregisterReceiver(a());
    d(true);
    GLGestureProxy.getInstance().removeAllListener();
    PlayDownloadManagerWrap.getInstance().clearObserver();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onDestroy();
    bnhs.a().b();
    CosFunHelper.setCountDownListener(null);
    c(true);
    if (e())
    {
      jdField_a_of_type_JavaUtilLinkedList.pop();
      bnrh.b(this.jdField_a_of_type_JavaLangString, "onDestroy, is on top, ID=" + this.jdField_c_of_type_Int);
    }
    for (;;)
    {
      bnrh.b(this.jdField_a_of_type_JavaLangString, "onDestroy, ID=" + this.jdField_c_of_type_Int + ", sUnitStack=" + jdField_a_of_type_JavaUtilLinkedList);
      return;
      bnrh.b(this.jdField_a_of_type_JavaLangString, "onDestroy, is NOT on top, ID=" + this.jdField_c_of_type_Int);
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    biwn.a(BaseApplicationImpl.getContext(), paramBoolean, 5);
    aqrl.a(BaseApplicationImpl.getContext(), 2, paramBoolean);
  }
  
  protected abstract boolean c();
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onResume();
    r();
    d(false);
    this.jdField_c_of_type_Boolean = d();
    u();
  }
  
  public void d(boolean paramBoolean)
  {
    bnrh.b(this.jdField_a_of_type_JavaLangString, "closeCamera");
    if (!e())
    {
      bnrh.d(this.jdField_a_of_type_JavaLangString, "closeCamera---EXIT, not called by the top unit");
      return;
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.stopCamera(paramBoolean);
  }
  
  protected boolean d()
  {
    if (Build.VERSION.SDK_INT < 23) {
      bnrh.b(this.jdField_a_of_type_JavaLangString, "checkPermission---below android6.0, no need check");
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
      bnrh.b(this.jdField_a_of_type_JavaLangString, "checkPermission, camera: " + i + " audio: " + j + ", storage=" + bool);
    } while ((i == 0) && (j == 0) && (bool));
    return false;
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
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilLinkedList.peek();
    return (localInteger != null) && (localInteger.intValue() == this.jdField_c_of_type_Int);
  }
  
  protected boolean f()
  {
    return true;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.captureByCameraProxy())
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "capturePhotoByCameraProxy");
      bnep.a.jdField_b_of_type_Boolean = false;
      x();
    }
    for (;;)
    {
      n();
      return;
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "capturePhotoByAEKit");
      bnep.a.jdField_b_of_type_Boolean = true;
      w();
    }
  }
  
  protected abstract void l();
  
  protected abstract void m();
  
  public abstract void n();
  
  public void o()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.toggleCamera(new bmvh(this));
  }
  
  public void onAEKitInited()
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "onAEKitInited: thread = " + Thread.currentThread().getName());
  }
  
  protected void p()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363645));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363643));
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364231));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378165));
  }
  
  protected void q()
  {
    AECaptureMode.NORMAL.setHasCountDown(this.jdField_a_of_type_Bmvr.j());
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.fromCode(this.jdField_a_of_type_Bmvr.h());
    this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = this.jdField_a_of_type_Bmvr.a();
    a();
    l();
  }
  
  public void r()
  {
    bnrh.b(this.jdField_a_of_type_JavaLangString, "stopPreview");
    if (!e())
    {
      bnrh.d(this.jdField_a_of_type_JavaLangString, "stopPreview---EXIT, not called by the top unit");
      return;
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.cameraStopPreview();
  }
  
  public void reportFirstFrameShown()
  {
    bnqm localbnqm = bnqm.a();
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isSupportCamera2()) {}
    for (int i = 2;; i = 1)
    {
      localbnqm.f(i);
      return;
    }
  }
  
  public void s()
  {
    bnrh.b(this.jdField_a_of_type_JavaLangString, "tryStartPreview---ENTER");
    if (!e())
    {
      bnrh.d(this.jdField_a_of_type_JavaLangString, "tryStartPreview---EXIT, not called by the top unit");
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      bnrh.d(this.jdField_a_of_type_JavaLangString, "tryStartPreview---EXIT, activity not resumed");
      return;
    }
    Object localObject = this.jdField_b_of_type_DovComQqImAeModeAECaptureMode;
    if ((localObject == null) || (!((AECaptureMode)localObject).shouldStartCamera()))
    {
      bnrh.d(this.jdField_a_of_type_JavaLangString, "tryStartPreview---EXIT, not right mode: " + localObject);
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null)
    {
      bnrh.d(this.jdField_a_of_type_JavaLangString, "tryStartPreview---EXIT, mPreviewTexture is NULL");
      return;
    }
    if (bnrg.a() == null)
    {
      bnrh.d(this.jdField_a_of_type_JavaLangString, "tryStartPreview---EXIT, mMaxPreviewSize is NULL");
      return;
    }
    localObject = bnrg.a((AECaptureMode)localObject, bnrg.a(), this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setCameraManagerListener(a());
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.startCameraPreview(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, (alsn)localObject);
    bnrh.b(this.jdField_a_of_type_JavaLangString, "tryStartPreview---EXIT, normal");
  }
  
  public void t()
  {
    bnrh.b(this.jdField_a_of_type_JavaLangString, "tryOpenCamera---ENTER");
    if (!e())
    {
      bnrh.d(this.jdField_a_of_type_JavaLangString, "tryOpenCamera---EXIT, not called by the top unit");
      return;
    }
    AECaptureMode localAECaptureMode = this.jdField_b_of_type_DovComQqImAeModeAECaptureMode;
    if ((localAECaptureMode == null) || (!localAECaptureMode.shouldStartCamera()))
    {
      bnrh.d(this.jdField_a_of_type_JavaLangString, "tryOpenCamera---EXIT, not right mode: " + localAECaptureMode);
      return;
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.openCamera(new bmvi(this));
  }
  
  protected void u()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      t();
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      v();
      return;
    }
    y();
  }
  
  protected void v()
  {
    if (Build.VERSION.SDK_INT < 23) {
      break label8;
    }
    label8:
    while (!(this.jdField_a_of_type_Borh.a() instanceof BaseActivity)) {
      return;
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_Borh.a();
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
  
  protected void w()
  {
    int i = 0;
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFlashEnabled())
    {
      i = 1500;
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.turnFlash(a(), true);
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.capturePhotoByAEKit(i);
  }
  
  protected void x()
  {
    alsn localalsn;
    Object localObject;
    boolean bool;
    if ((this.jdField_b_of_type_DovComQqImAeModeAECaptureMode != null) && (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera()) && (bnrg.a() != null))
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFlashEnabled()) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.turnFlash(a(), true);
      }
      localalsn = bnrg.a(this.jdField_b_of_type_DovComQqImAeModeAECaptureMode, bnrg.a(), this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
      localObject = this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getCaptureDir() + "/" + System.currentTimeMillis() + ".jpg";
      FileUtils.createFileIfNotExits((String)localObject);
      localObject = new File((String)localObject);
      bool = this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFrontCamera();
      if (!this.jdField_a_of_type_Bmvr.g()) {
        break label166;
      }
    }
    label166:
    for (int i = bbhm.c(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.getActivityOrientation());; i = 0)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.capturePhoto((File)localObject, i, bool, new bmvj(this), localalsn);
      return;
    }
  }
  
  public void y()
  {
    Activity localActivity = this.jdField_a_of_type_Borh.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (this.jdField_a_of_type_Bnrs == null) {
      this.jdField_a_of_type_Bnrs = new bnrs(localActivity);
    }
    this.jdField_a_of_type_Bnrs.a(new AEBaseCameraUnit.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvf
 * JD-Core Version:    0.7.0.1
 */