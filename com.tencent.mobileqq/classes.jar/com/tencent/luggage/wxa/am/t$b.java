package com.tencent.luggage.wxa.am;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.ao.v;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

@SuppressLint({"HandlerLeak"})
final class t$b<T extends t.c>
  extends Handler
  implements Runnable
{
  public final int a;
  private final T c;
  private final t.a<T> d;
  private final long e;
  private IOException f;
  private int g;
  private volatile Thread h;
  private volatile boolean i;
  
  public t$b(Looper paramLooper, T paramT, t.a<T> parama, int paramInt, long paramLong)
  {
    super(paramT);
    this.c = parama;
    this.d = paramInt;
    this.a = paramLong;
    Object localObject;
    this.e = localObject;
  }
  
  private void a()
  {
    this.f = null;
    t.b(this.b).execute(t.a(this.b));
  }
  
  private void b()
  {
    t.a(this.b, null);
  }
  
  private long c()
  {
    return Math.min((this.g - 1) * 1000, 5000);
  }
  
  public void a(int paramInt)
  {
    IOException localIOException = this.f;
    if (localIOException != null)
    {
      if (this.g <= paramInt) {
        return;
      }
      throw localIOException;
    }
  }
  
  public void a(long paramLong)
  {
    boolean bool;
    if (t.a(this.b) == null) {
      bool = true;
    } else {
      bool = false;
    }
    a.b(bool);
    t.a(this.b, this);
    if (paramLong > 0L)
    {
      sendEmptyMessageDelayed(0, paramLong);
      return;
    }
    a();
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    this.f = null;
    if (hasMessages(0))
    {
      removeMessages(0);
      if (!paramBoolean) {
        sendEmptyMessage(1);
      }
    }
    else
    {
      this.c.a();
      if (this.h != null) {
        this.h.interrupt();
      }
    }
    if (paramBoolean)
    {
      b();
      long l = SystemClock.elapsedRealtime();
      this.d.a(this.c, l, l - this.e, true);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.i) {
      return;
    }
    if (paramMessage.what == 0)
    {
      a();
      return;
    }
    if (paramMessage.what != 4)
    {
      b();
      long l1 = SystemClock.elapsedRealtime();
      long l2 = l1 - this.e;
      if (this.c.b())
      {
        this.d.a(this.c, l1, l2, false);
        return;
      }
      int k = paramMessage.what;
      int j = 1;
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3) {
            return;
          }
          this.f = ((IOException)paramMessage.obj);
          k = this.d.a(this.c, l1, l2, this.f);
          if (k == 3)
          {
            t.a(this.b, this.f);
            return;
          }
          if (k != 2)
          {
            if (k != 1) {
              j = 1 + this.g;
            }
            this.g = j;
            a(c());
          }
        }
        else
        {
          this.d.a(this.c, l1, l2);
        }
      }
      else {
        this.d.a(this.c, l1, l2, false);
      }
      return;
    }
    throw ((Error)paramMessage.obj);
  }
  
  public void run()
  {
    try
    {
      this.h = Thread.currentThread();
      if (!this.c.b())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("load:");
        localStringBuilder.append(this.c.getClass().getSimpleName());
        v.a(localStringBuilder.toString());
      }
      try
      {
        this.c.c();
        v.a();
      }
      finally
      {
        v.a();
      }
      sendEmptyMessage(2);
      return;
    }
    catch (Error localError)
    {
      Log.e("LoadTask", "Unexpected error loading stream", localError);
      if (!this.i) {
        obtainMessage(4, localError).sendToTarget();
      }
      throw localError;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Log.e("LoadTask", "OutOfMemory error loading stream", localOutOfMemoryError);
      if (!this.i)
      {
        obtainMessage(3, new t.f(localOutOfMemoryError)).sendToTarget();
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e("LoadTask", "Unexpected exception loading stream", localException);
      if (!this.i)
      {
        obtainMessage(3, new t.f(localException)).sendToTarget();
        return;
        a.b(this.c.b());
        if (!this.i)
        {
          sendEmptyMessage(2);
          return;
        }
      }
    }
    catch (IOException localIOException)
    {
      if (!this.i) {
        obtainMessage(3, localIOException).sendToTarget();
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      label187:
      break label187;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.am.t.b
 * JD-Core Version:    0.7.0.1
 */