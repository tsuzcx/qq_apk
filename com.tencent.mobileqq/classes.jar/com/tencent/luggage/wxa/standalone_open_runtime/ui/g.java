package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/WxaScreenAdaptiveContextThemeWrapper;", "Lcom/tencent/mm/ui/base/ScreenAdaptiveContextThemeWrapper;", "base", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getResourcesInstance", "Landroid/content/res/Resources;", "originalResources", "WxaAdaptiveResources", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class g
  extends k
{
  public g(@NotNull Context paramContext)
  {
    super(paramContext, a());
  }
  
  @NotNull
  public Resources a(@NotNull Resources paramResources)
  {
    Intrinsics.checkParameterIsNotNull(paramResources, "originalResources");
    DisplayMetrics localDisplayMetrics = paramResources.getDisplayMetrics();
    Intrinsics.checkExpressionValueIsNotNull(localDisplayMetrics, "originalResources.displayMetrics");
    Configuration localConfiguration = paramResources.getConfiguration();
    Intrinsics.checkExpressionValueIsNotNull(localConfiguration, "originalResources.configuration");
    k.a locala = a();
    Intrinsics.checkExpressionValueIsNotNull(locala, "DEFAULT_FACTORY");
    return (Resources)new g.a(paramResources, localDisplayMetrics, localConfiguration, locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.g
 * JD-Core Version:    0.7.0.1
 */