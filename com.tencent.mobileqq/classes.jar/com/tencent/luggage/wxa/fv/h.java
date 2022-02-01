package com.tencent.luggage.wxa.fv;

import com.tencent.ilink.tdi.b.v;
import com.tencent.ilinkservice.aq;
import com.tencent.luggage.wxa.dg.b;
import com.tencent.luggage.wxa.dg.b.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"login", "", "Lcom/tencent/luggage/login/device/IActivateDevice;", "loginAction", "Lkotlin/Function1;", "Lcom/tencent/ilinkservice/IlinkTdiSessionInterface;", "onLoginComplete", "Lkotlin/Function2;", "", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiLoginResponse;", "luggage-standalone-open-runtime-sdk_release"}, k=2, mv={1, 1, 16})
public final class h
{
  private static final void b(@NotNull b paramb, Function1<? super aq, Unit> paramFunction1, Function2<? super Integer, ? super b.v, Unit> paramFunction2)
  {
    paramb.a((b.b)new h.a(paramb, paramFunction2));
    paramb = paramb.f();
    if (paramb == null) {
      Intrinsics.throwNpe();
    }
    paramFunction1.invoke(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fv.h
 * JD-Core Version:    0.7.0.1
 */