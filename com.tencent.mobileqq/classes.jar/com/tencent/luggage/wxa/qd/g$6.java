package com.tencent.luggage.wxa.qd;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.luggage.wxa.gz.c.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;

class g$6
  implements com.tencent.luggage.wxa.gt.b
{
  g$6(g paramg) {}
  
  public void a(com.tencent.luggage.wxa.gm.c paramc) {}
  
  public void a(com.tencent.luggage.wxa.gz.c paramc)
  {
    com.tencent.luggage.wxa.qy.a.a.a(paramc, Looper.getMainLooper());
  }
  
  public void b(com.tencent.luggage.wxa.gz.c paramc)
  {
    com.tencent.luggage.wxa.qy.a.a.a(paramc, Looper.getMainLooper());
  }
  
  public void c(com.tencent.luggage.wxa.gz.c paramc)
  {
    com.tencent.luggage.wxa.qy.a.a.a(paramc, Looper.getMainLooper());
  }
  
  public void d(com.tencent.luggage.wxa.gz.c paramc)
  {
    com.tencent.luggage.wxa.qy.a.a.a(paramc, Looper.getMainLooper());
  }
  
  public void e(com.tencent.luggage.wxa.gz.c paramc)
  {
    com.tencent.luggage.wxa.qy.a.a.a(paramc, Looper.getMainLooper());
    g.c(this.a, paramc.a.c);
  }
  
  public void f(com.tencent.luggage.wxa.gz.c paramc)
  {
    com.tencent.luggage.wxa.qy.a.a.a(paramc, Looper.getMainLooper());
  }
  
  public void g(com.tencent.luggage.wxa.gz.c paramc)
  {
    com.tencent.luggage.wxa.qy.a.a.a(paramc, Looper.getMainLooper());
  }
  
  public void h(com.tencent.luggage.wxa.gz.c paramc)
  {
    com.tencent.luggage.wxa.qy.a.a.a(paramc, Looper.getMainLooper());
  }
  
  public void i(com.tencent.luggage.wxa.gz.c paramc)
  {
    int i = paramc.a.f;
    o.d("MicroMsg.Audio.AudioPlayerMgr", "onError errCode:%d", new Object[] { Integer.valueOf(i) });
    if ((i != 709) && (i != 702) && (i != 703) && (i != 705) && (i != 706)) {
      com.tencent.luggage.wxa.qy.a.a.a(paramc, Looper.getMainLooper());
    } else {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "decode mix cache errors, don't callback to JS");
    }
    if (g.k(this.a) != null)
    {
      com.tencent.luggage.wxa.if.b localb = (com.tencent.luggage.wxa.if.b)g.f(this.a).get(paramc.a.c);
      if (localb == null) {
        return;
      }
      g.k(this.a).b(localb.i, paramc.a.f);
      if (!g.h(this.a).t(localb.c)) {
        if (g.j(this.a).containsKey(localb.c))
        {
          i = ((Integer)g.j(this.a).get(localb.c)).intValue();
          g.j(this.a).put(localb.c, Integer.valueOf(i + 1));
        }
        else
        {
          g.j(this.a).put(localb.c, Integer.valueOf(1));
        }
      }
    }
    g.c(this.a, paramc.a.c);
  }
  
  public void j(com.tencent.luggage.wxa.gz.c paramc)
  {
    if (g.k(this.a) != null)
    {
      com.tencent.luggage.wxa.if.b localb = (com.tencent.luggage.wxa.if.b)g.f(this.a).get(paramc.a.c);
      if (localb == null) {
        return;
      }
      if (localb.q > 1000000L) {
        o.b("MicroMsg.Audio.AudioPlayerMgr", "onRealPlay: %s, invokeCallTime:%d", new Object[] { localb.a, Long.valueOf(localb.q) });
      }
      String str = paramc.a.h;
      paramc = str;
      if (TextUtils.isEmpty(str)) {
        paramc = localb.b;
      }
      g.k(this.a).a(localb.a, paramc, System.currentTimeMillis() - localb.o, localb.p, localb.q, false, localb.c, g.h(this.a).o(localb.a), localb.x, g.h(this.a).q(localb.c));
      if (g.j(this.a).containsKey(localb.c)) {
        g.j(this.a).remove(localb.c);
      }
    }
  }
  
  public void k(com.tencent.luggage.wxa.gz.c paramc) {}
  
  public void l(com.tencent.luggage.wxa.gz.c paramc)
  {
    g.c(this.a, paramc.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.g.6
 * JD-Core Version:    0.7.0.1
 */