package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.luggage.wxa.qz.o;

class q$1
  implements JavaCallback
{
  q$1(q paramq) {}
  
  public Object invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    paramV8Object = Integer.valueOf(q.a(this.a).a());
    o.e("V8DirectApiBuffer", "generateId:%d", new Object[] { paramV8Object });
    return paramV8Object;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.q.1
 * JD-Core Version:    0.7.0.1
 */