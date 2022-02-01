package com.tencent.luggage.wxa.iu;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

class h$3
  implements ValueCallback<String>
{
  h$3(h paramh, long paramLong, String paramString) {}
  
  public void a(String paramString)
  {
    long l = af.d();
    o.d("MicroMsg.AppBrandService", "injectConfig end by evaluateJavascript, cost=%dms, hash=%d", new Object[] { Long.valueOf(l - this.a), Integer.valueOf(this.c.getComponentId()) });
    h.a(this.c, new h.a(null));
    h.a.a(h.a(this.c), this.b);
    h.a.a(h.a(this.c), this.a);
    h.a.b(h.a(this.c), l);
    h.a.a(h.a(this.c), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.h.3
 * JD-Core Version:    0.7.0.1
 */