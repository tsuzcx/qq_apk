package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.SharedV8ArrayBuffer;
import com.tencent.luggage.wxa.qz.o;

class k$a$1
  implements Runnable
{
  k$a$1(k.a parama) {}
  
  public void run()
  {
    o.d("MicroMsg.SharedV8ArrayBufferMgr", "SharedBuffer do release");
    if (k.a.a(this.a) == null)
    {
      o.d("MicroMsg.SharedV8ArrayBufferMgr", "SharedBuffer do release mV8Buffer null");
      return;
    }
    k.a.a(this.a).manualRelease();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.k.a.1
 * JD-Core Version:    0.7.0.1
 */