package com.tencent.luggage.wxa.i;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.tencent.luggage.wxa.ao.j;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.h.q;
import com.tencent.luggage.wxa.h.u;
import com.tencent.luggage.wxa.u.a;
import java.nio.ByteBuffer;

@TargetApi(16)
public class i
  extends com.tencent.luggage.wxa.u.b
  implements com.tencent.luggage.wxa.ao.i
{
  private final e.a b;
  private final f c = new f(paramc2, paramVarArgs, new i.a(this, null));
  private boolean d;
  private boolean e;
  private MediaFormat f;
  private int g;
  private int h;
  private long i;
  private boolean j;
  
  public i(com.tencent.luggage.wxa.u.c paramc, com.tencent.luggage.wxa.k.c<com.tencent.luggage.wxa.k.e> paramc1, boolean paramBoolean, Handler paramHandler, e parame, c paramc2, d... paramVarArgs)
  {
    super(1, paramc, paramc1, paramBoolean);
    this.b = new e.a(paramHandler, parame);
  }
  
  private static boolean b(String paramString)
  {
    return (x.a < 24) && ("OMX.SEC.aac.dec".equals(paramString)) && ("samsung".equals(x.c)) && ((x.b.startsWith("zeroflte")) || (x.b.startsWith("herolte")) || (x.b.startsWith("heroqlte")));
  }
  
  protected int a(com.tencent.luggage.wxa.u.c paramc, k paramk)
  {
    String str = paramk.f;
    if (!j.a(str)) {
      return 0;
    }
    int k;
    if (x.a >= 21) {
      k = 32;
    } else {
      k = 0;
    }
    boolean bool = a(str);
    int n = 4;
    if ((bool) && (paramc.a() != null)) {
      return k | 0x8 | 0x4;
    }
    paramc = paramc.a(str, false);
    int i1 = 1;
    if (paramc == null) {
      return 1;
    }
    int m = i1;
    if (x.a >= 21)
    {
      if ((paramk.s == -1) || (paramc.a(paramk.s)))
      {
        m = i1;
        if (paramk.r == -1) {
          break label147;
        }
        if (paramc.b(paramk.r))
        {
          m = i1;
          break label147;
        }
      }
      m = 0;
    }
    label147:
    if (m != 0) {
      m = n;
    } else {
      m = 3;
    }
    return k | 0x8 | m;
  }
  
  public q a(q paramq)
  {
    return this.c.a(paramq);
  }
  
  protected a a(com.tencent.luggage.wxa.u.c paramc, k paramk, boolean paramBoolean)
  {
    if (a(paramk.f))
    {
      a locala = paramc.a();
      if (locala != null)
      {
        this.d = true;
        return locala;
      }
    }
    this.d = false;
    return super.a(paramc, paramk, paramBoolean);
  }
  
  protected void a(int paramInt, long paramLong1, long paramLong2) {}
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        super.a(paramInt, paramObject);
        return;
      }
      paramObject = (b)paramObject;
      this.c.a(paramObject);
      return;
    }
    this.c.a(((Float)paramObject).floatValue());
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    super.a(paramLong, paramBoolean);
    this.c.i();
    this.i = paramLong;
    this.j = true;
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    paramMediaCodec = this.f;
    int m = 0;
    int k;
    if (paramMediaCodec != null) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != 0) {
      paramMediaCodec = this.f.getString("mime");
    } else {
      paramMediaCodec = "audio/raw";
    }
    if (k != 0) {
      paramMediaFormat = this.f;
    }
    int n = paramMediaFormat.getInteger("channel-count");
    int i1 = paramMediaFormat.getInteger("sample-rate");
    if ((this.e) && (n == 6))
    {
      k = this.h;
      if (k < 6)
      {
        int[] arrayOfInt = new int[k];
        k = m;
        for (;;)
        {
          paramMediaFormat = arrayOfInt;
          if (k >= this.h) {
            break;
          }
          arrayOfInt[k] = k;
          k += 1;
        }
      }
    }
    paramMediaFormat = null;
    try
    {
      this.c.a(paramMediaCodec, n, i1, this.g, 0, paramMediaFormat);
      return;
    }
    catch (f.c paramMediaCodec)
    {
      paramMediaCodec = com.tencent.luggage.wxa.h.e.a(paramMediaCodec, r());
    }
    for (;;)
    {
      throw paramMediaCodec;
    }
  }
  
  protected void a(a parama, MediaCodec paramMediaCodec, k paramk, MediaCrypto paramMediaCrypto)
  {
    this.e = b(parama.a);
    if (this.d)
    {
      this.f = paramk.b();
      this.f.setString("mime", "audio/raw");
      paramMediaCodec.configure(this.f, null, paramMediaCrypto, 0);
      this.f.setString("mime", paramk.f);
      return;
    }
    paramMediaCodec.configure(paramk.b(), null, paramMediaCrypto, 0);
    this.f = null;
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2)
  {
    this.b.a(paramString, paramLong1, paramLong2);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.b.a(this.a);
    int k = q().b;
    if (k != 0)
    {
      this.c.a(k);
      return;
    }
    this.c.g();
  }
  
  protected boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    if ((this.d) && ((paramInt2 & 0x2) != 0))
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      return true;
    }
    if (paramBoolean)
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      paramMediaCodec = this.a;
      paramMediaCodec.e += 1;
      this.c.b();
      return true;
    }
    try
    {
      if (this.c.a(paramByteBuffer, paramLong3))
      {
        paramMediaCodec.releaseOutputBuffer(paramInt1, false);
        paramMediaCodec = this.a;
        paramMediaCodec.d += 1;
        return true;
      }
      return false;
    }
    catch (f.h paramMediaCodec) {}catch (f.d paramMediaCodec) {}
    throw com.tencent.luggage.wxa.h.e.a(paramMediaCodec, r());
  }
  
  protected boolean a(String paramString)
  {
    return this.c.a(paramString);
  }
  
  protected void b(int paramInt) {}
  
  protected void b(k paramk)
  {
    super.b(paramk);
    this.b.a(paramk);
    int k;
    if ("audio/raw".equals(paramk.f)) {
      k = paramk.t;
    } else {
      k = 2;
    }
    this.g = k;
    this.h = paramk.r;
  }
  
  public com.tencent.luggage.wxa.ao.i c()
  {
    return this;
  }
  
  protected void n()
  {
    super.n();
    this.c.a();
  }
  
  protected void o()
  {
    this.c.h();
    super.o();
  }
  
  /* Error */
  protected void p()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/tencent/luggage/wxa/i/i:c	Lcom/tencent/luggage/wxa/i/f;
    //   4: invokevirtual 276	com/tencent/luggage/wxa/i/f:j	()V
    //   7: aload_0
    //   8: invokespecial 278	com/tencent/luggage/wxa/u/b:p	()V
    //   11: aload_0
    //   12: getfield 217	com/tencent/luggage/wxa/i/i:a	Lcom/tencent/luggage/wxa/j/d;
    //   15: invokevirtual 279	com/tencent/luggage/wxa/j/d:a	()V
    //   18: aload_0
    //   19: getfield 48	com/tencent/luggage/wxa/i/i:b	Lcom/tencent/luggage/wxa/i/e$a;
    //   22: aload_0
    //   23: getfield 217	com/tencent/luggage/wxa/i/i:a	Lcom/tencent/luggage/wxa/j/d;
    //   26: invokevirtual 281	com/tencent/luggage/wxa/i/e$a:b	(Lcom/tencent/luggage/wxa/j/d;)V
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 217	com/tencent/luggage/wxa/i/i:a	Lcom/tencent/luggage/wxa/j/d;
    //   35: invokevirtual 279	com/tencent/luggage/wxa/j/d:a	()V
    //   38: aload_0
    //   39: getfield 48	com/tencent/luggage/wxa/i/i:b	Lcom/tencent/luggage/wxa/i/e$a;
    //   42: aload_0
    //   43: getfield 217	com/tencent/luggage/wxa/i/i:a	Lcom/tencent/luggage/wxa/j/d;
    //   46: invokevirtual 281	com/tencent/luggage/wxa/i/e$a:b	(Lcom/tencent/luggage/wxa/j/d;)V
    //   49: aload_1
    //   50: athrow
    //   51: astore_1
    //   52: aload_0
    //   53: invokespecial 278	com/tencent/luggage/wxa/u/b:p	()V
    //   56: aload_0
    //   57: getfield 217	com/tencent/luggage/wxa/i/i:a	Lcom/tencent/luggage/wxa/j/d;
    //   60: invokevirtual 279	com/tencent/luggage/wxa/j/d:a	()V
    //   63: aload_0
    //   64: getfield 48	com/tencent/luggage/wxa/i/i:b	Lcom/tencent/luggage/wxa/i/e$a;
    //   67: aload_0
    //   68: getfield 217	com/tencent/luggage/wxa/i/i:a	Lcom/tencent/luggage/wxa/j/d;
    //   71: invokevirtual 281	com/tencent/luggage/wxa/i/e$a:b	(Lcom/tencent/luggage/wxa/j/d;)V
    //   74: aload_1
    //   75: athrow
    //   76: astore_1
    //   77: aload_0
    //   78: getfield 217	com/tencent/luggage/wxa/i/i:a	Lcom/tencent/luggage/wxa/j/d;
    //   81: invokevirtual 279	com/tencent/luggage/wxa/j/d:a	()V
    //   84: aload_0
    //   85: getfield 48	com/tencent/luggage/wxa/i/i:b	Lcom/tencent/luggage/wxa/i/e$a;
    //   88: aload_0
    //   89: getfield 217	com/tencent/luggage/wxa/i/i:a	Lcom/tencent/luggage/wxa/j/d;
    //   92: invokevirtual 281	com/tencent/luggage/wxa/i/e$a:b	(Lcom/tencent/luggage/wxa/j/d;)V
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	i
    //   30	20	1	localObject1	Object
    //   51	24	1	localObject2	Object
    //   76	20	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   7	11	30	finally
    //   0	7	51	finally
    //   52	56	76	finally
  }
  
  public boolean t()
  {
    return (this.c.e()) || (super.t());
  }
  
  public boolean u()
  {
    return (super.u()) && (this.c.d());
  }
  
  protected void v() {}
  
  public long w()
  {
    long l = this.c.a(u());
    if (l != -9223372036854775808L)
    {
      if (!this.j) {
        l = Math.max(this.i, l);
      }
      this.i = l;
      this.j = false;
    }
    return this.i;
  }
  
  public q x()
  {
    return this.c.f();
  }
  
  protected void y()
  {
    try
    {
      this.c.c();
      return;
    }
    catch (f.h localh)
    {
      throw com.tencent.luggage.wxa.h.e.a(localh, r());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.i.i
 * JD-Core Version:    0.7.0.1
 */