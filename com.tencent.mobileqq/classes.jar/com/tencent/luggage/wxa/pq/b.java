package com.tencent.luggage.wxa.pq;

import android.view.View;
import android.widget.Filter;
import android.widget.Filter.FilterListener;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.luggage.wxa.pp.ac;
import com.tencent.luggage.wxa.pw.a.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.ArrayList;

public final class b
{
  private final ac a;
  private final e b;
  private final Filter.FilterListener c;
  private final c d;
  private final b.a e;
  private g f = g.b;
  private a g;
  private int h;
  private int i;
  
  public b(ac paramac)
  {
    this.a = paramac;
    this.b = new e(paramac.getContext());
    this.d = new c(paramac, this.b);
    this.a.a(new b.1(this));
    this.a.a(new b.2(this));
    this.a.a(new b.3(this));
    this.a.addTextChangedListener(new b.4(this));
    this.c = new b.5(this);
    this.e = new b.6(this);
  }
  
  private void a(CharSequence paramCharSequence)
  {
    a locala = this.g;
    if (locala == null) {
      return;
    }
    locala.getFilter().filter(paramCharSequence, this.c);
  }
  
  private void e()
  {
    int j = b.7.a[this.f.ordinal()];
    if (j != 1)
    {
      if (j == 2) {
        this.b.d(this.a.getView().getMeasuredWidth());
      }
    }
    else {
      this.b.d(com.tencent.luggage.wxa.qz.l.g(this.a.getContext())[0]);
    }
    j = this.h;
    e locale;
    if (j != 0)
    {
      this.b.b(j);
      locale = this.b;
      locale.d(locale.d() - this.h);
    }
    if (this.i != 0)
    {
      locale = this.b;
      locale.d(locale.d() - this.i);
    }
  }
  
  public void a()
  {
    this.d.a();
    this.g = null;
    this.b.e();
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.b.a(paramOnDismissListener);
  }
  
  void a(g paramg)
  {
    if (paramg != null) {
      this.f = paramg;
    }
    e();
  }
  
  void a(i parami)
  {
    b.a.a(this.e, parami);
  }
  
  public void a(u paramu)
  {
    this.d.a(paramu);
  }
  
  void a(ArrayList<a.b> paramArrayList)
  {
    this.g = new a(this.a.getContext(), paramArrayList);
    this.g.a(this.e);
    this.b.a(this.g);
  }
  
  void b()
  {
    if (this.g == null) {
      return;
    }
    CharSequence localCharSequence = this.a.getText();
    if (!af.a(localCharSequence)) {
      a(localCharSequence);
    }
    this.b.a(this.a.getView());
    this.b.a();
    ((h)this.b.i().getAdapter()).a(this);
    this.d.a(localCharSequence);
  }
  
  public void b(u paramu)
  {
    this.d.b(paramu);
  }
  
  void c()
  {
    if (!this.b.g()) {
      return;
    }
    h localh = (h)this.b.i().getAdapter();
    this.b.e();
    localh.b(this);
  }
  
  void d()
  {
    this.a.getView().clearFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pq.b
 * JD-Core Version:    0.7.0.1
 */