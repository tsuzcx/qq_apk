package com.tencent.mm.plugin.appbrand.page;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.qz.o;
import java.net.URL;

class bb$4
  implements Runnable
{
  bb$4(bb parambb, URL paramURL, String paramString, ValueCallback paramValueCallback) {}
  
  public void run()
  {
    if (this.a != null)
    {
      String str;
      if (bb.d(this.d) == null) {
        str = null;
      } else {
        str = bb.d(this.d).an();
      }
      int i;
      if (bb.d(this.d) == null) {
        i = 0;
      } else {
        i = bb.d(this.d).getComponentId();
      }
      o.d("Luggage.MPWebViewRenderEngineLegacyImpl", "evaluateJavascript sourceURL:%s, componentURL:%s, componentId:%d, hash:%d", new Object[] { this.a, str, Integer.valueOf(i), Integer.valueOf(this.d.hashCode()) });
    }
    this.d.a(this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bb.4
 * JD-Core Version:    0.7.0.1
 */