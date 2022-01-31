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
public class biim
  extends bigf
  implements agmj, View.OnClickListener, View.OnTouchListener, avtg, bijd, bije, bijf, bijg, bink, bjku, bkqr, bkqt, bkuy, bkve, AEFilterManager.StickerInnerEffectFilterListener
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
  private avsq jdField_a_of_type_Avsq;
  private avsr jdField_a_of_type_Avsr;
  private avst jdField_a_of_type_Avst;
  private avsu jdField_a_of_type_Avsu;
  private avsv jdField_a_of_type_Avsv;
  private biiw jdField_a_of_type_Biiw;
  private biju jdField_a_of_type_Biju;
  private bikb jdField_a_of_type_Bikb;
  private biob jdField_a_of_type_Biob = new biir(this);
  private bioi jdField_a_of_type_Bioi;
  private biol jdField_a_of_type_Biol;
  private bivx jdField_a_of_type_Bivx = bivx.jdField_a_of_type_Bivx;
  private bivy jdField_a_of_type_Bivy;
  private bivz jdField_a_of_type_Bivz;
  private biwb jdField_a_of_type_Biwb;
  private bizo jdField_a_of_type_Bizo = new bizo();
  private bizs jdField_a_of_type_Bizs;
  private bjqm jdField_a_of_type_Bjqm = new bjqm(10000, 100, 2);
  private bjqt jdField_a_of_type_Bjqt;
  private bjqu jdField_a_of_type_Bjqu;
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
  
  public biim()
  {
    bizq.b("AEPituCameraUnit", "[AEPituCameraUnit] + BEGIN");
    this.jdField_c_of_type_Int = 0;
    bizq.a("AEPituCameraUnit", "unitConstructor--fake");
    bizq.b("AEPituCameraUnit", "[AEPituCameraUnit] + END");
  }
  
  public biim(bjqu parambjqu, bjqt parambjqt)
  {
    bizq.b("AEPituCameraUnit", "[AEPituCameraUnit] + BEGIN");
    long l = System.currentTimeMillis();
    biwd.a().a("unitConstructor-begin");
    this.jdField_a_of_type_Bjqu = parambjqu;
    this.jdField_a_of_type_Bjqt = parambjqt;
    this.jdField_a_of_type_Int = 11;
    bctn.a(BaseApplicationImpl.getContext(), false, 5);
    amkg.a(BaseApplicationImpl.getContext(), 2, false);
    if (!birc.e.a(a()))
    {
      this.jdField_a_of_type_Int = 11;
      this.jdField_a_of_type_Bjqm = new bjqm(10023, a().getIntent().getIntExtra("entrance_type", 120), 14);
    }
    for (;;)
    {
      bizq.b("AEPituCameraUnit", "[AEPituCameraUnit] submit unit init");
      ThreadManager.excute(new AEPituCameraUnit.1(this), 16, null, true);
      biwd.a().a("begin identity");
      this.jdField_c_of_type_Int = System.identityHashCode(this);
      biwd.a().a("end identity");
      bizq.b("AEPituCameraUnit", "[AEPituCameraUnit] + END, time cost = " + (System.currentTimeMillis() - l));
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
    int j = this.jdField_a_of_type_Bjqu.a().getIntent().getIntExtra("edit_video_type", 10002);
    PeakAppInterface.a.a(bjbb.jdField_a_of_type_JavaLangString, new Object[] { this, Integer.valueOf(j) });
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
    this.jdField_a_of_type_Biju.f();
    bkur.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, bbkx.a(1.0F));
  }
  
  private void E()
  {
    this.jdField_a_of_type_Bivz.a().a(Boolean.valueOf(false));
  }
  
  private int a()
  {
    if (a().getIntent() != null) {
      return a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", birc.a.a());
    }
    return birc.a.a();
  }
  
  private long a()
  {
    long l1 = 9223372036854775807L;
    try
    {
      long l2 = bbbd.b();
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
  
  private void a(@Nullable bivx parambivx)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_Bivx = parambivx;
    boolean bool1;
    if (this.jdField_a_of_type_Bivx == bivx.c)
    {
      bool1 = true;
      if (this.jdField_a_of_type_Bivx != bivx.jdField_a_of_type_Bivx) {
        break label154;
      }
      label29:
      bizg.a().b(bool1);
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setIsGIFMode(bool1);
      }
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.22(this));
      this.jdField_a_of_type_Bikb.b(bool2);
      if (this.jdField_a_of_type_Bivx != bivx.b) {
        break label159;
      }
      if (this.jdField_a_of_type_Biol != null) {
        this.jdField_a_of_type_Biol.a();
      }
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avsr);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avsu);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avsv);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avsq);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avst);
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
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Avsr)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avsr);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Avsu)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avsu);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Avsv)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avsv);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Avsq)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avsq);
      }
    } while (GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Avst));
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avst);
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
      bizq.b("AEPituCameraUnit", "【GIF Capture】during time:" + (paramAEVideoCaptureResult.finishTimeMs - paramAEVideoCaptureResult.startTimeMs) + "ms");
      bizg.a().b(5L);
      bizc.a().F();
      long l = a();
      if (l > 0L)
      {
        paramAEVideoCaptureResult = new Intent(a(), AEStoryGIFPreviewActivity.class);
        paramAEVideoCaptureResult.putExtra("KEY_PREVIEW_SOURCE_PATH", this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath);
        paramAEVideoCaptureResult.putExtra("KEY_AVAILABLE_EMO_COUNT", l);
        Object localObject = (biry)biix.a(this).a(biry.class);
        if (((biry)localObject).c().a() != null) {}
        for (boolean bool = true;; bool = false)
        {
          paramAEVideoCaptureResult.putExtra("KEY_MATERIAL_APPLIED", bool);
          paramAEVideoCaptureResult.putExtra("KEY_AVAILABLE_SAVENAME", (String)((biry)localObject).d().a());
          paramAEVideoCaptureResult.putExtra("ARG_SESSION_INFO", this.jdField_a_of_type_DovComQqImAeSessionWrap);
          paramAEVideoCaptureResult.putExtra("ARG_GIF_SEND_TO_AIO", birc.f(a().getIntent()));
          localObject = a();
          if (localObject == null) {
            break;
          }
          Intent localIntent = ((Activity)localObject).getIntent();
          if (localIntent != null)
          {
            int j = localIntent.getIntExtra("AECAMERA_MODE", 200);
            int k = localIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", birc.a.a());
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
        bizq.b("AEPituCameraUnit", "【Dark Mode】Start");
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
    int j = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", birc.a.a());
    String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
    if (birc.a(j).a()) {
      bizg.a().a(j, str);
    }
    str = a().getIntent().getStringExtra("intent_key_uid_for_report");
    bizg.a().a(str);
    bizg.a().a(true);
    bizg.a().b();
    bizg.a().a();
    bizg.a().b(biqd.a(a()));
    bizc.a().D();
    if (birc.e.a(j)) {
      vel.a("check_Android", birc.e.a(), 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
    }
  }
  
  private void z()
  {
    String str = a().getIntent().getStringExtra("KEY_CURRENT_TAB");
    int j = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", -1);
    int k = a().getIntent().getIntExtra("AECAMERA_MODE", 200);
    if (!TextUtils.isEmpty(str)) {
      bihs.jdField_a_of_type_JavaLangString = str;
    }
    for (;;)
    {
      bihs.b = bizj.a().a("app_ui_playshow_ad_id", "", 4);
      AEPituCameraCaptureButtonLayout.i();
      return;
      if ((birc.c.a() == j) && (k == 201)) {
        bihs.jdField_a_of_type_JavaLangString = bizj.a().a("app_alg_entrance_id", "", 4);
      } else if ((birc.d(j)) && (k == 204)) {
        bihs.jdField_a_of_type_JavaLangString = bizj.a().a("app_alg_entrance_qzone_id", "", 4);
      } else {
        bihs.jdField_a_of_type_JavaLangString = String.valueOf(bivx.jdField_a_of_type_Bivx.jdField_a_of_type_Int);
      }
    }
  }
  
  public void U() {}
  
  public void W() {}
  
  public Activity a()
  {
    if (this.jdField_a_of_type_Bjqu == null) {
      return null;
    }
    return this.jdField_a_of_type_Bjqu.a();
  }
  
  public View a()
  {
    biwd.a().a("unitInflateView-begin");
    Object localObject = this.jdField_a_of_type_Bjqu.a().getLayoutInflater().inflate(2131558498, null, false);
    biwd.a().a("unitInflateView-end");
    this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131366493);
    this.jdField_a_of_type_Biiw = ((biiw)biix.a(this).a(biiw.class));
    ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376589)).inflate();
    ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376591)).inflate();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363297));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363295));
    bkur.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, bbkx.a(1.0F));
    this.jdField_a_of_type_Biju = new biju(this.jdField_a_of_type_AndroidViewView, this);
    this.jdField_a_of_type_Bikb = new bikb((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376595));
    this.jdField_a_of_type_Biiw.b.a(this.jdField_a_of_type_Bikb);
    localObject = this.jdField_a_of_type_Bikb;
    if (this.jdField_a_of_type_Bivx == bivx.jdField_a_of_type_Bivx)
    {
      bool = true;
      ((bikb)localObject).a(this, bool);
      this.jdField_a_of_type_Biwb = new biwb(this.jdField_a_of_type_Bjqu.a(), this.jdField_a_of_type_AndroidViewView, this);
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_Bjqu.a(), new biiv(this, null), null, true);
      this.jdField_a_of_type_Biol = new biol(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Biwb);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363833));
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAEKitInitListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setLaunchStateCallback(new biiq(this));
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDarkModeEnable(true);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDarkModeListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setFaceEffectListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCameraListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAECaptureController(this.jdField_a_of_type_Biju);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setStickerInnerLutFilterListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setRecommendTextCallback(new biis(this));
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a(a());
      if (!axkr.n()) {
        break label855;
      }
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(true);
      if (bimt.a()) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a = this;
      }
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376590));
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131372075));
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setMaterialPanelListener(this.jdField_a_of_type_Biob);
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(8);
      }
      this.jdField_a_of_type_Bioi = new bioi((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376587));
      this.jdField_a_of_type_Biiw.a.b(this.jdField_a_of_type_Bioi);
      CosFunHelper.setCountDownListener(new biit(this));
      this.jdField_a_of_type_Avsr = new avsr();
      this.jdField_a_of_type_Avsr.a(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Avsr.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel);
      this.jdField_a_of_type_Avsr.a(new biiu(this));
      this.jdField_a_of_type_Bioi.a(this.jdField_a_of_type_Avsr);
      this.jdField_a_of_type_Avsu = this.jdField_a_of_type_Bikb.a();
      this.jdField_a_of_type_Avsv = new avsv(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
      this.jdField_a_of_type_Avsq = new avsq(this.jdField_a_of_type_AndroidViewViewStub);
      this.jdField_a_of_type_Avst = new avst(this.jdField_a_of_type_Bjqu.a());
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
          localObject = aswx.a(((String)localObject).substring("data:image/png;base64,".length()));
          localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
          if (BitmapUtils.isLegal((Bitmap)localObject))
          {
            ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363317);
            localImageView.setImageBitmap((Bitmap)localObject);
            localImageView.setVisibility(0);
          }
        }
        o();
        bizq.b("AEPituCameraUnit", "[UnitAsyncInit] before await");
        try
        {
          this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await(1000L, TimeUnit.MILLISECONDS);
          bizq.b("AEPituCameraUnit", "[UnitAsyncInit] after await");
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
            bizq.d("AEPituCameraUnit", "[UnitAsyncInit] await interrupt exp: " + localInterruptedException.getMessage());
          }
        }
      }
    }
  }
  
  protected biiz a()
  {
    Intent localIntent = a().getIntent();
    int j;
    if (birc.h(localIntent)) {
      if (localIntent.getBooleanExtra("key_camera_prefer_id", false)) {
        j = 2;
      }
    }
    while (axkr.n())
    {
      return bkup.a().a(this.jdField_a_of_type_Bjqu.a(), j);
      j = 1;
      continue;
      j = avsx.a();
    }
    return bkup.a().b(this.jdField_a_of_type_Bjqu.a(), j);
  }
  
  public biju a()
  {
    return this.jdField_a_of_type_Biju;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.7(this));
    int j = AEBeautyProviderView.a();
    int k = AEBeautyProviderView.b();
    this.jdField_a_of_type_Biju.a(j);
    this.jdField_a_of_type_Biju.b(k);
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
    Activity localActivity = this.jdField_a_of_type_Bjqu.a();
    avtn.a(localActivity, paramInt1, paramInt2);
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
      this.jdField_a_of_type_Biju.j();
    }
    if (paramInt2 == 0) {
      biho.a(null);
    }
    if ((paramIntent != null) && (this.jdField_a_of_type_DovComQqImAeSessionWrap != null)) {
      paramIntent.putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_DovComQqImAeSessionWrap.a());
    }
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      bihp.a(this.jdField_a_of_type_Bjqu.a(), paramIntent, this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult, this.jdField_a_of_type_Bjqt, null);
      return;
    }
    this.jdField_a_of_type_Biwb.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    long l = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    bizg.a().c(l);
    super.a(paramBundle);
    bflj.jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Boolean = false;
    bkqo.a().b(false);
    this.jdField_a_of_type_DovComQqImAeSessionWrap = ((SessionWrap)this.jdField_a_of_type_Bjqu.a().getIntent().getParcelableExtra("ARG_SESSION_INFO"));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bjqu.a().getIntent().getStringExtra("ARG_AIO_CLASS");
    if (paramBundle != null) {
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = ((AEVideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver.a(this.jdField_a_of_type_Bjqu.a());
    this.jdField_a_of_type_Bizo.a();
    biyy.a();
  }
  
  public void a(avum paramavum)
  {
    bizg.a().b(1L);
    bizc.a().b(-1L);
    bizq.b("AEPituCameraUnit", "【Type】Photo");
    if (birc.f(a().getIntent()))
    {
      bjqn localbjqn = new bjqp(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.b()).a(this.jdField_a_of_type_DovComQqImAeSessionWrap).a(this.jdField_a_of_type_JavaLangString).a(1).a();
      this.jdField_a_of_type_Bjqm.a(localbjqn);
      this.jdField_a_of_type_Biwb.a(262148, new Object[] { paramavum, this.jdField_a_of_type_Bjqm, this.jdField_a_of_type_Biwb.a(196610, new Object[0]) });
      return;
    }
    this.jdField_a_of_type_Biwb.a(262148, new Object[] { paramavum, this.jdField_a_of_type_Biwb.a(196610, new Object[0]) });
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    this.d = false;
    if (!paramBoolean)
    {
      a(101);
      return;
    }
    bizq.b("AEPituCameraUnit", "[onVideoCaptured] videoInfo = " + paramLocalMediaInfo.mDuration);
    bizg.a().b(2L);
    bizc.a().b(paramLocalMediaInfo.mDuration);
    this.jdField_a_of_type_Biwb.a(196609, new Object[0]);
    this.jdField_a_of_type_Biwb.a(262146, new Object[] { this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult, paramLocalMediaInfo, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Bjqm, this.jdField_a_of_type_Biwb.a(196610, new Object[0]) });
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    C();
    if (this.jdField_a_of_type_Bivx != bivx.c)
    {
      if (paramVideoMaterial == null) {
        bizg.a().c("none");
      }
    }
    else
    {
      if (VideoMaterialUtil.isWatermarkMaterial(paramVideoMaterial)) {
        bipe.a().a();
      }
      if ((!VideoMaterialUtil.isWatermarkEditable(paramVideoMaterial)) || (this.jdField_a_of_type_Bivx == bivx.c)) {
        break label102;
      }
      a().runOnUiThread(new AEPituCameraUnit.20(this, paramVideoMaterial));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Biol != null) {
        this.jdField_a_of_type_Biol.a(paramVideoMaterial);
      }
      return;
      bizg.a().c(paramVideoMaterial.getId());
      break;
      label102:
      a().runOnUiThread(new AEPituCameraUnit.21(this, paramVideoMaterial));
    }
  }
  
  public void a(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = paramAEVideoCaptureResult;
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.finishTimeMs = System.currentTimeMillis();
    if (this.jdField_a_of_type_Bivx == bivx.c)
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
    agmi.a(BaseApplicationImpl.getContext()).a(this, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
  }
  
  public void a(String paramString)
  {
    biqk localbiqk = (biqk)bjae.a().c(18);
    if ((localbiqk != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = localbiqk.a(paramString);
      if (paramString == null) {
        Toast.makeText(a(), 2131689782, 1).show();
      }
    }
    else
    {
      return;
    }
    a().a(true, 150);
    this.jdField_a_of_type_Biwb.a(327683, new Object[] { paramString });
    this.jdField_a_of_type_Biwb.a(196612, new Object[0]);
  }
  
  public void a(@NonNull List<bimw> paramList, @NonNull List<bimv> paramList1)
  {
    this.jdField_a_of_type_Biwb.a(720897, new Object[] { paramList, paramList1 });
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
    bizq.b("AEPituCameraUnit", "[onCameraStarted] + BEGIN, success = " + paramBoolean + ", errorMsg = " + paramString);
    if (!paramBoolean)
    {
      bizq.d("AEPituCameraUnit", "[onCameraStarted] error = " + paramString);
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.11(this));
    }
    int j = AEBeautyProviderView.a();
    int k = AEBeautyProviderView.b();
    this.jdField_a_of_type_Biju.a(j);
    this.jdField_a_of_type_Biju.b(k);
    this.jdField_a_of_type_Biwb.a(458753, new Object[0]);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Biol != null) {
      this.jdField_a_of_type_Biol.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Biju == null) {
      return false;
    }
    if (this.jdField_a_of_type_Biju.a()) {
      return false;
    }
    if ((this.jdField_a_of_type_Biwb.a(589824)) && (((Boolean)this.jdField_a_of_type_Biwb.a(589826, new Object[0])).booleanValue()))
    {
      this.jdField_a_of_type_Biwb.a(589826, new Object[0]);
      return true;
    }
    this.jdField_a_of_type_Biju.h();
    this.jdField_a_of_type_Biju.j();
    this.jdField_a_of_type_Bjqu.a();
    if (this.jdField_a_of_type_Bivx == bivx.c) {}
    for (;;)
    {
      return true;
      bizc.a().j();
      bizq.b("AEPituCameraUnit", "【Click】onBackPressed");
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
          bbcv.a(localActivity, null, null);
          bool1 = false;
        }
      }
    }
    if (bool1) {
      bijj.a().f(paramBoolean);
    }
    return bool1;
  }
  
  public void b()
  {
    if (Build.VERSION.SDK_INT < 23) {
      break label8;
    }
    label8:
    while (!(this.jdField_a_of_type_Bjqu.a() instanceof QIMCameraCaptureActivity)) {
      return;
    }
    QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_Bjqu.a();
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
      if (akwg.a(localQIMCameraCaptureActivity)) {
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
    this.jdField_a_of_type_Biju.a(paramInt);
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
    //   5: getfield 123	biim:jdField_b_of_type_Int	I
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
    //   0	28	0	this	biim
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
    this.jdField_a_of_type_Biwb.a(paramInt1, paramInt2);
  }
  
  public void c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Biol != null) {
      this.jdField_a_of_type_Biol.c();
    }
    biwb localbiwb = this.jdField_a_of_type_Biwb;
    if (this.jdField_a_of_type_Bivx == bivx.c) {}
    for (;;)
    {
      localbiwb.a(196611, new Object[] { Boolean.valueOf(bool) });
      this.jdField_a_of_type_Biwb.a(327685, new Object[0]);
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
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avsr);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avsu);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avsv);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avsq);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avst);
    this.jdField_a_of_type_Bikb.b();
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.m();
    }
    this.jdField_a_of_type_Biju.h();
    this.jdField_a_of_type_Biwb.e();
    if (QLog.isDevelopLevel()) {
      bizq.a("AEPituCameraUnit", "onActivityPause, hashCode=" + this.jdField_c_of_type_Int);
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
    Object localObject = this.jdField_a_of_type_Bjqu.a();
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
      if (akwg.a((Context)localObject)) {
        break label192;
      }
    }
    for (;;)
    {
      localObject = new LinkedList();
      if (j != 0)
      {
        ((List)localObject).add("android.permission.CAMERA");
        bizq.b("AEPituCameraUnit", "【Camera Permission】denied");
      }
      if (k != 0)
      {
        ((List)localObject).add("android.permission.RECORD_AUDIO");
        bizq.b("AEPituCameraUnit", "【Audio Permission】denied");
      }
      if (m != 0)
      {
        ((List)localObject).add("android.permission.READ_EXTERNAL_STORAGE");
        ((List)localObject).add("android.permission.WRITE_EXTERNAL_STORAGE");
        bizq.b("AEPituCameraUnit", "【External Storage Permission】denied");
      }
      localObject = bbcv.a((String[])((List)localObject).toArray(new String[0]));
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
    biyo.a().a();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver.b(this.jdField_a_of_type_Bjqu.a());
    this.jdField_a_of_type_Biwb.h();
    if (bimt.a()) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a = null;
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.f();
    bkyn.jdField_a_of_type_JavaLangString = null;
    bipb.a().b();
    CosFunHelper.setCountDownListener(null);
    if (this.jdField_a_of_type_Biju != null) {
      this.jdField_a_of_type_Biju.e();
    }
    this.jdField_a_of_type_Bikb.c();
    bctn.a(BaseApplicationImpl.getContext(), true, 5);
    amkg.a(BaseApplicationImpl.getContext(), 2, true);
    blbc.a.clear();
    this.jdField_a_of_type_Bizo.b();
    bizg.a().l();
    if (birc.a(a()).a()) {
      bizg.a().a(false);
    }
    biyy.b();
    if ((a() != null) && (birc.h(a().getIntent()))) {
      bijj.a().c(avsx.a());
    }
  }
  
  public void f()
  {
    super.f();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onResume();
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avsr);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avsu);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avsv);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avsq);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avst);
    this.jdField_a_of_type_Biju.i();
    if (this.g)
    {
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.l();
      }
      q();
      a(false);
    }
    this.jdField_a_of_type_Biwb.d();
    bigh localbigh = (bigh)bjae.a(13);
    if (birc.e.a(a())) {
      localbigh.b(14);
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        bizq.a("AEPituCameraUnit", "onActivityResume, hashCode=" + this.jdField_c_of_type_Int);
      }
      b(false);
      return;
      localbigh.b(this.jdField_a_of_type_Bjqm.jdField_c_of_type_Int);
    }
  }
  
  public void g()
  {
    this.d = true;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.h();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.m();
    w();
    ((bjbk)bjae.a(5)).a(true);
    c(8);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.9(this));
    }
    bizq.b("AEPituCameraUnit", "【Camera / Audio / Storage Permission】grant");
  }
  
  public void h()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.n();
    this.d = false;
    ((bjbk)bjae.a(5)).a(false);
    c(0);
  }
  
  public void i()
  {
    this.jdField_a_of_type_Biwb.a(786435, new Object[0]);
  }
  
  public void j()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.k();
    E();
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setVisibility(8);
    }
    if (!bijj.a().a()) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.q();
    }
    this.jdField_a_of_type_Biwb.a(196609, new Object[0]);
    this.jdField_a_of_type_Biwb.a(262147, new Object[0]);
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
      this.jdField_a_of_type_Bjqu.a().runOnUiThread(new AEPituCameraUnit.26(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Biwb.a(paramBoolean);
      return;
      this.jdField_a_of_type_Bjqu.a().runOnUiThread(new AEPituCameraUnit.27(this));
    }
  }
  
  public void m() {}
  
  public void n()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.12(this));
    this.jdField_a_of_type_Biwb.a(196609, new Object[0]);
    this.jdField_a_of_type_Biwb.a(262145, new Object[0]);
  }
  
  public void notifyEnableStickerInnerEffectFilter(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      d(1);
      if (this.jdField_a_of_type_Biwb != null) {
        this.jdField_a_of_type_Biwb.a(196609, new Object[0]);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bjqu != null) && (this.jdField_a_of_type_Bjqu.a() != null)) {
        this.jdField_a_of_type_Bjqu.a().runOnUiThread(new AEPituCameraUnit.28(this, paramBoolean));
      }
      return;
      d(0);
    }
  }
  
  @CallSuper
  protected void o()
  {
    this.jdField_a_of_type_Bivy = ((bivy)biix.a(this).a(bivy.class));
    this.jdField_a_of_type_Bivy.a().a(this, new biip(this));
    this.jdField_a_of_type_Bivz = ((bivz)biix.a(this).a(bivz.class));
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    switch (paramView.getId())
    {
    default: 
    case 2131364898: 
    case 2131364030: 
      do
      {
        do
        {
          return;
        } while (this.jdField_b_of_type_AndroidWidgetButton == null);
        bjke.a(this.jdField_b_of_type_AndroidWidgetButton, 200L, null);
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
          avtn.a(bool);
          if (!bool) {
            break label146;
          }
        }
        for (;;)
        {
          avtb.c(j);
          return;
          bool = false;
          break;
          this.i = false;
          break label120;
          j = 2;
        }
        if (this.jdField_a_of_type_AndroidWidgetButton != null) {
          bjke.a(this.jdField_a_of_type_AndroidWidgetButton, 200L, null);
        }
        this.jdField_a_of_type_Biju.a();
      } while (this.jdField_a_of_type_AndroidWidgetButton == null);
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a())
      {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getResources().getString(2131718766));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getResources().getString(2131718767));
      return;
    case 2131363852: 
    case 2131363857: 
      label120:
      bjke.a(paramView, 200L, null);
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
    this.jdField_a_of_type_Biwb.f();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    bizc.a().i();
    if (QLog.isDevelopLevel()) {
      bizq.a("AEPituCameraUnit", "onActivityStart, hashCode=" + this.jdField_c_of_type_Int);
    }
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null)
    {
      if (amfw.d()) {
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
      bizg.a().h();
      bizc.a().C();
      if ((!this.jdField_a_of_type_Bivy.c()) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null)) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setVisibility(0);
      }
      this.jdField_a_of_type_Bivz.a().a(Boolean.valueOf(true));
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
    this.jdField_a_of_type_Biju.b();
  }
  
  public void s()
  {
    super.s();
  }
  
  public void t()
  {
    super.t();
    this.jdField_a_of_type_Biwb.g();
    bizc.a().a(this.jdField_a_of_type_Long);
    if (QLog.isDevelopLevel()) {
      bizq.a("AEPituCameraUnit", "onActivityStop, hashCode=" + this.jdField_c_of_type_Int);
    }
  }
  
  public void u()
  {
    this.jdField_a_of_type_Bjqu.a().onBackPressed();
  }
  
  public void v()
  {
    a().getIntent().removeExtra("widgetinfo");
    bizr.a(a());
  }
  
  public void w()
  {
    if (this.jdField_a_of_type_Biol != null) {
      this.jdField_a_of_type_Biol.b();
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    this.jdField_a_of_type_Bivz.a().a(Boolean.valueOf(false));
  }
  
  public void x()
  {
    this.jdField_a_of_type_Biwb.a(720898, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biim
 * JD-Core Version:    0.7.0.1
 */