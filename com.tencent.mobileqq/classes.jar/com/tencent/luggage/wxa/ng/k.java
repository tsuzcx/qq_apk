package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.jo.b;
import com.tencent.luggage.wxa.jo.c;
import com.tencent.luggage.wxa.qz.w;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"isRecentDevice", "", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "saveDevice", "", "luggage-xweb-ext_release"}, k=2, mv={1, 1, 16})
public final class k
{
  public static final boolean a(@NotNull c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "$this$isRecentDevice");
    w localw = w.a();
    paramc = paramc.a();
    if (paramc != null) {
      paramc = paramc.j;
    } else {
      paramc = null;
    }
    return localw.getLong(paramc, 0L) != 0L;
  }
  
  public static final void b(@NotNull c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "$this$saveDevice");
    w localw = w.a();
    f.a.c((Runnable)new k.a(paramc, localw, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.k
 * JD-Core Version:    0.7.0.1
 */