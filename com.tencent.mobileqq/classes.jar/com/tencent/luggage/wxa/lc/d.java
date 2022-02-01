package com.tencent.luggage.wxa.lc;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "SubscribeMsgTask", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class d
  extends a<com.tencent.luggage.wxa.du.c>
{
  public static final int CTRL_INDEX = 640;
  @NotNull
  public static final String NAME = "requestSubscribeMessage";
  public static final d.a a = new d.a(null);
  
  public void a(@Nullable com.tencent.luggage.wxa.du.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    o.d("JsApiRequestSubscribeMessage", "JsApiRequestSubscribeMessage invoked");
    if (paramJSONObject == null)
    {
      if (paramc == null) {
        Intrinsics.throwNpe();
      }
      paramc.a(paramInt, b("fail:invalid data"));
      return;
    }
    Object localObject1 = paramJSONObject.getJSONArray("tmplIds");
    paramJSONObject = (List)new ArrayList();
    if (((JSONArray)localObject1).length() == 0)
    {
      paramJSONObject = a;
      if (paramc == null) {
        Intrinsics.throwNpe();
      }
      d.a.a(paramJSONObject, paramc, this, paramInt, "fail:TmplIds can't be empty", null, 10001, 16, null);
      return;
    }
    int i = 0;
    try
    {
      int j = ((JSONArray)localObject1).length();
      while (i < j)
      {
        localObject2 = ((JSONArray)localObject1).get(i);
        if (!(localObject2 instanceof String))
        {
          paramJSONObject = a;
          if (paramc == null) {
            Intrinsics.throwNpe();
          }
          d.a.a(paramJSONObject, paramc, this, paramInt, "fail:Invalid template id", null, 10004, 16, null);
          return;
        }
        paramJSONObject.add(localObject2);
        i += 1;
      }
      if (paramc == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = paramc.i();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "env!!.runtime");
      localObject1 = ((com.tencent.luggage.wxa.ed.d)localObject1).j().b;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "env!!.runtime.initConfig.username");
      Object localObject2 = paramc.i();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "env!!.runtime");
      localObject2 = ((com.tencent.luggage.wxa.ed.d)localObject2).j().D;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "env!!.runtime.initConfig.appId");
      com.tencent.luggage.wxa.ed.d locald = paramc.i();
      Intrinsics.checkExpressionValueIsNotNull(locald, "env!!.runtime");
      paramJSONObject = new d.b((String)localObject1, (String)localObject2, locald.j().c, paramJSONObject, 0, this, paramc, paramInt);
      paramJSONObject.d();
      paramJSONObject.g();
      return;
    }
    catch (JSONException paramJSONObject)
    {
      label279:
      break label279;
    }
    if (paramc == null) {
      Intrinsics.throwNpe();
    }
    paramc.a(paramInt, b("fail:invalid data"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lc.d
 * JD-Core Version:    0.7.0.1
 */