package com.google.protobuf;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class UnknownFieldSet$Field
{
  private static final Field a = a().a();
  private List<Long> b;
  private List<Integer> c;
  private List<Long> d;
  private List<ByteString> e;
  private List<UnknownFieldSet> f;
  
  public static UnknownFieldSet.Field.Builder a()
  {
    return UnknownFieldSet.Field.Builder.b();
  }
  
  private void b(int paramInt, Writer paramWriter)
  {
    if (paramWriter.a() == Writer.FieldOrder.DESCENDING)
    {
      localObject = this.e;
      localObject = ((List)localObject).listIterator(((List)localObject).size());
      while (((ListIterator)localObject).hasPrevious()) {
        paramWriter.a(paramInt, ((ListIterator)localObject).previous());
      }
    }
    Object localObject = this.e.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramWriter.a(paramInt, (ByteString)((Iterator)localObject).next());
    }
  }
  
  private Object[] g()
  {
    return new Object[] { this.b, this.c, this.d, this.e, this.f };
  }
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.b.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += CodedOutputStream.g(paramInt, ((Long)localIterator.next()).longValue());
    }
    localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      i += CodedOutputStream.k(paramInt, ((Integer)localIterator.next()).intValue());
    }
    localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      i += CodedOutputStream.i(paramInt, ((Long)localIterator.next()).longValue());
    }
    localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      i += CodedOutputStream.c(paramInt, (ByteString)localIterator.next());
    }
    localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      i += CodedOutputStream.f(paramInt, (UnknownFieldSet)localIterator.next());
    }
    return i;
  }
  
  public void a(int paramInt, CodedOutputStream paramCodedOutputStream)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStream.b(paramInt, ((Long)localIterator.next()).longValue());
    }
    localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStream.e(paramInt, ((Integer)localIterator.next()).intValue());
    }
    localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStream.d(paramInt, ((Long)localIterator.next()).longValue());
    }
    localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStream.a(paramInt, (ByteString)localIterator.next());
    }
    localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStream.e(paramInt, (UnknownFieldSet)localIterator.next());
    }
  }
  
  void a(int paramInt, Writer paramWriter)
  {
    List localList = this.b;
    int i = 0;
    paramWriter.c(paramInt, localList, false);
    paramWriter.b(paramInt, this.c, false);
    paramWriter.e(paramInt, this.d, false);
    paramWriter.b(paramInt, this.e);
    if (paramWriter.a() == Writer.FieldOrder.ASCENDING) {
      while (i < this.f.size())
      {
        paramWriter.h(paramInt);
        ((UnknownFieldSet)this.f.get(i)).a(paramWriter);
        paramWriter.i(paramInt);
        i += 1;
      }
    }
    i = this.f.size() - 1;
    while (i >= 0)
    {
      paramWriter.i(paramInt);
      ((UnknownFieldSet)this.f.get(i)).a(paramWriter);
      paramWriter.h(paramInt);
      i -= 1;
    }
  }
  
  public int b(int paramInt)
  {
    Iterator localIterator = this.e.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += CodedOutputStream.d(paramInt, (ByteString)localIterator.next());
    }
    return i;
  }
  
  public List<Long> b()
  {
    return this.b;
  }
  
  public void b(int paramInt, CodedOutputStream paramCodedOutputStream)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      paramCodedOutputStream.b(paramInt, (ByteString)localIterator.next());
    }
  }
  
  public List<Integer> c()
  {
    return this.c;
  }
  
  public List<Long> d()
  {
    return this.d;
  }
  
  public List<ByteString> e()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Field)) {
      return false;
    }
    return Arrays.equals(g(), ((Field)paramObject).g());
  }
  
  public List<UnknownFieldSet> f()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(g());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.UnknownFieldSet.Field
 * JD-Core Version:    0.7.0.1
 */