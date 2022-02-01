package com.tencent.luggage.wxa.la;

import com.tencent.luggage.wxa.qz.af;

public enum b
{
  public final int d;
  
  private b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public static b a(int paramInt)
  {
    b[] arrayOfb = values();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      if (localb.d == paramInt) {
        return localb;
      }
      i += 1;
    }
    return a;
  }
  
  public static b a(String paramString, b paramb)
  {
    if (af.c(paramString)) {
      return paramb;
    }
    b[] arrayOfb = values();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      if (localb.name().toLowerCase().equals(paramString)) {
        return localb;
      }
      i += 1;
    }
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.la.b
 * JD-Core Version:    0.7.0.1
 */