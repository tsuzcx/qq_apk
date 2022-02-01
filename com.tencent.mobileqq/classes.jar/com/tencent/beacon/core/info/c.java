package com.tencent.beacon.core.info;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.beacon.core.d.k;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.e.j;

public class c
{
  private static volatile c a;
  public static String b;
  public static String c = "";
  public static String d = "";
  private final Context e;
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = "";
  private String k = "";
  private String l = "";
  private String m = "";
  private String n = "";
  private String o = "";
  private String p = "";
  
  private c(Context paramContext)
  {
    if (paramContext == null) {
      d.b("[core] create detail user info failed.", new Object[0]);
    }
    this.e = paramContext;
    e locale = e.d(paramContext);
    this.m = locale.b(paramContext);
    this.k = locale.i(paramContext);
    if (j.b(this.k)) {
      this.k = locale.e(paramContext);
    }
    this.l = locale.h(paramContext);
    this.o = locale.d();
    this.p = (locale.q() + "m");
    if (k.a(paramContext).f()) {}
    for (this.n = ("" + locale.l());; this.n = "")
    {
      b(paramContext);
      this.h = locale.g(paramContext);
      this.i = locale.j(paramContext);
      this.j = locale.k();
      return;
    }
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new c(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void b(Context paramContext)
  {
    this.g = e.d(paramContext).f(paramContext);
    if (!j.b(this.g)) {}
    for (;;)
    {
      try
      {
        paramContext = com.tencent.beacon.core.a.f.a(paramContext);
        int i1 = f.a();
        if (i1 == 1) {
          continue;
        }
        if (j.b(paramContext.a("IMEI_DENGTA", "")))
        {
          paramContext = paramContext.b();
          paramContext.a("IMEI_DENGTA", this.g).a();
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      d.d("[core] imei: " + this.g, new Object[0]);
      return;
      if (j.b(paramContext.a("IMEI_DENGTA", "imei_v2", "")))
      {
        paramContext = paramContext.b();
        paramContext.b("imei_v2", this.g).a();
      }
    }
  }
  
  public String a()
  {
    try
    {
      String str = this.m;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String b()
  {
    return this.n;
  }
  
  /* Error */
  public String c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/tencent/beacon/core/info/c:g	Ljava/lang/String;
    //   6: invokestatic 76	com/tencent/beacon/core/e/j:b	(Ljava/lang/String;)Z
    //   9: ifeq +28 -> 37
    //   12: invokestatic 135	com/tencent/beacon/core/info/f:a	()I
    //   15: iconst_1
    //   16: if_icmpeq +30 -> 46
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 61	com/tencent/beacon/core/info/c:e	Landroid/content/Context;
    //   24: invokestatic 130	com/tencent/beacon/core/a/f:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/a/f;
    //   27: ldc 137
    //   29: ldc 11
    //   31: invokevirtual 140	com/tencent/beacon/core/a/f:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   34: putfield 34	com/tencent/beacon/core/info/c:g	Ljava/lang/String;
    //   37: aload_0
    //   38: getfield 34	com/tencent/beacon/core/info/c:g	Ljava/lang/String;
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 61	com/tencent/beacon/core/info/c:e	Landroid/content/Context;
    //   51: invokestatic 130	com/tencent/beacon/core/a/f:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/a/f;
    //   54: ldc 137
    //   56: ldc 154
    //   58: ldc 11
    //   60: invokevirtual 157	com/tencent/beacon/core/a/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   63: putfield 34	com/tencent/beacon/core/info/c:g	Ljava/lang/String;
    //   66: goto -29 -> 37
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	c
    //   41	4	1	str	String
    //   69	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	37	69	finally
    //   37	42	69	finally
    //   46	66	69	finally
  }
  
  public String d()
  {
    return this.h;
  }
  
  public String e()
  {
    try
    {
      String str = this.l;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String f()
  {
    try
    {
      String str = this.k;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String g()
  {
    return this.j;
  }
  
  public String h()
  {
    return this.i;
  }
  
  public String i()
  {
    try
    {
      String str = b;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String j()
  {
    try
    {
      String str = c;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String k()
  {
    try
    {
      String str = d;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String l()
  {
    try
    {
      if (j.b(this.f)) {
        this.f = ("" + this.e.getApplicationInfo().targetSdkVersion);
      }
      String str = this.f;
      return str;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.info.c
 * JD-Core Version:    0.7.0.1
 */