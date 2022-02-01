import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.QIMStoryEffectCameraCaptureUnit.1;
import dov.com.qq.im.QIMStoryEffectCameraCaptureUnit.2;
import dov.com.qq.im.capture.mode.CaptureModeController;
import dov.com.qq.im.capture.view.StoryImageToastView;
import dov.com.qq.im.capture.view.StoryTextToastView;
import dov.com.qq.im.story.view.StoryGuideVideoView;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.richmedia.capture.view.DragAnimationMgr;
import dov.com.tencent.mobileqq.richmedia.capture.view.GuideVideoView;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class bncn
  extends QIMEffectCameraCaptureUnit
  implements bqec
{
  public static long a;
  public static HashSet<Integer> a;
  public static String l;
  public static boolean y;
  public static boolean z;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public StoryImageToastView a;
  private StoryTextToastView jdField_a_of_type_DovComQqImCaptureViewStoryTextToastView;
  public QIMCameraStoryCaptureButtonLayout a;
  public boolean a;
  public HashSet<Integer> b;
  public long d;
  
  static
  {
    jdField_a_of_type_Long = -1L;
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public bncn(boyn paramboyn, boym paramboym)
  {
    super(paramboyn, paramboym);
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_Int = 3;
  }
  
  private void a(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
    localIntent.putExtra("show_story_msg_tab", true);
    localIntent.setFlags(335544320);
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("dov.com.qq.im.finish_capture_action");
    localIntent.setPackage("com.tencent.mobileqq");
    paramContext.sendBroadcast(localIntent);
  }
  
  private void af()
  {
    Activity localActivity = a();
    if ((localActivity != null) && (localActivity.getIntent().getIntExtra("key_finish_jump_to_page", 1) == 0))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("back_when_cancel_from_shot", true);
      localActivity.setResult(0, localIntent);
    }
  }
  
  private void b(Intent paramIntent)
  {
    Activity localActivity = a();
    if (localActivity != null) {}
    switch (localActivity.getIntent().getIntExtra("key_finish_jump_to_page", 1))
    {
    default: 
      return;
    case 0: 
    case 1: 
      localActivity.setResult(-1, paramIntent);
      localActivity.finish();
      return;
    case 2: 
      a(localActivity);
      localActivity.finish();
      return;
    }
    paramIntent = localActivity.getIntent().getStringExtra("web_dispatch_event");
    if (!TextUtils.isEmpty(paramIntent))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("*");
      avob.a(paramIntent, null, localArrayList, null);
    }
    localActivity.finish();
  }
  
  private void o(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.c(paramBoolean);
    if (this.jdField_c_of_type_AndroidViewView.getTranslationY() != 0.0F)
    {
      if (paramBoolean) {
        DragAnimationMgr.c(this.jdField_c_of_type_AndroidViewView, null);
      }
    }
    else {
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setTranslationY(0.0F);
    this.jdField_c_of_type_AndroidViewView.setAlpha(1.0F);
  }
  
  private void p(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.d(paramBoolean);
    if (this.jdField_c_of_type_AndroidViewView.getTranslationY() == 0.0F)
    {
      if (paramBoolean) {
        DragAnimationMgr.d(this.jdField_c_of_type_AndroidViewView, null);
      }
    }
    else {
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setTranslationY(-this.jdField_c_of_type_AndroidViewView.getHeight());
    this.jdField_c_of_type_AndroidViewView.setAlpha(0.0F);
  }
  
  protected void B()
  {
    super.B();
    d(false);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setLockStatus(false);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setEnableSegment(true);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setSegment(false);
  }
  
  public void H()
  {
    super.H();
    o(false);
  }
  
  public void L()
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_b_of_type_JavaUtilList.size() == 0))
    {
      if (this.h) {
        d(false);
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setSegment(false);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setEnableSegment(true);
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setLockStatus(false);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.h(false);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setDrawCenterCircle(true);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setCurrentAnimatorValue(1.0F);
    this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.b();
    super.L();
  }
  
  public void Q()
  {
    super.Q();
    j();
    this.jdField_b_of_type_AndroidWidgetTextView.clearAnimation();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void R()
  {
    super.R();
    this.jdField_a_of_type_Bojo.v();
    A();
  }
  
  public void S()
  {
    super.S();
    this.jdField_a_of_type_Bojo.n();
    this.jdField_a_of_type_Bojo.m();
    h();
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.n();
  }
  
  public int a()
  {
    return 2131560968;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setIntercepPreviewCheck(true);
    if (this.jdField_b_of_type_Int == 5)
    {
      h();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
    }
    return localView;
  }
  
  protected baou a()
  {
    baou localbaou = super.a();
    localbaou.b(false);
    return localbaou;
  }
  
  public GuideVideoView a(Activity paramActivity, MqqHandler paramMqqHandler)
  {
    return new StoryGuideVideoView(paramActivity, paramMqqHandler);
  }
  
  public ArrayList<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(5));
    localArrayList.add(Integer.valueOf(0));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(4));
    return localArrayList;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_b_of_type_Int == 5) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().a(paramInt1, paramInt2, paramIntent);
    }
    if (paramIntent != null)
    {
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.a);
      if (localPublishParam != null) {
        paramIntent.putExtra("new_video_extra_info", localPublishParam.c);
      }
      this.jdField_a_of_type_Boyn.a().setResult(paramInt2, paramIntent);
    }
    if ((paramInt2 == -1) && ((paramInt1 == 10002) || (paramInt1 == 1012) || (paramInt1 == 10006))) {
      b(paramIntent);
    }
  }
  
  public void a(int paramInt, bomd parambomd)
  {
    super.a(paramInt, parambomd);
    int i = parambomd.a();
    parambomd = yqu.b(h());
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(parambomd));
    if ((i == 2) || (i == 4) || (i == 5))
    {
      jdField_a_of_type_Long = System.currentTimeMillis();
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_b_of_type_Long == -1L) {
          break label143;
        }
      }
    }
    label143:
    for (paramInt = (int)(jdField_a_of_type_Long - this.jdField_b_of_type_Long);; paramInt = 0)
    {
      parambomd = "3";
      if (i == 5) {
        parambomd = "4";
      }
      if (i == 4) {
        parambomd = "5";
      }
      yqu.a("time_waitshoot", 10002, paramInt, new String[] { "", parambomd, "", "" });
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    int i = this.jdField_a_of_type_Boyn.a().getIntent().getIntExtra("entrance_type", 1);
    this.jdField_a_of_type_Boyf = new boyf(10002, i, 1);
    super.a(paramBundle);
    if (i == 104) {
      yqu.a("video_shoot_fromweb", "exp_cam", 0, 0, new String[0]);
    }
    if (i == 18) {
      yqu.a("video_shoot_new", "shoot_exp", 1, 0, new String[] { "", "", "", "18" });
    }
    jdField_a_of_type_Long = -1L;
    y = false;
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    l = String.valueOf(i);
    z = false;
    long l1 = this.jdField_a_of_type_Boyn.a().getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L);
    if (l1 != 0L)
    {
      bcdl.d = QLog.sInitLogTime;
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_PEAK_ATTACH ", Long.valueOf(bcdl.d) });
      bcdl.jdField_a_of_type_Long = this.jdField_a_of_type_Boyn.a().getIntent().getLongExtra("TIMESTAMP_PRELOAD_PEAK", 0L);
      bcdl.jdField_b_of_type_Long = this.jdField_a_of_type_Boyn.a().getIntent().getLongExtra("TIMESTAMP_CLICK_CAMERA", 0L);
      bcdl.c = l1;
      bcdl.f = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_ONCREATE ", Long.valueOf(bcdl.f) });
    }
  }
  
  public void a(baox parambaox)
  {
    super.a(parambaox);
    boolean bool1;
    boolean bool2;
    label34:
    boolean bool3;
    label45:
    boolean bool4;
    if (this.jdField_a_of_type_Boyf.jdField_b_of_type_Int != 102)
    {
      bool1 = true;
      if (this.jdField_a_of_type_Boyf.jdField_b_of_type_Int == 102) {
        break label301;
      }
      bool2 = true;
      if (this.jdField_b_of_type_Int == 5) {
        break label307;
      }
      bool3 = true;
      if (this.jdField_b_of_type_Int == 5) {
        break label313;
      }
      bool4 = true;
      label56:
      Object localObject = new boyi(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a()).b(bool1).c(bool2).d(true).a(bool4).e(bool3).c(h()).a(11).a();
      this.jdField_a_of_type_Boyf.a((boyg)localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putString("extra_text_filter_text", this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().a());
      bqcc.a(this.jdField_a_of_type_Boyn.a(), parambaox, this.jdField_a_of_type_Boyf, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, (Bundle)localObject);
      if (!y)
      {
        y = true;
        yqu.a("clk_mode", 10002, 0, new String[] { ShortVideoUtils.a(jdField_a_of_type_JavaUtilHashSet), "0", "", "" });
      }
      if (!z)
      {
        z = true;
        if (jdField_a_of_type_Long == -1L) {
          break label319;
        }
      }
    }
    label301:
    label307:
    label313:
    label319:
    for (int i = (int)(System.currentTimeMillis() - jdField_a_of_type_Long);; i = 0)
    {
      yqu.a("time_shoot", 10002, i, new String[] { yqu.b(h()), "0", "", "" });
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label34;
      bool3 = false;
      break label45;
      bool4 = false;
      break label56;
    }
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool = this.j;
    super.a(paramLocalMediaInfo, paramBoolean);
    ThreadManager.getUIHandler().post(new QIMStoryEffectCameraCaptureUnit.2(this, paramBoolean, bool));
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    int j = -1;
    if (QLog.isColorLevel()) {
      QLog.d("QIMStoryEffectCameraCaptureUnit", 2, "onVideoCaptured final");
    }
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().l();
    boolean bool1;
    boolean bool2;
    label65:
    boolean bool3;
    label76:
    boolean bool4;
    if (this.jdField_a_of_type_Boyf.jdField_b_of_type_Int != 102)
    {
      bool1 = true;
      if (this.jdField_a_of_type_Boyf.jdField_b_of_type_Int == 102) {
        break label420;
      }
      bool2 = true;
      if (this.jdField_b_of_type_Int == 5) {
        break label426;
      }
      bool3 = true;
      if (this.jdField_b_of_type_Int == 5) {
        ad();
      }
      if ((this.jdField_a_of_type_Boyf.b() == 108) || (!this.h)) {
        break label432;
      }
      bool4 = true;
      label110:
      Bundle localBundle = this.jdField_a_of_type_Boyn.a().getIntent().getExtras();
      Object localObject = new boyl().a(false).e(bool1).f(bool2).g(true).h(bool4).i(bool3).c(h()).j(true);
      this.jdField_a_of_type_Boyf.a(((boyl)localObject).a());
      if (!this.h) {
        break label438;
      }
      i = 2;
      label196:
      localBundle.putInt("extra_transiton_src_from", i);
      localBundle.putString("extra_text_filter_text", this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().a());
      localObject = this.jdField_a_of_type_Boyn.a().getIntent();
      i = j;
      if (this.h) {
        i = 2;
      }
      ((Intent)localObject).putExtra("extra_transiton_src_from", i);
      bqcc.a(this.jdField_a_of_type_Boyn.a(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_a_of_type_Boyf, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, localBundle);
      if (!y)
      {
        y = true;
        yqu.a("clk_mode", 10002, 0, new String[] { ShortVideoUtils.a(jdField_a_of_type_JavaUtilHashSet), "0", "", "" });
      }
      if (!z)
      {
        z = true;
        if (jdField_a_of_type_Long == -1L) {
          break label443;
        }
      }
    }
    label420:
    label426:
    label432:
    label438:
    label443:
    for (int i = (int)(System.currentTimeMillis() - jdField_a_of_type_Long);; i = 0)
    {
      yqu.a("time_shoot", 10002, i, new String[] { yqu.b(h()), String.valueOf(paramLocalMediaInfo.mDuration), "", "" });
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label65;
      bool3 = false;
      break label76;
      bool4 = false;
      break label110;
      i = -1;
      break label196;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView;
    if (!paramBoolean1)
    {
      paramBoolean2 = true;
      ((CameraCaptureView)localObject).g = paramBoolean2;
      localObject = this.jdField_a_of_type_Bojo;
      if (paramBoolean1) {
        break label206;
      }
      paramBoolean2 = true;
      label30:
      ((bojo)localObject).g(paramBoolean2);
      if (!paramBoolean1) {
        break label211;
      }
      if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Bojo.n();
      }
      h();
      N();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      n(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.e != null))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.e);
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131367085);
        i = zlx.a(this.jdField_a_of_type_Boyn.a(), 88.0F);
        this.e.setTranslationY(i);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.e, (ViewGroup.LayoutParams)localObject);
        this.e.bringToFront();
      }
    }
    label206:
    label211:
    do
    {
      return;
      paramBoolean2 = false;
      break;
      paramBoolean2 = false;
      break label30;
      this.jdField_a_of_type_Bojo.b();
      g();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(0);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      n(true);
    } while ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.e == null));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.e);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131372978);
    int i = zlx.a(this.jdField_a_of_type_Boyn.a(), 88.0F);
    this.e.setTranslationY(i);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.e, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.g();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.c()) {
      return false;
    }
    af();
    boolean bool = super.a();
    if ((!this.jdField_a_of_type_Boolean) && (bool))
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_b_of_type_Long == -1L) {
        break label153;
      }
    }
    label153:
    for (int i = (int)(System.currentTimeMillis() - this.jdField_b_of_type_Long);; i = 0)
    {
      yqu.a("time_waitshoot", 10002, i, new String[] { "", "1", "", "" });
      if ((!y) && (bool))
      {
        y = true;
        yqu.a("clk_mode", 10002, 0, new String[] { ShortVideoUtils.a(jdField_a_of_type_JavaUtilHashSet), "1", "", "" });
      }
      return bool;
    }
  }
  
  public void ac()
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
    if (!this.jdField_b_of_type_JavaUtilHashSet.contains(Integer.valueOf(this.jdField_b_of_type_Int)))
    {
      this.jdField_b_of_type_JavaUtilHashSet.add(Integer.valueOf(this.jdField_b_of_type_Int));
      yqu.a("start_shoot", 10002, 0, new String[] { yqu.b(h()), "0", "", l });
    }
  }
  
  /* Error */
  void ad()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 159	bncn:jdField_a_of_type_DovComQqImCaptureModeCaptureModeController	Ldov/com/qq/im/capture/mode/CaptureModeController;
    //   4: invokevirtual 353	dov/com/qq/im/capture/mode/CaptureModeController:a	()Lboza;
    //   7: invokevirtual 731	boza:b	()Ljava/lang/String;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull +231 -> 243
    //   15: new 733	java/io/File
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 736	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: invokevirtual 739	java/io/File:exists	()Z
    //   26: ifeq +217 -> 243
    //   29: new 741	android/media/MediaMetadataRetriever
    //   32: dup
    //   33: invokespecial 742	android/media/MediaMetadataRetriever:<init>	()V
    //   36: astore 4
    //   38: sipush 5000
    //   41: istore_1
    //   42: aload 4
    //   44: aload_3
    //   45: invokevirtual 745	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   48: aload 4
    //   50: bipush 9
    //   52: invokevirtual 748	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   55: invokestatic 752	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   58: istore_2
    //   59: iload_2
    //   60: istore_1
    //   61: aload 4
    //   63: invokevirtual 755	android/media/MediaMetadataRetriever:release	()V
    //   66: new 757	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo
    //   69: dup
    //   70: invokespecial 758	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:<init>	()V
    //   73: astore 4
    //   75: aload 4
    //   77: iconst_1
    //   78: putfield 761	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mType	I
    //   81: aload 4
    //   83: aload_3
    //   84: invokevirtual 764	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:setPath	(Ljava/lang/String;)V
    //   87: aload 4
    //   89: ldc_w 765
    //   92: invokestatic 769	anni:a	(I)Ljava/lang/String;
    //   95: putfield 772	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mMusicName	Ljava/lang/String;
    //   98: aload 4
    //   100: ldc_w 419
    //   103: putfield 775	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mSingername	Ljava/lang/String;
    //   106: aload 4
    //   108: aconst_null
    //   109: putfield 778	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mUrl	Ljava/lang/String;
    //   112: aload 4
    //   114: aconst_null
    //   115: putfield 781	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mTagName	Ljava/lang/String;
    //   118: aload 4
    //   120: iconst_0
    //   121: putfield 784	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicStart	I
    //   124: aload 4
    //   126: iload_1
    //   127: putfield 787	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicDuration	I
    //   130: aload 4
    //   132: aconst_null
    //   133: putfield 790	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mSongMid	Ljava/lang/String;
    //   136: aload 4
    //   138: ldc_w 791
    //   141: putfield 795	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mRecognitionOffset	F
    //   144: aload 4
    //   146: iconst_0
    //   147: putfield 798	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mHasCopyright	Z
    //   150: aload 4
    //   152: iconst_0
    //   153: putfield 801	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mAccuracy	I
    //   156: aload 4
    //   158: aconst_null
    //   159: putfield 804	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:jumpWs	Ljava/lang/String;
    //   162: aload_0
    //   163: getfield 550	bncn:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   166: ldc_w 806
    //   169: invokevirtual 810	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   172: astore_3
    //   173: aload_3
    //   174: ldc_w 812
    //   177: invokevirtual 817	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   180: invokevirtual 810	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   183: astore 5
    //   185: aload 5
    //   187: ldc_w 819
    //   190: aload 4
    //   192: invokevirtual 823	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   195: aload 5
    //   197: ldc_w 825
    //   200: aload 4
    //   202: invokevirtual 828	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:getLocalPath	()Ljava/lang/String;
    //   205: invokevirtual 547	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload 5
    //   210: ldc_w 830
    //   213: aload_0
    //   214: getfield 324	bncn:jdField_b_of_type_Int	I
    //   217: invokevirtual 648	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   220: aload_3
    //   221: ldc_w 812
    //   224: invokevirtual 817	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   227: aload 5
    //   229: invokevirtual 834	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   232: aload_0
    //   233: getfield 550	bncn:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   236: ldc_w 806
    //   239: aload_3
    //   240: invokevirtual 834	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   243: return
    //   244: astore 5
    //   246: aload 4
    //   248: invokevirtual 755	android/media/MediaMetadataRetriever:release	()V
    //   251: goto -185 -> 66
    //   254: astore_3
    //   255: aload 4
    //   257: invokevirtual 755	android/media/MediaMetadataRetriever:release	()V
    //   260: aload_3
    //   261: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	bncn
    //   41	86	1	i	int
    //   58	2	2	j	int
    //   10	230	3	localObject1	Object
    //   254	7	3	localObject2	Object
    //   36	220	4	localObject3	Object
    //   183	45	5	localBundle	Bundle
    //   244	1	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   42	59	244	java/lang/Exception
    //   42	59	254	finally
  }
  
  public void ae()
  {
    p(true);
    if (this.jdField_b_of_type_Int == 5)
    {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().m();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public int b()
  {
    return 5;
  }
  
  public void b(long paramLong)
  {
    super.b(paramLong);
    Activity localActivity = this.jdField_a_of_type_Boyn.a();
    int k = localActivity.getIntent().getIntExtra("entrance_type", 1);
    String str;
    Object localObject2;
    int i;
    if (localActivity.getIntent().hasExtra("pendingIntentClass"))
    {
      str = "1";
      localObject2 = "0";
      int j = 0;
      i = j;
      if (this.jdField_b_of_type_Long != -1L)
      {
        i = j;
        if (str.equals("0")) {
          i = (int)(paramLong - this.jdField_b_of_type_Long);
        }
      }
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT < 23) {}
    }
    for (;;)
    {
      try
      {
        if (localActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
          continue;
        }
        bool1 = true;
        if (localActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
          continue;
        }
        bool2 = true;
        if (localActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
          continue;
        }
        bool3 = true;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QIMStoryEffectCameraCaptureUnit", 2, new Object[] { "checkSelfPermission ", Boolean.valueOf(bool1), " ", Boolean.valueOf(bool2), " ", Boolean.valueOf(bool3) });
      }
      catch (Exception localException)
      {
        boolean bool1;
        boolean bool2;
        boolean bool3;
        localObject1 = "4";
        QLog.e("QIMStoryEffectCameraCaptureUnit", 1, "checkSelfPermission error, ", localException);
        continue;
        if ((bool1) || (bool2)) {
          continue;
        }
        localObject1 = localException;
        if (!bool3) {
          continue;
        }
        continue;
      }
      localObject1 = "";
      if (bool1) {
        localObject1 = "".concat("1");
      }
      localObject2 = localObject1;
      if (bool2) {
        localObject2 = ((String)localObject1).concat(",3");
      }
      localObject1 = localObject2;
      if (bool3) {
        localObject1 = ((String)localObject2).concat(",2");
      }
      yqu.a("time_openshoot", 10002, i, new String[] { str, localObject1, "", String.valueOf(k) });
      if (bcdl.j != 0L)
      {
        bcdl.k = System.currentTimeMillis();
        QLog.d("CAM_START_MONITOR", 1, new Object[] { "story cost: ", Long.valueOf(bcdl.k - bcdl.jdField_b_of_type_Long), "\nStartClick cost: ", Long.valueOf(bcdl.jdField_b_of_type_Long - bcdl.jdField_a_of_type_Long), "\nStartActiv cost: ", Long.valueOf(bcdl.c - bcdl.jdField_b_of_type_Long), "\nStartProce cost: ", Long.valueOf(bcdl.d - bcdl.c), "\nCreateBase cost: ", Long.valueOf(bcdl.e - bcdl.d), "\nCreateQimA cost: ", Long.valueOf(bcdl.f - bcdl.e), "\nStartBaseA cost: ", Long.valueOf(bcdl.g - bcdl.f), "\nStartQimAc cost: ", Long.valueOf(bcdl.h - bcdl.g), "\nResumeBase cost: ", Long.valueOf(bcdl.i - bcdl.h), "\nResumeQimA cost: ", Long.valueOf(bcdl.j - bcdl.i), "\nFirstFrame cost: ", Long.valueOf(bcdl.k - bcdl.j), "\nPeakCreatS cost: ", Long.valueOf(bcdl.l - bcdl.d), "\nPeakCreatT cost: ", Long.valueOf(bcdl.m - bcdl.l) });
      }
      return;
      str = "0";
      break;
      bool1 = false;
      continue;
      bool2 = false;
      continue;
      bool3 = false;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.c()) {
      o(true);
    }
  }
  
  public int c()
  {
    int i = 0;
    int k = this.jdField_a_of_type_Boyn.a().getIntent().getExtras().getInt("capture_intent_mode", 0);
    int j = bomf.a(k);
    boolean bool = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a(j);
    if (!bool) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMStoryEffectCameraCaptureUnit", 2, "getIntentCaptureMode intentIndex:" + k + ", isSupport:" + bool);
      }
      return i;
      i = j;
    }
  }
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_b_of_type_Int == 5)
    {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().c(paramBoolean2);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void d()
  {
    super.d();
    yqu.a(1, this.d);
  }
  
  public void d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      d(true);
      this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.b();
      return;
    case 2: 
      this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.b();
      return;
    case 3: 
      this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.a(anni.a(2131708611)).a(2130844641).a(false);
      return;
    case 4: 
      this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.a(anni.a(2131708618)).a(2130844640).a(false);
      return;
    case 5: 
      this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.b();
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.b();
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStoryEffectCameraCaptureUnit", 2, new Object[] { "handleSegmentCaptureMode", Boolean.valueOf(paramBoolean) });
    }
    if (this.h != paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setSegmentMode(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.x();
      if (paramBoolean)
      {
        this.h = true;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
    }
    else
    {
      return;
    }
    this.h = false;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.i) {
      e(false);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      this.jdField_a_of_type_Boyn.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void f()
  {
    this.d = SystemClock.uptimeMillis();
    super.f();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.n();
    this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.b();
    String str = yqu.b(h());
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(str));
    if (bcdl.jdField_b_of_type_Long != 0L)
    {
      bcdl.j = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_ONRESUME ", Long.valueOf(bcdl.j) });
    }
  }
  
  public void f(boolean paramBoolean)
  {
    super.f(paramBoolean);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setEnableSegment(paramBoolean);
  }
  
  public void h()
  {
    super.h();
  }
  
  public int i()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void i()
  {
    super.i();
    if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.b()) || (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.c())) {
      yqu.a("clk_shoot", yqu.b(banm.jdField_a_of_type_Int), 1, new String[0]);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new QIMStoryEffectCameraCaptureUnit.1(this));
      return;
      yqu.a("clk_shoot", yqu.b(banm.jdField_a_of_type_Int), 3, new String[0]);
    }
  }
  
  public void i(boolean paramBoolean)
  {
    super.i(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetButton.setAlpha(0.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((this.jdField_a_of_type_Bojo != null) && (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Bojo.n();
      }
      if (this.e != null) {
        this.e.setVisibility(4);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.b(true);
      ab();
      return;
    }
    this.jdField_c_of_type_AndroidWidgetButton.setAlpha(1.0F);
    this.jdField_a_of_type_Bojo.b();
    if (this.e != null) {
      this.e.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect("");
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.b(false);
    aa();
  }
  
  public void j()
  {
    if (this.jdField_b_of_type_Int == 5) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().h();
    }
    super.j();
    jdField_a_of_type_Long = System.currentTimeMillis();
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_b_of_type_Long == -1L) {
        break label174;
      }
    }
    label174:
    for (int i = (int)(System.currentTimeMillis() - this.jdField_b_of_type_Long);; i = 0)
    {
      yqu.a("time_waitshoot", 10002, i, new String[] { "", "0", "", "" });
      if (!this.jdField_b_of_type_JavaUtilHashSet.contains(Integer.valueOf(this.jdField_b_of_type_Int)))
      {
        this.jdField_b_of_type_JavaUtilHashSet.add(Integer.valueOf(this.jdField_b_of_type_Int));
        yqu.a("start_shoot", 10002, 0, new String[] { yqu.b(h()), "0", "", l });
      }
      return;
    }
  }
  
  public void j(boolean paramBoolean)
  {
    super.j(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
  }
  
  public void k()
  {
    if (this.jdField_b_of_type_Int == 5)
    {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().i();
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    super.k();
  }
  
  public void k(boolean paramBoolean)
  {
    super.k(paramBoolean);
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (float f = 1.0F;; f = 0.5F)
    {
      localImageView.setAlpha(f);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_b_of_type_Int != 5) || (!this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().c())) {
        if (!this.f) {
          break;
        }
      }
    }
  }
  
  public void p()
  {
    super.p();
    if (bcdl.jdField_b_of_type_Long != 0L)
    {
      bcdl.h = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_ONSTART ", Long.valueOf(bcdl.h) });
    }
  }
  
  public void q()
  {
    if (this.jdField_b_of_type_Int == 5) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().j();
    }
    super.q();
    jdField_a_of_type_Long = System.currentTimeMillis();
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_b_of_type_Long == -1L) {
        break label174;
      }
    }
    label174:
    for (int i = (int)(System.currentTimeMillis() - this.jdField_b_of_type_Long);; i = 0)
    {
      yqu.a("time_waitshoot", 10002, i, new String[] { "", "0", "", "" });
      if (!this.jdField_b_of_type_JavaUtilHashSet.contains(Integer.valueOf(this.jdField_b_of_type_Int)))
      {
        this.jdField_b_of_type_JavaUtilHashSet.add(Integer.valueOf(this.jdField_b_of_type_Int));
        yqu.a("start_shoot", 10002, 0, new String[] { yqu.b(h()), "0", "", l });
      }
      return;
    }
  }
  
  protected void u()
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout = ((QIMCameraStoryCaptureButtonLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364143));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.a(this, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setCaptureStatusChangeListener(this);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout;
    this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout;
    ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131374009)).inflate();
    this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView = ((StoryImageToastView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374008));
    this.jdField_a_of_type_DovComQqImCaptureViewStoryTextToastView = ((StoryTextToastView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373999));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncn
 * JD-Core Version:    0.7.0.1
 */