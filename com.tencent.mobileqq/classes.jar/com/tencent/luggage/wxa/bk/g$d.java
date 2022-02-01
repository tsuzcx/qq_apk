package com.tencent.luggage.wxa.bk;

import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.tencent.luggage.wxa.bl.b.c;
import com.tencent.luggage.wxa.c.c.b;
import com.tencent.magicbrush.g.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "invoke"}, k=3, mv={1, 1, 16})
final class g$d
  extends Lambda
  implements Function1<g.b, Unit>
{
  public static final d a = new d();
  
  g$d()
  {
    super(1);
  }
  
  public final void a(@NotNull g.b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "$receiver");
    paramb.a(true);
    paramb.a((c.b)new b.c(14883));
    paramb.a((IImageDecodeService.a)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bk.g.d
 * JD-Core Version:    0.7.0.1
 */