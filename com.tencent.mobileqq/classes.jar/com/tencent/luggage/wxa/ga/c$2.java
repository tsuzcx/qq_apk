package com.tencent.luggage.wxa.ga;

import com.tencent.luggage.wxa.lp.a;
import com.tencent.luggage.wxa.lp.d;
import com.tencent.luggage.wxa.nc.b;
import com.tencent.luggage.wxa.nc.c;
import org.jetbrains.annotations.NotNull;

final class c$2
  implements d
{
  @NotNull
  public a a(int paramInt)
  {
    b localb = new b();
    localb.a("livePlayerId", Integer.valueOf(paramInt));
    return localb;
  }
  
  @NotNull
  public a b(int paramInt)
  {
    c localc = new c();
    localc.a("livePlayerId", Integer.valueOf(paramInt));
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ga.c.2
 * JD-Core Version:    0.7.0.1
 */