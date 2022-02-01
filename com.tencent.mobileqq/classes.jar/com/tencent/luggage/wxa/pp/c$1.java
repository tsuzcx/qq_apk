package com.tencent.luggage.wxa.pp;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;

class c$1
  implements View.OnFocusChangeListener
{
  c$1(c paramc) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((this.a.a(paramBoolean)) && (paramBoolean))
    {
      o.a((u)this.a.e.get(), (ac)this.a.b());
      ((ac)this.a.b()).setInputId(this.a.a());
      o.a((u)this.a.e.get(), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.c.1
 * JD-Core Version:    0.7.0.1
 */