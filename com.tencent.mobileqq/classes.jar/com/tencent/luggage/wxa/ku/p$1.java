package com.tencent.luggage.wxa.ku;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

class p$1
  implements Runnable
{
  p$1(p paramp, c paramc, String paramString, int paramInt) {}
  
  public void run()
  {
    if (!this.a.d()) {
      return;
    }
    i locali = this.a.getFileSystem().g(this.b);
    if (locali == null)
    {
      this.a.a(this.c, this.d.b(String.format(Locale.US, "fail no such file \"%s\"", new Object[] { this.b })));
      return;
    }
    HashMap localHashMap = new HashMap(3);
    localHashMap.put("size", Long.valueOf(locali.q()));
    localHashMap.put("createTime", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(locali.p())));
    this.a.a(this.c, this.d.a("ok", localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.p.1
 * JD-Core Version:    0.7.0.1
 */