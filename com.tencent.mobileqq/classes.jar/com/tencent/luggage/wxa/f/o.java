package com.tencent.luggage.wxa.f;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;

abstract class o
{
  private o.a a;
  private int b;
  private int c;
  
  abstract void a(int paramInt);
  
  void a(int paramInt1, int paramInt2) {}
  
  void a(o.a parama)
  {
    this.a = parama;
  }
  
  void b(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  abstract Surface e();
  
  SurfaceHolder f()
  {
    return null;
  }
  
  abstract View g();
  
  abstract Class h();
  
  abstract boolean i();
  
  protected void j()
  {
    this.a.a();
  }
  
  Object k()
  {
    return null;
  }
  
  int l()
  {
    return this.b;
  }
  
  int m()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.o
 * JD-Core Version:    0.7.0.1
 */