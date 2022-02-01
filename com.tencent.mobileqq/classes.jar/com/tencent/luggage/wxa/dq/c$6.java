package com.tencent.luggage.wxa.dq;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.h;
import com.tencent.mm.plugin.appbrand.page.am;

class c$6
  implements com.tencent.luggage.wxa.rl.b<Bitmap, Void>
{
  c$6(c paramc) {}
  
  public Bitmap a(Void paramVoid)
  {
    o.e("MicroMsg.AppBrandPageViewLU", "getScreenshotForSharing entered");
    paramVoid = this.a.aj().getContentView();
    if (paramVoid == null) {
      return null;
    }
    int i = this.a.aj().getWidth();
    int j = this.a.aj().getHeight();
    int k = this.a.aj().getWebScrollX();
    int m = this.a.aj().getWebScrollY();
    if (i != 0)
    {
      if (j == 0) {
        return null;
      }
      paramVoid.scrollTo(0, 0);
      com.tencent.luggage.wxa.ro.b localb = h.c();
      this.a.aj().a(new c.6.1(this, i, j, localb, paramVoid, k, m));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dq.c.6
 * JD-Core Version:    0.7.0.1
 */