package com.tencent.luggage.wxa.iu;

import java.util.Comparator;

class d$11
  implements Comparator<t>
{
  d$11(d paramd) {}
  
  public int a(t paramt1, t paramt2)
  {
    if (paramt1 == paramt2) {
      return 0;
    }
    return paramt1.hashCode() - paramt2.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.d.11
 * JD-Core Version:    0.7.0.1
 */