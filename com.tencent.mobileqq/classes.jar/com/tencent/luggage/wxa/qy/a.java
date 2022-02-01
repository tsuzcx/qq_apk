package com.tencent.luggage.wxa.qy;

import android.os.Looper;
import com.tencent.luggage.wxa.qz.m;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.luggage.wxa.ro.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public final class a
{
  public static a a = new a();
  private a.a b = new a.a();
  private final HashMap<Integer, LinkedList<c>> c = new HashMap();
  private final HashMap<Integer, a.b> d = new HashMap();
  
  private void a(LinkedList<c> paramLinkedList, b paramb)
  {
    if (paramb.d()) {
      Collections.sort(paramLinkedList, new a.2(this));
    }
    c[] arrayOfc = new c[paramLinkedList.size()];
    paramLinkedList.toArray(arrayOfc);
    int j = arrayOfc.length;
    int i = 0;
    while ((i < j) && ((!arrayOfc[i].a(paramb)) || (!paramb.d()))) {
      i += 1;
    }
    if (paramb.c != null) {
      paramb.c.run();
    }
  }
  
  public com.tencent.luggage.wxa.rk.b<c> a(c paramc)
  {
    try
    {
      junit.framework.a.a("EventPoolImpl.add", paramc);
      o.f("MicroMsg.EventCenter", "addListener %s(%d)", new Object[] { paramc, Integer.valueOf(paramc.b()) });
      Object localObject2 = (a.b)this.d.get(Integer.valueOf(paramc.b()));
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.d;
        int i = paramc.b();
        localObject1 = new a.b(this);
        ((HashMap)localObject2).put(Integer.valueOf(i), localObject1);
      }
      paramc = ((a.b)localObject1).a(paramc);
      return paramc;
    }
    finally {}
  }
  
  public void a(b paramb, Looper paramLooper)
  {
    junit.framework.a.a("EventPoolImpl.asyncPublish event", paramb);
    junit.framework.a.a("EventPoolImpl.asyncPublish looper", paramLooper);
    o.f("MicroMsg.EventCenter", "publish %s(%d)", new Object[] { paramb, Integer.valueOf(paramb.c()) });
    new s(paramLooper).a(new a.1(this, paramb));
  }
  
  public boolean a(b paramb)
  {
    junit.framework.a.a("EventPoolImpl.publish", paramb);
    o.f("MicroMsg.EventCenter", "publish %s(%d)", new Object[] { paramb, Integer.valueOf(paramb.c()) });
    for (;;)
    {
      try
      {
        int i = paramb.c();
        localLinkedList = (LinkedList)this.c.get(Integer.valueOf(i));
        if (localLinkedList != null)
        {
          localLinkedList = new LinkedList(localLinkedList);
          bool = true;
          a.b localb = (a.b)this.d.get(Integer.valueOf(i));
          if (localb != null) {
            bool = true;
          }
          if (!bool) {
            o.c("MicroMsg.EventCenter", "No listener for this event %s(%d), Stack: %s.", new Object[] { paramb, Integer.valueOf(i), "" });
          }
          if (localLinkedList != null) {
            a(localLinkedList, paramb);
          }
          if (localb != null) {
            localb.a(h.b(paramb));
          }
          return bool;
        }
      }
      finally {}
      LinkedList localLinkedList = null;
      boolean bool = false;
    }
  }
  
  @Deprecated
  public boolean b(c paramc)
  {
    try
    {
      junit.framework.a.a("EventPoolImpl.add", paramc);
      o.f("MicroMsg.EventCenter", "addListener %s(%d)", new Object[] { paramc, Integer.valueOf(paramc.b()) });
      Object localObject2 = (LinkedList)this.c.get(Integer.valueOf(paramc.b()));
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.c;
        int i = paramc.b();
        localObject1 = new LinkedList();
        ((HashMap)localObject2).put(Integer.valueOf(i), localObject1);
      }
      if (((LinkedList)localObject1).contains(paramc)) {
        return true;
      }
      m.a(paramc);
      boolean bool = ((LinkedList)localObject1).add(paramc);
      return bool;
    }
    finally {}
  }
  
  @Deprecated
  public boolean c(c paramc)
  {
    try
    {
      junit.framework.a.a("EventPoolImpl.remove", paramc);
      boolean bool = false;
      o.f("MicroMsg.EventCenter", "removeListener %s(%d)", new Object[] { paramc, Integer.valueOf(paramc.b()) });
      Object localObject = (LinkedList)this.c.get(Integer.valueOf(paramc.b()));
      if (localObject != null) {
        bool = ((LinkedList)localObject).remove(paramc);
      }
      localObject = (a.b)this.d.get(Integer.valueOf(paramc.b()));
      if (localObject != null)
      {
        ((a.b)localObject).b(paramc);
        bool = true;
      }
      m.b(paramc);
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qy.a
 * JD-Core Version:    0.7.0.1
 */