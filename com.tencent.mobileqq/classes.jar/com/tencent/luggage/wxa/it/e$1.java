package com.tencent.luggage.wxa.it;

import com.tencent.luggage.wxa.in.b;
import com.tencent.luggage.wxa.ir.a;
import com.tencent.mm.picker.base.view.WheelView;

class e$1
  implements b
{
  e$1(e parame) {}
  
  public void a(int paramInt)
  {
    paramInt += 1;
    e locale;
    if (e.a(this.a) == e.b(this.a))
    {
      paramInt = paramInt + e.c(this.a) - 1;
      if (e.c(this.a) == e.d(this.a))
      {
        locale = this.a;
        e.a(locale, e.e(locale), paramInt, e.f(this.a), e.g(this.a), e.h(this.a), e.i(this.a));
      }
      else if (e.c(this.a) == paramInt)
      {
        locale = this.a;
        e.a(locale, e.e(locale), paramInt, e.f(this.a), 31, e.h(this.a), e.i(this.a));
      }
      else if (e.d(this.a) == paramInt)
      {
        locale = this.a;
        e.a(locale, e.e(locale), paramInt, 1, e.g(this.a), e.h(this.a), e.i(this.a));
      }
      else
      {
        locale = this.a;
        e.a(locale, e.e(locale), paramInt, 1, 31, e.h(this.a), e.i(this.a));
      }
    }
    else if (e.e(this.a) == e.a(this.a))
    {
      paramInt = paramInt + e.c(this.a) - 1;
      if (paramInt == e.c(this.a))
      {
        locale = this.a;
        e.a(locale, e.e(locale), paramInt, e.f(this.a), 31, e.h(this.a), e.i(this.a));
      }
      else
      {
        locale = this.a;
        e.a(locale, e.e(locale), paramInt, 1, 31, e.h(this.a), e.i(this.a));
      }
    }
    else if (e.e(this.a) == e.b(this.a))
    {
      if (paramInt == e.d(this.a))
      {
        locale = this.a;
        e.a(locale, e.e(locale), e.j(this.a).getCurrentItem() + 1, 1, e.g(this.a), e.h(this.a), e.i(this.a));
      }
      else
      {
        locale = this.a;
        e.a(locale, e.e(locale), e.j(this.a).getCurrentItem() + 1, 1, 31, e.h(this.a), e.i(this.a));
      }
    }
    else
    {
      locale = this.a;
      e.a(locale, e.e(locale), paramInt, 1, 31, e.h(this.a), e.i(this.a));
    }
    if (e.k(this.a) != null) {
      e.k(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.it.e.1
 * JD-Core Version:    0.7.0.1
 */