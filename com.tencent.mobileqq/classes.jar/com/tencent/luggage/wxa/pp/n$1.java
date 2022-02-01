package com.tencent.luggage.wxa.pp;

import android.view.View;
import com.tencent.luggage.wxa.qz.o;

class n$1
  implements Runnable
{
  n$1(n paramn) {}
  
  public void run()
  {
    if (n.a(this.a) == null) {
      return;
    }
    Object localObject = n.a(this.a).getClass().getSimpleName();
    int i = 0;
    o.d("MicroMsg.AppBrandUIdRootFrameLayout", "hideInactivePanelView, mPanel %s", new Object[] { localObject });
    while (i < this.a.getChildCount())
    {
      localObject = this.a.getChildAt(i);
      if ((localObject != null) && (localObject != n.b(this.a)) && (localObject != n.a(this.a))) {
        n.a(this.a, (View)localObject, 8);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.n.1
 * JD-Core Version:    0.7.0.1
 */