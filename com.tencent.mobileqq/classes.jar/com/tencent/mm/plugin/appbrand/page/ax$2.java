package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.dq.c;

class ax$2
  implements Runnable
{
  ax$2(ax paramax) {}
  
  public void run()
  {
    View localView = this.a.s();
    if (ViewCompat.isAttachedToWindow(localView)) {
      ((c)this.a.y()).b(new ax.2.1(this, localView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ax.2
 * JD-Core Version:    0.7.0.1
 */