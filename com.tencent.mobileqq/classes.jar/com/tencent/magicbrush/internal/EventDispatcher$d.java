package com.tencent.magicbrush.internal;

import com.tencent.magicbrush.ui.i.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/ui/MagicBrushView$RenderingContextListener;", "invoke"}, k=3, mv={1, 1, 13})
final class EventDispatcher$d
  extends Lambda
  implements Function1<i.g, Unit>
{
  EventDispatcher$d(int paramInt)
  {
    super(1);
  }
  
  public final void a(@NotNull i.g paramg)
  {
    Intrinsics.checkParameterIsNotNull(paramg, "it");
    paramg.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.internal.EventDispatcher.d
 * JD-Core Version:    0.7.0.1
 */