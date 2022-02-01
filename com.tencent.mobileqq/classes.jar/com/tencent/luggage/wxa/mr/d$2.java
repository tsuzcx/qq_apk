package com.tencent.luggage.wxa.mr;

import android.content.Context;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.qz.o;

class d$2
  extends c.c
{
  d$2(d paramd, Context paramContext, com.tencent.luggage.wxa.jx.c paramc) {}
  
  public void c()
  {
    if (d.b != null)
    {
      o.d("MicroMsg.JsApiStartWifi", "unregisterReceiver");
      try
      {
        this.a.unregisterReceiver(d.b);
      }
      catch (Exception localException)
      {
        o.a("MicroMsg.JsApiStartWifi", localException, "", new Object[0]);
      }
      d.a = false;
      d.b = null;
    }
    com.tencent.luggage.wxa.iu.c.b(this.b.getAppId(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mr.d.2
 * JD-Core Version:    0.7.0.1
 */