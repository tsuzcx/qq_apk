package com.google.protobuf;

import java.util.List;
import java.util.Map;

abstract interface Writer
{
  public abstract Writer.FieldOrder a();
  
  public abstract void a(int paramInt, double paramDouble);
  
  public abstract void a(int paramInt, float paramFloat);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt, long paramLong);
  
  public abstract void a(int paramInt, ByteString paramByteString);
  
  public abstract <K, V> void a(int paramInt, MapEntryLite.Metadata<K, V> paramMetadata, Map<K, V> paramMap);
  
  public abstract void a(int paramInt, Object paramObject);
  
  public abstract void a(int paramInt, Object paramObject, Schema paramSchema);
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(int paramInt, List<String> paramList);
  
  public abstract void a(int paramInt, List<?> paramList, Schema paramSchema);
  
  public abstract void a(int paramInt, List<Integer> paramList, boolean paramBoolean);
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void b(int paramInt1, int paramInt2);
  
  public abstract void b(int paramInt, long paramLong);
  
  public abstract void b(int paramInt, Object paramObject);
  
  @Deprecated
  public abstract void b(int paramInt, Object paramObject, Schema paramSchema);
  
  public abstract void b(int paramInt, List<ByteString> paramList);
  
  @Deprecated
  public abstract void b(int paramInt, List<?> paramList, Schema paramSchema);
  
  public abstract void b(int paramInt, List<Integer> paramList, boolean paramBoolean);
  
  public abstract void c(int paramInt, long paramLong);
  
  @Deprecated
  public abstract void c(int paramInt, Object paramObject);
  
  public abstract void c(int paramInt, List<?> paramList);
  
  public abstract void c(int paramInt, List<Long> paramList, boolean paramBoolean);
  
  public abstract void d(int paramInt1, int paramInt2);
  
  public abstract void d(int paramInt, long paramLong);
  
  @Deprecated
  public abstract void d(int paramInt, List<?> paramList);
  
  public abstract void d(int paramInt, List<Long> paramList, boolean paramBoolean);
  
  public abstract void e(int paramInt1, int paramInt2);
  
  public abstract void e(int paramInt, long paramLong);
  
  public abstract void e(int paramInt, List<Long> paramList, boolean paramBoolean);
  
  public abstract void f(int paramInt1, int paramInt2);
  
  public abstract void f(int paramInt, List<Float> paramList, boolean paramBoolean);
  
  public abstract void g(int paramInt1, int paramInt2);
  
  public abstract void g(int paramInt, List<Double> paramList, boolean paramBoolean);
  
  @Deprecated
  public abstract void h(int paramInt);
  
  public abstract void h(int paramInt, List<Integer> paramList, boolean paramBoolean);
  
  @Deprecated
  public abstract void i(int paramInt);
  
  public abstract void i(int paramInt, List<Boolean> paramList, boolean paramBoolean);
  
  public abstract void j(int paramInt, List<Integer> paramList, boolean paramBoolean);
  
  public abstract void k(int paramInt, List<Integer> paramList, boolean paramBoolean);
  
  public abstract void l(int paramInt, List<Long> paramList, boolean paramBoolean);
  
  public abstract void m(int paramInt, List<Integer> paramList, boolean paramBoolean);
  
  public abstract void n(int paramInt, List<Long> paramList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Writer
 * JD-Core Version:    0.7.0.1
 */