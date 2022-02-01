package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.x;

class r$5
  implements JavaVoidCallback
{
  r$5(r paramr) {}
  
  public void invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    paramV8Object = paramV8Array.toString();
    o.b("MicroMsg.J2V8_Console", paramV8Object);
    if (r.a(this.a) != null) {
      r.a(this.a).a(paramV8Object);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.r.5
 * JD-Core Version:    0.7.0.1
 */