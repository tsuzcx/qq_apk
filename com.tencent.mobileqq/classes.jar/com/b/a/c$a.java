package com.b.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

final class c$a
  implements m.a
{
  private final Map<String, List<m<?>>> a = new HashMap();
  private final c b;
  
  c$a(c paramc)
  {
    this.b = paramc;
  }
  
  private boolean b(m<?> paramm)
  {
    try
    {
      String str = paramm.d();
      if (this.a.containsKey(str))
      {
        List localList = (List)this.a.get(str);
        Object localObject = localList;
        if (localList == null) {
          localObject = new ArrayList();
        }
        paramm.a("waiting-for-response");
        ((List)localObject).add(paramm);
        this.a.put(str, localObject);
        if (u.a) {
          u.b("Request for cacheKey=%s is in flight, putting on hold.", new Object[] { str });
        }
        return true;
      }
      this.a.put(str, null);
      paramm.a(this);
      if (u.a) {
        u.b("new request, sending to network %s", new Object[] { str });
      }
      return false;
    }
    finally {}
  }
  
  public final void a(m<?> paramm)
  {
    try
    {
      paramm = paramm.d();
      List localList = (List)this.a.remove(paramm);
      if ((localList != null) && (!localList.isEmpty()))
      {
        if (u.a) {
          u.a("%d waiting requests for cacheKey=%s; resend to network", new Object[] { Integer.valueOf(localList.size()), paramm });
        }
        m localm = (m)localList.remove(0);
        this.a.put(paramm, localList);
        try
        {
          c.a(this.b).put(localm);
          return;
        }
        catch (InterruptedException paramm)
        {
          u.c("Couldn't add request to queue. %s", new Object[] { paramm.toString() });
          Thread.currentThread().interrupt();
          this.b.a();
        }
      }
      return;
    }
    finally {}
  }
  
  public final void a(m<?> paramm, o<?> paramo)
  {
    if ((paramo.b != null) && (!paramo.b.a()))
    {
      paramm = paramm.d();
      try
      {
        Object localObject = (List)this.a.remove(paramm);
        if (localObject != null)
        {
          if (u.a) {
            u.a("Releasing %d waiting requests for cacheKey=%s.", new Object[] { Integer.valueOf(((List)localObject).size()), paramm });
          }
          paramm = ((List)localObject).iterator();
          while (paramm.hasNext())
          {
            localObject = (m)paramm.next();
            c.b(this.b).a((m)localObject, paramo);
          }
        }
        return;
      }
      finally {}
    }
    a(paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */