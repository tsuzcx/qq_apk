package com.tencent.hippy.qq.utils;

import adxr;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bijk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.hippy.qq.update.UpdateSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityForTool;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class HippyAccessHelper
{
  public static final String EXTRA_KEY_BUNDLE_NAME = "bundleName";
  public static final String EXTRA_KEY_ERROR_URL = "errorUrl";
  public static final String EXTRA_KEY_IS_ANIMATED = "isAnimated";
  public static final String EXTRA_KEY_IS_DEBUGMODE = "isDebugMode";
  public static final String EXTRA_KEY_IS_IN_TOOL_PROCESS = "isInToolProcess";
  public static final String EXTRA_KEY_IS_PRELOAD = "isPreload";
  public static final String EXTRA_KEY_IS_STATUSBAR_DARKFONT = "isStatusBarDarkFont";
  public static final String EXTRA_KEY_IS_TRANSPARENT = "isTrasparent";
  public static final String EXTRA_KEY_PAGE_URL = "url";
  public static final String EXTRA_KEY_PARAMS = "params";
  private static final long HALF_HOUR_IN_MILLIS = 1800000L;
  private static final int PRELOAD_COUNT_EACH_MODULE = 1;
  public static final String TAG = "HippyAccessHelper";
  private static HashMap<String, Long> sModulesPredownloadTime = new HashMap();
  private static HashMap<String, ArrayList<HippyQQPreloadEngine>> sPreloadEngines = new HashMap();
  private static final Object sPreloadLock = new Object();
  
  public static boolean checkAndPreloadHippyPage(Bundle paramBundle)
  {
    boolean bool2 = false;
    if (!checkBundle(paramBundle)) {
      return false;
    }
    boolean bool1;
    if (BaseApplicationImpl.sProcessId == 7)
    {
      bool1 = true;
      if (BaseApplicationImpl.sProcessId == 1) {
        bool2 = true;
      }
      boolean bool3 = paramBundle.getBoolean("isInToolProcess");
      QLog.d("HippyAccessHelper", 1, "checkAndPreloadHippyPage isToolProcess:" + bool1 + " isMainProcess:" + bool2);
      if (!bool3) {
        break label97;
      }
      if (bool1) {
        bijk.a(new HippyAccessHelper.1(paramBundle));
      }
    }
    for (;;)
    {
      return true;
      bool1 = false;
      break;
      label97:
      if (bool2)
      {
        bijk.a(new HippyAccessHelper.2(paramBundle));
      }
      else
      {
        Bundle localBundle = new Bundle();
        localBundle.putBundle("hippy_info", paramBundle);
        QIPCClientHelper.getInstance().callServer("module_hippy", "action_preload_hippy", localBundle, null);
      }
    }
  }
  
  private static boolean checkBundle(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.containsKey("bundleName"));
  }
  
  public static void clearPreloadHippy()
  {
    Object localObject2 = new HashMap();
    for (;;)
    {
      synchronized (sPreloadLock)
      {
        ((HashMap)localObject2).putAll(sPreloadEngines);
        sPreloadEngines.clear();
        ??? = ((HashMap)localObject2).entrySet().iterator();
        if (!((Iterator)???).hasNext()) {
          break;
        }
        localObject2 = (ArrayList)((Map.Entry)((Iterator)???).next()).getValue();
        if (localObject2 == null) {
          continue;
        }
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        if (localIterator.hasNext()) {
          ((HippyQQPreloadEngine)localIterator.next()).onDestroy();
        }
      }
      localObject3.clear();
    }
  }
  
  public static HippyQQPreloadEngine getPreloadedHippyQQEngine(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      HippyQQPreloadEngine localHippyQQPreloadEngine;
      synchronized (sPreloadLock)
      {
        ArrayList localArrayList = (ArrayList)sPreloadEngines.get(paramString);
        if ((localArrayList == null) || (localArrayList.size() <= 0)) {
          break;
        }
        if (localArrayList.size() <= 0) {
          break;
        }
        localHippyQQPreloadEngine = (HippyQQPreloadEngine)localArrayList.remove(0);
        if (localHippyQQPreloadEngine == null) {
          continue;
        }
        int i = UpdateSetting.getInstance().getModuleVersion(paramString);
        if (localHippyQQPreloadEngine.getModuleVersion() == i) {
          return localHippyQQPreloadEngine;
        }
      }
      localHippyQQPreloadEngine.onDestroy();
    }
    return null;
  }
  
  public static boolean openHippyPage(Context paramContext, Bundle paramBundle)
  {
    boolean bool2 = true;
    if ((paramContext == null) || (!checkBundle(paramBundle)))
    {
      bool1 = false;
      return bool1;
    }
    boolean bool3 = paramBundle.getBoolean("isAnimated");
    boolean bool1 = paramBundle.getBoolean("isTrasparent");
    boolean bool4 = paramBundle.getBoolean("isInToolProcess");
    paramBundle.putLong("openPageStart", System.currentTimeMillis());
    Intent localIntent = new Intent();
    localIntent.putExtra("params", paramBundle);
    if (bool1)
    {
      localIntent.putExtra("public_fragment_window_feature", 1);
      if (bool4) {
        adxr.a(paramContext, localIntent, PublicTransFragmentActivityForTool.class, CommonHippyFragment.class);
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (!bool3) {
        break;
      }
      bool1 = bool2;
      if (!(paramContext instanceof Activity)) {
        break;
      }
      ((Activity)paramContext).overridePendingTransition(2130772011, 2130772224);
      return true;
      adxr.a(paramContext, localIntent, PublicTransFragmentActivity.class, CommonHippyFragment.class);
      continue;
      if (bool4) {
        PublicFragmentActivityForTool.b(paramContext, localIntent, CommonHippyFragment.class);
      } else {
        PublicFragmentActivity.a(paramContext, localIntent, CommonHippyFragment.class);
      }
    }
  }
  
  private static boolean preloadHippyPage(Bundle paramBundle)
  {
    return preloadHippyPage(paramBundle.getString("bundleName"), paramBundle.getBoolean("isDebugMode"), paramBundle.getString("url"));
  }
  
  private static boolean preloadHippyPage(String paramString1, boolean paramBoolean, String paramString2)
  {
    QLog.d("HippyAccessHelper", 1, "preloadHippyPage moduleName:" + paramString1);
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    synchronized (sPreloadLock)
    {
      Object localObject2 = (ArrayList)sPreloadEngines.get(paramString1);
      if (localObject2 == null) {
        sPreloadEngines.put(paramString1, new ArrayList());
      }
      while (((ArrayList)localObject2).size() < 1)
      {
        ??? = BaseHippyFragment.getJSInitData(BaseApplicationImpl.getApplication().getRuntime(), paramString1, null);
        localObject2 = new HippyQQPreloadEngine(null, paramString1, paramString2);
        ((HippyQQPreloadEngine)localObject2).setDebugMode(false);
        ((HippyQQPreloadEngine)localObject2).setInitData((JSONObject)???, (JSONObject)???);
        ((HippyQQPreloadEngine)localObject2).preloadEngine(new HippyAccessHelper.3(paramString1, (HippyQQPreloadEngine)localObject2, paramBoolean, paramString2));
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HippyAccessHelper", 2, "preloadHippyPage size:" + ((ArrayList)localObject2).size());
      }
      return true;
    }
  }
  
  public static boolean startHippyPage(Context paramContext, HippyMap paramHippyMap)
  {
    if ((paramContext == null) || (paramHippyMap == null))
    {
      QLog.e("HippyAccessHelper", 1, "startHippyPage params error");
      return false;
    }
    String str1 = paramHippyMap.getString("url");
    String str2 = paramHippyMap.getString("errorUrl");
    boolean bool1 = paramHippyMap.getBoolean("isPreload");
    boolean bool2 = paramHippyMap.getBoolean("isAnimated");
    boolean bool3 = paramHippyMap.getBoolean("isTrasparent");
    boolean bool4 = paramHippyMap.getBoolean("isStatusBarDarkFont");
    boolean bool5 = paramHippyMap.getBoolean("isDebugMode");
    boolean bool6 = paramHippyMap.getBoolean("isInToolProcess");
    paramHippyMap = paramHippyMap.getString("bundleName");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isPreload", bool1);
    localBundle.putBoolean("isAnimated", bool2);
    localBundle.putBoolean("isTrasparent", bool3);
    localBundle.putBoolean("isStatusBarDarkFont", bool4);
    localBundle.putBoolean("isDebugMode", bool5);
    localBundle.putBoolean("isInToolProcess", bool6);
    localBundle.putString("bundleName", paramHippyMap);
    localBundle.putString("url", str1);
    localBundle.putString("errorUrl", str2);
    if (bool1) {
      return checkAndPreloadHippyPage(localBundle);
    }
    return openHippyPage(paramContext, localBundle);
  }
  
  public static boolean startHippyPage(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if ((paramContext == null) || (paramHashMap == null))
    {
      QLog.e("HippyAccessHelper", 1, "startHippyPage params error");
      return false;
    }
    String str1 = (String)paramHashMap.get("bundleName");
    String str2 = (String)paramHashMap.get("url");
    String str3 = (String)paramHashMap.get("errorUrl");
    boolean bool1 = Boolean.parseBoolean((String)paramHashMap.get("isPreload"));
    boolean bool2 = Boolean.parseBoolean((String)paramHashMap.get("isAnimated"));
    boolean bool3 = Boolean.parseBoolean((String)paramHashMap.get("isTrasparent"));
    boolean bool4 = Boolean.parseBoolean((String)paramHashMap.get("isStatusBarDarkFont"));
    boolean bool5 = Boolean.parseBoolean((String)paramHashMap.get("isDebugMode"));
    boolean bool6 = Boolean.parseBoolean((String)paramHashMap.get("isInToolProcess"));
    paramHashMap = new Bundle();
    paramHashMap.putBoolean("isPreload", bool1);
    paramHashMap.putBoolean("isAnimated", bool2);
    paramHashMap.putBoolean("isTrasparent", bool3);
    paramHashMap.putBoolean("isStatusBarDarkFont", bool4);
    paramHashMap.putBoolean("isDebugMode", bool5);
    paramHashMap.putBoolean("isInToolProcess", bool6);
    paramHashMap.putString("bundleName", str1);
    paramHashMap.putString("url", str2);
    paramHashMap.putString("errorUrl", str3);
    if (bool1) {
      return checkAndPreloadHippyPage(paramHashMap);
    }
    return openHippyPage(paramContext, paramHashMap);
  }
  
  public static boolean startHippyPage(Context paramContext, JSONObject paramJSONObject)
  {
    if ((paramContext == null) || (paramJSONObject == null))
    {
      QLog.e("HippyAccessHelper", 1, "startHippyPage params error");
      return false;
    }
    String str1 = paramJSONObject.optString("url");
    String str2 = paramJSONObject.optString("errorUrl");
    boolean bool1 = paramJSONObject.optBoolean("isPreload");
    boolean bool2 = paramJSONObject.optBoolean("isAnimated");
    boolean bool3 = paramJSONObject.optBoolean("isTrasparent");
    boolean bool4 = paramJSONObject.optBoolean("isStatusBarDarkFont");
    boolean bool5 = paramJSONObject.optBoolean("isDebugMode");
    boolean bool6 = paramJSONObject.optBoolean("isInToolProcess");
    paramJSONObject = paramJSONObject.optString("bundleName");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isPreload", bool1);
    localBundle.putBoolean("isAnimated", bool2);
    localBundle.putBoolean("isTrasparent", bool3);
    localBundle.putBoolean("isStatusBarDarkFont", bool4);
    localBundle.putBoolean("isDebugMode", bool5);
    localBundle.putBoolean("isInToolProcess", bool6);
    localBundle.putString("bundleName", paramJSONObject);
    localBundle.putString("url", str1);
    localBundle.putString("errorUrl", str2);
    if (bool1) {
      return checkAndPreloadHippyPage(localBundle);
    }
    return openHippyPage(paramContext, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.HippyAccessHelper
 * JD-Core Version:    0.7.0.1
 */