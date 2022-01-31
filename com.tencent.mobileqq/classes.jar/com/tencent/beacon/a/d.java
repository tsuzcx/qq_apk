package com.tencent.beacon.a;

import android.content.Context;
import com.tencent.beacon.d.a;
import com.tencent.beacon.event.UserAction;

public final class d
{
  private static d n = null;
  private Context a = null;
  private String b = "";
  private String c = "";
  private byte d = -1;
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private long j = 0L;
  private String k = "";
  private String l = "";
  private String m = "";
  
  public static void a(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        if (n == null) {
          n = new d();
        }
        synchronized (n)
        {
          a.e("init cominfo", new Object[0]);
          n.a = paramContext;
          f.a(paramContext);
          n.b = f.b();
          n.c = f.a();
          n.n();
          n.e(b.e(paramContext));
          n.a(b.f(paramContext));
          n.f("beacon");
          n.g("2.4.2");
          n.b("unknown");
          n.h(f.b(paramContext));
          String str = b.a(paramContext);
          if (!"".equals(str))
          {
            n.d(str);
            n.c(f.c(b.b(paramContext)));
            return;
          }
          if ((UserAction.getAppkey() != null) && (!"".equals(UserAction.getAppkey()))) {
            n.d(UserAction.getAppkey());
          }
        }
        n.d(n.o());
      }
      finally {}
    }
  }
  
  private void e(String paramString)
  {
    try
    {
      this.e = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void f(String paramString)
  {
    try
    {
      this.g = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void g(String paramString)
  {
    try
    {
      this.h = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  private void h(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 35
    //   4: aload_1
    //   5: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifne +14 -> 24
    //   13: aload_0
    //   14: getfield 33	com/tencent/beacon/a/d:a	Landroid/content/Context;
    //   17: ldc 136
    //   19: aload_1
    //   20: invokestatic 139	com/tencent/beacon/a/b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   23: pop
    //   24: aload_0
    //   25: aload_1
    //   26: putfield 55	com/tencent/beacon/a/d:k	Ljava/lang/String;
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    //   37: astore_3
    //   38: goto -14 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	d
    //   0	41	1	paramString	String
    //   8	2	2	bool	boolean
    //   37	1	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	9	32	finally
    //   13	24	32	finally
    //   24	29	32	finally
    //   13	24	37	java/lang/Exception
  }
  
  public static d m()
  {
    try
    {
      d locald = n;
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void n()
  {
    try
    {
      this.d = 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private String o()
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
  
  public final String a()
  {
    return this.b;
  }
  
  public final void a(long paramLong)
  {
    try
    {
      this.j = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      this.f = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String b()
  {
    return this.c;
  }
  
  public final void b(String paramString)
  {
    try
    {
      this.i = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final byte c()
  {
    try
    {
      byte b1 = this.d;
      return b1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void c(String paramString)
  {
    try
    {
      this.m = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String d()
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
  
  public final void d(String paramString)
  {
    try
    {
      this.l = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String e()
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
  
  public final String f()
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
  
  public final String g()
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
  
  public final long h()
  {
    try
    {
      long l1 = this.j;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final String i()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 35
    //   4: aload_0
    //   5: getfield 55	com/tencent/beacon/a/d:k	Ljava/lang/String;
    //   8: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: istore_1
    //   12: iload_1
    //   13: ifeq +18 -> 31
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 33	com/tencent/beacon/a/d:a	Landroid/content/Context;
    //   21: ldc 136
    //   23: ldc 35
    //   25: invokestatic 146	com/tencent/beacon/a/b:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: putfield 55	com/tencent/beacon/a/d:k	Ljava/lang/String;
    //   31: aload_0
    //   32: getfield 55	com/tencent/beacon/a/d:k	Ljava/lang/String;
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: areturn
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: goto -15 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	d
    //   11	2	1	bool	boolean
    //   35	4	2	str	String
    //   40	4	2	localObject	Object
    //   45	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	12	40	finally
    //   16	31	40	finally
    //   31	36	40	finally
    //   16	31	45	java/lang/Exception
  }
  
  public final String j()
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
  
  public final String k()
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
  
  public final Context l()
  {
    try
    {
      Context localContext = this.a;
      return localContext;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.d
 * JD-Core Version:    0.7.0.1
 */