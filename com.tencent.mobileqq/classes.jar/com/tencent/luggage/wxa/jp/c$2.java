package com.tencent.luggage.wxa.jp;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jq.a;
import com.tencent.luggage.wxa.jr.b;
import com.tencent.luggage.wxa.jr.e;
import java.util.Map;

class c$2
  implements a
{
  c$2(c paramc, com.tencent.luggage.wxa.jo.c paramc1, com.tencent.luggage.wxa.jq.c paramc2) {}
  
  public void a(e parame)
  {
    String str = parame.b.a("SID");
    com.tencent.luggage.wxa.jr.c localc = new com.tencent.luggage.wxa.jr.c();
    parame = parame.b;
    localc.a = parame.a("SID");
    localc.b = parame.a("TIMEOUT");
    localc.c = this.a;
    c.b(this.c).put(str, localc);
    parame = this.b;
    if (parame != null) {
      parame.a(localc);
    }
  }
  
  public void b(@Nullable e parame)
  {
    com.tencent.luggage.wxa.jq.c localc = this.b;
    if (localc != null) {
      localc.a(parame);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.c.2
 * JD-Core Version:    0.7.0.1
 */