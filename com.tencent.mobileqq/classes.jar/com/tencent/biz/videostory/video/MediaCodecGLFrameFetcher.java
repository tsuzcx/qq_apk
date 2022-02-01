package com.tencent.biz.videostory.video;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.TMG.utils.QLog;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public class MediaCodecGLFrameFetcher
{
  private int a;
  private int b;
  private String c;
  private MediaExtractor d;
  private MediaFormat e;
  private MediaCodec f;
  private ByteBuffer[] g;
  private MediaCodec.BufferInfo h;
  private int i;
  private int j;
  private boolean k = false;
  private long l = -1L;
  private SimpleGLThread m;
  private volatile SurfaceTexture n;
  private final Object o = new Object();
  private Surface p;
  private float[] q = new float[16];
  private volatile Bitmap r;
  private final AtomicBoolean s = new AtomicBoolean(false);
  private int t = 0;
  private long u = -1L;
  private boolean v = false;
  private OESTextureRender w;
  private int x;
  
  public MediaCodecGLFrameFetcher(long paramLong1, long paramLong2)
  {
    this.a = ((int)paramLong1);
    this.b = ((int)paramLong2);
  }
  
  private void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("finitRender: ");
    localStringBuilder.append(hashCode());
    QLog.i("MediaCodecGLFrameFetcher", 3, localStringBuilder.toString());
    this.n.release();
    GlUtil.a(this.x);
  }
  
  @TargetApi(16)
  private boolean b(long paramLong)
  {
    if (this.k) {
      return false;
    }
    try
    {
      for (;;)
      {
        int i1 = this.f.dequeueInputBuffer(0L);
        if (i1 >= 0)
        {
          ByteBuffer localByteBuffer = this.g[i1];
          int i2 = this.d.readSampleData(localByteBuffer, 0);
          long l1 = this.d.getSampleTime();
          if (i2 > 0)
          {
            this.d.advance();
            this.f.queueInputBuffer(i1, 0, i2, l1, 0);
          }
          else
          {
            QLog.i("MediaCodecGLFrameFetcher", 3, "decodeGOP: end of extractor");
            this.d.release();
            this.k = true;
            return false;
          }
        }
        i1 = this.f.dequeueOutputBuffer(this.h, 0L);
        if (i1 != -3) {
          if (i1 == -2)
          {
            this.e = this.f.getOutputFormat();
          }
          else if (i1 >= 0)
          {
            if (this.h.presentationTimeUs >= paramLong)
            {
              this.f.releaseOutputBuffer(i1, true);
              return true;
            }
            this.f.releaseOutputBuffer(i1, false);
          }
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.k = true;
    }
  }
  
  private void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initRender: ");
    localStringBuilder.append(hashCode());
    QLog.i("MediaCodecGLFrameFetcher", 3, localStringBuilder.toString());
    this.w = new OESTextureRender();
    this.w.a(true);
    this.w.b();
    this.n = new SurfaceTexture(this.w.a());
    this.x = GlUtil.a(this.i, this.j);
  }
  
  @TargetApi(16)
  private boolean d()
  {
    try
    {
      this.d = new MediaExtractor();
      this.d.setDataSource(this.c);
      this.e = e();
    }
    catch (Exception localException1)
    {
      label53:
      label58:
      localException1.printStackTrace();
      k();
      return false;
    }
    try
    {
      if (this.e == null) {
        break label58;
      }
      this.t = this.e.getInteger("rotation-degrees");
    }
    catch (Exception localException2)
    {
      break label53;
    }
    this.t = 0;
    if (!j())
    {
      k();
      return false;
    }
    this.m = new SimpleGLThread(null, "MediaCodecGLFrameFetcher");
    this.m.b(new MediaCodecGLFrameFetcher.2(this));
    if (this.n == null)
    {
      QLog.i("MediaCodecGLFrameFetcher", 3, "prepare: surface texture is null");
      return false;
    }
    i();
    this.h = new MediaCodec.BufferInfo();
    return true;
  }
  
  @TargetApi(16)
  private MediaFormat e()
  {
    int i1 = 0;
    while (i1 < this.d.getTrackCount())
    {
      MediaFormat localMediaFormat = this.d.getTrackFormat(i1);
      if (localMediaFormat.getString("mime").startsWith("video/"))
      {
        this.d.selectTrack(i1);
        return localMediaFormat;
      }
      i1 += 1;
    }
    return null;
  }
  
  private void f()
  {
    h();
    this.m.b(new MediaCodecGLFrameFetcher.3(this));
  }
  
  private void g()
  {
    synchronized (this.s)
    {
      QLog.i("MediaCodecGLFrameFetcher", 3, "notifyFrame");
      this.s.set(true);
      this.s.notifyAll();
      return;
    }
  }
  
  private void h()
  {
    synchronized (this.s)
    {
      boolean bool = this.s.get();
      if (!bool) {
        try
        {
          this.s.wait();
          QLog.i("MediaCodecGLFrameFetcher", 3, "waitFrame: done");
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      this.s.set(false);
      return;
    }
  }
  
  @TargetApi(16)
  private void i()
  {
    this.p = new Surface(this.n);
    this.n.setOnFrameAvailableListener(new MediaCodecGLFrameFetcher.4(this));
    this.f = MediaCodec.createDecoderByType(this.e.getString("mime"));
    this.f.configure(this.e, this.p, null, 0);
    this.f.start();
    this.g = this.f.getInputBuffers();
  }
  
  @TargetApi(16)
  private boolean j()
  {
    MediaFormat localMediaFormat = this.e;
    if (localMediaFormat == null) {
      return false;
    }
    this.i = localMediaFormat.getInteger("width");
    this.j = this.e.getInteger("height");
    int i1 = this.j;
    float f1 = i1;
    int i2 = this.i;
    f1 /= i2;
    int i3 = this.b;
    float f2 = i3;
    int i4 = this.a;
    if (f2 / i4 != f1)
    {
      f1 = Math.max(i4 / i2, i3 / i1);
      this.a = ((int)(this.i * f1));
      this.b = ((int)(this.j * f1));
    }
    i1 = this.t;
    if ((i1 == 270) || (i1 == 90))
    {
      i2 = this.a;
      i1 = this.b;
      this.a = (i2 ^ i1);
      i2 = this.a;
      this.b = (i1 ^ i2);
      this.a = (i2 ^ this.b);
    }
    return true;
  }
  
  /* Error */
  @TargetApi(16)
  private void k()
  {
    // Byte code:
    //   0: ldc 102
    //   2: iconst_3
    //   3: ldc_w 347
    //   6: invokestatic 111	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 143	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:g	[Ljava/nio/ByteBuffer;
    //   14: aload_0
    //   15: ldc2_w 53
    //   18: putfield 71	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:u	J
    //   21: aload_0
    //   22: getfield 81	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:r	Landroid/graphics/Bitmap;
    //   25: ifnull +25 -> 50
    //   28: aload_0
    //   29: getfield 81	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:r	Landroid/graphics/Bitmap;
    //   32: invokevirtual 352	android/graphics/Bitmap:isRecycled	()Z
    //   35: ifne +15 -> 50
    //   38: aload_0
    //   39: getfield 81	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:r	Landroid/graphics/Bitmap;
    //   42: invokevirtual 355	android/graphics/Bitmap:recycle	()V
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 81	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:r	Landroid/graphics/Bitmap;
    //   50: aload_0
    //   51: getfield 145	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:d	Landroid/media/MediaExtractor;
    //   54: ifnull +10 -> 64
    //   57: aload_0
    //   58: getfield 145	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:d	Landroid/media/MediaExtractor;
    //   61: invokevirtual 166	android/media/MediaExtractor:release	()V
    //   64: aload_0
    //   65: aconst_null
    //   66: putfield 145	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:d	Landroid/media/MediaExtractor;
    //   69: goto +15 -> 84
    //   72: astore_1
    //   73: goto +90 -> 163
    //   76: astore_1
    //   77: aload_1
    //   78: invokevirtual 190	java/lang/Exception:printStackTrace	()V
    //   81: goto -17 -> 64
    //   84: aload_0
    //   85: getfield 311	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:p	Landroid/view/Surface;
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +34 -> 124
    //   93: aload_1
    //   94: invokevirtual 356	android/view/Surface:release	()V
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield 311	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:p	Landroid/view/Surface;
    //   102: goto +22 -> 124
    //   105: astore_1
    //   106: goto +11 -> 117
    //   109: astore_1
    //   110: aload_1
    //   111: invokevirtual 190	java/lang/Exception:printStackTrace	()V
    //   114: goto -17 -> 97
    //   117: aload_0
    //   118: aconst_null
    //   119: putfield 311	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:p	Landroid/view/Surface;
    //   122: aload_1
    //   123: athrow
    //   124: aload_0
    //   125: getfield 135	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:f	Landroid/media/MediaCodec;
    //   128: ifnull +10 -> 138
    //   131: aload_0
    //   132: getfield 135	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:f	Landroid/media/MediaCodec;
    //   135: invokevirtual 357	android/media/MediaCodec:release	()V
    //   138: aload_0
    //   139: aconst_null
    //   140: putfield 135	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:f	Landroid/media/MediaCodec;
    //   143: return
    //   144: astore_1
    //   145: goto +11 -> 156
    //   148: astore_1
    //   149: aload_1
    //   150: invokevirtual 190	java/lang/Exception:printStackTrace	()V
    //   153: goto -15 -> 138
    //   156: aload_0
    //   157: aconst_null
    //   158: putfield 135	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:f	Landroid/media/MediaCodec;
    //   161: aload_1
    //   162: athrow
    //   163: aload_0
    //   164: aconst_null
    //   165: putfield 145	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:d	Landroid/media/MediaExtractor;
    //   168: goto +5 -> 173
    //   171: aload_1
    //   172: athrow
    //   173: goto -2 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	MediaCodecGLFrameFetcher
    //   72	1	1	localObject1	Object
    //   76	2	1	localException1	Exception
    //   88	6	1	localSurface	Surface
    //   105	1	1	localObject2	Object
    //   109	14	1	localException2	Exception
    //   144	1	1	localObject3	Object
    //   148	24	1	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   50	64	72	finally
    //   77	81	72	finally
    //   50	64	76	java/lang/Exception
    //   93	97	105	finally
    //   110	114	105	finally
    //   93	97	109	java/lang/Exception
    //   124	138	144	finally
    //   149	153	144	finally
    //   124	138	148	java/lang/Exception
  }
  
  public Bitmap a(long paramLong)
  {
    return a(paramLong, Bitmap.Config.ARGB_8888);
  }
  
  @TargetApi(16)
  public Bitmap a(long paramLong, Bitmap.Config paramConfig)
  {
    long l1 = paramLong * 1000L;
    if (this.u == -1L) {
      this.u = this.e.getLong("durationUs");
    }
    paramLong = l1;
    if (l1 > this.u)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("prepareSeek: pos=");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", du=");
      ((StringBuilder)localObject).append(this.u);
      QLog.w("MediaCodecGLFrameFetcher", 3, ((StringBuilder)localObject).toString());
      paramLong = this.u;
    }
    this.d.seekTo(paramLong, 2);
    paramLong = this.d.getSampleTime();
    boolean bool = b(paramLong);
    Object localObject = null;
    if (!bool)
    {
      paramConfig = new StringBuilder();
      paramConfig.append("getFrame: decode error, ts ");
      paramConfig.append(paramLong);
      QLog.e("MediaCodecGLFrameFetcher", 1, paramConfig.toString());
      return null;
    }
    f();
    this.l = paramLong;
    if (this.r != null) {
      localObject = this.r.copy(paramConfig, true);
    }
    return localObject;
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("release: ");
    ((StringBuilder)localObject).append(hashCode());
    QLog.d("MediaCodecGLFrameFetcher", 3, ((StringBuilder)localObject).toString());
    localObject = this.m;
    if (localObject != null)
    {
      ((SimpleGLThread)localObject).b(new MediaCodecGLFrameFetcher.1(this));
      this.m.a();
      this.m = null;
    }
    k();
    this.v = true;
  }
  
  public boolean a(String paramString)
  {
    if (!this.v)
    {
      this.c = paramString;
      return d();
    }
    throw new RuntimeException("should not reuse!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher
 * JD-Core Version:    0.7.0.1
 */