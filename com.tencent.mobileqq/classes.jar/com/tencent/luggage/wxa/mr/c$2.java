package com.tencent.luggage.wxa.mr;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ms.b;
import com.tencent.luggage.wxa.ms.d;
import com.tencent.luggage.wxa.ms.e;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.v;
import java.util.concurrent.atomic.AtomicBoolean;

class c$2
  implements b
{
  c$2(c paramc, v paramv, AtomicBoolean paramAtomicBoolean, com.tencent.luggage.wxa.jx.c paramc1, int paramInt, Context paramContext) {}
  
  public void a(@NonNull d paramd)
  {
    o.d("MicroMsg.JsApiGetWifiList", "onGetWiFiList");
    this.a.c();
    e.c();
    if (!this.b.get())
    {
      c.a(this.f, this.c, this.d, this.e, paramd);
      this.b.set(true);
      return;
    }
    o.d("MicroMsg.JsApiGetWifiList", "onGetWiFiList, hasCallback");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mr.c.2
 * JD-Core Version:    0.7.0.1
 */