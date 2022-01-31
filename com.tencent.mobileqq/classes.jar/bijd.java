import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import android.support.annotation.CallSuper;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.aekit.api.standard.filter.AEFilterManager.StickerInnerEffectFilterListener;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.filter.CosFunHelper;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;
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
import dov.com.qq.im.ae.AEPituCameraUnit.18;
import dov.com.qq.im.ae.AEPituCameraUnit.20;
import dov.com.qq.im.ae.AEPituCameraUnit.21;
import dov.com.qq.im.ae.AEPituCameraUnit.22;
import dov.com.qq.im.ae.AEPituCameraUnit.23;
import dov.com.qq.im.ae.AEPituCameraUnit.24;
import dov.com.qq.im.ae.AEPituCameraUnit.25;
import dov.com.qq.im.ae.AEPituCameraUnit.26;
import dov.com.qq.im.ae.AEPituCameraUnit.27;
import dov.com.qq.im.ae.AEPituCameraUnit.28;
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
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

@TargetApi(9)
public class bijd
  extends bigw
  implements agmh, View.OnClickListener, View.OnTouchListener, avti, biju, bijv, bijw, bijx, biob, bjll, bkri, bkrk, bkvp, bkvv, AEFilterManager.StickerInnerEffectFilterListener
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
  private avss jdField_a_of_type_Avss;
  private avst jdField_a_of_type_Avst;
  private avsv jdField_a_of_type_Avsv;
  private avsw jdField_a_of_type_Avsw;
  private avsx jdField_a_of_type_Avsx;
  private bijn jdField_a_of_type_Bijn;
  private bikl jdField_a_of_type_Bikl;
  private biks jdField_a_of_type_Biks;
  private bios jdField_a_of_type_Bios = new biji(this);
  private bioz jdField_a_of_type_Bioz;
  private bipc jdField_a_of_type_Bipc;
  private biwo jdField_a_of_type_Biwo = biwo.jdField_a_of_type_Biwo;
  private biwp jdField_a_of_type_Biwp;
  private biwq jdField_a_of_type_Biwq;
  private biws jdField_a_of_type_Biws;
  private bjaf jdField_a_of_type_Bjaf = new bjaf();
  private bjaj jdField_a_of_type_Bjaj;
  private bjrd jdField_a_of_type_Bjrd = new bjrd(10000, 100, 2);
  private bjrk jdField_a_of_type_Bjrk;
  private bjrl jdField_a_of_type_Bjrl;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private SessionWrap jdField_a_of_type_DovComQqImAeSessionWrap;
  private AEVideoCaptureResult jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult;
  private AECameraBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver = new AECameraBroadcastReceiver(this);
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private AEMaterialPanel jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel;
  private AEPituCameraCaptureButtonLayout jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString;
  private CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private final int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  
  public bijd()
  {
    bjah.b("AEPituCameraUnit", "[AEPituCameraUnit] + BEGIN");
    this.jdField_c_of_type_Int = 0;
    bjah.a("AEPituCameraUnit", "unitConstructor--fake");
    bjah.b("AEPituCameraUnit", "[AEPituCameraUnit] + END");
  }
  
  public bijd(bjrl parambjrl, bjrk parambjrk)
  {
    bjah.b("AEPituCameraUnit", "[AEPituCameraUnit] + BEGIN");
    long l = System.currentTimeMillis();
    biwu.a().a("unitConstructor-begin");
    this.jdField_a_of_type_Bjrl = parambjrl;
    this.jdField_a_of_type_Bjrk = parambjrk;
    this.jdField_a_of_type_Int = 11;
    bcuc.a(BaseApplicationImpl.getContext(), false, 5);
    amkf.a(BaseApplicationImpl.getContext(), 2, false);
    if (!birt.e.a(a()))
    {
      this.jdField_a_of_type_Int = 11;
      this.jdField_a_of_type_Bjrd = new bjrd(10023, a().getIntent().getIntExtra("entrance_type", 120), 14);
    }
    for (;;)
    {
      bjah.b("AEPituCameraUnit", "[AEPituCameraUnit] submit unit init");
      ThreadManager.excute(new AEPituCameraUnit.1(this), 16, null, true);
      biwu.a().a("begin identity");
      this.jdField_c_of_type_Int = System.identityHashCode(this);
      biwu.a().a("end identity");
      bjah.b("AEPituCameraUnit", "[AEPituCameraUnit] + END, time cost = " + (System.currentTimeMillis() - l));
      return;
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  private void A()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.16(this));
  }
  
  private void B()
  {
    if (this.h) {
      return;
    }
    this.h = true;
    int j = this.jdField_a_of_type_Bjrl.a().getIntent().getIntExtra("edit_video_type", 10002);
    PeakAppInterface.a.a(bjbs.jdField_a_of_type_JavaLangString, new Object[] { this, Integer.valueOf(j) });
    if (!this.e)
    {
      this.e = true;
      PeakAppInterface.a.a(1010);
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.17(this));
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.25(this));
    }
  }
  
  private void D()
  {
    this.jdField_a_of_type_Bikl.f();
    bkvi.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, bbll.a(1.0F));
  }
  
  private void E()
  {
    this.jdField_a_of_type_Biwq.a().a(Boolean.valueOf(false));
  }
  
  private int a()
  {
    if (a().getIntent() != null) {
      return a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", birt.a.a());
    }
    return birt.a.a();
  }
  
  private long a()
  {
    long l1 = 9223372036854775807L;
    try
    {
      long l2 = bbbr.b();
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
  
  private void a(@Nullable biwo parambiwo)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_Biwo = parambiwo;
    boolean bool1;
    if (this.jdField_a_of_type_Biwo == biwo.c)
    {
      bool1 = true;
      if (this.jdField_a_of_type_Biwo != biwo.jdField_a_of_type_Biwo) {
        break label154;
      }
      label29:
      bizx.a().b(bool1);
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setIsGIFMode(bool1);
      }
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.22(this));
      this.jdField_a_of_type_Biks.b(bool2);
      if (this.jdField_a_of_type_Biwo != biwo.b) {
        break label159;
      }
      if (this.jdField_a_of_type_Bipc != null) {
        this.jdField_a_of_type_Bipc.a();
      }
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avst);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avsw);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avsx);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avss);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avsv);
    }
    label154:
    label159:
    do
    {
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label29;
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Avst)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avst);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Avsw)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avsw);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Avsx)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avsx);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Avss)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avss);
      }
    } while (GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Avsv));
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avsv);
  }
  
  private void a(LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable)
  {
    C();
    if (paramLazyLoadAnimationDrawable == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable = new AEPituCameraUnit.23(this);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.24(this, paramLazyLoadAnimationDrawable));
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
        A();
        return;
      }
      bjah.b("AEPituCameraUnit", "【GIF Capture】during time:" + (paramAEVideoCaptureResult.finishTimeMs - paramAEVideoCaptureResult.startTimeMs) + "ms");
      bizx.a().b(5L);
      bizt.a().F();
      long l = a();
      if (l > 0L)
      {
        paramAEVideoCaptureResult = new Intent(a(), AEStoryGIFPreviewActivity.class);
        paramAEVideoCaptureResult.putExtra("KEY_PREVIEW_SOURCE_PATH", this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath);
        paramAEVideoCaptureResult.putExtra("KEY_AVAILABLE_EMO_COUNT", l);
        Object localObject = (bisp)bijo.a(this).a(bisp.class);
        if (((bisp)localObject).c().a() != null) {}
        for (boolean bool = true;; bool = false)
        {
          paramAEVideoCaptureResult.putExtra("KEY_MATERIAL_APPLIED", bool);
          paramAEVideoCaptureResult.putExtra("KEY_AVAILABLE_SAVENAME", (String)((bisp)localObject).d().a());
          paramAEVideoCaptureResult.putExtra("ARG_SESSION_INFO", this.jdField_a_of_type_DovComQqImAeSessionWrap);
          paramAEVideoCaptureResult.putExtra("ARG_GIF_SEND_TO_AIO", birt.f(a().getIntent()));
          localObject = a();
          if (localObject == null) {
            break;
          }
          Intent localIntent = ((Activity)localObject).getIntent();
          if (localIntent != null)
          {
            int j = localIntent.getIntExtra("AECAMERA_MODE", 200);
            int k = localIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", birt.a.a());
            paramAEVideoCaptureResult.putExtra("AECAMERA_MODE", j);
            paramAEVideoCaptureResult.putExtra("VIDEO_STORY_FROM_TYPE", k);
          }
          ((Activity)localObject).startActivityForResult(paramAEVideoCaptureResult, 101);
          return;
        }
      }
      paramAEVideoCaptureResult = BaseApplicationImpl.getContext();
    } while (paramAEVideoCaptureResult == null);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.15(this, paramAEVideoCaptureResult));
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.i)
      {
        if (this.jdField_b_of_type_AndroidWidgetButton != null)
        {
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetButton.setSelected(true);
        }
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.b(true);
        this.i = false;
        bjah.b("AEPituCameraUnit", "【Dark Mode】Start");
      }
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetButton != null)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setSelected(false);
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.b(false);
    this.i = false;
  }
  
  private void y()
  {
    int j = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", birt.a.a());
    String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
    if (birt.a(j).a()) {
      bizx.a().a(j, str);
    }
    str = a().getIntent().getStringExtra("intent_key_uid_for_report");
    bizx.a().a(str);
    bizx.a().a(true);
    bizx.a().b();
    bizx.a().a();
    bizx.a().b(biqu.a(a()));
    bizt.a().D();
    if (birt.e.a(j)) {
      vei.a("check_Android", birt.e.a(), 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
    }
  }
  
  private void z()
  {
    String str = a().getIntent().getStringExtra("KEY_CURRENT_TAB");
    int j = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", -1);
    int k = a().getIntent().getIntExtra("AECAMERA_MODE", 200);
    if (!TextUtils.isEmpty(str)) {
      biij.jdField_a_of_type_JavaLangString = str;
    }
    for (;;)
    {
      biij.b = bjaa.a().a("app_ui_playshow_ad_id", "", 4);
      AEPituCameraCaptureButtonLayout.i();
      return;
      if ((birt.c.a() == j) && (k == 201)) {
        biij.jdField_a_of_type_JavaLangString = bjaa.a().a("app_alg_entrance_id", "", 4);
      } else if ((birt.d(j)) && (k == 204)) {
        biij.jdField_a_of_type_JavaLangString = bjaa.a().a("app_alg_entrance_qzone_id", "", 4);
      } else {
        biij.jdField_a_of_type_JavaLangString = String.valueOf(biwo.jdField_a_of_type_Biwo.jdField_a_of_type_Int);
      }
    }
  }
  
  public void U() {}
  
  public void W() {}
  
  public Activity a()
  {
    if (this.jdField_a_of_type_Bjrl == null) {
      return null;
    }
    return this.jdField_a_of_type_Bjrl.a();
  }
  
  public View a()
  {
    biwu.a().a("unitInflateView-begin");
    Object localObject = this.jdField_a_of_type_Bjrl.a().getLayoutInflater().inflate(2131558498, null, false);
    biwu.a().a("unitInflateView-end");
    this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131366493);
    this.jdField_a_of_type_Bijn = ((bijn)bijo.a(this).a(bijn.class));
    ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376591)).inflate();
    ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376593)).inflate();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363296));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363294));
    bkvi.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, bbll.a(1.0F));
    this.jdField_a_of_type_Bikl = new bikl(this.jdField_a_of_type_AndroidViewView, this);
    this.jdField_a_of_type_Biks = new biks((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376597));
    this.jdField_a_of_type_Bijn.b.a(this.jdField_a_of_type_Biks);
    localObject = this.jdField_a_of_type_Biks;
    if (this.jdField_a_of_type_Biwo == biwo.jdField_a_of_type_Biwo)
    {
      bool = true;
      ((biks)localObject).a(this, bool);
      this.jdField_a_of_type_Biws = new biws(this.jdField_a_of_type_Bjrl.a(), this.jdField_a_of_type_AndroidViewView, this);
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_Bjrl.a(), new bijm(this, null), null, true);
      this.jdField_a_of_type_Bipc = new bipc(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Biws);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363832));
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAEKitInitListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setLaunchStateCallback(new bijh(this));
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDarkModeEnable(true);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDarkModeListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setFaceEffectListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCameraListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAECaptureController(this.jdField_a_of_type_Bikl);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setStickerInnerLutFilterListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setRecommendTextCallback(new bijj(this));
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a(a());
      if (!axkt.n()) {
        break label855;
      }
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(true);
      if (bink.a()) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a = this;
      }
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376592));
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131372075));
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setMaterialPanelListener(this.jdField_a_of_type_Bios);
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(8);
      }
      this.jdField_a_of_type_Bioz = new bioz((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376589));
      this.jdField_a_of_type_Bijn.a.b(this.jdField_a_of_type_Bioz);
      CosFunHelper.setCountDownListener(new bijk(this));
      this.jdField_a_of_type_Avst = new avst();
      this.jdField_a_of_type_Avst.a(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Avst.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel);
      this.jdField_a_of_type_Avst.a(new bijl(this));
      this.jdField_a_of_type_Bioz.a(this.jdField_a_of_type_Avst);
      this.jdField_a_of_type_Avsw = this.jdField_a_of_type_Biks.a();
      this.jdField_a_of_type_Avsx = new avsx(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
      this.jdField_a_of_type_Avss = new avss(this.jdField_a_of_type_AndroidViewViewStub);
      this.jdField_a_of_type_Avsv = new avsv(this.jdField_a_of_type_Bjrl.a());
      if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)) {
        break label898;
      }
    }
    label898:
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AEPituCameraUnit", 1, "onCreateView needLiuHaiTop:" + bool);
        }
        localObject = a().getIntent().getStringExtra("key_guide_image");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = aswz.a(((String)localObject).substring("data:image/png;base64,".length()));
          localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
          if (BitmapUtils.isLegal((Bitmap)localObject))
          {
            ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363316);
            localImageView.setImageBitmap((Bitmap)localObject);
            localImageView.setVisibility(0);
          }
        }
        o();
        bjah.b("AEPituCameraUnit", "[UnitAsyncInit] before await");
        try
        {
          this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await(1000L, TimeUnit.MILLISECONDS);
          bjah.b("AEPituCameraUnit", "[UnitAsyncInit] after await");
          return this.jdField_a_of_type_AndroidViewView;
          bool = false;
          break;
          label855:
          this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(false);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            bjah.d("AEPituCameraUnit", "[UnitAsyncInit] await interrupt exp: " + localInterruptedException.getMessage());
          }
        }
      }
    }
  }
  
  protected bijq a()
  {
    Intent localIntent = a().getIntent();
    int j;
    if (birt.h(localIntent)) {
      if (localIntent.getBooleanExtra("key_camera_prefer_id", false)) {
        j = 2;
      }
    }
    while (axkt.n())
    {
      return bkvg.a().a(this.jdField_a_of_type_Bjrl.a(), j);
      j = 1;
      continue;
      j = avsz.a();
    }
    return bkvg.a().b(this.jdField_a_of_type_Bjrl.a(), j);
  }
  
  public bikl a()
  {
    return this.jdField_a_of_type_Bikl;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.7(this));
    int j = AEBeautyProviderView.a();
    int k = AEBeautyProviderView.b();
    this.jdField_a_of_type_Bikl.a(j);
    this.jdField_a_of_type_Bikl.b(k);
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
    Activity localActivity = this.jdField_a_of_type_Bjrl.a();
    avtp.a(localActivity, paramInt1, paramInt2);
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
      this.jdField_a_of_type_Bikl.j();
    }
    if (paramInt2 == 0) {
      biif.a(null);
    }
    if ((paramIntent != null) && (this.jdField_a_of_type_DovComQqImAeSessionWrap != null)) {
      paramIntent.putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_DovComQqImAeSessionWrap.a());
    }
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      biig.a(this.jdField_a_of_type_Bjrl.a(), paramIntent, this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult, this.jdField_a_of_type_Bjrk, null);
      return;
    }
    this.jdField_a_of_type_Biws.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    long l = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    bizx.a().c(l);
    super.a(paramBundle);
    bfma.jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Boolean = false;
    bkrf.a().b(false);
    this.jdField_a_of_type_DovComQqImAeSessionWrap = ((SessionWrap)this.jdField_a_of_type_Bjrl.a().getIntent().getParcelableExtra("ARG_SESSION_INFO"));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bjrl.a().getIntent().getStringExtra("ARG_AIO_CLASS");
    if (paramBundle != null) {
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = ((AEVideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver.a(this.jdField_a_of_type_Bjrl.a());
    this.jdField_a_of_type_Bjaf.a();
    bizp.a();
  }
  
  public void a(avuo paramavuo)
  {
    bizx.a().b(1L);
    bizt.a().b(-1L);
    bjah.b("AEPituCameraUnit", "【Type】Photo");
    if (birt.f(a().getIntent()))
    {
      bjre localbjre = new bjrg(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.b()).a(this.jdField_a_of_type_DovComQqImAeSessionWrap).a(this.jdField_a_of_type_JavaLangString).a(1).a();
      this.jdField_a_of_type_Bjrd.a(localbjre);
      this.jdField_a_of_type_Biws.a(262148, new Object[] { paramavuo, this.jdField_a_of_type_Bjrd, this.jdField_a_of_type_Biws.a(196610, new Object[0]) });
      return;
    }
    this.jdField_a_of_type_Biws.a(262148, new Object[] { paramavuo, this.jdField_a_of_type_Biws.a(196610, new Object[0]) });
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    this.d = false;
    if (!paramBoolean)
    {
      a(101);
      return;
    }
    bjah.b("AEPituCameraUnit", "[onVideoCaptured] videoInfo = " + paramLocalMediaInfo.mDuration);
    bizx.a().b(2L);
    bizt.a().b(paramLocalMediaInfo.mDuration);
    this.jdField_a_of_type_Biws.a(196609, new Object[0]);
    this.jdField_a_of_type_Biws.a(262146, new Object[] { this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult, paramLocalMediaInfo, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Bjrd, this.jdField_a_of_type_Biws.a(196610, new Object[0]) });
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    C();
    if (this.jdField_a_of_type_Biwo != biwo.c)
    {
      if (paramVideoMaterial == null) {
        bizx.a().c("none");
      }
    }
    else
    {
      if (VideoMaterialUtil.isWatermarkMaterial(paramVideoMaterial)) {
        bipv.a().a();
      }
      if ((!VideoMaterialUtil.isWatermarkEditable(paramVideoMaterial)) || (this.jdField_a_of_type_Biwo == biwo.c)) {
        break label102;
      }
      a().runOnUiThread(new AEPituCameraUnit.20(this, paramVideoMaterial));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bipc != null) {
        this.jdField_a_of_type_Bipc.a(paramVideoMaterial);
      }
      return;
      bizx.a().c(paramVideoMaterial.getId());
      break;
      label102:
      a().runOnUiThread(new AEPituCameraUnit.21(this, paramVideoMaterial));
    }
  }
  
  public void a(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = paramAEVideoCaptureResult;
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.finishTimeMs = System.currentTimeMillis();
    if (this.jdField_a_of_type_Biwo == biwo.c)
    {
      b(paramAEVideoCaptureResult);
      return;
    }
    if (paramAEVideoCaptureResult.getVideoCaptureLength() < 500L)
    {
      this.d = false;
      A();
      return;
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.14(this));
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.p();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = paramAEVideoCaptureResult.videoMp4FilePath;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
    agmg.a(BaseApplicationImpl.getContext()).a(this, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
  }
  
  public void a(String paramString)
  {
    birb localbirb = (birb)bjav.a().c(18);
    if ((localbirb != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = localbirb.a(paramString);
      if (paramString == null) {
        Toast.makeText(a(), 2131689782, 1).show();
      }
    }
    else
    {
      return;
    }
    a().a(true, 150);
    this.jdField_a_of_type_Biws.a(327683, new Object[] { paramString });
    this.jdField_a_of_type_Biws.a(196612, new Object[0]);
  }
  
  public void a(@NonNull List<binn> paramList, @NonNull List<binm> paramList1)
  {
    this.jdField_a_of_type_Biws.a(720897, new Object[] { paramList, paramList1 });
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (this.jdField_b_of_type_AndroidWidgetButton == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.18(this));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    bjah.b("AEPituCameraUnit", "[onCameraStarted] + BEGIN, success = " + paramBoolean + ", errorMsg = " + paramString);
    if (!paramBoolean)
    {
      bjah.d("AEPituCameraUnit", "[onCameraStarted] error = " + paramString);
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.11(this));
    }
    int j = AEBeautyProviderView.a();
    int k = AEBeautyProviderView.b();
    this.jdField_a_of_type_Bikl.a(j);
    this.jdField_a_of_type_Bikl.b(k);
    this.jdField_a_of_type_Biws.a(458753, new Object[0]);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bipc != null) {
      this.jdField_a_of_type_Bipc.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bikl == null) {
      return false;
    }
    if (this.jdField_a_of_type_Bikl.a()) {
      return false;
    }
    if ((this.jdField_a_of_type_Biws.a(589824)) && (((Boolean)this.jdField_a_of_type_Biws.a(589826, new Object[0])).booleanValue()))
    {
      this.jdField_a_of_type_Biws.a(589826, new Object[0]);
      return true;
    }
    this.jdField_a_of_type_Bikl.h();
    this.jdField_a_of_type_Bikl.j();
    this.jdField_a_of_type_Bjrl.a();
    if (this.jdField_a_of_type_Biwo == biwo.c) {}
    for (;;)
    {
      return true;
      bizt.a().j();
      bjah.b("AEPituCameraUnit", "【Click】onBackPressed");
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
          bbdj.a(localActivity, null, null);
          bool1 = false;
        }
      }
    }
    if (bool1) {
      bika.a().f(paramBoolean);
    }
    return bool1;
  }
  
  public void b()
  {
    if (Build.VERSION.SDK_INT < 23) {
      break label8;
    }
    label8:
    while (!(this.jdField_a_of_type_Bjrl.a() instanceof QIMCameraCaptureActivity)) {
      return;
    }
    QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_Bjrl.a();
    int j;
    label51:
    int k;
    if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      j = 1;
      if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label176;
      }
      k = 1;
      label64:
      if (akwf.a(localQIMCameraCaptureActivity)) {
        break label181;
      }
    }
    label176:
    label181:
    for (int m = 1;; m = 0)
    {
      LinkedList localLinkedList = new LinkedList();
      if (j != 0) {
        localLinkedList.add("android.permission.CAMERA");
      }
      if (k != 0) {
        localLinkedList.add("android.permission.RECORD_AUDIO");
      }
      if (m != 0)
      {
        localLinkedList.add("android.permission.READ_EXTERNAL_STORAGE");
        localLinkedList.add("android.permission.WRITE_EXTERNAL_STORAGE");
      }
      if (localLinkedList.size() <= 0) {
        break;
      }
      localQIMCameraCaptureActivity.requestPermissions(this, 1, (String[])localLinkedList.toArray(new String[0]));
      return;
      j = 0;
      break label51;
      k = 0;
      break label64;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Bikl.a(paramInt);
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putSerializable("KEY_VIDEO_RESULT", this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
  }
  
  public void b(boolean paramBoolean)
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
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 123	bijd:jdField_b_of_type_Int	I
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
    //   0	28	0	this	bijd
    //   8	4	1	j	int
    //   1	19	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	23	finally
  }
  
  public void b_(int paramInt1, int paramInt2)
  {
    super.b_(paramInt1, paramInt2);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.6(this));
    this.jdField_a_of_type_Biws.a(paramInt1, paramInt2);
  }
  
  public void c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Bipc != null) {
      this.jdField_a_of_type_Bipc.c();
    }
    biws localbiws = this.jdField_a_of_type_Biws;
    if (this.jdField_a_of_type_Biwo == biwo.c) {}
    for (;;)
    {
      localbiws.a(196611, new Object[] { Boolean.valueOf(bool) });
      this.jdField_a_of_type_Biws.a(327685, new Object[0]);
      return;
      bool = false;
    }
  }
  
  public void c(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366418);
    if ((localView instanceof VideoFilterViewPager))
    {
      ((VideoFilterViewPager)localView).setVisibility(paramInt);
      QLog.i("AEPituCameraUnit", 2, "yes to domVideoFilterViewPager setVisibility: " + paramInt);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onPause();
    super.d();
    this.jdField_c_of_type_Boolean = false;
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avst);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avsw);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avsx);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avss);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avsv);
    this.jdField_a_of_type_Biks.b();
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.m();
    }
    this.jdField_a_of_type_Bikl.h();
    this.jdField_a_of_type_Biws.e();
    if (QLog.isDevelopLevel()) {
      bjah.a("AEPituCameraUnit", "onActivityPause, hashCode=" + this.jdField_c_of_type_Int);
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
    int m = 1;
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Bjrl.a();
    int j;
    int k;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)
    {
      j = 1;
      if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label187;
      }
      k = 1;
      label48:
      if (akwf.a((Context)localObject)) {
        break label192;
      }
    }
    for (;;)
    {
      localObject = new LinkedList();
      if (j != 0)
      {
        ((List)localObject).add("android.permission.CAMERA");
        bjah.b("AEPituCameraUnit", "【Camera Permission】denied");
      }
      if (k != 0)
      {
        ((List)localObject).add("android.permission.RECORD_AUDIO");
        bjah.b("AEPituCameraUnit", "【Audio Permission】denied");
      }
      if (m != 0)
      {
        ((List)localObject).add("android.permission.READ_EXTERNAL_STORAGE");
        ((List)localObject).add("android.permission.WRITE_EXTERNAL_STORAGE");
        bjah.b("AEPituCameraUnit", "【External Storage Permission】denied");
      }
      localObject = bbdj.a((String[])((List)localObject).toArray(new String[0]));
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.10(this, (String)localObject));
      return;
      j = 0;
      break;
      label187:
      k = 0;
      break label48;
      label192:
      m = 0;
    }
  }
  
  public void e()
  {
    super.e();
    GLGestureProxy.getInstance().removeAllListener();
    bizf.a().a();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver.b(this.jdField_a_of_type_Bjrl.a());
    this.jdField_a_of_type_Biws.h();
    if (bink.a()) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a = null;
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.f();
    bkze.jdField_a_of_type_JavaLangString = null;
    bips.a().b();
    CosFunHelper.setCountDownListener(null);
    if (this.jdField_a_of_type_Bikl != null) {
      this.jdField_a_of_type_Bikl.e();
    }
    this.jdField_a_of_type_Biks.c();
    bcuc.a(BaseApplicationImpl.getContext(), true, 5);
    amkf.a(BaseApplicationImpl.getContext(), 2, true);
    blbt.a.clear();
    this.jdField_a_of_type_Bjaf.b();
    bizx.a().l();
    if (birt.a(a()).a()) {
      bizx.a().a(false);
    }
    bizp.b();
    if ((a() != null) && (birt.h(a().getIntent()))) {
      bika.a().c(avsz.a());
    }
  }
  
  public void f()
  {
    super.f();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onResume();
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avst);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avsw);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avsx);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avss);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avsv);
    this.jdField_a_of_type_Bikl.i();
    if (this.g)
    {
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.l();
      }
      q();
      a(false);
    }
    this.jdField_a_of_type_Biws.d();
    bigy localbigy = (bigy)bjav.a(13);
    if (birt.e.a(a())) {
      localbigy.b(14);
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        bjah.a("AEPituCameraUnit", "onActivityResume, hashCode=" + this.jdField_c_of_type_Int);
      }
      b(false);
      return;
      localbigy.b(this.jdField_a_of_type_Bjrd.jdField_c_of_type_Int);
    }
  }
  
  public void g()
  {
    this.d = true;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.h();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.m();
    w();
    ((bjcb)bjav.a(5)).a(true);
    c(8);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.9(this));
    }
    bjah.b("AEPituCameraUnit", "【Camera / Audio / Storage Permission】grant");
  }
  
  public void h()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.n();
    this.d = false;
    ((bjcb)bjav.a(5)).a(false);
    c(0);
  }
  
  public void i()
  {
    this.jdField_a_of_type_Biws.a(786435, new Object[0]);
  }
  
  public void j()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.k();
    E();
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setVisibility(8);
    }
    if (!bika.a().a()) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.q();
    }
    this.jdField_a_of_type_Biws.a(196609, new Object[0]);
    this.jdField_a_of_type_Biws.a(262147, new Object[0]);
  }
  
  public void k()
  {
    w();
  }
  
  public void l()
  {
    A();
  }
  
  public void l(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraUnit", 2, "onResourceDownload isOnlineRes: " + paramBoolean);
    }
    if (!jdField_b_of_type_Boolean)
    {
      jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Bjrl.a().runOnUiThread(new AEPituCameraUnit.26(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Biws.a(paramBoolean);
      return;
      this.jdField_a_of_type_Bjrl.a().runOnUiThread(new AEPituCameraUnit.27(this));
    }
  }
  
  public void m() {}
  
  public void n()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.12(this));
    this.jdField_a_of_type_Biws.a(196609, new Object[0]);
    this.jdField_a_of_type_Biws.a(262145, new Object[0]);
  }
  
  public void notifyEnableStickerInnerEffectFilter(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      d(1);
      if (this.jdField_a_of_type_Biws != null) {
        this.jdField_a_of_type_Biws.a(196609, new Object[0]);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bjrl != null) && (this.jdField_a_of_type_Bjrl.a() != null)) {
        this.jdField_a_of_type_Bjrl.a().runOnUiThread(new AEPituCameraUnit.28(this, paramBoolean));
      }
      return;
      d(0);
    }
  }
  
  @CallSuper
  protected void o()
  {
    this.jdField_a_of_type_Biwp = ((biwp)bijo.a(this).a(biwp.class));
    this.jdField_a_of_type_Biwp.a().a(this, new bijg(this));
    this.jdField_a_of_type_Biwq = ((biwq)bijo.a(this).a(biwq.class));
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    switch (paramView.getId())
    {
    default: 
    case 2131364897: 
    case 2131364029: 
      do
      {
        do
        {
          return;
        } while (this.jdField_b_of_type_AndroidWidgetButton == null);
        bjkv.a(this.jdField_b_of_type_AndroidWidgetButton, 200L, null);
        boolean bool;
        if (!this.jdField_b_of_type_AndroidWidgetButton.isSelected())
        {
          bool = true;
          this.jdField_b_of_type_AndroidWidgetButton.setSelected(bool);
          this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.b(bool);
          if (bool) {
            break label138;
          }
          this.i = true;
          avtp.a(bool);
          if (!bool) {
            break label146;
          }
        }
        for (;;)
        {
          avtd.c(j);
          return;
          bool = false;
          break;
          this.i = false;
          break label120;
          j = 2;
        }
        if (this.jdField_a_of_type_AndroidWidgetButton != null) {
          bjkv.a(this.jdField_a_of_type_AndroidWidgetButton, 200L, null);
        }
        this.jdField_a_of_type_Bikl.a();
      } while (this.jdField_a_of_type_AndroidWidgetButton == null);
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a())
      {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getResources().getString(2131718777));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getResources().getString(2131718778));
      return;
    case 2131363851: 
    case 2131363856: 
      label120:
      bjkv.a(paramView, 200L, null);
      label138:
      label146:
      u();
      return;
    }
    a().getIntent().removeExtra("widgetinfo");
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
    this.jdField_a_of_type_Biws.f();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    bizt.a().i();
    if (QLog.isDevelopLevel()) {
      bjah.a("AEPituCameraUnit", "onActivityStart, hashCode=" + this.jdField_c_of_type_Int);
    }
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null)
    {
      if (amfv.d()) {
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
      b(true);
      bizx.a().h();
      bizt.a().C();
      if ((!this.jdField_a_of_type_Biwp.c()) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null)) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setVisibility(0);
      }
      this.jdField_a_of_type_Biwq.a().a(Boolean.valueOf(true));
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
      break;
      label110:
      if ((this.jdField_b_of_type_AndroidWidgetButton != null) && (this.i))
      {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setSelected(false);
      }
    }
  }
  
  public void r()
  {
    this.jdField_a_of_type_Bikl.b();
  }
  
  public void s()
  {
    super.s();
  }
  
  public void t()
  {
    super.t();
    this.jdField_a_of_type_Biws.g();
    bizt.a().a(this.jdField_a_of_type_Long);
    if (QLog.isDevelopLevel()) {
      bjah.a("AEPituCameraUnit", "onActivityStop, hashCode=" + this.jdField_c_of_type_Int);
    }
  }
  
  public void u()
  {
    this.jdField_a_of_type_Bjrl.a().onBackPressed();
  }
  
  public void v()
  {
    a().getIntent().removeExtra("widgetinfo");
    bjai.a(a());
  }
  
  public void w()
  {
    if (this.jdField_a_of_type_Bipc != null) {
      this.jdField_a_of_type_Bipc.b();
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    this.jdField_a_of_type_Biwq.a().a(Boolean.valueOf(false));
  }
  
  public void x()
  {
    this.jdField_a_of_type_Biws.a(720898, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bijd
 * JD-Core Version:    0.7.0.1
 */