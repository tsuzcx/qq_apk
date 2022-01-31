package com.tencent.mobileqq.apollo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.gdtad.net.GdtAdHandler;
import com.tencent.mobileqq.apollo.game.ApolloGameConfig;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloConfigUtils
{
  public static ArrayList a;
  public static JSONObject a;
  public static ArrayList b;
  public static JSONObject b;
  public static JSONObject c;
  public static JSONObject d;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_b_of_type_JavaUtilArrayList = new ArrayList();
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
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    if ((paramString1 == null) || (paramString2 == null) || (paramString1.length <= 0) || (paramString2.length <= 0)) {
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
            break label315;
          }
          if (Integer.parseInt((String)paramString2.get(i)) != 0)
          {
            break label315;
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
      label315:
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
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replace("[client]", "androidQQ").replace("[version]", "7.6.0.3525").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE).replace("[systemInt]", Integer.toString(Build.VERSION.SDK_INT));
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        c = new JSONObject(paramString);
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ApolloConfigUtils", 2, "aplloStepConfig parse json exception = " + paramString.toString());
  }
  
  public static void a(String paramString, Context paramContext)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    for (;;)
    {
      Object localObject1;
      int i;
      Object localObject2;
      try
      {
        localObject1 = new JSONObject(paramString);
        if (localObject1 == null) {
          break;
        }
        SharedPreUtils.o(paramContext, Integer.parseInt(((JSONObject)localObject1).optString("apolloSwitch")));
        if (((JSONObject)localObject1).has("default"))
        {
          paramString = ((JSONObject)localObject1).optJSONObject("default").optJSONObject("rules");
          jdField_a_of_type_OrgJsonJSONObject = paramString;
          if (((JSONObject)localObject1).has("switchSet"))
          {
            jdField_b_of_type_OrgJsonJSONObject = ((JSONObject)localObject1).optJSONObject("switchSet");
            if (jdField_b_of_type_OrgJsonJSONObject == null) {
              continue;
            }
            paramString = jdField_b_of_type_OrgJsonJSONObject.optString("gameMenuBlackList");
            QLog.d("ApolloConfigUtils", 1, new Object[] { "[parseConfigJson] gameMenuBlackListStr=", paramString });
            if (!TextUtils.isEmpty(paramString))
            {
              paramString = paramString.split("\\|");
              if (paramString != null)
              {
                i = paramString.length;
                if (i <= 0) {}
              }
            }
          }
        }
        else
        {
          try
          {
            int j = paramString.length;
            i = 0;
            if (i < j)
            {
              localObject2 = paramString[i];
              jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(Integer.parseInt((String)localObject2)));
              i += 1;
              continue;
              paramString = ((JSONObject)localObject1).optJSONObject("rules");
            }
          }
          catch (Exception paramString)
          {
            QLog.e("ApolloConfigUtils", 1, "[parseConfigJson] parse game id error, e=", paramString);
          }
        }
        if (!((JSONObject)localObject1).has("errorAction")) {
          break label354;
        }
        paramString = ((JSONObject)localObject1).optString("errorAction");
        if (TextUtils.isEmpty(paramString)) {
          break label354;
        }
        localObject2 = paramString.split(",");
        if (localObject2 == null) {
          break label354;
        }
        i = 0;
        if (i >= paramString.length()) {
          break label354;
        }
        jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(Integer.parseInt(localObject2[i])));
        if (!QLog.isColorLevel()) {
          break label924;
        }
        QLog.d("ApolloConfigUtils", 2, "errorAction =" + localObject2[i]);
        break label924;
        QLog.e("ApolloConfigUtils", 1, "[parseConfigJson] sSwitchSet null");
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramString) {}
      QLog.e("ApolloConfigUtils", 2, "aplloConfig parse json exception = " + paramString.toString());
      return;
      label354:
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
          localObject2 = paramString.getJSONObject(i);
          if (!a("7.6.0", ((JSONObject)localObject2).optString("minVersion"), ((JSONObject)localObject2).optString("maxVersion"))) {
            break label917;
          }
          localObject2 = ((JSONObject)localObject2).optString("url");
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label917;
          }
          c((String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloConfigUtils", 2, "localversion target.url=" + (String)localObject2);
          }
        }
        if (((JSONObject)localObject1).has("urlConfig"))
        {
          paramString = ((JSONObject)localObject1).optJSONObject("urlConfig");
          if (paramString != null)
          {
            a(paramString, "mall");
            a(paramString, "new_mall");
            a(paramString, "interact");
            a(paramString, "game_rank");
            a(paramString, "game_life");
            a(paramString, "coin");
            a(paramString, "my_card");
            a(paramString, "my_card_detail");
            a(paramString, "crystal");
            a(paramString, "production");
            a(paramString, "game_manage");
            a(paramString, "game_center");
            a(paramString, "new_interact");
            a(paramString, "game_city");
            a(paramString, "apollo_drawer_game_box");
          }
        }
        if (((JSONObject)localObject1).has("freqConfig"))
        {
          paramString = ((JSONObject)localObject1).optJSONObject("freqConfig");
          if (paramString != null)
          {
            i = paramString.optInt("drawerBubble", 3);
            paramContext.getSharedPreferences("apollo_sp", 0).edit().putInt("bubble_max_count", i).commit();
            i = paramString.optInt("foregroundEvent") * 1000 * 60;
            if (GdtAdHandler.a < i) {
              GdtAdHandler.a = i;
            }
          }
        }
        if (((JSONObject)localObject1).has("avConfig"))
        {
          paramContext = ((JSONObject)localObject1).optJSONObject("avConfig");
          if (paramContext != null)
          {
            paramString = paramContext.optString("url");
            paramContext = paramContext.optString("md5");
            if (!TextUtils.isEmpty(paramString)) {
              ApolloConstant.V = paramString;
            }
            if (!TextUtils.isEmpty(paramContext)) {
              ApolloConstant.W = paramContext;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloConfigUtils", 2, "gameAVSOUrl =" + paramString + ", md5=" + paramContext);
            }
          }
        }
        if (!((JSONObject)localObject1).has("gameConfig")) {
          break;
        }
        paramString = ((JSONObject)localObject1).optJSONObject("gameConfig");
        if ((paramString == null) || (!paramString.has("aio"))) {
          break;
        }
        localObject2 = paramString.getJSONObject("aio");
        paramString = ((JSONObject)localObject2).optString("aioPanelTip");
        paramContext = ((JSONObject)localObject2).optString("gamePanelTip");
        localObject1 = ((JSONObject)localObject2).optString("gamePanelBg");
        localObject2 = ((JSONObject)localObject2).optString("gamePanelBgColor");
        if (!TextUtils.isEmpty(paramString)) {
          ApolloConstant.ah = paramString;
        }
        if (!TextUtils.isEmpty(paramContext)) {
          ApolloConstant.ai = paramContext;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ApolloConstant.aj = ((String)localObject1).trim();
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        ApolloConstant.ak = ((String)localObject2).trim();
        return;
        label917:
        i += 1;
      }
      label924:
      i += 1;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ("mall".equals(paramString1)) {
      c(paramString2);
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
                          return;
                          if (!"interact".equals(paramString1)) {
                            break;
                          }
                        } while (TextUtils.isEmpty(paramString2));
                        ApolloConstant.Y = a(paramString2);
                      } while (!QLog.isColorLevel());
                      QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloStoreInteractUrl=", ApolloConstant.Y });
                      return;
                      if ("game_rank".equals(paramString1))
                      {
                        ApolloConstant.N = paramString2;
                        return;
                      }
                      if ("game_life".equals(paramString1))
                      {
                        ApolloConstant.O = paramString2;
                        return;
                      }
                      if ("coin".equals(paramString1))
                      {
                        ApolloConstant.P = paramString2;
                        return;
                      }
                      if ("my_card".equals(paramString1))
                      {
                        ApolloConstant.Q = paramString2;
                        return;
                      }
                      if ("crystal".equals(paramString1))
                      {
                        ApolloConstant.S = paramString2;
                        return;
                      }
                      if ("production".equals(paramString1))
                      {
                        ApolloConstant.T = paramString2;
                        return;
                      }
                      if ("game_manage".equals(paramString1))
                      {
                        ApolloConstant.U = paramString2;
                        return;
                      }
                      if ("my_card_detail".equals(paramString1))
                      {
                        ApolloConstant.R = paramString2;
                        return;
                      }
                      if (!"new_mall".equals(paramString1)) {
                        break;
                      }
                    } while (TextUtils.isEmpty(paramString2));
                    ApolloConstant.Z = a(paramString2);
                  } while (!QLog.isColorLevel());
                  QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloNewStoreUrl=", ApolloConstant.Z });
                  return;
                  if (!"game_center".equals(paramString1)) {
                    break;
                  }
                } while (TextUtils.isEmpty(paramString2));
                ApolloConstant.aa = a(paramString2);
              } while (!QLog.isColorLevel());
              QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloGameCenterUrl=", ApolloConstant.aa });
              return;
              if (!"new_interact".equals(paramString1)) {
                break;
              }
            } while (TextUtils.isEmpty(paramString2));
            ApolloConstant.ab = a(paramString2);
          } while (!QLog.isColorLevel());
          QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloNewInteractUrl=", ApolloConstant.ab });
          return;
          if (!"game_city".equals(paramString1)) {
            break;
          }
        } while (TextUtils.isEmpty(paramString2));
        ApolloConstant.ac = a(paramString2);
      } while (!QLog.isColorLevel());
      QLog.d("ApolloConfigUtils", 2, new Object[] { "[handleConfigUrl] sApolloGameCityUrl=", ApolloConstant.ac });
      return;
    } while (!"apollo_drawer_game_box".equals(paramString1));
    ApolloConstant.ad = paramString2;
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
            if (!a("7.6.0", localJSONObject.optString("minVersion"), localJSONObject.optString("maxVersion"))) {
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
          if ((a(paramString1, paramString2) >= 0) && (a(paramString1, paramString3) == -1))
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
  
  public static void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString = new JSONObject(paramString);
          if ((paramString.has("weatherConfig")) && (paramString.optInt("weatherConfig") == 1))
          {
            d = paramString;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloConfigUtils", 2, "weather config parse success");
            }
          }
          if (paramString.has("CMGamePlusPanel"))
          {
            ApolloGameConfig.a("CMGamePlusPanel", paramString.optInt("CMGamePlusPanel"));
            return;
          }
        }
        catch (Exception paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("ApolloConfigUtils", 2, "aplloWeatherConfig parse json exception = " + paramString.toString());
  }
  
  public static void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      ApolloConstant.X = a(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloConfigUtils", 2, "sApolloStoreUrl = " + ApolloConstant.X);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloConfigUtils
 * JD-Core Version:    0.7.0.1
 */