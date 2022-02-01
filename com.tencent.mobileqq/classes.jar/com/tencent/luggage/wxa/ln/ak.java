package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.mm.plugin.appbrand.page.av;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/PrivateJsApiSetPageOrientation;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiPageExtensionBased;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/page/MPPageViewOrientationExtensionImpl;", "()V", "invokeByExt", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "ext", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public class ak
  extends j<b, av>
{
  public static final int CTRL_INDEX = 584;
  @NotNull
  public static final String NAME = "private_setPageOrientation";
  @Deprecated
  public static final ak.a b = new ak.a(null);
  
  public ak()
  {
    super(av.class);
  }
  
  protected void a(@NotNull b paramb, @NotNull JSONObject paramJSONObject, int paramInt, @NotNull av paramav)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "env");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "data");
    Intrinsics.checkParameterIsNotNull(paramav, "ext");
    paramJSONObject = paramJSONObject.optString("orientation", null);
    if (paramJSONObject != null)
    {
      if (e.b.a(paramJSONObject) != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put(d(), paramJSONObject);
        paramav.a(paramJSONObject, (Map)localHashMap);
        paramb.a(paramInt, b("ok"));
        return;
      }
      ((Function0)new ak.b(this, paramb, paramInt)).invoke();
      return;
    }
    ((Function0)new ak.c(this, paramb, paramInt)).invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.ak
 * JD-Core Version:    0.7.0.1
 */