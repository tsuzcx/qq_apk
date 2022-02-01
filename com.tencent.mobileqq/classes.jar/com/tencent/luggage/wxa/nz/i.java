package com.tencent.luggage.wxa.nz;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class i
{
  private static AtomicInteger a = new AtomicInteger(1);
  private HashMap<String, g> b = new HashMap();
  
  public static i b()
  {
    return i.a.a();
  }
  
  public int a()
  {
    return a.incrementAndGet();
  }
  
  public g a(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      return (g)this.b.get(paramString);
    }
    return null;
  }
  
  public boolean a(String paramString, g paramg)
  {
    if (!this.b.containsKey(paramString))
    {
      this.b.put(paramString, paramg);
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (this.b.containsKey(paramString))
    {
      ((g)this.b.remove(paramString)).a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.i
 * JD-Core Version:    0.7.0.1
 */