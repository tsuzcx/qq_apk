package com.tencent.luggage.wxa.bm;

import com.tencent.luggage.wxa.jx.h;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

class b$2
  extends g.b
{
  b$2(b paramb) {}
  
  public void a()
  {
    b.a(this.a, true);
    if ((b.a(this.a) != null) && (!b.a(this.a).isEmpty()))
    {
      Iterator localIterator = b.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        b.a(this.a, str);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    return "wagame://servicewechat.com/WAGameVConsole.html".equals(paramString);
  }
  
  public InputStream b(String paramString)
  {
    return b.b(this.a).A().c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bm.b.2
 * JD-Core Version:    0.7.0.1
 */