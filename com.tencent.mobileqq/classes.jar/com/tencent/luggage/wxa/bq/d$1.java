package com.tencent.luggage.wxa.bq;

import com.tencent.luggage.game.widget.input.a;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.mm.plugin.appbrand.page.u;

class d$1
  implements Runnable
{
  d$1(d paramd, h paramh) {}
  
  public void run()
  {
    Object localObject = this.a.v();
    if (localObject == null) {
      return;
    }
    localObject = a.a(((u)localObject).getContentView());
    if (localObject != null) {
      ((a)localObject).j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bq.d.1
 * JD-Core Version:    0.7.0.1
 */