package com.tencent.luggage.wxa.ly;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.ln.j;
import com.tencent.luggage.wxa.oi.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/JsApiHideStatusBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiPageExtensionBased;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewStatusBarExtension;", "()V", "invokeByExt", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "ext", "Companion", "luggage-wxa-app-jsapi_release"}, k=1, mv={1, 1, 16})
public final class a
  extends j<b, i>
{
  private static final int CTRL_INDEX = 471;
  private static final String NAME = "hideStatusBar";
  public static final a.a a = new a.a(null);
  
  static
  {
    NAME = "hideStatusBar";
  }
  
  public a()
  {
    super(i.class);
  }
  
  protected void a(@NotNull b paramb, @NotNull JSONObject paramJSONObject, int paramInt, @NotNull i parami)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "env");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "data");
    Intrinsics.checkParameterIsNotNull(parami, "ext");
    parami.b();
    paramb.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ly.a
 * JD-Core Version:    0.7.0.1
 */