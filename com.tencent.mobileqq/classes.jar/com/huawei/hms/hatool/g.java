package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

public abstract class g
{
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(a.a(paramString1, paramString2))) {
      return a.a(paramString1, paramString2);
    }
    y.c("hmsSdk", "getAndroidId(): to getConfigByType()");
    return c(paramContext, paramString1, paramString2);
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString2.equals("oper")) {
      return d(paramContext, paramString1, paramString2);
    }
    if (paramString2.equals("maint")) {
      return d(paramContext, paramString1, paramString2);
    }
    if (paramString2.equals("diffprivacy")) {
      return d(paramContext, paramString1, paramString2);
    }
    if (paramString2.equals("preins")) {
      return d(paramContext, paramString1, paramString2);
    }
    paramContext = new StringBuilder();
    paramContext.append("getChannel(): Invalid type: ");
    paramContext.append(paramString2);
    y.f("hmsSdk", paramContext.toString());
    return "";
  }
  
  public static String c(Context paramContext, String paramString1, String paramString2)
  {
    if (a.b(paramString1, paramString2))
    {
      if (TextUtils.isEmpty(b.b()))
      {
        paramContext = f.a(paramContext);
        i.c().b().b(paramContext);
      }
      return b.b();
    }
    return "";
  }
  
  public static String d(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(c.d(paramString1, paramString2))) {
      return c.d(paramString1, paramString2);
    }
    paramString2 = i.c().b();
    if (TextUtils.isEmpty(paramString2.g()))
    {
      paramString1 = f.b(paramContext);
      paramContext = paramString1;
      if (!q0.a("channel", paramString1, 256)) {
        paramContext = "";
      }
      paramString2.d(paramContext);
    }
    return paramString2.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.g
 * JD-Core Version:    0.7.0.1
 */