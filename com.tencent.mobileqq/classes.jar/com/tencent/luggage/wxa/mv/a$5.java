package com.tencent.luggage.wxa.mv;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.fx.a.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.jx.e.a;
import com.tencent.luggage.wxa.kp.f;

class a$5
  implements a.a
{
  a$5(a parama, e parame, c paramc, com.tencent.luggage.wxa.fx.a parama1) {}
  
  public void a()
  {
    a.a(this.d, this.a);
  }
  
  public void a(int paramInt)
  {
    e locale = (e)this.b;
    View localView = a.c(this.d).getView();
    if (locale.getCustomViewContainer().b().findViewById(localView.hashCode()) != null) {
      locale.getCustomViewContainer().b().removeView(a.c(this.d).getView());
    }
  }
  
  public void b()
  {
    this.c.f();
    a.a(this.d, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mv.a.5
 * JD-Core Version:    0.7.0.1
 */