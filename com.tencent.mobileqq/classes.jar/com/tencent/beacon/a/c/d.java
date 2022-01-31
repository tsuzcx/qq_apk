package com.tencent.beacon.a.c;

import android.content.Context;
import com.tencent.beacon.a.f.h;
import com.tencent.beacon.a.g.a;

public final class d
{
  private static d a = null;
  private final Context b;
  private f c;
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  
  private d(Context paramContext)
  {
    if (paramContext == null) {
      a.d("[core] create detail user info failed.", new Object[0]);
    }
    this.b = paramContext;
    e.a(paramContext);
    this.g = e.d(paramContext);
    this.e = e.e(paramContext);
    Object localObject = this.e;
    int i;
    if ((localObject == null) || (((String)localObject).equals("")))
    {
      i = 1;
      if (i != 0) {
        this.e = e.d();
      }
      this.f = e.c(paramContext);
      e.e();
      new StringBuilder().append(e.f()).append("m");
      if (!h.a(paramContext).a()) {
        break label319;
      }
      this.h = e.g();
      label170:
      e.a(paramContext);
      this.d = e.b(paramContext);
      localObject = this.d;
      if ((localObject != null) && (!((String)localObject).equals(""))) {
        break label328;
      }
      i = 1;
      label206:
      if (i != 0) {}
    }
    for (;;)
    {
      try
      {
        localObject = com.tencent.beacon.a.a.c.a(paramContext);
        String str = ((com.tencent.beacon.a.a.c)localObject).a("IMEI_DENGTA", "");
        i = j;
        if (str != null)
        {
          if (!str.equals("")) {
            continue;
          }
          i = j;
        }
        if (i != 0) {
          ((com.tencent.beacon.a.a.c)localObject).a().a("IMEI_DENGTA", this.d).b();
        }
      }
      catch (Exception localException)
      {
        label319:
        label328:
        continue;
      }
      a.a("[core] imei: " + this.d, new Object[0]);
      this.c = new c(paramContext, this.d, this.g);
      return;
      i = 0;
      break;
      this.h = "";
      break label170;
      i = 0;
      break label206;
      i = 0;
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
    label64:
    for (;;)
    {
      try
      {
        String str = this.d;
        if (str != null) {
          if (str.equals(""))
          {
            break label64;
            if (i != 0) {
              this.d = com.tencent.beacon.a.a.c.a(this.b).a("IMEI_DENGTA", "");
            }
            str = this.d;
            return str;
          }
          else
          {
            i = 0;
            continue;
          }
        }
        int i = 1;
      }
      finally {}
    }
  }
  
  public final void a(f paramf)
  {
    this.c = paramf;
  }
  
  public final String b()
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
  
  public final String c()
  {
    try
    {
      String str = this.f;
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
      String str = this.g;
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
    return this.h;
  }
  
  /* Error */
  public final String f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 129	com/tencent/beacon/a/c/d:c	Lcom/tencent/beacon/a/c/f;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 129	com/tencent/beacon/a/c/d:c	Lcom/tencent/beacon/a/c/f;
    //   13: invokeinterface 137 1 0
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: areturn
    //   23: ldc 29
    //   25: astore_1
    //   26: goto -7 -> 19
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	d
    //   18	8	1	str	String
    //   29	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	29	finally
  }
  
  public final f g()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.c.d
 * JD-Core Version:    0.7.0.1
 */