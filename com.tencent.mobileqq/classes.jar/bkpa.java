import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.minigame.utils.PathUtil;
import com.tencent.qqmini.proxyimpl.MiniAdAntiSpamReportUtil.1;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.GetLastClicksActionBridge;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.GetTheLastClickInfoActionBridge;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.TouchInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class bkpa
{
  private static long jdField_a_of_type_Long;
  private static HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static long b;
  private static long c;
  
  private static long a()
  {
    return Math.max(b, jdField_a_of_type_Long);
  }
  
  private static Bundle a(String paramString1, int paramInt1, String paramString2, String paramString3, long paramLong, String paramString4, int paramInt2, String paramString5)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        paramString1 = a(paramString1);
        localBundle.putString("viewid", paramString1);
        localBundle.putInt("lt", paramInt1);
        localBundle.putInt("ig", 1);
        localBundle.putString("refer", "");
        localBundle.putInt("at", 0);
        localBundle.putInt("fh", 0);
        localBundle.putString("wlv", paramString2);
        localBundle.putString("dl", "");
        localBundle.putInt("s", 0);
        localBundle.putString("lc", paramString3);
        localBundle.putString("s_p", paramString4);
        localBundle.putInt("sc_c", paramInt2);
        localBundle.putString("sc_sn", paramString5);
        if (paramInt1 == 0)
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
        break label420;
      }
      paramIMiniAppContext = (IMiniAppContext)localObject4;
      i = k;
      if (((MiniAppInfo)localObject5).launchParam == null) {
        break label420;
      }
      k = ((MiniAppInfo)localObject5).launchParam.scene;
      localObject2 = ((MiniAppInfo)localObject5).launchParam.fromMiniAppId;
      paramIMiniAppContext = (IMiniAppContext)localObject2;
      i = k;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label420;
      }
      if (TextUtils.isEmpty(((MiniAppInfo)localObject5).launchParam.reportData)) {
        break label433;
      }
      paramIMiniAppContext = PathUtil.getJSONQueryString(((MiniAppInfo)localObject5).launchParam.reportData);
      if (paramIMiniAppContext == null) {
        break label438;
      }
      paramIMiniAppContext = paramIMiniAppContext.optString("groupid", "");
      i = k;
    }
    catch (Throwable paramIMiniAppContext)
    {
      label190:
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
        paramIMiniAppContext = bknl.a;
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
      label420:
      localObject4 = paramIMiniAppContext;
      localObject2 = "";
      paramIMiniAppContext = (IMiniAppContext)localObject3;
      break label190;
      label433:
      paramIMiniAppContext = null;
      break;
      label438:
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
  
  public static JSONObject a(IMiniAppContext paramIMiniAppContext, long paramLong, String paramString)
  {
    int j = 0;
    JSONObject localJSONObject = new JSONObject();
    if (paramIMiniAppContext == null)
    {
      QLog.e("MiniAdAntiSpamReportUtil", 1, "miniAppContext == null");
      return localJSONObject;
    }
    String str2 = paramIMiniAppContext.getBaseLibVersion();
    String str3 = (String)paramIMiniAppContext.performAction(ActionBridge.GetLastClicksActionBridge.obtain());
    String str1 = "";
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    paramIMiniAppContext = str1;
    int i = j;
    if (localMiniAppInfo != null)
    {
      paramIMiniAppContext = str1;
      i = j;
      if (localMiniAppInfo.launchParam != null)
      {
        j = localMiniAppInfo.launchParam.scene;
        str1 = localMiniAppInfo.launchParam.fromMiniAppId;
        paramIMiniAppContext = str1;
        i = j;
        if (TextUtils.isEmpty(str1))
        {
          if (TextUtils.isEmpty(localMiniAppInfo.launchParam.reportData)) {
            break label286;
          }
          paramIMiniAppContext = PathUtil.getJSONQueryString(localMiniAppInfo.launchParam.reportData);
          if (paramIMiniAppContext == null) {
            break label291;
          }
          paramIMiniAppContext = paramIMiniAppContext.optString("groupid", "");
          i = j;
        }
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("at", 0);
        localJSONObject.put("ent", a());
        localJSONObject.put("ig", 1);
        localJSONObject.put("it", paramLong);
        localJSONObject.put("lc", str3);
        localJSONObject.put("s_p", paramString);
        localJSONObject.put("sc_s", i);
        if (paramIMiniAppContext != null) {
          continue;
        }
        paramIMiniAppContext = "";
        localJSONObject.put("sc_sn", paramIMiniAppContext);
        localJSONObject.put("st", jdField_a_of_type_Long);
        localJSONObject.put("ud", b());
        localJSONObject.put("wlv", str2);
      }
      catch (JSONException paramIMiniAppContext)
      {
        label286:
        label291:
        paramIMiniAppContext.printStackTrace();
        continue;
      }
      return localJSONObject;
      paramIMiniAppContext = null;
      break;
      paramIMiniAppContext = "";
      i = j;
    }
  }
  
  public static JSONObject a(IMiniAppContext paramIMiniAppContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    if ((paramIMiniAppContext == null) || (!paramIMiniAppContext.isMiniGame()) || (TextUtils.isEmpty(paramString1))) {
      return null;
    }
    String str2 = paramIMiniAppContext.getBaseLibVersion();
    String str3 = (String)paramIMiniAppContext.performAction(ActionBridge.GetLastClicksActionBridge.obtain());
    int j = 0;
    String str1 = "";
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    int i = j;
    paramIMiniAppContext = str1;
    if (localMiniAppInfo != null)
    {
      i = j;
      paramIMiniAppContext = str1;
      if (localMiniAppInfo.launchParam != null)
      {
        j = localMiniAppInfo.launchParam.scene;
        str1 = localMiniAppInfo.launchParam.fromMiniAppId;
        i = j;
        paramIMiniAppContext = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramIMiniAppContext = localObject;
          if (!TextUtils.isEmpty(localMiniAppInfo.launchParam.reportData)) {
            paramIMiniAppContext = PathUtil.getJSONQueryString(localMiniAppInfo.launchParam.reportData);
          }
          if (paramIMiniAppContext == null) {
            break label180;
          }
        }
      }
    }
    label180:
    for (paramIMiniAppContext = paramIMiniAppContext.optString("groupid", "");; paramIMiniAppContext = "")
    {
      i = j;
      return a(paramString1, 3, str2, str3, 0L, paramString2, i, paramIMiniAppContext);
    }
  }
  
  private static JSONObject a(String paramString1, int paramInt1, String paramString2, String paramString3, long paramLong, String paramString4, int paramInt2, String paramString5)
  {
    return a(a(paramString1, paramInt1, paramString2, paramString3, paramLong, paramString4, paramInt2, paramString5));
  }
  
  public static void a()
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
    b = System.currentTimeMillis();
    c = 0L;
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    QLog.i("MiniAdAntiSpamReportUtil", 1, "reportParams=" + paramBundle.toString());
    ThreadManager.excute(new MiniAdAntiSpamReportUtil.1(paramBundle), 128, null, true);
  }
  
  public static void a(IMiniAppContext paramIMiniAppContext, String paramString1, long paramLong, String paramString2, int paramInt)
  {
    if ((paramIMiniAppContext == null) || (!paramIMiniAppContext.isMiniGame()) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    String str2 = paramIMiniAppContext.getBaseLibVersion();
    String str3 = (String)paramIMiniAppContext.performAction(ActionBridge.GetLastClicksActionBridge.obtain());
    int j = 0;
    String str1 = "";
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    int i = j;
    paramIMiniAppContext = str1;
    if (localMiniAppInfo != null)
    {
      i = j;
      paramIMiniAppContext = str1;
      if (localMiniAppInfo.launchParam != null)
      {
        j = localMiniAppInfo.launchParam.scene;
        str1 = localMiniAppInfo.launchParam.fromMiniAppId;
        i = j;
        paramIMiniAppContext = str1;
        if (TextUtils.isEmpty(str1))
        {
          if (TextUtils.isEmpty(localMiniAppInfo.launchParam.reportData)) {
            break label183;
          }
          paramIMiniAppContext = PathUtil.getJSONQueryString(localMiniAppInfo.launchParam.reportData);
          if (paramIMiniAppContext == null) {
            break label188;
          }
        }
      }
    }
    label183:
    label188:
    for (paramIMiniAppContext = paramIMiniAppContext.optString("groupid", "");; paramIMiniAppContext = "")
    {
      i = j;
      a(a(paramString1, paramInt, str2, str3, paramLong, paramString2, i, paramIMiniAppContext));
      return;
      paramIMiniAppContext = null;
      break;
    }
  }
  
  public static void a(IMiniAppContext paramIMiniAppContext, String paramString1, String paramString2)
  {
    if ((paramIMiniAppContext == null) || (!paramIMiniAppContext.isMiniGame()) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    String str2 = paramIMiniAppContext.getBaseLibVersion();
    String str3 = (String)paramIMiniAppContext.performAction(ActionBridge.GetLastClicksActionBridge.obtain());
    String str1 = "";
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    int i;
    if ((localMiniAppInfo != null) && (localMiniAppInfo.launchParam != null))
    {
      int j = localMiniAppInfo.launchParam.scene;
      str1 = localMiniAppInfo.launchParam.fromMiniAppId;
      i = j;
      paramIMiniAppContext = str1;
      if (TextUtils.isEmpty(str1))
      {
        if (TextUtils.isEmpty(localMiniAppInfo.launchParam.reportData)) {
          break label159;
        }
        paramIMiniAppContext = PathUtil.getJSONQueryString(localMiniAppInfo.launchParam.reportData);
        if (paramIMiniAppContext == null) {
          break label164;
        }
        paramIMiniAppContext = paramIMiniAppContext.optString("groupid", "");
        label141:
        i = j;
      }
    }
    for (;;)
    {
      a(paramString1, 0, str2, str3, 0L, paramString2, i, paramIMiniAppContext);
      return;
      label159:
      paramIMiniAppContext = null;
      break;
      label164:
      paramIMiniAppContext = "";
      break label141;
      i = 0;
      paramIMiniAppContext = str1;
    }
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
 * Qualified Name:     bkpa
 * JD-Core Version:    0.7.0.1
 */