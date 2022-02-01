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
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = "";
    }
    return MobileQQ.sMobileQQ.getSharedPreferences(d((String)localObject), 4).getString(paramString, "");
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      localObject = MobileQQ.sMobileQQ.getSharedPreferences(paramString1, 4).getString(paramString2, "");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getStringOutAccount group=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",key=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",value=");
      localStringBuilder.append((String)localObject);
      QLog.i("Wadl_GameCenterSpUtils", 1, localStringBuilder.toString());
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getStringOutAccount fail, group=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(",key=");
    ((StringBuilder)localObject).append(paramString2);
    QLog.w("Wadl_GameCenterSpUtils", 1, ((StringBuilder)localObject).toString());
    return "";
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
          localObject = MobileQQ.sMobileQQ.getSharedPreferences(d((String)localObject), 4).edit();
          ((SharedPreferences.Editor)localObject).putLong(paramString, paramLong);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("writeToSpLong ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" :");
          localStringBuilder.append(paramLong);
          QLog.i("Wadl_GameCenterSpUtils", 1, localStringBuilder.toString());
          ((SharedPreferences.Editor)localObject).commit();
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("Wadl_GameCenterSpUtils", 1, "writeToSpLong exception", paramString);
        return;
      }
      Object localObject = "";
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      boolean bool = MobileQQ.sMobileQQ.getSharedPreferences(paramString1, 4).edit().putString(paramString2, paramString3).commit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setStringOutAccount group=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",key=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",value=");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(",ret=");
      localStringBuilder.append(bool);
      QLog.i("Wadl_GameCenterSpUtils", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setStringOutAccount fail, group=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",key=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",value=");
    localStringBuilder.append(paramString3);
    QLog.w("Wadl_GameCenterSpUtils", 1, localStringBuilder.toString());
  }
  
  public static void a(String paramString, JSONObject paramJSONObject)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramJSONObject == null) {
        return;
      }
      Object localObject = MobileQQ.sMobileQQ;
      if (localObject == null) {
        return;
      }
      QLog.d("Wadl_GameCenterSpUtils", 1, new Object[] { "saveTipInfo: ", paramJSONObject.toString() });
      JSONObject localJSONObject1 = new JSONObject();
      localObject = ((Context)localObject).getSharedPreferences("wadl_TipInfo", 4).edit();
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
        QLog.e("Wadl_GameCenterSpUtils", 1, paramJSONObject, new Object[0]);
      }
      if (localJSONObject1.length() > 0) {
        ((SharedPreferences.Editor)localObject).putString(paramString.trim(), localJSONObject1.toString());
      }
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = "";
    }
    localObject = MobileQQ.sMobileQQ.getSharedPreferences(d((String)localObject), 4).edit();
    ((SharedPreferences.Editor)localObject).putBoolean(paramString, paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("writeToSp ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" :");
    localStringBuilder.append(paramBoolean);
    QLog.i("Wadl_GameCenterSpUtils", 1, localStringBuilder.toString());
    return ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static boolean a(String... paramVarArgs)
  {
    int i = 0;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject != null) {
        localObject = ((AppRuntime)localObject).getAccount();
      } else {
        localObject = "";
      }
      localObject = MobileQQ.sMobileQQ.getSharedPreferences(d((String)localObject), 4).edit();
      int j = paramVarArgs.length;
      while (i < j)
      {
        ((SharedPreferences.Editor)localObject).remove(paramVarArgs[i]);
        i += 1;
      }
      return ((SharedPreferences.Editor)localObject).commit();
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = "";
    }
    return MobileQQ.sMobileQQ.getSharedPreferences(d((String)localObject), 4).getBoolean(paramString, false);
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = "";
    }
    localObject = MobileQQ.sMobileQQ.getSharedPreferences(d((String)localObject), 4).edit();
    ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("writeToSp ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" :");
    localStringBuilder.append(paramString2);
    QLog.i("Wadl_GameCenterSpUtils", 1, localStringBuilder.toString());
    return ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static long c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    for (;;)
    {
      try
      {
        localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localObject != null)
        {
          localObject = ((AppRuntime)localObject).getAccount();
          long l = MobileQQ.sMobileQQ.getSharedPreferences(d((String)localObject), 4).getLong(paramString, 0L);
          return l;
        }
      }
      catch (Throwable paramString)
      {
        QLog.i("Wadl_GameCenterSpUtils", 1, "readFromSpLong exception", paramString);
        return 0L;
      }
      Object localObject = "";
    }
  }
  
  public static String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_appoint");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.util.GameCenterSpUtils
 * JD-Core Version:    0.7.0.1
 */