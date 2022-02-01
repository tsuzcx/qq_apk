package com.tencent.mm.appbrand.v8;

import android.util.SparseArray;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Function;

abstract class u$b
{
  n b;
  V8Function c;
  int d;
  
  u$b(u paramu, n paramn, int paramInt, V8Function paramV8Function)
  {
    this.b = paramn;
    this.c = paramV8Function;
    this.d = paramInt;
  }
  
  abstract void a();
  
  void a(V8Array paramV8Array)
  {
    if ((!this.c.isReleased()) && (!this.b.b().isReleased())) {
      this.c.call(this.b.b().getGlobalObject(), paramV8Array);
    }
  }
  
  void b()
  {
    d();
  }
  
  boolean c()
  {
    return (!this.c.isReleased()) && (!this.b.b().isReleased());
  }
  
  void d()
  {
    u.a(this.e).remove(this.d);
    this.c.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.u.b
 * JD-Core Version:    0.7.0.1
 */