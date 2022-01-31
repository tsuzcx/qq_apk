package com.tencent.beacon.core.a;

import android.util.SparseArray;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class b$a
  extends b
{
  private ScheduledExecutorService b = null;
  private SparseArray<ScheduledFuture<?>> c = null;
  private boolean d = false;
  
  public b$a()
  {
    this.b = Executors.newScheduledThreadPool(3, new b.b());
    this.c = new SparseArray();
  }
  
  public b$a(ScheduledExecutorService paramScheduledExecutorService)
  {
    if ((paramScheduledExecutorService == null) || (paramScheduledExecutorService.isShutdown())) {
      throw new IllegalArgumentException("ScheduledExecutorService is not valiable!");
    }
    this.b = paramScheduledExecutorService;
    this.c = new SparseArray();
  }
  
  private static Runnable b(Runnable paramRunnable)
  {
    return new b.a.1(paramRunnable);
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 57
    //   4: iconst_0
    //   5: anewarray 59	java/lang/Object
    //   8: invokestatic 64	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   11: aload_0
    //   12: getfield 21	com/tencent/beacon/core/a/b$a:d	Z
    //   15: ifeq +15 -> 30
    //   18: ldc 66
    //   20: iconst_0
    //   21: anewarray 59	java/lang/Object
    //   24: invokestatic 68	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: ldc 70
    //   32: iconst_0
    //   33: anewarray 59	java/lang/Object
    //   36: invokestatic 64	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: aload_0
    //   40: iconst_1
    //   41: putfield 21	com/tencent/beacon/core/a/b$a:d	Z
    //   44: aload_0
    //   45: getfield 17	com/tencent/beacon/core/a/b$a:b	Ljava/util/concurrent/ScheduledExecutorService;
    //   48: invokeinterface 73 1 0
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 17	com/tencent/beacon/core/a/b$a:b	Ljava/util/concurrent/ScheduledExecutorService;
    //   58: aload_0
    //   59: getfield 19	com/tencent/beacon/core/a/b$a:c	Landroid/util/SparseArray;
    //   62: invokevirtual 76	android/util/SparseArray:clear	()V
    //   65: aload_0
    //   66: aconst_null
    //   67: putfield 19	com/tencent/beacon/core/a/b$a:c	Landroid/util/SparseArray;
    //   70: ldc 78
    //   72: iconst_0
    //   73: anewarray 59	java/lang/Object
    //   76: invokestatic 64	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: goto -52 -> 27
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	a
    //   82	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	82	finally
    //   30	79	82	finally
  }
  
  public final void a(int paramInt, Runnable paramRunnable, long paramLong1, long paramLong2)
  {
    long l = 0L;
    try
    {
      if (this.d) {
        com.tencent.beacon.core.d.b.d("[task] was closed , should not post!", new Object[0]);
      }
      for (;;)
      {
        return;
        if (paramRunnable != null) {
          break;
        }
        com.tencent.beacon.core.d.b.d("[task] runner should not be null", new Object[0]);
      }
      paramRunnable = b(paramRunnable);
    }
    finally {}
    if (paramLong1 > 0L) {
      l = paramLong1;
    }
    if (a) {
      if (paramLong2 > 10000L) {
        break label153;
      }
    }
    for (;;)
    {
      a(paramInt, true);
      paramRunnable = this.b.scheduleAtFixedRate(paramRunnable, l, paramLong1, TimeUnit.MILLISECONDS);
      if (paramRunnable == null) {
        break;
      }
      com.tencent.beacon.core.d.b.b("[task] add a new future! taskId: %d , periodTime: %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
      this.c.put(paramInt, paramRunnable);
      break;
      paramLong2 = 10000L;
      break label153;
      paramLong1 = paramLong2;
      continue;
      label153:
      paramLong1 = paramLong2;
    }
  }
  
  /* Error */
  public final void a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/tencent/beacon/core/a/b$a:d	Z
    //   6: ifeq +15 -> 21
    //   9: ldc 66
    //   11: iconst_0
    //   12: anewarray 59	java/lang/Object
    //   15: invokestatic 68	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 19	com/tencent/beacon/core/a/b$a:c	Landroid/util/SparseArray;
    //   25: iload_1
    //   26: invokevirtual 123	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   29: checkcast 125	java/util/concurrent/ScheduledFuture
    //   32: astore_3
    //   33: aload_3
    //   34: ifnull +29 -> 63
    //   37: aload_3
    //   38: invokeinterface 128 1 0
    //   43: ifne +20 -> 63
    //   46: ldc 130
    //   48: iconst_0
    //   49: anewarray 59	java/lang/Object
    //   52: invokestatic 64	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   55: aload_3
    //   56: iload_2
    //   57: invokeinterface 134 2 0
    //   62: pop
    //   63: aload_0
    //   64: getfield 19	com/tencent/beacon/core/a/b$a:c	Landroid/util/SparseArray;
    //   67: iload_1
    //   68: invokevirtual 138	android/util/SparseArray:remove	(I)V
    //   71: goto -53 -> 18
    //   74: astore_3
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_3
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	a
    //   0	79	1	paramInt	int
    //   0	79	2	paramBoolean	boolean
    //   32	24	3	localScheduledFuture	ScheduledFuture
    //   74	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	74	finally
    //   21	33	74	finally
    //   37	63	74	finally
    //   63	71	74	finally
  }
  
  public final void a(Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        if (this.d)
        {
          com.tencent.beacon.core.d.b.d("[task] was closed , should not post!", new Object[0]);
          return;
        }
        if (paramRunnable == null)
        {
          com.tencent.beacon.core.d.b.d("[task] runner should not be null", new Object[0]);
          continue;
        }
        paramRunnable = b(paramRunnable);
      }
      finally {}
      this.b.execute(paramRunnable);
    }
  }
  
  public final void a(Runnable paramRunnable, long paramLong)
  {
    try
    {
      if (this.d) {
        com.tencent.beacon.core.d.b.d("[task] was closed , should not post!", new Object[0]);
      }
      for (;;)
      {
        return;
        if (paramRunnable != null) {
          break;
        }
        com.tencent.beacon.core.d.b.d("[task] runner should not be null", new Object[0]);
      }
      paramRunnable = b(paramRunnable);
    }
    finally {}
    if (paramLong > 0L) {}
    for (;;)
    {
      this.b.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
      break;
      paramLong = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.a.b.a
 * JD-Core Version:    0.7.0.1
 */