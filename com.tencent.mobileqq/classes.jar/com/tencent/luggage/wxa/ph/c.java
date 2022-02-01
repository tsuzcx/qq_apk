package com.tencent.luggage.wxa.ph;

import com.tencent.luggage.wxa.pl.d.a;
import com.tencent.luggage.wxa.pm.h;
import com.tencent.luggage.wxa.pm.i;
import com.tencent.luggage.wxa.qz.o;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class c
  implements a
{
  public static int a = 16384;
  public static boolean b = false;
  public static final List<com.tencent.luggage.wxa.pj.a> c = new ArrayList(4);
  public SelectionKey d;
  public ByteChannel e;
  public final BlockingQueue<ByteBuffer> f;
  public final BlockingQueue<ByteBuffer> g;
  private volatile boolean h = false;
  private a.a i = a.a.a;
  private final d j;
  private List<com.tencent.luggage.wxa.pj.a> k;
  private com.tencent.luggage.wxa.pj.a l = null;
  private a.b m;
  private d.a n = null;
  private ByteBuffer o = ByteBuffer.allocate(0);
  private com.tencent.luggage.wxa.pm.a p = null;
  private String q = null;
  private Integer r = null;
  private Boolean s = null;
  private String t = null;
  
  static
  {
    c.add(new com.tencent.luggage.wxa.pj.c());
    c.add(new com.tencent.luggage.wxa.pj.b());
    c.add(new com.tencent.luggage.wxa.pj.d());
  }
  
  public c(d paramd, com.tencent.luggage.wxa.pj.a parama)
  {
    if ((paramd != null) && ((parama != null) || (this.m != a.b.b)))
    {
      this.f = new LinkedBlockingQueue();
      this.g = new LinkedBlockingQueue();
      this.j = paramd;
      this.m = a.b.a;
      if (parama != null) {
        this.l = parama.c();
      }
      return;
    }
    throw new IllegalArgumentException("parameters must not be null");
  }
  
  private void a(com.tencent.luggage.wxa.pm.f paramf)
  {
    if (b)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("open using draft: ");
      localStringBuilder.append(this.l.getClass().getSimpleName());
      o.d("MicroMsg.AppBrandNetWork.WebSocketImpl", localStringBuilder.toString());
    }
    this.i = a.a.c;
    try
    {
      this.j.a(this, paramf);
      return;
    }
    catch (RuntimeException paramf)
    {
      this.j.a(this, paramf);
    }
  }
  
  private void a(Collection<com.tencent.luggage.wxa.pl.d> paramCollection)
  {
    if (c())
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        b((com.tencent.luggage.wxa.pl.d)paramCollection.next());
      }
      return;
    }
    paramCollection = new com.tencent.luggage.wxa.pk.f();
    for (;;)
    {
      throw paramCollection;
    }
  }
  
  private void a(List<ByteBuffer> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      e((ByteBuffer)paramList.next());
    }
  }
  
  private void c(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.i != a.a.d) && (this.i != a.a.e))
    {
      if (this.i == a.a.c)
      {
        if (paramInt == 1006)
        {
          this.i = a.a.d;
          b(paramInt, paramString, false);
          return;
        }
        if (this.l.b() != com.tencent.luggage.wxa.pj.a.a.a)
        {
          if (!paramBoolean) {}
          try
          {
            try
            {
              this.j.a(this, paramInt, paramString);
            }
            catch (RuntimeException localRuntimeException)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("close: ");
              localStringBuilder.append(localRuntimeException.toString());
              o.b("MicroMsg.AppBrandNetWork.WebSocketImpl", localStringBuilder.toString());
              this.j.a(this, localRuntimeException);
            }
            b(new com.tencent.luggage.wxa.pl.b(paramInt, paramString));
          }
          catch (com.tencent.luggage.wxa.pk.b localb)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("close: ");
            localStringBuilder.append(localb.toString());
            o.b("MicroMsg.AppBrandNetWork.WebSocketImpl", localStringBuilder.toString());
            this.j.a(this, localb);
            b(1006, "generated frame is invalid", false);
          }
        }
        b(paramInt, paramString, paramBoolean);
      }
      else if (paramInt == -3)
      {
        b(-3, paramString, true);
      }
      else
      {
        b(-1, paramString, false);
      }
      if (paramInt == 1002) {
        b(paramInt, paramString, paramBoolean);
      }
      this.i = a.a.d;
      this.o = null;
    }
  }
  
  private boolean c(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer;
    if (this.o.capacity() == 0)
    {
      localByteBuffer = paramByteBuffer;
    }
    else
    {
      if (this.o.remaining() < paramByteBuffer.remaining())
      {
        localByteBuffer = ByteBuffer.allocate(this.o.capacity() + paramByteBuffer.remaining());
        this.o.flip();
        localByteBuffer.put(this.o);
        this.o = localByteBuffer;
      }
      this.o.put(paramByteBuffer);
      this.o.flip();
      localByteBuffer = this.o;
    }
    localByteBuffer.mark();
    try
    {
      Object localObject1 = this.m;
      Object localObject2 = a.b.b;
      if (localObject1 == localObject2)
      {
        if (this.l == null)
        {
          localObject1 = this.k.iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = ((com.tencent.luggage.wxa.pj.a)((Iterator)localObject1).next()).c();
              try
              {
                ((com.tencent.luggage.wxa.pj.a)localObject2).a(this.m);
                localByteBuffer.reset();
                localObject4 = ((com.tencent.luggage.wxa.pj.a)localObject2).d(localByteBuffer);
                if (!(localObject4 instanceof com.tencent.luggage.wxa.pm.a))
                {
                  b(1002, "wrong http function", false);
                  return false;
                }
                localObject4 = (com.tencent.luggage.wxa.pm.a)localObject4;
                if (((com.tencent.luggage.wxa.pj.a)localObject2).a((com.tencent.luggage.wxa.pm.a)localObject4) == com.tencent.luggage.wxa.pj.a.b.a)
                {
                  this.t = ((com.tencent.luggage.wxa.pm.a)localObject4).a();
                  try
                  {
                    i locali = this.j.a(this, (com.tencent.luggage.wxa.pj.a)localObject2, (com.tencent.luggage.wxa.pm.a)localObject4);
                    a(((com.tencent.luggage.wxa.pj.a)localObject2).a(((com.tencent.luggage.wxa.pj.a)localObject2).a((com.tencent.luggage.wxa.pm.a)localObject4, locali), this.m));
                    this.l = ((com.tencent.luggage.wxa.pj.a)localObject2);
                    a((com.tencent.luggage.wxa.pm.f)localObject4);
                    return true;
                  }
                  catch (RuntimeException localRuntimeException2)
                  {
                    this.j.a(this, localRuntimeException2);
                    b(-1, localRuntimeException2.getMessage(), false);
                    return false;
                  }
                  catch (com.tencent.luggage.wxa.pk.b localb2)
                  {
                    b(localb2.a(), localb2.getMessage(), false);
                    return false;
                  }
                }
              }
              catch (com.tencent.luggage.wxa.pk.d locald2)
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("InvalidHandshakeException e: ");
                ((StringBuilder)localObject4).append(locald2.toString());
                o.b("MicroMsg.AppBrandNetWork.WebSocketImpl", ((StringBuilder)localObject4).toString());
              }
            }
          }
          if (this.l != null) {
            break label953;
          }
          a(1002, "no draft matches");
          return false;
        }
        localObject1 = this.l.d(localByteBuffer);
        if (!(localObject1 instanceof com.tencent.luggage.wxa.pm.a))
        {
          b(1002, "wrong http function", false);
          return false;
        }
        localObject1 = (com.tencent.luggage.wxa.pm.a)localObject1;
        if (this.l.a((com.tencent.luggage.wxa.pm.a)localObject1) == com.tencent.luggage.wxa.pj.a.b.a)
        {
          a((com.tencent.luggage.wxa.pm.f)localObject1);
          return true;
        }
        a(1002, "the handshake did finaly not match");
        return false;
      }
      if (this.m != a.b.a) {
        break label951;
      }
      this.l.a(this.m);
      localObject1 = this.l.d(localByteBuffer);
      if (!(localObject1 instanceof h))
      {
        b(1002, "wrong http function", false);
        return false;
      }
      localObject1 = (h)localObject1;
      localObject3 = this.l.a(this.p, (h)localObject1);
      Object localObject4 = com.tencent.luggage.wxa.pj.a.b.a;
      if (localObject3 == localObject4) {
        try
        {
          this.j.a(this, this.p, (h)localObject1);
          a((com.tencent.luggage.wxa.pm.f)localObject1);
          return true;
        }
        catch (RuntimeException localRuntimeException1)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("decodeHandshake: ");
          ((StringBuilder)localObject3).append(localRuntimeException1.toString());
          o.b("MicroMsg.AppBrandNetWork.WebSocketImpl", ((StringBuilder)localObject3).toString());
          this.j.a(this, localRuntimeException1);
          b(-1, localRuntimeException1.getMessage(), false);
          return false;
        }
        catch (com.tencent.luggage.wxa.pk.b localb1)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("decodeHandshake: ");
          ((StringBuilder)localObject3).append(localb1.toString());
          o.b("MicroMsg.AppBrandNetWork.WebSocketImpl", ((StringBuilder)localObject3).toString());
          b(localb1.a(), localb1.getMessage(), false);
          return false;
        }
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("draft refuses handshake ");
      ((StringBuilder)localObject3).append(localb1.b());
      ((StringBuilder)localObject3).append(" ");
      ((StringBuilder)localObject3).append(localb1.a());
      a(1002, ((StringBuilder)localObject3).toString());
      return false;
    }
    catch (com.tencent.luggage.wxa.pk.a locala) {}catch (com.tencent.luggage.wxa.pk.d locald1)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("decodeHandshake: ");
      ((StringBuilder)localObject3).append(locald1.toString());
      o.b("MicroMsg.AppBrandNetWork.WebSocketImpl", ((StringBuilder)localObject3).toString());
      a(locald1);
      return false;
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("decodeHandshake: ");
    ((StringBuilder)localObject3).append(locald1.toString());
    o.b("MicroMsg.AppBrandNetWork.WebSocketImpl", ((StringBuilder)localObject3).toString());
    if (this.o.capacity() == 0)
    {
      localByteBuffer.reset();
      int i2 = locald1.a();
      int i1 = i2;
      if (i2 == 0) {
        i1 = localByteBuffer.capacity() + 16;
      }
      this.o = ByteBuffer.allocate(i1);
      this.o.put(paramByteBuffer);
      return false;
    }
    paramByteBuffer = this.o;
    paramByteBuffer.position(paramByteBuffer.limit());
    paramByteBuffer = this.o;
    paramByteBuffer.limit(paramByteBuffer.capacity());
    label951:
    return false;
    label953:
    return false;
  }
  
  private void d(ByteBuffer paramByteBuffer)
  {
    try
    {
      localObject = this.l.c(paramByteBuffer).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.luggage.wxa.pl.d locald = (com.tencent.luggage.wxa.pl.d)((Iterator)localObject).next();
        if (b)
        {
          paramByteBuffer = new StringBuilder();
          paramByteBuffer.append("matched frame: ");
          paramByteBuffer.append(locald);
          o.d("MicroMsg.AppBrandNetWork.WebSocketImpl", paramByteBuffer.toString());
        }
        paramByteBuffer = locald.f();
        boolean bool = locald.d();
        if (paramByteBuffer == d.a.f)
        {
          int i1 = 1005;
          paramByteBuffer = "";
          if ((locald instanceof com.tencent.luggage.wxa.pl.a))
          {
            paramByteBuffer = (com.tencent.luggage.wxa.pl.a)locald;
            i1 = paramByteBuffer.a();
            paramByteBuffer = paramByteBuffer.b();
          }
          if (this.i == a.a.d) {
            a(i1, paramByteBuffer, true);
          } else if (this.l.b() == com.tencent.luggage.wxa.pj.a.a.c) {
            c(i1, paramByteBuffer, true);
          } else {
            b(i1, paramByteBuffer, false);
          }
        }
        else if (paramByteBuffer == d.a.d)
        {
          this.j.b(this, locald);
        }
        else if (paramByteBuffer == d.a.e)
        {
          this.j.c(this, locald);
        }
        else if ((bool) && (paramByteBuffer != d.a.a))
        {
          if (this.n == null)
          {
            d.a locala = d.a.b;
            if (paramByteBuffer == locala)
            {
              try
              {
                this.j.a(this, com.tencent.luggage.wxa.pn.b.a(locald.c()));
              }
              catch (RuntimeException paramByteBuffer)
              {
                this.j.a(this, paramByteBuffer);
              }
            }
            else
            {
              locala = d.a.c;
              if (paramByteBuffer == locala) {
                try
                {
                  this.j.a(this, locald.c());
                }
                catch (RuntimeException paramByteBuffer)
                {
                  this.j.a(this, paramByteBuffer);
                }
              } else {
                throw new com.tencent.luggage.wxa.pk.b(1002, "non control or continious frame expected");
              }
            }
          }
          else
          {
            throw new com.tencent.luggage.wxa.pk.b(1002, "Continuous frame sequence not completed.");
          }
        }
        else
        {
          if (paramByteBuffer != d.a.a)
          {
            if (this.n == null) {
              this.n = paramByteBuffer;
            } else {
              throw new com.tencent.luggage.wxa.pk.b(1002, "Previous continuous frame sequence not completed.");
            }
          }
          else if (bool)
          {
            if (this.n != null) {
              this.n = null;
            } else {
              throw new com.tencent.luggage.wxa.pk.b(1002, "Continuous frame sequence was not started.");
            }
          }
          else
          {
            paramByteBuffer = this.n;
            if (paramByteBuffer == null) {
              break label483;
            }
          }
          try
          {
            this.j.a(this, locald);
          }
          catch (RuntimeException paramByteBuffer)
          {
            this.j.a(this, paramByteBuffer);
          }
          continue;
          label483:
          throw new com.tencent.luggage.wxa.pk.b(1002, "Continuous frame sequence was not started.");
        }
      }
      return;
    }
    catch (com.tencent.luggage.wxa.pk.b paramByteBuffer)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decodeFrames: ");
      ((StringBuilder)localObject).append(paramByteBuffer.toString());
      o.b("MicroMsg.AppBrandNetWork.WebSocketImpl", ((StringBuilder)localObject).toString());
      this.j.a(this, paramByteBuffer);
      a(paramByteBuffer);
    }
  }
  
  private void e(ByteBuffer paramByteBuffer)
  {
    if (b) {
      o.d("MicroMsg.AppBrandNetWork.WebSocketImpl", "write(\" + buf.remaining() + \"): {\" + ( buf.remaining() > 1000 ? \"too big to display\" : new String( buf.array() ) ) + \"}");
    }
    this.f.add(paramByteBuffer);
    this.j.a(this);
  }
  
  public void a()
  {
    if (f() == a.a.a)
    {
      a(-1, true);
      return;
    }
    if (this.h)
    {
      a(this.r.intValue(), this.q, this.s.booleanValue());
      return;
    }
    if (this.l.b() == com.tencent.luggage.wxa.pj.a.a.a)
    {
      a(1000, true);
      return;
    }
    if (this.l.b() == com.tencent.luggage.wxa.pj.a.a.b)
    {
      if (this.m == a.b.b)
      {
        a(1006, true);
        return;
      }
      a(1000, true);
      return;
    }
    a(1006, true);
  }
  
  public void a(int paramInt)
  {
    c(paramInt, "", false);
  }
  
  public void a(int paramInt, String paramString)
  {
    c(paramInt, paramString, false);
  }
  
  protected void a(int paramInt, String paramString, boolean paramBoolean)
  {
    try
    {
      Object localObject = this.i;
      a.a locala = a.a.e;
      if (localObject == locala) {
        return;
      }
      if (this.d != null) {
        this.d.cancel();
      }
      localObject = this.e;
      if (localObject != null) {
        try
        {
          this.e.close();
        }
        catch (IOException localIOException)
        {
          this.j.a(this, localIOException);
        }
      }
      try
      {
        this.j.a(this, paramInt, paramString, paramBoolean);
      }
      catch (RuntimeException paramString)
      {
        this.j.a(this, paramString);
      }
      if (this.l != null) {
        this.l.a();
      }
      this.p = null;
      this.i = a.a.e;
      this.f.clear();
      return;
    }
    finally {}
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, "", paramBoolean);
  }
  
  public void a(com.tencent.luggage.wxa.pk.b paramb)
  {
    c(paramb.a(), paramb.getMessage(), false);
  }
  
  public void a(com.tencent.luggage.wxa.pm.b paramb)
  {
    this.p = this.l.a(paramb);
    this.t = paramb.a();
    if (this.t == null) {
      return;
    }
    try
    {
      this.j.a(this, this.p);
      a(this.l.a(this.p, this.m));
      return;
    }
    catch (RuntimeException paramb)
    {
      this.j.a(this, paramb);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rejected because of");
      localStringBuilder.append(paramb);
      throw new com.tencent.luggage.wxa.pk.d(localStringBuilder.toString());
      throw new com.tencent.luggage.wxa.pk.d("Handshake data rejected by client.");
    }
    catch (com.tencent.luggage.wxa.pk.b paramb)
    {
      label110:
      break label110;
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null)
    {
      o.d("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
      return;
    }
    com.tencent.luggage.wxa.pj.a locala = this.l;
    boolean bool;
    if (this.m == a.b.a) {
      bool = true;
    } else {
      bool = false;
    }
    a(locala.a(paramString, bool));
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    if (b) {
      o.d("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"process(\" + socketBuffer.remaining() + \"): {\" + ( socketBuffer.remaining() > 1000 ? \"too big to display\" : new String( socketBuffer.array(), socketBuffer.position(), socketBuffer.remaining() ) ) + \"}\"");
    }
    if (this.i != a.a.a)
    {
      if (f() == a.a.c) {
        d(paramByteBuffer);
      }
    }
    else if ((c(paramByteBuffer)) && (!d()) && (!e()))
    {
      if (paramByteBuffer.hasRemaining())
      {
        d(paramByteBuffer);
        return;
      }
      if (this.o.hasRemaining()) {
        d(this.o);
      }
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    a(paramInt, paramString, false);
  }
  
  protected void b(int paramInt, String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = this.h;
      if (bool) {
        return;
      }
      this.r = Integer.valueOf(paramInt);
      this.q = paramString;
      this.s = Boolean.valueOf(paramBoolean);
      this.h = true;
      this.j.a(this);
      try
      {
        this.j.b(this, paramInt, paramString, paramBoolean);
      }
      catch (RuntimeException paramString)
      {
        this.j.a(this, paramString);
      }
      if (this.l != null) {
        this.l.a();
      }
      this.p = null;
      return;
    }
    finally {}
  }
  
  public void b(com.tencent.luggage.wxa.pl.d paramd)
  {
    if (b) {
      o.d("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"send frame: \" + framedata ");
    }
    e(this.l.a(paramd));
  }
  
  public void b(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null)
    {
      o.d("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
      return;
    }
    com.tencent.luggage.wxa.pj.a locala = this.l;
    boolean bool;
    if (this.m == a.b.a) {
      bool = true;
    } else {
      bool = false;
    }
    a(locala.a(paramByteBuffer, bool));
  }
  
  public boolean b()
  {
    return this.f.isEmpty() ^ true;
  }
  
  public boolean c()
  {
    return this.i == a.a.c;
  }
  
  public boolean d()
  {
    return this.i == a.a.d;
  }
  
  public boolean e()
  {
    return this.i == a.a.e;
  }
  
  public a.a f()
  {
    return this.i;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ph.c
 * JD-Core Version:    0.7.0.1
 */