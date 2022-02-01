package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.luggage.wxa.qz.o;

class r$3
  implements JavaVoidCallback
{
  r$3(r paramr) {}
  
  public void invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    o.d("MicroMsg.J2V8_Console", paramV8Array.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.r.3
 * JD-Core Version:    0.7.0.1
 */