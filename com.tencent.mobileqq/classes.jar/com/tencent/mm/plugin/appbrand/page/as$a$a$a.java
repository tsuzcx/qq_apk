package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.dq.c;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.h;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "invoke"}, k=3, mv={1, 1, 16})
final class as$a$a$a
  extends Lambda
  implements Function0<h>
{
  as$a$a$a(as.a.a parama)
  {
    super(0);
  }
  
  @NotNull
  public final h a()
  {
    Object localObject = (c)as.a.a.a(this.a).y();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ad.b((d)((c)localObject).f());
    if (localObject != null) {
      return (h)localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.IWxaPkgRuntimeReader");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.as.a.a.a
 * JD-Core Version:    0.7.0.1
 */