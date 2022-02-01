package com.tencent.mm.plugin.appbrand.page;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.oq.e.a;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.qz.o;

class av$4
  implements e.a
{
  av$4(av paramav, e.a parama) {}
  
  public void a(@Nullable e.b paramb, boolean paramBoolean)
  {
    o.d("Luggage.MPPageViewOrientationExtensionImpl[AppBrandSplashAd]", "resetPageOrientation, onOrientationChanged, appId[%s] url[%s] orientation[%s] success[%b]", new Object[] { av.e(this.b), av.f(this.b), paramb, Boolean.valueOf(paramBoolean) });
    e.a locala = this.a;
    if (locala != null) {
      locala.a(paramb, paramBoolean);
    }
    av.b(this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.av.4
 * JD-Core Version:    0.7.0.1
 */