package com.tencent.map.sdk.a;

import java.util.LinkedHashMap;

public final class fy$a$a<K, V>
{
  public LinkedHashMap<K, V> a = new fy.a.a.1(this, (int)Math.ceil(13.333333015441895D) + 1);
  int b = 10;
  public byte[] c = new byte[0];
  
  public final V a(K paramK)
  {
    synchronized (this.c)
    {
      paramK = this.a.get(paramK);
      return paramK;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.fy.a.a
 * JD-Core Version:    0.7.0.1
 */