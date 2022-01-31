package com.tencent.mobileqq.app;

import ajwk;
import ajwm;
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
import aqhc;
import axrn;
import bbjc;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.Now;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.Constants.LogoutReason;

public class FrameFragment
  extends Fragment
  implements TabHost.OnTabChangeListener, TabHost.TabContentFactory, aqhc
{
  long jdField_a_of_type_Long = -1L;
  private ajwk jdField_a_of_type_Ajwk;
  protected View a;
  public QQTabHost a;
  private HashMap<String, TabHost.TabSpec> jdField_a_of_type_JavaUtilHashMap;
  private final Map<String, ajwk> jdField_a_of_type_JavaUtilMap = new HashMap(4);
  String f = null;
  protected boolean g;
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTab();
  }
  
  protected ajwk a()
  {
    return this.jdField_a_of_type_Ajwk;
  }
  
  public ajwk a(Class<? extends ajwk> paramClass)
  {
    ajwk localajwk = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localajwk = (ajwk)this.jdField_a_of_type_JavaUtilMap.get(paramClass.getName());
    }
    return localajwk;
  }
  
  protected String a()
  {
    ajwk localajwk = b();
    if (localajwk != null) {
      return localajwk.a();
    }
    return null;
  }
  
  public void a()
  {
    long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    Log.i("AutoMonitor", this.f + "TabSwitch, cost=" + l);
    if (QLog.isColorLevel()) {
      QLog.d("Q.PerfTrace", 2, this.f + "TabSwitch, cost=" + l);
    }
    axrn.a(BaseApplication.getContext()).a(bbjc.a(), "actSwitch" + this.f, true, l, 0L, null, null);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ajwk localajwk = b();
    if (localajwk != null) {
      localajwk.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void a(View paramView1, Class<? extends ajwk> paramClass, View paramView2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost = ((QQTabHost)paramView1.findViewById(16908306));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setup();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setOnTabChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setOnTabSelectionListener(new ajwm(this));
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
  
  protected void a(Class<? extends ajwk> paramClass)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      ajwk localajwk = a(paramClass);
      if (localajwk != null) {
        localajwk.j();
      }
      paramClass = paramClass.getName();
      this.jdField_a_of_type_JavaUtilMap.remove(paramClass);
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramClass);
      }
    }
  }
  
  protected void a(Constants.LogoutReason paramLogoutReason)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ajwk)localIterator.next()).a(paramLogoutReason);
    }
  }
  
  public ajwk b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FrameActivity", 2, "mTabHost=null");
      }
      return null;
    }
    return (ajwk)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getCurrentTabTag());
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameActivity", 2, "onAccountChanged");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ajwk)localIterator.next()).a();
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
      ((ajwk)localObject).a(getActivity());
      View localView = ((ajwk)localObject).a(getActivity().getLayoutInflater());
      ((ajwk)localObject).c(localView);
      ((ajwk)localObject).f();
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
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ajwk)localIterator.next()).a(paramConfiguration);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2131559203, null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ajwk)localIterator.next()).j();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((SplashActivity.a != 1) && (!this.g)) {}
    ajwk localajwk;
    do
    {
      return;
      localajwk = b();
    } while (localajwk == null);
    localajwk.h();
  }
  
  public void onResume()
  {
    super.onResume();
    if (SplashActivity.a != 1) {}
    ajwk localajwk;
    do
    {
      return;
      localajwk = b();
    } while ((localajwk == null) || (!localajwk.b()));
    localajwk.d(false);
  }
  
  public void onStart()
  {
    super.onStart();
    if (SplashActivity.a != 1) {}
    ajwk localajwk;
    do
    {
      return;
      localajwk = b();
    } while (localajwk == null);
    localajwk.g();
  }
  
  public void onStop()
  {
    super.onStop();
    if ((SplashActivity.a != 1) && (!this.g)) {}
    ajwk localajwk;
    do
    {
      return;
      localajwk = b();
    } while (localajwk == null);
    localajwk.i();
  }
  
  public void onTabChanged(String paramString)
  {
    if (paramString != null)
    {
      this.f = paramString;
      int i = paramString.lastIndexOf(".");
      if (i >= 0) {
        this.f = paramString.substring(i + 1, paramString.length());
      }
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost instanceof QQTabHost)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setFirstDrawTrue();
      }
    }
    if (this.jdField_a_of_type_Ajwk != null)
    {
      this.jdField_a_of_type_Ajwk.h();
      this.jdField_a_of_type_Ajwk.A();
    }
    this.jdField_a_of_type_Ajwk = b();
    if ((this.jdField_a_of_type_Ajwk != null) && (this.jdField_a_of_type_Ajwk.b())) {
      this.jdField_a_of_type_Ajwk.d(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameFragment
 * JD-Core Version:    0.7.0.1
 */