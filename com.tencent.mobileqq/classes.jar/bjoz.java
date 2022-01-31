import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.ptv.LWMotionEvent;
import dov.com.qq.im.ptv.LightVideoConfigMgr;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.10;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.11;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.12;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.2;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.4;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.6;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.7;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.8;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.9;
import dov.com.qq.im.ptv.LightWeightCaptureButtonCornerLayout;
import dov.com.qq.im.ptv.LightWeightCaptureButtonHorizontalLayout;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout;
import dov.com.qq.im.ptv.LightWeightCaptureShadow;
import dov.com.qq.im.ptv.LightWeightProgress;
import dov.com.qq.im.ptv.PtvCameraCaptureActivity;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

@TargetApi(11)
public class bjoz
  implements View.OnClickListener, View.OnTouchListener, avuh, avui, avwf, bjqc, bjqd, bjql, bjqv
{
  protected int a;
  protected long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bjpa(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected View a;
  protected ImageView a;
  protected RelativeLayout a;
  private avre jdField_a_of_type_Avre;
  protected avsq a;
  protected avsv a;
  private bbgg jdField_a_of_type_Bbgg;
  protected bjqm a;
  public bjqt a;
  public bjqu a;
  protected CameraFocusView a;
  protected SimpleEffectsCaptureView a;
  public LightWeightCaptureButtonLayout a;
  private LightWeightCaptureShadow jdField_a_of_type_DovComQqImPtvLightWeightCaptureShadow;
  protected LightWeightProgress a;
  protected boolean a;
  private long b;
  protected boolean b;
  protected boolean c;
  private boolean d;
  
  public bjoz()
  {
    this.jdField_b_of_type_Long = 3L;
    this.jdField_a_of_type_Bjqm = new bjqm(10000, 100, 2);
  }
  
  public bjoz(bjqu parambjqu, bjqt parambjqt)
  {
    this.jdField_b_of_type_Long = 3L;
    this.jdField_a_of_type_Bjqm = new bjqm(10000, 100, 2);
    this.jdField_a_of_type_Bjqu = parambjqu;
    this.jdField_a_of_type_Bjqt = parambjqt;
  }
  
  private void v()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bjqu.a().getIntent().getIntExtra("flow_camera_show_mode_style", 0) == 1) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Bjqu.a().getIntent().getBooleanExtra("flow_camera_show_panel", false);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Bjqu.a().getIntent().getIntExtra("light_video_entry_type", 0);
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_Bbgg == null)
    {
      Activity localActivity = this.jdField_a_of_type_Bjqu.a();
      String str = localActivity.getString(2131699354);
      this.jdField_a_of_type_Bbgg = bbcv.a(localActivity, 230).setMessage(str).setPositiveButton(localActivity.getString(2131694087), new bjpd(this));
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Avre = avre.a();
      this.jdField_a_of_type_AndroidViewView.post(new LightWeightCameraCaptureUnit.6(this));
    }
  }
  
  public void H_()
  {
    if (Build.VERSION.SDK_INT < 23) {}
    while (!(this.jdField_a_of_type_Bjqu.a() instanceof PtvCameraCaptureActivity)) {
      return;
    }
    PtvCameraCaptureActivity localPtvCameraCaptureActivity = (PtvCameraCaptureActivity)this.jdField_a_of_type_Bjqu.a();
    int i;
    if (localPtvCameraCaptureActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (localPtvCameraCaptureActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label93;
      }
    }
    label93:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label98;
      }
      localPtvCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      return;
      i = 0;
      break;
    }
    label98:
    if (i != 0)
    {
      localPtvCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
      return;
    }
    localPtvCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  protected int a()
  {
    return 2131560536;
  }
  
  public View a()
  {
    v();
    View localView = b();
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_Bjqu.a());
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    Object localObject = localView;
    if (localView == null) {
      localObject = this.jdField_a_of_type_Bjqu.a().getLayoutInflater().inflate(a(), localRelativeLayout, false);
    }
    this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131366493);
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363895));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView = ((SimpleEffectsCaptureView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363833));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.d(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setCaptureParam(a());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setDarkModeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setCaptureListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setCameraPermissionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setUseVideoOrientation(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setFaceEffectListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setDynamicResolutionMode(false);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = ((CameraFocusView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363843));
    this.jdField_a_of_type_Avsv = new avsv(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView);
    this.jdField_a_of_type_Avsq = a();
    localObject = (SessionInfo)this.jdField_a_of_type_Bjqu.a().getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout = ((LightWeightCaptureButtonCornerLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363774));
      if (localObject != null) {
        this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.d = ((SessionInfo)localObject).jdField_a_of_type_Int;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label531;
      }
      arql.b(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.d);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureShadow = ((LightWeightCaptureShadow)this.jdField_a_of_type_AndroidViewView.findViewById(2131363896));
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureShadow.setVisibility(0);
      this.jdField_a_of_type_DovComQqImPtvLightWeightProgress = ((LightWeightProgress)this.jdField_a_of_type_AndroidViewView.findViewById(2131372030));
      int i = LightVideoConfigMgr.a().b();
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.setMaxDuration(i * 1000);
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.a(this, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView, this.jdField_a_of_type_DovComQqImPtvLightWeightProgress);
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.setVisibility(0);
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.setUIButtonListener(this);
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = (blbz.a(73.5F) - blbz.a(8.0F));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setStrokeWidth(2.0F);
      this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362990));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      return this.jdField_a_of_type_AndroidViewView;
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout = ((LightWeightCaptureButtonHorizontalLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363775));
      break;
      label531:
      arql.a(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.d);
      arql.d(this.jdField_a_of_type_Int);
    }
  }
  
  protected avsq a()
  {
    return new avsq(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView);
  }
  
  protected avuj a()
  {
    return bkup.a().c(this.jdField_a_of_type_Bjqu.a());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Long != -1L)
    {
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      QLog.d("LightWeightCameraCaptureUnit", 1, "(NEW)LaunchActivity to FirstFrameShown cost : " + l + "ms");
      axds.a("sv_light_cost_time_total", l);
    }
    bkpd.a();
    QLog.i("LightWeightCameraCaptureUnit", 1, "(NEW)LaunchActivity to onFirstFrameShown mIsCornerStyle: " + this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidViewView.post(new LightWeightCameraCaptureUnit.4(this));
  }
  
  public void a(int paramInt)
  {
    this.c = false;
    QLog.e("LightWeightCameraCaptureUnit", 2, "onCaptureError. errorCode = " + paramInt);
    ThreadManager.getUIHandler().post(new LightWeightCameraCaptureUnit.9(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(long paramLong) {}
  
  public void a(Intent paramIntent) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = this.jdField_a_of_type_Bjqu.a().getIntent().getLongExtra("ACTIVITY_START_TIME", -1L);
    avtn.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_Bjqu.a(), new bjpe(this, null));
  }
  
  public void a(avum paramavum) {}
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightWeightCameraCaptureUnit", 2, "onVideoCaptured[co-new]. videoFrameCount = " + paramVideoCaptureResult.videoFrameCount + " ; minFrameCount = " + this.jdField_b_of_type_Long);
    }
    if (paramVideoCaptureResult.videoFrameCount < this.jdField_b_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightWeightCameraCaptureUnit", 2, "onVideoCaptured. videoFrameCount = " + paramVideoCaptureResult.videoFrameCount + " ; minFrameCount = " + this.jdField_b_of_type_Long);
      }
      this.c = false;
      ThreadManager.getUIHandler().post(new LightWeightCameraCaptureUnit.7(this));
      vel.a("clk_shoot", vel.b(avtb.jdField_a_of_type_Int), 2, new String[0]);
    }
  }
  
  public void a(LWMotionEvent paramLWMotionEvent)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("IPC onTouchHook...  uiHandler!=null: ");
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("LightWeightCameraCaptureUnit", 2, bool);
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(new LightWeightCameraCaptureUnit.11(this, paramLWMotionEvent));
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightWeightCameraCaptureUnit", 2, "onSoLoad soLoaded=" + paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new LightWeightCameraCaptureUnit.2(this, paramString));
    }
    avtn.b = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.a();
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Bjqu.a();
    return true;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  protected View b()
  {
    return null;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.d() == paramInt) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setBeauty(paramInt);
  }
  
  public void b(Bundle paramBundle) {}
  
  public void b_(int paramInt1, int paramInt2) {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightWeightCameraCaptureUnit", 2, "onVideoCaptureStart[co-new].");
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setCurrentProgress(paramInt);
  }
  
  public void d()
  {
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avsv);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Avsq);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.onPause();
    if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout != null) {
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.g();
    }
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    int j = 1;
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Bjqu.a();
    int i;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label78;
      }
      label41:
      if ((i == 0) || (j == 0)) {
        break label83;
      }
      localObject = ajyc.a(2131706066);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new LightWeightCameraCaptureUnit.10(this, (String)localObject));
      return;
      i = 0;
      break;
      label78:
      j = 0;
      break label41;
      label83:
      if (i != 0) {
        localObject = ajyc.a(2131706098);
      } else {
        localObject = ajyc.a(2131706096);
      }
    }
  }
  
  public void e()
  {
    GLGestureProxy.getInstance().removeAllListener();
    if (this.d)
    {
      this.jdField_a_of_type_Bjqu.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.d = false;
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightWeightCameraCaptureUnit", 2, "onActivityResume");
    }
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avsv);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Avsq);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.onResume();
    if (this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout != null) {
      this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.f();
    }
    if (!this.d)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
      localIntentFilter.addAction("tencent.qq.ipc.event");
      this.jdField_a_of_type_Bjqu.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.d = true;
    }
    x();
  }
  
  public void g()
  {
    b(60);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setCameraPermissionResult(true);
  }
  
  protected void h()
  {
    this.jdField_a_of_type_Bjqt.a(2);
  }
  
  public void i()
  {
    ThreadManager.getUIHandler().post(new LightWeightCameraCaptureUnit.8(this));
  }
  
  public void j()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
  }
  
  public void k()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(null);
  }
  
  public void l()
  {
    this.jdField_a_of_type_Bjqt.a(1);
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LightWeightCameraCaptureUnit", 2, "onCaptureButtonVideoStart!");
    }
    this.c = true;
    boolean bool = this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.b();
    if (QLog.isColorLevel()) {
      QLog.i("LightWeightCameraCaptureUnit", 2, "onCaptureButtonVideoStart!  enabled: " + bool);
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.i();
    }
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LightWeightCameraCaptureUnit", 2, "onCaptureButtonVideoStop!");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.j();
    this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout.setCaptureEnable(false);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView) {
      this.jdField_a_of_type_Bjqt.a(0);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public void p() {}
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LightWeightCameraCaptureUnit", 2, "onCaptureButtonVideoCancel!");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.h();
  }
  
  public void r() {}
  
  public void s() {}
  
  public void t()
  {
    if (this.d)
    {
      this.jdField_a_of_type_Bjqu.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.d = false;
    }
  }
  
  public void u()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("IPC onIPCExitEvent...  uiHandler!=null: ");
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("LightWeightCameraCaptureUnit", 2, bool);
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new LightWeightCameraCaptureUnit.12(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjoz
 * JD-Core Version:    0.7.0.1
 */