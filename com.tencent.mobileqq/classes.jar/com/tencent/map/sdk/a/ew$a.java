package com.tencent.map.sdk.a;

import java.lang.reflect.Type;
import java.util.Map;

final class ew$a<K, V>
  extends ee<Map<K, V>>
{
  private final dn b;
  private final Type c;
  private final Type d;
  private final ee<K> e;
  private final ee<V> f;
  private final en<? extends Map<K, V>> g;
  
  public ew$a(dn paramdn, Type paramType1, ee<K> paramee, Type paramType2, ee<V> paramee1, en<? extends Map<K, V>> paramen)
  {
    this.b = paramType1;
    this.c = paramee;
    this.d = paramee1;
    this.e = new fb(paramType1, paramType2, paramee);
    this.f = new fb(paramType1, paramen, paramee1);
    Object localObject;
    this.g = localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.ew.a
 * JD-Core Version:    0.7.0.1
 */