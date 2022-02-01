package com.tencent.luggage.wxa.kb;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.kc.a;
import com.tencent.mm.plugin.appbrand.page.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class c$s
  extends Lambda
  implements Function0<Unit>
{
  c$s(com.tencent.mm.plugin.appbrand.phonenumber.z paramz, a parama, u paramu, c.b paramb)
  {
    super(0);
  }
  
  public final void a()
  {
    com.tencent.mm.plugin.appbrand.phonenumber.z localz = this.a;
    if (localz != null)
    {
      Long localLong;
      if (localz != null) {
        localLong = Long.valueOf(localz.h());
      } else {
        localLong = null;
      }
      if (localLong == null) {
        Intrinsics.throwNpe();
      }
      localz.i(localLong.longValue() + 1L);
    }
    this.b.a((b)this.c, this.d.b().b, (com.tencent.luggage.wxa.jx.z)this.c.a(com.tencent.luggage.wxa.jx.z.class)).a((b)this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.c.s
 * JD-Core Version:    0.7.0.1
 */