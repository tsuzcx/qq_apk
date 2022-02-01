package com.tencent.luggage.wxa.lw;

import com.tencent.luggage.wxa.dp.a;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.sj.g;

class r$2
  implements g
{
  r$2(r paramr, h paramh, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, r.a parama, int paramInt2, long paramLong) {}
  
  public String a()
  {
    return "JsApiSetStorage";
  }
  
  public void run()
  {
    String str = u.a(((a)com.tencent.luggage.wxa.ba.e.a(a.class)).a(this.a.getAppId()).a(this.b, this.c, this.d, this.e, this.f));
    r.a locala = this.g;
    if (locala != null) {
      locala.a(str, this.a, this.h);
    }
    r.a(this.j, 2, com.tencent.mm.plugin.appbrand.appstorage.r.a(this.d, this.e), this.i, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.r.2
 * JD-Core Version:    0.7.0.1
 */