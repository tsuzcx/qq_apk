package com.tencent.luggage.wxa.bs;

import com.tencent.luggage.wxa.dq.c;
import com.tencent.luggage.wxa.oy.a;
import com.tencent.magicbrush.e.b;
import com.tencent.mm.plugin.appbrand.keylogger.d;
import java.util.concurrent.atomic.AtomicBoolean;

class h$2
  implements e.b
{
  h$2(h paramh) {}
  
  public void a()
  {
    if (h.b(this.a).compareAndSet(false, true))
    {
      ((c)this.a.y()).f("onFirstFrame");
      d.b(this.a.o(), a.S);
      d.b(this.a.o(), a.H);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bs.h.2
 * JD-Core Version:    0.7.0.1
 */