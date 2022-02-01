package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IArkQualityReport
  extends QRouteApi
{
  public abstract void reportAppSSOResult(AppRuntime paramAppRuntime, String paramString1, String paramString2, boolean paramBoolean, int paramInt);
  
  public abstract void reportScriptError(AppRuntime paramAppRuntime, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.IArkQualityReport
 * JD-Core Version:    0.7.0.1
 */