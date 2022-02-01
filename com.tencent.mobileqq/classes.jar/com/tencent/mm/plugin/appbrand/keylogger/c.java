package com.tencent.mm.plugin.appbrand.keylogger;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.nk.b;
import com.tencent.luggage.wxa.nk.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  private final Map<String, List<d>> a = new HashMap();
  
  public static c a()
  {
    return c.a.a();
  }
  
  private void a(String paramString, @NonNull c.b paramb)
  {
    paramString = (List)this.a.get(paramString);
    if (paramString == null) {
      return;
    }
    int i = 0;
    while (i < paramString.size())
    {
      paramb.a((d)paramString.get(i));
      i += 1;
    }
  }
  
  public void a(String paramString, d paramd)
  {
    if (paramd == null) {
      return;
    }
    List localList = (List)this.a.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.a.put(paramString, localObject);
    }
    ((List)localObject).add(paramd);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, new c.1(this, paramString2));
  }
  
  public void a(String paramString1, String paramString2, b paramb)
  {
    a(paramString1, new c.3(this, paramString2, paramb));
  }
  
  public void a(String paramString1, String paramString2, b paramb, long paramLong)
  {
    a(paramString1, new c.4(this, paramString2, paramb, paramLong));
  }
  
  public void b(String paramString1, String paramString2)
  {
    a(paramString1, new c.2(this, paramString2));
  }
  
  public void b(String paramString1, String paramString2, b paramb, long paramLong)
  {
    a(paramString1, new c.5(this, paramString2, paramb, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.c
 * JD-Core Version:    0.7.0.1
 */