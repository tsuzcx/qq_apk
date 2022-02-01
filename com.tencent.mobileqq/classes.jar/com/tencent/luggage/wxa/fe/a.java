package com.tencent.luggage.wxa.fe;

import com.tencent.luggage.wxa.iu.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/jsapi/facial/JsApiCheckIsSupportFacialRecognition;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "FacialCapabilityDetector", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
  extends com.tencent.luggage.wxa.jx.a<b>
{
  public static final int CTRL_INDEX = 214;
  @NotNull
  public static final String NAME = "checkIsSupportFacialRecognition";
  public static final a.a a = new a.a(null);
  
  public void a(@NotNull b paramb, @NotNull JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "env");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "data");
    Object localObject = a.b.a.a();
    int i = ((Number)((Triple)localObject).component1()).intValue();
    paramJSONObject = (String)((Triple)localObject).component2();
    int j = ((Number)((Triple)localObject).component3()).intValue();
    localObject = (Map)new HashMap();
    ((Map)localObject).put("errCode", Integer.valueOf(i));
    ((Map)localObject).put("libVersionCode", Integer.valueOf(j));
    if (i == 0)
    {
      paramJSONObject = "ok";
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail ");
      if (paramJSONObject == null) {
        paramJSONObject = "";
      }
      localStringBuilder.append(paramJSONObject);
      paramJSONObject = localStringBuilder.toString();
    }
    paramb.a(paramInt, a(paramJSONObject, (Map)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fe.a
 * JD-Core Version:    0.7.0.1
 */