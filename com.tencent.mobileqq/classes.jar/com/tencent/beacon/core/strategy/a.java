package com.tencent.beacon.core.strategy;

import android.content.Context;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.beacon.core.protocol.a.c;
import java.util.Map;

public class a
{
  private static a a = null;
  private boolean b = false;
  private String c = "http://oth.str.mdt.qq.com:8080/analytics/upload";
  private int d = 360;
  private int e = 100;
  private SparseArray<a.a> f = null;
  private Map<String, String> g = null;
  private byte h = 3;
  private byte i = 2;
  private String j = "";
  private String k = "";
  private String l = "";
  private boolean m = true;
  
  private a()
  {
    this.f.put(1, new a.a(1));
    this.f.put(2, new a.a(2));
    this.f.put(3, new a.a(3));
  }
  
  public static a a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new a();
      }
      return a;
    }
    finally {}
  }
  
  private void a(Context paramContext, String paramString)
  {
    try
    {
      this.k = paramString;
      this.j = Base64.encodeToString(c.a(paramContext, paramString), 2);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private void c(String paramString)
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
  
  public final void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  /* Error */
  public final void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 95
    //   5: invokestatic 100	com/tencent/beacon/core/a/a/c:a	(Landroid/content/Context;Ljava/lang/String;)[Ljava/lang/Object;
    //   8: astore 6
    //   10: aload 6
    //   12: ifnull +55 -> 67
    //   15: aload 6
    //   17: arraylength
    //   18: iconst_3
    //   19: if_icmpne +48 -> 67
    //   22: new 102	java/util/Date
    //   25: dup
    //   26: invokespecial 103	java/util/Date:<init>	()V
    //   29: invokevirtual 107	java/util/Date:getTime	()J
    //   32: ldc2_w 108
    //   35: ldiv
    //   36: lstore 4
    //   38: aload 6
    //   40: iconst_2
    //   41: aaload
    //   42: checkcast 111	java/lang/Long
    //   45: invokevirtual 114	java/lang/Long:longValue	()J
    //   48: lstore_2
    //   49: lload_2
    //   50: lload 4
    //   52: lcmp
    //   53: ifle +14 -> 67
    //   56: aload_0
    //   57: aload 6
    //   59: iconst_1
    //   60: aaload
    //   61: checkcast 116	java/lang/String
    //   64: invokespecial 118	com/tencent/beacon/core/strategy/a:c	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: aload_1
    //   69: aload_1
    //   70: invokestatic 123	com/tencent/beacon/core/d/i:a	(Landroid/content/Context;)Ljava/lang/String;
    //   73: invokespecial 125	com/tencent/beacon/core/strategy/a:a	(Landroid/content/Context;Ljava/lang/String;)V
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
    //   0	91	0	this	a
    //   0	91	1	paramContext	Context
    //   48	35	2	l1	long
    //   36	15	4	l2	long
    //   8	50	6	arrayOfObject	Object[]
    //   79	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   38	49	79	java/lang/Exception
    //   2	10	86	finally
    //   15	38	86	finally
    //   38	49	86	finally
    //   56	67	86	finally
    //   67	76	86	finally
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      com.tencent.beacon.core.d.b.b("[net] -> update local sid|time[%s|%s].", new Object[] { paramString1, paramString2 });
      this.l = paramString1;
      paramContext = new a.1(paramString1, paramString2, paramContext);
      com.tencent.beacon.core.a.b.b().a(paramContext);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public final void a(String paramString)
  {
    if (this.b)
    {
      com.tencent.beacon.core.d.b.c("[strategy] url has defined by api, don't change.", new Object[0]);
      return;
    }
    this.c = paramString;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    try
    {
      this.b = true;
      this.c = com.tencent.beacon.core.protocol.a.b.a(paramString1);
      com.tencent.beacon.core.d.b.b("[strategy] set strategy url to %s by api.", new Object[] { this.c });
      paramString1 = (a.a)this.f.get(1);
      if (paramString1 != null)
      {
        a.a.a(paramString1, com.tencent.beacon.core.protocol.a.b.a(paramString2));
        com.tencent.beacon.core.d.b.b("[strategy] set user event url to %s by api.", new Object[] { a.a.a(paramString1) });
      }
      return;
    }
    finally {}
  }
  
  public final void a(Map<String, String> paramMap)
  {
    this.g = paramMap;
  }
  
  /* Error */
  public final a.a b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/tencent/beacon/core/strategy/a:f	Landroid/util/SparseArray;
    //   6: ifnull +19 -> 25
    //   9: aload_0
    //   10: getfield 46	com/tencent/beacon/core/strategy/a:f	Landroid/util/SparseArray;
    //   13: iload_1
    //   14: invokevirtual 162	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   17: checkcast 69	com/tencent/beacon/core/strategy/a$a
    //   20: astore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_2
    //   24: areturn
    //   25: aconst_null
    //   26: astore_2
    //   27: goto -6 -> 21
    //   30: astore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_2
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	a
    //   0	35	1	paramInt	int
    //   20	7	2	locala	a.a
    //   30	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	30	finally
  }
  
  public final String b()
  {
    if (!a().h()) {}
    for (boolean bool = true;; bool = false)
    {
      String str = com.tencent.beacon.core.protocol.a.b.a(bool, false, false, this.c);
      com.tencent.beacon.core.d.b.b("[net] module strategy url: %s", new Object[] { str });
      return str;
    }
  }
  
  public final String b(String paramString)
  {
    Object localObject = (a.a)this.f.get(1);
    if (localObject != null)
    {
      localObject = ((a.a)localObject).c();
      if (localObject != null) {
        return (String)((Map)localObject).get(paramString);
      }
    }
    return null;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  public final Map<String, String> d()
  {
    return this.g;
  }
  
  /* Error */
  public final SparseArray<a.a> e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/tencent/beacon/core/strategy/a:f	Landroid/util/SparseArray;
    //   6: ifnull +23 -> 29
    //   9: new 198	com/tencent/beacon/core/d/g
    //   12: dup
    //   13: invokespecial 199	com/tencent/beacon/core/d/g:<init>	()V
    //   16: pop
    //   17: aload_0
    //   18: getfield 46	com/tencent/beacon/core/strategy/a:f	Landroid/util/SparseArray;
    //   21: invokestatic 202	com/tencent/beacon/core/d/g:a	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: areturn
    //   29: aconst_null
    //   30: astore_1
    //   31: goto -6 -> 25
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	a
    //   24	7	1	localSparseArray	SparseArray
    //   34	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	34	finally
  }
  
  public final int f()
  {
    if (this.g != null)
    {
      String str = (String)this.g.get("maxStrategyQueryOneDay");
      if ((str != null) && (!str.trim().equals("")))
      {
        int n = this.e;
        try
        {
          int i1 = Integer.valueOf(str).intValue();
          return i1;
        }
        catch (Exception localException)
        {
          return n;
        }
      }
    }
    return this.e;
  }
  
  /* Error */
  public final boolean g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	com/tencent/beacon/core/strategy/a:g	Ljava/util/Map;
    //   6: ifnull +50 -> 56
    //   9: aload_0
    //   10: getfield 48	com/tencent/beacon/core/strategy/a:g	Ljava/util/Map;
    //   13: ldc 223
    //   15: invokeinterface 193 2 0
    //   20: checkcast 116	java/lang/String
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +31 -> 56
    //   28: ldc 225
    //   30: aload_3
    //   31: invokevirtual 229	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   34: ifeq +22 -> 56
    //   37: invokestatic 235	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   40: bipush 11
    //   42: invokevirtual 238	java/util/Calendar:get	(I)I
    //   45: istore_1
    //   46: iload_1
    //   47: ifne +9 -> 56
    //   50: iconst_1
    //   51: istore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_2
    //   55: ireturn
    //   56: iconst_0
    //   57: istore_2
    //   58: goto -6 -> 52
    //   61: astore_3
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_3
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	a
    //   45	2	1	n	int
    //   51	7	2	bool	boolean
    //   23	8	3	str	String
    //   61	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	61	finally
    //   28	46	61	finally
  }
  
  public final boolean h()
  {
    if (this.m) {}
    for (String str = "socket";; str = "http")
    {
      com.tencent.beacon.core.d.b.b("[strategy] -> use %s to upload.", new Object[] { str });
      return this.m;
    }
  }
  
  public final void i()
  {
    com.tencent.beacon.core.d.b.b("[net] -> change to http mode.", new Object[0]);
    this.m = false;
  }
  
  public final void j()
  {
    String str = b("isSocketOnOff");
    if ((str != null) && ("n".equals(str))) {
      i();
    }
  }
  
  public final int k()
  {
    Object localObject = (a.a)this.f.get(1);
    if (localObject != null)
    {
      localObject = ((a.a)localObject).c();
      if (localObject != null)
      {
        localObject = (String)((Map)localObject).get("socketPort");
        if (localObject != null) {
          return Integer.valueOf((String)localObject).intValue();
        }
      }
    }
    return 8081;
  }
  
  public final byte l()
  {
    try
    {
      byte b1 = this.h;
      return b1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final byte m()
  {
    try
    {
      byte b1 = this.i;
      return b1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String n()
  {
    try
    {
      String str = this.j;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String o()
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
  
  public final String p()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.strategy.a
 * JD-Core Version:    0.7.0.1
 */