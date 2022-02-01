package com.tencent.luggage.wxa.ln;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiPageInitReadyForPreRender;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandSyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class m
  extends com.tencent.luggage.wxa.jx.u<com.tencent.mm.plugin.appbrand.page.u>
{
  public static final int CTRL_INDEX = -2;
  @NotNull
  public static final String NAME = "initReadyForPrerender";
  @Deprecated
  public static final m.a a = new m.a(null);
  
  @NotNull
  public String a(@Nullable com.tencent.mm.plugin.appbrand.page.u paramu, @Nullable JSONObject paramJSONObject)
  {
    if (paramu != null) {
      paramu.f("initReadyForPrerender");
    }
    paramu = b("ok");
    Intrinsics.checkExpressionValueIsNotNull(paramu, "makeReturnJson(\"ok\")");
    return paramu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.m
 * JD-Core Version:    0.7.0.1
 */