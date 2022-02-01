import android.annotation.TargetApi;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
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
import com.tencent.aekit.api.standard.filter.AEFilterManager.StickerInnerEffectFilterListener;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.filter.QQLowLightFilter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.filter.CosFunHelper;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;
import cooperation.qzone.QzonePluginProxyActivity;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.ae.AEPituCameraUnit.1;
import dov.com.qq.im.ae.AEPituCameraUnit.10;
import dov.com.qq.im.ae.AEPituCameraUnit.11;
import dov.com.qq.im.ae.AEPituCameraUnit.12;
import dov.com.qq.im.ae.AEPituCameraUnit.13;
import dov.com.qq.im.ae.AEPituCameraUnit.14;
import dov.com.qq.im.ae.AEPituCameraUnit.16;
import dov.com.qq.im.ae.AEPituCameraUnit.17;
import dov.com.qq.im.ae.AEPituCameraUnit.18;
import dov.com.qq.im.ae.AEPituCameraUnit.20;
import dov.com.qq.im.ae.AEPituCameraUnit.21;
import dov.com.qq.im.ae.AEPituCameraUnit.22;
import dov.com.qq.im.ae.AEPituCameraUnit.23;
import dov.com.qq.im.ae.AEPituCameraUnit.24;
import dov.com.qq.im.ae.AEPituCameraUnit.29;
import dov.com.qq.im.ae.AEPituCameraUnit.30;
import dov.com.qq.im.ae.AEPituCameraUnit.31;
import dov.com.qq.im.ae.AEPituCameraUnit.6;
import dov.com.qq.im.ae.AEPituCameraUnit.7;
import dov.com.qq.im.ae.AEPituCameraUnit.8;
import dov.com.qq.im.ae.AEPituCameraUnit.9;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.ae.camera.AEVideoCaptureResult;
import dov.com.qq.im.ae.camera.core.AECameraBroadcastReceiver;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.gif.AEStoryGIFPreviewActivity;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.ae.view.AEPituCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

@TargetApi(9)
public class bofh
  extends bocu
  implements View.OnClickListener, View.OnTouchListener, bbgk, boir, bois, boit, bonq, bpay, bpwg, brac, brae, breb, AEFilterManager.StickerInnerEffectFilterListener, MediaScanner.OnMediaInfoScannerListener
{
  private static final LinkedList<Integer> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public static boolean a;
  public static boolean b;
  private int jdField_a_of_type_Int = 11;
  private long jdField_a_of_type_Long = -1L;
  private volatile SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bbft jdField_a_of_type_Bbft;
  private bbfu jdField_a_of_type_Bbfu;
  private bbfw jdField_a_of_type_Bbfw;
  private bbfx jdField_a_of_type_Bbfx;
  private bbfy jdField_a_of_type_Bbfy;
  private bbfz jdField_a_of_type_Bbfz;
  private bofy jdField_a_of_type_Bofy;
  private final boiv jdField_a_of_type_Boiv = new bofp(this);
  private boiw jdField_a_of_type_Boiw = new boiw();
  private final boiz jdField_a_of_type_Boiz = new bofo(this);
  private bojq jdField_a_of_type_Bojq;
  private bojx jdField_a_of_type_Bojx;
  private boof jdField_a_of_type_Boof = new bofm(this);
  private boom jdField_a_of_type_Boom;
  private boop jdField_a_of_type_Boop;
  private bowk jdField_a_of_type_Bowk;
  private bowl jdField_a_of_type_Bowl;
  private bown jdField_a_of_type_Bown;
  private bpae jdField_a_of_type_Bpae = new bpae();
  private bpaq jdField_a_of_type_Bpaq;
  private bqaa jdField_a_of_type_Bqaa = new bqaa(10000, 100, 2);
  private bqah jdField_a_of_type_Bqah;
  private bqai jdField_a_of_type_Bqai;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private SessionWrap jdField_a_of_type_DovComQqImAeSessionWrap;
  private AEVideoCaptureResult jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult;
  private AECameraBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver = new AECameraBroadcastReceiver(this);
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private AEMaterialPanel jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel;
  private AEVideoStoryTopBarViewModel.Ratio jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private AECompoundButton jdField_a_of_type_DovComQqImAeViewAECompoundButton;
  private AEPituCameraCaptureButtonLayout jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString;
  private CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  private AECaptureMode[] jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private AECaptureMode jdField_b_of_type_DovComQqImAeModeAECaptureMode;
  private AECompoundButton jdField_b_of_type_DovComQqImAeViewAECompoundButton;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i = bpan.a();
  private volatile boolean j;
  private volatile boolean k;
  private boolean l;
  private boolean m;
  
  public bofh()
  {
    bpam.b("AEPituCameraUnit", "[AEPituCameraUnit] + BEGIN");
    bpam.a("AEPituCameraUnit", "unitConstructor--fake");
    bpam.b("AEPituCameraUnit", "[AEPituCameraUnit] + END");
  }
  
  public bofh(bqai parambqai, bqah parambqah)
  {
    bpam.b("AEPituCameraUnit", "[AEPituCameraUnit] + BEGIN");
    long l1 = System.currentTimeMillis();
    bowp.a().a("unitConstructor-begin");
    this.jdField_a_of_type_Bqai = parambqai;
    this.jdField_a_of_type_Bqah = parambqah;
    this.jdField_a_of_type_Int = 11;
    bjfr.a(BaseApplicationImpl.getContext(), false, 5);
    aquy.a(BaseApplicationImpl.getContext(), 2, false);
    if (born.h(a()))
    {
      this.jdField_a_of_type_Int = 13;
      this.jdField_a_of_type_Bqaa = new bqaa(10023, a().getIntent().getIntExtra("entrance_type", 120), 14);
    }
    for (;;)
    {
      bpam.b("AEPituCameraUnit", "[AEPituCameraUnit] submit unit init");
      ThreadManager.excute(new AEPituCameraUnit.1(this), 16, null, true);
      bpam.b("AEPituCameraUnit", "[AEPituCameraUnit] + END, time cost = " + (System.currentTimeMillis() - l1));
      return;
      if (!born.e.a(a()))
      {
        this.jdField_a_of_type_Int = 11;
        this.jdField_a_of_type_Bqaa = new bqaa(10023, a().getIntent().getIntExtra("entrance_type", 120), 14);
      }
      else
      {
        this.jdField_a_of_type_Int = 1;
      }
    }
  }
  
  private void A()
  {
    int n = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", born.a.a());
    if (a() != born.x.a())
    {
      String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
      if (born.a(n).a()) {
        bozv.a().a(n, str);
      }
      str = a().getIntent().getStringExtra("intent_key_uid_for_report");
      bozv.a().a(str);
      bozv.a().a(true);
      bozv.a().b();
      bozv.a().a();
      bozv.a().b(boqg.a(a()));
    }
    bozr.a().Y();
    if (born.e.a(n)) {
      yup.a("check_Android", born.e.a(), 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
    }
  }
  
  private void B()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.12(this));
  }
  
  private void C()
  {
    if (this.h) {
      return;
    }
    this.h = true;
    bpam.b("AEPituCameraUnit", "actionAfterFirstFrame");
    int n = this.jdField_a_of_type_Bqai.a().getIntent().getIntExtra("edit_video_type", 10002);
    PeakAppInterface.a.a(bpmn.jdField_a_of_type_JavaLangString, new Object[] { this, Integer.valueOf(n) });
    if (!this.e)
    {
      this.e = true;
      PeakAppInterface.a.a(1010);
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.13(this));
  }
  
  private void D()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.22(this));
    }
  }
  
  private void E()
  {
    this.jdField_a_of_type_Bojq.f();
    LiuHaiUtils.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, bhtq.a(1.0F));
  }
  
  private void F()
  {
    e(false);
    this.jdField_a_of_type_Bowl.a().postValue(Boolean.valueOf(false));
  }
  
  private void G()
  {
    bpam.b("AEPituCameraUnit", "tryStartPreview---ENTER");
    if (!d())
    {
      bpam.d("AEPituCameraUnit", "tryStartPreview---EXIT, not called by the top unit");
      return;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      bpam.d("AEPituCameraUnit", "tryStartPreview---EXIT, activity not resumed");
      return;
    }
    Object localObject = this.jdField_a_of_type_DovComQqImAeModeAECaptureMode;
    if ((localObject == null) || (!((AECaptureMode)localObject).shouldStartCamera()))
    {
      bpam.d("AEPituCameraUnit", "tryStartPreview---EXIT, not right mode: " + localObject);
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null)
    {
      bpam.d("AEPituCameraUnit", "tryStartPreview---EXIT, mPreviewTexture is NULL");
      return;
    }
    if (bpal.a() == null)
    {
      bpam.d("AEPituCameraUnit", "tryStartPreview---EXIT, mMaxPreviewSize is NULL");
      return;
    }
    localObject = bpal.a((AECaptureMode)localObject, bpal.a(), this.l, this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
    this.jdField_a_of_type_Boiw.a(this.jdField_a_of_type_Boiz);
    this.jdField_a_of_type_Boiw.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, (alxc)localObject);
    bpam.b("AEPituCameraUnit", "tryStartPreview---EXIT, normal");
  }
  
  private void H()
  {
    bpam.b("AEPituCameraUnit", "stopPreview");
    if (!d())
    {
      bpam.d("AEPituCameraUnit", "stopPreview---EXIT, not called by the top unit");
      return;
    }
    this.jdField_a_of_type_Boiw.a();
  }
  
  private void I()
  {
    bpam.b("AEPituCameraUnit", "tryOpenCamera---ENTER");
    if (!d())
    {
      bpam.d("AEPituCameraUnit", "tryOpenCamera---EXIT, not called by the top unit");
      return;
    }
    AECaptureMode localAECaptureMode = this.jdField_a_of_type_DovComQqImAeModeAECaptureMode;
    if ((localAECaptureMode == null) || (!localAECaptureMode.shouldStartCamera()))
    {
      bpam.d("AEPituCameraUnit", "tryOpenCamera---EXIT, not right mode: " + localAECaptureMode);
      return;
    }
    this.jdField_a_of_type_Boiw.a(new bofn(this));
  }
  
  private void J()
  {
    if (Build.VERSION.SDK_INT < 23) {
      break label8;
    }
    label8:
    while (!(this.jdField_a_of_type_Bqai.a() instanceof QIMCameraCaptureActivity)) {
      return;
    }
    QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_Bqai.a();
    int n;
    label51:
    int i1;
    if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      n = 1;
      if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label176;
      }
      i1 = 1;
      label64:
      if (apdr.a(localQIMCameraCaptureActivity)) {
        break label181;
      }
    }
    label176:
    label181:
    for (int i2 = 1;; i2 = 0)
    {
      LinkedList localLinkedList = new LinkedList();
      if (n != 0) {
        localLinkedList.add("android.permission.CAMERA");
      }
      if (i1 != 0) {
        localLinkedList.add("android.permission.RECORD_AUDIO");
      }
      if (i2 != 0)
      {
        localLinkedList.add("android.permission.READ_EXTERNAL_STORAGE");
        localLinkedList.add("android.permission.WRITE_EXTERNAL_STORAGE");
      }
      if (localLinkedList.size() <= 0) {
        break;
      }
      localQIMCameraCaptureActivity.requestPermissions(this, 1, (String[])localLinkedList.toArray(new String[0]));
      return;
      n = 0;
      break label51;
      i1 = 0;
      break label64;
    }
  }
  
  private void K()
  {
    Activity localActivity = this.jdField_a_of_type_Bqai.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (this.jdField_a_of_type_Bpaq == null) {
      this.jdField_a_of_type_Bpaq = new bpaq(localActivity);
    }
    this.jdField_a_of_type_Bpaq.a(new AEPituCameraUnit.30(this));
  }
  
  private void L()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.31(this));
  }
  
  private int a()
  {
    if (a().getIntent() != null) {
      return a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", born.a.a());
    }
    return born.a.a();
  }
  
  private long a()
  {
    long l1 = 9223372036854775807L;
    try
    {
      long l2 = bhjx.b();
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    l1 >>>= 20;
    QLog.d("AEPituCameraUnit", 4, "available size = " + l1 + "M");
    return l1 / 30L;
  }
  
  private AECaptureMode a(AECaptureMode[] paramArrayOfAECaptureMode, int paramInt)
  {
    String str = a().getIntent().getStringExtra("KEY_CURRENT_TAB");
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      AECaptureMode localAECaptureMode2 = AECaptureMode.fromName(str);
      int n;
      if (localAECaptureMode2 != null)
      {
        n = paramArrayOfAECaptureMode.length;
        paramInt = 0;
        label40:
        if (paramInt < n) {
          if (paramArrayOfAECaptureMode[paramInt] != localAECaptureMode2) {}
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        AECaptureMode localAECaptureMode1 = localAECaptureMode2;
        if (paramInt == 0)
        {
          bpam.d("AEPituCameraUnit", "[getFirstModeAccordingABTest], get invalid mode=" + localAECaptureMode2);
          localAECaptureMode1 = paramArrayOfAECaptureMode[0];
        }
        bpam.b("AEPituCameraUnit", "[getFirstModeAccordingABTest], ABTest name=" + str + ", real picked mode=" + localAECaptureMode1);
        return localAECaptureMode1;
        n = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", -1);
        if ((paramInt == 201) && (born.c.a() == n)) {
          return AECaptureMode.PLAY;
        }
        if ((paramInt != 204) || (!born.d(n))) {
          break label214;
        }
        str = bozz.a().a("app_alg_entrance_qzone_id_from833", "", 4);
        break;
        paramInt += 1;
        break label40;
      }
      label214:
      str = null;
    }
  }
  
  private static void a(Activity paramActivity)
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
  
  private void a(LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable)
  {
    D();
    if (paramLazyLoadAnimationDrawable == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable = new AEPituCameraUnit.20(this);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.21(this, paramLazyLoadAnimationDrawable));
  }
  
  private void a(@Nullable AECaptureMode paramAECaptureMode1, @NonNull AECaptureMode paramAECaptureMode2)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_DovComQqImAeModeAECaptureMode = paramAECaptureMode2;
    if (paramAECaptureMode1 == paramAECaptureMode2) {}
    label231:
    label236:
    do
    {
      return;
      bpam.b("AEPituCameraUnit", "onCaptureModeChanged---from " + paramAECaptureMode1 + " to " + paramAECaptureMode2);
      b(paramAECaptureMode1, paramAECaptureMode2);
      if (this.jdField_a_of_type_Bbft != null) {
        this.jdField_a_of_type_Bbft.a();
      }
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF)
      {
        bool1 = true;
        bozv.a().b(bool1);
        if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
          this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setIsGIFMode(bool1);
        }
        ThreadManager.getUIHandler().post(new AEPituCameraUnit.18(this));
        paramAECaptureMode1 = this.jdField_a_of_type_Bojx;
        if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.NORMAL) {
          break label231;
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramAECaptureMode1.b(bool1);
        if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera()) {
          break label236;
        }
        if (this.jdField_a_of_type_Boop != null) {
          this.jdField_a_of_type_Boop.b();
        }
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbfu);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbfy);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbfz);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbfx);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbft);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbfw);
        return;
        bool1 = false;
        break;
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Bbfu)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbfu);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Bbfy)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbfy);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Bbfx)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbfx);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Bbfz)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbfz);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Bbfx)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbfx);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Bbft)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbft);
      }
    } while (GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Bbfw));
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbfw);
  }
  
  private void b(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    boolean bool2 = false;
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      if (paramAEVideoCaptureResult.videoFrameCount < 5L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AEPituCameraUnit", 2, "onVideoCaptured. videoFrameCount = " + this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoFrameCount + " ; minFrameCount = " + 5L);
        }
        B();
        return;
      }
      bpam.b("AEPituCameraUnit", "【GIF Capture】during time:" + (paramAEVideoCaptureResult.finishTimeMs - paramAEVideoCaptureResult.startTimeMs) + "ms");
      bozv.a().b(5L);
      bozr.a().ad();
      long l1 = a();
      if (l1 > 0L)
      {
        paramAEVideoCaptureResult = new Intent(a(), AEStoryGIFPreviewActivity.class);
        paramAEVideoCaptureResult.putExtra("KEY_PREVIEW_SOURCE_PATH", this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath);
        paramAEVideoCaptureResult.putExtra("KEY_AVAILABLE_EMO_COUNT", l1);
        Object localObject1 = (bosm)bofz.a(this).get(bosm.class);
        Object localObject2 = (boqw)((bosm)localObject1).b().getValue();
        if (localObject2 != null) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          paramAEVideoCaptureResult.putExtra("KEY_MATERIAL_APPLIED", bool1);
          if (localObject2 != null)
          {
            paramAEVideoCaptureResult.putExtra("ARG_GIF_MATERIAL_ID", ((boqw)localObject2).jdField_a_of_type_JavaLangString);
            bpam.a("AEPituCameraUnit", "[recordGIF] gifMaterial.id=" + ((boqw)localObject2).jdField_a_of_type_JavaLangString);
          }
          paramAEVideoCaptureResult.putExtra("KEY_AVAILABLE_SAVENAME", (String)((bosm)localObject1).c().getValue());
          paramAEVideoCaptureResult.putExtra("ARG_SESSION_INFO", this.jdField_a_of_type_DovComQqImAeSessionWrap);
          localObject2 = a().getIntent();
          if (!born.f((Intent)localObject2))
          {
            bool1 = bool2;
            if (!born.g((Intent)localObject2)) {}
          }
          else
          {
            bool1 = true;
          }
          paramAEVideoCaptureResult.putExtra("ARG_GIF_SEND_TO_AIO", bool1);
          localObject1 = (String)((bosm)localObject1).d().getValue();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            paramAEVideoCaptureResult.putExtra("KEY_FONT_ID", (String)localObject1);
          }
          localObject1 = a();
          if (localObject1 == null) {
            break;
          }
          localObject2 = ((Activity)localObject1).getIntent();
          if (localObject2 != null)
          {
            int n = ((Intent)localObject2).getIntExtra("AECAMERA_MODE", 200);
            int i1 = ((Intent)localObject2).getIntExtra("VIDEO_STORY_FROM_TYPE", born.a.a());
            paramAEVideoCaptureResult.putExtra("AECAMERA_MODE", n);
            paramAEVideoCaptureResult.putExtra("VIDEO_STORY_FROM_TYPE", i1);
          }
          ((Activity)localObject1).startActivityForResult(paramAEVideoCaptureResult, 101);
          return;
        }
      }
      paramAEVideoCaptureResult = BaseApplicationImpl.getContext();
    } while (paramAEVideoCaptureResult == null);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.11(this, paramAEVideoCaptureResult));
  }
  
  private void b(@Nullable AECaptureMode paramAECaptureMode1, @NonNull AECaptureMode paramAECaptureMode2)
  {
    if ((paramAECaptureMode1 != null) && (paramAECaptureMode1.shouldStartCamera())) {
      H();
    }
    if (!paramAECaptureMode2.shouldStartCamera()) {
      f(false);
    }
    int n;
    do
    {
      return;
      n = bbgb.a();
      if (paramAECaptureMode2 == AECaptureMode.GIF) {
        n = 1;
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_Boiw.c(n);
        return;
      }
    } while (!this.k);
    this.jdField_a_of_type_Boiw.a(n, new bofk(this));
  }
  
  private void c(boolean paramBoolean)
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
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.m)
      {
        if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null)
        {
          this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
          this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(true);
        }
        c(true);
        this.m = false;
        bpam.b("AEPituCameraUnit", "【Dark Mode】Start");
      }
      return;
    }
    if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null)
    {
      this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
      this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(false);
    }
    c(false);
    this.m = false;
  }
  
  private boolean d()
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilLinkedList.peek();
    return (localInteger != null) && (localInteger.intValue() == this.jdField_c_of_type_Int);
  }
  
  private void e(boolean paramBoolean)
  {
    if (born.j(a().getIntent()))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("ae_editor_bottom_tab_show_hide");
      localIntent.putExtra("is_show", paramBoolean);
      a().sendBroadcast(localIntent);
    }
  }
  
  private boolean e()
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF) {}
    while (born.i(a().getIntent())) {
      return false;
    }
    return true;
  }
  
  private void f(boolean paramBoolean)
  {
    bpam.b("AEPituCameraUnit", "closeCamera");
    if (!d())
    {
      bpam.d("AEPituCameraUnit", "closeCamera---EXIT, not called by the top unit");
      return;
    }
    this.jdField_a_of_type_Boiw.a(paramBoolean);
  }
  
  private boolean f()
  {
    if (Build.VERSION.SDK_INT < 23) {
      bpam.b("AEPituCameraUnit", "checkPermission---below android6.0, no need check");
    }
    int n;
    int i1;
    boolean bool;
    do
    {
      return true;
      Activity localActivity = a();
      n = localActivity.checkSelfPermission("android.permission.CAMERA");
      i1 = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
      bool = apdr.a(localActivity);
      bpam.b("AEPituCameraUnit", "checkPermission, camera: " + n + " audio: " + i1 + ", storage=" + bool);
    } while ((n == 0) && (i1 == 0) && (bool));
    return false;
  }
  
  private void w()
  {
    this.l = born.j(a().getIntent());
    int n;
    if (this.l)
    {
      n = bpal.a();
      if (n != 1) {
        break label73;
      }
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.R_4_3;
    }
    for (;;)
    {
      ((AEVideoStoryTopBarViewModel)bofz.a(this).get(AEVideoStoryTopBarViewModel.class)).a.setValue(this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
      z();
      this.jdField_a_of_type_DovComQqImAeModeAECaptureMode = this.jdField_b_of_type_DovComQqImAeModeAECaptureMode;
      return;
      label73:
      if (n == 2) {
        this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.R_4_3;
      } else {
        this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.FULL;
      }
    }
  }
  
  private void x()
  {
    Object localObject = a();
    if (bdep.c((Context)localObject) / bdep.e((Context)localObject) >= 2.0F)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (!born.h(a())) {
        a((Activity)localObject);
      }
    }
    if ((Build.MODEL.contains("Pixel 2")) && (Build.VERSION.SDK_INT >= 16))
    {
      localObject = ((Activity)localObject).getWindow().getDecorView();
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() & 0xFFFFFFFB);
    }
    localObject = this.jdField_b_of_type_AndroidViewView.getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(new bofw(this));
    }
  }
  
  @MainThread
  private void y()
  {
    bpam.b("AEPituCameraUnit", "setInitialMode---");
    bowk localbowk = (bowk)bofz.a(this).get(bowk.class);
    localbowk.a.setValue(new bowc(null, this.jdField_b_of_type_DovComQqImAeModeAECaptureMode, 1));
    localbowk.b.setValue(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode);
  }
  
  private void z()
  {
    int n = 200;
    Intent localIntent = a().getIntent();
    if (localIntent != null) {
      n = localIntent.getIntExtra("AECAMERA_MODE", 200);
    }
    this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.NORMAL;
    AECaptureMode.NORMAL.setHasCountDown(false);
    switch (n)
    {
    default: 
      this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = new AECaptureMode[] { AECaptureMode.NORMAL };
      this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.NORMAL;
      boolean bool = a().getIntent().getBooleanExtra("key_has_countdown", false);
      AECaptureMode.NORMAL.setHasCountDown(bool);
    }
    for (;;)
    {
      bpam.b("AEPituCameraUnit", "initCaptureModesAndFirstMode---initialMode=" + this.jdField_b_of_type_DovComQqImAeModeAECaptureMode + ", initialCModes=" + Arrays.toString(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode));
      return;
      this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = new AECaptureMode[] { AECaptureMode.PLAY };
      this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.PLAY;
      continue;
      this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = new AECaptureMode[] { AECaptureMode.PLAY, AECaptureMode.GIF };
      this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.PLAY;
      continue;
      this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = new AECaptureMode[] { AECaptureMode.NORMAL, AECaptureMode.GIF };
      this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.NORMAL;
      continue;
      this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = new AECaptureMode[] { AECaptureMode.NORMAL, AECaptureMode.PLAY };
      this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = a(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode, n);
      continue;
      this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = new AECaptureMode[] { AECaptureMode.NORMAL, AECaptureMode.PLAY, AECaptureMode.GIF };
      this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = a(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode, n);
      continue;
      this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = new AECaptureMode[] { AECaptureMode.GIF };
      this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.GIF;
    }
  }
  
  public void U() {}
  
  public void W() {}
  
  public Activity a()
  {
    if (this.jdField_a_of_type_Bqai == null) {
      return null;
    }
    return this.jdField_a_of_type_Bqai.a();
  }
  
  public View a()
  {
    bowp.a().a("unitInflateView-begin");
    Object localObject;
    if (born.h(a()))
    {
      localObject = this.jdField_a_of_type_Bqai.a().getLayoutInflater().inflate(2131558517, null, false);
      bowp.a().a("unitInflateView-end");
      this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131366922);
      w();
      this.jdField_b_of_type_AndroidViewView = ((View)localObject).findViewById(2131366923);
      this.jdField_a_of_type_Bofy = ((bofy)bofz.a(this).get(bofy.class));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363547));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363545));
      LiuHaiUtils.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, bhtq.a(1.0F));
      x();
      this.jdField_a_of_type_Bojq = new bojq(this.jdField_a_of_type_AndroidViewView, this);
      this.jdField_a_of_type_Bojx = new bojx((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378113));
      this.jdField_a_of_type_Bofy.b.postValue(this.jdField_a_of_type_Bojx);
      localObject = this.jdField_a_of_type_Bojx;
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.NORMAL) {
        break label997;
      }
      bool = true;
      label217:
      ((bojx)localObject).a(this, bool);
      this.jdField_a_of_type_Bown = new bown(this.jdField_a_of_type_Bqai.a(), this.jdField_a_of_type_AndroidViewView, this);
      if (!this.jdField_b_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera())
      {
        y();
        if (this.l)
        {
          localObject = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378107);
          if (localObject != null)
          {
            ((ViewStub)localObject).inflate();
            bpam.b("AEPituCameraUnit", "AEPartAction--inflate bottom");
          }
        }
        this.jdField_a_of_type_Bown.a();
      }
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_Bqai.a(), new bofx(this, null), null, true);
      this.jdField_a_of_type_Boop = new boop(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Bown);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364134));
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAEKitInitListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setEventCallback(this.jdField_a_of_type_Boiv);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setFaceEffectListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAECaptureController(this.jdField_a_of_type_Bojq);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setStickerInnerLutFilterListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setRecommendTextCallback(new bofl(this));
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setIsVoiceNeedEncode(born.j(a().getIntent()));
      localObject = a();
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a(this.jdField_a_of_type_Boiw, (boim)localObject);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setPreExtractFrame(born.j(a()));
      this.jdField_a_of_type_Boiw.a((boim)localObject);
      this.jdField_a_of_type_Boiw.b(true);
      this.jdField_a_of_type_Boiw.a(this);
      this.jdField_a_of_type_Boiw.a(new bbgj());
      this.jdField_a_of_type_Boiw.a(this.jdField_a_of_type_Boiz);
      if (!bddz.n()) {
        break label1002;
      }
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(true);
      if (bomz.a()) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a = this;
      }
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378108));
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131373117));
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setMaterialPanelListener(this.jdField_a_of_type_Boof);
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(8);
      }
      this.jdField_a_of_type_Boom = new boom((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378105));
      this.jdField_a_of_type_Bofy.a.setValue(this.jdField_a_of_type_Boom);
      CosFunHelper.setCountDownListener(new bofu(this));
      this.jdField_a_of_type_Bbfu = new bbfu();
      this.jdField_a_of_type_Bbfu.a(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Bbfu.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel);
      this.jdField_a_of_type_Bbfu.a(new bofv(this));
      this.jdField_a_of_type_Boom.a(this.jdField_a_of_type_Bbfu);
      this.jdField_a_of_type_Bbfy = this.jdField_a_of_type_Bojx.a();
      this.jdField_a_of_type_Bbfz = new bbfz(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
      this.jdField_a_of_type_Bbfx = new bbfx();
      this.jdField_a_of_type_Bbft = new bbft(this.jdField_a_of_type_AndroidViewViewStub);
      this.jdField_a_of_type_Bbfw = new bbfw(this.jdField_a_of_type_Bqai.a());
      if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)) {
        break label1045;
      }
    }
    label1045:
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AEPituCameraUnit", 1, "onCreateView needLiuHaiTop:" + bool);
        }
        localObject = a().getIntent().getStringExtra("key_guide_image");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = axse.a(((String)localObject).substring("data:image/png;base64,".length()));
          localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
          if (BitmapUtils.isLegal((Bitmap)localObject))
          {
            ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363568);
            localImageView.setImageBitmap((Bitmap)localObject);
            localImageView.setVisibility(0);
          }
        }
        n();
        bpam.b("AEPituCameraUnit", "[UnitAsyncInit] before await");
        try
        {
          this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await(1000L, TimeUnit.MILLISECONDS);
          bpam.b("AEPituCameraUnit", "[UnitAsyncInit] after await");
          return this.jdField_a_of_type_AndroidViewView;
          localObject = this.jdField_a_of_type_Bqai.a().getLayoutInflater().inflate(2131558516, null, false);
          break;
          label997:
          bool = false;
          break label217;
          label1002:
          this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(false);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            bpam.d("AEPituCameraUnit", "[UnitAsyncInit] await interrupt exp: " + localInterruptedException.getMessage());
          }
        }
      }
    }
  }
  
  protected boim a()
  {
    int n = 1;
    Intent localIntent = a().getIntent();
    if (born.i(localIntent)) {
      if ((!localIntent.getBooleanExtra("key_camera_prefer_id", false)) && (aqql.d())) {}
    }
    label36:
    int i1;
    for (n = 2; bddz.n(); n = i1)
    {
      return brdw.a().a(this.jdField_a_of_type_Bqai.a(), n);
      i1 = bbgb.a();
      if ((this.jdField_b_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF) && (aqql.d())) {
        break label36;
      }
    }
    return brdw.a().b(this.jdField_a_of_type_Bqai.a(), n);
  }
  
  public bojq a()
  {
    return this.jdField_a_of_type_Bojq;
  }
  
  public void a()
  {
    bocw localbocw = (bocw)bplq.a(13);
    if (born.e.a(a()))
    {
      localbocw.b(14);
      return;
    }
    localbocw.b(this.jdField_a_of_type_Bqaa.jdField_c_of_type_Int);
  }
  
  public void a(int paramInt)
  {
    this.d = false;
    bpam.a("AEPituCameraUnit", "onCaptureError. errorCode = " + paramInt, new Throwable());
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.10(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraUnit", 2, "onActivityResult:requestCode=" + paramInt1 + " resultCode=" + paramInt2 + " data=" + paramIntent + " publishStoryFlag=" + jdField_a_of_type_Boolean);
    }
    Activity localActivity = this.jdField_a_of_type_Bqai.a();
    bbgr.a(localActivity, paramInt1, paramInt2);
    if ((localActivity == null) || (localActivity.isFinishing())) {
      if (QLog.isColorLevel())
      {
        bool1 = bool2;
        if (localActivity == null) {
          bool1 = true;
        }
        QLog.d("AEPituCameraUnit", 2, new Object[] { "activity is finishing, ", Boolean.valueOf(bool1) });
      }
    }
    do
    {
      return;
      if (paramInt1 != 1024) {
        break;
      }
    } while (paramInt2 != -1);
    localActivity.setResult(-1, paramIntent);
    localActivity.finish();
    return;
    String str1;
    if ((paramInt1 == 1025) && (paramInt2 == -1) && (paramIntent != null))
    {
      str1 = paramIntent.getStringExtra("file_send_path");
      long l1 = paramIntent.getLongExtra("file_send_duration", -1L);
      String str2 = paramIntent.getStringExtra("widgetinfo");
      if ((!TextUtils.isEmpty(str1)) && (l1 > 0L))
      {
        paramIntent = new Intent(localActivity, SendVideoActivity.class);
        paramIntent.putExtra("file_send_path", str1);
        paramIntent.putExtra("file_send_size", new File(str1).length());
        paramIntent.putExtra("file_send_duration", l1);
        paramIntent.putExtra("uin", this.jdField_a_of_type_DovComQqImAeSessionWrap.jdField_a_of_type_JavaLangString);
        paramIntent.putExtra("uintype", this.jdField_a_of_type_DovComQqImAeSessionWrap.jdField_a_of_type_Int);
        paramIntent.putExtra("file_source", "album");
        paramIntent.putExtra("start_init_activity_after_sended", false);
        if (!TextUtils.isEmpty(str2)) {
          paramIntent.putExtra("widgetinfo", str2);
        }
        localActivity.startActivity(paramIntent);
        localActivity.finish();
        return;
      }
    }
    if ((paramIntent == null) && (paramInt2 == 0) && (jdField_a_of_type_Boolean))
    {
      jdField_a_of_type_Boolean = false;
      return;
    }
    if ((paramInt2 == -1) && ((paramInt1 == 10006) || (paramInt1 == 1012))) {
      this.jdField_a_of_type_Bojq.j();
    }
    if (paramInt2 == 0) {
      boec.a(null);
    }
    if ((paramIntent != null) && (this.jdField_a_of_type_DovComQqImAeSessionWrap != null)) {
      paramIntent.putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_DovComQqImAeSessionWrap.a());
    }
    if ((paramInt1 == 1012) && (paramInt2 == -1))
    {
      if (paramIntent != null)
      {
        str1 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if ((paramIntent == null) || (!paramIntent.getBooleanExtra("input_full_screen_mode", false))) {
          break label538;
        }
      }
      for (;;)
      {
        paramIntent = new Intent();
        paramIntent.putExtra("input_full_screen_mode_result", str1);
        paramIntent.putExtra("input_full_screen_mode", bool1);
        localActivity.setResult(-1, paramIntent);
        localActivity.finish();
        return;
        str1 = "";
        break;
        label538:
        bool1 = false;
      }
    }
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      boed.a(this.jdField_a_of_type_Bqai.a(), paramIntent, this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult, this.jdField_a_of_type_Bqah, null);
      return;
    }
    this.jdField_a_of_type_Bown.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    bpam.a("AEPituCameraUnit", "[AE Profiler] AEPituCameraUnit onCreate");
    long l1 = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    bozv.a().c(l1);
    super.a(paramBundle);
    this.k = f();
    blfp.jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Boolean = false;
    bqzz.a().b(false);
    this.jdField_a_of_type_DovComQqImAeSessionWrap = ((SessionWrap)this.jdField_a_of_type_Bqai.a().getIntent().getParcelableExtra("ARG_SESSION_INFO"));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bqai.a().getIntent().getStringExtra("ARG_AIO_CLASS");
    if (paramBundle != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = ((AEVideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
      this.jdField_c_of_type_Int = paramBundle.getInt("KEY_IDENTITY_CODE_SAVE");
      bpam.b("AEPituCameraUnit", "onCreate, restore from background, ID=" + this.jdField_c_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver.a(this.jdField_a_of_type_Bqai.a());
      this.jdField_a_of_type_Bpae.a();
      bozn.a();
      if (!jdField_a_of_type_JavaUtilLinkedList.contains(Integer.valueOf(this.jdField_c_of_type_Int))) {
        jdField_a_of_type_JavaUtilLinkedList.push(Integer.valueOf(this.jdField_c_of_type_Int));
      }
      bpam.b("AEPituCameraUnit", "onCreate, ID=" + this.jdField_c_of_type_Int + ", sUnitStack=" + jdField_a_of_type_JavaUtilLinkedList);
      return;
      this.jdField_c_of_type_Int = (jdField_a_of_type_JavaUtilLinkedList.size() + 1);
      bpam.b("AEPituCameraUnit", "onCreate, new created, ID=" + this.jdField_c_of_type_Int);
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout != null) {
      this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout.a(paramMotionEvent);
    }
  }
  
  public void a(bbhq parambbhq)
  {
    bozv.a().b(1L);
    bozr.a().c(-1L);
    bpam.b("AEPituCameraUnit", "【Type】Photo");
    Object localObject = a().getIntent();
    if (born.j((Intent)localObject))
    {
      this.jdField_a_of_type_Bown.a(262148, new Object[] { parambbhq });
      return;
    }
    if (born.f((Intent)localObject))
    {
      localObject = new bqad(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.b()).a(this.jdField_a_of_type_DovComQqImAeSessionWrap).a(this.jdField_a_of_type_JavaLangString).a(1).a();
      this.jdField_a_of_type_Bqaa.a((bqab)localObject);
      this.jdField_a_of_type_Bown.a(262148, new Object[] { parambbhq, this.jdField_a_of_type_Bqaa, this.jdField_a_of_type_Bown.a(196610, new Object[0]) });
      return;
    }
    this.jdField_a_of_type_Bown.a(262148, new Object[] { parambbhq, this.jdField_a_of_type_Bown.a(196610, new Object[0]) });
  }
  
  public void a(bojl parambojl)
  {
    if ((parambojl != null) && (this.jdField_a_of_type_Boop != null)) {
      parambojl.a(this.jdField_a_of_type_Boop.a());
    }
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    D();
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF)
    {
      if (paramVideoMaterial == null) {
        bozv.a().c("none");
      }
    }
    else
    {
      if (VideoMaterialUtil.isWatermarkMaterial(paramVideoMaterial)) {
        bopl.a().a();
      }
      if ((!VideoMaterialUtil.isWatermarkEditable(paramVideoMaterial)) || (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF)) {
        break label102;
      }
      a().runOnUiThread(new AEPituCameraUnit.16(this, paramVideoMaterial));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boop != null) {
        this.jdField_a_of_type_Boop.a(paramVideoMaterial);
      }
      return;
      bozv.a().c(paramVideoMaterial.getId());
      break;
      label102:
      a().runOnUiThread(new AEPituCameraUnit.17(this, paramVideoMaterial));
    }
  }
  
  public void a(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = paramAEVideoCaptureResult;
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.finishTimeMs = System.currentTimeMillis();
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF)
    {
      b(paramAEVideoCaptureResult);
      return;
    }
    int n = 500;
    if (this.jdField_a_of_type_Int == 13) {
      n = 2000;
    }
    if (brgs.a(paramAEVideoCaptureResult.videoMp4FilePath) < n)
    {
      this.d = false;
      B();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = paramAEVideoCaptureResult.videoMp4FilePath;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
    MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(this, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
  }
  
  public void a(String paramString)
  {
    boqr localboqr = (boqr)bplq.a().c(18);
    if ((localboqr != null) && (!TextUtils.isEmpty(paramString)))
    {
      localboqr.a(false);
      paramString = localboqr.a(paramString, b());
      if (paramString == null) {
        Toast.makeText(a(), 2131689675, 1).show();
      }
    }
    else
    {
      return;
    }
    e(false);
    a().a(true, 150);
    this.jdField_a_of_type_Bown.a(327683, new Object[] { paramString });
    this.jdField_a_of_type_Bown.a(196612, new Object[0]);
  }
  
  public void a(@NonNull List<bonc> paramList, @NonNull List<bonb> paramList1)
  {
    this.jdField_a_of_type_Bown.a(720897, new Object[] { paramList, paramList1 });
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.14(this));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Boop != null) {
      this.jdField_a_of_type_Boop.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bojq == null) {
      return false;
    }
    if (this.jdField_a_of_type_Bojq.a()) {
      return false;
    }
    if ((this.jdField_a_of_type_Bown.a(589824)) && (((Boolean)this.jdField_a_of_type_Bown.a(589826, new Object[0])).booleanValue()))
    {
      this.jdField_a_of_type_Bown.a(589826, new Object[0]);
      return true;
    }
    this.jdField_a_of_type_Bojq.h();
    this.jdField_a_of_type_Bojq.j();
    Intent localIntent;
    String str1;
    String str2;
    if (born.j(a().getIntent()))
    {
      localIntent = a().getIntent();
      str1 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str2 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      if (str1 != null) {
        break label168;
      }
      QQToast.a(a(), "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bqai.a();
      bozr.a().C();
      bpam.b("AEPituCameraUnit", "【Click】onBackPressed");
      return true;
      label168:
      localIntent.setClassName(str2, str1);
      localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      localIntent.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
      localIntent.addFlags(603979776);
      if (!localIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false))
      {
        a().startActivity(localIntent);
      }
      else
      {
        localIntent.getStringExtra("PhotoConst.PLUGIN_NAME");
        str2 = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
        String str3 = localIntent.getStringExtra("PhotoConst.UIN");
        if ("qzone_plugin.apk".equals(str2))
        {
          QzonePluginProxyActivity.a(localIntent, str1);
          bmtd.a(a(), str3, localIntent, 2);
        }
      }
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if (paramInt == 4) {
      a();
    }
    return super.a(paramInt, paramKeyEvent, paramBoolean);
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
          bhlq.a(localActivity, null, null);
          bool1 = false;
        }
      }
    }
    if (bool1) {
      this.jdField_a_of_type_Boiw.d(paramBoolean);
    }
    return bool1;
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.7(this));
    int n = AEBeautyProviderView.a();
    int i1 = AEBeautyProviderView.b();
    this.jdField_a_of_type_Bojq.a(n);
    this.jdField_a_of_type_Bojq.b(i1);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.8(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Bojq.a(paramInt);
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putSerializable("KEY_VIDEO_RESULT", this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
    paramBundle.putInt("KEY_IDENTITY_CODE_SAVE", this.jdField_c_of_type_Int);
    bpam.b("AEPituCameraUnit", "onSaveInstanceState---destroyed in background, ID=" + this.jdField_c_of_type_Int);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bown.a(327687, new Object[0]);
      return;
    }
    this.jdField_a_of_type_Bown.a(327688, new Object[0]);
  }
  
  public boolean b()
  {
    return born.h(a());
  }
  
  public void b_(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.6(this));
  }
  
  public void c()
  {
    this.d = true;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.h();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.l();
    v();
    ((bpmw)bplq.a(5)).a(true);
    c(8);
  }
  
  public void c(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366846);
    if ((localView instanceof VideoFilterViewPager))
    {
      ((VideoFilterViewPager)localView).setVisibility(paramInt);
      QLog.i("AEPituCameraUnit", 2, "yes to domVideoFilterViewPager setVisibility: " + paramInt);
    }
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 136	bofh:jdField_b_of_type_Int	I
    //   8: istore_1
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmpeq +7 -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	bofh
    //   8	4	1	n	int
    //   1	19	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	23	finally
  }
  
  public void d()
  {
    bpam.b("AEPituCameraUnit", "onActivityPause");
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onPause();
    super.d();
    this.jdField_c_of_type_Boolean = false;
    H();
    f(false);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbfu);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbfy);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbfz);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbfx);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbft);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbfw);
    this.jdField_a_of_type_Bojx.b();
    if (this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout != null) {
      this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout.l();
    }
    this.jdField_a_of_type_Bojq.h();
    this.jdField_a_of_type_Bown.c();
    if (QLog.isDevelopLevel()) {
      bpam.a("AEPituCameraUnit", "onActivityPause, ID=" + this.jdField_c_of_type_Int);
    }
  }
  
  public void d(int paramInt)
  {
    try
    {
      this.jdField_b_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    int i2 = 1;
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Bqai.a();
    int n;
    int i1;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)
    {
      n = 1;
      if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label187;
      }
      i1 = 1;
      label48:
      if (apdr.a((Context)localObject)) {
        break label192;
      }
    }
    for (;;)
    {
      localObject = new LinkedList();
      if (n != 0)
      {
        ((List)localObject).add("android.permission.CAMERA");
        bpam.b("AEPituCameraUnit", "【Camera Permission】denied");
      }
      if (i1 != 0)
      {
        ((List)localObject).add("android.permission.RECORD_AUDIO");
        bpam.b("AEPituCameraUnit", "【Audio Permission】denied");
      }
      if (i2 != 0)
      {
        ((List)localObject).add("android.permission.READ_EXTERNAL_STORAGE");
        ((List)localObject).add("android.permission.WRITE_EXTERNAL_STORAGE");
        bpam.b("AEPituCameraUnit", "【External Storage Permission】denied");
      }
      localObject = bhlq.a((String[])((List)localObject).toArray(new String[0]));
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.29(this, (String)localObject));
      return;
      n = 0;
      break;
      label187:
      i1 = 0;
      break label48;
      label192:
      i2 = 0;
    }
  }
  
  public void e()
  {
    super.e();
    f(true);
    GLGestureProxy.getInstance().removeAllListener();
    bozd.a().a();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver.b(this.jdField_a_of_type_Bqai.a());
    this.jdField_a_of_type_Bown.f();
    if (bomz.a()) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a = null;
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.f();
    bopi.a().b();
    CosFunHelper.setCountDownListener(null);
    if (this.jdField_a_of_type_Bojq != null) {
      this.jdField_a_of_type_Bojq.e();
    }
    this.jdField_a_of_type_Bojx.c();
    bjfr.a(BaseApplicationImpl.getContext(), true, 5);
    aquy.a(BaseApplicationImpl.getContext(), 2, true);
    brjp.a.clear();
    this.jdField_a_of_type_Bpae.b();
    bozv.a().k();
    bozv.a().a(false);
    bozn.b();
    if ((a() != null) && (born.i(a().getIntent()))) {
      this.jdField_a_of_type_Boiw.c(bbgb.a());
    }
    ((boqr)bplq.a(18)).c();
    if (d())
    {
      jdField_a_of_type_JavaUtilLinkedList.pop();
      bpam.b("AEPituCameraUnit", "onDestroy, is on top, ID=" + this.jdField_c_of_type_Int);
    }
    for (;;)
    {
      bpam.b("AEPituCameraUnit", "onDestroy, ID=" + this.jdField_c_of_type_Int + ", sUnitStack=" + jdField_a_of_type_JavaUtilLinkedList);
      return;
      bpam.b("AEPituCameraUnit", "onDestroy, is NOT on top, ID=" + this.jdField_c_of_type_Int);
    }
  }
  
  public void f()
  {
    bpam.b("AEPituCameraUnit", "onActivityResume");
    super.f();
    this.jdField_c_of_type_Boolean = true;
    if (jdField_a_of_type_Boolean)
    {
      bpam.d("AEPituCameraUnit", "onActivityResume---publishStoryFlag is true, activity will finish soon, fast return");
      return;
    }
    H();
    f(false);
    if (this.l) {
      this.k = f();
    }
    if (this.k) {
      I();
    }
    for (;;)
    {
      this.jdField_a_of_type_Boiw.c();
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onResume();
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbfu);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbfy);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbfz);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbfx);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbft);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbfw);
      this.jdField_a_of_type_Bojq.i();
      if (this.g)
      {
        if (this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout != null) {
          this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout.k();
        }
        o();
        a(false);
      }
      this.jdField_a_of_type_Bown.b();
      a();
      b(false);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      bpam.a("AEPituCameraUnit", "onActivityResume, ID=" + this.jdField_c_of_type_Int);
      return;
      if (!this.j)
      {
        this.j = true;
        J();
      }
      else
      {
        K();
      }
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.m();
    this.d = false;
    ((bpmw)bplq.a(5)).a(false);
    c(0);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    bpam.b("AEPituCameraUnit", "【Camera / Audio / Storage Permission】grant");
    this.k = true;
    if (this.jdField_c_of_type_Boolean) {
      I();
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_Bown.a(786435, new Object[0]);
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != null) && (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera()) && (bpal.a() != null))
    {
      alxc localalxc = bpal.a(this.jdField_a_of_type_DovComQqImAeModeAECaptureMode, bpal.a(), this.l, this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a(localalxc);
    }
    F();
    if (this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout != null) {
      this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout.setVisibility(8);
    }
    this.jdField_a_of_type_Bown.a(196609, new Object[0]);
    this.jdField_a_of_type_Bown.a(262147, new Object[0]);
  }
  
  public void j()
  {
    v();
  }
  
  public void k()
  {
    B();
  }
  
  public void l() {}
  
  public void l(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraUnit", 2, "onResourceDownload isOnlineRes: " + paramBoolean);
    }
    if (!jdField_b_of_type_Boolean)
    {
      jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Bqai.a().runOnUiThread(new AEPituCameraUnit.23(this));
      return;
    }
    this.jdField_a_of_type_Bqai.a().runOnUiThread(new AEPituCameraUnit.24(this));
  }
  
  public void m()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.9(this));
    this.jdField_a_of_type_Bown.a(196609, new Object[0]);
    this.jdField_a_of_type_Bown.a(262145, new Object[0]);
  }
  
  protected void n()
  {
    this.jdField_a_of_type_Bowk = ((bowk)bofz.a(this).get(bowk.class));
    this.jdField_a_of_type_Bowk.a.observe(this, new bofj(this));
    this.jdField_a_of_type_Bowl = ((bowl)bofz.a(this).get(bowl.class));
  }
  
  public void notifyEnableStickerInnerEffectFilter(boolean paramBoolean)
  {
    boolean bool2 = true;
    Object localObject;
    boolean bool1;
    if (paramBoolean)
    {
      d(1);
      if (this.jdField_a_of_type_Bown != null) {
        this.jdField_a_of_type_Bown.a(196609, new Object[0]);
      }
      localObject = bojk.a();
      if (localObject != null)
      {
        if (paramBoolean) {
          break label97;
        }
        bool1 = true;
        label48:
        ((bojl)localObject).jdField_a_of_type_Boolean = bool1;
        if (paramBoolean) {
          ((bojl)localObject).f();
        }
      }
      if (this.jdField_a_of_type_Bojq != null)
      {
        localObject = this.jdField_a_of_type_Bojq;
        if (paramBoolean) {
          break label102;
        }
      }
    }
    label97:
    label102:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((bojq)localObject).jdField_a_of_type_Boolean = paramBoolean;
      return;
      d(0);
      break;
      bool1 = false;
      break label48;
    }
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null)
    {
      if (aqql.d()) {
        this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
      }
    }
    else
    {
      if (!GLVideoClipUtil.b()) {
        break label115;
      }
      if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null) {
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
      }
    }
    for (;;)
    {
      b(true);
      bozv.a().h();
      bozr.a().X();
      if ((!this.jdField_a_of_type_Bowk.c()) && (this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout != null)) {
        this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout.setVisibility(0);
      }
      e(true);
      this.jdField_a_of_type_Bowl.a().postValue(Boolean.valueOf(true));
      return;
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(4);
      break;
      label115:
      if ((this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null) && (this.m))
      {
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(false);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int n = 1;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null)
      {
        bpvq.a(this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.a(), 200L, null);
        boolean bool;
        if (!this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.isSelected())
        {
          bool = true;
          label105:
          this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(bool);
          c(bool);
          if (bool) {
            break label147;
          }
          this.m = true;
          label127:
          bbgr.a(bool);
          if (!bool) {
            break label155;
          }
        }
        for (;;)
        {
          bbgf.c(n);
          break;
          bool = false;
          break label105;
          label147:
          this.m = false;
          break label127;
          label155:
          n = 2;
        }
        if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null) {
          bpvq.a(this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.a(), 200L, null);
        }
        this.jdField_a_of_type_Bojq.a();
        if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null) {
          if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a())
          {
            this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setContentDescription(this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.getResources().getString(2131717467));
          }
          else
          {
            this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setContentDescription(this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.getResources().getString(2131717468));
            continue;
            bpvq.a(paramView, 200L, null);
            r();
            continue;
            a().getIntent().removeExtra("widgetinfo");
          }
        }
      }
    }
  }
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    this.d = false;
    if (!paramBoolean)
    {
      a(101);
      return;
    }
    bpam.b("AEPituCameraUnit", "[onVideoCaptured] videoInfo = " + paramLocalMediaInfo.mDuration);
    bozv.a().b(2L);
    bozr.a().c(paramLocalMediaInfo.mDuration);
    this.jdField_a_of_type_Bown.a(196609, new Object[0]);
    this.jdField_a_of_type_Bown.a(262146, new Object[] { this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult, paramLocalMediaInfo, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Bqaa, this.jdField_a_of_type_Bown.a(196610, new Object[0]) });
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    if (this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout != null) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, this.jdField_a_of_type_DovComQqImAeViewAEPituCameraCaptureButtonLayout.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
    }
    return true;
  }
  
  public void p()
  {
    bpam.b("AEPituCameraUnit", "onActivityStart");
    super.p();
    this.jdField_a_of_type_Bown.d();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    bozr.a().B();
    if (QLog.isDevelopLevel()) {
      bpam.a("AEPituCameraUnit", "onActivityStart, ID=" + this.jdField_c_of_type_Int);
    }
  }
  
  public void q()
  {
    this.jdField_a_of_type_Bojq.b();
  }
  
  public void r()
  {
    this.jdField_a_of_type_Bqai.a().onBackPressed();
  }
  
  public void s()
  {
    super.s();
  }
  
  public void t()
  {
    bpam.b("AEPituCameraUnit", "onActivityStop");
    super.t();
    this.jdField_a_of_type_Bown.e();
    bozr.a().b(this.jdField_a_of_type_Long);
    if (QLog.isDevelopLevel()) {
      bpam.a("AEPituCameraUnit", "onActivityStop, ID=" + this.jdField_c_of_type_Int);
    }
  }
  
  public void u()
  {
    a().getIntent().removeExtra("widgetinfo");
    bpao.a(a());
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_Boop != null) {
      this.jdField_a_of_type_Boop.c();
    }
    if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null) {
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
    }
    e(false);
    this.jdField_a_of_type_Bowl.a().postValue(Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bofh
 * JD-Core Version:    0.7.0.1
 */