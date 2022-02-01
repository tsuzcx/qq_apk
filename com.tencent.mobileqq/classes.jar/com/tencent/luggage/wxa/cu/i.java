package com.tencent.luggage.wxa.cu;

import com.tencent.luggage.wxa.jx.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/jsapi/HTMLWebViewJsApiPreVerify;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/luggage/jsapi/webview/HTMLWebViewComponentImpl;", "()V", "__makeReturnJson", "", "reason", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class i
  extends a<com.tencent.luggage.wxa.ct.b>
{
  @NotNull
  public static final String NAME = "preVerifyJSAPI";
  public static final i.a a = new i.a(null);
  
  private final String a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pre_verify_jsapi:");
    localStringBuilder.append(paramString);
    paramString = localJSONObject.put("err_msg", localStringBuilder.toString()).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "JSONObject()\n           …)\n            .toString()");
    return paramString;
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.ct.b paramb, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if ((paramb != null) && (paramJSONObject != null)) {
      paramb.c().a(paramJSONObject, (Function0)new i.b(this, paramb, paramInt), (Function1)new i.c(this, paramb, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cu.i
 * JD-Core Version:    0.7.0.1
 */