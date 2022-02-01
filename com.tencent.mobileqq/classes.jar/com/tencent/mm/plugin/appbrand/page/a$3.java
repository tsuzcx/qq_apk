package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.dq.c;
import com.tencent.luggage.wxa.qz.o;

class a$3
  implements ao
{
  a$3(a parama) {}
  
  public void a(q paramq)
  {
    if (((c)this.a.y()).T() == null)
    {
      o.b("Luggage.AbstractMPPageViewRenderer", "FullScreenViewAttach getContainerPage is null, check time sequence, err, appId[%s], url[%s]", new Object[] { this.a.o(), this.a.u() });
      return;
    }
    ((c)this.a.y()).T().a((u)this.a.y(), paramq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.3
 * JD-Core Version:    0.7.0.1
 */