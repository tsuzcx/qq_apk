package com.tencent.luggage.wxa.bk;

import android.content.Context;
import com.tencent.luggage.wxa.bl.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/game/boot/MagicBrushForMiniProgram;", "Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "context", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;)V", "onAppBrandRuntimeReady", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onConfig", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "luggage-wxa-game-ext_release"}, k=1, mv={1, 1, 16})
public class f
  extends g
{
  public f(@NotNull Context paramContext, @NotNull i parami)
  {
    super(paramContext, parami);
  }
  
  protected void a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "runtime");
    b.a.a((MBRuntime)b(), paramd, false);
    Object localObject = paramd.A();
    if (localObject != null)
    {
      localObject = ((l)localObject).S;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.appbrand.appcache.af)localObject).md5;
        break label49;
      }
    }
    localObject = null;
    label49:
    if (!com.tencent.luggage.wxa.qz.af.c((String)localObject))
    {
      b().a(paramd.aa(), (String)localObject);
      return;
    }
    o.b("MicroMsg.MagicBrush", "onAppBrandRuntimeReady pkg md5 is null!!!");
  }
  
  protected void a(@NotNull com.tencent.magicbrush.f paramf)
  {
    Intrinsics.checkParameterIsNotNull(paramf, "builder");
    super.a(paramf);
    paramf.e(true);
    paramf.d(false);
    paramf.a(a.b.b);
    paramf.f(false);
    paramf.a(false);
    paramf.c(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bk.f
 * JD-Core Version:    0.7.0.1
 */