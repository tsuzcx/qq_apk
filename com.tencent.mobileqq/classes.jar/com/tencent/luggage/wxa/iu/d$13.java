package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.jj.a;
import com.tencent.luggage.wxa.jj.a.b;
import com.tencent.luggage.wxa.jj.h;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.oq.c.a;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;

class d$13
  implements Runnable
{
  d$13(d paramd) {}
  
  public void run()
  {
    c localc = this.a.W();
    if (localc == null) {
      return;
    }
    Object localObject = this.a.aj();
    if (localObject == null)
    {
      localObject = new c.a(this.a.B().E);
    }
    else
    {
      int i = g.a(((a)localObject).c().e, -16777216);
      localObject = new c.a(this.a.B().E, null, i);
    }
    localc.setWindowDescription((c.a)localObject);
    AppBrandSimpleImageLoader.instance().load(new d.13.1(this, localc, (c.a)localObject), this.a.B().F, WxaIconTransformation.INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.d.13
 * JD-Core Version:    0.7.0.1
 */