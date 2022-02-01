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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCGetMaxTransceiveLength;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public final class i
  extends a<com.tencent.luggage.wxa.jx.c>
{
  public static final int CTRL_INDEX = 791;
  @NotNull
  public static final String NAME = "NFCGetMaxTransceiveLength";
  public static final i.a a = new i.a(null);
  
  public void a(@Nullable com.tencent.luggage.wxa.jx.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if (paramc == null)
    {
      o.c("MicroMsg.AppBrand.JsApiNFCGetMaxTransceiveLength", "invoke, env is null");
      return;
    }
    if (paramJSONObject == null)
    {
      o.c("MicroMsg.AppBrand.JsApiNFCGetMaxTransceiveLength", "invoke, data is null");
      paramc.a(paramInt, a("fail:invalid parameter", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13011)) })));
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
      o.c("MicroMsg.AppBrand.JsApiNFCGetMaxTransceiveLength", "invoke, can not get activity");
      paramc.a(paramInt, a("fail:unknown", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13010)) })));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invoke, appId: ");
    localStringBuilder.append(paramc.getAppId());
    localStringBuilder.append(", data: ");
    localStringBuilder.append(paramJSONObject);
    o.d("MicroMsg.AppBrand.JsApiNFCGetMaxTransceiveLength", localStringBuilder.toString());
    try
    {
      paramJSONObject = paramJSONObject.getString("tech");
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "tech");
      ((com.tencent.luggage.wxa.lk.c)localObject).d(paramJSONObject, (Function1)new i.b(this, paramc, paramInt));
      return;
    }
    catch (Exception paramJSONObject)
    {
      label270:
      break label270;
    }
    o.c("MicroMsg.AppBrand.JsApiNFCGetMaxTransceiveLength", "parse tech failed");
    paramc.a(paramInt, a("fail:invalid parameter", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13011)) })));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lj.i
 * JD-Core Version:    0.7.0.1
 */