package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.luggage.wxa.nk.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class e$a
{
  private final Map<String, Long> a = new ConcurrentHashMap();
  
  private String c(String paramString1, String paramString2, b paramb)
  {
    return String.format("%s#%s#%s", new Object[] { paramString1, paramString2, paramb.b() });
  }
  
  void a(String paramString1, String paramString2, b paramb)
  {
    paramString1 = c(paramString1, paramString2, paramb);
    this.a.put(paramString1, Long.valueOf(System.currentTimeMillis()));
  }
  
  long b(String paramString1, String paramString2, b paramb)
  {
    paramString1 = c(paramString1, paramString2, paramb);
    boolean bool = this.a.containsKey(paramString1);
    long l = -1L;
    if (bool)
    {
      paramString2 = (Long)this.a.get(paramString1);
      if (paramString2 == null) {
        return -1L;
      }
      l = System.currentTimeMillis() - paramString2.longValue();
      this.a.remove(paramString1);
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.e.a
 * JD-Core Version:    0.7.0.1
 */