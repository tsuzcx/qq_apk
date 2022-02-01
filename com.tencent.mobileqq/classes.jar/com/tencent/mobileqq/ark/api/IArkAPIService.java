package com.tencent.mobileqq.ark.api;

import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ModuleRegister;
import com.tencent.mobileqq.ark.module.IAppNotifyCallback;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import org.json.JSONObject;

@QAPI(process={"all"})
@QRouteFactory
public abstract interface IArkAPIService
  extends QRouteApi
{
  public abstract boolean dispatchAppNotification(String paramString1, String paramString2, String paramString3);
  
  public abstract boolean dispatchOpenURL(String paramString1, String paramString2, JSONObject paramJSONObject, int paramInt, String paramString3);
  
  public abstract void postArkNotify(String paramString1, String paramString2, String paramString3);
  
  public abstract void registerAppNotification(String paramString, IAppNotifyCallback paramIAppNotifyCallback);
  
  public abstract void registerModules(ark.ModuleRegister paramModuleRegister, ark.Application paramApplication);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.IArkAPIService
 * JD-Core Version:    0.7.0.1
 */