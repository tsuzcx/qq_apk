package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.mm.plugin.appbrand.page.u;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/EventOnKeyboardHeightChange;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "dispatch", "", "height", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "inputId", "(ILcom/tencent/mm/plugin/appbrand/AppBrandService;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;Ljava/lang/Integer;)V", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class y
  extends n
{
  public static final int CTRL_INDEX = 590;
  @NotNull
  public static final String NAME = "onKeyboardHeightChange";
  public static final y.a a = new y.a(null);
  
  @JvmOverloads
  public final void a(int paramInt, @NotNull h paramh, @NotNull u paramu, @Nullable Integer paramInteger)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "service");
    Intrinsics.checkParameterIsNotNull(paramu, "page");
    a("height", Integer.valueOf(g.a(paramInt)));
    if (paramInteger != null) {
      a("inputId", Integer.valueOf(paramInteger.intValue()));
    }
    a((c)paramh).a();
    a((c)paramu).a();
  }
  
  public final void a(int paramInt, @NotNull c paramc1, @NotNull c paramc2)
  {
    Intrinsics.checkParameterIsNotNull(paramc1, "service");
    Intrinsics.checkParameterIsNotNull(paramc2, "page");
    a("height", Integer.valueOf(g.a(paramInt)));
    a(paramc1).a();
    a(paramc2).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.y
 * JD-Core Version:    0.7.0.1
 */