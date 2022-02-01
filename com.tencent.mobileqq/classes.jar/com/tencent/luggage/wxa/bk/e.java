package com.tencent.luggage.wxa.bk;

import android.content.Context;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/game/boot/MagicBrushForMiniGame;", "Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "context", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "shouldEnableCommandBuffer", "", "shouldEnableGfx", "cmdPoolTypeEnabled", "", "shouldRevertCpuOptimizerTest", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;ZZIZ)V", "onConfig", "", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "luggage-wxa-game-ext_release"}, k=1, mv={1, 1, 16})
public class e
  extends g
{
  private final boolean a;
  private final boolean b;
  private final int c;
  private final boolean d;
  
  public e(@NotNull Context paramContext, @NotNull i parami, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    super(paramContext, parami);
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramInt;
    this.d = paramBoolean3;
  }
  
  protected void a(@NotNull com.tencent.magicbrush.f paramf)
  {
    Intrinsics.checkParameterIsNotNull(paramf, "builder");
    super.a(paramf);
    paramf.e(false);
    paramf.a(this.a);
    paramf.b(this.b);
    paramf.c(this.c);
    paramf.h(true);
    paramf.g(this.d);
    paramf.c(com.tencent.luggage.wxa.hg.f.b("mmbox2d"));
    paramf.d(com.tencent.luggage.wxa.hg.f.b("mmphysx"));
    o.d("MicroMsg.MagicBrush", "find phys so path: %s %s", new Object[] { paramf.q(), paramf.r() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bk.e
 * JD-Core Version:    0.7.0.1
 */