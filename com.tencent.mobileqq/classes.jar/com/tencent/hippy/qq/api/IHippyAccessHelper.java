package com.tencent.hippy.qq.api;

import android.content.Context;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IHippyAccessHelper
  extends QRouteApi
{
  public abstract boolean checkAndPreloadHippyPage(OpenHippyInfo paramOpenHippyInfo);
  
  public abstract boolean checkDomainPermission(String paramString);
  
  public abstract boolean checkUrlPermission(String paramString);
  
  public abstract void doAfterLogin();
  
  public abstract JSONObject getJSInitData(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3);
  
  public abstract String getOfflineResPath(String paramString);
  
  public abstract HippyQQPreloadEngine getPreloadedHippyQQEngine(String paramString);
  
  public abstract void onMainTabShowForTool(String paramString);
  
  public abstract boolean openHippyPage(Context paramContext, OpenHippyInfo paramOpenHippyInfo);
  
  public abstract JSONObject wrapHashMap(JSONObject paramJSONObject, HashMap paramHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.api.IHippyAccessHelper
 * JD-Core Version:    0.7.0.1
 */