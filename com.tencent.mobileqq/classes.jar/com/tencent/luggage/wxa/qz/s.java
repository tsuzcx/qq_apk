package com.tencent.luggage.wxa.qz;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.sd.b;

public class s
  implements com.tencent.luggage.wxa.sd.a
{
  private static final Handler a = new Handler(Looper.getMainLooper());
  private volatile Message b;
  private final com.tencent.luggage.wxa.sd.a c;
  private final Object d = new Object();
  
  public s()
  {
    this.c = a(Looper.myLooper(), com.tencent.luggage.wxa.sk.a.b(), null);
  }
  
  public s(Looper paramLooper)
  {
    paramLooper.getClass();
    this.c = a(paramLooper, null, null);
  }
  
  public s(com.tencent.luggage.wxa.sk.a parama)
  {
    parama.getClass();
    this.c = a(null, parama, null);
  }
  
  public s(String paramString)
  {
    this.c = a(null, com.tencent.luggage.wxa.sk.a.a(paramString), null);
  }
  
  public static Handler a(Looper paramLooper)
  {
    return new Handler(paramLooper);
  }
  
  private com.tencent.luggage.wxa.sd.a a(Looper paramLooper, s.a parama)
  {
    return b.a(new s.1(this, paramLooper, parama, Looper.getMainLooper().getThread().getId(), parama));
  }
  
  private com.tencent.luggage.wxa.sd.a a(Looper paramLooper, com.tencent.luggage.wxa.sk.a parama, s.a parama1)
  {
    if ((paramLooper != Looper.getMainLooper()) && (parama != com.tencent.luggage.wxa.sk.a.a()))
    {
      if (parama != null) {
        return a(parama, parama1);
      }
      if (paramLooper != null) {
        return a(paramLooper, parama1);
      }
      throw new RuntimeException("looper and serial is null!");
    }
    return a(Looper.getMainLooper(), parama1);
  }
  
  @SuppressLint({"HandlerLeak"})
  private com.tencent.luggage.wxa.sd.a a(com.tencent.luggage.wxa.sk.a parama, s.a parama1)
  {
    return new s.2(this, parama, parama1, Looper.getMainLooper().getThread().getId(), parama1);
  }
  
  public Looper a()
  {
    return this.c.a();
  }
  
  public Message a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    return this.c.a(paramInt1, paramInt2, paramInt3, paramObject);
  }
  
  public void a(Message paramMessage) {}
  
  public void a(Object paramObject)
  {
    this.c.a(paramObject);
  }
  
  public boolean a(int paramInt)
  {
    return this.c.a(paramInt);
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return this.c.a(paramInt, paramLong);
  }
  
  public boolean a(Message paramMessage, long paramLong)
  {
    return this.c.a(paramMessage, paramLong);
  }
  
  public boolean a(Runnable paramRunnable)
  {
    return this.c.a(paramRunnable);
  }
  
  public String b()
  {
    return this.c.b();
  }
  
  public void b(int paramInt)
  {
    this.c.b(paramInt);
  }
  
  public void b(Runnable paramRunnable)
  {
    this.c.b(paramRunnable);
  }
  
  public boolean b(Message paramMessage)
  {
    return this.c.b(paramMessage);
  }
  
  public boolean b(Runnable paramRunnable, long paramLong)
  {
    return this.c.b(paramRunnable, paramLong);
  }
  
  public boolean c(int paramInt)
  {
    return this.c.c(paramInt);
  }
  
  @Deprecated
  public final boolean c(Runnable paramRunnable)
  {
    return this.c.a(paramRunnable);
  }
  
  @NonNull
  public String toString()
  {
    return this.c.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.s
 * JD-Core Version:    0.7.0.1
 */