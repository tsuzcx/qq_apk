package com.tencent.luggage.wxa.fk;

import com.tencent.luggage.opensdk.i;
import com.tencent.luggage.wxa.em.d;
import com.tencent.luggage.wxa.em.h;
import com.tencent.luggage.wxa.jx.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class e$c$a
  implements Runnable
{
  e$c$a(e.c paramc1, e.c paramc2) {}
  
  public final void run()
  {
    j localj = this.a.a.a(f.class, true);
    if (localj == null) {
      Intrinsics.throwNpe();
    }
    ((f)localj).a(i.a.a("sdk_openGrowthCare"));
    h.a.a((d)this.a.a);
    this.b.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fk.e.c.a
 * JD-Core Version:    0.7.0.1
 */