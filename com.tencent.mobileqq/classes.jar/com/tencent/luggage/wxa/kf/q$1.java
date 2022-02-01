package com.tencent.luggage.wxa.kf;

import com.tencent.luggage.wxa.kl.b;
import com.tencent.luggage.wxa.kl.j;
import java.util.HashMap;
import java.util.Map;

class q$1
  implements b
{
  q$1(q paramq, com.tencent.luggage.wxa.jx.c paramc, int paramInt) {}
  
  public void a(j paramj)
  {
    if (paramj.u != 0)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(paramj.u));
      this.a.a(this.b, this.c.a(paramj.v, localHashMap));
      com.tencent.luggage.wxa.ke.c.a(58);
      return;
    }
    paramj = new HashMap();
    paramj.put("errCode", Integer.valueOf(0));
    this.a.a(this.b, this.c.a("ok", paramj));
    com.tencent.luggage.wxa.ke.c.a(58);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.q.1
 * JD-Core Version:    0.7.0.1
 */