package com.tencent.luggage.wxa.qd;

import com.tencent.luggage.wxa.if.b;
import java.util.Comparator;

public class g$a
  implements Comparator<b>
{
  public g$a(g paramg) {}
  
  public int a(b paramb1, b paramb2)
  {
    if (paramb1.j > paramb2.j) {
      return 1;
    }
    if (paramb1.j < paramb2.j) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.g.a
 * JD-Core Version:    0.7.0.1
 */