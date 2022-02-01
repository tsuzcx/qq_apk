package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Log;
import com.tencent.luggage.util.m;
import com.tencent.luggage.wxa.nz.j;
import com.tencent.luggage.wxa.nz.k.b;
import com.tencent.luggage.wxa.pj.d;
import com.tencent.luggage.wxa.qw.jt;
import com.tencent.luggage.wxa.qz.o;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class k
{
  private com.tencent.luggage.wxa.pi.a a;
  private SSLSocketFactory b;
  
  public k(com.tencent.luggage.wxa.nz.a parama)
  {
    parama = j.a(parama);
    if (parama != null) {
      this.b = parama.getSocketFactory();
    }
  }
  
  public void a(String paramString, k.b paramb)
  {
    o.d("MicroMsg.RemoteDebugSocket", "connectSocket url is %s", new Object[] { paramString });
    try
    {
      URI localURI = new URI(paramString);
      HashMap localHashMap = new HashMap();
      if (paramString.startsWith("ws://localhost:")) {
        localHashMap.put("Sec-WebSocket-Protocol", "client");
      }
      try
      {
        this.a = new k.1(this, localURI, new d(), localHashMap, 60000, paramb);
        if (m.a(paramString, "ws://"))
        {
          paramString = new Socket(Proxy.NO_PROXY);
          this.a.a(paramString);
          this.a.e();
          return;
        }
        if (this.b != null) {
          paramString = this.b;
        } else {
          paramString = (SSLSocketFactory)SSLSocketFactory.getDefault();
        }
        paramString = paramString.createSocket();
        this.a.a(paramString);
        this.a.e();
        return;
      }
      catch (Exception paramString)
      {
        o.b("MicroMsg.RemoteDebugSocket", "onSocketMessage %s", new Object[] { Log.getStackTraceString(paramString) });
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      o.b("MicroMsg.RemoteDebugSocket", "connect fail : %s ", new Object[] { paramString.toString() });
      paramb.c("url not well format");
    }
  }
  
  public boolean a()
  {
    com.tencent.luggage.wxa.pi.a locala = this.a;
    if (locala == null) {
      return false;
    }
    return locala.d();
  }
  
  public boolean a(int paramInt, String paramString)
  {
    com.tencent.luggage.wxa.pi.a locala = this.a;
    if (locala == null)
    {
      o.c("MicroMsg.RemoteDebugSocket", "client is null");
      return false;
    }
    locala.b(paramInt, paramString);
    o.e("MicroMsg.RemoteDebugSocket", "closeSocket code %d, reason %s", new Object[] { Integer.valueOf(paramInt), paramString });
    return true;
  }
  
  public boolean a(jt paramjt)
  {
    o.e("MicroMsg.RemoteDebugSocket", "sendSocketMsg");
    if (!a())
    {
      o.c("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail, not open");
      return false;
    }
    if (paramjt == null)
    {
      o.c("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail");
      return false;
    }
    paramjt = l.a(paramjt);
    this.a.a_(paramjt);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.k
 * JD-Core Version:    0.7.0.1
 */