package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFutureTarget<R>
  implements FutureTarget<R>, RequestListener<R>, Runnable
{
  private static final RequestFutureTarget.Waiter a = new RequestFutureTarget.Waiter();
  private final Handler b;
  private final int c;
  private final int d;
  private final boolean e;
  private final RequestFutureTarget.Waiter f;
  @Nullable
  private R g;
  @Nullable
  private Request h;
  private boolean i;
  private boolean j;
  private boolean k;
  @Nullable
  private GlideException l;
  
  private R a(Long paramLong)
  {
    try
    {
      if ((this.e) && (!isDone())) {
        Util.b();
      }
      if (!this.i)
      {
        if (!this.k)
        {
          if (this.j)
          {
            paramLong = this.g;
            return paramLong;
          }
          if (paramLong == null)
          {
            this.f.a(this, 0L);
          }
          else if (paramLong.longValue() > 0L)
          {
            long l1 = System.currentTimeMillis();
            long l2 = paramLong.longValue() + l1;
            while ((!isDone()) && (l1 < l2))
            {
              this.f.a(this, l2 - l1);
              l1 = System.currentTimeMillis();
            }
          }
          if (!Thread.interrupted())
          {
            if (!this.k)
            {
              if (!this.i)
              {
                if (this.j)
                {
                  paramLong = this.g;
                  return paramLong;
                }
                throw new TimeoutException();
              }
              throw new CancellationException();
            }
            throw new ExecutionException(this.l);
          }
          throw new InterruptedException();
        }
        throw new ExecutionException(this.l);
      }
      throw new CancellationException();
    }
    finally {}
    for (;;)
    {
      throw paramLong;
    }
  }
  
  private void b()
  {
    this.b.post(this);
  }
  
  @Nullable
  public Request a()
  {
    return this.h;
  }
  
  public void a(@Nullable Drawable paramDrawable) {}
  
  public void a(@Nullable Request paramRequest)
  {
    this.h = paramRequest;
  }
  
  public void a(@NonNull SizeReadyCallback paramSizeReadyCallback)
  {
    paramSizeReadyCallback.a(this.c, this.d);
  }
  
  public void a(@NonNull R paramR, @Nullable Transition<? super R> paramTransition) {}
  
  public boolean a(@Nullable GlideException paramGlideException, Object paramObject, Target<R> paramTarget, boolean paramBoolean)
  {
    try
    {
      this.k = true;
      this.l = paramGlideException;
      this.f.a(this);
      return false;
    }
    finally
    {
      paramGlideException = finally;
      throw paramGlideException;
    }
  }
  
  public boolean a(R paramR, Object paramObject, Target<R> paramTarget, DataSource paramDataSource, boolean paramBoolean)
  {
    try
    {
      this.j = true;
      this.g = paramR;
      this.f.a(this);
      return false;
    }
    finally
    {
      paramR = finally;
      throw paramR;
    }
  }
  
  public void b(@Nullable Drawable paramDrawable) {}
  
  public void b(@NonNull SizeReadyCallback paramSizeReadyCallback) {}
  
  public void c() {}
  
  public void c(@Nullable Drawable paramDrawable) {}
  
  public boolean cancel(boolean paramBoolean)
  {
    try
    {
      boolean bool = isDone();
      if (bool) {
        return false;
      }
      this.i = true;
      this.f.a(this);
      if (paramBoolean) {
        b();
      }
      return true;
    }
    finally {}
  }
  
  public void d() {}
  
  public void e() {}
  
  public R get()
  {
    try
    {
      Object localObject = a(null);
      return localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      throw new AssertionError(localTimeoutException);
    }
  }
  
  public R get(long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    return a(Long.valueOf(paramTimeUnit.toMillis(paramLong)));
  }
  
  public boolean isCancelled()
  {
    try
    {
      boolean bool = this.i;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isDone()
  {
    try
    {
      if ((!this.i) && (!this.j))
      {
        bool = this.k;
        if (!bool)
        {
          bool = false;
          break label35;
        }
      }
      boolean bool = true;
      label35:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void run()
  {
    Request localRequest = this.h;
    if (localRequest != null)
    {
      localRequest.c();
      this.h = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.RequestFutureTarget
 * JD-Core Version:    0.7.0.1
 */