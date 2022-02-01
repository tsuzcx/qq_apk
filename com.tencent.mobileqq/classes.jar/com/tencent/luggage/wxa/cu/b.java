package com.tencent.luggage.wxa.cu;

import com.tencent.luggage.wxa.jx.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/jsapi/HTMLWebViewJsApiCheckJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/luggage/jsapi/webview/HTMLWebViewComponentImpl;", "()V", "ERR_MSG_TAG", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b
  extends a<com.tencent.luggage.wxa.ct.b>
{
  @NotNull
  public static final String NAME = "checkJsApi";
  public static final b.a a = new b.a(null);
  
  @NotNull
  protected String a()
  {
    return "err_msg";
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.ct.b paramb, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONArray("jsApiList");
      if (paramJSONObject == null) {}
    }
    try
    {
      localJSONObject = new JSONObject();
      k = paramJSONObject.length();
      i = 0;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        int k;
        int i;
        String str;
        CharSequence localCharSequence;
        continue;
        int j = 0;
        break label186;
        j = 1;
        if (j != 0) {
          i += 1;
        }
      }
    }
    if (i < k)
    {
      str = paramJSONObject.optString(i);
      localCharSequence = (CharSequence)str;
      if (localCharSequence == null) {
        break label183;
      }
      if (localCharSequence.length() == 0)
      {
        break label183;
        if (paramb == null) {
          Intrinsics.throwNpe();
        }
        localJSONObject.put(str, paramb.a().containsKey(str));
        break label191;
      }
    }
    else
    {
      if (paramb == null) {
        Intrinsics.throwNpe();
      }
      paramb.a(paramInt, a("ok", new JSONObject().put("checkResult", localJSONObject.toString())));
      return;
      if (paramb != null) {
        paramb.a(paramInt, b("fail"));
      }
      return;
      ((Function0)new b.b(paramb, paramInt)).invoke();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cu.b
 * JD-Core Version:    0.7.0.1
 */