package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Log;
import com.tencent.luggage.wxa.nz.k.b;
import com.tencent.luggage.wxa.pc.l.a;
import com.tencent.luggage.wxa.pm.h;
import com.tencent.luggage.wxa.qu.b;
import com.tencent.luggage.wxa.qw.jt;
import com.tencent.luggage.wxa.qw.ke;
import com.tencent.luggage.wxa.qw.kn;
import com.tencent.luggage.wxa.qw.kq;
import com.tencent.luggage.wxa.qw.ks;
import com.tencent.luggage.wxa.qw.ku;
import com.tencent.luggage.wxa.qw.ky;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.nio.ByteBuffer;
import java.util.Map;

class g$2
  implements k.b
{
  g$2(g paramg) {}
  
  public void a(int paramInt, String paramString)
  {
    o.d("MicroMsg.RemoteDebugJsEngine", "onSocketClose code:%d reason:%s ", new Object[] { Integer.valueOf(paramInt), paramString });
    if (g.b(this.a).C())
    {
      com.tencent.luggage.wxa.pc.l.a().a(new g.2.1(this), 1000L);
      g.b(this.a).E();
    }
    g.d(this.a).h();
    g.b(this.a).q();
    g.e(this.a).h();
    g.b(this.a).c(5);
    g.e(this.a).a(paramString);
  }
  
  public void a(h paramh)
  {
    o.d("MicroMsg.RemoteDebugJsEngine", "onSocketOpen");
    g.b(this.a).q();
    g.b(this.a).D();
    if (!af.c(g.b(this.a).c())) {
      g.c(this.a);
    }
    g.d(this.a).i();
  }
  
  public void a(String paramString)
  {
    o.d("MicroMsg.RemoteDebugJsEngine", "onSocketError message:%s ", new Object[] { paramString });
    g.e(this.a).a(paramString);
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    g.b(this.a).q();
    for (;;)
    {
      try
      {
        paramByteBuffer = com.tencent.luggage.wxa.pc.c.a(paramByteBuffer);
        paramByteBuffer = (jt)new jt().a(paramByteBuffer);
        if (paramByteBuffer.c == null)
        {
          o.c("MicroMsg.RemoteDebugJsEngine", "dataFormat.data is null");
          return;
        }
        Object localObject = paramByteBuffer.c.c();
        int i = paramByteBuffer.a;
        if (i != 2006) {
          if (i != 3001) {
            if (i == 3002) {}
          }
        }
        switch (i)
        {
        case 1006: 
          localObject = (kn)new kn().a((byte[])localObject);
          g.d(this.a).a((kn)localObject, paramByteBuffer);
          j.a(paramByteBuffer, (d)g.b(this.a).g().get(paramByteBuffer.b));
          break;
        case 1005: 
          localObject = (ky)new ky().a((byte[])localObject);
          g.d(this.a).a((ky)localObject, paramByteBuffer);
          break;
        case 1004: 
          if (g.a(this.a).d()) {
            g.d(this.a).e();
          } else {
            g.d(this.a).f();
          }
          break;
        case 1003: 
          localObject = (ks)new ks().a((byte[])localObject);
          if (l.a(g.b(this.a), paramByteBuffer, ((ks)localObject).a, g.e(this.a), g.d(this.a))) {
            g.f(this.a);
          }
          break;
        case 1002: 
          localObject = (ku)new ku().a((byte[])localObject);
          g.a(this.a, (ku)localObject, paramByteBuffer);
          break;
        case 1001: 
          localObject = (kq)new kq().a((byte[])localObject);
          l.a(g.b(this.a), paramByteBuffer, ((kq)localObject).a, g.e(this.a), g.d(this.a));
          g.b(this.a).q();
          continue;
          g.b(this.a).c(4);
          g.d(this.a).d();
          continue;
          g.g(this.a);
          continue;
          localObject = (ke)new ke().a((byte[])localObject);
          g.d(this.a).a((ke)localObject);
          o.d("MicroMsg.RemoteDebugJsEngine", "onSocketMessage cmd: %d", new Object[] { Integer.valueOf(paramByteBuffer.a) });
          return;
        }
      }
      catch (Throwable paramByteBuffer)
      {
        o.b("MicroMsg.RemoteDebugJsEngine", "onSocketMessage %s", new Object[] { Log.getStackTraceString(paramByteBuffer) });
        return;
      }
    }
  }
  
  public void b(String paramString)
  {
    g.b(this.a).q();
  }
  
  public void c(String paramString)
  {
    o.d("MicroMsg.RemoteDebugJsEngine", "onSocketConnectFail reason:%s ", new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.g.2
 * JD-Core Version:    0.7.0.1
 */