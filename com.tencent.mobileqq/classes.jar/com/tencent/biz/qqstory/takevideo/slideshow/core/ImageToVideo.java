package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.SystemClock;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video;
import com.tencent.mobileqq.richmedia.capture.util.SVParamManager;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQImage2FrameFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThrowablesUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

public class ImageToVideo
  extends ToVideoConverter
{
  long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  long jdField_b_of_type_Long;
  private long jdField_c_of_type_Long = 0L;
  private String jdField_c_of_type_JavaLangString;
  
  public ImageToVideo(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private int a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramBitmap == null) || (paramInt2 == 0) || (paramInt1 == 0)) {
      if (paramBitmap == null) {
        paramInt1 = i;
      }
    }
    do
    {
      return paramInt1;
      try
      {
        return GlUtil.createTexture(3553, paramBitmap);
      }
      catch (IllegalStateException paramBitmap) {}
      i = GlUtil.createTexture(3553, paramBitmap);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = new QQFilterRenderManager();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceCreate(paramInt1, paramInt2, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceChange(paramInt1, paramInt2, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.pushChain(new int[] { 170 }, null);
      List localList = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getQQFilters(170);
      if ((localList != null) && (localList.size() > 0) && ((localList.get(0) instanceof QQImage2FrameFilter))) {
        ((QQImage2FrameFilter)localList.get(0)).setImageSize(paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.drawFrame(i);
      paramInt1 = paramInt2;
    } while (i <= 0);
    GlUtil.deleteTexture(i);
    return paramInt2;
    return -1;
  }
  
  /* Error */
  private int a(String paramString)
  {
    // Byte code:
    //   0: new 96	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 97	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_1
    //   12: invokevirtual 101	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   15: aload 4
    //   17: bipush 9
    //   19: invokevirtual 105	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   22: invokestatic 110	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   25: istore_2
    //   26: iload_2
    //   27: istore_3
    //   28: aload 4
    //   30: ifnull +10 -> 40
    //   33: aload 4
    //   35: invokevirtual 113	android/media/MediaMetadataRetriever:release	()V
    //   38: iload_2
    //   39: istore_3
    //   40: iload_3
    //   41: ireturn
    //   42: astore_1
    //   43: aconst_null
    //   44: astore 4
    //   46: iconst_m1
    //   47: istore_3
    //   48: aload 4
    //   50: ifnull -10 -> 40
    //   53: aload 4
    //   55: invokevirtual 113	android/media/MediaMetadataRetriever:release	()V
    //   58: iconst_m1
    //   59: ireturn
    //   60: astore_1
    //   61: aconst_null
    //   62: astore 4
    //   64: aload 4
    //   66: ifnull +8 -> 74
    //   69: aload 4
    //   71: invokevirtual 113	android/media/MediaMetadataRetriever:release	()V
    //   74: aload_1
    //   75: athrow
    //   76: astore_1
    //   77: goto -13 -> 64
    //   80: astore_1
    //   81: goto -35 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	ImageToVideo
    //   0	84	1	paramString	String
    //   25	14	2	i	int
    //   27	21	3	j	int
    //   7	63	4	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   0	9	42	java/lang/Exception
    //   0	9	60	finally
    //   9	26	76	finally
    //   9	26	80	java/lang/Exception
  }
  
  @TargetApi(16)
  public static MediaFormat a()
  {
    EncodeConfig localEncodeConfig = new EncodeConfig("", 720, 1280, SVParamManager.a().a(1) * 1000, 1, false, 0);
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat("video/avc", 720, 1280);
    localMediaFormat.setInteger("color-format", 2130708361);
    localMediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[] { 0, 0, 0, 1, 103, 66, -128, 31, -38, 2, -48, 40, 105, 72, 40, 48, 40, 54, -123, 9, -88 }));
    localMediaFormat.setByteBuffer("csd-1", ByteBuffer.wrap(new byte[] { 0, 0, 0, 1, 104, -50, 6, -30 }));
    localMediaFormat.setInteger("bitrate", localEncodeConfig.c);
    localMediaFormat.setInteger("frame-rate", localEncodeConfig.d);
    localMediaFormat.setInteger("i-frame-interval", localEncodeConfig.e);
    return localMediaFormat;
  }
  
  @TargetApi(16)
  public static MediaFormat a(String paramString)
  {
    localMediaExtractor = new MediaExtractor();
    try
    {
      long l = SystemClock.elapsedRealtime();
      localMediaExtractor.setDataSource(paramString);
      int i = 0;
      while (i < localMediaExtractor.getTrackCount())
      {
        paramString = localMediaExtractor.getTrackFormat(i);
        if (paramString.getString("mime").startsWith("video/"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ImageToVideo", 2, "getVideoFormatFromVideo, elapsed Time : " + (SystemClock.elapsedRealtime() - l));
          }
          return paramString;
        }
        i += 1;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, ThrowablesUtils.a(paramString));
        }
        localMediaExtractor.release();
      }
    }
    finally
    {
      localMediaExtractor.release();
    }
    return null;
  }
  
  private int b(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap == null) || (paramInt2 == 0) || (paramInt1 == 0))
    {
      if (paramBitmap == null) {
        return 0;
      }
      return GlUtil.createTexture(3553, paramBitmap);
    }
    Object localObject1 = Image2Video.a(paramBitmap, 0.05F, 5, false);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
    float f2 = paramInt1 * 1.0F / paramInt2;
    float f1 = paramBitmap.getWidth() * 1.0F / paramBitmap.getHeight();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    localObject1 = new Matrix();
    ((Matrix)localObject1).postTranslate(i * -0.5F, j * -0.5F);
    float f3;
    float f4;
    Object localObject2;
    if (f1 > f2)
    {
      ((Matrix)localObject1).postScale(1.0F, paramInt1 * 1.0F / paramBitmap.getWidth() * paramBitmap.getHeight() / paramInt2);
      f2 = paramInt2;
      f3 = paramInt1 / f1;
      f4 = paramInt1;
      float f5 = paramInt2;
      localObject2 = new RectF(0.0F, 0.5F * (f2 - f3), f4, (paramInt1 / f1 + f5) * 0.5F);
      localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, i, j), (RectF)localObject2, null);
    }
    for (;;)
    {
      ((Matrix)localObject1).postTranslate(paramInt1 * 0.5F, paramInt2 * 0.5F);
      return GlUtil.createTexture(3553, localBitmap);
      ((Matrix)localObject1).postScale(paramInt2 * 1.0F / paramBitmap.getHeight() * paramBitmap.getWidth() / paramInt1, 1.0F);
      localObject2 = new Rect(0, 0, i, j);
      f2 = paramInt1;
      f3 = paramInt2;
      f4 = paramInt1;
      localCanvas.drawBitmap(paramBitmap, (Rect)localObject2, new RectF((f2 - f3 * f1) * 0.5F, 0.0F, (f1 * paramInt2 + f4) * 0.5F, paramInt2), null);
    }
  }
  
  /* Error */
  public void a(SlideShowProcessor.ConvertContext paramConvertContext)
  {
    // Byte code:
    //   0: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +32 -> 35
    //   6: ldc 244
    //   8: iconst_2
    //   9: new 246	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 328
    //   19: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: getfield 332	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:d	Z
    //   26: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 338	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)Z
    //   40: ifeq +34 -> 74
    //   43: ldc_w 340
    //   46: iconst_1
    //   47: anewarray 232	java/lang/String
    //   50: dup
    //   51: iconst_0
    //   52: ldc_w 342
    //   55: aastore
    //   56: invokestatic 347	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   59: aload_0
    //   60: bipush 9
    //   62: aload_1
    //   63: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   66: aconst_null
    //   67: aconst_null
    //   68: aconst_null
    //   69: aload_1
    //   70: invokevirtual 352	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)V
    //   73: return
    //   74: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   77: lstore_3
    //   78: new 359	java/io/FileInputStream
    //   81: dup
    //   82: aload_1
    //   83: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   86: invokespecial 361	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   89: astore 10
    //   91: new 363	java/io/BufferedInputStream
    //   94: dup
    //   95: aload 10
    //   97: ldc_w 364
    //   100: invokespecial 367	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   103: astore 9
    //   105: aload_0
    //   106: aload 9
    //   108: aconst_null
    //   109: aload_1
    //   110: getfield 369	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_Int	I
    //   113: aload_1
    //   114: getfield 370	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Int	I
    //   117: invokestatic 375	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/io/InputStream;Landroid/graphics/Rect;II)Landroid/graphics/Bitmap;
    //   120: putfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   123: aload 9
    //   125: ifnull +8 -> 133
    //   128: aload 9
    //   130: invokevirtual 378	java/io/BufferedInputStream:close	()V
    //   133: aload 10
    //   135: ifnull +8 -> 143
    //   138: aload 10
    //   140: invokevirtual 379	java/io/FileInputStream:close	()V
    //   143: aload_0
    //   144: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   147: ifnonnull +22 -> 169
    //   150: aload_0
    //   151: aload_1
    //   152: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   155: aload_1
    //   156: getfield 369	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_Int	I
    //   159: aload_1
    //   160: getfield 370	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Int	I
    //   163: invokestatic 382	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   166: putfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   169: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   172: lstore 5
    //   174: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +51 -> 228
    //   180: ldc 244
    //   182: iconst_2
    //   183: new 246	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   190: ldc_w 384
    //   193: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_1
    //   197: getfield 386	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Long	J
    //   200: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   203: ldc_w 388
    //   206: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: lload 5
    //   211: lload_3
    //   212: lsub
    //   213: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   216: ldc_w 390
    //   219: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload_0
    //   229: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   232: ifnonnull +204 -> 436
    //   235: aload_1
    //   236: iconst_0
    //   237: putfield 332	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:d	Z
    //   240: ldc_w 340
    //   243: iconst_1
    //   244: anewarray 232	java/lang/String
    //   247: dup
    //   248: iconst_0
    //   249: ldc_w 392
    //   252: aastore
    //   253: invokestatic 347	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   256: aload_0
    //   257: iconst_5
    //   258: aload_1
    //   259: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   262: aconst_null
    //   263: aconst_null
    //   264: aconst_null
    //   265: aload_1
    //   266: invokevirtual 352	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)V
    //   269: return
    //   270: astore 8
    //   272: aload_0
    //   273: aconst_null
    //   274: putfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   277: aload_0
    //   278: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   281: ifnonnull +310 -> 591
    //   284: aload_1
    //   285: iconst_0
    //   286: putfield 332	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:d	Z
    //   289: ldc_w 340
    //   292: iconst_1
    //   293: anewarray 232	java/lang/String
    //   296: dup
    //   297: iconst_0
    //   298: ldc_w 392
    //   301: aastore
    //   302: invokestatic 347	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   305: aload_0
    //   306: iconst_5
    //   307: aload_1
    //   308: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   311: aconst_null
    //   312: aconst_null
    //   313: aconst_null
    //   314: aload_1
    //   315: invokevirtual 352	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)V
    //   318: return
    //   319: astore 10
    //   321: aconst_null
    //   322: astore 8
    //   324: aconst_null
    //   325: astore 9
    //   327: aload 10
    //   329: invokevirtual 395	java/lang/Exception:printStackTrace	()V
    //   332: aload 9
    //   334: ifnull +8 -> 342
    //   337: aload 9
    //   339: invokevirtual 378	java/io/BufferedInputStream:close	()V
    //   342: aload 8
    //   344: ifnull -201 -> 143
    //   347: aload 8
    //   349: invokevirtual 379	java/io/FileInputStream:close	()V
    //   352: goto -209 -> 143
    //   355: astore 8
    //   357: goto -214 -> 143
    //   360: astore 8
    //   362: aconst_null
    //   363: astore 10
    //   365: aconst_null
    //   366: astore 9
    //   368: aload 9
    //   370: ifnull +8 -> 378
    //   373: aload 9
    //   375: invokevirtual 378	java/io/BufferedInputStream:close	()V
    //   378: aload 10
    //   380: ifnull +8 -> 388
    //   383: aload 10
    //   385: invokevirtual 379	java/io/FileInputStream:close	()V
    //   388: aload 8
    //   390: athrow
    //   391: astore 8
    //   393: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   396: ifeq +32 -> 428
    //   399: ldc 244
    //   401: iconst_2
    //   402: new 246	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   409: ldc_w 397
    //   412: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload_1
    //   416: getfield 386	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Long	J
    //   419: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   422: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: aload_0
    //   429: aconst_null
    //   430: putfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   433: goto -156 -> 277
    //   436: aload_1
    //   437: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   440: invokestatic 401	com/tencent/mobileqq/utils/ImageUtil:c	(Ljava/lang/String;)I
    //   443: istore_2
    //   444: iload_2
    //   445: ifeq +88 -> 533
    //   448: iload_2
    //   449: bipush 90
    //   451: irem
    //   452: ifne +81 -> 533
    //   455: new 297	android/graphics/Matrix
    //   458: dup
    //   459: invokespecial 298	android/graphics/Matrix:<init>	()V
    //   462: astore 8
    //   464: aload 8
    //   466: iload_2
    //   467: i2f
    //   468: aload_0
    //   469: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   472: invokevirtual 71	android/graphics/Bitmap:getWidth	()I
    //   475: i2f
    //   476: fconst_2
    //   477: fdiv
    //   478: aload_0
    //   479: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   482: invokevirtual 74	android/graphics/Bitmap:getHeight	()I
    //   485: i2f
    //   486: fconst_2
    //   487: fdiv
    //   488: invokevirtual 405	android/graphics/Matrix:postRotate	(FFF)Z
    //   491: pop
    //   492: aload_0
    //   493: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   496: iconst_0
    //   497: iconst_0
    //   498: aload_0
    //   499: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   502: invokevirtual 71	android/graphics/Bitmap:getWidth	()I
    //   505: aload_0
    //   506: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   509: invokevirtual 74	android/graphics/Bitmap:getHeight	()I
    //   512: aload 8
    //   514: iconst_1
    //   515: invokestatic 408	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   518: astore 8
    //   520: aload_0
    //   521: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   524: invokevirtual 411	android/graphics/Bitmap:recycle	()V
    //   527: aload_0
    //   528: aload 8
    //   530: putfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   533: aload_0
    //   534: aload_1
    //   535: invokevirtual 338	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)Z
    //   538: ifeq -261 -> 277
    //   541: aload_0
    //   542: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   545: ifnull +15 -> 560
    //   548: aload_0
    //   549: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   552: invokevirtual 411	android/graphics/Bitmap:recycle	()V
    //   555: aload_0
    //   556: aconst_null
    //   557: putfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   560: ldc_w 340
    //   563: iconst_1
    //   564: anewarray 232	java/lang/String
    //   567: dup
    //   568: iconst_0
    //   569: ldc_w 342
    //   572: aastore
    //   573: invokestatic 347	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   576: aload_0
    //   577: bipush 9
    //   579: aload_1
    //   580: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   583: aconst_null
    //   584: aconst_null
    //   585: aconst_null
    //   586: aload_1
    //   587: invokevirtual 352	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)V
    //   590: return
    //   591: new 413	java/io/File
    //   594: dup
    //   595: getstatic 415	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   598: invokespecial 416	java/io/File:<init>	(Ljava/lang/String;)V
    //   601: astore 8
    //   603: aload 8
    //   605: invokevirtual 419	java/io/File:exists	()Z
    //   608: ifne +43 -> 651
    //   611: aload 8
    //   613: invokevirtual 422	java/io/File:mkdirs	()Z
    //   616: istore 7
    //   618: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   621: ifeq +30 -> 651
    //   624: ldc 244
    //   626: iconst_2
    //   627: new 246	java/lang/StringBuilder
    //   630: dup
    //   631: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   634: ldc_w 424
    //   637: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: iload 7
    //   642: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   645: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   651: new 413	java/io/File
    //   654: dup
    //   655: aload_1
    //   656: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   659: invokespecial 416	java/io/File:<init>	(Ljava/lang/String;)V
    //   662: astore 9
    //   664: aload 9
    //   666: ifnull +1047 -> 1713
    //   669: aload 9
    //   671: invokevirtual 427	java/io/File:getName	()Ljava/lang/String;
    //   674: astore 8
    //   676: aload 8
    //   678: invokestatic 433	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   681: ifne +1029 -> 1710
    //   684: aload 8
    //   686: ldc_w 435
    //   689: ldc_w 437
    //   692: invokevirtual 441	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   695: astore 8
    //   697: new 246	java/lang/StringBuilder
    //   700: dup
    //   701: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   704: aload 8
    //   706: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: ldc_w 437
    //   712: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: aload 9
    //   717: invokevirtual 444	java/io/File:length	()J
    //   720: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   723: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   726: astore 8
    //   728: new 246	java/lang/StringBuilder
    //   731: dup
    //   732: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   735: aload 8
    //   737: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: ldc_w 446
    //   743: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: astore 8
    //   751: invokestatic 451	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/common/app/AppInterface;
    //   754: getstatic 454	com/tencent/mobileqq/app/PeakAppInterface:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   757: invokevirtual 460	com/tencent/common/app/AppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   760: checkcast 462	com/tencent/biz/qqstory/takevideo/slideshow/TransitionHandler
    //   763: astore 9
    //   765: aload 9
    //   767: aload_1
    //   768: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   771: invokevirtual 465	com/tencent/biz/qqstory/takevideo/slideshow/TransitionHandler:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   774: ifnull +37 -> 811
    //   777: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   780: ifeq -707 -> 73
    //   783: ldc 244
    //   785: iconst_2
    //   786: new 246	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   793: aload 8
    //   795: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: ldc_w 467
    //   801: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   807: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   810: return
    //   811: aload_0
    //   812: new 246	java/lang/StringBuilder
    //   815: dup
    //   816: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   819: getstatic 470	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   822: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: aload 8
    //   827: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: invokespecial 472	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(Ljava/lang/String;)I
    //   836: sipush 1000
    //   839: if_icmplt +168 -> 1007
    //   842: new 246	java/lang/StringBuilder
    //   845: dup
    //   846: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   849: getstatic 470	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   852: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: aload 8
    //   857: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: ldc_w 474
    //   863: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   869: invokestatic 478	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   872: ifeq +135 -> 1007
    //   875: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   878: ifeq +30 -> 908
    //   881: ldc 244
    //   883: iconst_2
    //   884: new 246	java/lang/StringBuilder
    //   887: dup
    //   888: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   891: aload 8
    //   893: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: ldc_w 480
    //   899: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   908: new 482	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   911: dup
    //   912: invokespecial 483	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   915: astore 10
    //   917: aload 10
    //   919: new 246	java/lang/StringBuilder
    //   922: dup
    //   923: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   926: getstatic 470	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   929: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: aload 8
    //   934: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   940: putfield 486	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   943: aload 10
    //   945: ldc_w 488
    //   948: putfield 491	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   951: aload 10
    //   953: new 246	java/lang/StringBuilder
    //   956: dup
    //   957: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   960: getstatic 470	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   963: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: aload 8
    //   968: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: ldc_w 474
    //   974: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   980: putfield 494	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mAudioPath	Ljava/lang/String;
    //   983: aload 10
    //   985: iconst_0
    //   986: putfield 497	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mHasAudioTrack	Z
    //   989: aload 10
    //   991: iconst_1
    //   992: putfield 500	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mSampleRate	I
    //   995: aload 9
    //   997: aload_1
    //   998: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1001: aload 10
    //   1003: invokevirtual 503	com/tencent/biz/qqstory/takevideo/slideshow/TransitionHandler:a	(Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V
    //   1006: return
    //   1007: aload_0
    //   1008: new 246	java/lang/StringBuilder
    //   1011: dup
    //   1012: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1015: getstatic 415	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1018: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: aload 8
    //   1023: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1029: putfield 504	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1032: aload_0
    //   1033: new 246	java/lang/StringBuilder
    //   1036: dup
    //   1037: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1040: aload_0
    //   1041: getfield 504	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1044: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: ldc_w 506
    //   1050: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   1056: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1059: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1062: putfield 508	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1065: aload_0
    //   1066: getfield 508	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1069: invokestatic 513	com/tencent/biz/qqstory/utils/FileUtils:g	(Ljava/lang/String;)Z
    //   1072: pop
    //   1073: aload_1
    //   1074: getfield 515	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_Long	J
    //   1077: l2i
    //   1078: istore_2
    //   1079: aload_0
    //   1080: lconst_0
    //   1081: putfield 24	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_c_of_type_Long	J
    //   1084: aload_1
    //   1085: ldc2_w 516
    //   1088: aload_1
    //   1089: getfield 515	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_Long	J
    //   1092: lmul
    //   1093: putfield 515	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_Long	J
    //   1096: aload_1
    //   1097: aload_1
    //   1098: getfield 515	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_Long	J
    //   1101: ldc2_w 518
    //   1104: ldiv
    //   1105: putfield 515	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_Long	J
    //   1108: aload_0
    //   1109: aload_1
    //   1110: invokevirtual 338	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)Z
    //   1113: ifeq +53 -> 1166
    //   1116: aload_0
    //   1117: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1120: ifnull +15 -> 1135
    //   1123: aload_0
    //   1124: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1127: invokevirtual 411	android/graphics/Bitmap:recycle	()V
    //   1130: aload_0
    //   1131: aconst_null
    //   1132: putfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1135: ldc_w 340
    //   1138: iconst_1
    //   1139: anewarray 232	java/lang/String
    //   1142: dup
    //   1143: iconst_0
    //   1144: ldc_w 342
    //   1147: aastore
    //   1148: invokestatic 347	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1151: aload_0
    //   1152: bipush 9
    //   1154: aload_1
    //   1155: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1158: aconst_null
    //   1159: aconst_null
    //   1160: aconst_null
    //   1161: aload_1
    //   1162: invokevirtual 352	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)V
    //   1165: return
    //   1166: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   1169: lstore 5
    //   1171: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1174: ifeq +51 -> 1225
    //   1177: ldc 244
    //   1179: iconst_2
    //   1180: new 246	java/lang/StringBuilder
    //   1183: dup
    //   1184: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1187: ldc_w 521
    //   1190: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: aload_1
    //   1194: getfield 386	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Long	J
    //   1197: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1200: ldc_w 523
    //   1203: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: lload 5
    //   1208: lload_3
    //   1209: lsub
    //   1210: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1213: ldc_w 390
    //   1216: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1222: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1225: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   1228: lstore_3
    //   1229: new 246	java/lang/StringBuilder
    //   1232: dup
    //   1233: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1236: getstatic 415	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1239: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1242: aload 8
    //   1244: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: ldc_w 474
    //   1250: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1253: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1256: astore 8
    //   1258: aload 8
    //   1260: invokestatic 525	com/tencent/biz/qqstory/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   1263: ifeq +9 -> 1272
    //   1266: aload 8
    //   1268: invokestatic 528	com/tencent/biz/qqstory/utils/FileUtils:f	(Ljava/lang/String;)Z
    //   1271: pop
    //   1272: aload 8
    //   1274: iload_2
    //   1275: bipush 42
    //   1277: iadd
    //   1278: bipush 15
    //   1280: iadd
    //   1281: invokestatic 532	com/tencent/biz/qqstory/utils/ExtractPCMFromFile:a	(Ljava/lang/String;I)V
    //   1284: aload 8
    //   1286: invokestatic 525	com/tencent/biz/qqstory/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   1289: ifne +80 -> 1369
    //   1292: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1295: ifeq +43 -> 1338
    //   1298: ldc 244
    //   1300: iconst_2
    //   1301: new 246	java/lang/StringBuilder
    //   1304: dup
    //   1305: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1308: ldc_w 534
    //   1311: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: aload_1
    //   1315: getfield 386	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Long	J
    //   1318: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1321: ldc_w 536
    //   1324: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1327: aload 8
    //   1329: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1332: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1335: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1338: ldc_w 340
    //   1341: iconst_1
    //   1342: anewarray 232	java/lang/String
    //   1345: dup
    //   1346: iconst_0
    //   1347: ldc_w 538
    //   1350: aastore
    //   1351: invokestatic 347	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1354: aload_0
    //   1355: bipush 8
    //   1357: aload_1
    //   1358: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1361: aconst_null
    //   1362: aconst_null
    //   1363: aconst_null
    //   1364: aload_1
    //   1365: invokevirtual 352	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)V
    //   1368: return
    //   1369: aload_0
    //   1370: aload 8
    //   1372: putfield 539	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1375: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   1378: lstore 5
    //   1380: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1383: ifeq +51 -> 1434
    //   1386: ldc 244
    //   1388: iconst_2
    //   1389: new 246	java/lang/StringBuilder
    //   1392: dup
    //   1393: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1396: ldc_w 541
    //   1399: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1402: aload_1
    //   1403: getfield 386	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Long	J
    //   1406: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1409: ldc_w 543
    //   1412: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: lload 5
    //   1417: lload_3
    //   1418: lsub
    //   1419: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1422: ldc_w 390
    //   1425: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1428: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1431: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1434: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   1437: lstore_3
    //   1438: aload_0
    //   1439: new 545	com/tencent/mobileqq/richmedia/mediacodec/recorder/HWVideoRecorder
    //   1442: dup
    //   1443: invokespecial 546	com/tencent/mobileqq/richmedia/mediacodec/recorder/HWVideoRecorder:<init>	()V
    //   1446: putfield 549	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder	Lcom/tencent/mobileqq/richmedia/mediacodec/recorder/HWVideoRecorder;
    //   1449: new 125	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig
    //   1452: dup
    //   1453: aload_0
    //   1454: getfield 508	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1457: aload_1
    //   1458: getfield 369	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_Int	I
    //   1461: aload_1
    //   1462: getfield 370	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Int	I
    //   1465: invokestatic 132	com/tencent/mobileqq/richmedia/capture/util/SVParamManager:a	()Lcom/tencent/mobileqq/richmedia/capture/util/SVParamManager;
    //   1468: iconst_1
    //   1469: invokevirtual 134	com/tencent/mobileqq/richmedia/capture/util/SVParamManager:a	(I)I
    //   1472: sipush 1000
    //   1475: imul
    //   1476: iconst_1
    //   1477: iconst_0
    //   1478: iconst_0
    //   1479: invokespecial 137	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:<init>	(Ljava/lang/String;IIIIZI)V
    //   1482: astore 8
    //   1484: aload 8
    //   1486: invokestatic 555	android/opengl/EGL14:eglGetCurrentContext	()Landroid/opengl/EGLContext;
    //   1489: invokevirtual 558	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:a	(Landroid/opengl/EGLContext;)V
    //   1492: aload_0
    //   1493: getfield 549	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder	Lcom/tencent/mobileqq/richmedia/mediacodec/recorder/HWVideoRecorder;
    //   1496: aload 8
    //   1498: new 560	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo$1
    //   1501: dup
    //   1502: aload_0
    //   1503: aload_1
    //   1504: invokespecial 563	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo$1:<init>	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext;)V
    //   1507: invokevirtual 566	com/tencent/mobileqq/richmedia/mediacodec/recorder/HWVideoRecorder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;Lcom/tencent/mobileqq/richmedia/mediacodec/recorder/HWEncodeListener;)V
    //   1510: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   1513: lstore 5
    //   1515: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1518: ifeq +51 -> 1569
    //   1521: ldc 244
    //   1523: iconst_2
    //   1524: new 246	java/lang/StringBuilder
    //   1527: dup
    //   1528: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1531: ldc_w 568
    //   1534: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: aload_1
    //   1538: getfield 386	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Long	J
    //   1541: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1544: ldc_w 570
    //   1547: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: lload 5
    //   1552: lload_3
    //   1553: lsub
    //   1554: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1557: ldc_w 390
    //   1560: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1566: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1569: aload_0
    //   1570: monitorenter
    //   1571: aload_0
    //   1572: invokevirtual 575	java/lang/Object:wait	()V
    //   1575: aload_0
    //   1576: monitorexit
    //   1577: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1580: ifeq -1507 -> 73
    //   1583: ldc 244
    //   1585: iconst_2
    //   1586: new 246	java/lang/StringBuilder
    //   1589: dup
    //   1590: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   1593: ldc_w 577
    //   1596: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1599: aload_1
    //   1600: getfield 386	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Long	J
    //   1603: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1606: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1609: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1612: return
    //   1613: astore 8
    //   1615: aload_0
    //   1616: monitorexit
    //   1617: aload 8
    //   1619: athrow
    //   1620: astore 8
    //   1622: aload 8
    //   1624: invokevirtual 578	java/lang/InterruptedException:printStackTrace	()V
    //   1627: goto -50 -> 1577
    //   1630: astore 8
    //   1632: goto -1499 -> 133
    //   1635: astore 8
    //   1637: goto -1494 -> 143
    //   1640: astore 9
    //   1642: goto -1300 -> 342
    //   1645: astore 9
    //   1647: goto -1269 -> 378
    //   1650: astore 9
    //   1652: goto -1264 -> 388
    //   1655: astore 8
    //   1657: aconst_null
    //   1658: astore 9
    //   1660: goto -1292 -> 368
    //   1663: astore 8
    //   1665: goto -1297 -> 368
    //   1668: astore 11
    //   1670: aload 8
    //   1672: astore 10
    //   1674: aload 11
    //   1676: astore 8
    //   1678: goto -1310 -> 368
    //   1681: astore 11
    //   1683: aconst_null
    //   1684: astore 9
    //   1686: aload 10
    //   1688: astore 8
    //   1690: aload 11
    //   1692: astore 10
    //   1694: goto -1367 -> 327
    //   1697: astore 11
    //   1699: aload 10
    //   1701: astore 8
    //   1703: aload 11
    //   1705: astore 10
    //   1707: goto -1380 -> 327
    //   1710: goto -959 -> 751
    //   1713: aconst_null
    //   1714: astore 8
    //   1716: goto -965 -> 751
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1719	0	this	ImageToVideo
    //   0	1719	1	paramConvertContext	SlideShowProcessor.ConvertContext
    //   443	835	2	i	int
    //   77	1476	3	l1	long
    //   172	1379	5	l2	long
    //   616	25	7	bool	boolean
    //   270	1	8	localException1	java.lang.Exception
    //   322	26	8	localObject1	Object
    //   355	1	8	localException2	java.lang.Exception
    //   360	29	8	localObject2	Object
    //   391	1	8	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   462	1035	8	localObject3	Object
    //   1613	5	8	localObject4	Object
    //   1620	3	8	localInterruptedException	java.lang.InterruptedException
    //   1630	1	8	localException3	java.lang.Exception
    //   1635	1	8	localException4	java.lang.Exception
    //   1655	1	8	localObject5	Object
    //   1663	8	8	localObject6	Object
    //   1676	39	8	localObject7	Object
    //   103	893	9	localObject8	Object
    //   1640	1	9	localException5	java.lang.Exception
    //   1645	1	9	localException6	java.lang.Exception
    //   1650	1	9	localException7	java.lang.Exception
    //   1658	27	9	localObject9	Object
    //   89	50	10	localFileInputStream	java.io.FileInputStream
    //   319	9	10	localException8	java.lang.Exception
    //   363	1343	10	localObject10	Object
    //   1668	7	11	localObject11	Object
    //   1681	10	11	localException9	java.lang.Exception
    //   1697	7	11	localException10	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   143	169	270	java/lang/Exception
    //   169	228	270	java/lang/Exception
    //   228	269	270	java/lang/Exception
    //   388	391	270	java/lang/Exception
    //   436	444	270	java/lang/Exception
    //   455	533	270	java/lang/Exception
    //   533	560	270	java/lang/Exception
    //   560	590	270	java/lang/Exception
    //   78	91	319	java/lang/Exception
    //   347	352	355	java/lang/Exception
    //   78	91	360	finally
    //   128	133	391	java/lang/OutOfMemoryError
    //   138	143	391	java/lang/OutOfMemoryError
    //   143	169	391	java/lang/OutOfMemoryError
    //   169	228	391	java/lang/OutOfMemoryError
    //   228	269	391	java/lang/OutOfMemoryError
    //   337	342	391	java/lang/OutOfMemoryError
    //   347	352	391	java/lang/OutOfMemoryError
    //   373	378	391	java/lang/OutOfMemoryError
    //   383	388	391	java/lang/OutOfMemoryError
    //   388	391	391	java/lang/OutOfMemoryError
    //   436	444	391	java/lang/OutOfMemoryError
    //   455	533	391	java/lang/OutOfMemoryError
    //   533	560	391	java/lang/OutOfMemoryError
    //   560	590	391	java/lang/OutOfMemoryError
    //   1571	1577	1613	finally
    //   1615	1617	1613	finally
    //   1569	1571	1620	java/lang/InterruptedException
    //   1617	1620	1620	java/lang/InterruptedException
    //   128	133	1630	java/lang/Exception
    //   138	143	1635	java/lang/Exception
    //   337	342	1640	java/lang/Exception
    //   373	378	1645	java/lang/Exception
    //   383	388	1650	java/lang/Exception
    //   91	105	1655	finally
    //   105	123	1663	finally
    //   327	332	1668	finally
    //   91	105	1681	java/lang/Exception
    //   105	123	1697	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.ImageToVideo
 * JD-Core Version:    0.7.0.1
 */