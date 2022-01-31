import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.aekit.api.standard.filter.AEFilterManager.StickerInnerEffectFilterListener;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
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
import dov.com.qq.im.ae.AEPituCameraUnit.15;
import dov.com.qq.im.ae.AEPituCameraUnit.16;
import dov.com.qq.im.ae.AEPituCameraUnit.17;
import dov.com.qq.im.ae.AEPituCameraUnit.19;
import dov.com.qq.im.ae.AEPituCameraUnit.20;
import dov.com.qq.im.ae.AEPituCameraUnit.21;
import dov.com.qq.im.ae.AEPituCameraUnit.22;
import dov.com.qq.im.ae.AEPituCameraUnit.23;
import dov.com.qq.im.ae.AEPituCameraUnit.24;
import dov.com.qq.im.ae.AEPituCameraUnit.25;
import dov.com.qq.im.ae.AEPituCameraUnit.26;
import dov.com.qq.im.ae.AEPituCameraUnit.27;
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
import dov.com.qq.im.ae.gif.AEStoryGIFPreviewActivity;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;
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
public class bkpl
  extends bkmz
  implements View.OnClickListener, View.OnTouchListener, axpq, bksj, bksk, bksl, bksm, bkxc, bmbh, bnhe, bnhg, bnll, bnlr, AEFilterManager.StickerInnerEffectFilterListener, MediaScanner.OnMediaInfoScannerListener
{
  public static boolean a;
  public static boolean b;
  private int jdField_a_of_type_Int = 11;
  private long jdField_a_of_type_Long = -1L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private axoz jdField_a_of_type_Axoz;
  private axpa jdField_a_of_type_Axpa;
  private axpc jdField_a_of_type_Axpc;
  private axpd jdField_a_of_type_Axpd;
  private axpe jdField_a_of_type_Axpe;
  private axpf jdField_a_of_type_Axpf;
  private bkpw jdField_a_of_type_Bkpw;
  private bkth jdField_a_of_type_Bkth;
  private bkto jdField_a_of_type_Bkto;
  private bkxt jdField_a_of_type_Bkxt = new bkpr(this);
  private bkya jdField_a_of_type_Bkya;
  private bkyd jdField_a_of_type_Bkyd;
  private blfq jdField_a_of_type_Blfq;
  private blfr jdField_a_of_type_Blfr;
  private blft jdField_a_of_type_Blft;
  private bljh jdField_a_of_type_Bljh = new bljh();
  private bljp jdField_a_of_type_Bljp;
  private bmgz jdField_a_of_type_Bmgz = new bmgz(10000, 100, 2);
  private bmhg jdField_a_of_type_Bmhg;
  private bmhh jdField_a_of_type_Bmhh;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private SessionWrap jdField_a_of_type_DovComQqImAeSessionWrap;
  private AEVideoCaptureResult jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult;
  private AECameraBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver = new AECameraBroadcastReceiver(this);
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private AEMaterialPanel jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.NORMAL;
  private AEPituCameraCaptureButtonLayout jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString;
  private CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  private AECaptureMode[] jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private AECaptureMode jdField_b_of_type_DovComQqImAeModeAECaptureMode;
  private final int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private volatile boolean i;
  private boolean j;
  
  public bkpl()
  {
    bljn.b("AEPituCameraUnit", "[AEPituCameraUnit] + BEGIN");
    this.jdField_c_of_type_Int = 0;
    bljn.a("AEPituCameraUnit", "unitConstructor--fake");
    bljn.b("AEPituCameraUnit", "[AEPituCameraUnit] + END");
  }
  
  public bkpl(bmhh parambmhh, bmhg parambmhg)
  {
    bljn.b("AEPituCameraUnit", "[AEPituCameraUnit] + BEGIN");
    long l = System.currentTimeMillis();
    blfv.a().a("unitConstructor-begin");
    this.jdField_a_of_type_Bmhh = parambmhh;
    this.jdField_a_of_type_Bmhg = parambmhg;
    this.jdField_a_of_type_Int = 11;
    bexu.a(BaseApplicationImpl.getContext(), false, 5);
    aofm.a(BaseApplicationImpl.getContext(), 2, false);
    if (blat.h(a()))
    {
      this.jdField_a_of_type_Int = 13;
      this.jdField_a_of_type_Bmgz = new bmgz(10023, a().getIntent().getIntExtra("entrance_type", 120), 14);
    }
    for (;;)
    {
      bljn.b("AEPituCameraUnit", "[AEPituCameraUnit] submit unit init");
      ThreadManager.excute(new AEPituCameraUnit.1(this), 16, null, true);
      blfv.a().a("begin identity");
      this.jdField_c_of_type_Int = System.identityHashCode(this);
      blfv.a().a("end identity");
      bljn.b("AEPituCameraUnit", "[AEPituCameraUnit] + END, time cost = " + (System.currentTimeMillis() - l));
      return;
      if (!blat.e.a(a()))
      {
        this.jdField_a_of_type_Int = 11;
        this.jdField_a_of_type_Bmgz = new bmgz(10023, a().getIntent().getIntExtra("entrance_type", 120), 14);
      }
      else
      {
        this.jdField_a_of_type_Int = 1;
      }
    }
  }
  
  private void A()
  {
    int k = 200;
    Object localObject = a().getIntent();
    if (localObject != null) {
      k = ((Intent)localObject).getIntExtra("AECAMERA_MODE", 200);
    }
    this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.NORMAL;
    AECaptureMode.NORMAL.setIsCircleMode(false);
    AECaptureMode.NORMAL.setHasCountDown(false);
    switch (k)
    {
    default: 
      this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = new AECaptureMode[] { AECaptureMode.NORMAL };
      this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.NORMAL;
      bool = a().getIntent().getBooleanExtra("key_has_countdown", false);
      AECaptureMode.NORMAL.setHasCountDown(bool);
      localObject = AECaptureMode.NORMAL;
      if (this.jdField_a_of_type_Int != 13) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      ((AECaptureMode)localObject).setIsCircleMode(bool);
      for (;;)
      {
        bljn.b("AEPituCameraUnit", "initCaptureModesAndFirstMode---initialMode=" + this.jdField_b_of_type_DovComQqImAeModeAECaptureMode + ", initialCModes=" + Arrays.toString(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode));
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
        this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = a(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode, k);
        continue;
        this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = new AECaptureMode[] { AECaptureMode.NORMAL, AECaptureMode.PLAY, AECaptureMode.GIF };
        this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = a(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode, k);
        continue;
        this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = new AECaptureMode[] { AECaptureMode.GIF };
        this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.GIF;
      }
    }
  }
  
  private void B()
  {
    int k = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", blat.a.a());
    if (!blat.h(a()))
    {
      String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
      if (blat.a(k).a()) {
        bliy.a().a(k, str);
      }
      str = a().getIntent().getStringExtra("intent_key_uid_for_report");
      bliy.a().a(str);
      bliy.a().a(true);
      bliy.a().b();
      bliy.a().a();
      bliy.a().b(bkzr.a(a()));
    }
    bliu.a().J();
    if (blat.e.a(k)) {
      wxj.a("check_Android", blat.e.a(), 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
    }
  }
  
  private void C() {}
  
  private void D()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.15(this));
  }
  
  private void E()
  {
    if (this.h) {
      return;
    }
    this.h = true;
    bljn.b("AEPituCameraUnit", "actionAfterFirstFrame");
    int k = this.jdField_a_of_type_Bmhh.a().getIntent().getIntExtra("edit_video_type", 10002);
    PeakAppInterface.a.a(blro.jdField_a_of_type_JavaLangString, new Object[] { this, Integer.valueOf(k) });
    if (!this.e)
    {
      this.e = true;
      PeakAppInterface.a.a(1010);
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.16(this));
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.24(this));
    }
  }
  
  private void G()
  {
    this.jdField_a_of_type_Bkth.f();
    bnle.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, bdoo.a(1.0F));
  }
  
  private void H()
  {
    this.jdField_a_of_type_Blfr.a().a(Boolean.valueOf(false));
  }
  
  private int a()
  {
    if (a().getIntent() != null) {
      return a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", blat.a.a());
    }
    return blat.a.a();
  }
  
  private long a()
  {
    long l1 = 9223372036854775807L;
    try
    {
      long l2 = bdeu.b();
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
      int k;
      if (localAECaptureMode2 != null)
      {
        k = paramArrayOfAECaptureMode.length;
        paramInt = 0;
        label40:
        if (paramInt < k) {
          if (paramArrayOfAECaptureMode[paramInt] != localAECaptureMode2) {}
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        AECaptureMode localAECaptureMode1 = localAECaptureMode2;
        if (paramInt == 0)
        {
          bljn.d("AEPituCameraUnit", "[getFirstModeAccordingABTest], get invalid mode=" + localAECaptureMode2);
          localAECaptureMode1 = paramArrayOfAECaptureMode[0];
        }
        bljn.b("AEPituCameraUnit", "[getFirstModeAccordingABTest], ABTest name=" + str + ", real picked mode=" + localAECaptureMode1);
        return localAECaptureMode1;
        k = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", -1);
        if ((paramInt == 201) && (blat.c.a() == k)) {
          return AECaptureMode.PLAY;
        }
        if ((paramInt != 204) || (!blat.d(k))) {
          break label214;
        }
        str = bljc.a().a("app_alg_entrance_qzone_id_from833", "", 4);
        break;
        paramInt += 1;
        break label40;
      }
      label214:
      str = null;
    }
  }
  
  private void a(LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable)
  {
    F();
    if (paramLazyLoadAnimationDrawable == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable = new AEPituCameraUnit.22(this);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.23(this, paramLazyLoadAnimationDrawable));
  }
  
  private void a(@Nullable AECaptureMode paramAECaptureMode)
  {
    boolean bool2 = true;
    if ((this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != paramAECaptureMode) && (this.jdField_a_of_type_Axoz != null)) {
      this.jdField_a_of_type_Axoz.a();
    }
    this.jdField_a_of_type_DovComQqImAeModeAECaptureMode = paramAECaptureMode;
    boolean bool1;
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF)
    {
      bool1 = true;
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.NORMAL) {
        break label186;
      }
      label51:
      bliy.a().b(bool1);
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setIsGIFMode(bool1);
      }
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.21(this));
      this.jdField_a_of_type_Bkto.b(bool2);
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.PLAY) {
        break label191;
      }
      if (this.jdField_a_of_type_Bkyd != null) {
        this.jdField_a_of_type_Bkyd.a();
      }
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axpa);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axpe);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axpf);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axpd);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axoz);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axpc);
    }
    label186:
    label191:
    do
    {
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label51;
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Axpa)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpa);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Axpe)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpe);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Axpd)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpd);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Axpf)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpf);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Axpd)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpd);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Axoz)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axoz);
      }
    } while (GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Axpc));
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpc);
  }
  
  private void b(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      if (paramAEVideoCaptureResult.videoFrameCount < 5L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AEPituCameraUnit", 2, "onVideoCaptured. videoFrameCount = " + this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoFrameCount + " ; minFrameCount = " + 5L);
        }
        D();
        return;
      }
      bljn.b("AEPituCameraUnit", "【GIF Capture】during time:" + (paramAEVideoCaptureResult.finishTimeMs - paramAEVideoCaptureResult.startTimeMs) + "ms");
      bliy.a().b(5L);
      bliu.a().N();
      long l = a();
      if (l > 0L)
      {
        paramAEVideoCaptureResult = new Intent(a(), AEStoryGIFPreviewActivity.class);
        paramAEVideoCaptureResult.putExtra("KEY_PREVIEW_SOURCE_PATH", this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath);
        paramAEVideoCaptureResult.putExtra("KEY_AVAILABLE_EMO_COUNT", l);
        Object localObject1 = (blbp)bkpx.a(this).a(blbp.class);
        Object localObject2 = (blag)((blbp)localObject1).c().a();
        if (localObject2 != null) {}
        for (boolean bool = true;; bool = false)
        {
          paramAEVideoCaptureResult.putExtra("KEY_MATERIAL_APPLIED", bool);
          if (localObject2 != null) {
            paramAEVideoCaptureResult.putExtra("ARG_GIF_MATERIAL_ID", ((blag)localObject2).jdField_a_of_type_JavaLangString);
          }
          paramAEVideoCaptureResult.putExtra("KEY_AVAILABLE_SAVENAME", (String)((blbp)localObject1).d().a());
          paramAEVideoCaptureResult.putExtra("ARG_SESSION_INFO", this.jdField_a_of_type_DovComQqImAeSessionWrap);
          paramAEVideoCaptureResult.putExtra("ARG_GIF_SEND_TO_AIO", blat.f(a().getIntent()));
          localObject1 = a();
          if (localObject1 == null) {
            break;
          }
          localObject2 = ((Activity)localObject1).getIntent();
          if (localObject2 != null)
          {
            int k = ((Intent)localObject2).getIntExtra("AECAMERA_MODE", 200);
            int m = ((Intent)localObject2).getIntExtra("VIDEO_STORY_FROM_TYPE", blat.a.a());
            paramAEVideoCaptureResult.putExtra("AECAMERA_MODE", k);
            paramAEVideoCaptureResult.putExtra("VIDEO_STORY_FROM_TYPE", m);
          }
          ((Activity)localObject1).startActivityForResult(paramAEVideoCaptureResult, 101);
          return;
        }
      }
      paramAEVideoCaptureResult = BaseApplicationImpl.getContext();
    } while (paramAEVideoCaptureResult == null);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.14(this, paramAEVideoCaptureResult));
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.j)
      {
        if (this.jdField_b_of_type_AndroidWidgetButton != null)
        {
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetButton.setSelected(true);
        }
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.b(true);
        this.j = false;
        bljn.b("AEPituCameraUnit", "【Dark Mode】Start");
      }
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetButton != null)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setSelected(false);
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.b(false);
    this.j = false;
  }
  
  private void y()
  {
    Object localObject = a();
    if (azkz.c((Context)localObject) / azkz.e((Context)localObject) >= 2.0F)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (!blat.h(a())) {
        bnle.c((Activity)localObject);
      }
    }
    if ((Build.MODEL.contains("Pixel 2")) && (Build.VERSION.SDK_INT >= 16))
    {
      localObject = ((Activity)localObject).getWindow().getDecorView();
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() & 0xFFFFFFFB);
    }
  }
  
  private void z()
  {
    bljn.b("AEPituCameraUnit", "setInitialMode---");
    blfq localblfq = (blfq)bkpx.a(this).a(blfq.class);
    localblfq.a.b(new blfi(this.jdField_b_of_type_DovComQqImAeModeAECaptureMode, 1));
    localblfq.b.b(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode);
  }
  
  public void U() {}
  
  public void W() {}
  
  public Activity a()
  {
    if (this.jdField_a_of_type_Bmhh == null) {
      return null;
    }
    return this.jdField_a_of_type_Bmhh.a();
  }
  
  public View a()
  {
    blfv.a().a("unitInflateView-begin");
    Object localObject = this.jdField_a_of_type_Bmhh.a().getLayoutInflater().inflate(2131558502, null, false);
    blfv.a().a("unitInflateView-end");
    this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131366605);
    A();
    this.jdField_a_of_type_Bkpw = ((bkpw)bkpx.a(this).a(bkpw.class));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363334));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363332));
    bnle.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, bdoo.a(1.0F));
    y();
    this.jdField_a_of_type_Bkth = new bkth(this.jdField_a_of_type_AndroidViewView, this);
    this.jdField_a_of_type_Bkto = new bkto((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377151));
    this.jdField_a_of_type_Bkpw.b.a(this.jdField_a_of_type_Bkto);
    localObject = this.jdField_a_of_type_Bkto;
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL)
    {
      bool = true;
      ((bkto)localObject).a(this, bool);
      this.jdField_a_of_type_Blft = new blft(this.jdField_a_of_type_Bmhh.a(), this.jdField_a_of_type_AndroidViewView, this);
      if (!this.jdField_b_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera())
      {
        z();
        this.jdField_a_of_type_Blft.a();
      }
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_Bmhh.a(), new bkpv(this, null), null, true);
      this.jdField_a_of_type_Bkyd = new bkyd(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Blft);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363890));
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAEKitInitListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setLaunchStateCallback(new bkpq(this));
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDarkModeEnable(true);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDarkModeListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setFaceEffectListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCameraListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAECaptureController(this.jdField_a_of_type_Bkth);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setStickerInnerLutFilterListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setRecommendTextCallback(new bkps(this));
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setIsVoiceNeedEncode(blat.i(a().getIntent()));
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a(a());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setPreExtractFrame(blat.j(a()));
      if (!azki.n()) {
        break label892;
      }
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(true);
      if (bkwl.a()) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a = this;
      }
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377146));
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131372413));
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setMaterialPanelListener(this.jdField_a_of_type_Bkxt);
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(8);
      }
      this.jdField_a_of_type_Bkya = new bkya((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377143));
      this.jdField_a_of_type_Bkpw.a.b(this.jdField_a_of_type_Bkya);
      CosFunHelper.setCountDownListener(new bkpt(this));
      this.jdField_a_of_type_Axpa = new axpa();
      this.jdField_a_of_type_Axpa.a(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Axpa.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel);
      this.jdField_a_of_type_Axpa.a(new bkpu(this));
      this.jdField_a_of_type_Bkya.a(this.jdField_a_of_type_Axpa);
      this.jdField_a_of_type_Axpe = this.jdField_a_of_type_Bkto.a();
      this.jdField_a_of_type_Axpf = new axpf(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
      this.jdField_a_of_type_Axpd = new axpd();
      this.jdField_a_of_type_Axoz = new axoz(this.jdField_a_of_type_AndroidViewViewStub);
      this.jdField_a_of_type_Axpc = new axpc(this.jdField_a_of_type_Bmhh.a());
      if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)) {
        break label935;
      }
    }
    label935:
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AEPituCameraUnit", 1, "onCreateView needLiuHaiTop:" + bool);
        }
        localObject = a().getIntent().getStringExtra("key_guide_image");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ausf.a(((String)localObject).substring("data:image/png;base64,".length()));
          localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
          if (BitmapUtils.isLegal((Bitmap)localObject))
          {
            ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363354);
            localImageView.setImageBitmap((Bitmap)localObject);
            localImageView.setVisibility(0);
          }
        }
        o();
        bljn.b("AEPituCameraUnit", "[UnitAsyncInit] before await");
        try
        {
          this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await(1000L, TimeUnit.MILLISECONDS);
          bljn.b("AEPituCameraUnit", "[UnitAsyncInit] after await");
          return this.jdField_a_of_type_AndroidViewView;
          bool = false;
          break;
          label892:
          this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(false);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            bljn.d("AEPituCameraUnit", "[UnitAsyncInit] await interrupt exp: " + localInterruptedException.getMessage());
          }
        }
      }
    }
  }
  
  protected bksf a()
  {
    Intent localIntent = a().getIntent();
    int k;
    if (blat.h(localIntent)) {
      if (localIntent.getBooleanExtra("key_camera_prefer_id", false)) {
        k = 2;
      }
    }
    while (azki.n())
    {
      return bnlc.a().a(this.jdField_a_of_type_Bmhh.a(), k);
      k = 1;
      continue;
      k = axph.a();
    }
    return bnlc.a().b(this.jdField_a_of_type_Bmhh.a(), k);
  }
  
  public bkth a()
  {
    return this.jdField_a_of_type_Bkth;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.7(this));
    int k = AEBeautyProviderView.a();
    int m = AEBeautyProviderView.b();
    this.jdField_a_of_type_Bkth.a(k);
    this.jdField_a_of_type_Bkth.b(m);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.8(this));
  }
  
  public void a(int paramInt)
  {
    this.d = false;
    QLog.e("AEPituCameraUnit", 2, "onCaptureError. errorCode = " + paramInt);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.13(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraUnit", 2, "onActivityResult:requestCode=" + paramInt1 + " resultCode=" + paramInt2 + " data=" + paramIntent + " publishStoryFlag=" + jdField_a_of_type_Boolean);
    }
    Activity localActivity = this.jdField_a_of_type_Bmhh.a();
    axpx.a(localActivity, paramInt1, paramInt2);
    if ((localActivity == null) || (localActivity.isFinishing())) {
      if (QLog.isColorLevel())
      {
        if (localActivity == null) {
          bool = true;
        }
        QLog.d("AEPituCameraUnit", 2, new Object[] { "activity is finishing, ", Boolean.valueOf(bool) });
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
    if ((paramInt1 == 1025) && (paramInt2 == -1) && (paramIntent != null))
    {
      String str1 = paramIntent.getStringExtra("file_send_path");
      long l = paramIntent.getLongExtra("file_send_duration", -1L);
      String str2 = paramIntent.getStringExtra("widgetinfo");
      if ((!TextUtils.isEmpty(str1)) && (l > 0L))
      {
        paramIntent = new Intent(localActivity, SendVideoActivity.class);
        paramIntent.putExtra("file_send_path", str1);
        paramIntent.putExtra("file_send_size", new File(str1).length());
        paramIntent.putExtra("file_send_duration", l);
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
    if ((paramIntent != null) && (paramInt2 == -1))
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setBlockCameraFlag(jdField_a_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.i("AEPituCameraUnit", 2, "cameraCaptureView setBlockCameraFlag");
      }
    }
    if ((paramInt2 == -1) && ((paramInt1 == 10006) || (paramInt1 == 1012))) {
      this.jdField_a_of_type_Bkth.j();
    }
    if (paramInt2 == 0) {
      bkoh.a(null);
    }
    if ((paramIntent != null) && (this.jdField_a_of_type_DovComQqImAeSessionWrap != null)) {
      paramIntent.putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_DovComQqImAeSessionWrap.a());
    }
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      bkoi.a(this.jdField_a_of_type_Bmhh.a(), paramIntent, this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult, this.jdField_a_of_type_Bmhg, null);
      return;
    }
    this.jdField_a_of_type_Blft.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    bljn.a("AEPituCameraUnit", "[AE Profiler] AEPituCameraUnit onCreate");
    long l = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    bliy.a().c(l);
    super.a(paramBundle);
    bhrb.jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Boolean = false;
    bnhb.a().b(false);
    this.jdField_a_of_type_DovComQqImAeSessionWrap = ((SessionWrap)this.jdField_a_of_type_Bmhh.a().getIntent().getParcelableExtra("ARG_SESSION_INFO"));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bmhh.a().getIntent().getStringExtra("ARG_AIO_CLASS");
    if (paramBundle != null) {
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = ((AEVideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver.a(this.jdField_a_of_type_Bmhh.a());
    this.jdField_a_of_type_Bljh.a();
    bliq.a();
  }
  
  public void a(axqw paramaxqw)
  {
    bliy.a().b(1L);
    bliu.a().b(-1L);
    bljn.b("AEPituCameraUnit", "【Type】Photo");
    Object localObject = a().getIntent();
    if (blat.i((Intent)localObject))
    {
      this.jdField_a_of_type_Blft.a(262148, new Object[] { paramaxqw });
      return;
    }
    if (blat.f((Intent)localObject))
    {
      localObject = new bmhc(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.b()).a(this.jdField_a_of_type_DovComQqImAeSessionWrap).a(this.jdField_a_of_type_JavaLangString).a(1).a();
      this.jdField_a_of_type_Bmgz.a((bmha)localObject);
      this.jdField_a_of_type_Blft.a(262148, new Object[] { paramaxqw, this.jdField_a_of_type_Bmgz, this.jdField_a_of_type_Blft.a(196610, new Object[0]) });
      return;
    }
    this.jdField_a_of_type_Blft.a(262148, new Object[] { paramaxqw, this.jdField_a_of_type_Blft.a(196610, new Object[0]) });
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    F();
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF)
    {
      if (paramVideoMaterial == null) {
        bliy.a().c("none");
      }
    }
    else
    {
      if (VideoMaterialUtil.isWatermarkMaterial(paramVideoMaterial)) {
        bkyw.a().a();
      }
      if ((!VideoMaterialUtil.isWatermarkEditable(paramVideoMaterial)) || (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF)) {
        break label102;
      }
      a().runOnUiThread(new AEPituCameraUnit.19(this, paramVideoMaterial));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bkyd != null) {
        this.jdField_a_of_type_Bkyd.a(paramVideoMaterial);
      }
      return;
      bliy.a().c(paramVideoMaterial.getId());
      break;
      label102:
      a().runOnUiThread(new AEPituCameraUnit.20(this, paramVideoMaterial));
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
    int k = 500;
    if (this.jdField_a_of_type_Int == 13) {
      k = 2000;
    }
    if (bnon.a(paramAEVideoCaptureResult.videoMp4FilePath) < k)
    {
      this.d = false;
      D();
      return;
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.p();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = paramAEVideoCaptureResult.videoMp4FilePath;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
    MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(this, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
  }
  
  public void a(String paramString)
  {
    bkzy localbkzy = (bkzy)blqr.a().c(18);
    if ((localbkzy != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = localbkzy.a(paramString);
      if (paramString == null) {
        Toast.makeText(a(), 2131689784, 1).show();
      }
    }
    else
    {
      return;
    }
    a().a(true, 150);
    this.jdField_a_of_type_Blft.a(327683, new Object[] { paramString });
    this.jdField_a_of_type_Blft.a(196612, new Object[0]);
  }
  
  public void a(@NonNull List<bkwo> paramList, @NonNull List<bkwn> paramList1)
  {
    this.jdField_a_of_type_Blft.a(720897, new Object[] { paramList, paramList1 });
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (this.jdField_b_of_type_AndroidWidgetButton == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.17(this));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    bljn.b("AEPituCameraUnit", "[onCameraStarted] + BEGIN, success = " + paramBoolean + ", errorMsg = " + paramString);
    if (!paramBoolean)
    {
      bljn.d("AEPituCameraUnit", "[onCameraStarted] error = " + paramString);
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.11(this));
    }
    for (;;)
    {
      int k = AEBeautyProviderView.a();
      int m = AEBeautyProviderView.b();
      this.jdField_a_of_type_Bkth.a(k);
      this.jdField_a_of_type_Bkth.b(m);
      this.jdField_a_of_type_Blft.a(458753, new Object[0]);
      return;
      if (this.jdField_a_of_type_Bljp != null) {
        this.jdField_a_of_type_Bljp.a();
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bkyd != null) {
      this.jdField_a_of_type_Bkyd.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bkth == null) {
      return false;
    }
    if (this.jdField_a_of_type_Bkth.a()) {
      return false;
    }
    if ((this.jdField_a_of_type_Blft.a(589824)) && (((Boolean)this.jdField_a_of_type_Blft.a(589826, new Object[0])).booleanValue()))
    {
      this.jdField_a_of_type_Blft.a(589826, new Object[0]);
      return true;
    }
    this.jdField_a_of_type_Bkth.h();
    this.jdField_a_of_type_Bkth.j();
    Intent localIntent;
    String str1;
    String str2;
    if (blat.i(a().getIntent()))
    {
      localIntent = a().getIntent();
      str1 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str2 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      if (str1 == null) {
        QQToast.a(a(), "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      }
    }
    else
    {
      this.jdField_a_of_type_Bmhh.a();
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF) {
        break label269;
      }
    }
    for (;;)
    {
      return true;
      localIntent.setClassName(str2, str1);
      localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      localIntent.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
      localIntent.addFlags(603979776);
      if (!localIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false))
      {
        a().startActivity(localIntent);
        break;
      }
      localIntent.getStringExtra("PhotoConst.PLUGIN_NAME");
      str2 = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      String str3 = localIntent.getStringExtra("PhotoConst.UIN");
      if (!"qzone_plugin.apk".equals(str2)) {
        break;
      }
      QzonePluginProxyActivity.a(localIntent, str1);
      bjdt.a(a(), str3, localIntent, 2);
      break;
      label269:
      bliu.a().p();
      bljn.b("AEPituCameraUnit", "【Click】onBackPressed");
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
          bdgm.a(localActivity, null, null);
          bool1 = false;
        }
      }
    }
    if (bool1) {
      bksp.a().f(paramBoolean);
    }
    return bool1;
  }
  
  public void b()
  {
    if (!this.i)
    {
      this.i = true;
      if (Build.VERSION.SDK_INT >= 23) {
        break label21;
      }
    }
    label21:
    while (!(this.jdField_a_of_type_Bmhh.a() instanceof QIMCameraCaptureActivity)) {
      return;
    }
    QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_Bmhh.a();
    int k;
    label63:
    int m;
    if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      k = 1;
      if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label188;
      }
      m = 1;
      label76:
      if (amrk.a(localQIMCameraCaptureActivity)) {
        break label193;
      }
    }
    label188:
    label193:
    for (int n = 1;; n = 0)
    {
      LinkedList localLinkedList = new LinkedList();
      if (k != 0) {
        localLinkedList.add("android.permission.CAMERA");
      }
      if (m != 0) {
        localLinkedList.add("android.permission.RECORD_AUDIO");
      }
      if (n != 0)
      {
        localLinkedList.add("android.permission.READ_EXTERNAL_STORAGE");
        localLinkedList.add("android.permission.WRITE_EXTERNAL_STORAGE");
      }
      if (localLinkedList.size() <= 0) {
        break;
      }
      localQIMCameraCaptureActivity.requestPermissions(this, 1, (String[])localLinkedList.toArray(new String[0]));
      return;
      k = 0;
      break label63;
      m = 0;
      break label76;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Bkth.a(paramInt);
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putSerializable("KEY_VIDEO_RESULT", this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setBlockCameraFlag(paramBoolean);
    }
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 128	bkpl:jdField_b_of_type_Int	I
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
    //   0	28	0	this	bkpl
    //   8	4	1	k	int
    //   1	19	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	23	finally
  }
  
  public void b_(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.6(this));
  }
  
  public void c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Bkyd != null) {
      this.jdField_a_of_type_Bkyd.c();
    }
    blft localblft = this.jdField_a_of_type_Blft;
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF) {}
    for (;;)
    {
      localblft.a(196611, new Object[] { Boolean.valueOf(bool) });
      this.jdField_a_of_type_Blft.a(327685, new Object[0]);
      return;
      bool = false;
    }
  }
  
  public void c(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366530);
    if ((localView instanceof VideoFilterViewPager))
    {
      ((VideoFilterViewPager)localView).setVisibility(paramInt);
      QLog.i("AEPituCameraUnit", 2, "yes to domVideoFilterViewPager setVisibility: " + paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.j();
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.k();
  }
  
  public void d()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onPause();
    super.d();
    this.jdField_c_of_type_Boolean = false;
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axpa);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axpe);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axpf);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axpd);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axoz);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axpc);
    this.jdField_a_of_type_Bkto.b();
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.m();
    }
    this.jdField_a_of_type_Bkth.h();
    this.jdField_a_of_type_Blft.c();
    if (QLog.isDevelopLevel()) {
      bljn.a("AEPituCameraUnit", "onActivityPause, hashCode=" + this.jdField_c_of_type_Int);
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
    int n = 1;
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Bmhh.a();
    int k;
    int m;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)
    {
      k = 1;
      if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label187;
      }
      m = 1;
      label48:
      if (amrk.a((Context)localObject)) {
        break label192;
      }
    }
    for (;;)
    {
      localObject = new LinkedList();
      if (k != 0)
      {
        ((List)localObject).add("android.permission.CAMERA");
        bljn.b("AEPituCameraUnit", "【Camera Permission】denied");
      }
      if (m != 0)
      {
        ((List)localObject).add("android.permission.RECORD_AUDIO");
        bljn.b("AEPituCameraUnit", "【Audio Permission】denied");
      }
      if (n != 0)
      {
        ((List)localObject).add("android.permission.READ_EXTERNAL_STORAGE");
        ((List)localObject).add("android.permission.WRITE_EXTERNAL_STORAGE");
        bljn.b("AEPituCameraUnit", "【External Storage Permission】denied");
      }
      localObject = bdgm.a((String[])((List)localObject).toArray(new String[0]));
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.10(this, (String)localObject));
      return;
      k = 0;
      break;
      label187:
      m = 0;
      break label48;
      label192:
      n = 0;
    }
  }
  
  public void e()
  {
    super.e();
    GLGestureProxy.getInstance().removeAllListener();
    blig.a().a();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver.b(this.jdField_a_of_type_Bmhh.a());
    this.jdField_a_of_type_Blft.f();
    if (bkwl.a()) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a = null;
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.f();
    bnpa.jdField_a_of_type_JavaLangString = null;
    bkyt.a().b();
    CosFunHelper.setCountDownListener(null);
    if (this.jdField_a_of_type_Bkth != null) {
      this.jdField_a_of_type_Bkth.e();
    }
    this.jdField_a_of_type_Bkto.c();
    bexu.a(BaseApplicationImpl.getContext(), true, 5);
    aofm.a(BaseApplicationImpl.getContext(), 2, true);
    bnrp.a.clear();
    this.jdField_a_of_type_Bljh.b();
    bliy.a().k();
    bliy.a().a(false);
    bliq.b();
    if ((a() != null) && (blat.h(a().getIntent()))) {
      bksp.a().c(axph.a());
    }
  }
  
  public void f()
  {
    super.f();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onResume();
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpa);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpe);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpf);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpd);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axoz);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpc);
    this.jdField_a_of_type_Bkth.i();
    if (this.g)
    {
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.l();
      }
      q();
      a(false);
    }
    this.jdField_a_of_type_Blft.b();
    bknb localbknb = (bknb)blqr.a(13);
    if (blat.e.a(a())) {
      localbknb.b(14);
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        bljn.a("AEPituCameraUnit", "onActivityResume, hashCode=" + this.jdField_c_of_type_Int);
      }
      c(false);
      return;
      localbknb.b(this.jdField_a_of_type_Bmgz.jdField_c_of_type_Int);
    }
  }
  
  public void g()
  {
    this.d = true;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.h();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.m();
    w();
    ((blrx)blqr.a(5)).a(true);
    c(8);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.9(this));
    }
    bljn.b("AEPituCameraUnit", "【Camera / Audio / Storage Permission】grant");
  }
  
  public void h()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.n();
    this.d = false;
    ((blrx)blqr.a(5)).a(false);
    c(0);
  }
  
  public void i()
  {
    this.jdField_a_of_type_Blft.a(786435, new Object[0]);
  }
  
  public void j()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.k();
    H();
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setVisibility(8);
    }
    if (!bksp.a().a()) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.q();
    }
    this.jdField_a_of_type_Blft.a(196609, new Object[0]);
    this.jdField_a_of_type_Blft.a(262147, new Object[0]);
  }
  
  public void k()
  {
    w();
  }
  
  public void l()
  {
    D();
  }
  
  public void l(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraUnit", 2, "onResourceDownload isOnlineRes: " + paramBoolean);
    }
    if (!jdField_b_of_type_Boolean)
    {
      jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Bmhh.a().runOnUiThread(new AEPituCameraUnit.25(this));
      return;
    }
    this.jdField_a_of_type_Bmhh.a().runOnUiThread(new AEPituCameraUnit.26(this));
  }
  
  public void m() {}
  
  public void n()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.12(this));
    this.jdField_a_of_type_Blft.a(196609, new Object[0]);
    this.jdField_a_of_type_Blft.a(262145, new Object[0]);
  }
  
  public void notifyEnableStickerInnerEffectFilter(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      d(1);
      if (this.jdField_a_of_type_Blft != null) {
        this.jdField_a_of_type_Blft.a(196609, new Object[0]);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bmhh != null) && (this.jdField_a_of_type_Bmhh.a() != null)) {
        this.jdField_a_of_type_Bmhh.a().runOnUiThread(new AEPituCameraUnit.27(this, paramBoolean));
      }
      return;
      d(0);
    }
  }
  
  protected void o()
  {
    this.jdField_a_of_type_Blfq = ((blfq)bkpx.a(this).a(blfq.class));
    this.jdField_a_of_type_Blfq.a.a(this, new bkpp(this));
    this.jdField_a_of_type_Blfr = ((blfr)bkpx.a(this).a(blfr.class));
  }
  
  public void onClick(View paramView)
  {
    int k = 1;
    switch (paramView.getId())
    {
    default: 
    case 2131364986: 
    case 2131364092: 
      do
      {
        do
        {
          return;
        } while (this.jdField_b_of_type_AndroidWidgetButton == null);
        bmar.a(this.jdField_b_of_type_AndroidWidgetButton, 200L, null);
        boolean bool;
        if (!this.jdField_b_of_type_AndroidWidgetButton.isSelected())
        {
          bool = true;
          this.jdField_b_of_type_AndroidWidgetButton.setSelected(bool);
          this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.b(bool);
          if (bool) {
            break label138;
          }
          this.j = true;
          axpx.a(bool);
          if (!bool) {
            break label146;
          }
        }
        for (;;)
        {
          axpl.c(k);
          return;
          bool = false;
          break;
          this.j = false;
          break label120;
          k = 2;
        }
        if (this.jdField_a_of_type_AndroidWidgetButton != null) {
          bmar.a(this.jdField_a_of_type_AndroidWidgetButton, 200L, null);
        }
        this.jdField_a_of_type_Bkth.a();
      } while (this.jdField_a_of_type_AndroidWidgetButton == null);
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a())
      {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getResources().getString(2131719262));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getResources().getString(2131719263));
      return;
    case 2131363909: 
    case 2131363914: 
      label120:
      bmar.a(paramView, 200L, null);
      label138:
      label146:
      u();
      return;
    }
    a().getIntent().removeExtra("widgetinfo");
  }
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    this.d = false;
    if (!paramBoolean)
    {
      a(101);
      return;
    }
    bljn.b("AEPituCameraUnit", "[onVideoCaptured] videoInfo = " + paramLocalMediaInfo.mDuration);
    bliy.a().b(2L);
    bliu.a().b(paramLocalMediaInfo.mDuration);
    this.jdField_a_of_type_Blft.a(196609, new Object[0]);
    this.jdField_a_of_type_Blft.a(262146, new Object[] { this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult, paramLocalMediaInfo, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Bmgz, this.jdField_a_of_type_Blft.a(196610, new Object[0]) });
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.b, this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
    }
    return true;
  }
  
  public void p()
  {
    super.p();
    this.jdField_a_of_type_Blft.d();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    bliu.a().o();
    if (QLog.isDevelopLevel()) {
      bljn.a("AEPituCameraUnit", "onActivityStart, hashCode=" + this.jdField_c_of_type_Int);
    }
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null)
    {
      if (aobe.d()) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
    }
    else
    {
      if (!GLVideoClipUtil.b()) {
        break label110;
      }
      if (this.jdField_b_of_type_AndroidWidgetButton != null) {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      }
    }
    for (;;)
    {
      c(true);
      bliy.a().h();
      bliu.a().I();
      if ((!this.jdField_a_of_type_Blfq.c()) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null)) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setVisibility(0);
      }
      this.jdField_a_of_type_Blfr.a().a(Boolean.valueOf(true));
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      break;
      label110:
      if ((this.jdField_b_of_type_AndroidWidgetButton != null) && (this.j))
      {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setSelected(false);
      }
    }
  }
  
  public void r()
  {
    this.jdField_a_of_type_Bkth.b();
  }
  
  public void s()
  {
    super.s();
  }
  
  public void t()
  {
    super.t();
    this.jdField_a_of_type_Blft.e();
    bliu.a().a(this.jdField_a_of_type_Long);
    if (QLog.isDevelopLevel()) {
      bljn.a("AEPituCameraUnit", "onActivityStop, hashCode=" + this.jdField_c_of_type_Int);
    }
  }
  
  public void u()
  {
    this.jdField_a_of_type_Bmhh.a().onBackPressed();
  }
  
  public void v()
  {
    a().getIntent().removeExtra("widgetinfo");
    bljo.a(a());
  }
  
  public void w()
  {
    if (this.jdField_a_of_type_Bkyd != null) {
      this.jdField_a_of_type_Bkyd.b();
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    this.jdField_a_of_type_Blfr.a().a(Boolean.valueOf(false));
  }
  
  public void x()
  {
    this.jdField_a_of_type_Blft.a(720898, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpl
 * JD-Core Version:    0.7.0.1
 */