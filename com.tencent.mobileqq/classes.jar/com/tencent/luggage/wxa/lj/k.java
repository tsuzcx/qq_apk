package com.tencent.luggage.wxa.lj;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.ab;
import com.tencent.luggage.wxa.lk.c.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCSetTimeout;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public final class k
  extends a<com.tencent.luggage.wxa.jx.c>
{
  public static final int CTRL_INDEX = 814;
  @NotNull
  public static final String NAME = "NFCSetTimeout";
  public static final k.a a = new k.a(null);
  
  public void a(@Nullable com.tencent.luggage.wxa.jx.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if (paramc == null)
    {
      o.c("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, env is null");
      return;
    }
    if (paramJSONObject == null)
    {
      o.c("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, data is null");
      paramc.a(paramInt, a("fail:invalid parameter", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13011)) })));
      return;
    }
    Object localObject1 = (ab)e.a(ab.class);
    if ((localObject1 != null) && (!((ab)localObject1).a()))
    {
      paramc.a(paramInt, a("fail:user is not authorized", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13019)) })));
      return;
    }
    localObject1 = com.tencent.luggage.wxa.lk.c.a.a(paramc);
    if (localObject1 == null)
    {
      o.c("MicroMsg.AppBrand.JsApiNFCSetTimeout", "invoke, can not get activity");
      paramc.a(paramInt, a("fail:unknown", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13010)) })));
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("invoke, appId: ");
    ((StringBuilder)localObject2).append(paramc.getAppId());
    ((StringBuilder)localObject2).append(", data: ");
    ((StringBuilder)localObject2).append(paramJSONObject);
    o.e("MicroMsg.AppBrand.JsApiNFCSetTimeout", ((StringBuilder)localObject2).toString());
    try
    {
      localObject2 = paramJSONObject.getString("tech");
    }
    catch (Exception paramJSONObject)
    {
      int i;
      label283:
      break label328;
    }
    try
    {
      i = paramJSONObject.getInt("timeout");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "tech");
      ((com.tencent.luggage.wxa.lk.c)localObject1).a((String)localObject2, i, (Function1)new k.b(this, paramc, paramInt));
      return;
    }
    catch (Exception paramJSONObject)
    {
      break label283;
    }
    o.c("MicroMsg.AppBrand.JsApiNFCSetTimeout", "parse timeout failed");
    paramc.a(paramInt, a("fail:invalid parameter", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13011)) })));
    return;
    label328:
    o.c("MicroMsg.AppBrand.JsApiNFCSetTimeout", "parse tech failed");
    paramc.a(paramInt, a("fail:invalid parameter", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13011)) })));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lj.k
 * JD-Core Version:    0.7.0.1
 */