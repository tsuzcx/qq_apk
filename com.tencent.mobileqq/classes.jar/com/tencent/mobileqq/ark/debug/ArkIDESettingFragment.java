package com.tencent.mobileqq.ark.debug;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import antf;
import anzj;
import apaw;
import apzu;
import aqdt;
import aqdu;
import aqdv;
import aqdy;
import aqeb;
import aqec;
import aqed;
import bhjc;
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
import com.tencent.mobileqq.widget.QQToast;
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
    aqed.a(paramInt, new aqec(this));
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
    FormSwitchItem localFormSwitchItem1 = (FormSwitchItem)this.mContentView.findViewById(2131363943);
    FormSwitchItem localFormSwitchItem2 = (FormSwitchItem)this.mContentView.findViewById(2131363945);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131369468));
    View localView1 = this.mContentView.findViewById(2131363760);
    View localView2 = this.mContentView.findViewById(2131363759);
    View localView3 = this.mContentView.findViewById(2131363981);
    localFormSwitchItem1.setChecked(true);
    localFormSwitchItem1.setOnCheckedChangeListener(new aqdt(this));
    if ((!TextUtils.isEmpty(b())) && (b().equals("close")))
    {
      localFormSwitchItem2.setChecked(false);
      ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("btnSetupIDE is closed and idestate=%s", new Object[] { b() }));
    }
    for (;;)
    {
      localFormSwitchItem2.setOnCheckedChangeListener(new aqdu(this));
      localView1.setOnClickListener(new aqdv(this));
      localView2.setOnClickListener(new aqdy(this));
      localView3.setOnClickListener(new aqeb(this));
      return;
      localFormSwitchItem2.setChecked(true);
      b();
      ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("btnSetupIDE is open", new Object[0]));
    }
  }
  
  public void a(String paramString)
  {
    bhjc.a(BaseApplication.getContext(), "ark_ide_state_" + a(), paramString);
  }
  
  public String b()
  {
    return bhjc.a(BaseApplication.getContext(), "ark_ide_state_" + a()).toString();
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
    RecentUser localRecentUser = (RecentUser)((apaw)localObject).findRecentUserByUin(antf.aL, 1031);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    localRecentUser.showUpTime = (System.currentTimeMillis() / 1000L);
    ((apaw)localObject).saveRecentUser(localRecentUser);
    ((apaw)localObject).updateCache(localRecentUser);
    a(1);
  }
  
  public void b(String paramString)
  {
    int i = this.mContentView.getHeight();
    QQToast.a(BaseApplication.getContext(), paramString, 0).b(i - 20);
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
    RecentUser localRecentUser = (RecentUser)((apaw)localObject).findRecentUserByUin(antf.aL, 1031);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    ((apaw)localObject).delRecentUser(localRecentUser);
    ((apaw)localObject).removeCache(localRecentUser);
  }
  
  public void d()
  {
    ArkAppMgr.deleteAllLocalApps();
    ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("App is clear", new Object[0]));
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    setTitle(anzj.a(2131699613));
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
    return 2131561085;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    aqed.a(1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.ArkIDESettingFragment
 * JD-Core Version:    0.7.0.1
 */