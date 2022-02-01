package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.jj.s.f;
import com.tencent.luggage.wxa.jj.u;
import com.tencent.luggage.wxa.lz.a;
import com.tencent.luggage.wxa.qw.lv;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.luggage.wxa.ro.h;

final class f$2
  implements e.c<lv>
{
  f$2(String paramString, com.tencent.luggage.wxa.em.d paramd, c paramc) {}
  
  public void a(lv paramlv)
  {
    if (paramlv != null)
    {
      u.a().a(this.a, paramlv);
      paramlv = u.a().b(this.a, new String[] { "versionInfo", "passThroughInfo" });
      if ((paramlv != null) && (paramlv.e() != null))
      {
        if (paramlv.e().a <= this.c.n)
        {
          o.d("Luggage.WxaLaunchPrepareProcess|runProfiled", "after async update, version(%d) no change, appId=%s", new Object[] { Integer.valueOf(paramlv.e().a), this.a });
          f.a(this.b, a.b, paramlv.p);
          return;
        }
        f.a(this.b, a.a, paramlv.p);
        h.a(this.b, paramlv).b(new i()).a(new f.2.2(this, paramlv)).a(new f.2.1(this, paramlv));
        return;
      }
      o.b("Luggage.WxaLaunchPrepareProcess|runProfiled", "after async update, get invalid info, appId=%s", new Object[] { this.a });
      f.a(this.b, a.b, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.f.2
 * JD-Core Version:    0.7.0.1
 */