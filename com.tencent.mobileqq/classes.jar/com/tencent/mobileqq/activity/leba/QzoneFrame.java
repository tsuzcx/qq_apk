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
import cooperation.qzone.api.OnSwitchQzoneTabListener;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.api.QzoneFragmentImpl;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;

public class QzoneFrame
  extends Frame
{
  public static int a = 1;
  public static String a = "qzone_publish_queue_notify";
  public static int b = 2;
  private Fragment jdField_a_of_type_AndroidAppFragment;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new QzoneFrame.1(this);
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private OnSwitchQzoneTabListener jdField_a_of_type_CooperationQzoneApiOnSwitchQzoneTabListener = new QzoneFrame.2(this);
  private boolean jdField_a_of_type_Boolean = true;
  private Fragment jdField_b_of_type_AndroidAppFragment;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = 255;
  private Fragment jdField_c_of_type_AndroidAppFragment;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private boolean jdField_c_of_type_Boolean = true;
  
  public void V_()
  {
    QLog.d("QzoneFrame", 1, "onStart: ");
    super.V_();
    Fragment localFragment = this.jdField_a_of_type_AndroidAppFragment;
    if (localFragment == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    localFragment.onStart();
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131562321, null);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    QLog.d("QzoneFrame", 1, "onCreate: ");
    super.a();
    QZoneApiProxy.initEnv(a(), (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    QZoneApiProxy.initServlet(a(), (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131375464));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131375075));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131375457));
    this.jdField_b_of_type_AndroidAppFragment = QZoneApiProxy.createLebaFragment(a(), (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, "com.qzone.feed.ui.activity.QQLebaFriendFeedFragment");
    this.jdField_a_of_type_AndroidAppFragment = this.jdField_b_of_type_AndroidAppFragment;
    i();
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
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
    }
    else
    {
      localObject = this.jdField_b_of_type_AndroidAppFragment;
      if ((localObject instanceof QzoneFragmentImpl)) {
        ((QzoneFragmentImpl)localObject).forceRefresh();
      }
    }
    Object localObject = new IntentFilter(new IntentFilter(jdField_a_of_type_JavaLangString));
    try
    {
      a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("registerReceiver");
      localStringBuilder.append(localException);
      QLog.e("QzoneFrame", 1, localStringBuilder.toString());
    }
    QZoneLoginReportHelper.reportLoginFromSimpleMode();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Fragment localFragment = this.jdField_a_of_type_AndroidAppFragment;
    if (localFragment == null) {
      return;
    }
    localFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    Fragment localFragment = this.jdField_b_of_type_AndroidAppFragment;
    if (localFragment != null) {
      localFragment.onConfigurationChanged(paramConfiguration);
    }
    localFragment = this.jdField_c_of_type_AndroidAppFragment;
    if (localFragment != null) {
      localFragment.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    super.a((BaseActivity)paramQBaseActivity);
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("QzoneFrame", 1, "onResume: ");
    super.a(paramBoolean);
    if (this.jdField_b_of_type_AndroidAppFragment == null) {
      return;
    }
    ViewGroup localViewGroup = this.jdField_b_of_type_AndroidViewViewGroup;
    if ((localViewGroup != null) && (localViewGroup.findViewById(2131369202) != null)) {
      this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369202).setVisibility(8);
    }
    this.jdField_a_of_type_AndroidAppFragment.onResume();
    FrameHelperActivity.b(true);
    if (FrameHelperActivity.b())
    {
      FrameHelperActivity.w();
      FrameHelperActivity.b(false);
    }
  }
  
  public void ab_()
  {
    QLog.d("QzoneFrame", 1, "onPause: ");
    super.ab_();
    Fragment localFragment = this.jdField_a_of_type_AndroidAppFragment;
    if (localFragment == null) {
      return;
    }
    localFragment.onPause();
    FrameHelperActivity.b(true);
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b()
  {
    return this.jdField_a_of_type_AndroidAppFragment != null;
  }
  
  public void c()
  {
    QLog.d("QzoneFrame", 1, "onStop: ");
    super.c();
    Fragment localFragment = this.jdField_a_of_type_AndroidAppFragment;
    if (localFragment == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    localFragment.onStop();
  }
  
  public void c(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSwitchToQzone:");
    localStringBuilder.append(paramBoolean);
    QLog.i("QzoneFrame", 1, localStringBuilder.toString());
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
  
  public void d()
  {
    QLog.d("QzoneFrame", 1, "onDestroy: ");
    super.d();
    try
    {
      a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("registerReceiver");
      localStringBuilder.append(localException);
      QLog.e("QzoneFrame", 1, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_AndroidAppFragment == null) {
      return;
    }
    Fragment localFragment = this.jdField_b_of_type_AndroidAppFragment;
    if (localFragment != null)
    {
      localFragment.onDestroy();
      this.jdField_b_of_type_AndroidAppFragment = null;
    }
    localFragment = this.jdField_c_of_type_AndroidAppFragment;
    if (localFragment != null)
    {
      localFragment.onDestroy();
      this.jdField_c_of_type_AndroidAppFragment = null;
    }
  }
  
  public void f()
  {
    super.f();
    QZoneApiProxy.onAccountChange(a(), (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    a();
    a(false);
  }
  
  public void h()
  {
    super.h();
    l();
  }
  
  public void i()
  {
    Fragment localFragment = this.jdField_a_of_type_AndroidAppFragment;
    if ((localFragment != null) && ((localFragment instanceof QzoneFragmentImpl))) {
      ((QzoneFragmentImpl)localFragment).setQzoneSwitchlistener(this.jdField_a_of_type_CooperationQzoneApiOnSwitchQzoneTabListener);
    }
  }
  
  public void j()
  {
    try
    {
      QzoneOnlineTimeCollectRptService.getInstance().closeTrace();
      ImmersiveUtils.setStatusTextColor(SimpleUIUtil.b(), a().getWindow());
      ImageLoader.getInstance().clear(false);
      if (this.jdField_a_of_type_AndroidAppFragment != null)
      {
        ((QzoneFragmentImpl)this.jdField_a_of_type_AndroidAppFragment).onSwitchOutofQzone();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSwitchOutofQzone");
      localStringBuilder.append(localThrowable);
      QLog.e("QzoneFrame", 1, localStringBuilder.toString());
    }
  }
  
  public void k()
  {
    l();
    SimpleUIUtil.d = 0;
    SimpleUIUtil.e = 0;
    a();
  }
  
  public void l()
  {
    this.jdField_c_of_type_AndroidViewViewGroup.removeAllViews();
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    Fragment localFragment = this.jdField_b_of_type_AndroidAppFragment;
    if (localFragment != null) {
      localFragment.onDestroy();
    }
    localFragment = this.jdField_c_of_type_AndroidAppFragment;
    if (localFragment != null) {
      localFragment.onDestroy();
    }
    localFragment = this.jdField_b_of_type_AndroidAppFragment;
    if ((localFragment instanceof QzoneFragmentImpl)) {
      ((QzoneFragmentImpl)localFragment).clearCache();
    }
    localFragment = this.jdField_c_of_type_AndroidAppFragment;
    if ((localFragment instanceof QzoneFragmentImpl)) {
      ((QzoneFragmentImpl)localFragment).clearCache();
    }
    this.jdField_b_of_type_AndroidAppFragment = null;
    this.jdField_c_of_type_AndroidAppFragment = null;
    a().getIntent().putExtra("newflag", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.QzoneFrame
 * JD-Core Version:    0.7.0.1
 */