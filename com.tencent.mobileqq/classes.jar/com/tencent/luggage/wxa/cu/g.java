package com.tencent.luggage.wxa.cu;

import com.tencent.luggage.wxa.ct.b;
import com.tencent.luggage.wxa.jx.ah;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/jsapi/HTMLWebViewJsApiInvokeMiniProgramAPI;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/luggage/jsapi/webview/HTMLWebViewComponentImpl;", "()V", "ERR_MSG_TAG", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "EventOnHTMLWebViewInvoke", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class g
  extends com.tencent.luggage.wxa.jx.a<b>
{
  @NotNull
  public static final String NAME = "invokeMiniProgramAPI";
  public static final g.a a = new g.a(null);
  
  @NotNull
  protected String a()
  {
    return "err_msg";
  }
  
  public void a(@Nullable b paramb, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject != null)
    {
      String str = paramJSONObject.optString("name");
      if (str != null)
      {
        paramJSONObject = paramJSONObject.opt("arg");
        if (paramb != null) {
          paramb.a(new g.b().a("name", str).a("arg", paramJSONObject), new int[] { 0 });
        }
        if (paramb != null) {
          paramb.a(paramInt, b("ok"));
        }
        return;
      }
    }
    paramJSONObject = (g)this;
    if (paramb != null) {
      paramb.a(paramInt, a.a.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cu.g
 * JD-Core Version:    0.7.0.1
 */