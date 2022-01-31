import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aekit.api.standard.filter.AEFilterManager.StickerInnerEffectFilterListener;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.CosFunHelper;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;
import dov.com.qq.im.AECamera.View.AEBeautyProviderView;
import dov.com.qq.im.AECamera.View.AECameraGLSurfaceView;
import dov.com.qq.im.AECamera.panel.material.AEMaterialPanel;
import dov.com.qq.im.AECamera.record.AEVideoCaptureResult;
import dov.com.qq.im.AECameraBroadcastReceiver;
import dov.com.qq.im.AEPituCameraUnit.14;
import dov.com.qq.im.AEPituCameraUnit.16;
import dov.com.qq.im.AEPituCameraUnit.17;
import dov.com.qq.im.AEPituCameraUnit.18;
import dov.com.qq.im.AEPituCameraUnit.19;
import dov.com.qq.im.AEPituCameraUnit.2;
import dov.com.qq.im.AEPituCameraUnit.20;
import dov.com.qq.im.AEPituCameraUnit.21;
import dov.com.qq.im.AEPituCameraUnit.22;
import dov.com.qq.im.AEPituCameraUnit.23;
import dov.com.qq.im.AEPituCameraUnit.24;
import dov.com.qq.im.AEPituCameraUnit.25;
import dov.com.qq.im.AEPituCameraUnit.26;
import dov.com.qq.im.AEPituCameraUnit.27;
import dov.com.qq.im.AEPituCameraUnit.28;
import dov.com.qq.im.AEPituCameraUnit.3;
import dov.com.qq.im.AEPituCameraUnit.4;
import dov.com.qq.im.AEPituCameraUnit.5;
import dov.com.qq.im.AEPituCameraUnit.6;
import dov.com.qq.im.AEPituCameraUnit.7;
import dov.com.qq.im.AEPituCameraUnit.8;
import dov.com.qq.im.AEPituCameraUnit.9;
import dov.com.qq.im.AEStoryGIFPreviewActivity;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.story.SessionWrap;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;
import java.util.HashMap;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

@TargetApi(9)
public class bhcw
  extends bhdp
  implements agal, View.OnClickListener, View.OnTouchListener, autx, bgyn, bgyo, bgyp, bgyq, bhqc, bjaf, bjah, bjen, bjet, AEFilterManager.StickerInnerEffectFilterListener, wqo, wsu
{
  private static final String jdField_a_of_type_JavaLangString = bhcw.class.getSimpleName();
  public static boolean a;
  public static boolean b;
  private int jdField_a_of_type_Int = 11;
  private long jdField_a_of_type_Long = -1L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new AECameraBroadcastReceiver(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private auth jdField_a_of_type_Auth;
  private auti jdField_a_of_type_Auti;
  private autk jdField_a_of_type_Autk;
  private autl jdField_a_of_type_Autl;
  private autm jdField_a_of_type_Autm;
  private bafb jdField_a_of_type_Bafb;
  private bgxg jdField_a_of_type_Bgxg = new bgxg();
  private bgxh jdField_a_of_type_Bgxh;
  private bgyc jdField_a_of_type_Bgyc;
  private bhaf jdField_a_of_type_Bhaf = new bhdb(this);
  private bhdg jdField_a_of_type_Bhdg;
  private bhyu jdField_a_of_type_Bhyu = new bhyu(10000, 100, 2);
  private bhzb jdField_a_of_type_Bhzb;
  private bhzc jdField_a_of_type_Bhzc;
  private CameraFocusView jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView;
  private AEMaterialPanel jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel;
  private AEVideoCaptureResult jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult;
  private SessionWrap jdField_a_of_type_DovComQqImStorySessionWrap;
  private AEPituCameraCaptureButtonLayout jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private wsh jdField_a_of_type_Wsh = wsh.jdField_a_of_type_Wsh;
  private wsi jdField_a_of_type_Wsi;
  private wsz jdField_a_of_type_Wsz;
  private wus jdField_a_of_type_Wus;
  private wvz jdField_a_of_type_Wvz;
  private wwj jdField_a_of_type_Wwj;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private AEPituCameraCaptureButtonLayout jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private String jdField_b_of_type_JavaLangString;
  private long jdField_c_of_type_Long = 3L;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public bhcw(bhzc parambhzc, bhzb parambhzb)
  {
    this.jdField_a_of_type_Bhzc = parambhzc;
    this.jdField_a_of_type_Bhzb = parambhzb;
    this.jdField_a_of_type_Int = 11;
    bbqo.a(BaseApplicationImpl.getContext(), false, 5);
    aluq.a(BaseApplicationImpl.getContext(), 2, false);
    if (!bgww.d.a(a()))
    {
      this.jdField_a_of_type_Int = 11;
      this.jdField_a_of_type_Bhyu = new bhyu(10023, a().getIntent().getIntExtra("entrance_type", 120), 14);
    }
    for (;;)
    {
      D();
      E();
      bhaj.a();
      return;
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  private void D()
  {
    int i = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bgww.a.a());
    String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
    if ((i != bgww.v.a()) && (i != bgww.w.a())) {
      bhcm.a().a(i, str);
    }
    bhcm.a().a(bhfc.a());
    bhcm.a().a(true);
    bhcm.a().b();
    bhcm.a().a();
    bhcm.a().a(avzk.a(a()));
    bhci.a().B();
    if (bgww.d.a(i)) {
      urp.a("check_Android", bgww.d.a(), 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
    }
  }
  
  private void E()
  {
    String str = a().getIntent().getStringExtra("KEY_CURRENT_TAB");
    int i = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", -1);
    int j = a().getIntent().getIntExtra("AECAMERA_MODE", 200);
    if ((bgww.b.a() == i) && (j == 201)) {
      avzg.e = bgxb.a().a("app_alg_entrance_id", "", 4);
    }
    for (;;)
    {
      avzg.f = bgxb.a().a("app_ui_playshow_ad_id", "", 4);
      return;
      if (!TextUtils.isEmpty(str)) {
        avzg.e = str;
      } else {
        avzg.e = String.valueOf(wsh.jdField_a_of_type_Wsh.jdField_a_of_type_Int);
      }
    }
  }
  
  private void F()
  {
    this.jdField_a_of_type_Bgxh.c();
  }
  
  private void G()
  {
    int i = AEBeautyProviderView.a();
    int j = AEBeautyProviderView.b();
    this.jdField_a_of_type_Bgxh.a(i);
    this.jdField_a_of_type_Bgxh.b(j);
  }
  
  private void H()
  {
    bhcm localbhcm = bhcm.a();
    localbhcm.e(AEBeautyProviderView.a());
    localbhcm.f(AEBeautyProviderView.b());
    localbhcm.g(this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.b());
    bhci.a().D();
  }
  
  private void I()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.7(this));
  }
  
  private void J()
  {
    if (GLVideoClipUtil.b()) {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    }
    while ((this.jdField_b_of_type_AndroidWidgetButton == null) || (!this.g)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton.setSelected(false);
  }
  
  private void K()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.21(this));
  }
  
  private void L()
  {
    this.jdField_a_of_type_Bgxh.e();
    this.jdField_c_of_type_Boolean = bjeh.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout, bajq.a(1.0F));
  }
  
  private void M()
  {
    this.jdField_a_of_type_Wsz.a().a(Boolean.valueOf(false));
  }
  
  private int a()
  {
    if (a().getIntent() != null) {
      return a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bgww.a.a());
    }
    return bgww.a.a();
  }
  
  private long a()
  {
    long l1 = 9223372036854775807L;
    try
    {
      long l2 = azzz.b();
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
    QLog.d(jdField_a_of_type_JavaLangString, 4, "available size = " + l1 + "M");
    return l1 / 30L;
  }
  
  private void a(LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable)
  {
    K();
    if (paramLazyLoadAnimationDrawable == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable = new AEPituCameraUnit.19(this);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.20(this, paramLazyLoadAnimationDrawable));
  }
  
  private void a(AEVideoCaptureResult paramAEVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    bhcm.a().b(2L);
    bhci.a().b(paramLocalMediaInfo.mDuration);
    bhcs.a(jdField_a_of_type_JavaLangString, 1, "【Type】Video:" + paramLocalMediaInfo.mDuration);
    this.jdField_a_of_type_Wus.a(196609, new Object[0]);
    this.jdField_a_of_type_Wus.a(262146, new Object[] { paramAEVideoCaptureResult, paramLocalMediaInfo, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Bhyu, this.jdField_a_of_type_Wus.a(196610, new Object[0]) });
  }
  
  private void b(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    boolean bool = true;
    if (!this.d) {}
    do
    {
      return;
      if (paramAEVideoCaptureResult.videoFrameCount < 5)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onVideoCaptured. videoFrameCount = " + this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult.videoFrameCount + " ; minFrameCount = " + this.jdField_c_of_type_Long);
        }
        I();
        return;
      }
      bhcs.a(jdField_a_of_type_JavaLangString, 1, "【GIF Capture】during time:" + (paramAEVideoCaptureResult.finishTimeMs - paramAEVideoCaptureResult.startTimeMs) + "ms");
      H();
      long l = a();
      if (l > 0L)
      {
        paramAEVideoCaptureResult = new Intent(a(), AEStoryGIFPreviewActivity.class);
        paramAEVideoCaptureResult.putExtra("KEY_PREVIEW_SOURCE_PATH", this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult.videoMp4FilePath);
        paramAEVideoCaptureResult.putExtra("KEY_AVAILABLE_EMO_COUNT", l);
        Object localObject = (wsw)bhur.a(this).a(wsw.class);
        if (((wsw)localObject).c().a() != null) {}
        for (;;)
        {
          paramAEVideoCaptureResult.putExtra("KEY_MATERIAL_APPLIED", bool);
          paramAEVideoCaptureResult.putExtra("KEY_AVAILABLE_SAVENAME", (String)((wsw)localObject).d().a());
          localObject = a();
          if (localObject == null) {
            break;
          }
          Intent localIntent = ((Activity)localObject).getIntent();
          if (localIntent != null)
          {
            int i = localIntent.getIntExtra("AECAMERA_MODE", 200);
            int j = localIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", bgww.a.a());
            paramAEVideoCaptureResult.putExtra("AECAMERA_MODE", i);
            paramAEVideoCaptureResult.putExtra("VIDEO_STORY_FROM_TYPE", j);
          }
          ((Activity)localObject).startActivityForResult(paramAEVideoCaptureResult, 101);
          return;
          bool = false;
        }
      }
      paramAEVideoCaptureResult = BaseApplicationImpl.getContext();
    } while (paramAEVideoCaptureResult == null);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.6(this, paramAEVideoCaptureResult));
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.g)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setSelected(true);
        this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.a(true);
        this.g = false;
        bhcs.a(jdField_a_of_type_JavaLangString, 1, "【Dark Mode】Start");
      }
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setSelected(false);
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.a(false);
    this.g = false;
  }
  
  public void A()
  {
    C();
  }
  
  public void B()
  {
    I();
  }
  
  public void C()
  {
    if (this.jdField_a_of_type_Bgyc != null) {
      this.jdField_a_of_type_Bgyc.b();
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_Wsz.a().a(Boolean.valueOf(false));
  }
  
  public Activity a()
  {
    if (this.jdField_a_of_type_Bhzc == null) {
      return null;
    }
    return this.jdField_a_of_type_Bhzc.a();
  }
  
  public IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("key_notify_filter_so_ready");
    localIntentFilter.addAction("key_notify_ptures_so_ready");
    return localIntentFilter;
  }
  
  public View a()
  {
    Object localObject = new RelativeLayout(this.jdField_a_of_type_Bhzc.a());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Bhzc.a().getLayoutInflater().inflate(2131492958, (ViewGroup)localObject, false).findViewById(2131300884);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
    this.jdField_a_of_type_Bhdg = ((bhdg)bhur.a(this).a(bhdg.class));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300885));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297747));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297745));
    this.jdField_c_of_type_Boolean = bjeh.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout, bajq.a(1.0F));
    this.jdField_a_of_type_Bgxh = new bgxh(this.jdField_a_of_type_Bhzc.a(), this.jdField_a_of_type_AndroidViewView, this);
    this.jdField_a_of_type_Wwj = new wwj((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131310794));
    this.jdField_a_of_type_Bhdg.b.a(this.jdField_a_of_type_Wwj);
    localObject = this.jdField_a_of_type_Wwj;
    if (this.jdField_a_of_type_Wsh == wsh.jdField_a_of_type_Wsh)
    {
      bool = true;
      ((wwj)localObject).a(this, bool);
      this.jdField_a_of_type_Wus = new wus(this.jdField_a_of_type_Bhzc.a(), this.jdField_a_of_type_Bhzc.a(), this.jdField_a_of_type_AndroidViewView, this);
      this.jdField_a_of_type_Wus.b();
      this.jdField_a_of_type_Wus.a(393217, new Object[0]);
      this.jdField_a_of_type_Wus.a(262149, new Object[0]);
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_Bhzc.a(), new bhdf(this, null), null, true);
      this.jdField_a_of_type_Bgyc = new bgyc(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Wus);
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298277));
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setAEKitInitListener(this);
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setDarkModeEnable(true);
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setDarkModeListener(this);
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setCaptureListener(this);
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setFaceEffectListener(this);
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setCameraListener(this);
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setAECaptureController(this.jdField_a_of_type_Bgxh);
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setStickerInnerLutFilterListener(this);
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setRecommendTextCallback(new bhcy(this));
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setCaptureParam(a());
      if (!awll.n()) {
        break label974;
      }
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setDynamicResolutionMode(true);
      label471:
      if (bgxl.a()) {
        this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.a = this;
      }
      this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout = ((AEPituCameraCaptureButtonLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131298325));
      this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.a(this, this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout = this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = ((CameraFocusView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298287));
      this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131306378));
      if (this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel != null)
      {
        this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel.setMaterialPanelListener(this.jdField_a_of_type_Bhaf);
        this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel.setVisibility(8);
        this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel.a();
      }
      m();
      this.jdField_a_of_type_Wvz = new wvz((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131310791));
      this.jdField_a_of_type_Bhdg.a.b(this.jdField_a_of_type_Wvz);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298472));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getResources().getString(2131652942));
      if (!alrg.d())
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297009));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      CosFunHelper.setCountDownListener(new bhcz(this));
      this.jdField_a_of_type_Auti = new auti();
      this.jdField_a_of_type_Auti.a(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Auti.a(this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel);
      this.jdField_a_of_type_Auti.a(new bhda(this));
      this.jdField_a_of_type_Wvz.a(this.jdField_a_of_type_Auti);
      this.jdField_a_of_type_Autl = this.jdField_a_of_type_Wwj.a();
      this.jdField_a_of_type_Autm = new autm(this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView);
      this.jdField_a_of_type_Auth = new auth(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView);
      this.jdField_a_of_type_Autk = new autk(this.jdField_a_of_type_Bhzc.a());
      if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)) {
        break label985;
      }
    }
    label974:
    label985:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "onCreateView needLiuHaiTop:" + bool);
      }
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299334));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setSelected(false);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      n();
      return this.jdField_a_of_type_AndroidViewView;
      bool = false;
      break;
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setDynamicResolutionMode(false);
      break label471;
    }
  }
  
  public bgxh a()
  {
    return this.jdField_a_of_type_Bgxh;
  }
  
  protected bgxk a()
  {
    if (awll.n()) {
      return bjef.a().a(this.jdField_a_of_type_Bhzc.a());
    }
    return bjef.a().b(this.jdField_a_of_type_Bhzc.a());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Wus != null) {
      this.jdField_a_of_type_Wus.a(131076, new Object[0]);
    }
  }
  
  public void a(int paramInt)
  {
    this.e = false;
    QLog.e(jdField_a_of_type_JavaLangString, 2, "onCaptureError. errorCode = " + paramInt);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.8(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onActivityResult:requestCode=" + paramInt1 + " resultCode=" + paramInt2 + " data=" + paramIntent + " publishStoryFlag=" + jdField_a_of_type_Boolean);
    }
    Activity localActivity = this.jdField_a_of_type_Bhzc.a();
    auue.a(localActivity, paramInt1, paramInt2);
    if ((localActivity == null) || (localActivity.isFinishing())) {
      if (QLog.isColorLevel())
      {
        paramIntent = jdField_a_of_type_JavaLangString;
        if (localActivity == null) {
          bool = true;
        }
        QLog.d(paramIntent, 2, new Object[] { "activity is finishing, ", Boolean.valueOf(bool) });
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
    if ((paramIntent == null) && (paramInt2 == 0) && (jdField_a_of_type_Boolean))
    {
      jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_JavaLangRunnable = new AEPituCameraUnit.22(this, localActivity, paramInt2, paramIntent);
      return;
    }
    if ((paramIntent != null) && (paramInt2 == -1))
    {
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setBlockCameraFlag(jdField_a_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "cameraCaptureView setBlockCameraFlag");
      }
    }
    if ((paramInt2 == -1) && ((paramInt1 == 10006) || (paramInt1 == 1012))) {
      this.jdField_a_of_type_Bgxh.i();
    }
    if (paramInt2 == 0) {
      bhey.a(null);
    }
    if ((paramIntent != null) && (this.jdField_a_of_type_DovComQqImStorySessionWrap != null)) {
      paramIntent.putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_DovComQqImStorySessionWrap.a());
    }
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      bhez.a(this.jdField_a_of_type_Bhzc.a(), paramIntent, this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult, this.jdField_a_of_type_Bhzb, null);
      return;
    }
    this.jdField_a_of_type_Wus.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Activity paramActivity)
  {
    label501:
    for (;;)
    {
      try
      {
        Object localObject = QIMCameraCaptureActivity.class.getName();
        String str = LocalVideoSelectActivity.class.getName();
        Intent localIntent = new Intent(paramActivity, PhotoListActivity.class);
        a_(localIntent);
        vmo.a(localIntent, paramActivity.getIntent().getExtras(), paramActivity);
        localIntent.putExtra("from_qqstory", true);
        localIntent.putExtra("edit_video_type", this.jdField_a_of_type_Bhyu.a());
        if (!localIntent.hasExtra("ALBUM_NAME")) {
          localIntent.putExtra("ALBUM_NAME", baae.l);
        }
        if (!localIntent.hasExtra("ALBUM_ID")) {
          localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
        }
        localIntent.putExtra("video_refer", this.jdField_a_of_type_Bhyu.a());
        localIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
        localIntent.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
        localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        localIntent.putExtra("PhotoConst.ENABLE_MULTI_FRAGMENT_VIDEO", false);
        localIntent.putExtra("entrance_type", this.jdField_a_of_type_Bhyu.c());
        localIntent.putExtra("story_default_label", paramActivity.getIntent().getStringExtra("story_default_label"));
        localIntent.putExtra("troop_uin", paramActivity.getIntent().getLongExtra("troop_uin", 0L));
        if (localObject != null)
        {
          localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", (String)localObject);
          localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        }
        if (str != null)
        {
          localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", str);
          localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        }
        localObject = (SessionWrap)this.jdField_a_of_type_Bhzc.a().getIntent().getParcelableExtra("ARG_SESSION_INFO");
        if (localObject == null) {
          break label501;
        }
        localIntent.putExtra("uin", ((SessionWrap)localObject).jdField_a_of_type_JavaLangString);
        localIntent.putExtra("uintype", ((SessionWrap)localObject).jdField_a_of_type_Int);
        localIntent.putExtra("troop_uin", ((SessionWrap)localObject).c);
        localIntent.putExtra("uinname", ((SessionWrap)localObject).jdField_b_of_type_JavaLangString);
        localIntent = aciy.a(localIntent, null);
        localObject = SplashActivity.class.getName();
        str = this.jdField_a_of_type_Bhzc.a().getIntent().getStringExtra("f_a_a_n");
        if ((str != null) && (str.equals(ChatActivity.class.getName())))
        {
          localObject = str;
          localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", (String)localObject);
          localIntent.putExtra("key_activity_code", this.jdField_a_of_type_Bhzc.a().getIntent().getStringExtra("key_activity_code"));
          localIntent.putExtra("edit_video_way", this.jdField_a_of_type_Int);
          localIntent.putExtra("from_camera_album", true);
          localIntent.putExtra("VIDEO_STORY_JUMP_TO_TYPE", bjeg.b(paramActivity.getIntent()));
          localIntent.putExtra("VIDEO_STORY_FROM_TYPE", bjeg.a(paramActivity.getIntent()));
          paramActivity.startActivityForResult(localIntent, 10006);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        urk.b(jdField_a_of_type_JavaLangString, "QQStoryFlowCallback ", paramActivity);
        return;
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    long l = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    bhcm.a().c(l);
    super.a(paramBundle);
    bedt.jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Boolean = false;
    bjac.a().b(false);
    this.jdField_a_of_type_DovComQqImStorySessionWrap = ((SessionWrap)this.jdField_a_of_type_Bhzc.a().getIntent().getParcelableExtra("ARG_SESSION_INFO"));
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bhzc.a().getIntent().getStringExtra("ARG_AIO_CLASS");
    if (paramBundle != null) {
      this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult = ((AEVideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
    }
    this.jdField_a_of_type_Bhzc.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, a());
    this.jdField_a_of_type_Bgxg.a();
  }
  
  public void a(auuy paramauuy)
  {
    bhcm.a().b(1L);
    bhci.a().b(-1L);
    bhcs.a(jdField_a_of_type_JavaLangString, 1, "【Type】Photo");
    if (bjeg.k(a().getIntent()))
    {
      bhyv localbhyv = new bhyx(this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.b()).a(this.jdField_a_of_type_DovComQqImStorySessionWrap).a(this.jdField_b_of_type_JavaLangString).a(1).a();
      this.jdField_a_of_type_Bhyu.a(localbhyv);
      this.jdField_a_of_type_Wus.a(262148, new Object[] { paramauuy, this.jdField_a_of_type_Bhyu, this.jdField_a_of_type_Wus.a(196610, new Object[0]) });
      return;
    }
    this.jdField_a_of_type_Wus.a(262148, new Object[] { paramauuy, this.jdField_a_of_type_Wus.a(196610, new Object[0]) });
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    this.e = false;
    if (!paramBoolean)
    {
      a(101);
      return;
    }
    a(this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult, paramLocalMediaInfo);
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    K();
    if (this.jdField_a_of_type_Wsh != wsh.c)
    {
      if (paramVideoMaterial == null) {
        bhcm.a().b("none");
      }
    }
    else
    {
      if (VideoMaterialUtil.isWatermarkMaterial(paramVideoMaterial)) {
        wvk.a().a();
      }
      if ((!VideoMaterialUtil.isWatermarkEditable(paramVideoMaterial)) || (this.jdField_a_of_type_Wsh == wsh.c)) {
        break label102;
      }
      a().runOnUiThread(new AEPituCameraUnit.16(this, paramVideoMaterial));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bgyc != null) {
        this.jdField_a_of_type_Bgyc.a(paramVideoMaterial);
      }
      return;
      bhcm.a().b(paramVideoMaterial.getId());
      break;
      label102:
      a().runOnUiThread(new AEPituCameraUnit.17(this, paramVideoMaterial));
    }
  }
  
  public void a(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult = paramAEVideoCaptureResult;
    this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult.finishTimeMs = System.currentTimeMillis();
    if (this.jdField_a_of_type_Wsh == wsh.c)
    {
      b(paramAEVideoCaptureResult);
      return;
    }
    if (paramAEVideoCaptureResult.getVideoCaptureLength() < 500L)
    {
      this.e = false;
      I();
      return;
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.5(this));
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.n();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = paramAEVideoCaptureResult.videoMp4FilePath;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
    agak.a(BaseApplicationImpl.getContext()).a(this, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
  }
  
  public void a(@NonNull List<bgxo> paramList, @NonNull List<bgxn> paramList1)
  {
    this.jdField_a_of_type_Wus.a(720897, new Object[] { paramList, paramList1 });
  }
  
  public void a(@Nullable wsh paramwsh)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_Wsh = paramwsh;
    boolean bool1;
    if (this.jdField_a_of_type_Wsh == wsh.c)
    {
      bool1 = true;
      if (this.jdField_a_of_type_Wsh != wsh.jdField_a_of_type_Wsh) {
        break label154;
      }
      label29:
      bhcm.a().b(bool1);
      if (this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView != null) {
        this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setIsGIFMode(bool1);
      }
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.18(this));
      this.jdField_a_of_type_Wwj.b(bool2);
      if (this.jdField_a_of_type_Wsh != wsh.b) {
        break label159;
      }
      if (this.jdField_a_of_type_Bgyc != null) {
        this.jdField_a_of_type_Bgyc.a();
      }
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Auti);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Autl);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Autm);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Auth);
      GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Autk);
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
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Auti)) {
        GLGestureProxy.getInstance().setListener(this.jdField_a_of_type_Auti);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Autl)) {
        GLGestureProxy.getInstance().setListener(this.jdField_a_of_type_Autl);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Autm)) {
        GLGestureProxy.getInstance().setListener(this.jdField_a_of_type_Autm);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Auth)) {
        GLGestureProxy.getInstance().setListener(this.jdField_a_of_type_Auth);
      }
    } while (GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Autk));
    GLGestureProxy.getInstance().setListener(this.jdField_a_of_type_Autk);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetButton == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.14(this, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    bhcs.a(jdField_a_of_type_JavaLangString, 1, "###onCameraStarted###");
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.9(this, paramString));
    }
    int i = AEBeautyProviderView.a();
    int j = AEBeautyProviderView.b();
    this.jdField_a_of_type_Bgxh.a(i);
    this.jdField_a_of_type_Bgxh.b(j);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bgyc != null) {
      this.jdField_a_of_type_Bgyc.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bgxh == null) {
      return false;
    }
    if (this.jdField_a_of_type_Bgxh.a()) {
      return false;
    }
    if ((this.jdField_a_of_type_Wus.a(589824)) && (((Boolean)this.jdField_a_of_type_Wus.a(589826, new Object[0])).booleanValue()))
    {
      this.jdField_a_of_type_Wus.a(589826, new Object[0]);
      return true;
    }
    this.jdField_a_of_type_Bgxh.g();
    this.jdField_a_of_type_Bgxh.i();
    this.jdField_a_of_type_Bhzc.a();
    if (this.jdField_a_of_type_Wsh == wsh.c) {}
    for (;;)
    {
      return true;
      bhci.a().j();
      bhcs.a(jdField_a_of_type_JavaLangString, 1, "【Click】onBackPressed");
    }
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if (paramInt == 4) {
      a();
    }
    return super.a(paramInt, paramKeyEvent, paramBoolean);
  }
  
  protected void a_(Intent paramIntent)
  {
    paramIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
    paramIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 60000L);
    paramIntent.putExtra("qq_sub_business_id", this.jdField_a_of_type_Bhyu.b());
    paramIntent.putExtra("ALBUM_NAME", baae.l);
    paramIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
  }
  
  public void b()
  {
    this.jdField_a_of_type_Wus.a(720898, new Object[0]);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Bgxh.a(paramInt);
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putSerializable("KEY_VIDEO_RESULT", this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult);
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onResourceDownload isOnlineRes: " + paramBoolean);
    }
    if (!jdField_b_of_type_Boolean)
    {
      jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Bhzc.a().runOnUiThread(new AEPituCameraUnit.26(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Wus.a(paramBoolean);
      return;
      this.jdField_a_of_type_Bhzc.a().runOnUiThread(new AEPituCameraUnit.27(this));
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
    //   5: getfield 137	bhcw:jdField_b_of_type_Int	I
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
    //   0	28	0	this	bhcw
    //   8	4	1	i	int
    //   1	19	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	23	finally
  }
  
  public void b_(int paramInt1, int paramInt2)
  {
    super.b_(paramInt1, paramInt2);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.23(this));
    this.jdField_a_of_type_Wus.a(paramInt1, paramInt2);
  }
  
  public void c()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.2(this));
    G();
    int i = this.jdField_a_of_type_Bhzc.a().getIntent().getIntExtra("edit_video_type", 10002);
    PeakAppInterface.a.a(bhgj.jdField_a_of_type_JavaLangString, new Object[] { this, Integer.valueOf(i) });
    if (!this.f)
    {
      this.f = true;
      PeakAppInterface.a.a(1010);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.3(this));
  }
  
  public void c(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300808);
    if ((localView instanceof VideoFilterViewPager))
    {
      ((VideoFilterViewPager)localView).setVisibility(paramInt);
      QLog.i(jdField_a_of_type_JavaLangString, 2, "yes to domVideoFilterViewPager setVisibility: " + paramInt);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.onPause();
    super.d();
    this.d = false;
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Auti);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Autl);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Autm);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Auth);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Autk);
    this.jdField_a_of_type_Wwj.b();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.j();
    this.jdField_a_of_type_Bgxh.g();
    this.jdField_a_of_type_Wus.d();
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
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Bhzc.a();
    int i;
    int j;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label103;
      }
      j = 1;
      label43:
      if ((i == 0) || (j == 0)) {
        break label108;
      }
      localObject = babr.a(new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      bhcs.a(jdField_a_of_type_JavaLangString, 1, "【Camera/Audio Permission】denied");
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.25(this, (String)localObject));
      return;
      i = 0;
      break;
      label103:
      j = 0;
      break label43;
      label108:
      if (i != 0)
      {
        localObject = babr.a(new String[] { "android.permission.CAMERA" });
        bhcs.a(jdField_a_of_type_JavaLangString, 1, "【Camera Permission】denied");
      }
      else
      {
        localObject = babr.a(new String[] { "android.permission.RECORD_AUDIO" });
        bhcs.a(jdField_a_of_type_JavaLangString, 1, "【Audio Permission】denied");
      }
    }
  }
  
  public void e()
  {
    super.e();
    GLGestureProxy.getInstance().removeAllListener();
    wtt.a().a();
    this.jdField_a_of_type_Bhzc.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_Wus.g();
    if (bgxl.a()) {
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.a = null;
    }
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.e();
    bjic.jdField_a_of_type_JavaLangString = null;
    wvh.a().b();
    CosFunHelper.setCountDownListener(null);
    if (this.jdField_a_of_type_Bgxh != null) {
      this.jdField_a_of_type_Bgxh.d();
    }
    this.jdField_a_of_type_Wwj.c();
    bbqo.a(BaseApplicationImpl.getContext(), true, 5);
    aluq.a(BaseApplicationImpl.getContext(), 2, true);
    bjkr.a.clear();
    this.jdField_a_of_type_Bgxg.b();
    bhcm.a().l();
    int i = a();
    if ((i != bgww.v.a()) && (i != bgww.w.a())) {
      bhcm.a().a(false);
    }
  }
  
  public void f()
  {
    super.f();
    this.d = true;
    GLGestureProxy.getInstance().setListener(this.jdField_a_of_type_Auti);
    GLGestureProxy.getInstance().setListener(this.jdField_a_of_type_Autl);
    GLGestureProxy.getInstance().setListener(this.jdField_a_of_type_Autm);
    GLGestureProxy.getInstance().setListener(this.jdField_a_of_type_Auth);
    GLGestureProxy.getInstance().setListener(this.jdField_a_of_type_Autk);
    GLGestureProxy.getInstance().setListener(this.jdField_a_of_type_Auti);
    this.jdField_a_of_type_Bgxh.h();
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.onResume();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.i();
    o();
    a(false);
    this.jdField_a_of_type_Wus.c();
    bhdr localbhdr = (bhdr)bhfm.a(13);
    if (bgww.d.a(a()))
    {
      localbhdr.b(14);
      return;
    }
    localbhdr.b(this.jdField_a_of_type_Bhyu.c);
  }
  
  public void g()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Bgyc != null) {
      this.jdField_a_of_type_Bgyc.c();
    }
    wus localwus = this.jdField_a_of_type_Wus;
    if (this.jdField_a_of_type_Wsh == wsh.c) {}
    for (;;)
    {
      localwus.a(196611, new Object[] { Boolean.valueOf(bool) });
      this.jdField_a_of_type_Wus.a(327685, new Object[0]);
      return;
      bool = false;
    }
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.24(this));
    }
    bhcs.a(jdField_a_of_type_JavaLangString, 1, "【Camera or Audio Permission】grant");
  }
  
  public void h()
  {
    if (Build.VERSION.SDK_INT < 23) {}
    while (!(this.jdField_a_of_type_Bhzc.a() instanceof QIMCameraCaptureActivity)) {
      return;
    }
    QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_Bhzc.a();
    int i;
    if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label97;
      }
    }
    label97:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label102;
      }
      localQIMCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      return;
      i = 0;
      break;
    }
    label102:
    if (i != 0)
    {
      localQIMCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
      return;
    }
    localQIMCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  public void i() {}
  
  public void j()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.4(this));
    this.jdField_a_of_type_Wus.a(196609, new Object[0]);
    this.jdField_a_of_type_Wus.a(262145, new Object[0]);
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Bafb != null) {
      return;
    }
    Activity localActivity = this.jdField_a_of_type_Bhzc.a();
    String str = localActivity.getString(2131633588);
    this.jdField_a_of_type_Bafb = babr.a(localActivity, 230).setMessage(str).setPositiveButton(localActivity.getString(2131628445), new bhcx(this));
  }
  
  public void l() {}
  
  public void m()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.getLayoutParams();
    localLayoutParams.bottomMargin = aciy.a(-30.0F, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.getResources());
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.b();
  }
  
  @CallSuper
  protected void n()
  {
    this.jdField_a_of_type_Wsi = ((wsi)bhur.a(this).a(wsi.class));
    this.jdField_a_of_type_Wsi.a().a(this, new bhdc(this));
    this.jdField_a_of_type_Wsz = ((wsz)bhur.a(this).a(wsz.class));
  }
  
  public void notifyEnableStickerInnerEffectFilter(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      d(1);
      if (this.jdField_a_of_type_Wus != null) {
        this.jdField_a_of_type_Wus.a(196609, new Object[0]);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bhzc != null) && (this.jdField_a_of_type_Bhzc.a() != null)) {
        this.jdField_a_of_type_Bhzc.a().runOnUiThread(new AEPituCameraUnit.28(this, paramBoolean));
      }
      return;
      d(0);
    }
  }
  
  public void o()
  {
    if (alrg.d()) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    for (;;)
    {
      J();
      bhcm.a().h();
      bhci.a().A();
      if (!this.jdField_a_of_type_Wsi.c()) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setVisibility(0);
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.g();
      this.jdField_a_of_type_Wsz.a().a(Boolean.valueOf(true));
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    switch (paramView.getId())
    {
    default: 
    case 2131299334: 
    case 2131298472: 
      do
      {
        return;
        bhpm.a(this.jdField_b_of_type_AndroidWidgetButton, 200L, null);
        boolean bool;
        if (!this.jdField_b_of_type_AndroidWidgetButton.isSelected())
        {
          bool = true;
          this.jdField_b_of_type_AndroidWidgetButton.setSelected(bool);
          this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.a(bool);
          if (bool) {
            break label139;
          }
          this.g = true;
          auue.a(bool);
          if (!bool) {
            break label147;
          }
        }
        for (;;)
        {
          auts.c(i);
          return;
          bool = false;
          break;
          this.g = false;
          break label121;
          i = 2;
        }
        bhpm.a(this.jdField_a_of_type_AndroidWidgetButton, 200L, null);
        this.jdField_a_of_type_Bgxh.a();
      } while (this.jdField_a_of_type_AndroidWidgetButton == null);
      if (this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.a())
      {
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getResources().getString(2131652941));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getResources().getString(2131652942));
      return;
    case 2131300750: 
      bhci.a().l();
      return;
    case 2131298297: 
    case 2131298302: 
      label121:
      bhpm.a(paramView, 200L, null);
      label139:
      label147:
      v();
      return;
    }
    a().getIntent().removeExtra("widgetinfo");
    a(this.jdField_a_of_type_Bhzc.a());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.b, this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView);
    return true;
  }
  
  public void p()
  {
    super.p();
  }
  
  public void q()
  {
    super.q();
    this.jdField_a_of_type_Wus.e();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    bhci.a().i();
  }
  
  public void r()
  {
    super.r();
    this.jdField_a_of_type_Wus.f();
    bhci.a().a(this.jdField_a_of_type_Long);
  }
  
  public void s() {}
  
  public void t() {}
  
  public void u()
  {
    this.jdField_a_of_type_Bgxh.b();
  }
  
  public void v()
  {
    this.jdField_a_of_type_Bhzc.a().onBackPressed();
  }
  
  public void w()
  {
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.j();
    M();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setVisibility(8);
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.o();
    this.jdField_a_of_type_Wus.a(196609, new Object[0]);
    this.jdField_a_of_type_Wus.a(262147, new Object[0]);
  }
  
  public void x()
  {
    this.e = true;
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.l();
    C();
    ((bhgs)bhfm.a(5)).a(true);
    c(8);
  }
  
  public void y()
  {
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.m();
    this.e = false;
    ((bhgs)bhfm.a(5)).a(false);
    c(0);
  }
  
  public void z()
  {
    this.jdField_a_of_type_Wus.a(786435, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhcw
 * JD-Core Version:    0.7.0.1
 */