package com.tencent.luggage.wxa.cu;

import com.tencent.luggage.util.g;
import com.tencent.luggage.wxa.ck.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/jsapi/HTMLWebViewJsApiChooseImage;", "Lcom/tencent/luggage/jsapi/media/JsApiChooseImage;", "()V", "ERR_MSG_TAG", "", "makeReturnJson", "reason", "res", "", "", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class c
  extends a
{
  @NotNull
  public static final String NAME = "chooseImage";
  public static final c.a a = new c.a(null);
  
  @NotNull
  protected String a()
  {
    return "err_msg";
  }
  
  @NotNull
  public String a(@NotNull String paramString, @Nullable Map<Object, Object> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "reason");
    g.a(paramMap);
    paramMap = new JSONObject(paramMap);
    if (paramMap.has("tempFilePaths"))
    {
      paramMap.put("localIds", paramMap.remove("tempFilePaths"));
      paramMap.remove("tempFileSizes");
    }
    paramString = super.a(paramString, paramMap);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "super.makeReturnJson(reason, json)");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cu.c
 * JD-Core Version:    0.7.0.1
 */