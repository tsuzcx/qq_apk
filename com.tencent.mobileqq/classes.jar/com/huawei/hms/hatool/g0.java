package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.Map;

@SuppressLint({"ApplySharedPref"})
public class g0
{
  public static long a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramContext = b(paramContext, paramString1);
      long l = paramLong;
      if (paramContext != null) {
        l = paramContext.getLong(paramString2, paramLong);
      }
      return l;
    }
    y.f("hmsSdk", "context is null or spName empty or spkey is empty");
    return paramLong;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = b(paramContext, paramString1);
      paramContext = paramString3;
      if (paramString1 != null) {
        paramContext = paramString1.getString(paramString2, paramString3);
      }
      return paramContext;
    }
    y.f("hmsSdk", "context is null or spName empty or spkey is empty");
    return paramString3;
  }
  
  public static Map<String, ?> a(Context paramContext, String paramString)
  {
    return b(paramContext, paramString).getAll();
  }
  
  public static void a(Context paramContext, String paramString, String... paramVarArgs)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString))) {
      if (paramVarArgs != null) {}
    }
    for (paramContext = "clearData(): No data need to be deleted,keys is null";; paramContext = "clearData(): parameter error.context,spname")
    {
      y.f("hmsSdk", paramContext);
      return;
      paramContext = b(paramContext, paramString);
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
      return;
    }
  }
  
  public static SharedPreferences b(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(c(paramContext, paramString), 0);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramContext = b(paramContext, paramString1);
      if (paramContext != null)
      {
        paramContext = paramContext.edit();
        paramContext.putLong(paramString2, paramLong);
        paramContext.commit();
      }
      return;
    }
    y.f("hmsSdk", "context is null or spName empty or spkey is empty");
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramContext = b(paramContext, paramString1);
      if (paramContext != null)
      {
        paramContext = paramContext.edit();
        paramContext.putString(paramString2, paramString3);
        paramContext.commit();
      }
      return;
    }
    y.e("hmsSdk", "context is null or spName empty or spkey is empty");
  }
  
  public static String c(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageName();
    Object localObject = c.n("_hms_config_tag", "oper");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hms_");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramContext);
      return ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hms_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramContext);
    localStringBuilder.append("_");
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.g0
 * JD-Core Version:    0.7.0.1
 */