package com.tencent.luggage.wxa.ov;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.ot.d;
import com.tencent.luggage.wxa.ou.g;
import com.tencent.luggage.wxa.ou.k;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

class m$1
  implements Runnable
{
  m$1(m paramm, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    d locald = (d)e.b(d.class);
    if (locald == null)
    {
      o.b("MicroMsg.AppBrand.Report.kv_14992", "report get null kvReporter");
      return;
    }
    try
    {
      String str = (String)this.a[18];
      if (af.c(str)) {
        break label91;
      }
      int i = str.indexOf('?');
      if (i < 0) {
        str = "";
      } else {
        str = k.a(str.substring(i + 1, str.length()));
      }
      this.a[18] = str;
    }
    catch (Exception localException)
    {
      label82:
      break label82;
    }
    this.a[18] = "";
    label91:
    locald.a(14992, g.a(this.a));
    locald.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ov.m.1
 * JD-Core Version:    0.7.0.1
 */