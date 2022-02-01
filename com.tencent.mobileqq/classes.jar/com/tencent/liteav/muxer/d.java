package com.tencent.liteav.muxer;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.muxer.jni.TXSWMuxerJNI;
import com.tencent.liteav.muxer.jni.TXSWMuxerJNI.AVOptions;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

@TargetApi(18)
public class d
  implements a
{
  public static float a = 0.5F;
  public static float b = 0.8F;
  public static float c = 1.25F;
  public static float d = 2.0F;
  private int e = 2;
  private TXSWMuxerJNI f;
  private String g = null;
  private MediaFormat h = null;
  private MediaFormat i = null;
  private int j = 0;
  private int k = 0;
  private boolean l = false;
  private boolean m = false;
  private ConcurrentLinkedQueue<d.a> n = new ConcurrentLinkedQueue();
  private ConcurrentLinkedQueue<d.a> o = new ConcurrentLinkedQueue();
  private long p = -1L;
  private long q = -1L;
  private long r = -1L;
  
  private void a(long paramLong)
  {
    while (this.o.size() > 0) {
      if (((d.a)this.o.peek()).b() == null)
      {
        TXCLog.e("TXCMP4SWMuxer", "flushAudioCache, bufferInfo is null");
        this.o.remove();
      }
      else
      {
        if (((d.a)this.o.peek()).b().presentationTimeUs >= paramLong) {
          break;
        }
        d.a locala = (d.a)this.o.poll();
        d(locala.a(), locala.b());
      }
    }
  }
  
  private void a(boolean paramBoolean, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (paramByteBuffer != null)
    {
      if (paramBufferInfo == null) {
        return;
      }
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramByteBuffer.capacity());
      paramByteBuffer.rewind();
      if (paramBufferInfo.size > 0)
      {
        paramByteBuffer.position(paramBufferInfo.offset);
        paramByteBuffer.limit(paramBufferInfo.size);
      }
      localByteBuffer.rewind();
      localByteBuffer.put(paramByteBuffer);
      paramByteBuffer = new MediaCodec.BufferInfo();
      paramByteBuffer.set(paramBufferInfo.offset, paramBufferInfo.size, paramBufferInfo.presentationTimeUs, paramBufferInfo.flags);
      paramByteBuffer = new d.a(localByteBuffer, paramByteBuffer);
      if (paramBoolean)
      {
        if (this.n.size() < 200)
        {
          this.n.add(paramByteBuffer);
          return;
        }
        TXCLog.e("TXCMP4SWMuxer", "drop video frame. video cache size is larger than 200");
        return;
      }
      this.o.add(paramByteBuffer);
    }
  }
  
  private void c(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    long l2 = paramBufferInfo.presentationTimeUs - this.p;
    long l1 = l2;
    Object localObject;
    if (l2 < 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pts error! first frame offset timeus = ");
      ((StringBuilder)localObject).append(this.p);
      ((StringBuilder)localObject).append(", current timeus = ");
      ((StringBuilder)localObject).append(paramBufferInfo.presentationTimeUs);
      TXCLog.e("TXCMP4SWMuxer", ((StringBuilder)localObject).toString());
      l1 = this.q;
      if (l1 <= 0L) {
        l1 = 0L;
      }
    }
    if (l1 < this.q)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("video is not in chronological order. current frame's pts(");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(") smaller than pre frame's pts(");
      ((StringBuilder)localObject).append(this.q);
      ((StringBuilder)localObject).append(")");
      TXCLog.w("TXCMP4SWMuxer", ((StringBuilder)localObject).toString());
    }
    else
    {
      this.q = l1;
    }
    int i1 = this.e;
    if (i1 == 2)
    {
      l2 = l1;
    }
    else
    {
      float f1;
      float f2;
      if (i1 == 3)
      {
        f1 = (float)l1;
        f2 = b;
      }
      for (;;)
      {
        l2 = (f1 * f2);
        break;
        if (i1 == 4)
        {
          f1 = (float)l1;
          f2 = a;
        }
        else if (i1 == 1)
        {
          f1 = (float)l1;
          f2 = c;
        }
        else
        {
          l2 = l1;
          if (i1 != 0) {
            break;
          }
          f1 = (float)l1;
          f2 = d;
        }
      }
    }
    paramBufferInfo.presentationTimeUs = l2;
    for (;;)
    {
      try
      {
        paramByteBuffer.position(paramBufferInfo.offset);
        paramByteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
        localObject = this.f;
        int i2 = paramBufferInfo.offset;
        int i3 = paramBufferInfo.size;
        if (paramBufferInfo.flags != 1) {
          break label435;
        }
        i1 = 1;
        ((TXSWMuxerJNI)localObject).a(paramByteBuffer, 1, i2, i3, i1, paramBufferInfo.presentationTimeUs);
        if ((paramBufferInfo.flags & 0x1) != 0)
        {
          this.m = true;
          return;
        }
      }
      catch (IllegalArgumentException paramByteBuffer)
      {
        paramBufferInfo = new StringBuilder();
        paramBufferInfo.append("write frame IllegalArgumentException: ");
        paramBufferInfo.append(paramByteBuffer);
        TXCLog.e("TXCMP4SWMuxer", paramBufferInfo.toString());
        return;
      }
      catch (IllegalStateException paramByteBuffer)
      {
        paramBufferInfo = new StringBuilder();
        paramBufferInfo.append("write frame IllegalStateException: ");
        paramBufferInfo.append(paramByteBuffer);
        TXCLog.e("TXCMP4SWMuxer", paramBufferInfo.toString());
      }
      return;
      label435:
      i1 = 0;
    }
  }
  
  private ByteBuffer d()
  {
    ByteBuffer localByteBuffer = this.i.getByteBuffer("csd-0");
    if (localByteBuffer != null) {
      localByteBuffer.position(0);
    }
    return localByteBuffer;
  }
  
  private void d(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    long l1 = paramBufferInfo.presentationTimeUs;
    long l2 = this.p;
    l1 -= l2;
    if ((l2 >= 0L) && (l1 >= 0L))
    {
      if (l1 < this.r)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("audio is not in chronological order. current audio's pts pts(");
        localStringBuilder.append(l1);
        localStringBuilder.append(") must larger than pre audio's pts(");
        localStringBuilder.append(this.r);
        localStringBuilder.append(")");
        TXCLog.e("TXCMP4SWMuxer", localStringBuilder.toString());
        l1 = this.r + 1L;
      }
      else
      {
        this.r = l1;
      }
      int i1 = this.e;
      if (i1 == 2)
      {
        l2 = l1;
      }
      else
      {
        float f1;
        float f2;
        if (i1 == 3)
        {
          f1 = (float)l1;
          f2 = b;
        }
        for (;;)
        {
          l2 = (f1 * f2);
          break;
          if (i1 == 4)
          {
            f1 = (float)l1;
            f2 = a;
          }
          else if (i1 == 1)
          {
            f1 = (float)l1;
            f2 = c;
          }
          else
          {
            l2 = l1;
            if (i1 != 0) {
              break;
            }
            f1 = (float)l1;
            f2 = d;
          }
        }
      }
      paramBufferInfo.presentationTimeUs = l2;
      try
      {
        paramByteBuffer.position(paramBufferInfo.offset);
        paramByteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
        this.f.a(paramByteBuffer, 0, paramBufferInfo.offset, paramBufferInfo.size, paramBufferInfo.flags, paramBufferInfo.presentationTimeUs);
        return;
      }
      catch (IllegalArgumentException paramByteBuffer)
      {
        paramBufferInfo = new StringBuilder();
        paramBufferInfo.append("write sample IllegalArgumentException: ");
        paramBufferInfo.append(paramByteBuffer);
        TXCLog.e("TXCMP4SWMuxer", paramBufferInfo.toString());
        return;
      }
      catch (IllegalStateException paramByteBuffer)
      {
        paramBufferInfo = new StringBuilder();
        paramBufferInfo.append("write sample IllegalStateException: ");
        paramBufferInfo.append(paramByteBuffer);
        TXCLog.e("TXCMP4SWMuxer", paramBufferInfo.toString());
        return;
      }
    }
    paramByteBuffer = new StringBuilder();
    paramByteBuffer.append("drop sample. first frame offset timeus = ");
    paramByteBuffer.append(this.p);
    paramByteBuffer.append(", current sample timeus = ");
    paramByteBuffer.append(paramBufferInfo.presentationTimeUs);
    TXCLog.w("TXCMP4SWMuxer", paramByteBuffer.toString());
  }
  
  private ByteBuffer e()
  {
    return this.h.getByteBuffer("csd-0");
  }
  
  private ByteBuffer f()
  {
    return this.h.getByteBuffer("csd-1");
  }
  
  private long g()
  {
    long l1;
    if (this.n.size() > 0) {
      l1 = ((d.a)this.n.peek()).b().presentationTimeUs;
    } else {
      l1 = 0L;
    }
    long l2 = l1;
    if (this.o.size() > 0)
    {
      d.a locala = (d.a)this.o.peek();
      l2 = l1;
      if (locala != null)
      {
        l2 = l1;
        if (locala.b() != null)
        {
          long l3 = ((d.a)this.o.peek()).b().presentationTimeUs;
          l2 = l1;
          if (l1 > l3) {
            l2 = l3;
          }
        }
      }
    }
    return l2;
  }
  
  private void h()
  {
    d.a locala;
    while (this.n.size() > 0)
    {
      locala = (d.a)this.n.poll();
      c(locala.a(), locala.b());
    }
    while (this.o.size() > 0)
    {
      locala = (d.a)this.o.poll();
      d(locala.a(), locala.b());
    }
  }
  
  private void i()
  {
    while (this.n.size() > 0)
    {
      d.a locala = (d.a)this.n.poll();
      a(locala.b().presentationTimeUs);
      c(locala.a(), locala.b());
    }
  }
  
  public int a()
  {
    for (;;)
    {
      ByteBuffer localByteBuffer2;
      ByteBuffer localByteBuffer3;
      try
      {
        if ((this.g != null) && (!this.g.isEmpty()))
        {
          if (!c())
          {
            TXCLog.e("TXCMP4SWMuxer", "video track not set yet!");
            return -2;
          }
          if (this.f != null)
          {
            TXCLog.w("TXCMP4SWMuxer", "start has been called. stop must be called before start");
            return 0;
          }
          TXCLog.d("TXCMP4SWMuxer", "start");
          this.f = new TXSWMuxerJNI();
          TXSWMuxerJNI.AVOptions localAVOptions = new TXSWMuxerJNI.AVOptions();
          if (this.h != null)
          {
            i1 = this.h.getInteger("width");
            localAVOptions.videoHeight = this.h.getInteger("height");
            localAVOptions.videoWidth = i1;
            if (this.h.containsKey("i-frame-interval"))
            {
              i1 = this.h.getInteger("i-frame-interval");
              localAVOptions.videoGOP = i1;
            }
          }
          else
          {
            if (this.i != null)
            {
              i1 = this.i.getInteger("channel-count");
              int i2 = this.i.getInteger("sample-rate");
              localAVOptions.audioChannels = i1;
              localAVOptions.audioSampleRate = i2;
            }
            localByteBuffer2 = e();
            localByteBuffer3 = f();
            ByteBuffer localByteBuffer1 = null;
            if (this.i == null) {
              break label391;
            }
            localByteBuffer1 = d();
            break label391;
            if ((this.i != null) && (localByteBuffer1 == null))
            {
              TXCLog.e("TXCMP4SWMuxer", "audio format contains error csd!");
              return -3;
            }
            this.f.a(localByteBuffer2, localByteBuffer2.capacity(), localByteBuffer3, localByteBuffer3.capacity());
            if (this.i != null) {
              this.f.a(localByteBuffer1, localByteBuffer1.capacity());
            }
            this.f.a(localAVOptions);
            this.f.a(this.g);
            this.f.a();
            this.p = -1L;
            this.l = true;
            this.m = false;
            this.q = -1L;
            this.r = -1L;
            return 0;
            TXCLog.e("TXCMP4SWMuxer", "video format contains error csd!");
            return -3;
          }
        }
        else
        {
          TXCLog.e("TXCMP4SWMuxer", "target path not set yet!");
          return -1;
        }
      }
      finally {}
      int i1 = 3;
      continue;
      label391:
      if (localByteBuffer2 != null) {
        if (localByteBuffer3 != null) {}
      }
    }
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addVideoTrack:");
      localStringBuilder.append(paramMediaFormat);
      TXCLog.d("TXCMP4SWMuxer", localStringBuilder.toString());
      this.h = paramMediaFormat;
      this.n.clear();
      return;
    }
    finally
    {
      paramMediaFormat = finally;
      throw paramMediaFormat;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.g = paramString;
      if (!TextUtils.isEmpty(this.g))
      {
        paramString = new File(this.g);
        File localFile = paramString.getParentFile();
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        if (paramString.exists()) {
          paramString.delete();
        }
        try
        {
          paramString.createNewFile();
        }
        catch (IOException paramString)
        {
          TXCLog.e("TXCMP4SWMuxer", "create new file failed.", paramString);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    try
    {
      if (this.f == null)
      {
        a(true, paramByteBuffer, paramBufferInfo);
        paramByteBuffer = new StringBuilder();
        paramByteBuffer.append("cache frame before muexer ready. ptsUs: ");
        paramByteBuffer.append(paramBufferInfo.presentationTimeUs);
        TXCLog.w("TXCMP4SWMuxer", paramByteBuffer.toString());
        return;
      }
      if (this.p < 0L)
      {
        a(true, paramByteBuffer, paramBufferInfo);
        this.p = g();
        paramByteBuffer = new StringBuilder();
        paramByteBuffer.append("first frame offset = ");
        paramByteBuffer.append(this.p);
        TXCLog.d("TXCMP4SWMuxer", paramByteBuffer.toString());
        i();
      }
      else
      {
        a(paramBufferInfo.presentationTimeUs);
        c(paramByteBuffer, paramBufferInfo);
      }
      return;
    }
    finally {}
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt2);
      localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = new MediaCodec.BufferInfo();
      paramArrayOfByte.presentationTimeUs = paramLong;
      paramArrayOfByte.offset = 0;
      paramArrayOfByte.size = paramInt2;
      paramArrayOfByte.flags = paramInt3;
      b(localByteBuffer, paramArrayOfByte);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  /* Error */
  public int b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 204	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   6: ifnull +296 -> 302
    //   9: aload_0
    //   10: invokespecial 380	com/tencent/liteav/muxer/d:h	()V
    //   13: new 169	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   20: astore_1
    //   21: aload_1
    //   22: ldc_w 382
    //   25: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_1
    //   30: aload_0
    //   31: getfield 60	com/tencent/liteav/muxer/d:l	Z
    //   34: invokevirtual 385	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_1
    //   39: ldc_w 387
    //   42: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_1
    //   47: aload_0
    //   48: getfield 62	com/tencent/liteav/muxer/d:m	Z
    //   51: invokevirtual 385	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: ldc 93
    //   57: aload_1
    //   58: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 259	com/tencent/liteav/basic/log/TXCLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_0
    //   65: getfield 60	com/tencent/liteav/muxer/d:l	Z
    //   68: ifeq +18 -> 86
    //   71: aload_0
    //   72: getfield 62	com/tencent/liteav/muxer/d:m	Z
    //   75: ifeq +11 -> 86
    //   78: aload_0
    //   79: getfield 204	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   82: invokevirtual 389	com/tencent/liteav/muxer/jni/TXSWMuxerJNI:b	()I
    //   85: pop
    //   86: aload_0
    //   87: getfield 204	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   90: invokevirtual 391	com/tencent/liteav/muxer/jni/TXSWMuxerJNI:c	()V
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 204	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 60	com/tencent/liteav/muxer/d:l	Z
    //   103: aload_0
    //   104: aconst_null
    //   105: putfield 204	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   108: aload_0
    //   109: iconst_0
    //   110: putfield 62	com/tencent/liteav/muxer/d:m	Z
    //   113: aload_0
    //   114: getfield 67	com/tencent/liteav/muxer/d:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   117: invokevirtual 328	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   120: aload_0
    //   121: getfield 69	com/tencent/liteav/muxer/d:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   124: invokevirtual 328	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   127: aload_0
    //   128: aconst_null
    //   129: putfield 52	com/tencent/liteav/muxer/d:h	Landroid/media/MediaFormat;
    //   132: aload_0
    //   133: aconst_null
    //   134: putfield 54	com/tencent/liteav/muxer/d:i	Landroid/media/MediaFormat;
    //   137: aload_0
    //   138: ldc2_w 70
    //   141: putfield 75	com/tencent/liteav/muxer/d:q	J
    //   144: aload_0
    //   145: ldc2_w 70
    //   148: putfield 77	com/tencent/liteav/muxer/d:r	J
    //   151: goto +151 -> 302
    //   154: astore_1
    //   155: goto +92 -> 247
    //   158: astore_1
    //   159: new 169	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   166: astore_2
    //   167: aload_2
    //   168: ldc_w 393
    //   171: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_2
    //   176: aload_1
    //   177: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: ldc 93
    //   183: aload_2
    //   184: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 100	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_0
    //   191: iconst_0
    //   192: putfield 60	com/tencent/liteav/muxer/d:l	Z
    //   195: aload_0
    //   196: aconst_null
    //   197: putfield 204	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   200: aload_0
    //   201: iconst_0
    //   202: putfield 62	com/tencent/liteav/muxer/d:m	Z
    //   205: aload_0
    //   206: getfield 67	com/tencent/liteav/muxer/d:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   209: invokevirtual 328	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   212: aload_0
    //   213: getfield 69	com/tencent/liteav/muxer/d:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   216: invokevirtual 328	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   219: aload_0
    //   220: aconst_null
    //   221: putfield 52	com/tencent/liteav/muxer/d:h	Landroid/media/MediaFormat;
    //   224: aload_0
    //   225: aconst_null
    //   226: putfield 54	com/tencent/liteav/muxer/d:i	Landroid/media/MediaFormat;
    //   229: aload_0
    //   230: ldc2_w 70
    //   233: putfield 75	com/tencent/liteav/muxer/d:q	J
    //   236: aload_0
    //   237: ldc2_w 70
    //   240: putfield 77	com/tencent/liteav/muxer/d:r	J
    //   243: aload_0
    //   244: monitorexit
    //   245: iconst_m1
    //   246: ireturn
    //   247: aload_0
    //   248: iconst_0
    //   249: putfield 60	com/tencent/liteav/muxer/d:l	Z
    //   252: aload_0
    //   253: aconst_null
    //   254: putfield 204	com/tencent/liteav/muxer/d:f	Lcom/tencent/liteav/muxer/jni/TXSWMuxerJNI;
    //   257: aload_0
    //   258: iconst_0
    //   259: putfield 62	com/tencent/liteav/muxer/d:m	Z
    //   262: aload_0
    //   263: getfield 67	com/tencent/liteav/muxer/d:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   266: invokevirtual 328	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   269: aload_0
    //   270: getfield 69	com/tencent/liteav/muxer/d:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   273: invokevirtual 328	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   276: aload_0
    //   277: aconst_null
    //   278: putfield 52	com/tencent/liteav/muxer/d:h	Landroid/media/MediaFormat;
    //   281: aload_0
    //   282: aconst_null
    //   283: putfield 54	com/tencent/liteav/muxer/d:i	Landroid/media/MediaFormat;
    //   286: aload_0
    //   287: ldc2_w 70
    //   290: putfield 75	com/tencent/liteav/muxer/d:q	J
    //   293: aload_0
    //   294: ldc2_w 70
    //   297: putfield 77	com/tencent/liteav/muxer/d:r	J
    //   300: aload_1
    //   301: athrow
    //   302: aload_0
    //   303: monitorexit
    //   304: iconst_0
    //   305: ireturn
    //   306: astore_1
    //   307: aload_0
    //   308: monitorexit
    //   309: aload_1
    //   310: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	d
    //   20	38	1	localStringBuilder1	StringBuilder
    //   154	1	1	localObject1	Object
    //   158	143	1	localException	java.lang.Exception
    //   306	4	1	localObject2	Object
    //   166	18	2	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   64	86	154	finally
    //   86	98	154	finally
    //   159	190	154	finally
    //   64	86	158	java/lang/Exception
    //   86	98	158	java/lang/Exception
    //   2	64	306	finally
    //   98	151	306	finally
    //   190	243	306	finally
    //   247	302	306	finally
  }
  
  public void b(MediaFormat paramMediaFormat)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addAudioTrack:");
      localStringBuilder.append(paramMediaFormat);
      TXCLog.d("TXCMP4SWMuxer", localStringBuilder.toString());
      this.i = paramMediaFormat;
      this.o.clear();
      return;
    }
    finally
    {
      paramMediaFormat = finally;
      throw paramMediaFormat;
    }
  }
  
  public void b(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    try
    {
      a(false, paramByteBuffer, paramBufferInfo);
      return;
    }
    finally
    {
      paramByteBuffer = finally;
      throw paramByteBuffer;
    }
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt2);
      localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = new MediaCodec.BufferInfo();
      paramArrayOfByte.presentationTimeUs = paramLong;
      paramArrayOfByte.offset = 0;
      paramArrayOfByte.size = paramInt2;
      paramArrayOfByte.flags = paramInt3;
      a(localByteBuffer, paramArrayOfByte);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public boolean c()
  {
    try
    {
      MediaFormat localMediaFormat = this.h;
      return localMediaFormat != null;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.muxer.d
 * JD-Core Version:    0.7.0.1
 */