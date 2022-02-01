package com.tencent.luggage.wxa.cx;

import android.util.Log;
import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.nl.a.a;
import com.tencent.luggage.wxa.nn.a;
import com.tencent.luggage.wxa.ou.d;
import com.tencent.luggage.wxa.ro.b;
import com.tencent.luggage.wxa.ro.e;

class r$2$1
  implements a.a<c>
{
  r$2$1(r.2 param2, b paramb) {}
  
  public void a(c paramc, d paramd, int paramInt)
  {
    if (paramc != null)
    {
      paramc.a(this.b.a.a);
      paramc.a(r.b(this.b.a));
      com.tencent.luggage.wxa.qz.o.d("Luggage.Standalone.WxaLaunchPreconditionProcess", "AppBrandPreLaunchProcess.onResult, hash:%d, do wormhole with config:%s", new Object[] { Integer.valueOf(this.b.a.hashCode()), paramc });
      this.a.a(new Object[] { paramc });
      paramd = t.a;
      String str = this.b.a.a;
      t.d locald = t.d.b;
      t.c localc = t.c.c;
      if (r.b(this.b.a)) {
        paramc = "SYNC";
      } else {
        paramc = "ASYNC";
      }
      paramd.a(str, locald, localc, paramc);
      return;
    }
    com.tencent.luggage.wxa.qz.o.b("Luggage.Standalone.WxaLaunchPreconditionProcess", "AppBrandPreLaunchProcess.onResult, hash:%d, get NULL config, appId:%s, versionType:%d, stack:%s", new Object[] { Integer.valueOf(this.b.a.hashCode()), r.a(this.b.a).b, Integer.valueOf(r.a(this.b.a).d), Log.getStackTraceString(new Throwable()) });
    if (!r.b(this.b.a))
    {
      paramc = r.a(this.b.a).b;
      com.tencent.luggage.wxa.dc.o.c(paramc).a(new r.2.1.1(this, paramc));
    }
    this.a.a(null);
    t.a.a(this.b.a.a, t.d.b, t.c.d, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.r.2.1
 * JD-Core Version:    0.7.0.1
 */