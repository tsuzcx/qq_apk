package com.tencent.mobileqq.ark.api.impl;

import com.tencent.ark.ark;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ModuleRegister;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.module.ArkAppModuleReg;
import com.tencent.mobileqq.ark.module.ArkAppNotifyCenter;
import com.tencent.mobileqq.ark.module.ArkAppSchemeCenter;
import com.tencent.mobileqq.ark.module.IAppNotifyCallback;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import org.json.JSONObject;

public class ArkAPIServiceImpl
  implements IArkAPIService
{
  public static boolean postArkNotify(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArkMultiProcUtil.a();
    return ark.arkNotify(paramString1, paramString2, paramString3, paramString4);
  }
  
  public boolean dispatchAppNotification(String paramString1, String paramString2, String paramString3)
  {
    return ArkAppNotifyCenter.notify(paramString1, paramString2, paramString3);
  }
  
  public boolean dispatchOpenURL(String paramString1, String paramString2, JSONObject paramJSONObject, int paramInt, String paramString3)
  {
    return ArkAppSchemeCenter.a(paramString1, paramString2, paramJSONObject, paramInt, paramString3);
  }
  
  public void postArkNotify(String paramString1, String paramString2, String paramString3)
  {
    postArkNotify(paramString1, paramString2, paramString3, "json");
  }
  
  public void registerAppNotification(String paramString, IAppNotifyCallback paramIAppNotifyCallback)
  {
    ArkAppNotifyCenter.setNotify(paramString, paramIAppNotifyCallback);
  }
  
  public void registerModules(ark.ModuleRegister paramModuleRegister, ark.Application paramApplication)
  {
    ArkAppModuleReg.a(paramModuleRegister, paramApplication);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.impl.ArkAPIServiceImpl
 * JD-Core Version:    0.7.0.1
 */