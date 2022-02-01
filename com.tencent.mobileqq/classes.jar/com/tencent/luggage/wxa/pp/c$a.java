package com.tencent.luggage.wxa.pp;

import androidx.collection.ArraySet;
import com.tencent.luggage.wxa.pw.e;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.Iterator;

 enum c$a
{
  private static final ArraySet<c.a.a> a = new ArraySet();
  
  static c a(String paramString, u paramu, e parame)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      c localc = ((c.a.a)localIterator.next()).a(paramString, paramu, parame);
      if (localc != null) {
        return localc;
      }
    }
    if ((!"digit".equalsIgnoreCase(paramString)) && (!"idcard".equalsIgnoreCase(paramString)) && (!"number".equalsIgnoreCase(paramString))) {
      return null;
    }
    return new d(paramString, paramu, parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.c.a
 * JD-Core Version:    0.7.0.1
 */