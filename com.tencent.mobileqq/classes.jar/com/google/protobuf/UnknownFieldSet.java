package com.google.protobuf;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class UnknownFieldSet
  implements MessageLite
{
  private static final UnknownFieldSet a = new UnknownFieldSet(Collections.emptyMap(), Collections.emptyMap());
  private static final UnknownFieldSet.Parser d = new UnknownFieldSet.Parser();
  private final Map<Integer, UnknownFieldSet.Field> b;
  private final Map<Integer, UnknownFieldSet.Field> c;
  
  private UnknownFieldSet()
  {
    this.b = null;
    this.c = null;
  }
  
  UnknownFieldSet(Map<Integer, UnknownFieldSet.Field> paramMap1, Map<Integer, UnknownFieldSet.Field> paramMap2)
  {
    this.b = paramMap1;
    this.c = paramMap2;
  }
  
  public static UnknownFieldSet.Builder a()
  {
    return UnknownFieldSet.Builder.e();
  }
  
  public static UnknownFieldSet.Builder a(UnknownFieldSet paramUnknownFieldSet)
  {
    return a().a(paramUnknownFieldSet);
  }
  
  public static UnknownFieldSet a(ByteString paramByteString)
  {
    return a().a(paramByteString).a();
  }
  
  public static UnknownFieldSet b()
  {
    return a;
  }
  
  public void a(CodedOutputStream paramCodedOutputStream)
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((UnknownFieldSet.Field)localEntry.getValue()).b(((Integer)localEntry.getKey()).intValue(), paramCodedOutputStream);
    }
  }
  
  void a(Writer paramWriter)
  {
    Map.Entry localEntry;
    if (paramWriter.a() == Writer.FieldOrder.DESCENDING)
    {
      localIterator = this.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        ((UnknownFieldSet.Field)localEntry.getValue()).a(((Integer)localEntry.getKey()).intValue(), paramWriter);
      }
    }
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      ((UnknownFieldSet.Field)localEntry.getValue()).a(((Integer)localEntry.getKey()).intValue(), paramWriter);
    }
  }
  
  void b(Writer paramWriter)
  {
    Map.Entry localEntry;
    if (paramWriter.a() == Writer.FieldOrder.DESCENDING)
    {
      localIterator = this.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        UnknownFieldSet.Field.a((UnknownFieldSet.Field)localEntry.getValue(), ((Integer)localEntry.getKey()).intValue(), paramWriter);
      }
    }
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      UnknownFieldSet.Field.a((UnknownFieldSet.Field)localEntry.getValue(), ((Integer)localEntry.getKey()).intValue(), paramWriter);
    }
  }
  
  public UnknownFieldSet c()
  {
    return a;
  }
  
  public Map<Integer, UnknownFieldSet.Field> d()
  {
    return this.b;
  }
  
  public int e()
  {
    Iterator localIterator = this.b.entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      i += ((UnknownFieldSet.Field)localEntry.getValue()).b(((Integer)localEntry.getKey()).intValue());
    }
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    return ((paramObject instanceof UnknownFieldSet)) && (this.b.equals(((UnknownFieldSet)paramObject).b));
  }
  
  public UnknownFieldSet.Builder f()
  {
    return a();
  }
  
  public UnknownFieldSet.Builder g()
  {
    return a().a(this);
  }
  
  public int getSerializedSize()
  {
    Iterator localIterator = this.b.entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      i += ((UnknownFieldSet.Field)localEntry.getValue()).a(((Integer)localEntry.getKey()).intValue());
    }
    return i;
  }
  
  public final UnknownFieldSet.Parser h()
  {
    return d;
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public boolean isInitialized()
  {
    return true;
  }
  
  public byte[] toByteArray()
  {
    try
    {
      byte[] arrayOfByte = new byte[getSerializedSize()];
      CodedOutputStream localCodedOutputStream = CodedOutputStream.a(arrayOfByte);
      writeTo(localCodedOutputStream);
      localCodedOutputStream.d();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", localIOException);
    }
  }
  
  public ByteString toByteString()
  {
    try
    {
      Object localObject = ByteString.newCodedBuilder(getSerializedSize());
      writeTo(((ByteString.CodedBuilder)localObject).b());
      localObject = ((ByteString.CodedBuilder)localObject).a();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", localIOException);
    }
  }
  
  public String toString()
  {
    return TextFormat.a(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream)
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((UnknownFieldSet.Field)localEntry.getValue()).a(((Integer)localEntry.getKey()).intValue(), paramCodedOutputStream);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.UnknownFieldSet
 * JD-Core Version:    0.7.0.1
 */