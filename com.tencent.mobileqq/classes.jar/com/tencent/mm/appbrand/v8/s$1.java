package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.luggage.wxa.qz.o;

class s$1
  implements JavaCallback
{
  s$1(s params) {}
  
  public Object invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    if ((paramV8Array.length() >= 1) && (paramV8Array.getType(0) == 1))
    {
      int i = paramV8Array.getInteger(0);
      o.d("MicroMsg.V8DirectApiSharedBuffer", "get, id:%d", new Object[] { Integer.valueOf(i) });
      return s.a(this.a).b(i);
    }
    o.c("MicroMsg.V8DirectApiSharedBuffer", "get invalid parameters");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.s.1
 * JD-Core Version:    0.7.0.1
 */