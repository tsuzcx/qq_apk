package com.tencent.mm.plugin.appbrand.page;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

class ax$3$1
  implements ValueCallback<String>
{
  ax$3$1(ax.3 param3) {}
  
  public void a(String paramString)
  {
    if (!this.a.a.t()) {
      return;
    }
    if (!"undefined".equals(paramString))
    {
      float f1 = af.a(paramString, -1.0F);
      if (f1 > 0.0F)
      {
        o.d("Luggage.MPPageViewRenderer", "[%s] update density with window.devicePixelRatio = %s", new Object[] { this.a.c(), paramString });
        float f2 = this.a.a.D().getPixelRatio();
        if (f1 != f2) {
          o.c("Luggage.MPPageViewRenderer", "[%s] mismatch devicePixelRatio!!! interface[%f], WebView[%f]", new Object[] { this.a.c(), Float.valueOf(f2), Float.valueOf(f1) });
        }
        g.c(f1);
        return;
      }
    }
    o.c("Luggage.MPPageViewRenderer", "[%s] invalid window.devicePixelRatio %s", new Object[] { this.a.c(), paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ax.3.1
 * JD-Core Version:    0.7.0.1
 */