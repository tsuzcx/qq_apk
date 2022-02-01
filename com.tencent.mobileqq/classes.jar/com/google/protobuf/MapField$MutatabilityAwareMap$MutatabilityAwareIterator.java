package com.google.protobuf;

import java.util.Iterator;

class MapField$MutatabilityAwareMap$MutatabilityAwareIterator<E>
  implements Iterator<E>
{
  private final MutabilityOracle a;
  private final Iterator<E> b;
  
  MapField$MutatabilityAwareMap$MutatabilityAwareIterator(MutabilityOracle paramMutabilityOracle, Iterator<E> paramIterator)
  {
    this.a = paramMutabilityOracle;
    this.b = paramIterator;
  }
  
  public boolean equals(Object paramObject)
  {
    return this.b.equals(paramObject);
  }
  
  public boolean hasNext()
  {
    return this.b.hasNext();
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public E next()
  {
    return this.b.next();
  }
  
  public void remove()
  {
    this.a.j();
    this.b.remove();
  }
  
  public String toString()
  {
    return this.b.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MapField.MutatabilityAwareMap.MutatabilityAwareIterator
 * JD-Core Version:    0.7.0.1
 */