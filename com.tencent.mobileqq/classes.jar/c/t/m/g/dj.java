package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;

public abstract class dj
  extends dm
{
  private volatile HandlerThread c = null;
  private volatile dj.a d = null;
  
  public final int a(@Nullable Looper paramLooper)
  {
    synchronized (this.b)
    {
      if (f()) {
        return -1;
      }
      this.a = true;
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
        this.c = new HandlerThread("th_" + c());
        this.c.start();
      }
      for (this.d = new dj.a(this, this.c.getLooper());; this.d = new dj.a(this, paramLooper))
      {
        this.d.getLooper();
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
    synchronized (this.b)
    {
      boolean bool = co.a(this.d, paramInt, paramLong);
      return bool;
    }
  }
  
  public final boolean b(Message paramMessage)
  {
    synchronized (this.b)
    {
      boolean bool = co.a(this.d, paramMessage, 0L);
      return bool;
    }
  }
  
  public final void d()
  {
    for (;;)
    {
      try
      {
        synchronized (this.b)
        {
          boolean bool = this.a;
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
        dt.a(this.c, this.d, 100L);
        this.c = null;
        this.d = null;
        this.a = false;
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
  
  public final Handler e()
  {
    synchronized (this.b)
    {
      dj.a locala = this.d;
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.dj
 * JD-Core Version:    0.7.0.1
 */