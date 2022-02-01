package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.dg.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.ro.h;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"}, k=3, mv={1, 1, 16})
final class w$c<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  w$c(com.tencent.luggage.wxa.dg.b paramb) {}
  
  public final boolean a(Void paramVoid)
  {
    paramVoid = new StringBuilder();
    paramVoid.append("Wxa login logic boot: step 1: activate device by ILink. process:");
    paramVoid.append(r.c());
    paramVoid.append(" hasActivateDevice: ");
    paramVoid.append(d.a.g());
    o.d("Luggage.WxaTdiLoginBoot", paramVoid.toString());
    paramVoid = h.c();
    w localw = w.a;
    com.tencent.luggage.wxa.dg.b localb = this.a;
    Intrinsics.checkExpressionValueIsNotNull(localb, "activateDeviceLogic");
    localw.a(localb, (Function2)new w.c.1(paramVoid));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.w.c
 * JD-Core Version:    0.7.0.1
 */