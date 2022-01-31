package com.tencent.beacon.a.b;

import android.content.Context;
import com.tencent.beacon.a.a.b;
import com.tencent.beacon.a.a.c;
import com.tencent.beacon.a.f.h;
import com.tencent.beacon.event.UserAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e
{
  private g a;
  private Context b;
  private final boolean c;
  private boolean d = false;
  private int e = 20000;
  private int f = 0;
  private Runnable g = new Runnable()
  {
    public final void run()
    {
      try
      {
        e.this.a();
        return;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.a.g.a.a(localThrowable);
      }
    }
  };
  
  public e(Context paramContext)
  {
    this.b = paramContext;
    this.c = com.tencent.beacon.a.c.a.g(this.b);
    this.d = com.tencent.beacon.a.c.a.a;
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
    b.a().a(108);
    c.a(paramContext).a().a("HEART_DENGTA", com.tencent.beacon.a.a.f()).b();
    com.tencent.beacon.a.g.a.a("[event] heartbeat uploaded success!", new Object[0]);
  }
  
  private Map d()
  {
    HashMap localHashMap = new HashMap(4);
    com.tencent.beacon.a.c.e.a(this.b);
    localHashMap.put("A33", com.tencent.beacon.a.c.e.i(this.b));
    if (this.c)
    {
      localHashMap.put("A66", "F");
      localHashMap.put("A68", com.tencent.beacon.a.c.a.h(this.b));
      if (!this.d) {
        break label148;
      }
    }
    label148:
    for (String str = "Y";; str = "N")
    {
      localHashMap.put("A85", str);
      localHashMap.put("A20", com.tencent.beacon.a.c.e.f(this.b));
      localHashMap.put("A69", com.tencent.beacon.a.c.e.g(this.b));
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
    if (!com.tencent.beacon.a.a.h(this.b)) {}
    do
    {
      return;
      h localh = h.a(this.b);
      if (localh != null)
      {
        ArrayList localArrayList = new ArrayList(2);
        localArrayList.add(this.a);
        Iterator localIterator = h.a(this.b).c().iterator();
        while (localIterator.hasNext()) {
          ((com.tencent.beacon.a.f.i)localIterator.next()).b();
        }
        localh.a(new i(this.b, localArrayList));
      }
      a(e() + 1);
      if (e() % 10 == 0)
      {
        b.a().a(108, this.g, 600000L, this.e);
        a(0);
      }
    } while (!this.d);
    c.a(this.b).a().a("active_user_date", com.tencent.beacon.a.a.f()).b();
  }
  
  public final void b()
  {
    Object localObject1 = com.tencent.beacon.a.a.f();
    Object localObject2 = c.a(this.b);
    String str = ((c)localObject2).a("HEART_DENGTA", "");
    localObject2 = ((c)localObject2).a("active_user_date", "");
    if ((((String)localObject1).equals(str)) || (((String)localObject2).equals(localObject1)))
    {
      com.tencent.beacon.a.g.a.c("[event] heartbeat had upload!", new Object[0]);
      return;
    }
    localObject1 = d.a();
    if (((d)localObject1).a("rqd_heartbeat"))
    {
      com.tencent.beacon.a.g.a.c("[event] rqd_heartbeat not allowed in strategy!", new Object[0]);
      return;
    }
    if (!((d)localObject1).b("rqd_heartbeat"))
    {
      com.tencent.beacon.a.g.a.c("[event] rqd_heartbeat is sampled by svr rate!", new Object[0]);
      return;
    }
    localObject1 = d();
    this.a = com.tencent.beacon.a.a.a(this.b, "rqd_heartbeat", true, 0L, 0L, (Map)localObject1, true, false);
    b.a().a(108, this.g, 0L, this.e);
  }
  
  public final void c()
  {
    c localc = c.a(this.b);
    String str = localc.a("active_user_date", "");
    if (!com.tencent.beacon.a.a.f().equals(str))
    {
      if (UserAction.onUserAction("rqd_heartbeat", true, 0L, 0L, d(), true)) {
        localc.a().a("active_user_date", com.tencent.beacon.a.a.f()).b();
      }
      return;
    }
    com.tencent.beacon.a.g.a.c("[event] active user event had upload.", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.b.e
 * JD-Core Version:    0.7.0.1
 */