package com.tencent.beacon.module;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.a.d.a.a;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconEvent.Builder;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.beacon.event.open.EventType;
import java.util.HashMap;
import java.util.Map;

public class StatModule
  implements com.tencent.beacon.a.a.d, BeaconModule
{
  private Context a;
  private boolean b = true;
  private boolean c = true;
  private com.tencent.beacon.e.b d;
  private long e = 0L;
  
  private void c()
  {
    ((Application)this.a).registerActivityLifecycleCallbacks(new com.tencent.beacon.d.a.d(this));
  }
  
  private void d()
  {
    com.tencent.beacon.a.d.a locala = com.tencent.beacon.a.d.a.a();
    Object localObject = locala.getString("rqd_model", "");
    if (com.tencent.beacon.base.util.b.c().equals(localObject)) {
      return;
    }
    localObject = new StatModule.1(this);
    com.tencent.beacon.a.b.a.a().a(50000L, (Runnable)localObject);
    locala.edit().putString("rqd_model", com.tencent.beacon.base.util.b.c());
  }
  
  private void e()
  {
    if (this.d.h())
    {
      localObject = com.tencent.beacon.a.d.a.a().getString("LAUEVE_DENGTA", "");
      if (com.tencent.beacon.base.util.b.c().equals(localObject))
      {
        com.tencent.beacon.base.util.c.d("[event] APP_LAUNCHED_EVENT has been uploaded!", new Object[0]);
        return;
      }
    }
    f localf = f.p();
    HashMap localHashMap = new HashMap();
    localHashMap.put("A19", localf.w());
    localHashMap.put("A133", localf.d());
    String str = "Y";
    localHashMap.put("A63", "Y");
    if (com.tencent.beacon.a.c.b.g()) {
      localObject = "Y";
    } else {
      localObject = "N";
    }
    localHashMap.put("A21", localObject);
    if (com.tencent.beacon.a.c.b.d(this.a)) {
      localObject = "Y";
    } else {
      localObject = "N";
    }
    localHashMap.put("A45", localObject);
    if (com.tencent.beacon.a.c.b.e(this.a)) {
      localObject = "F";
    } else {
      localObject = "B";
    }
    localHashMap.put("A66", localObject);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(com.tencent.beacon.a.c.b.b(this.a));
    localHashMap.put("A68", ((StringBuilder)localObject).toString());
    if (com.tencent.beacon.a.c.b.d) {
      localObject = str;
    } else {
      localObject = "N";
    }
    localHashMap.put("A85", localObject);
    localHashMap.put("A9", Build.BRAND);
    localHashMap.put("A14", localf.D());
    localHashMap.put("A20", localf.I());
    localHashMap.put("A69", localf.J());
    if (b(localHashMap)) {
      com.tencent.beacon.a.d.a.a().edit().putString("LAUEVE_DENGTA", com.tencent.beacon.base.util.b.c());
    }
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    this.a = paramContext;
    if (!com.tencent.beacon.a.c.b.g(this.a))
    {
      com.tencent.beacon.base.util.c.a("non-main process. do not report rqd event", new Object[0]);
      return;
    }
    this.d = ((StrategyModule)BeaconModule.a.get(ModuleName.STRATEGY)).b();
    this.c = this.d.k();
    ((Application)this.a).registerActivityLifecycleCallbacks(new com.tencent.beacon.d.a.c(this));
    com.tencent.beacon.a.a.b.a().a(2, this);
    com.tencent.beacon.a.a.b.a().a(10, this);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    com.tencent.beacon.a.b.a.a().a(new StatModule.2(this, paramLong2, paramString, paramLong1));
  }
  
  public void a(Map<String, String> paramMap)
  {
    com.tencent.beacon.a.b.a.a().a(new StatModule.5(this, paramMap));
  }
  
  public void b() {}
  
  public void b(String paramString, long paramLong1, long paramLong2)
  {
    com.tencent.beacon.a.b.a.a().a(new StatModule.3(this, paramLong2, paramString, paramLong1));
  }
  
  public boolean b(Map<String, String> paramMap)
  {
    paramMap = BeaconEvent.builder().withCode("rqd_applaunched").withParams(paramMap).withType(EventType.REALTIME).build();
    return BeaconReport.getInstance().report(paramMap).isSuccess();
  }
  
  public boolean c(Map<String, String> paramMap)
  {
    paramMap = BeaconEvent.builder().withParams(paramMap).withCode("rqd_heartbeat").withType(EventType.REALTIME).build();
    return BeaconReport.getInstance().report(paramMap).isSuccess();
  }
  
  public void onEvent(com.tencent.beacon.a.a.c paramc)
  {
    int i = paramc.a;
    if (i != 2)
    {
      if (i != 10) {
        return;
      }
      e();
      if (com.tencent.beacon.a.c.b.g(this.a)) {
        new com.tencent.beacon.d.c(this.a).a(this.d);
      }
      if (this.b) {
        d();
      }
      if (this.c) {
        c();
      }
    }
    else
    {
      paramc = (Map)paramc.b.get("d_m");
      if (paramc != null)
      {
        this.b = com.tencent.beacon.base.util.b.a((String)paramc.get("modelEventUsable"), this.b);
        this.c = com.tencent.beacon.base.util.b.a((String)paramc.get("isPagePath"), this.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.module.StatModule
 * JD-Core Version:    0.7.0.1
 */