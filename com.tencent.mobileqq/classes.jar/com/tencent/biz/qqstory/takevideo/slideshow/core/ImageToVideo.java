package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video;
import com.tencent.mobileqq.richmedia.capture.util.SVParamManager;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQImage2FrameFilter;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
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
    if ((paramBitmap != null) && (paramInt2 != 0) && (paramInt1 != 0)) {}
    label177:
    label183:
    while (paramBitmap != null)
    {
      try
      {
        int i = GlUtil.createTexture(3553, paramBitmap);
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
        paramInt1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.drawFrame(i);
        if (i <= 0) {
          break label183;
        }
        GlUtil.deleteTexture(i);
        return paramInt1;
      }
      catch (IllegalStateException paramBitmap)
      {
        break label177;
      }
      paramInt1 = GlUtil.createTexture(3553, paramBitmap);
      return paramInt1;
      return -1;
      return paramInt1;
    }
    return 0;
  }
  
  /* Error */
  private int a(String paramString)
  {
    // Byte code:
    //   0: new 96	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 97	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_1
    //   10: invokevirtual 101	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   13: aload_3
    //   14: bipush 9
    //   16: invokevirtual 105	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   19: invokestatic 110	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   22: istore_2
    //   23: aload_3
    //   24: invokevirtual 113	android/media/MediaMetadataRetriever:release	()V
    //   27: iload_2
    //   28: ireturn
    //   29: astore_1
    //   30: goto +9 -> 39
    //   33: goto +18 -> 51
    //   36: astore_1
    //   37: aconst_null
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull +7 -> 47
    //   43: aload_3
    //   44: invokevirtual 113	android/media/MediaMetadataRetriever:release	()V
    //   47: aload_1
    //   48: athrow
    //   49: aconst_null
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +7 -> 59
    //   55: aload_3
    //   56: invokevirtual 113	android/media/MediaMetadataRetriever:release	()V
    //   59: iconst_m1
    //   60: ireturn
    //   61: astore_1
    //   62: goto -13 -> 49
    //   65: astore_1
    //   66: goto -33 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	ImageToVideo
    //   0	69	1	paramString	String
    //   22	6	2	i	int
    //   7	49	3	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   8	23	29	finally
    //   0	8	36	finally
    //   0	8	61	java/lang/Exception
    //   8	23	65	java/lang/Exception
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
  
  /* Error */
  @TargetApi(16)
  public static MediaFormat a(String paramString)
  {
    // Byte code:
    //   0: new 207	android/media/MediaExtractor
    //   3: dup
    //   4: invokespecial 208	android/media/MediaExtractor:<init>	()V
    //   7: astore 4
    //   9: invokestatic 214	android/os/SystemClock:elapsedRealtime	()J
    //   12: lstore_2
    //   13: aload 4
    //   15: aload_0
    //   16: invokevirtual 215	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   19: iconst_0
    //   20: istore_1
    //   21: iload_1
    //   22: aload 4
    //   24: invokevirtual 218	android/media/MediaExtractor:getTrackCount	()I
    //   27: if_icmpge +106 -> 133
    //   30: aload 4
    //   32: iload_1
    //   33: invokevirtual 222	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   36: astore_0
    //   37: aload_0
    //   38: ldc 224
    //   40: invokevirtual 228	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: ldc 230
    //   45: invokevirtual 236	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   48: ifeq +56 -> 104
    //   51: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +43 -> 97
    //   57: new 244	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   64: astore 5
    //   66: aload 5
    //   68: ldc 247
    //   70: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 5
    //   76: invokestatic 214	android/os/SystemClock:elapsedRealtime	()J
    //   79: lload_2
    //   80: lsub
    //   81: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: ldc_w 256
    //   88: iconst_2
    //   89: aload 5
    //   91: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: aload 4
    //   99: invokevirtual 264	android/media/MediaExtractor:release	()V
    //   102: aload_0
    //   103: areturn
    //   104: iload_1
    //   105: iconst_1
    //   106: iadd
    //   107: istore_1
    //   108: goto -87 -> 21
    //   111: astore_0
    //   112: goto +28 -> 140
    //   115: astore_0
    //   116: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +14 -> 133
    //   122: ldc_w 256
    //   125: iconst_2
    //   126: aload_0
    //   127: invokestatic 269	com/tencent/util/ThrowablesUtils:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   130: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload 4
    //   135: invokevirtual 264	android/media/MediaExtractor:release	()V
    //   138: aconst_null
    //   139: areturn
    //   140: aload 4
    //   142: invokevirtual 264	android/media/MediaExtractor:release	()V
    //   145: goto +5 -> 150
    //   148: aload_0
    //   149: athrow
    //   150: goto -2 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramString	String
    //   20	88	1	i	int
    //   12	68	2	l	long
    //   7	134	4	localMediaExtractor	android.media.MediaExtractor
    //   64	26	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   9	19	111	finally
    //   21	97	111	finally
    //   116	133	111	finally
    //   9	19	115	java/io/IOException
    //   21	97	115	java/io/IOException
  }
  
  private int b(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap != null) && (paramInt2 != 0) && (paramInt1 != 0))
    {
      Object localObject1 = Image2Video.a(paramBitmap, 0.05F, 5, false);
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
      float f1 = paramInt1;
      float f3 = f1 * 1.0F;
      float f2 = paramInt2;
      float f4 = f3 / f2;
      float f5 = paramBitmap.getWidth() * 1.0F / paramBitmap.getHeight();
      paramInt1 = paramBitmap.getWidth();
      paramInt2 = paramBitmap.getHeight();
      localObject1 = new Matrix();
      ((Matrix)localObject1).postTranslate(paramInt1 * -0.5F, paramInt2 * -0.5F);
      Object localObject2;
      if (f5 > f4)
      {
        ((Matrix)localObject1).postScale(1.0F, f3 / paramBitmap.getWidth() * paramBitmap.getHeight() / f2);
        f3 = f1 / f5;
        localObject2 = new RectF(0.0F, (f2 - f3) * 0.5F, f1, (f3 + f2) * 0.5F);
        localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramInt1, paramInt2), (RectF)localObject2, null);
      }
      else
      {
        ((Matrix)localObject1).postScale(f2 * 1.0F / paramBitmap.getHeight() * paramBitmap.getWidth() / f1, 1.0F);
        localObject2 = new Rect(0, 0, paramInt1, paramInt2);
        f3 = f5 * f2;
        localCanvas.drawBitmap(paramBitmap, (Rect)localObject2, new RectF((f1 - f3) * 0.5F, 0.0F, (f3 + f1) * 0.5F, f2), null);
      }
      ((Matrix)localObject1).postTranslate(f1 * 0.5F, f2 * 0.5F);
      return GlUtil.createTexture(3553, localBitmap);
    }
    if (paramBitmap == null) {
      return 0;
    }
    return GlUtil.createTexture(3553, paramBitmap);
  }
  
  /* Error */
  public void a(SlideShowProcessor.ConvertContext paramConvertContext)
  {
    // Byte code:
    //   0: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +43 -> 46
    //   6: new 244	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   13: astore 8
    //   15: aload 8
    //   17: ldc_w 328
    //   20: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 8
    //   26: aload_1
    //   27: getfield 332	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:d	Z
    //   30: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: ldc_w 256
    //   37: iconst_2
    //   38: aload 8
    //   40: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 338	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)Z
    //   51: ifeq +34 -> 85
    //   54: ldc_w 340
    //   57: iconst_1
    //   58: anewarray 232	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: ldc_w 342
    //   66: aastore
    //   67: invokestatic 347	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   70: aload_0
    //   71: bipush 9
    //   73: aload_1
    //   74: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   77: aconst_null
    //   78: aconst_null
    //   79: aconst_null
    //   80: aload_1
    //   81: invokevirtual 352	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)V
    //   84: return
    //   85: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   88: lstore_3
    //   89: new 359	java/io/FileInputStream
    //   92: dup
    //   93: aload_1
    //   94: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   97: invokespecial 361	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   100: astore 8
    //   102: new 363	java/io/BufferedInputStream
    //   105: dup
    //   106: aload 8
    //   108: ldc_w 364
    //   111: invokespecial 367	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   114: astore 9
    //   116: aload 8
    //   118: astore 10
    //   120: aload 9
    //   122: astore 12
    //   124: aload_0
    //   125: aload 9
    //   127: aconst_null
    //   128: aload_1
    //   129: getfield 369	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_Int	I
    //   132: aload_1
    //   133: getfield 370	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Int	I
    //   136: invokestatic 375	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/io/InputStream;Landroid/graphics/Rect;II)Landroid/graphics/Bitmap;
    //   139: putfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   142: aload 9
    //   144: invokevirtual 378	java/io/BufferedInputStream:close	()V
    //   147: aload 8
    //   149: invokevirtual 379	java/io/FileInputStream:close	()V
    //   152: goto +79 -> 231
    //   155: astore 11
    //   157: goto +40 -> 197
    //   160: astore 9
    //   162: aconst_null
    //   163: astore 12
    //   165: goto +374 -> 539
    //   168: astore 11
    //   170: aconst_null
    //   171: astore 9
    //   173: goto +24 -> 197
    //   176: astore 9
    //   178: aconst_null
    //   179: astore 8
    //   181: aload 8
    //   183: astore 12
    //   185: goto +354 -> 539
    //   188: astore 11
    //   190: aconst_null
    //   191: astore 8
    //   193: aload 8
    //   195: astore 9
    //   197: aload 8
    //   199: astore 10
    //   201: aload 9
    //   203: astore 12
    //   205: aload 11
    //   207: invokevirtual 382	java/lang/Exception:printStackTrace	()V
    //   210: aload 9
    //   212: ifnull +11 -> 223
    //   215: aload 9
    //   217: invokevirtual 378	java/io/BufferedInputStream:close	()V
    //   220: goto +3 -> 223
    //   223: aload 8
    //   225: ifnull +6 -> 231
    //   228: goto -81 -> 147
    //   231: aload_0
    //   232: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   235: ifnonnull +22 -> 257
    //   238: aload_0
    //   239: aload_1
    //   240: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   243: aload_1
    //   244: getfield 369	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_Int	I
    //   247: aload_1
    //   248: getfield 370	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Int	I
    //   251: invokestatic 385	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   254: putfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   257: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   260: lstore 5
    //   262: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq +71 -> 336
    //   268: new 244	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   275: astore 8
    //   277: aload 8
    //   279: ldc_w 387
    //   282: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 8
    //   288: aload_1
    //   289: getfield 389	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Long	J
    //   292: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 8
    //   298: ldc_w 391
    //   301: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 8
    //   307: lload 5
    //   309: lload_3
    //   310: lsub
    //   311: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 8
    //   317: ldc_w 393
    //   320: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: ldc_w 256
    //   327: iconst_2
    //   328: aload 8
    //   330: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: aload_0
    //   337: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   340: ifnonnull +38 -> 378
    //   343: aload_1
    //   344: iconst_0
    //   345: putfield 332	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:d	Z
    //   348: ldc_w 340
    //   351: iconst_1
    //   352: anewarray 232	java/lang/String
    //   355: dup
    //   356: iconst_0
    //   357: ldc_w 395
    //   360: aastore
    //   361: invokestatic 347	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   364: aload_0
    //   365: iconst_5
    //   366: aload_1
    //   367: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   370: aconst_null
    //   371: aconst_null
    //   372: aconst_null
    //   373: aload_1
    //   374: invokevirtual 352	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)V
    //   377: return
    //   378: aload_1
    //   379: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   382: invokestatic 399	com/tencent/mobileqq/utils/ImageUtil:c	(Ljava/lang/String;)I
    //   385: istore_2
    //   386: iload_2
    //   387: ifeq +88 -> 475
    //   390: iload_2
    //   391: bipush 90
    //   393: irem
    //   394: ifne +81 -> 475
    //   397: new 297	android/graphics/Matrix
    //   400: dup
    //   401: invokespecial 298	android/graphics/Matrix:<init>	()V
    //   404: astore 8
    //   406: aload 8
    //   408: iload_2
    //   409: i2f
    //   410: aload_0
    //   411: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   414: invokevirtual 71	android/graphics/Bitmap:getWidth	()I
    //   417: i2f
    //   418: fconst_2
    //   419: fdiv
    //   420: aload_0
    //   421: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   424: invokevirtual 74	android/graphics/Bitmap:getHeight	()I
    //   427: i2f
    //   428: fconst_2
    //   429: fdiv
    //   430: invokevirtual 403	android/graphics/Matrix:postRotate	(FFF)Z
    //   433: pop
    //   434: aload_0
    //   435: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   438: iconst_0
    //   439: iconst_0
    //   440: aload_0
    //   441: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   444: invokevirtual 71	android/graphics/Bitmap:getWidth	()I
    //   447: aload_0
    //   448: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   451: invokevirtual 74	android/graphics/Bitmap:getHeight	()I
    //   454: aload 8
    //   456: iconst_1
    //   457: invokestatic 406	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   460: astore 8
    //   462: aload_0
    //   463: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   466: invokevirtual 409	android/graphics/Bitmap:recycle	()V
    //   469: aload_0
    //   470: aload 8
    //   472: putfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   475: aload_0
    //   476: aload_1
    //   477: invokevirtual 338	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)Z
    //   480: ifeq +147 -> 627
    //   483: aload_0
    //   484: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   487: ifnull +15 -> 502
    //   490: aload_0
    //   491: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   494: invokevirtual 409	android/graphics/Bitmap:recycle	()V
    //   497: aload_0
    //   498: aconst_null
    //   499: putfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   502: ldc_w 340
    //   505: iconst_1
    //   506: anewarray 232	java/lang/String
    //   509: dup
    //   510: iconst_0
    //   511: ldc_w 342
    //   514: aastore
    //   515: invokestatic 347	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   518: aload_0
    //   519: bipush 9
    //   521: aload_1
    //   522: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   525: aconst_null
    //   526: aconst_null
    //   527: aconst_null
    //   528: aload_1
    //   529: invokevirtual 352	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)V
    //   532: return
    //   533: astore 9
    //   535: aload 10
    //   537: astore 8
    //   539: aload 12
    //   541: ifnull +14 -> 555
    //   544: aload 12
    //   546: invokevirtual 378	java/io/BufferedInputStream:close	()V
    //   549: goto +6 -> 555
    //   552: goto +16 -> 568
    //   555: aload 8
    //   557: ifnull +8 -> 565
    //   560: aload 8
    //   562: invokevirtual 379	java/io/FileInputStream:close	()V
    //   565: aload 9
    //   567: athrow
    //   568: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   571: ifeq +43 -> 614
    //   574: new 244	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   581: astore 8
    //   583: aload 8
    //   585: ldc_w 411
    //   588: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload 8
    //   594: aload_1
    //   595: getfield 389	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Long	J
    //   598: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: ldc_w 256
    //   605: iconst_2
    //   606: aload 8
    //   608: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   614: aload_0
    //   615: aconst_null
    //   616: putfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   619: goto +8 -> 627
    //   622: aload_0
    //   623: aconst_null
    //   624: putfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   627: aload_0
    //   628: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   631: ifnonnull +38 -> 669
    //   634: aload_1
    //   635: iconst_0
    //   636: putfield 332	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:d	Z
    //   639: ldc_w 340
    //   642: iconst_1
    //   643: anewarray 232	java/lang/String
    //   646: dup
    //   647: iconst_0
    //   648: ldc_w 395
    //   651: aastore
    //   652: invokestatic 347	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   655: aload_0
    //   656: iconst_5
    //   657: aload_1
    //   658: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   661: aconst_null
    //   662: aconst_null
    //   663: aconst_null
    //   664: aload_1
    //   665: invokevirtual 352	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)V
    //   668: return
    //   669: new 413	java/io/File
    //   672: dup
    //   673: getstatic 415	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   676: invokespecial 416	java/io/File:<init>	(Ljava/lang/String;)V
    //   679: astore 8
    //   681: aload 8
    //   683: invokevirtual 419	java/io/File:exists	()Z
    //   686: ifne +54 -> 740
    //   689: aload 8
    //   691: invokevirtual 422	java/io/File:mkdirs	()Z
    //   694: istore 7
    //   696: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   699: ifeq +41 -> 740
    //   702: new 244	java/lang/StringBuilder
    //   705: dup
    //   706: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   709: astore 8
    //   711: aload 8
    //   713: ldc_w 424
    //   716: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: pop
    //   720: aload 8
    //   722: iload 7
    //   724: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: ldc_w 256
    //   731: iconst_2
    //   732: aload 8
    //   734: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   740: new 413	java/io/File
    //   743: dup
    //   744: aload_1
    //   745: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   748: invokespecial 416	java/io/File:<init>	(Ljava/lang/String;)V
    //   751: astore 10
    //   753: aload 10
    //   755: invokevirtual 427	java/io/File:getName	()Ljava/lang/String;
    //   758: astore 9
    //   760: aload 9
    //   762: astore 8
    //   764: aload 9
    //   766: invokestatic 433	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   769: ifne +93 -> 862
    //   772: aload 9
    //   774: ldc_w 435
    //   777: ldc_w 437
    //   780: invokevirtual 441	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   783: astore 8
    //   785: new 244	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   792: astore 9
    //   794: aload 9
    //   796: aload 8
    //   798: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: pop
    //   802: aload 9
    //   804: ldc_w 437
    //   807: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: pop
    //   811: aload 9
    //   813: aload 10
    //   815: invokevirtual 444	java/io/File:length	()J
    //   818: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   821: pop
    //   822: aload 9
    //   824: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: astore 8
    //   829: new 244	java/lang/StringBuilder
    //   832: dup
    //   833: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   836: astore 9
    //   838: aload 9
    //   840: aload 8
    //   842: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: pop
    //   846: aload 9
    //   848: ldc_w 446
    //   851: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: pop
    //   855: aload 9
    //   857: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   860: astore 8
    //   862: invokestatic 451	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/common/app/AppInterface;
    //   865: getstatic 454	com/tencent/mobileqq/app/PeakAppInterface:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   868: invokevirtual 460	com/tencent/common/app/AppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   871: checkcast 462	com/tencent/biz/qqstory/takevideo/slideshow/TransitionHandler
    //   874: astore 9
    //   876: aload 9
    //   878: aload_1
    //   879: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   882: invokevirtual 465	com/tencent/biz/qqstory/takevideo/slideshow/TransitionHandler:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   885: ifnull +44 -> 929
    //   888: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   891: ifeq +37 -> 928
    //   894: new 244	java/lang/StringBuilder
    //   897: dup
    //   898: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   901: astore_1
    //   902: aload_1
    //   903: aload 8
    //   905: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: pop
    //   909: aload_1
    //   910: ldc_w 467
    //   913: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: pop
    //   917: ldc_w 256
    //   920: iconst_2
    //   921: aload_1
    //   922: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   925: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   928: return
    //   929: new 244	java/lang/StringBuilder
    //   932: dup
    //   933: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   936: astore 10
    //   938: aload 10
    //   940: getstatic 470	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   943: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: pop
    //   947: aload 10
    //   949: aload 8
    //   951: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: pop
    //   955: aload_0
    //   956: aload 10
    //   958: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   961: invokespecial 472	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(Ljava/lang/String;)I
    //   964: sipush 1000
    //   967: if_icmplt +215 -> 1182
    //   970: new 244	java/lang/StringBuilder
    //   973: dup
    //   974: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   977: astore 10
    //   979: aload 10
    //   981: getstatic 470	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   984: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: aload 10
    //   990: aload 8
    //   992: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: pop
    //   996: aload 10
    //   998: ldc_w 474
    //   1001: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: pop
    //   1005: aload 10
    //   1007: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1010: invokestatic 479	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   1013: ifeq +169 -> 1182
    //   1016: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1019: ifeq +41 -> 1060
    //   1022: new 244	java/lang/StringBuilder
    //   1025: dup
    //   1026: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   1029: astore 10
    //   1031: aload 10
    //   1033: aload 8
    //   1035: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: pop
    //   1039: aload 10
    //   1041: ldc_w 481
    //   1044: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: pop
    //   1048: ldc_w 256
    //   1051: iconst_2
    //   1052: aload 10
    //   1054: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1057: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1060: new 483	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   1063: dup
    //   1064: invokespecial 484	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   1067: astore 10
    //   1069: new 244	java/lang/StringBuilder
    //   1072: dup
    //   1073: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   1076: astore 11
    //   1078: aload 11
    //   1080: getstatic 470	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1083: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: aload 11
    //   1089: aload 8
    //   1091: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1094: pop
    //   1095: aload 10
    //   1097: aload 11
    //   1099: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: putfield 487	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   1105: aload 10
    //   1107: ldc_w 489
    //   1110: putfield 492	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   1113: new 244	java/lang/StringBuilder
    //   1116: dup
    //   1117: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   1120: astore 11
    //   1122: aload 11
    //   1124: getstatic 470	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1127: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1130: pop
    //   1131: aload 11
    //   1133: aload 8
    //   1135: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: pop
    //   1139: aload 11
    //   1141: ldc_w 474
    //   1144: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: pop
    //   1148: aload 10
    //   1150: aload 11
    //   1152: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1155: putfield 495	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mAudioPath	Ljava/lang/String;
    //   1158: aload 10
    //   1160: iconst_0
    //   1161: putfield 498	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mHasAudioTrack	Z
    //   1164: aload 10
    //   1166: iconst_1
    //   1167: putfield 501	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mSampleRate	I
    //   1170: aload 9
    //   1172: aload_1
    //   1173: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1176: aload 10
    //   1178: invokevirtual 504	com/tencent/biz/qqstory/takevideo/slideshow/TransitionHandler:a	(Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V
    //   1181: return
    //   1182: new 244	java/lang/StringBuilder
    //   1185: dup
    //   1186: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   1189: astore 9
    //   1191: aload 9
    //   1193: getstatic 415	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1196: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: pop
    //   1200: aload 9
    //   1202: aload 8
    //   1204: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: pop
    //   1208: aload_0
    //   1209: aload 9
    //   1211: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1214: putfield 505	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1217: new 244	java/lang/StringBuilder
    //   1220: dup
    //   1221: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   1224: astore 9
    //   1226: aload 9
    //   1228: aload_0
    //   1229: getfield 505	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1232: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1235: pop
    //   1236: aload 9
    //   1238: ldc_w 507
    //   1241: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1244: pop
    //   1245: aload 9
    //   1247: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   1250: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1253: pop
    //   1254: aload_0
    //   1255: aload 9
    //   1257: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1260: putfield 509	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1263: aload_0
    //   1264: getfield 509	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1267: invokestatic 514	com/tencent/biz/qqstory/utils/FileUtils:g	(Ljava/lang/String;)Z
    //   1270: pop
    //   1271: aload_1
    //   1272: getfield 516	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_Long	J
    //   1275: l2i
    //   1276: istore_2
    //   1277: aload_0
    //   1278: lconst_0
    //   1279: putfield 24	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_c_of_type_Long	J
    //   1282: aload_1
    //   1283: aload_1
    //   1284: getfield 516	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_Long	J
    //   1287: ldc2_w 517
    //   1290: lmul
    //   1291: putfield 516	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_Long	J
    //   1294: aload_1
    //   1295: aload_1
    //   1296: getfield 516	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_Long	J
    //   1299: ldc2_w 519
    //   1302: ldiv
    //   1303: putfield 516	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_Long	J
    //   1306: aload_0
    //   1307: aload_1
    //   1308: invokevirtual 338	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)Z
    //   1311: ifeq +55 -> 1366
    //   1314: aload_0
    //   1315: getfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1318: astore 8
    //   1320: aload 8
    //   1322: ifnull +13 -> 1335
    //   1325: aload 8
    //   1327: invokevirtual 409	android/graphics/Bitmap:recycle	()V
    //   1330: aload_0
    //   1331: aconst_null
    //   1332: putfield 118	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1335: ldc_w 340
    //   1338: iconst_1
    //   1339: anewarray 232	java/lang/String
    //   1342: dup
    //   1343: iconst_0
    //   1344: ldc_w 342
    //   1347: aastore
    //   1348: invokestatic 347	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1351: aload_0
    //   1352: bipush 9
    //   1354: aload_1
    //   1355: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1358: aconst_null
    //   1359: aconst_null
    //   1360: aconst_null
    //   1361: aload_1
    //   1362: invokevirtual 352	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)V
    //   1365: return
    //   1366: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   1369: lstore 5
    //   1371: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1374: ifeq +71 -> 1445
    //   1377: new 244	java/lang/StringBuilder
    //   1380: dup
    //   1381: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   1384: astore 9
    //   1386: aload 9
    //   1388: ldc_w 522
    //   1391: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1394: pop
    //   1395: aload 9
    //   1397: aload_1
    //   1398: getfield 389	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Long	J
    //   1401: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1404: pop
    //   1405: aload 9
    //   1407: ldc_w 524
    //   1410: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: pop
    //   1414: aload 9
    //   1416: lload 5
    //   1418: lload_3
    //   1419: lsub
    //   1420: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1423: pop
    //   1424: aload 9
    //   1426: ldc_w 393
    //   1429: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: pop
    //   1433: ldc_w 256
    //   1436: iconst_2
    //   1437: aload 9
    //   1439: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1442: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1445: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   1448: lstore_3
    //   1449: new 244	java/lang/StringBuilder
    //   1452: dup
    //   1453: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   1456: astore 9
    //   1458: aload 9
    //   1460: getstatic 415	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1463: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: pop
    //   1467: aload 9
    //   1469: aload 8
    //   1471: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: pop
    //   1475: aload 9
    //   1477: ldc_w 474
    //   1480: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1483: pop
    //   1484: aload 9
    //   1486: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1489: astore 8
    //   1491: aload 8
    //   1493: invokestatic 526	com/tencent/biz/qqstory/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   1496: ifeq +9 -> 1505
    //   1499: aload 8
    //   1501: invokestatic 529	com/tencent/biz/qqstory/utils/FileUtils:f	(Ljava/lang/String;)Z
    //   1504: pop
    //   1505: aload 8
    //   1507: iload_2
    //   1508: bipush 42
    //   1510: iadd
    //   1511: bipush 15
    //   1513: iadd
    //   1514: invokestatic 533	com/tencent/biz/qqstory/utils/ExtractPCMFromFile:a	(Ljava/lang/String;I)V
    //   1517: aload 8
    //   1519: invokestatic 526	com/tencent/biz/qqstory/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   1522: ifne +97 -> 1619
    //   1525: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1528: ifeq +60 -> 1588
    //   1531: new 244	java/lang/StringBuilder
    //   1534: dup
    //   1535: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   1538: astore 9
    //   1540: aload 9
    //   1542: ldc_w 535
    //   1545: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1548: pop
    //   1549: aload 9
    //   1551: aload_1
    //   1552: getfield 389	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Long	J
    //   1555: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1558: pop
    //   1559: aload 9
    //   1561: ldc_w 537
    //   1564: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: pop
    //   1568: aload 9
    //   1570: aload 8
    //   1572: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1575: pop
    //   1576: ldc_w 256
    //   1579: iconst_2
    //   1580: aload 9
    //   1582: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1585: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1588: ldc_w 340
    //   1591: iconst_1
    //   1592: anewarray 232	java/lang/String
    //   1595: dup
    //   1596: iconst_0
    //   1597: ldc_w 539
    //   1600: aastore
    //   1601: invokestatic 347	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1604: aload_0
    //   1605: bipush 8
    //   1607: aload_1
    //   1608: getfield 349	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1611: aconst_null
    //   1612: aconst_null
    //   1613: aconst_null
    //   1614: aload_1
    //   1615: invokevirtual 352	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)V
    //   1618: return
    //   1619: aload_0
    //   1620: aload 8
    //   1622: putfield 540	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1625: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   1628: lstore 5
    //   1630: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1633: ifeq +71 -> 1704
    //   1636: new 244	java/lang/StringBuilder
    //   1639: dup
    //   1640: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   1643: astore 8
    //   1645: aload 8
    //   1647: ldc_w 542
    //   1650: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1653: pop
    //   1654: aload 8
    //   1656: aload_1
    //   1657: getfield 389	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Long	J
    //   1660: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1663: pop
    //   1664: aload 8
    //   1666: ldc_w 544
    //   1669: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1672: pop
    //   1673: aload 8
    //   1675: lload 5
    //   1677: lload_3
    //   1678: lsub
    //   1679: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1682: pop
    //   1683: aload 8
    //   1685: ldc_w 393
    //   1688: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1691: pop
    //   1692: ldc_w 256
    //   1695: iconst_2
    //   1696: aload 8
    //   1698: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1701: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1704: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   1707: lstore_3
    //   1708: aload_0
    //   1709: new 546	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder
    //   1712: dup
    //   1713: invokespecial 547	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder:<init>	()V
    //   1716: putfield 550	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder	Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder;
    //   1719: new 125	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig
    //   1722: dup
    //   1723: aload_0
    //   1724: getfield 509	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1727: aload_1
    //   1728: getfield 369	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_a_of_type_Int	I
    //   1731: aload_1
    //   1732: getfield 370	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Int	I
    //   1735: invokestatic 132	com/tencent/mobileqq/richmedia/capture/util/SVParamManager:a	()Lcom/tencent/mobileqq/richmedia/capture/util/SVParamManager;
    //   1738: iconst_1
    //   1739: invokevirtual 134	com/tencent/mobileqq/richmedia/capture/util/SVParamManager:a	(I)I
    //   1742: sipush 1000
    //   1745: imul
    //   1746: iconst_1
    //   1747: iconst_0
    //   1748: iconst_0
    //   1749: invokespecial 137	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig:<init>	(Ljava/lang/String;IIIIZI)V
    //   1752: astore 8
    //   1754: aload 8
    //   1756: invokestatic 556	android/opengl/EGL14:eglGetCurrentContext	()Landroid/opengl/EGLContext;
    //   1759: invokevirtual 559	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig:a	(Landroid/opengl/EGLContext;)V
    //   1762: aload_0
    //   1763: getfield 550	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder	Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder;
    //   1766: aload 8
    //   1768: new 561	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo$1
    //   1771: dup
    //   1772: aload_0
    //   1773: aload_1
    //   1774: invokespecial 564	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo$1:<init>	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext;)V
    //   1777: invokevirtual 567	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder:a	(Lcom/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig;Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWEncodeListener;)V
    //   1780: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   1783: lstore 5
    //   1785: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1788: ifeq +71 -> 1859
    //   1791: new 244	java/lang/StringBuilder
    //   1794: dup
    //   1795: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   1798: astore 8
    //   1800: aload 8
    //   1802: ldc_w 569
    //   1805: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1808: pop
    //   1809: aload 8
    //   1811: aload_1
    //   1812: getfield 389	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Long	J
    //   1815: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1818: pop
    //   1819: aload 8
    //   1821: ldc_w 571
    //   1824: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1827: pop
    //   1828: aload 8
    //   1830: lload 5
    //   1832: lload_3
    //   1833: lsub
    //   1834: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1837: pop
    //   1838: aload 8
    //   1840: ldc_w 393
    //   1843: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1846: pop
    //   1847: ldc_w 256
    //   1850: iconst_2
    //   1851: aload 8
    //   1853: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1856: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1859: aload_0
    //   1860: monitorenter
    //   1861: aload_0
    //   1862: invokevirtual 576	java/lang/Object:wait	()V
    //   1865: aload_0
    //   1866: monitorexit
    //   1867: goto +17 -> 1884
    //   1870: astore 8
    //   1872: aload_0
    //   1873: monitorexit
    //   1874: aload 8
    //   1876: athrow
    //   1877: astore 8
    //   1879: aload 8
    //   1881: invokevirtual 577	java/lang/InterruptedException:printStackTrace	()V
    //   1884: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1887: ifeq +43 -> 1930
    //   1890: new 244	java/lang/StringBuilder
    //   1893: dup
    //   1894: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   1897: astore 8
    //   1899: aload 8
    //   1901: ldc_w 579
    //   1904: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1907: pop
    //   1908: aload 8
    //   1910: aload_1
    //   1911: getfield 389	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:jdField_b_of_type_Long	J
    //   1914: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1917: pop
    //   1918: ldc_w 256
    //   1921: iconst_2
    //   1922: aload 8
    //   1924: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1927: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1930: return
    //   1931: astore 9
    //   1933: goto -1786 -> 147
    //   1936: astore 8
    //   1938: goto -1386 -> 552
    //   1941: astore 8
    //   1943: goto -1712 -> 231
    //   1946: astore 9
    //   1948: goto -1725 -> 223
    //   1951: astore 8
    //   1953: goto -1331 -> 622
    //   1956: astore 10
    //   1958: goto -1403 -> 555
    //   1961: astore 8
    //   1963: goto -1398 -> 565
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1966	0	this	ImageToVideo
    //   0	1966	1	paramConvertContext	SlideShowProcessor.ConvertContext
    //   385	1126	2	i	int
    //   88	1745	3	l1	long
    //   260	1571	5	l2	long
    //   694	29	7	bool	boolean
    //   13	1839	8	localObject1	Object
    //   1870	5	8	localObject2	Object
    //   1877	3	8	localInterruptedException	java.lang.InterruptedException
    //   1897	26	8	localStringBuilder1	java.lang.StringBuilder
    //   1936	1	8	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1941	1	8	localException1	java.lang.Exception
    //   1951	1	8	localException2	java.lang.Exception
    //   1961	1	8	localException3	java.lang.Exception
    //   114	29	9	localBufferedInputStream	java.io.BufferedInputStream
    //   160	1	9	localObject3	Object
    //   171	1	9	localObject4	Object
    //   176	1	9	localObject5	Object
    //   195	21	9	localObject6	Object
    //   533	33	9	localObject7	Object
    //   758	823	9	localObject8	Object
    //   1931	1	9	localException4	java.lang.Exception
    //   1946	1	9	localException5	java.lang.Exception
    //   118	1059	10	localObject9	Object
    //   1956	1	10	localException6	java.lang.Exception
    //   155	1	11	localException7	java.lang.Exception
    //   168	1	11	localException8	java.lang.Exception
    //   188	18	11	localException9	java.lang.Exception
    //   1076	75	11	localStringBuilder2	java.lang.StringBuilder
    //   122	423	12	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   124	142	155	java/lang/Exception
    //   102	116	160	finally
    //   102	116	168	java/lang/Exception
    //   89	102	176	finally
    //   89	102	188	java/lang/Exception
    //   124	142	533	finally
    //   205	210	533	finally
    //   1861	1867	1870	finally
    //   1872	1874	1870	finally
    //   1859	1861	1877	java/lang/InterruptedException
    //   1874	1877	1877	java/lang/InterruptedException
    //   142	147	1931	java/lang/Exception
    //   142	147	1936	java/lang/OutOfMemoryError
    //   147	152	1936	java/lang/OutOfMemoryError
    //   215	220	1936	java/lang/OutOfMemoryError
    //   231	257	1936	java/lang/OutOfMemoryError
    //   257	336	1936	java/lang/OutOfMemoryError
    //   336	377	1936	java/lang/OutOfMemoryError
    //   378	386	1936	java/lang/OutOfMemoryError
    //   397	475	1936	java/lang/OutOfMemoryError
    //   475	502	1936	java/lang/OutOfMemoryError
    //   502	532	1936	java/lang/OutOfMemoryError
    //   544	549	1936	java/lang/OutOfMemoryError
    //   560	565	1936	java/lang/OutOfMemoryError
    //   565	568	1936	java/lang/OutOfMemoryError
    //   147	152	1941	java/lang/Exception
    //   215	220	1946	java/lang/Exception
    //   231	257	1951	java/lang/Exception
    //   257	336	1951	java/lang/Exception
    //   336	377	1951	java/lang/Exception
    //   378	386	1951	java/lang/Exception
    //   397	475	1951	java/lang/Exception
    //   475	502	1951	java/lang/Exception
    //   502	532	1951	java/lang/Exception
    //   565	568	1951	java/lang/Exception
    //   544	549	1956	java/lang/Exception
    //   560	565	1961	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.ImageToVideo
 * JD-Core Version:    0.7.0.1
 */