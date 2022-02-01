package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.luggage.wxa.nk.c.c;
import java.util.Comparator;

class a$2
  implements Comparator<a.a>
{
  a$2(a parama) {}
  
  public int a(a.a parama1, a.a parama2)
  {
    long l1 = parama1.a.a;
    long l2 = parama2.a.a;
    if (l1 > l2) {
      return 1;
    }
    if (l1 < l2) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.a.2
 * JD-Core Version:    0.7.0.1
 */