package com.tencent.luggage.wxa.lx;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetSystemInfoAsync;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class j
  extends a<b>
{
  private static final int CTRL_INDEX = 919;
  private static final String NAME = "getSystemInfoAsync";
  @Deprecated
  public static final j.a a = new j.a(null);
  
  public void a(@Nullable b paramb, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    Object localObject = null;
    if (paramb != null) {
      paramJSONObject = paramb.d("getSystemInfo");
    } else {
      paramJSONObject = null;
    }
    if (!(paramJSONObject instanceof i)) {
      paramJSONObject = localObject;
    }
    paramJSONObject = (i)paramJSONObject;
    if (paramJSONObject != null)
    {
      paramb.a(paramInt, a("ok", paramJSONObject.a((c)paramb)));
      return;
    }
    ((Function0)new j.b(this, paramb, paramInt)).invoke();
  }
  
  protected boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.j
 * JD-Core Version:    0.7.0.1
 */