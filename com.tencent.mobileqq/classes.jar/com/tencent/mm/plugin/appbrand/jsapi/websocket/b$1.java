package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.ot.c;
import com.tencent.luggage.wxa.pm.h;
import com.tencent.luggage.wxa.qz.o;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

class b$1
  implements WcWss.a
{
  b$1(b paramb) {}
  
  public int a(String paramString, byte[][] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("certifivate verify for ");
    ((StringBuilder)localObject).append(paramString);
    o.d("MicroMsg.AppBrandWcWssSocket", ((StringBuilder)localObject).toString());
    int j = -1;
    try
    {
      com.tencent.mars.cdn.a locala = com.tencent.mars.cdn.b.a(paramArrayOfByte, "RSA", paramString, 1, b.b(this.a));
      o.d("MicroMsg.AppBrandWcWssSocket", "host %s rsa verify result %d, isknownroots %b, ishostmatched %b", new Object[] { paramString, Integer.valueOf(locala.a()), Boolean.valueOf(locala.b()), Boolean.valueOf(locala.c()) });
      localObject = locala;
      if (locala.a() != 0)
      {
        localObject = com.tencent.mars.cdn.b.a(paramArrayOfByte, "ECDSA", paramString, 1, b.b(this.a));
        o.d("MicroMsg.AppBrandWcWssSocket", "host %s ecdsa verify result %d, isknownroots %b, ishostmatched %b", new Object[] { paramString, Integer.valueOf(((com.tencent.mars.cdn.a)localObject).a()), Boolean.valueOf(((com.tencent.mars.cdn.a)localObject).b()), Boolean.valueOf(((com.tencent.mars.cdn.a)localObject).c()) });
      }
      if (((com.tencent.mars.cdn.a)localObject).a() != 0) {
        ((c)e.b(c.class)).a(972L, 7L, 1L, false);
      }
      if ((((com.tencent.mars.cdn.a)localObject).a() == 0) && (!((com.tencent.mars.cdn.a)localObject).c())) {
        ((c)e.b(c.class)).a(972L, 8L, 1L, false);
      }
      if ((((com.tencent.mars.cdn.a)localObject).a() == 0) && (!((com.tencent.mars.cdn.a)localObject).b())) {
        ((c)e.b(c.class)).a(972L, 9L, 1L, false);
      }
      int i = j;
      if (((com.tencent.mars.cdn.a)localObject).a() == 0)
      {
        boolean bool = ((com.tencent.mars.cdn.a)localObject).b();
        i = j;
        if (bool) {
          i = 0;
        }
      }
      return i;
    }
    catch (Exception paramString)
    {
      o.a("MicroMsg.AppBrandWcWssSocket", paramString, "doCertificateVerify Exception", new Object[0]);
    }
    return -1;
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    o.d("MicroMsg.AppBrandWcWssSocket", "onClose group:%s,id:%s, reason:%s, code:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2) });
    b.a(this.a, b.a.e);
    b.a(this.a).a(paramInt2, paramString2);
  }
  
  public void a(String paramString1, int paramInt1, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt2, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8)
  {
    o.d("MicroMsg.AppBrandWcWssSocket", "onOpen group:%s,isSuc:%s, msg:%s, code:%s, wssId:%s, fetchStart:%d, domainLookupStart:%d, domainLookupEnd:%d, connectStart:%d, connectEnd:%d, rtt:%d, handshakeCost:%d, cost:%d", new Object[] { paramString1, Boolean.valueOf(paramBoolean), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Long.valueOf(paramLong6), Long.valueOf(paramLong7), Long.valueOf(paramLong8) });
    if (paramBoolean)
    {
      b.a(this.a, b.a.c);
      paramString1 = b.a(this.a, 2, paramArrayOfString1, paramArrayOfString2);
      paramArrayOfString1 = b.a(this.a, new String[] { "fetchStart", "domainLookupStart", "domainLookupEnd", "connectStart", "connectEnd", "rtt", "handshakeCost", "cost" }, new long[] { paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7, paramLong8 });
      b.a(this.a).a((h)paramString1, paramArrayOfString1);
      return;
    }
    paramString1 = b.a(this.a);
    paramArrayOfString1 = new StringBuilder();
    paramArrayOfString1.append("onOpen fail code:");
    paramArrayOfString1.append(paramInt2);
    paramArrayOfString1.append(", msg:");
    paramArrayOfString1.append(paramString2);
    paramString1.a(paramArrayOfString1.toString());
  }
  
  public void a(String paramString, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    o.e("MicroMsg.AppBrandWcWssSocket", "onMessage group:%s,wssId:%s,isText:%s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      try
      {
        paramString = new String(paramArrayOfByte, "utf-8");
        b.a(this.a).b(paramString);
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        o.a("MicroMsg.AppBrandWcWssSocket", paramString, "onmessage unsupport encoding UnsupportedEncodingException", new Object[0]);
        return;
      }
    }
    paramString = ByteBuffer.wrap(paramArrayOfByte);
    b.a(this.a).a(paramString);
  }
  
  public void a(String paramString, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    o.d("MicroMsg.AppBrandWcWssSocket", "onHandShake group:%s, wssId:%s", new Object[] { paramString, Integer.valueOf(paramInt) });
    paramString = b.a(this.a, 1, paramArrayOfString1, paramArrayOfString2);
    b.a(this.a).a((com.tencent.luggage.wxa.pm.a)paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.b.1
 * JD-Core Version:    0.7.0.1
 */