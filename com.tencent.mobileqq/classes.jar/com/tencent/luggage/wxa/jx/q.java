package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.hv.h;
import com.tencent.luggage.wxa.pd.t.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandOnVideoOrientationChanged;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "dispatch", "", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "viewId", "", "orientation", "Lcom/tencent/mm/plugin/appbrand/utils/OrientationListenerHelper$Orientation;", "parseOrientation", "", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public abstract class q
  extends n
{
  private final String a(t.a parama)
  {
    int i = r.a[parama.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return null;
        }
        return "portrait";
      }
      return "landscape";
    }
    return "landscapeLeft";
  }
  
  public final void a(@NotNull u paramu, int paramInt, @NotNull t.a parama)
  {
    Intrinsics.checkParameterIsNotNull(paramu, "pageView");
    Intrinsics.checkParameterIsNotNull(parama, "orientation");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dispatch, pageView: ");
    ((StringBuilder)localObject).append(paramu);
    ((StringBuilder)localObject).append(", viewId: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", orientation: ");
    ((StringBuilder)localObject).append(parama);
    o.e("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", ((StringBuilder)localObject).toString());
    parama = a(parama);
    if (parama == null)
    {
      o.e("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", "dispatch, null == orientationStr");
      return;
    }
    localObject = (Map)new HashMap(2);
    ((Map)localObject).put("viewId", Integer.valueOf(paramInt));
    ((Map)localObject).put("orientation", parama);
    parama = h.a((Map)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dispatch, name: ");
    ((StringBuilder)localObject).append(d());
    ((StringBuilder)localObject).append(", data: ");
    ((StringBuilder)localObject).append(parama);
    o.d("MicroMsg.AppBrand.AppBrandOnVideoOrientationChanged", ((StringBuilder)localObject).toString());
    a(parama).a((c)paramu, paramu.getComponentId()).a();
    localObject = paramu.p();
    if (localObject != null) {
      a(parama).a((c)localObject, paramu.getComponentId()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.q
 * JD-Core Version:    0.7.0.1
 */