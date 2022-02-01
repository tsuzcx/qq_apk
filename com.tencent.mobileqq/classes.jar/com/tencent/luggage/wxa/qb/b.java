package com.tencent.luggage.wxa.qb;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.appbrand.v8.n;
import com.tencent.mm.appbrand.v8.w;
import com.tencent.mm.appbrand.v8.w.a;
import com.tencent.mm.appbrand.v8.x;

public class b
  extends w
{
  b(x paramx)
  {
    super(paramx);
  }
  
  protected final void a(n paramn, w.a parama)
  {
    if ((parama instanceof b.a))
    {
      String str = ((b.a)parama).c;
      if (!af.c(str))
      {
        o.d("MicroMsg.V8EngineWorkerManagerLU", "hy: %s has sourcemap", new Object[] { parama.a });
        paramn.a(str, null);
      }
    }
    o.d("MicroMsg.V8EngineWorkerManagerLU", "hy: evaluating %s", new Object[] { parama.a });
    long l = System.currentTimeMillis();
    paramn.a(parama.a, parama.b, new b.1(this, parama, l));
  }
  
  protected void a(w.a parama, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qb.b
 * JD-Core Version:    0.7.0.1
 */