package com.tencent.luggage.wxa.lt;

import com.tencent.luggage.wxa.jx.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "EventOnRealtimeDataResponse", "Priority", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
  extends a<com.tencent.luggage.wxa.iu.b>
{
  public static final int CTRL_INDEX = 652;
  @NotNull
  public static final String NAME = "operateRealtimeData";
  @Deprecated
  public static final b.a a = new b.a(null);
  
  public void a(@Nullable com.tencent.luggage.wxa.iu.b paramb, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if ((paramb != null) && (paramJSONObject != null)) {}
    try
    {
      localObject1 = paramJSONObject.getString("content");
      if (((String)localObject1).length() >= 65536L)
      {
        paramb.a(paramInt, b("fail too large data"));
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      Object localObject1;
      int i;
      Object localObject2;
      String str;
      int j;
      label173:
      break label209;
    }
    try
    {
      i = paramJSONObject.getInt("type");
    }
    catch (JSONException paramJSONObject)
    {
      break label197;
    }
    try
    {
      localObject2 = b.c.c;
      str = paramJSONObject.getString("priority");
      Intrinsics.checkExpressionValueIsNotNull(str, "data.getString(\"priority\")");
      localObject2 = ((b.c.a)localObject2).a(str);
    }
    catch (JSONException paramJSONObject)
    {
      break label185;
    }
    try
    {
      j = paramJSONObject.getInt("id");
      try
      {
        paramJSONObject = g.a;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "content");
        paramJSONObject.a(paramb, j, i, (String)localObject1, (b.c)localObject2);
        paramb.a(paramInt, b("ok"));
        return;
      }
      catch (Exception paramJSONObject)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("fail:internal error");
        ((StringBuilder)localObject1).append(' ');
        ((StringBuilder)localObject1).append(paramJSONObject.getMessage());
        paramb.a(paramInt, b(((StringBuilder)localObject1).toString()));
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      break label173;
    }
    paramb.a(paramInt, b("fail:invalid data id"));
    return;
    label185:
    paramb.a(paramInt, b("fail:invalid data priority"));
    return;
    label197:
    paramb.a(paramInt, b("fail:invalid data type"));
    return;
    label209:
    paramb.a(paramInt, b("fail:invalid data content"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lt.b
 * JD-Core Version:    0.7.0.1
 */