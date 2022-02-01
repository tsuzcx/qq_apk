package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.mm.plugin.appbrand.page.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class c$b
  implements Runnable
{
  c$b(c paramc, u paramu, b paramb, int paramInt) {}
  
  public final void run()
  {
    if (this.b.ah() == null) {
      this.b.aN();
    } else {
      this.b.aO();
    }
    b localb = this.c;
    if (localb == null) {
      Intrinsics.throwNpe();
    }
    localb.a(this.d, this.a.b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.c.b
 * JD-Core Version:    0.7.0.1
 */