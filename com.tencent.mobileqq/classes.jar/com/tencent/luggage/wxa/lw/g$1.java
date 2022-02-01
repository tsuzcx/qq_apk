package com.tencent.luggage.wxa.lw;

import com.tencent.luggage.wxa.dp.a;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.mm.plugin.appbrand.appstorage.m.a;
import com.tencent.mm.plugin.appbrand.appstorage.r;

class g$1
  implements Runnable
{
  g$1(g paramg, h paramh, int paramInt1, String paramString1, String paramString2, int paramInt2, long paramLong) {}
  
  public void run()
  {
    Object localObject2 = ((a)com.tencent.luggage.wxa.ba.e.a(a.class)).a(this.a.getAppId()).a(this.b, this.c, this.d);
    m.a locala = (m.a)localObject2[0];
    Object localObject1 = m.a.a;
    String str = null;
    if (locala == localObject1) {
      localObject1 = (String)localObject2[1];
    } else {
      localObject1 = null;
    }
    if (locala == m.a.a) {
      str = (String)localObject2[2];
    }
    if (localObject1 == null) {
      localObject2 = "fail:data not found";
    } else {
      localObject2 = "ok";
    }
    g.a(this.g, (String)localObject2, (String)localObject1, str, this.a, this.e);
    g.a(this.g, 2, r.a(this.d, (String)localObject1), this.f, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.g.1
 * JD-Core Version:    0.7.0.1
 */