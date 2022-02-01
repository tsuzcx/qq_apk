package com.tencent.map.sdk.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class ev
  extends fg
{
  private static final Writer e = new ev.1();
  private static final dy f = new dy("closed");
  public final List<dt> a = new ArrayList();
  public dt b = dv.a;
  private String g;
  
  public ev()
  {
    super(e);
  }
  
  private void a(dt paramdt)
  {
    if (this.g != null)
    {
      if ((!(paramdt instanceof dv)) || (this.d)) {
        ((dw)f()).a(this.g, paramdt);
      }
      this.g = null;
      return;
    }
    if (this.a.isEmpty())
    {
      this.b = paramdt;
      return;
    }
    dt localdt = f();
    if ((localdt instanceof dq))
    {
      ((dq)localdt).a(paramdt);
      return;
    }
    throw new IllegalStateException();
  }
  
  private dt f()
  {
    List localList = this.a;
    return (dt)localList.get(localList.size() - 1);
  }
  
  public final fg a()
  {
    dq localdq = new dq();
    a(localdq);
    this.a.add(localdq);
    return this;
  }
  
  public final fg a(long paramLong)
  {
    a(new dy(Long.valueOf(paramLong)));
    return this;
  }
  
  public final fg a(Number paramNumber)
  {
    if (paramNumber == null) {
      return e();
    }
    if (!this.c)
    {
      double d = paramNumber.doubleValue();
      if ((Double.isNaN(d)) || (Double.isInfinite(d))) {
        throw new IllegalArgumentException("JSON forbids NaN and infinities: ".concat(String.valueOf(paramNumber)));
      }
    }
    a(new dy(paramNumber));
    return this;
  }
  
  public final fg a(String paramString)
  {
    if ((!this.a.isEmpty()) && (this.g == null))
    {
      if ((f() instanceof dw))
      {
        this.g = paramString;
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public final fg a(boolean paramBoolean)
  {
    a(new dy(Boolean.valueOf(paramBoolean)));
    return this;
  }
  
  public final fg b()
  {
    if ((!this.a.isEmpty()) && (this.g == null))
    {
      if ((f() instanceof dq))
      {
        List localList = this.a;
        localList.remove(localList.size() - 1);
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public final fg b(String paramString)
  {
    if (paramString == null) {
      return e();
    }
    a(new dy(paramString));
    return this;
  }
  
  public final fg c()
  {
    dw localdw = new dw();
    a(localdw);
    this.a.add(localdw);
    return this;
  }
  
  public final void close()
  {
    if (this.a.isEmpty())
    {
      this.a.add(f);
      return;
    }
    throw new IOException("Incomplete document");
  }
  
  public final fg d()
  {
    if ((!this.a.isEmpty()) && (this.g == null))
    {
      if ((f() instanceof dw))
      {
        List localList = this.a;
        localList.remove(localList.size() - 1);
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public final fg e()
  {
    a(dv.a);
    return this;
  }
  
  public final void flush() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ev
 * JD-Core Version:    0.7.0.1
 */