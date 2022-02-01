package com.tencent.luggage.util;

import android.content.Context;
import com.tencent.luggage.ui.WxaSimpleWebViewActivity;
import com.tencent.luggage.ui.WxaSimpleWebViewActivity.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.ng.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/util/WxaOpenUrlHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IOpenUrlHelper;", "()V", "openUrl", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "url", "", "context", "Landroid/content/Context;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class o
  implements b
{
  public void a(@NotNull c paramc, @NotNull String paramString, @NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "component");
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    WxaSimpleWebViewActivity.a.a(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.o
 * JD-Core Version:    0.7.0.1
 */