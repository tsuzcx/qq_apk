package com.tencent.mobileqq.ark.debug;

import ajsf;
import ajyc;
import aktg;
import alqy;
import aluw;
import alux;
import aluy;
import alvb;
import alve;
import alvf;
import alvg;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bbaj;
import bcpw;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;

public class ArkIDESettingFragment
  extends IphoneTitleBarFragment
{
  public static ArkIDESettingFragment a;
  private TextView a;
  
  public static ArkIDESettingFragment a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArkDebugArkIDESettingFragment == null) {
      jdField_a_of_type_ComTencentMobileqqArkDebugArkIDESettingFragment = new ArkIDESettingFragment();
    }
    return jdField_a_of_type_ComTencentMobileqqArkDebugArkIDESettingFragment;
  }
  
  private void a(int paramInt)
  {
    alvg.a(paramInt, new alvf(this));
  }
  
  protected QQAppInterface a()
  {
    return (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
  }
  
  public String a()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("appinterface is null", new Object[0]));
      return "";
    }
    return localQQAppInterface.getCurrentAccountUin();
  }
  
  void a()
  {
    FormSwitchItem localFormSwitchItem1 = (FormSwitchItem)this.mContentView.findViewById(2131363660);
    FormSwitchItem localFormSwitchItem2 = (FormSwitchItem)this.mContentView.findViewById(2131363662);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131368757));
    View localView1 = this.mContentView.findViewById(2131363496);
    View localView2 = this.mContentView.findViewById(2131363495);
    View localView3 = this.mContentView.findViewById(2131363694);
    localFormSwitchItem1.setChecked(true);
    localFormSwitchItem1.setOnCheckedChangeListener(new aluw(this));
    if ((!TextUtils.isEmpty(b())) && (b().equals("close")))
    {
      localFormSwitchItem2.setChecked(false);
      ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("btnSetupIDE is closed and idestate=%s", new Object[] { b() }));
    }
    for (;;)
    {
      localFormSwitchItem2.setOnCheckedChangeListener(new alux(this));
      localView1.setOnClickListener(new aluy(this));
      localView2.setOnClickListener(new alvb(this));
      localView3.setOnClickListener(new alve(this));
      return;
      localFormSwitchItem2.setChecked(true);
      b();
      ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("btnSetupIDE is open", new Object[0]));
    }
  }
  
  public void a(String paramString)
  {
    bbaj.a(BaseApplication.getContext(), "ark_ide_state_" + a(), paramString);
  }
  
  public String b()
  {
    return bbaj.a(BaseApplication.getContext(), "ark_ide_state_" + a()).toString();
  }
  
  public void b()
  {
    long l = NetConnInfoCenter.getServerTime();
    Object localObject = a();
    if (localObject == null)
    {
      ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("appinterface is null", new Object[0]));
      return;
    }
    localObject = ((QQAppInterface)localObject).a().a();
    RecentUser localRecentUser = ((aktg)localObject).a(ajsf.aL, 1031);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    localRecentUser.showUpTime = (System.currentTimeMillis() / 1000L);
    ((aktg)localObject).a(localRecentUser);
    ((aktg)localObject).b(localRecentUser);
    a(1);
  }
  
  public void b(String paramString)
  {
    int i = this.mContentView.getHeight();
    bcpw.a(BaseApplication.getContext(), paramString, 0).b(i - 20);
  }
  
  public void c()
  {
    long l = NetConnInfoCenter.getServerTime();
    Object localObject = a();
    if (localObject == null)
    {
      ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("appinterface is null", new Object[0]));
      return;
    }
    localObject = ((QQAppInterface)localObject).a().a();
    RecentUser localRecentUser = ((aktg)localObject).a(ajsf.aL, 1031);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    ((aktg)localObject).b(localRecentUser);
    ((aktg)localObject).c(localRecentUser);
  }
  
  public void d()
  {
    ArkAppMgr.deleteAllLocalApps();
    ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("App is clear", new Object[0]));
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    setTitle(ajyc.a(2131700689));
    a();
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void e()
  {
    Object localObject = a();
    if (localObject == null)
    {
      ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("appinterface is null", new Object[0]));
      return;
    }
    localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(121);
    ArkAppCenter.d();
    ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("AppData is clear", new Object[0]));
    ((ArkAppCenter)localObject).a().c();
    ((ArkAppCenter)localObject).a().a();
    ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("Dict is clear", new Object[0]));
    ArkAppCenter.c();
    ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("HttpCache is clear", new Object[0]));
    ArkAppConfigMgr.getInstance().cleanAllConfig();
    ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("AppConfig is clear", new Object[0]));
  }
  
  public int getContentLayoutId()
  {
    return 2131560652;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    alvg.a(1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.ArkIDESettingFragment
 * JD-Core Version:    0.7.0.1
 */