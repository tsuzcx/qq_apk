package com.tencent.hippy.qq.api;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TabPreloadItem
{
  public static final int MIN_PRE_UPDATE_INTERVAL = 120;
  public static final String PRELOAD_PROCESS_MAIN = "main";
  public static final String PRELOAD_PROCESS_TOOL = "tool";
  public static final String PRELOAD_PROCESS_UNKNOWN = "unknown";
  private static final String PRELOAD_TYPE_PREDRAW = "predraw";
  private static final String PRELOAD_TYPE_PRELOAD = "preload";
  private static final String PRELOAD_TYPE_PREUPDATE = "predownload";
  public static final String TAB_NAME_CONTACTS = "contacts";
  public static final String TAB_NAME_DRAWER = "drawer";
  public static final String TAB_NAME_DYNAMIC = "dynamic";
  public static final String TAB_NAME_KANDIAN = "kandian";
  public static final String TAB_NAME_MESSAGE = "msgList";
  private static final String TAG = "TabPreloadItem";
  public String bundleName;
  public String domain;
  public int lifeTime;
  public boolean needCheckPreload;
  public int preUpdateInterval = 120;
  public String preloadFramework;
  public String preloadProcess;
  public TabPreloadItem.PreloadType preloadType;
  public int priority;
  
  private static TabPreloadItem.PreloadType convertToPreloadType(String paramString)
  {
    if ("predownload".equals(paramString)) {
      return TabPreloadItem.PreloadType.PRE_UPDATE;
    }
    if ("preload".equals(paramString)) {
      return TabPreloadItem.PreloadType.PRE_LOAD;
    }
    if ("predraw".equals(paramString)) {
      return TabPreloadItem.PreloadType.PRE_DRAW;
    }
    return TabPreloadItem.PreloadType.UNKNOWN;
  }
  
  public static TabPreloadItem fromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      localObject = new TabPreloadItem();
      ((TabPreloadItem)localObject).bundleName = paramJSONObject.optString("bundleName");
      ((TabPreloadItem)localObject).lifeTime = paramJSONObject.optInt("lifeTime");
      ((TabPreloadItem)localObject).priority = paramJSONObject.optInt("priority");
      ((TabPreloadItem)localObject).preloadType = convertToPreloadType(paramJSONObject.optString("preloadType"));
      ((TabPreloadItem)localObject).preloadProcess = paramJSONObject.optString("process");
      ((TabPreloadItem)localObject).preloadFramework = paramJSONObject.optString("framework", "vue");
      ((TabPreloadItem)localObject).needCheckPreload = paramJSONObject.optBoolean("needCheckPreload");
      ((TabPreloadItem)localObject).domain = paramJSONObject.optString("domain");
      ((TabPreloadItem)localObject).preUpdateInterval = paramJSONObject.optInt("preDownLoadTimeLimit");
      if (((TabPreloadItem)localObject).preUpdateInterval < 120) {
        ((TabPreloadItem)localObject).preUpdateInterval = 120;
      }
      boolean bool = ((TabPreloadItem)localObject).checkData();
      if (bool) {
        return localObject;
      }
    }
    catch (Throwable paramJSONObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fromJson e:");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.e("TabPreloadItem", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public boolean checkData()
  {
    if (TextUtils.isEmpty(this.bundleName)) {
      return false;
    }
    if (this.preloadType == TabPreloadItem.PreloadType.UNKNOWN) {
      return false;
    }
    if (TextUtils.isEmpty(this.preloadProcess)) {
      return false;
    }
    if ((!this.preloadProcess.equals("main")) && (!this.preloadProcess.equals("tool"))) {
      return false;
    }
    String str = this.preloadFramework;
    return (str == null) || (str.equals("vue")) || (this.preloadFramework.equals("react"));
  }
  
  public boolean isPreUpdate()
  {
    return this.preloadType == TabPreloadItem.PreloadType.PRE_UPDATE;
  }
  
  public boolean isPredraw()
  {
    return this.preloadType == TabPreloadItem.PreloadType.PRE_DRAW;
  }
  
  public boolean isPreload()
  {
    return this.preloadType == TabPreloadItem.PreloadType.PRE_LOAD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.api.TabPreloadItem
 * JD-Core Version:    0.7.0.1
 */