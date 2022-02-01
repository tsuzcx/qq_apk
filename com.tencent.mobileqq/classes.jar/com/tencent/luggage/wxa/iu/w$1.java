package com.tencent.luggage.wxa.iu;

import java.util.Comparator;

class w$1
  implements Comparator<x>
{
  w$1(w paramw) {}
  
  public int a(x paramx1, x paramx2)
  {
    if (paramx1 == paramx2) {
      return 0;
    }
    return paramx1.hashCode() - paramx2.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.w.1
 * JD-Core Version:    0.7.0.1
 */