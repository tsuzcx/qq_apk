package com.tencent.mm.plugin.appbrand.page;

import android.webkit.JavascriptInterface;
import com.tencent.luggage.wxa.om.g;
import com.tencent.luggage.wxa.qz.o;

class a$6
  implements g
{
  a$6(a parama) {}
  
  @JavascriptInterface
  public void notifyLongTask(long paramLong)
  {
    o.e("Luggage.AbstractMPPageViewRenderer", "notifyLongTask :%d", new Object[] { Long.valueOf(paramLong) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.6
 * JD-Core Version:    0.7.0.1
 */