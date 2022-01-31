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
public class bkle
  extends bkis
  implements View.OnClickListener, View.OnTouchListener, axlh, bkoc, bkod, bkoe, bkof, bksv, blwv, bncs, bncu, bngz, bnhf, AEFilterManager.StickerInnerEffectFilterListener, MediaScanner.OnMediaInfoScannerListener
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
  private axkq jdField_a_of_type_Axkq;
  private axkr jdField_a_of_type_Axkr;
  private axkt jdField_a_of_type_Axkt;
  private axku jdField_a_of_type_Axku;
  private axkv jdField_a_of_type_Axkv;
  private axkw jdField_a_of_type_Axkw;
  private bklp jdField_a_of_type_Bklp;
  private bkpa jdField_a_of_type_Bkpa;
  private bkph jdField_a_of_type_Bkph;
  private bktm jdField_a_of_type_Bktm = new bklk(this);
  private bktt jdField_a_of_type_Bktt;
  private bktw jdField_a_of_type_Bktw;
  private blbj jdField_a_of_type_Blbj;
  private blbk jdField_a_of_type_Blbk;
  private blbm jdField_a_of_type_Blbm;
  private blfa jdField_a_of_type_Blfa = new blfa();
  private blfi jdField_a_of_type_Blfi;
  private bmcn jdField_a_of_type_Bmcn = new bmcn(10000, 100, 2);
  private bmcu jdField_a_of_type_Bmcu;
  private bmcv jdField_a_of_type_Bmcv;
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
  
  public bkle()
  {
    blfg.b("AEPituCameraUnit", "[AEPituCameraUnit] + BEGIN");
    this.jdField_c_of_type_Int = 0;
    blfg.a("AEPituCameraUnit", "unitConstructor--fake");
    blfg.b("AEPituCameraUnit", "[AEPituCameraUnit] + END");
  }
  
  public bkle(bmcv parambmcv, bmcu parambmcu)
  {
    blfg.b("AEPituCameraUnit", "[AEPituCameraUnit] + BEGIN");
    long l = System.currentTimeMillis();
    blbo.a().a("unitConstructor-begin");
    this.jdField_a_of_type_Bmcv = parambmcv;
    this.jdField_a_of_type_Bmcu = parambmcu;
    this.jdField_a_of_type_Int = 11;
    betl.a(BaseApplicationImpl.getContext(), false, 5);
    aobd.a(BaseApplicationImpl.getContext(), 2, false);
    if (bkwm.h(a()))
    {
      this.jdField_a_of_type_Int = 13;
      this.jdField_a_of_type_Bmcn = new bmcn(10023, a().getIntent().getIntExtra("entrance_type", 120), 14);
    }
    for (;;)
    {
      blfg.b("AEPituCameraUnit", "[AEPituCameraUnit] submit unit init");
      ThreadManager.excute(new AEPituCameraUnit.1(this), 16, null, true);
      blbo.a().a("begin identity");
      this.jdField_c_of_type_Int = System.identityHashCode(this);
      blbo.a().a("end identity");
      blfg.b("AEPituCameraUnit", "[AEPituCameraUnit] + END, time cost = " + (System.currentTimeMillis() - l));
      return;
      if (!bkwm.e.a(a()))
      {
        this.jdField_a_of_type_Int = 11;
        this.jdField_a_of_type_Bmcn = new bmcn(10023, a().getIntent().getIntExtra("entrance_type", 120), 14);
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
        blfg.b("AEPituCameraUnit", "initCaptureModesAndFirstMode---initialMode=" + this.jdField_b_of_type_DovComQqImAeModeAECaptureMode + ", initialCModes=" + Arrays.toString(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode));
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
    int k = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bkwm.a.a());
    if (a() != bkwm.x.a())
    {
      String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
      if (bkwm.a(k).a()) {
        bler.a().a(k, str);
      }
      str = a().getIntent().getStringExtra("intent_key_uid_for_report");
      bler.a().a(str);
      bler.a().a(true);
      bler.a().b();
      bler.a().a();
      bler.a().b(bkvk.a(a()));
    }
    blen.a().J();
    if (bkwm.e.a(k)) {
      wta.a("check_Android", bkwm.e.a(), 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
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
    blfg.b("AEPituCameraUnit", "actionAfterFirstFrame");
    int k = this.jdField_a_of_type_Bmcv.a().getIntent().getIntExtra("edit_video_type", 10002);
    PeakAppInterface.a.a(blnc.jdField_a_of_type_JavaLangString, new Object[] { this, Integer.valueOf(k) });
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
    this.jdField_a_of_type_Bkpa.f();
    bngs.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, bdkf.a(1.0F));
  }
  
  private void H()
  {
    this.jdField_a_of_type_Blbk.a().a(Boolean.valueOf(false));
  }
  
  private int a()
  {
    if (a().getIntent() != null) {
      return a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bkwm.a.a());
    }
    return bkwm.a.a();
  }
  
  private long a()
  {
    long l1 = 9223372036854775807L;
    try
    {
      long l2 = bdal.b();
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
          blfg.d("AEPituCameraUnit", "[getFirstModeAccordingABTest], get invalid mode=" + localAECaptureMode2);
          localAECaptureMode1 = paramArrayOfAECaptureMode[0];
        }
        blfg.b("AEPituCameraUnit", "[getFirstModeAccordingABTest], ABTest name=" + str + ", real picked mode=" + localAECaptureMode1);
        return localAECaptureMode1;
        k = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", -1);
        if ((paramInt == 201) && (bkwm.c.a() == k)) {
          return AECaptureMode.PLAY;
        }
        if ((paramInt != 204) || (!bkwm.d(k))) {
          break label214;
        }
        str = blev.a().a("app_alg_entrance_qzone_id_from833", "", 4);
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
    if ((this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != paramAECaptureMode) && (this.jdField_a_of_type_Axkq != null)) {
      this.jdField_a_of_type_Axkq.a();
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
      bler.a().b(bool1);
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setIsGIFMode(bool1);
      }
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.21(this));
      this.jdField_a_of_type_Bkph.b(bool2);
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.PLAY) {
        break label191;
      }
      if (this.jdField_a_of_type_Bktw != null) {
        this.jdField_a_of_type_Bktw.a();
      }
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axkr);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axkv);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axkw);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axku);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axkq);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axkt);
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
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Axkr)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axkr);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Axkv)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axkv);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Axku)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axku);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Axkw)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axkw);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Axku)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axku);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Axkq)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axkq);
      }
    } while (GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Axkt));
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axkt);
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
      blfg.b("AEPituCameraUnit", "【GIF Capture】during time:" + (paramAEVideoCaptureResult.finishTimeMs - paramAEVideoCaptureResult.startTimeMs) + "ms");
      bler.a().b(5L);
      blen.a().N();
      long l = a();
      if (l > 0L)
      {
        paramAEVideoCaptureResult = new Intent(a(), AEStoryGIFPreviewActivity.class);
        paramAEVideoCaptureResult.putExtra("KEY_PREVIEW_SOURCE_PATH", this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath);
        paramAEVideoCaptureResult.putExtra("KEY_AVAILABLE_EMO_COUNT", l);
        Object localObject1 = (bkxi)bklq.a(this).a(bkxi.class);
        Object localObject2 = (bkvz)((bkxi)localObject1).c().a();
        if (localObject2 != null) {}
        for (boolean bool = true;; bool = false)
        {
          paramAEVideoCaptureResult.putExtra("KEY_MATERIAL_APPLIED", bool);
          if (localObject2 != null) {
            paramAEVideoCaptureResult.putExtra("ARG_GIF_MATERIAL_ID", ((bkvz)localObject2).jdField_a_of_type_JavaLangString);
          }
          paramAEVideoCaptureResult.putExtra("KEY_AVAILABLE_SAVENAME", (String)((bkxi)localObject1).d().a());
          paramAEVideoCaptureResult.putExtra("ARG_SESSION_INFO", this.jdField_a_of_type_DovComQqImAeSessionWrap);
          paramAEVideoCaptureResult.putExtra("ARG_GIF_SEND_TO_AIO", bkwm.f(a().getIntent()));
          localObject1 = a();
          if (localObject1 == null) {
            break;
          }
          localObject2 = ((Activity)localObject1).getIntent();
          if (localObject2 != null)
          {
            int k = ((Intent)localObject2).getIntExtra("AECAMERA_MODE", 200);
            int m = ((Intent)localObject2).getIntExtra("VIDEO_STORY_FROM_TYPE", bkwm.a.a());
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
        blfg.b("AEPituCameraUnit", "【Dark Mode】Start");
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
    if (azgq.c((Context)localObject) / azgq.e((Context)localObject) >= 2.0F)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (a() != bkwm.x.a()) {
        bngs.c((Activity)localObject);
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
    blfg.b("AEPituCameraUnit", "setInitialMode---");
    blbj localblbj = (blbj)bklq.a(this).a(blbj.class);
    localblbj.a.b(new blbb(this.jdField_b_of_type_DovComQqImAeModeAECaptureMode, 1));
    localblbj.b.b(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode);
  }
  
  public void U() {}
  
  public void W() {}
  
  public Activity a()
  {
    if (this.jdField_a_of_type_Bmcv == null) {
      return null;
    }
    return this.jdField_a_of_type_Bmcv.a();
  }
  
  public View a()
  {
    blbo.a().a("unitInflateView-begin");
    Object localObject = this.jdField_a_of_type_Bmcv.a().getLayoutInflater().inflate(2131558502, null, false);
    blbo.a().a("unitInflateView-end");
    this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131366599);
    A();
    this.jdField_a_of_type_Bklp = ((bklp)bklq.a(this).a(bklp.class));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363334));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363332));
    bngs.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, bdkf.a(1.0F));
    y();
    this.jdField_a_of_type_Bkpa = new bkpa(this.jdField_a_of_type_AndroidViewView, this);
    this.jdField_a_of_type_Bkph = new bkph((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377097));
    this.jdField_a_of_type_Bklp.b.a(this.jdField_a_of_type_Bkph);
    localObject = this.jdField_a_of_type_Bkph;
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL)
    {
      bool = true;
      ((bkph)localObject).a(this, bool);
      this.jdField_a_of_type_Blbm = new blbm(this.jdField_a_of_type_Bmcv.a(), this.jdField_a_of_type_AndroidViewView, this);
      if (!this.jdField_b_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera())
      {
        z();
        this.jdField_a_of_type_Blbm.a();
      }
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_Bmcv.a(), new bklo(this, null), null, true);
      this.jdField_a_of_type_Bktw = new bktw(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Blbm);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363888));
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAEKitInitListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setLaunchStateCallback(new bklj(this));
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDarkModeEnable(true);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDarkModeListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setFaceEffectListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCameraListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAECaptureController(this.jdField_a_of_type_Bkpa);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setStickerInnerLutFilterListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setRecommendTextCallback(new bkll(this));
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setIsVoiceNeedEncode(bkwm.i(a().getIntent()));
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a(a());
      if (!azfz.n()) {
        break label878;
      }
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(true);
      if (bkse.a()) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a = this;
      }
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377092));
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131372393));
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setMaterialPanelListener(this.jdField_a_of_type_Bktm);
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(8);
      }
      this.jdField_a_of_type_Bktt = new bktt((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377089));
      this.jdField_a_of_type_Bklp.a.b(this.jdField_a_of_type_Bktt);
      CosFunHelper.setCountDownListener(new bklm(this));
      this.jdField_a_of_type_Axkr = new axkr();
      this.jdField_a_of_type_Axkr.a(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Axkr.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel);
      this.jdField_a_of_type_Axkr.a(new bkln(this));
      this.jdField_a_of_type_Bktt.a(this.jdField_a_of_type_Axkr);
      this.jdField_a_of_type_Axkv = this.jdField_a_of_type_Bkph.a();
      this.jdField_a_of_type_Axkw = new axkw(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
      this.jdField_a_of_type_Axku = new axku();
      this.jdField_a_of_type_Axkq = new axkq(this.jdField_a_of_type_AndroidViewViewStub);
      this.jdField_a_of_type_Axkt = new axkt(this.jdField_a_of_type_Bmcv.a());
      if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)) {
        break label921;
      }
    }
    label921:
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AEPituCameraUnit", 1, "onCreateView needLiuHaiTop:" + bool);
        }
        localObject = a().getIntent().getStringExtra("key_guide_image");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = aunw.a(((String)localObject).substring("data:image/png;base64,".length()));
          localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
          if (BitmapUtils.isLegal((Bitmap)localObject))
          {
            ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363354);
            localImageView.setImageBitmap((Bitmap)localObject);
            localImageView.setVisibility(0);
          }
        }
        o();
        blfg.b("AEPituCameraUnit", "[UnitAsyncInit] before await");
        try
        {
          this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await(1000L, TimeUnit.MILLISECONDS);
          blfg.b("AEPituCameraUnit", "[UnitAsyncInit] after await");
          return this.jdField_a_of_type_AndroidViewView;
          bool = false;
          break;
          label878:
          this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(false);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            blfg.d("AEPituCameraUnit", "[UnitAsyncInit] await interrupt exp: " + localInterruptedException.getMessage());
          }
        }
      }
    }
  }
  
  protected bkny a()
  {
    Intent localIntent = a().getIntent();
    int k;
    if (bkwm.h(localIntent)) {
      if (localIntent.getBooleanExtra("key_camera_prefer_id", false)) {
        k = 2;
      }
    }
    while (azfz.n())
    {
      return bngq.a().a(this.jdField_a_of_type_Bmcv.a(), k);
      k = 1;
      continue;
      k = axky.a();
    }
    return bngq.a().b(this.jdField_a_of_type_Bmcv.a(), k);
  }
  
  public bkpa a()
  {
    return this.jdField_a_of_type_Bkpa;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.7(this));
    int k = AEBeautyProviderView.a();
    int m = AEBeautyProviderView.b();
    this.jdField_a_of_type_Bkpa.a(k);
    this.jdField_a_of_type_Bkpa.b(m);
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
    Activity localActivity = this.jdField_a_of_type_Bmcv.a();
    axlo.a(localActivity, paramInt1, paramInt2);
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
      this.jdField_a_of_type_Bkpa.j();
    }
    if (paramInt2 == 0) {
      bkka.a(null);
    }
    if ((paramIntent != null) && (this.jdField_a_of_type_DovComQqImAeSessionWrap != null)) {
      paramIntent.putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_DovComQqImAeSessionWrap.a());
    }
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      bkkb.a(this.jdField_a_of_type_Bmcv.a(), paramIntent, this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult, this.jdField_a_of_type_Bmcu, null);
      return;
    }
    this.jdField_a_of_type_Blbm.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    blfg.a("AEPituCameraUnit", "[AE Profiler] AEPituCameraUnit onCreate");
    long l = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    bler.a().c(l);
    super.a(paramBundle);
    bhmu.jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Boolean = false;
    bncp.a().b(false);
    this.jdField_a_of_type_DovComQqImAeSessionWrap = ((SessionWrap)this.jdField_a_of_type_Bmcv.a().getIntent().getParcelableExtra("ARG_SESSION_INFO"));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bmcv.a().getIntent().getStringExtra("ARG_AIO_CLASS");
    if (paramBundle != null) {
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = ((AEVideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver.a(this.jdField_a_of_type_Bmcv.a());
    this.jdField_a_of_type_Blfa.a();
    blej.a();
  }
  
  public void a(axmn paramaxmn)
  {
    bler.a().b(1L);
    blen.a().b(-1L);
    blfg.b("AEPituCameraUnit", "【Type】Photo");
    Object localObject = a().getIntent();
    if (bkwm.i((Intent)localObject))
    {
      this.jdField_a_of_type_Blbm.a(262148, new Object[] { paramaxmn });
      return;
    }
    if (bkwm.f((Intent)localObject))
    {
      localObject = new bmcq(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.b()).a(this.jdField_a_of_type_DovComQqImAeSessionWrap).a(this.jdField_a_of_type_JavaLangString).a(1).a();
      this.jdField_a_of_type_Bmcn.a((bmco)localObject);
      this.jdField_a_of_type_Blbm.a(262148, new Object[] { paramaxmn, this.jdField_a_of_type_Bmcn, this.jdField_a_of_type_Blbm.a(196610, new Object[0]) });
      return;
    }
    this.jdField_a_of_type_Blbm.a(262148, new Object[] { paramaxmn, this.jdField_a_of_type_Blbm.a(196610, new Object[0]) });
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    F();
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF)
    {
      if (paramVideoMaterial == null) {
        bler.a().c("none");
      }
    }
    else
    {
      if (VideoMaterialUtil.isWatermarkMaterial(paramVideoMaterial)) {
        bkup.a().a();
      }
      if ((!VideoMaterialUtil.isWatermarkEditable(paramVideoMaterial)) || (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF)) {
        break label102;
      }
      a().runOnUiThread(new AEPituCameraUnit.19(this, paramVideoMaterial));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bktw != null) {
        this.jdField_a_of_type_Bktw.a(paramVideoMaterial);
      }
      return;
      bler.a().c(paramVideoMaterial.getId());
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
    if (bnkb.a(paramAEVideoCaptureResult.videoMp4FilePath) < k)
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
    bkvr localbkvr = (bkvr)blmf.a().c(18);
    if ((localbkvr != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = localbkvr.a(paramString);
      if (paramString == null) {
        Toast.makeText(a(), 2131689784, 1).show();
      }
    }
    else
    {
      return;
    }
    a().a(true, 150);
    this.jdField_a_of_type_Blbm.a(327683, new Object[] { paramString });
    this.jdField_a_of_type_Blbm.a(196612, new Object[0]);
  }
  
  public void a(@NonNull List<bksh> paramList, @NonNull List<bksg> paramList1)
  {
    this.jdField_a_of_type_Blbm.a(720897, new Object[] { paramList, paramList1 });
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
    blfg.b("AEPituCameraUnit", "[onCameraStarted] + BEGIN, success = " + paramBoolean + ", errorMsg = " + paramString);
    if (!paramBoolean)
    {
      blfg.d("AEPituCameraUnit", "[onCameraStarted] error = " + paramString);
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.11(this));
    }
    for (;;)
    {
      int k = AEBeautyProviderView.a();
      int m = AEBeautyProviderView.b();
      this.jdField_a_of_type_Bkpa.a(k);
      this.jdField_a_of_type_Bkpa.b(m);
      this.jdField_a_of_type_Blbm.a(458753, new Object[0]);
      return;
      if (this.jdField_a_of_type_Blfi != null) {
        this.jdField_a_of_type_Blfi.a();
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bktw != null) {
      this.jdField_a_of_type_Bktw.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bkpa == null) {
      return false;
    }
    if (this.jdField_a_of_type_Bkpa.a()) {
      return false;
    }
    if ((this.jdField_a_of_type_Blbm.a(589824)) && (((Boolean)this.jdField_a_of_type_Blbm.a(589826, new Object[0])).booleanValue()))
    {
      this.jdField_a_of_type_Blbm.a(589826, new Object[0]);
      return true;
    }
    this.jdField_a_of_type_Bkpa.h();
    this.jdField_a_of_type_Bkpa.j();
    Intent localIntent;
    String str1;
    String str2;
    if (bkwm.i(a().getIntent()))
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
      this.jdField_a_of_type_Bmcv.a();
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
      bizm.a(a(), str3, localIntent, 2);
      break;
      label269:
      blen.a().p();
      blfg.b("AEPituCameraUnit", "【Click】onBackPressed");
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
          bdcd.a(localActivity, null, null);
          bool1 = false;
        }
      }
    }
    if (bool1) {
      bkoi.a().f(paramBoolean);
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
    while (!(this.jdField_a_of_type_Bmcv.a() instanceof QIMCameraCaptureActivity)) {
      return;
    }
    QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_Bmcv.a();
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
      if (ammv.a(localQIMCameraCaptureActivity)) {
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
    this.jdField_a_of_type_Bkpa.a(paramInt);
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
    //   5: getfield 128	bkle:jdField_b_of_type_Int	I
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
    //   0	28	0	this	bkle
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
    if (this.jdField_a_of_type_Bktw != null) {
      this.jdField_a_of_type_Bktw.c();
    }
    blbm localblbm = this.jdField_a_of_type_Blbm;
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF) {}
    for (;;)
    {
      localblbm.a(196611, new Object[] { Boolean.valueOf(bool) });
      this.jdField_a_of_type_Blbm.a(327685, new Object[0]);
      return;
      bool = false;
    }
  }
  
  public void c(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366524);
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
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axkr);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axkv);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axkw);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axku);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axkq);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axkt);
    this.jdField_a_of_type_Bkph.b();
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.m();
    }
    this.jdField_a_of_type_Bkpa.h();
    this.jdField_a_of_type_Blbm.c();
    if (QLog.isDevelopLevel()) {
      blfg.a("AEPituCameraUnit", "onActivityPause, hashCode=" + this.jdField_c_of_type_Int);
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
    Object localObject = this.jdField_a_of_type_Bmcv.a();
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
      if (ammv.a((Context)localObject)) {
        break label192;
      }
    }
    for (;;)
    {
      localObject = new LinkedList();
      if (k != 0)
      {
        ((List)localObject).add("android.permission.CAMERA");
        blfg.b("AEPituCameraUnit", "【Camera Permission】denied");
      }
      if (m != 0)
      {
        ((List)localObject).add("android.permission.RECORD_AUDIO");
        blfg.b("AEPituCameraUnit", "【Audio Permission】denied");
      }
      if (n != 0)
      {
        ((List)localObject).add("android.permission.READ_EXTERNAL_STORAGE");
        ((List)localObject).add("android.permission.WRITE_EXTERNAL_STORAGE");
        blfg.b("AEPituCameraUnit", "【External Storage Permission】denied");
      }
      localObject = bdcd.a((String[])((List)localObject).toArray(new String[0]));
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
    bldz.a().a();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver.b(this.jdField_a_of_type_Bmcv.a());
    this.jdField_a_of_type_Blbm.f();
    if (bkse.a()) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a = null;
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.f();
    bnko.jdField_a_of_type_JavaLangString = null;
    bkum.a().b();
    CosFunHelper.setCountDownListener(null);
    if (this.jdField_a_of_type_Bkpa != null) {
      this.jdField_a_of_type_Bkpa.e();
    }
    this.jdField_a_of_type_Bkph.c();
    betl.a(BaseApplicationImpl.getContext(), true, 5);
    aobd.a(BaseApplicationImpl.getContext(), 2, true);
    bnnd.a.clear();
    this.jdField_a_of_type_Blfa.b();
    bler.a().k();
    bler.a().a(false);
    blej.b();
    if ((a() != null) && (bkwm.h(a().getIntent()))) {
      bkoi.a().c(axky.a());
    }
  }
  
  public void f()
  {
    super.f();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onResume();
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axkr);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axkv);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axkw);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axku);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axkq);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axkt);
    this.jdField_a_of_type_Bkpa.i();
    if (this.g)
    {
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.l();
      }
      q();
      a(false);
    }
    this.jdField_a_of_type_Blbm.b();
    bkiu localbkiu = (bkiu)blmf.a(13);
    if (bkwm.e.a(a())) {
      localbkiu.b(14);
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        blfg.a("AEPituCameraUnit", "onActivityResume, hashCode=" + this.jdField_c_of_type_Int);
      }
      c(false);
      return;
      localbkiu.b(this.jdField_a_of_type_Bmcn.jdField_c_of_type_Int);
    }
  }
  
  public void g()
  {
    this.d = true;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.h();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.m();
    w();
    ((blnl)blmf.a(5)).a(true);
    c(8);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.9(this));
    }
    blfg.b("AEPituCameraUnit", "【Camera / Audio / Storage Permission】grant");
  }
  
  public void h()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.n();
    this.d = false;
    ((blnl)blmf.a(5)).a(false);
    c(0);
  }
  
  public void i()
  {
    this.jdField_a_of_type_Blbm.a(786435, new Object[0]);
  }
  
  public void j()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.k();
    H();
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setVisibility(8);
    }
    if (!bkoi.a().a()) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.q();
    }
    this.jdField_a_of_type_Blbm.a(196609, new Object[0]);
    this.jdField_a_of_type_Blbm.a(262147, new Object[0]);
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
      this.jdField_a_of_type_Bmcv.a().runOnUiThread(new AEPituCameraUnit.25(this));
      return;
    }
    this.jdField_a_of_type_Bmcv.a().runOnUiThread(new AEPituCameraUnit.26(this));
  }
  
  public void m() {}
  
  public void n()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.12(this));
    this.jdField_a_of_type_Blbm.a(196609, new Object[0]);
    this.jdField_a_of_type_Blbm.a(262145, new Object[0]);
  }
  
  public void notifyEnableStickerInnerEffectFilter(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      d(1);
      if (this.jdField_a_of_type_Blbm != null) {
        this.jdField_a_of_type_Blbm.a(196609, new Object[0]);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bmcv != null) && (this.jdField_a_of_type_Bmcv.a() != null)) {
        this.jdField_a_of_type_Bmcv.a().runOnUiThread(new AEPituCameraUnit.27(this, paramBoolean));
      }
      return;
      d(0);
    }
  }
  
  protected void o()
  {
    this.jdField_a_of_type_Blbj = ((blbj)bklq.a(this).a(blbj.class));
    this.jdField_a_of_type_Blbj.a.a(this, new bkli(this));
    this.jdField_a_of_type_Blbk = ((blbk)bklq.a(this).a(blbk.class));
  }
  
  public void onClick(View paramView)
  {
    int k = 1;
    switch (paramView.getId())
    {
    default: 
    case 2131364984: 
    case 2131364090: 
      do
      {
        do
        {
          return;
        } while (this.jdField_b_of_type_AndroidWidgetButton == null);
        blwf.a(this.jdField_b_of_type_AndroidWidgetButton, 200L, null);
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
          axlo.a(bool);
          if (!bool) {
            break label146;
          }
        }
        for (;;)
        {
          axlc.c(k);
          return;
          bool = false;
          break;
          this.j = false;
          break label120;
          k = 2;
        }
        if (this.jdField_a_of_type_AndroidWidgetButton != null) {
          blwf.a(this.jdField_a_of_type_AndroidWidgetButton, 200L, null);
        }
        this.jdField_a_of_type_Bkpa.a();
      } while (this.jdField_a_of_type_AndroidWidgetButton == null);
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a())
      {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getResources().getString(2131719250));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getResources().getString(2131719251));
      return;
    case 2131363907: 
    case 2131363912: 
      label120:
      blwf.a(paramView, 200L, null);
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
    blfg.b("AEPituCameraUnit", "[onVideoCaptured] videoInfo = " + paramLocalMediaInfo.mDuration);
    bler.a().b(2L);
    blen.a().b(paramLocalMediaInfo.mDuration);
    this.jdField_a_of_type_Blbm.a(196609, new Object[0]);
    this.jdField_a_of_type_Blbm.a(262146, new Object[] { this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult, paramLocalMediaInfo, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Bmcn, this.jdField_a_of_type_Blbm.a(196610, new Object[0]) });
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
    this.jdField_a_of_type_Blbm.d();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    blen.a().o();
    if (QLog.isDevelopLevel()) {
      blfg.a("AEPituCameraUnit", "onActivityStart, hashCode=" + this.jdField_c_of_type_Int);
    }
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null)
    {
      if (anwv.d()) {
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
      bler.a().h();
      blen.a().I();
      if ((!this.jdField_a_of_type_Blbj.c()) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null)) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setVisibility(0);
      }
      this.jdField_a_of_type_Blbk.a().a(Boolean.valueOf(true));
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
    this.jdField_a_of_type_Bkpa.b();
  }
  
  public void s()
  {
    super.s();
  }
  
  public void t()
  {
    super.t();
    this.jdField_a_of_type_Blbm.e();
    blen.a().a(this.jdField_a_of_type_Long);
    if (QLog.isDevelopLevel()) {
      blfg.a("AEPituCameraUnit", "onActivityStop, hashCode=" + this.jdField_c_of_type_Int);
    }
  }
  
  public void u()
  {
    this.jdField_a_of_type_Bmcv.a().onBackPressed();
  }
  
  public void v()
  {
    a().getIntent().removeExtra("widgetinfo");
    blfh.a(a());
  }
  
  public void w()
  {
    if (this.jdField_a_of_type_Bktw != null) {
      this.jdField_a_of_type_Bktw.b();
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    this.jdField_a_of_type_Blbk.a().a(Boolean.valueOf(false));
  }
  
  public void x()
  {
    this.jdField_a_of_type_Blbm.a(720898, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkle
 * JD-Core Version:    0.7.0.1
 */