package com.tencent.luggage.wxa.cu;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/jsapi/ConstantsHTMLWebViewJsApi;", "", "()V", "ERR_MSG_TAG", "", "RET_ACCESS_DENIED", "getRET_ACCESS_DENIED", "()Ljava/lang/String;", "RET_FUNCTION_NOT_EXIST", "getRET_FUNCTION_NOT_EXIST", "RET_INVALID_API", "getRET_INVALID_API", "RET_INVALID_DATA", "getRET_INVALID_DATA", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a
{
  public static final a a;
  @NotNull
  private static final String b;
  @NotNull
  private static final String c;
  @NotNull
  private static final String d;
  @NotNull
  private static final String e;
  
  static
  {
    str3 = "{}";
    a = new a();
    try
    {
      str1 = new JSONObject().put("err_msg", "system:function_not_exist").toString();
    }
    catch (JSONException localJSONException3)
    {
      try
      {
        str1 = new JSONObject().put("err_msg", "system:invalid_data").toString();
        break label65;
        str1 = "{}";
        c = str1;
      }
      catch (JSONException localJSONException3)
      {
        try
        {
          str1 = new JSONObject().put("err_msg", "system:invalid_api").toString();
          break label93;
          str1 = "{}";
          d = str1;
        }
        catch (JSONException localJSONException3)
        {
          try
          {
            for (;;)
            {
              String str1 = new JSONObject().put("err_msg", "system:access_denied").toString();
              e = str1;
              return;
              localJSONException1 = localJSONException1;
              continue;
              localJSONException2 = localJSONException2;
            }
            localJSONException3 = localJSONException3;
          }
          catch (JSONException localJSONException4)
          {
            for (;;)
            {
              String str2 = str3;
            }
          }
        }
      }
    }
    str1 = "{}";
    b = str1;
  }
  
  @NotNull
  public final String a()
  {
    return b;
  }
  
  @NotNull
  public final String b()
  {
    return c;
  }
  
  @NotNull
  public final String c()
  {
    return d;
  }
  
  @NotNull
  public final String d()
  {
    return e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cu.a
 * JD-Core Version:    0.7.0.1
 */