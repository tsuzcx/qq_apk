package com.tencent.magicbrush.internal;

import com.tencent.magicbrush.e.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "invoke"}, k=3, mv={1, 1, 13})
final class EventDispatcher$c
  extends Lambda
  implements Function1<e.d, Unit>
{
  EventDispatcher$c(String paramString1, String paramString2, int paramInt)
  {
    super(1);
  }
  
  public final void a(@NotNull e.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "it");
    paramd.a(this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.internal.EventDispatcher.c
 * JD-Core Version:    0.7.0.1
 */