package com.tencent.luggage.wxa.nz;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class f
{
  private static AtomicInteger a = new AtomicInteger(1);
  private HashMap<String, d> b = new HashMap();
  
  public static f b()
  {
    return f.a.a();
  }
  
  public int a()
  {
    return a.incrementAndGet();
  }
  
  public d a(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      return (d)this.b.get(paramString);
    }
    return null;
  }
  
  public boolean a(String paramString, d paramd)
  {
    if (!this.b.containsKey(paramString))
    {
      this.b.put(paramString, paramd);
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (this.b.containsKey(paramString))
    {
      ((d)this.b.remove(paramString)).a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.f
 * JD-Core Version:    0.7.0.1
 */