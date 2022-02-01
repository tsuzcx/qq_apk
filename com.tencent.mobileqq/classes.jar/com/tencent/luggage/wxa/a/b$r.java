package com.tencent.luggage.wxa.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class b$r
{
  List<b.s> a = null;
  int b = 0;
  
  int a()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  b.s a(int paramInt)
  {
    return (b.s)this.a.get(paramInt);
  }
  
  void a(b.s params)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.add(params);
  }
  
  boolean b()
  {
    List localList = this.a;
    return (localList == null) || (localList.isEmpty());
  }
  
  void c()
  {
    this.b += 1000000;
  }
  
  void d()
  {
    this.b += 1000;
  }
  
  void e()
  {
    this.b += 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((b.s)localIterator.next());
      localStringBuilder.append(' ');
    }
    localStringBuilder.append('[');
    localStringBuilder.append(this.b);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.b.r
 * JD-Core Version:    0.7.0.1
 */