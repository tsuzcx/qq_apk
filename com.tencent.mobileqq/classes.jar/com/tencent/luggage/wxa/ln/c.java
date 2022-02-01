package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.bd;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiHideHomeButton;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app-jsapi_release"}, k=1, mv={1, 1, 16})
public final class c
  extends a<b>
{
  public static final int CTRL_INDEX = 684;
  @NotNull
  public static final String NAME = "hideHomeButton";
  @Deprecated
  public static final c.a a = new c.a(null);
  
  public void a(@Nullable b paramb, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = bd.a((com.tencent.luggage.wxa.jx.c)paramb);
    if (paramJSONObject == null)
    {
      if (paramb == null) {
        Intrinsics.throwNpe();
      }
      paramb.a(paramInt, b("fail:page don't exist"));
      return;
    }
    f.a.a((Runnable)new c.b(this, paramJSONObject, paramb, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.c
 * JD-Core Version:    0.7.0.1
 */