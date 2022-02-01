package com.tencent.luggage.wxa.mv;

import android.graphics.Point;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.pd.w;

public class b
  implements com.tencent.luggage.wxa.kp.d
{
  public int[] a(c paramc)
  {
    if (paramc == null) {
      return new int[2];
    }
    if ((paramc instanceof h)) {
      return w.a((h)paramc);
    }
    paramc = com.tencent.luggage.wxa.rh.d.f(paramc.getContext());
    if (paramc == null) {
      return new int[2];
    }
    return new int[] { paramc.x, paramc.y };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mv.b
 * JD-Core Version:    0.7.0.1
 */