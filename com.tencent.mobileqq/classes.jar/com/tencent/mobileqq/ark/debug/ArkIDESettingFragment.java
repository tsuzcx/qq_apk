package com.tencent.mobileqq.ark.debug;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.appmanage.LocalAppManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.ark.dict.api.IArkDictManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ArkIDESettingFragment
  extends IphoneTitleBarFragment
{
  public static ArkIDESettingFragment a;
  private TextView b = null;
  
  public static ArkIDESettingFragment a()
  {
    if (a == null) {
      a = new ArkIDESettingFragment();
    }
    return a;
  }
  
  private void a(int paramInt)
  {
    JSDebuggerSoLoader.a(paramInt, new ArkIDESettingFragment.6(this));
  }
  
  public void a(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ark_ide_state_");
    localStringBuilder.append(d());
    SharePreferenceUtils.a(localBaseApplication, localStringBuilder.toString(), paramString);
  }
  
  protected QQAppInterface b()
  {
    return (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
  }
  
  void b(String paramString)
  {
    int i = this.mContentView.getHeight();
    QQToast.makeText(BaseApplication.getContext(), paramString, 0).show(i - 20);
  }
  
  void c()
  {
    FormSwitchItem localFormSwitchItem1 = (FormSwitchItem)this.mContentView.findViewById(2131430023);
    FormSwitchItem localFormSwitchItem2 = (FormSwitchItem)this.mContentView.findViewById(2131430025);
    this.b = ((TextView)this.mContentView.findViewById(2131436683));
    View localView1 = this.mContentView.findViewById(2131429834);
    View localView2 = this.mContentView.findViewById(2131429833);
    View localView3 = this.mContentView.findViewById(2131430070);
    localFormSwitchItem1.setChecked(true);
    localFormSwitchItem1.setOnCheckedChangeListener(new ArkIDESettingFragment.1(this));
    if ((!TextUtils.isEmpty(e())) && (e().equals("close")))
    {
      localFormSwitchItem2.setChecked(false);
      ArkAppCenter.a("ArkApp.DebugOnlineActivity", String.format("btnSetupIDE is closed and idestate=%s", new Object[] { e() }));
    }
    else
    {
      localFormSwitchItem2.setChecked(true);
      f();
      ArkAppCenter.a("ArkApp.DebugOnlineActivity", String.format("btnSetupIDE is open", new Object[0]));
    }
    localFormSwitchItem2.setOnCheckedChangeListener(new ArkIDESettingFragment.2(this));
    localView1.setOnClickListener(new ArkIDESettingFragment.3(this));
    localView2.setOnClickListener(new ArkIDESettingFragment.4(this));
    localView3.setOnClickListener(new ArkIDESettingFragment.5(this));
  }
  
  public String d()
  {
    QQAppInterface localQQAppInterface = b();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.a("ArkApp.DebugOnlineActivity", String.format("appinterface is null", new Object[0]));
      return "";
    }
    return localQQAppInterface.getCurrentAccountUin();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    setTitle(HardCodeUtil.a(2131898945));
    c();
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public String e()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ark_ide_state_");
    localStringBuilder.append(d());
    return SharePreferenceUtils.a(localBaseApplication, localStringBuilder.toString()).toString();
  }
  
  public void f()
  {
    long l = NetConnInfoCenter.getServerTime();
    Object localObject = b();
    if (localObject == null)
    {
      ArkAppCenter.a("ArkApp.DebugOnlineActivity", String.format("appinterface is null", new Object[0]));
      return;
    }
    localObject = ((QQAppInterface)localObject).getProxyManager().g();
    RecentUser localRecentUser = ((RecentUserProxy)localObject).b(AppConstants.ARK_DEBUG_UIN, 1031);
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
  
  public void g()
  {
    long l = NetConnInfoCenter.getServerTime();
    Object localObject = b();
    if (localObject == null)
    {
      ArkAppCenter.a("ArkApp.DebugOnlineActivity", String.format("appinterface is null", new Object[0]));
      return;
    }
    localObject = ((QQAppInterface)localObject).getProxyManager().g();
    RecentUser localRecentUser = ((RecentUserProxy)localObject).b(AppConstants.ARK_DEBUG_UIN, 1031);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    ((RecentUserProxy)localObject).a(localRecentUser);
    if ((localObject instanceof FullCache)) {
      ((FullCache)localObject).removeCache(localRecentUser);
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131627310;
  }
  
  void h()
  {
    LocalAppManager.deleteAllLocalApps();
    ArkAppCenter.a("ArkApp.DebugOnlineActivity", String.format("App is clear", new Object[0]));
  }
  
  void i()
  {
    Object localObject = b();
    if (localObject == null)
    {
      ArkAppCenter.a("ArkApp.DebugOnlineActivity", String.format("appinterface is null", new Object[0]));
      return;
    }
    IArkHelper localIArkHelper = (IArkHelper)QRoute.api(IArkHelper.class);
    localIArkHelper.cleanAppStorage();
    QLog.i("ArkApp.DebugOnlineActivity", 1, "AppData is clear");
    localIArkHelper.cleanWebCache();
    QLog.i("ArkApp.DebugOnlineActivity", 1, "HttpCache is clear");
    localObject = (IArkDictManager)((QQAppInterface)localObject).getRuntimeService(IArkDictManager.class, "");
    ((IArkDictManager)localObject).clearDict();
    ((IArkDictManager)localObject).updateLocalDict();
    ArkAppCenter.a("ArkApp.DebugOnlineActivity", "Dict is clear");
    ArkAppConfigMgr.getInstance().cleanAllConfig();
    ArkAppCenter.a("ArkApp.DebugOnlineActivity", "AppConfig is clear");
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