package com.tencent.luggage.wxa.qk;

import com.tencent.luggage.wxa.ig.e;
import com.tencent.luggage.wxa.qh.b.b;
import com.tencent.luggage.wxa.qz.t;

class d$2
  implements b.b
{
  d$2(d paramd) {}
  
  public void a(int paramInt)
  {
    Object localObject;
    if (paramInt == 1)
    {
      if ((d.b(this.a) != null) && (!d.e(this.a)) && (d.a(this.a) != null))
      {
        localObject = com.tencent.luggage.wxa.qq.b.a(d.b(this.a).a().c, d.b(this.a).e());
        d.a(this.a).a((String)localObject);
        d.f(this.a);
      }
    }
    else if ((paramInt != -2) && (paramInt != 5) && (paramInt != 19))
    {
      if ((paramInt == -1) || (paramInt == 6) || (paramInt == 4))
      {
        t.a(new d.2.2(this));
        localObject = this.a;
        d.a((d)localObject, d.c((d)localObject), paramInt);
      }
    }
    else {
      t.a(new d.2.1(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qk.d.2
 * JD-Core Version:    0.7.0.1
 */