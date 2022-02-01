package com.tencent.luggage.wxa.rp;

import android.os.Handler;
import android.os.Looper;

public class h
  extends d
{
  private a d;
  private Looper e;
  private String f;
  
  public h(Handler paramHandler, String paramString)
  {
    this(new b(paramHandler), paramString);
  }
  
  h(Looper paramLooper, a parama, String paramString)
  {
    this.e = paramLooper;
    this.d = parama;
    this.f = paramString;
  }
  
  public h(Looper paramLooper, String paramString)
  {
    this(new Handler(paramLooper), paramString);
  }
  
  public h(a parama, String paramString)
  {
    this(parama.a(), parama, paramString);
  }
  
  public void a()
  {
    this.d.b();
  }
  
  public void a(Runnable paramRunnable)
  {
    this.d.a(paramRunnable);
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    if (paramLong >= 0L)
    {
      this.d.a(paramRunnable, paramLong);
      return;
    }
    this.d.a(paramRunnable);
  }
  
  public Looper b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rp.h
 * JD-Core Version:    0.7.0.1
 */