package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Vibrator;
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
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class FrameFragment
  extends QBaseFragment
  implements TabHost.OnTabChangeListener, TabHost.TabContentFactory, OnDrawCompleteListener
{
  public static int a = 0;
  public static boolean d = true;
  public static boolean e = false;
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
  public String d = "";
  protected String e;
  public boolean g = false;
  public boolean h = true;
  protected boolean i = false;
  public boolean j = false;
  public boolean k = false;
  protected boolean l = false;
  public boolean m = false;
  
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
    QQTabHost localQQTabHost = this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost;
    if (localQQTabHost != null) {
      return localQQTabHost.getCurrentTab();
    }
    if (QLog.isColorLevel()) {
      QLog.e("FrameActivity", 2, "getCurrentTab");
    }
    return 0;
  }
  
  public Frame a()
  {
    QQTabHost localQQTabHost = this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost;
    if (localQQTabHost == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FrameActivity", 2, "mTabHost=null");
      }
      return null;
    }
    return (Frame)this.jdField_a_of_type_JavaUtilMap.get(localQQTabHost.getCurrentTabTag());
  }
  
  public Frame a(Class<? extends Frame> paramClass)
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null) {
      return (Frame)localMap.get(paramClass.getName());
    }
    return null;
  }
  
  public QBaseActivity a()
  {
    return super.getQBaseActivity();
  }
  
  public RedTouch a(String paramString)
  {
    return (RedTouch)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public HashMap<String, View> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a(int paramInt)
  {
    QQTabHost localQQTabHost = this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost;
    if (localQQTabHost != null) {
      localQQTabHost.setCurrentTab(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    if (localTabDragAnimationView != null)
    {
      if (this.h) {
        paramInt2 = -1;
      }
      localTabDragAnimationView.setFaceDrawable(paramInt2);
      if (this.h) {
        paramInt3 = -1;
      }
      localTabDragAnimationView.setFacePressedDrawable(paramInt3);
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
    paramView.setBackgroundResource(2130850362);
    int n = 0;
    for (;;)
    {
      paramView = this.jdField_a_of_type_ArrayOfAndroidViewView;
      if (n >= paramView.length) {
        break;
      }
      if (paramView[n] != null) {
        paramView[n].setBackgroundResource(2130850909);
      }
      n += 1;
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
    paramView2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    paramView2.b(paramView2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c(-1);
    paramView2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (Build.VERSION.SDK_INT < 24) {
      bool = false;
    }
    paramView2.setEnableBlur(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDisableBlurDrawableRes(2130840680);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new FrameFragment.2(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    if (!this.i) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    }
    paramView1.setBackgroundColor(0);
    int n = 0;
    for (;;)
    {
      paramView1 = this.jdField_a_of_type_ArrayOfAndroidViewView;
      if (n >= paramView1.length) {
        break;
      }
      if (paramView1[n] != null) {
        paramView1[n].setBackgroundColor(0);
      }
      n += 1;
    }
  }
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, IRedTouchManager paramIRedTouchManager) {}
  
  public void a(Class<? extends Frame> paramClass)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Object localObject = a(paramClass);
      if (localObject != null) {
        ((Frame)localObject).d();
      }
      paramClass = paramClass.getName();
      this.jdField_a_of_type_JavaUtilMap.remove(paramClass);
      localObject = this.jdField_c_of_type_JavaUtilHashMap;
      if (localObject != null) {
        ((HashMap)localObject).remove(paramClass);
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
      return localFrame.a();
    }
    return null;
  }
  
  public void b()
  {
    long l1 = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append("TabSwitch, cost=");
    ((StringBuilder)localObject).append(l1);
    Log.i("AutoMonitor", ((StringBuilder)localObject).toString());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append("TabSwitch, cost=");
      ((StringBuilder)localObject).append(l1);
      QLog.d("Q.PerfTrace", 2, ((StringBuilder)localObject).toString());
    }
    localObject = StatisticCollector.getInstance(BaseApplication.getContext());
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("actSwitch");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    ((StatisticCollector)localObject).collectPerformance(str, localStringBuilder.toString(), true, l1, 0L, null, null);
    localObject = a();
    if (localObject != null) {
      ((Frame)localObject).q();
    }
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).onDrawCompleteAfter(this);
  }
  
  public String c()
  {
    return this.e;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameActivity", 2, "onAccountChanged");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).f();
    }
  }
  
  public View createTabContent(String paramString)
  {
    if (a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FrameFragment", 2, "FrameFragment.createTabContent getActivity == null");
      }
      return null;
    }
    if (a().getAppRuntime() == null)
    {
      QLog.e("FrameFragment", 1, "FrameFragment.createTabContent appRuntime == null");
      return null;
    }
    Frame localFrame = ((ITabFrameController)QRoute.api(ITabFrameController.class)).buildFrame(this, paramString);
    if (localFrame == null) {
      return null;
    }
    localFrame.a(a());
    View localView = localFrame.a(a().getLayoutInflater());
    localFrame.a(localView);
    localFrame.a();
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
    QQBlurView localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (localQQBlurView != null) {
      localQQBlurView.b();
    }
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).doFramesPauseAfter(this);
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setCurrentIntentParams(this);
  }
  
  protected void o()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (localObject != null) {
      ((QQBlurView)localObject).c();
    }
    localObject = this.jdField_a_of_type_JavaLangRunnable;
    this.jdField_a_of_type_JavaLangRunnable = null;
    ThreadManager.getSubThreadHandler().removeCallbacks((Runnable)localObject);
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131559323, null);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).d();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((((ITabFrameController)QRoute.api(ITabFrameController.class)).isFragmentNotMatch()) && (!this.l)) {
      return;
    }
    Frame localFrame = a();
    if (localFrame != null) {
      localFrame.ab_();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (((ITabFrameController)QRoute.api(ITabFrameController.class)).isFragmentNotMatch()) {
      return;
    }
    Frame localFrame = a();
    if ((localFrame != null) && (localFrame.b())) {
      localFrame.a(false);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (((ITabFrameController)QRoute.api(ITabFrameController.class)).isFragmentNotMatch()) {
      return;
    }
    Frame localFrame = a();
    if (localFrame != null) {
      localFrame.V_();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if ((((ITabFrameController)QRoute.api(ITabFrameController.class)).isFragmentNotMatch()) && (!this.l)) {
      return;
    }
    Frame localFrame = a();
    if (localFrame != null) {
      localFrame.c();
    }
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
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost;
      if ((localObject1 instanceof QQTabHost)) {
        ((QQTabHost)localObject1).setFirstDrawTrue();
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFrame;
    if (localObject1 != null)
    {
      ((Frame)localObject1).ab_();
      this.jdField_a_of_type_ComTencentMobileqqAppFrame.C();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFrame;
    this.jdField_a_of_type_ComTencentMobileqqAppFrame = a();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFrame;
    if ((localObject2 != null) && (((Frame)localObject2).b())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrame.a(true);
    }
    localObject2 = this.e;
    this.e = paramString;
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateUIAfterTabChange(this, paramString, (String)localObject2, (Frame)localObject1);
  }
  
  protected void p()
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).onResumeUpdateSound(this);
  }
  
  public void q()
  {
    Frame localFrame = a();
    if (localFrame != null) {
      localFrame.C();
    }
  }
  
  public void r()
  {
    QQBlurView localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (localQQBlurView != null)
    {
      localQQBlurView.b();
      this.i = true;
    }
  }
  
  public void s()
  {
    QQBlurView localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (localQQBlurView != null)
    {
      localQQBlurView.a();
      this.i = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameFragment
 * JD-Core Version:    0.7.0.1
 */