package com.tencent.beacon.core.strategy;

import android.content.Context;
import com.tencent.beacon.core.a.f;
import com.tencent.beacon.core.d.j;
import com.tencent.beacon.core.event.EventStrategyBean;

public class i
  implements Runnable
{
  protected static long a;
  Context b = null;
  public volatile boolean c = false;
  
  public i(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static long a()
  {
    try
    {
      long l = a;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(long paramLong)
  {
    try
    {
      a = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = f.a(paramContext);
      int i = Integer.parseInt(paramContext.a("querytimes", "0"));
      if (!com.tencent.beacon.core.e.b.a().equals(paramString)) {
        i = 0;
      }
      if (i <= c.g().j())
      {
        paramContext = paramContext.b();
        paramString = new StringBuilder().append(i + 1);
        paramContext.a("querytimes", "").a();
        return false;
      }
      bool = true;
      com.tencent.beacon.core.e.d.i("[strategy] set init times failed! ", new Object[0]);
    }
    catch (Exception paramContext)
    {
      try
      {
        com.tencent.beacon.core.e.d.e("[strategy] sdk init max times", new Object[0]);
        return true;
      }
      catch (Exception paramContext)
      {
        boolean bool;
        break label96;
      }
      paramContext = paramContext;
      bool = false;
    }
    label96:
    return bool;
  }
  
  private boolean b(Context paramContext, String paramString)
  {
    EventStrategyBean localEventStrategyBean = EventStrategyBean.getInstance();
    if (localEventStrategyBean.isStrategyQuerySuccessDaxMax())
    {
      paramContext = f.a(paramContext);
      long l1 = System.currentTimeMillis();
      long l2 = (l1 / 60000L + 480L) % 1440L;
      if ((l2 >= 0L) && (l2 <= 30L) && (l1 - paramContext.a("last_success_strategy_query_time", 0L) <= 90000000L)) {}
      do
      {
        return true;
        if (!com.tencent.beacon.core.e.b.a().equals(paramString)) {
          break;
        }
      } while (paramContext.a("today_success_strategy_query_times", 0) >= localEventStrategyBean.getStrategyQuerySuccessDayMaxTimes());
    }
    for (;;)
    {
      return false;
      paramContext.b().a("today_success_strategy_query_times", Integer.valueOf(0)).a();
    }
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/tencent/beacon/core/strategy/i:b	Landroid/content/Context;
    //   6: invokestatic 151	com/tencent/beacon/core/strategy/StrategyQueryModule:getInstance	(Landroid/content/Context;)Lcom/tencent/beacon/core/strategy/StrategyQueryModule;
    //   9: astore 4
    //   11: aload 4
    //   13: invokevirtual 154	com/tencent/beacon/core/strategy/StrategyQueryModule:getCurrentQueryStep	()I
    //   16: ifne +181 -> 197
    //   19: ldc 156
    //   21: iconst_0
    //   22: anewarray 4	java/lang/Object
    //   25: invokestatic 99	com/tencent/beacon/core/e/d:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload 4
    //   30: iconst_1
    //   31: invokevirtual 160	com/tencent/beacon/core/strategy/StrategyQueryModule:setCurrentQueryStep	(I)V
    //   34: aload_0
    //   35: getfield 19	com/tencent/beacon/core/strategy/i:b	Landroid/content/Context;
    //   38: invokestatic 166	com/tencent/beacon/core/info/a:f	(Landroid/content/Context;)Z
    //   41: istore_1
    //   42: ldc 168
    //   44: iconst_1
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: iload_1
    //   51: invokestatic 173	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   54: aastore
    //   55: invokestatic 99	com/tencent/beacon/core/e/d:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   58: iload_1
    //   59: ifeq +107 -> 166
    //   62: aload_0
    //   63: getfield 19	com/tencent/beacon/core/strategy/i:b	Landroid/content/Context;
    //   66: astore 5
    //   68: ldc 175
    //   70: iconst_1
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload 5
    //   78: aload 5
    //   80: invokestatic 180	com/tencent/beacon/core/info/g:b	(Landroid/content/Context;)Lcom/tencent/beacon/core/info/g;
    //   83: invokevirtual 183	com/tencent/beacon/core/info/b:a	()Ljava/lang/String;
    //   86: aconst_null
    //   87: ldc2_w 184
    //   90: ldc2_w 186
    //   93: invokestatic 192	com/tencent/beacon/core/a/a/b:a	(Landroid/content/Context;Ljava/lang/String;[IJJ)I
    //   96: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: aastore
    //   100: invokestatic 99	com/tencent/beacon/core/e/d:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload 4
    //   105: monitorenter
    //   106: aload 4
    //   108: iconst_1
    //   109: invokevirtual 196	com/tencent/beacon/core/strategy/StrategyQueryModule:setAppFirstRun	(Z)V
    //   112: aload 4
    //   114: monitorexit
    //   115: getstatic 202	com/tencent/beacon/event/UserAction:beaconModules	Ljava/util/List;
    //   118: invokeinterface 208 1 0
    //   123: astore 5
    //   125: aload 5
    //   127: invokeinterface 213 1 0
    //   132: ifeq +65 -> 197
    //   135: aload 5
    //   137: invokeinterface 217 1 0
    //   142: checkcast 219	com/tencent/beacon/core/c
    //   145: invokevirtual 222	com/tencent/beacon/core/c:onAppFirstRun	()V
    //   148: goto -23 -> 125
    //   151: astore 4
    //   153: aload_0
    //   154: monitorexit
    //   155: aload 4
    //   157: athrow
    //   158: astore 5
    //   160: aload 4
    //   162: monitorexit
    //   163: aload 5
    //   165: athrow
    //   166: invokestatic 224	com/tencent/beacon/core/strategy/i:a	()J
    //   169: lstore_2
    //   170: lload_2
    //   171: lconst_0
    //   172: lcmp
    //   173: ifle +24 -> 197
    //   176: ldc 226
    //   178: iconst_1
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: lload_2
    //   185: invokestatic 231	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   188: aastore
    //   189: invokestatic 99	com/tencent/beacon/core/e/d:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: aload_0
    //   193: lload_2
    //   194: invokevirtual 233	com/tencent/beacon/core/strategy/i:b	(J)V
    //   197: ldc 235
    //   199: iconst_0
    //   200: anewarray 4	java/lang/Object
    //   203: invokestatic 99	com/tencent/beacon/core/e/d:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: aload 4
    //   208: iconst_2
    //   209: invokevirtual 160	com/tencent/beacon/core/strategy/StrategyQueryModule:setCurrentQueryStep	(I)V
    //   212: aload 4
    //   214: aload 4
    //   216: invokevirtual 238	com/tencent/beacon/core/strategy/StrategyQueryModule:getCommonQueryTime	()I
    //   219: iconst_1
    //   220: iadd
    //   221: invokevirtual 241	com/tencent/beacon/core/strategy/StrategyQueryModule:setCommonQueryTime	(I)V
    //   224: getstatic 202	com/tencent/beacon/event/UserAction:beaconModules	Ljava/util/List;
    //   227: invokeinterface 208 1 0
    //   232: astore 5
    //   234: aload 5
    //   236: invokeinterface 213 1 0
    //   241: ifeq +19 -> 260
    //   244: aload 5
    //   246: invokeinterface 217 1 0
    //   251: checkcast 219	com/tencent/beacon/core/c
    //   254: invokevirtual 244	com/tencent/beacon/core/c:onStrategyQueryStarted	()V
    //   257: goto -23 -> 234
    //   260: invokestatic 64	com/tencent/beacon/core/strategy/c:g	()Lcom/tencent/beacon/core/strategy/c;
    //   263: invokevirtual 247	com/tencent/beacon/core/strategy/c:k	()Z
    //   266: ifne +7 -> 273
    //   269: aload_0
    //   270: invokevirtual 249	com/tencent/beacon/core/strategy/i:c	()V
    //   273: ldc 251
    //   275: iconst_0
    //   276: anewarray 4	java/lang/Object
    //   279: invokestatic 254	com/tencent/beacon/core/e/d:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: aload 4
    //   284: iconst_3
    //   285: invokevirtual 160	com/tencent/beacon/core/strategy/StrategyQueryModule:setCurrentQueryStep	(I)V
    //   288: getstatic 202	com/tencent/beacon/event/UserAction:beaconModules	Ljava/util/List;
    //   291: invokeinterface 208 1 0
    //   296: astore 4
    //   298: aload 4
    //   300: invokeinterface 213 1 0
    //   305: ifeq +19 -> 324
    //   308: aload 4
    //   310: invokeinterface 217 1 0
    //   315: checkcast 219	com/tencent/beacon/core/c
    //   318: invokevirtual 257	com/tencent/beacon/core/c:onStrategyQueryFinished	()V
    //   321: goto -23 -> 298
    //   324: aload_0
    //   325: invokevirtual 259	com/tencent/beacon/core/strategy/i:b	()J
    //   328: pop2
    //   329: aload_0
    //   330: monitorexit
    //   331: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	i
    //   41	18	1	bool	boolean
    //   169	25	2	l	long
    //   9	104	4	localStrategyQueryModule	StrategyQueryModule
    //   151	132	4	localObject1	Object
    //   296	13	4	localIterator1	java.util.Iterator
    //   66	70	5	localObject2	Object
    //   158	6	5	localObject3	Object
    //   232	13	5	localIterator2	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   2	58	151	finally
    //   62	106	151	finally
    //   115	125	151	finally
    //   125	148	151	finally
    //   163	166	151	finally
    //   166	170	151	finally
    //   176	197	151	finally
    //   197	234	151	finally
    //   234	257	151	finally
    //   260	273	151	finally
    //   273	298	151	finally
    //   298	321	151	finally
    //   324	329	151	finally
    //   106	115	158	finally
    //   160	163	158	finally
  }
  
  public long b()
  {
    c localc = StrategyQueryModule.getInstance(this.b).getStrategy();
    if (localc == null)
    {
      com.tencent.beacon.core.e.d.b("[strategy] currentStrategy is null.", new Object[0]);
      return -1L;
    }
    long l = localc.i() * 60000L;
    if (l > 0L)
    {
      com.tencent.beacon.core.a.d.a().a(this, l);
      com.tencent.beacon.core.e.d.h("[strategy] next time: %d", new Object[] { Long.valueOf(l) });
      StrategyQueryModule.getInstance(this.b).setCurrentQueryStep(4);
      return l;
    }
    com.tencent.beacon.core.e.d.h("[strategy] stop loop query", new Object[0]);
    return -1L;
  }
  
  protected void b(long paramLong)
  {
    try
    {
      Thread.sleep(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      com.tencent.beacon.core.e.d.a(localInterruptedException);
    }
  }
  
  public void c()
  {
    j localj = StrategyQueryModule.getMyUpload();
    int i = 0;
    for (;;)
    {
      if (localj == null)
      {
        i += 1;
        if (i < 5) {
          try
          {
            Thread.sleep(200L);
            localj = StrategyQueryModule.getMyUpload();
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              com.tencent.beacon.core.e.d.a(localInterruptedException);
            }
          }
        }
      }
    }
    if (localInterruptedException != null)
    {
      Object localObject = f.a(this.b);
      String str = ((f)localObject).a("initsdkdate", "");
      if (!com.tencent.beacon.core.e.b.a().equals(str)) {
        ((f)localObject).b().a("initsdkdate", com.tencent.beacon.core.e.b.a()).a();
      }
      boolean bool1 = a(this.b, str);
      boolean bool2 = b(this.b, str);
      if ((bool1) || (bool2))
      {
        com.tencent.beacon.core.e.d.i("[strategy] query times or query success times arrive max, return!", new Object[0]);
        StrategyQueryModule.getInstance(this.b).setAtLeastAComQuerySuccess(true);
        return;
      }
      localObject = com.tencent.beacon.core.info.g.b(this.b).a();
      com.tencent.beacon.core.e.d.a("[strategy] strategy UploadData appKey: " + (String)localObject, new Object[0]);
      localInterruptedException.a(new l(this.b, 0, 100, (String)localObject));
      return;
    }
    com.tencent.beacon.core.e.d.h("[strategy] uphandler is null", new Object[0]);
  }
  
  void d()
  {
    try
    {
      k localk = d.b(this.b, 101);
      if ((localk != null) && (localk.b == 101) && (localk.c != null))
      {
        com.tencent.beacon.core.d.g localg = StrategyQueryModule.getInstance(this.b).getStrategyHandler();
        if (localg != null)
        {
          localg.a(101, localk.c, false);
          com.tencent.beacon.core.e.d.e("common strategy setted by local db", new Object[0]);
        }
        return;
      }
      com.tencent.beacon.core.e.d.b("local strategy data == null", new Object[0]);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.core.e.d.a(localThrowable);
    }
  }
  
  public void run()
  {
    this.c = true;
    e();
    this.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.strategy.i
 * JD-Core Version:    0.7.0.1
 */