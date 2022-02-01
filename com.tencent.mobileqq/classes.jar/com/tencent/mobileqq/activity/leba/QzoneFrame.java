package com.tencent.mobileqq.activity.leba;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.api.QzoneFragmentImpl;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;

public class QzoneFrame
  extends Frame
{
  public static int a;
  public static String a;
  public static int b;
  private Fragment jdField_a_of_type_AndroidAppFragment;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new QzoneFrame.1(this);
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QzoneFrame.OnSwitchQzoneTabListener jdField_a_of_type_ComTencentMobileqqActivityLebaQzoneFrame$OnSwitchQzoneTabListener = new QzoneFrame.2(this);
  private boolean jdField_a_of_type_Boolean = true;
  private Fragment jdField_b_of_type_AndroidAppFragment;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = 255;
  private Fragment jdField_c_of_type_AndroidAppFragment;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private boolean jdField_c_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_a_of_type_JavaLangString = "qzone_publish_queue_notify";
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131562485, null);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_AndroidAppFragment == null) {
      return;
    }
    this.jdField_a_of_type_AndroidAppFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    if (this.jdField_b_of_type_AndroidAppFragment != null) {
      this.jdField_b_of_type_AndroidAppFragment.onConfigurationChanged(paramConfiguration);
    }
    if (this.jdField_c_of_type_AndroidAppFragment != null) {
      this.jdField_c_of_type_AndroidAppFragment.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    super.a((BaseActivity)paramQBaseActivity);
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.i("QzoneFrame", 1, "onSwitchToQzone:" + paramBoolean);
    QzoneOnlineTimeCollectRptService.getInstance().beginTrace(0);
    ThreadManager.executeOnSubThread(new QzoneFrame.3(this));
    LpReportInfo_pf00064.allReport(637, 30, 1);
    LpReportInfo_pf00064.allReport(637, 31, 1);
    if (paramBoolean)
    {
      LebaTabRedTouch.b();
      return;
    }
    LpReportInfo_pf00064.allReport(637, 23, 2);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidAppFragment != null) && ((this.jdField_a_of_type_AndroidAppFragment instanceof QzoneFragmentImpl))) {
      ((QzoneFragmentImpl)this.jdField_a_of_type_AndroidAppFragment).setQzoneSwitchlistener(this.jdField_a_of_type_ComTencentMobileqqActivityLebaQzoneFrame$OnSwitchQzoneTabListener);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    QLog.d("QzoneFrame", 1, "onResume: ");
    super.b(paramBoolean);
    if (this.jdField_b_of_type_AndroidAppFragment == null) {}
    do
    {
      return;
      if ((this.jdField_b_of_type_AndroidViewViewGroup != null) && (this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369487) != null)) {
        this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369487).setVisibility(8);
      }
      this.jdField_a_of_type_AndroidAppFragment.onResume();
      FrameHelperActivity.c(true);
    } while (!FrameHelperActivity.b());
    FrameHelperActivity.w();
    FrameHelperActivity.c(false);
  }
  
  public void c()
  {
    try
    {
      QzoneOnlineTimeCollectRptService.getInstance().closeTrace();
      ImmersiveUtils.setStatusTextColor(SimpleUIUtil.b(), a().getWindow());
      ImageLoader.getInstance().clear(false);
      if (this.jdField_a_of_type_AndroidAppFragment != null) {
        ((QzoneFragmentImpl)this.jdField_a_of_type_AndroidAppFragment).onSwitchOutofQzone();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QzoneFrame", 1, "onSwitchOutofQzone" + localThrowable);
    }
  }
  
  public void d()
  {
    super.d();
    i();
  }
  
  public void e()
  {
    QLog.d("QzoneFrame", 1, "onStart: ");
    super.e();
    if (this.jdField_a_of_type_AndroidAppFragment == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppFragment.onStart();
  }
  
  public void e(boolean paramBoolean) {}
  
  public boolean e_()
  {
    return this.jdField_a_of_type_AndroidAppFragment != null;
  }
  
  public void f()
  {
    QLog.d("QzoneFrame", 1, "onCreate: ");
    super.f();
    QZoneApiProxy.initEnv(a(), (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    QZoneApiProxy.initServlet(a(), (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131375948));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131375557));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131375941));
    this.jdField_b_of_type_AndroidAppFragment = QZoneApiProxy.createLebaFragment(a(), (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, "com.qzone.feed.ui.activity.QQLebaFriendFeedFragment");
    this.jdField_a_of_type_AndroidAppFragment = this.jdField_b_of_type_AndroidAppFragment;
    b();
    Object localObject;
    if (this.jdField_a_of_type_AndroidAppFragment != null)
    {
      ((QzoneFragmentImpl)this.jdField_b_of_type_AndroidAppFragment).setTitleView(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_AndroidAppFragment.onAttach(a());
      this.jdField_a_of_type_AndroidAppFragment.onCreate(null);
      localObject = this.jdField_a_of_type_AndroidAppFragment.onCreateView(a().getLayoutInflater(), null, null);
      if (localObject == null) {
        return;
      }
      this.jdField_c_of_type_AndroidViewViewGroup.addView((View)localObject);
      this.jdField_a_of_type_AndroidAppFragment.onActivityCreated(null);
      this.jdField_a_of_type_AndroidAppFragment.onStart();
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = false;
    }
    for (;;)
    {
      localObject = new IntentFilter(new IntentFilter(jdField_a_of_type_JavaLangString));
      try
      {
        a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
        QZoneLoginReportHelper.reportLoginFromSimpleMode();
        return;
        if (!(this.jdField_b_of_type_AndroidAppFragment instanceof QzoneFragmentImpl)) {
          continue;
        }
        ((QzoneFragmentImpl)this.jdField_b_of_type_AndroidAppFragment).forceRefresh();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("QzoneFrame", 1, "registerReceiver" + localException);
        }
      }
    }
  }
  
  public void g()
  {
    i();
    SimpleUIUtil.d = 0;
    SimpleUIUtil.e = 0;
    f();
  }
  
  public void h()
  {
    QLog.d("QzoneFrame", 1, "onStop: ");
    super.h();
    if (this.jdField_a_of_type_AndroidAppFragment == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidAppFragment.onStop();
  }
  
  public void i()
  {
    this.jdField_c_of_type_AndroidViewViewGroup.removeAllViews();
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    if (this.jdField_b_of_type_AndroidAppFragment != null) {
      this.jdField_b_of_type_AndroidAppFragment.onDestroy();
    }
    if (this.jdField_c_of_type_AndroidAppFragment != null) {
      this.jdField_c_of_type_AndroidAppFragment.onDestroy();
    }
    if ((this.jdField_b_of_type_AndroidAppFragment instanceof QzoneFragmentImpl)) {
      ((QzoneFragmentImpl)this.jdField_b_of_type_AndroidAppFragment).clearCache();
    }
    if ((this.jdField_c_of_type_AndroidAppFragment instanceof QzoneFragmentImpl)) {
      ((QzoneFragmentImpl)this.jdField_c_of_type_AndroidAppFragment).clearCache();
    }
    this.jdField_b_of_type_AndroidAppFragment = null;
    this.jdField_c_of_type_AndroidAppFragment = null;
    a().getIntent().putExtra("newflag", true);
  }
  
  public void k()
  {
    QLog.d("QzoneFrame", 1, "onDestroy: ");
    super.k();
    try
    {
      a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_a_of_type_AndroidAppFragment == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          QLog.e("QzoneFrame", 1, "registerReceiver" + localException);
        }
        if (this.jdField_b_of_type_AndroidAppFragment != null)
        {
          this.jdField_b_of_type_AndroidAppFragment.onDestroy();
          this.jdField_b_of_type_AndroidAppFragment = null;
        }
      } while (this.jdField_c_of_type_AndroidAppFragment == null);
      this.jdField_c_of_type_AndroidAppFragment.onDestroy();
      this.jdField_c_of_type_AndroidAppFragment = null;
    }
  }
  
  public void l()
  {
    super.l();
    QZoneApiProxy.onAccountChange(a(), (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    f();
    b(false);
  }
  
  public void n()
  {
    QLog.d("QzoneFrame", 1, "onPause: ");
    super.n();
    if (this.jdField_a_of_type_AndroidAppFragment == null) {
      return;
    }
    this.jdField_a_of_type_AndroidAppFragment.onPause();
    FrameHelperActivity.c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.QzoneFrame
 * JD-Core Version:    0.7.0.1
 */