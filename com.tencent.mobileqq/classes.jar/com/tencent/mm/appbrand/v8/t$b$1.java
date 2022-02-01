package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Function;
import com.tencent.luggage.wxa.qz.o;

class t$b$1
  implements Runnable
{
  t$b$1(t.b paramb, V8Function paramV8Function, n paramn) {}
  
  public void run()
  {
    if (!this.a.isReleased())
    {
      o.e("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger task call");
      this.a.call(this.b.b().getGlobalObject(), null);
      this.a.release();
      return;
    }
    o.c("MicroMsg.V8DirectApiSharedBufferLock", "hy: called a released task");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.t.b.1
 * JD-Core Version:    0.7.0.1
 */