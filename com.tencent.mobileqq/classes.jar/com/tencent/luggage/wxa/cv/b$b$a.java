package com.tencent.luggage.wxa.cv;

import com.tencent.luggage.wxa.jx.m;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/model/HTMLWebViewJsApiPermissionController$JSVerifyRequestProxy$Companion;", "", "()V", "make", "Lcom/tencent/luggage/jsapi/webview/model/HTMLWebViewJsApiPermissionController$JSVerifyRequestProxy;", "url", "", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "dataJson", "Lorg/json/JSONObject;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b$b$a
{
  @NotNull
  public final b.b a(@Nullable String paramString, @NotNull m paramm, @NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramm, "api");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "dataJson");
    String str1 = paramJSONObject.toString();
    Intrinsics.checkExpressionValueIsNotNull(str1, "dataJson.toString()");
    Object localObject = Charsets.UTF_8;
    if (str1 != null)
    {
      byte[] arrayOfByte = str1.getBytes((Charset)localObject);
      Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "(this as java.lang.String).getBytes(charset)");
      b.a();
      if (paramJSONObject.has("addrSign"))
      {
        b.a();
        if (!paramJSONObject.has("verifySignature"))
        {
          b.a();
          b.a();
          str4 = paramJSONObject.optString("appId");
          Intrinsics.checkExpressionValueIsNotNull(str4, "dataJson.optString(KEY_JSOAUTH_APPID)");
          b.a();
          str1 = paramJSONObject.optString("addrSign");
          Intrinsics.checkExpressionValueIsNotNull(str1, "dataJson.optString(KEY_JSOAUTH_ADDR_SIGN)");
          b.a();
          localObject = paramJSONObject.optString("signType");
          Intrinsics.checkExpressionValueIsNotNull(localObject, "dataJson.optString(KEY_JSOAUTH_SIGN_TYPE)");
          b.a();
          str2 = paramJSONObject.optString("timeStamp");
          Intrinsics.checkExpressionValueIsNotNull(str2, "dataJson.optString(KEY_JSOAUTH_TIMESTAMP)");
          b.a();
          str3 = paramJSONObject.optString("nonceStr");
          Intrinsics.checkExpressionValueIsNotNull(str3, "dataJson.optString(KEY_JSOAUTH_NONCESTR)");
          i = 1;
          break label284;
        }
      }
      b.a();
      b.a();
      String str4 = paramJSONObject.optString("verifyAppId");
      Intrinsics.checkExpressionValueIsNotNull(str4, "dataJson.optString(KEY_JSVERIFY_APPID)");
      b.a();
      str1 = paramJSONObject.optString("verifySignature");
      Intrinsics.checkExpressionValueIsNotNull(str1, "dataJson.optString(KEY_JSVERIFY_SIGNATURE)");
      b.a();
      localObject = paramJSONObject.optString("verifySignType");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "dataJson.optString(KEY_JSVERIFY_SIGN_TYPE)");
      b.a();
      String str2 = paramJSONObject.optString("verifyTimestamp");
      Intrinsics.checkExpressionValueIsNotNull(str2, "dataJson.optString(KEY_JSVERIFY_TIMESTAMP)");
      b.a();
      String str3 = paramJSONObject.optString("verifyNonceStr");
      Intrinsics.checkExpressionValueIsNotNull(str3, "dataJson.optString(KEY_JSVERIFY_NONCE_STR)");
      int i = 2;
      label284:
      paramm = paramm.d();
      b.a();
      return new b.b(paramString, i, str4, str1, (String)localObject, str2, str3, paramm, arrayOfByte, paramJSONObject.optString("scope"));
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.b.b.a
 * JD-Core Version:    0.7.0.1
 */