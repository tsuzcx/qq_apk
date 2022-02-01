package com.tencent.luggage.wxa.ql;

import com.tencent.luggage.wxa.ig.e;
import com.tencent.luggage.wxa.qz.t;

public abstract class b
{
  protected f a;
  protected e b;
  protected g c = new g();
  
  protected void a(int paramInt)
  {
    if (this.a != null) {
      t.a(new b.3(this, paramInt));
    }
  }
  
  public abstract void a(long paramLong);
  
  public void a(e parame)
  {
    this.b = parame;
  }
  
  public void a(f paramf)
  {
    this.a = paramf;
  }
  
  public abstract void a(String paramString);
  
  protected void a(boolean paramBoolean)
  {
    if (this.a != null) {
      t.a(new b.1(this, paramBoolean));
    }
  }
  
  public abstract boolean a();
  
  protected void b(boolean paramBoolean)
  {
    if (this.a != null) {
      t.a(new b.4(this, paramBoolean));
    }
  }
  
  public abstract boolean b();
  
  public abstract int c();
  
  public abstract int d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract String h();
  
  protected void l()
  {
    if (this.a != null) {
      t.a(new b.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ql.b
 * JD-Core Version:    0.7.0.1
 */