package com.tencent.luggage.wxa.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class b$q
{
  private List<b.o> a = null;
  
  List<b.o> a()
  {
    return this.a;
  }
  
  void a(b.o paramo)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    int i = 0;
    while (i < this.a.size())
    {
      if (((b.o)this.a.get(i)).a.b > paramo.a.b)
      {
        this.a.add(i, paramo);
        return;
      }
      i += 1;
    }
    this.a.add(paramo);
  }
  
  void a(q paramq)
  {
    List localList = paramq.a;
    if (localList == null) {
      return;
    }
    if (this.a == null) {
      this.a = new ArrayList(localList.size());
    }
    paramq = paramq.a.iterator();
    while (paramq.hasNext()) {
      a((b.o)paramq.next());
    }
  }
  
  void a(b.t paramt)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((b.o)((Iterator)localObject).next()).c == paramt) {
        ((Iterator)localObject).remove();
      }
    }
  }
  
  boolean b()
  {
    List localList = this.a;
    return (localList == null) || (localList.isEmpty());
  }
  
  int c()
  {
    List localList = this.a;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public String toString()
  {
    if (this.a == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((b.o)localIterator.next()).toString());
      localStringBuilder.append('\n');
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.b.q
 * JD-Core Version:    0.7.0.1
 */