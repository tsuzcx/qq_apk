package com.tencent.mobileqq.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import anun;
import anup;
import auvj;
import bhgy;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.Now;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.Constants.LogoutReason;

public class FrameFragment
  extends ReportV4Fragment
  implements TabHost.OnTabChangeListener, TabHost.TabContentFactory, auvj
{
  long jdField_a_of_type_Long = -1L;
  protected View a;
  private anun jdField_a_of_type_Anun;
  public QQTabHost a;
  private HashMap<String, TabHost.TabSpec> jdField_a_of_type_JavaUtilHashMap;
  private final Map<String, anun> jdField_a_of_type_JavaUtilMap = new HashMap(4);
  String g;
  protected boolean g;
  
  public FrameFragment()
  {
    this.jdField_g_of_type_JavaLangString = null;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTab();
  }
  
  protected anun a()
  {
    return this.jdField_a_of_type_Anun;
  }
  
  public anun a(Class<? extends anun> paramClass)
  {
    anun localanun = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localanun = (anun)this.jdField_a_of_type_JavaUtilMap.get(paramClass.getName());
    }
    return localanun;
  }
  
  public String a()
  {
    anun localanun = b();
    if (localanun != null) {
      return localanun.a();
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    anun localanun = b();
    if (localanun != null) {
      localanun.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void a(View paramView1, Class<? extends anun> paramClass, View paramView2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost = ((QQTabHost)paramView1.findViewById(16908306));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setup();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setOnTabChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setOnTabSelectionListener(new anup(this));
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
    }
    String str = paramClass.getName();
    paramClass = (TabHost.TabSpec)this.jdField_a_of_type_JavaUtilHashMap.get(str);
    paramView1 = paramClass;
    if (paramClass == null)
    {
      paramView1 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.newTabSpec(str).setIndicator(paramView2).setContent(this);
      this.jdField_a_of_type_JavaUtilHashMap.put(str, paramView1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.addTab(paramView1);
  }
  
  protected void a(Class<? extends anun> paramClass)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      anun localanun = a(paramClass);
      if (localanun != null) {
        localanun.i();
      }
      paramClass = paramClass.getName();
      this.jdField_a_of_type_JavaUtilMap.remove(paramClass);
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramClass);
      }
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((anun)localIterator.next()).a(paramLogoutReason);
    }
  }
  
  public anun b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FrameActivity", 2, "mTabHost=null");
      }
      return null;
    }
    return (anun)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTabTag());
  }
  
  public void b()
  {
    long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    Log.i("AutoMonitor", this.jdField_g_of_type_JavaLangString + "TabSwitch, cost=" + l);
    if (QLog.isColorLevel()) {
      QLog.d("Q.PerfTrace", 2, this.jdField_g_of_type_JavaLangString + "TabSwitch, cost=" + l);
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(bhgy.a(), "actSwitch" + this.jdField_g_of_type_JavaLangString, true, l, 0L, null, null);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameActivity", 2, "onAccountChanged");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((anun)localIterator.next()).a();
    }
  }
  
  public View createTabContent(String paramString)
  {
    if (getActivity() == null) {
      if (QLog.isColorLevel()) {
        QLog.e("MainFragment", 2, "FrameFragment.createTabContent getActivity == null");
      }
    }
    for (;;)
    {
      return null;
      Object localObject;
      if (paramString.equals(Conversation.class.getName())) {
        localObject = new Conversation();
      }
      while (localObject != null)
      {
        ((anun)localObject).a(getActivity());
        View localView = ((anun)localObject).a(getActivity().getLayoutInflater());
        ((anun)localObject).c(localView);
        ((anun)localObject).e();
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
        return localView;
        if (paramString.equals(Contacts.class.getName())) {
          localObject = new Contacts();
        } else if (paramString.equals(Leba.class.getName())) {
          localObject = new Leba();
        } else if (paramString.equals(Now.class.getName())) {
          localObject = new Now();
        } else if (paramString.equals(ReadinjoyTabFrame.class.getName())) {
          localObject = new ReadinjoyTabFrame(this);
        } else if (paramString.equals(QzoneFrame.class.getName())) {
          localObject = new QzoneFrame();
        } else {
          localObject = null;
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((anun)localIterator.next()).a(paramConfiguration);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559382, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((anun)localIterator.next()).i();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((SplashActivity.a != 1) && (!this.jdField_g_of_type_Boolean)) {}
    anun localanun;
    do
    {
      return;
      localanun = b();
    } while (localanun == null);
    localanun.g();
  }
  
  public void onResume()
  {
    super.onResume();
    if (SplashActivity.a != 1) {}
    anun localanun;
    do
    {
      return;
      localanun = b();
    } while ((localanun == null) || (!localanun.b()));
    localanun.e(false);
  }
  
  public void onStart()
  {
    super.onStart();
    if (SplashActivity.a != 1) {}
    anun localanun;
    do
    {
      return;
      localanun = b();
    } while (localanun == null);
    localanun.f();
  }
  
  public void onStop()
  {
    super.onStop();
    if ((SplashActivity.a != 1) && (!this.jdField_g_of_type_Boolean)) {}
    anun localanun;
    do
    {
      return;
      localanun = b();
    } while (localanun == null);
    localanun.h();
  }
  
  public void onTabChanged(String paramString)
  {
    if (paramString != null)
    {
      this.jdField_g_of_type_JavaLangString = paramString;
      int i = paramString.lastIndexOf(".");
      if (i >= 0) {
        this.jdField_g_of_type_JavaLangString = paramString.substring(i + 1, paramString.length());
      }
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost instanceof QQTabHost)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setFirstDrawTrue();
      }
    }
    if (this.jdField_a_of_type_Anun != null)
    {
      this.jdField_a_of_type_Anun.g();
      this.jdField_a_of_type_Anun.D();
    }
    this.jdField_a_of_type_Anun = b();
    if ((this.jdField_a_of_type_Anun != null) && (this.jdField_a_of_type_Anun.b())) {
      this.jdField_a_of_type_Anun.e(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameFragment
 * JD-Core Version:    0.7.0.1
 */