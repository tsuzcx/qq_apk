package com.tencent.luggage.wxa.fa;

import android.os.Handler;
import com.tencent.luggage.wxa.mi.b;
import com.tencent.luggage.wxa.mk.c;
import com.tencent.luggage.wxa.nf.h;

public class a
  implements h
{
  private static a a;
  
  public static a a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new a();
        }
      }
      finally {}
    }
    return a;
  }
  
  public b a(com.tencent.luggage.wxa.fx.a parama, Handler paramHandler)
  {
    return new c(paramHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fa.a
 * JD-Core Version:    0.7.0.1
 */