package com.google.protobuf;

import java.util.Collection;
import java.util.Iterator;

class MapField$MutatabilityAwareMap$MutatabilityAwareCollection<E>
  implements Collection<E>
{
  private final MutabilityOracle a;
  private final Collection<E> b;
  
  MapField$MutatabilityAwareMap$MutatabilityAwareCollection(MutabilityOracle paramMutabilityOracle, Collection<E> paramCollection)
  {
    this.a = paramMutabilityOracle;
    this.b = paramCollection;
  }
  
  public boolean add(E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
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
 * Qualified Name:     com.google.protobuf.MapField.MutatabilityAwareMap.MutatabilityAwareCollection
 * JD-Core Version:    0.7.0.1
 */