package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8ArrayBuffer;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.luggage.wxa.qz.o;

class q$3
  implements JavaVoidCallback
{
  q$3(q paramq) {}
  
  public void invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    if ((paramV8Array.length() >= 2) && (paramV8Array.getType(0) == 1) && (paramV8Array.getType(1) == 10))
    {
      o.e("V8DirectApiBuffer", "setNativeBuffer, id:%d", new Object[] { Integer.valueOf(paramV8Array.getInteger(0)) });
      paramV8Object = (V8ArrayBuffer)paramV8Array.get(1);
      if (paramV8Object != null)
      {
        q.a(this.a).a(paramV8Array.getInteger(0), paramV8Object.getBackingStore());
        paramV8Object.release();
        return;
      }
      o.c("V8DirectApiBuffer", "setNativeBuffer buffer null");
      return;
    }
    o.c("V8DirectApiBuffer", "setNativeBuffer invalid parameters");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.q.3
 * JD-Core Version:    0.7.0.1
 */