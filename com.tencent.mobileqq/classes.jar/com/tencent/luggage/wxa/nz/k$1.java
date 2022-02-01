package com.tencent.luggage.wxa.nz;

import com.tencent.luggage.wxa.pl.d;
import com.tencent.luggage.wxa.pm.h;
import com.tencent.luggage.wxa.pn.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.x;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.c;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.e.a;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;

class k$1
  extends c
{
  private d g = null;
  
  k$1(k paramk, URI paramURI, com.tencent.luggage.wxa.pj.a parama, Map paramMap, int paramInt, String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a parama1)
  {
    super(paramURI, parama, paramMap, paramInt);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    o.d("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: closed ,reason: %s, errCode = %d, taskId=%s", new Object[] { this.b, paramString, Integer.valueOf(paramInt), this.c });
    k.a(this.e, this);
    k.b(this.e, this);
    if ((paramInt != -1) && (paramInt != -2) && (paramInt != -3))
    {
      this.d.a(paramInt, paramString);
      return;
    }
    if (!x.a(r.a()))
    {
      this.d.a("network is down");
    }
    else
    {
      com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a locala = this.d;
      String str;
      if (af.c(paramString)) {
        str = "abnormal closure";
      } else {
        str = paramString;
      }
      locala.a(str);
    }
    this.d.a(1006, paramString);
  }
  
  public void a(com.tencent.luggage.wxa.ph.a parama, com.tencent.luggage.wxa.pm.a parama1)
  {
    this.d.a(parama1);
  }
  
  public void a(d paramd)
  {
    if ((paramd.f() != com.tencent.luggage.wxa.pl.d.a.a) && (!paramd.d()))
    {
      this.g = paramd;
      return;
    }
    if (paramd.f() == com.tencent.luggage.wxa.pl.d.a.a)
    {
      d locald = this.g;
      if (locald == null) {
        return;
      }
      if (locald.c().position() > 10485760)
      {
        o.b("MicroMsg.AppBrandNetworkWebSocket", "Pending Frame exploded");
        this.g = null;
        return;
      }
      try
      {
        this.g.a(paramd);
      }
      catch (Exception localException)
      {
        o.a("MicroMsg.AppBrandNetworkWebSocket", localException, "Exception: Framedata append fail", new Object[0]);
      }
      if (!paramd.d()) {
        return;
      }
      if (this.g.f() == com.tencent.luggage.wxa.pl.d.a.c) {
        a(this.g.c());
      } else if (this.g.f() == com.tencent.luggage.wxa.pl.d.a.b) {
        try
        {
          a(af.b(b.a(this.g.c())));
        }
        catch (Exception paramd)
        {
          o.a("MicroMsg.AppBrandNetworkWebSocket", paramd, "Exception: stringUtf8 error", new Object[0]);
        }
      }
      this.g = null;
    }
  }
  
  public void a(h paramh)
  {
    o.d("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: opened, taskId=%s", new Object[] { this.b, this.c });
    k.a(this.e, this);
    this.d.a(paramh, null);
  }
  
  public void a(e.a parama) {}
  
  public void a(Exception paramException)
  {
    o.a("MicroMsg.AppBrandNetworkWebSocket", paramException, "onError Exception: url %s, taskId=%s", new Object[] { this.b, this.c });
    k.a(this.e, this);
    k.b(this.e, this);
    com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a locala = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exception ");
    localStringBuilder.append(paramException.getMessage());
    locala.a(localStringBuilder.toString());
  }
  
  public void a(String paramString)
  {
    String str = this.b;
    int i;
    if (paramString != null) {
      i = paramString.length();
    } else {
      i = -1;
    }
    o.d("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,socket onmessage length :%d, taskId=%s", new Object[] { str, Integer.valueOf(i), this.c });
    this.d.b(paramString);
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    String str = this.b;
    int i;
    if (paramByteBuffer != null) {
      i = paramByteBuffer.capacity();
    } else {
      i = -1;
    }
    o.d("MicroMsg.AppBrandNetworkWebSocket", "url is %s , socket onMessage buffer length : %d, taskId=%s", new Object[] { str, Integer.valueOf(i), this.c });
    this.d.a(paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.k.1
 * JD-Core Version:    0.7.0.1
 */