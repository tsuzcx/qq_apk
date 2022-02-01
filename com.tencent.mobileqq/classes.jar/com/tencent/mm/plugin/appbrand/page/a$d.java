package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.qz.o;

final class a$d
  extends ai
{
  public a$d(a parama, Context paramContext)
  {
    super(paramContext);
  }
  
  private float a()
  {
    int i = this.a.n().W().getVDisplayMetrics().widthPixels;
    float f = getPixelRatio();
    return (float)Math.ceil(i / f);
  }
  
  @JavascriptInterface
  public float getWidth()
  {
    float f1 = a();
    float f2 = (float)Math.ceil(a.b(this.a).getWidth() / super.getPixelRatio());
    if ((f2 > 0.0F) && (f2 != f1)) {
      o.c("Luggage.AbstractMPPageViewRenderer", "__deviceInfo.getWidth(), resources[%f] != view[%f], may in pad env", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
    }
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.d
 * JD-Core Version:    0.7.0.1
 */