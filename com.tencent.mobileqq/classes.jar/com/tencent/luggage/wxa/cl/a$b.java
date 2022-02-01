package com.tencent.luggage.wxa.cl;

import com.tencent.luggage.wxa.cx.r;
import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.la.h;
import com.tencent.luggage.wxa.nn.a;
import com.tencent.luggage.wxa.ro.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/jsapi/miniprogram_navigator/JsApiNavigateToMiniProgramStandalone$Companion$NAVIGATOR$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigator;", "prepareInitConfig", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "kotlin.jvm.PlatformType", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "params", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "navigateInvokeParams", "Lorg/json/JSONObject;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a$b
  extends h
{
  public d<c> a(@NotNull com.tencent.luggage.wxa.iu.b paramb, @NotNull a parama, @NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "component");
    Intrinsics.checkParameterIsNotNull(parama, "params");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "navigateInvokeParams");
    return new r(parama).a().b((com.tencent.luggage.wxa.rl.b)new a.b.a(this, parama)).b((com.tencent.luggage.wxa.rl.b)new a.b.b(parama, paramb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cl.a.b
 * JD-Core Version:    0.7.0.1
 */