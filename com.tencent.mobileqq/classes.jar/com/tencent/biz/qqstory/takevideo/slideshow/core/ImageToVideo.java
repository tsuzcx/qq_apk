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
  QQFilterRenderManager a = null;
  long b;
  long c;
  private int h = -1;
  private String i;
  private boolean j;
  private Bitmap k;
  private long l = 0L;
  
  public ImageToVideo(boolean paramBoolean)
  {
    this.j = paramBoolean;
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
        int m = GlUtil.createTexture(3553, paramBitmap);
        if (this.a == null) {
          this.a = new QQFilterRenderManager();
        }
        this.a.surfaceCreate(paramInt1, paramInt2, paramInt1, paramInt2);
        this.a.surfaceChange(paramInt1, paramInt2, paramInt1, paramInt2);
        this.a.pushChain(new int[] { 170 }, null);
        List localList = this.a.getQQFilters(170);
        if ((localList != null) && (localList.size() > 0) && ((localList.get(0) instanceof QQImage2FrameFilter))) {
          ((QQImage2FrameFilter)localList.get(0)).setImageSize(paramBitmap.getWidth(), paramBitmap.getHeight());
        }
        paramInt1 = this.a.drawFrame(m);
        if (m <= 0) {
          break label183;
        }
        GlUtil.deleteTexture(m);
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
  
  @TargetApi(16)
  public static MediaFormat a()
  {
    EncodeConfig localEncodeConfig = new EncodeConfig("", 720, 1280, SVParamManager.a().c(1) * 1000, 1, false, 0);
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat("video/avc", 720, 1280);
    localMediaFormat.setInteger("color-format", 2130708361);
    localMediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[] { 0, 0, 0, 1, 103, 66, -128, 31, -38, 2, -48, 40, 105, 72, 40, 48, 40, 54, -123, 9, -88 }));
    localMediaFormat.setByteBuffer("csd-1", ByteBuffer.wrap(new byte[] { 0, 0, 0, 1, 104, -50, 6, -30 }));
    localMediaFormat.setInteger("bitrate", localEncodeConfig.e);
    localMediaFormat.setInteger("frame-rate", localEncodeConfig.f);
    localMediaFormat.setInteger("i-frame-interval", localEncodeConfig.g);
    return localMediaFormat;
  }
  
  /* Error */
  @TargetApi(16)
  public static MediaFormat a(String paramString)
  {
    // Byte code:
    //   0: new 188	android/media/MediaExtractor
    //   3: dup
    //   4: invokespecial 189	android/media/MediaExtractor:<init>	()V
    //   7: astore 4
    //   9: invokestatic 195	android/os/SystemClock:elapsedRealtime	()J
    //   12: lstore_2
    //   13: aload 4
    //   15: aload_0
    //   16: invokevirtual 199	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   19: iconst_0
    //   20: istore_1
    //   21: iload_1
    //   22: aload 4
    //   24: invokevirtual 202	android/media/MediaExtractor:getTrackCount	()I
    //   27: if_icmpge +104 -> 131
    //   30: aload 4
    //   32: iload_1
    //   33: invokevirtual 206	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   36: astore_0
    //   37: aload_0
    //   38: ldc 208
    //   40: invokevirtual 212	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: ldc 214
    //   45: invokevirtual 220	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   48: ifeq +55 -> 103
    //   51: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +42 -> 96
    //   57: new 228	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   64: astore 5
    //   66: aload 5
    //   68: ldc 231
    //   70: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 5
    //   76: invokestatic 195	android/os/SystemClock:elapsedRealtime	()J
    //   79: lload_2
    //   80: lsub
    //   81: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: ldc 240
    //   87: iconst_2
    //   88: aload 5
    //   90: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: aload 4
    //   98: invokevirtual 251	android/media/MediaExtractor:release	()V
    //   101: aload_0
    //   102: areturn
    //   103: iload_1
    //   104: iconst_1
    //   105: iadd
    //   106: istore_1
    //   107: goto -86 -> 21
    //   110: astore_0
    //   111: goto +27 -> 138
    //   114: astore_0
    //   115: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +13 -> 131
    //   121: ldc 240
    //   123: iconst_2
    //   124: aload_0
    //   125: invokestatic 256	com/tencent/util/ThrowablesUtils:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   128: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload 4
    //   133: invokevirtual 251	android/media/MediaExtractor:release	()V
    //   136: aconst_null
    //   137: areturn
    //   138: aload 4
    //   140: invokevirtual 251	android/media/MediaExtractor:release	()V
    //   143: goto +5 -> 148
    //   146: aload_0
    //   147: athrow
    //   148: goto -2 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramString	String
    //   20	87	1	m	int
    //   12	68	2	l1	long
    //   7	132	4	localMediaExtractor	android.media.MediaExtractor
    //   64	25	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   9	19	110	finally
    //   21	96	110	finally
    //   115	131	110	finally
    //   9	19	114	java/io/IOException
    //   21	96	114	java/io/IOException
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
  private int b(String paramString)
  {
    // Byte code:
    //   0: new 313	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 314	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_1
    //   10: invokevirtual 315	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   13: aload_3
    //   14: bipush 9
    //   16: invokevirtual 319	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   19: invokestatic 324	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   22: istore_2
    //   23: aload_3
    //   24: invokevirtual 325	android/media/MediaMetadataRetriever:release	()V
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
    //   44: invokevirtual 325	android/media/MediaMetadataRetriever:release	()V
    //   47: aload_1
    //   48: athrow
    //   49: aconst_null
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +7 -> 59
    //   55: aload_3
    //   56: invokevirtual 325	android/media/MediaMetadataRetriever:release	()V
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
    //   22	6	2	m	int
    //   7	49	3	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   8	23	29	finally
    //   0	8	36	finally
    //   0	8	61	java/lang/Exception
    //   8	23	65	java/lang/Exception
  }
  
  /* Error */
  public void a(SlideShowProcessor.ConvertContext paramConvertContext)
  {
    // Byte code:
    //   0: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +42 -> 45
    //   6: new 228	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   13: astore 8
    //   15: aload 8
    //   17: ldc_w 335
    //   20: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 8
    //   26: aload_1
    //   27: getfield 338	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:j	Z
    //   30: invokevirtual 341	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: ldc 240
    //   36: iconst_2
    //   37: aload 8
    //   39: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_0
    //   46: aload_1
    //   47: invokevirtual 344	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)Z
    //   50: ifeq +34 -> 84
    //   53: ldc_w 346
    //   56: iconst_1
    //   57: anewarray 216	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: ldc_w 348
    //   65: aastore
    //   66: invokestatic 353	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   69: aload_0
    //   70: bipush 9
    //   72: aload_1
    //   73: getfield 355	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:a	Ljava/lang/String;
    //   76: aconst_null
    //   77: aconst_null
    //   78: aconst_null
    //   79: aload_1
    //   80: invokevirtual 358	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)V
    //   83: return
    //   84: invokestatic 363	java/lang/System:currentTimeMillis	()J
    //   87: lstore_3
    //   88: new 365	java/io/FileInputStream
    //   91: dup
    //   92: aload_1
    //   93: getfield 355	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:a	Ljava/lang/String;
    //   96: invokespecial 367	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   99: astore 8
    //   101: new 369	java/io/BufferedInputStream
    //   104: dup
    //   105: aload 8
    //   107: ldc_w 370
    //   110: invokespecial 373	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   113: astore 9
    //   115: aload 8
    //   117: astore 10
    //   119: aload 9
    //   121: astore 12
    //   123: aload_0
    //   124: aload 9
    //   126: aconst_null
    //   127: aload_1
    //   128: getfield 375	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:b	I
    //   131: aload_1
    //   132: getfield 377	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:c	I
    //   135: invokestatic 382	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/io/InputStream;Landroid/graphics/Rect;II)Landroid/graphics/Bitmap;
    //   138: putfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   141: aload 9
    //   143: invokevirtual 385	java/io/BufferedInputStream:close	()V
    //   146: aload 8
    //   148: invokevirtual 386	java/io/FileInputStream:close	()V
    //   151: goto +79 -> 230
    //   154: astore 11
    //   156: goto +40 -> 196
    //   159: astore 9
    //   161: aconst_null
    //   162: astore 12
    //   164: goto +373 -> 537
    //   167: astore 11
    //   169: aconst_null
    //   170: astore 9
    //   172: goto +24 -> 196
    //   175: astore 9
    //   177: aconst_null
    //   178: astore 8
    //   180: aload 8
    //   182: astore 12
    //   184: goto +353 -> 537
    //   187: astore 11
    //   189: aconst_null
    //   190: astore 8
    //   192: aload 8
    //   194: astore 9
    //   196: aload 8
    //   198: astore 10
    //   200: aload 9
    //   202: astore 12
    //   204: aload 11
    //   206: invokevirtual 389	java/lang/Exception:printStackTrace	()V
    //   209: aload 9
    //   211: ifnull +11 -> 222
    //   214: aload 9
    //   216: invokevirtual 385	java/io/BufferedInputStream:close	()V
    //   219: goto +3 -> 222
    //   222: aload 8
    //   224: ifnull +6 -> 230
    //   227: goto -81 -> 146
    //   230: aload_0
    //   231: getfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   234: ifnonnull +22 -> 256
    //   237: aload_0
    //   238: aload_1
    //   239: getfield 355	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:a	Ljava/lang/String;
    //   242: aload_1
    //   243: getfield 375	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:b	I
    //   246: aload_1
    //   247: getfield 377	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:c	I
    //   250: invokestatic 392	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   253: putfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   256: invokestatic 363	java/lang/System:currentTimeMillis	()J
    //   259: lstore 5
    //   261: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +70 -> 334
    //   267: new 228	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   274: astore 8
    //   276: aload 8
    //   278: ldc_w 394
    //   281: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 8
    //   287: aload_1
    //   288: getfield 396	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:k	J
    //   291: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 8
    //   297: ldc_w 398
    //   300: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload 8
    //   306: lload 5
    //   308: lload_3
    //   309: lsub
    //   310: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 8
    //   316: ldc_w 400
    //   319: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: ldc 240
    //   325: iconst_2
    //   326: aload 8
    //   328: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: aload_0
    //   335: getfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   338: ifnonnull +38 -> 376
    //   341: aload_1
    //   342: iconst_0
    //   343: putfield 338	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:j	Z
    //   346: ldc_w 346
    //   349: iconst_1
    //   350: anewarray 216	java/lang/String
    //   353: dup
    //   354: iconst_0
    //   355: ldc_w 402
    //   358: aastore
    //   359: invokestatic 353	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   362: aload_0
    //   363: iconst_5
    //   364: aload_1
    //   365: getfield 355	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:a	Ljava/lang/String;
    //   368: aconst_null
    //   369: aconst_null
    //   370: aconst_null
    //   371: aload_1
    //   372: invokevirtual 358	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)V
    //   375: return
    //   376: aload_1
    //   377: getfield 355	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:a	Ljava/lang/String;
    //   380: invokestatic 406	com/tencent/mobileqq/utils/ImageUtil:h	(Ljava/lang/String;)I
    //   383: istore_2
    //   384: iload_2
    //   385: ifeq +88 -> 473
    //   388: iload_2
    //   389: bipush 90
    //   391: irem
    //   392: ifne +81 -> 473
    //   395: new 284	android/graphics/Matrix
    //   398: dup
    //   399: invokespecial 285	android/graphics/Matrix:<init>	()V
    //   402: astore 8
    //   404: aload 8
    //   406: iload_2
    //   407: i2f
    //   408: aload_0
    //   409: getfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   412: invokevirtual 76	android/graphics/Bitmap:getWidth	()I
    //   415: i2f
    //   416: fconst_2
    //   417: fdiv
    //   418: aload_0
    //   419: getfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   422: invokevirtual 79	android/graphics/Bitmap:getHeight	()I
    //   425: i2f
    //   426: fconst_2
    //   427: fdiv
    //   428: invokevirtual 410	android/graphics/Matrix:postRotate	(FFF)Z
    //   431: pop
    //   432: aload_0
    //   433: getfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   436: iconst_0
    //   437: iconst_0
    //   438: aload_0
    //   439: getfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   442: invokevirtual 76	android/graphics/Bitmap:getWidth	()I
    //   445: aload_0
    //   446: getfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   449: invokevirtual 79	android/graphics/Bitmap:getHeight	()I
    //   452: aload 8
    //   454: iconst_1
    //   455: invokestatic 413	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   458: astore 8
    //   460: aload_0
    //   461: getfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   464: invokevirtual 416	android/graphics/Bitmap:recycle	()V
    //   467: aload_0
    //   468: aload 8
    //   470: putfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   473: aload_0
    //   474: aload_1
    //   475: invokevirtual 344	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)Z
    //   478: ifeq +146 -> 624
    //   481: aload_0
    //   482: getfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   485: ifnull +15 -> 500
    //   488: aload_0
    //   489: getfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   492: invokevirtual 416	android/graphics/Bitmap:recycle	()V
    //   495: aload_0
    //   496: aconst_null
    //   497: putfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   500: ldc_w 346
    //   503: iconst_1
    //   504: anewarray 216	java/lang/String
    //   507: dup
    //   508: iconst_0
    //   509: ldc_w 348
    //   512: aastore
    //   513: invokestatic 353	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   516: aload_0
    //   517: bipush 9
    //   519: aload_1
    //   520: getfield 355	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:a	Ljava/lang/String;
    //   523: aconst_null
    //   524: aconst_null
    //   525: aconst_null
    //   526: aload_1
    //   527: invokevirtual 358	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)V
    //   530: return
    //   531: astore 9
    //   533: aload 10
    //   535: astore 8
    //   537: aload 12
    //   539: ifnull +14 -> 553
    //   542: aload 12
    //   544: invokevirtual 385	java/io/BufferedInputStream:close	()V
    //   547: goto +6 -> 553
    //   550: goto +16 -> 566
    //   553: aload 8
    //   555: ifnull +8 -> 563
    //   558: aload 8
    //   560: invokevirtual 386	java/io/FileInputStream:close	()V
    //   563: aload 9
    //   565: athrow
    //   566: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   569: ifeq +42 -> 611
    //   572: new 228	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   579: astore 8
    //   581: aload 8
    //   583: ldc_w 418
    //   586: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload 8
    //   592: aload_1
    //   593: getfield 396	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:k	J
    //   596: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: ldc 240
    //   602: iconst_2
    //   603: aload 8
    //   605: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   611: aload_0
    //   612: aconst_null
    //   613: putfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   616: goto +8 -> 624
    //   619: aload_0
    //   620: aconst_null
    //   621: putfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   624: aload_0
    //   625: getfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   628: ifnonnull +38 -> 666
    //   631: aload_1
    //   632: iconst_0
    //   633: putfield 338	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:j	Z
    //   636: ldc_w 346
    //   639: iconst_1
    //   640: anewarray 216	java/lang/String
    //   643: dup
    //   644: iconst_0
    //   645: ldc_w 402
    //   648: aastore
    //   649: invokestatic 353	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   652: aload_0
    //   653: iconst_5
    //   654: aload_1
    //   655: getfield 355	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:a	Ljava/lang/String;
    //   658: aconst_null
    //   659: aconst_null
    //   660: aconst_null
    //   661: aload_1
    //   662: invokevirtual 358	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)V
    //   665: return
    //   666: new 420	java/io/File
    //   669: dup
    //   670: getstatic 422	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:b	Ljava/lang/String;
    //   673: invokespecial 423	java/io/File:<init>	(Ljava/lang/String;)V
    //   676: astore 8
    //   678: aload 8
    //   680: invokevirtual 426	java/io/File:exists	()Z
    //   683: ifne +53 -> 736
    //   686: aload 8
    //   688: invokevirtual 429	java/io/File:mkdirs	()Z
    //   691: istore 7
    //   693: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   696: ifeq +40 -> 736
    //   699: new 228	java/lang/StringBuilder
    //   702: dup
    //   703: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   706: astore 8
    //   708: aload 8
    //   710: ldc_w 431
    //   713: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: pop
    //   717: aload 8
    //   719: iload 7
    //   721: invokevirtual 341	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   724: pop
    //   725: ldc 240
    //   727: iconst_2
    //   728: aload 8
    //   730: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   736: new 420	java/io/File
    //   739: dup
    //   740: aload_1
    //   741: getfield 355	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:a	Ljava/lang/String;
    //   744: invokespecial 423	java/io/File:<init>	(Ljava/lang/String;)V
    //   747: astore 10
    //   749: aload 10
    //   751: invokevirtual 434	java/io/File:getName	()Ljava/lang/String;
    //   754: astore 9
    //   756: aload 9
    //   758: astore 8
    //   760: aload 9
    //   762: invokestatic 440	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   765: ifne +93 -> 858
    //   768: aload 9
    //   770: ldc_w 442
    //   773: ldc_w 444
    //   776: invokevirtual 448	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   779: astore 8
    //   781: new 228	java/lang/StringBuilder
    //   784: dup
    //   785: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   788: astore 9
    //   790: aload 9
    //   792: aload 8
    //   794: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: pop
    //   798: aload 9
    //   800: ldc_w 444
    //   803: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: pop
    //   807: aload 9
    //   809: aload 10
    //   811: invokevirtual 451	java/io/File:length	()J
    //   814: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   817: pop
    //   818: aload 9
    //   820: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   823: astore 8
    //   825: new 228	java/lang/StringBuilder
    //   828: dup
    //   829: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   832: astore 9
    //   834: aload 9
    //   836: aload 8
    //   838: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: pop
    //   842: aload 9
    //   844: ldc_w 453
    //   847: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: pop
    //   851: aload 9
    //   853: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   856: astore 8
    //   858: invokestatic 458	com/tencent/biz/qqstory/app/QQStoryContext:k	()Lcom/tencent/common/app/AppInterface;
    //   861: getstatic 462	com/tencent/mobileqq/app/PeakAppInterface:c	Ljava/lang/String;
    //   864: invokevirtual 468	com/tencent/common/app/AppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   867: checkcast 470	com/tencent/biz/qqstory/takevideo/slideshow/TransitionHandler
    //   870: astore 9
    //   872: aload 9
    //   874: aload_1
    //   875: getfield 355	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:a	Ljava/lang/String;
    //   878: invokevirtual 473	com/tencent/biz/qqstory/takevideo/slideshow/TransitionHandler:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   881: ifnull +43 -> 924
    //   884: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   887: ifeq +36 -> 923
    //   890: new 228	java/lang/StringBuilder
    //   893: dup
    //   894: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   897: astore_1
    //   898: aload_1
    //   899: aload 8
    //   901: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: pop
    //   905: aload_1
    //   906: ldc_w 475
    //   909: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: pop
    //   913: ldc 240
    //   915: iconst_2
    //   916: aload_1
    //   917: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   920: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   923: return
    //   924: new 228	java/lang/StringBuilder
    //   927: dup
    //   928: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   931: astore 10
    //   933: aload 10
    //   935: getstatic 478	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:b	Ljava/lang/String;
    //   938: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: pop
    //   942: aload 10
    //   944: aload 8
    //   946: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: pop
    //   950: aload_0
    //   951: aload 10
    //   953: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   956: invokespecial 480	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:b	(Ljava/lang/String;)I
    //   959: sipush 1000
    //   962: if_icmplt +214 -> 1176
    //   965: new 228	java/lang/StringBuilder
    //   968: dup
    //   969: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   972: astore 10
    //   974: aload 10
    //   976: getstatic 478	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:b	Ljava/lang/String;
    //   979: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: pop
    //   983: aload 10
    //   985: aload 8
    //   987: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   990: pop
    //   991: aload 10
    //   993: ldc_w 482
    //   996: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: pop
    //   1000: aload 10
    //   1002: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1005: invokestatic 487	com/tencent/mobileqq/utils/FileUtils:fileExists	(Ljava/lang/String;)Z
    //   1008: ifeq +168 -> 1176
    //   1011: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1014: ifeq +40 -> 1054
    //   1017: new 228	java/lang/StringBuilder
    //   1020: dup
    //   1021: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1024: astore 10
    //   1026: aload 10
    //   1028: aload 8
    //   1030: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: pop
    //   1034: aload 10
    //   1036: ldc_w 489
    //   1039: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: pop
    //   1043: ldc 240
    //   1045: iconst_2
    //   1046: aload 10
    //   1048: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1051: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1054: new 491	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   1057: dup
    //   1058: invokespecial 492	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   1061: astore 10
    //   1063: new 228	java/lang/StringBuilder
    //   1066: dup
    //   1067: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1070: astore 11
    //   1072: aload 11
    //   1074: getstatic 478	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:b	Ljava/lang/String;
    //   1077: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1080: pop
    //   1081: aload 11
    //   1083: aload 8
    //   1085: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: pop
    //   1089: aload 10
    //   1091: aload 11
    //   1093: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1096: putfield 495	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   1099: aload 10
    //   1101: ldc_w 497
    //   1104: putfield 500	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   1107: new 228	java/lang/StringBuilder
    //   1110: dup
    //   1111: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1114: astore 11
    //   1116: aload 11
    //   1118: getstatic 478	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:b	Ljava/lang/String;
    //   1121: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1124: pop
    //   1125: aload 11
    //   1127: aload 8
    //   1129: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: pop
    //   1133: aload 11
    //   1135: ldc_w 482
    //   1138: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: pop
    //   1142: aload 10
    //   1144: aload 11
    //   1146: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1149: putfield 503	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mAudioPath	Ljava/lang/String;
    //   1152: aload 10
    //   1154: iconst_0
    //   1155: putfield 506	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mHasAudioTrack	Z
    //   1158: aload 10
    //   1160: iconst_1
    //   1161: putfield 509	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mSampleRate	I
    //   1164: aload 9
    //   1166: aload_1
    //   1167: getfield 355	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:a	Ljava/lang/String;
    //   1170: aload 10
    //   1172: invokevirtual 512	com/tencent/biz/qqstory/takevideo/slideshow/TransitionHandler:a	(Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V
    //   1175: return
    //   1176: new 228	java/lang/StringBuilder
    //   1179: dup
    //   1180: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1183: astore 9
    //   1185: aload 9
    //   1187: getstatic 422	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:b	Ljava/lang/String;
    //   1190: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: pop
    //   1194: aload 9
    //   1196: aload 8
    //   1198: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: pop
    //   1202: aload_0
    //   1203: aload 9
    //   1205: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1208: putfield 514	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:f	Ljava/lang/String;
    //   1211: new 228	java/lang/StringBuilder
    //   1214: dup
    //   1215: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1218: astore 9
    //   1220: aload 9
    //   1222: aload_0
    //   1223: getfield 514	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:f	Ljava/lang/String;
    //   1226: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: pop
    //   1230: aload 9
    //   1232: ldc_w 516
    //   1235: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1238: pop
    //   1239: aload 9
    //   1241: invokestatic 363	java/lang/System:currentTimeMillis	()J
    //   1244: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1247: pop
    //   1248: aload_0
    //   1249: aload 9
    //   1251: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1254: putfield 518	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:i	Ljava/lang/String;
    //   1257: aload_0
    //   1258: getfield 518	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:i	Ljava/lang/String;
    //   1261: invokestatic 522	com/tencent/biz/qqstory/utils/FileUtils:k	(Ljava/lang/String;)Z
    //   1264: pop
    //   1265: aload_1
    //   1266: getfield 524	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:d	J
    //   1269: l2i
    //   1270: istore_2
    //   1271: aload_0
    //   1272: lconst_0
    //   1273: putfield 29	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:l	J
    //   1276: aload_1
    //   1277: aload_1
    //   1278: getfield 524	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:d	J
    //   1281: ldc2_w 525
    //   1284: lmul
    //   1285: putfield 524	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:d	J
    //   1288: aload_1
    //   1289: aload_1
    //   1290: getfield 524	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:d	J
    //   1293: ldc2_w 527
    //   1296: ldiv
    //   1297: putfield 524	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:d	J
    //   1300: aload_0
    //   1301: aload_1
    //   1302: invokevirtual 344	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)Z
    //   1305: ifeq +55 -> 1360
    //   1308: aload_0
    //   1309: getfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   1312: astore 8
    //   1314: aload 8
    //   1316: ifnull +13 -> 1329
    //   1319: aload 8
    //   1321: invokevirtual 416	android/graphics/Bitmap:recycle	()V
    //   1324: aload_0
    //   1325: aconst_null
    //   1326: putfield 99	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:k	Landroid/graphics/Bitmap;
    //   1329: ldc_w 346
    //   1332: iconst_1
    //   1333: anewarray 216	java/lang/String
    //   1336: dup
    //   1337: iconst_0
    //   1338: ldc_w 348
    //   1341: aastore
    //   1342: invokestatic 353	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1345: aload_0
    //   1346: bipush 9
    //   1348: aload_1
    //   1349: getfield 355	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:a	Ljava/lang/String;
    //   1352: aconst_null
    //   1353: aconst_null
    //   1354: aconst_null
    //   1355: aload_1
    //   1356: invokevirtual 358	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)V
    //   1359: return
    //   1360: invokestatic 363	java/lang/System:currentTimeMillis	()J
    //   1363: lstore 5
    //   1365: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1368: ifeq +70 -> 1438
    //   1371: new 228	java/lang/StringBuilder
    //   1374: dup
    //   1375: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1378: astore 9
    //   1380: aload 9
    //   1382: ldc_w 530
    //   1385: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: pop
    //   1389: aload 9
    //   1391: aload_1
    //   1392: getfield 396	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:k	J
    //   1395: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1398: pop
    //   1399: aload 9
    //   1401: ldc_w 532
    //   1404: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1407: pop
    //   1408: aload 9
    //   1410: lload 5
    //   1412: lload_3
    //   1413: lsub
    //   1414: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1417: pop
    //   1418: aload 9
    //   1420: ldc_w 400
    //   1423: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: pop
    //   1427: ldc 240
    //   1429: iconst_2
    //   1430: aload 9
    //   1432: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1435: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1438: invokestatic 363	java/lang/System:currentTimeMillis	()J
    //   1441: lstore_3
    //   1442: new 228	java/lang/StringBuilder
    //   1445: dup
    //   1446: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1449: astore 9
    //   1451: aload 9
    //   1453: getstatic 422	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:b	Ljava/lang/String;
    //   1456: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1459: pop
    //   1460: aload 9
    //   1462: aload 8
    //   1464: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1467: pop
    //   1468: aload 9
    //   1470: ldc_w 482
    //   1473: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1476: pop
    //   1477: aload 9
    //   1479: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1482: astore 8
    //   1484: aload 8
    //   1486: invokestatic 534	com/tencent/biz/qqstory/utils/FileUtils:i	(Ljava/lang/String;)Z
    //   1489: ifeq +9 -> 1498
    //   1492: aload 8
    //   1494: invokestatic 536	com/tencent/biz/qqstory/utils/FileUtils:j	(Ljava/lang/String;)Z
    //   1497: pop
    //   1498: aload 8
    //   1500: iload_2
    //   1501: bipush 42
    //   1503: iadd
    //   1504: bipush 15
    //   1506: iadd
    //   1507: invokestatic 540	com/tencent/biz/qqstory/utils/ExtractPCMFromFile:a	(Ljava/lang/String;I)V
    //   1510: aload 8
    //   1512: invokestatic 534	com/tencent/biz/qqstory/utils/FileUtils:i	(Ljava/lang/String;)Z
    //   1515: ifne +96 -> 1611
    //   1518: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1521: ifeq +59 -> 1580
    //   1524: new 228	java/lang/StringBuilder
    //   1527: dup
    //   1528: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1531: astore 9
    //   1533: aload 9
    //   1535: ldc_w 542
    //   1538: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1541: pop
    //   1542: aload 9
    //   1544: aload_1
    //   1545: getfield 396	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:k	J
    //   1548: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1551: pop
    //   1552: aload 9
    //   1554: ldc_w 544
    //   1557: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1560: pop
    //   1561: aload 9
    //   1563: aload 8
    //   1565: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1568: pop
    //   1569: ldc 240
    //   1571: iconst_2
    //   1572: aload 9
    //   1574: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1577: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1580: ldc_w 346
    //   1583: iconst_1
    //   1584: anewarray 216	java/lang/String
    //   1587: dup
    //   1588: iconst_0
    //   1589: ldc_w 546
    //   1592: aastore
    //   1593: invokestatic 353	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1596: aload_0
    //   1597: bipush 8
    //   1599: aload_1
    //   1600: getfield 355	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:a	Ljava/lang/String;
    //   1603: aconst_null
    //   1604: aconst_null
    //   1605: aconst_null
    //   1606: aload_1
    //   1607: invokevirtual 358	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;)V
    //   1610: return
    //   1611: aload_0
    //   1612: aload 8
    //   1614: putfield 548	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:g	Ljava/lang/String;
    //   1617: invokestatic 363	java/lang/System:currentTimeMillis	()J
    //   1620: lstore 5
    //   1622: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1625: ifeq +70 -> 1695
    //   1628: new 228	java/lang/StringBuilder
    //   1631: dup
    //   1632: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1635: astore 8
    //   1637: aload 8
    //   1639: ldc_w 550
    //   1642: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1645: pop
    //   1646: aload 8
    //   1648: aload_1
    //   1649: getfield 396	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:k	J
    //   1652: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1655: pop
    //   1656: aload 8
    //   1658: ldc_w 552
    //   1661: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1664: pop
    //   1665: aload 8
    //   1667: lload 5
    //   1669: lload_3
    //   1670: lsub
    //   1671: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1674: pop
    //   1675: aload 8
    //   1677: ldc_w 400
    //   1680: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1683: pop
    //   1684: ldc 240
    //   1686: iconst_2
    //   1687: aload 8
    //   1689: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1692: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1695: invokestatic 363	java/lang/System:currentTimeMillis	()J
    //   1698: lstore_3
    //   1699: aload_0
    //   1700: new 554	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder
    //   1703: dup
    //   1704: invokespecial 555	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder:<init>	()V
    //   1707: putfield 558	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:e	Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder;
    //   1710: new 105	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig
    //   1713: dup
    //   1714: aload_0
    //   1715: getfield 518	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:i	Ljava/lang/String;
    //   1718: aload_1
    //   1719: getfield 375	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:b	I
    //   1722: aload_1
    //   1723: getfield 377	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:c	I
    //   1726: invokestatic 112	com/tencent/mobileqq/richmedia/capture/util/SVParamManager:a	()Lcom/tencent/mobileqq/richmedia/capture/util/SVParamManager;
    //   1729: iconst_1
    //   1730: invokevirtual 114	com/tencent/mobileqq/richmedia/capture/util/SVParamManager:c	(I)I
    //   1733: sipush 1000
    //   1736: imul
    //   1737: iconst_1
    //   1738: iconst_0
    //   1739: iconst_0
    //   1740: invokespecial 117	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig:<init>	(Ljava/lang/String;IIIIZI)V
    //   1743: astore 8
    //   1745: aload 8
    //   1747: invokestatic 564	android/opengl/EGL14:eglGetCurrentContext	()Landroid/opengl/EGLContext;
    //   1750: invokevirtual 567	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig:a	(Landroid/opengl/EGLContext;)V
    //   1753: aload_0
    //   1754: getfield 558	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:e	Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder;
    //   1757: aload 8
    //   1759: new 569	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo$1
    //   1762: dup
    //   1763: aload_0
    //   1764: aload_1
    //   1765: invokespecial 572	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo$1:<init>	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext;)V
    //   1768: invokevirtual 575	com/tencent/mobileqq/videocodec/mediacodec/recorder/HWVideoRecorder:a	(Lcom/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig;Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWEncodeListener;)V
    //   1771: invokestatic 363	java/lang/System:currentTimeMillis	()J
    //   1774: lstore 5
    //   1776: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1779: ifeq +70 -> 1849
    //   1782: new 228	java/lang/StringBuilder
    //   1785: dup
    //   1786: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1789: astore 8
    //   1791: aload 8
    //   1793: ldc_w 577
    //   1796: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1799: pop
    //   1800: aload 8
    //   1802: aload_1
    //   1803: getfield 396	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:k	J
    //   1806: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1809: pop
    //   1810: aload 8
    //   1812: ldc_w 579
    //   1815: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1818: pop
    //   1819: aload 8
    //   1821: lload 5
    //   1823: lload_3
    //   1824: lsub
    //   1825: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1828: pop
    //   1829: aload 8
    //   1831: ldc_w 400
    //   1834: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1837: pop
    //   1838: ldc 240
    //   1840: iconst_2
    //   1841: aload 8
    //   1843: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1846: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1849: aload_0
    //   1850: monitorenter
    //   1851: aload_0
    //   1852: invokevirtual 584	java/lang/Object:wait	()V
    //   1855: aload_0
    //   1856: monitorexit
    //   1857: goto +17 -> 1874
    //   1860: astore 8
    //   1862: aload_0
    //   1863: monitorexit
    //   1864: aload 8
    //   1866: athrow
    //   1867: astore 8
    //   1869: aload 8
    //   1871: invokevirtual 585	java/lang/InterruptedException:printStackTrace	()V
    //   1874: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1877: ifeq +42 -> 1919
    //   1880: new 228	java/lang/StringBuilder
    //   1883: dup
    //   1884: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   1887: astore 8
    //   1889: aload 8
    //   1891: ldc_w 587
    //   1894: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1897: pop
    //   1898: aload 8
    //   1900: aload_1
    //   1901: getfield 396	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:k	J
    //   1904: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1907: pop
    //   1908: ldc 240
    //   1910: iconst_2
    //   1911: aload 8
    //   1913: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1916: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1919: return
    //   1920: astore 9
    //   1922: goto -1776 -> 146
    //   1925: astore 8
    //   1927: goto -1377 -> 550
    //   1930: astore 8
    //   1932: goto -1702 -> 230
    //   1935: astore 9
    //   1937: goto -1715 -> 222
    //   1940: astore 8
    //   1942: goto -1323 -> 619
    //   1945: astore 10
    //   1947: goto -1394 -> 553
    //   1950: astore 8
    //   1952: goto -1389 -> 563
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1955	0	this	ImageToVideo
    //   0	1955	1	paramConvertContext	SlideShowProcessor.ConvertContext
    //   383	1121	2	m	int
    //   87	1737	3	l1	long
    //   259	1563	5	l2	long
    //   691	29	7	bool	boolean
    //   13	1829	8	localObject1	Object
    //   1860	5	8	localObject2	Object
    //   1867	3	8	localInterruptedException	java.lang.InterruptedException
    //   1887	25	8	localStringBuilder1	java.lang.StringBuilder
    //   1925	1	8	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1930	1	8	localException1	java.lang.Exception
    //   1940	1	8	localException2	java.lang.Exception
    //   1950	1	8	localException3	java.lang.Exception
    //   113	29	9	localBufferedInputStream	java.io.BufferedInputStream
    //   159	1	9	localObject3	Object
    //   170	1	9	localObject4	Object
    //   175	1	9	localObject5	Object
    //   194	21	9	localObject6	Object
    //   531	33	9	localObject7	Object
    //   754	819	9	localObject8	Object
    //   1920	1	9	localException4	java.lang.Exception
    //   1935	1	9	localException5	java.lang.Exception
    //   117	1054	10	localObject9	Object
    //   1945	1	10	localException6	java.lang.Exception
    //   154	1	11	localException7	java.lang.Exception
    //   167	1	11	localException8	java.lang.Exception
    //   187	18	11	localException9	java.lang.Exception
    //   1070	75	11	localStringBuilder2	java.lang.StringBuilder
    //   121	422	12	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   123	141	154	java/lang/Exception
    //   101	115	159	finally
    //   101	115	167	java/lang/Exception
    //   88	101	175	finally
    //   88	101	187	java/lang/Exception
    //   123	141	531	finally
    //   204	209	531	finally
    //   1851	1857	1860	finally
    //   1862	1864	1860	finally
    //   1849	1851	1867	java/lang/InterruptedException
    //   1864	1867	1867	java/lang/InterruptedException
    //   141	146	1920	java/lang/Exception
    //   141	146	1925	java/lang/OutOfMemoryError
    //   146	151	1925	java/lang/OutOfMemoryError
    //   214	219	1925	java/lang/OutOfMemoryError
    //   230	256	1925	java/lang/OutOfMemoryError
    //   256	334	1925	java/lang/OutOfMemoryError
    //   334	375	1925	java/lang/OutOfMemoryError
    //   376	384	1925	java/lang/OutOfMemoryError
    //   395	473	1925	java/lang/OutOfMemoryError
    //   473	500	1925	java/lang/OutOfMemoryError
    //   500	530	1925	java/lang/OutOfMemoryError
    //   542	547	1925	java/lang/OutOfMemoryError
    //   558	563	1925	java/lang/OutOfMemoryError
    //   563	566	1925	java/lang/OutOfMemoryError
    //   146	151	1930	java/lang/Exception
    //   214	219	1935	java/lang/Exception
    //   230	256	1940	java/lang/Exception
    //   256	334	1940	java/lang/Exception
    //   334	375	1940	java/lang/Exception
    //   376	384	1940	java/lang/Exception
    //   395	473	1940	java/lang/Exception
    //   473	500	1940	java/lang/Exception
    //   500	530	1940	java/lang/Exception
    //   563	566	1940	java/lang/Exception
    //   542	547	1945	java/lang/Exception
    //   558	563	1950	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.ImageToVideo
 * JD-Core Version:    0.7.0.1
 */