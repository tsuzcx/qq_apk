package com.tencent.luggage.wxa.ls;

import com.tencent.mm.plugin.appbrand.page.u;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/rendering_cache/JsApiSaveInitialRenderingCache;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
  extends com.tencent.luggage.wxa.jx.a<u>
{
  public static final int CTRL_INDEX = -2;
  @NotNull
  public static final String NAME = "saveInitialRenderingCache";
  @Deprecated
  public static final b.a a = new b.a(null);
  
  public void a(@Nullable u paramu, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.luggage.wxa.ol.a locala;
    if (paramu != null) {
      locala = (com.tencent.luggage.wxa.ol.a)paramu.a(com.tencent.luggage.wxa.ol.a.class);
    } else {
      locala = null;
    }
    String str;
    if (locala != null) {
      if (paramJSONObject != null) {
        str = paramJSONObject.optString("path", paramu.an());
      }
    }
    try
    {
      paramJSONObject = new Triple(paramJSONObject.getString("content"), paramJSONObject.optString("webviewData", null), paramJSONObject.optString("appserviceData", null));
      locala.a(str, (String)paramJSONObject.component1(), (String)paramJSONObject.component2(), (String)paramJSONObject.component3());
      paramu.a(paramInt, b("ok"));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      label112:
      break label112;
    }
    paramu.a(paramInt, b("fail:invalid data"));
    return;
    ((Function0)new b.c(this, paramu, paramInt)).invoke();
    return;
    ((Function0)new b.b(this, paramu, paramInt)).invoke();
  }
  
  protected boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ls.b
 * JD-Core Version:    0.7.0.1
 */