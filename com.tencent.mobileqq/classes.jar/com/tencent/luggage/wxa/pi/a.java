package com.tencent.luggage.wxa.pi;

import com.tencent.luggage.wxa.ph.c;
import com.tencent.luggage.wxa.pm.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.g;
import com.tencent.luggage.wxa.sj.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import javax.net.ssl.SSLException;

public abstract class a
  extends com.tencent.luggage.wxa.ph.b
  implements com.tencent.luggage.wxa.ph.a, e, com.tencent.luggage.wxa.sj.f, Runnable
{
  private c b = null;
  private Socket c = null;
  private InputStream d;
  private OutputStream e;
  protected URI f = null;
  private Proxy g = Proxy.NO_PROXY;
  private Runnable h;
  private com.tencent.luggage.wxa.pj.a i;
  private Map<String, String> j;
  private CountDownLatch k = new CountDownLatch(1);
  private CountDownLatch l = new CountDownLatch(1);
  private int m = 0;
  private String n;
  private Timer o = null;
  private Future p;
  
  public a(URI paramURI, com.tencent.luggage.wxa.pj.a parama, Map<String, String> paramMap, int paramInt)
  {
    if (paramURI != null)
    {
      if (parama != null)
      {
        this.f = paramURI;
        this.i = parama;
        this.j = paramMap;
        this.m = paramInt;
        this.b = new c(this, parama);
        a(false);
        return;
      }
      throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
    throw new IllegalArgumentException();
  }
  
  private void b(Exception paramException)
  {
    if ((paramException instanceof SSLException)) {
      a(paramException);
    }
    this.b.a();
  }
  
  private int j()
  {
    int i1 = this.f.getPort();
    if (i1 == -1)
    {
      String str = this.f.getScheme();
      if (str.equals("wss")) {
        return 443;
      }
      if (str.equals("ws")) {
        return 80;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unkonow scheme");
      localStringBuilder.append(str);
      throw new RuntimeException(localStringBuilder.toString());
    }
    return i1;
  }
  
  private void k()
  {
    Object localObject2 = this.f.getRawPath();
    Object localObject3 = this.f.getRawQuery();
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
    int i1 = j();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.f.getHost());
    if (i1 != 80)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(i1);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    ((StringBuilder)localObject3).append((String)localObject1);
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject1 = new com.tencent.luggage.wxa.pm.d();
    ((com.tencent.luggage.wxa.pm.d)localObject1).a((String)localObject2);
    ((com.tencent.luggage.wxa.pm.d)localObject1).a("Host", (String)localObject3);
    localObject2 = this.j;
    if (localObject2 != null)
    {
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((com.tencent.luggage.wxa.pm.d)localObject1).a((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
      }
    }
    this.b.a((com.tencent.luggage.wxa.pm.b)localObject1);
  }
  
  private void l()
  {
    try
    {
      if (this.c != null)
      {
        this.c.close();
        return;
      }
    }
    catch (IOException localIOException)
    {
      a(this, localIOException);
    }
  }
  
  public String a()
  {
    return "WebsocketWriteThread";
  }
  
  public void a(int paramInt, String paramString) {}
  
  public abstract void a(int paramInt, String paramString, boolean paramBoolean);
  
  public final void a(com.tencent.luggage.wxa.ph.a parama) {}
  
  public void a(com.tencent.luggage.wxa.ph.a parama, int paramInt, String paramString)
  {
    a(paramInt, paramString);
  }
  
  public final void a(com.tencent.luggage.wxa.ph.a parama, int paramInt, String paramString, boolean paramBoolean)
  {
    this.k.countDown();
    this.l.countDown();
    parama = this.p;
    if (parama != null) {
      parama.cancel(false);
    }
    parama = this.h;
    if ((parama != null) && ((parama instanceof a.a))) {
      ((a.a)parama).a(true);
    }
    try
    {
      if (this.c != null) {
        this.c.close();
      }
    }
    catch (IOException parama)
    {
      a(this, parama);
    }
    a(paramInt, paramString, paramBoolean);
  }
  
  public void a(com.tencent.luggage.wxa.ph.a parama, com.tencent.luggage.wxa.pl.d paramd)
  {
    a(paramd);
  }
  
  public final void a(com.tencent.luggage.wxa.ph.a parama, com.tencent.luggage.wxa.pm.f paramf)
  {
    this.k.countDown();
    a((h)paramf);
  }
  
  public final void a(com.tencent.luggage.wxa.ph.a parama, Exception paramException)
  {
    a(paramException);
  }
  
  public final void a(com.tencent.luggage.wxa.ph.a parama, String paramString)
  {
    a(paramString);
  }
  
  public final void a(com.tencent.luggage.wxa.ph.a parama, ByteBuffer paramByteBuffer)
  {
    a(paramByteBuffer);
  }
  
  public void a(com.tencent.luggage.wxa.pl.d paramd) {}
  
  public abstract void a(h paramh);
  
  public abstract void a(Exception paramException);
  
  public abstract void a(String paramString);
  
  public void a(String paramString, int paramInt)
  {
    if (this.h != null) {
      b(paramInt, paramString);
    }
  }
  
  public void a(Socket paramSocket)
  {
    if (this.c != null)
    {
      o.d("MicroMsg.AppBrandNetWork.WebSocketClient", "socket has already been set");
      return;
    }
    this.c = paramSocket;
  }
  
  public void a(ByteBuffer paramByteBuffer) {}
  
  public void a(Timer paramTimer)
  {
    this.o = paramTimer;
  }
  
  public void a(Future paramFuture)
  {
    this.p = paramFuture;
  }
  
  public void a_(ByteBuffer paramByteBuffer)
  {
    this.b.b(paramByteBuffer);
  }
  
  public Timer b()
  {
    return this.o;
  }
  
  public void b(int paramInt, String paramString)
  {
    this.b.a(paramInt, paramString);
  }
  
  public void b(int paramInt, String paramString, boolean paramBoolean) {}
  
  public void b(com.tencent.luggage.wxa.ph.a parama, int paramInt, String paramString, boolean paramBoolean)
  {
    b(paramInt, paramString, paramBoolean);
  }
  
  public void b(com.tencent.luggage.wxa.pl.d paramd)
  {
    this.b.b(paramd);
  }
  
  public void b(String paramString)
  {
    this.b.a(paramString);
  }
  
  public void c()
  {
    if (this.h != null) {
      this.b.a(1000);
    }
  }
  
  public void c_(String paramString)
  {
    this.n = paramString;
  }
  
  public boolean d()
  {
    return this.b.c();
  }
  
  public void e()
  {
    if (this.h != null)
    {
      o.d("MicroMsg.AppBrandNetWork.WebSocketClient", "WebSocketClient objects are not reuseable");
      return;
    }
    this.h = this;
    com.tencent.luggage.wxa.rz.f.a.c(this.h);
  }
  
  public Socket f()
  {
    return this.c;
  }
  
  public boolean h()
  {
    return this.b.e();
  }
  
  public boolean i()
  {
    return this.b.d();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/tencent/luggage/wxa/pi/a:c	Ljava/net/Socket;
    //   4: ifnonnull +21 -> 25
    //   7: aload_0
    //   8: new 221	java/net/Socket
    //   11: dup
    //   12: aload_0
    //   13: getfield 60	com/tencent/luggage/wxa/pi/a:g	Ljava/net/Proxy;
    //   16: invokespecial 324	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   19: putfield 53	com/tencent/luggage/wxa/pi/a:c	Ljava/net/Socket;
    //   22: goto +13 -> 35
    //   25: aload_0
    //   26: getfield 53	com/tencent/luggage/wxa/pi/a:c	Ljava/net/Socket;
    //   29: invokevirtual 327	java/net/Socket:isClosed	()Z
    //   32: ifne +192 -> 224
    //   35: aload_0
    //   36: getfield 53	com/tencent/luggage/wxa/pi/a:c	Ljava/net/Socket;
    //   39: aload_0
    //   40: invokevirtual 329	com/tencent/luggage/wxa/pi/a:g	()Z
    //   43: invokevirtual 332	java/net/Socket:setTcpNoDelay	(Z)V
    //   46: aload_0
    //   47: getfield 53	com/tencent/luggage/wxa/pi/a:c	Ljava/net/Socket;
    //   50: invokevirtual 335	java/net/Socket:isBound	()Z
    //   53: ifne +32 -> 85
    //   56: aload_0
    //   57: getfield 53	com/tencent/luggage/wxa/pi/a:c	Ljava/net/Socket;
    //   60: new 337	java/net/InetSocketAddress
    //   63: dup
    //   64: aload_0
    //   65: getfield 49	com/tencent/luggage/wxa/pi/a:f	Ljava/net/URI;
    //   68: invokevirtual 167	java/net/URI:getHost	()Ljava/lang/String;
    //   71: aload_0
    //   72: invokespecial 164	com/tencent/luggage/wxa/pi/a:j	()I
    //   75: invokespecial 339	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   78: aload_0
    //   79: getfield 71	com/tencent/luggage/wxa/pi/a:m	I
    //   82: invokevirtual 343	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   85: aload_0
    //   86: aload_0
    //   87: getfield 53	com/tencent/luggage/wxa/pi/a:c	Ljava/net/Socket;
    //   90: invokevirtual 347	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   93: putfield 349	com/tencent/luggage/wxa/pi/a:d	Ljava/io/InputStream;
    //   96: aload_0
    //   97: aload_0
    //   98: getfield 53	com/tencent/luggage/wxa/pi/a:c	Ljava/net/Socket;
    //   101: invokevirtual 353	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   104: putfield 105	com/tencent/luggage/wxa/pi/a:e	Ljava/io/OutputStream;
    //   107: aload_0
    //   108: invokespecial 355	com/tencent/luggage/wxa/pi/a:k	()V
    //   111: aload_0
    //   112: new 251	com/tencent/luggage/wxa/pi/a$a
    //   115: dup
    //   116: aload_0
    //   117: aconst_null
    //   118: invokespecial 358	com/tencent/luggage/wxa/pi/a$a:<init>	(Lcom/tencent/luggage/wxa/pi/a;Lcom/tencent/luggage/wxa/pi/a$1;)V
    //   121: putfield 249	com/tencent/luggage/wxa/pi/a:h	Ljava/lang/Runnable;
    //   124: getstatic 308	com/tencent/luggage/wxa/rz/f:a	Lcom/tencent/luggage/wxa/rz/g;
    //   127: aload_0
    //   128: getfield 249	com/tencent/luggage/wxa/pi/a:h	Ljava/lang/Runnable;
    //   131: invokeinterface 313 2 0
    //   136: pop
    //   137: getstatic 360	com/tencent/luggage/wxa/ph/c:a	I
    //   140: newarray byte
    //   142: astore_2
    //   143: aload_0
    //   144: invokevirtual 362	com/tencent/luggage/wxa/pi/a:i	()Z
    //   147: ifne +40 -> 187
    //   150: aload_0
    //   151: invokevirtual 364	com/tencent/luggage/wxa/pi/a:h	()Z
    //   154: ifne +33 -> 187
    //   157: aload_0
    //   158: getfield 349	com/tencent/luggage/wxa/pi/a:d	Ljava/io/InputStream;
    //   161: aload_2
    //   162: invokevirtual 370	java/io/InputStream:read	([B)I
    //   165: istore_1
    //   166: iload_1
    //   167: iconst_m1
    //   168: if_icmpeq +19 -> 187
    //   171: aload_0
    //   172: getfield 51	com/tencent/luggage/wxa/pi/a:b	Lcom/tencent/luggage/wxa/ph/c;
    //   175: aload_2
    //   176: iconst_0
    //   177: iload_1
    //   178: invokestatic 376	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   181: invokevirtual 377	com/tencent/luggage/wxa/ph/c:a	(Ljava/nio/ByteBuffer;)V
    //   184: goto -41 -> 143
    //   187: aload_0
    //   188: getfield 51	com/tencent/luggage/wxa/pi/a:b	Lcom/tencent/luggage/wxa/ph/c;
    //   191: invokevirtual 111	com/tencent/luggage/wxa/ph/c:a	()V
    //   194: return
    //   195: astore_2
    //   196: aload_0
    //   197: aload_2
    //   198: invokevirtual 109	com/tencent/luggage/wxa/pi/a:a	(Ljava/lang/Exception;)V
    //   201: aload_0
    //   202: getfield 51	com/tencent/luggage/wxa/pi/a:b	Lcom/tencent/luggage/wxa/ph/c;
    //   205: sipush 1006
    //   208: aload_2
    //   209: invokevirtual 380	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   212: invokevirtual 381	com/tencent/luggage/wxa/ph/c:b	(ILjava/lang/String;)V
    //   215: return
    //   216: aload_0
    //   217: getfield 51	com/tencent/luggage/wxa/pi/a:b	Lcom/tencent/luggage/wxa/ph/c;
    //   220: invokevirtual 111	com/tencent/luggage/wxa/ph/c:a	()V
    //   223: return
    //   224: new 219	java/io/IOException
    //   227: dup
    //   228: invokespecial 382	java/io/IOException:<init>	()V
    //   231: athrow
    //   232: astore_2
    //   233: aload_0
    //   234: getfield 51	com/tencent/luggage/wxa/pi/a:b	Lcom/tencent/luggage/wxa/ph/c;
    //   237: iconst_m1
    //   238: aload_2
    //   239: invokevirtual 383	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   242: invokevirtual 381	com/tencent/luggage/wxa/ph/c:b	(ILjava/lang/String;)V
    //   245: return
    //   246: astore_2
    //   247: goto -31 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	a
    //   165	13	1	i1	int
    //   142	34	2	arrayOfByte	byte[]
    //   195	14	2	localRuntimeException	RuntimeException
    //   232	7	2	localException	Exception
    //   246	1	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   143	166	195	java/lang/RuntimeException
    //   171	184	195	java/lang/RuntimeException
    //   187	194	195	java/lang/RuntimeException
    //   0	22	232	java/lang/Exception
    //   25	35	232	java/lang/Exception
    //   35	85	232	java/lang/Exception
    //   85	111	232	java/lang/Exception
    //   224	232	232	java/lang/Exception
    //   143	166	246	java/io/IOException
    //   171	184	246	java/io/IOException
    //   187	194	246	java/io/IOException
  }
  
  public String v_()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pi.a
 * JD-Core Version:    0.7.0.1
 */