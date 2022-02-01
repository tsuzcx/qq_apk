package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.fx.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"CAST_BUTTON_CLICKED", "", "CAST_BUTTON_SHOW", "CAST_URL_CHANGE", "DEVICE_BUTTON_CLICKED", "EXIT_BUTTON_CLICKED", "HELP_BUTTON_CLICKED", "RECONNECT_BUTTON_CLICKED", "SWITCH_BUTTON_CLICKED", "getAppBrandRuntime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "luggage-xweb-ext_release"}, k=2, mv={1, 1, 16})
public final class d
{
  @NotNull
  public static final com.tencent.luggage.wxa.iu.d a(@NotNull a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "$this$getAppBrandRuntime");
    if ((parama instanceof com.tencent.luggage.wxa.ju.b))
    {
      parama = ((com.tencent.luggage.wxa.ju.b)parama).g();
      if ((parama instanceof com.tencent.luggage.wxa.iu.b))
      {
        parama = ((com.tencent.luggage.wxa.iu.b)parama).q();
        Intrinsics.checkExpressionValueIsNotNull(parama, "component.runtime");
        return parama;
      }
      throw ((Throwable)new IllegalStateException("Check failed.".toString()));
    }
    throw ((Throwable)new IllegalStateException("Check failed.".toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.d
 * JD-Core Version:    0.7.0.1
 */