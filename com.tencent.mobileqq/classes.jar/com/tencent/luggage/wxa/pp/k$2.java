package com.tencent.luggage.wxa.pp;

import android.view.View;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.u;

class k$2
  implements Runnable
{
  k$2(k paramk) {}
  
  public void run()
  {
    if (!k.a(this.a).d()) {
      return;
    }
    Object localObject = k.b(this.a);
    if (localObject != null)
    {
      ((View)localObject).scrollTo(0, 0);
      if (k.c(this.a) != 0)
      {
        localObject = k.a(this.a).aj();
        if (localObject != null)
        {
          localObject = ((am)localObject).getContentView();
          if (localObject != null) {
            ((View)localObject).scrollBy(((View)localObject).getScrollX(), -k.c(this.a));
          }
        }
      }
      k.d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.k.2
 * JD-Core Version:    0.7.0.1
 */