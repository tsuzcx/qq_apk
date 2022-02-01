package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONObject;

public class h0
{
  public static h0 b;
  public Context a;
  
  static
  {
    new HashMap();
  }
  
  public static h0 a()
  {
    return b();
  }
  
  public static h0 b()
  {
    try
    {
      if (b == null) {
        b = new h0();
      }
      h0 localh0 = b;
      return localh0;
    }
    finally {}
  }
  
  public void a(Context paramContext)
  {
    this.a = paramContext;
    b(paramContext);
    i.c().b().e(f.a());
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.a == null)
    {
      y.e("hmsSdk", "onReport() null context or SDK was not init.");
      return;
    }
    y.c("hmsSdk", "onReport: Before calling runtaskhandler()");
    a(paramString, s0.a(paramInt), b.d());
  }
  
  public void a(String paramString1, int paramInt, String paramString2, JSONObject paramJSONObject)
  {
    long l2 = System.currentTimeMillis();
    long l1 = l2;
    if (2 == paramInt) {
      l1 = s0.a("yyyy-MM-dd", l2);
    }
    paramString1 = new j0(paramString2, paramJSONObject, paramString1, s0.a(paramInt), l1);
    n0.b().a(paramString1);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (c.a(paramString1, paramString2))
    {
      long l1 = c.j(paramString1, paramString2);
      long l2 = System.currentTimeMillis();
      if (l2 - l1 > 30000L)
      {
        y.a("hmsSdk", "begin to call onReport!");
        c.a(paramString1, paramString2, l2);
        a(paramString1, paramString2, b.d());
        return;
      }
      y.f("hmsSdk", "autoReport timeout. interval < 30s ");
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("auto report is closed tag:");
    paramString2.append(paramString1);
    y.c("hmsSdk", paramString2.toString());
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      y.e("hmsSdk", "onReport() null context or SDK was not init.");
      return;
    }
    localObject = h.a((Context)localObject);
    if ((c.e(paramString1, paramString2)) && (!"WIFI".equals(localObject)))
    {
      paramString1 = new StringBuilder();
      paramString1.append("strNetworkType is :");
      paramString1.append((String)localObject);
      y.c("hmsSdk", paramString1.toString());
      return;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"2G".equals(localObject)))
    {
      paramString1 = new k0(paramString1, paramString2, paramString3);
      n0.b().a(paramString1);
      return;
    }
    y.e("hmsSdk", "The network is bad.");
  }
  
  public final void b(Context paramContext)
  {
    String str1 = f.d(paramContext);
    b.a(str1);
    if (u0.b().a())
    {
      String str2 = g0.a(paramContext, "global_v2", "app_ver", "");
      g0.b(paramContext, "global_v2", "app_ver", str1);
      b.b(str2);
      if (TextUtils.isEmpty(str2))
      {
        paramContext = "app ver is first save!";
      }
      else
      {
        if (str2.equals(str1)) {
          return;
        }
        y.c("hmsSdk", "the appVers are different!");
        a().a("", "alltype", str2);
      }
    }
    else
    {
      paramContext = "userManager.isUserUnlocked() == false";
    }
    y.c("hmsSdk", paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.h0
 * JD-Core Version:    0.7.0.1
 */