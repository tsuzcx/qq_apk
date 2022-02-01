import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.ui.SwipeBackLayout;
import com.tencent.mobileqq.mini.appbrand.ui.SwipeBackLayout.TouchInfo;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.statistic.StatisticsManager;
import com.tencent.qqmini.minigame.utils.PathUtil;
import com.tencent.qqmini.proxyimpl.MiniAdAntiSpamReportUtil.1;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.GetLastClicksActionBridge;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.GetTheLastClickInfoActionBridge;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.TouchInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class bkxw
{
  private static long jdField_a_of_type_Long;
  private static HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static long b;
  private static long c;
  
  private static long a()
  {
    return Math.max(b, jdField_a_of_type_Long);
  }
  
  private static Bundle a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        paramString1 = a(paramString1);
        localBundle.putString("viewid", paramString1);
        localBundle.putInt("lt", paramInt);
        localBundle.putInt("ig", 0);
        localBundle.putString("refer", "");
        localBundle.putInt("at", 0);
        localBundle.putInt("fh", 1);
        localBundle.putString("wlf", paramString2);
        localBundle.putString("dl", "");
        localBundle.putInt("s", 0);
        localBundle.putString("lc", paramString3);
        if (paramInt == 0)
        {
          long l2 = System.currentTimeMillis();
          l1 = l2;
          if (!TextUtils.isEmpty(paramString1))
          {
            jdField_a_of_type_JavaUtilHashMap.put(paramString1, Long.valueOf(l2));
            l1 = l2;
          }
          localBundle.putLong("it", l1);
          localBundle.putLong("st", jdField_a_of_type_Long);
          localBundle.putLong("ent", a());
          localBundle.putLong("et", paramLong);
          localBundle.putLong("ct", 0L);
          localBundle.putLong("ud", b());
          return localBundle;
        }
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString1 = (Long)jdField_a_of_type_JavaUtilHashMap.get(paramString1);
          if (paramString1 != null)
          {
            l1 = paramString1.longValue();
            continue;
          }
        }
        long l1 = 0L;
      }
      catch (Exception paramString1)
      {
        QLog.e("MiniAdAntiSpamReportUtil", 1, "createReportString error.", paramString1);
        return localBundle;
      }
    }
  }
  
  public static String a(Activity paramActivity, String paramString, long paramLong, boolean paramBoolean, BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString))) {
      return new JSONObject().toString();
    }
    String str = "";
    int i = 0;
    int j = 0;
    Object localObject1 = "";
    if (paramBoolean) {}
    for (;;)
    {
      int k;
      try
      {
        paramActivity = GameRuntimeLoaderManager.g().getBindRuntimeLoader(paramActivity);
        if (paramActivity == null) {
          return new JSONObject().toString();
        }
        str = paramActivity.getJsVersion();
        paramBaseJsPluginEngine = paramActivity.getGameEngine();
        Object localObject2;
        if (paramBaseJsPluginEngine == null)
        {
          paramBaseJsPluginEngine = null;
          k = 0;
          localObject2 = paramActivity.getGameInfoManager();
          paramActivity = (Activity)localObject1;
          i = j;
          if (localObject2 != null)
          {
            j = ((GameInfoManager)localObject2).getScene();
            localObject1 = ((GameInfoManager)localObject2).getFromMiniAppId();
            paramActivity = (Activity)localObject1;
            i = j;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              paramActivity = ((GameInfoManager)localObject2).getGroupIdFromReportData();
              i = j;
              break label318;
              return a(paramBoolean, paramActivity, str, i, j, (String)localObject1, paramBaseJsPluginEngine, paramString, paramLong);
            }
          }
        }
        else
        {
          paramBaseJsPluginEngine = paramBaseJsPluginEngine.getStatisticsManager().getLastClickInfo();
          continue;
          j = paramBaseJsPluginEngine.appBrandRuntime.getLaunchAppScene();
          localObject2 = paramBaseJsPluginEngine.appBrandRuntime.getCurPage().getUrl();
          localObject1 = paramBaseJsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam.fromMiniAppId;
          if (paramBaseJsPluginEngine.appBrandRuntime.getPageWebView().getView().getWidth() > DisplayUtil.getScreenHeight(paramActivity)) {
            i = 1;
          }
          paramActivity = SwipeBackLayout.getTouchInfoList();
          paramBaseJsPluginEngine = ((SwipeBackLayout.TouchInfo)paramActivity.get(paramActivity.size() - 1)).toJsonStr();
          paramActivity = (Activity)localObject2;
          continue;
        }
        localObject1 = paramActivity;
      }
      catch (Throwable paramActivity)
      {
        QLog.e("MiniAdAntiSpamReportUtil", 1, "getRewardedVideoAdExposeReportParam get an Exception:" + paramActivity.toString());
        return new JSONObject().toString();
      }
      label318:
      paramActivity = "";
      j = i;
      i = k;
    }
  }
  
  public static String a(IMiniAppContext paramIMiniAppContext, String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramIMiniAppContext == null) || (TextUtils.isEmpty(paramString))) {
      return new JSONObject().toString();
    }
    Object localObject2 = paramIMiniAppContext.getBaseLibVersion();
    Object localObject5 = "";
    int j = 0;
    int k = 0;
    Object localObject4 = "";
    if (paramBoolean) {}
    Object localObject1;
    try
    {
      localObject3 = paramIMiniAppContext.getBaseLibVersion();
      localObject1 = (String)paramIMiniAppContext.performAction(ActionBridge.GetTheLastClickInfoActionBridge.obtain());
      j = 0;
      localObject5 = paramIMiniAppContext.getMiniAppInfo();
      paramIMiniAppContext = (IMiniAppContext)localObject4;
      i = k;
      if (localObject5 == null) {
        break label422;
      }
      paramIMiniAppContext = (IMiniAppContext)localObject4;
      i = k;
      if (((MiniAppInfo)localObject5).launchParam == null) {
        break label422;
      }
      k = ((MiniAppInfo)localObject5).launchParam.scene;
      localObject2 = ((MiniAppInfo)localObject5).launchParam.fromMiniAppId;
      paramIMiniAppContext = (IMiniAppContext)localObject2;
      i = k;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label422;
      }
      if (TextUtils.isEmpty(((MiniAppInfo)localObject5).launchParam.reportData)) {
        break label435;
      }
      paramIMiniAppContext = PathUtil.getJSONQueryString(((MiniAppInfo)localObject5).launchParam.reportData);
      if (paramIMiniAppContext == null) {
        break label440;
      }
      paramIMiniAppContext = paramIMiniAppContext.optString("groupid", "");
      i = k;
    }
    catch (Throwable paramIMiniAppContext)
    {
      label191:
      QLog.e("MiniAdAntiSpamReportUtil", 1, "getRewardedVideoAdExposeReportParamForSDK get an Exception:" + paramIMiniAppContext.toString());
      return new JSONObject().toString();
    }
    return a(paramBoolean, (String)localObject2, paramIMiniAppContext, j, i, (String)localObject4, (String)localObject1, paramString, paramLong);
    Object localObject3 = null;
    if ((paramIMiniAppContext instanceof BaseRuntime))
    {
      localObject1 = (BaseRuntime)paramIMiniAppContext;
      localObject3 = ((BaseRuntime)localObject1).getPage().getPageInfo(10);
    }
    for (int i = ((BaseRuntime)localObject1).getMiniAppInfo().launchParam.scene;; i = 0)
    {
      if (localObject3 != null)
      {
        localObject4 = ((AppPageInfo)localObject3).pageUrl;
        localObject1 = localObject4;
        if (((AppPageInfo)localObject3).windowHeight > DisplayUtil.getScreenHeight(paramIMiniAppContext.getAttachedActivity())) {
          j = 1;
        }
      }
      for (localObject1 = localObject4;; localObject1 = "")
      {
        localObject4 = paramIMiniAppContext.getMiniAppInfo().launchParam.fromMiniAppId;
        paramIMiniAppContext = bkwo.a;
        if ((paramIMiniAppContext != null) && (paramIMiniAppContext.size() > 0))
        {
          localObject3 = ((TouchInfo)paramIMiniAppContext.get(paramIMiniAppContext.size() - 1)).toJsonStr();
          paramIMiniAppContext = (IMiniAppContext)localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
          break;
        }
        paramIMiniAppContext = (IMiniAppContext)localObject2;
        localObject2 = localObject1;
        localObject1 = localObject5;
        break;
      }
    }
    for (;;)
    {
      label422:
      localObject4 = paramIMiniAppContext;
      localObject2 = "";
      paramIMiniAppContext = (IMiniAppContext)localObject3;
      break label191;
      label435:
      paramIMiniAppContext = null;
      break;
      label440:
      paramIMiniAppContext = "";
      i = k;
    }
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = Uri.parse(paramString).getQueryParameter("viewid");
      paramString = str;
    } while (str != null);
    return "";
  }
  
  private static String a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    int i = 0;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("lt", 2);
      if (paramBoolean) {
        i = 1;
      }
      localJSONObject.put("ig", i);
      localJSONObject.put("refer", paramString1);
      localJSONObject.put("at", 0);
      localJSONObject.put("fh", 1);
      localJSONObject.put("wlv", paramString2);
      localJSONObject.put("dl", "");
      localJSONObject.put("s", paramInt1);
      if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString5)) {
        localJSONObject.put("it", jdField_a_of_type_JavaUtilHashMap.get(paramString5));
      }
      localJSONObject.put("st", jdField_a_of_type_Long);
      localJSONObject.put("ent", a());
      localJSONObject.put("et", paramLong);
      localJSONObject.put("ct", 0);
      localJSONObject.put("ud", b());
      localJSONObject.put("ic", 0);
      localJSONObject.put("sc_s", paramInt2);
      paramString1 = paramString3;
      if (paramString3 == null) {
        paramString1 = "";
      }
      localJSONObject.put("sc_sn", paramString1);
      if (!TextUtils.isEmpty(paramString4))
      {
        paramString1 = new JSONObject(paramString4);
        localJSONObject.put("tsx", paramString1.getInt("tsx"));
        localJSONObject.put("tsy", paramString1.getInt("tsy"));
        localJSONObject.put("tex", paramString1.getInt("tex"));
        localJSONObject.put("tey", paramString1.getInt("tey"));
        localJSONObject.put("td", paramString1.getLong("td"));
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QLog.e("MiniAdAntiSpamReportUtil", 1, "createRewardedVideoAdReportParams error.", paramString1);
      }
    }
    return localJSONObject.toString();
  }
  
  public static JSONObject a(Context paramContext, String paramString)
  {
    Object localObject = null;
    paramContext = GameRuntimeLoaderManager.g().getBindRuntimeLoader(paramContext);
    if (paramContext == null) {
      return null;
    }
    String str = paramContext.getJsVersion();
    paramContext = paramContext.getGameEngine();
    if (paramContext == null) {}
    for (paramContext = localObject;; paramContext = paramContext.getStatisticsManager().getLastClicks()) {
      return a(paramString, 3, str, paramContext, 0L);
    }
  }
  
  private static JSONObject a(Bundle paramBundle)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      String str;
      Object localObject;
      try
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = paramBundle.get(str);
          if ((localObject instanceof String)) {
            localJSONObject.put(str, paramBundle.getString(str));
          }
        }
        else
        {
          return localJSONObject;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("MiniAdAntiSpamReportUtil", 1, "paramsToJson error.", paramBundle);
      }
      if ((localObject instanceof Integer)) {
        localJSONObject.put(str, paramBundle.getInt(str));
      } else if ((localObject instanceof Long)) {
        localJSONObject.put(str, paramBundle.getLong(str));
      }
    }
  }
  
  public static JSONObject a(IMiniAppContext paramIMiniAppContext, String paramString)
  {
    if ((paramIMiniAppContext == null) || (!paramIMiniAppContext.isMiniGame()) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    return a(paramString, 3, paramIMiniAppContext.getBaseLibVersion(), (String)paramIMiniAppContext.performAction(ActionBridge.GetLastClicksActionBridge.obtain()), 0L);
  }
  
  private static JSONObject a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    return a(a(paramString1, paramInt, paramString2, paramString3, paramLong));
  }
  
  public static void a()
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
    b = System.currentTimeMillis();
    c = 0L;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      paramContext = GameRuntimeLoaderManager.g().getBindRuntimeLoader(paramContext);
    } while (paramContext == null);
    String str = paramContext.getJsVersion();
    paramContext = paramContext.getGameEngine();
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramContext.getStatisticsManager().getLastClicks())
    {
      a(paramString, 0, str, paramContext, 0L);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      paramContext = GameRuntimeLoaderManager.g().getBindRuntimeLoader(paramContext);
    } while (paramContext == null);
    String str = paramContext.getJsVersion();
    paramContext = paramContext.getGameEngine();
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramContext.getStatisticsManager().getLastClicks())
    {
      a(a(paramString, 5, str, paramContext, paramLong));
      return;
    }
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    QLog.i("MiniAdAntiSpamReportUtil", 1, "reportParams=" + paramBundle.toString());
    ThreadManager.excute(new MiniAdAntiSpamReportUtil.1(paramBundle), 128, null, true);
  }
  
  public static void a(IMiniAppContext paramIMiniAppContext, String paramString)
  {
    if ((paramIMiniAppContext == null) || (!paramIMiniAppContext.isMiniGame()) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(paramString, 0, paramIMiniAppContext.getBaseLibVersion(), (String)paramIMiniAppContext.performAction(ActionBridge.GetLastClicksActionBridge.obtain()), 0L);
  }
  
  public static void a(IMiniAppContext paramIMiniAppContext, String paramString, long paramLong)
  {
    if ((paramIMiniAppContext == null) || (!paramIMiniAppContext.isMiniGame()) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(a(paramString, 5, paramIMiniAppContext.getBaseLibVersion(), (String)paramIMiniAppContext.performAction(ActionBridge.GetLastClicksActionBridge.obtain()), paramLong));
  }
  
  public static void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString)) {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(l));
    }
  }
  
  private static long b()
  {
    return c + System.currentTimeMillis() - a();
  }
  
  public static void b()
  {
    b = System.currentTimeMillis();
  }
  
  public static void c()
  {
    c += System.currentTimeMillis() - b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxw
 * JD-Core Version:    0.7.0.1
 */