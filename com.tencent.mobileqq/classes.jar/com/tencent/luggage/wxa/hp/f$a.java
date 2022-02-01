package com.tencent.luggage.wxa.hp;

import com.tencent.luggage.wxa.hj.c;
import com.tencent.luggage.wxa.hj.e;
import com.tencent.luggage.wxa.hj.p;
import com.tencent.luggage.wxa.hs.b;

class f$a
  implements c<f.c, f.c>
{
  public void a(f.c paramc, e<f.c> parame)
  {
    Object localObject = paramc.a();
    paramc = paramc.b();
    if ((paramc != null) && (paramc.length() != 0))
    {
      c localc = (c)p.a(paramc, c.class);
      if (localc == null)
      {
        b.c("IPC.IPCAsyncInvokeTaskProxy", "proxy AsyncInvoke failed, newInstance(%s) return null.", new Object[] { paramc });
        return;
      }
      localc.a(localObject, new f.b(parame));
      return;
    }
    b.b("IPC.IPCAsyncInvokeTaskProxy", "proxy AsyncInvoke failed, class is null or nil.", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hp.f.a
 * JD-Core Version:    0.7.0.1
 */