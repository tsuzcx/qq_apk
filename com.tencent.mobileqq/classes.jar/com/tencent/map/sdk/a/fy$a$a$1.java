package com.tencent.map.sdk.a;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class fy$a$a$1
  extends LinkedHashMap<K, V>
{
  fy$a$a$1(fy.a.a parama, int paramInt)
  {
    super(paramInt, 0.75F, true);
  }
  
  protected final boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    return size() > this.a.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.fy.a.a.1
 * JD-Core Version:    0.7.0.1
 */