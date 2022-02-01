package com.tencent.luggage.wxa.g;

import com.tencent.luggage.wxa.f.q;
import java.util.Comparator;

class a$a
  implements Comparator<q>
{
  public int a(q paramq1, q paramq2)
  {
    int i = paramq1.b() * paramq1.a();
    int j = paramq2.b() * paramq2.a();
    if (j < i) {
      return -1;
    }
    if (j > i) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.g.a.a
 * JD-Core Version:    0.7.0.1
 */