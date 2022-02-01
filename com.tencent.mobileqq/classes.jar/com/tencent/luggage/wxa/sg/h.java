package com.tencent.luggage.wxa.sg;

import com.tencent.luggage.wxa.sh.b;

public class h
{
  public static b a;
  
  public static b a(com.tencent.luggage.wxa.rz.a parama)
  {
    if (parama.e != null) {
      return parama.e;
    }
    int i = Math.max(1, parama.a / 2);
    int j = Math.max(1, i / 3);
    int k = h.1.a[parama.f.ordinal()];
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4)
          {
            if (k != 5) {
              return new d();
            }
            return new a(j, j);
          }
          return new i(i);
        }
        return new f(1000L, 500.0F, i, j);
      }
      return new c(1000L, i, j);
    }
    return new e(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sg.h
 * JD-Core Version:    0.7.0.1
 */