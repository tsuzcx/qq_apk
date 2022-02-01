package com.tencent.luggage.wxa.lp;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.n;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.u;

public abstract class a
  extends n
{
  public final void a(@NonNull m paramm)
  {
    paramm = paramm.getCurrentPageView();
    a(paramm, paramm.getComponentId()).a();
    a(paramm.p(), paramm.getComponentId()).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lp.a
 * JD-Core Version:    0.7.0.1
 */