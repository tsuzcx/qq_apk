package com.tencent.luggage.wxa.lj;

import com.tencent.luggage.wxa.jx.ab;
import com.tencent.luggage.wxa.lk.c.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCConnectClose;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "function", "Lkotlin/Function3;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/ConnectClosePrototype;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)V", "invoke", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public abstract class a
  extends com.tencent.luggage.wxa.jx.a<com.tencent.luggage.wxa.jx.c>
{
  public static final a.a a = new a.a(null);
  private final Function3<com.tencent.luggage.wxa.lk.c, String, Function1<? super com.tencent.luggage.wxa.lk.e<Unit>, Unit>, Unit> b;
  
  public a(@NotNull Function3<? super com.tencent.luggage.wxa.lk.c, ? super String, ? super Function1<? super com.tencent.luggage.wxa.lk.e<Unit>, Unit>, Unit> paramFunction3)
  {
    this.b = paramFunction3;
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.jx.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if (paramc == null)
    {
      o.c("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, env is null");
      return;
    }
    if (paramJSONObject == null)
    {
      o.c("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, data is null");
      paramc.a(paramInt, a("fail:invalid parameter", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13011)) })));
      return;
    }
    Object localObject1 = (ab)com.tencent.luggage.wxa.ba.e.a(ab.class);
    if ((localObject1 != null) && (!((ab)localObject1).a()))
    {
      paramc.a(paramInt, a("fail:user is not authorized", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13019)) })));
      return;
    }
    localObject1 = com.tencent.luggage.wxa.lk.c.a.a(paramc);
    if (localObject1 == null)
    {
      o.c("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, can not get activity");
      paramc.a(paramInt, a("fail:unknown", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13010)) })));
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("invoke, appId: ");
    ((StringBuilder)localObject2).append(paramc.getAppId());
    ((StringBuilder)localObject2).append(", data: ");
    ((StringBuilder)localObject2).append(paramJSONObject);
    o.e("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", ((StringBuilder)localObject2).toString());
    try
    {
      paramJSONObject = paramJSONObject.getString("tech");
      localObject2 = this.b;
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "tech");
      ((Function3)localObject2).invoke(localObject1, paramJSONObject, new a.b(this, paramc, paramInt));
      return;
    }
    catch (Exception paramJSONObject)
    {
      label278:
      break label278;
    }
    o.c("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "parse tech failed");
    paramc.a(paramInt, a("fail:invalid parameter", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13011)) })));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lj.a
 * JD-Core Version:    0.7.0.1
 */