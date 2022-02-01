package com.tencent.mobileqq.ark.base;

import android.content.Context;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.ark.ark.ModuleRegister;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.api.IArkAppLifeEvent;
import com.tencent.mobileqq.ark.api.IArkQualityReport;
import com.tencent.mobileqq.ark.api.IArkSecureReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class DefaultApplicationCallback
  implements ark.ApplicationCallback
{
  protected static void a()
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    if (localBaseApplication == null) {
      return;
    }
    a(localBaseApplication.getString(2131690169));
  }
  
  protected static void a(String paramString)
  {
    ArkDispatchTask.getInstance().postToMainThread(new DefaultApplicationCallback.1(paramString));
  }
  
  public void AppCreate(ark.Application paramApplication)
  {
    paramApplication = paramApplication.GetSpecific("appName");
    ((IArkAppLifeEvent)QRoute.api(IArkAppLifeEvent.class)).doAction(0, paramApplication, null);
  }
  
  public void AppDestroy(ark.Application paramApplication)
  {
    paramApplication = paramApplication.GetSpecific("appName");
    ((IArkAppLifeEvent)QRoute.api(IArkAppLifeEvent.class)).doAction(1, paramApplication, null);
    ((IArkSecureReport)QRoute.api(IArkSecureReport.class)).reportAccumulatedValidURL(paramApplication);
  }
  
  public boolean CheckUrlLegalityCallback(ark.Application paramApplication, String paramString)
  {
    paramApplication = paramApplication.GetSpecific("appName");
    int i = a(paramApplication, paramString);
    if (i == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("CheckURL, valid. appName=");
      localStringBuilder.append(paramApplication);
      localStringBuilder.append(",url=");
      localStringBuilder.append(Util.b(paramString, new String[0]));
      QLog.i("ArkApp.ApplicationCallback", 1, localStringBuilder.toString());
      return true;
    }
    if (!a(paramApplication))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("CheckURL, check. appName=");
      localStringBuilder.append(paramApplication);
      localStringBuilder.append(",url=");
      localStringBuilder.append(Util.b(paramString, new String[0]));
      QLog.i("ArkApp.ApplicationCallback", 1, localStringBuilder.toString());
      ((IArkSecureReport)QRoute.api(IArkSecureReport.class)).reportResourceURLAccess(paramApplication, paramString, i, 2, "");
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CheckURL, blocked. appName=");
    localStringBuilder.append(paramApplication);
    localStringBuilder.append(",url=");
    localStringBuilder.append(Util.b(paramString, new String[0]));
    QLog.i("ArkApp.ApplicationCallback", 1, localStringBuilder.toString());
    ((IArkSecureReport)QRoute.api(IArkSecureReport.class)).reportResourceURLAccess(paramApplication, paramString, i, 1, "");
    a();
    return false;
  }
  
  public void OutputScriptError(String paramString1, String paramString2)
  {
    QLog.e("ArkApp.ApplicationCallback", 1, String.format("%s.script error:\n%s", new Object[] { paramString1, paramString2 }));
    ((IArkQualityReport)QRoute.api(IArkQualityReport.class)).reportScriptError(MobileQQ.sMobileQQ.waitAppRuntime(null), paramString1, paramString2);
  }
  
  public void RegisterModules(ark.ModuleRegister paramModuleRegister, ark.Application paramApplication)
  {
    ((IArkAPIService)QRoute.api(IArkAPIService.class)).registerModules(paramModuleRegister, paramApplication);
  }
  
  protected final int a(String paramString1, String paramString2)
  {
    paramString1 = ArkAppConfigMgr.getInstance().getUrlChecker(paramString1);
    if (paramString1 == null) {
      return 0;
    }
    return paramString1.checkUrlIsValidByAppResouceList(paramString2);
  }
  
  protected boolean a(String paramString)
  {
    return ArkAppConfigMgr.getInstance().isUrlCheckEnable(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.base.DefaultApplicationCallback
 * JD-Core Version:    0.7.0.1
 */