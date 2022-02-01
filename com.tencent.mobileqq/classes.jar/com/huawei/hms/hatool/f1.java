package com.huawei.hms.hatool;

import android.content.Context;

public final class f1
{
  public static f1 b;
  public static final Object c = new Object();
  public Context a;
  
  public static f1 a()
  {
    if (b == null) {
      b();
    }
    return b;
  }
  
  public static void b()
  {
    try
    {
      if (b == null) {
        b = new f1();
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
      if (this.a != null)
      {
        y.f("hmsSdk", "DataManager already initialized.");
        return;
      }
      this.a = paramContext;
      i.c().b().a(this.a);
      i.c().b().g(paramContext.getPackageName());
      x0.a().a(paramContext);
      return;
    }
  }
  
  public void a(String paramString)
  {
    y.c("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
    Context localContext = this.a;
    if (localContext == null)
    {
      y.e("hmsSdk", "sdk is not init");
      return;
    }
    paramString = q0.a("appID", paramString, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", localContext.getPackageName());
    i.c().b().f(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.f1
 * JD-Core Version:    0.7.0.1
 */