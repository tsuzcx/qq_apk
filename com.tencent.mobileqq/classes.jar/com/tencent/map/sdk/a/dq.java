package com.tencent.map.sdk.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class dq
  extends dt
  implements Iterable<dt>
{
  private final List<dt> a = new ArrayList();
  
  public final int a()
  {
    return this.a.size();
  }
  
  public final dt a(int paramInt)
  {
    return (dt)this.a.get(paramInt);
  }
  
  public final void a(dt paramdt)
  {
    Object localObject = paramdt;
    if (paramdt == null) {
      localObject = dv.a;
    }
    this.a.add(localObject);
  }
  
  public final Number b()
  {
    if (this.a.size() == 1) {
      return ((dt)this.a.get(0)).b();
    }
    throw new IllegalStateException();
  }
  
  public final String c()
  {
    if (this.a.size() == 1) {
      return ((dt)this.a.get(0)).c();
    }
    throw new IllegalStateException();
  }
  
  public final double d()
  {
    if (this.a.size() == 1) {
      return ((dt)this.a.get(0)).d();
    }
    throw new IllegalStateException();
  }
  
  public final float e()
  {
    if (this.a.size() == 1) {
      return ((dt)this.a.get(0)).e();
    }
    throw new IllegalStateException();
  }
  
  public final boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof dq)) && (((dq)paramObject).a.equals(this.a)));
  }
  
  public final long f()
  {
    if (this.a.size() == 1) {
      return ((dt)this.a.get(0)).f();
    }
    throw new IllegalStateException();
  }
  
  public final int g()
  {
    if (this.a.size() == 1) {
      return ((dt)this.a.get(0)).g();
    }
    throw new IllegalStateException();
  }
  
  public final boolean h()
  {
    if (this.a.size() == 1) {
      return ((dt)this.a.get(0)).h();
    }
    throw new IllegalStateException();
  }
  
  public final int hashCode()
  {
    return this.a.hashCode();
  }
  
  public final Iterator<dt> iterator()
  {
    return this.a.iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.dq
 * JD-Core Version:    0.7.0.1
 */