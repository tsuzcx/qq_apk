package com.tencent.luggage.wxa.it;

import com.tencent.luggage.wxa.il.c;
import com.tencent.luggage.wxa.ir.a;
import com.tencent.mm.picker.base.view.WheelView;

class e$3
  implements com.tencent.luggage.wxa.in.b
{
  private int b;
  
  e$3(e parame) {}
  
  public void a(int paramInt)
  {
    paramInt = ((Integer)e.o(this.a).getAdapter().a(paramInt)).intValue();
    this.b = ((Integer)e.p(this.a).getAdapter().a(e.p(this.a).getCurrentItem())).intValue();
    if (paramInt == e.q(this.a))
    {
      e.p(this.a).setAdapter(new c(0, e.r(this.a)));
      if (this.b >= e.r(this.a)) {
        e.p(this.a).setCurrentItem(e.r(this.a));
      } else {
        e.p(this.a).setCurrentItem(this.b);
      }
    }
    else if (paramInt == e.s(this.a))
    {
      e.p(this.a).setAdapter(new c(e.t(this.a), 59));
      if (this.b < e.t(this.a)) {
        e.p(this.a).setCurrentItem(0);
      } else {
        e.p(this.a).setCurrentItem(this.b - e.t(this.a));
      }
    }
    else
    {
      e.p(this.a).setAdapter(new c(0, 59));
      e.p(this.a).setCurrentItem(this.b);
    }
    if (e.k(this.a) != null) {
      e.k(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.it.e.3
 * JD-Core Version:    0.7.0.1
 */