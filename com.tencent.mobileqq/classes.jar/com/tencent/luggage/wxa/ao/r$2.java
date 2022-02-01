package com.tencent.luggage.wxa.ao;

import java.util.Comparator;

final class r$2
  implements Comparator<r.a>
{
  public int a(r.a parama1, r.a parama2)
  {
    if (parama1.c < parama2.c) {
      return -1;
    }
    if (parama2.c < parama1.c) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.r.2
 * JD-Core Version:    0.7.0.1
 */