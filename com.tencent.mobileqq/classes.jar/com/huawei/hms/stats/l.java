package com.huawei.hms.stats;

import android.content.Context;
import android.text.TextUtils;

public abstract class l
{
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(a.c(paramString1, paramString2))) {
      return a.c(paramString1, paramString2);
    }
    af.b("hmsSdk", "getAndroidId(): to getConfigByType()");
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
    af.c("hmsSdk", "getChannel(): Invalid type: " + paramString2);
    return "";
  }
  
  private static String c(Context paramContext, String paramString1, String paramString2)
  {
    if (a.i(paramString1, paramString2))
    {
      if (TextUtils.isEmpty(b.c()))
      {
        paramContext = bi.c(paramContext);
        n.a().c().f(paramContext);
      }
      return b.c();
    }
    return "";
  }
  
  private static String d(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(c.b(paramString1, paramString2))) {
      return c.b(paramString1, paramString2);
    }
    paramString2 = n.a().c();
    if (TextUtils.isEmpty(paramString2.e()))
    {
      paramString1 = bi.d(paramContext);
      paramContext = paramString1;
      if (!az.a("channel", paramString1, 256)) {
        paramContext = "";
      }
      paramString2.b(paramContext);
    }
    return paramString2.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.l
 * JD-Core Version:    0.7.0.1
 */