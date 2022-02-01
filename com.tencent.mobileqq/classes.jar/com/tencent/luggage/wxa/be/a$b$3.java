package com.tencent.luggage.wxa.be;

import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

class a$b$3
  implements Runnable
{
  a$b$3(a.b paramb) {}
  
  public void run()
  {
    String str2;
    try
    {
      String str1 = com.tencent.mm.plugin.sight.base.a.a(a.h(this.a.a).c());
    }
    catch (Exception localException)
    {
      o.b("MicroMsg.AppBrandCameraView", "stopRecord, remux failed, callback with origin videoexp = %s", new Object[] { af.a(localException) });
      str2 = null;
    }
    l.a(new a.b.3.1(this, str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.a.b.3
 * JD-Core Version:    0.7.0.1
 */