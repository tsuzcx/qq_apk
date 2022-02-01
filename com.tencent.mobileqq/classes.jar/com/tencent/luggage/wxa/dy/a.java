package com.tencent.luggage.wxa.dy;

import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.ny.g;

public class a
{
  public static com.tencent.luggage.wxa.ny.a a(com.tencent.luggage.wxa.ed.d paramd)
  {
    int i;
    if ((paramd.i() != null) && ((!com.tencent.luggage.wxa.qz.af.a(paramd.i().S.e)) || (paramd.j().g()))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return new g(paramd);
    }
    return new a.a(paramd, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dy.a
 * JD-Core Version:    0.7.0.1
 */