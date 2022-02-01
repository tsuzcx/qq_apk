package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.luggage.wxa.qz.o;

class q$2
  implements JavaCallback
{
  q$2(q paramq, n paramn) {}
  
  public Object invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    if ((paramV8Array.length() >= 1) && (paramV8Array.getType(0) == 1))
    {
      o.e("V8DirectApiBuffer", "getNativeBuffer, id:%d", new Object[] { Integer.valueOf(paramV8Array.getInteger(0)) });
      paramV8Object = q.a(this.b).a(paramV8Array.getInteger(0), false);
      if (paramV8Object == null)
      {
        o.c("V8DirectApiBuffer", "getNativeBuffer bb null");
        return null;
      }
      return this.a.b().newV8ArrayBuffer(paramV8Object);
    }
    o.c("V8DirectApiBuffer", "getNativeBuffer invalid parameters");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.q.2
 * JD-Core Version:    0.7.0.1
 */