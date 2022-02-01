package com.tencent.luggage.wxa.nz;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class c
{
  private static AtomicInteger a = new AtomicInteger(1);
  private HashMap<String, b> b = new HashMap();
  
  public static c b()
  {
    return c.a.a();
  }
  
  public int a()
  {
    return a.incrementAndGet();
  }
  
  public b a(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      return (b)this.b.get(paramString);
    }
    return null;
  }
  
  public boolean a(String paramString, b paramb)
  {
    if (!this.b.containsKey(paramString))
    {
      this.b.put(paramString, paramb);
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (this.b.containsKey(paramString))
    {
      ((b)this.b.remove(paramString)).a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.c
 * JD-Core Version:    0.7.0.1
 */