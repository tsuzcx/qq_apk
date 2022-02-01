package com.tencent.luggage.wxa.cv;

import java.util.LinkedList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/model/HTMLWebViewJsApiPermissionController$Companion;", "", "()V", "CGI_URL_JSVERIFY", "", "CGI_URL_JS_AUTH_VERIFY", "CGI_URL_REALTIME_VERIFY", "CGI_URL_SET_JS_AUTH", "FUNCTION_PERMISSION_CONTROL_INDEX_MAP", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "KEY_JSOAUTH_ADDR_SIGN", "KEY_JSOAUTH_APPID", "KEY_JSOAUTH_NONCESTR", "KEY_JSOAUTH_SCOPE", "KEY_JSOAUTH_SIGN_TYPE", "KEY_JSOAUTH_TIMESTAMP", "KEY_JSVERIFY_APPID", "KEY_JSVERIFY_JSAPI_LIST", "KEY_JSVERIFY_NONCE_STR", "KEY_JSVERIFY_SIGNATURE", "KEY_JSVERIFY_SIGN_TYPE", "KEY_JSVERIFY_TIMESTAMP", "KEY_JSVERIFY_WEB_COMPT", "MMBIZ_JSAPI_AUTHORIZED", "MMBIZ_JSAPI_NO_USE", "MMBIZ_JSAPI_SIGTYPE_DEFAULT", "MMBIZ_JSAPI_SIGTYPE_NEW", "MMBIZ_JSAPI_SIGTYPE_OLD", "MMBIZ_JSAPI_UN_AUTHORIZED", "TAG", "optStringList", "Ljava/util/LinkedList;", "Lorg/json/JSONObject;", "name", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
final class b$a
{
  private final LinkedList<String> a(@NotNull JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject != null)
    {
      paramString = new LinkedList();
      int i = 0;
      int j = paramJSONObject.length();
      while (i < j)
      {
        paramString.add(paramJSONObject.optString(i));
        i += 1;
      }
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.b.a
 * JD-Core Version:    0.7.0.1
 */