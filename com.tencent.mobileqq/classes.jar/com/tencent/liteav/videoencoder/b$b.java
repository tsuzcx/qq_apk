package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.util.h;
import java.lang.ref.WeakReference;
import java.util.TimerTask;

class b$b
  extends TimerTask
{
  private WeakReference<b> a;
  
  public b$b(b paramb)
  {
    this.a = new WeakReference(paramb);
  }
  
  public void run()
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return;
    }
    localObject1 = (b)((WeakReference)localObject1).get();
    if (localObject1 == null) {
      return;
    }
    Object localObject2;
    if (b.i((b)localObject1) < b.j((b)localObject1))
    {
      localObject2 = h.a();
      b.k((b)localObject1);
      b.a((b)localObject1, b.l((b)localObject1) + localObject2[0] / 10);
      b.b((b)localObject1, b.m((b)localObject1) + localObject2[1] / 10);
      double d1 = b.n((b)localObject1);
      double d2 = ((b)localObject1).c();
      double d3 = b.g((b)localObject1).fps;
      Double.isNaN(d3);
      d2 = d2 * 100.0D / d3;
      Double.isNaN(d1);
      b.c((b)localObject1, (float)(d1 + d2));
      return;
    }
    if ((c.a().a(b.l((b)localObject1) / b.j((b)localObject1), b.m((b)localObject1) / b.j((b)localObject1), b.n((b)localObject1) / b.j((b)localObject1))) && (c.a().d() != 0))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("VideoEncoder: Insufficient performance, switching software encoding to hardware encoding [appCPU:");
      ((StringBuilder)localObject2).append(b.l((b)localObject1));
      ((StringBuilder)localObject2).append("][sysCPU:");
      ((StringBuilder)localObject2).append(b.m((b)localObject1));
      ((StringBuilder)localObject2).append("][fps:");
      ((StringBuilder)localObject2).append(b.n((b)localObject1));
      ((StringBuilder)localObject2).append("][checkCount:");
      ((StringBuilder)localObject2).append(b.j((b)localObject1));
      ((StringBuilder)localObject2).append("]");
      Monitor.a(2, ((StringBuilder)localObject2).toString(), "", 0);
      b.o((b)localObject1);
    }
    b.p((b)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.b.b
 * JD-Core Version:    0.7.0.1
 */