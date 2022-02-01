package com.tencent.luggage.wxa.cu;

import com.tencent.luggage.wxa.ct.b;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/jsapi/HTMLWebViewJsApiSystemLog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/luggage/jsapi/webview/HTMLWebViewComponentImpl;", "()V", "ERR_MSG_TAG", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class j
  extends a<b>
{
  @NotNull
  public static final String NAME = "log";
  public static final j.a a = new j.a(null);
  
  @NotNull
  protected String a()
  {
    return "err_msg";
  }
  
  public void a(@Nullable b paramb, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msg:");
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.optString("msg");
    } else {
      paramJSONObject = null;
    }
    localStringBuilder.append(paramJSONObject);
    o.d("Luggage.STANDALONE.HTMLWebViewJsApiSystemLog", localStringBuilder.toString());
    if (paramb != null) {
      paramb.a(paramInt, b("ok"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cu.j
 * JD-Core Version:    0.7.0.1
 */