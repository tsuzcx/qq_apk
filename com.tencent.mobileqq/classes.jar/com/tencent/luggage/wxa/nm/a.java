package com.tencent.luggage.wxa.nm;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jj.j;
import com.tencent.luggage.wxa.qw.mp;
import com.tencent.luggage.wxa.qw.np;

public final class a
{
  @Nullable
  public static np a(@Nullable j paramj)
  {
    np localnp = null;
    if (paramj == null) {
      return null;
    }
    if (2 == paramj.a)
    {
      localnp = new np();
      localnp.a = paramj.b;
      localnp.b = paramj.f;
    }
    return localnp;
  }
  
  @Nullable
  public static mp b(@Nullable j paramj)
  {
    mp localmp1 = null;
    if (paramj == null) {
      return null;
    }
    if (1 == paramj.a)
    {
      localmp1 = new mp();
      localmp1.a = paramj.b;
      localmp1.b = paramj.h;
      localmp1.c = paramj.g;
    }
    mp localmp2 = localmp1;
    if (paramj.h != 0)
    {
      localmp2 = localmp1;
      if (localmp1 == null) {
        localmp2 = new mp();
      }
      localmp2.b = paramj.h;
    }
    return localmp2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nm.a
 * JD-Core Version:    0.7.0.1
 */