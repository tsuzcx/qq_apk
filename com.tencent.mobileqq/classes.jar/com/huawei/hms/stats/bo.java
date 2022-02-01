package com.huawei.hms.stats;

import android.content.Context;

public final class bo
{
  private static final String[] a = { "ABTesting", "_default_config_tag", "_openness_config_tag", "_hms_config_tag" };
  private static bo b = null;
  private static final Object c = new Object();
  private Context d;
  
  public static bo a()
  {
    if (b == null) {
      b();
    }
    return b;
  }
  
  private static void b()
  {
    try
    {
      if (b == null) {
        b = new bo();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(Context paramContext)
  {
    synchronized (c)
    {
      if (this.d != null)
      {
        af.c("HiAnalyticsDataManager", "DataManager already initialized.");
        return;
      }
      this.d = paramContext;
      n.a().c().a(this.d);
      n.a().c().g(paramContext.getPackageName());
      bg.a().a(paramContext);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.d == null)
    {
      af.c("HiAnalyticsDataManager", "clearDataByTag() sdk is not init");
      return;
    }
    af.b("HiAnalyticsDataManager", "HiAnalyticsDataManager.clearDataByTag(String appid) is execute.");
    ap.c(this.d, paramString);
  }
  
  public void b(String paramString)
  {
    af.b("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
    if (this.d == null)
    {
      af.c("hmsSdk", "sdk is not init");
      return;
    }
    paramString = az.a("appID", paramString, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", this.d.getPackageName());
    n.a().c().h(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.bo
 * JD-Core Version:    0.7.0.1
 */