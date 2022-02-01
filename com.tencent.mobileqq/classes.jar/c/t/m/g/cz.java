package c.t.m.g;

import android.content.Context;
import java.util.HashMap;
import java.util.Timer;

public class cz
{
  private static volatile cz b;
  private static Context c;
  private volatile boolean a = true;
  private volatile boolean d = false;
  private volatile df e = df.a;
  private Timer f = null;
  
  private cz()
  {
    Context localContext = c;
    if ((localContext != null) && (localContext.getApplicationContext() != null)) {
      return;
    }
    throw new IllegalStateException("Please invoke initial(context,...) first when app started!");
  }
  
  public static cz a()
  {
    try
    {
      if (b == null) {
        try
        {
          if (b == null) {
            b = new cz();
          }
        }
        finally {}
      }
      cz localcz = b;
      return localcz;
    }
    finally {}
  }
  
  private void a(long paramLong)
  {
    Timer localTimer = this.f;
    if (localTimer != null)
    {
      cz.a locala = new cz.a(this);
      long l = paramLong;
      if (paramLong < 0L) {
        l = 0L;
      }
      localTimer.schedule(locala, l);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext != null) && (paramContext.getApplicationContext() != null))
    {
      paramContext = paramContext.getApplicationContext();
      c = paramContext;
      dp.a(paramContext);
      db.a(paramString1);
      da.a(paramString1, paramString2);
      new cz.1("th_CC_init").start();
      return;
    }
    throw new NullPointerException("context cannot be null!");
  }
  
  public static void a(String paramString)
  {
    da.a(paramString);
  }
  
  public static void a(HashMap<String, String> paramHashMap)
  {
    da.a(paramHashMap);
  }
  
  private void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        int i = da.a().b("cc_version");
        if (i == -1)
        {
          if (!paramBoolean) {
            break label110;
          }
          l = 5000L;
        }
        else
        {
          l = e();
        }
        StringBuilder localStringBuilder = new StringBuilder("schedule : first[");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("],locVer[");
        localStringBuilder.append(i);
        localStringBuilder.append("],delayTime[");
        localStringBuilder.append(l);
        localStringBuilder.append("]");
        co.a(localStringBuilder.toString());
        a(l);
        return;
      }
      catch (Throwable localThrowable)
      {
        co.b(localThrowable.toString());
        return;
      }
      label110:
      long l = 10800000L;
    }
  }
  
  private static long e()
  {
    long l2 = da.a().c("cc_req_interval");
    long l1 = l2;
    if (l2 > 86400000L) {
      l1 = 86400000L;
    }
    l2 = l1;
    if (l1 < 3600000L) {
      l2 = 3600000L;
    }
    return l2;
  }
  
  public final void b()
  {
    try
    {
      boolean bool = this.d;
      if (bool) {
        return;
      }
      this.d = true;
      co.a("startUp()");
      this.f = new Timer("th_CC_Timer");
      a(true);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	c/t/m/g/cz:d	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 25	c/t/m/g/cz:d	Z
    //   19: invokestatic 104	c/t/m/g/da:a	()Lc/t/m/g/da;
    //   22: getfield 173	c/t/m/g/da:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: invokevirtual 178	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   28: ldc 180
    //   30: invokestatic 145	c/t/m/g/co:a	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: lconst_0
    //   35: invokespecial 147	c/t/m/g/cz:a	(J)V
    //   38: aload_0
    //   39: getfield 33	c/t/m/g/cz:f	Ljava/util/Timer;
    //   42: ifnull +29 -> 71
    //   45: aload_0
    //   46: getfield 33	c/t/m/g/cz:f	Ljava/util/Timer;
    //   49: astore_2
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 33	c/t/m/g/cz:f	Ljava/util/Timer;
    //   55: aload_2
    //   56: new 182	c/t/m/g/cz$2
    //   59: dup
    //   60: aload_0
    //   61: aload_2
    //   62: invokespecial 185	c/t/m/g/cz$2:<init>	(Lc/t/m/g/cz;Ljava/util/Timer;)V
    //   65: ldc2_w 186
    //   68: invokevirtual 64	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: astore_2
    //   75: ldc 189
    //   77: aload_2
    //   78: invokestatic 192	c/t/m/g/co:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    //   84: astore_2
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_2
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	cz
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.cz
 * JD-Core Version:    0.7.0.1
 */