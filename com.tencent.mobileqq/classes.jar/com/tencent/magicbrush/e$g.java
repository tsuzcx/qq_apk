package com.tencent.magicbrush;

import com.tencent.luggage.wxa.gi.b;
import com.tencent.luggage.wxa.gi.c.c;
import com.tencent.luggage.wxa.gk.h;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 13})
final class e$g
  implements Runnable
{
  e$g(e parame) {}
  
  public final void run()
  {
    long l1 = h.a();
    b.a("mmbox2d");
    long l2 = h.a();
    e locale = this.a;
    locale.nativeLazyLoadBox2D(locale.a, this.a.p().q());
    c.c.b("MagicBrush", "lazy load box2d loadCost: %d bindCost: %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(h.a(l2)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.e.g
 * JD-Core Version:    0.7.0.1
 */