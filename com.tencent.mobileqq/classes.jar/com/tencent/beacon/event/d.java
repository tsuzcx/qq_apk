package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.b;
import com.tencent.beacon.a.f;
import com.tencent.beacon.d.a;
import com.tencent.beacon.upload.i;

public final class d
{
  private static d a = null;
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  
  private d(Context paramContext)
  {
    if (paramContext == null) {
      a.d(" DetailUserInfo context == null? pls check!", new Object[0]);
    }
    a.b(" start to create DetailUserInfo", new Object[0]);
    long l = System.currentTimeMillis();
    f.a(paramContext);
    this.b = f.b(paramContext);
    a.b(" imei:" + this.b, new Object[0]);
    if (!"".equals(this.b)) {}
    try
    {
      if ("".equals(b.b(paramContext, "IMEI_DENGTA", ""))) {
        b.a(paramContext, "IMEI_DENGTA", this.b);
      }
      label151:
      this.c = f.e(paramContext);
      this.d = f.c(paramContext);
      this.e = f.d(paramContext);
      if (i.a(paramContext).a()) {}
      for (this.f = f.l();; this.f = "")
      {
        a.b(" detail create cost: %d  values:\n %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), toString() });
        return;
      }
    }
    catch (Exception localException)
    {
      break label151;
    }
  }
  
  public static d a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new d(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public final String a()
  {
    return this.f;
  }
  
  public final String b()
  {
    try
    {
      String str = this.b;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String c()
  {
    try
    {
      String str = this.c;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String d()
  {
    try
    {
      String str = this.d;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String e()
  {
    try
    {
      String str = this.e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.d
 * JD-Core Version:    0.7.0.1
 */