package com.tencent.gamecenter.wadl.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class GameCenterSpUtils
{
  public static long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    try
    {
      Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject != null) {}
      for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "") {
        return MobileQQ.sMobileQQ.getSharedPreferences(b((String)localObject), 4).getLong(paramString, 0L);
      }
      return 0L;
    }
    catch (Throwable paramString)
    {
      WLog.b("GameCenterSpUtils", "readFromSpLong exception", paramString);
    }
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "") {
      return MobileQQ.sMobileQQ.getSharedPreferences(b((String)localObject), 4).getString(paramString, "");
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      WLog.a("GameCenterSpUtils", "getStringOutAccount fail, group=" + paramString1 + ",key=" + paramString2);
      return "";
    }
    String str = MobileQQ.sMobileQQ.getSharedPreferences(paramString1, 4).getString(paramString2, "");
    WLog.c("GameCenterSpUtils", "getStringOutAccount group=" + paramString1 + ",key=" + paramString2 + ",value=" + str);
    return str;
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localObject != null)
        {
          localObject = ((AppRuntime)localObject).getAccount();
          localObject = MobileQQ.sMobileQQ.getSharedPreferences(b((String)localObject), 4).edit();
          ((SharedPreferences.Editor)localObject).putLong(paramString, paramLong);
          WLog.c("GameCenterSpUtils", "writeToSpLong " + paramString + " :" + paramLong);
          ((SharedPreferences.Editor)localObject).commit();
          return;
        }
      }
      catch (Throwable paramString)
      {
        WLog.b("GameCenterSpUtils", "writeToSpLong exception", paramString);
        return;
      }
      Object localObject = "";
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      WLog.a("GameCenterSpUtils", "setStringOutAccount fail, group=" + paramString1 + ",key=" + paramString2 + ",value=" + paramString3);
      return;
    }
    boolean bool = MobileQQ.sMobileQQ.getSharedPreferences(paramString1, 4).edit().putString(paramString2, paramString3).commit();
    WLog.c("GameCenterSpUtils", "setStringOutAccount group=" + paramString1 + ",key=" + paramString2 + ",value=" + paramString3 + ",ret=" + bool);
  }
  
  public static void a(String paramString, JSONObject paramJSONObject)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramJSONObject == null)) {}
    do
    {
      return;
      localObject = MobileQQ.sMobileQQ;
    } while (localObject == null);
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterSpUtils", 2, new Object[] { "saveTipInfo: ", paramJSONObject.toString() });
    }
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = ((Context)localObject).getSharedPreferences("wadl_TipInfo", 4).edit();
    try
    {
      JSONObject localJSONObject2 = paramJSONObject.optJSONObject("install_bartips");
      if ((localJSONObject2 != null) && (localJSONObject2.optBoolean("valid", false))) {
        localJSONObject1.put("install_bartips", localJSONObject2);
      }
      localJSONObject2 = paramJSONObject.optJSONObject("register_bartips");
      if ((localJSONObject2 != null) && (localJSONObject2.optBoolean("valid", false))) {
        localJSONObject1.put("register_bartips", localJSONObject2);
      }
      if (paramJSONObject.has("app_icon")) {
        localJSONObject1.put("app_icon", paramJSONObject.optString("app_icon"));
      }
      if (paramJSONObject.has("install_tips_gray")) {
        localJSONObject1.put("install_tips_gray", paramJSONObject.optString("install_tips_gray"));
      }
      if (paramJSONObject.has("default_install_bartips_text")) {
        ((SharedPreferences.Editor)localObject).putString("default_install_bartips_text", paramJSONObject.optString("default_install_bartips_text"));
      }
      if (paramJSONObject.has("default_register_bartips_text")) {
        ((SharedPreferences.Editor)localObject).putString("default_register_bartips_text", paramJSONObject.optString("default_register_bartips_text"));
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        QLog.e("GameCenterSpUtils", 1, paramJSONObject, new Object[0]);
      }
    }
    if (localJSONObject1.length() > 0) {
      ((SharedPreferences.Editor)localObject).putString(paramString.trim(), localJSONObject1.toString());
    }
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "") {
      return MobileQQ.sMobileQQ.getSharedPreferences(b((String)localObject), 4).getBoolean(paramString, false);
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
    {
      localObject = MobileQQ.sMobileQQ.getSharedPreferences(b((String)localObject), 4).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      WLog.c("GameCenterSpUtils", "writeToSp " + paramString1 + " :" + paramString2);
      return ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null) {}
    for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
    {
      localObject = MobileQQ.sMobileQQ.getSharedPreferences(b((String)localObject), 4).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(paramString, paramBoolean);
      WLog.c("GameCenterSpUtils", "writeToSp " + paramString + " :" + paramBoolean);
      return ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static boolean a(String... paramVarArgs)
  {
    int i = 0;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject != null) {}
      for (localObject = ((AppRuntime)localObject).getAccount();; localObject = "")
      {
        localObject = MobileQQ.sMobileQQ.getSharedPreferences(b((String)localObject), 4).edit();
        int j = paramVarArgs.length;
        while (i < j)
        {
          ((SharedPreferences.Editor)localObject).remove(paramVarArgs[i]);
          i += 1;
        }
      }
      return ((SharedPreferences.Editor)localObject).commit();
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    return paramString + "_appoint";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.util.GameCenterSpUtils
 * JD-Core Version:    0.7.0.1
 */