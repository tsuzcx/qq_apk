package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Function;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.luggage.wxa.qz.o;

class t$1
  implements JavaCallback
{
  t$1(t paramt, n paramn) {}
  
  public Object invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    if ((paramV8Array.length() >= 2) && (paramV8Array.getType(0) == 1) && (paramV8Array.getType(1) == 7))
    {
      int i = paramV8Array.getInteger(0);
      paramV8Object = (V8Function)paramV8Array.getObject(1);
      return Integer.valueOf(t.b.a(t.b.a(), i, paramV8Object, this.a));
    }
    o.c("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
    return Integer.valueOf(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.t.1
 * JD-Core Version:    0.7.0.1
 */