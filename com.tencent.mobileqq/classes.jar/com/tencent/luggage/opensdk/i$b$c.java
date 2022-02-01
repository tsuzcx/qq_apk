package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.h;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "", "call", "(Lkotlin/Unit;)Ljava/lang/String;"}, k=3, mv={1, 1, 16})
final class i$b$c<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  i$b$c(i.b paramb) {}
  
  public final String a(Unit paramUnit)
  {
    paramUnit = i.b.b(this.a).a();
    if (paramUnit != null) {
      h.a((e)paramUnit);
    } else {
      h.b().a("fail:internal error");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.i.b.c
 * JD-Core Version:    0.7.0.1
 */