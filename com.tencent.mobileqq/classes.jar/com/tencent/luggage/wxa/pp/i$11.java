package com.tencent.luggage.wxa.pp;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.luggage.wxa.pw.e;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.ui.c;
import java.lang.ref.WeakReference;

class i$11
  implements View.OnFocusChangeListener
{
  i$11(i parami) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      o.a((u)this.a.f.get(), this.a);
    }
    i.a(this.a, paramBoolean);
    int i;
    if ((paramBoolean) && ((!i.c(this.a).e) || (c.a(i.d(this.a))))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (i.d(this.a) != null) && (i.e(this.a) != null))
    {
      i.d(this.a).requestFocus();
      i.e(this.a).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.i.11
 * JD-Core Version:    0.7.0.1
 */