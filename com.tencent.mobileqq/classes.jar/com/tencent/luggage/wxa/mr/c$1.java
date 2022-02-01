package com.tencent.luggage.wxa.mr;

import android.content.Context;
import com.tencent.luggage.wxa.ms.d;
import com.tencent.luggage.wxa.ms.e;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.v.a;
import java.util.concurrent.atomic.AtomicBoolean;

class c$1
  implements v.a
{
  c$1(c paramc, AtomicBoolean paramAtomicBoolean, com.tencent.luggage.wxa.jx.c paramc1, int paramInt, Context paramContext) {}
  
  public boolean p_()
  {
    o.d("MicroMsg.JsApiGetWifiList", "onTimerExpired");
    e.c();
    if (!this.a.get())
    {
      d locald = e.b();
      c.a(this.e, this.b, this.c, this.d, locald);
      this.a.set(true);
    }
    else
    {
      o.d("MicroMsg.JsApiGetWifiList", "onTimerExpired, hasCallback");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mr.c.1
 * JD-Core Version:    0.7.0.1
 */