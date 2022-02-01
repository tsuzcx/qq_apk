package com.tencent.beacon.a.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.beacon.base.util.c;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class f
  extends a
{
  private static final int b = Runtime.getRuntime().availableProcessors();
  private static final int c = Math.max(2, Math.min(b - 1, 3));
  private static final AtomicInteger d = new AtomicInteger(0);
  private final ScheduledExecutorService e;
  private final SparseArray<f.a> f;
  private final SparseArray<Handler> g;
  private final g h = new g();
  private boolean i = false;
  
  f()
  {
    this(null);
  }
  
  f(ScheduledExecutorService paramScheduledExecutorService)
  {
    ScheduledExecutorService localScheduledExecutorService = paramScheduledExecutorService;
    if (paramScheduledExecutorService == null) {
      localScheduledExecutorService = Executors.newScheduledThreadPool(c, this.h);
    }
    this.e = localScheduledExecutorService;
    this.f = new SparseArray();
    this.g = new SparseArray();
  }
  
  private Runnable b(Runnable paramRunnable)
  {
    return new e(this, paramRunnable);
  }
  
  private boolean d()
  {
    if (this.i)
    {
      c.b("[task] was closed , should all stopped!", new Object[0]);
      return true;
    }
    return false;
  }
  
  public Handler a(int paramInt)
  {
    try
    {
      Handler localHandler = (Handler)this.g.get(paramInt);
      Object localObject1 = localHandler;
      if (localHandler == null)
      {
        localObject1 = new HandlerThread(this.h.a());
        ((HandlerThread)localObject1).start();
        localObject1 = new Handler(((HandlerThread)localObject1).getLooper());
      }
      this.g.put(paramInt, localObject1);
      return localObject1;
    }
    finally {}
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, @NonNull Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        boolean bool = d();
        if (bool) {
          return;
        }
        f.a locala = (f.a)this.f.get(paramInt);
        if (locala != null)
        {
          bool = locala.a();
          if (!bool) {
            return;
          }
        }
        paramRunnable = b(paramRunnable);
        if (paramLong1 <= 0L) {
          break label144;
        }
      }
      finally {}
      paramRunnable = new f.a(this.e.scheduleAtFixedRate(paramRunnable, paramLong1, paramLong2, TimeUnit.MILLISECONDS), paramRunnable, paramLong1, paramLong2, TimeUnit.MILLISECONDS);
      c.a("[task] add a new polling task! taskId: %d , periodTime: %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong2) });
      this.f.put(paramInt, paramRunnable);
      return;
      label144:
      paramLong1 = 0L;
      if (paramLong2 < 500L) {
        paramLong2 = 500L;
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    f.a locala = (f.a)this.f.get(paramInt);
    if ((locala != null) && (!locala.a()))
    {
      c.a("[task] cancel a old pollingTaskWrapper!", new Object[0]);
      locala.a(paramBoolean);
    }
  }
  
  public void a(long paramLong, @NonNull Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        boolean bool = d();
        if (bool) {
          return;
        }
        paramRunnable = b(paramRunnable);
        if (paramLong > 0L)
        {
          this.e.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
          return;
        }
      }
      finally {}
      paramLong = 0L;
    }
  }
  
  public void a(@NonNull Runnable paramRunnable)
  {
    try
    {
      boolean bool = d();
      if (bool) {
        return;
      }
      paramRunnable = b(paramRunnable);
      this.e.execute(paramRunnable);
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      boolean bool = d();
      if (bool) {
        return;
      }
      int j = 0;
      while (j < this.f.size())
      {
        a(this.f.keyAt(j), paramBoolean);
        j += 1;
      }
      c.a("[task] All schedule tasks stop", new Object[0]);
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void b()
  {
    try
    {
      c.a("[task] Resumed all schedule task", new Object[0]);
      boolean bool = d();
      if (bool) {
        return;
      }
      int j = 0;
      while (j < this.f.size())
      {
        b(this.f.keyAt(j));
        j += 1;
      }
      c.a("[task] Resumed all schedule task", new Object[0]);
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      f.a locala = (f.a)this.f.get(paramInt);
      if (locala != null)
      {
        boolean bool = locala.a();
        if (!bool) {
          return;
        }
        f.a.a(locala, this.e.scheduleAtFixedRate(f.a.a(locala), f.a.b(locala), f.a.c(locala), f.a.d(locala)));
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.a.b.f
 * JD-Core Version:    0.7.0.1
 */