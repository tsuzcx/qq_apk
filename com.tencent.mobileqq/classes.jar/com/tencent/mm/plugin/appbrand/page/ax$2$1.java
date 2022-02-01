package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.qz.o;

class ax$2$1
  implements Runnable
{
  ax$2$1(ax.2 param2, View paramView) {}
  
  public void run()
  {
    if (!ViewCompat.isAttachedToWindow(this.a)) {
      return;
    }
    if (!ViewCompat.isLaidOut(this.a))
    {
      o.e("Luggage.MPPageViewRenderer", "loadURL[page], PageView(%s) not laid out, forceLayout", new Object[] { this.b.a.u() });
      this.a.forceLayout();
      Object localObject = this.a.getParent();
      ViewParent localViewParent;
      do
      {
        ((View)localObject).forceLayout();
        localViewParent = ((ViewParent)localObject).getParent();
        localObject = localViewParent;
      } while ((localViewParent instanceof View));
      if (localViewParent != null) {
        localViewParent.requestLayout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ax.2.1
 * JD-Core Version:    0.7.0.1
 */