package com.tencent.luggage.wxa.se;

import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicBoolean;

public class e<P>
{
  static f a = new c();
  static f b = new b();
  static f c = new g();
  private static final e.a k = new e.a();
  P d;
  f e;
  volatile a f;
  a<Throwable, ?> g;
  volatile e h;
  volatile e i;
  AtomicBoolean j = new AtomicBoolean(false);
  private final Object l = new Object();
  private volatile boolean m = false;
  
  e() {}
  
  e(P paramP)
  {
    this.d = paramP;
  }
  
  public static <T> e<T> a(T paramT)
  {
    return new e(paramT);
  }
  
  private void d()
  {
    for (e locale = this; locale != null; locale = locale.i) {
      locale.e();
    }
  }
  
  private void e()
  {
    if (this.m) {
      synchronized (this.l)
      {
        if (this.m) {
          this.l.notifyAll();
        }
        return;
      }
    }
  }
  
  a<Throwable, ?> a()
  {
    return null;
  }
  
  public <R> e<R> a(@NonNull a<P, R> parama)
  {
    parama.getClass();
    e locale = new e();
    locale.e = c();
    locale.h = null;
    this.i = locale;
    this.f = parama;
    this.j.compareAndSet(false, true);
    b(parama);
    return locale;
  }
  
  public P b()
  {
    try
    {
      if (this.d == null) {
        synchronized (this.l)
        {
          if (this.d == null)
          {
            this.m = true;
            this.l.wait();
            this.m = false;
          }
        }
      }
      return this.d;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
  
  void b(a parama)
  {
    if (parama == null)
    {
      e();
      return;
    }
    parama = new e.1(this, parama);
    if (this.d != null)
    {
      f localf = this.e;
      if (localf == null)
      {
        parama.run();
        return;
      }
      localf.execute(parama);
    }
  }
  
  public f c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.se.e
 * JD-Core Version:    0.7.0.1
 */