package com.tencent.luggage.wxa.gq;

import com.tencent.luggage.wxa.gv.c;
import com.tencent.luggage.wxa.if.b;

public class h
{
  public static n a(com.tencent.luggage.wxa.gt.d paramd, c paramc, int paramInt, boolean paramBoolean)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if ((paramc != null) && (paramc.a().z)) {
          paramd = new e(paramd, paramc);
        } else {
          paramd = new f(paramd, paramc);
        }
      }
      else {
        paramd = new g(paramd, paramc);
      }
    }
    else {
      paramd = new d(paramd, paramc);
    }
    paramd.a();
    if (paramBoolean) {
      paramd.b();
    }
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gq.h
 * JD-Core Version:    0.7.0.1
 */