package com.tencent.luggage.wxa.cu;

import com.tencent.luggage.wxa.ct.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/jsapi/HTMLWebViewJsApiGeoLocation;", "Lcom/tencent/mm/plugin/appbrand/jsapi/lbs/JsApiGetLocation;", "Lcom/tencent/luggage/jsapi/webview/HTMLWebViewComponentImpl;", "()V", "makeReturnJson", "", "reason", "res", "", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class d
  extends com.tencent.luggage.wxa.kx.g<b>
{
  @NotNull
  public static final String NAME = "geoLocation";
  public static final d.a a = new d.a(null);
  
  @NotNull
  public String a(@NotNull String paramString, @Nullable Map<String, ?> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "reason");
    com.tencent.luggage.util.g.a(paramMap);
    paramMap = new JSONObject(paramMap);
    if (paramMap.has("buildingId")) {
      paramMap.put("indoor_building_id", paramMap.remove("buildingId"));
    }
    if (paramMap.has("floorName")) {
      paramMap.put("indoor_building_floor", paramMap.remove("floorName"));
    }
    if (paramMap.has("indoorLocationType")) {
      paramMap.put("indoor_building_type", paramMap.remove("indoorLocationType"));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("geo_location:");
    localStringBuilder.append(paramString);
    paramMap.put("err_msg", localStringBuilder.toString());
    paramString = super.a(paramString, paramMap);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "super.makeReturnJson(reason, json)");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cu.d
 * JD-Core Version:    0.7.0.1
 */