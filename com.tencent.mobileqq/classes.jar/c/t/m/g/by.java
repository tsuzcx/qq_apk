package c.t.m.g;

import android.os.Handler;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class by
  implements aw, bc
{
  private static by a = new by();
  private Map<String, ax> b = new ConcurrentHashMap();
  private bv c;
  private Runnable d = new ca(this);
  private Runnable e = new cb(this);
  
  private by()
  {
    Object localObject = new bb();
    this.b.put(((ax)localObject).a(), localObject);
    localObject = new ba();
    this.b.put(((ax)localObject).a(), localObject);
    localObject = new ay();
    this.b.put(((ax)localObject).a(), localObject);
    localObject = this.d;
    if ((!l.g()) && (l.g))
    {
      ab.a().a((Runnable)localObject);
      ab.a().b((Runnable)localObject, 30000L);
    }
    localObject = this.e;
    if ((!l.g()) && (l.g))
    {
      ab.a().a((Runnable)localObject);
      ab.a().b((Runnable)localObject, 30000L);
    }
  }
  
  public static by c()
  {
    return a;
  }
  
  public final void a()
  {
    this.c.a();
  }
  
  public final void a(int paramInt)
  {
    l.j().post(new bz(this, paramInt));
  }
  
  public final void a(String paramString1, String paramString2)
  {
    Object localObject = this.d;
    long l = v.a("app_ipc_timertask_gap", 0, 3600000, 60000);
    if ((!l.g()) && (l.g))
    {
      ab.a().a((Runnable)localObject);
      ab.a().b((Runnable)localObject, l);
    }
    localObject = this.b.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ax)((Iterator)localObject).next()).a(paramString1, paramString2);
    }
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    Object localObject = this.e;
    long l = v.a("app_ipc_timertask_gap", 0, 3600000, 60000);
    if ((!l.g()) && (l.g))
    {
      ab.a().a((Runnable)localObject);
      ab.a().b((Runnable)localObject, l);
    }
    localObject = this.b.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ax)((Iterator)localObject).next()).a(paramString1, paramArrayOfByte, paramString2);
    }
  }
  
  public final void a_()
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      ((ax)localIterator.next()).a_();
    }
  }
  
  public final void b()
  {
    this.c.b();
  }
  
  public final bw d()
  {
    return (bw)this.b.get("settings");
  }
  
  public final r e()
  {
    return (r)this.b.get("accessscheduler");
  }
  
  public final void f()
  {
    if (l.g()) {
      this.c = bx.c();
    }
    this.c.a(this);
    this.c.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.by
 * JD-Core Version:    0.7.0.1
 */