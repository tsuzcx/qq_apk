package com.tencent.hippy.qq.api;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TabPreloadItem
{
  public static final String PRELOAD_PROCESS_MAIN = "main";
  public static final String PRELOAD_PROCESS_TOOL = "tool";
  public static final String PRELOAD_TYPE_PREDRAW = "predraw";
  public static final String PRELOAD_TYPE_PRELOAD = "preload";
  public static final String TAB_NAME_CONTACTS = "contacts";
  public static final String TAB_NAME_DRAWER = "drawer";
  public static final String TAB_NAME_DYNAMIC = "dynamic";
  public static final String TAB_NAME_KANDIAN = "kandian";
  public static final String TAB_NAME_MESSAGE = "msgList";
  public static final String TAG = "TabPreloadItem";
  public String bundleName;
  public String domain;
  public int lifeTime;
  public boolean needCheckPreload;
  public String preloadProcess;
  public String preloadType;
  public int priority;
  
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
      ((TabPreloadItem)localObject).preloadType = paramJSONObject.optString("preloadType");
      ((TabPreloadItem)localObject).preloadProcess = paramJSONObject.optString("process");
      ((TabPreloadItem)localObject).needCheckPreload = paramJSONObject.optBoolean("needCheckPreload");
      ((TabPreloadItem)localObject).domain = paramJSONObject.optString("domain");
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
    if (TextUtils.isEmpty(this.preloadType)) {
      return false;
    }
    if ((!this.preloadType.equals("predraw")) && (!this.preloadType.equals("preload"))) {
      return false;
    }
    if (TextUtils.isEmpty(this.preloadProcess)) {
      return false;
    }
    return (this.preloadProcess.equals("main")) || (this.preloadProcess.equals("tool"));
  }
  
  public boolean isPredraw()
  {
    return "predraw".equals(this.preloadType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.api.TabPreloadItem
 * JD-Core Version:    0.7.0.1
 */