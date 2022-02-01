package com.tencent.luggage.wxa.jp;

import com.tencent.luggage.wxa.jq.a;
import com.tencent.luggage.wxa.jr.e;
import rx.functions.Action1;

class h$1
  implements Action1<e>
{
  public void a(e parame)
  {
    if (this.a != null)
    {
      if (parame.a == 200)
      {
        this.a.a(parame);
        return;
      }
      this.a.b(parame);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.h.1
 * JD-Core Version:    0.7.0.1
 */