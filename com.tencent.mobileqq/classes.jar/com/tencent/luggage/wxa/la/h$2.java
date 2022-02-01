package com.tencent.luggage.wxa.la;

import android.text.TextUtils;
import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.nn.a;
import com.tencent.luggage.wxa.pc.i;

class h$2
  implements com.tencent.luggage.wxa.rl.b<Void, c>
{
  h$2(h paramh, i parami, com.tencent.luggage.wxa.iu.b paramb, a parama, c.c paramc) {}
  
  public Void a(c paramc)
  {
    if (this.a.a != null) {
      ((com.tencent.luggage.wxa.ny.d)this.a.a).dismiss();
    }
    if (paramc == null)
    {
      com.tencent.luggage.wxa.ro.h.b().a(new Exception("get attrs failed"));
      return null;
    }
    if (TextUtils.isEmpty(paramc.D))
    {
      com.tencent.luggage.wxa.ro.h.b().a(new Exception("get invalid appId"));
      return null;
    }
    if (!this.b.d())
    {
      com.tencent.luggage.wxa.ro.h.b().a(new Exception("fail:interrupted"));
      return null;
    }
    com.tencent.luggage.wxa.ed.d locald = (com.tencent.luggage.wxa.ed.d)this.b.q();
    if (locald == null)
    {
      com.tencent.luggage.wxa.ro.h.b().a(new Exception("fail:internal error"));
      return null;
    }
    paramc.r = locald.j().r;
    locald.a(paramc, this.c.f);
    paramc = this.d;
    if (paramc != null) {
      paramc.a(true, "ok");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.la.h.2
 * JD-Core Version:    0.7.0.1
 */