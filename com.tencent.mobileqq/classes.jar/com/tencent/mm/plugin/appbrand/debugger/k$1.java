package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.luggage.wxa.nz.k.b;
import com.tencent.luggage.wxa.pl.d;
import com.tencent.luggage.wxa.pl.d.a;
import com.tencent.luggage.wxa.pm.h;
import com.tencent.luggage.wxa.pn.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.x;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;

class k$1
  extends com.tencent.luggage.wxa.pi.a
{
  private d c = null;
  
  k$1(k paramk, URI paramURI, com.tencent.luggage.wxa.pj.a parama, Map paramMap, int paramInt, k.b paramb)
  {
    super(paramURI, parama, paramMap, paramInt);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    o.d("MicroMsg.RemoteDebugSocket", "onClose,reason: %s, errCode = %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    if ((paramInt != -1) && (paramInt != -2) && (paramInt != -3))
    {
      this.a.a(paramInt, paramString);
      return;
    }
    if (!x.a(r.a()))
    {
      this.a.a("network is down");
      paramInt = 1006;
    }
    else
    {
      this.a.a(paramString);
    }
    this.a.a(paramInt, paramString);
  }
  
  public void a(d paramd)
  {
    if ((paramd.f() != d.a.a) && (!paramd.d()))
    {
      this.c = paramd;
      return;
    }
    if (paramd.f() == d.a.a)
    {
      d locald = this.c;
      if (locald == null) {
        return;
      }
      if (locald.c().position() > 10485760)
      {
        o.b("MicroMsg.RemoteDebugSocket", "Pending Frame exploded");
        this.c = null;
        return;
      }
      try
      {
        this.c.a(paramd);
      }
      catch (Exception localException)
      {
        o.b("MicroMsg.RemoteDebugSocket", localException.getMessage());
      }
      if (!paramd.d()) {
        return;
      }
      if (this.c.f() == d.a.c) {
        a(this.c.c());
      } else if (this.c.f() == d.a.b) {
        try
        {
          a(af.b(b.a(this.c.c())));
        }
        catch (Exception paramd)
        {
          o.b("MicroMsg.RemoteDebugSocket", paramd.getMessage());
        }
      }
      this.c = null;
    }
  }
  
  public void a(h paramh)
  {
    o.e("MicroMsg.RemoteDebugSocket", "onSocketOpen");
    this.a.a(paramh);
  }
  
  public void a(Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSocketError, ex: ");
    localStringBuilder.append(paramException.toString());
    o.b("MicroMsg.RemoteDebugSocket", localStringBuilder.toString());
  }
  
  public void a(String paramString)
  {
    k.a(this.b).b(paramString);
    o.e("MicroMsg.RemoteDebugSocket", "onSocketMessage, message: %s", new Object[] { paramString });
    this.a.b(paramString);
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    this.a.a(paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.k.1
 * JD-Core Version:    0.7.0.1
 */