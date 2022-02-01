package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.ro.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Lkotlin/Unit;)Z"}, k=3, mv={1, 1, 16})
final class w$e<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  w$e(com.tencent.luggage.wxa.dg.b paramb) {}
  
  public final boolean a(Unit paramUnit)
  {
    paramUnit = new StringBuilder();
    paramUnit.append("Wxa login logic boot: step 3: checkLogin ");
    paramUnit.append("process:");
    paramUnit.append(r.c());
    paramUnit.append(" hasLogin:");
    paramUnit.append(i.a.g());
    o.d("Luggage.WxaTdiLoginBoot", paramUnit.toString());
    paramUnit = h.c();
    if (i.a.g())
    {
      w localw = w.a;
      com.tencent.luggage.wxa.dg.b localb = this.a;
      Intrinsics.checkExpressionValueIsNotNull(localb, "activateDeviceLogic");
      w.a(localw, localb, (Function2)new w.e.1(paramUnit));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.w.e
 * JD-Core Version:    0.7.0.1
 */