package com.tencent.mobileqq.ark.debug;

import aaym;
import aayn;
import aayo;
import aayr;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.ark.ArkActionAppMgr;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ArkIDESettingFragment
  extends IphoneTitleBarFragment
{
  public static ArkIDESettingFragment a;
  QQAppInterface a;
  
  public ArkIDESettingFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime());
  }
  
  public static ArkIDESettingFragment a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArkDebugArkIDESettingFragment == null) {
      jdField_a_of_type_ComTencentMobileqqArkDebugArkIDESettingFragment = new ArkIDESettingFragment();
    }
    return jdField_a_of_type_ComTencentMobileqqArkDebugArkIDESettingFragment;
  }
  
  public static String a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localQQAppInterface == null) {
      return "";
    }
    return localQQAppInterface.getCurrentAccountUin();
  }
  
  public static void a(String paramString)
  {
    SharePreferenceUtils.a(BaseApplication.getContext(), "ark_ide_state_" + a(), paramString);
  }
  
  public static String b()
  {
    return SharePreferenceUtils.a(BaseApplication.getContext(), "ark_ide_state_" + a()).toString();
  }
  
  protected int a()
  {
    return 2130970204;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    a("轻应用设置");
    b();
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  void b()
  {
    FormSwitchItem localFormSwitchItem1 = (FormSwitchItem)this.e.findViewById(2131369541);
    FormSwitchItem localFormSwitchItem2 = (FormSwitchItem)this.e.findViewById(2131369542);
    View localView1 = this.e.findViewById(2131369543);
    View localView2 = this.e.findViewById(2131369544);
    localFormSwitchItem1.setChecked(true);
    localFormSwitchItem1.setOnCheckedChangeListener(new aaym(this));
    if ((!TextUtils.isEmpty(b())) && (b().equals("close")))
    {
      localFormSwitchItem2.setChecked(false);
      ArkAppCenter.b("ArkApp.DebugOnlineActivity", String.format("btnSetupIDE is closed and idestate=%s", new Object[] { b() }));
    }
    for (;;)
    {
      localFormSwitchItem2.setOnCheckedChangeListener(new aayn(this));
      localView1.setOnClickListener(new aayo(this));
      localView2.setOnClickListener(new aayr(this));
      return;
      localFormSwitchItem2.setChecked(true);
      c();
      ArkAppCenter.b("ArkApp.DebugOnlineActivity", String.format("btnSetupIDE is open", new Object[0]));
    }
  }
  
  public void b(String paramString)
  {
    int i = this.e.getHeight();
    QQToast.a(BaseApplication.getContext(), paramString, 0).b(i - 20);
  }
  
  public void c()
  {
    long l = NetConnInfoCenter.getServerTime();
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = localRecentUserProxy.a(AppConstants.aD, 1031);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    localRecentUserProxy.a(localRecentUser);
    localRecentUserProxy.b(localRecentUser);
  }
  
  public void d()
  {
    long l = NetConnInfoCenter.getServerTime();
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = localRecentUserProxy.a(AppConstants.aD, 1031);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    localRecentUserProxy.b(localRecentUser);
    localRecentUserProxy.c(localRecentUser);
  }
  
  public void e()
  {
    ArkLocalAppMgr.d();
    ((ArkAppCenter)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(120)).a().b();
    ArkAppCenter.b("ArkApp.DebugOnlineActivity", String.format("App is clear", new Object[0]));
  }
  
  public void f()
  {
    ArkAppCenter localArkAppCenter = (ArkAppCenter)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(120);
    ArkAppCenter.d();
    ArkAppCenter.b("ArkApp.DebugOnlineActivity", String.format("AppData is clear", new Object[0]));
  }
  
  public void g()
  {
    ArkAppCenter localArkAppCenter = (ArkAppCenter)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(120);
    localArkAppCenter.a().b();
    localArkAppCenter.a().a();
    ArkAppCenter.b("ArkApp.DebugOnlineActivity", String.format("Dict is clear", new Object[0]));
  }
  
  public void h()
  {
    ArkAppCenter localArkAppCenter = (ArkAppCenter)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(120);
    ArkAppCenter.c();
    ArkAppCenter.b("ArkApp.DebugOnlineActivity", String.format("HttpCache is clear", new Object[0]));
  }
  
  public void i()
  {
    ((ArkAppCenter)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(120)).a().e();
    ArkAppCenter.b("ArkApp.DebugOnlineActivity", String.format("Action is clear", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.ArkIDESettingFragment
 * JD-Core Version:    0.7.0.1
 */