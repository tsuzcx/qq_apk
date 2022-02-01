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
import com.tencent.mobileqq.apollo.game.ApolloGameConfig;
import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.ipc.business.IEngineConfigLoader;
import com.tencent.mobileqq.apollo.model.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ProcessUtil;
import com.tencent.mobileqq.apollo.utils.VersionUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
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
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloConfigUtils
{
  public static int a;
  public static long a;
  public static String a;
  public static ArrayList<Integer> a;
  private static List<ApolloConfigUtils.AioOpenTips> a;
  public static JSONArray a;
  public static JSONObject a;
  public static boolean a;
  public static int b;
  public static ArrayList<Integer> b;
  public static JSONObject b;
  public static boolean b;
  public static ArrayList<Integer> c;
  public static JSONObject c;
  public static boolean c;
  public static ArrayList<Integer> d;
  public static JSONObject d;
  public static boolean d;
  public static ArrayList<Integer> e;
  public static JSONObject e;
  public static boolean e;
  private static JSONObject f;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_c_of_type_OrgJsonJSONObject = null;
    jdField_d_of_type_OrgJsonJSONObject = null;
    jdField_e_of_type_OrgJsonJSONObject = null;
    jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    jdField_e_of_type_JavaUtilArrayList = new ApolloConfigUtils.1();
    jdField_a_of_type_Boolean = true;
  }
  
  public static ApolloConfigUtils.AioOpenTips a()
  {
    try
    {
      if (jdField_a_of_type_JavaUtilList == null)
      {
        jdField_a_of_type_JavaUtilList = new ArrayList();
        jdField_a_of_type_JavaUtilList.add(new ApolloConfigUtils.AioOpenTips(HardCodeUtil.a(2131690029), HardCodeUtil.a(2131690030)));
        jdField_a_of_type_JavaUtilList.add(new ApolloConfigUtils.AioOpenTips(HardCodeUtil.a(2131690031), HardCodeUtil.a(2131690032)));
      }
      int i = new Random().nextInt(jdField_a_of_type_JavaUtilList.size());
      ApolloConfigUtils.AioOpenTips localAioOpenTips = (ApolloConfigUtils.AioOpenTips)jdField_a_of_type_JavaUtilList.get(i);
      return localAioOpenTips;
    }
    finally {}
  }
  
  protected static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replace("[client]", "androidQQ").replace("[version]", "8.7.0.5295").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE).replace("[systemInt]", Integer.toString(Build.VERSION.SDK_INT));
  }
  
  private static void a()
  {
    if (ProcessUtil.a()) {
      return;
    }
    ((IEngineConfigLoader)ApolloIPCModule.a(IEngineConfigLoader.class)).initConfig(new ApolloConfigUtils.3());
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ApolloConstant.z = a(paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("sApolloStoreUrl = ");
      paramString.append(ApolloConstant.z);
      QLog.d("[cmshow]ApolloConfigUtils", 2, paramString.toString());
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ("mall".equals(paramString1))
    {
      a(paramString2);
      return;
    }
    if ("interact".equals(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        ApolloConstant.A = a(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloStoreInteractUrl=", ApolloConstant.A });
        }
      }
    }
    else
    {
      if ("game_rank".equals(paramString1))
      {
        ApolloConstant.p = paramString2;
        return;
      }
      if ("game_life".equals(paramString1))
      {
        ApolloConstant.q = paramString2;
        return;
      }
      if ("coin".equals(paramString1))
      {
        ApolloConstant.r = paramString2;
        return;
      }
      if ("my_card".equals(paramString1))
      {
        ApolloConstant.s = paramString2;
        return;
      }
      if ("crystal".equals(paramString1))
      {
        ApolloConstant.u = paramString2;
        return;
      }
      if ("production".equals(paramString1))
      {
        ApolloConstant.v = paramString2;
        return;
      }
      if ("game_manage".equals(paramString1))
      {
        ApolloConstant.w = paramString2;
        return;
      }
      if ("my_card_detail".equals(paramString1))
      {
        ApolloConstant.t = paramString2;
        return;
      }
      if ("new_mall".equals(paramString1))
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          ApolloConstant.B = a(paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloNewStoreUrl=", ApolloConstant.B });
          }
        }
      }
      else if ("game_center".equals(paramString1))
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          ApolloConstant.C = a(paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloGameCenterUrl=", ApolloConstant.C });
          }
        }
      }
      else if ("new_interact".equals(paramString1))
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          ApolloConstant.D = a(paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloNewInteractUrl=", ApolloConstant.D });
          }
        }
      }
      else if ("game_city".equals(paramString1))
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          ApolloConstant.E = a(paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloGameCityUrl=", ApolloConstant.E });
          }
        }
      }
      else
      {
        if ("apollo_drawer_game_box_lottie".equals(paramString1))
        {
          ApolloConstant.J = paramString2;
          return;
        }
        if ("apollo_plus_url".equals(paramString1))
        {
          if (!TextUtils.isEmpty(paramString2)) {
            ApolloConstant.K = paramString2;
          }
        }
        else if ("3d_mall".equals(paramString1))
        {
          if (!TextUtils.isEmpty(paramString2)) {
            ApolloConstant.F = a(paramString2);
          }
        }
        else if ("3d_interact".equals(paramString1))
        {
          if (!TextUtils.isEmpty(paramString2)) {
            ApolloConstant.G = a(paramString2);
          }
        }
        else if ("3d_game_city".equals(paramString1))
        {
          if (!TextUtils.isEmpty(paramString2)) {
            ApolloConstant.H = a(paramString2);
          }
        }
        else if (("2d_3available_interact".equals(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
          ApolloConstant.I = a(paramString2);
        }
      }
    }
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if ((paramAppRuntime != null) && (paramAppRuntime.getApplication() != null)) {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = paramAppRuntime.getApplication();
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optString("apolloSwitch");
        SharedPreUtils.k((Context)localObject1, Integer.parseInt(paramString));
        Object localObject2 = localJSONObject.optString("apollo3dSwitch");
        QLog.d("[cmshow]ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] apolloSwitch=", paramString, ", apollo3dSwitch=", localObject2 });
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          SharedPreUtils.l((Context)localObject1, Integer.parseInt((String)localObject2));
        } else {
          SharedPreUtils.l((Context)localObject1, 0);
        }
        bool = localJSONObject.has("default");
        if (bool) {
          paramString = localJSONObject.optJSONObject("default").optJSONObject("rules");
        } else {
          paramString = localJSONObject.optJSONObject("rules");
        }
        jdField_a_of_type_OrgJsonJSONObject = paramString;
        int j;
        if (localJSONObject.has("switchSet"))
        {
          jdField_b_of_type_OrgJsonJSONObject = localJSONObject.optJSONObject("switchSet");
          if (jdField_b_of_type_OrgJsonJSONObject != null)
          {
            paramString = jdField_b_of_type_OrgJsonJSONObject.optString("gameMenuBlackList");
            QLog.d("[cmshow]ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] gameMenuBlackListStr=", paramString });
            bool = TextUtils.isEmpty(paramString);
            if (!bool)
            {
              paramString = paramString.split("\\|");
              if (paramString != null)
              {
                i = paramString.length;
                if (i > 0) {
                  try
                  {
                    j = paramString.length;
                    i = 0;
                    if (i < j)
                    {
                      localObject2 = paramString[i];
                      jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(Integer.parseInt((String)localObject2)));
                      i += 1;
                      continue;
                    }
                    if (jdField_b_of_type_OrgJsonJSONObject.optInt("traceReportSwitch", 1) != 1) {
                      break label1448;
                    }
                  }
                  catch (Exception paramString)
                  {
                    QLog.e("[cmshow]ApolloConfigUtils", 1, "[parseConfigJson] parse game id error, e=", paramString);
                  }
                }
              }
            }
            bool = true;
            jdField_a_of_type_Boolean = bool;
            if (jdField_b_of_type_OrgJsonJSONObject.optInt("disablePreLoadEngineSwitch_V3", 0) != 1) {
              break label1454;
            }
            bool = true;
            jdField_b_of_type_Boolean = bool;
            if (jdField_b_of_type_OrgJsonJSONObject.optInt("disablePipeLog_V3", 0) != 1) {
              break label1460;
            }
            bool = true;
            BKCMShowEngine.a.a(bool);
            if (jdField_b_of_type_OrgJsonJSONObject.optInt("disableSettingMeDestroySwitch", 0) != 1) {
              break label1466;
            }
            bool = true;
            jdField_c_of_type_Boolean = bool;
            jdField_b_of_type_Int = jdField_b_of_type_OrgJsonJSONObject.optInt("disableSettingMeDestroyTimeOut", 0);
            if (jdField_b_of_type_OrgJsonJSONObject.optInt("disablePreLoadcm3DSwitch_V3") != 1) {
              break label1472;
            }
            bool = true;
            jdField_d_of_type_Boolean = bool;
            jdField_a_of_type_Long = jdField_b_of_type_OrgJsonJSONObject.optLong("gameConnHeartbeatInterval");
            if (jdField_b_of_type_OrgJsonJSONObject.optInt("enableGL3_0", 1) != 1) {
              break label1478;
            }
            bool = true;
            jdField_e_of_type_Boolean = bool;
            paramString = (ApolloManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all");
            if (jdField_b_of_type_OrgJsonJSONObject.optInt("disableCreateRenderThread", 0) != 1) {
              break label1484;
            }
            bool = true;
            paramString.setDisableCreateRenderThread(bool);
            if (jdField_b_of_type_OrgJsonJSONObject.optInt("apolloEngineLockEnable_V3", 0) != 1) {
              break label1490;
            }
            bool = true;
            paramString.setApolloEngineLockEnable(bool);
            QLog.d("[cmshow]ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] sSwitchSet=", jdField_b_of_type_OrgJsonJSONObject.toString() });
            long l = jdField_b_of_type_OrgJsonJSONObject.optLong("store_page_load_timeout_value");
            if (l > 0L)
            {
              paramString = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0).edit();
              paramString.putLong("SP_KEY_APOLLO_STORE_PAGE_LOAD_TIMEOUT_VALUE", l);
              paramString.apply();
              QLog.d("[cmshow]ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] sStorePageLoadTimeoutValue=", Long.valueOf(l) });
            }
            else
            {
              QLog.d("[cmshow]ApolloConfigUtils", 1, "[parseConfigJson] sStorePageLoadTimeoutValue from config not > 0, use default value. ");
            }
            paramString = jdField_b_of_type_OrgJsonJSONObject.optString("transparentGameList");
            QLog.d("[cmshow]ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] transparentGameListStr=", paramString });
            if (TextUtils.isEmpty(paramString)) {
              continue;
            }
            paramString = paramString.split("\\|");
            if (paramString == null) {
              continue;
            }
            i = paramString.length;
            if (i <= 0) {
              continue;
            }
            try
            {
              j = paramString.length;
              i = 0;
              if (i < j)
              {
                localObject2 = paramString[i];
                jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(Integer.parseInt((String)localObject2)));
                i += 1;
                continue;
                QLog.e("[cmshow]ApolloConfigUtils", 1, "[parseConfigJson] sSwitchSet null");
              }
            }
            catch (Exception paramString)
            {
              QLog.e("[cmshow]ApolloConfigUtils", 1, "[parseConfigJson] parse trans game id error, e=", paramString);
            }
          }
        }
        if (localJSONObject.has("errorAction"))
        {
          paramString = localJSONObject.optString("errorAction");
          if (!TextUtils.isEmpty(paramString))
          {
            localObject2 = paramString.split(",");
            if (localObject2 != null)
            {
              i = 0;
              if (i < paramString.length())
              {
                jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(Integer.parseInt(localObject2[i])));
                if (!QLog.isColorLevel()) {
                  break label1496;
                }
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("errorAction =");
                localStringBuilder.append(localObject2[i]);
                QLog.d("[cmshow]ApolloConfigUtils", 2, localStringBuilder.toString());
                break label1496;
              }
            }
          }
        }
        if (localJSONObject.has("shopUrl"))
        {
          paramString = localJSONObject.optJSONArray("shopUrl");
          if (paramString != null)
          {
            i = 0;
            if (i < paramString.length())
            {
              localObject2 = paramString.getJSONObject(i);
              if (!VersionUtil.a("8.7.0", ((JSONObject)localObject2).optString("minVersion"), ((JSONObject)localObject2).optString("maxVersion"))) {
                break label1503;
              }
              localObject2 = ((JSONObject)localObject2).optString("url");
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label1503;
              }
              a((String)localObject2);
              if (QLog.isColorLevel())
              {
                paramString = new StringBuilder();
                paramString.append("localversion target.url=");
                paramString.append((String)localObject2);
                QLog.d("[cmshow]ApolloConfigUtils", 2, paramString.toString());
              }
            }
          }
        }
        if (localJSONObject.has("urlConfig")) {
          a(localJSONObject.optJSONObject("urlConfig"), paramBoolean);
        }
        if (localJSONObject.has("freqConfig"))
        {
          paramString = localJSONObject.optJSONObject("freqConfig");
          if (paramString != null)
          {
            i = paramString.optInt("drawerBubble", 3);
            j = paramString.optInt("aioBubble", 3);
            localObject1 = ((Context)localObject1).getSharedPreferences("apollo_sp", 0);
            ((SharedPreferences)localObject1).edit().putInt("bubble_max_count", i);
            ((SharedPreferences)localObject1).edit().putInt("sp_key_aio_bubble_max_count", j);
            ((SharedPreferences)localObject1).edit().commit();
            i = paramString.optInt("foregroundEvent");
            ((IEcshopAdApi)QRoute.api(IEcshopAdApi.class)).updateRequestInterval(i * 1000 * 60);
          }
        }
        if (localJSONObject.has("avConfig"))
        {
          localObject1 = localJSONObject.optJSONObject("avConfig");
          if (localObject1 != null)
          {
            paramString = ((JSONObject)localObject1).optString("url");
            localObject1 = ((JSONObject)localObject1).optString("md5");
            if (!TextUtils.isEmpty(paramString)) {
              ApolloConstant.x = paramString;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ApolloConstant.y = (String)localObject1;
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("gameAVSOUrl =");
              ((StringBuilder)localObject2).append(paramString);
              ((StringBuilder)localObject2).append(", md5=");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("[cmshow]ApolloConfigUtils", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
        if (localJSONObject.has("gameConfig"))
        {
          paramString = localJSONObject.optJSONObject("gameConfig");
          if ((paramString != null) && (paramString.has("aio")))
          {
            paramString = paramString.getJSONObject("aio");
            paramString.optString("aioPanelTip");
            paramString.optString("gamePanelTip");
            paramString.optString("gamePanelBg");
            paramString.optString("gamePanelBgColor");
          }
        }
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
      return;
      label1448:
      boolean bool = false;
      continue;
      label1454:
      bool = false;
      continue;
      label1460:
      bool = false;
      continue;
      label1466:
      bool = false;
      continue;
      label1472:
      bool = false;
      continue;
      label1478:
      bool = false;
      continue;
      label1484:
      bool = false;
      continue;
      label1490:
      bool = false;
      continue;
      label1496:
      i += 1;
      continue;
      label1503:
      i += 1;
    }
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
        jdField_d_of_type_JavaUtilArrayList.clear();
        paramAppRuntime = paramAppRuntime.optJSONObject("traceConfig").optJSONArray("featureList");
        if (paramAppRuntime != null)
        {
          if (paramAppRuntime.length() != 0) {
            break label140;
          }
          return;
          if (i < paramAppRuntime.length())
          {
            paramString = paramAppRuntime.optJSONObject(i);
            int k = paramString.optInt("featureId");
            if (paramString.optInt("isFocus") != 1) {
              break label145;
            }
            j = 1;
            if (j != 0) {
              jdField_d_of_type_JavaUtilArrayList.add(Integer.valueOf(k));
            }
            i += 1;
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
      int i = 0;
      continue;
      label145:
      int j = 0;
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
        paramAppRuntime = new JSONObject(paramString);
        if (paramAppRuntime.has("grayUrlConfig"))
        {
          a(paramAppRuntime.optJSONObject("grayUrlConfig"), paramBoolean);
          return;
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("[cmshow]ApolloConfigUtils", 1, paramAppRuntime, new Object[0]);
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
      if (i < paramJSONObject.length())
      {
        localJSONObject = paramJSONObject.getJSONObject(i);
        if (VersionUtil.a("8.7.0", localJSONObject.optString("minVersion"), localJSONObject.optString("maxVersion")))
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
          i += 1;
          continue;
        }
      }
      return;
      label187:
      int i = 0;
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
      Object localObject2 = "8.7.0";
      int i = 0;
      Object localObject1;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        String str1 = localJSONObject.optString("minVersion");
        String str2 = localJSONObject.optString("maxVersion");
        Object localObject3 = localJSONObject.optString("androidUrl");
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = localJSONObject.optString("url");
        }
        boolean bool = VersionUtil.a("8.7.0", str1, str2);
        if (bool)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            ApolloConstant.L = (String)localObject1;
            c(localJSONObject.optString("id"));
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
            QLog.d("[cmshow]ApolloConfigUtils", 2, new Object[] { ((StringBuilder)localObject3).toString(), ",scriptId:", ApolloConstant.M, ",isUpdate:", Boolean.valueOf(paramBoolean) });
            localObject3 = localObject2;
          }
        }
        else
        {
          localObject3 = localObject2;
          if (VersionUtil.a("8.7.0", str1) < 0)
          {
            localObject3 = localObject2;
            if (VersionUtil.a((String)localObject2, str1) < 0)
            {
              if (!TextUtils.isEmpty((CharSequence)localObject1))
              {
                ApolloConstant.O = (String)localObject1;
                ApolloConstant.P = localJSONObject.optString("id");
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/script/");
                ((StringBuilder)localObject2).append(ApolloConstant.P);
                ((StringBuilder)localObject2).append("/");
                ApolloConstant.Q = ((StringBuilder)localObject2).toString();
              }
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("parseBaseScriptConfig: newestMinVersion=");
                ((StringBuilder)localObject2).append(str1);
                ((StringBuilder)localObject2).append(" target.url=");
                ((StringBuilder)localObject2).append((String)localObject1);
                ((StringBuilder)localObject2).append(", id=");
                ((StringBuilder)localObject2).append(ApolloConstant.P);
                QLog.d("[cmshow]ApolloConfigUtils", 2, ((StringBuilder)localObject2).toString());
              }
              localObject3 = str1;
            }
          }
        }
        i += 1;
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
  
  public static boolean a()
  {
    if (TextUtils.isEmpty(ApolloConstant.M))
    {
      if (ProcessUtil.a()) {
        return false;
      }
      a();
    }
    return true;
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("preDownLoadRes");
        if (paramString == null) {
          return;
        }
        HashMap localHashMap = new HashMap();
        i = 0;
        if (i < paramString.length())
        {
          JSONObject localJSONObject1 = paramString.optJSONObject(i);
          JSONObject localJSONObject2 = localJSONObject1.optJSONObject("android");
          if (localJSONObject2 == null) {
            break label401;
          }
          ApolloPreDownloadData localApolloPreDownloadData = new ApolloPreDownloadData();
          localApolloPreDownloadData.reportId = localJSONObject1.optString("reportId");
          localApolloPreDownloadData.url = localJSONObject1.optString("url");
          if (TextUtils.isEmpty(localApolloPreDownloadData.url))
          {
            QLog.e("[cmshow]ApolloConfigUtils", 1, new Object[] { "parsePreDownloadConfig url is null, reportId:", localApolloPreDownloadData.reportId });
            break label401;
          }
          localApolloPreDownloadData.resId = MD5FileUtil.b(localApolloPreDownloadData.url);
          localApolloPreDownloadData.md5 = localJSONObject1.optString("md5");
          localApolloPreDownloadData.version = localJSONObject1.optInt("version");
          localApolloPreDownloadData.minVer = localJSONObject1.optString("minQQVer");
          localApolloPreDownloadData.maxVer = localJSONObject1.optString("maxQQVer");
          localApolloPreDownloadData.endTime = localJSONObject1.optLong("endTime");
          if ((!TextUtils.isEmpty(localApolloPreDownloadData.minVer)) && (!TextUtils.isEmpty(localApolloPreDownloadData.maxVer)) && (!VersionUtil.a("8.7.0", localApolloPreDownloadData.minVer, localApolloPreDownloadData.maxVer)))
          {
            QLog.e("[cmshow]ApolloConfigUtils", 1, new Object[] { "parsePreDownloadConfig ver is not correct, url:", localApolloPreDownloadData.url });
            break label401;
          }
          localApolloPreDownloadData.dir = localJSONObject2.optString("dir");
          localApolloPreDownloadData.zipDir = localJSONObject2.optString("zipDir");
          localApolloPreDownloadData.dirType = localJSONObject2.optInt("dirType");
          localHashMap.put(localApolloPreDownloadData.resId, localApolloPreDownloadData);
          break label401;
        }
        if (localHashMap.size() > 0)
        {
          ThreadManager.excute(new ApolloConfigUtils.2(paramAppRuntime, localHashMap), 160, null, true);
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
      label401:
      i += 1;
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        jdField_c_of_type_OrgJsonJSONObject = localJSONObject1.optJSONObject("aioGameTab");
        jdField_d_of_type_OrgJsonJSONObject = localJSONObject1.optJSONObject("gameAudioConfig");
        jdField_e_of_type_OrgJsonJSONObject = localJSONObject1.optJSONObject("plusPanelGameConfig");
        jdField_a_of_type_OrgJsonJSONArray = localJSONObject1.optJSONArray("quickTipsConfig");
        jdField_a_of_type_Int = localJSONObject1.optInt("gameMinTimeOut");
        jdField_a_of_type_JavaLangString = localJSONObject1.optString("notFullScreenModelList");
        f = localJSONObject1.optJSONObject("textureViewConfig");
        ((ApolloManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all")).initTextureViewConfig(f);
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("moreGameConfig");
        if (localJSONObject2 != null)
        {
          ApolloGameConfig.a("aio.enter.bg", localJSONObject2.optString("entranceBkgUrl"));
          paramString = localJSONObject2.optString("entranceUrl_Android_general");
          paramBoolean = ApolloUtilImpl.isApolloUser(paramAppRuntime);
          if (paramBoolean)
          {
            String str1 = localJSONObject2.optString("entranceUrl_Android");
            String str2 = localJSONObject2.optString("entranceUrl_Android_3d");
            paramString = str1;
            if (ApolloUtilImpl.isApollo3DUser(paramAppRuntime))
            {
              paramString = str1;
              if (!TextUtils.isEmpty(str2)) {
                paramString = str2;
              }
            }
          }
          paramAppRuntime = paramString;
          if (TextUtils.isEmpty(paramString)) {
            paramAppRuntime = localJSONObject2.optString("entranceUrl");
          }
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloConfigUtils", 2, new Object[] { "parseGameConfigJson enter:", paramAppRuntime, ",isOpenCmShow:", Boolean.valueOf(paramBoolean) });
          }
          ApolloGameConfig.a("aio.enter", paramAppRuntime);
          ApolloGameConfig.a("aio.enter.name", localJSONObject2.optString("entranceName"));
        }
        paramAppRuntime = BaseApplicationImpl.sApplication.getSharedPreferences("apollo_sp", 0).edit();
        if (localJSONObject1.has("freqConfig"))
        {
          paramString = localJSONObject1.optJSONObject("freqConfig");
          if (paramString != null) {
            paramAppRuntime.putInt("sp_key_exit_game_guide_count_limit", paramString.optInt("exitGuideCount", 1));
          }
        }
        if (localJSONObject1.has("switchSet"))
        {
          paramString = localJSONObject1.optJSONObject("switchSet");
          if (paramString != null) {
            paramAppRuntime.putInt("sp_key_exit_show_game_box_guide", paramString.optInt("gameBoxGuideSwitch"));
          }
        }
        paramAppRuntime.apply();
        return;
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("[cmshow]ApolloConfigUtils", 1, "Exception:", paramAppRuntime);
        return;
      }
    }
    QLog.e("[cmshow]ApolloConfigUtils", 1, "parseGameConfigJson content is null");
  }
  
  private static void c(String paramString)
  {
    ApolloConstant.M = paramString;
    paramString = new StringBuilder();
    paramString.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/script/");
    paramString.append(ApolloConstant.M);
    paramString.append("/");
    ApolloConstant.N = paramString.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.config.ApolloConfigUtils
 * JD-Core Version:    0.7.0.1
 */