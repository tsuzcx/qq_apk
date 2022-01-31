package com.tencent.beacon.a.b;

import android.content.Context;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.beacon.a.c;
import com.tencent.beacon.a.f;
import com.tencent.beacon.d.a;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class d
{
  private static d a = null;
  private String b = "http://oth.str.mdt.qq.com:8080/analytics/upload";
  private int c = 360;
  private int d = 1;
  private int e = 100;
  private SparseArray<a> f = null;
  private Map<String, String> g = null;
  private byte h = 3;
  private byte i = 2;
  private String j = "*^@K#K@!";
  private String k = "";
  private String l = "";
  private String m = "";
  
  private d()
  {
    this.f.put(1, new a(1));
    this.f.put(2, new a(2));
    this.f.put(3, new a(3));
  }
  
  public static d a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new d();
      }
      return a;
    }
    finally {}
  }
  
  private void c(String paramString)
  {
    try
    {
      this.l = paramString;
      this.k = Base64.encodeToString(f.a(paramString), 2);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void d(String paramString)
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
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  /* Error */
  final void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 96
    //   5: invokestatic 99	com/tencent/beacon/a/f:a	(Landroid/content/Context;Ljava/lang/String;)[Ljava/lang/Object;
    //   8: astore 6
    //   10: aload 6
    //   12: ifnull +55 -> 67
    //   15: aload 6
    //   17: arraylength
    //   18: iconst_3
    //   19: if_icmpne +48 -> 67
    //   22: new 101	java/util/Date
    //   25: dup
    //   26: invokespecial 102	java/util/Date:<init>	()V
    //   29: invokevirtual 106	java/util/Date:getTime	()J
    //   32: ldc2_w 107
    //   35: ldiv
    //   36: lstore 4
    //   38: aload 6
    //   40: iconst_2
    //   41: aaload
    //   42: checkcast 110	java/lang/Long
    //   45: invokevirtual 113	java/lang/Long:longValue	()J
    //   48: lstore_2
    //   49: lload_2
    //   50: lload 4
    //   52: lcmp
    //   53: ifle +14 -> 67
    //   56: aload_0
    //   57: aload 6
    //   59: iconst_1
    //   60: aaload
    //   61: checkcast 115	java/lang/String
    //   64: invokespecial 117	com/tencent/beacon/a/b/d:d	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: aload_1
    //   69: invokestatic 121	com/tencent/beacon/a/f:r	(Landroid/content/Context;)Ljava/lang/String;
    //   72: invokespecial 123	com/tencent/beacon/a/b/d:c	(Ljava/lang/String;)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore 7
    //   80: lconst_0
    //   81: lstore_2
    //   82: goto -33 -> 49
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	d
    //   0	90	1	paramContext	Context
    //   48	34	2	l1	long
    //   36	15	4	l2	long
    //   8	50	6	arrayOfObject	Object[]
    //   78	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   38	49	78	java/lang/Exception
    //   2	10	85	finally
    //   15	38	85	finally
    //   38	49	85	finally
    //   56	67	85	finally
    //   67	75	85	finally
  }
  
  public final void a(final Context paramContext, String paramString1, final String paramString2)
  {
    try
    {
      this.m = paramString1;
      paramContext = new Runnable()
      {
        public final void run()
        {
          String str = d.this;
          try
          {
            l1 = f.e(paramString2).getTime() / 1000L;
            long l2 = l1;
            if (l1 == 0L) {
              l2 = new Date().getTime() / 1000L + 86400L;
            }
            f.a(paramContext, "sid", new Object[] { str, Long.valueOf(l2) });
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              long l1 = 0L;
            }
          }
        }
      };
      c.a().a(paramContext);
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
    this.b = paramString;
  }
  
  public final void a(Map<String, String> paramMap)
  {
    this.g = paramMap;
  }
  
  /* Error */
  public final a b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/tencent/beacon/a/b/d:f	Landroid/util/SparseArray;
    //   6: ifnull +19 -> 25
    //   9: aload_0
    //   10: getfield 49	com/tencent/beacon/a/b/d:f	Landroid/util/SparseArray;
    //   13: iload_1
    //   14: invokevirtual 143	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   17: checkcast 8	com/tencent/beacon/a/b/d$a
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
    //   0	35	0	this	d
    //   0	35	1	paramInt	int
    //   20	7	2	locala	a
    //   30	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	30	finally
  }
  
  public final String b()
  {
    return this.b;
  }
  
  public final void b(String paramString)
  {
    try
    {
      this.j = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final Map<String, String> d()
  {
    return this.g;
  }
  
  /* Error */
  public final SparseArray<a> e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/tencent/beacon/a/b/d:f	Landroid/util/SparseArray;
    //   6: ifnull +23 -> 29
    //   9: new 150	com/tencent/beacon/d/d
    //   12: dup
    //   13: invokespecial 151	com/tencent/beacon/d/d:<init>	()V
    //   16: pop
    //   17: aload_0
    //   18: getfield 49	com/tencent/beacon/a/b/d:f	Landroid/util/SparseArray;
    //   21: invokestatic 154	com/tencent/beacon/d/d:a	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
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
    //   0	39	0	this	d
    //   24	7	1	localSparseArray	SparseArray
    //   34	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	34	finally
  }
  
  public final boolean f()
  {
    if (this.g != null)
    {
      String str = (String)this.g.get("updateQimei");
      if ((str != null) && ("n".equalsIgnoreCase(str))) {
        return false;
      }
      if ((str != null) && ("y".equalsIgnoreCase(str))) {
        return true;
      }
    }
    return true;
  }
  
  public final int g()
  {
    if (this.g != null)
    {
      String str = (String)this.g.get("maxQIMEIQueryOneDay");
      if ((str != null) && (!str.trim().equals("")))
      {
        int n = this.d;
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
    return this.d;
  }
  
  public final int h()
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
  public final boolean i()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/tencent/beacon/a/b/d:g	Ljava/util/Map;
    //   6: ifnull +50 -> 56
    //   9: aload_0
    //   10: getfield 51	com/tencent/beacon/a/b/d:g	Ljava/util/Map;
    //   13: ldc 193
    //   15: invokeinterface 163 2 0
    //   20: checkcast 115	java/lang/String
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +31 -> 56
    //   28: ldc 171
    //   30: aload_3
    //   31: invokevirtual 169	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   34: ifeq +22 -> 56
    //   37: invokestatic 199	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   40: bipush 11
    //   42: invokevirtual 202	java/util/Calendar:get	(I)I
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
    //   0	66	0	this	d
    //   45	2	1	n	int
    //   51	7	2	bool	boolean
    //   23	8	3	str	String
    //   61	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	61	finally
    //   28	46	61	finally
  }
  
  /* Error */
  public final boolean j()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/tencent/beacon/a/b/d:g	Ljava/util/Map;
    //   6: ifnull +50 -> 56
    //   9: aload_0
    //   10: getfield 51	com/tencent/beacon/a/b/d:g	Ljava/util/Map;
    //   13: ldc 204
    //   15: invokeinterface 163 2 0
    //   20: checkcast 115	java/lang/String
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +31 -> 56
    //   28: ldc 171
    //   30: aload_3
    //   31: invokevirtual 169	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   34: ifeq +22 -> 56
    //   37: invokestatic 199	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   40: bipush 11
    //   42: invokevirtual 202	java/util/Calendar:get	(I)I
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
    //   0	66	0	this	d
    //   45	2	1	n	int
    //   51	7	2	bool	boolean
    //   23	8	3	str	String
    //   61	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	61	finally
    //   28	46	61	finally
  }
  
  public final byte k()
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
  
  public final byte l()
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
  
  public final String m()
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
  
  public final String n()
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
  
  public final String o()
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
  
  public final String p()
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
  
  public static final class a
  {
    private final int a;
    private boolean b = false;
    private String c = "http://oth.eve.mdt.qq.com:8080/analytics/upload";
    private String d = "http://jrlt.beacon.qq.com/analytics/upload";
    private Map<String, String> e = null;
    private Set<String> f = null;
    private Set<String> g = null;
    
    public a(int paramInt)
    {
      this.a = paramInt;
    }
    
    public final void a(String paramString)
    {
      this.c = paramString;
    }
    
    public final void a(Map<String, String> paramMap)
    {
      this.e = paramMap;
    }
    
    public final void a(Set<String> paramSet)
    {
      this.f = paramSet;
    }
    
    public final void a(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }
    
    public final boolean a()
    {
      return this.b;
    }
    
    public final String b()
    {
      if (a.b) {
        return this.d;
      }
      return this.c;
    }
    
    public final void b(Set<String> paramSet)
    {
      this.g = paramSet;
    }
    
    public final Map<String, String> c()
    {
      return this.e;
    }
    
    public final Set<String> d()
    {
      return this.f;
    }
    
    public final int e()
    {
      return this.a;
    }
    
    public final Set<String> f()
    {
      return this.g;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.b.d
 * JD-Core Version:    0.7.0.1
 */