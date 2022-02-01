package com.tencent.luggage.wxa.jx;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandOnCopyUrlEvent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "isCopyShortLink", "", "(Z)V", "dispatchEvent", "", "webviewId", "", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class o
  extends n
{
  public static final int CTRL_INDEX = 754;
  @NotNull
  public static final String NAME = "onCopyUrl";
  public static final o.a a = new o.a(null);
  private final boolean b;
  
  public o()
  {
    this(false, 1, null);
  }
  
  public o(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public final void a(int paramInt, @NotNull com.tencent.luggage.wxa.du.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "service");
    Map localMap = (Map)new HashMap();
    localMap.put("webviewId", Integer.valueOf(paramInt));
    localMap.put("shortLinkEnable", Boolean.valueOf(this.b));
    a((c)paramc).a(localMap).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.o
 * JD-Core Version:    0.7.0.1
 */