package com.tencent.luggage.wxa.pj;

import com.tencent.luggage.wxa.pl.d.a;
import com.tencent.luggage.wxa.pm.c;
import com.tencent.luggage.wxa.pm.e;
import com.tencent.luggage.wxa.pm.f;
import com.tencent.luggage.wxa.pm.h;
import com.tencent.luggage.wxa.pm.i;
import com.tencent.luggage.wxa.qz.o;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class a
{
  public static int a = 1000;
  public static int b = 64;
  public static final byte[] c = com.tencent.luggage.wxa.pn.b.a("");
  protected com.tencent.luggage.wxa.ph.a.b d = null;
  protected d.a e = null;
  
  public static c a(ByteBuffer paramByteBuffer, com.tencent.luggage.wxa.ph.a.b paramb)
  {
    Object localObject = b(paramByteBuffer);
    if (localObject != null)
    {
      localObject = ((String)localObject).split(" ", 3);
      if (localObject.length == 3)
      {
        if (paramb == com.tencent.luggage.wxa.ph.a.b.a)
        {
          paramb = new e();
          i locali = (i)paramb;
          locali.a(Short.parseShort(localObject[1]));
          locali.a(localObject[2]);
        }
        else
        {
          paramb = new com.tencent.luggage.wxa.pm.d();
          paramb.a(localObject[1]);
        }
        localObject = b(paramByteBuffer);
        while ((localObject != null) && (((String)localObject).length() > 0))
        {
          localObject = ((String)localObject).split(":", 2);
          if (localObject.length == 2)
          {
            paramb.a(localObject[0], localObject[1].replaceFirst("^ +", ""));
            localObject = b(paramByteBuffer);
          }
          else
          {
            throw new com.tencent.luggage.wxa.pk.d("not an http header");
          }
        }
        if (localObject != null) {
          return paramb;
        }
        throw new com.tencent.luggage.wxa.pk.a();
      }
      throw new com.tencent.luggage.wxa.pk.d();
    }
    paramByteBuffer = new com.tencent.luggage.wxa.pk.a(paramByteBuffer.capacity() + 128);
    for (;;)
    {
      throw paramByteBuffer;
    }
  }
  
  public static ByteBuffer a(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramByteBuffer.remaining());
    byte b1;
    for (int i = 48; paramByteBuffer.hasRemaining(); i = b1)
    {
      b1 = paramByteBuffer.get();
      localByteBuffer.put(b1);
      if ((i == 13) && (b1 == 10))
      {
        localByteBuffer.limit(localByteBuffer.position() - 2);
        localByteBuffer.position(0);
        return localByteBuffer;
      }
    }
    paramByteBuffer.position(paramByteBuffer.position() - localByteBuffer.position());
    return null;
  }
  
  public static String b(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = a(paramByteBuffer);
    if (paramByteBuffer == null) {
      return null;
    }
    return com.tencent.luggage.wxa.pn.b.a(paramByteBuffer.array(), 0, paramByteBuffer.limit());
  }
  
  public int a(int paramInt)
  {
    if (paramInt >= 0) {
      return paramInt;
    }
    throw new com.tencent.luggage.wxa.pk.b(1002, "Negative count");
  }
  
  public abstract a.b a(com.tencent.luggage.wxa.pm.a parama);
  
  public abstract a.b a(com.tencent.luggage.wxa.pm.a parama, h paramh);
  
  public abstract com.tencent.luggage.wxa.pm.b a(com.tencent.luggage.wxa.pm.b paramb);
  
  public abstract c a(com.tencent.luggage.wxa.pm.a parama, i parami);
  
  public abstract ByteBuffer a(com.tencent.luggage.wxa.pl.d paramd);
  
  public List<ByteBuffer> a(f paramf, com.tencent.luggage.wxa.ph.a.b paramb)
  {
    return a(paramf, paramb, true);
  }
  
  public List<ByteBuffer> a(f paramf, com.tencent.luggage.wxa.ph.a.b paramb, boolean paramBoolean)
  {
    paramb = new StringBuilder(100);
    if ((paramf instanceof com.tencent.luggage.wxa.pm.a))
    {
      paramb.append("GET ");
      paramb.append(((com.tencent.luggage.wxa.pm.a)paramf).a());
      paramb.append(" HTTP/1.1");
    }
    else if ((paramf instanceof h))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("HTTP/1.1 101 ");
      ((StringBuilder)localObject).append(((h)paramf).a());
      paramb.append(((StringBuilder)localObject).toString());
    }
    else
    {
      paramb.append("GET ");
      paramb.append(((com.tencent.luggage.wxa.pm.a)paramf).a());
      paramb.append(" HTTP/1.1");
      o.b("MicroMsg.AppBrandNetWork.Draft", "unknow role");
    }
    paramb.append("\r\n");
    Object localObject = paramf.c();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = paramf.b(str1);
      paramb.append(str1);
      paramb.append(": ");
      paramb.append(str2);
      paramb.append("\r\n");
    }
    paramb.append("\r\n");
    paramb = com.tencent.luggage.wxa.pn.b.b(paramb.toString());
    if (paramBoolean) {
      paramf = paramf.d();
    } else {
      paramf = null;
    }
    int i;
    if (paramf == null) {
      i = 0;
    } else {
      i = paramf.length;
    }
    localObject = ByteBuffer.allocate(i + paramb.length);
    ((ByteBuffer)localObject).put(paramb);
    if (paramf != null) {
      ((ByteBuffer)localObject).put(paramf);
    }
    ((ByteBuffer)localObject).flip();
    return Collections.singletonList(localObject);
  }
  
  public abstract List<com.tencent.luggage.wxa.pl.d> a(String paramString, boolean paramBoolean);
  
  public abstract List<com.tencent.luggage.wxa.pl.d> a(ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  public abstract void a();
  
  public void a(com.tencent.luggage.wxa.ph.a.b paramb)
  {
    this.d = paramb;
  }
  
  protected boolean a(f paramf)
  {
    return (paramf.b("Upgrade").equalsIgnoreCase("websocket")) && (paramf.b("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade"));
  }
  
  public abstract a.a b();
  
  public abstract a c();
  
  public abstract List<com.tencent.luggage.wxa.pl.d> c(ByteBuffer paramByteBuffer);
  
  public f d(ByteBuffer paramByteBuffer)
  {
    return a(paramByteBuffer, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pj.a
 * JD-Core Version:    0.7.0.1
 */