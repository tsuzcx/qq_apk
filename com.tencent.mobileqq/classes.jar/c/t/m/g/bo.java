package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public final class bo
  implements bv, Runnable
{
  private static bo a = new bo();
  private bc b;
  private Handler c;
  private Map<String, bk> d = new ConcurrentHashMap();
  private Runnable e = new br(this);
  private Runnable f = new bt(this);
  private Runnable g = new bu(this);
  private Map<String, a> h = new HashMap();
  
  private static int c(int paramInt)
  {
    String str;
    if (paramInt == 0)
    {
      str = "http_platform_update_interval_succ";
      if (paramInt != 0) {
        break label48;
      }
      paramInt = 1800000;
    }
    for (;;)
    {
      return v.a(str, 60000, 3600000, paramInt);
      if ((paramInt == -4) || (paramInt == -3))
      {
        str = "http_platform_update_interval_nonet";
        break;
      }
      str = "http_platform_update_interval_fail";
      break;
      label48:
      if ((paramInt == -4) || (paramInt == -3)) {
        paramInt = 60000;
      } else {
        paramInt = 300000;
      }
    }
  }
  
  public static bo c()
  {
    return a;
  }
  
  public final void a()
  {
    ((bk)this.d.get("accessscheduler")).a();
  }
  
  public final void a(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.c.removeCallbacks(this.f);
      this.c.post(this.f);
    }
    while ((paramInt != 3) && (paramInt != 4)) {
      return;
    }
    int i = v.a("detect_platform_update_random_interval", 0, 1440, 10);
    i = new Random().nextInt(i);
    if (paramInt == 3) {}
    for (paramInt = c(-4);; paramInt = c(0))
    {
      ab.a().a(this.e, paramInt + i * 60 * 1000);
      return;
    }
  }
  
  public final void a(bc parambc)
  {
    this.b = parambc;
    parambc = new bs();
    this.d.put(parambc.c(), parambc);
    parambc = new bm();
    this.d.put(parambc.c(), parambc);
    parambc = new bp();
    this.d.put(parambc.c(), parambc);
  }
  
  public final void b()
  {
    ((bk)this.d.get("settings")).b();
  }
  
  public final bc d()
  {
    return this.b;
  }
  
  public final void e()
  {
    HandlerThread localHandlerThread = new HandlerThread("HttpPlatformConnection");
    localHandlerThread.start();
    this.c = new Handler(localHandlerThread.getLooper());
    this.c.post(this);
    this.b.a_();
  }
  
  public final void run()
  {
    if (v.a("http_platform_start_update_on", 0, 1, 1) == 1) {
      this.c.post(this.g);
    }
  }
  
  final class a
  {
    public long a;
    public int b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.bo
 * JD-Core Version:    0.7.0.1
 */