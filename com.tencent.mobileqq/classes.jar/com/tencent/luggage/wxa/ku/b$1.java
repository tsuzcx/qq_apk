package com.tencent.luggage.wxa.ku;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import org.json.JSONObject;

class b$1
  implements Runnable
{
  b$1(b paramb, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public void run()
  {
    if (!this.a.d()) {
      return;
    }
    try
    {
      f.a locala = b.a(this.d).a(this.a, this.b);
      c localc = this.a;
      localc.a(this.c, this.d.a(localc, locala.b, locala.a));
      return;
    }
    catch (Throwable localThrowable)
    {
      o.a("Luggage.BaseNFSApiAsync", localThrowable, "%s.invoke, appId=%s, callbackId=%d", new Object[] { b.a(this.d).getClass().getName(), this.a.getAppId(), Integer.valueOf(this.c) });
      t.a(new b.1.1(this, localThrowable));
      this.a.a(this.c, this.d.b("fail:internal error"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.b.1
 * JD-Core Version:    0.7.0.1
 */