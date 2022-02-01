package com.tencent.luggage.wxa.jp;

import rx.functions.Action1;

class h$2
  implements Action1<com.tencent.luggage.wxa.jr.e>
{
  h$2(h paramh, com.tencent.luggage.wxa.jn.e parame, com.tencent.luggage.wxa.jq.a parama) {}
  
  public void a(com.tencent.luggage.wxa.jr.e parame)
  {
    String str = h.d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Send Tcp Custom:");
    localStringBuilder.append(this.a.a());
    localStringBuilder.append(" response: code=");
    localStringBuilder.append(parame.a);
    com.tencent.luggage.wxa.jm.a.a(str, localStringBuilder.toString());
    if (this.b != null)
    {
      if (parame.a == 200)
      {
        this.b.a(parame);
        return;
      }
      this.b.b(parame);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.h.2
 * JD-Core Version:    0.7.0.1
 */