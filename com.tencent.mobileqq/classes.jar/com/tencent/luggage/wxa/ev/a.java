package com.tencent.luggage.wxa.ev;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.mm.plugin.appbrand.page.u;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/standalone_ext/xweb/LuggageXWebNativeTransInitLogic;", "", "()V", "isServiceOpen", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "isWebViewOpen", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a
{
  public static final a a = new a();
  
  @JvmStatic
  public static final boolean a(@NotNull h paramh)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "component");
    return com.tencent.luggage.wxa.qc.a.a((b)paramh);
  }
  
  @JvmStatic
  public static final boolean a(@NotNull u paramu)
  {
    Intrinsics.checkParameterIsNotNull(paramu, "component");
    if (com.tencent.luggage.wxa.qc.a.a((b)paramu))
    {
      paramu = com.tencent.luggage.wxa.qc.a.b();
      Intrinsics.checkExpressionValueIsNotNull(paramu, "XWebNativeTransInitLogic.isWebMatch()");
      if (paramu.booleanValue()) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ev.a
 * JD-Core Version:    0.7.0.1
 */