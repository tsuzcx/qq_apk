package com.tencent.luggage.wxa.oq;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.n;
import com.tencent.luggage.wxa.pd.a;
import com.tencent.luggage.wxa.pd.a.a;
import com.tencent.luggage.wxa.pd.j;
import com.tencent.luggage.wxa.pd.j.a;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/platform/window/WxaOrientationGetter$Companion;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter$IFactory;", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "componentView", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class h$a
  implements j.a
{
  @NotNull
  public j a(@Nullable com.tencent.luggage.wxa.jx.e parame)
  {
    if ((parame instanceof com.tencent.luggage.wxa.jx.h))
    {
      Object localObject = ((com.tencent.luggage.wxa.jx.h)parame).q();
      if (localObject != null)
      {
        localObject = ((d)localObject).af();
        if (localObject != null)
        {
          localObject = ((n)localObject).getWindowAndroid();
          if (localObject != null)
          {
            localObject = ((c)localObject).getOrientationHandler();
            if (localObject != null) {
              return (j)new h((e)localObject);
            }
          }
        }
      }
      parame = a.a.b(parame);
      o.c("MicroMsg.AppBrand.WxaOrientationGetter", "create, something null, use AndroidOrientationGetter as fallback");
      return (j)parame;
    }
    o.c("MicroMsg.AppBrand.WxaOrientationGetter", "create, componentView is not AppBrandComponentWithExtra, use AndroidOrientationGetter as fallback");
    return (j)a.a.b(parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oq.h.a
 * JD-Core Version:    0.7.0.1
 */