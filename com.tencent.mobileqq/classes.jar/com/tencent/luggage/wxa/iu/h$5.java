package com.tencent.luggage.wxa.iu;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

class h$5
  implements ValueCallback<String>
{
  h$5(h paramh, long paramLong) {}
  
  public void a(String paramString)
  {
    boolean bool = Boolean.parseBoolean(paramString);
    if (bool)
    {
      h.a.a(h.a(this.b), this.a);
      h.a.b(h.a(this.b), af.d());
      h.a.a(h.a(this.b), null);
    }
    o.d("MicroMsg.AppBrandService", "notifyWxConfigReadyIfNeed end by evaluateJavascript, applied=%b, hash=%d, reportWxConfigInjectEnd cost=%dms", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.b.getComponentId()), Long.valueOf(h.a.a(h.a(this.b)) - h.a.b(h.a(this.b))) });
    paramString = this.b;
    paramString.a(h.a.c(h.a(paramString)), h.a.b(h.a(this.b)), h.a.a(h.a(this.b)), h.a.d(h.a(this.b)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.h.5
 * JD-Core Version:    0.7.0.1
 */