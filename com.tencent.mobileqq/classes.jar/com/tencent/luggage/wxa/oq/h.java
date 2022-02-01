package com.tencent.luggage.wxa.oq;

import com.tencent.luggage.wxa.pd.j;
import com.tencent.luggage.wxa.pd.s;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/platform/window/WxaOrientationGetter;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "orientationHandler", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;)V", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "getCurOrientation", "()Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "name", "", "getName", "()Ljava/lang/String;", "wxaOrientation2Orientation", "wxaOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class h
  implements j
{
  public static final h.a a = new h.a(null);
  private final e b;
  
  public h(@NotNull e parame)
  {
    this.b = parame;
  }
  
  private final s a(e.b paramb)
  {
    switch (i.a[paramb.ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 6: 
      return s.a;
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      return s.c;
    }
    return s.b;
  }
  
  @NotNull
  public String a()
  {
    return "WxaOrientationGetter";
  }
  
  @NotNull
  public s b()
  {
    e.b localb = this.b.a();
    Intrinsics.checkExpressionValueIsNotNull(localb, "orientationHandler.currentOrientation");
    return a(localb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oq.h
 * JD-Core Version:    0.7.0.1
 */