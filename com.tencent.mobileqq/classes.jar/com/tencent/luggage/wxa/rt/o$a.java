package com.tencent.luggage.wxa.rt;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class o$a<From, To>
  implements Iterator<To>
{
  private final Iterator<? extends From> a;
  private From b;
  protected final boolean c;
  private To e;
  private To f;
  private Iterator<? extends To> g;
  
  o$a(Iterator<? extends From> paramIterator)
  {
    this.a = paramIterator;
    this.c = false;
  }
  
  o$a(Iterator<? extends From> paramIterator, boolean paramBoolean)
  {
    this.a = paramIterator;
    this.c = paramBoolean;
  }
  
  protected abstract To a(From paramFrom);
  
  protected abstract Iterator<? extends To> a(From paramFrom, To paramTo);
  
  public boolean hasNext()
  {
    while (this.f == null)
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        this.g = a(localObject, this.e);
        this.b = null;
      }
      localObject = this.g;
      if (localObject != null)
      {
        if (((Iterator)localObject).hasNext())
        {
          this.f = this.g.next();
          continue;
        }
        this.g = null;
        if (this.c)
        {
          this.f = this.e;
          continue;
        }
      }
      if ((!d) && ((this.b != null) || (this.g != null) || (this.f != null))) {
        throw new AssertionError();
      }
      if (!this.a.hasNext())
      {
        this.e = null;
        return false;
      }
      this.b = this.a.next();
      localObject = this.b;
      if (localObject != null)
      {
        this.e = a(localObject);
        if (!this.c) {
          this.f = this.e;
        }
      }
    }
    return true;
  }
  
  public To next()
  {
    if ((this.f == null) && (!hasNext())) {
      throw new NoSuchElementException();
    }
    Object localObject = this.f;
    this.f = null;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.o.a
 * JD-Core Version:    0.7.0.1
 */