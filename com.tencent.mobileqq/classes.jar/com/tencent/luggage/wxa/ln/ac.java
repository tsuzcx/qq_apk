package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.mm.plugin.appbrand.page.u;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiShowNavigationBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app-jsapi_release"}, k=1, mv={1, 1, 16})
public final class ac
  extends a<b>
{
  public static final int CTRL_INDEX = 577;
  @NotNull
  public static final String NAME = "showNavigationBar";
  @Deprecated
  public static final ac.a a = new ac.a(null);
  
  public void a(@Nullable b paramb, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if (paramb != null)
    {
      paramJSONObject = (Runnable)new ac.b(this, paramb, paramInt);
      if ((!(paramb instanceof u)) && (paramb.q().F()))
      {
        paramb.q().c(paramJSONObject);
        return;
      }
      paramJSONObject.run();
    }
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.ac
 * JD-Core Version:    0.7.0.1
 */