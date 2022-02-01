package com.tencent.luggage.wxa.pp;

import androidx.annotation.MainThread;
import com.tencent.luggage.wxa.pw.h;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;

public final class j
{
  private c a(u paramu, int paramInt)
  {
    paramu = e.a(paramu, new j.1(this, paramInt));
    if ((paramu instanceof c)) {
      return (c)paramu;
    }
    return null;
  }
  
  public static j a()
  {
    return j.a.a();
  }
  
  @MainThread
  private void a(u paramu, c paramc)
  {
    e.a(paramu, paramc);
  }
  
  @MainThread
  public Integer a(com.tencent.luggage.wxa.pw.e parame, String paramString, int paramInt1, int paramInt2, u paramu)
  {
    c localc = c.a.a(parame.c, paramu, parame);
    if (localc == null) {
      return null;
    }
    if (parame.i != null) {
      localc.a(parame.i);
    }
    localc.a(parame);
    if (parame.g != null) {
      localc.a(parame.g);
    }
    if (!localc.a(parame.j.intValue(), parame.k.intValue(), parame.m.intValue(), parame.l.intValue())) {
      return null;
    }
    if (!localc.a(paramInt1, paramInt2, paramu.y().i_())) {
      return null;
    }
    parame = new WeakReference(paramu);
    l.a(paramu);
    paramInt1 = localc.a();
    ((ac)localc.b()).setOnKeyUpPostImeListener(new j.2(this, parame, localc, paramString));
    localc.a(new j.3(this, parame, localc, paramInt1, paramString));
    localc.a(new j.4(this, parame, paramInt1));
    a(paramu, localc);
    return Integer.valueOf(paramInt1);
  }
  
  @MainThread
  public boolean a(u paramu, int paramInt, h paramh)
  {
    paramu = a(paramu, paramInt);
    if (paramu != null)
    {
      if (paramh.i != null) {
        paramu.a(paramh.i);
      }
      paramu.a(paramh);
      paramu.c();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.j
 * JD-Core Version:    0.7.0.1
 */