package c.t.m.g;

import android.content.Context;
import java.util.HashMap;
import java.util.Timer;

public class cy
{
  private static volatile cy b = null;
  private static Context c = null;
  private volatile boolean a = true;
  private volatile boolean d = false;
  private volatile de e = de.a;
  private Timer f = null;
  
  private cy()
  {
    if ((c == null) || (c.getApplicationContext() == null)) {
      throw new IllegalStateException("Please invoke initial(context,...) first when app started!");
    }
  }
  
  /* Error */
  public static cy a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 19	c/t/m/g/cy:b	Lc/t/m/g/cy;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 19	c/t/m/g/cy:b	Lc/t/m/g/cy;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	c/t/m/g/cy
    //   21: dup
    //   22: invokespecial 52	c/t/m/g/cy:<init>	()V
    //   25: putstatic 19	c/t/m/g/cy:b	Lc/t/m/g/cy;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 19	c/t/m/g/cy:b	Lc/t/m/g/cy;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localcy	cy
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  private void a(long paramLong)
  {
    if (this.f != null)
    {
      Timer localTimer = this.f;
      cy.a locala = new cy.a(this);
      long l = paramLong;
      if (paramLong < 0L) {
        l = 0L;
      }
      localTimer.schedule(locala, l);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (paramContext.getApplicationContext() == null)) {
      throw new NullPointerException("context cannot be null!");
    }
    paramContext = paramContext.getApplicationContext();
    c = paramContext;
    do.a(paramContext);
    da.a(paramString1);
    cz.a(paramString1, paramString2);
    new cy.1("th_CC_init").start();
  }
  
  public static void a(String paramString)
  {
    cz.a(paramString);
  }
  
  public static void a(HashMap<String, String> paramHashMap)
  {
    cz.a(paramHashMap);
  }
  
  private void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        int i = cz.a().b("cc_version");
        if (i == -1)
        {
          if (paramBoolean)
          {
            l = 5000L;
            co.a("schedule : first[" + paramBoolean + "],locVer[" + i + "],delayTime[" + l + "]");
            a(l);
          }
        }
        else
        {
          l = e();
          continue;
        }
        long l = 10800000L;
      }
      catch (Throwable localThrowable)
      {
        co.b(localThrowable.toString());
        return;
      }
    }
  }
  
  private static long e()
  {
    long l1 = 86400000L;
    long l2 = cz.a().c("cc_req_interval");
    if (l2 > 86400000L) {}
    for (;;)
    {
      if (l1 < 3600000L) {
        return 3600000L;
      }
      return l1;
      l1 = l2;
    }
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	c/t/m/g/cy:d	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 29	c/t/m/g/cy:d	Z
    //   19: ldc 167
    //   21: invokestatic 142	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   24: aload_0
    //   25: new 60	java/util/Timer
    //   28: dup
    //   29: ldc 169
    //   31: invokespecial 170	java/util/Timer:<init>	(Ljava/lang/String;)V
    //   34: putfield 37	c/t/m/g/cy:f	Ljava/util/Timer;
    //   37: aload_0
    //   38: iconst_1
    //   39: invokespecial 155	c/t/m/g/cy:a	(Z)V
    //   42: goto -31 -> 11
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	cy
    //   6	2	1	bool	boolean
    //   45	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	45	finally
    //   14	42	45	finally
  }
  
  /* Error */
  public final void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	c/t/m/g/cy:d	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 29	c/t/m/g/cy:d	Z
    //   19: invokestatic 104	c/t/m/g/cz:a	()Lc/t/m/g/cz;
    //   22: getfield 173	c/t/m/g/cz:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: invokevirtual 178	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   28: ldc 180
    //   30: invokestatic 142	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: lconst_0
    //   35: invokespecial 144	c/t/m/g/cy:a	(J)V
    //   38: aload_0
    //   39: getfield 37	c/t/m/g/cy:f	Ljava/util/Timer;
    //   42: ifnull -31 -> 11
    //   45: aload_0
    //   46: getfield 37	c/t/m/g/cy:f	Ljava/util/Timer;
    //   49: astore_2
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 37	c/t/m/g/cy:f	Ljava/util/Timer;
    //   55: aload_2
    //   56: new 182	c/t/m/g/cy$2
    //   59: dup
    //   60: aload_0
    //   61: aload_2
    //   62: invokespecial 185	c/t/m/g/cy$2:<init>	(Lc/t/m/g/cy;Ljava/util/Timer;)V
    //   65: ldc2_w 186
    //   68: invokevirtual 64	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   71: goto -60 -> 11
    //   74: astore_2
    //   75: ldc 189
    //   77: aload_2
    //   78: invokestatic 192	c/t/m/g/co:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   81: goto -70 -> 11
    //   84: astore_2
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_2
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	cy
    //   6	2	1	bool	boolean
    //   49	13	2	localTimer	Timer
    //   74	4	2	localThrowable	Throwable
    //   84	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   19	71	74	java/lang/Throwable
    //   2	7	84	finally
    //   14	19	84	finally
    //   19	71	84	finally
    //   75	81	84	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.cy
 * JD-Core Version:    0.7.0.1
 */