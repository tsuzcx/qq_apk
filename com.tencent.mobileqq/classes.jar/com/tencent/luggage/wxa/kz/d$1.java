package com.tencent.luggage.wxa.kz;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.rr.a;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class d$1
  implements Runnable
{
  d$1(d paramd, h paramh, String paramString, WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = d.c().iterator();
    Object localObject1 = null;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = ((d.b)localIterator.next()).a(this.a.q(), this.b);
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    if ((this.c.get() != null) && (((h)this.c.get()).d()))
    {
      if (localObject1 != null)
      {
        int i = d.2.a[((d.e)localObject1.a(0)).ordinal()];
        if (i != 1)
        {
          if (i != 2)
          {
            localObject1 = this.e.b("fail");
          }
          else
          {
            localObject2 = new HashMap(2);
            ((Map)localObject2).put("width", Integer.valueOf(((d.c)((a)localObject1).a(1)).a));
            ((Map)localObject2).put("height", Integer.valueOf(((d.c)((a)localObject1).a(1)).b));
            ((Map)localObject2).put("orientation", ((d.c)((a)localObject1).a(1)).c);
            ((Map)localObject2).put("type", ((d.c)((a)localObject1).a(1)).d);
            localObject1 = this.e.a("ok", (Map)localObject2);
          }
        }
        else {
          localObject1 = this.e.b("fail:file not found");
        }
        ((h)this.c.get()).a(this.d, (String)localObject1);
        return;
      }
      ((h)this.c.get()).a(this.d, this.e.b("fail:file not found"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kz.d.1
 * JD-Core Version:    0.7.0.1
 */