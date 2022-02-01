package com.tencent.luggage.wxa.a;

public class g
{
  b.q a = null;
  f b = null;
  String c = null;
  h.b d = null;
  String e = null;
  h.b f = null;
  
  public g() {}
  
  public g(g paramg)
  {
    if (paramg == null) {
      return;
    }
    this.a = paramg.a;
    this.b = paramg.b;
    this.d = paramg.d;
    this.e = paramg.e;
    this.f = paramg.f;
  }
  
  public g a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.f = new h.b(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    return this;
  }
  
  public boolean a()
  {
    b.q localq = this.a;
    return (localq != null) && (localq.c() > 0);
  }
  
  public boolean b()
  {
    return this.b != null;
  }
  
  public boolean c()
  {
    return this.e != null;
  }
  
  public boolean d()
  {
    return this.d != null;
  }
  
  public boolean e()
  {
    return this.f != null;
  }
  
  public boolean f()
  {
    return this.c != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.g
 * JD-Core Version:    0.7.0.1
 */