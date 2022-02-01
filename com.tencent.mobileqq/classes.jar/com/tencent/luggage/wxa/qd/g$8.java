package com.tencent.luggage.wxa.qd;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.luggage.wxa.gr.f.a;
import com.tencent.luggage.wxa.gt.c;
import com.tencent.luggage.wxa.if.b;
import com.tencent.luggage.wxa.qz.o;

class g$8
  implements f.a
{
  g$8(g paramg) {}
  
  public void a(b paramb)
  {
    o.d("MicroMsg.Audio.AudioPlayerMgr", "loadCache audio:%s", new Object[] { paramb.a });
    if (paramb != null)
    {
      b localb = this.a.l(paramb.a);
      boolean bool;
      if ((localb != null) && (!TextUtils.isEmpty(localb.c)) && (g.h(this.a).t(localb.c))) {
        bool = true;
      } else {
        bool = false;
      }
      o.d("MicroMsg.Audio.AudioPlayerMgr", "cached:%b", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) && (g.m(this.a) != null)) {
        g.m(this.a).post(new g.8.1(this, paramb));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.g.8
 * JD-Core Version:    0.7.0.1
 */