package com.tencent.luggage.wxa.fy;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.q;
import com.tencent.luggage.wxa.jx.s;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.or.i;
import com.tencent.luggage.wxa.pd.t.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import org.jetbrains.annotations.NotNull;

class a$1
  implements i
{
  a$1(a parama, u paramu) {}
  
  public void a(@NotNull t.a parama)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onOrientationChanged, orientation: ");
    ((StringBuilder)localObject).append(parama);
    o.e("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", ((StringBuilder)localObject).toString());
    if (!this.b.a())
    {
      o.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, not in foreground");
      return;
    }
    if ((this.b.a) && (this.b.b))
    {
      if (a.a(this.b) == null)
      {
        o.c("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged, null == mPageView");
        return;
      }
      localObject = this.a.q().W();
      if ((localObject != null) && (((c)localObject).h_()))
      {
        o.d("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", "onOrientationChanged: disable autoRotationEnabled for pad compat mode");
        return;
      }
      a.c(this.b).a().a(a.a(this.b), a.b(this.b).B(), parama);
      return;
    }
    parama = new StringBuilder();
    parama.append("onOrientationChanged, mIsNeedNotify: ");
    parama.append(this.b.a);
    parama.append(", mIsAutoRotationEnabled: ");
    parama.append(this.b.b);
    o.e("MicroMsg.AppBrand.AbsAutoRotationPluginHandlerCommons", parama.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.a.1
 * JD-Core Version:    0.7.0.1
 */