package com.tencent.luggage.wxa.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class e
  extends h
  implements Iterable<e.b>
{
  private final List<String> d = new ArrayList();
  private final List<h> e = new ArrayList();
  private transient e.a f = new e.a();
  
  public e a(String paramString)
  {
    if (paramString != null)
    {
      int i = c(paramString);
      if (i != -1)
      {
        this.f.a(i);
        this.d.remove(i);
        this.e.remove(i);
      }
      return this;
    }
    throw new NullPointerException("name is null");
  }
  
  public e a(String paramString, double paramDouble)
  {
    a(paramString, a.a(paramDouble));
    return this;
  }
  
  public e a(String paramString, float paramFloat)
  {
    b(paramString, a.a(paramFloat));
    return this;
  }
  
  public e a(String paramString, int paramInt)
  {
    a(paramString, a.a(paramInt));
    return this;
  }
  
  public e a(String paramString, long paramLong)
  {
    a(paramString, a.a(paramLong));
    return this;
  }
  
  public e a(String paramString, h paramh)
  {
    if (paramString != null)
    {
      if (paramh != null)
      {
        this.f.a(paramString, this.d.size());
        this.d.add(paramString);
        this.e.add(paramh);
        return this;
      }
      throw new NullPointerException("value is null");
    }
    throw new NullPointerException("name is null");
  }
  
  public e a(String paramString1, String paramString2)
  {
    b(paramString1, a.a(paramString2));
    return this;
  }
  
  public e a(String paramString, boolean paramBoolean)
  {
    a(paramString, a.a(paramBoolean));
    return this;
  }
  
  void a(i parami)
  {
    parami.d();
    Iterator localIterator1 = this.d.iterator();
    Iterator localIterator2 = this.e.iterator();
    for (int i = 1; localIterator1.hasNext(); i = 0)
    {
      if (i == 0) {
        parami.g();
      }
      parami.d((String)localIterator1.next());
      parami.f();
      ((h)localIterator2.next()).a(parami);
    }
    parami.e();
  }
  
  public e b(String paramString, double paramDouble)
  {
    b(paramString, a.a(paramDouble));
    return this;
  }
  
  public e b(String paramString, int paramInt)
  {
    b(paramString, a.a(paramInt));
    return this;
  }
  
  public e b(String paramString, long paramLong)
  {
    b(paramString, a.a(paramLong));
    return this;
  }
  
  public e b(String paramString, h paramh)
  {
    if (paramString != null)
    {
      if (paramh != null)
      {
        int i = c(paramString);
        if (i != -1)
        {
          this.e.set(i, paramh);
          return this;
        }
        this.f.a(paramString, this.d.size());
        this.d.add(paramString);
        this.e.add(paramh);
        return this;
      }
      throw new NullPointerException("value is null");
    }
    throw new NullPointerException("name is null");
  }
  
  public e b(String paramString, boolean paramBoolean)
  {
    b(paramString, a.a(paramBoolean));
    return this;
  }
  
  public h b(String paramString)
  {
    if (paramString != null)
    {
      int i = c(paramString);
      if (i != -1) {
        return (h)this.e.get(i);
      }
      return null;
    }
    throw new NullPointerException("name is null");
  }
  
  public int b_()
  {
    return this.d.size();
  }
  
  int c(String paramString)
  {
    int i = this.f.a(paramString);
    if ((i != -1) && (paramString.equals(this.d.get(i)))) {
      return i;
    }
    return this.d.lastIndexOf(paramString);
  }
  
  public List<String> c_()
  {
    return Collections.unmodifiableList(this.d);
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
    paramObject = (e)paramObject;
    return (this.d.equals(paramObject.d)) && (this.e.equals(paramObject.e));
  }
  
  public int hashCode()
  {
    return (this.d.hashCode() + 31) * 31 + this.e.hashCode();
  }
  
  public Iterator<e.b> iterator()
  {
    return new e.1(this, this.d.iterator(), this.e.iterator());
  }
  
  public boolean k()
  {
    return true;
  }
  
  public e l()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.b.e
 * JD-Core Version:    0.7.0.1
 */