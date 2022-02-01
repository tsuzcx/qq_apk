package com.tencent.luggage.wxa.kb;

import com.tencent.luggage.wxa.ro.b;
import com.tencent.mm.plugin.appbrand.phonenumber.z;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class c$o
  extends Lambda
  implements Function0<Unit>
{
  c$o(z paramz, b paramb)
  {
    super(0);
  }
  
  public final void a()
  {
    z localz = this.a;
    if (localz != null)
    {
      Long localLong;
      if (localz != null) {
        localLong = Long.valueOf(localz.e());
      } else {
        localLong = null;
      }
      if (localLong == null) {
        Intrinsics.throwNpe();
      }
      localz.f(localLong.longValue() + 1L);
    }
    this.b.a("user cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.c.o
 * JD-Core Version:    0.7.0.1
 */