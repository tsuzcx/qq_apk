package com.tencent.beacon.core.strategy;

import android.content.Context;
import android.util.Base64;
import com.tencent.beacon.core.c.a.b;
import com.tencent.beacon.core.c.a.c;

public class g
{
  private static volatile g a;
  private a b;
  private final String c = "sid";
  private String d = "";
  private boolean e = true;
  private int f = 8081;
  private String g = "";
  private String h = "";
  
  private g(Context paramContext)
  {
    paramContext = new e(this, paramContext);
    com.tencent.beacon.core.a.d.a().a(paramContext);
  }
  
  public static g b(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new g(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public String a()
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
  
  public String a(int paramInt)
  {
    Object localObject = this.b;
    int i;
    boolean bool2;
    if ((localObject != null) && (((a)localObject).d()))
    {
      i = 1;
      bool2 = com.tencent.beacon.core.e.d.a();
      if (paramInt != 0) {}
    }
    for (;;)
    {
      try
      {
        if (this.b != null) {
          return this.b.c();
        }
        if (this.e) {
          break label143;
        }
        bool1 = true;
        return b.a(bool1, null);
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.core.e.d.i("[strategy] get strategy error:%s", new Object[] { localThrowable.toString() });
        com.tencent.beacon.core.e.d.a(localThrowable);
        return null;
      }
      if (this.b != null) {
        return this.b.a(paramInt);
      }
      if (!e())
      {
        bool1 = true;
        localObject = b.a(bool1, bool2 & (i ^ 0x1), null);
        return localObject;
      }
      boolean bool1 = false;
      continue;
      i = 0;
      break;
      label143:
      bool1 = false;
    }
  }
  
  public String a(String paramString)
  {
    a locala = this.b;
    if (locala != null) {
      return locala.a(paramString);
    }
    return null;
  }
  
  /* Error */
  public void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 24
    //   5: invokestatic 108	com/tencent/beacon/core/a/a/c:a	(Landroid/content/Context;Ljava/lang/String;)[Ljava/lang/Object;
    //   8: astore 6
    //   10: aload 6
    //   12: ifnull +55 -> 67
    //   15: aload 6
    //   17: arraylength
    //   18: iconst_3
    //   19: if_icmpne +48 -> 67
    //   22: new 110	java/util/Date
    //   25: dup
    //   26: invokespecial 111	java/util/Date:<init>	()V
    //   29: invokevirtual 115	java/util/Date:getTime	()J
    //   32: ldc2_w 116
    //   35: ldiv
    //   36: lstore 4
    //   38: aload 6
    //   40: iconst_2
    //   41: aaload
    //   42: checkcast 119	java/lang/Long
    //   45: invokevirtual 122	java/lang/Long:longValue	()J
    //   48: lstore_2
    //   49: lload_2
    //   50: lload 4
    //   52: lcmp
    //   53: ifle +14 -> 67
    //   56: aload_0
    //   57: aload 6
    //   59: iconst_1
    //   60: aaload
    //   61: checkcast 124	java/lang/String
    //   64: invokevirtual 127	com/tencent/beacon/core/strategy/g:b	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: aload_1
    //   69: aload_1
    //   70: invokestatic 132	com/tencent/beacon/core/e/b:a	(Landroid/content/Context;)Ljava/lang/String;
    //   73: invokevirtual 135	com/tencent/beacon/core/strategy/g:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: astore 7
    //   81: lconst_0
    //   82: lstore_2
    //   83: goto -34 -> 49
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	g
    //   0	91	1	paramContext	Context
    //   48	35	2	l1	long
    //   36	15	4	l2	long
    //   8	50	6	arrayOfObject	Object[]
    //   79	1	7	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   38	49	79	java/lang/Exception
    //   2	10	86	finally
    //   15	38	86	finally
    //   38	49	86	finally
    //   56	67	86	finally
    //   67	76	86	finally
  }
  
  void a(Context paramContext, String paramString)
  {
    try
    {
      this.h = paramString;
      paramContext = c.a(paramContext, paramString);
      if (paramContext != null) {
        this.g = Base64.encodeToString(paramContext, 2);
      }
      return;
    }
    finally {}
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      com.tencent.beacon.core.e.d.a("[net] -> update local sid|time[%s|%s].", new Object[] { paramString1, paramString2 });
      this.d = paramString1;
      paramContext = new f(this, paramString1, paramString2, paramContext);
      com.tencent.beacon.core.a.d.a().a(paramContext);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void a(a parama)
  {
    this.b = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    a locala = this.b;
    if (locala != null) {
      locala.a(paramBoolean);
    }
    this.e = paramBoolean;
  }
  
  public String b()
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
  
  public void b(String paramString)
  {
    try
    {
      this.d = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String c()
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
  
  public int d()
  {
    a locala = this.b;
    if (locala == null) {
      return this.f;
    }
    return locala.b();
  }
  
  public boolean e()
  {
    a locala = this.b;
    if (locala == null) {
      return this.e;
    }
    return locala.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.strategy.g
 * JD-Core Version:    0.7.0.1
 */