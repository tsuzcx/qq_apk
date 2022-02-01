package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.jo.c;
import com.tencent.luggage.wxa.jo.e.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"updateDevicePlayState", "", "state", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRState$PlayState;", "invoke"}, k=3, mv={1, 1, 16})
final class h$g
  extends Lambda
  implements Function1<e.a, Unit>
{
  h$g(h paramh)
  {
    super(1);
  }
  
  public final void a(@NotNull e.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "state");
    h.d(this.a).a().a(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.h.g
 * JD-Core Version:    0.7.0.1
 */