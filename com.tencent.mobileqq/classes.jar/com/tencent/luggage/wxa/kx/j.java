package com.tencent.luggage.wxa.kx;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.luggage.wxa.jx.k;

public class j
  extends com.tencent.luggage.wxa.ra.c
  implements k
{
  private final b a;
  private Bundle b;
  private volatile boolean c = false;
  private volatile boolean d = false;
  private volatile boolean e = false;
  private j.a f;
  private final com.tencent.luggage.wxa.ra.b g = new j.1(this);
  private final com.tencent.luggage.wxa.ra.b h = new j.2(this);
  private final com.tencent.luggage.wxa.ra.b i = new j.3(this);
  
  j(com.tencent.luggage.wxa.jx.c paramc)
  {
    super(localStringBuilder.toString(), Looper.getMainLooper());
    this.a = new b(paramc);
    a(this.g);
    a(this.h);
    a(this.i);
    b(this.g);
  }
  
  public void a(Bundle paramBundle)
  {
    this.b = paramBundle;
  }
  
  public void a(j.a parama)
  {
    this.f = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public void d()
  {
    c();
  }
  
  public void e()
  {
    this.c = false;
    c(3);
  }
  
  public void e(String paramString)
  {
    j.a locala = this.f;
    if (locala != null) {
      locala.a(paramString);
    }
  }
  
  public void f()
  {
    if (!this.c)
    {
      c(4);
      return;
    }
    this.c = false;
  }
  
  public void g()
  {
    this.c = false;
    c(1);
  }
  
  public void h()
  {
    this.c = false;
    c(2);
  }
  
  public void j()
  {
    this.c = true;
    c(2);
  }
  
  public void k()
  {
    s();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.j
 * JD-Core Version:    0.7.0.1
 */