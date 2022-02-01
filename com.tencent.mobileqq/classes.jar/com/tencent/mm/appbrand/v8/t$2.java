package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.luggage.wxa.qz.o;

class t$2
  implements JavaCallback
{
  t$2(t paramt) {}
  
  public Object invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    if ((paramV8Array.length() >= 2) && (paramV8Array.getType(0) == 1) && (paramV8Array.getType(1) == 1))
    {
      int i = paramV8Array.getInteger(0);
      int j = paramV8Array.getInteger(1);
      t.b.a(t.b.a(), i, j);
      return null;
    }
    o.c("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.t.2
 * JD-Core Version:    0.7.0.1
 */