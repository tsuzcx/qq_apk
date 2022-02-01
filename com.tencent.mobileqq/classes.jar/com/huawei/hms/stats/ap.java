package com.huawei.hms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.Map;

@SuppressLint({"ApplySharedPref"})
public class ap
{
  public static String a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageName();
    String str = c.m("_hms_config_tag", "oper");
    if (TextUtils.isEmpty(str)) {
      return "hms_" + paramString + "_" + paramContext;
    }
    return "hms_" + paramString + "_" + paramContext + "_" + str;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      af.c("SharedPreUtils", "context is null or spName empty or spkey is empty");
    }
    do
    {
      return;
      paramContext = d(paramContext, paramString1);
    } while (paramContext == null);
    paramContext = paramContext.edit();
    paramContext.putLong(paramString2, paramLong);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      af.c("SharedPreUtils", "context is null or spName empty or spkey is empty");
    }
    do
    {
      return;
      paramContext = d(paramContext, paramString1);
    } while (paramContext == null);
    paramContext = paramContext.edit();
    paramContext.putString(paramString2, paramString3);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, String... paramVarArgs)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      af.c("SharedPreUtils", "clearData(): parameter error.context,spname");
    }
    for (;;)
    {
      return;
      if (paramVarArgs == null)
      {
        af.c("SharedPreUtils", "clearData(): No data need to be deleted,keys is null");
        return;
      }
      paramContext = d(paramContext, paramString);
      if (paramContext != null)
      {
        paramString = paramContext.edit();
        if (paramVarArgs.length == 0)
        {
          paramString.clear();
          paramString.commit();
          return;
        }
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          String str = paramVarArgs[i];
          if (paramContext.contains(str))
          {
            paramString.remove(str);
            paramString.commit();
          }
          i += 1;
        }
      }
    }
  }
  
  public static long b(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      af.c("SharedPreUtils", "context is null or spName empty or spkey is empty");
    }
    do
    {
      return paramLong;
      paramContext = d(paramContext, paramString1);
    } while (paramContext == null);
    return paramContext.getLong(paramString2, paramLong);
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      af.c("SharedPreUtils", "context is null or spName empty or spkey is empty");
    }
    do
    {
      return paramString3;
      paramContext = d(paramContext, paramString1);
    } while (paramContext == null);
    return paramContext.getString(paramString2, paramString3);
  }
  
  public static Map<String, ?> b(Context paramContext, String paramString)
  {
    return d(paramContext, paramString).getAll();
  }
  
  public static void c(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      af.c("SharedPreUtils", "clearTypeDataByTag() eventTag is null or empty!");
      return;
    }
    if ("_default_config_tag".equals(paramString))
    {
      a(paramContext, "stat_v2_1", new String[] { paramString });
      a(paramContext, "cached_v2_1", new String[] { paramString });
      return;
    }
    String str1 = paramString + "-" + "oper";
    String str2 = paramString + "-" + "maint";
    paramString = paramString + "-" + "diffprivacy";
    a(paramContext, "stat_v2_1", new String[] { str1 });
    a(paramContext, "cached_v2_1", new String[] { str1 });
    a(paramContext, "stat_v2_1", new String[] { str2 });
    a(paramContext, "cached_v2_1", new String[] { str2 });
    a(paramContext, "stat_v2_1", new String[] { paramString });
    a(paramContext, "cached_v2_1", new String[] { paramString });
  }
  
  private static SharedPreferences d(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(a(paramContext, paramString), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.ap
 * JD-Core Version:    0.7.0.1
 */