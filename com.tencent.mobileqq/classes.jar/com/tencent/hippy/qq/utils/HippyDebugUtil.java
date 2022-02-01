package com.tencent.hippy.qq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mtt.hippy.common.HippyMap;
import org.json.JSONArray;

public class HippyDebugUtil
{
  public static final int DEBUG_VERSION = 2147483646;
  public static String KEY_ENV_SWITCH = "envSwitch";
  public static String KEY_HIPPY_DEBUG;
  public static String KEY_HIPPY_EXTRA_BUNDLE_NAME = "key_extra_bundle_name";
  public static String KEY_HIPPY_SERVER_HOST = "key_extra_serve_host";
  
  static
  {
    KEY_HIPPY_DEBUG = "key_extra_hippy_debug";
  }
  
  public static boolean deleteModule(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    return false;
  }
  
  public static void enableDebug(boolean paramBoolean) {}
  
  public static void enableDebugModule(String paramString)
  {
    HippyQQEngine.onDebugModuleChanged(paramString);
    getEditor().putString(KEY_HIPPY_EXTRA_BUNDLE_NAME, paramString).commit();
  }
  
  public static void enableDebugModuleAndPort(String paramString1, String paramString2) {}
  
  public static void enableDebugPort(String paramString)
  {
    HippyQQEngine.onDebugPortChanged(paramString);
    getEditor().putString(KEY_HIPPY_SERVER_HOST, paramString).commit();
  }
  
  private static SharedPreferences.Editor getEditor()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(KEY_ENV_SWITCH, 4).edit();
  }
  
  public static String getHippyBundleName()
  {
    return "Demo";
  }
  
  public static JSONArray getHippyModules()
  {
    return new JSONArray();
  }
  
  public static String getHippyServerHost()
  {
    return "localhost:38989";
  }
  
  public static JSONArray getModuleInfo(String paramString)
  {
    return new JSONArray();
  }
  
  public static void gotoDebugTool(Context paramContext)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("bundleName", "DebugTool");
    localHippyMap.pushString("url", "qb://hippy?debug&framework=react");
    new HippyAccessHelper.OpenHippyInfo(localHippyMap).openHippy(paramContext);
  }
  
  public static boolean isHippyDebug()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.HippyDebugUtil
 * JD-Core Version:    0.7.0.1
 */