package com.tencent.magicbrush.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "invoke"}, k=3, mv={1, 1, 13})
final class i$j$f
  extends Lambda
  implements Function1<i.c, Unit>
{
  i$j$f(Object paramObject, int paramInt1, int paramInt2)
  {
    super(1);
  }
  
  public final void a(@NotNull i.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "it");
    if ((paramc instanceof i.e)) {
      ((i.e)paramc).c(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.i.j.f
 * JD-Core Version:    0.7.0.1
 */