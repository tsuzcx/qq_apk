package com.tencent.component.media.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.drawable.BitmapImageDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.media.image.image.BitmapImage;
import com.tencent.component.media.image.image.FeedsBitmapImage;
import com.tencent.component.media.image.image.Image;
import com.tencent.component.media.image.image.NewGifImage;
import com.tencent.component.media.image.processor.NewGifDrawableSpecifiedRegionProcessor;
import com.tencent.component.media.image.processor.ScaleProcessor;
import com.tencent.component.media.photogif.PhotoGifDrawable;
import com.tencent.component.media.photogif.PhotoGifImage;
import com.tencent.component.media.utils.BaseHandler;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.component.media.utils.RapidNetUtils;
import com.tencent.sharpP.SharpPDecoderHelper;
import com.tencent.sharpP.SharpPDecoderWrapper.SharpPFeatureWrapper;
import com.tencent.sharpP.SharpPUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import pkx;
import pla;
import plb;
import plz;
import pma;

public class DecodeImageTask
  extends plz
{
  private static int jdField_a_of_type_Int = 0;
  private static DecodeImageTask jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask;
  private static BaseHandler jdField_a_of_type_ComTencentComponentMediaUtilsBaseHandler;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static String jdField_a_of_type_JavaLangString = DecodeImageTask.class.getSimpleName();
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static ConcurrentHashMap c = new ConcurrentHashMap();
  private DecodeImageTask jdField_b_of_type_ComTencentComponentMediaImageDecodeImageTask = null;
  
  static
  {
    jdField_a_of_type_ComTencentComponentMediaUtilsBaseHandler = new BaseHandler(Looper.getMainLooper());
    jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask = null;
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  protected DecodeImageTask(ImageKey paramImageKey)
  {
    super(paramImageKey);
  }
  
  protected DecodeImageTask(plz paramplz)
  {
    super(paramplz);
  }
  
  private BitmapReference a(IDecoder paramIDecoder, FileInputStream paramFileInputStream, BitmapFactory.Options paramOptions, boolean paramBoolean)
  {
    if (paramFileInputStream == null) {
      return null;
    }
    if (paramIDecoder != null) {
      return paramIDecoder.decodeImage(paramFileInputStream, paramOptions);
    }
    ImageManagerLog.e(jdField_a_of_type_JavaLangString, "decodeImageStream wtf decoder==null");
    return null;
  }
  
  private static BitmapImage a(BitmapReference paramBitmapReference, ImageLoader.Options paramOptions)
  {
    if (paramBitmapReference == null) {
      return null;
    }
    if ((paramOptions != null) && (paramOptions.processor != null))
    {
      int i = paramBitmapReference.getWidth();
      int j = paramBitmapReference.getHeight();
      try
      {
        paramOptions = paramOptions.processor.doProcess(paramBitmapReference, true);
        if ((paramOptions != null) && (paramOptions != paramBitmapReference))
        {
          paramBitmapReference = new BitmapImage(paramOptions);
          paramBitmapReference.getMetaInfo().width = i;
          paramBitmapReference.getMetaInfo().height = j;
          return paramBitmapReference;
        }
      }
      catch (Throwable paramOptions)
      {
        for (;;)
        {
          paramOptions.printStackTrace();
          paramOptions = null;
        }
      }
    }
    return new BitmapImage(paramBitmapReference);
  }
  
  private void a(BitmapReference paramBitmapReference, ImageKey paramImageKey, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    BitmapImage localBitmapImage;
    int j;
    int k;
    int i;
    if (paramBitmapReference != null)
    {
      ImageManager.getInstance().b(paramImageKey);
      localObject = paramBitmapReference;
      if (paramBoolean) {
        localObject = BitmapUtils.processExif(paramBitmapReference, paramImageKey.filePath);
      }
      localBitmapImage = a((BitmapReference)localObject, paramImageKey.options);
      j = -1;
      k = -1;
      if (paramImageKey.options != null)
      {
        j = paramImageKey.options.clipWidth;
        k = paramImageKey.options.clipHeight;
      }
      if ((!paramImageKey.needSuperResolution) || (!ImageManagerEnv.g().enableSuperResolution()) || (paramImageKey.url == null) || (!paramImageKey.url.contains("sce="))) {
        break label846;
      }
      if ((ImageManagerEnv.g().checkShouldRunSuperResolutionBenchmark()) && (RapidNetUtils.needRerunBenchmark(paramImageKey.url))) {
        ImageManagerEnv.g().clearSuperResolutionBenchmark();
      }
      if (!ImageManagerEnv.g().isSuperResolutionEnvReady())
      {
        ImageManagerEnv.g().prepareSuperResolutionEnv();
        i = 0;
      }
    }
    for (;;)
    {
      if ((paramImageKey.options != null) && (paramImageKey.options.extraProcessor != null))
      {
        localObject = new BitmapImageDrawable(localBitmapImage, j, k);
        paramBitmapReference = (BitmapReference)localObject;
        if (RapidNetUtils.isHighScaleUrl(paramImageKey.url))
        {
          ImageManagerLog.w(jdField_a_of_type_JavaLangString, "super resolution. check high scale not process. url=" + paramImageKey.url);
          paramBitmapReference = (BitmapReference)localObject;
          if (b((Drawable)localObject)) {
            paramBitmapReference = b((Drawable)localObject);
          }
        }
        paramBitmapReference = paramImageKey.options.extraProcessor.doProcess(paramBitmapReference);
        if ((paramBitmapReference instanceof SpecifiedBitmapDrawable))
        {
          localObject = ((SpecifiedBitmapDrawable)paramBitmapReference).getBitmapRef();
          ImageManager.getInstance().a(paramImageKey.urlKey, paramInt, new FeedsBitmapImage((BitmapReference)localObject), paramBitmapReference, paramImageKey.options);
          setResult(8, new Object[] { paramBitmapReference, localObject, paramImageKey.urlKey, Integer.valueOf(paramInt), new FeedsBitmapImage((BitmapReference)localObject), paramBitmapReference });
          ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
          label349:
          ImageTracer.endDecode(paramImageKey.url);
        }
      }
      for (;;)
      {
        if ((i == 0) && (ImageManagerEnv.g().enableReportNoneSuperResolutionTime()) && (RapidNetUtils.isBigUrl(paramImageKey.url)))
        {
          ImageTracer.reportDecodeTime(paramImageKey.url, false);
          ImageTracer.reportDownloadTime(paramImageKey.url, false);
        }
        return;
        if (!RapidNetUtils.needSuperResolution(paramImageKey.url)) {
          break label846;
        }
        i = localBitmapImage.getBitmap().getWidth();
        int m = localBitmapImage.getBitmap().getHeight();
        ImageManagerLog.d(jdField_a_of_type_JavaLangString, "super resolution. width=" + i + " height=" + m + " url=" + paramImageKey.url);
        if (!RapidNetUtils.canDoSuperResolution(i, m)) {
          break label846;
        }
        paramBitmapReference = localBitmapImage.getBitmap().getBitmap();
        ImageTracer.requestSuperResolution(paramImageKey.url);
        ProgressTracer.print(7, paramImageKey.urlKey);
        ImageManager.getSuperResolutionHandler().postAtFrontOfQueue(new pkx(this, paramImageKey, paramBitmapReference, j, k, paramInt));
        i = 1;
        break;
        localObject = localBitmapImage.getBitmap();
        ImageManager.getInstance().a(paramImageKey.urlKey, paramInt, localBitmapImage, paramBitmapReference, paramImageKey.options);
        setResult(8, new Object[] { paramBitmapReference, localObject, paramImageKey.urlKey, Integer.valueOf(paramInt), localBitmapImage, paramBitmapReference });
        ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
        break label349;
        paramBitmapReference = new SpecifiedBitmapDrawable(localBitmapImage.getBitmap());
        ImageTracer.endDecode(paramImageKey.url);
        ImageManager.getInstance().a(paramImageKey.urlKey, paramInt, localBitmapImage, paramBitmapReference, paramImageKey.options);
        setResult(8, new Object[] { paramBitmapReference, localBitmapImage.getBitmap(), paramImageKey.urlKey, Integer.valueOf(paramInt), localBitmapImage, paramBitmapReference });
        ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
      }
      if ((paramImageKey != null) && (paramImageKey.options != null)) {
        paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 105);
      }
      setResult(9, new Object[0]);
      if (paramImageKey != null)
      {
        paramBitmapReference = new File(paramImageKey.filePath);
        ImageManagerEnv.g().reportImageDecodingTask("unknown", paramImageKey.url, paramBitmapReference.length(), 51000, "processBitmap, bm is null", System.currentTimeMillis());
        ImageManagerLog.w(jdField_a_of_type_JavaLangString, "processBitmap, bm is null, url=" + paramImageKey.url + ", file length=" + paramBitmapReference.length());
      }
      ImageTaskTracer.addImageDecodeFailedRecord(paramImageKey.hashCodeEx());
      ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
      return;
      label846:
      i = 0;
    }
  }
  
  /* Error */
  private void a(ImageKey paramImageKey)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 170	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   5: invokevirtual 390	com/tencent/component/media/ImageManagerEnv:getCurrentLoadingImgStatus	()Z
    //   8: ifne +112 -> 120
    //   11: ldc_w 392
    //   14: new 217	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 394
    //   24: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: getfield 177	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   31: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 396
    //   37: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: getfield 142	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   44: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 307	com/tencent/component/media/utils/ImageManagerLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_1
    //   54: getfield 177	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   57: invokestatic 399	com/tencent/component/media/image/ImageTracer:startDecode	(Ljava/lang/String;)V
    //   60: iconst_3
    //   61: aload_1
    //   62: getfield 246	com/tencent/component/media/image/ImageKey:urlKey	Ljava/lang/String;
    //   65: invokestatic 323	com/tencent/component/media/image/ProgressTracer:print	(ILjava/lang/String;)V
    //   68: invokestatic 135	com/tencent/component/media/image/ImageManager:getInstance	()Lcom/tencent/component/media/image/ImageManager;
    //   71: aload_1
    //   72: invokevirtual 401	com/tencent/component/media/image/ImageManager:c	(Lcom/tencent/component/media/image/ImageKey;)V
    //   75: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   78: lstore 5
    //   80: new 348	java/io/File
    //   83: dup
    //   84: aload_1
    //   85: getfield 142	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   88: invokespecial 350	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: astore 10
    //   93: lconst_0
    //   94: lstore_3
    //   95: aload_1
    //   96: getfield 142	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   99: invokestatic 406	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   102: ifne +9 -> 111
    //   105: aload 10
    //   107: invokevirtual 356	java/io/File:length	()J
    //   110: lstore_3
    //   111: aload_0
    //   112: aload_1
    //   113: invokespecial 409	com/tencent/component/media/image/DecodeImageTask:b	(Lcom/tencent/component/media/image/ImageKey;)Z
    //   116: ifeq +49 -> 165
    //   119: return
    //   120: ldc_w 411
    //   123: new 217	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   130: ldc_w 413
    //   133: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_1
    //   137: getfield 177	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   140: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 396
    //   146: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_1
    //   150: getfield 142	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   153: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 307	com/tencent/component/media/utils/ImageManagerLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: goto -109 -> 53
    //   165: aload_0
    //   166: aload_1
    //   167: invokespecial 415	com/tencent/component/media/image/DecodeImageTask:c	(Lcom/tencent/component/media/image/ImageKey;)Z
    //   170: ifeq +30 -> 200
    //   173: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   176: lstore 7
    //   178: invokestatic 170	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   181: ldc_w 417
    //   184: aload_1
    //   185: getfield 177	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   188: lload_3
    //   189: iconst_1
    //   190: lload 7
    //   192: lload 5
    //   194: lsub
    //   195: iconst_0
    //   196: invokevirtual 421	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   199: return
    //   200: aload_0
    //   201: aload_1
    //   202: invokespecial 423	com/tencent/component/media/image/DecodeImageTask:d	(Lcom/tencent/component/media/image/ImageKey;)Z
    //   205: ifeq +30 -> 235
    //   208: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   211: lstore 7
    //   213: invokestatic 170	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   216: ldc_w 425
    //   219: aload_1
    //   220: getfield 177	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   223: lload_3
    //   224: iconst_1
    //   225: lload 7
    //   227: lload 5
    //   229: lsub
    //   230: iconst_0
    //   231: invokevirtual 421	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   234: return
    //   235: getstatic 30	com/tencent/component/media/image/DecodeImageTask:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   238: aload_1
    //   239: getfield 142	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   242: invokevirtual 429	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   245: checkcast 431	plb
    //   248: astore 15
    //   250: invokestatic 435	com/tencent/component/media/utils/BitmapUtils:getOptions	()Landroid/graphics/BitmapFactory$Options;
    //   253: astore 16
    //   255: aload 15
    //   257: ifnonnull +802 -> 1059
    //   260: new 431	plb
    //   263: dup
    //   264: invokespecial 436	plb:<init>	()V
    //   267: astore 15
    //   269: new 438	java/io/FileInputStream
    //   272: dup
    //   273: aload_1
    //   274: getfield 142	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   277: invokespecial 439	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   280: astore 10
    //   282: aload 10
    //   284: astore 11
    //   286: aload 10
    //   288: astore 12
    //   290: aload 10
    //   292: astore 13
    //   294: aload 10
    //   296: astore 14
    //   298: aload_0
    //   299: aload_1
    //   300: new 441	java/io/BufferedInputStream
    //   303: dup
    //   304: aload 10
    //   306: invokespecial 444	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   309: aload 15
    //   311: aload 16
    //   313: invokespecial 447	com/tencent/component/media/image/DecodeImageTask:a	(Lcom/tencent/component/media/image/ImageKey;Ljava/io/InputStream;Lplb;Landroid/graphics/BitmapFactory$Options;)V
    //   316: aload 10
    //   318: astore 11
    //   320: aload 10
    //   322: astore 12
    //   324: aload 10
    //   326: astore 13
    //   328: aload 10
    //   330: astore 14
    //   332: aload_0
    //   333: aload_1
    //   334: aload 15
    //   336: invokespecial 450	com/tencent/component/media/image/DecodeImageTask:a	(Lcom/tencent/component/media/image/ImageKey;Lplb;)Z
    //   339: ifne +302 -> 641
    //   342: aload 10
    //   344: ifnonnull +146 -> 490
    //   347: aload 10
    //   349: astore 11
    //   351: aload 10
    //   353: astore 12
    //   355: aload 10
    //   357: astore 13
    //   359: aload 10
    //   361: astore 14
    //   363: new 438	java/io/FileInputStream
    //   366: dup
    //   367: aload_1
    //   368: getfield 142	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   371: invokespecial 439	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   374: astore 10
    //   376: aload 16
    //   378: iconst_0
    //   379: putfield 455	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   382: aload_0
    //   383: aload_1
    //   384: aload 15
    //   386: aload 10
    //   388: aload 16
    //   390: invokespecial 458	com/tencent/component/media/image/DecodeImageTask:a	(Lcom/tencent/component/media/image/ImageKey;Lplb;Ljava/io/FileInputStream;Landroid/graphics/BitmapFactory$Options;)Z
    //   393: istore 9
    //   395: aload 10
    //   397: astore 11
    //   399: aload 15
    //   401: getfield 459	plb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   404: astore 13
    //   406: aload 10
    //   408: astore 11
    //   410: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   413: lstore 7
    //   415: aload 10
    //   417: astore 11
    //   419: invokestatic 170	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   422: astore 12
    //   424: aload 10
    //   426: astore 11
    //   428: aload_1
    //   429: getfield 177	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   432: astore 14
    //   434: iload 9
    //   436: ifeq +211 -> 647
    //   439: aload 10
    //   441: astore 11
    //   443: aload 12
    //   445: aload 13
    //   447: aload 14
    //   449: lload_3
    //   450: iload 9
    //   452: lload 7
    //   454: lload 5
    //   456: lsub
    //   457: iload_2
    //   458: invokevirtual 421	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   461: iload 9
    //   463: ifne +14 -> 477
    //   466: aload 10
    //   468: astore 11
    //   470: invokestatic 135	com/tencent/component/media/image/ImageManager:getInstance	()Lcom/tencent/component/media/image/ImageManager;
    //   473: aload_1
    //   474: invokevirtual 460	com/tencent/component/media/image/ImageManager:a	(Lcom/tencent/component/media/image/ImageKey;)V
    //   477: aload 10
    //   479: ifnull -360 -> 119
    //   482: aload 10
    //   484: invokevirtual 463	java/io/FileInputStream:close	()V
    //   487: return
    //   488: astore_1
    //   489: return
    //   490: aload 10
    //   492: astore 11
    //   494: aload 10
    //   496: astore 12
    //   498: aload 10
    //   500: astore 13
    //   502: aload 10
    //   504: astore 14
    //   506: aload_0
    //   507: aload 10
    //   509: invokespecial 466	com/tencent/component/media/image/DecodeImageTask:a	(Ljava/io/FileInputStream;)V
    //   512: goto -136 -> 376
    //   515: astore 12
    //   517: aload 11
    //   519: astore 10
    //   521: ldc_w 352
    //   524: astore 13
    //   526: aload 10
    //   528: astore 11
    //   530: aload_1
    //   531: getfield 152	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   534: ifnull +20 -> 554
    //   537: aload 10
    //   539: astore 11
    //   541: aload_1
    //   542: getfield 152	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   545: aload_1
    //   546: bipush 110
    //   548: invokestatic 343	com/tencent/component/media/image/ImageManager:getErrorString	(Lcom/tencent/component/media/image/ImageKey;I)Ljava/lang/String;
    //   551: putfield 346	com/tencent/component/media/image/ImageLoader$Options:errCode	Ljava/lang/String;
    //   554: aload 10
    //   556: astore 11
    //   558: getstatic 23	com/tencent/component/media/image/DecodeImageTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   561: aload 12
    //   563: invokestatic 472	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   566: invokestatic 83	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   569: aload 10
    //   571: astore 11
    //   573: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   576: lstore 7
    //   578: aload 10
    //   580: astore 11
    //   582: invokestatic 170	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   585: aload 13
    //   587: aload_1
    //   588: getfield 177	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   591: lload_3
    //   592: iconst_0
    //   593: lload 7
    //   595: lload 5
    //   597: lsub
    //   598: iconst_3
    //   599: invokevirtual 421	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   602: aload 10
    //   604: astore 11
    //   606: invokestatic 170	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   609: aload 13
    //   611: aload_1
    //   612: getfield 177	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   615: lload_3
    //   616: ldc_w 357
    //   619: ldc_w 474
    //   622: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   625: invokevirtual 368	com/tencent/component/media/ImageManagerEnv:reportImageDecodingTask	(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;J)V
    //   628: aload 10
    //   630: ifnull -511 -> 119
    //   633: aload 10
    //   635: invokevirtual 463	java/io/FileInputStream:close	()V
    //   638: return
    //   639: astore_1
    //   640: return
    //   641: iconst_1
    //   642: istore 9
    //   644: goto -249 -> 395
    //   647: iconst_1
    //   648: istore_2
    //   649: goto -210 -> 439
    //   652: astore 12
    //   654: aconst_null
    //   655: astore 10
    //   657: ldc_w 352
    //   660: astore 13
    //   662: aload 10
    //   664: astore 11
    //   666: aload_1
    //   667: getfield 152	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   670: ifnull +20 -> 690
    //   673: aload 10
    //   675: astore 11
    //   677: aload_1
    //   678: getfield 152	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   681: aload_1
    //   682: bipush 111
    //   684: invokestatic 343	com/tencent/component/media/image/ImageManager:getErrorString	(Lcom/tencent/component/media/image/ImageKey;I)Ljava/lang/String;
    //   687: putfield 346	com/tencent/component/media/image/ImageLoader$Options:errCode	Ljava/lang/String;
    //   690: aload 10
    //   692: astore 11
    //   694: getstatic 23	com/tencent/component/media/image/DecodeImageTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   697: aload 12
    //   699: invokestatic 472	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   702: invokestatic 83	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   705: aload 10
    //   707: astore 11
    //   709: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   712: lstore 7
    //   714: aload 10
    //   716: astore 11
    //   718: invokestatic 170	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   721: aload 13
    //   723: aload_1
    //   724: getfield 177	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   727: lload_3
    //   728: iconst_0
    //   729: lload 7
    //   731: lload 5
    //   733: lsub
    //   734: iconst_2
    //   735: invokevirtual 421	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   738: aload 10
    //   740: astore 11
    //   742: invokestatic 170	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   745: aload 13
    //   747: aload_1
    //   748: getfield 177	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   751: lload_3
    //   752: ldc_w 357
    //   755: ldc_w 476
    //   758: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   761: invokevirtual 368	com/tencent/component/media/ImageManagerEnv:reportImageDecodingTask	(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;J)V
    //   764: aload 10
    //   766: ifnull -647 -> 119
    //   769: aload 10
    //   771: invokevirtual 463	java/io/FileInputStream:close	()V
    //   774: return
    //   775: astore_1
    //   776: return
    //   777: astore 12
    //   779: aconst_null
    //   780: astore 10
    //   782: ldc_w 352
    //   785: astore 13
    //   787: aload 10
    //   789: astore 11
    //   791: aload_1
    //   792: getfield 152	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   795: ifnull +20 -> 815
    //   798: aload 10
    //   800: astore 11
    //   802: aload_1
    //   803: getfield 152	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   806: aload_1
    //   807: bipush 112
    //   809: invokestatic 343	com/tencent/component/media/image/ImageManager:getErrorString	(Lcom/tencent/component/media/image/ImageKey;I)Ljava/lang/String;
    //   812: putfield 346	com/tencent/component/media/image/ImageLoader$Options:errCode	Ljava/lang/String;
    //   815: aload 10
    //   817: astore 11
    //   819: getstatic 23	com/tencent/component/media/image/DecodeImageTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   822: aload 12
    //   824: invokestatic 472	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   827: invokestatic 83	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: aload 10
    //   832: astore 11
    //   834: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   837: lstore 7
    //   839: aload 10
    //   841: astore 11
    //   843: invokestatic 170	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   846: aload 13
    //   848: aload_1
    //   849: getfield 177	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   852: lload_3
    //   853: iconst_0
    //   854: lload 7
    //   856: lload 5
    //   858: lsub
    //   859: iconst_4
    //   860: invokevirtual 421	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   863: aload 10
    //   865: astore 11
    //   867: invokestatic 170	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   870: aload 13
    //   872: aload_1
    //   873: getfield 177	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   876: lload_3
    //   877: ldc_w 357
    //   880: ldc_w 478
    //   883: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   886: invokevirtual 368	com/tencent/component/media/ImageManagerEnv:reportImageDecodingTask	(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;J)V
    //   889: aload 10
    //   891: ifnull -772 -> 119
    //   894: aload 10
    //   896: invokevirtual 463	java/io/FileInputStream:close	()V
    //   899: return
    //   900: astore_1
    //   901: return
    //   902: astore_1
    //   903: aconst_null
    //   904: astore 11
    //   906: aload 11
    //   908: ifnull +8 -> 916
    //   911: aload 11
    //   913: invokevirtual 463	java/io/FileInputStream:close	()V
    //   916: aload_1
    //   917: athrow
    //   918: astore 10
    //   920: goto -4 -> 916
    //   923: astore_1
    //   924: aload 12
    //   926: astore 11
    //   928: goto -22 -> 906
    //   931: astore_1
    //   932: aload 10
    //   934: astore 11
    //   936: goto -30 -> 906
    //   939: astore_1
    //   940: goto -34 -> 906
    //   943: astore 12
    //   945: aload 13
    //   947: astore 10
    //   949: ldc_w 352
    //   952: astore 13
    //   954: goto -167 -> 787
    //   957: astore 12
    //   959: ldc_w 352
    //   962: astore 13
    //   964: goto -177 -> 787
    //   967: astore 12
    //   969: ldc_w 352
    //   972: astore 13
    //   974: goto -187 -> 787
    //   977: astore 12
    //   979: goto -192 -> 787
    //   982: astore 12
    //   984: aload 14
    //   986: astore 10
    //   988: ldc_w 352
    //   991: astore 13
    //   993: goto -331 -> 662
    //   996: astore 12
    //   998: ldc_w 352
    //   1001: astore 13
    //   1003: goto -341 -> 662
    //   1006: astore 12
    //   1008: ldc_w 352
    //   1011: astore 13
    //   1013: goto -351 -> 662
    //   1016: astore 12
    //   1018: goto -356 -> 662
    //   1021: astore 12
    //   1023: aconst_null
    //   1024: astore 10
    //   1026: ldc_w 352
    //   1029: astore 13
    //   1031: goto -505 -> 526
    //   1034: astore 12
    //   1036: ldc_w 352
    //   1039: astore 13
    //   1041: goto -515 -> 526
    //   1044: astore 12
    //   1046: ldc_w 352
    //   1049: astore 13
    //   1051: goto -525 -> 526
    //   1054: astore 12
    //   1056: goto -530 -> 526
    //   1059: aconst_null
    //   1060: astore 10
    //   1062: goto -746 -> 316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1065	0	this	DecodeImageTask
    //   0	1065	1	paramImageKey	ImageKey
    //   1	648	2	i	int
    //   94	783	3	l1	long
    //   78	779	5	l2	long
    //   176	679	7	l3	long
    //   393	250	9	bool	boolean
    //   91	804	10	localObject1	Object
    //   918	15	10	localIOException	java.io.IOException
    //   947	114	10	localObject2	Object
    //   284	651	11	localObject3	Object
    //   288	209	12	localObject4	Object
    //   515	47	12	localException1	java.lang.Exception
    //   652	46	12	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   777	148	12	localThrowable1	Throwable
    //   943	1	12	localThrowable2	Throwable
    //   957	1	12	localThrowable3	Throwable
    //   967	1	12	localThrowable4	Throwable
    //   977	1	12	localThrowable5	Throwable
    //   982	1	12	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   996	1	12	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1006	1	12	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1016	1	12	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   1021	1	12	localException2	java.lang.Exception
    //   1034	1	12	localException3	java.lang.Exception
    //   1044	1	12	localException4	java.lang.Exception
    //   1054	1	12	localException5	java.lang.Exception
    //   292	758	13	localObject5	Object
    //   296	689	14	localObject6	Object
    //   248	152	15	localplb	plb
    //   253	136	16	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   482	487	488	java/io/IOException
    //   298	316	515	java/lang/Exception
    //   332	342	515	java/lang/Exception
    //   363	376	515	java/lang/Exception
    //   506	512	515	java/lang/Exception
    //   633	638	639	java/io/IOException
    //   250	255	652	java/lang/OutOfMemoryError
    //   260	282	652	java/lang/OutOfMemoryError
    //   769	774	775	java/io/IOException
    //   250	255	777	java/lang/Throwable
    //   260	282	777	java/lang/Throwable
    //   894	899	900	java/io/IOException
    //   250	255	902	finally
    //   260	282	902	finally
    //   911	916	918	java/io/IOException
    //   298	316	923	finally
    //   332	342	923	finally
    //   363	376	923	finally
    //   506	512	923	finally
    //   376	395	931	finally
    //   399	406	939	finally
    //   410	415	939	finally
    //   419	424	939	finally
    //   428	434	939	finally
    //   443	461	939	finally
    //   470	477	939	finally
    //   530	537	939	finally
    //   541	554	939	finally
    //   558	569	939	finally
    //   573	578	939	finally
    //   582	602	939	finally
    //   606	628	939	finally
    //   666	673	939	finally
    //   677	690	939	finally
    //   694	705	939	finally
    //   709	714	939	finally
    //   718	738	939	finally
    //   742	764	939	finally
    //   791	798	939	finally
    //   802	815	939	finally
    //   819	830	939	finally
    //   834	839	939	finally
    //   843	863	939	finally
    //   867	889	939	finally
    //   298	316	943	java/lang/Throwable
    //   332	342	943	java/lang/Throwable
    //   363	376	943	java/lang/Throwable
    //   506	512	943	java/lang/Throwable
    //   376	395	957	java/lang/Throwable
    //   399	406	967	java/lang/Throwable
    //   410	415	977	java/lang/Throwable
    //   419	424	977	java/lang/Throwable
    //   428	434	977	java/lang/Throwable
    //   443	461	977	java/lang/Throwable
    //   470	477	977	java/lang/Throwable
    //   298	316	982	java/lang/OutOfMemoryError
    //   332	342	982	java/lang/OutOfMemoryError
    //   363	376	982	java/lang/OutOfMemoryError
    //   506	512	982	java/lang/OutOfMemoryError
    //   376	395	996	java/lang/OutOfMemoryError
    //   399	406	1006	java/lang/OutOfMemoryError
    //   410	415	1016	java/lang/OutOfMemoryError
    //   419	424	1016	java/lang/OutOfMemoryError
    //   428	434	1016	java/lang/OutOfMemoryError
    //   443	461	1016	java/lang/OutOfMemoryError
    //   470	477	1016	java/lang/OutOfMemoryError
    //   250	255	1021	java/lang/Exception
    //   260	282	1021	java/lang/Exception
    //   376	395	1034	java/lang/Exception
    //   399	406	1044	java/lang/Exception
    //   410	415	1054	java/lang/Exception
    //   419	424	1054	java/lang/Exception
    //   428	434	1054	java/lang/Exception
    //   443	461	1054	java/lang/Exception
    //   470	477	1054	java/lang/Exception
  }
  
  private void a(ImageKey paramImageKey, InputStream paramInputStream, plb paramplb, BitmapFactory.Options paramOptions)
  {
    paramOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, paramOptions);
    if (paramOptions.outMimeType != null) {}
    for (paramInputStream = paramOptions.outMimeType;; paramInputStream = "unknown")
    {
      paramplb.jdField_a_of_type_JavaLangString = paramInputStream;
      paramplb.b = paramOptions.outHeight;
      paramplb.jdField_a_of_type_Int = paramOptions.outWidth;
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramImageKey.filePath, paramplb);
      return;
    }
  }
  
  private void a(FileInputStream paramFileInputStream)
  {
    paramFileInputStream = paramFileInputStream.getChannel();
    paramFileInputStream.position();
    paramFileInputStream.position(0L);
  }
  
  private boolean a(ImageKey paramImageKey)
  {
    int j = paramImageKey.hashCodeEx();
    SharpPDecoderHelper localSharpPDecoderHelper = new SharpPDecoderHelper(paramImageKey.filePath);
    int i = localSharpPDecoderHelper.a();
    if (i != 0)
    {
      ImageManagerLog.w(jdField_a_of_type_JavaLangString, "parseHeader error,status=" + i + "," + paramImageKey.url + ",hashCode=" + paramImageKey.hashCodeEx() + ",filePath=" + paramImageKey.filePath + ", try again");
      return false;
    }
    plb localplb = (plb)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramImageKey.filePath);
    Object localObject2 = localSharpPDecoderHelper.a();
    Object localObject1;
    if ((localplb == null) || (localplb.jdField_a_of_type_JavaLangString.equals("unknown")))
    {
      localplb = new plb();
      localplb.b = ((SharpPDecoderWrapper.SharpPFeatureWrapper)localObject2).b();
      localplb.jdField_a_of_type_Int = ((SharpPDecoderWrapper.SharpPFeatureWrapper)localObject2).a();
      localObject1 = localSharpPDecoderHelper.a();
      if (localObject1 != null)
      {
        localplb.jdField_a_of_type_JavaLangString = ((String)localObject1);
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramImageKey.filePath, localplb);
      }
    }
    label267:
    label553:
    label842:
    for (;;)
    {
      localObject1 = (Integer)c.get(Integer.valueOf(j));
      int m = ((SharpPDecoderWrapper.SharpPFeatureWrapper)localObject2).a();
      int k = ((SharpPDecoderWrapper.SharpPFeatureWrapper)localObject2).b();
      if (localObject1 == null)
      {
        i = ImageOptionSampleSize.computeSampleSize(paramImageKey.options, m, k);
        c.put(Integer.valueOf(j), Integer.valueOf(i));
        if ((!b(localplb.jdField_a_of_type_JavaLangString)) || (paramImageKey.options == null) || (!paramImageKey.options.needShowGifAnimation)) {
          break label553;
        }
        ImageManagerLog.d(jdField_a_of_type_JavaLangString, "handlerSharpPDecodeMessage -- url: " + paramImageKey.url + " --" + "is sharp gif：" + localplb.jdField_a_of_type_JavaLangString);
        localObject2 = new NewGifImage(paramImageKey.filePath, m, k, i, paramImageKey.url);
        if (localObject2 == null) {
          break label876;
        }
      }
      label717:
      label858:
      label873:
      label876:
      for (localObject1 = ((NewGifImage)localObject2).getDrawable();; localObject1 = null)
      {
        ImageManagerEnv.g().reportImageDecodingResMTA("gif_collect", "sharp/gif");
        if (localObject1 != null)
        {
          if ((paramImageKey.options.extraProcessor == null) || (!(paramImageKey.options.extraProcessor instanceof NewGifDrawableSpecifiedRegionProcessor))) {
            break label873;
          }
          localObject1 = paramImageKey.options.extraProcessor.doProcess((Drawable)localObject1);
        }
        for (;;)
        {
          ImageManager.getInstance().a(paramImageKey.urlKey, j, (Image)localObject2, (Drawable)localObject1, paramImageKey.options);
          setResult(8, new Object[] { localObject1, null, paramImageKey.urlKey, Integer.valueOf(j), localObject2, localObject1 });
          ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
          ImageTracer.endDecode(paramImageKey.url);
          return true;
          localObject1 = "unknown";
          break;
          i = ((Integer)localObject1).intValue();
          break label267;
          if (paramImageKey.options != null) {
            paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 103);
          }
          return false;
          localObject1 = Bitmap.Config.ARGB_8888;
          if ((paramImageKey.options != null) && (paramImageKey.options.imageConfig != null))
          {
            localObject1 = paramImageKey.options.imageConfig;
            localObject2 = localObject1;
            if (i == 1)
            {
              localObject2 = localObject1;
              if (localObject1 == Bitmap.Config.ARGB_8888)
              {
                float f = k / m;
                if (f <= 2.0F)
                {
                  localObject2 = localObject1;
                  if (f >= 0.5F) {}
                }
                else
                {
                  localObject2 = localObject1;
                  if (k * m > ImageManagerEnv.g().getScreenHeight() * ImageManagerEnv.g().getScreenWidth()) {
                    localObject2 = Bitmap.Config.RGB_565;
                  }
                }
              }
            }
            localObject1 = localObject2;
            if (paramImageKey.options != null) {
              if (paramImageKey.options.mImageType != 3)
              {
                localObject1 = localObject2;
                if (paramImageKey.options.mImageType != 4) {}
              }
              else
              {
                if (paramImageKey.options.imageConfig == null) {
                  break label805;
                }
                localObject1 = paramImageKey.options.imageConfig;
              }
            }
            m /= i;
            i = k / i;
            if (!SharpPUtils.b(localplb.jdField_a_of_type_JavaLangString)) {
              break label842;
            }
          }
          for (localObject1 = localSharpPDecoderHelper.c(m, i, (Bitmap.Config)localObject1);; localObject1 = localSharpPDecoderHelper.b(m, i, Bitmap.Config.ARGB_8888))
          {
            if (localObject1 != null) {
              break label858;
            }
            if (paramImageKey.options != null) {
              paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 104);
            }
            return false;
            if (SharpPUtils.b(localplb.jdField_a_of_type_JavaLangString))
            {
              localObject1 = Bitmap.Config.RGB_565;
              break;
            }
            localObject1 = Bitmap.Config.ARGB_8888;
            break;
            if ((m != 0) && (k != 0) && (m / k == 2.0F))
            {
              localObject1 = Bitmap.Config.RGB_565;
              break label717;
            }
            localObject1 = Bitmap.Config.ARGB_8888;
            break label717;
          }
          a(BitmapReference.getBitmapReference((Bitmap)localObject1), paramImageKey, j, true);
          return true;
        }
      }
    }
  }
  
  private boolean a(ImageKey paramImageKey, plb paramplb)
  {
    int i;
    NewGifImage localNewGifImage;
    if ((b(paramplb.jdField_a_of_type_JavaLangString)) && (paramImageKey.options != null) && (paramImageKey.options.needShowGifAnimation))
    {
      int j = paramImageKey.options.clipWidth;
      int k = paramImageKey.options.clipHeight;
      if (j > 0)
      {
        i = k;
        if (k > 0) {}
      }
      else
      {
        j = ImageManagerEnv.g().getScreenWidth();
        i = ImageManagerEnv.g().getScreenHeight();
      }
      localNewGifImage = new NewGifImage(paramImageKey, j, i);
      if (localNewGifImage == null) {
        break label366;
      }
    }
    label363:
    label366:
    for (paramplb = localNewGifImage.getDrawable();; paramplb = null)
    {
      ImageManagerEnv.g().reportImageDecodingResMTA("gif_collect", "normal/gif");
      if (paramplb != null)
      {
        if ((paramImageKey.options == null) || (!(paramImageKey.options.extraProcessor instanceof NewGifDrawableSpecifiedRegionProcessor))) {
          break label363;
        }
        paramplb = paramImageKey.options.extraProcessor.doProcess(paramplb);
      }
      for (;;)
      {
        i = paramImageKey.hashCodeEx();
        ImageManager.getInstance().a(paramImageKey.urlKey, i, localNewGifImage, paramplb, paramImageKey.options);
        setResult(8, new Object[] { paramplb, null, paramImageKey.urlKey, Integer.valueOf(i), localNewGifImage, paramplb });
        ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
        for (;;)
        {
          boolean bool1 = true;
          boolean bool2;
          do
          {
            return bool1;
            if ((TextUtils.isEmpty(paramImageKey.filePath)) || (!SharpPUtils.a(new File(paramImageKey.filePath)))) {
              break;
            }
            ImageManagerLog.e(jdField_a_of_type_JavaLangString, "decodeGif url----" + paramImageKey.url + "   is not normal gif picture,try sharpP decode");
            bool2 = a(paramImageKey);
            bool1 = bool2;
          } while (bool2);
          setResult(9, new Object[0]);
          return bool2;
          if (paramImageKey.options != null) {
            paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 107);
          }
          setResult(9, new Object[0]);
          ImageTaskTracer.addImageDecodeFailedRecord(paramImageKey.hashCodeEx());
          ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
        }
        return false;
      }
    }
  }
  
  private boolean a(ImageKey paramImageKey, plb paramplb, FileInputStream paramFileInputStream, BitmapFactory.Options paramOptions)
  {
    int j = paramImageKey.hashCodeEx();
    Integer localInteger = (Integer)c.get(Integer.valueOf(j));
    int i;
    if (localInteger == null)
    {
      i = ImageOptionSampleSize.computeSampleSize(paramImageKey.options, paramplb.jdField_a_of_type_Int, paramplb.b);
      c.put(Integer.valueOf(j), Integer.valueOf(i));
      if ((paramImageKey.options == null) || (paramImageKey.options.imageConfig == null)) {
        break label434;
      }
      paramOptions.inPreferredConfig = paramImageKey.options.imageConfig;
      label90:
      if ((i == 1) && (paramOptions.inPreferredConfig == Bitmap.Config.ARGB_8888))
      {
        float f = paramplb.b / paramplb.jdField_a_of_type_Int;
        if (((f > 2.0F) || (f < 0.5F)) && (paramplb.b * paramplb.jdField_a_of_type_Int > ImageManagerEnv.g().getScreenHeight() * ImageManagerEnv.g().getScreenWidth())) {
          paramOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        }
      }
      if (paramOptions.inPreferredConfig == Bitmap.Config.RGB_565) {
        paramOptions.inDither = true;
      }
      if ((paramImageKey.options != null) && ((paramImageKey.options.mImageType == 3) || (paramImageKey.options.mImageType == 4)))
      {
        if (paramImageKey.options.imageConfig == null) {
          break label466;
        }
        paramOptions.inPreferredConfig = paramImageKey.options.imageConfig;
      }
    }
    for (;;)
    {
      paramOptions.outWidth = paramplb.jdField_a_of_type_Int;
      paramOptions.outHeight = paramplb.b;
      paramOptions.inPurgeable = true;
      paramOptions.inInputShareable = true;
      paramOptions.inSampleSize = i;
      paramOptions.outMimeType = paramplb.jdField_a_of_type_JavaLangString;
      paramplb = a(ImageManager.getInstance().getDecoder(), paramFileInputStream, paramOptions, false);
      if ((paramplb != null) || (TextUtils.isEmpty(paramImageKey.filePath)) || (!SharpPUtils.a(new File(paramImageKey.filePath)))) {
        break label517;
      }
      ImageManagerLog.e(jdField_a_of_type_JavaLangString, "decodeNormalImage --url=" + paramImageKey.url + "  is not normal picture,try sharpP decode");
      boolean bool = a(paramImageKey);
      if (!bool)
      {
        setResult(9, new Object[0]);
        ImageManagerLog.e(jdField_a_of_type_JavaLangString, "decodeNormalImage -- url=" + paramImageKey.url + "  is not normal picture,try sharpP decode failed");
      }
      return bool;
      i = localInteger.intValue();
      break;
      label434:
      if (c(paramplb.jdField_a_of_type_JavaLangString))
      {
        paramOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        break label90;
      }
      paramOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      break label90;
      label466:
      if ((paramplb.jdField_a_of_type_Int != 0) && (paramplb.b != 0) && (paramplb.jdField_a_of_type_Int / paramplb.b == 2.0F)) {
        paramOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      } else {
        paramOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      }
    }
    label517:
    a(paramplb, paramImageKey, j, true);
    return paramplb != null;
  }
  
  private static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("avatar://");
  }
  
  private static Drawable b(Drawable paramDrawable)
  {
    int k = paramDrawable.getIntrinsicWidth();
    int m = paramDrawable.getIntrinsicHeight();
    int j = ImageManagerEnv.g().getScreenWidth() - (int)(ImageManagerEnv.g().getDesity() * 4.0F);
    int i = ImageManagerEnv.g().getScreenHeight() - (int)(ImageManagerEnv.g().getDesity() * 4.0F);
    Drawable localDrawable;
    double d;
    if (k <= j)
    {
      localDrawable = paramDrawable;
      if (m <= i) {}
    }
    else
    {
      if (k / m <= j / i) {
        break label129;
      }
      d = j;
      i = (int)(m / k * d);
    }
    for (;;)
    {
      localDrawable = new ScaleProcessor(j, i, true).process(paramDrawable);
      localDrawable.setBounds(0, 0, j, i);
      return localDrawable;
      label129:
      d = i;
      j = (int)(k / m * d);
    }
  }
  
  private static boolean b(Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    int k = ImageManagerEnv.g().getScreenWidth() - (int)(ImageManagerEnv.g().getDesity() * 4.0F);
    int m = ImageManagerEnv.g().getScreenHeight() - (int)(ImageManagerEnv.g().getDesity() * 4.0F);
    ImageManagerLog.w(jdField_a_of_type_JavaLangString, "super resolution. needTryScaleDrawable: width=" + i + " screenWidth=" + k + " height=" + j + " screenHeight=" + m);
    return (i > k) || (j > m);
  }
  
  private boolean b(ImageKey paramImageKey)
  {
    boolean bool = false;
    if (VideoThumbnail.isVideo(paramImageKey.filePath))
    {
      int i = paramImageKey.hashCodeEx();
      a(VideoThumbnail.getThumb(ImageManagerEnv.getAppContext(), paramImageKey.filePath), paramImageKey, i, false);
      bool = true;
    }
    return bool;
  }
  
  private static boolean b(String paramString)
  {
    return "image/gif".equalsIgnoreCase(paramString);
  }
  
  private boolean c(ImageKey paramImageKey)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (SharpPUtils.a(paramImageKey.url))
    {
      bool1 = bool2;
      if (paramImageKey.filePath != null)
      {
        ImageManagerLog.d(jdField_a_of_type_JavaLangString, "decodeSharpP -- url: " + paramImageKey.url + " --" + "is SharpP");
        bool1 = a(paramImageKey);
        if ((!bool1) && (!SharpPUtils.a(new File(paramImageKey.filePath)))) {
          break label218;
        }
        if (!bool1)
        {
          ImageManager.getInstance().a(paramImageKey);
          setResult(9, new Object[0]);
          ImageManagerLog.e(jdField_a_of_type_JavaLangString, "decodeSharpP -- url: " + paramImageKey.url + " --" + "  decode sharpp failed.");
          ImageTaskTracer.addImageDecodeFailedRecord(paramImageKey.hashCodeEx());
          ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
          ImageTracer.decodeFail(paramImageKey.url);
          File localFile = new File(paramImageKey.filePath);
          ImageManagerEnv.g().reportImageDecodingTask("image/sharpp", paramImageKey.url, localFile.length(), 51000, "decode sharpP image failed", System.currentTimeMillis());
        }
        bool1 = true;
      }
    }
    return bool1;
    label218:
    ImageManagerLog.w(jdField_a_of_type_JavaLangString, "decodeSharpP -- url: " + paramImageKey.url + " --" + "is not really SharpP,so try normal decode");
    return false;
  }
  
  private static boolean c(String paramString)
  {
    return "image/png".equalsIgnoreCase(paramString);
  }
  
  public static void clearImageKey2SampleSizeMap()
  {
    c.clear();
  }
  
  public static void clearImagePath2AttriMap()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public static void clearImagePath2RotationMap()
  {
    jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  private boolean d(ImageKey paramImageKey)
  {
    if (PhotoGifDrawable.isPhotoGif(paramImageKey))
    {
      int i = paramImageKey.hashCodeEx();
      Object localObject = new PhotoGifImage(paramImageKey);
      Drawable localDrawable = ((PhotoGifImage)localObject).getDrawable();
      if (localDrawable != null)
      {
        ImageManager.getInstance().a(paramImageKey.urlKey, i, (Image)localObject, localDrawable, paramImageKey.options);
        setResult(8, new Object[] { localDrawable, null, paramImageKey.urlKey, Integer.valueOf(i), localObject, localDrawable });
      }
      for (;;)
      {
        return true;
        if ((paramImageKey != null) && (paramImageKey.options != null)) {
          paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 106);
        }
        setResult(9, new Object[0]);
        localObject = new File(paramImageKey.filePath);
        ImageManagerEnv.g().reportImageDecodingTask("image/photogif", paramImageKey.url, ((File)localObject).length(), 51000, "decode gif failed, gif drawable is null", System.currentTimeMillis());
      }
    }
    return false;
  }
  
  public static Integer getImagePath2Rotation(String paramString)
  {
    if (paramString != null) {
      return (Integer)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public static DecodeImageTask obtain(ImageKey paramImageKey)
  {
    if (needRecycle) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask != null)
      {
        DecodeImageTask localDecodeImageTask = jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask;
        jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask = jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask.jdField_b_of_type_ComTencentComponentMediaImageDecodeImageTask;
        localDecodeImageTask.jdField_b_of_type_ComTencentComponentMediaImageDecodeImageTask = null;
        jdField_a_of_type_Int -= 1;
        localDecodeImageTask.setImageKey(paramImageKey);
        return localDecodeImageTask;
      }
      return new DecodeImageTask(paramImageKey);
    }
  }
  
  public static DecodeImageTask obtain(plz paramplz)
  {
    if (needRecycle) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask != null)
      {
        DecodeImageTask localDecodeImageTask = jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask;
        jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask = jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask.jdField_b_of_type_ComTencentComponentMediaImageDecodeImageTask;
        localDecodeImageTask.jdField_b_of_type_ComTencentComponentMediaImageDecodeImageTask = null;
        jdField_a_of_type_Int -= 1;
        localDecodeImageTask.setImageTask(paramplz);
        return localDecodeImageTask;
      }
      return new DecodeImageTask(paramplz);
    }
  }
  
  public static void putImagePath2Rotation(String paramString, int paramInt)
  {
    jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void excuteTask()
  {
    Object localObject = ImageManager.getInstance().a(this.mImageKey);
    if (localObject != null)
    {
      setResult(11, new Object[] { localObject });
      return;
    }
    ImageManager.getInstance().c(this.mImageKey);
    localObject = new File(this.mImageKey.filePath);
    SharpPUtils.a((File)localObject, this.mImageKey.url);
    if (((File)localObject).exists())
    {
      ImageManager.getInstance().traceImageFile(true);
      if (!ImageManagerEnv.g().getCurrentLoadingImgStatus())
      {
        pma.a().a(this);
        return;
      }
      startDecodeTask();
      return;
    }
    ImageManager.getInstance().traceImageFile(false);
    if ((this.mImageKey != null) && (this.mImageKey.options != null) && (this.mImageKey.options.mImageType == 2))
    {
      ImageTaskBuilder.stampMap.put(this.mImageKey.url, Long.valueOf(System.currentTimeMillis()));
      ImageManagerLog.w(jdField_a_of_type_JavaLangString, "no file hashCodeEx:" + this.mImageKey.hashCodeEx() + " isGifPlayWhileDownloading:" + this.mImageKey.options.isGifPlayWhileDownloading);
    }
    if (this.mNextTask != null)
    {
      this.mNextTask.excuteTask();
      return;
    }
    if (this.mImageKey.options != null) {
      this.mImageKey.options.errCode = ImageManager.getErrorString(this.mImageKey, 100);
    }
    setResult(9, new Object[0]);
  }
  
  protected void onResult(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      setResult(paramInt, paramVarArgs);
    }
    do
    {
      return;
      setResult(9, new Object[0]);
      return;
      setResult(9, new Object[0]);
      return;
      ImageManager.getInstance().c(this.mImageKey);
      if ((a(this.mImageKey.url)) && (paramVarArgs[1] != null)) {
        this.mImageKey.filePath = paramVarArgs[1].toString();
      }
      paramVarArgs = new File(this.mImageKey.filePath);
      if (paramVarArgs.exists())
      {
        if (!ImageManagerEnv.g().getCurrentLoadingImgStatus())
        {
          pma.a().a(this);
          return;
        }
        startDecodeTask();
        return;
      }
      if (this.mImageKey.options != null) {
        this.mImageKey.options.errCode = ImageManager.getErrorString(this.mImageKey, 102);
      }
      setResult(9, new Object[0]);
    } while (this.mImageKey == null);
    ImageManagerEnv.g().reportImageDecodingTask("unknown", this.mImageKey.url, paramVarArgs.length(), 51000, "download success, file does not exist", System.currentTimeMillis());
    ImageManagerLog.w(jdField_a_of_type_JavaLangString, "onResult, download success, file does not exist!, url=" + this.mImageKey.url + ", file length=" + paramVarArgs.length());
  }
  
  public void recycle()
  {
    if (!needRecycle) {
      return;
    }
    reset();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 50)
      {
        this.jdField_b_of_type_ComTencentComponentMediaImageDecodeImageTask = jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask;
        jdField_a_of_type_ComTencentComponentMediaImageDecodeImageTask = this;
        jdField_a_of_type_Int += 1;
      }
      return;
    }
  }
  
  public void startDecodeTask()
  {
    if (this.mImageKey != null) {
      ImageTaskTracer.addImageDecodeThreadPendingRecord(this.mImageKey.hashCodeEx());
    }
    pla localpla = new pla(this, this.mImageKey);
    if ((this.mImageKey != null) && (this.mImageKey.options != null) && (this.mImageKey.options.priority)) {}
    for (boolean bool = true;; bool = false)
    {
      ImageManager.post(localpla, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.DecodeImageTask
 * JD-Core Version:    0.7.0.1
 */