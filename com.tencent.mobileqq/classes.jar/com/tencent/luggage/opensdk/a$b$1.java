package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.ix.b;
import com.tencent.luggage.wxa.ix.c.a;
import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;

class a$b$1
  implements c.a
{
  a$b$1(a.b paramb) {}
  
  public void a(String paramString, b paramb)
  {
    if (b.a == paramb)
    {
      paramString = a.b.a(this.a).iterator();
      while (paramString.hasNext()) {
        ((Runnable)paramString.next()).run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.a.b.1
 * JD-Core Version:    0.7.0.1
 */