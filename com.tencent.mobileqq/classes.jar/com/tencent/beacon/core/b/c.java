package com.tencent.beacon.core.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.beacon.core.BeaconIdJNI;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.h;

public final class c
{
  public static String a = "";
  private static c b = null;
  private final Context c;
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = "";
  
  private c(Context paramContext)
  {
    if (paramContext == null) {
      b.d("[core] create detail user info failed.", new Object[0]);
    }
    this.c = paramContext;
    d.a(paramContext);
    this.i = d.d(paramContext);
    this.g = d.e(paramContext);
    if (h.a(this.g)) {
      this.g = d.d();
    }
    this.h = d.c(paramContext);
    d.e();
    new StringBuilder().append(d.f()).append("m");
    if (com.tencent.beacon.core.c.i.a(paramContext).a()) {
      this.j = d.h();
    }
    for (;;)
    {
      d.a(paramContext);
      this.f = d.b(paramContext);
      if (!h.a(this.f)) {}
      try
      {
        paramContext = com.tencent.beacon.core.a.c.a(paramContext);
        if (h.a(paramContext.a("IMEI_DENGTA", ""))) {
          paramContext.a().a("IMEI_DENGTA", this.f).b();
        }
        b.a("[core] imei: " + this.f, new Object[0]);
        return;
        this.j = "";
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          com.tencent.beacon.core.d.i.a(paramContext);
        }
      }
    }
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new c(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public final String a()
  {
    try
    {
      if (h.a(this.f)) {
        this.f = com.tencent.beacon.core.a.c.a(this.c).a("IMEI_DENGTA", "");
      }
      String str = this.f;
      return str;
    }
    finally {}
  }
  
  public final String b()
  {
    try
    {
      String str = this.g;
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
      String str = this.h;
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
      String str = this.i;
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
    return this.j;
  }
  
  public final String f()
  {
    try
    {
      if (h.a(this.e)) {
        this.e = BeaconIdJNI.a(this.c, Build.VERSION.SDK_INT);
      }
      String str = this.e;
      return str;
    }
    finally {}
  }
  
  public final String g()
  {
    try
    {
      if (h.a(this.d)) {
        this.d = this.c.getApplicationInfo().targetSdkVersion;
      }
      String str = this.d;
      return str;
    }
    finally {}
  }
  
  public final String h()
  {
    try
    {
      String str = a;
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
 * Qualified Name:     com.tencent.beacon.core.b.c
 * JD-Core Version:    0.7.0.1
 */