package com.tencent.luggage.wxa.fw;

import com.tencent.luggage.wxa.ny.c;
import com.tencent.luggage.wxa.ny.e.a;
import com.tencent.luggage.wxa.ny.e.b;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "invoke"}, k=3, mv={1, 1, 16})
final class a$c
  extends Lambda
  implements Function1<aa, Unit>
{
  a$c(a parama)
  {
    super(1);
  }
  
  public final void a(@NotNull aa paramaa)
  {
    Intrinsics.checkParameterIsNotNull(paramaa, "it");
    e.a locala = a.a(this.a);
    Object localObject = locala;
    if (!(locala instanceof e.b)) {
      localObject = null;
    }
    localObject = (e.b)localObject;
    if (localObject != null) {
      ((e.b)localObject).a((c)paramaa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fw.a.c
 * JD-Core Version:    0.7.0.1
 */