package com.tencent.mm.plugin.appbrand.page;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.qz.o;

class ax$3$3
  implements ValueCallback<String>
{
  ax$3$3(ax.3 param3, long paramLong) {}
  
  public void a(String paramString)
  {
    boolean bool = Boolean.parseBoolean(paramString);
    if (bool)
    {
      ax.a.a(ax.b(this.b.a), this.a);
      ax.a.b(ax.b(this.b.a), System.currentTimeMillis());
    }
    o.d("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate onWxConfigReady end, applied=%b, hash=%d, reportWxConfigInjectEnd cost=%dms", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.b.a.hashCode()), Long.valueOf(ax.a.a(ax.b(this.b.a)) - ax.a.b(ax.b(this.b.a))) });
    this.b.a.a(ax.a.c(ax.b(this.b.a)), ax.a.b(ax.b(this.b.a)), ax.a.a(ax.b(this.b.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ax.3.3
 * JD-Core Version:    0.7.0.1
 */