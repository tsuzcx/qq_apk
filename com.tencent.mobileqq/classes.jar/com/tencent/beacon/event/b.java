package com.tencent.beacon.event;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.beacon.a.a.d;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.beacon.event.open.EventResult.a;
import java.util.Map;

public class b
  implements d, f
{
  private final Handler a = com.tencent.beacon.a.b.a.a().a(3000);
  private final com.tencent.beacon.event.a.a b = new com.tencent.beacon.event.a.a();
  private final e c = new e(2000, this.b, true);
  private final e d = new e(1000, this.b, false);
  private long e = 2000L;
  private long f = 3000L;
  
  public b()
  {
    com.tencent.beacon.a.a.b.a().a(11, this);
    com.tencent.beacon.a.a.b.a().a(2, this);
  }
  
  public EventResult a(@Nullable String paramString, @NonNull EventBean paramEventBean)
  {
    boolean bool = a(new a(this, paramEventBean));
    com.tencent.beacon.base.util.c.a("[EventModule]", 1, "event: %s. go in EventManager(%s). offer: %s", new Object[] { paramEventBean.getEventCode(), paramEventBean.getAppKey(), Boolean.valueOf(bool) });
    if (bool)
    {
      paramEventBean = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramEventBean = "-1";
      }
      return EventResult.a.a(Long.parseLong(paramEventBean));
    }
    return EventResult.a.a(103);
  }
  
  public void a()
  {
    com.tencent.beacon.a.b.a.a().a(2000, 0L, this.e, this.c);
    com.tencent.beacon.a.b.a.a().a(1000, 0L, this.f, this.d);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.d.run();
      this.c.run();
      return;
    }
    com.tencent.beacon.a.b.a.a().a(this.d);
    com.tencent.beacon.a.b.a.a().a(this.c);
  }
  
  public boolean a(Runnable paramRunnable)
  {
    return this.a.post(paramRunnable);
  }
  
  public void b()
  {
    com.tencent.beacon.a.b.a.a().b(2000);
    com.tencent.beacon.a.b.a.a().b(1000);
  }
  
  public void c()
  {
    com.tencent.beacon.a.b.a.a().a(2000, false);
    com.tencent.beacon.a.b.a.a().a(1000, false);
  }
  
  public void onEvent(com.tencent.beacon.a.a.c paramc)
  {
    int i = paramc.a;
    if (i != 2)
    {
      if (i == 11)
      {
        Object localObject = paramc.b.get("u_c_r_p");
        long l;
        if (localObject != null)
        {
          l = ((Long)localObject).longValue();
          if (l <= 500L) {
            l = 500L;
          }
          this.e = l;
        }
        paramc = paramc.b.get("u_c_n_p");
        if (paramc != null)
        {
          l = ((Long)paramc).longValue();
          if (l <= 1000L) {
            l = 1000L;
          }
          this.f = l;
        }
      }
    }
    else
    {
      paramc = (Map)paramc.b.get("d_m");
      if (paramc != null)
      {
        this.e = com.tencent.beacon.base.util.b.a((String)paramc.get("realtimePollingTime"), this.e, 500L, 5000L);
        this.f = com.tencent.beacon.base.util.b.a((String)paramc.get("normalPollingTime"), this.f, 1000L, 8000L);
      }
    }
    com.tencent.beacon.base.util.c.a("[EventManager]", "pollingTime maybe change, realtime: %s normal: %s", new Object[] { Long.valueOf(this.e), Long.valueOf(this.f) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.b
 * JD-Core Version:    0.7.0.1
 */