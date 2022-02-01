package com.google.protobuf;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class BinaryWriter
  extends ByteOutput
  implements Writer
{
  final ArrayDeque<AllocatedBuffer> a;
  int b;
  private final BufferAllocator c;
  private final int d;
  
  private final void a(int paramInt, BooleanArrayList paramBooleanArrayList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramBooleanArrayList.size() + 10);
      int j = d();
      i = paramBooleanArrayList.size() - 1;
      while (i >= 0)
      {
        a(paramBooleanArrayList.c(i));
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramBooleanArrayList.size() - 1;
    while (i >= 0)
    {
      a(paramInt, paramBooleanArrayList.c(i));
      i -= 1;
    }
  }
  
  private final void a(int paramInt, DoubleArrayList paramDoubleArrayList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramDoubleArrayList.size() * 8 + 10);
      int j = d();
      i = paramDoubleArrayList.size() - 1;
      while (i >= 0)
      {
        c(Double.doubleToRawLongBits(paramDoubleArrayList.c(i)));
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramDoubleArrayList.size() - 1;
    while (i >= 0)
    {
      a(paramInt, paramDoubleArrayList.c(i));
      i -= 1;
    }
  }
  
  private final void a(int paramInt, FloatArrayList paramFloatArrayList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramFloatArrayList.size() * 4 + 10);
      int j = d();
      i = paramFloatArrayList.size() - 1;
      while (i >= 0)
      {
        g(Float.floatToRawIntBits(paramFloatArrayList.c(i)));
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramFloatArrayList.size() - 1;
    while (i >= 0)
    {
      a(paramInt, paramFloatArrayList.c(i));
      i -= 1;
    }
  }
  
  private final void a(int paramInt, IntArrayList paramIntArrayList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramIntArrayList.size() * 10 + 10);
      int j = d();
      i = paramIntArrayList.size() - 1;
      while (i >= 0)
      {
        e(paramIntArrayList.c(i));
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramIntArrayList.size() - 1;
    while (i >= 0)
    {
      e(paramInt, paramIntArrayList.c(i));
      i -= 1;
    }
  }
  
  private final void a(int paramInt, LongArrayList paramLongArrayList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramLongArrayList.size() * 10 + 10);
      int j = d();
      i = paramLongArrayList.size() - 1;
      while (i >= 0)
      {
        a(paramLongArrayList.c(i));
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramLongArrayList.size() - 1;
    while (i >= 0)
    {
      c(paramInt, paramLongArrayList.c(i));
      i -= 1;
    }
  }
  
  static final void a(Writer paramWriter, int paramInt, WireFormat.FieldType paramFieldType, Object paramObject)
  {
    switch (BinaryWriter.1.a[paramFieldType.ordinal()])
    {
    default: 
      paramWriter = new StringBuilder();
      paramWriter.append("Unsupported map value type for: ");
      paramWriter.append(paramFieldType);
      throw new IllegalArgumentException(paramWriter.toString());
    case 17: 
      if ((paramObject instanceof Internal.EnumLite))
      {
        paramWriter.b(paramInt, ((Internal.EnumLite)paramObject).getNumber());
        return;
      }
      if ((paramObject instanceof Integer))
      {
        paramWriter.b(paramInt, ((Integer)paramObject).intValue());
        return;
      }
      throw new IllegalArgumentException("Unexpected type for enum in map.");
    case 16: 
      paramWriter.a(paramInt, (ByteString)paramObject);
      return;
    case 15: 
      paramWriter.b(paramInt, paramObject);
      return;
    case 14: 
      paramWriter.a(paramInt, ((Double)paramObject).doubleValue());
      return;
    case 13: 
      paramWriter.a(paramInt, ((Float)paramObject).floatValue());
      return;
    case 12: 
      paramWriter.c(paramInt, ((Long)paramObject).longValue());
      return;
    case 11: 
      paramWriter.d(paramInt, ((Integer)paramObject).intValue());
      return;
    case 10: 
      paramWriter.a(paramInt, (String)paramObject);
      return;
    case 9: 
      paramWriter.d(paramInt, ((Long)paramObject).longValue());
      return;
    case 8: 
      paramWriter.f(paramInt, ((Integer)paramObject).intValue());
      return;
    case 7: 
      paramWriter.b(paramInt, ((Long)paramObject).longValue());
      return;
    case 6: 
      paramWriter.a(paramInt, ((Integer)paramObject).intValue());
      return;
    case 5: 
      paramWriter.a(paramInt, ((Long)paramObject).longValue());
      return;
    case 4: 
      paramWriter.e(paramInt, ((Integer)paramObject).intValue());
      return;
    case 3: 
      paramWriter.e(paramInt, ((Long)paramObject).longValue());
      return;
    case 2: 
      paramWriter.g(paramInt, ((Integer)paramObject).intValue());
      return;
    }
    paramWriter.a(paramInt, ((Boolean)paramObject).booleanValue());
  }
  
  private final void b(int paramInt, IntArrayList paramIntArrayList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramIntArrayList.size() * 4 + 10);
      int j = d();
      i = paramIntArrayList.size() - 1;
      while (i >= 0)
      {
        g(paramIntArrayList.c(i));
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramIntArrayList.size() - 1;
    while (i >= 0)
    {
      g(paramInt, paramIntArrayList.c(i));
      i -= 1;
    }
  }
  
  private final void b(int paramInt, LongArrayList paramLongArrayList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramLongArrayList.size() * 8 + 10);
      int j = d();
      i = paramLongArrayList.size() - 1;
      while (i >= 0)
      {
        c(paramLongArrayList.c(i));
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramLongArrayList.size() - 1;
    while (i >= 0)
    {
      e(paramInt, paramLongArrayList.c(i));
      i -= 1;
    }
  }
  
  private final void c(int paramInt, IntArrayList paramIntArrayList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramIntArrayList.size() * 5 + 10);
      int j = d();
      i = paramIntArrayList.size() - 1;
      while (i >= 0)
      {
        d(paramIntArrayList.c(i));
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramIntArrayList.size() - 1;
    while (i >= 0)
    {
      d(paramInt, paramIntArrayList.c(i));
      i -= 1;
    }
  }
  
  private final void c(int paramInt, LongArrayList paramLongArrayList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramLongArrayList.size() * 10 + 10);
      int j = d();
      i = paramLongArrayList.size() - 1;
      while (i >= 0)
      {
        b(paramLongArrayList.c(i));
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramLongArrayList.size() - 1;
    while (i >= 0)
    {
      d(paramInt, paramLongArrayList.c(i));
      i -= 1;
    }
  }
  
  private final void d(int paramInt, IntArrayList paramIntArrayList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramIntArrayList.size() * 5 + 10);
      int j = d();
      i = paramIntArrayList.size() - 1;
      while (i >= 0)
      {
        f(paramIntArrayList.c(i));
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramIntArrayList.size() - 1;
    while (i >= 0)
    {
      f(paramInt, paramIntArrayList.c(i));
      i -= 1;
    }
  }
  
  private void d(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      a(paramInt, (String)paramObject);
      return;
    }
    a(paramInt, (ByteString)paramObject);
  }
  
  private static byte e(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if (paramLong < 0L) {
      return 10;
    }
    if ((0x0 & paramLong) != 0L)
    {
      b2 = (byte)6;
      paramLong >>>= 28;
    }
    else
    {
      b2 = 2;
    }
    byte b1 = b2;
    long l = paramLong;
    if ((0xFFE00000 & paramLong) != 0L)
    {
      b1 = (byte)(b2 + 2);
      l = paramLong >>> 14;
    }
    byte b2 = b1;
    if ((l & 0xFFFFC000) != 0L) {
      b2 = (byte)(b1 + 1);
    }
    return b2;
  }
  
  private final void o(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramList.size() * 10 + 10);
      int j = d();
      i = paramList.size() - 1;
      while (i >= 0)
      {
        e(((Integer)paramList.get(i)).intValue());
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      e(paramInt, ((Integer)paramList.get(i)).intValue());
      i -= 1;
    }
  }
  
  private final void p(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramList.size() * 4 + 10);
      int j = d();
      i = paramList.size() - 1;
      while (i >= 0)
      {
        g(((Integer)paramList.get(i)).intValue());
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      g(paramInt, ((Integer)paramList.get(i)).intValue());
      i -= 1;
    }
  }
  
  private final void q(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramList.size() * 10 + 10);
      int j = d();
      i = paramList.size() - 1;
      while (i >= 0)
      {
        a(((Long)paramList.get(i)).longValue());
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      c(paramInt, ((Long)paramList.get(i)).longValue());
      i -= 1;
    }
  }
  
  private final void r(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramList.size() * 8 + 10);
      int j = d();
      i = paramList.size() - 1;
      while (i >= 0)
      {
        c(((Long)paramList.get(i)).longValue());
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      e(paramInt, ((Long)paramList.get(i)).longValue());
      i -= 1;
    }
  }
  
  private final void s(int paramInt, List<Float> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramList.size() * 4 + 10);
      int j = d();
      i = paramList.size() - 1;
      while (i >= 0)
      {
        g(Float.floatToRawIntBits(((Float)paramList.get(i)).floatValue()));
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a(paramInt, ((Float)paramList.get(i)).floatValue());
      i -= 1;
    }
  }
  
  private final void t(int paramInt, List<Double> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramList.size() * 8 + 10);
      int j = d();
      i = paramList.size() - 1;
      while (i >= 0)
      {
        c(Double.doubleToRawLongBits(((Double)paramList.get(i)).doubleValue()));
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a(paramInt, ((Double)paramList.get(i)).doubleValue());
      i -= 1;
    }
  }
  
  private final void u(int paramInt, List<Boolean> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramList.size() + 10);
      int j = d();
      i = paramList.size() - 1;
      while (i >= 0)
      {
        a(((Boolean)paramList.get(i)).booleanValue());
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a(paramInt, ((Boolean)paramList.get(i)).booleanValue());
      i -= 1;
    }
  }
  
  private final void v(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramList.size() * 5 + 10);
      int j = d();
      i = paramList.size() - 1;
      while (i >= 0)
      {
        d(((Integer)paramList.get(i)).intValue());
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      d(paramInt, ((Integer)paramList.get(i)).intValue());
      i -= 1;
    }
  }
  
  private final void w(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramList.size() * 5 + 10);
      int j = d();
      i = paramList.size() - 1;
      while (i >= 0)
      {
        f(((Integer)paramList.get(i)).intValue());
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      f(paramInt, ((Integer)paramList.get(i)).intValue());
      i -= 1;
    }
  }
  
  private final void x(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(paramList.size() * 10 + 10);
      int j = d();
      i = paramList.size() - 1;
      while (i >= 0)
      {
        b(((Long)paramList.get(i)).longValue());
        i -= 1;
      }
      d(d() - j);
      c(paramInt, 2);
      return;
    }
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      d(paramInt, ((Long)paramList.get(i)).longValue());
      i -= 1;
    }
  }
  
  final AllocatedBuffer a(int paramInt)
  {
    return this.c.a(Math.max(paramInt, this.d));
  }
  
  public final Writer.FieldOrder a()
  {
    return Writer.FieldOrder.DESCENDING;
  }
  
  public final void a(int paramInt, double paramDouble)
  {
    e(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void a(int paramInt, float paramFloat)
  {
    g(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    g(paramInt1, paramInt2);
  }
  
  public final void a(int paramInt, long paramLong)
  {
    c(paramInt, paramLong);
  }
  
  public <K, V> void a(int paramInt, MapEntryLite.Metadata<K, V> paramMetadata, Map<K, V> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      int i = d();
      a(this, 2, paramMetadata.e, localEntry.getValue());
      a(this, 1, paramMetadata.c, localEntry.getKey());
      d(d() - i);
      c(paramInt, 2);
    }
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    c(1, 4);
    if ((paramObject instanceof ByteString)) {
      a(3, (ByteString)paramObject);
    } else {
      b(3, paramObject);
    }
    d(2, paramInt);
    c(1, 3);
  }
  
  public final void a(int paramInt, List<String> paramList)
  {
    if ((paramList instanceof LazyStringList))
    {
      LazyStringList localLazyStringList = (LazyStringList)paramList;
      i = paramList.size() - 1;
      while (i >= 0)
      {
        d(paramInt, localLazyStringList.d(i));
        i -= 1;
      }
    }
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a(paramInt, (String)paramList.get(i));
      i -= 1;
    }
  }
  
  public final void a(int paramInt, List<?> paramList, Schema paramSchema)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a(paramInt, paramList.get(i), paramSchema);
      i -= 1;
    }
  }
  
  public final void a(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    if ((paramList instanceof IntArrayList))
    {
      a(paramInt, (IntArrayList)paramList, paramBoolean);
      return;
    }
    o(paramInt, paramList, paramBoolean);
  }
  
  abstract void a(long paramLong);
  
  abstract void a(String paramString);
  
  abstract void a(boolean paramBoolean);
  
  final AllocatedBuffer b()
  {
    return this.c.a(this.d);
  }
  
  final AllocatedBuffer b(int paramInt)
  {
    return this.c.b(Math.max(paramInt, this.d));
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    e(paramInt1, paramInt2);
  }
  
  public final void b(int paramInt, long paramLong)
  {
    e(paramInt, paramLong);
  }
  
  public final void b(int paramInt, List<ByteString> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a(paramInt, (ByteString)paramList.get(i));
      i -= 1;
    }
  }
  
  public final void b(int paramInt, List<?> paramList, Schema paramSchema)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      b(paramInt, paramList.get(i), paramSchema);
      i -= 1;
    }
  }
  
  public final void b(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    if ((paramList instanceof IntArrayList))
    {
      b(paramInt, (IntArrayList)paramList, paramBoolean);
      return;
    }
    p(paramInt, paramList, paramBoolean);
  }
  
  abstract void b(long paramLong);
  
  final AllocatedBuffer c()
  {
    return this.c.b(this.d);
  }
  
  abstract void c(int paramInt);
  
  abstract void c(int paramInt1, int paramInt2);
  
  public final void c(int paramInt, List<?> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      b(paramInt, paramList.get(i));
      i -= 1;
    }
  }
  
  public final void c(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    d(paramInt, paramList, paramBoolean);
  }
  
  abstract void c(long paramLong);
  
  public abstract int d();
  
  abstract void d(int paramInt);
  
  public final void d(int paramInt, List<?> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      c(paramInt, paramList.get(i));
      i -= 1;
    }
  }
  
  public final void d(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    if ((paramList instanceof LongArrayList))
    {
      a(paramInt, (LongArrayList)paramList, paramBoolean);
      return;
    }
    q(paramInt, paramList, paramBoolean);
  }
  
  abstract void e();
  
  abstract void e(int paramInt);
  
  public final void e(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    if ((paramList instanceof LongArrayList))
    {
      b(paramInt, (LongArrayList)paramList, paramBoolean);
      return;
    }
    r(paramInt, paramList, paramBoolean);
  }
  
  abstract void f(int paramInt);
  
  public final void f(int paramInt, List<Float> paramList, boolean paramBoolean)
  {
    if ((paramList instanceof FloatArrayList))
    {
      a(paramInt, (FloatArrayList)paramList, paramBoolean);
      return;
    }
    s(paramInt, paramList, paramBoolean);
  }
  
  abstract void g(int paramInt);
  
  public final void g(int paramInt, List<Double> paramList, boolean paramBoolean)
  {
    if ((paramList instanceof DoubleArrayList))
    {
      a(paramInt, (DoubleArrayList)paramList, paramBoolean);
      return;
    }
    t(paramInt, paramList, paramBoolean);
  }
  
  public final void h(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    a(paramInt, paramList, paramBoolean);
  }
  
  public final void i(int paramInt, List<Boolean> paramList, boolean paramBoolean)
  {
    if ((paramList instanceof BooleanArrayList))
    {
      a(paramInt, (BooleanArrayList)paramList, paramBoolean);
      return;
    }
    u(paramInt, paramList, paramBoolean);
  }
  
  public final void j(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    if ((paramList instanceof IntArrayList))
    {
      c(paramInt, (IntArrayList)paramList, paramBoolean);
      return;
    }
    v(paramInt, paramList, paramBoolean);
  }
  
  public final void k(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    b(paramInt, paramList, paramBoolean);
  }
  
  public final void l(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    e(paramInt, paramList, paramBoolean);
  }
  
  public final void m(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    if ((paramList instanceof IntArrayList))
    {
      d(paramInt, (IntArrayList)paramList, paramBoolean);
      return;
    }
    w(paramInt, paramList, paramBoolean);
  }
  
  public final void n(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    if ((paramList instanceof LongArrayList))
    {
      c(paramInt, (LongArrayList)paramList, paramBoolean);
      return;
    }
    x(paramInt, paramList, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.BinaryWriter
 * JD-Core Version:    0.7.0.1
 */