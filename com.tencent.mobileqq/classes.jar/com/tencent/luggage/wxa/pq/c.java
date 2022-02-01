package com.tencent.luggage.wxa.pq;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.luggage.wxa.pp.ac;
import com.tencent.luggage.wxa.pp.k;
import com.tencent.luggage.wxa.pp.k.a;
import com.tencent.luggage.wxa.qx.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.page.u;

final class c
{
  private final ac a;
  private final e b;
  private final k.a c = new c.1(this);
  private u d;
  private int e = -2147483648;
  private boolean f = false;
  
  c(ac paramac, e parame)
  {
    this.a = paramac;
    this.b = parame;
  }
  
  private void a(int paramInt)
  {
    ListView localListView = this.b.i();
    if (localListView == null) {
      return;
    }
    if (!this.b.g()) {
      return;
    }
    if ((1 == paramInt) && (this.f))
    {
      this.e = -2147483648;
      this.f = false;
    }
    localListView.getViewTreeObserver().addOnPreDrawListener(new c.3(this, localListView, paramInt));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = this.e;
    if (((i == -2147483648) || (i >= 0 - paramInt5)) && (paramInt2 - paramInt1 >= paramInt4 + paramInt5))
    {
      this.b.a(this.a.getView());
      this.b.e(paramInt4 + paramInt5 * 2);
      this.b.c(0 - paramInt5);
      return;
    }
    if (paramInt1 - this.a.getView().getHeight() >= paramInt4)
    {
      this.b.a(this.a.getView());
      this.b.e(paramInt5 * 2 + paramInt4);
      this.b.c(-(paramInt4 + paramInt5) - this.a.getView().getHeight());
      return;
    }
    if (paramInt4 <= paramInt3)
    {
      this.b.e(paramInt3);
      this.b.a(this.a.getView());
      paramInt1 = this.e;
      paramInt2 = 0 - paramInt5;
      if (paramInt1 < paramInt2)
      {
        this.b.c(-(paramInt4 + paramInt5) - this.a.getView().getHeight());
        return;
      }
      this.b.c(paramInt2);
      return;
    }
    a(paramInt1, paramInt2, paramInt3, paramInt4 - paramInt3, paramInt5);
  }
  
  private void b(int paramInt)
  {
    if ((this.b.g()) && (this.b.i() != null) && (this.b.i().getAdapter() != null))
    {
      if (this.b.i().getAdapter().getCount() <= 0) {
        return;
      }
      View localView = this.a.getInputPanel();
      if (localView == null) {
        return;
      }
      int k = a.e(this.a.getContext(), 8);
      int m = this.b.i().getChildAt(0).getHeight();
      int j = this.b.i().getAdapter().getCount() * m;
      int n = k * 2;
      int i = j + n;
      paramInt = m * 3 + n;
      if (i > paramInt)
      {
        j = paramInt - n;
        i = paramInt;
        paramInt = j;
      }
      else
      {
        paramInt = j;
      }
      this.b.e(i);
      int[] arrayOfInt = new int[2];
      this.a.getView().getLocationInWindow(arrayOfInt);
      i = arrayOfInt[1];
      j = this.a.getView().getHeight();
      localView.getLocationInWindow(arrayOfInt);
      a(j + i, arrayOfInt[1], m, paramInt, k);
      this.b.a();
      this.e = this.b.c();
    }
  }
  
  void a()
  {
    k.a(this.d).b(this.c);
  }
  
  void a(u paramu)
  {
    this.d = paramu;
    k.a(paramu).a(this.c);
  }
  
  void a(CharSequence paramCharSequence)
  {
    a(2);
    this.e = -2147483648;
    if (!af.a(paramCharSequence)) {
      this.f = true;
    }
    paramCharSequence = this.b.i();
    if (paramCharSequence != null) {
      paramCharSequence.getAdapter().registerDataSetObserver(new c.2(this));
    }
  }
  
  void b(u paramu)
  {
    k.a(paramu).b(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pq.c
 * JD-Core Version:    0.7.0.1
 */