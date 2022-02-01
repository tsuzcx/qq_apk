package com.tencent.mm.plugin.appbrand.jsruntime;

import com.tencent.luggage.wxa.qz.c;
import java.util.ArrayList;

class a$3
  implements Runnable
{
  a$3(a parama) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      ArrayList localArrayList = new ArrayList(a.d(this.a));
      a.d(this.a).clear();
      int i = 0;
      while (i < localArrayList.size())
      {
        ??? = (m.a)localArrayList.get(i);
        if (??? != null) {
          ((m.a)???).a();
        }
        i += 1;
      }
      if ((c.a) || (c.b)) {
        synchronized (this.a)
        {
          if (a.d(this.a).size() == 0) {
            return;
          }
          throw new IllegalStateException("OnDestroyListener execute failed. Add Destroy listener recursively is forbidden.");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.a.3
 * JD-Core Version:    0.7.0.1
 */