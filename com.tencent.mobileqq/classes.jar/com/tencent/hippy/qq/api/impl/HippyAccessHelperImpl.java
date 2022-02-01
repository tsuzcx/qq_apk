package com.tencent.hippy.qq.api.impl;

import android.content.Context;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.offline.HippyOfflineAssist;
import com.tencent.hippy.qq.preload.TabPreloadManager;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class HippyAccessHelperImpl
  implements IHippyAccessHelper
{
  public boolean checkAndPreloadHippyPage(OpenHippyInfo paramOpenHippyInfo)
  {
    return HippyAccessHelper.checkAndPreloadHippyPage(paramOpenHippyInfo);
  }
  
  public boolean checkDomainPermission(String paramString)
  {
    return HippyAccessHelper.checkDomainPermission(paramString);
  }
  
  public boolean checkUrlPermission(String paramString)
  {
    return HippyAccessHelper.checkUrlPermission(paramString);
  }
  
  public void doAfterLogin() {}
  
  public JSONObject getJSInitData(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3)
  {
    return HippyAccessHelper.getJSInitData(paramAppRuntime, paramString1, paramString2, paramString3);
  }
  
  public String getOfflineResPath(String paramString)
  {
    return HippyOfflineAssist.getOfflineResPath(paramString);
  }
  
  public HippyQQPreloadEngine getPreloadedHippyQQEngine(String paramString)
  {
    return HippyAccessHelper.getPreloadedHippyQQEngine(paramString);
  }
  
  public void onMainTabShowForTool(String paramString)
  {
    TabPreloadManager.getInstance().onTabChangeForTool(paramString);
  }
  
  public boolean openHippyPage(Context paramContext, OpenHippyInfo paramOpenHippyInfo)
  {
    return HippyAccessHelper.openHippyPage(paramContext, paramOpenHippyInfo);
  }
  
  public JSONObject wrapHashMap(JSONObject paramJSONObject, HashMap paramHashMap)
  {
    return HippyAccessHelper.wrapHashMap(paramJSONObject, paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.api.impl.HippyAccessHelperImpl
 * JD-Core Version:    0.7.0.1
 */