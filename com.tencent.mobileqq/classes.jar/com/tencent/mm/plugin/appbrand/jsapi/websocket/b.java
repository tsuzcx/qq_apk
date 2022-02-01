package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.luggage.wxa.nz.a;
import com.tencent.luggage.wxa.nz.j;
import com.tencent.luggage.wxa.pm.d;
import com.tencent.luggage.wxa.pm.f;
import com.tencent.luggage.wxa.pm.i;
import com.tencent.luggage.wxa.qz.o;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import javax.net.ssl.X509TrustManager;

public class b
  implements e
{
  private String b;
  private String c;
  private URI d;
  private Map<String, String> e;
  private ArrayList f = new ArrayList();
  private ArrayList g = new ArrayList();
  private WssConfig h;
  private String i;
  private int j = -1;
  private Timer k = null;
  private ArrayList<String> l;
  private e.a m;
  private WcWss.a n;
  private b.a o = b.a.a;
  private X509TrustManager p;
  
  public b(String paramString1, String paramString2, URI paramURI, Map<String, String> paramMap, WssConfig paramWssConfig, ArrayList<String> paramArrayList, a parama)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramURI;
    this.e = paramMap;
    this.h = paramWssConfig;
    this.l = paramArrayList;
    this.p = j.b(parama);
    paramString1 = this.e;
    if (paramString1 == null)
    {
      o.b("MicroMsg.AppBrandWcWssSocket", "header is null");
      return;
    }
    paramString1 = paramString1.entrySet().iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (Map.Entry)paramString1.next();
      this.f.add(paramString2.getKey());
      this.g.add(paramString2.getValue());
    }
  }
  
  private f a(int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int i1 = 0;
    Object localObject1;
    if (paramInt == 1)
    {
      Object localObject2 = this.d.getPath();
      Object localObject3 = this.d.getQuery();
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() != 0) {}
      }
      else
      {
        localObject1 = "/";
      }
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("?");
        ((StringBuilder)localObject2).append((String)localObject3);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      i1 = g();
      if ((i1 != -1) && (i1 != 80))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.d.getHost());
        ((StringBuilder)localObject1).append(":");
        ((StringBuilder)localObject1).append(i1);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = this.d.getHost();
      }
      localObject3 = new d();
      ((com.tencent.luggage.wxa.pm.b)localObject3).a((String)localObject2);
      ((com.tencent.luggage.wxa.pm.b)localObject3).a("Host", (String)localObject1);
      if ((paramArrayOfString1 != null) && (paramArrayOfString2 != null))
      {
        if (paramArrayOfString1.length == paramArrayOfString2.length)
        {
          i1 = 0;
          while (i1 < paramArrayOfString1.length)
          {
            ((com.tencent.luggage.wxa.pm.b)localObject3).a(paramArrayOfString1[i1], paramArrayOfString2[i1]);
            i1 += 1;
          }
          o.d("MicroMsg.AppBrandWcWssSocket", "buildHandshake headerKey.length:%s, type:%s", new Object[] { Integer.valueOf(paramArrayOfString1.length), Integer.valueOf(paramInt) });
          return localObject3;
        }
        o.c("MicroMsg.AppBrandWcWssSocket", "buildHandshake headerKey != headerValue type:%s", new Object[] { Integer.valueOf(paramInt) });
        return localObject3;
      }
      o.d("MicroMsg.AppBrandWcWssSocket", "buildHandshake header args is null type:%s", new Object[] { Integer.valueOf(paramInt) });
      paramArrayOfString1 = this.e;
      if (paramArrayOfString1 != null)
      {
        paramArrayOfString1 = paramArrayOfString1.entrySet().iterator();
        while (paramArrayOfString1.hasNext())
        {
          paramArrayOfString2 = (Map.Entry)paramArrayOfString1.next();
          ((com.tencent.luggage.wxa.pm.b)localObject3).a((String)paramArrayOfString2.getKey(), (String)paramArrayOfString2.getValue());
        }
      }
      o.c("MicroMsg.AppBrandWcWssSocket", "buildHandshake mHeaders is null type:%s", new Object[] { Integer.valueOf(paramInt) });
      return localObject3;
    }
    if (paramInt == 2)
    {
      localObject1 = new com.tencent.luggage.wxa.pm.e();
      if ((paramArrayOfString1 != null) && (paramArrayOfString2 != null))
      {
        if (paramArrayOfString1.length == paramArrayOfString2.length)
        {
          paramInt = i1;
          while (paramInt < paramArrayOfString1.length)
          {
            ((i)localObject1).a(paramArrayOfString1[paramInt], paramArrayOfString2[paramInt]);
            paramInt += 1;
          }
        }
        o.c("MicroMsg.AppBrandWcWssSocket", "buildHandshake headerKey != headerValue type:%s", new Object[] { Integer.valueOf(paramInt) });
        return localObject1;
      }
      o.c("MicroMsg.AppBrandWcWssSocket", "buildHandshake header args is null type:%s", new Object[] { Integer.valueOf(paramInt) });
      return localObject1;
    }
    o.c("MicroMsg.AppBrandWcWssSocket", "buildHandshake unknow type:%s", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  private Map<String, Long> a(String[] paramArrayOfString, long[] paramArrayOfLong)
  {
    HashMap localHashMap = new HashMap();
    if ((paramArrayOfString != null) && (paramArrayOfLong != null))
    {
      int i2 = paramArrayOfString.length;
      int i3 = paramArrayOfLong.length;
      int i1 = 0;
      if (i2 == i3) {
        while (i1 < paramArrayOfString.length)
        {
          localHashMap.put(paramArrayOfString[i1], Long.valueOf(paramArrayOfLong[i1]));
          i1 += 1;
        }
      }
      o.c("MicroMsg.AppBrandWcWssSocket", "buildProfileMap profileKey != profileValue profileKey.length:%d,profileValue.length:%d", new Object[] { Integer.valueOf(paramArrayOfString.length), Integer.valueOf(paramArrayOfLong.length) });
      return localHashMap;
    }
    o.c("MicroMsg.AppBrandWcWssSocket", "buildProfileMap profileKey args is null");
    return localHashMap;
  }
  
  private int g()
  {
    int i1 = this.d.getPort();
    if (i1 == -1)
    {
      String str = this.d.getScheme();
      if (str.equals("wss")) {
        return 443;
      }
      if (str.equals("ws")) {
        return 80;
      }
      o.b("MicroMsg.AppBrandWcWssSocket", "getPort unkonow scheme:%s", new Object[] { str });
    }
    return i1;
  }
  
  public void a(e.a parama)
  {
    o.d("MicroMsg.AppBrandWcWssSocket", "setCallBack");
    this.m = parama;
    this.n = new b.1(this);
  }
  
  public void a(String paramString, int paramInt)
  {
    o.d("MicroMsg.AppBrandWcWssSocket", "close reason:%s,code:%s", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (this.j < 0)
    {
      this.m.a("error socket id");
      return;
    }
    if ((this.o != b.a.d) && (this.o != b.a.e)) {
      this.o = b.a.d;
    }
    WcWss.closeSocket(this.b, this.j, paramInt, paramString);
  }
  
  public void a(Socket paramSocket) {}
  
  public void a(Timer paramTimer)
  {
    this.k = paramTimer;
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a_(ByteBuffer paramByteBuffer)
  {
    o.d("MicroMsg.AppBrandWcWssSocket", "send bytes");
    if (this.j < 0)
    {
      this.m.a("error socket id");
      return;
    }
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte);
    WcWss.sendBuffer(this.b, this.j, arrayOfByte, false);
  }
  
  public Timer b()
  {
    return this.k;
  }
  
  public void b(String paramString)
  {
    o.d("MicroMsg.AppBrandWcWssSocket", "send text");
    if (this.j < 0)
    {
      this.m.a("error socket id");
      return;
    }
    try
    {
      paramString = ByteBuffer.wrap(paramString.getBytes("UTF8"));
      byte[] arrayOfByte = new byte[paramString.remaining()];
      paramString.get(arrayOfByte);
      WcWss.sendBuffer(this.b, this.j, arrayOfByte, true);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      o.a("MicroMsg.AppBrandWcWssSocket", paramString, "unsupport encoding UnsupportedEncodingException", new Object[0]);
      this.m.a("unsupport encoding");
    }
  }
  
  public void c()
  {
    o.d("MicroMsg.AppBrandWcWssSocket", "close");
    a("default_close", 1000);
  }
  
  public void c_(String paramString)
  {
    this.i = paramString;
  }
  
  public boolean d()
  {
    return this.o == b.a.c;
  }
  
  public void e()
  {
    o.d("MicroMsg.AppBrandWcWssSocket", "connect");
    if (this.e == null)
    {
      this.m.a("header is null");
      return;
    }
    this.j = WcWss.a(this.n, this.b, this.c, this.f.toArray(), this.g.toArray(), null, this.h, this.l.toArray());
    if (this.j < 0)
    {
      e.a locala = this.m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("call connect fail code:");
      localStringBuilder.append(this.j);
      locala.a(localStringBuilder.toString());
    }
    o.d("MicroMsg.AppBrandWcWssSocket", "connect mWcWssId:%s", new Object[] { Integer.valueOf(this.j) });
  }
  
  public Socket f()
  {
    return null;
  }
  
  public String v_()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.b
 * JD-Core Version:    0.7.0.1
 */