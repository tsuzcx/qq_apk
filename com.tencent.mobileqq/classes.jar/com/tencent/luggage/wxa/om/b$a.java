package com.tencent.luggage.wxa.om;

import android.os.Build.VERSION;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.pc.l.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.r;

public class b$a
  implements Runnable
{
  protected final com.tencent.luggage.wxa.ed.d a;
  protected final String b;
  protected volatile boolean c = false;
  f.a d = new b.a.2(this);
  private volatile double e = 0.0D;
  private volatile int f = 4;
  private volatile boolean g = true;
  private volatile boolean h = false;
  private volatile boolean i = false;
  private e j;
  private f k;
  private c.c l = new b.a.3(this);
  
  public b$a(@NonNull com.tencent.luggage.wxa.ed.d paramd)
  {
    this.a = paramd;
    this.b = paramd.aa();
    this.j = new e(Process.myPid());
    this.c = false;
    if (k())
    {
      this.k = new f();
      this.k.a(100L);
      this.k.a(this.d);
    }
  }
  
  private boolean k()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  @WorkerThread
  private void l()
  {
    double d1 = this.j.a();
    com.tencent.luggage.wxa.ed.d locald = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((int)d1);
    localStringBuilder.append("%");
    b.a(locald, 101, localStringBuilder.toString());
    c.a(this.b, "Hardware", "CPU", d1);
  }
  
  @WorkerThread
  private void m()
  {
    Object localObject = this.a.i();
    if (localObject == null) {
      return;
    }
    if (((com.tencent.luggage.wxa.do.d)localObject).T == 1)
    {
      localObject = new com.tencent.luggage.wxa.lw.a();
      ((com.tencent.luggage.wxa.lw.a)localObject).a = this.b;
      ((com.tencent.luggage.wxa.lw.a)localObject).c = new b.a.1(this, (com.tencent.luggage.wxa.lw.a)localObject);
      ((com.tencent.luggage.wxa.lw.a)localObject).h();
      ((com.tencent.luggage.wxa.lw.a)localObject).g();
      return;
    }
    b.a(this.a, 401, af.a(((com.tencent.luggage.wxa.dp.a)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.dp.a.class)).a(this.b).a(this.b)));
  }
  
  public void a()
  {
    this.g = true;
    l.a().c(this);
    com.tencent.luggage.wxa.iu.c.a(this.b, this.l);
    if (k())
    {
      f localf = this.k;
      if (localf != null) {
        localf.a();
      }
    }
  }
  
  public void b()
  {
    this.g = false;
    com.tencent.luggage.wxa.iu.c.b(this.b, this.l);
    if (k())
    {
      localObject = this.k;
      if (localObject != null) {
        ((f)localObject).b();
      }
    }
    Object localObject = this.j;
    if (localObject != null) {
      ((e)localObject).close();
    }
  }
  
  public void c()
  {
    this.h = false;
    if (k())
    {
      f localf = this.k;
      if (localf != null) {
        localf.a();
      }
    }
  }
  
  public void d()
  {
    this.h = true;
    if (k())
    {
      f localf = this.k;
      if (localf != null) {
        localf.b();
      }
    }
  }
  
  @WorkerThread
  protected void e()
  {
    int m = af.a(r.a());
    com.tencent.luggage.wxa.ed.d locald = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(m);
    localStringBuilder.append("m");
    b.a(locald, 102, localStringBuilder.toString());
    c.a(this.b, "Hardware", "MEMORY", m);
  }
  
  protected void f()
  {
    if (!this.c) {}
  }
  
  protected void g()
  {
    if (!this.c) {}
  }
  
  protected void h() {}
  
  protected void i() {}
  
  protected void j() {}
  
  public void run()
  {
    if (this.a.au()) {
      return;
    }
    if ((this.g) && (!this.h))
    {
      l();
      e();
      f();
      g();
      h();
      i();
      j();
      this.f += 1;
      if (this.f >= 4)
      {
        this.f = 0;
        m();
      }
    }
    if (this.g) {
      l.a().a(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.om.b.a
 * JD-Core Version:    0.7.0.1
 */