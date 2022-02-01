package com.tencent.magicbrush.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/ui/MBViewManager$Listener;", "invoke"}, k=3, mv={1, 1, 13})
final class MBViewManager$b
  extends Lambda
  implements Function1<MBViewManager.a, Unit>
{
  MBViewManager$b(i parami)
  {
    super(1);
  }
  
  public final void a(@NotNull MBViewManager.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "it");
    parama.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.MBViewManager.b
 * JD-Core Version:    0.7.0.1
 */