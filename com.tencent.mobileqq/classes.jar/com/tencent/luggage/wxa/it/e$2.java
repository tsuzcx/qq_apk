package com.tencent.luggage.wxa.it;

import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.il.c;
import com.tencent.luggage.wxa.ir.a;
import com.tencent.mm.picker.base.view.WheelView;

class e$2
  implements com.tencent.luggage.wxa.in.b
{
  e$2(e parame) {}
  
  public void a(int paramInt)
  {
    int j = e.a(this.a) + paramInt;
    int i = j;
    if (e.l(this.a)) {
      i = j - 1;
    }
    int k = ((Integer)e.j(this.a).getAdapter().a(e.j(this.a).getCurrentItem())).intValue();
    e.a(this.a, i);
    if ((e.l(this.a)) && (paramInt == -1))
    {
      e.j(this.a).b(0);
      e.m(this.a).b(0);
      e.j(this.a).invalidate();
      e.m(this.a).invalidate();
    }
    else
    {
      e.j(this.a).b(ContextCompat.getColor(e.n(this.a), 2131165207));
      e.m(this.a).b(ContextCompat.getColor(e.n(this.a), 2131165207));
      e.j(this.a).invalidate();
      e.m(this.a).invalidate();
      paramInt = e.j(this.a).getCurrentItem();
      e locale;
      if (e.a(this.a) == e.b(this.a))
      {
        e.j(this.a).setAdapter(new c(e.c(this.a), e.d(this.a), new com.tencent.luggage.wxa.il.b(e.n(this.a))));
        j = paramInt;
        if (paramInt > e.j(this.a).getAdapter().a() - 1)
        {
          j = e.j(this.a).getAdapter().a() - 1;
          e.j(this.a).setCurrentItem(j);
        }
        paramInt = j + e.c(this.a);
        if (e.c(this.a) == e.d(this.a))
        {
          locale = this.a;
          e.a(locale, i, paramInt, e.f(locale), e.g(this.a), e.h(this.a), e.i(this.a));
        }
        else if (paramInt == e.c(this.a))
        {
          locale = this.a;
          e.a(locale, i, paramInt, e.f(locale), 31, e.h(this.a), e.i(this.a));
        }
        else if (paramInt == e.d(this.a))
        {
          locale = this.a;
          e.a(locale, i, paramInt, 1, e.g(locale), e.h(this.a), e.i(this.a));
        }
        else
        {
          locale = this.a;
          e.a(locale, i, paramInt, 1, 31, e.h(locale), e.i(this.a));
        }
      }
      else if (i == e.a(this.a))
      {
        e.j(this.a).setAdapter(new c(e.c(this.a), 12, new com.tencent.luggage.wxa.il.b(e.n(this.a))));
        if (k <= e.c(this.a))
        {
          e.j(this.a).setCurrentItem(0);
          paramInt = e.c(this.a);
        }
        else
        {
          e.j(this.a).setCurrentItem(k - e.c(this.a));
          paramInt = k;
        }
        if (paramInt == e.c(this.a))
        {
          locale = this.a;
          e.a(locale, i, paramInt, e.f(locale), 31, e.h(this.a), e.i(this.a));
        }
        else
        {
          locale = this.a;
          e.a(locale, i, paramInt, 1, 31, e.h(locale), e.i(this.a));
        }
      }
      else if (i == e.b(this.a))
      {
        e.j(this.a).setAdapter(new c(1, e.d(this.a), new com.tencent.luggage.wxa.il.b(e.n(this.a))));
        j = paramInt;
        if (paramInt > e.j(this.a).getAdapter().a() - 1)
        {
          j = e.j(this.a).getAdapter().a() - 1;
          e.j(this.a).setCurrentItem(j);
        }
        if (k >= e.d(this.a)) {
          e.j(this.a).setCurrentItem(e.d(this.a) - 1);
        } else {
          e.j(this.a).setCurrentItem(k - 1);
        }
        paramInt = j + 1;
        if (paramInt == e.d(this.a))
        {
          locale = this.a;
          e.a(locale, i, paramInt, 1, e.g(locale), e.h(this.a), e.i(this.a));
        }
        else
        {
          locale = this.a;
          e.a(locale, i, paramInt, 1, 31, e.h(locale), e.i(this.a));
        }
      }
      else
      {
        e.j(this.a).setAdapter(new c(1, 12, new com.tencent.luggage.wxa.il.b(e.n(this.a))));
        e.j(this.a).setCurrentItem(k - 1);
        locale = this.a;
        e.a(locale, i, e.j(locale).getCurrentItem() + 1, 1, 31, e.h(this.a), e.i(this.a));
      }
    }
    if (e.k(this.a) != null) {
      e.k(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.it.e.2
 * JD-Core Version:    0.7.0.1
 */