package com.tencent.magicbrush;

import com.tencent.luggage.wxa.gi.b;
import com.tencent.luggage.wxa.gi.c.c;
import com.tencent.luggage.wxa.gk.h;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 13})
final class e$h
  implements Runnable
{
  e$h(e parame) {}
  
  public final void run()
  {
    long l1 = h.a();
    b.a("mmphysx");
    long l2 = h.a();
    e locale = this.a;
    locale.nativeLazyLoadPhysx(locale.a, this.a.p().r());
    c.c.b("MagicBrush", "lazy load physx loadCost: %d bindCost: %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(h.a(l2)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.e.h
 * JD-Core Version:    0.7.0.1
 */