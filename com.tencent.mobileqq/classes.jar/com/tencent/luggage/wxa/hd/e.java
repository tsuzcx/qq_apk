package com.tencent.luggage.wxa.hd;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Process;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.qz.u;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public class e
{
  private MediaCodec a;
  private f.a b;
  private volatile boolean c = false;
  private AtomicInteger d = new AtomicInteger();
  private AtomicInteger e = new AtomicInteger();
  private AtomicInteger f = new AtomicInteger();
  private AtomicInteger g = new AtomicInteger();
  private AtomicInteger h = new AtomicInteger();
  private final int i = 10;
  private long j = 0L;
  private long k = 5000L;
  
  private e(MediaCodec paramMediaCodec, f.a parama)
  {
    this.a = paramMediaCodec;
    this.b = parama;
    this.c = true;
  }
  
  public static e a(String paramString)
  {
    o.d("MicroMsg.MediaCodecProxy", "into createDecoderByType, type = [%s]", new Object[] { paramString });
    Object localObject2 = new f.a();
    Object localObject1 = localObject2;
    try
    {
      a(7);
      localObject1 = localObject2;
      a(60);
      localObject1 = localObject2;
      localObject3 = MediaCodec.createDecoderByType(paramString);
      localObject1 = localObject2;
      a(61);
      localObject1 = localObject2;
      localObject2 = f.a(localObject3.hashCode(), false, paramString);
      localObject1 = localObject2;
      f.a(paramString, (f.a)localObject2);
      localObject1 = localObject2;
      f.a();
      localObject1 = localObject2;
      localObject2 = new e((MediaCodec)localObject3, (f.a)localObject2);
      return localObject2;
    }
    catch (Exception localException)
    {
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("createDecoderByType error ");
      ((StringBuilder)localObject3).append(paramString);
      o.a("MicroMsg.MediaCodecProxy", localException, ((StringBuilder)localObject3).toString(), new Object[0]);
      a(0, localException, localObject1);
      f.a(false, paramString, localObject1);
      throw localException;
    }
  }
  
  public static e a(String paramString, boolean paramBoolean)
  {
    o.d("MicroMsg.MediaCodecProxy", "into createEncoderByType, type = [%s]", new Object[] { paramString });
    Object localObject2 = new f.a();
    Object localObject1 = localObject2;
    try
    {
      a(7);
      localObject1 = localObject2;
      a(63);
      localObject1 = localObject2;
      localObject3 = MediaCodec.createEncoderByType(paramString);
      localObject1 = localObject2;
      a(64);
      localObject1 = localObject2;
      localObject2 = f.a(localObject3.hashCode(), true, paramString);
      localObject1 = localObject2;
      f.a(paramString, (f.a)localObject2);
      localObject1 = localObject2;
      f.a();
      localObject1 = localObject2;
      localObject2 = new e((MediaCodec)localObject3, (f.a)localObject2);
      return localObject2;
    }
    catch (Exception localException)
    {
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("createByCodecName error ");
      ((StringBuilder)localObject3).append(paramString);
      o.a("MicroMsg.MediaCodecProxy", localException, ((StringBuilder)localObject3).toString(), new Object[0]);
      if (!paramBoolean)
      {
        a(1, localException, localObject1);
        f.a(true, paramString, localObject1);
      }
      throw localException;
    }
  }
  
  private static String a(Exception paramException)
  {
    if (paramException != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramException.toString());
      localStringBuilder.append("----");
      localStringBuilder.append(af.c().toString());
      return localStringBuilder.toString();
    }
    return af.c().toString();
  }
  
  private static void a(int paramInt)
  {
    f.b.a(paramInt);
  }
  
  private static void a(int paramInt, @Nullable Exception paramException, f.a parama)
  {
    if (parama != null) {
      parama.c = a(paramException);
    }
    f.b.a(paramInt);
    f.b.a(paramInt, parama);
  }
  
  public static e b(String paramString)
  {
    return a(paramString, false);
  }
  
  private void g()
  {
    int m = this.d.get() + this.g.get() + this.h.get() + this.e.get() + this.f.get();
    if (m > 10)
    {
      o.e("MicroMsg.MediaCodecProxy", "reportCount count:[%d]", new Object[] { Integer.valueOf(m) });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("countFlush:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(";");
      localStringBuilder.append("countDequeueInputBuffer:");
      localStringBuilder.append(this.g);
      localStringBuilder.append(";");
      localStringBuilder.append("countDequeueOutputBuffer:");
      localStringBuilder.append(this.h);
      localStringBuilder.append(";");
      localStringBuilder.append("countQueueInputBuffer:");
      localStringBuilder.append(this.e);
      localStringBuilder.append(";");
      localStringBuilder.append("countQueueSecureInputBuffer:");
      localStringBuilder.append(this.f);
      localStringBuilder.append(";");
      Object localObject = this.b;
      if (localObject != null)
      {
        if (((f.a)localObject).f != null) {
          localObject = this.b.f.replace(",", ";");
        } else {
          localObject = "";
        }
        localStringBuilder.append(this.b.b);
        localStringBuilder.append(";");
        localStringBuilder.append(this.b.d);
        localStringBuilder.append(";");
        localStringBuilder.append(this.b.e);
        localStringBuilder.append(";");
        localStringBuilder.append(r.c());
        localStringBuilder.append(";");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(";");
        localStringBuilder.append("stack:");
        localStringBuilder.append(this.b.c);
      }
      f.b.a(16);
      f.b.a(16, localStringBuilder.toString());
      this.d.set(0);
      this.g.set(0);
      this.h.set(0);
      this.e.set(0);
      this.f.set(0);
    }
  }
  
  public final int a(long paramLong)
  {
    try
    {
      if (!this.c)
      {
        o.b("MicroMsg.MediaCodecProxy", "dequeueInputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        o.b("MicroMsg.MediaCodecProxy", "MediaCodecProxy dequeueInputBuffer not alive");
      }
      int m = this.a.dequeueInputBuffer(paramLong);
      return m;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy dequeueInputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      f.b.a(42);
      this.g.getAndIncrement();
      if (((c.a) || (c.b) || (c.c)) && (System.currentTimeMillis() - this.j > this.k))
      {
        this.j = System.currentTimeMillis();
        t.a(new e.2(this));
      }
      throw localException;
    }
  }
  
  public final int a(@NonNull MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    try
    {
      if (!this.c)
      {
        o.b("MicroMsg.MediaCodecProxy", "dequeueOutputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        o.b("MicroMsg.MediaCodecProxy", "MediaCodecProxy dequeueOutputBuffer not alive");
      }
      int m = this.a.dequeueOutputBuffer(paramBufferInfo, paramLong);
      return m;
    }
    catch (Exception paramBufferInfo)
    {
      o.a("MicroMsg.MediaCodecProxy", paramBufferInfo, "MediaCodecProxy dequeueOutputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      f.b.a(43);
      if (((c.a) || (c.b) || (c.c)) && (System.currentTimeMillis() - this.j > this.k))
      {
        this.j = System.currentTimeMillis();
        t.a(new e.3(this));
      }
      this.h.getAndIncrement();
      throw paramBufferInfo;
    }
  }
  
  public final void a()
  {
    try
    {
      a(11);
      o.d("MicroMsg.MediaCodecProxy", "into release function, thread:[%s], stack:[%s]", new Object[] { Integer.valueOf(Process.myTid()), af.c().toString() });
      if (!this.c)
      {
        o.b("MicroMsg.MediaCodecProxy", "release error, multi release, stack:[%s]", new Object[] { af.c().toString() });
        a(10, null, this.b);
      }
      f.a(this.a.hashCode());
      f.a();
      a(69);
      this.a.release();
      a(70);
      g();
      this.c = false;
      return;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy release", new Object[0]);
      a(30, localException, this.b);
      throw localException;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    try
    {
      if (!this.c)
      {
        o.b("MicroMsg.MediaCodecProxy", "queueInputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        o.b("MicroMsg.MediaCodecProxy", "MediaCodecProxy queueInputBuffer not alive");
      }
      this.a.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      return;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy queueInputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      f.b.a(40);
      this.e.getAndIncrement();
      if (((c.a) || (c.b) || (c.c)) && (System.currentTimeMillis() - this.j > this.k))
      {
        this.j = System.currentTimeMillis();
        t.a(new e.1(this));
      }
      throw localException;
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      if (!this.c)
      {
        o.b("MicroMsg.MediaCodecProxy", "releaseOutputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        o.b("MicroMsg.MediaCodecProxy", "MediaCodecProxy releaseOutputBuffer not alive");
      }
      this.a.releaseOutputBuffer(paramInt, paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy releaseOutputBuffer 1, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(44, localException, this.b);
      throw localException;
    }
  }
  
  public void a(@Nullable MediaFormat paramMediaFormat, @Nullable Surface paramSurface, @Nullable MediaCrypto paramMediaCrypto, int paramInt)
  {
    for (;;)
    {
      try
      {
        o.d("MicroMsg.MediaCodecProxy", "configure 1 function, thread:[%s], threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("configure 1 format = ");
        String str2 = "null";
        if (paramMediaFormat != null)
        {
          str1 = paramMediaFormat.toString();
          localStringBuilder.append(str1);
          localStringBuilder.append(" surface = ");
          if (paramSurface == null) {
            break label249;
          }
          str1 = paramSurface.toString();
          localStringBuilder.append(str1);
          localStringBuilder.append(" crypto = ");
          str1 = str2;
          if (paramMediaCrypto != null) {
            str1 = paramMediaCrypto.toString();
          }
          localStringBuilder.append(str1);
          localStringBuilder.append(" flags = ");
          localStringBuilder.append(paramInt);
          o.d("MicroMsg.MediaCodecProxy", localStringBuilder.toString());
          if (!this.c) {
            o.b("MicroMsg.MediaCodecProxy", "MediaCodecProxy configure not alive");
          }
          if (paramMediaFormat != null) {
            this.b.f = paramMediaFormat.toString();
          }
          a(75);
          this.a.configure(paramMediaFormat, paramSurface, paramMediaCrypto, paramInt);
          a(76);
          return;
        }
      }
      catch (Exception paramMediaFormat)
      {
        o.a("MicroMsg.MediaCodecProxy", paramMediaFormat, "MediaCodecProxy configure 1", new Object[0]);
        a(32, paramMediaFormat, this.b);
        throw paramMediaFormat;
      }
      String str1 = "null";
      continue;
      label249:
      str1 = "null";
    }
  }
  
  public final void b()
  {
    try
    {
      o.d("MicroMsg.MediaCodecProxy", "start function, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      if (!this.c) {
        o.b("MicroMsg.MediaCodecProxy", "MediaCodecProxy start not alive");
      }
      a(90);
      this.a.start();
      a(91);
      return;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy start", new Object[0]);
      a(37, localException, this.b);
      throw localException;
    }
  }
  
  public final void c()
  {
    try
    {
      o.d("MicroMsg.MediaCodecProxy", "stop function, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      if (!this.c) {
        o.b("MicroMsg.MediaCodecProxy", "MediaCodecProxy stop not alive");
      }
      a(93);
      this.a.stop();
      a(94);
      return;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy stop", new Object[0]);
      a(38, localException, this.b);
      throw localException;
    }
  }
  
  public final MediaFormat d()
  {
    try
    {
      a(120);
      MediaFormat localMediaFormat = this.a.getOutputFormat();
      a(121);
      return localMediaFormat;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getOutputFormat, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(47, localException, this.b);
      throw localException;
    }
  }
  
  public ByteBuffer[] e()
  {
    try
    {
      a(126);
      ByteBuffer[] arrayOfByteBuffer = this.a.getInputBuffers();
      a(127);
      return arrayOfByteBuffer;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getInputBuffers", new Object[0]);
      a(49, localException, this.b);
      throw localException;
    }
  }
  
  public ByteBuffer[] f()
  {
    try
    {
      a(129);
      ByteBuffer[] arrayOfByteBuffer = this.a.getOutputBuffers();
      a(130);
      return arrayOfByteBuffer;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getOutputBuffers", new Object[0]);
      a(50, localException, this.b);
      throw localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.e
 * JD-Core Version:    0.7.0.1
 */