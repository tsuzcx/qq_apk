package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.jj.u;
import com.tencent.luggage.wxa.ob.a.a;
import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.lv;
import com.tencent.luggage.wxa.ro.b;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.mm.plugin.appbrand.keylogger.d;
import java.util.Locale;

class r$3$2
  implements e.c<lv>
{
  r$3$2(r.3 param3, b paramb) {}
  
  public void a(lv paramlv)
  {
    if ((paramlv != null) && (paramlv.z != null))
    {
      if (paramlv.z.a != 0)
      {
        String str = String.format(Locale.ENGLISH, "errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramlv.z.a), paramlv.z.b });
        this.a.a(new com.tencent.luggage.wxa.ob.a(a.a.e, paramlv.z.a, r.a(paramlv.z.b)));
        t.a.a(this.b.b.a, t.d.b, t.c.d, str);
        d.c(this.b.a, com.tencent.luggage.wxa.oy.a.d);
        d.c(this.b.a, com.tencent.luggage.wxa.oy.a.b);
        return;
      }
      r.a(this.b.b, true);
      u.a().a(this.b.a, paramlv);
      this.a.a(new Object[] { Boolean.valueOf(true) });
      return;
    }
    this.a.a(new com.tencent.luggage.wxa.ob.a(a.a.e, -1, "Response is NULL"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.r.3.2
 * JD-Core Version:    0.7.0.1
 */