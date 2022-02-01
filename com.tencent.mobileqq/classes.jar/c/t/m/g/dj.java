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
      try
      {
        if (co.e())
        {
          c();
          co.a("startup()");
        }
        if (paramLooper == null)
        {
          paramLooper = new StringBuilder("th_");
          paramLooper.append(c());
          this.c = new HandlerThread(paramLooper.toString());
          this.c.start();
          this.d = new dj.a(this, this.c.getLooper());
        }
        else
        {
          this.d = new dj.a(this, paramLooper);
        }
        this.d.getLooper();
        int i = a();
        return i;
      }
      catch (Throwable paramLooper)
      {
        if (co.e())
        {
          c();
          co.a("startup error.", paramLooper);
        }
        return -1;
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
        try
        {
          dt.a(this.c, this.d, 100L);
          this.c = null;
          this.d = null;
        }
        catch (Throwable localThrowable1)
        {
          if (co.e())
          {
            c();
            co.a("shutdown thread error.", localThrowable1);
          }
        }
        this.a = false;
      }
    }
    catch (Throwable localThrowable2)
    {
      if (co.e())
      {
        c();
        co.a("shutdown error.", localThrowable2);
      }
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.dj
 * JD-Core Version:    0.7.0.1
 */