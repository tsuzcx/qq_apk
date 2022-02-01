package com.tencent.luggage.wxa.mx;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.mz.b;
import com.tencent.luggage.wxa.mz.d;
import com.tencent.luggage.wxa.mz.e;
import org.json.JSONObject;

class a$2
  implements Runnable
{
  a$2(a parama, m paramm, com.tencent.luggage.wxa.fx.a parama1, c paramc, JSONObject paramJSONObject, int paramInt) {}
  
  public void run()
  {
    m localm = this.a;
    if ((localm instanceof b))
    {
      a.a(this.f, this.b);
      a.a(this.f, this.c, this.d, this.a, this.e);
      return;
    }
    if ((localm instanceof e))
    {
      a.b(this.f, this.c, this.d, localm, this.e);
      return;
    }
    if ((localm instanceof d)) {
      a.c(this.f, this.c, this.d, localm, this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mx.a.2
 * JD-Core Version:    0.7.0.1
 */