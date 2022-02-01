package com.bumptech.glide.load.engine.executor;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class GlideExecutor
  implements ExecutorService
{
  private static final long a = TimeUnit.SECONDS.toMillis(10L);
  private static volatile int b;
  private final ExecutorService c;
  
  @VisibleForTesting
  GlideExecutor(ExecutorService paramExecutorService)
  {
    this.c = paramExecutorService;
  }
  
  public static GlideExecutor a()
  {
    return a(1, "disk-cache", GlideExecutor.UncaughtThrowableStrategy.d);
  }
  
  public static GlideExecutor a(int paramInt, GlideExecutor.UncaughtThrowableStrategy paramUncaughtThrowableStrategy)
  {
    return new GlideExecutor(new ThreadPoolExecutor(0, paramInt, a, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new GlideExecutor.DefaultThreadFactory("animation", paramUncaughtThrowableStrategy, true)));
  }
  
  public static GlideExecutor a(int paramInt, String paramString, GlideExecutor.UncaughtThrowableStrategy paramUncaughtThrowableStrategy)
  {
    return new GlideExecutor(new ThreadPoolExecutor(paramInt, paramInt, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new GlideExecutor.DefaultThreadFactory(paramString, paramUncaughtThrowableStrategy, true)));
  }
  
  public static GlideExecutor b()
  {
    return b(e(), "source", GlideExecutor.UncaughtThrowableStrategy.d);
  }
  
  public static GlideExecutor b(int paramInt, String paramString, GlideExecutor.UncaughtThrowableStrategy paramUncaughtThrowableStrategy)
  {
    return new GlideExecutor(new ThreadPoolExecutor(paramInt, paramInt, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new GlideExecutor.DefaultThreadFactory(paramString, paramUncaughtThrowableStrategy, false)));
  }
  
  public static GlideExecutor c()
  {
    return new GlideExecutor(new ThreadPoolExecutor(0, 2147483647, a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new GlideExecutor.DefaultThreadFactory("source-unlimited", GlideExecutor.UncaughtThrowableStrategy.d, false)));
  }
  
  public static GlideExecutor d()
  {
    int i;
    if (e() >= 4) {
      i = 2;
    } else {
      i = 1;
    }
    return a(i, GlideExecutor.UncaughtThrowableStrategy.d);
  }
  
  public static int e()
  {
    if (b == 0) {
      b = Math.min(4, RuntimeCompat.a());
    }
    return b;
  }
  
  public boolean awaitTermination(long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    return this.c.awaitTermination(paramLong, paramTimeUnit);
  }
  
  public void execute(@NonNull Runnable paramRunnable)
  {
    this.c.execute(paramRunnable);
  }
  
  @NonNull
  public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> paramCollection)
  {
    return this.c.invokeAll(paramCollection);
  }
  
  @NonNull
  public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> paramCollection, long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    return this.c.invokeAll(paramCollection, paramLong, paramTimeUnit);
  }
  
  @NonNull
  public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> paramCollection)
  {
    return this.c.invokeAny(paramCollection);
  }
  
  public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> paramCollection, long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    return this.c.invokeAny(paramCollection, paramLong, paramTimeUnit);
  }
  
  public boolean isShutdown()
  {
    return this.c.isShutdown();
  }
  
  public boolean isTerminated()
  {
    return this.c.isTerminated();
  }
  
  public void shutdown()
  {
    this.c.shutdown();
  }
  
  @NonNull
  public List<Runnable> shutdownNow()
  {
    return this.c.shutdownNow();
  }
  
  @NonNull
  public Future<?> submit(@NonNull Runnable paramRunnable)
  {
    return this.c.submit(paramRunnable);
  }
  
  @NonNull
  public <T> Future<T> submit(@NonNull Runnable paramRunnable, T paramT)
  {
    return this.c.submit(paramRunnable, paramT);
  }
  
  public <T> Future<T> submit(@NonNull Callable<T> paramCallable)
  {
    return this.c.submit(paramCallable);
  }
  
  public String toString()
  {
    return this.c.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.executor.GlideExecutor
 * JD-Core Version:    0.7.0.1
 */