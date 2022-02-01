package com.tencent.luggage.wxa.sd;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
  implements a
{
  private final Handler a;
  private AtomicBoolean b = new AtomicBoolean();
  
  public b(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public static b a(Handler paramHandler)
  {
    return new b(paramHandler);
  }
  
  public Looper a()
  {
    return this.a.getLooper();
  }
  
  public Message a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    return this.a.obtainMessage(paramInt1, paramInt2, paramInt3, paramObject);
  }
  
  public void a(Object paramObject)
  {
    this.a.removeCallbacksAndMessages(paramObject);
  }
  
  public boolean a(int paramInt)
  {
    return this.a.sendEmptyMessage(paramInt);
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return this.a.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  public boolean a(Message paramMessage, long paramLong)
  {
    return this.a.sendMessageDelayed(paramMessage, paramLong);
  }
  
  public boolean a(Runnable paramRunnable)
  {
    return this.a.post(paramRunnable);
  }
  
  public String b()
  {
    return null;
  }
  
  public void b(int paramInt)
  {
    this.a.removeMessages(paramInt);
  }
  
  public void b(Runnable paramRunnable)
  {
    this.a.removeCallbacks(paramRunnable);
  }
  
  public boolean b(Message paramMessage)
  {
    return this.a.sendMessage(paramMessage);
  }
  
  public boolean b(Runnable paramRunnable, long paramLong)
  {
    return this.a.postDelayed(paramRunnable, paramLong);
  }
  
  public boolean c(int paramInt)
  {
    return this.a.hasMessages(paramInt);
  }
  
  @NonNull
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sd.b
 * JD-Core Version:    0.7.0.1
 */