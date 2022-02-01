package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.ConcurrentLinkedQueue;

class d$20
  implements d.a
{
  d$20(d paramd, ConcurrentLinkedQueue paramConcurrentLinkedQueue, d.b paramb, long paramLong, d.a parama) {}
  
  public void u_()
  {
    if (!this.a.remove(this.b))
    {
      o.b("MicroMsg.AppBrandRuntime", "AppBrandRuntime[%s].prepare() duplicate ready() called, PrepareProcess[%s]", new Object[] { this.e.aa(), this.b.c() });
      return;
    }
    o.d("MicroMsg.AppBrandRuntime", "|runProfiled|AppBrandRuntime[%s].prepare() PrepareProcess[%s] done, cost[%d]", new Object[] { this.e.aa(), this.b.c(), Long.valueOf(af.b() - this.c) });
    if (this.a.isEmpty()) {
      this.d.u_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.d.20
 * JD-Core Version:    0.7.0.1
 */