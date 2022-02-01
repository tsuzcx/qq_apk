package com.tencent.luggage.wxa.standalone_open_runtime;

import com.tencent.luggage.wxa.fq.g.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/CommonWxConfig;", "", "()V", "TAG", "", "attachCommonConfig", "", "config", "Lorg/json/JSONObject;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
{
  public static final b a = new b();
  
  public final void a(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "config");
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("env", "SDK");
      ((JSONObject)localObject).put("appId", g.c.a.a());
      ((JSONObject)localObject).put("version", 553976065);
      paramJSONObject.put("host", localObject);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("attachCommonConfig assign __wxConfig.host e=");
      ((StringBuilder)localObject).append(paramJSONObject);
      com.tencent.luggage.wxa.gw.b.a("Luggage.WXA.CommonWxConfig", ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.b
 * JD-Core Version:    0.7.0.1
 */