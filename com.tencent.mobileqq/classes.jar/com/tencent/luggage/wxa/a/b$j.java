package com.tencent.luggage.wxa.a;

import java.util.Iterator;
import java.util.List;

class b$j
  implements b.f
{
  private List<b.r> a;
  
  b$j(List<b.r> paramList)
  {
    this.a = paramList;
  }
  
  int a()
  {
    Iterator localIterator = this.a.iterator();
    int i = -2147483648;
    while (localIterator.hasNext())
    {
      b.r localr = (b.r)localIterator.next();
      if (localr.b > i) {
        i = localr.b;
      }
    }
    return i;
  }
  
  public boolean a(b.p paramp, h.al paramal)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (b.a(paramp, (b.r)localIterator.next(), paramal)) {
        return false;
      }
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("not(");
    localStringBuilder.append(this.a);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.b.j
 * JD-Core Version:    0.7.0.1
 */