package com.tencent.luggage.wxa.sk;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.rz.c.e;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import com.tencent.luggage.wxa.sl.b;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
  implements com.tencent.luggage.wxa.sd.a
{
  private final Handler.Callback a;
  private boolean b = true;
  private AtomicBoolean c = new AtomicBoolean();
  private final String d;
  private final a e;
  private final Handler f = new c.1(this, Looper.getMainLooper());
  private b g = new b(Message.class, "recycleUnchecked", new Class[0]);
  
  public c(@NonNull a parama, Handler.Callback paramCallback)
  {
    parama.getClass();
    this.e = parama;
    this.d = parama.e();
    this.a = paramCallback;
    try
    {
      com.tencent.luggage.wxa.sl.c.a(Handler.class, "mLooper", this.f, null);
      return;
    }
    catch (Exception parama)
    {
      throw new RuntimeException(parama);
    }
  }
  
  private void f(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    try
    {
      this.g.a(paramMessage, new Object[0]);
      return;
    }
    catch (Exception paramMessage)
    {
      throw new RuntimeException(paramMessage);
    }
  }
  
  public Looper a()
  {
    return null;
  }
  
  public Message a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    return this.f.obtainMessage(paramInt1, paramInt2, paramInt3, paramObject);
  }
  
  public void a(Message paramMessage)
  {
    if (paramMessage.getCallback() != null)
    {
      paramMessage.getCallback().run();
      return;
    }
    Handler.Callback localCallback = this.a;
    if ((localCallback != null) && (localCallback.handleMessage(paramMessage))) {
      return;
    }
    c(paramMessage);
  }
  
  public void a(Object paramObject)
  {
    this.e.d().a(new c.4(this, paramObject));
  }
  
  public boolean a(int paramInt)
  {
    return this.f.sendEmptyMessage(paramInt);
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return this.f.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  public boolean a(Message paramMessage, long paramLong)
  {
    return this.f.sendMessageDelayed(paramMessage, paramLong);
  }
  
  public boolean a(Runnable paramRunnable)
  {
    return this.f.post(paramRunnable);
  }
  
  public String b()
  {
    return this.d;
  }
  
  public void b(int paramInt)
  {
    this.e.d().a(new c.3(this, paramInt));
  }
  
  public void b(Runnable paramRunnable)
  {
    this.e.d().a(new c.2(this, paramRunnable));
  }
  
  public boolean b(Message paramMessage)
  {
    return this.f.sendMessage(paramMessage);
  }
  
  public boolean b(Message paramMessage, long paramLong)
  {
    paramMessage = e(paramMessage);
    if (c())
    {
      com.tencent.luggage.wxa.rz.c.a.a(paramMessage.a(), 0, this.d, true);
      return false;
    }
    if (f.a.a())
    {
      com.tencent.luggage.wxa.rz.c.a.a(paramMessage.a(), 0, this.d, true);
      return false;
    }
    if (paramLong == -9223372036854775808L)
    {
      if (a.a() == this.e)
      {
        f.a.b(paramMessage);
        return true;
      }
      f.a.b(paramMessage, this.d);
      return true;
    }
    paramLong -= SystemClock.uptimeMillis();
    if (a.a() == this.e)
    {
      f.a.a(paramMessage, paramLong);
      return true;
    }
    f.a.a(paramMessage, paramLong, this.d);
    return true;
  }
  
  public boolean b(Runnable paramRunnable, long paramLong)
  {
    return this.f.postDelayed(paramRunnable, paramLong);
  }
  
  public void c(Message paramMessage) {}
  
  public boolean c()
  {
    return this.c.get();
  }
  
  public boolean c(int paramInt)
  {
    return this.e.d().a(new c.5(this, paramInt));
  }
  
  public String d(Message paramMessage)
  {
    return this.f.getMessageName(paramMessage);
  }
  
  protected c.a e(Message paramMessage)
  {
    return new c.a(this, paramMessage);
  }
  
  public String toString()
  {
    return String.format("SerialHandler(%s) %s", new Object[] { b(), getClass().getName() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sk.c
 * JD-Core Version:    0.7.0.1
 */