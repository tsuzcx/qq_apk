package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.h;

class x$3
  implements x.a
{
  x$3(x paramx) {}
  
  @NonNull
  public j a(@NonNull com.tencent.luggage.wxa.rt.i parami, Object... paramVarArgs)
  {
    com.tencent.luggage.wxa.rt.i locali = (com.tencent.luggage.wxa.rt.i)paramVarArgs[0];
    boolean bool = ((Boolean)paramVarArgs[1]).booleanValue();
    if (parami.n()) {
      return j.f;
    }
    if (k.d(parami)) {
      return j.k;
    }
    if ((x.b(this.a) > 0L) && (x.c(this.a) + locali.q() > x.b(this.a))) {
      return j.p;
    }
    if (bool)
    {
      if (i.a(locali.l(), parami.l())) {
        return j.a;
      }
      return j.b;
    }
    if (h.a(locali.l(), parami.l(), false)) {
      return j.a;
    }
    return j.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.x.3
 * JD-Core Version:    0.7.0.1
 */