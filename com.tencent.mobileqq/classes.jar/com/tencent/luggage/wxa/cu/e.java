package com.tencent.luggage.wxa.cu;

import com.tencent.luggage.wxa.ct.b;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.lx.f;
import com.tencent.luggage.wxa.lx.f.c;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/jsapi/HTMLWebViewJsApiGetNetworkType;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/luggage/jsapi/webview/HTMLWebViewComponentImpl;", "()V", "__makeReturnJson", "", "errMsg", "values", "Lorg/json/JSONObject;", "invoke", "", "env", "data", "callbackId", "", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class e
  extends a<b>
{
  @NotNull
  public static final String NAME = "getNetworkType";
  public static final e.a a = new e.a(null);
  
  private final String b(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    paramString = paramJSONObject.put("err_msg", paramString).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(values ?: JSONObject())…G_TAG, errMsg).toString()");
    return paramString;
  }
  
  public void a(@Nullable b paramb, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = new JSONObject().put("simtype", 0);
    f.c localc = f.a(r.a());
    int i = f.a[localc.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              if (paramb != null) {
                paramb.a(paramInt, a(this, "network_type:fail", null, 2, null));
              }
            }
            else
            {
              paramJSONObject.put("subtype", "5g");
              if (paramb != null) {
                paramb.a(paramInt, b("network_type:wwan", paramJSONObject));
              }
            }
          }
          else
          {
            paramJSONObject.put("subtype", "4g");
            if (paramb != null) {
              paramb.a(paramInt, b("network_type:wwan", paramJSONObject));
            }
          }
        }
        else
        {
          paramJSONObject.put("subtype", "3g");
          if (paramb != null) {
            paramb.a(paramInt, b("network_type:wwan", paramJSONObject));
          }
        }
      }
      else
      {
        paramJSONObject.put("subtype", "2g");
        if (paramb != null) {
          paramb.a(paramInt, b("network_type:wwan", paramJSONObject));
        }
      }
    }
    else if (paramb != null) {
      paramb.a(paramInt, a(this, "network_type:wifi", null, 2, null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cu.e
 * JD-Core Version:    0.7.0.1
 */