package c.t.m.g;

import android.os.Handler;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class cg
  implements bc, bj
{
  private static cg b = new cg();
  public cd a;
  private Map<String, bd> c = new ConcurrentHashMap();
  private Runnable d = new ci(this);
  private Runnable e = new cj(this);
  
  private cg()
  {
    Object localObject = new bi();
    this.c.put(((bd)localObject).b(), localObject);
    localObject = new bg();
    this.c.put(((bd)localObject).b(), localObject);
    localObject = new be();
    this.c.put(((bd)localObject).b(), localObject);
    localObject = this.d;
    if ((!m.g()) && (m.e))
    {
      af.a().a((Runnable)localObject);
      af.a().a((Runnable)localObject, true, 30000L);
    }
    localObject = this.e;
    if ((!m.g()) && (m.e))
    {
      af.a().a((Runnable)localObject);
      af.a().a((Runnable)localObject, true, 30000L);
    }
  }
  
  public static cg d()
  {
    return b;
  }
  
  public final void a()
  {
    this.a.a();
  }
  
  public final void a(int paramInt)
  {
    m.j().post(new ch(this, paramInt));
  }
  
  public final void a(String paramString1, String paramString2)
  {
    Object localObject = this.d;
    long l = x.a.a("app_ipc_timertask_gap", 0, 3600000, 60000);
    if ((!m.g()) && (m.e))
    {
      af.a().a((Runnable)localObject);
      af.a().a((Runnable)localObject, true, l);
    }
    localObject = this.c.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bd)((Iterator)localObject).next()).a(paramString1, paramString2);
    }
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    Object localObject = this.e;
    long l = x.a.a("app_ipc_timertask_gap", 0, 3600000, 60000);
    if ((!m.g()) && (m.e))
    {
      af.a().a((Runnable)localObject);
      af.a().a((Runnable)localObject, true, l);
    }
    localObject = this.c.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bd)((Iterator)localObject).next()).a(paramString1, paramArrayOfByte, paramString2);
    }
  }
  
  public final void b()
  {
    this.a.b();
  }
  
  public final void c()
  {
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext()) {
      ((bd)localIterator.next()).c();
    }
  }
  
  public final ce e()
  {
    return (ce)this.c.get("settings");
  }
  
  public final w f()
  {
    return (w)this.c.get("accessscheduler");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.cg
 * JD-Core Version:    0.7.0.1
 */