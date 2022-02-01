package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.a.f;
import com.tencent.beacon.core.d.j;
import com.tencent.beacon.core.d.k;
import com.tencent.beacon.core.info.a;
import com.tencent.beacon.event.UserAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class m
{
  protected RDBean a;
  protected final Context b;
  private final boolean c;
  private boolean d = false;
  private int e = 20000;
  private int f = 0;
  protected Runnable g = new l(this);
  
  public m(Context paramContext)
  {
    this.b = paramContext;
    this.c = a.h(this.b);
    this.d = a.f;
  }
  
  public static void a(Context paramContext)
  {
    com.tencent.beacon.core.a.d.a().a(108, true);
    f.a(paramContext).b().a("HEART_DENGTA", com.tencent.beacon.core.e.b.a()).a();
    com.tencent.beacon.core.e.d.d("[event] heartbeat uploaded success!", new Object[0]);
  }
  
  private Map<String, String> d()
  {
    HashMap localHashMap = new HashMap(4);
    com.tencent.beacon.core.info.e locale = com.tencent.beacon.core.info.e.d(this.b);
    localHashMap.put("A33", locale.k(this.b));
    if (this.c)
    {
      localHashMap.put("A66", "F");
      localHashMap.put("A68", "" + a.b(this.b));
      if (!this.d) {
        break label156;
      }
    }
    label156:
    for (String str = "Y";; str = "N")
    {
      localHashMap.put("A85", str);
      localHashMap.put("A20", locale.p(this.b));
      localHashMap.put("A69", locale.q(this.b));
      return localHashMap;
      localHashMap.put("A66", "B");
      break;
    }
  }
  
  private void e()
  {
    Map localMap = d();
    Context localContext = this.b;
    this.a = s.a(localContext, com.tencent.beacon.core.info.b.b(localContext).a(), "rqd_heartbeat", true, 0L, 0L, localMap, true);
  }
  
  protected void a()
  {
    if (!com.tencent.beacon.core.e.e.c(this.b)) {}
    do
    {
      return;
      k localk = k.a(this.b);
      if (localk != null)
      {
        ArrayList localArrayList = new ArrayList(2);
        localArrayList.add(this.a);
        Object localObject = k.a(this.b).d().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((com.tencent.beacon.core.d.l)((Iterator)localObject).next()).incRealTimeEventCalls();
        }
        localObject = this.b;
        localk.a(new r((Context)localObject, com.tencent.beacon.core.info.b.b((Context)localObject).a(), localArrayList));
      }
      a(b() + 1);
      if (b() % 10 == 0)
      {
        com.tencent.beacon.core.a.d.a().a(108, this.g, 600000L, this.e);
        a(0);
      }
    } while (!this.d);
    f.a(this.b).b().a("active_user_date", com.tencent.beacon.core.e.b.a()).a();
  }
  
  public void a(int paramInt)
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
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    Object localObject1 = com.tencent.beacon.core.e.b.a();
    Object localObject2 = f.a(this.b);
    String str = ((f)localObject2).a("HEART_DENGTA", "");
    localObject2 = ((f)localObject2).a("active_user_date", "");
    if ((((String)localObject1).equals(str)) || (((String)localObject2).equals(localObject1)))
    {
      com.tencent.beacon.core.e.d.i("[event] heartbeat had upload!", new Object[0]);
      return;
    }
    localObject1 = EventStrategyBean.getInstance();
    if (((EventStrategyBean)localObject1).isInPreventEventCode("rqd_heartbeat"))
    {
      com.tencent.beacon.core.e.d.i("[event] rqd_heartbeat not allowed in strategy!", new Object[0]);
      return;
    }
    if (!((EventStrategyBean)localObject1).isUploadByRate("rqd_heartbeat"))
    {
      com.tencent.beacon.core.e.d.i("[event] rqd_heartbeat is sampled by svr rate!", new Object[0]);
      return;
    }
    e();
    if (paramBoolean) {
      i = com.tencent.beacon.core.e.b.a(1800) * 1000;
    }
    com.tencent.beacon.core.a.d.a().a(108, this.g, i, this.e);
  }
  
  public int b()
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
  
  public void c()
  {
    f localf = f.a(this.b);
    String str = localf.a("active_user_date", "");
    if (!com.tencent.beacon.core.e.b.a().equals(str))
    {
      com.tencent.beacon.core.e.d.a("[event] recover a heart beat for active user.", new Object[0]);
      if (UserAction.onUserAction("rqd_heartbeat", true, 0L, 0L, d(), true)) {
        localf.b().a("active_user_date", com.tencent.beacon.core.e.b.a()).a();
      }
      return;
    }
    com.tencent.beacon.core.e.d.i("[event] active user event had upload.", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.m
 * JD-Core Version:    0.7.0.1
 */