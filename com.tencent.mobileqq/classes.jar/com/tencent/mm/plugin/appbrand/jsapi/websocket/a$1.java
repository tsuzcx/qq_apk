package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.luggage.wxa.pm.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.x;
import java.nio.ByteBuffer;
import java.util.Map;

class a$1
  implements e.a
{
  a$1(a parama, String paramString1, e parame, d.a parama1, String paramString2) {}
  
  public void a(int paramInt, String paramString)
  {
    o.d("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketClose url is %s ,state: closed ,reason: %s, errCode = %d,taskId=%s", new Object[] { this.d, paramString, Integer.valueOf(paramInt), this.a });
    a.a(this.e, this.b);
    a.b(this.e, this.b);
    if (paramInt == -1)
    {
      if (!x.a(r.a()))
      {
        this.c.a("network is down");
      }
      else
      {
        d.a locala = this.c;
        String str;
        if (af.c(paramString)) {
          str = "abnormal closure";
        } else {
          str = paramString;
        }
        locala.a(str);
      }
      this.c.a(1006, paramString);
      return;
    }
    this.c.a(paramInt, paramString);
  }
  
  public void a(com.tencent.luggage.wxa.pm.a parama)
  {
    o.d("MicroMsg.AppBrandNetworkWcWssSocket", "onWebsocketHandshakeSentAsClient");
    this.c.a(parama);
  }
  
  public void a(h paramh, Map<String, Long> paramMap)
  {
    o.d("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketOpen taskId=%s", new Object[] { this.a });
    a.a(this.e, this.b);
    this.c.a(paramh, paramMap);
  }
  
  public void a(String paramString)
  {
    o.b("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketError url is %s ,error is %s,taskId=%s", new Object[] { this.d, paramString, this.a });
    a.a(this.e, this.b);
    a.b(this.e, this.b);
    d.a locala = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exception ");
    localStringBuilder.append(paramString);
    locala.a(localStringBuilder.toString());
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    String str = this.d;
    int i;
    if (paramByteBuffer != null) {
      i = paramByteBuffer.capacity();
    } else {
      i = -1;
    }
    o.e("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketMessage url is %s , socket onMessage buffer length : %d,taskId=%s", new Object[] { str, Integer.valueOf(i), this.a });
    this.c.a(paramByteBuffer);
  }
  
  public void b(String paramString)
  {
    String str = this.d;
    int i;
    if (paramString != null) {
      i = paramString.length();
    } else {
      i = -1;
    }
    o.e("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketMessage url is %s ,socket onmessage length :%d,taskId=%s", new Object[] { str, Integer.valueOf(i), this.a });
    this.c.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.a.1
 * JD-Core Version:    0.7.0.1
 */