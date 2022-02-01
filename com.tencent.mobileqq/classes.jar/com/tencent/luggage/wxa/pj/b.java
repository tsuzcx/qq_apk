package com.tencent.luggage.wxa.pj;

import com.tencent.luggage.wxa.pl.d.a;
import com.tencent.luggage.wxa.pl.e;
import com.tencent.luggage.wxa.pm.f;
import com.tencent.luggage.wxa.pm.h;
import com.tencent.luggage.wxa.pm.i;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class b
  extends a
{
  private ByteBuffer f;
  private com.tencent.luggage.wxa.pl.d g = null;
  private final Random h = new Random();
  
  private byte a(d.a parama)
  {
    if (parama == d.a.a) {
      return 0;
    }
    if (parama == d.a.b) {
      return 1;
    }
    if (parama == d.a.c) {
      return 2;
    }
    if (parama == d.a.f) {
      return 8;
    }
    if (parama == d.a.d) {
      return 9;
    }
    if (parama == d.a.e) {
      return 10;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Don't know how to handle force close");
    localStringBuilder.append(parama.toString());
    o.b("MicroMsg.AppBrandNetWork.Draft_10", localStringBuilder.toString());
    return 8;
  }
  
  private d.a a(byte paramByte)
  {
    if (paramByte != 0)
    {
      if (paramByte != 1)
      {
        if (paramByte != 2)
        {
          switch (paramByte)
          {
          default: 
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("unknow optcode ");
            localStringBuilder.append((short)paramByte);
            throw new com.tencent.luggage.wxa.pk.c(localStringBuilder.toString());
          case 10: 
            return d.a.e;
          case 9: 
            return d.a.d;
          }
          return d.a.f;
        }
        return d.a.c;
      }
      return d.a.b;
    }
    return d.a.a;
  }
  
  private String a(String paramString)
  {
    paramString = paramString.trim();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
    paramString = ((StringBuilder)localObject).toString();
    try
    {
      localObject = MessageDigest.getInstance("SHA1");
      return com.tencent.luggage.wxa.pn.a.a(((MessageDigest)localObject).digest(paramString.getBytes()));
    }
    catch (NoSuchAlgorithmException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("not such algorithm ");
      ((StringBuilder)localObject).append(paramString.toString());
      o.b("MicroMsg.AppBrandNetWork.Draft_10", ((StringBuilder)localObject).toString());
    }
    return "";
  }
  
  private byte[] a(long paramLong, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfByte[i] = ((byte)(int)(paramLong >>> paramInt * 8 - 8 - i * 8));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static int b(f paramf)
  {
    paramf = paramf.b("Sec-WebSocket-Version");
    if (paramf.length() > 0) {}
    try
    {
      int i = new Integer(paramf.trim()).intValue();
      return i;
    }
    catch (NumberFormatException paramf) {}
    return -1;
    return -1;
  }
  
  public a.b a(com.tencent.luggage.wxa.pm.a parama)
  {
    int i = b(parama);
    if ((i != 7) && (i != 8)) {
      return a.b.b;
    }
    if (a(parama)) {
      return a.b.a;
    }
    return a.b.b;
  }
  
  public a.b a(com.tencent.luggage.wxa.pm.a parama, h paramh)
  {
    Object localObject = parama.b("Sec-WebSocket-Protocol");
    String str = paramh.b("Sec-WebSocket-Protocol");
    if ((!af.c((String)localObject)) && (!af.c(str)))
    {
      int j = 1;
      o.e("MicroMsg.AppBrandNetWork.Draft_10", "respProtocol is %s", new Object[] { str });
      localObject = ((String)localObject).split(", ");
      int k = localObject.length;
      int i = 0;
      while (i < k)
      {
        if (str.equals(localObject[i]))
        {
          i = j;
          break label104;
        }
        i += 1;
      }
      i = 0;
      label104:
      if (i == 0) {
        return a.b.b;
      }
    }
    if ((parama.c("Sec-WebSocket-Key")) && (paramh.c("Sec-WebSocket-Accept")))
    {
      paramh = paramh.b("Sec-WebSocket-Accept");
      if (a(parama.b("Sec-WebSocket-Key")).equals(paramh)) {
        return a.b.a;
      }
      return a.b.b;
    }
    return a.b.b;
  }
  
  public com.tencent.luggage.wxa.pm.b a(com.tencent.luggage.wxa.pm.b paramb)
  {
    paramb.a("Upgrade", "websocket");
    paramb.a("Connection", "Upgrade");
    paramb.a("Sec-WebSocket-Version", "8");
    byte[] arrayOfByte = new byte[16];
    this.h.nextBytes(arrayOfByte);
    paramb.a("Sec-WebSocket-Key", com.tencent.luggage.wxa.pn.a.a(arrayOfByte));
    return paramb;
  }
  
  public com.tencent.luggage.wxa.pm.c a(com.tencent.luggage.wxa.pm.a parama, i parami)
  {
    parami.a("Upgrade", "websocket");
    parami.a("Connection", parama.b("Connection"));
    parami.a("Switching Protocols");
    parama = parama.b("Sec-WebSocket-Key");
    if (parama != null)
    {
      parami.a("Sec-WebSocket-Accept", a(parama));
      return parami;
    }
    throw new com.tencent.luggage.wxa.pk.d("missing Sec-WebSocket-Key");
  }
  
  public ByteBuffer a(com.tencent.luggage.wxa.pl.d paramd)
  {
    ByteBuffer localByteBuffer = paramd.c();
    Object localObject = this.d;
    com.tencent.luggage.wxa.ph.a.b localb = com.tencent.luggage.wxa.ph.a.b.a;
    int n = 0;
    int k;
    if (localObject == localb) {
      k = 1;
    } else {
      k = 0;
    }
    int i;
    if (localByteBuffer.remaining() <= 125) {
      i = 1;
    } else if (localByteBuffer.remaining() <= 65535) {
      i = 2;
    } else {
      i = 8;
    }
    if (i > 1) {
      j = i + 1;
    } else {
      j = i;
    }
    int m;
    if (k != 0) {
      m = 4;
    } else {
      m = 0;
    }
    localObject = ByteBuffer.allocate(j + 1 + m + localByteBuffer.remaining());
    int i1 = a(paramd.f());
    boolean bool = paramd.d();
    int j = -128;
    if (bool) {
      m = -128;
    } else {
      m = 0;
    }
    ((ByteBuffer)localObject).put((byte)((byte)m | i1));
    paramd = a(localByteBuffer.remaining(), i);
    if (i == 1)
    {
      i = paramd[0];
      if (k == 0) {
        j = 0;
      }
      ((ByteBuffer)localObject).put((byte)(i | j));
    }
    else if (i == 2)
    {
      if (k == 0) {
        j = 0;
      }
      ((ByteBuffer)localObject).put((byte)(j | 0x7E));
      ((ByteBuffer)localObject).put(paramd);
    }
    else if (i == 8)
    {
      if (k == 0) {
        j = 0;
      }
      ((ByteBuffer)localObject).put((byte)(j | 0x7F));
      ((ByteBuffer)localObject).put(paramd);
    }
    else
    {
      o.b("MicroMsg.AppBrandNetWork.Draft_10", "Size representation not supported/specified");
    }
    if (k != 0)
    {
      paramd = ByteBuffer.allocate(4);
      paramd.putInt(this.h.nextInt());
      ((ByteBuffer)localObject).put(paramd.array());
      i = n;
      while (localByteBuffer.hasRemaining())
      {
        ((ByteBuffer)localObject).put((byte)(localByteBuffer.get() ^ paramd.get(i % 4)));
        i += 1;
      }
    }
    ((ByteBuffer)localObject).put(localByteBuffer);
    ((ByteBuffer)localObject).flip();
    return localObject;
  }
  
  public List<com.tencent.luggage.wxa.pl.d> a(String paramString, boolean paramBoolean)
  {
    e locale = new e();
    try
    {
      locale.a(ByteBuffer.wrap(com.tencent.luggage.wxa.pn.b.a(paramString)));
    }
    catch (com.tencent.luggage.wxa.pk.b paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createFrames setPayload exception");
      localStringBuilder.append(paramString.toString());
      o.b("MicroMsg.AppBrandNetWork.Draft_10", localStringBuilder.toString());
    }
    locale.a(true);
    locale.a(d.a.b);
    locale.b(paramBoolean);
    return Collections.singletonList(locale);
  }
  
  public List<com.tencent.luggage.wxa.pl.d> a(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    e locale = new e();
    try
    {
      locale.a(paramByteBuffer);
    }
    catch (com.tencent.luggage.wxa.pk.b paramByteBuffer)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createFrames setPayload exception");
      localStringBuilder.append(paramByteBuffer.toString());
      o.b("MicroMsg.AppBrandNetWork.Draft_10", localStringBuilder.toString());
    }
    locale.a(true);
    locale.a(d.a.c);
    locale.b(paramBoolean);
    return Collections.singletonList(locale);
  }
  
  public void a()
  {
    this.f = null;
  }
  
  public a.a b()
  {
    return a.a.c;
  }
  
  public a c()
  {
    return new b();
  }
  
  public List<com.tencent.luggage.wxa.pl.d> c(ByteBuffer paramByteBuffer)
  {
    LinkedList localLinkedList = new LinkedList();
    ByteBuffer localByteBuffer;
    if (this.f != null) {
      try
      {
        paramByteBuffer.mark();
        int i = paramByteBuffer.remaining();
        int j = this.f.remaining();
        if (j > i)
        {
          this.f.put(paramByteBuffer.array(), paramByteBuffer.position(), i);
          paramByteBuffer.position(paramByteBuffer.position() + i);
          return Collections.emptyList();
        }
        this.f.put(paramByteBuffer.array(), paramByteBuffer.position(), j);
        paramByteBuffer.position(paramByteBuffer.position() + j);
        localLinkedList.add(e((ByteBuffer)this.f.duplicate().position(0)));
        this.f = null;
      }
      catch (b.a locala1)
      {
        this.f.limit();
        localByteBuffer = ByteBuffer.allocate(a(locala1.a()));
        this.f.rewind();
        localByteBuffer.put(this.f);
        this.f = localByteBuffer;
        return c(paramByteBuffer);
      }
    }
    while (paramByteBuffer.hasRemaining())
    {
      paramByteBuffer.mark();
      try
      {
        localByteBuffer.add(e(paramByteBuffer));
      }
      catch (b.a locala2)
      {
        paramByteBuffer.reset();
        this.f = ByteBuffer.allocate(a(locala2.a()));
        this.f.put(paramByteBuffer);
      }
    }
    return localByteBuffer;
  }
  
  public com.tencent.luggage.wxa.pl.d e(ByteBuffer paramByteBuffer)
  {
    int i1 = paramByteBuffer.remaining();
    int j = 2;
    if (i1 >= 2)
    {
      int i = paramByteBuffer.get();
      int n = 0;
      boolean bool;
      if (i >> 8 != 0) {
        bool = true;
      } else {
        bool = false;
      }
      int k = (byte)((i & 0x7F) >> 4);
      if (k == 0)
      {
        int m = paramByteBuffer.get();
        if ((m & 0xFFFFFF80) != 0) {
          k = 1;
        } else {
          k = 0;
        }
        m = (byte)(m & 0x7F);
        d.a locala = a((byte)(i & 0xF));
        if ((!bool) && ((locala == d.a.d) || (locala == d.a.e) || (locala == d.a.f))) {
          throw new com.tencent.luggage.wxa.pk.c("control frames may no be fragmented");
        }
        Object localObject;
        if ((m >= 0) && (m <= 125))
        {
          i = m;
        }
        else
        {
          if ((locala == d.a.d) || (locala == d.a.e) || (locala == d.a.f)) {
            break label522;
          }
          if (m == 126)
          {
            if (i1 >= 4)
            {
              localObject = new byte[3];
              localObject[1] = paramByteBuffer.get();
              localObject[2] = paramByteBuffer.get();
              i = new BigInteger((byte[])localObject).intValue();
              j = 4;
            }
            else
            {
              throw new b.a(this, 4);
            }
          }
          else
          {
            j = 10;
            if (i1 < 10) {
              break label511;
            }
            localObject = new byte[8];
            i = 0;
            while (i < 8)
            {
              localObject[i] = paramByteBuffer.get();
              i += 1;
            }
            long l = new BigInteger((byte[])localObject).longValue();
            if (l > 2147483647L)
            {
              o.b("MicroMsg.AppBrandNetWork.Draft_10", "Payloadsize is to big...");
              i = m;
            }
            else
            {
              i = (int)l;
            }
          }
        }
        if (k != 0) {
          m = 4;
        } else {
          m = 0;
        }
        j = j + m + i;
        if (i1 >= j)
        {
          localObject = ByteBuffer.allocate(a(i));
          if (k != 0)
          {
            byte[] arrayOfByte = new byte[4];
            paramByteBuffer.get(arrayOfByte);
            j = n;
            while (j < i)
            {
              ((ByteBuffer)localObject).put((byte)(paramByteBuffer.get() ^ arrayOfByte[(j % 4)]));
              j += 1;
            }
          }
          ((ByteBuffer)localObject).put(paramByteBuffer.array(), paramByteBuffer.position(), ((ByteBuffer)localObject).limit());
          paramByteBuffer.position(paramByteBuffer.position() + ((ByteBuffer)localObject).limit());
          if (locala == d.a.f)
          {
            paramByteBuffer = new com.tencent.luggage.wxa.pl.b();
          }
          else
          {
            paramByteBuffer = new e();
            paramByteBuffer.a(bool);
            paramByteBuffer.a(locala);
          }
          ((ByteBuffer)localObject).flip();
          paramByteBuffer.a((ByteBuffer)localObject);
          return paramByteBuffer;
        }
        throw new b.a(this, j);
        label511:
        throw new b.a(this, 10);
        label522:
        throw new com.tencent.luggage.wxa.pk.c("more than 125 octets");
      }
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("bad rsv ");
      paramByteBuffer.append(k);
      throw new com.tencent.luggage.wxa.pk.c(paramByteBuffer.toString());
    }
    paramByteBuffer = new b.a(this, 2);
    for (;;)
    {
      throw paramByteBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pj.b
 * JD-Core Version:    0.7.0.1
 */