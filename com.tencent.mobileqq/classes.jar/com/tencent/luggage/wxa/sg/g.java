package com.tencent.luggage.wxa.sg;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class g
{
  public g.a a;
  private HashMap<String, Object> b = new HashMap();
  
  public g(g.a parama)
  {
    this.a = parama;
  }
  
  public int a()
  {
    return this.a.c.get();
  }
  
  public int a(String paramString)
  {
    return d(paramString, 0);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.b.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString, long paramLong)
  {
    this.b.put(paramString, Long.valueOf(paramLong));
  }
  
  public long b(String paramString, long paramLong)
  {
    paramString = this.b.get(paramString);
    if (paramString == null) {
      return paramLong;
    }
    return ((Long)paramString).longValue();
  }
  
  public void b(String paramString, int paramInt)
  {
    this.a.a.put(paramString, Integer.valueOf(paramInt));
  }
  
  public int c(String paramString, int paramInt)
  {
    paramString = this.b.get(paramString);
    if (paramString == null) {
      return paramInt;
    }
    return ((Integer)paramString).intValue();
  }
  
  public int d(String paramString, int paramInt)
  {
    paramString = this.a.a.get(paramString);
    if (paramString == null) {
      return paramInt;
    }
    return ((Integer)paramString).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sg.g
 * JD-Core Version:    0.7.0.1
 */