package com.tencent.mobileqq.ark.base;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.config.bean.ArkPlatformConfigBean;
import com.tencent.mobileqq.ark.config.config.ArkPlatformConfig;
import com.tencent.mobileqq.ark.config.processor.ArkConfProcessor;
import com.tencent.mobileqq.ark.core.ArkAppCGI;
import com.tencent.mobileqq.ark.core.ArkAppCGI.ArkAppCGICallback;
import com.tencent.mobileqq.ark.core.ArkAppPreDownloadMgr;
import com.tencent.mobileqq.ark.core.ArkAppSSO;
import com.tencent.mobileqq.ark.dict.api.IArkDictManager;
import com.tencent.mobileqq.ark.module.ArkAppNotifyCenter;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ArkAppCenter
{
  private static boolean g = false;
  private final AppRuntime a;
  private final ArkAppCGI b;
  private final ArkAppSSO c;
  private final ArkAiAppCenter d;
  private final ArkAppPreDownloadMgr e;
  private final IGuardInterface f = new ArkAppCenter.1(this);
  private final int h = 0;
  private final int i = 1;
  private final int j = 2;
  private final ArkAppCenter.ProxyChangeNotifier k = new ArkAppCenter.ProxyChangeNotifier(null);
  private final INetInfoHandler l = new ArkAppCenter.5(this);
  
  public ArkAppCenter(AppRuntime paramAppRuntime)
  {
    QLog.i("ArkApp.AppCenter", 1, "ArkAppCenter.onCreate");
    this.a = paramAppRuntime;
    this.b = new ArkAppCGI(this);
    this.c = new ArkAppSSO(this);
    this.d = new ArkAiAppCenter();
    this.e = new ArkAppPreDownloadMgr(this.a);
    a();
    b();
    c();
    f();
    g();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 2)
    {
      ArkViewModel.setArkHttpProxy();
      return;
    }
    ArkViewModel.clearArkHttpProxy();
  }
  
  public static void a(String paramString)
  {
    if (paramString != null) {}
    try
    {
      g = "1".equalsIgnoreCase(paramString);
      break label20;
      g = false;
      label20:
      BaseApplication.getContext().getSharedPreferences("arkappmsg_entry", 4).edit().putBoolean("arkapp_pa_nshow", g).apply();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updatePANShowSwitch, value = ");
      localStringBuilder.append(paramString);
      QLog.i("ArkApp.AppCenter", 1, localStringBuilder.toString());
      return;
    }
    QLog.i("ArkApp.AppCenter", 1, "updatePANShowSwitch, value = null");
  }
  
  public static void a(boolean paramBoolean) {}
  
  public static boolean i()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPANonShow,  bRet = ");
      localStringBuilder.append(g);
      QLog.i("ArkApp.AppCenter", 4, localStringBuilder.toString());
    }
    return (g) || (!ArkUtil.isDeviceSupportArkMsg());
  }
  
  private void m()
  {
    Object localObject = (ArkPlatformConfigBean)ArkConfProcessor.a(ArkPlatformConfigBean.class);
    if ((localObject != null) && (((ArkPlatformConfigBean)localObject).b() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ArkSafe.initGlobalWhiteListAndUrlCheckStatus.loadConfig content = ");
      localStringBuilder.append(((ArkPlatformConfigBean)localObject).d());
      QLog.d("ArkApp.AppCenter", 1, localStringBuilder.toString());
      localObject = ((ArkPlatformConfigBean)localObject).b();
      ArkAppConfigMgr.getInstance().initGlobalWhiteListAndUrlCheckStatus(((ArkPlatformConfig)localObject).b, ((ArkPlatformConfig)localObject).k, ((ArkPlatformConfig)localObject).j);
    }
  }
  
  void a()
  {
    ArkMultiProcUtil.a();
    ArkAppNotifyCenter.init();
  }
  
  public boolean a(String paramString, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      this.b.a(paramString, paramObject, paramArkAppCGICallback);
      return true;
    }
    return false;
  }
  
  void b()
  {
    g = BaseApplication.getContext().getSharedPreferences("arkappmsg_entry", 4).getBoolean("arkapp_pa_nshow", g);
    m();
  }
  
  void c()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(this.a.getApp(), this.l);
    Object localObject = new IntentFilter("android.intent.action.PROXY_CHANGE");
    this.a.getApp().registerReceiver(this.k, (IntentFilter)localObject);
    localObject = GuardManager.sInstance;
    if (localObject != null)
    {
      ((GuardManager)localObject).registerCallBack(this.f);
      return;
    }
    QLog.i("ArkApp.AppCenter", 1, "guard manager is null");
  }
  
  public AppRuntime d()
  {
    return this.a;
  }
  
  public void e()
  {
    QLog.i("ArkApp.AppCenter", 1, "ArkAppCenter.onDestroy");
    ArkAppMgr.getInstance().onDestroy();
    AppNetConnInfo.unregisterNetInfoHandler(this.l);
    this.a.getApp().unregisterReceiver(this.k);
    if (GuardManager.sInstance != null)
    {
      GuardManager.sInstance.unregisterCallback(this.f);
      return;
    }
    QLog.i("ArkApp.AppCenter", 1, "guard manager is null");
  }
  
  void f()
  {
    ThreadManagerV2.executeOnSubThread(new ArkAppCenter.2(this));
  }
  
  void g()
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThreadDelay(new ArkAppCenter.3(this), 10000);
  }
  
  public void h()
  {
    if (!TextUtils.isEmpty(this.a.getAccount())) {
      ArkAppMgr.getInstance().updateInstalledApps();
    }
    ((IArkDictManager)this.a.getRuntimeService(IArkDictManager.class, "")).reloadWordData();
  }
  
  public ArkAppCGI j()
  {
    return this.b;
  }
  
  public ArkAppSSO k()
  {
    return this.c;
  }
  
  public ArkAppPreDownloadMgr l()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.base.ArkAppCenter
 * JD-Core Version:    0.7.0.1
 */