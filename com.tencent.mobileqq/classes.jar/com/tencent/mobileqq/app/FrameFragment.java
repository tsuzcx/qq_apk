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
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.Now;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.mobileqq.leba.LebaWithFeeds;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.Constants.LogoutReason;
import zdf;

public class FrameFragment
  extends Fragment
  implements TabHost.OnTabChangeListener, TabHost.TabContentFactory, OnDrawCompleteListener
{
  long jdField_a_of_type_Long = -1L;
  public View a;
  private Frame jdField_a_of_type_ComTencentMobileqqAppFrame;
  public QQTabHost a;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private final Map jdField_a_of_type_JavaUtilMap = new HashMap(4);
  String b = null;
  public boolean e;
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTab();
  }
  
  public Frame a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFrame;
  }
  
  public Frame a(Class paramClass)
  {
    Frame localFrame = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localFrame = (Frame)this.jdField_a_of_type_JavaUtilMap.get(paramClass.getName());
    }
    return localFrame;
  }
  
  public String a()
  {
    Frame localFrame = b();
    if (localFrame != null) {
      return localFrame.a();
    }
    return null;
  }
  
  public void a()
  {
    long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    Log.i("AutoMonitor", this.b + "TabSwitch, cost=" + l);
    if (QLog.isColorLevel()) {
      QLog.d("Q.PerfTrace", 2, this.b + "TabSwitch, cost=" + l);
    }
    StatisticCollector.a(BaseApplication.getContext()).a(QQUtils.a(), "actSwitch" + this.b, true, l, 0L, null, null);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Frame localFrame = b();
    if (localFrame != null) {
      localFrame.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(View paramView1, Class paramClass, View paramView2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost = ((QQTabHost)paramView1.findViewById(16908306));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setup();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setOnTabChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setOnTabSelectionListener(new zdf(this));
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
  
  public void a(Class paramClass)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Frame localFrame = a(paramClass);
      if (localFrame != null) {
        localFrame.k();
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
      ((Frame)localIterator.next()).a(paramLogoutReason);
    }
  }
  
  public Frame b()
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
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameActivity", 2, "onAccountChanged");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Frame)localIterator.next()).c();
    }
  }
  
  public View createTabContent(String paramString)
  {
    Object localObject = null;
    if (getActivity() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MainFragment", 2, "FrameFragment.createTabContent getActivity == null");
      }
      return null;
    }
    if (paramString.equals(Conversation.class.getName())) {
      localObject = new Conversation();
    }
    for (;;)
    {
      ((Frame)localObject).a(getActivity());
      View localView = ((Frame)localObject).a(getActivity().getLayoutInflater());
      ((Frame)localObject).c(localView);
      ((Frame)localObject).g();
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
      return localView;
      if (paramString.equals(Contacts.class.getName())) {
        localObject = new Contacts();
      } else if (paramString.equals(Leba.class.getName())) {
        localObject = new Leba();
      } else if (paramString.equals(Now.class.getName())) {
        localObject = new Now();
      } else if (paramString.equals(ReadinjoyTabFrame.class.getName())) {
        localObject = new ReadinjoyTabFrame();
      } else if (paramString.equals(LebaWithFeeds.class.getName())) {
        localObject = new LebaWithFeeds();
      }
    }
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
    return paramLayoutInflater.inflate(2130969062, null);
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
    if ((SplashActivity.a != 1) && (!this.e)) {}
    Frame localFrame;
    do
    {
      return;
      localFrame = b();
    } while (localFrame == null);
    localFrame.i();
  }
  
  public void onResume()
  {
    super.onResume();
    if (SplashActivity.a != 1) {}
    Frame localFrame;
    do
    {
      return;
      localFrame = b();
    } while ((localFrame == null) || (!localFrame.b()));
    localFrame.a(false);
  }
  
  public void onStart()
  {
    super.onStart();
    if (SplashActivity.a != 1) {}
    Frame localFrame;
    do
    {
      return;
      localFrame = b();
    } while (localFrame == null);
    localFrame.h();
  }
  
  public void onStop()
  {
    super.onStop();
    if ((SplashActivity.a != 1) && (!this.e)) {}
    Frame localFrame;
    do
    {
      return;
      localFrame = b();
    } while (localFrame == null);
    localFrame.j();
  }
  
  public void onTabChanged(String paramString)
  {
    if (paramString != null)
    {
      this.b = paramString;
      int i = paramString.lastIndexOf(".");
      if (i >= 0) {
        this.b = paramString.substring(i + 1, paramString.length());
      }
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost instanceof QQTabHost)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setFirstDrawTrue();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrame != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFrame.i();
      this.jdField_a_of_type_ComTencentMobileqqAppFrame.v();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFrame = b();
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFrame != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrame.b())) {
      this.jdField_a_of_type_ComTencentMobileqqAppFrame.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameFragment
 * JD-Core Version:    0.7.0.1
 */