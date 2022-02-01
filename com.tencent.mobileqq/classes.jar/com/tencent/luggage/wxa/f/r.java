package com.tencent.luggage.wxa.f;

import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class r
{
  private final ArrayMap<a, SortedSet<q>> a = new ArrayMap();
  
  Set<a> a()
  {
    return this.a.keySet();
  }
  
  public void a(a parama)
  {
    this.a.remove(parama);
  }
  
  public boolean a(q paramq)
  {
    Object localObject = this.a.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (locala.a(paramq))
      {
        localObject = (SortedSet)this.a.get(locala);
        if (((SortedSet)localObject).contains(paramq)) {
          return false;
        }
        ((SortedSet)localObject).add(paramq);
        return true;
      }
    }
    localObject = new TreeSet();
    ((SortedSet)localObject).add(paramq);
    this.a.put(a.a(paramq.a(), paramq.b()), localObject);
    return true;
  }
  
  SortedSet<q> b(a parama)
  {
    return (SortedSet)this.a.get(parama);
  }
  
  void b()
  {
    this.a.clear();
  }
  
  boolean c()
  {
    return this.a.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.r
 * JD-Core Version:    0.7.0.1
 */