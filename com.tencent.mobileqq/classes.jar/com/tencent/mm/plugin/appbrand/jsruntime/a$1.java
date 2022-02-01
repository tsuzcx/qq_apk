package com.tencent.mm.plugin.appbrand.jsruntime;

import java.util.ArrayList;
import java.util.Iterator;

class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public void run()
  {
    synchronized (a.a(this.a))
    {
      ArrayList localArrayList = new ArrayList(a.b(this.a));
      a.b(this.a).clear();
      a.a(this.a, null);
      ??? = localArrayList.iterator();
      while (((Iterator)???).hasNext()) {
        ((p.a)((Iterator)???).next()).a();
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.a.1
 * JD-Core Version:    0.7.0.1
 */