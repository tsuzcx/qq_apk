package com.google.protobuf;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class CodedOutputStreamWriter
  implements Writer
{
  private final CodedOutputStream a;
  
  private CodedOutputStreamWriter(CodedOutputStream paramCodedOutputStream)
  {
    this.a = ((CodedOutputStream)Internal.a(paramCodedOutputStream, "output"));
    this.a.a = this;
  }
  
  public static CodedOutputStreamWriter a(CodedOutputStream paramCodedOutputStream)
  {
    if (paramCodedOutputStream.a != null) {
      return paramCodedOutputStream.a;
    }
    return new CodedOutputStreamWriter(paramCodedOutputStream);
  }
  
  private <V> void a(int paramInt, boolean paramBoolean, V paramV, MapEntryLite.Metadata<Boolean, V> paramMetadata)
  {
    this.a.a(paramInt, 2);
    this.a.c(MapEntryLite.a(paramMetadata, Boolean.valueOf(paramBoolean), paramV));
    MapEntryLite.a(this.a, paramMetadata, Boolean.valueOf(paramBoolean), paramV);
  }
  
  private <K, V> void b(int paramInt, MapEntryLite.Metadata<K, V> paramMetadata, Map<K, V> paramMap)
  {
    switch (CodedOutputStreamWriter.1.a[paramMetadata.c.ordinal()])
    {
    default: 
      paramMap = new StringBuilder();
      paramMap.append("does not support key type: ");
      paramMap.append(paramMetadata.c);
      throw new IllegalArgumentException(paramMap.toString());
    case 12: 
      e(paramInt, paramMetadata, paramMap);
      return;
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      d(paramInt, paramMetadata, paramMap);
      return;
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      c(paramInt, paramMetadata, paramMap);
      return;
    }
    Object localObject = paramMap.get(Boolean.FALSE);
    if (localObject != null) {
      a(paramInt, false, localObject, paramMetadata);
    }
    paramMap = paramMap.get(Boolean.TRUE);
    if (paramMap != null) {
      a(paramInt, true, paramMap, paramMetadata);
    }
  }
  
  private <V> void c(int paramInt, MapEntryLite.Metadata<Integer, V> paramMetadata, Map<Integer, V> paramMap)
  {
    int[] arrayOfInt = new int[paramMap.size()];
    Object localObject = paramMap.keySet().iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfInt[i] = ((Integer)((Iterator)localObject).next()).intValue();
      i += 1;
    }
    Arrays.sort(arrayOfInt);
    int k = arrayOfInt.length;
    i = j;
    while (i < k)
    {
      j = arrayOfInt[i];
      localObject = paramMap.get(Integer.valueOf(j));
      this.a.a(paramInt, 2);
      this.a.c(MapEntryLite.a(paramMetadata, Integer.valueOf(j), localObject));
      MapEntryLite.a(this.a, paramMetadata, Integer.valueOf(j), localObject);
      i += 1;
    }
  }
  
  private <V> void d(int paramInt, MapEntryLite.Metadata<Long, V> paramMetadata, Map<Long, V> paramMap)
  {
    long[] arrayOfLong = new long[paramMap.size()];
    Object localObject = paramMap.keySet().iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfLong[i] = ((Long)((Iterator)localObject).next()).longValue();
      i += 1;
    }
    Arrays.sort(arrayOfLong);
    int k = arrayOfLong.length;
    i = j;
    while (i < k)
    {
      long l = arrayOfLong[i];
      localObject = paramMap.get(Long.valueOf(l));
      this.a.a(paramInt, 2);
      this.a.c(MapEntryLite.a(paramMetadata, Long.valueOf(l), localObject));
      MapEntryLite.a(this.a, paramMetadata, Long.valueOf(l), localObject);
      i += 1;
    }
  }
  
  private void d(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      this.a.a(paramInt, (String)paramObject);
      return;
    }
    this.a.a(paramInt, (ByteString)paramObject);
  }
  
  private <V> void e(int paramInt, MapEntryLite.Metadata<String, V> paramMetadata, Map<String, V> paramMap)
  {
    String[] arrayOfString = new String[paramMap.size()];
    Object localObject1 = paramMap.keySet().iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      arrayOfString[i] = ((String)((Iterator)localObject1).next());
      i += 1;
    }
    Arrays.sort(arrayOfString);
    int k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      localObject1 = arrayOfString[i];
      Object localObject2 = paramMap.get(localObject1);
      this.a.a(paramInt, 2);
      this.a.c(MapEntryLite.a(paramMetadata, localObject1, localObject2));
      MapEntryLite.a(this.a, paramMetadata, localObject1, localObject2);
      i += 1;
    }
  }
  
  public Writer.FieldOrder a()
  {
    return Writer.FieldOrder.ASCENDING;
  }
  
  public void a(int paramInt, double paramDouble)
  {
    this.a.a(paramInt, paramDouble);
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.a.a(paramInt, paramFloat);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.f(paramInt1, paramInt2);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.a.a(paramInt, paramLong);
  }
  
  public void a(int paramInt, ByteString paramByteString)
  {
    this.a.a(paramInt, paramByteString);
  }
  
  public <K, V> void a(int paramInt, MapEntryLite.Metadata<K, V> paramMetadata, Map<K, V> paramMap)
  {
    if (this.a.a())
    {
      b(paramInt, paramMetadata, paramMap);
      return;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      this.a.a(paramInt, 2);
      this.a.c(MapEntryLite.a(paramMetadata, localEntry.getKey(), localEntry.getValue()));
      MapEntryLite.a(this.a, paramMetadata, localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof ByteString))
    {
      this.a.b(paramInt, (ByteString)paramObject);
      return;
    }
    this.a.b(paramInt, (MessageLite)paramObject);
  }
  
  public void a(int paramInt, Object paramObject, Schema paramSchema)
  {
    this.a.a(paramInt, (MessageLite)paramObject, paramSchema);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
  }
  
  public void a(int paramInt, List<String> paramList)
  {
    boolean bool = paramList instanceof LazyStringList;
    int i = 0;
    int j = 0;
    if (bool)
    {
      LazyStringList localLazyStringList = (LazyStringList)paramList;
      i = j;
      while (i < paramList.size())
      {
        d(paramInt, localLazyStringList.d(i));
        i += 1;
      }
    }
    while (i < paramList.size())
    {
      this.a.a(paramInt, (String)paramList.get(i));
      i += 1;
    }
  }
  
  public void a(int paramInt, List<?> paramList, Schema paramSchema)
  {
    int i = 0;
    while (i < paramList.size())
    {
      a(paramInt, paramList.get(i), paramSchema);
      i += 1;
    }
  }
  
  public void a(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.a.a(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += CodedOutputStream.i(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      this.a.c(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.a.b(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.a.b(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.a.a(paramInt, paramBoolean);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.a.g(paramInt1, paramInt2);
  }
  
  public void b(int paramInt, long paramLong)
  {
    this.a.e(paramInt, paramLong);
  }
  
  public void b(int paramInt, Object paramObject)
  {
    this.a.a(paramInt, (MessageLite)paramObject);
  }
  
  public void b(int paramInt, Object paramObject, Schema paramSchema)
  {
    this.a.c(paramInt, (MessageLite)paramObject, paramSchema);
  }
  
  public void b(int paramInt, List<ByteString> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      this.a.a(paramInt, (ByteString)paramList.get(i));
      i += 1;
    }
  }
  
  public void b(int paramInt, List<?> paramList, Schema paramSchema)
  {
    int i = 0;
    while (i < paramList.size())
    {
      b(paramInt, paramList.get(i), paramSchema);
      i += 1;
    }
  }
  
  public void b(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.a.a(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += CodedOutputStream.l(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      this.a.c(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.a.e(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.a.e(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public void c(int paramInt, long paramLong)
  {
    this.a.b(paramInt, paramLong);
  }
  
  public void c(int paramInt, Object paramObject)
  {
    this.a.e(paramInt, (MessageLite)paramObject);
  }
  
  public void c(int paramInt, List<?> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      b(paramInt, paramList.get(i));
      i += 1;
    }
  }
  
  public void c(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.a.a(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += CodedOutputStream.f(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      this.a.c(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.a.a(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.a.a(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    this.a.c(paramInt1, paramInt2);
  }
  
  public void d(int paramInt, long paramLong)
  {
    this.a.c(paramInt, paramLong);
  }
  
  public void d(int paramInt, List<?> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      c(paramInt, paramList.get(i));
      i += 1;
    }
  }
  
  public void d(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.a.a(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += CodedOutputStream.g(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      this.a.c(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.a.b(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.a.b(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    this.a.b(paramInt1, paramInt2);
  }
  
  public void e(int paramInt, long paramLong)
  {
    this.a.d(paramInt, paramLong);
  }
  
  public void e(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.a.a(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += CodedOutputStream.i(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      this.a.c(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.a.d(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.a.d(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public void f(int paramInt1, int paramInt2)
  {
    this.a.d(paramInt1, paramInt2);
  }
  
  public void f(int paramInt, List<Float> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.a.a(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += CodedOutputStream.b(((Float)paramList.get(paramInt)).floatValue());
        paramInt += 1;
      }
      this.a.c(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.a.a(((Float)paramList.get(paramInt)).floatValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.a.a(paramInt, ((Float)paramList.get(i)).floatValue());
      i += 1;
    }
  }
  
  public void g(int paramInt1, int paramInt2)
  {
    this.a.e(paramInt1, paramInt2);
  }
  
  public void g(int paramInt, List<Double> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.a.a(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += CodedOutputStream.b(((Double)paramList.get(paramInt)).doubleValue());
        paramInt += 1;
      }
      this.a.c(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.a.a(((Double)paramList.get(paramInt)).doubleValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.a.a(paramInt, ((Double)paramList.get(i)).doubleValue());
      i += 1;
    }
  }
  
  public void h(int paramInt)
  {
    this.a.a(paramInt, 3);
  }
  
  public void h(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.a.a(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += CodedOutputStream.n(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      this.a.c(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.a.g(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.a.g(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public void i(int paramInt)
  {
    this.a.a(paramInt, 4);
  }
  
  public void i(int paramInt, List<Boolean> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.a.a(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += CodedOutputStream.b(((Boolean)paramList.get(paramInt)).booleanValue());
        paramInt += 1;
      }
      this.a.c(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.a.a(((Boolean)paramList.get(paramInt)).booleanValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.a.a(paramInt, ((Boolean)paramList.get(i)).booleanValue());
      i += 1;
    }
  }
  
  public void j(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.a.a(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += CodedOutputStream.j(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      this.a.c(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.a.c(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.a.c(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public void k(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.a.a(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += CodedOutputStream.m(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      this.a.c(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.a.f(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.a.f(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public void l(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.a.a(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += CodedOutputStream.j(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      this.a.c(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.a.e(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.a.e(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public void m(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.a.a(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += CodedOutputStream.k(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      this.a.c(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.a.d(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.a.d(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public void n(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.a.a(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += CodedOutputStream.h(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      this.a.c(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.a.c(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.a.c(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.CodedOutputStreamWriter
 * JD-Core Version:    0.7.0.1
 */