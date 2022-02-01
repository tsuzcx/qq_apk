package com.tencent.beacon.event;

import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.a.i;
import com.tencent.beacon.base.net.a.k;
import com.tencent.beacon.base.net.a.k.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class e
  implements com.tencent.beacon.a.a.d, Runnable
{
  private final String a;
  private final int b;
  private final com.tencent.beacon.event.a.a c;
  private final Set<Long> d = new HashSet();
  private final Set<Long> e = new HashSet();
  private final String f;
  private boolean g;
  private int h;
  private boolean i;
  private String j;
  
  public e(int paramInt, com.tencent.beacon.event.a.a parama, boolean paramBoolean)
  {
    this.b = paramInt;
    this.c = parama;
    this.g = paramBoolean;
    if (paramBoolean) {
      parama = "t_r_e";
    } else {
      parama = "t_n_e";
    }
    this.a = parama;
    this.h = 48;
    parama = new StringBuilder();
    parama.append("[EventReport (");
    parama.append(this.a);
    parama.append(")]");
    this.f = parama.toString();
  }
  
  private k a(List<EventBean> paramList)
  {
    int k;
    if (this.g) {
      k = 2;
    } else {
      k = 1;
    }
    paramList = com.tencent.beacon.event.c.c.a(paramList);
    String str = com.tencent.beacon.a.c.c.d().f();
    return k.a().a(RequestType.EVENT).a(k).a(com.tencent.beacon.base.net.c.b.a(true), 8081).a(str).a("version", "v2").a(paramList).a();
  }
  
  private void a(List<EventBean> paramList, Set<Long> paramSet)
  {
    paramList = a(paramList);
    com.tencent.beacon.base.util.c.a(this.f, 2, "event request entity: %s", new Object[] { paramList.toString() });
    paramSet = new d(this, this.a, this.c, paramSet, this.j);
    com.tencent.beacon.base.net.d.c().a(paramList).a(paramSet);
  }
  
  private List<EventBean> b()
  {
    Object localObject = new StringBuilder();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      ((StringBuilder)localObject).append((Long)localIterator.next());
      ((StringBuilder)localObject).append(",");
    }
    if (((StringBuilder)localObject).length() > 0) {
      localObject = ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).lastIndexOf(","));
    } else {
      localObject = "";
    }
    return this.c.a(this.a, (String)localObject, this.h);
  }
  
  private void c()
  {
    com.tencent.beacon.a.a.b.a().a(2, this);
  }
  
  public int a()
  {
    return this.h;
  }
  
  public void a(Set<Long> paramSet)
  {
    synchronized (this.d)
    {
      this.d.removeAll(paramSet);
      paramSet.clear();
      return;
    }
  }
  
  public void onEvent(com.tencent.beacon.a.a.c paramc)
  {
    if (paramc.a == 2)
    {
      paramc = (Map)paramc.b.get("d_m");
      if (paramc != null)
      {
        if (this.g)
        {
          this.h = com.tencent.beacon.base.util.b.a((String)paramc.get("realtimeUploadNum"), this.h, 24, 60);
          return;
        }
        this.h = com.tencent.beacon.base.util.b.a((String)paramc.get("normalUploadNum"), this.h, 24, 60);
      }
    }
  }
  
  public void run()
  {
    if (!this.i)
    {
      c();
      this.i = true;
    }
    if ((com.tencent.beacon.base.net.c.d.d()) && (!com.tencent.beacon.base.net.d.c().d())) {
      synchronized (this.d)
      {
        Object localObject1 = this.f;
        com.tencent.beacon.base.util.c.a((String)localObject1, 0, "start read EventBean from DB.", new Object[0]);
        List localList = b();
        if ((localList != null) && (!localList.isEmpty()))
        {
          HashMap localHashMap = new HashMap();
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            localObject1 = (EventBean)localIterator.next();
            long l = ((EventBean)localObject1).getCid();
            this.d.add(Long.valueOf(l));
            this.e.add(Long.valueOf(l));
            Object localObject4 = ((EventBean)localObject1).getEventValue();
            if (localObject4 != null)
            {
              String str = ((EventBean)localObject1).getAppKey();
              localObject3 = (String)localHashMap.get(str);
              localObject1 = localObject3;
              if (localObject3 == null)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(str);
                ((StringBuilder)localObject1).append(": ");
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              localObject3 = (String)((Map)localObject4).get("A100");
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append((String)localObject1);
              ((StringBuilder)localObject4).append((String)localObject3);
              ((StringBuilder)localObject4).append(", ");
              localHashMap.put(str, ((StringBuilder)localObject4).toString());
            }
          }
          localObject1 = new StringBuilder("--logID: \n");
          Object localObject3 = localHashMap.entrySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            ((StringBuilder)localObject1).append((String)((Map.Entry)((Iterator)localObject3).next()).getValue());
            ((StringBuilder)localObject1).append("\n");
          }
          this.j = ((StringBuilder)localObject1).toString();
          localObject1 = this.f;
          com.tencent.beacon.base.util.c.a((String)localObject1, 1, "send LogID: %s", new Object[] { this.j });
          a(localList, this.e);
          localList.clear();
          this.e.clear();
          return;
        }
        localObject1 = this.f;
        com.tencent.beacon.base.util.c.a((String)localObject1, 1, "EventBean List == null. Task end!", new Object[0]);
        com.tencent.beacon.a.b.a.a().a(this.b, false);
        return;
      }
    }
    com.tencent.beacon.a.b.a.a().a(this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.e
 * JD-Core Version:    0.7.0.1
 */