package com.tencent.luggage.wxa.kf;

import android.util.Base64;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.kj.f;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiMakeBluetoothPair;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class j
  extends com.tencent.luggage.wxa.jx.a<c>
{
  public static final int CTRL_INDEX = 815;
  @NotNull
  public static final String NAME = "makeBluetoothPair";
  public static final j.a a = new j.a(null);
  
  public void a(@Nullable c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if (paramc == null)
    {
      com.tencent.luggage.wxa.kn.a.b("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "env is null", new Object[0]);
      return;
    }
    if ((paramJSONObject != null) && (paramJSONObject.has("deviceId")))
    {
      String str1 = paramc.getAppId();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("appId: ");
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append(", data: ");
      ((StringBuilder)localObject1).append(paramJSONObject);
      com.tencent.luggage.wxa.kn.a.c("MicroMsg.AppBrand.JsApiMakeBluetoothPair", ((StringBuilder)localObject1).toString(), new Object[0]);
      com.tencent.luggage.wxa.ke.b localb = com.tencent.luggage.wxa.ke.a.a(str1);
      if (localb == null)
      {
        com.tencent.luggage.wxa.kn.a.b("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "bleWorker is null", new Object[0]);
        paramc.a(paramInt, a("fail:not init", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(10000)) })));
        return;
      }
      Object localObject2 = null;
      String str2 = paramJSONObject.optString("deviceId", null);
      if (str2 == null)
      {
        com.tencent.luggage.wxa.kn.a.b("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "deviceId is null", new Object[0]);
        paramc.a(paramInt, a("fail:invalid data", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(10013)) })));
        return;
      }
      localObject1 = paramJSONObject.optString("pin", null);
      if (localObject1 == null) {
        localObject1 = null;
      }
      try
      {
        localObject1 = Base64.decode((String)localObject1, 2);
        long l = paramJSONObject.optLong("timeout", 20000L);
        boolean bool = paramJSONObject.optBoolean("forcePair", false);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("deviceId: ");
        localStringBuilder.append(str2);
        localStringBuilder.append(", pin: ");
        paramJSONObject = localObject2;
        if (localObject1 != null)
        {
          paramJSONObject = Arrays.toString((byte[])localObject1);
          Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "java.util.Arrays.toString(this)");
        }
        localStringBuilder.append(paramJSONObject);
        localStringBuilder.append(", timeoutMs: ");
        localStringBuilder.append(l);
        localStringBuilder.append(", forcePair: ");
        localStringBuilder.append(bool);
        com.tencent.luggage.wxa.kn.a.c("MicroMsg.AppBrand.JsApiMakeBluetoothPair", localStringBuilder.toString(), new Object[0]);
        localb.a(str2, (com.tencent.luggage.wxa.kl.a)new f(str2, (byte[])localObject1, l, bool), (com.tencent.luggage.wxa.kl.b)new j.b(this, str1, paramInt, paramc));
        return;
      }
      catch (Exception paramJSONObject)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("decode pin fail since ");
        ((StringBuilder)localObject1).append(paramJSONObject.toString());
        com.tencent.luggage.wxa.kn.a.b("MicroMsg.AppBrand.JsApiMakeBluetoothPair", ((StringBuilder)localObject1).toString(), new Object[0]);
        paramc.a(paramInt, a("fail:invalid data", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(10013)) })));
        return;
      }
    }
    com.tencent.luggage.wxa.kn.a.b("MicroMsg.AppBrand.JsApiMakeBluetoothPair", "data is null or do not have key: deviceId", new Object[0]);
    paramc.a(paramInt, a("fail:invalid data", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(10013)) })));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.j
 * JD-Core Version:    0.7.0.1
 */