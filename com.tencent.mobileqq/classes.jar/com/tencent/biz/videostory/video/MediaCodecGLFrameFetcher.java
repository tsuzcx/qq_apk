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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private volatile Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private volatile SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private OESTextureRender jdField_a_of_type_ComTencentBizVideostoryVideoOESTextureRender;
  private SimpleGLThread jdField_a_of_type_ComTencentBizVideostoryVideoSimpleGLThread;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  private int d;
  private int e = 0;
  private int f;
  
  public MediaCodecGLFrameFetcher(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Int = ((int)paramLong1);
    this.jdField_b_of_type_Int = ((int)paramLong2);
  }
  
  @TargetApi(16)
  private MediaFormat a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackCount())
    {
      MediaFormat localMediaFormat = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i);
      if (localMediaFormat.getString("mime").startsWith("video/"))
      {
        this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(i);
        return localMediaFormat;
      }
      i += 1;
    }
    return null;
  }
  
  @TargetApi(16)
  private boolean a()
  {
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
      this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidMediaMediaFormat = a();
    }
    catch (Exception localException1)
    {
      label53:
      label58:
      localException1.printStackTrace();
      h();
      return false;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaFormat == null) {
        break label58;
      }
      this.e = this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("rotation-degrees");
    }
    catch (Exception localException2)
    {
      break label53;
    }
    this.e = 0;
    if (!b())
    {
      h();
      return false;
    }
    this.jdField_a_of_type_ComTencentBizVideostoryVideoSimpleGLThread = new SimpleGLThread(null, "MediaCodecGLFrameFetcher");
    this.jdField_a_of_type_ComTencentBizVideostoryVideoSimpleGLThread.b(new MediaCodecGLFrameFetcher.2(this));
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null)
    {
      QLog.i("MediaCodecGLFrameFetcher", 3, "prepare: surface texture is null");
      return false;
    }
    g();
    this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
    return true;
  }
  
  @TargetApi(16)
  private boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    try
    {
      for (;;)
      {
        int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(0L);
        if (i >= 0)
        {
          ByteBuffer localByteBuffer = this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[i];
          int j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(localByteBuffer, 0);
          long l = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
          if (j > 0)
          {
            this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
            this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, l, 0);
          }
          else
          {
            QLog.i("MediaCodecGLFrameFetcher", 3, "decodeGOP: end of extractor");
            this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
            this.jdField_a_of_type_Boolean = true;
            return false;
          }
        }
        i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 0L);
        if (i != -3) {
          if (i == -2)
          {
            this.jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
          }
          else if (i >= 0)
          {
            if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs >= paramLong)
            {
              this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, true);
              return true;
            }
            this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, false);
          }
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("finitRender: ");
    localStringBuilder.append(hashCode());
    QLog.i("MediaCodecGLFrameFetcher", 3, localStringBuilder.toString());
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
    GlUtil.a(this.f);
  }
  
  @TargetApi(16)
  private boolean b()
  {
    MediaFormat localMediaFormat = this.jdField_a_of_type_AndroidMediaMediaFormat;
    if (localMediaFormat == null) {
      return false;
    }
    this.c = localMediaFormat.getInteger("width");
    this.d = this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("height");
    int i = this.d;
    float f1 = i;
    int j = this.c;
    f1 /= j;
    int k = this.jdField_b_of_type_Int;
    float f2 = k;
    int m = this.jdField_a_of_type_Int;
    if (f2 / m != f1)
    {
      f1 = Math.max(m / j, k / i);
      this.jdField_a_of_type_Int = ((int)(this.c * f1));
      this.jdField_b_of_type_Int = ((int)(this.d * f1));
    }
    i = this.e;
    if ((i == 270) || (i == 90))
    {
      j = this.jdField_a_of_type_Int;
      i = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Int = (j ^ i);
      j = this.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = (i ^ j);
      this.jdField_a_of_type_Int = (j ^ this.jdField_b_of_type_Int);
    }
    return true;
  }
  
  private void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initRender: ");
    localStringBuilder.append(hashCode());
    QLog.i("MediaCodecGLFrameFetcher", 3, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentBizVideostoryVideoOESTextureRender = new OESTextureRender();
    this.jdField_a_of_type_ComTencentBizVideostoryVideoOESTextureRender.a(true);
    this.jdField_a_of_type_ComTencentBizVideostoryVideoOESTextureRender.a();
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_ComTencentBizVideostoryVideoOESTextureRender.a());
    this.f = GlUtil.a(this.c, this.d);
  }
  
  private void d()
  {
    f();
    this.jdField_a_of_type_ComTencentBizVideostoryVideoSimpleGLThread.b(new MediaCodecGLFrameFetcher.3(this));
  }
  
  private void e()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      QLog.i("MediaCodecGLFrameFetcher", 3, "notifyFrame");
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
      return;
    }
  }
  
  private void f()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      boolean bool = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
      if (!bool) {
        try
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.wait();
          QLog.i("MediaCodecGLFrameFetcher", 3, "waitFrame: done");
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
  }
  
  @TargetApi(16)
  private void g()
  {
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(new MediaCodecGLFrameFetcher.4(this));
    this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType(this.jdField_a_of_type_AndroidMediaMediaFormat.getString("mime"));
    this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, this.jdField_a_of_type_AndroidViewSurface, null, 0);
    this.jdField_a_of_type_AndroidMediaMediaCodec.start();
    this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
  }
  
  /* Error */
  @TargetApi(16)
  private void h()
  {
    // Byte code:
    //   0: ldc 140
    //   2: iconst_3
    //   3: ldc_w 333
    //   6: invokestatic 160	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 182	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:jdField_a_of_type_ArrayOfJavaNioByteBuffer	[Ljava/nio/ByteBuffer;
    //   14: aload_0
    //   15: ldc2_w 35
    //   18: putfield 53	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:jdField_b_of_type_Long	J
    //   21: aload_0
    //   22: getfield 64	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   25: ifnull +25 -> 50
    //   28: aload_0
    //   29: getfield 64	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   32: invokevirtual 338	android/graphics/Bitmap:isRecycled	()Z
    //   35: ifne +15 -> 50
    //   38: aload_0
    //   39: getfield 64	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   42: invokevirtual 341	android/graphics/Bitmap:recycle	()V
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 64	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   50: aload_0
    //   51: getfield 74	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   54: ifnull +10 -> 64
    //   57: aload_0
    //   58: getfield 74	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   61: invokevirtual 202	android/media/MediaExtractor:release	()V
    //   64: aload_0
    //   65: aconst_null
    //   66: putfield 74	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   69: goto +15 -> 84
    //   72: astore_1
    //   73: goto +90 -> 163
    //   76: astore_1
    //   77: aload_1
    //   78: invokevirtual 171	java/lang/Exception:printStackTrace	()V
    //   81: goto -17 -> 64
    //   84: aload_0
    //   85: getfield 309	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:jdField_a_of_type_AndroidViewSurface	Landroid/view/Surface;
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +34 -> 124
    //   93: aload_1
    //   94: invokevirtual 342	android/view/Surface:release	()V
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield 309	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:jdField_a_of_type_AndroidViewSurface	Landroid/view/Surface;
    //   102: goto +22 -> 124
    //   105: astore_1
    //   106: goto +11 -> 117
    //   109: astore_1
    //   110: aload_1
    //   111: invokevirtual 171	java/lang/Exception:printStackTrace	()V
    //   114: goto -17 -> 97
    //   117: aload_0
    //   118: aconst_null
    //   119: putfield 309	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:jdField_a_of_type_AndroidViewSurface	Landroid/view/Surface;
    //   122: aload_1
    //   123: athrow
    //   124: aload_0
    //   125: getfield 174	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   128: ifnull +10 -> 138
    //   131: aload_0
    //   132: getfield 174	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   135: invokevirtual 343	android/media/MediaCodec:release	()V
    //   138: aload_0
    //   139: aconst_null
    //   140: putfield 174	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   143: return
    //   144: astore_1
    //   145: goto +11 -> 156
    //   148: astore_1
    //   149: aload_1
    //   150: invokevirtual 171	java/lang/Exception:printStackTrace	()V
    //   153: goto -15 -> 138
    //   156: aload_0
    //   157: aconst_null
    //   158: putfield 174	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   161: aload_1
    //   162: athrow
    //   163: aload_0
    //   164: aconst_null
    //   165: putfield 74	com/tencent/biz/videostory/video/MediaCodecGLFrameFetcher:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
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
    long l = paramLong * 1000L;
    if (this.jdField_b_of_type_Long == -1L) {
      this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidMediaMediaFormat.getLong("durationUs");
    }
    paramLong = l;
    if (l > this.jdField_b_of_type_Long)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("prepareSeek: pos=");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(", du=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
      QLog.w("MediaCodecGLFrameFetcher", 3, ((StringBuilder)localObject).toString());
      paramLong = this.jdField_b_of_type_Long;
    }
    this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(paramLong, 2);
    paramLong = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
    boolean bool = a(paramLong);
    Object localObject = null;
    if (!bool)
    {
      paramConfig = new StringBuilder();
      paramConfig.append("getFrame: decode error, ts ");
      paramConfig.append(paramLong);
      QLog.e("MediaCodecGLFrameFetcher", 1, paramConfig.toString());
      return null;
    }
    d();
    this.jdField_a_of_type_Long = paramLong;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      localObject = this.jdField_a_of_type_AndroidGraphicsBitmap.copy(paramConfig, true);
    }
    return localObject;
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("release: ");
    ((StringBuilder)localObject).append(hashCode());
    QLog.d("MediaCodecGLFrameFetcher", 3, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentBizVideostoryVideoSimpleGLThread;
    if (localObject != null)
    {
      ((SimpleGLThread)localObject).b(new MediaCodecGLFrameFetcher.1(this));
      this.jdField_a_of_type_ComTencentBizVideostoryVideoSimpleGLThread.a();
      this.jdField_a_of_type_ComTencentBizVideostoryVideoSimpleGLThread = null;
    }
    h();
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean a(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      return a();
    }
    throw new RuntimeException("should not reuse!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher
 * JD-Core Version:    0.7.0.1
 */