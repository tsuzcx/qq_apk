package com.tencent.mobileqq.ark.debug;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenter;
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
  private TextView a;
  
  public ArkIDESettingFragment()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = null;
  }
  
  public static ArkIDESettingFragment a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArkDebugArkIDESettingFragment == null) {
      jdField_a_of_type_ComTencentMobileqqArkDebugArkIDESettingFragment = new ArkIDESettingFragment();
    }
    return jdField_a_of_type_ComTencentMobileqqArkDebugArkIDESettingFragment;
  }
  
  private void a(int paramInt)
  {
    JSDebuggerSoLoader.a(paramInt, new ArkIDESettingFragment.6(this));
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
    FormSwitchItem localFormSwitchItem1 = (FormSwitchItem)this.mContentView.findViewById(2131364144);
    FormSwitchItem localFormSwitchItem2 = (FormSwitchItem)this.mContentView.findViewById(2131364146);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131369894));
    View localView1 = this.mContentView.findViewById(2131363958);
    View localView2 = this.mContentView.findViewById(2131363957);
    View localView3 = this.mContentView.findViewById(2131364185);
    localFormSwitchItem1.setChecked(true);
    localFormSwitchItem1.setOnCheckedChangeListener(new ArkIDESettingFragment.1(this));
    if ((!TextUtils.isEmpty(b())) && (b().equals("close")))
    {
      localFormSwitchItem2.setChecked(false);
      ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("btnSetupIDE is closed and idestate=%s", new Object[] { b() }));
    }
    for (;;)
    {
      localFormSwitchItem2.setOnCheckedChangeListener(new ArkIDESettingFragment.2(this));
      localView1.setOnClickListener(new ArkIDESettingFragment.3(this));
      localView2.setOnClickListener(new ArkIDESettingFragment.4(this));
      localView3.setOnClickListener(new ArkIDESettingFragment.5(this));
      return;
      localFormSwitchItem2.setChecked(true);
      b();
      ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("btnSetupIDE is open", new Object[0]));
    }
  }
  
  public void a(String paramString)
  {
    SharePreferenceUtils.a(BaseApplication.getContext(), "ark_ide_state_" + a(), paramString);
  }
  
  public String b()
  {
    return SharePreferenceUtils.a(BaseApplication.getContext(), "ark_ide_state_" + a()).toString();
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
    localObject = ((QQAppInterface)localObject).getProxyManager().a();
    RecentUser localRecentUser = ((RecentUserProxy)localObject).a(AppConstants.ARK_DEBUG_UIN, 1031);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    localRecentUser.showUpTime = (System.currentTimeMillis() / 1000L);
    ((RecentUserProxy)localObject).b(localRecentUser);
    if ((localObject instanceof FullCache)) {
      ((FullCache)localObject).updateCache(localRecentUser);
    }
    a(1);
  }
  
  void b(String paramString)
  {
    int i = this.mContentView.getHeight();
    QQToast.a(BaseApplication.getContext(), paramString, 0).b(i - 20);
  }
  
  public void c()
  {
    long l = NetConnInfoCenter.getServerTime();
    Object localObject = a();
    if (localObject == null) {
      ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("appinterface is null", new Object[0]));
    }
    RecentUser localRecentUser;
    do
    {
      return;
      localObject = ((QQAppInterface)localObject).getProxyManager().a();
      localRecentUser = ((RecentUserProxy)localObject).a(AppConstants.ARK_DEBUG_UIN, 1031);
      if (localRecentUser.lastmsgtime < l) {
        localRecentUser.lastmsgtime = l;
      }
      ((RecentUserProxy)localObject).a(localRecentUser);
    } while (!(localObject instanceof FullCache));
    ((FullCache)localObject).removeCache(localRecentUser);
  }
  
  void d()
  {
    ArkAppMgr.deleteAllLocalApps();
    ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("App is clear", new Object[0]));
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    setTitle(HardCodeUtil.a(2131700777));
    a();
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  void e()
  {
    Object localObject = a();
    if (localObject == null)
    {
      ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("appinterface is null", new Object[0]));
      return;
    }
    localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
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
    return 2131561107;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    JSDebuggerSoLoader.a(1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.ArkIDESettingFragment
 * JD-Core Version:    0.7.0.1
 */