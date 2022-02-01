package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Function;

class u$c
  extends u.b
  implements Runnable
{
  final long f;
  final boolean g;
  final V8Array h;
  
  u$c(u paramu, n paramn, int paramInt, V8Function paramV8Function, V8Array paramV8Array, boolean paramBoolean, long paramLong)
  {
    super(paramu, paramn, paramInt, paramV8Function);
    this.f = paramLong;
    this.g = paramBoolean;
    this.h = paramV8Array;
  }
  
  void a()
  {
    this.b.a().a(this, this.f);
  }
  
  void d()
  {
    super.d();
    this.h.release();
  }
  
  public void run()
  {
    if (!c()) {
      return;
    }
    a(this.h);
    if (!c()) {
      return;
    }
    if (this.g)
    {
      a();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.u.c
 * JD-Core Version:    0.7.0.1
 */