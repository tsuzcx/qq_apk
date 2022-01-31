package c.t.m.g;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;

public abstract class di
  extends dl
{
  public di.a a = null;
  private HandlerThread d = null;
  
  public final int a(@Nullable Looper paramLooper)
  {
    synchronized (this.c)
    {
      if (e()) {
        return -1;
      }
      this.b = true;
    }
    try
    {
      if (co.e())
      {
        c();
        co.a("startup()");
      }
      if (paramLooper == null)
      {
        this.d = new HandlerThread("thread_" + c());
        this.d.start();
      }
      for (this.a = new di.a(this, this.d.getLooper());; this.a = new di.a(this, paramLooper))
      {
        this.a.getLooper();
        int i = a();
        return i;
        paramLooper = finally;
        throw paramLooper;
      }
      return -1;
    }
    catch (Throwable paramLooper)
    {
      if (co.e())
      {
        c();
        co.a("startup error.", paramLooper);
      }
    }
  }
  
  public abstract void a(Message paramMessage);
  
  public final boolean a(int paramInt, long paramLong)
  {
    return co.a(this.a, paramInt, paramLong);
  }
  
  public final void d()
  {
    for (;;)
    {
      try
      {
        synchronized (this.c)
        {
          boolean bool = this.b;
          if (!bool) {
            return;
          }
          if (co.e())
          {
            c();
            co.a("shutdown()");
          }
          b();
        }
      }
      catch (Throwable localThrowable2)
      {
        if (!co.e()) {
          continue;
        }
        c();
        co.a("shutdown error.", localThrowable2);
        continue;
      }
      try
      {
        dr.a(this.d, this.a, 100L);
        this.d = null;
        this.a = null;
        this.b = false;
        return;
        localObject = finally;
        throw localObject;
      }
      catch (Throwable localThrowable1)
      {
        if (!co.e()) {
          continue;
        }
        c();
        co.a("shutdown thread error.", localThrowable1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.di
 * JD-Core Version:    0.7.0.1
 */