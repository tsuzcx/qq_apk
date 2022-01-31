package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.a.c;
import com.tencent.beacon.core.b.a;
import com.tencent.beacon.core.c.h;
import com.tencent.beacon.event.UserAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class f
{
  private RDBean a;
  private Context b;
  private final boolean c;
  private boolean d = false;
  private int e = 20000;
  private int f = 0;
  private Runnable g = new f.1(this);
  
  public f(Context paramContext)
  {
    this.b = paramContext;
    this.c = a.g(this.b);
    this.d = a.a;
  }
  
  private void a(int paramInt)
  {
    try
    {
      this.f = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(Context paramContext)
  {
    com.tencent.beacon.core.a.b.b().a(108, true);
    c.a(paramContext).a().a("HEART_DENGTA", com.tencent.beacon.core.d.i.a()).b();
    com.tencent.beacon.core.d.b.a("[event] heartbeat uploaded success!", new Object[0]);
  }
  
  private Map d()
  {
    HashMap localHashMap = new HashMap(4);
    com.tencent.beacon.core.b.d.a(this.b);
    localHashMap.put("A33", com.tencent.beacon.core.b.d.j(this.b));
    if (this.c)
    {
      localHashMap.put("A66", "F");
      localHashMap.put("A68", a.h(this.b));
      if (!this.d) {
        break label148;
      }
    }
    label148:
    for (String str = "Y";; str = "N")
    {
      localHashMap.put("A85", str);
      localHashMap.put("A20", com.tencent.beacon.core.b.d.g(this.b));
      localHashMap.put("A69", com.tencent.beacon.core.b.d.h(this.b));
      return localHashMap;
      localHashMap.put("A66", "B");
      break;
    }
  }
  
  private int e()
  {
    try
    {
      int i = this.f;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void a()
  {
    if (!com.tencent.beacon.core.d.d.b(this.b)) {}
    do
    {
      return;
      com.tencent.beacon.core.c.i locali = com.tencent.beacon.core.c.i.a(this.b);
      if (locali != null)
      {
        ArrayList localArrayList = new ArrayList(2);
        localArrayList.add(this.a);
        Iterator localIterator = com.tencent.beacon.core.c.i.a(this.b).c().iterator();
        while (localIterator.hasNext()) {
          ((com.tencent.beacon.core.c.j)localIterator.next()).incRealTimeEventCalls();
        }
        locali.a(new i(this.b, com.tencent.beacon.core.b.b.a(this.b).b(), localArrayList));
      }
      a(e() + 1);
      if (e() % 10 == 0)
      {
        com.tencent.beacon.core.a.b.b().a(108, this.g, 600000L, this.e);
        a(0);
      }
    } while (!this.d);
    c.a(this.b).a().a("active_user_date", com.tencent.beacon.core.d.i.a()).b();
  }
  
  public final void b()
  {
    Object localObject1 = com.tencent.beacon.core.d.i.a();
    Object localObject2 = c.a(this.b);
    String str = ((c)localObject2).a("HEART_DENGTA", "");
    localObject2 = ((c)localObject2).a("active_user_date", "");
    if ((((String)localObject1).equals(str)) || (((String)localObject2).equals(localObject1)))
    {
      com.tencent.beacon.core.d.b.c("[event] heartbeat had upload!", new Object[0]);
      return;
    }
    localObject1 = EventStrategyBean.getInstance();
    if (((EventStrategyBean)localObject1).isInPreventEventCode("rqd_heartbeat"))
    {
      com.tencent.beacon.core.d.b.c("[event] rqd_heartbeat not allowed in strategy!", new Object[0]);
      return;
    }
    if (!((EventStrategyBean)localObject1).isUploadByRate("rqd_heartbeat"))
    {
      com.tencent.beacon.core.d.b.c("[event] rqd_heartbeat is sampled by svr rate!", new Object[0]);
      return;
    }
    localObject1 = d();
    this.a = j.a(this.b, null, "rqd_heartbeat", true, 0L, 0L, (Map)localObject1, true, false);
    com.tencent.beacon.core.a.b.b().a(108, this.g, 0L, this.e);
  }
  
  public final void c()
  {
    c localc = c.a(this.b);
    String str = localc.a("active_user_date", "");
    if (!com.tencent.beacon.core.d.i.a().equals(str))
    {
      com.tencent.beacon.core.d.b.b("[event] recover a heart beat for active user.", new Object[0]);
      if (UserAction.onUserAction("rqd_heartbeat", true, 0L, 0L, d(), true)) {
        localc.a().a("active_user_date", com.tencent.beacon.core.d.i.a()).b();
      }
      return;
    }
    com.tencent.beacon.core.d.b.c("[event] active user event had upload.", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.f
 * JD-Core Version:    0.7.0.1
 */