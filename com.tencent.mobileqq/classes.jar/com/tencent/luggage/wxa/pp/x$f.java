package com.tencent.luggage.wxa.pp;

import android.view.View;
import com.tencent.luggage.wxa.pv.a;
import com.tencent.luggage.wxa.qz.l;
import com.tencent.mm.plugin.appbrand.ui.c;

final class x$f
  implements x.b
{
  public void a(x paramx)
  {
    if (paramx.isShown()) {
      x.a(paramx).setVisibility(0);
    }
    x.b(paramx).d();
  }
  
  public void a(x paramx, int paramInt)
  {
    if (c.a(paramx))
    {
      paramx.c(8);
      return;
    }
    if (x.a(paramx) != null)
    {
      if (paramInt <= 0) {
        return;
      }
      x.b(paramx, paramInt);
    }
  }
  
  public void b(x paramx)
  {
    if (c.a(paramx))
    {
      paramx.c(8);
      x.f(paramx);
      return;
    }
    if (paramx.isShown()) {
      x.a(paramx).setVisibility(0);
    }
    if (!x.g(paramx))
    {
      x.b(paramx).d();
      return;
    }
    x.b(paramx).c();
  }
  
  public void c(x paramx)
  {
    x.h(paramx).k();
    x.i(paramx);
  }
  
  public void d(x paramx)
  {
    x.h(paramx).i();
    x.j(paramx);
    paramx.a(l.d(x.k(paramx)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.x.f
 * JD-Core Version:    0.7.0.1
 */