package com.tencent.luggage.wxa.nz;

import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class l
{
  private static AtomicInteger a = new AtomicInteger(1);
  private HashMap<String, d> b = new HashMap();
  
  public static l a()
  {
    return l.a.a();
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
  
  public int b()
  {
    return a.incrementAndGet();
  }
  
  public boolean b(String paramString)
  {
    if (this.b.containsKey(paramString))
    {
      paramString = (d)this.b.remove(paramString);
      if (paramString != null) {
        paramString.a();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.l
 * JD-Core Version:    0.7.0.1
 */