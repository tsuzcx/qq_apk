package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.c;
import com.tencent.beacon.a.f;
import com.tencent.beacon.d.a;
import com.tencent.beacon.upload.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i
{
  private k a;
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
        i.this.a();
        return;
      }
      catch (Throwable localThrowable)
      {
        a.a(localThrowable);
      }
    }
  };
  
  public i(Context paramContext)
  {
    this.b = paramContext;
    this.c = com.tencent.beacon.a.b.h(this.b);
    this.d = com.tencent.beacon.a.b.a;
  }
  
  public i(Context paramContext, boolean paramBoolean)
  {
    this.b = paramContext;
    this.c = paramBoolean;
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
  
  private Map c()
  {
    HashMap localHashMap = new HashMap(4);
    f.a(this.b);
    localHashMap.put("A33", f.l(this.b));
    if (this.c)
    {
      localHashMap.put("A66", "F");
      localHashMap.put("A68", com.tencent.beacon.a.b.i(this.b));
      if (!this.d) {
        break label116;
      }
    }
    label116:
    for (String str = "Y";; str = "N")
    {
      localHashMap.put("A85", str);
      return localHashMap;
      localHashMap.put("A66", "B");
      break;
    }
  }
  
  private int d()
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
    if (!f.t(this.b)) {}
    do
    {
      return;
      h localh = o.d().h();
      if (localh != null)
      {
        ArrayList localArrayList = new ArrayList(2);
        localArrayList.add(this.a);
        o.d().d.b();
        localh.a(new l.a(this.b, localArrayList));
      }
      a(d() + 1);
      if (d() % 10 == 0)
      {
        c.a().a(108, this.g, 600000L, this.e);
        a(0);
      }
    } while (!this.d);
    com.tencent.beacon.a.b.a(this.b, "active_user_date", f.n());
  }
  
  public final void a(boolean paramBoolean)
  {
    int i = 0;
    Object localObject = f.n();
    String str1 = com.tencent.beacon.a.b.b(this.b, "HEART_DENGTA", "");
    String str2 = com.tencent.beacon.a.b.b(this.b, "active_user_date", "");
    if ((((String)localObject).equals(str1)) || (str2.equals(localObject)))
    {
      a.a("heartbeat has been uploaded today!", new Object[0]);
      return;
    }
    localObject = o.d();
    if (((o)localObject).a.a("rqd_heartbeat"))
    {
      a.c("rqd_heartbeat is not allowed in server strategy!", new Object[0]);
      return;
    }
    if (!((o)localObject).a.b("rqd_heartbeat"))
    {
      a.c("rqd_heartbeat is sampled by svr rate!", new Object[0]);
      return;
    }
    localObject = c();
    this.a = b.a(this.b, "rqd_heartbeat", (Map)localObject);
    if (paramBoolean) {
      i = (int)(Math.random() * 1800.0D) * 1000;
    }
    c.a().a(108, this.g, i, this.e);
  }
  
  public final void b()
  {
    String str = com.tencent.beacon.a.b.b(this.b, "active_user_date", "");
    if (!f.n().equals(str))
    {
      a.b("recover a heart beat for active user.", new Object[0]);
      if (UserAction.onUserAction("rqd_heartbeat", true, 0L, 0L, c(), true)) {
        com.tencent.beacon.a.b.a(this.b, "active_user_date", f.n());
      }
      return;
    }
    a.b("active user event has been uploaded today.", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.i
 * JD-Core Version:    0.7.0.1
 */