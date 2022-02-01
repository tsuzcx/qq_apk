package com.tencent.luggage.wxa.lj;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.ab;
import com.tencent.luggage.wxa.li.d;
import com.tencent.luggage.wxa.lk.c.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStartNFCDiscovery;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "onNFCDiscoveredEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "getOnNFCDiscoveredEvent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "onNFCDiscoveredEvent$delegate", "Lkotlin/Lazy;", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public final class m
  extends a<com.tencent.luggage.wxa.jx.c>
{
  public static final int CTRL_INDEX = 789;
  @NotNull
  public static final String NAME = "startNFCDiscovery";
  public static final m.a a = new m.a(null);
  private final Lazy b = LazyKt.lazy((Function0)m.c.a);
  
  private final c c()
  {
    return (c)this.b.getValue();
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.jx.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if (paramc == null) {
      return;
    }
    if (!d.d())
    {
      paramc.a(paramInt, a("fail:system NFC switch not opened", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13001)) })));
      return;
    }
    Object localObject = (ab)e.a(ab.class);
    if ((localObject != null) && (!((ab)localObject).a()))
    {
      paramc.a(paramInt, a("fail:user is not authorized", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13019)) })));
      return;
    }
    localObject = com.tencent.luggage.wxa.lk.c.a.a(paramc);
    if (localObject == null)
    {
      o.c("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "invoke, can not get activity");
      paramc.a(paramInt, a("fail:unknown", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13010)) })));
      return;
    }
    if (paramJSONObject != null) {}
    try
    {
      ((com.tencent.luggage.wxa.lk.c)localObject).a(paramJSONObject.getBoolean("requireForegroundDispatch"));
    }
    catch (Exception paramJSONObject)
    {
      label189:
      break label189;
    }
    o.e("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "parse requireForegroundDispatch failed");
    ((com.tencent.luggage.wxa.lk.c)localObject).a((Function1)new m.b(this, paramc, paramInt, (com.tencent.luggage.wxa.lk.c)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lj.m
 * JD-Core Version:    0.7.0.1
 */