package com.tencent.luggage.wxa.hp;

import com.tencent.luggage.wxa.hj.e;
import com.tencent.luggage.wxa.hs.b;

final class f$1
  implements e<f.c>
{
  f$1(e parame) {}
  
  public void a(f.c paramc)
  {
    e locale = this.a;
    if (locale != null)
    {
      if (paramc == null)
      {
        b.c("IPC.XIPCInvoker", "async invoke callback error, wrapper parcelable data is null!", new Object[0]);
        this.a.a(null);
        return;
      }
      locale.a(paramc.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hp.f.1
 * JD-Core Version:    0.7.0.1
 */