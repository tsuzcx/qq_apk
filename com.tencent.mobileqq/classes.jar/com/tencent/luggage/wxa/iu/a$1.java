package com.tencent.luggage.wxa.iu;

import android.text.TextUtils;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.on.c.b;

class a$1
  implements c.b
{
  a$1(a parama, com.tencent.luggage.wxa.jx.c.a parama1, m paramm) {}
  
  public void a(com.tencent.luggage.wxa.on.c.a parama)
  {
    if (a.a(this.c) != null)
    {
      if (!a.a(this.c).d()) {
        return;
      }
      if (parama.a == 0)
      {
        this.a.a();
        return;
      }
      if (TextUtils.isEmpty(parama.b)) {
        parama = "fail:internal error";
      } else {
        parama = parama.b;
      }
      this.a.a(this.b.b(parama));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.a.1
 * JD-Core Version:    0.7.0.1
 */