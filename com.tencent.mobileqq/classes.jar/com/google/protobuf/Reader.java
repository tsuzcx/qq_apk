package com.google.protobuf;

import java.util.List;
import java.util.Map;

abstract interface Reader
{
  public abstract <T> T a(Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract <T> T a(Class<T> paramClass, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract void a(List<Double> paramList);
  
  public abstract <T> void a(List<T> paramList, Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract <K, V> void a(Map<K, V> paramMap, MapEntryLite.Metadata<K, V> paramMetadata, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract boolean a();
  
  public abstract int b();
  
  @Deprecated
  public abstract <T> T b(Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite);
  
  @Deprecated
  public abstract <T> T b(Class<T> paramClass, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract void b(List<Float> paramList);
  
  @Deprecated
  public abstract <T> void b(List<T> paramList, Schema<T> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite);
  
  public abstract int c();
  
  public abstract void c(List<Long> paramList);
  
  public abstract void d(List<Long> paramList);
  
  public abstract boolean d();
  
  public abstract double e();
  
  public abstract void e(List<Integer> paramList);
  
  public abstract float f();
  
  public abstract void f(List<Long> paramList);
  
  public abstract long g();
  
  public abstract void g(List<Integer> paramList);
  
  public abstract long h();
  
  public abstract void h(List<Boolean> paramList);
  
  public abstract int i();
  
  public abstract void i(List<String> paramList);
  
  public abstract long j();
  
  public abstract void j(List<String> paramList);
  
  public abstract int k();
  
  public abstract void k(List<ByteString> paramList);
  
  public abstract void l(List<Integer> paramList);
  
  public abstract boolean l();
  
  public abstract String m();
  
  public abstract void m(List<Integer> paramList);
  
  public abstract String n();
  
  public abstract void n(List<Integer> paramList);
  
  public abstract ByteString o();
  
  public abstract void o(List<Long> paramList);
  
  public abstract int p();
  
  public abstract void p(List<Integer> paramList);
  
  public abstract int q();
  
  public abstract void q(List<Long> paramList);
  
  public abstract int r();
  
  public abstract long s();
  
  public abstract int t();
  
  public abstract long u();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Reader
 * JD-Core Version:    0.7.0.1
 */