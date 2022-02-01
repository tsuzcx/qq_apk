package com.tencent.hippy.qq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.comic.api.IQQComicHippyUtil;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUtils;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.preload.TabPreloadManager;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.statemachine.MainStateManager;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class HippyAccessHelper
{
  private static final String[] DOMAIN_WHITE_LIST = { "*.qq.com", "*.tenpay.com" };
  private static final long HALF_HOUR_IN_MILLIS = 1800000L;
  private static final int PRELOAD_COUNT_EACH_MODULE = 1;
  public static final String TAG = "HippyAccessHelper";
  private static HashMap<String, String> mNeedLoginStateInfoModules;
  private static HashMap<String, Long> sModulesPredownloadTime = new HashMap();
  private static HashMap<String, ArrayList<HippyQQPreloadEngine>> sPreloadEngines;
  private static final Object sPreloadLock = new Object();
  private static HashMap<String, Long> sPreloadingEngines;
  
  static
  {
    sPreloadEngines = new HashMap();
    sPreloadingEngines = new HashMap();
    mNeedLoginStateInfoModules = new HashMap();
    mNeedLoginStateInfoModules.put("QQGameCenter", "gamecenter.qq.com");
    mNeedLoginStateInfoModules.put("QQBoodoComic", "vip.qq.com");
    mNeedLoginStateInfoModules.put("SGameOfficial", "SGameOfficial.qq.com");
    mNeedLoginStateInfoModules.put("QQVip", "vip.qq.com");
    mNeedLoginStateInfoModules.put("qqgxh", "vip.qq.com");
    mNeedLoginStateInfoModules.put("qqdhy", "qzone.qq.com");
    mNeedLoginStateInfoModules.put("qqMiniGame", "qzone.qq.com");
    mNeedLoginStateInfoModules.put("qqshop", "qianbao.qq.com");
  }
  
  public static void addPreloadParameters(JSONObject paramJSONObject, boolean paramBoolean)
  {
    try
    {
      paramJSONObject.put("isPreload", true);
      paramJSONObject.put("isPredraw", paramBoolean);
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  public static boolean checkAndPreloadHippyPage(OpenHippyInfo paramOpenHippyInfo)
  {
    int i = 0;
    if ((paramOpenHippyInfo != null) && (paramOpenHippyInfo.checkData()))
    {
      Object localObject = paramOpenHippyInfo.getProcessName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndPreloadHippyPage curProcessId:");
      localStringBuilder.append(MobileQQ.sProcessId);
      localStringBuilder.append(" processName:");
      localStringBuilder.append((String)localObject);
      QLog.d("HippyAccessHelper", 1, localStringBuilder.toString());
      if ("local".equals(localObject)) {}
      do
      {
        do
        {
          i = 1;
          break label221;
          if (!"main".equals(localObject)) {
            break;
          }
        } while (MobileQQ.sProcessId == 1);
        localObject = new Bundle();
        ((Bundle)localObject).putBundle("hippy_info", paramOpenHippyInfo.toBundle());
        QIPCClientHelper.getInstance().callServer("module_hippy", "action_preload_hippy", (Bundle)localObject, null);
        break;
        if (!"tool".equals(localObject)) {
          break label238;
        }
      } while (MobileQQ.sProcessId == 7);
      try
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("hippy_info", paramOpenHippyInfo.toBundle());
        ((IHippyUtils)QRoute.api(IHippyUtils.class)).preloadHippyInToolProcess((Intent)localObject);
      }
      catch (Throwable localThrowable)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkAndPreloadHippyPage sendBroadcast:");
        localStringBuilder.append(localThrowable);
        QLog.e("HippyAccessHelper", 1, localStringBuilder.toString());
      }
      label221:
      if (i != 0) {
        ThreadManager.executeOnSubThread(new HippyAccessHelper.1(paramOpenHippyInfo));
      }
      return true;
      label238:
      paramOpenHippyInfo = new StringBuilder();
      paramOpenHippyInfo.append("checkAndPreloadHippyPage not support process name:");
      paramOpenHippyInfo.append(localThrowable);
      QLog.e("HippyAccessHelper", 1, paramOpenHippyInfo.toString());
      return false;
    }
    QLog.d("HippyAccessHelper", 1, "checkAndPreloadHippyPage parameters error");
    return false;
  }
  
  private static boolean checkBundle(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.containsKey("bundleName"));
  }
  
  public static boolean checkDomainPermission(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.toLowerCase();
    int i = 0;
    for (;;)
    {
      Object localObject = DOMAIN_WHITE_LIST;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if (((IHippyUtils)QRoute.api(IHippyUtils.class)).isDomainMatch((String)localObject, paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean checkUrlPermission(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = Uri.parse(paramString);
      localObject = paramString.getScheme();
      if ((!"http".equals(localObject)) && (!"https".equals(localObject))) {
        return false;
      }
      boolean bool = checkDomainPermission(paramString.getHost());
      return bool;
    }
    catch (Throwable paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkUrlPermission e:");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("HippyAccessHelper", 1, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public static void doAfterLogin()
  {
    MainStateManager.getInstance().doAfterLogin();
    TabPreloadManager.getInstance().doAfterLogin();
    Object localObject2 = new HashMap();
    synchronized (sPreloadLock)
    {
      ((HashMap)localObject2).putAll(sPreloadEngines);
      sPreloadEngines.clear();
      sPreloadingEngines.clear();
      ??? = ((HashMap)localObject2).entrySet().iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (ArrayList)((Map.Entry)((Iterator)???).next()).getValue();
        if (localObject2 != null)
        {
          Iterator localIterator = ((ArrayList)localObject2).iterator();
          while (localIterator.hasNext()) {
            ((HippyQQPreloadEngine)localIterator.next()).destoryEngineImmediately();
          }
          ((ArrayList)localObject2).clear();
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public static JSONObject getJSInitData(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3)
  {
    if (paramAppRuntime == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString2)) {
          localJSONObject.put("url", paramString2);
        }
        localJSONObject.put("QQVersion", DeviceInfoUtil.c());
        if (ImmersiveUtils.isSupporImmersive() != 1) {
          break label385;
        }
        bool = true;
        localJSONObject.put("isSupporImmersive", bool);
        localJSONObject.put("statusBarHeight", ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ.getApplicationContext()));
        localJSONObject.put("notchHeight", LiuHaiUtils.a);
        localJSONObject.put("_titleBarHeight", BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168) + ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ.getApplicationContext()));
        paramString2 = paramString3;
        if (TextUtils.isEmpty(paramString3))
        {
          Iterator localIterator = mNeedLoginStateInfoModules.keySet().iterator();
          paramString2 = paramString3;
          if (localIterator.hasNext())
          {
            paramString2 = (String)localIterator.next();
            if ((paramString2 == null) || (!paramString1.startsWith(paramString2))) {
              continue;
            }
            paramString2 = (String)mNeedLoginStateInfoModules.get(paramString2);
          }
        }
        paramString3 = (TicketManager)paramAppRuntime.getManager(2);
        if ((!TextUtils.isEmpty(paramString2)) && (paramString3 != null))
        {
          paramAppRuntime = paramAppRuntime.getAccount();
          localJSONObject.put("uin", HttpBaseUtil.b(paramAppRuntime));
          localJSONObject.put("p_uin", HttpBaseUtil.b(paramAppRuntime));
          localJSONObject.put("skey", paramString3.getSkey(paramAppRuntime));
          localJSONObject.put("p_skey", paramString3.getPskey(paramAppRuntime, paramString2));
          if (paramString1.startsWith("QQBoodoComic")) {
            localJSONObject.put("pt4_token", paramString3.getPt4Token(paramAppRuntime, paramString2));
          }
          if (QLog.isColorLevel())
          {
            paramAppRuntime = new StringBuilder();
            paramAppRuntime.append("getJSInitData jsInitData:");
            paramAppRuntime.append(localJSONObject);
            QLog.d("HippyAccessHelper", 2, paramAppRuntime.toString());
            return localJSONObject;
          }
        }
      }
      catch (Throwable paramAppRuntime)
      {
        paramString1 = new StringBuilder();
        paramString1.append("getJSInitData error:");
        paramString1.append(paramAppRuntime);
        QLog.e("HippyAccessHelper", 1, paramString1.toString());
      }
      return localJSONObject;
      label385:
      boolean bool = false;
    }
  }
  
  public static HippyQQPreloadEngine getPreloadedHippyQQEngine(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ??? = TabPreloadManager.getInstance().getPreloadedHippyQQEngine(paramString);
    if (??? != null) {
      return ???;
    }
    synchronized (sPreloadLock)
    {
      ArrayList localArrayList = (ArrayList)sPreloadEngines.get(paramString);
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        while (localArrayList.size() > 0)
        {
          HippyQQPreloadEngine localHippyQQPreloadEngine = (HippyQQPreloadEngine)localArrayList.remove(0);
          if (localHippyQQPreloadEngine != null)
          {
            int i = ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleVersion(paramString);
            if (localHippyQQPreloadEngine.getPreloadModuleVersion() == i) {
              return localHippyQQPreloadEngine;
            }
            localHippyQQPreloadEngine.destoryEngineImmediately();
          }
        }
      }
      return null;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static boolean openHippyPage(Context paramContext, OpenHippyInfo paramOpenHippyInfo)
  {
    if ((paramContext != null) && (paramOpenHippyInfo != null) && (paramOpenHippyInfo.checkData()))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("openHippy bundleName:");
      ((StringBuilder)localObject1).append(paramOpenHippyInfo.bundleName);
      ((StringBuilder)localObject1).append(" processName:");
      ((StringBuilder)localObject1).append(paramOpenHippyInfo.getProcessName());
      QLog.i("HippyAccessHelper", 1, ((StringBuilder)localObject1).toString());
      Object localObject2 = paramOpenHippyInfo.toBundle();
      ((Bundle)localObject2).putLong("openPageStart", System.currentTimeMillis());
      localObject1 = ((Bundle)localObject2).getString("bundleName");
      if (((IQQComicHippyUtil)QRoute.api(IQQComicHippyUtil.class)).isBoodoModule((String)localObject1))
      {
        ((Bundle)localObject2).putString("processName", "tool");
        paramOpenHippyInfo.processName = "tool";
        if (paramOpenHippyInfo.fragmentClass == null) {
          paramOpenHippyInfo.fragmentClass = ((IQQComicHippyUtil)QRoute.api(IQQComicHippyUtil.class)).getHippyFragmentClass();
        }
      }
      else if ((((IMiniGamePublicAccountApi)QRoute.api(IMiniGamePublicAccountApi.class)).isMiniGamePAModule((String)localObject1)) && (paramOpenHippyInfo.fragmentClass == null))
      {
        paramOpenHippyInfo.fragmentClass = ((IMiniGamePublicAccountApi)QRoute.api(IMiniGamePublicAccountApi.class)).getMiniGamePAHippyClass();
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("params", (Bundle)localObject2);
      if (paramOpenHippyInfo.isTransparent) {
        ((Intent)localObject1).putExtra("public_fragment_window_feature", 1);
      }
      boolean bool = paramContext instanceof Activity;
      if (!bool) {
        ((Intent)localObject1).addFlags(268435456);
      }
      localObject2 = paramOpenHippyInfo.getStartActivityClass();
      Class localClass = paramOpenHippyInfo.getStartFragmentClass();
      if ((localObject2 != null) && (localClass != null))
      {
        QPublicFragmentActivity.Launcher.a(paramContext, (Intent)localObject1, (Class)localObject2, localClass);
        if ((paramOpenHippyInfo.isAnimated) && (bool)) {
          ((Activity)paramContext).overridePendingTransition(2130772023, 2130772024);
        }
        return true;
      }
      QLog.e("HippyAccessHelper", 1, "openHippyPage cannot find activity class or fragment class");
      return false;
    }
    QLog.e("HippyAccessHelper", 1, "openHippyPage params error");
    return false;
  }
  
  private static boolean preloadHippyPage(OpenHippyInfo paramOpenHippyInfo)
  {
    String str;
    if ((paramOpenHippyInfo != null) && (paramOpenHippyInfo.checkData()))
    {
      if (TabPreloadManager.getInstance().isInTabPreload(paramOpenHippyInfo.bundleName)) {
        return TabPreloadManager.getInstance().preloadWhenBack(paramOpenHippyInfo);
      }
      str = paramOpenHippyInfo.bundleName;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("preloadHippyPage moduleName:");
      ((StringBuilder)???).append(str);
      ((StringBuilder)???).append(" isPredraw:");
      ((StringBuilder)???).append(paramOpenHippyInfo.isPredraw);
      QLog.d("HippyAccessHelper", 1, ((StringBuilder)???).toString());
    }
    for (;;)
    {
      int i;
      synchronized (sPreloadLock)
      {
        Object localObject2 = (ArrayList)sPreloadEngines.get(str);
        if (localObject2 == null)
        {
          sPreloadEngines.put(str, new ArrayList());
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("preloadHippyPage size:");
            ((StringBuilder)localObject3).append(((ArrayList)localObject2).size());
            QLog.d("HippyAccessHelper", 2, ((StringBuilder)localObject3).toString());
          }
          int j = ((IHippySetting)QRoute.api(IHippySetting.class)).getModuleVersion(str);
          i = ((ArrayList)localObject2).size() - 1;
          if (i >= 0)
          {
            localObject3 = (HippyQQPreloadEngine)((ArrayList)localObject2).get(i);
            if (((HippyQQPreloadEngine)localObject3).getPreloadModuleVersion() == j) {
              break label526;
            }
            ((HippyQQPreloadEngine)localObject3).destoryEngineImmediately();
            ((ArrayList)localObject2).remove(i);
            if (!QLog.isColorLevel()) {
              break label526;
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("preloadHippyPage remove old version i:");
            ((StringBuilder)localObject3).append(i);
            QLog.d("HippyAccessHelper", 2, ((StringBuilder)localObject3).toString());
            break label526;
          }
          if (((ArrayList)localObject2).size() >= 1) {
            return true;
          }
        }
        if (sPreloadingEngines.containsKey(str))
        {
          if (QLog.isColorLevel())
          {
            paramOpenHippyInfo = new StringBuilder();
            paramOpenHippyInfo.append("preloadHippyPage moduleName:");
            paramOpenHippyInfo.append(str);
            paramOpenHippyInfo.append(" isLoading");
            QLog.d("HippyAccessHelper", 2, paramOpenHippyInfo.toString());
          }
          return false;
        }
        sPreloadingEngines.put(str, Long.valueOf(System.currentTimeMillis()));
        Object localObject3 = MobileQQ.sMobileQQ.waitAppRuntime(null);
        localObject2 = getJSInitData((AppRuntime)localObject3, str, null, paramOpenHippyInfo.domain);
        ??? = localObject2;
        if (localObject2 == null) {
          ??? = new JSONObject();
        }
        addPreloadParameters((JSONObject)???, paramOpenHippyInfo.isPredraw);
        if (localObject3 == null) {
          localObject2 = "";
        } else {
          localObject2 = ((AppRuntime)localObject3).getAccount();
        }
        localObject3 = new HippyQQPreloadEngine(null, str, paramOpenHippyInfo.url);
        ((HippyQQPreloadEngine)localObject3).setInitData((JSONObject)???, (JSONObject)???);
        ??? = new HippyAccessHelper.2(str, (HippyQQPreloadEngine)localObject3, (String)localObject2, paramOpenHippyInfo);
        if (paramOpenHippyInfo.isPredraw)
        {
          ((HippyQQPreloadEngine)localObject3).predrawHippy((HippyQQEngine.HippyQQEngineListener)???, false, 0);
          return true;
        }
        ((HippyQQPreloadEngine)localObject3).preloadHippy((HippyQQEngine.HippyQQEngineListener)???, false, 0);
        return true;
      }
      QLog.d("HippyAccessHelper", 1, "preloadHippyPage parameters error");
      return false;
      label526:
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
    paramJSONObject = paramHashMap.keySet().iterator();
    while (paramJSONObject.hasNext())
    {
      Object localObject = paramJSONObject.next();
      try
      {
        localJSONObject.put(localObject.toString(), paramHashMap.get(localObject));
      }
      catch (Exception localException)
      {
        QLog.e("HippyAccessHelper", 1, localException, new Object[0]);
      }
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.HippyAccessHelper
 * JD-Core Version:    0.7.0.1
 */