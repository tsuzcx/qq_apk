package com.tencent.mobileqq.apollo.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.ipc.business.IEngineConfigLoader;
import com.tencent.mobileqq.apollo.model.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ProcessUtil;
import com.tencent.mobileqq.apollo.utils.VersionUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.brickengine.BKCMShowEngine;
import com.tencent.mobileqq.cmshow.brickengine.BKCMShowEngine.CONSTANT;
import com.tencent.mobileqq.ecshop.ad.api.IEcshopAdApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloConfigUtils
{
  public static JSONObject a;
  public static JSONObject b;
  public static ArrayList<Integer> c = new ArrayList();
  public static ArrayList<Integer> d = new ArrayList();
  public static long e;
  public static ArrayList<Integer> f = new ApolloConfigUtils.1();
  public static boolean g = true;
  public static boolean h;
  public static boolean i;
  public static int j;
  public static boolean k;
  public static boolean l;
  private static List<ApolloConfigUtils.AioOpenTips> m;
  
  public static ApolloConfigUtils.AioOpenTips a()
  {
    try
    {
      if (m == null)
      {
        m = new ArrayList();
        m.add(new ApolloConfigUtils.AioOpenTips(HardCodeUtil.a(2131886679), HardCodeUtil.a(2131886680)));
        m.add(new ApolloConfigUtils.AioOpenTips(HardCodeUtil.a(2131886681), HardCodeUtil.a(2131886682)));
      }
      int n = new Random().nextInt(m.size());
      ApolloConfigUtils.AioOpenTips localAioOpenTips = (ApolloConfigUtils.AioOpenTips)m.get(n);
      return localAioOpenTips;
    }
    finally {}
  }
  
  private static void a(Context paramContext, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("freqConfig"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("freqConfig");
      if (paramJSONObject != null)
      {
        int n = paramJSONObject.optInt("drawerBubble", 3);
        int i1 = paramJSONObject.optInt("aioBubble", 3);
        paramContext = paramContext.getSharedPreferences("apollo_sp", 0).edit();
        paramContext.putInt("bubble_max_count", n);
        paramContext.putInt("sp_key_aio_bubble_max_count", i1);
        paramContext.apply();
        n = paramJSONObject.optInt("foregroundEvent");
        ((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).updateRequestInterval(n * 1000 * 60);
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ApolloConstant.H = b(paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("sApolloStoreUrl = ");
      paramString.append(ApolloConstant.H);
      QLog.d("[cmshow]ApolloConfigUtils", 2, paramString.toString());
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (b(paramString1, paramString2)) {
      return;
    }
    if (c(paramString1, paramString2)) {
      return;
    }
    d(paramString1, paramString2);
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if ((paramAppRuntime != null) && (paramAppRuntime.getApplication() != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        MobileQQ localMobileQQ = paramAppRuntime.getApplication();
        paramString = new JSONObject(paramString);
        b(localMobileQQ, paramString);
        d(paramString);
        a(paramAppRuntime, paramString);
        c(paramString);
        b(paramString);
        a(paramBoolean, paramString, "urlConfig");
        a(localMobileQQ, paramString);
        a(paramString);
        paramString = (ApolloManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all");
        if (!paramString.getConfigInitDone())
        {
          paramString.setConfigInitDone(true);
          paramString.initDataAfterConfig();
          return;
        }
      }
      catch (Exception paramString)
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("aplloConfig parse json exception = ");
        paramAppRuntime.append(paramString);
        QLog.e("[cmshow]ApolloConfigUtils", 1, paramAppRuntime.toString());
      }
    }
  }
  
  private static void a(AppRuntime paramAppRuntime)
  {
    boolean bool;
    if (b.optInt("traceReportSwitch", 1) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    g = bool;
    if (b.optInt("disablePreLoadEngineSwitch_V3", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    h = bool;
    if (b.optInt("disablePipeLog_V3", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    BKCMShowEngine.a.a(bool);
    if (b.optInt("disableSettingMeDestroySwitch", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    i = bool;
    j = b.optInt("disableSettingMeDestroyTimeOut", 0);
    if (b.optInt("disablePreLoadcm3DSwitch_V3") == 1) {
      bool = true;
    } else {
      bool = false;
    }
    k = bool;
    e = b.optLong("gameConnHeartbeatInterval");
    if (b.optInt("enableGL3_0", 1) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    l = bool;
    paramAppRuntime = (ApolloManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all");
    if (b.optInt("disableCreateRenderThread", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramAppRuntime.setDisableCreateRenderThread(bool);
    if (b.optInt("apolloEngineLockEnable_V3", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramAppRuntime.setApolloEngineLockEnable(bool);
    QLog.d("[cmshow]ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] sSwitchSet=", b.toString() });
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime != null) {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramAppRuntime = new JSONObject(paramString);
        if (!paramAppRuntime.has("traceConfig")) {
          return;
        }
        d.clear();
        paramAppRuntime = paramAppRuntime.optJSONObject("traceConfig").optJSONArray("featureList");
        if (paramAppRuntime != null)
        {
          if (paramAppRuntime.length() != 0) {
            break label140;
          }
          return;
          if (n < paramAppRuntime.length())
          {
            paramString = paramAppRuntime.optJSONObject(n);
            int i2 = paramString.optInt("featureId");
            if (paramString.optInt("isFocus") != 1) {
              break label145;
            }
            i1 = 1;
            if (i1 != 0) {
              d.add(Integer.valueOf(i2));
            }
            n += 1;
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("[cmshow]ApolloConfigUtils", 1, paramAppRuntime, new Object[0]);
      }
      return;
      label140:
      int n = 0;
      continue;
      label145:
      int i1 = 0;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        QLog.d("[cmshow]ApolloConfigUtils", 1, new Object[] { "parseUrlGrayConfigJson, isUpdate:", Boolean.valueOf(paramBoolean), ",content:", paramString });
        a(paramBoolean, new JSONObject(paramString), "grayUrlConfig");
        return;
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("[cmshow]ApolloConfigUtils", 1, paramAppRuntime, new Object[0]);
      }
    }
  }
  
  private static void a(AppRuntime paramAppRuntime, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("switchSet"))
    {
      b = paramJSONObject.optJSONObject("switchSet");
      if (b != null)
      {
        a(paramAppRuntime);
        c();
        return;
      }
      QLog.e("[cmshow]ApolloConfigUtils", 1, "[parseConfigJson] sSwitchSet null");
    }
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("avConfig"))
    {
      Object localObject = paramJSONObject.optJSONObject("avConfig");
      if (localObject != null)
      {
        paramJSONObject = ((JSONObject)localObject).optString("url");
        localObject = ((JSONObject)localObject).optString("md5");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          ApolloConstant.F = paramJSONObject;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          ApolloConstant.G = (String)localObject;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("gameAVSOUrl =");
          localStringBuilder.append(paramJSONObject);
          localStringBuilder.append(", md5=");
          localStringBuilder.append((String)localObject);
          QLog.d("[cmshow]ApolloConfigUtils", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString)
  {
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray(paramString);
        if (paramJSONObject != null) {
          break label187;
        }
        QLog.e("[cmshow]ApolloConfigUtils", 1, "parseUrlConfig array is null");
        return;
      }
      catch (Exception paramJSONObject)
      {
        JSONObject localJSONObject;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" parse configUrl error e=");
        ((StringBuilder)localObject).append(paramJSONObject.toString());
        QLog.e("[cmshow]ApolloConfigUtils", 1, ((StringBuilder)localObject).toString());
      }
      if (n < paramJSONObject.length())
      {
        localJSONObject = paramJSONObject.getJSONObject(n);
        if (VersionUtil.a("8.8.17", localJSONObject.optString("minVersion"), localJSONObject.optString("maxVersion")))
        {
          localObject = localJSONObject.optString("androidUrl");
          paramJSONObject = (JSONObject)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramJSONObject = localJSONObject.optString("url");
          }
          a(paramString, paramJSONObject);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(" localversion target.url=");
            ((StringBuilder)localObject).append(paramJSONObject);
            QLog.d("[cmshow]ApolloConfigUtils", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          n += 1;
          continue;
        }
      }
      return;
      label187:
      int n = 0;
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    try
    {
      JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
      if (localJSONArray == null)
      {
        QLog.e("[cmshow]ApolloConfigUtils", 1, "parseBaseScriptConfig array is null");
        return;
      }
      Object localObject2 = "8.8.17";
      int n = 0;
      Object localObject1;
      while (n < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(n);
        String str1 = localJSONObject.optString("minVersion");
        String str2 = localJSONObject.optString("maxVersion");
        Object localObject3 = localJSONObject.optString("androidUrl");
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = localJSONObject.optString("url");
        }
        boolean bool = VersionUtil.a("8.8.17", str1, str2);
        if (bool)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            ApolloConstant.T = (String)localObject1;
            d(localJSONObject.optString("id"));
            if (paramBoolean)
            {
              localObject3 = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
              ((SharedPreferences)localObject3).edit().putString("sp_key_config_script", paramJSONObject.toString());
              ((SharedPreferences)localObject3).edit().commit();
            }
          }
          localObject3 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("parseBaseScriptConfig: localversion target.url=");
            ((StringBuilder)localObject3).append((String)localObject1);
            QLog.d("[cmshow]ApolloConfigUtils", 2, new Object[] { ((StringBuilder)localObject3).toString(), ",scriptId:", ApolloConstant.U, ",isUpdate:", Boolean.valueOf(paramBoolean) });
            localObject3 = localObject2;
          }
        }
        else
        {
          localObject3 = localObject2;
          if (VersionUtil.a("8.8.17", str1) < 0)
          {
            localObject3 = localObject2;
            if (VersionUtil.a((String)localObject2, str1) < 0)
            {
              if (!TextUtils.isEmpty((CharSequence)localObject1))
              {
                ApolloConstant.W = (String)localObject1;
                ApolloConstant.X = localJSONObject.optString("id");
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/script/");
                ((StringBuilder)localObject2).append(ApolloConstant.X);
                ((StringBuilder)localObject2).append("/");
                ApolloConstant.Y = ((StringBuilder)localObject2).toString();
              }
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("parseBaseScriptConfig: newestMinVersion=");
                ((StringBuilder)localObject2).append(str1);
                ((StringBuilder)localObject2).append(" target.url=");
                ((StringBuilder)localObject2).append((String)localObject1);
                ((StringBuilder)localObject2).append(", id=");
                ((StringBuilder)localObject2).append(ApolloConstant.X);
                QLog.d("[cmshow]ApolloConfigUtils", 2, ((StringBuilder)localObject2).toString());
              }
              localObject3 = str1;
            }
          }
        }
        n += 1;
        localObject2 = localObject3;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" parse configUrl error e=");
      ((StringBuilder)localObject1).append(paramJSONObject.toString());
      QLog.e("[cmshow]ApolloConfigUtils", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  public static void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject == null) {
      return;
    }
    a(paramJSONObject, "mall");
    a(paramJSONObject, "new_mall");
    a(paramJSONObject, "interact");
    a(paramJSONObject, "game_rank");
    a(paramJSONObject, "game_life");
    a(paramJSONObject, "coin");
    a(paramJSONObject, "my_card");
    a(paramJSONObject, "my_card_detail");
    a(paramJSONObject, "crystal");
    a(paramJSONObject, "production");
    a(paramJSONObject, "game_manage");
    a(paramJSONObject, "game_center");
    a(paramJSONObject, "new_interact");
    a(paramJSONObject, "game_city");
    a(paramJSONObject, "apollo_drawer_game_box_lottie");
    a(paramJSONObject, "apollo_plus_url");
    a(paramJSONObject, "3d_mall");
    a(paramJSONObject, "3d_interact");
    a(paramJSONObject, "3d_game_city");
    a(paramJSONObject, "2d_3available_interact");
    a(paramJSONObject, "base_script", paramBoolean);
  }
  
  private static void a(boolean paramBoolean, JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has(paramString)) {
      a(paramJSONObject.optJSONObject(paramString), paramBoolean);
    }
  }
  
  protected static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replace("[client]", "androidQQ").replace("[version]", "8.8.17.5770").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE).replace("[systemInt]", Integer.toString(Build.VERSION.SDK_INT));
  }
  
  private static void b(Context paramContext, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("apolloSwitch");
    SharedPreUtils.k(paramContext, Integer.parseInt(str));
    paramJSONObject = paramJSONObject.optString("apollo3dSwitch");
    QLog.d("[cmshow]ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] apolloSwitch=", str, ", apollo3dSwitch=", paramJSONObject });
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      SharedPreUtils.l(paramContext, Integer.parseInt(paramJSONObject));
      return;
    }
    SharedPreUtils.l(paramContext, 0);
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      int n;
      try
      {
        paramAppRuntime = new JSONObject(paramString).optJSONArray("preDownLoadRes");
        if (paramAppRuntime == null) {
          return;
        }
        paramString = new HashMap();
        n = 0;
        if (n < paramAppRuntime.length())
        {
          JSONObject localJSONObject1 = paramAppRuntime.optJSONObject(n);
          JSONObject localJSONObject2 = localJSONObject1.optJSONObject("android");
          if (localJSONObject2 == null) {
            break label391;
          }
          ApolloPreDownloadData localApolloPreDownloadData = new ApolloPreDownloadData();
          localApolloPreDownloadData.reportId = localJSONObject1.optString("reportId");
          localApolloPreDownloadData.url = localJSONObject1.optString("url");
          if (TextUtils.isEmpty(localApolloPreDownloadData.url))
          {
            QLog.e("[cmshow]ApolloConfigUtils", 1, new Object[] { "parsePreDownloadConfig url is null, reportId:", localApolloPreDownloadData.reportId });
            break label391;
          }
          localApolloPreDownloadData.resId = MD5FileUtil.b(localApolloPreDownloadData.url);
          localApolloPreDownloadData.md5 = localJSONObject1.optString("md5");
          localApolloPreDownloadData.version = localJSONObject1.optInt("version");
          localApolloPreDownloadData.minVer = localJSONObject1.optString("minQQVer");
          localApolloPreDownloadData.maxVer = localJSONObject1.optString("maxQQVer");
          localApolloPreDownloadData.endTime = localJSONObject1.optLong("endTime");
          if ((!TextUtils.isEmpty(localApolloPreDownloadData.minVer)) && (!TextUtils.isEmpty(localApolloPreDownloadData.maxVer)) && (!VersionUtil.a("8.8.17", localApolloPreDownloadData.minVer, localApolloPreDownloadData.maxVer)))
          {
            QLog.e("[cmshow]ApolloConfigUtils", 1, new Object[] { "parsePreDownloadConfig ver is not correct, url:", localApolloPreDownloadData.url });
            break label391;
          }
          localApolloPreDownloadData.dir = localJSONObject2.optString("dir");
          localApolloPreDownloadData.zipDir = localJSONObject2.optString("zipDir");
          localApolloPreDownloadData.dirType = localJSONObject2.optInt("dirType");
          paramString.put(localApolloPreDownloadData.resId, localApolloPreDownloadData);
          break label391;
        }
        if (paramString.size() > 0)
        {
          ThreadManager.excute(new ApolloConfigUtils.2(paramString), 160, null, true);
          return;
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("[cmshow]ApolloConfigUtils", 1, "parsePreDownloadConfig e:", paramAppRuntime);
      }
      return;
      QLog.e("[cmshow]ApolloConfigUtils", 1, "parsePreDownloadConfig content is null");
      return;
      label391:
      n += 1;
    }
  }
  
  private static void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("shopUrl"))
    {
      paramJSONObject = paramJSONObject.optJSONArray("shopUrl");
      if (paramJSONObject != null)
      {
        int n = 0;
        while (n < paramJSONObject.length())
        {
          Object localObject = paramJSONObject.getJSONObject(n);
          if (VersionUtil.a("8.8.17", ((JSONObject)localObject).optString("minVersion"), ((JSONObject)localObject).optString("maxVersion")))
          {
            localObject = ((JSONObject)localObject).optString("url");
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              a((String)localObject);
              if (!QLog.isColorLevel()) {
                break;
              }
              paramJSONObject = new StringBuilder();
              paramJSONObject.append("localversion target.url=");
              paramJSONObject.append((String)localObject);
              QLog.d("[cmshow]ApolloConfigUtils", 2, paramJSONObject.toString());
              return;
            }
          }
          n += 1;
        }
      }
    }
  }
  
  public static boolean b()
  {
    if (TextUtils.isEmpty(ApolloConstant.U))
    {
      if (ProcessUtil.a()) {
        return false;
      }
      d();
    }
    return true;
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    if ("mall".equals(paramString1))
    {
      a(paramString2);
      return true;
    }
    if ("interact".equals(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        ApolloConstant.I = b(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloStoreInteractUrl=", ApolloConstant.I });
        }
      }
      return true;
    }
    if ("game_rank".equals(paramString1))
    {
      ApolloConstant.x = paramString2;
      return true;
    }
    if ("game_life".equals(paramString1))
    {
      ApolloConstant.y = paramString2;
      return true;
    }
    if ("coin".equals(paramString1))
    {
      ApolloConstant.z = paramString2;
      return true;
    }
    if ("my_card".equals(paramString1))
    {
      ApolloConstant.A = paramString2;
      return true;
    }
    if ("crystal".equals(paramString1))
    {
      ApolloConstant.C = paramString2;
      return true;
    }
    return false;
  }
  
  private static void c()
  {
    long l1 = b.optLong("store_page_load_timeout_value");
    if (l1 > 0L)
    {
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0).edit();
      localEditor.putLong("SP_KEY_APOLLO_STORE_PAGE_LOAD_TIMEOUT_VALUE", l1);
      localEditor.apply();
      QLog.d("[cmshow]ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] sStorePageLoadTimeoutValue=", Long.valueOf(l1) });
      return;
    }
    QLog.d("[cmshow]ApolloConfigUtils", 1, "[parseConfigJson] sStorePageLoadTimeoutValue from config not > 0, use default value. ");
  }
  
  private static void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("errorAction"))
    {
      paramJSONObject = paramJSONObject.optString("errorAction");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        String[] arrayOfString = paramJSONObject.split(",");
        if (arrayOfString != null)
        {
          int n = 0;
          while (n < paramJSONObject.length())
          {
            c.add(Integer.valueOf(Integer.parseInt(arrayOfString[n])));
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("errorAction =");
              localStringBuilder.append(arrayOfString[n]);
              QLog.d("[cmshow]ApolloConfigUtils", 2, localStringBuilder.toString());
            }
            n += 1;
          }
        }
      }
    }
  }
  
  private static boolean c(String paramString1, String paramString2)
  {
    if ("production".equals(paramString1))
    {
      ApolloConstant.D = paramString2;
      return true;
    }
    if ("game_manage".equals(paramString1))
    {
      ApolloConstant.E = paramString2;
      return true;
    }
    if ("my_card_detail".equals(paramString1))
    {
      ApolloConstant.B = paramString2;
      return true;
    }
    if ("new_mall".equals(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        ApolloConstant.J = b(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloNewStoreUrl=", ApolloConstant.J });
        }
      }
      return true;
    }
    if ("game_center".equals(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        ApolloConstant.K = b(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloGameCenterUrl=", ApolloConstant.K });
        }
      }
      return true;
    }
    if ("new_interact".equals(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        ApolloConstant.L = b(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloNewInteractUrl=", ApolloConstant.L });
        }
      }
      return true;
    }
    return false;
  }
  
  private static void d()
  {
    if (ProcessUtil.a()) {
      return;
    }
    ((IEngineConfigLoader)ApolloIPCModule.a(IEngineConfigLoader.class)).initConfig(new ApolloConfigUtils.3());
  }
  
  private static void d(String paramString)
  {
    ApolloConstant.U = paramString;
    paramString = new StringBuilder();
    paramString.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/script/");
    paramString.append(ApolloConstant.U);
    paramString.append("/");
    ApolloConstant.V = paramString.toString();
  }
  
  private static void d(String paramString1, String paramString2)
  {
    if ("game_city".equals(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        ApolloConstant.M = b(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloGameCityUrl=", ApolloConstant.M });
        }
      }
    }
    else
    {
      if ("apollo_drawer_game_box_lottie".equals(paramString1))
      {
        ApolloConstant.R = paramString2;
        return;
      }
      if ("apollo_plus_url".equals(paramString1))
      {
        if (!TextUtils.isEmpty(paramString2)) {
          ApolloConstant.S = paramString2;
        }
      }
      else if ("3d_mall".equals(paramString1))
      {
        if (!TextUtils.isEmpty(paramString2)) {
          ApolloConstant.N = b(paramString2);
        }
      }
      else if ("3d_interact".equals(paramString1))
      {
        if (!TextUtils.isEmpty(paramString2)) {
          ApolloConstant.O = b(paramString2);
        }
      }
      else if ("3d_game_city".equals(paramString1))
      {
        if (!TextUtils.isEmpty(paramString2)) {
          ApolloConstant.P = b(paramString2);
        }
      }
      else if (("2d_3available_interact".equals(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
        ApolloConstant.Q = b(paramString2);
      }
    }
  }
  
  private static void d(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("default")) {
      paramJSONObject = paramJSONObject.optJSONObject("default").optJSONObject("rules");
    } else {
      paramJSONObject = paramJSONObject.optJSONObject("rules");
    }
    a = paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.config.ApolloConfigUtils
 * JD-Core Version:    0.7.0.1
 */