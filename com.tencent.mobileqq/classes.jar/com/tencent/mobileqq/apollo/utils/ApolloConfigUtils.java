package com.tencent.mobileqq.apollo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.game.ApolloGameConfig;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.util.ArrayList;
import java.util.Arrays;
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
    jdField_a_of_type_OrgJsonJSONObject = null;
    jdField_b_of_type_OrgJsonJSONObject = null;
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
  
  public static int a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return -2;
    }
    if ((TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return -1;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return 1;
    }
    paramString1 = paramString1.trim();
    paramString2 = paramString2.trim();
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    if ((paramString1.length <= 0) || (paramString2.length <= 0)) {
      return -2;
    }
    paramString1 = new ArrayList(Arrays.asList(paramString1));
    paramString2 = new ArrayList(Arrays.asList(paramString2));
    int i;
    int j;
    int k;
    for (;;)
    {
      try
      {
        i = paramString1.size() - 1;
        if ((i < 0) || (Integer.parseInt((String)paramString1.get(i)) != 0))
        {
          i = paramString2.size() - 1;
          if (i < 0) {
            break label317;
          }
          if (Integer.parseInt((String)paramString2.get(i)) != 0)
          {
            break label317;
            if (i >= paramString1.size()) {
              continue;
            }
            j = Integer.parseInt((String)paramString1.get(i));
            if (paramString2.size() >= i + 1) {
              continue;
            }
            return 1;
          }
        }
        else
        {
          paramString1.remove(i);
          i -= 1;
          continue;
        }
        paramString2.remove(i);
        i -= 1;
        continue;
        k = Integer.parseInt((String)paramString2.get(i));
        if (j <= k) {
          break;
        }
        return 1;
        i = paramString2.size();
        j = paramString1.size();
        if (i > j) {
          return -1;
        }
        return 0;
      }
      catch (Exception paramString1)
      {
        QLog.e("ApolloConfigUtils", 1, "compareVersion fail e:" + paramString1.toString());
        return -2;
      }
      label317:
      i = 0;
    }
    if (j == k) {}
    while (j >= k)
    {
      i += 1;
      break;
    }
    return -1;
  }
  
  public static ApolloConfigUtils.AioOpenTips a()
  {
    try
    {
      if (jdField_a_of_type_JavaUtilList == null)
      {
        jdField_a_of_type_JavaUtilList = new ArrayList();
        jdField_a_of_type_JavaUtilList.add(new ApolloConfigUtils.AioOpenTips(HardCodeUtil.a(2131690112), HardCodeUtil.a(2131690113)));
        jdField_a_of_type_JavaUtilList.add(new ApolloConfigUtils.AioOpenTips(HardCodeUtil.a(2131690114), HardCodeUtil.a(2131690115)));
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
    return paramString.replace("[client]", "androidQQ").replace("[version]", "8.5.5.5105").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE).replace("[systemInt]", Integer.toString(Build.VERSION.SDK_INT));
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      ApolloConstant.u = a(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloConfigUtils", 2, "sApolloStoreUrl = " + ApolloConstant.u);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ("mall".equals(paramString1)) {
      a(paramString2);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  return;
                                  if (!"interact".equals(paramString1)) {
                                    break;
                                  }
                                } while (TextUtils.isEmpty(paramString2));
                                ApolloConstant.v = a(paramString2);
                              } while (!QLog.isColorLevel());
                              QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloStoreInteractUrl=", ApolloConstant.v });
                              return;
                              if ("game_rank".equals(paramString1))
                              {
                                ApolloConstant.k = paramString2;
                                return;
                              }
                              if ("game_life".equals(paramString1))
                              {
                                ApolloConstant.l = paramString2;
                                return;
                              }
                              if ("coin".equals(paramString1))
                              {
                                ApolloConstant.m = paramString2;
                                return;
                              }
                              if ("my_card".equals(paramString1))
                              {
                                ApolloConstant.n = paramString2;
                                return;
                              }
                              if ("crystal".equals(paramString1))
                              {
                                ApolloConstant.p = paramString2;
                                return;
                              }
                              if ("production".equals(paramString1))
                              {
                                ApolloConstant.q = paramString2;
                                return;
                              }
                              if ("game_manage".equals(paramString1))
                              {
                                ApolloConstant.r = paramString2;
                                return;
                              }
                              if ("my_card_detail".equals(paramString1))
                              {
                                ApolloConstant.o = paramString2;
                                return;
                              }
                              if (!"new_mall".equals(paramString1)) {
                                break;
                              }
                            } while (TextUtils.isEmpty(paramString2));
                            ApolloConstant.w = a(paramString2);
                          } while (!QLog.isColorLevel());
                          QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloNewStoreUrl=", ApolloConstant.w });
                          return;
                          if (!"game_center".equals(paramString1)) {
                            break;
                          }
                        } while (TextUtils.isEmpty(paramString2));
                        ApolloConstant.x = a(paramString2);
                      } while (!QLog.isColorLevel());
                      QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloGameCenterUrl=", ApolloConstant.x });
                      return;
                      if (!"new_interact".equals(paramString1)) {
                        break;
                      }
                    } while (TextUtils.isEmpty(paramString2));
                    ApolloConstant.y = a(paramString2);
                  } while (!QLog.isColorLevel());
                  QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloNewInteractUrl=", ApolloConstant.y });
                  return;
                  if (!"game_city".equals(paramString1)) {
                    break;
                  }
                } while (TextUtils.isEmpty(paramString2));
                ApolloConstant.z = a(paramString2);
              } while (!QLog.isColorLevel());
              QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloGameCityUrl=", ApolloConstant.z });
              return;
              if ("apollo_drawer_game_box_lottie".equals(paramString1))
              {
                ApolloConstant.E = paramString2;
                return;
              }
              if (!"apollo_plus_url".equals(paramString1)) {
                break;
              }
            } while (TextUtils.isEmpty(paramString2));
            ApolloConstant.F = paramString2;
            return;
            if (!"3d_mall".equals(paramString1)) {
              break;
            }
          } while (TextUtils.isEmpty(paramString2));
          ApolloConstant.A = a(paramString2);
          return;
          if (!"3d_interact".equals(paramString1)) {
            break;
          }
        } while (TextUtils.isEmpty(paramString2));
        ApolloConstant.B = a(paramString2);
        return;
        if (!"3d_game_city".equals(paramString1)) {
          break;
        }
      } while (TextUtils.isEmpty(paramString2));
      ApolloConstant.C = a(paramString2);
      return;
    } while ((!"2d_3available_interact".equals(paramString1)) || (TextUtils.isEmpty(paramString2)));
    ApolloConstant.D = a(paramString2);
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if ((paramAppRuntime == null) || (paramAppRuntime.getApplication() == null) || (TextUtils.isEmpty(paramString))) {}
    Object localObject2;
    Object localObject1;
    Object localObject3;
    for (;;)
    {
      return;
      try
      {
        localObject2 = paramAppRuntime.getApplication();
        localObject1 = new JSONObject(paramString);
        if (localObject1 != null)
        {
          paramString = ((JSONObject)localObject1).optString("apolloSwitch");
          SharedPreUtils.k((Context)localObject2, Integer.parseInt(paramString));
          localObject3 = ((JSONObject)localObject1).optString("apollo3dSwitch");
          QLog.d("ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] apolloSwitch=", paramString, ", apollo3dSwitch=", localObject3 });
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label270;
          }
          SharedPreUtils.l((Context)localObject2, Integer.parseInt((String)localObject3));
        }
      }
      catch (Exception paramString)
      {
        try
        {
          j = paramString.length;
          i = 0;
          while (i < j)
          {
            localObject3 = paramString[i];
            jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(Integer.parseInt((String)localObject3)));
            i += 1;
          }
          SharedPreUtils.l((Context)localObject2, 0);
        }
        catch (Exception paramString)
        {
          QLog.e("ApolloConfigUtils", 1, "[parseConfigJson] parse game id error, e=", paramString);
        }
        paramString = paramString;
        QLog.e("ApolloConfigUtils", 1, "aplloConfig parse json exception = " + paramString);
        return;
      }
    }
    if (((JSONObject)localObject1).has("default")) {}
    int i;
    int j;
    label270:
    for (paramString = ((JSONObject)localObject1).optJSONObject("default").optJSONObject("rules");; paramString = ((JSONObject)localObject1).optJSONObject("rules"))
    {
      jdField_a_of_type_OrgJsonJSONObject = paramString;
      if (!((JSONObject)localObject1).has("switchSet")) {
        break label813;
      }
      jdField_b_of_type_OrgJsonJSONObject = ((JSONObject)localObject1).optJSONObject("switchSet");
      if (jdField_b_of_type_OrgJsonJSONObject == null) {
        break label919;
      }
      paramString = jdField_b_of_type_OrgJsonJSONObject.optString("gameMenuBlackList");
      QLog.d("ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] gameMenuBlackListStr=", paramString });
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      paramString = paramString.split("\\|");
      if (paramString == null) {
        break;
      }
      i = paramString.length;
      if (i <= 0) {
        break;
      }
    }
    boolean bool;
    if (jdField_b_of_type_OrgJsonJSONObject.optInt("traceReportSwitch", 1) == 1)
    {
      bool = true;
      jdField_a_of_type_Boolean = bool;
      if (jdField_b_of_type_OrgJsonJSONObject.optInt("disablePreLoadEngineSwitch_V3", 0) != 1) {
        break label748;
      }
      bool = true;
      label369:
      jdField_b_of_type_Boolean = bool;
      if (jdField_b_of_type_OrgJsonJSONObject.optInt("disablePipeLog_V3", 0) != 1) {
        break label754;
      }
      bool = true;
      label391:
      ApolloEngine.a(bool);
      if (jdField_b_of_type_OrgJsonJSONObject.optInt("disableSettingMeDestroySwitch", 0) != 1) {
        break label760;
      }
      bool = true;
      label413:
      jdField_c_of_type_Boolean = bool;
      jdField_b_of_type_Int = jdField_b_of_type_OrgJsonJSONObject.optInt("disableSettingMeDestroyTimeOut", 0);
      if (jdField_b_of_type_OrgJsonJSONObject.optInt("disablePreLoadcm3DSwitch_V3") != 1) {
        break label766;
      }
      bool = true;
      label447:
      jdField_d_of_type_Boolean = bool;
      jdField_a_of_type_Long = jdField_b_of_type_OrgJsonJSONObject.optLong("gameConnHeartbeatInterval");
      if (jdField_b_of_type_OrgJsonJSONObject.optInt("enableGL3_0", 1) != 1) {
        break label772;
      }
      bool = true;
      label481:
      jdField_e_of_type_Boolean = bool;
      paramString = (ApolloManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all");
      if (jdField_b_of_type_OrgJsonJSONObject.optInt("disableCreateRenderThread", 0) != 1) {
        break label778;
      }
      bool = true;
      label517:
      paramString.setDisableCreateRenderThread(bool);
      if (jdField_b_of_type_OrgJsonJSONObject.optInt("apolloEngineLockEnable_V3", 0) != 1) {
        break label784;
      }
      bool = true;
      label540:
      paramString.setApolloEngineLockEnable(bool);
      QLog.d("ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] sSwitchSet=", jdField_b_of_type_OrgJsonJSONObject.toString() });
      long l = jdField_b_of_type_OrgJsonJSONObject.optLong("store_page_load_timeout_value");
      if (l <= 0L) {
        break label790;
      }
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0).edit();
      paramString.putLong("SP_KEY_APOLLO_STORE_PAGE_LOAD_TIMEOUT_VALUE", l);
      paramString.apply();
      QLog.d("ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] sStorePageLoadTimeoutValue=", Long.valueOf(l) });
    }
    for (;;)
    {
      for (;;)
      {
        paramString = jdField_b_of_type_OrgJsonJSONObject.optString("transparentGameList");
        QLog.d("ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] transparentGameListStr=", paramString });
        if (TextUtils.isEmpty(paramString)) {
          break label813;
        }
        paramString = paramString.split("\\|");
        if (paramString == null) {
          break label813;
        }
        i = paramString.length;
        if (i <= 0) {
          break label813;
        }
        label772:
        label778:
        label784:
        label790:
        try
        {
          j = paramString.length;
          i = 0;
          while (i < j)
          {
            localObject3 = paramString[i];
            jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(Integer.parseInt((String)localObject3)));
            i += 1;
          }
          bool = false;
        }
        catch (Exception paramString)
        {
          label748:
          label754:
          label760:
          label766:
          QLog.e("ApolloConfigUtils", 1, "[parseConfigJson] parse trans game id error, e=", paramString);
        }
      }
      bool = false;
      break label369;
      bool = false;
      break label391;
      bool = false;
      break label413;
      bool = false;
      break label447;
      bool = false;
      break label481;
      bool = false;
      break label517;
      bool = false;
      break label540;
      QLog.d("ApolloConfigUtils", 1, "[parseConfigJson] sStorePageLoadTimeoutValue from config not > 0, use default value. ");
    }
    label813:
    if (((JSONObject)localObject1).has("errorAction"))
    {
      paramString = ((JSONObject)localObject1).optString("errorAction");
      if (!TextUtils.isEmpty(paramString))
      {
        localObject3 = paramString.split(",");
        if (localObject3 != null) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i < paramString.length())
      {
        jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(Integer.parseInt(localObject3[i])));
        if (!QLog.isColorLevel()) {
          break label1492;
        }
        QLog.d("ApolloConfigUtils", 2, "errorAction =" + localObject3[i]);
        break label1492;
        label919:
        QLog.e("ApolloConfigUtils", 1, "[parseConfigJson] sSwitchSet null");
        break label813;
      }
      if (((JSONObject)localObject1).has("shopUrl"))
      {
        paramString = ((JSONObject)localObject1).optJSONArray("shopUrl");
        if (paramString != null) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i < paramString.length())
        {
          localObject3 = paramString.getJSONObject(i);
          if (!a("8.5.5", ((JSONObject)localObject3).optString("minVersion"), ((JSONObject)localObject3).optString("maxVersion"))) {
            break label1485;
          }
          localObject3 = ((JSONObject)localObject3).optString("url");
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label1485;
          }
          a((String)localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloConfigUtils", 2, "localversion target.url=" + (String)localObject3);
          }
        }
        if (((JSONObject)localObject1).has("urlConfig")) {
          a(((JSONObject)localObject1).optJSONObject("urlConfig"), paramBoolean);
        }
        if (((JSONObject)localObject1).has("freqConfig"))
        {
          paramString = ((JSONObject)localObject1).optJSONObject("freqConfig");
          if (paramString != null)
          {
            i = paramString.optInt("drawerBubble", 3);
            j = paramString.optInt("aioBubble", 3);
            localObject2 = ((Context)localObject2).getSharedPreferences("apollo_sp", 0);
            ((SharedPreferences)localObject2).edit().putInt("bubble_max_count", i);
            ((SharedPreferences)localObject2).edit().putInt("sp_key_aio_bubble_max_count", j);
            ((SharedPreferences)localObject2).edit().commit();
            i = paramString.optInt("foregroundEvent") * 1000 * 60;
            if (EcshopAdHandler.jdField_a_of_type_Int < i) {
              EcshopAdHandler.jdField_a_of_type_Int = i;
            }
          }
        }
        if (((JSONObject)localObject1).has("avConfig"))
        {
          localObject2 = ((JSONObject)localObject1).optJSONObject("avConfig");
          if (localObject2 != null)
          {
            paramString = ((JSONObject)localObject2).optString("url");
            localObject2 = ((JSONObject)localObject2).optString("md5");
            if (!TextUtils.isEmpty(paramString)) {
              ApolloConstant.s = paramString;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              ApolloConstant.t = (String)localObject2;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloConfigUtils", 2, "gameAVSOUrl =" + paramString + ", md5=" + (String)localObject2);
            }
          }
        }
        if (((JSONObject)localObject1).has("gameConfig"))
        {
          paramString = ((JSONObject)localObject1).optJSONObject("gameConfig");
          if ((paramString != null) && (paramString.has("aio")))
          {
            localObject3 = paramString.getJSONObject("aio");
            paramString = ((JSONObject)localObject3).optString("aioPanelTip");
            localObject1 = ((JSONObject)localObject3).optString("gamePanelTip");
            localObject2 = ((JSONObject)localObject3).optString("gamePanelBg");
            localObject3 = ((JSONObject)localObject3).optString("gamePanelBgColor");
            if (!TextUtils.isEmpty(paramString)) {
              ApolloConstant.P = paramString;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ApolloConstant.Q = (String)localObject1;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              ApolloConstant.R = ((String)localObject2).trim();
            }
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              ApolloConstant.S = ((String)localObject3).trim();
            }
          }
        }
        paramString = (ApolloManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all");
        if (paramString.getConfigInitDone()) {
          break;
        }
        paramString.setConfigInitDone(true);
        paramString.initDataAfterConfig();
        return;
        label1485:
        i += 1;
      }
      label1492:
      i += 1;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        paramAppRuntime = new JSONObject(paramString);
        if (!paramAppRuntime.has("traceConfig")) {
          continue;
        }
        jdField_d_of_type_JavaUtilArrayList.clear();
        paramAppRuntime = paramAppRuntime.optJSONObject("traceConfig").optJSONArray("featureList");
        if ((paramAppRuntime == null) || (paramAppRuntime.length() <= 0)) {
          continue;
        }
        int i = 0;
        if (i >= paramAppRuntime.length()) {
          continue;
        }
        paramString = paramAppRuntime.optJSONObject(i);
        int k = paramString.optInt("featureId");
        if (paramString.optInt("isFocus") == 1) {}
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            jdField_d_of_type_JavaUtilArrayList.add(Integer.valueOf(k));
          }
          i += 1;
          break;
        }
        return;
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("ApolloConfigUtils", 1, paramAppRuntime, new Object[0]);
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        QLog.d("ApolloConfigUtils", 1, new Object[] { "parseUrlGrayConfigJson, isUpdate:", Boolean.valueOf(paramBoolean), ",content:", paramString });
        paramAppRuntime = new JSONObject(paramString);
        if (paramAppRuntime.has("grayUrlConfig"))
        {
          a(paramAppRuntime.optJSONObject("grayUrlConfig"), paramBoolean);
          return;
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("ApolloConfigUtils", 1, paramAppRuntime, new Object[0]);
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
        if (paramJSONObject != null)
        {
          i = 0;
          if (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            if (!a("8.5.5", localJSONObject.optString("minVersion"), localJSONObject.optString("maxVersion"))) {
              continue;
            }
            String str = localJSONObject.optString("androidUrl");
            paramJSONObject = str;
            if (TextUtils.isEmpty(str)) {
              paramJSONObject = localJSONObject.optString("url");
            }
            a(paramString, paramJSONObject);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloConfigUtils", 2, paramString + " localversion target.url=" + paramJSONObject);
            }
          }
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloConfigUtils", 2, paramString + " parse configUrl error e=" + paramJSONObject.toString());
      }
      i += 1;
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      Object localObject3;
      try
      {
        JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
        if (localJSONArray != null)
        {
          i = 0;
          localObject1 = "8.5.5";
          if (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            String str1 = localJSONObject.optString("minVersion");
            String str2 = localJSONObject.optString("maxVersion");
            localObject3 = localJSONObject.optString("androidUrl");
            Object localObject2 = localObject3;
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              localObject2 = localJSONObject.optString("url");
            }
            if (a("8.5.5", str1, str2))
            {
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                ApolloConstant.G = (String)localObject2;
                ApolloConstant.H = localJSONObject.optString("id");
                ApolloConstant.I = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/script/" + ApolloConstant.H + "/";
                if (paramBoolean)
                {
                  localObject3 = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0);
                  ((SharedPreferences)localObject3).edit().putString("sp_key_config_script", paramJSONObject.toString());
                  ((SharedPreferences)localObject3).edit().commit();
                }
              }
              localObject3 = localObject1;
              if (QLog.isColorLevel())
              {
                QLog.d("ApolloConfigUtils", 2, new Object[] { "parseBaseScriptConfig: localversion target.url=" + (String)localObject2, ",scriptId:", ApolloConstant.H, ",isUpdate:", Boolean.valueOf(paramBoolean) });
                localObject3 = localObject1;
              }
            }
            else
            {
              localObject3 = localObject1;
              if (a("8.5.5", str1) < 0)
              {
                localObject3 = localObject1;
                if (a((String)localObject1, str1) < 0)
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject2))
                  {
                    ApolloConstant.J = (String)localObject2;
                    ApolloConstant.K = localJSONObject.optString("id");
                    ApolloConstant.L = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/script/" + ApolloConstant.K + "/";
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloConfigUtils", 2, "parseBaseScriptConfig: newestMinVersion=" + str1 + " target.url=" + (String)localObject2 + ", id=" + ApolloConstant.K);
                  }
                  localObject3 = str1;
                }
              }
            }
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.d("ApolloConfigUtils", 1, paramString + " parse configUrl error e=" + paramJSONObject.toString());
      }
      return;
      i += 1;
      Object localObject1 = localObject3;
    }
  }
  
  public static void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject != null)
    {
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
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {}
    do
    {
      for (;;)
      {
        return false;
        try
        {
          if ((a(paramString1, paramString2) >= 0) && (a(paramString1, paramString3) <= 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloConfigUtils", 2, "localversion target. min=" + paramString2 + ",local =" + paramString1 + ",max=" + paramString3);
            }
            return true;
          }
        }
        catch (Throwable paramString1) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("ApolloConfigUtils", 2, paramString1.toString());
    return false;
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString)
  {
    int i = 0;
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("ApolloConfigUtils", 1, "parsePreDownloadConfig content is null");
      return;
    }
    for (;;)
    {
      HashMap localHashMap;
      JSONObject localJSONObject2;
      ApolloPreDownloadData localApolloPreDownloadData;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("preDownLoadRes");
        if (paramString == null) {
          break;
        }
        localHashMap = new HashMap();
        if (i >= paramString.length()) {
          break label367;
        }
        JSONObject localJSONObject1 = paramString.optJSONObject(i);
        localJSONObject2 = localJSONObject1.optJSONObject("android");
        if (localJSONObject2 == null) {
          break label394;
        }
        localApolloPreDownloadData = new ApolloPreDownloadData();
        localApolloPreDownloadData.reportId = localJSONObject1.optString("reportId");
        localApolloPreDownloadData.url = localJSONObject1.optString("url");
        if (TextUtils.isEmpty(localApolloPreDownloadData.url))
        {
          QLog.e("ApolloConfigUtils", 1, new Object[] { "parsePreDownloadConfig url is null, reportId:", localApolloPreDownloadData.reportId });
        }
        else
        {
          localApolloPreDownloadData.resId = MD5FileUtil.b(localApolloPreDownloadData.url);
          localApolloPreDownloadData.md5 = localJSONObject1.optString("md5");
          localApolloPreDownloadData.version = localJSONObject1.optInt("version");
          localApolloPreDownloadData.minVer = localJSONObject1.optString("minQQVer");
          localApolloPreDownloadData.maxVer = localJSONObject1.optString("maxQQVer");
          localApolloPreDownloadData.endTime = localJSONObject1.optLong("endTime");
          if ((!TextUtils.isEmpty(localApolloPreDownloadData.minVer)) && (!TextUtils.isEmpty(localApolloPreDownloadData.maxVer)) && (!a("8.5.5", localApolloPreDownloadData.minVer, localApolloPreDownloadData.maxVer))) {
            QLog.e("ApolloConfigUtils", 1, new Object[] { "parsePreDownloadConfig ver is not correct, url:", localApolloPreDownloadData.url });
          }
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("ApolloConfigUtils", 1, "parsePreDownloadConfig e:", paramAppRuntime);
        return;
      }
      localApolloPreDownloadData.dir = localJSONObject2.optString("dir");
      localApolloPreDownloadData.zipDir = localJSONObject2.optString("zipDir");
      localApolloPreDownloadData.dirType = localJSONObject2.optInt("dirType");
      localHashMap.put(localApolloPreDownloadData.resId, localApolloPreDownloadData);
      break label394;
      label367:
      if (localHashMap.size() <= 0) {
        break;
      }
      ThreadManager.excute(new ApolloConfigUtils.3(paramAppRuntime, localHashMap), 160, null, true);
      return;
      label394:
      i += 1;
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("ApolloConfigUtils", 1, "parseGameConfigJson content is null");
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString);
        jdField_c_of_type_OrgJsonJSONObject = localJSONObject1.optJSONObject("aioGameTab");
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("moreGameConfig");
        jdField_d_of_type_OrgJsonJSONObject = localJSONObject1.optJSONObject("gameAudioConfig");
        jdField_e_of_type_OrgJsonJSONObject = localJSONObject1.optJSONObject("plusPanelGameConfig");
        jdField_a_of_type_OrgJsonJSONArray = localJSONObject1.optJSONArray("quickTipsConfig");
        CmGameTempSessionHandler.a(jdField_a_of_type_OrgJsonJSONArray);
        jdField_a_of_type_Int = localJSONObject1.optInt("gameMinTimeOut");
        jdField_a_of_type_JavaLangString = localJSONObject1.optString("notFullScreenModelList");
        f = localJSONObject1.optJSONObject("textureViewConfig");
        ((ApolloManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all")).initTextureViewConfig(f);
        if (paramBoolean)
        {
          QLog.e("ApolloConfigUtils", 1, "parseGameConfigJson online get update");
          ThreadManager.excute(new ApolloConfigUtils.2(paramAppRuntime), 32, null, true);
        }
        if (localJSONObject2 != null)
        {
          ApolloGameConfig.a("aio.enter.bg", localJSONObject2.optString("entranceBkgUrl"));
          paramString = localJSONObject2.optString("entranceUrl_Android_general");
          paramBoolean = ApolloGameUtil.a(paramAppRuntime);
          if (paramBoolean)
          {
            paramString = localJSONObject2.optString("entranceUrl_Android");
            String str = localJSONObject2.optString("entranceUrl_Android_3d");
            if ((ApolloGameUtil.b(paramAppRuntime)) && (!TextUtils.isEmpty(str))) {
              paramString = str;
            }
          }
          else
          {
            paramAppRuntime = paramString;
            if (TextUtils.isEmpty(paramString)) {
              paramAppRuntime = localJSONObject2.optString("entranceUrl");
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloConfigUtils", 2, new Object[] { "parseGameConfigJson enter:", paramAppRuntime, ",isOpenCmShow:", Boolean.valueOf(paramBoolean) });
            }
            ApolloGameConfig.a("aio.enter", paramAppRuntime);
            ApolloGameConfig.a("aio.enter.name", localJSONObject2.optString("entranceName"));
          }
        }
        else
        {
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
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("ApolloConfigUtils", 1, "Exception:", paramAppRuntime);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloConfigUtils
 * JD-Core Version:    0.7.0.1
 */