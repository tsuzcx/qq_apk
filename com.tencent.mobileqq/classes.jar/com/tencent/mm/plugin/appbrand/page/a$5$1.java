package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.luggage.wxa.dq.c;

class a$5$1
  implements Runnable
{
  a$5$1(a.5 param5, int paramInt) {}
  
  public void run()
  {
    if ((this.b.a.y() != null) && (((c)this.b.a.y()).getContentView() != null)) {
      ((c)this.b.a.y()).getContentView().setBackgroundColor(this.a);
    }
    if (a.a(this.b.a) != null) {
      a.a(this.b.a).setBackgroundColor(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.5.1
 * JD-Core Version:    0.7.0.1
 */