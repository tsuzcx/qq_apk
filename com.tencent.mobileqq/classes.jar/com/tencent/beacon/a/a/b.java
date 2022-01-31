package com.tencent.beacon.a.a;

import android.util.SparseArray;
import com.tencent.beacon.a.g.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class b
{
  public static boolean a = true;
  private static b b;
  
  public static b a()
  {
    try
    {
      if (b == null) {
        b = new a();
      }
      b localb = b;
      return localb;
    }
    finally {}
  }
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, Runnable paramRunnable, long paramLong1, long paramLong2);
  
  public abstract void a(Runnable paramRunnable);
  
  public abstract void a(Runnable paramRunnable, long paramLong);
  
  static final class a
    extends b
  {
    private ScheduledExecutorService b = null;
    private SparseArray<ScheduledFuture<?>> c = null;
    
    public final void a(int paramInt)
    {
      try
      {
        ScheduledFuture localScheduledFuture = (ScheduledFuture)this.c.get(paramInt);
        if ((localScheduledFuture != null) && (!localScheduledFuture.isCancelled())) {
          localScheduledFuture.cancel(true);
        }
        this.c.remove(paramInt);
        return;
      }
      finally {}
    }
    
    public final void a(int paramInt, Runnable paramRunnable, long paramLong1, long paramLong2)
    {
      long l = 0L;
      if (paramRunnable == null) {}
      try
      {
        a.d("[task] runner should not be null", new Object[0]);
        return;
      }
      finally {}
      if (paramLong1 > 0L) {
        l = paramLong1;
      }
      if (a) {
        if (paramLong2 > 10000L) {
          break label105;
        }
      }
      for (;;)
      {
        a(paramInt);
        paramRunnable = this.b.scheduleAtFixedRate(paramRunnable, l, paramLong1, TimeUnit.MILLISECONDS);
        if (paramRunnable == null) {
          break;
        }
        this.c.put(paramInt, paramRunnable);
        break;
        paramLong2 = 10000L;
        break label105;
        paramLong1 = paramLong2;
        continue;
        label105:
        paramLong1 = paramLong2;
      }
    }
    
    public final void a(Runnable paramRunnable)
    {
      if (paramRunnable == null) {}
      for (;;)
      {
        try
        {
          a.d("[task] runner should not be null", new Object[0]);
          return;
        }
        finally {}
        this.b.execute(paramRunnable);
      }
    }
    
    public final void a(Runnable paramRunnable, long paramLong)
    {
      if (paramRunnable == null) {}
      try
      {
        a.d("[task] runner should not be null", new Object[0]);
        return;
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
  
  public final class b
    implements ThreadFactory
  {
    private final AtomicInteger a = new AtomicInteger(1);
    
    public final Thread newThread(Runnable paramRunnable)
    {
      try
      {
        paramRunnable = new Thread(paramRunnable, "beacon-thread-" + this.a.getAndIncrement());
        return paramRunnable;
      }
      catch (Exception paramRunnable)
      {
        a.a(paramRunnable);
        return null;
      }
      catch (OutOfMemoryError paramRunnable)
      {
        for (;;)
        {
          a.d("[task] memory not enough, create thread failed.", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.a.b
 * JD-Core Version:    0.7.0.1
 */