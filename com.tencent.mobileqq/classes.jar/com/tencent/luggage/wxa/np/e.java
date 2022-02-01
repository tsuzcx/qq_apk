package com.tencent.luggage.wxa.np;

import com.tencent.luggage.wxa.iu.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class e
  implements com.tencent.luggage.wxa.jl.b
{
  private final List<com.tencent.luggage.wxa.jl.b> a = new LinkedList();
  
  public e(d paramd)
  {
    this.a.add(new g(paramd));
    this.a.add(new b());
    this.a.add(new c(paramd));
    this.a.add(new a(paramd));
  }
  
  public boolean a(com.tencent.luggage.wxa.jx.c paramc, String paramString)
  {
    if ((paramc != null) && (paramString != null))
    {
      if (paramString.length() == 0) {
        return false;
      }
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        if (((com.tencent.luggage.wxa.jl.b)localIterator.next()).a(paramc, paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public String b(com.tencent.luggage.wxa.jx.c paramc, String paramString)
  {
    if ((paramc != null) && (paramString != null))
    {
      if (paramString.length() == 0) {
        return paramString;
      }
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.luggage.wxa.jl.b localb = (com.tencent.luggage.wxa.jl.b)localIterator.next();
        if (localb.a(paramc, paramString)) {
          return localb.b(paramc, paramString);
        }
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.np.e
 * JD-Core Version:    0.7.0.1
 */