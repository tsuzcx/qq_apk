package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.updatesdk.service.a.a;
import com.huawei.updatesdk.service.e.c;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class h
{
  private static h a = new h();
  private String b;
  private String c;
  private String d = null;
  
  public static h a()
  {
    return a;
  }
  
  public void a(Context paramContext)
  {
    this.c = null;
    if (!c.b(paramContext)) {
      return;
    }
    long l = a.a().d();
    if (Math.abs(System.currentTimeMillis() - l) < 86400000L)
    {
      paramContext = a.a().e();
      a().b(paramContext);
      return;
    }
    paramContext = new h.a(null);
    paramContext.executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
    try
    {
      paramContext.get(1000L, TimeUnit.MILLISECONDS);
      return;
    }
    catch (Exception localException)
    {
      paramContext.cancel(true);
      Log.e("ServiceZoneUtil", "init AccountZone error: " + localException.toString());
    }
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    if (!TextUtils.isEmpty(this.b)) {
      return this.b;
    }
    return this.c;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public boolean d()
  {
    if (this.b != null) {
      return this.b.equals(this.c);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.h
 * JD-Core Version:    0.7.0.1
 */