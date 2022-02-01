package com.tencent.luggage.wxa.ou;

import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicInteger;

public final class j
{
  private final AtomicInteger a;
  private volatile j.a b;
  private final j.c c = new j.c(this, null);
  private final j.b d = new j.b(this, null);
  private final String e;
  private long f;
  private long g;
  
  public j(String paramString)
  {
    this.e = paramString;
    this.a = new AtomicInteger(0);
    this.b = new j.d(this, null);
  }
  
  public boolean a()
  {
    return 1 == this.a.get();
  }
  
  public boolean b()
  {
    int i = this.a.get();
    return (-1 == i) || (2 == i);
  }
  
  public boolean c()
  {
    boolean bool;
    if (this.a.getAndSet(1) != 1) {
      bool = true;
    } else {
      bool = false;
    }
    o.e("Luggage.StayingRecorder", "%s toForeground, changed:%b", new Object[] { this.e, Boolean.valueOf(bool) });
    if (bool)
    {
      this.b.b();
      j.c localc = this.c;
      this.b = localc;
      localc.a();
    }
    return bool;
  }
  
  public boolean d()
  {
    boolean bool;
    if (this.a.getAndSet(2) != 2) {
      bool = true;
    } else {
      bool = false;
    }
    o.e("Luggage.StayingRecorder", "%s toBackground, changed:%b", new Object[] { this.e, Boolean.valueOf(bool) });
    if (bool)
    {
      this.b.b();
      j.b localb = this.d;
      this.b = localb;
      localb.a();
    }
    return bool;
  }
  
  public long e()
  {
    return this.g;
  }
  
  public void f()
  {
    this.a.set(-1);
    this.b = new j.d(this, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ou.j
 * JD-Core Version:    0.7.0.1
 */