package com.tencent.beacon.core.a;

import android.util.SparseArray;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class d$a
  extends d
{
  ScheduledExecutorService c = null;
  SparseArray<d.c<?>> d = null;
  boolean e = false;
  
  public d$a()
  {
    this.c = Executors.newScheduledThreadPool(4, new d.b());
    this.d = new SparseArray();
  }
  
  public d$a(ScheduledExecutorService paramScheduledExecutorService)
  {
    if ((paramScheduledExecutorService != null) && (!paramScheduledExecutorService.isShutdown()))
    {
      this.c = paramScheduledExecutorService;
      this.d = new SparseArray();
      return;
    }
    throw new IllegalArgumentException("ScheduledExecutorService is not valiable!");
  }
  
  private Runnable b(Runnable paramRunnable)
  {
    return new c(this, paramRunnable);
  }
  
  public void a(int paramInt, Runnable paramRunnable, long paramLong1, long paramLong2)
  {
    try
    {
      if (this.e) {
        com.tencent.beacon.core.e.d.b("[task] was closed , should not post!", new Object[0]);
      }
      for (;;)
      {
        return;
        if (paramRunnable != null) {
          break;
        }
        com.tencent.beacon.core.e.d.b("[task] runner should not be null", new Object[0]);
      }
      paramRunnable = b(paramRunnable);
    }
    finally {}
    long l;
    if (paramLong1 > 0L)
    {
      l = paramLong1;
      label57:
      if (!d.a) {
        break label163;
      }
      if (paramLong2 <= 10000L) {
        break label156;
      }
      paramLong1 = paramLong2;
    }
    for (;;)
    {
      a(paramInt, true);
      paramRunnable = new d.c((FutureTask)this.c.scheduleAtFixedRate(paramRunnable, l, paramLong1, TimeUnit.MILLISECONDS), paramRunnable, l, paramLong1, TimeUnit.MILLISECONDS);
      com.tencent.beacon.core.e.d.a("[task] add a new future! taskId: %d , periodTime: %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong1) });
      this.d.put(paramInt, paramRunnable);
      break;
      l = 0L;
      break label57;
      label156:
      paramLong1 = 10000L;
      continue;
      label163:
      paramLong1 = paramLong2;
    }
  }
  
  /* Error */
  public void a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/tencent/beacon/core/a/d$a:e	Z
    //   6: ifeq +15 -> 21
    //   9: ldc 115
    //   11: iconst_0
    //   12: anewarray 61	java/lang/Object
    //   15: invokestatic 66	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 19	com/tencent/beacon/core/a/d$a:d	Landroid/util/SparseArray;
    //   25: iload_1
    //   26: invokevirtual 119	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   29: checkcast 79	com/tencent/beacon/core/a/d$c
    //   32: astore_3
    //   33: aload_3
    //   34: ifnull +25 -> 59
    //   37: aload_3
    //   38: invokevirtual 121	com/tencent/beacon/core/a/d$c:a	()Z
    //   41: ifne +18 -> 59
    //   44: ldc 123
    //   46: iconst_0
    //   47: anewarray 61	java/lang/Object
    //   50: invokestatic 109	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aload_3
    //   54: iload_2
    //   55: invokevirtual 126	com/tencent/beacon/core/a/d$c:a	(Z)Z
    //   58: pop
    //   59: aload_0
    //   60: getfield 19	com/tencent/beacon/core/a/d$a:d	Landroid/util/SparseArray;
    //   63: iload_1
    //   64: invokevirtual 130	android/util/SparseArray:remove	(I)V
    //   67: goto -49 -> 18
    //   70: astore_3
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_3
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	a
    //   0	75	1	paramInt	int
    //   0	75	2	paramBoolean	boolean
    //   32	22	3	localc	d.c
    //   70	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	70	finally
    //   21	33	70	finally
    //   37	59	70	finally
    //   59	67	70	finally
  }
  
  public void a(Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        if (this.e)
        {
          com.tencent.beacon.core.e.d.b("[task] was closed , should not post!", new Object[0]);
          return;
        }
        if (paramRunnable == null)
        {
          com.tencent.beacon.core.e.d.b("[task] runner should not be null", new Object[0]);
          continue;
        }
        paramRunnable = b(paramRunnable);
      }
      finally {}
      this.c.execute(paramRunnable);
    }
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    try
    {
      if (this.e) {
        com.tencent.beacon.core.e.d.b("[task] was closed , should not post!", new Object[0]);
      }
      for (;;)
      {
        return;
        if (paramRunnable != null) {
          break;
        }
        com.tencent.beacon.core.e.d.b("[task] runner should not be null", new Object[0]);
      }
      paramRunnable = b(paramRunnable);
    }
    finally {}
    if (paramLong > 0L) {}
    for (;;)
    {
      this.c.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
      break;
      paramLong = 0L;
    }
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        com.tencent.beacon.core.e.d.a("[task] Resumed all schedule task", new Object[0]);
        if (this.e)
        {
          com.tencent.beacon.core.e.d.b("task was close, should all stopped!", new Object[0]);
          return;
        }
        int i = 0;
        if (i < this.d.size())
        {
          Object localObject1 = this.d;
          localObject1 = (d.c)((SparseArray)localObject1).get(((SparseArray)localObject1).keyAt(i));
          if (localObject1 != null)
          {
            if (!d.c.a((d.c)localObject1).isCancelled()) {
              d.c.a((d.c)localObject1).cancel(true);
            }
            d.c.a((d.c)localObject1, (FutureTask)this.c.scheduleAtFixedRate(d.c.b((d.c)localObject1), d.c.c((d.c)localObject1), d.c.d((d.c)localObject1), d.c.e((d.c)localObject1)));
          }
        }
        else
        {
          com.tencent.beacon.core.e.d.a("[task] Resumed all schedule task", new Object[0]);
          continue;
        }
        i += 1;
      }
      finally {}
    }
  }
  
  public void b(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        com.tencent.beacon.core.e.d.a("[task] Start stop all schedule task", new Object[0]);
        if (this.e)
        {
          com.tencent.beacon.core.e.d.b("task was close, should all stopped!", new Object[0]);
          return;
        }
        int i = 0;
        if (i < this.d.size())
        {
          Object localObject1 = this.d;
          localObject1 = (d.c)((SparseArray)localObject1).get(((SparseArray)localObject1).keyAt(i));
          if ((localObject1 != null) && (!((d.c)localObject1).a())) {
            ((d.c)localObject1).a(paramBoolean);
          }
        }
        else
        {
          com.tencent.beacon.core.e.d.a("[task] All schedule tasks stop", new Object[0]);
          continue;
        }
        i += 1;
      }
      finally {}
    }
  }
  
  /* Error */
  public void c(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 181
    //   4: iconst_0
    //   5: anewarray 61	java/lang/Object
    //   8: invokestatic 109	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   11: aload_0
    //   12: getfield 21	com/tencent/beacon/core/a/d$a:e	Z
    //   15: ifeq +15 -> 30
    //   18: ldc 115
    //   20: iconst_0
    //   21: anewarray 61	java/lang/Object
    //   24: invokestatic 66	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: ldc 183
    //   32: iconst_0
    //   33: anewarray 61	java/lang/Object
    //   36: invokestatic 109	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: aload_0
    //   40: iconst_1
    //   41: putfield 21	com/tencent/beacon/core/a/d$a:e	Z
    //   44: aload_0
    //   45: getfield 17	com/tencent/beacon/core/a/d$a:c	Ljava/util/concurrent/ScheduledExecutorService;
    //   48: invokeinterface 186 1 0
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 17	com/tencent/beacon/core/a/d$a:c	Ljava/util/concurrent/ScheduledExecutorService;
    //   58: aload_0
    //   59: getfield 19	com/tencent/beacon/core/a/d$a:d	Landroid/util/SparseArray;
    //   62: invokevirtual 189	android/util/SparseArray:clear	()V
    //   65: aload_0
    //   66: aconst_null
    //   67: putfield 19	com/tencent/beacon/core/a/d$a:d	Landroid/util/SparseArray;
    //   70: ldc 191
    //   72: iconst_0
    //   73: anewarray 61	java/lang/Object
    //   76: invokestatic 109	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: goto -52 -> 27
    //   82: astore_2
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_2
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	a
    //   0	87	1	paramBoolean	boolean
    //   82	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	82	finally
    //   30	79	82	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.a.d.a
 * JD-Core Version:    0.7.0.1
 */