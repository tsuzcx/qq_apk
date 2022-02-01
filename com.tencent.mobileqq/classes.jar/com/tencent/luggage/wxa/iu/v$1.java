package com.tencent.luggage.wxa.iu;

import java.util.Comparator;

class v$1
  implements Comparator<r>
{
  v$1(v paramv) {}
  
  public int a(r paramr1, r paramr2)
  {
    if (paramr1 == paramr2) {
      return 0;
    }
    return paramr1.hashCode() - paramr2.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.v.1
 * JD-Core Version:    0.7.0.1
 */