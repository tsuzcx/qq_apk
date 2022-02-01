package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.oi.d;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/PrivateJsApiSetDisplayOrientation;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiPageExtensionBasedSync;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewOrientationExtension;", "()V", "invokeByExt", "", "env", "data", "Lorg/json/JSONObject;", "ext", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class ai
  extends k<b, d>
{
  public static final int CTRL_INDEX = 533;
  @NotNull
  public static final String NAME = "setDisplayOrientation";
  @Deprecated
  public static final ai.a a = new ai.a(null);
  
  public ai()
  {
    super(d.class);
  }
  
  @NotNull
  protected String a(@NotNull b paramb, @NotNull JSONObject paramJSONObject, @NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "env");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "data");
    Intrinsics.checkParameterIsNotNull(paramd, "ext");
    int i = paramJSONObject.optInt("orientation", 0);
    if (i != -90)
    {
      if (i != 90) {
        paramb = "portrait";
      } else {
        paramb = "landscape";
      }
    }
    else {
      paramb = "landscapeLeft";
    }
    o.d("MicroMsg.AppBrand.PrivateJsApiSetDisplayOrientation", "set display orientation:%s", new Object[] { paramb });
    paramd.a(paramb);
    paramb = b("ok");
    Intrinsics.checkExpressionValueIsNotNull(paramb, "makeReturnJson(\"ok\")");
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.ai
 * JD-Core Version:    0.7.0.1
 */