package com.huawei.hms.stats;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class aq
{
  private static aq a;
  private static Map<String, Long> c = new HashMap();
  private Context b;
  
  public static aq a()
  {
    return b();
  }
  
  private static aq b()
  {
    try
    {
      if (a == null) {
        a = new aq();
      }
      aq localaq = a;
      return localaq;
    }
    finally {}
  }
  
  private void b(Context paramContext)
  {
    String str1 = k.b(paramContext);
    b.b(str1);
    if (bd.a().b())
    {
      String str2 = ap.b(paramContext, "global_v2", "app_ver", "");
      ap.a(paramContext, "global_v2", "app_ver", str1);
      b.c(str2);
      if (TextUtils.isEmpty(str2)) {
        af.b("HiAnalyticsEventServer", "app ver is first save!");
      }
      while (str2.equals(str1)) {
        return;
      }
      af.b("HiAnalyticsEventServer", "the appVers are different!");
      a().a("", "alltype", str2);
      return;
    }
    af.b("HiAnalyticsEventServer", "userManager.isUserUnlocked() == false");
  }
  
  public void a(Context paramContext)
  {
    this.b = paramContext;
    b(paramContext);
    n.a().c().c(k.a());
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.b == null)
    {
      af.c("HiAnalyticsEventServer", "onReport() null context or SDK was not init.");
      return;
    }
    af.b("hmsSdk", "onReport: Before calling runtaskhandler()");
    a(paramString, bb.a(paramInt), b.f());
  }
  
  public void a(String paramString1, int paramInt, String paramString2, JSONObject paramJSONObject)
  {
    long l2 = System.currentTimeMillis();
    long l1 = l2;
    if (2 == paramInt) {
      l1 = bb.a("yyyy-MM-dd", l2);
    }
    paramString1 = new as(paramString2, paramJSONObject, paramString1, bb.a(paramInt), l1);
    aw.a().a(paramString1);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (c.i(paramString1, paramString2))
    {
      long l1 = c.n(paramString1, paramString2);
      long l2 = System.currentTimeMillis();
      if (l2 - l1 > 30000L)
      {
        af.a("HiAnalyticsEventServer", "begin to call onReport!");
        c.a(paramString1, paramString2, l2);
        a(paramString1, paramString2, b.f());
        return;
      }
      af.c("HiAnalyticsEventServer", "autoReport timeout. interval < 30s ");
      return;
    }
    af.b("HiAnalyticsEventServer", "auto report is closed tag:" + paramString1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (c.j(paramString1, paramString2))
    {
      String str = m.a(this.b);
      if (!"WIFI".equals(str))
      {
        af.b("HiAnalyticsEventServer", "strNetworkType is :" + str);
        return;
      }
    }
    paramString1 = new at(paramString1, paramString2, paramString3);
    aw.a().a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.aq
 * JD-Core Version:    0.7.0.1
 */