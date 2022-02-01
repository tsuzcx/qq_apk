package com.tencent.luggage.wxa.bk;

import com.tencent.magicbrush.e;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.k;
import com.tencent.mm.plugin.appbrand.jsruntime.w;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/game/boot/BufferURLLogic;", "", "()V", "bind", "", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "jsruntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "luggage-wxa-game-ext_release"}, k=1, mv={1, 1, 16})
public final class a
{
  public static final a a = new a();
  
  @JvmStatic
  public static final void a(@NotNull e parame, @NotNull i parami)
  {
    Intrinsics.checkParameterIsNotNull(parame, "magicbrush");
    Intrinsics.checkParameterIsNotNull(parami, "jsruntime");
    parami = parami.a(k.class);
    if (parami == null) {
      Intrinsics.throwNpe();
    }
    ((k)parami).a((w)new b(parame.q()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bk.a
 * JD-Core Version:    0.7.0.1
 */