package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
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
  public static boolean m = true;
  public static int n = 0;
  public static boolean o = false;
  public static boolean p = true;
  public AppRuntime A;
  public SparseArray<TabDragAnimationView> B = null;
  public SparseArray<TextView> C = null;
  long D = -1L;
  String E = null;
  public Intent F = null;
  public HashMap<String, View> G = null;
  public String H = "";
  public String I = "";
  public boolean J = true;
  public QQBlurView K;
  protected boolean L = false;
  public SharedPreferences M = null;
  public boolean N = false;
  protected String O;
  public boolean P = false;
  public DragFrameLayout Q;
  public HashMap<String, Object> R = null;
  public long S;
  protected Vibrator T;
  public Runnable U = new FrameFragment.1(this);
  public HashMap<String, TabHost.TabSpec> V;
  public View W;
  protected boolean X = false;
  public boolean Y = false;
  public MqqHandler Z;
  private final Map<String, Frame> a = new HashMap(4);
  public TabFrameControllerImpl.FrameDoubleTapListener aa = new TabFrameControllerImpl.FrameDoubleTapListener(this);
  private Frame b;
  public Handler q;
  public Intent r = null;
  public QQTabHost s;
  public View t;
  public ArrayList<TabHost.TabSpec> u = new ArrayList();
  public ArrayList<TabHost.TabSpec> v = new ArrayList();
  public boolean w = false;
  public boolean x = false;
  public boolean y = false;
  public View[] z = null;
  
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
  
  public void A()
  {
    QQBlurView localQQBlurView = this.K;
    if (localQQBlurView != null)
    {
      localQQBlurView.b();
      this.L = true;
    }
  }
  
  public void B()
  {
    QQBlurView localQQBlurView = this.K;
    if (localQQBlurView != null)
    {
      localQQBlurView.a();
      this.L = false;
    }
  }
  
  public QBaseActivity C()
  {
    return super.getQBaseActivity();
  }
  
  public Frame a(Class<? extends Frame> paramClass)
  {
    Map localMap = this.a;
    if (localMap != null) {
      return (Frame)localMap.get(paramClass.getName());
    }
    return null;
  }
  
  public RedTouch a(String paramString)
  {
    return (RedTouch)this.G.get(paramString);
  }
  
  public void a(int paramInt)
  {
    QQTabHost localQQTabHost = this.s;
    if (localQQTabHost != null) {
      localQQTabHost.setCurrentTab(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)this.B.get(paramInt1);
    if (localTabDragAnimationView != null)
    {
      if (this.J) {
        paramInt2 = -1;
      }
      localTabDragAnimationView.setFaceDrawable(paramInt2);
      if (this.J) {
        paramInt3 = -1;
      }
      localTabDragAnimationView.setFacePressedDrawable(paramInt3);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Frame localFrame = v();
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
    paramView.setBackgroundResource(2130852153);
    int i = 0;
    for (;;)
    {
      paramView = this.z;
      if (i >= paramView.length) {
        break;
      }
      if (paramView[i] != null) {
        paramView[i].setBackgroundResource(2130852761);
      }
      i += 1;
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
    this.K.setVisibility(0);
    this.K.a(paramView2);
    paramView2 = this.K;
    paramView2.b(paramView2);
    this.K.a(8);
    this.K.c(-1);
    paramView2 = this.K;
    if (Build.VERSION.SDK_INT < 24) {
      bool = false;
    }
    paramView2.setEnableBlur(bool);
    this.K.setDisableBlurDrawableRes(2130841458);
    if (QQTheme.isSimpleWhite()) {
      this.K.a(new ColorDrawable(Color.parseColor("#E5FFFFFF")));
    } else {
      this.K.a(new ColorDrawable(Color.parseColor("#DAFAFAFC")));
    }
    this.K.a(new FrameFragment.2(this));
    this.K.d();
    if (!this.L) {
      this.K.a();
    }
    paramView1.setBackgroundColor(0);
    int i = 0;
    for (;;)
    {
      paramView1 = this.z;
      if (i >= paramView1.length) {
        break;
      }
      if (paramView1[i] != null) {
        paramView1[i].setBackgroundColor(0);
      }
      i += 1;
    }
  }
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, IRedTouchManager paramIRedTouchManager) {}
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).a(paramLogoutReason);
    }
  }
  
  public void b(Class<? extends Frame> paramClass)
  {
    if (this.a != null)
    {
      Object localObject = a(paramClass);
      if (localObject != null) {
        ((Frame)localObject).d();
      }
      paramClass = paramClass.getName();
      this.a.remove(paramClass);
      localObject = this.V;
      if (localObject != null) {
        ((HashMap)localObject).remove(paramClass);
      }
    }
  }
  
  public View createTabContent(String paramString)
  {
    if (C() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FrameFragment", 2, "FrameFragment.createTabContent getActivity == null");
      }
      return null;
    }
    if (C().getAppRuntime() == null)
    {
      QLog.e("FrameFragment", 1, "FrameFragment.createTabContent appRuntime == null");
      return null;
    }
    Frame localFrame = ((ITabFrameController)QRoute.api(ITabFrameController.class)).buildFrame(this, paramString);
    if (localFrame == null) {
      return null;
    }
    localFrame.a(C());
    View localView = localFrame.a(C().getLayoutInflater());
    localFrame.a(localView);
    localFrame.a();
    this.a.put(paramString, localFrame);
    return localView;
  }
  
  public void d()
  {
    long l = SystemClock.uptimeMillis() - this.D;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.E);
    ((StringBuilder)localObject).append("TabSwitch, cost=");
    ((StringBuilder)localObject).append(l);
    Log.i("AutoMonitor", ((StringBuilder)localObject).toString());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.E);
      ((StringBuilder)localObject).append("TabSwitch, cost=");
      ((StringBuilder)localObject).append(l);
      QLog.d("Q.PerfTrace", 2, ((StringBuilder)localObject).toString());
    }
    localObject = StatisticCollector.getInstance(BaseApplication.getContext());
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("actSwitch");
    localStringBuilder.append(this.E);
    ((StatisticCollector)localObject).collectPerformance(str, localStringBuilder.toString(), true, l, 0L, null, null);
    localObject = v();
    if (localObject != null) {
      ((Frame)localObject).v();
    }
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).onDrawCompleteAfter(this);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameActivity", 2, "onAccountChanged");
    }
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).f();
    }
  }
  
  public String getCIOPageName()
  {
    if (v() != null) {
      return v().getClass().getName();
    }
    return super.getCIOPageName();
  }
  
  protected void k()
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).handleThemeChanged(this);
  }
  
  public String l()
  {
    Frame localFrame = v();
    if (localFrame != null) {
      return localFrame.cy_();
    }
    return null;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).a(paramConfiguration);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131625273, null);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).d();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((((ITabFrameController)QRoute.api(ITabFrameController.class)).isFragmentNotMatch()) && (!this.X)) {
      return;
    }
    Frame localFrame = v();
    if (localFrame != null) {
      localFrame.bQ_();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (((ITabFrameController)QRoute.api(ITabFrameController.class)).isFragmentNotMatch()) {
      return;
    }
    Frame localFrame = v();
    if ((localFrame != null) && (localFrame.cz_())) {
      localFrame.a(false);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (((ITabFrameController)QRoute.api(ITabFrameController.class)).isFragmentNotMatch()) {
      return;
    }
    Frame localFrame = v();
    if (localFrame != null) {
      localFrame.bS_();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if ((((ITabFrameController)QRoute.api(ITabFrameController.class)).isFragmentNotMatch()) && (!this.X)) {
      return;
    }
    Frame localFrame = v();
    if (localFrame != null) {
      localFrame.c();
    }
  }
  
  public void onTabChanged(String paramString)
  {
    if (paramString != null)
    {
      this.E = paramString;
      int i = paramString.lastIndexOf(".");
      if (i >= 0) {
        this.E = paramString.substring(i + 1, paramString.length());
      }
      this.D = SystemClock.uptimeMillis();
      localObject1 = this.s;
      if ((localObject1 instanceof QQTabHost)) {
        ((QQTabHost)localObject1).setFirstDrawTrue();
      }
    }
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      ((Frame)localObject1).bQ_();
      this.b.S();
    }
    localObject1 = this.b;
    this.b = v();
    Object localObject2 = this.b;
    if ((localObject2 != null) && (((Frame)localObject2).cz_())) {
      this.b.a(true);
    }
    localObject2 = this.O;
    this.O = paramString;
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateUIAfterTabChange(this, paramString, (String)localObject2, (Frame)localObject1);
  }
  
  protected void r()
  {
    QQBlurView localQQBlurView = this.K;
    if (localQQBlurView != null) {
      localQQBlurView.b();
    }
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).doFramesPauseAfter(this);
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setCurrentIntentParams(this);
  }
  
  protected void s()
  {
    Object localObject = this.K;
    if (localObject != null) {
      ((QQBlurView)localObject).c();
    }
    localObject = this.U;
    this.U = null;
    ThreadManager.getSubThreadHandler().removeCallbacks((Runnable)localObject);
  }
  
  protected void t()
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).onResumeUpdateSound(this);
  }
  
  public boolean u()
  {
    boolean bool = "2971".equals(QQTheme.getCurrentThemeId());
    return (this.J) || (bool);
  }
  
  public Frame v()
  {
    QQTabHost localQQTabHost = this.s;
    if (localQQTabHost == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FrameActivity", 2, "mTabHost=null");
      }
      return null;
    }
    return (Frame)this.a.get(localQQTabHost.getCurrentTabTag());
  }
  
  public int w()
  {
    QQTabHost localQQTabHost = this.s;
    if (localQQTabHost != null) {
      return localQQTabHost.getCurrentTab();
    }
    if (QLog.isColorLevel()) {
      QLog.e("FrameActivity", 2, "getCurrentTab");
    }
    return 0;
  }
  
  public void x()
  {
    Frame localFrame = v();
    if (localFrame != null) {
      localFrame.S();
    }
  }
  
  public HashMap<String, View> y()
  {
    return this.G;
  }
  
  public String z()
  {
    return this.O;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameFragment
 * JD-Core Version:    0.7.0.1
 */