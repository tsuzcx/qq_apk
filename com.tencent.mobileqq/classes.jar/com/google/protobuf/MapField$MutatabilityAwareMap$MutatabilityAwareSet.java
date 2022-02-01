package com.google.protobuf;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class MapField$MutatabilityAwareMap$MutatabilityAwareSet<E>
  implements Set<E>
{
  private final MutabilityOracle a;
  private final Set<E> b;
  
  MapField$MutatabilityAwareMap$MutatabilityAwareSet(MutabilityOracle paramMutabilityOracle, Set<E> paramSet)
  {
    this.a = paramMutabilityOracle;
    this.b = paramSet;
  }
  
  public boolean add(E paramE)
  {
    this.a.j();
    return this.b.add(paramE);
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    this.a.j();
    return this.b.addAll(paramCollection);
  }
  
  public void clear()
  {
    this.a.j();
    this.b.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.b.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return this.b.containsAll(paramCollection);
  }
  
  public boolean equals(Object paramObject)
  {
    return this.b.equals(paramObject);
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public boolean isEmpty()
  {
    return this.b.isEmpty();
  }
  
  public Iterator<E> iterator()
  {
    return new MapField.MutatabilityAwareMap.MutatabilityAwareIterator(this.a, this.b.iterator());
  }
  
  public boolean remove(Object paramObject)
  {
    this.a.j();
    return this.b.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    this.a.j();
    return this.b.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    this.a.j();
    return this.b.retainAll(paramCollection);
  }
  
  public int size()
  {
    return this.b.size();
  }
  
  public Object[] toArray()
  {
    return this.b.toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return this.b.toArray(paramArrayOfT);
  }
  
  public String toString()
  {
    return this.b.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MapField.MutatabilityAwareMap.MutatabilityAwareSet
 * JD-Core Version:    0.7.0.1
 */