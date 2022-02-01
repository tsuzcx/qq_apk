package com.tencent.luggage.wxa.lj;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.jx.ab;
import com.tencent.luggage.wxa.lk.c.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiWriteNdefMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public final class o
  extends com.tencent.luggage.wxa.jx.a<com.tencent.luggage.wxa.jx.c>
{
  public static final int CTRL_INDEX = 793;
  @NotNull
  public static final String NAME = "writeNdefMessage";
  public static final o.a a = new o.a(null);
  
  public void a(@Nullable com.tencent.luggage.wxa.jx.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if (paramc == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, env is null");
      return;
    }
    if (paramJSONObject == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, data is null");
      paramc.a(paramInt, a("fail:invalid parameter", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13011)) })));
      return;
    }
    Object localObject1 = (ab)e.a(ab.class);
    if ((localObject1 != null) && (!((ab)localObject1).a()))
    {
      paramc.a(paramInt, a("fail:user is not authorized", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13019)) })));
      return;
    }
    com.tencent.luggage.wxa.lk.c localc = com.tencent.luggage.wxa.lk.c.a.a(paramc);
    if (localc == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, can not get activity");
      paramc.a(paramInt, a("fail:unknown", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13010)) })));
      return;
    }
    Function1 localFunction1 = (Function1)new o.b(this, paramc, paramInt);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("invoke, appId: ");
    ((StringBuilder)localObject1).append(paramc.getAppId());
    ((StringBuilder)localObject1).append(", data: ");
    ((StringBuilder)localObject1).append(paramJSONObject);
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrand.JsApiWriteNdefMessage", ((StringBuilder)localObject1).toString());
    boolean bool = paramJSONObject.has("uris");
    localObject1 = "get(index)";
    int j;
    int i;
    Object localObject2;
    if (bool) {
      try
      {
        paramJSONObject = paramJSONObject.get("uris");
        if (paramJSONObject != null)
        {
          paramJSONObject = (JSONArray)paramJSONObject;
          localObject1 = (Collection)new ArrayList(paramJSONObject.length());
          j = paramJSONObject.length();
          i = 0;
          while (i < j)
          {
            localObject2 = paramJSONObject.get(i);
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "get(index)");
            ((Collection)localObject1).add(localObject2.toString());
            i += 1;
          }
          paramJSONObject = (List)localObject1;
          paramJSONObject = com.tencent.luggage.wxa.ll.c.a.b(paramJSONObject);
          if (paramJSONObject == null)
          {
            paramc.a(paramInt, a("fail:parse NdefMessage failed", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13012)) })));
            return;
          }
          localc.a(paramJSONObject, localFunction1);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONArray");
      }
      catch (Exception paramJSONObject)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parse uris failed since ");
        ((StringBuilder)localObject1).append(paramJSONObject);
        com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrand.JsApiWriteNdefMessage", ((StringBuilder)localObject1).toString());
        paramc.a(paramInt, a("fail:invalid parameter", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13011)) })));
        return;
      }
    }
    if (paramJSONObject.has("texts")) {
      try
      {
        paramJSONObject = paramJSONObject.get("texts");
        if (paramJSONObject != null)
        {
          localObject2 = (JSONArray)paramJSONObject;
          Collection localCollection = (Collection)new ArrayList(((JSONArray)localObject2).length());
          i = ((JSONArray)localObject2).length();
          j = 0;
          paramJSONObject = (JSONObject)localObject1;
          localObject1 = localObject2;
          while (j < i)
          {
            Object localObject3 = ((JSONArray)localObject1).get(j);
            Intrinsics.checkExpressionValueIsNotNull(localObject3, paramJSONObject);
            localObject2 = localObject3;
            if (!(localObject3 instanceof JSONObject)) {
              localObject2 = null;
            }
            localObject2 = (JSONObject)localObject2;
            if (localObject2 == null)
            {
              com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse texts failed since convert jsonObject failed");
              paramc.a(paramInt, a("fail:invalid parameter", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13011)) })));
              return;
            }
            HashMap localHashMap = new HashMap();
            localObject3 = ((JSONObject)localObject2).keys();
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "keys()");
            while (((Iterator)localObject3).hasNext())
            {
              String str = (String)((Iterator)localObject3).next();
              Map localMap = (Map)localHashMap;
              Intrinsics.checkExpressionValueIsNotNull(str, "it");
              Object localObject4 = ((JSONObject)localObject2).get(str);
              Intrinsics.checkExpressionValueIsNotNull(localObject4, "get(it)");
              localMap.put(str, localObject4.toString());
            }
            localCollection.add((Map)localHashMap);
            j += 1;
          }
          paramJSONObject = (List)localCollection;
          paramJSONObject = com.tencent.luggage.wxa.ll.c.a.c(paramJSONObject);
          if (paramJSONObject == null)
          {
            paramc.a(paramInt, a("fail:parse NdefMessage failed", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13012)) })));
            return;
          }
          localc.a(paramJSONObject, localFunction1);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONArray");
      }
      catch (Exception paramJSONObject)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parse texts failed since ");
        ((StringBuilder)localObject1).append(paramJSONObject);
        com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrand.JsApiWriteNdefMessage", ((StringBuilder)localObject1).toString());
        paramc.a(paramInt, a("fail:invalid parameter", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13011)) })));
        return;
      }
    }
    paramJSONObject = com.tencent.luggage.wxa.lm.a.a(paramJSONObject, (Function1)o.c.a);
    paramJSONObject = com.tencent.luggage.wxa.ll.c.a.a(paramJSONObject);
    if (paramJSONObject == null)
    {
      paramc.a(paramInt, a("fail:parse NdefMessage failed", (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(13012)) })));
      return;
    }
    localc.a(paramJSONObject, localFunction1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lj.o
 * JD-Core Version:    0.7.0.1
 */