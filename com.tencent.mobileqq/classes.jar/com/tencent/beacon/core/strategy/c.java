package com.tencent.beacon.core.strategy;

import android.util.SparseArray;
import com.tencent.beacon.core.e.d;
import java.util.Map;

public class c
  implements a
{
  private static volatile c a;
  public boolean b = false;
  private String c = "";
  private int d = 360;
  private int e = 100;
  private SparseArray<b> f = null;
  private Map<String, String> g = null;
  private boolean h = true;
  
  private c()
  {
    this.f.put(1, new b(1));
    this.f.put(2, new b(2));
    this.f.put(3, new b(3));
  }
  
  public static c g()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new c();
      }
      return a;
    }
    finally {}
  }
  
  public String a(int paramInt)
  {
    b localb = b(paramInt);
    if (localb == null) {
      return "";
    }
    return localb.d();
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	com/tencent/beacon/core/strategy/c:g	Ljava/util/Map;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +18 -> 26
    //   11: aload_2
    //   12: aload_1
    //   13: invokeinterface 73 2 0
    //   18: checkcast 75	java/lang/String
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: aconst_null
    //   27: astore_1
    //   28: goto -6 -> 22
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	c
    //   0	36	1	paramString	String
    //   6	6	2	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   11	22	31	finally
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      this.b = true;
      a(false);
      this.c = com.tencent.beacon.core.c.a.b.a(paramString1);
      d.a("[strategy] set strategy url to %s by api.", new Object[] { this.c });
      paramString1 = (b)h().get(1);
      if (paramString1 != null)
      {
        paramString1.c = com.tencent.beacon.core.c.a.b.a(paramString2);
        d.a("[strategy] set user event url to %s by api.", new Object[] { paramString1.c });
      }
      return;
    }
    finally {}
  }
  
  public void a(Map<String, String> paramMap)
  {
    try
    {
      this.g = paramMap;
      return;
    }
    finally
    {
      paramMap = finally;
      throw paramMap;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    d.a("[net] -> change to http mode.", new Object[0]);
    this.h = paramBoolean;
  }
  
  public boolean a()
  {
    return this.h;
  }
  
  public int b()
  {
    Object localObject = (b)h().get(1);
    if (localObject != null)
    {
      localObject = ((b)localObject).a();
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
  
  /* Error */
  public b b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/beacon/core/strategy/c:f	Landroid/util/SparseArray;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +16 -> 24
    //   11: aload_2
    //   12: iload_1
    //   13: invokevirtual 96	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   16: checkcast 49	com/tencent/beacon/core/strategy/b
    //   19: astore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_2
    //   23: areturn
    //   24: aconst_null
    //   25: astore_2
    //   26: goto -6 -> 20
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	c
    //   0	34	1	paramInt	int
    //   6	20	2	localObject1	Object
    //   29	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	29	finally
    //   11	20	29	finally
  }
  
  public String b(String paramString)
  {
    Object localObject = (b)h().get(1);
    if (localObject != null)
    {
      localObject = ((b)localObject).a();
      if (localObject != null) {
        return (String)((Map)localObject).get(paramString);
      }
    }
    return null;
  }
  
  public String c()
  {
    String str = com.tencent.beacon.core.c.a.b.a(g().a() ^ true, this.c);
    d.a("[net] module strategy url: %s", new Object[] { str });
    return str;
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void c(String paramString)
  {
    if (this.b)
    {
      d.i("[strategy] url has defined by api, don't change.", new Object[0]);
      return;
    }
    this.c = paramString;
  }
  
  public boolean d()
  {
    String str = b("stopTest");
    if (str != null) {
      return "y".equals(str);
    }
    return false;
  }
  
  public Map<String, String> e()
  {
    try
    {
      Map localMap = this.g;
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public SparseArray<b> f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/beacon/core/strategy/c:f	Landroid/util/SparseArray;
    //   6: ifnull +22 -> 28
    //   9: new 148	com/tencent/beacon/core/e/h
    //   12: dup
    //   13: invokespecial 149	com/tencent/beacon/core/e/h:<init>	()V
    //   16: aload_0
    //   17: getfield 38	com/tencent/beacon/core/strategy/c:f	Landroid/util/SparseArray;
    //   20: invokevirtual 152	com/tencent/beacon/core/e/h:a	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aconst_null
    //   29: astore_1
    //   30: goto -6 -> 24
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	c
    //   23	7	1	localSparseArray	SparseArray
    //   33	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	33	finally
  }
  
  public SparseArray<b> h()
  {
    return this.f;
  }
  
  public int i()
  {
    return this.d;
  }
  
  public int j()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = (String)((Map)localObject).get("maxStrategyQueryOneDay");
      if ((localObject != null) && (!((String)localObject).trim().equals("")))
      {
        int i = this.e;
        try
        {
          int j = Integer.valueOf((String)localObject).intValue();
          return j;
        }
        catch (Exception localException)
        {
          return i;
        }
      }
    }
    return this.e;
  }
  
  /* Error */
  public boolean k()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	com/tencent/beacon/core/strategy/c:g	Ljava/util/Map;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +47 -> 55
    //   11: aload_3
    //   12: ldc 164
    //   14: invokeinterface 73 2 0
    //   19: checkcast 75	java/lang/String
    //   22: astore_3
    //   23: aload_3
    //   24: ifnull +31 -> 55
    //   27: ldc 141
    //   29: aload_3
    //   30: invokevirtual 168	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   33: ifeq +22 -> 55
    //   36: invokestatic 174	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   39: bipush 11
    //   41: invokevirtual 177	java/util/Calendar:get	(I)I
    //   44: istore_1
    //   45: iload_1
    //   46: ifne +9 -> 55
    //   49: iconst_1
    //   50: istore_2
    //   51: aload_0
    //   52: monitorexit
    //   53: iload_2
    //   54: ireturn
    //   55: iconst_0
    //   56: istore_2
    //   57: goto -6 -> 51
    //   60: astore_3
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_3
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	c
    //   44	2	1	i	int
    //   50	7	2	bool	boolean
    //   6	24	3	localObject1	Object
    //   60	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	60	finally
    //   11	23	60	finally
    //   27	45	60	finally
  }
  
  public void l()
  {
    String str = b("isSocketOnOff");
    if ((str != null) && ("n".equals(str))) {
      a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.strategy.c
 * JD-Core Version:    0.7.0.1
 */