package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl.FrameDoubleTapListener;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class FrameFragment
  extends ReportV4Fragment
  implements TabHost.OnTabChangeListener, TabHost.TabContentFactory, OnDrawCompleteListener
{
  public static int a;
  public static boolean d;
  public static boolean e;
  public static boolean f = true;
  long jdField_a_of_type_Long = -1L;
  public Intent a;
  public SharedPreferences a;
  public Handler a;
  protected Vibrator a;
  public SparseArray<TabDragAnimationView> a;
  public View a;
  public TabFrameControllerImpl.FrameDoubleTapListener a;
  public DragFrameLayout a;
  private Frame jdField_a_of_type_ComTencentMobileqqAppFrame;
  public QQBlurView a;
  public QQTabHost a;
  public Runnable a;
  public HashMap<String, View> a;
  private final Map<String, Frame> jdField_a_of_type_JavaUtilMap = new HashMap(4);
  public AppRuntime a;
  public MqqHandler a;
  public View[] a;
  public long b;
  public Intent b;
  public SparseArray<TextView> b;
  String b;
  public HashMap<String, Object> b;
  public String c;
  public HashMap<String, TabHost.TabSpec> c;
  public String d;
  protected String e;
  public boolean g = false;
  public boolean h = true;
  protected boolean i = false;
  public boolean j = false;
  public boolean k = false;
  protected boolean l = false;
  public boolean m = false;
  
  static
  {
    jdField_d_of_type_Boolean = true;
    jdField_a_of_type_Int = 0;
    jdField_e_of_type_Boolean = false;
  }
  
  public FrameFragment()
  {
    this.jdField_a_of_type_AndroidContentIntent = null;
    this.jdField_a_of_type_ArrayOfAndroidViewView = null;
    this.jdField_a_of_type_AndroidUtilSparseArray = null;
    this.jdField_b_of_type_AndroidUtilSparseArray = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_AndroidContentIntent = null;
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentSharedPreferences = null;
    this.jdField_b_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_JavaLangRunnable = new FrameFragment.1(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeImplTabFrameControllerImpl$FrameDoubleTapListener = new TabFrameControllerImpl.FrameDoubleTapListener(this);
  }
  
  private String a()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppRuntime == null) {
      return "0";
    }
    if (localAppRuntime.getAccount() == null) {
      return "0";
    }
    return localAppRuntime.getAccount();
  }
  
  public static View[] a(LayoutInflater paramLayoutInflater)
  {
    return ((ITabFrameController)QRoute.api(ITabFrameController.class)).getTabViews(paramLayoutInflater);
  }
  
  public int a()
  {
    int n = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
      n = this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTab();
    }
    while (!QLog.isColorLevel()) {
      return n;
    }
    QLog.e("FrameActivity", 2, "getCurrentTab");
    return 0;
  }
  
  public Frame a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FrameActivity", 2, "mTabHost=null");
      }
      return null;
    }
    return (Frame)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTabTag());
  }
  
  public Frame a(Class<? extends Frame> paramClass)
  {
    Frame localFrame = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localFrame = (Frame)this.jdField_a_of_type_JavaUtilMap.get(paramClass.getName());
    }
    return localFrame;
  }
  
  public RedTouch a(String paramString)
  {
    return (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public QQTabHost a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost;
  }
  
  public HashMap<String, View> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setCurrentTab(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int n = -1;
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    if (localTabDragAnimationView != null)
    {
      if (this.h) {
        paramInt2 = -1;
      }
      localTabDragAnimationView.setFaceDrawable(paramInt2);
      if (!this.h) {
        break label53;
      }
    }
    label53:
    for (paramInt1 = n;; paramInt1 = paramInt3)
    {
      localTabDragAnimationView.setFacePressedDrawable(paramInt1);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Frame localFrame = a();
    if (localFrame != null) {
      localFrame.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateFrames(this, paramInt1, paramInt2, paramObject);
  }
  
  public void a(Intent paramIntent)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).doOnEntry(this, paramIntent);
  }
  
  public void a(View paramView)
  {
    if (paramView == null)
    {
      QLog.e("FrameActivity", 1, "disableBlur: tabWidget == null");
      return;
    }
    paramView.setBackgroundResource(2130850435);
    int n = 0;
    label21:
    if (n < this.jdField_a_of_type_ArrayOfAndroidViewView.length) {
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[n] != null) {
        break label46;
      }
    }
    for (;;)
    {
      n += 1;
      break label21;
      break;
      label46:
      this.jdField_a_of_type_ArrayOfAndroidViewView[n].setBackgroundResource(2130850969);
    }
  }
  
  public void a(View paramView1, View paramView2)
  {
    boolean bool = true;
    if (paramView1 == null)
    {
      QLog.e("FrameActivity", 1, "enableBlur: tabWidget == null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(paramView2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c(-1);
    paramView2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    label73:
    int n;
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramView2.setEnableBlur(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDisableBlurDrawableRes(2130840805);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new FrameFragment.2(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      if (!this.i) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      }
      paramView1.setBackgroundColor(0);
      n = 0;
      label132:
      if (n < this.jdField_a_of_type_ArrayOfAndroidViewView.length) {
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[n] != null) {
          break label163;
        }
      }
    }
    for (;;)
    {
      n += 1;
      break label132;
      break;
      bool = false;
      break label73;
      label163:
      this.jdField_a_of_type_ArrayOfAndroidViewView[n].setBackgroundColor(0);
    }
  }
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, RedTouchManager paramRedTouchManager) {}
  
  public void a(Class<? extends Frame> paramClass)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Frame localFrame = a(paramClass);
      if (localFrame != null) {
        localFrame.k();
      }
      paramClass = paramClass.getName();
      this.jdField_a_of_type_JavaUtilMap.remove(paramClass);
      if (this.jdField_c_of_type_JavaUtilHashMap != null) {
        this.jdField_c_of_type_JavaUtilHashMap.remove(paramClass);
      }
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).a(paramLogoutReason);
    }
  }
  
  public boolean a()
  {
    return this.h;
  }
  
  public String b()
  {
    Frame localFrame = a();
    if (localFrame != null) {
      return localFrame.a_();
    }
    return null;
  }
  
  public void b()
  {
    long l1 = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    Log.i("AutoMonitor", this.jdField_b_of_type_JavaLangString + "TabSwitch, cost=" + l1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.PerfTrace", 2, this.jdField_b_of_type_JavaLangString + "TabSwitch, cost=" + l1);
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(a(), "actSwitch" + this.jdField_b_of_type_JavaLangString, true, l1, 0L, null, null);
    Frame localFrame = a();
    if (localFrame != null) {
      localFrame.r();
    }
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).onDrawCompleteAfter(this);
  }
  
  public String c()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameActivity", 2, "onAccountChanged");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).l();
    }
  }
  
  public View createTabContent(String paramString)
  {
    if (getActivity() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FrameFragment", 2, "FrameFragment.createTabContent getActivity == null");
      }
      return null;
    }
    if (getActivity().getAppRuntime() == null)
    {
      QLog.e("FrameFragment", 1, "FrameFragment.createTabContent appRuntime == null");
      return null;
    }
    Frame localFrame = ((ITabFrameController)QRoute.api(ITabFrameController.class)).buildFrame(this, paramString);
    if (localFrame == null) {
      return null;
    }
    localFrame.a(getActivity());
    View localView = localFrame.a(getActivity().getLayoutInflater());
    localFrame.b(localView);
    localFrame.f();
    this.jdField_a_of_type_JavaUtilMap.put(paramString, localFrame);
    return localView;
  }
  
  public String getCIOPageName()
  {
    if (a() != null) {
      return a().getClass().getName();
    }
    return super.getCIOPageName();
  }
  
  protected void h()
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).handleThemeChanged(this);
  }
  
  protected void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
    }
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).doFramesPauseAfter(this);
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setCurrentIntentParams(this);
  }
  
  protected void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
    }
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    this.jdField_a_of_type_JavaLangRunnable = null;
    ThreadManager.getSubThreadHandler().removeCallbacks(localRunnable);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).a(paramConfiguration);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559449, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).k();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((((ITabFrameController)QRoute.api(ITabFrameController.class)).isFragmentNotMatch()) && (!this.l)) {}
    Frame localFrame;
    do
    {
      return;
      localFrame = a();
    } while (localFrame == null);
    localFrame.n();
  }
  
  public void onResume()
  {
    super.onResume();
    if (((ITabFrameController)QRoute.api(ITabFrameController.class)).isFragmentNotMatch()) {}
    Frame localFrame;
    do
    {
      return;
      localFrame = a();
    } while ((localFrame == null) || (!localFrame.e_()));
    localFrame.b(false);
  }
  
  public void onStart()
  {
    super.onStart();
    if (((ITabFrameController)QRoute.api(ITabFrameController.class)).isFragmentNotMatch()) {}
    Frame localFrame;
    do
    {
      return;
      localFrame = a();
    } while (localFrame == null);
    localFrame.e();
  }
  
  public void onStop()
  {
    super.onStop();
    if ((((ITabFrameController)QRoute.api(ITabFrameController.class)).isFragmentNotMatch()) && (!this.l)) {}
    Frame localFrame;
    do
    {
      return;
      localFrame = a();
    } while (localFrame == null);
    localFrame.h();
  }
  
  public void onTabChanged(String paramString)
  {
    if (paramString != null)
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      int n = paramString.lastIndexOf(".");
      if (n >= 0) {
        this.jdField_b_of_type_JavaLangString = paramString.substring(n + 1, paramString.length());
      }
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost instanceof QQTabHost)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setFirstDrawTrue();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrame != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFrame.n();
      this.jdField_a_of_type_ComTencentMobileqqAppFrame.D();
    }
    Frame localFrame = this.jdField_a_of_type_ComTencentMobileqqAppFrame;
    this.jdField_a_of_type_ComTencentMobileqqAppFrame = a();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrame.e_())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrame.b(true);
    }
    String str = this.jdField_e_of_type_JavaLangString;
    this.jdField_e_of_type_JavaLangString = paramString;
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateUIAfterTabChange(this, paramString, str, localFrame);
  }
  
  protected void p()
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).onResumeUpdateSound(this);
  }
  
  public void q()
  {
    Frame localFrame = a();
    if (localFrame != null) {
      localFrame.D();
    }
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
      this.i = true;
    }
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      this.i = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameFragment
 * JD-Core Version:    0.7.0.1
 */