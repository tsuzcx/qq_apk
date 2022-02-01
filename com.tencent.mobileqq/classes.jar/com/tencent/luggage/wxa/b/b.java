package com.tencent.luggage.wxa.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
  extends h
  implements Iterable<h>
{
  private final List<h> d = new ArrayList();
  
  public b a(double paramDouble)
  {
    this.d.add(a.a(paramDouble));
    return this;
  }
  
  public b a(float paramFloat)
  {
    this.d.add(a.a(paramFloat));
    return this;
  }
  
  public b a(int paramInt)
  {
    this.d.add(a.a(paramInt));
    return this;
  }
  
  public b a(int paramInt, double paramDouble)
  {
    this.d.set(paramInt, a.a(paramDouble));
    return this;
  }
  
  public b a(int paramInt, float paramFloat)
  {
    this.d.set(paramInt, a.a(paramFloat));
    return this;
  }
  
  public b a(int paramInt1, int paramInt2)
  {
    this.d.set(paramInt1, a.a(paramInt2));
    return this;
  }
  
  public b a(int paramInt, long paramLong)
  {
    this.d.set(paramInt, a.a(paramLong));
    return this;
  }
  
  public b a(int paramInt, h paramh)
  {
    if (paramh != null)
    {
      this.d.set(paramInt, paramh);
      return this;
    }
    throw new NullPointerException("value is null");
  }
  
  public b a(int paramInt, String paramString)
  {
    this.d.set(paramInt, a.a(paramString));
    return this;
  }
  
  public b a(int paramInt, boolean paramBoolean)
  {
    this.d.set(paramInt, a.a(paramBoolean));
    return this;
  }
  
  public b a(long paramLong)
  {
    this.d.add(a.a(paramLong));
    return this;
  }
  
  public b a(h paramh)
  {
    if (paramh != null)
    {
      this.d.add(paramh);
      return this;
    }
    throw new NullPointerException("value is null");
  }
  
  public b a(String paramString)
  {
    this.d.add(a.a(paramString));
    return this;
  }
  
  public b a(boolean paramBoolean)
  {
    this.d.add(a.a(paramBoolean));
    return this;
  }
  
  void a(i parami)
  {
    parami.a();
    Iterator localIterator = iterator();
    for (int i = 1; localIterator.hasNext(); i = 0)
    {
      if (i == 0) {
        parami.c();
      }
      ((h)localIterator.next()).a(parami);
    }
    parami.b();
  }
  
  public int a_()
  {
    return this.d.size();
  }
  
  public b b(int paramInt)
  {
    this.d.remove(paramInt);
    return this;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public b c()
  {
    return this;
  }
  
  public h c(int paramInt)
  {
    return (h)this.d.get(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (b)paramObject;
    return this.d.equals(paramObject.d);
  }
  
  public int hashCode()
  {
    return this.d.hashCode();
  }
  
  public Iterator<h> iterator()
  {
    return new b.1(this, this.d.iterator());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.b.b
 * JD-Core Version:    0.7.0.1
 */