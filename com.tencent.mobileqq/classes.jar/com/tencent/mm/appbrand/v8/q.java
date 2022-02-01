package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.V8Object;

class q
  extends p
{
  private f a;
  
  q(f paramf)
  {
    this.a = paramf;
  }
  
  public void a() {}
  
  protected void a(n paramn, V8Object paramV8Object)
  {
    paramV8Object.registerJavaMethod(new q.1(this), "getNativeBufferId");
    paramV8Object.registerJavaMethod(new q.2(this, paramn), "getNativeBuffer");
    paramV8Object.registerJavaMethod(new q.3(this), "setNativeBuffer");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.q
 * JD-Core Version:    0.7.0.1
 */