package com.tencent.beacon.module;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.base.net.c.e.a;
import com.tencent.beacon.event.EventBean;
import com.tencent.beacon.event.f;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconEvent.Builder;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.beacon.event.open.EventResult.a;
import com.tencent.beacon.qimei.Qimei;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class EventModule
  implements com.tencent.beacon.a.a.d, e.a, BeaconModule
{
  private static final Map<String, Map<String, String>> a = new ConcurrentHashMap(3);
  private static final Map<String, String> b = new ConcurrentHashMap(3);
  private final List<com.tencent.beacon.event.b.c> c = new ArrayList(3);
  private AtomicInteger d = new AtomicInteger(0);
  private AtomicBoolean e = new AtomicBoolean(false);
  private boolean f = true;
  private StrategyModule g;
  private f h;
  private volatile boolean i;
  
  private String c(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = com.tencent.beacon.a.c.c.d().f();
    }
    return str;
  }
  
  private void e()
  {
    this.c.add(new com.tencent.beacon.event.b.b());
    this.c.add(new com.tencent.beacon.event.b.a());
    int j = 1;
    while (j < this.c.size())
    {
      ((com.tencent.beacon.event.b.c)this.c.get(j - 1)).a((com.tencent.beacon.event.b.c)this.c.get(j));
      j += 1;
    }
  }
  
  private void f()
  {
    com.tencent.beacon.a.a.b.a().a(7, this);
    if (this.f)
    {
      this.h = new com.tencent.beacon.event.b();
      this.h.a();
    }
  }
  
  private void g()
  {
    com.tencent.beacon.a.a.b.a().a(3, this);
    com.tencent.beacon.a.a.b.a().a(4, this);
    com.tencent.beacon.a.a.b.a().a(6, this);
    com.tencent.beacon.a.a.b.a().a(1, this);
  }
  
  public EventResult a(@NonNull BeaconEvent paramBeaconEvent)
  {
    com.tencent.beacon.base.util.c.a("[EventModule]", 0, "event: %s. go in EventModule", new Object[] { paramBeaconEvent.getCode() });
    if (!this.f)
    {
      com.tencent.beacon.base.util.c.a("[EventModule]", 1, "event: %s. EventModule is not enable", new Object[] { paramBeaconEvent.getCode() });
      return EventResult.a.a(102);
    }
    com.tencent.beacon.base.util.e.a(paramBeaconEvent.getParams());
    Object localObject1 = this.g;
    if ((localObject1 != null) && (((StrategyModule)localObject1).b().a(paramBeaconEvent.getCode())))
    {
      com.tencent.beacon.base.util.c.a("[EventModule]", 1, "event: %s.  is not allowed in strategy (false)", new Object[] { paramBeaconEvent.getCode() });
      return EventResult.a.a(100);
    }
    if (paramBeaconEvent.isSucceed())
    {
      localObject1 = this.g;
      if ((localObject1 != null) && (!((StrategyModule)localObject1).b().b(paramBeaconEvent.getCode())))
      {
        com.tencent.beacon.base.util.c.a("[EventModule]", 1, "event: %s. is sampled by svr rate (false)", new Object[] { paramBeaconEvent.getCode() });
        return EventResult.a.a(101);
      }
    }
    paramBeaconEvent.setAppKey(c(paramBeaconEvent.getAppKey()));
    localObject1 = ((com.tencent.beacon.event.b.c)this.c.get(0)).b(paramBeaconEvent);
    if (localObject1 == null) {
      return EventResult.a.a(105);
    }
    Object localObject2 = com.tencent.beacon.qimei.a.a().b();
    if ((localObject2 == null) || (((Qimei)localObject2).isEmpty())) {
      if (this.d.addAndGet(1) > 64)
      {
        localObject2 = String.format("qimei empty cache count over max , appKey: %s, event: %s", new Object[] { paramBeaconEvent.getAppKey(), paramBeaconEvent.getCode() });
        com.tencent.beacon.base.util.c.a((String)localObject2, new Object[0]);
        if (this.e.compareAndSet(false, true)) {
          com.tencent.beacon.a.b.d.b().a("510", (String)localObject2);
        }
      }
      else
      {
        com.tencent.beacon.base.util.c.a("qimei empty and add to cache , appKey: %s, event: %s", new Object[] { paramBeaconEvent.getAppKey(), paramBeaconEvent.getCode() });
        localObject2 = BeaconEvent.newBuilder(paramBeaconEvent).build();
        HashMap localHashMap = new HashMap();
        localHashMap.put("e_q_e_k", localObject2);
        com.tencent.beacon.a.a.b.a().a(new com.tencent.beacon.a.a.c(12, localHashMap));
      }
    }
    return this.h.a((String)paramBeaconEvent.getParams().get("A100"), (EventBean)localObject1);
  }
  
  public Map<String, String> a(String paramString)
  {
    paramString = c(paramString);
    return (Map)a.get(paramString);
  }
  
  public void a()
  {
    this.h.b();
  }
  
  public void a(Context paramContext)
  {
    this.g = ((StrategyModule)BeaconModule.a.get(ModuleName.STRATEGY));
    e();
    f();
    g();
    com.tencent.beacon.base.net.c.e.a(paramContext, this);
    this.i = true;
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = c(paramString1);
    b.put(paramString1, com.tencent.beacon.event.c.c.d(paramString2));
  }
  
  public void a(String paramString, Map<String, String> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.size() < 50))
    {
      paramString = c(paramString);
      Map localMap = (Map)a.get(paramString);
      if (localMap != null)
      {
        if (localMap.size() + paramMap.size() >= 50)
        {
          com.tencent.beacon.base.util.c.a("setAdditionalParams error , params.size: can not more than 50", new Object[0]);
          return;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(localMap);
        localHashMap.putAll(paramMap);
        a.put(paramString, localHashMap);
        return;
      }
      a.put(paramString, new HashMap(paramMap));
      return;
    }
    int j;
    if (paramMap == null) {
      j = 0;
    } else {
      j = paramMap.size();
    }
    com.tencent.beacon.base.util.c.a("setAdditionalParams error , params.size: %s", new Object[] { Integer.valueOf(j) });
  }
  
  public void a(boolean paramBoolean)
  {
    f localf = this.h;
    if (localf != null) {
      localf.a(paramBoolean);
    }
  }
  
  @NonNull
  public String b(String paramString)
  {
    paramString = c(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return "10000";
    }
    String str = (String)b.get(paramString);
    paramString = str;
    if (str == null) {
      paramString = "10000";
    }
    return paramString;
  }
  
  public void b()
  {
    this.h.c();
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public f c()
  {
    return this.h;
  }
  
  public boolean d()
  {
    return this.i;
  }
  
  public void onEvent(com.tencent.beacon.a.a.c paramc)
  {
    int j = paramc.a;
    if (j != 1)
    {
      if (j != 12)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            if (j != 6)
            {
              if (j != 7) {
                return;
              }
              this.f = ((Boolean)paramc.b.get("s_e_e")).booleanValue();
              return;
            }
            paramc = paramc.b.get("b_e");
            if ((paramc instanceof BeaconEvent)) {
              a((BeaconEvent)paramc);
            }
          }
          else
          {
            a((String)paramc.b.get("i_c_ak"), (String)paramc.b.get("i_c_u_i"));
          }
        }
        else {
          a((String)paramc.b.get("i_c_ak"), (HashMap)paramc.b.get("i_c_ad"));
        }
      }
      else
      {
        paramc = paramc.b.get("e_q_e_k");
        if ((paramc instanceof BeaconEvent))
        {
          paramc = (BeaconEvent)paramc;
          paramc.getParams().put("A93", "Y");
          com.tencent.beacon.base.util.c.a("qimei empty cache report , appKey: %s, event: %s", new Object[] { paramc.getAppKey(), paramc.getCode() });
          a(paramc);
        }
      }
    }
    else {
      com.tencent.beacon.a.a.b.a().a(12, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.module.EventModule
 * JD-Core Version:    0.7.0.1
 */