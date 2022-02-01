package com.tencent.luggage.wxa.nf;

import com.tencent.luggage.wxa.ng.f;
import com.tencent.luggage.wxa.ng.h;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/Response;", "", "invoke"}, k=3, mv={1, 1, 16})
final class b$i$a
  extends Lambda
  implements Function1<f<Integer>, Unit>
{
  b$i$a(b.i parami)
  {
    super(1);
  }
  
  public final void a(@NotNull f<Integer> paramf)
  {
    Intrinsics.checkParameterIsNotNull(paramf, "it");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("volume now:");
    ((StringBuilder)localObject).append((Integer)paramf.a());
    o.d("MicroMsg.VideoCast.AppBrandVideoCastHandler", ((StringBuilder)localObject).toString());
    localObject = b.a(this.a.a);
    paramf = paramf.a();
    if (paramf == null) {
      Intrinsics.throwNpe();
    }
    ((h)localObject).b(((Number)paramf).intValue() + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.b.i.a
 * JD-Core Version:    0.7.0.1
 */