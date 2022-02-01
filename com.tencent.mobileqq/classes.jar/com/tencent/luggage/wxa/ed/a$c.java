package com.tencent.luggage.wxa.ed;

import com.tencent.luggage.wxa.oq.e.a;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "success", "", "onOrientationChanged"}, k=3, mv={1, 1, 16})
final class a$c
  implements e.a
{
  a$c(a parama) {}
  
  public final void a(@Nullable e.b paramb, boolean paramBoolean)
  {
    o.d("Luggage.AppBrandWindowLayoutManager", "request orientation result: [%b]", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.a.c() != null) {
      a.a(this.a, "requestDeviceOrientation done", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ed.a.c
 * JD-Core Version:    0.7.0.1
 */