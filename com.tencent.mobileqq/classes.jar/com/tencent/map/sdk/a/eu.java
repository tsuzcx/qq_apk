package com.tencent.map.sdk.a;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class eu
  extends fe
{
  private static final Reader c = new eu.1();
  private static final Object d = new Object();
  public final List<Object> a = new ArrayList();
  
  public eu(dt paramdt)
  {
    super(c);
    this.a.add(paramdt);
  }
  
  private Object p()
  {
    List localList = this.a;
    return localList.remove(localList.size() - 1);
  }
  
  public final void a()
  {
    a(ff.a);
    dq localdq = (dq)g();
    this.a.add(localdq.iterator());
  }
  
  public final void a(ff paramff)
  {
    if (f() == paramff) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("Expected ");
    localStringBuilder.append(paramff);
    localStringBuilder.append(" but was ");
    localStringBuilder.append(f());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public final void b()
  {
    a(ff.b);
    p();
    p();
  }
  
  public final void c()
  {
    a(ff.c);
    dw localdw = (dw)g();
    this.a.add(localdw.a.entrySet().iterator());
  }
  
  public final void close()
  {
    this.a.clear();
    this.a.add(d);
  }
  
  public final void d()
  {
    a(ff.d);
    p();
    p();
  }
  
  public final boolean e()
  {
    ff localff = f();
    return (localff != ff.d) && (localff != ff.b);
  }
  
  public final ff f()
  {
    boolean bool;
    for (;;)
    {
      if (this.a.isEmpty()) {
        return ff.j;
      }
      localObject = g();
      if (!(localObject instanceof Iterator)) {
        break label104;
      }
      List localList = this.a;
      bool = localList.get(localList.size() - 2) instanceof dw;
      localObject = (Iterator)localObject;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      if (bool) {
        return ff.e;
      }
      this.a.add(((Iterator)localObject).next());
    }
    if (bool) {
      return ff.d;
    }
    return ff.b;
    label104:
    if ((localObject instanceof dw)) {
      return ff.c;
    }
    if ((localObject instanceof dq)) {
      return ff.a;
    }
    if ((localObject instanceof dy))
    {
      localObject = (dy)localObject;
      if ((((dy)localObject).a instanceof String)) {
        return ff.f;
      }
      if ((((dy)localObject).a instanceof Boolean)) {
        return ff.h;
      }
      if ((((dy)localObject).a instanceof Number)) {
        return ff.g;
      }
      throw new AssertionError();
    }
    if ((localObject instanceof dv)) {
      return ff.i;
    }
    if (localObject == d) {
      throw new IllegalStateException("JsonReader is closed");
    }
    Object localObject = new AssertionError();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public final Object g()
  {
    List localList = this.a;
    return localList.get(localList.size() - 1);
  }
  
  public final String h()
  {
    a(ff.e);
    Map.Entry localEntry = (Map.Entry)((Iterator)g()).next();
    this.a.add(localEntry.getValue());
    return (String)localEntry.getKey();
  }
  
  public final String i()
  {
    ff localff = f();
    if ((localff != ff.f) && (localff != ff.g))
    {
      StringBuilder localStringBuilder = new StringBuilder("Expected ");
      localStringBuilder.append(ff.f);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(localff);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    return ((dy)p()).c();
  }
  
  public final boolean j()
  {
    a(ff.h);
    return ((dy)p()).h();
  }
  
  public final void k()
  {
    a(ff.i);
    p();
  }
  
  public final double l()
  {
    ff localff = f();
    if ((localff != ff.g) && (localff != ff.f))
    {
      StringBuilder localStringBuilder = new StringBuilder("Expected ");
      localStringBuilder.append(ff.g);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(localff);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    double d1 = ((dy)g()).d();
    if ((!this.b) && ((Double.isNaN(d1)) || (Double.isInfinite(d1)))) {
      throw new NumberFormatException("JSON forbids NaN and infinities: ".concat(String.valueOf(d1)));
    }
    p();
    return d1;
  }
  
  public final long m()
  {
    ff localff = f();
    if ((localff != ff.g) && (localff != ff.f))
    {
      StringBuilder localStringBuilder = new StringBuilder("Expected ");
      localStringBuilder.append(ff.g);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(localff);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    long l = ((dy)g()).f();
    p();
    return l;
  }
  
  public final int n()
  {
    ff localff = f();
    if ((localff != ff.g) && (localff != ff.f))
    {
      StringBuilder localStringBuilder = new StringBuilder("Expected ");
      localStringBuilder.append(ff.g);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(localff);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    int i = ((dy)g()).g();
    p();
    return i;
  }
  
  public final void o()
  {
    if (f() == ff.e)
    {
      h();
      return;
    }
    p();
  }
  
  public final String toString()
  {
    return getClass().getSimpleName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.eu
 * JD-Core Version:    0.7.0.1
 */