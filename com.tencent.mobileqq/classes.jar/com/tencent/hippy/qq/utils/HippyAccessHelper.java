package com.tencent.hippy.qq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.hippy.qq.update.UpdateSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityForTool;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.utils.BoodoHippyBirdge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class HippyAccessHelper
{
  public static final String EXTRA_KEY_BUNDLE_NAME = "bundleName";
  public static final String EXTRA_KEY_BUNDLE_URL = "bundleUrl";
  public static final String EXTRA_KEY_ERROR_URL = "errorUrl";
  public static final String EXTRA_KEY_FRAMEWORK = "framework";
  public static final String EXTRA_KEY_FROM = "from";
  public static final String EXTRA_KEY_IS_ANIMATED = "isAnimated";
  public static final String EXTRA_KEY_IS_DISABLE_PRELOAD = "isDisablePreload";
  public static final String EXTRA_KEY_IS_ENABLE_RIGHT_FLING = "isEnbaleRightFling";
  public static final String EXTRA_KEY_IS_IN_TOOL_PROCESS = "isInToolProcess";
  public static final String EXTRA_KEY_IS_PREDRAW = "isPredraw";
  public static final String EXTRA_KEY_IS_PREDRAW_WHEN_CLOSED = "isPredrawWhenClosed";
  public static final String EXTRA_KEY_IS_PRELOAD = "isPreload";
  public static final String EXTRA_KEY_IS_PRELOAD_WHEN_CLOSED = "isPreloadWhenClosed";
  public static final String EXTRA_KEY_IS_STATUSBAR_DARKFONT = "isStatusBarDarkFont";
  public static final String EXTRA_KEY_IS_TRANSPARENT = "isTrasparent";
  public static final String EXTRA_KEY_JS_PARAM_MAP = "js_param_map";
  public static final String EXTRA_KEY_PAGE_URL = "url";
  public static final String EXTRA_KEY_PARAMS = "params";
  private static final long HALF_HOUR_IN_MILLIS = 1800000L;
  private static final int PRELOAD_COUNT_EACH_MODULE = 1;
  public static final String TAG = "HippyAccessHelper";
  private static HashMap<String, Long> sModulesPredownloadTime = new HashMap();
  private static HashMap<String, ArrayList<HippyQQPreloadEngine>> sPreloadEngines = new HashMap();
  private static final Object sPreloadLock = new Object();
  private static HashMap<String, Long> sPreloadingEngines = new HashMap();
  
  private static void addPreloadParameters(JSONObject paramJSONObject, boolean paramBoolean)
  {
    try
    {
      paramJSONObject.put("isPreload", true);
      paramJSONObject.put("isPredraw", paramBoolean);
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  public static boolean checkAndPreloadHippyPage(HippyAccessHelper.OpenHippyInfo paramOpenHippyInfo)
  {
    boolean bool2 = false;
    if ((paramOpenHippyInfo == null) || (!HippyAccessHelper.OpenHippyInfo.access$000(paramOpenHippyInfo)))
    {
      QLog.d("HippyAccessHelper", 1, "checkAndPreloadHippyPage parameters error");
      return false;
    }
    if (BaseApplicationImpl.sProcessId == 7) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (BaseApplicationImpl.sProcessId == 1) {
        bool2 = true;
      }
      QLog.d("HippyAccessHelper", 1, "checkAndPreloadHippyPage isToolProcess:" + bool1 + " isMainProcess:" + bool2 + " isLoadInToolProcess:" + paramOpenHippyInfo.isInToolProcess);
      if (!paramOpenHippyInfo.isInToolProcess) {
        break label203;
      }
      if (!bool1) {
        break;
      }
      ThreadManager.a(new HippyAccessHelper.1(paramOpenHippyInfo));
      return true;
    }
    try
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("from", 306);
      ((Intent)localObject).putExtra("hippy_info", paramOpenHippyInfo.toBundle());
      ((Intent)localObject).setAction("com.tencent.mobileqq.webprocess.preload_web_process");
      ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
      BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
      return true;
    }
    catch (Throwable paramOpenHippyInfo)
    {
      QLog.e("HippyAccessHelper", 1, "checkAndPreloadHippyPage sendBroadcast:" + paramOpenHippyInfo);
      return true;
    }
    label203:
    if (bool2)
    {
      ThreadManager.a(new HippyAccessHelper.2(paramOpenHippyInfo));
      return true;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putBundle("hippy_info", paramOpenHippyInfo.toBundle());
    QIPCClientHelper.getInstance().callServer("module_hippy", "action_preload_hippy", (Bundle)localObject, null);
    return true;
  }
  
  private static boolean checkBundle(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.containsKey("bundleName"));
  }
  
  public static void checkDebugHippyUpdate(QQAppInterface paramQQAppInterface, AppActivity paramAppActivity, String paramString)
  {
    String str = paramString;
    if (!isMqqapi(paramString))
    {
      Object localObject = Uri.parse(paramString);
      paramString = ((Uri)localObject).getQueryParameter("module");
      str = ((Uri)localObject).getQueryParameter("url");
      localObject = ((Uri)localObject).getQueryParameter("framework");
      paramString = "mqqapi://hippy/open?bundleName=" + paramString + "&bundleUrl=" + str;
      str = paramString;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        str = paramString + "&framework=" + (String)localObject;
      }
    }
    handleMqqJump(paramQQAppInterface, paramAppActivity, str);
  }
  
  public static boolean checkHippyQRCode(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    return false;
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
        sPreloadingEngines.clear();
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
          ((HippyQQPreloadEngine)localIterator.next()).destoryEngineImmediately();
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
        if (localHippyQQPreloadEngine.getPreloadModuleVersion() == i) {
          return localHippyQQPreloadEngine;
        }
      }
      localHippyQQPreloadEngine.destoryEngineImmediately();
    }
    return null;
  }
  
  public static void handleMqqJump(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramActivity, paramString);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a();
    }
  }
  
  private static boolean hasHippyParams(String paramString)
  {
    Object localObject = Uri.parse(paramString);
    paramString = ((Uri)localObject).getQueryParameter("module");
    localObject = ((Uri)localObject).getQueryParameter("url");
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject));
  }
  
  private static boolean isMqqapi(String paramString)
  {
    return paramString.startsWith("mqqapi");
  }
  
  private static boolean isQbScheme(String paramString)
  {
    return (paramString.startsWith("qb://react")) || (paramString.startsWith("qb://hippy"));
  }
  
  public static boolean openHippyPage(Context paramContext, HippyAccessHelper.OpenHippyInfo paramOpenHippyInfo)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramContext == null) || (paramOpenHippyInfo == null) || (!HippyAccessHelper.OpenHippyInfo.access$000(paramOpenHippyInfo)))
    {
      QLog.e("HippyAccessHelper", 1, "openHippyPage params error");
      bool1 = false;
      return bool1;
    }
    QLog.i("HippyAccessHelper", 1, "openHippy bundleName:" + paramOpenHippyInfo.bundleName + " isInToolProcess:" + paramOpenHippyInfo.isInToolProcess);
    Bundle localBundle = paramOpenHippyInfo.toBundle();
    localBundle.putLong("openPageStart", System.currentTimeMillis());
    if (BoodoHippyBirdge.a(localBundle.getString("bundleName")))
    {
      localBundle.putBoolean("isInToolProcess", true);
      paramOpenHippyInfo.isInToolProcess = true;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("params", localBundle);
    if (paramOpenHippyInfo.isTransparent)
    {
      localIntent.putExtra("public_fragment_window_feature", 1);
      if (paramOpenHippyInfo.isInToolProcess) {
        PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicTransFragmentActivityForTool.class, CommonHippyFragment.class);
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (!paramOpenHippyInfo.isAnimated) {
        break;
      }
      bool1 = bool2;
      if (!(paramContext instanceof Activity)) {
        break;
      }
      ((Activity)paramContext).overridePendingTransition(2130772014, 2130772238);
      return true;
      PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicTransFragmentActivity.class, CommonHippyFragment.class);
      continue;
      if (paramOpenHippyInfo.isInToolProcess) {
        PublicFragmentActivityForTool.b(paramContext, localIntent, CommonHippyFragment.class);
      } else {
        PublicFragmentActivity.a(paramContext, localIntent, CommonHippyFragment.class);
      }
    }
  }
  
  private static boolean preloadHippyPage(HippyAccessHelper.OpenHippyInfo paramOpenHippyInfo)
  {
    if ((paramOpenHippyInfo == null) || (!HippyAccessHelper.OpenHippyInfo.access$000(paramOpenHippyInfo)))
    {
      QLog.d("HippyAccessHelper", 1, "preloadHippyPage parameters error");
      return false;
    }
    String str = paramOpenHippyInfo.bundleName;
    QLog.d("HippyAccessHelper", 1, "preloadHippyPage moduleName:" + str + " isPredraw:" + paramOpenHippyInfo.isPredraw);
    for (;;)
    {
      int i;
      Object localObject3;
      synchronized (sPreloadLock)
      {
        localObject2 = (ArrayList)sPreloadEngines.get(str);
        if (localObject2 == null)
        {
          sPreloadEngines.put(str, new ArrayList());
          if (sPreloadingEngines.containsKey(str))
          {
            if (QLog.isColorLevel()) {
              QLog.d("HippyAccessHelper", 2, "preloadHippyPage moduleName:" + str + " isLoading");
            }
            return false;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("HippyAccessHelper", 2, "preloadHippyPage size:" + ((ArrayList)localObject2).size());
          }
          int j = UpdateSetting.getInstance().getModuleVersion(str);
          i = ((ArrayList)localObject2).size() - 1;
          if (i >= 0)
          {
            localObject3 = (HippyQQPreloadEngine)((ArrayList)localObject2).get(i);
            if (((HippyQQPreloadEngine)localObject3).getPreloadModuleVersion() == j) {
              break label445;
            }
            ((HippyQQPreloadEngine)localObject3).destoryEngineImmediately();
            ((ArrayList)localObject2).remove(i);
            if (!QLog.isColorLevel()) {
              break label445;
            }
            QLog.d("HippyAccessHelper", 2, "preloadHippyPage remove old version i:" + i);
            break label445;
          }
          if (((ArrayList)localObject2).size() < 1) {
            continue;
          }
          return true;
        }
        sPreloadingEngines.put(str, Long.valueOf(System.currentTimeMillis()));
        localObject3 = BaseApplicationImpl.getApplication().getRuntime();
        localObject2 = BaseHippyFragment.getJSInitData((AppRuntime)localObject3, str, null);
        ??? = localObject2;
        if (localObject2 == null) {
          ??? = new JSONObject();
        }
        addPreloadParameters((JSONObject)???, paramOpenHippyInfo.isPredraw);
        if (localObject3 == null)
        {
          localObject2 = "";
          localObject3 = new HippyQQPreloadEngine(null, str, paramOpenHippyInfo.url);
          ((HippyQQPreloadEngine)localObject3).setInitData((JSONObject)???, (JSONObject)???);
          ??? = new HippyAccessHelper.3(str, (String)localObject2, (HippyQQPreloadEngine)localObject3, paramOpenHippyInfo);
          if (!paramOpenHippyInfo.isPredraw) {
            break label436;
          }
          ((HippyQQPreloadEngine)localObject3).predrawHippy((HippyQQEngine.HippyQQEngineListener)???);
          return true;
        }
      }
      Object localObject2 = ((AppRuntime)localObject3).getAccount();
      continue;
      label436:
      ((HippyQQPreloadEngine)localObject3).preloadHippy((HippyQQEngine.HippyQQEngineListener)???);
      continue;
      label445:
      i -= 1;
    }
  }
  
  public static JSONObject wrapHashMap(JSONObject paramJSONObject, HashMap paramHashMap)
  {
    if (paramHashMap == null) {
      return paramJSONObject;
    }
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    Iterator localIterator = paramHashMap.keySet().iterator();
    for (;;)
    {
      paramJSONObject = localJSONObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramJSONObject = localIterator.next();
      try
      {
        localJSONObject.put(paramJSONObject.toString(), paramHashMap.get(paramJSONObject));
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("HippyAccessHelper", 1, paramJSONObject, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.HippyAccessHelper
 * JD-Core Version:    0.7.0.1
 */