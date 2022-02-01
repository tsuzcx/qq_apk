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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStopNFCDiscovery;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public final class n
  extends a<com.tencent.luggage.wxa.jx.c>
{
  public static final int CTRL_INDEX = 794;
  @NotNull
  public static final String NAME = "stopNFCDiscovery";
  public static final n.a a = new n.a(null);
  
  public void a(@Nullable com.tencent.luggage.wxa.jx.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if (paramc == null) {
      return;
    }
    paramJSONObject = (ab)e.a(ab.class);
    if ((paramJSONObject != null) && (!paramJSONObject.a()))
    {
      paramc.a(paramInt, a("fail:user is not authorized", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13019)) })));
      return;
    }
    paramJSONObject = com.tencent.luggage.wxa.lk.c.a.a(paramc);
    if (paramJSONObject == null)
    {
      o.c("MicroMsg.AppBrand.JsApiStopNFCDiscovery", "invoke, can not get activity");
      paramc.a(paramInt, a("fail:unknown", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13010)) })));
      return;
    }
    paramJSONObject.b((Function1)new n.b(this, paramc, paramInt, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lj.n
 * JD-Core Version:    0.7.0.1
 */