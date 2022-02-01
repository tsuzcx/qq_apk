package com.tencent.liteav.muxer;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

@TargetApi(18)
public class b
  implements a
{
  public static float a = 0.5F;
  public static float b = 0.8F;
  public static float c = 1.25F;
  public static float d = 2.0F;
  private int e = 2;
  private MediaMuxer f;
  private String g = null;
  private MediaFormat h = null;
  private MediaFormat i = null;
  private int j = 0;
  private int k = 0;
  private boolean l = false;
  private boolean m = false;
  private ConcurrentLinkedQueue<b.a> n = new ConcurrentLinkedQueue();
  private ConcurrentLinkedQueue<b.a> o = new ConcurrentLinkedQueue();
  private long p = -1L;
  private long q = -1L;
  private long r = -1L;
  
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
      paramByteBuffer = new b.a(localByteBuffer, paramByteBuffer);
      if (paramBoolean)
      {
        if (this.n.size() < 200)
        {
          this.n.add(paramByteBuffer);
          return;
        }
        TXCLog.e("TXCMP4HWMuxer", "drop video frame. video cache size is larger than 200");
        return;
      }
      if (this.o.size() < 600)
      {
        this.o.add(paramByteBuffer);
        return;
      }
      TXCLog.e("TXCMP4HWMuxer", "drop audio frame. audio cache size is larger than 600");
    }
  }
  
  private void c(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    long l2 = paramBufferInfo.presentationTimeUs - this.p;
    long l1 = l2;
    StringBuilder localStringBuilder;
    if (l2 < 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pts error! first frame offset timeus = ");
      localStringBuilder.append(this.p);
      localStringBuilder.append(", current timeus = ");
      localStringBuilder.append(paramBufferInfo.presentationTimeUs);
      TXCLog.e("TXCMP4HWMuxer", localStringBuilder.toString());
      l1 = this.q;
      if (l1 <= 0L) {
        l1 = 0L;
      }
    }
    if (l1 < this.q)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("video is not in chronological order. current frame's pts(");
      localStringBuilder.append(l1);
      localStringBuilder.append(") smaller than pre frame's pts(");
      localStringBuilder.append(this.q);
      localStringBuilder.append(")");
      TXCLog.w("TXCMP4HWMuxer", localStringBuilder.toString());
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
    try
    {
      paramByteBuffer.position(paramBufferInfo.offset);
      paramByteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
      this.f.writeSampleData(this.k, paramByteBuffer, paramBufferInfo);
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
      TXCLog.e("TXCMP4HWMuxer", paramBufferInfo.toString());
      return;
    }
    catch (IllegalStateException paramByteBuffer)
    {
      paramBufferInfo = new StringBuilder();
      paramBufferInfo.append("write frame IllegalStateException: ");
      paramBufferInfo.append(paramByteBuffer);
      TXCLog.e("TXCMP4HWMuxer", paramBufferInfo.toString());
    }
  }
  
  private long d()
  {
    long l1;
    if (this.n.size() > 0) {
      l1 = ((b.a)this.n.peek()).b().presentationTimeUs;
    } else {
      l1 = 0L;
    }
    long l2 = l1;
    if (this.o.size() > 0)
    {
      b.a locala = (b.a)this.o.peek();
      l2 = l1;
      if (locala != null)
      {
        l2 = l1;
        if (locala.b() != null)
        {
          long l3 = ((b.a)this.o.peek()).b().presentationTimeUs;
          l2 = l1;
          if (l1 > l3) {
            l2 = l3;
          }
        }
      }
    }
    return l2;
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
        TXCLog.e("TXCMP4HWMuxer", localStringBuilder.toString());
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
        this.f.writeSampleData(this.j, paramByteBuffer, paramBufferInfo);
        return;
      }
      catch (IllegalArgumentException paramByteBuffer)
      {
        paramBufferInfo = new StringBuilder();
        paramBufferInfo.append("write sample IllegalArgumentException: ");
        paramBufferInfo.append(paramByteBuffer);
        TXCLog.e("TXCMP4HWMuxer", paramBufferInfo.toString());
        return;
      }
      catch (IllegalStateException paramByteBuffer)
      {
        paramBufferInfo = new StringBuilder();
        paramBufferInfo.append("write sample IllegalStateException: ");
        paramBufferInfo.append(paramByteBuffer);
        TXCLog.e("TXCMP4HWMuxer", paramBufferInfo.toString());
        return;
      }
    }
    paramByteBuffer = new StringBuilder();
    paramByteBuffer.append("drop sample. first frame offset timeus = ");
    paramByteBuffer.append(this.p);
    paramByteBuffer.append(", current sample timeus = ");
    paramByteBuffer.append(paramBufferInfo.presentationTimeUs);
    TXCLog.w("TXCMP4HWMuxer", paramByteBuffer.toString());
  }
  
  private void e()
  {
    b.a locala;
    while (this.n.size() > 0)
    {
      locala = (b.a)this.n.poll();
      c(locala.a(), locala.b());
    }
    while (this.o.size() > 0)
    {
      locala = (b.a)this.o.poll();
      d(locala.a(), locala.b());
    }
  }
  
  public int a()
  {
    try
    {
      if ((this.g != null) && (!this.g.isEmpty()))
      {
        if (!c())
        {
          TXCLog.e("TXCMP4HWMuxer", "video track not set yet!");
          return -2;
        }
        if (this.f != null)
        {
          TXCLog.w("TXCMP4HWMuxer", "start has been called. stop must be called before start");
          return 0;
        }
        TXCLog.d("TXCMP4HWMuxer", "start");
        try
        {
          this.f = new MediaMuxer(this.g, 0);
          MediaFormat localMediaFormat1 = this.h;
          if (localMediaFormat1 != null) {
            try
            {
              this.k = this.f.addTrack(this.h);
            }
            catch (IllegalStateException localIllegalStateException1)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("addVideoTrack IllegalStateException: ");
              localStringBuilder.append(localIllegalStateException1);
              TXCLog.e("TXCMP4HWMuxer", localStringBuilder.toString());
              return -6;
            }
            catch (IllegalArgumentException localIllegalArgumentException1)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("addVideoTrack IllegalArgumentException: ");
              localStringBuilder.append(localIllegalArgumentException1);
              TXCLog.e("TXCMP4HWMuxer", localStringBuilder.toString());
              return -5;
            }
          }
          MediaFormat localMediaFormat2 = this.i;
          if (localMediaFormat2 != null) {
            try
            {
              this.j = this.f.addTrack(this.i);
            }
            catch (IllegalStateException localIllegalStateException2)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("addAudioTrack IllegalStateException: ");
              localStringBuilder.append(localIllegalStateException2);
              TXCLog.e("TXCMP4HWMuxer", localStringBuilder.toString());
              return -8;
            }
            catch (IllegalArgumentException localIllegalArgumentException2)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("addAudioTrack IllegalArgumentException: ");
              localStringBuilder.append(localIllegalArgumentException2);
              TXCLog.e("TXCMP4HWMuxer", localStringBuilder.toString());
              return -7;
            }
          }
          this.f.start();
          this.p = -1L;
          this.l = true;
          this.m = false;
          this.q = -1L;
          this.r = -1L;
          return 0;
        }
        catch (IOException localIOException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("create MediaMuxer exception:");
          localStringBuilder.append(localIOException);
          TXCLog.e("TXCMP4HWMuxer", localStringBuilder.toString());
          return -4;
        }
      }
      TXCLog.e("TXCMP4HWMuxer", "target path not set yet!");
      return -1;
    }
    finally {}
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addVideoTrack:");
      localStringBuilder.append(paramMediaFormat);
      TXCLog.d("TXCMP4HWMuxer", localStringBuilder.toString());
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
          TXCLog.e("TXCMP4HWMuxer", "create new file failed.", paramString);
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
        TXCLog.w("TXCMP4HWMuxer", paramByteBuffer.toString());
        return;
      }
      if (this.p < 0L)
      {
        a(true, paramByteBuffer, paramBufferInfo);
        this.p = d();
        paramByteBuffer = new StringBuilder();
        paramByteBuffer.append("first frame offset = ");
        paramByteBuffer.append(this.p);
        TXCLog.d("TXCMP4HWMuxer", paramByteBuffer.toString());
        e();
      }
      else
      {
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
    //   3: getfield 185	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   6: ifnull +286 -> 292
    //   9: new 150	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   16: astore_1
    //   17: aload_1
    //   18: ldc_w 324
    //   21: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_1
    //   26: aload_0
    //   27: getfield 60	com/tencent/liteav/muxer/b:l	Z
    //   30: invokevirtual 327	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_1
    //   35: ldc_w 329
    //   38: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_1
    //   43: aload_0
    //   44: getfield 62	com/tencent/liteav/muxer/b:m	Z
    //   47: invokevirtual 327	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: ldc 135
    //   53: aload_1
    //   54: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 246	com/tencent/liteav/basic/log/TXCLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 60	com/tencent/liteav/muxer/b:l	Z
    //   64: ifeq +17 -> 81
    //   67: aload_0
    //   68: getfield 62	com/tencent/liteav/muxer/b:m	Z
    //   71: ifeq +10 -> 81
    //   74: aload_0
    //   75: getfield 185	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   78: invokevirtual 332	android/media/MediaMuxer:stop	()V
    //   81: aload_0
    //   82: getfield 185	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   85: invokevirtual 335	android/media/MediaMuxer:release	()V
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 60	com/tencent/liteav/muxer/b:l	Z
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 185	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 62	com/tencent/liteav/muxer/b:m	Z
    //   103: aload_0
    //   104: getfield 67	com/tencent/liteav/muxer/b:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   107: invokevirtual 273	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   110: aload_0
    //   111: getfield 69	com/tencent/liteav/muxer/b:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   114: invokevirtual 273	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   117: aload_0
    //   118: aconst_null
    //   119: putfield 52	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   122: aload_0
    //   123: aconst_null
    //   124: putfield 54	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   127: aload_0
    //   128: ldc2_w 70
    //   131: putfield 75	com/tencent/liteav/muxer/b:q	J
    //   134: aload_0
    //   135: ldc2_w 70
    //   138: putfield 77	com/tencent/liteav/muxer/b:r	J
    //   141: goto +151 -> 292
    //   144: astore_1
    //   145: goto +92 -> 237
    //   148: astore_1
    //   149: new 150	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   156: astore_2
    //   157: aload_2
    //   158: ldc_w 337
    //   161: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_2
    //   166: aload_1
    //   167: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: ldc 135
    //   173: aload_2
    //   174: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 142	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload_0
    //   181: iconst_0
    //   182: putfield 60	com/tencent/liteav/muxer/b:l	Z
    //   185: aload_0
    //   186: aconst_null
    //   187: putfield 185	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   190: aload_0
    //   191: iconst_0
    //   192: putfield 62	com/tencent/liteav/muxer/b:m	Z
    //   195: aload_0
    //   196: getfield 67	com/tencent/liteav/muxer/b:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   199: invokevirtual 273	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   202: aload_0
    //   203: getfield 69	com/tencent/liteav/muxer/b:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   206: invokevirtual 273	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   209: aload_0
    //   210: aconst_null
    //   211: putfield 52	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   214: aload_0
    //   215: aconst_null
    //   216: putfield 54	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   219: aload_0
    //   220: ldc2_w 70
    //   223: putfield 75	com/tencent/liteav/muxer/b:q	J
    //   226: aload_0
    //   227: ldc2_w 70
    //   230: putfield 77	com/tencent/liteav/muxer/b:r	J
    //   233: aload_0
    //   234: monitorexit
    //   235: iconst_m1
    //   236: ireturn
    //   237: aload_0
    //   238: iconst_0
    //   239: putfield 60	com/tencent/liteav/muxer/b:l	Z
    //   242: aload_0
    //   243: aconst_null
    //   244: putfield 185	com/tencent/liteav/muxer/b:f	Landroid/media/MediaMuxer;
    //   247: aload_0
    //   248: iconst_0
    //   249: putfield 62	com/tencent/liteav/muxer/b:m	Z
    //   252: aload_0
    //   253: getfield 67	com/tencent/liteav/muxer/b:n	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   256: invokevirtual 273	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   259: aload_0
    //   260: getfield 69	com/tencent/liteav/muxer/b:o	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   263: invokevirtual 273	java/util/concurrent/ConcurrentLinkedQueue:clear	()V
    //   266: aload_0
    //   267: aconst_null
    //   268: putfield 52	com/tencent/liteav/muxer/b:h	Landroid/media/MediaFormat;
    //   271: aload_0
    //   272: aconst_null
    //   273: putfield 54	com/tencent/liteav/muxer/b:i	Landroid/media/MediaFormat;
    //   276: aload_0
    //   277: ldc2_w 70
    //   280: putfield 75	com/tencent/liteav/muxer/b:q	J
    //   283: aload_0
    //   284: ldc2_w 70
    //   287: putfield 77	com/tencent/liteav/muxer/b:r	J
    //   290: aload_1
    //   291: athrow
    //   292: aload_0
    //   293: monitorexit
    //   294: iconst_0
    //   295: ireturn
    //   296: astore_1
    //   297: aload_0
    //   298: monitorexit
    //   299: aload_1
    //   300: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	b
    //   16	38	1	localStringBuilder1	StringBuilder
    //   144	1	1	localObject1	Object
    //   148	143	1	localException	java.lang.Exception
    //   296	4	1	localObject2	Object
    //   156	18	2	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   60	81	144	finally
    //   81	88	144	finally
    //   149	180	144	finally
    //   60	81	148	java/lang/Exception
    //   81	88	148	java/lang/Exception
    //   2	60	296	finally
    //   88	141	296	finally
    //   180	233	296	finally
    //   237	292	296	finally
  }
  
  public void b(MediaFormat paramMediaFormat)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addAudioTrack:");
      localStringBuilder.append(paramMediaFormat);
      TXCLog.d("TXCMP4HWMuxer", localStringBuilder.toString());
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
      if ((this.f != null) && (this.p >= 0L))
      {
        d(paramByteBuffer, paramBufferInfo);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cache sample before muexer ready. ptsUs: ");
      localStringBuilder.append(paramBufferInfo.presentationTimeUs);
      TXCLog.d("TXCMP4HWMuxer", localStringBuilder.toString());
      a(false, paramByteBuffer, paramBufferInfo);
      return;
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.muxer.b
 * JD-Core Version:    0.7.0.1
 */