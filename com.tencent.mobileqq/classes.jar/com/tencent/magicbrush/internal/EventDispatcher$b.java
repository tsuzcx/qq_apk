package com.tencent.magicbrush.internal;

import com.tencent.magicbrush.e.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "invoke"}, k=3, mv={1, 1, 13})
final class EventDispatcher$b
  extends Lambda
  implements Function1<e.b, Unit>
{
  public static final b a = new b();
  
  EventDispatcher$b()
  {
    super(1);
  }
  
  public final void a(@NotNull e.b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "it");
    paramb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.internal.EventDispatcher.b
 * JD-Core Version:    0.7.0.1
 */