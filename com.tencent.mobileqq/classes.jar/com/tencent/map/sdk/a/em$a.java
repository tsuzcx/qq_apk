package com.tencent.map.sdk.a;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

final class em$a
  extends AbstractSet<Map.Entry<K, V>>
{
  em$a(em paramem) {}
  
  public final Iterator<Map.Entry<K, V>> iterator()
  {
    em localem = this.a;
    return new em.b(localem, em.a(localem), (byte)0);
  }
  
  public final int size()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.em.a
 * JD-Core Version:    0.7.0.1
 */