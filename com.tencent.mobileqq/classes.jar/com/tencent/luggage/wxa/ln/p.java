package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jx.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiRewriteRoute;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class p
  extends a<b>
{
  public static final int CTRL_INDEX = -2;
  @NotNull
  public static final String NAME = "rewriteRoute";
  @Deprecated
  public static final p.a a = new p.a(null);
  
  public void a(@Nullable b paramb, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if (paramb != null)
    {
      if (paramJSONObject != null) {
        paramJSONObject = paramJSONObject.optString("url");
      } else {
        paramJSONObject = null;
      }
      CharSequence localCharSequence = (CharSequence)paramJSONObject;
      int i;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        paramb.a(paramInt, b("fail:invalid data"));
        return;
      }
      paramb.a((Runnable)new p.b(this, paramb, paramJSONObject, paramInt));
    }
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.p
 * JD-Core Version:    0.7.0.1
 */