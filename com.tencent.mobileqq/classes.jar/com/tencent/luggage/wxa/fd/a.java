package com.tencent.luggage.wxa.fd;

import com.tencent.luggage.wxa.fi.a.b;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.ka.e;
import com.tencent.luggage.wxa.ka.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/auth/JsApiAuthorizeWithTransferAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorizeLU;", "()V", "unhandledCgiException", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "e", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
  extends h
{
  public boolean a(@Nullable b paramb, @Nullable JSONObject paramJSONObject, int paramInt, @Nullable e parame, @Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramb != null)
    {
      bool1 = bool2;
      if ((paramObject instanceof com.tencent.luggage.wxa.dc.d))
      {
        com.tencent.luggage.wxa.fi.a locala = com.tencent.luggage.wxa.fi.a.a;
        String str = d();
        Intrinsics.checkExpressionValueIsNotNull(str, "this.name");
        if (paramJSONObject != null) {
          paramJSONObject = paramJSONObject.toString();
        } else {
          paramJSONObject = null;
        }
        locala.a(new com.tencent.luggage.wxa.oo.d(paramb, str, paramJSONObject, paramInt), (a.b)new a.a(this, paramb, paramInt, parame), paramObject);
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fd.a
 * JD-Core Version:    0.7.0.1
 */