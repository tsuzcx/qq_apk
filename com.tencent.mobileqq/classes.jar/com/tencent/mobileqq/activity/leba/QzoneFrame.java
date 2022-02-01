package com.tencent.mobileqq.activity.leba;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.feed.ILebaPluginFeedApi;
import com.tencent.mobileqq.leba.feed.ILebaPluginFeedController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.api.QzoneFragmentImpl;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import mqq.app.MobileQQ;

public class QzoneFrame
  extends Frame
{
  public static int a = 1;
  public static String b = "qzone_publish_queue_notify";
  private static boolean l;
  private static boolean m;
  BroadcastReceiver c = new QzoneFrame.1(this);
  private Fragment d;
  private boolean e = true;
  private ViewGroup f;
  private ViewGroup g;
  private ViewGroup h;
  private View i;
  private boolean j = true;
  private ILebaPluginFeedController k;
  
  public static boolean p()
  {
    return l;
  }
  
  public static boolean q()
  {
    return m;
  }
  
  private boolean r()
  {
    return "exp_shouq_dongtai_jianjie_B".equals(((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).getExpContentInSimpleUI(this.aF));
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.i = paramLayoutInflater.inflate(2131628752, null);
    l = true;
    return this.i;
  }
  
  public void a()
  {
    QLog.d("QzoneFrame", 1, "onCreate: ");
    super.a();
    this.k = ((ILebaPluginFeedApi)QRoute.api(ILebaPluginFeedApi.class)).getLebaPluginFeedController(P(), MobileQQ.sMobileQQ.waitAppRuntime(null), P());
    QZoneApiProxy.initEnv(P(), (QQAppInterface)this.aF);
    QZoneApiProxy.initServlet(P(), (QQAppInterface)this.aF);
    this.g = ((ViewGroup)this.i.findViewById(2131443655));
    this.f = ((ViewGroup)this.g.findViewById(2131443260));
    this.h = ((ViewGroup)this.i.findViewById(2131443648));
    if (r()) {
      localObject = "com.qzone.feed.ui.activity.QConciseDynamicFragment";
    } else {
      localObject = "com.qzone.feed.ui.activity.QQLebaFriendFeedFragment";
    }
    this.d = QZoneApiProxy.createLebaFragment(P(), (QQAppInterface)this.aF, (String)localObject);
    m = "com.qzone.feed.ui.activity.QQLebaFriendFeedFragment".equals(localObject);
    Object localObject = this.d;
    if (localObject != null)
    {
      ((QzoneFragmentImpl)localObject).setTitleView(this.f);
      this.d.onAttach(P());
      this.d.onCreate(null);
      localObject = this.d.onCreateView(P().getLayoutInflater(), null, null);
      if (localObject == null) {
        return;
      }
      this.h.addView((View)localObject);
      this.d.onActivityCreated(null);
      this.d.onStart();
    }
    if (this.j)
    {
      this.j = false;
    }
    else
    {
      localObject = this.d;
      if ((localObject instanceof QzoneFragmentImpl)) {
        ((QzoneFragmentImpl)localObject).forceRefresh();
      }
    }
    localObject = new IntentFilter(new IntentFilter(b));
    try
    {
      P().registerReceiver(this.c, (IntentFilter)localObject);
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
    Fragment localFragment = this.d;
    if (localFragment == null) {
      return;
    }
    localFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    Fragment localFragment = this.d;
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
    if (this.d == null) {
      return;
    }
    ViewGroup localViewGroup = this.g;
    if ((localViewGroup != null) && (localViewGroup.findViewById(2131436180) != null)) {
      this.g.findViewById(2131436180).setVisibility(8);
    }
    this.d.onResume();
    ApngImage.playByTag(4);
    FrameHelperActivity.c(true);
    if (FrameHelperActivity.G())
    {
      FrameHelperActivity.H();
      FrameHelperActivity.c(false);
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public void bQ_()
  {
    QLog.d("QzoneFrame", 1, "onPause: ");
    super.bQ_();
    Fragment localFragment = this.d;
    if (localFragment == null) {
      return;
    }
    localFragment.onPause();
    ApngImage.pauseByTag(4);
    FrameHelperActivity.c(true);
  }
  
  public void bS_()
  {
    QLog.d("QzoneFrame", 1, "onStart: ");
    super.bS_();
    Fragment localFragment = this.d;
    if (localFragment == null) {
      return;
    }
    this.e = false;
    localFragment.onStart();
  }
  
  public void c()
  {
    QLog.d("QzoneFrame", 1, "onStop: ");
    super.c();
    Fragment localFragment = this.d;
    if (localFragment == null) {
      return;
    }
    this.e = true;
    localFragment.onStop();
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSwitchToQzone:");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("QzoneFrame", 1, ((StringBuilder)localObject).toString());
    QzoneOnlineTimeCollectRptService.getInstance().beginTrace(0);
    ThreadManager.executeOnSubThread(new QzoneFrame.2(this));
    LpReportInfo_pf00064.allReport(637, 30, 1);
    LpReportInfo_pf00064.allReport(637, 31, 1);
    if (paramBoolean) {
      LebaTabRedTouch.f();
    } else {
      LpReportInfo_pf00064.allReport(637, 23, 2);
    }
    VideoReport.addToDetectionWhitelist(P());
    l();
    localObject = this.k;
    if (localObject != null) {
      ((ILebaPluginFeedController)localObject).b();
    }
  }
  
  public void cx_()
  {
    super.cx_();
    Fragment localFragment = this.d;
    if ((localFragment instanceof QzoneFragmentImpl)) {
      ((QzoneFragmentImpl)localFragment).forceRefresh();
    }
  }
  
  public boolean cz_()
  {
    return this.d != null;
  }
  
  public void d()
  {
    QLog.d("QzoneFrame", 1, "onDestroy: ");
    super.d();
    try
    {
      P().unregisterReceiver(this.c);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("registerReceiver");
      localStringBuilder.append(localException);
      QLog.e("QzoneFrame", 1, localStringBuilder.toString());
    }
    Fragment localFragment = this.d;
    if (localFragment == null) {
      return;
    }
    if (localFragment != null)
    {
      localFragment.onDestroy();
      this.d = null;
    }
    l = false;
    m = false;
  }
  
  public void f()
  {
    super.f();
    ILebaPluginFeedController localILebaPluginFeedController = this.k;
    if (localILebaPluginFeedController != null) {
      localILebaPluginFeedController.g();
    }
    QZoneApiProxy.onAccountChange(P(), (QQAppInterface)this.aF);
    a();
    a(false);
  }
  
  public void k()
  {
    super.k();
    ILebaPluginFeedController localILebaPluginFeedController = this.k;
    if (localILebaPluginFeedController != null) {
      localILebaPluginFeedController.h();
    }
    o();
  }
  
  void l()
  {
    ABTestController.a().a("exp_shouq_dongtai_jianjie_copy_copy").h();
  }
  
  public void m()
  {
    try
    {
      QzoneOnlineTimeCollectRptService.getInstance().closeTrace();
      ImmersiveUtils.setStatusTextColor(SimpleUIUtil.h(), P().getWindow());
      ImageLoader.getInstance().clear(false);
      if (this.d != null)
      {
        ((QzoneFragmentImpl)this.d).onSwitchOutofQzone();
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
  
  public void n()
  {
    ILebaPluginFeedController localILebaPluginFeedController = this.k;
    if (localILebaPluginFeedController != null) {
      localILebaPluginFeedController.i();
    }
    o();
    SimpleUIUtil.e = 0;
    SimpleUIUtil.f = 0;
    a();
  }
  
  public void o()
  {
    this.h.removeAllViews();
    this.f.removeAllViews();
    Fragment localFragment = this.d;
    if (localFragment != null) {
      localFragment.onDestroy();
    }
    localFragment = this.d;
    if ((localFragment instanceof QzoneFragmentImpl)) {
      ((QzoneFragmentImpl)localFragment).clearCache();
    }
    this.d = null;
    P().getIntent().putExtra("newflag", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.QzoneFrame
 * JD-Core Version:    0.7.0.1
 */