package com.tencent.luggage.wxa.ca;

import com.tencent.luggage.wxa.qz.af;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/ad/JsApiAdDataReport;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "component", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b
  extends com.tencent.luggage.wxa.jx.a<com.tencent.luggage.wxa.iu.b>
{
  public static final int CTRL_INDEX = 435;
  @NotNull
  public static final String NAME = "adDataReport";
  public static final b.a a = new b.a(null);
  
  public void a(@NotNull com.tencent.luggage.wxa.iu.b paramb, @NotNull JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "component");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "data");
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = paramb.q();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((com.tencent.luggage.wxa.iu.d)localObject1).B();
    } else {
      localObject1 = null;
    }
    if ((localObject1 instanceof com.tencent.luggage.wxa.do.c))
    {
      com.tencent.luggage.wxa.iu.d locald = paramb.q();
      localObject1 = localObject2;
      if (locald != null) {
        localObject1 = locald.B();
      }
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.luggage.wxa.do.c)localObject1).f();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "(component?.runtime?.ini…dInitConfigLU).statObject");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(String.valueOf(((com.tencent.luggage.wxa.ou.d)localObject1).c));
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append(((com.tencent.luggage.wxa.ou.d)localObject1).d);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append(((com.tencent.luggage.wxa.ou.d)localObject1).a);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append(((com.tencent.luggage.wxa.ou.d)localObject1).b);
        ((StringBuilder)localObject2).append(",");
        localStringBuilder.append(((StringBuilder)localObject2).toString());
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.luggage.sdk.config.AppBrandInitConfigLU");
      }
    }
    localStringBuilder.append(paramJSONObject.optString("adInfo"));
    paramJSONObject = new StringBuilder();
    paramJSONObject.append(",");
    paramJSONObject.append(com.tencent.luggage.wxa.hd.c.a(false));
    localStringBuilder.append(paramJSONObject.toString());
    paramJSONObject = paramb.getAppId();
    Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "component.appId");
    localObject1 = com.tencent.luggage.wxa.dg.d.a.d();
    localObject2 = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "reportStr.toString()");
    a.a(paramJSONObject, (String)localObject1, 15175, (String)localObject2, af.a()).a((com.tencent.luggage.wxa.rl.b)new b.b(this, paramb, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ca.b
 * JD-Core Version:    0.7.0.1
 */