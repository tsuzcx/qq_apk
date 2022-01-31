package com.tencent.component.media.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.animwebp.AnimWebPHelper;
import com.tencent.component.media.animwebp.AnimWebpImage;
import com.tencent.component.media.image.drawable.BitmapImageDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.media.image.image.BitmapImage;
import com.tencent.component.media.image.image.FeedsBitmapImage;
import com.tencent.component.media.image.image.Image;
import com.tencent.component.media.image.image.NewGifImage;
import com.tencent.component.media.image.processor.NewGifDrawableSpecifiedRegionProcessor;
import com.tencent.component.media.image.processor.ScaleProcessor;
import com.tencent.component.media.image.region.RegionDrawable;
import com.tencent.component.media.image.region.RegionImageUtil;
import com.tencent.component.media.photogif.PhotoGifDrawable;
import com.tencent.component.media.photogif.PhotoGifImage;
import com.tencent.component.media.utils.BaseHandler;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.sharpP.SharpPDecoderHelper;
import com.tencent.sharpP.SharpPDecoderWrapper.SharpPFeatureWrapper;
import com.tencent.sharpP.SharpPUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DecodeImageTask
  extends ImageTask
{
  private static final int MAX_CROP_PIC_WIDTH = 500;
  private static final int MAX_CROP_TRY_TIME = 3;
  private static String TAG = DecodeImageTask.class.getSimpleName();
  private static ConcurrentHashMap<Integer, Integer> mImageKey2SampleSizeMap;
  private static ConcurrentHashMap<String, DecodeImageTask.ImageAttri> mImagePath2AttriMap = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, Integer> mImagePath2RotationMap = new ConcurrentHashMap();
  private static BaseHandler mMainHandler;
  private static int mObjectPoolSize = 0;
  private static DecodeImageTask sPool;
  private static final Object sPoolSync;
  private DecodeImageTask next = null;
  
  static
  {
    mImageKey2SampleSizeMap = new ConcurrentHashMap();
    mMainHandler = new BaseHandler(Looper.getMainLooper());
    sPool = null;
    sPoolSync = new Object();
  }
  
  protected DecodeImageTask(ImageKey paramImageKey)
  {
    super(paramImageKey);
  }
  
  protected DecodeImageTask(ImageTask paramImageTask)
  {
    super(paramImageTask);
  }
  
  public static void clearImageKey2SampleSizeMap()
  {
    mImageKey2SampleSizeMap.clear();
  }
  
  public static void clearImagePath2AttriMap()
  {
    mImagePath2AttriMap.clear();
  }
  
  public static void clearImagePath2RotationMap()
  {
    mImagePath2RotationMap.clear();
  }
  
  private boolean decodeAnimateWebp(ImageKey paramImageKey)
  {
    if ((paramImageKey == null) || (!AnimWebPHelper.isAnimWebpUrl(paramImageKey.url)) || (!AnimWebPHelper.isReady())) {
      return false;
    }
    Object localObject = AnimWebPHelper.bytesFromFile(paramImageKey.filePath);
    if ((localObject == null) || (!AnimWebPHelper.isAnimWebP((byte[])localObject))) {
      return false;
    }
    localObject = new AnimWebpImage((byte[])localObject);
    Drawable localDrawable = ((AnimWebpImage)localObject).getDrawable();
    if (localDrawable == null)
    {
      ImageManagerLog.e(TAG, "decodeWebp fail");
      if (paramImageKey.options != null) {
        paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 113);
      }
      setResult(9, new Object[0]);
      ImageTaskTracer.addImageDecodeFailedRecord(paramImageKey.hashCodeEx());
      ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
    }
    for (;;)
    {
      return true;
      int i = paramImageKey.hashCodeEx();
      ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, i, (Image)localObject, localDrawable, paramImageKey.options);
      setResult(8, new Object[] { localDrawable, null, paramImageKey.urlKey, Integer.valueOf(i), localObject, localDrawable });
      ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
      ImageTracer.endDecode(paramImageKey.url);
    }
  }
  
  private void decodeBounds(ImageKey paramImageKey, InputStream paramInputStream, DecodeImageTask.ImageAttri paramImageAttri, BitmapFactory.Options paramOptions)
  {
    paramOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, paramOptions);
    if (paramOptions.outMimeType != null) {}
    for (paramInputStream = paramOptions.outMimeType;; paramInputStream = "unknown")
    {
      paramImageAttri.mimeType = paramInputStream;
      paramImageAttri.srcHeight = paramOptions.outHeight;
      paramImageAttri.srcWidth = paramOptions.outWidth;
      mImagePath2AttriMap.put(paramImageKey.filePath, paramImageAttri);
      return;
    }
  }
  
  private boolean decodeGif(ImageKey paramImageKey, DecodeImageTask.ImageAttri paramImageAttri)
  {
    boolean bool1;
    if (ImageManagerEnv.g().isForceShutdownGif())
    {
      ImageManagerLog.w(TAG, "[decodeGif] force shutdown gif decode");
      bool1 = false;
      return bool1;
    }
    int i;
    NewGifImage localNewGifImage;
    if ((isGif(paramImageAttri.mimeType)) && (paramImageKey.options != null) && (paramImageKey.options.needShowGifAnimation))
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
        break label382;
      }
    }
    label379:
    label382:
    for (paramImageAttri = localNewGifImage.getDrawable();; paramImageAttri = null)
    {
      ImageManagerEnv.g().reportImageDecodingResMTA("gif_collect", "normal/gif");
      if (paramImageAttri != null)
      {
        if ((paramImageKey.options == null) || (!(paramImageKey.options.extraProcessor instanceof NewGifDrawableSpecifiedRegionProcessor))) {
          break label379;
        }
        paramImageAttri = paramImageKey.options.extraProcessor.doProcess(paramImageAttri);
      }
      for (;;)
      {
        i = paramImageKey.hashCodeEx();
        ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, i, localNewGifImage, paramImageAttri, paramImageKey.options);
        setResult(8, new Object[] { paramImageAttri, null, paramImageKey.urlKey, Integer.valueOf(i), localNewGifImage, paramImageAttri });
        ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
        for (;;)
        {
          return true;
          if ((!TextUtils.isEmpty(paramImageKey.filePath)) && (SharpPUtils.isSharpP(new File(paramImageKey.filePath))))
          {
            ImageManagerLog.e(TAG, "decodeGif url----" + paramImageKey.url + "   is not normal gif picture,try sharpP decode");
            boolean bool2 = handlerSharpPDecodeMessage(paramImageKey);
            bool1 = bool2;
            if (bool2) {
              break;
            }
            setResult(9, new Object[0]);
            return bool2;
          }
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
  
  private boolean decodeImageFrame(ImageKey paramImageKey)
  {
    if (PhotoGifDrawable.isPhotoGif(paramImageKey))
    {
      int i = paramImageKey.hashCodeEx();
      Object localObject = new PhotoGifImage(paramImageKey);
      Drawable localDrawable = ((PhotoGifImage)localObject).getDrawable();
      if (localDrawable != null)
      {
        ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, i, (Image)localObject, localDrawable, paramImageKey.options);
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
  
  private BitmapReference decodeImageStream(IDecoder paramIDecoder, FileInputStream paramFileInputStream, BitmapFactory.Options paramOptions, boolean paramBoolean)
  {
    if (paramFileInputStream == null) {
      return null;
    }
    if (paramIDecoder != null) {
      return paramIDecoder.decodeImage(paramFileInputStream, paramOptions);
    }
    ImageManagerLog.e(TAG, "decodeImageStream wtf decoder==null");
    return null;
  }
  
  private boolean decodeNormalImage(ImageKey paramImageKey, DecodeImageTask.ImageAttri paramImageAttri, FileInputStream paramFileInputStream, BitmapFactory.Options paramOptions)
  {
    boolean bool1 = true;
    int j = paramImageKey.hashCodeEx();
    if ((paramImageKey.options != null) && (!TextUtils.isEmpty(paramImageKey.filePath)) && (paramImageKey.options.isNeedPieceLoad))
    {
      paramImageKey.options.isNeedPieceLoad = RegionImageUtil.isValidRegionImageFormat(paramImageKey.filePath);
      ImageManagerLog.i(TAG, "decodeNormalImage Region decode file isValidRegionImageFormat with isNeedPieceLoad = " + paramImageKey.options.isNeedPieceLoad);
    }
    Object localObject1 = (Integer)mImageKey2SampleSizeMap.get(Integer.valueOf(j));
    int i;
    label166:
    label313:
    Object localObject2;
    if (localObject1 == null)
    {
      i = ImageOptionSampleSize.computeSampleSize(paramImageKey.options, paramImageAttri.srcWidth, paramImageAttri.srcHeight);
      mImageKey2SampleSizeMap.put(Integer.valueOf(j), Integer.valueOf(i));
      if ((paramImageKey.options == null) || (paramImageKey.options.imageConfig == null)) {
        break label645;
      }
      paramOptions.inPreferredConfig = paramImageKey.options.imageConfig;
      if ((i == 1) && (paramOptions.inPreferredConfig == Bitmap.Config.ARGB_8888))
      {
        float f = paramImageAttri.srcHeight / paramImageAttri.srcWidth;
        if (((f > 2.0F) || (f < 0.5F)) && (paramImageAttri.srcHeight * paramImageAttri.srcWidth > ImageManagerEnv.g().getScreenHeight() * ImageManagerEnv.g().getScreenWidth())) {
          paramOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        }
      }
      if (paramOptions.inPreferredConfig == Bitmap.Config.RGB_565) {
        paramOptions.inDither = true;
      }
      if ((paramImageKey.options != null) && ((paramImageKey.options.mImageType == 3) || (paramImageKey.options.mImageType == 4)))
      {
        if (paramImageKey.options.imageConfig == null) {
          break label677;
        }
        paramOptions.inPreferredConfig = paramImageKey.options.imageConfig;
      }
      if (paramImageKey != null)
      {
        paramImageKey.inSampleSize = i;
        paramImageKey.orgWidth = paramImageAttri.srcWidth;
        paramImageKey.orgHeight = paramImageAttri.srcHeight;
      }
      paramOptions.outWidth = paramImageAttri.srcWidth;
      paramOptions.outHeight = paramImageAttri.srcHeight;
      paramOptions.inPurgeable = true;
      paramOptions.inInputShareable = true;
      paramOptions.inSampleSize = i;
      paramOptions.outMimeType = paramImageAttri.mimeType;
      localObject2 = null;
      localObject1 = localObject2;
      if (paramImageKey.options != null)
      {
        localObject1 = localObject2;
        if (paramImageKey.options.cropHead) {
          localObject1 = decodePicCropHead(paramFileInputStream, paramImageKey.options.cropHwRation);
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder().append("decodeNormalImage: other mode ");
        if (paramImageKey.options != null) {
          break label728;
        }
        localObject1 = "null";
        label468:
        Log.i((String)localObject2, (String)localObject1);
        localObject2 = decodeImageStream(ImageManager.getInstance().getDecoder(), paramFileInputStream, paramOptions, false);
      }
      if ((localObject2 != null) || (TextUtils.isEmpty(paramImageKey.filePath)) || (!SharpPUtils.isSharpP(new File(paramImageKey.filePath)))) {
        break label769;
      }
      ImageManagerLog.e(TAG, "decodeNormalImage --url=" + paramImageKey.url + "  is not normal picture,try sharpP decode");
      boolean bool2 = handlerSharpPDecodeMessage(paramImageKey);
      bool1 = bool2;
      if (!bool2)
      {
        setResult(9, new Object[0]);
        ImageManagerLog.e(TAG, "decodeNormalImage -- url=" + paramImageKey.url + "  is not normal picture,try sharpP decode failed");
        bool1 = bool2;
      }
    }
    label645:
    label677:
    label728:
    do
    {
      return bool1;
      i = ((Integer)localObject1).intValue();
      break;
      if (isPng(paramImageAttri.mimeType))
      {
        paramOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        break label166;
      }
      paramOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      break label166;
      if ((paramImageAttri.srcWidth != 0) && (paramImageAttri.srcHeight != 0) && (paramImageAttri.srcWidth / paramImageAttri.srcHeight == 2.0F))
      {
        paramOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        break label313;
      }
      paramOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      break label313;
      localObject1 = paramImageKey.options.cropHead + " " + paramImageKey.options.cropHwRation;
      break label468;
      processBitmap((BitmapReference)localObject2, paramImageKey, j, true, paramImageAttri.mimeType);
    } while (localObject2 != null);
    label769:
    return false;
  }
  
  private BitmapReference decodePicCropHead(InputStream paramInputStream, float paramFloat)
  {
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder().append("decodePicCropHead: ").append(paramFloat).append(" ");
    if (paramInputStream == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject1, bool);
      if ((paramInputStream != null) && (paramFloat > 0.0F)) {
        break;
      }
      return null;
    }
    int i = 0;
    label73:
    if (i < 3) {}
    for (;;)
    {
      try
      {
        localObject1 = BitmapRegionDecoder.newInstance(paramInputStream, false);
        paramInputStream = (InputStream)localObject1;
        if (paramInputStream != null) {
          break label175;
        }
        return null;
      }
      catch (IOException localIOException)
      {
        Log.w(TAG, "decodePicCropHead: failed to get decoder " + i, localIOException);
        ImageManagerEnv.getLogger().w(TAG, new Object[] { "decodePicCropHead: failed to get decoder " + i, localIOException });
        i += 1;
      }
      break label73;
      label175:
      i = paramInputStream.getWidth();
      int j = paramInputStream.getHeight();
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = (i / 500 + 1);
      if (i * paramFloat > j) {
        return null;
      }
      localObject2 = new Rect(0, 0, i, (int)(i * paramFloat));
      i = 0;
      while (i < 3)
      {
        if (i == 1) {
          localOptions.inSampleSize *= 2;
        }
        try
        {
          BitmapReference localBitmapReference = BitmapReference.getBitmapReference(paramInputStream.decodeRegion((Rect)localObject2, localOptions));
          return localBitmapReference;
        }
        catch (Throwable localThrowable)
        {
          Log.w(TAG, "decodePicCropHead: failed to decode bitmap " + i, localThrowable);
          ImageManagerEnv.getLogger().w(TAG, new Object[] { "decodePicCropHead: failed to decode bitmap " + i, localThrowable });
          i += 1;
        }
      }
      break;
      paramInputStream = null;
    }
  }
  
  private boolean decodeSharpP(ImageKey paramImageKey)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (SharpPUtils.isSharpP(paramImageKey.url))
    {
      bool1 = bool2;
      if (paramImageKey.filePath != null)
      {
        ImageManagerLog.d(TAG, "decodeSharpP -- url: " + paramImageKey.url + " --is SharpP");
        bool1 = handlerSharpPDecodeMessage(paramImageKey);
        if ((!bool1) && (!SharpPUtils.isSharpP(new File(paramImageKey.filePath)))) {
          break label206;
        }
        if (!bool1)
        {
          ImageManager.getInstance().checkBitmapDecodeFailCount(paramImageKey);
          setResult(9, new Object[0]);
          ImageManagerLog.e(TAG, "decodeSharpP -- url: " + paramImageKey.url + " --  decode sharpp failed.");
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
    label206:
    ImageManagerLog.w(TAG, "decodeSharpP -- url: " + paramImageKey.url + " --is not really SharpP,so try normal decode");
    return false;
  }
  
  private boolean decodeVideoThumb(ImageKey paramImageKey)
  {
    boolean bool = false;
    if (VideoThumbnail.isVideo(paramImageKey.filePath))
    {
      int i = paramImageKey.hashCodeEx();
      processBitmap(VideoThumbnail.getThumb(ImageManagerEnv.getAppContext(), paramImageKey.filePath), paramImageKey, i, false, "");
      bool = true;
    }
    return bool;
  }
  
  public static Integer getImagePath2Rotation(String paramString)
  {
    if (paramString != null) {
      return (Integer)mImagePath2RotationMap.get(paramString);
    }
    return null;
  }
  
  /* Error */
  private void handlerImageDecodeMessage(ImageKey paramImageKey)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 250	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   5: invokevirtual 588	com/tencent/component/media/ImageManagerEnv:getCurrentLoadingImgStatus	()Z
    //   8: ifne +112 -> 120
    //   11: ldc_w 590
    //   14: new 318	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 592
    //   24: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: getfield 109	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   31: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 594
    //   37: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: getfield 122	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   44: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 549	com/tencent/component/media/utils/ImageManagerLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_1
    //   54: getfield 109	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   57: invokestatic 597	com/tencent/component/media/image/ImageTracer:startDecode	(Ljava/lang/String;)V
    //   60: iconst_3
    //   61: aload_1
    //   62: getfield 190	com/tencent/component/media/image/ImageKey:urlKey	Ljava/lang/String;
    //   65: invokestatic 603	com/tencent/component/media/image/ProgressTracer:print	(ILjava/lang/String;)V
    //   68: invokestatic 183	com/tencent/component/media/image/ImageManager:getInstance	()Lcom/tencent/component/media/image/ImageManager;
    //   71: aload_1
    //   72: invokevirtual 606	com/tencent/component/media/image/ImageManager:imageKeyFilePathCheck	(Lcom/tencent/component/media/image/ImageKey;)V
    //   75: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   78: lstore 5
    //   80: new 308	java/io/File
    //   83: dup
    //   84: aload_1
    //   85: getfield 122	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   88: invokespecial 310	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: astore 10
    //   93: lconst_0
    //   94: lstore_3
    //   95: aload_1
    //   96: getfield 122	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   99: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   102: ifne +9 -> 111
    //   105: aload 10
    //   107: invokevirtual 349	java/io/File:length	()J
    //   110: lstore_3
    //   111: aload_0
    //   112: aload_1
    //   113: invokespecial 608	com/tencent/component/media/image/DecodeImageTask:decodeVideoThumb	(Lcom/tencent/component/media/image/ImageKey;)Z
    //   116: ifeq +49 -> 165
    //   119: return
    //   120: ldc_w 610
    //   123: new 318	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   130: ldc_w 612
    //   133: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_1
    //   137: getfield 109	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   140: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 594
    //   146: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_1
    //   150: getfield 122	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   153: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 549	com/tencent/component/media/utils/ImageManagerLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: goto -109 -> 53
    //   165: aload_0
    //   166: aload_1
    //   167: invokespecial 614	com/tencent/component/media/image/DecodeImageTask:decodeSharpP	(Lcom/tencent/component/media/image/ImageKey;)Z
    //   170: ifeq +30 -> 200
    //   173: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   176: lstore 7
    //   178: invokestatic 250	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   181: ldc_w 559
    //   184: aload_1
    //   185: getfield 109	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   188: lload_3
    //   189: iconst_1
    //   190: lload 7
    //   192: lload 5
    //   194: lsub
    //   195: iconst_0
    //   196: invokevirtual 618	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   199: return
    //   200: aload_0
    //   201: aload_1
    //   202: invokespecial 620	com/tencent/component/media/image/DecodeImageTask:decodeImageFrame	(Lcom/tencent/component/media/image/ImageKey;)Z
    //   205: ifeq +30 -> 235
    //   208: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   211: lstore 7
    //   213: invokestatic 250	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   216: ldc_w 345
    //   219: aload_1
    //   220: getfield 109	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   223: lload_3
    //   224: iconst_1
    //   225: lload 7
    //   227: lload 5
    //   229: lsub
    //   230: iconst_0
    //   231: invokevirtual 618	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   234: return
    //   235: aload_0
    //   236: aload_1
    //   237: invokespecial 622	com/tencent/component/media/image/DecodeImageTask:decodeAnimateWebp	(Lcom/tencent/component/media/image/ImageKey;)Z
    //   240: ifne -121 -> 119
    //   243: getstatic 43	com/tencent/component/media/image/DecodeImageTask:mImagePath2AttriMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   246: aload_1
    //   247: getfield 122	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   250: invokevirtual 393	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   253: checkcast 221	com/tencent/component/media/image/DecodeImageTask$ImageAttri
    //   256: astore 15
    //   258: invokestatic 628	com/tencent/component/media/utils/BitmapUtils:getOptions	()Landroid/graphics/BitmapFactory$Options;
    //   261: astore 16
    //   263: aload 15
    //   265: ifnonnull +790 -> 1055
    //   268: new 221	com/tencent/component/media/image/DecodeImageTask$ImageAttri
    //   271: dup
    //   272: invokespecial 629	com/tencent/component/media/image/DecodeImageTask$ImageAttri:<init>	()V
    //   275: astore 15
    //   277: new 631	java/io/FileInputStream
    //   280: dup
    //   281: aload_1
    //   282: getfield 122	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   285: invokespecial 632	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   288: astore 10
    //   290: aload 10
    //   292: astore 11
    //   294: aload 10
    //   296: astore 12
    //   298: aload 10
    //   300: astore 13
    //   302: aload 10
    //   304: astore 14
    //   306: aload_0
    //   307: aload_1
    //   308: new 634	java/io/BufferedInputStream
    //   311: dup
    //   312: aload 10
    //   314: invokespecial 637	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   317: aload 15
    //   319: aload 16
    //   321: invokespecial 639	com/tencent/component/media/image/DecodeImageTask:decodeBounds	(Lcom/tencent/component/media/image/ImageKey;Ljava/io/InputStream;Lcom/tencent/component/media/image/DecodeImageTask$ImageAttri;Landroid/graphics/BitmapFactory$Options;)V
    //   324: aload 10
    //   326: astore 11
    //   328: aload 10
    //   330: astore 12
    //   332: aload 10
    //   334: astore 13
    //   336: aload 10
    //   338: astore 14
    //   340: aload_0
    //   341: aload_1
    //   342: aload 15
    //   344: invokespecial 641	com/tencent/component/media/image/DecodeImageTask:decodeGif	(Lcom/tencent/component/media/image/ImageKey;Lcom/tencent/component/media/image/DecodeImageTask$ImageAttri;)Z
    //   347: ifne +301 -> 648
    //   350: aload 10
    //   352: ifnonnull +146 -> 498
    //   355: aload 10
    //   357: astore 11
    //   359: aload 10
    //   361: astore 12
    //   363: aload 10
    //   365: astore 13
    //   367: aload 10
    //   369: astore 14
    //   371: new 631	java/io/FileInputStream
    //   374: dup
    //   375: aload_1
    //   376: getfield 122	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   379: invokespecial 632	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   382: astore 10
    //   384: aload 16
    //   386: iconst_0
    //   387: putfield 210	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   390: aload_0
    //   391: aload_1
    //   392: aload 15
    //   394: aload 10
    //   396: aload 16
    //   398: invokespecial 643	com/tencent/component/media/image/DecodeImageTask:decodeNormalImage	(Lcom/tencent/component/media/image/ImageKey;Lcom/tencent/component/media/image/DecodeImageTask$ImageAttri;Ljava/io/FileInputStream;Landroid/graphics/BitmapFactory$Options;)Z
    //   401: istore 9
    //   403: aload 10
    //   405: astore 11
    //   407: aload 15
    //   409: getfield 224	com/tencent/component/media/image/DecodeImageTask$ImageAttri:mimeType	Ljava/lang/String;
    //   412: astore 13
    //   414: aload 10
    //   416: astore 11
    //   418: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   421: lstore 7
    //   423: aload 10
    //   425: astore 11
    //   427: invokestatic 250	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   430: astore 12
    //   432: aload 10
    //   434: astore 11
    //   436: aload_1
    //   437: getfield 109	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   440: astore 14
    //   442: iload 9
    //   444: ifeq +210 -> 654
    //   447: aload 10
    //   449: astore 11
    //   451: aload 12
    //   453: aload 13
    //   455: aload 14
    //   457: lload_3
    //   458: iload 9
    //   460: lload 7
    //   462: lload 5
    //   464: lsub
    //   465: iload_2
    //   466: invokevirtual 618	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   469: iload 9
    //   471: ifne +14 -> 485
    //   474: aload 10
    //   476: astore 11
    //   478: invokestatic 183	com/tencent/component/media/image/ImageManager:getInstance	()Lcom/tencent/component/media/image/ImageManager;
    //   481: aload_1
    //   482: invokevirtual 552	com/tencent/component/media/image/ImageManager:checkBitmapDecodeFailCount	(Lcom/tencent/component/media/image/ImageKey;)V
    //   485: aload 10
    //   487: ifnull -368 -> 119
    //   490: aload 10
    //   492: invokevirtual 646	java/io/FileInputStream:close	()V
    //   495: return
    //   496: astore_1
    //   497: return
    //   498: aload 10
    //   500: astore 11
    //   502: aload 10
    //   504: astore 12
    //   506: aload 10
    //   508: astore 13
    //   510: aload 10
    //   512: astore 14
    //   514: aload_0
    //   515: aload 10
    //   517: invokespecial 650	com/tencent/component/media/image/DecodeImageTask:reset	(Ljava/io/FileInputStream;)V
    //   520: goto -136 -> 384
    //   523: astore 12
    //   525: aload 11
    //   527: astore 10
    //   529: ldc 242
    //   531: astore 13
    //   533: aload 10
    //   535: astore 11
    //   537: aload_1
    //   538: getfield 151	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   541: ifnull +20 -> 561
    //   544: aload 10
    //   546: astore 11
    //   548: aload_1
    //   549: getfield 151	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   552: aload_1
    //   553: bipush 110
    //   555: invokestatic 157	com/tencent/component/media/image/ImageManager:getErrorString	(Lcom/tencent/component/media/image/ImageKey;I)Ljava/lang/String;
    //   558: putfield 162	com/tencent/component/media/image/ImageLoader$Options:errCode	Ljava/lang/String;
    //   561: aload 10
    //   563: astore 11
    //   565: getstatic 36	com/tencent/component/media/image/DecodeImageTask:TAG	Ljava/lang/String;
    //   568: aload 12
    //   570: invokestatic 654	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   573: invokestatic 147	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   576: aload 10
    //   578: astore 11
    //   580: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   583: lstore 7
    //   585: aload 10
    //   587: astore 11
    //   589: invokestatic 250	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   592: aload 13
    //   594: aload_1
    //   595: getfield 109	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   598: lload_3
    //   599: iconst_0
    //   600: lload 7
    //   602: lload 5
    //   604: lsub
    //   605: iconst_3
    //   606: invokevirtual 618	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   609: aload 10
    //   611: astore 11
    //   613: invokestatic 250	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   616: aload 13
    //   618: aload_1
    //   619: getfield 109	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   622: lload_3
    //   623: ldc_w 350
    //   626: ldc_w 656
    //   629: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   632: invokevirtual 361	com/tencent/component/media/ImageManagerEnv:reportImageDecodingTask	(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;J)V
    //   635: aload 10
    //   637: ifnull -518 -> 119
    //   640: aload 10
    //   642: invokevirtual 646	java/io/FileInputStream:close	()V
    //   645: return
    //   646: astore_1
    //   647: return
    //   648: iconst_1
    //   649: istore 9
    //   651: goto -248 -> 403
    //   654: iconst_1
    //   655: istore_2
    //   656: goto -209 -> 447
    //   659: astore 12
    //   661: aconst_null
    //   662: astore 10
    //   664: ldc 242
    //   666: astore 13
    //   668: aload 10
    //   670: astore 11
    //   672: aload_1
    //   673: getfield 151	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   676: ifnull +20 -> 696
    //   679: aload 10
    //   681: astore 11
    //   683: aload_1
    //   684: getfield 151	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   687: aload_1
    //   688: bipush 111
    //   690: invokestatic 157	com/tencent/component/media/image/ImageManager:getErrorString	(Lcom/tencent/component/media/image/ImageKey;I)Ljava/lang/String;
    //   693: putfield 162	com/tencent/component/media/image/ImageLoader$Options:errCode	Ljava/lang/String;
    //   696: aload 10
    //   698: astore 11
    //   700: getstatic 36	com/tencent/component/media/image/DecodeImageTask:TAG	Ljava/lang/String;
    //   703: aload 12
    //   705: invokestatic 654	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   708: invokestatic 147	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   711: aload 10
    //   713: astore 11
    //   715: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   718: lstore 7
    //   720: aload 10
    //   722: astore 11
    //   724: invokestatic 250	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   727: aload 13
    //   729: aload_1
    //   730: getfield 109	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   733: lload_3
    //   734: iconst_0
    //   735: lload 7
    //   737: lload 5
    //   739: lsub
    //   740: iconst_2
    //   741: invokevirtual 618	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   744: aload 10
    //   746: astore 11
    //   748: invokestatic 250	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   751: aload 13
    //   753: aload_1
    //   754: getfield 109	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   757: lload_3
    //   758: ldc_w 350
    //   761: ldc_w 658
    //   764: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   767: invokevirtual 361	com/tencent/component/media/ImageManagerEnv:reportImageDecodingTask	(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;J)V
    //   770: aload 10
    //   772: ifnull -653 -> 119
    //   775: aload 10
    //   777: invokevirtual 646	java/io/FileInputStream:close	()V
    //   780: return
    //   781: astore_1
    //   782: return
    //   783: astore 12
    //   785: aconst_null
    //   786: astore 10
    //   788: ldc 242
    //   790: astore 13
    //   792: aload 10
    //   794: astore 11
    //   796: aload_1
    //   797: getfield 151	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   800: ifnull +20 -> 820
    //   803: aload 10
    //   805: astore 11
    //   807: aload_1
    //   808: getfield 151	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   811: aload_1
    //   812: bipush 112
    //   814: invokestatic 157	com/tencent/component/media/image/ImageManager:getErrorString	(Lcom/tencent/component/media/image/ImageKey;I)Ljava/lang/String;
    //   817: putfield 162	com/tencent/component/media/image/ImageLoader$Options:errCode	Ljava/lang/String;
    //   820: aload 10
    //   822: astore 11
    //   824: getstatic 36	com/tencent/component/media/image/DecodeImageTask:TAG	Ljava/lang/String;
    //   827: aload 12
    //   829: invokestatic 654	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   832: invokestatic 147	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   835: aload 10
    //   837: astore 11
    //   839: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   842: lstore 7
    //   844: aload 10
    //   846: astore 11
    //   848: invokestatic 250	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   851: aload 13
    //   853: aload_1
    //   854: getfield 109	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   857: lload_3
    //   858: iconst_0
    //   859: lload 7
    //   861: lload 5
    //   863: lsub
    //   864: iconst_4
    //   865: invokevirtual 618	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   868: aload 10
    //   870: astore 11
    //   872: invokestatic 250	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   875: aload 13
    //   877: aload_1
    //   878: getfield 109	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   881: lload_3
    //   882: ldc_w 350
    //   885: ldc_w 660
    //   888: invokestatic 357	java/lang/System:currentTimeMillis	()J
    //   891: invokevirtual 361	com/tencent/component/media/ImageManagerEnv:reportImageDecodingTask	(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;J)V
    //   894: aload 10
    //   896: ifnull -777 -> 119
    //   899: aload 10
    //   901: invokevirtual 646	java/io/FileInputStream:close	()V
    //   904: return
    //   905: astore_1
    //   906: return
    //   907: astore_1
    //   908: aconst_null
    //   909: astore 11
    //   911: aload 11
    //   913: ifnull +8 -> 921
    //   916: aload 11
    //   918: invokevirtual 646	java/io/FileInputStream:close	()V
    //   921: aload_1
    //   922: athrow
    //   923: astore 10
    //   925: goto -4 -> 921
    //   928: astore_1
    //   929: aload 12
    //   931: astore 11
    //   933: goto -22 -> 911
    //   936: astore_1
    //   937: aload 10
    //   939: astore 11
    //   941: goto -30 -> 911
    //   944: astore_1
    //   945: goto -34 -> 911
    //   948: astore 12
    //   950: aload 13
    //   952: astore 10
    //   954: ldc 242
    //   956: astore 13
    //   958: goto -166 -> 792
    //   961: astore 12
    //   963: ldc 242
    //   965: astore 13
    //   967: goto -175 -> 792
    //   970: astore 12
    //   972: ldc 242
    //   974: astore 13
    //   976: goto -184 -> 792
    //   979: astore 12
    //   981: goto -189 -> 792
    //   984: astore 12
    //   986: aload 14
    //   988: astore 10
    //   990: ldc 242
    //   992: astore 13
    //   994: goto -326 -> 668
    //   997: astore 12
    //   999: ldc 242
    //   1001: astore 13
    //   1003: goto -335 -> 668
    //   1006: astore 12
    //   1008: ldc 242
    //   1010: astore 13
    //   1012: goto -344 -> 668
    //   1015: astore 12
    //   1017: goto -349 -> 668
    //   1020: astore 12
    //   1022: aconst_null
    //   1023: astore 10
    //   1025: ldc 242
    //   1027: astore 13
    //   1029: goto -496 -> 533
    //   1032: astore 12
    //   1034: ldc 242
    //   1036: astore 13
    //   1038: goto -505 -> 533
    //   1041: astore 12
    //   1043: ldc 242
    //   1045: astore 13
    //   1047: goto -514 -> 533
    //   1050: astore 12
    //   1052: goto -519 -> 533
    //   1055: aconst_null
    //   1056: astore 10
    //   1058: goto -734 -> 324
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1061	0	this	DecodeImageTask
    //   0	1061	1	paramImageKey	ImageKey
    //   1	655	2	i	int
    //   94	788	3	l1	long
    //   78	784	5	l2	long
    //   176	684	7	l3	long
    //   401	249	9	bool	boolean
    //   91	809	10	localObject1	Object
    //   923	15	10	localIOException	IOException
    //   952	105	10	localObject2	Object
    //   292	648	11	localObject3	Object
    //   296	209	12	localObject4	Object
    //   523	46	12	localException1	java.lang.Exception
    //   659	45	12	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   783	147	12	localThrowable1	Throwable
    //   948	1	12	localThrowable2	Throwable
    //   961	1	12	localThrowable3	Throwable
    //   970	1	12	localThrowable4	Throwable
    //   979	1	12	localThrowable5	Throwable
    //   984	1	12	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   997	1	12	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1006	1	12	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1015	1	12	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   1020	1	12	localException2	java.lang.Exception
    //   1032	1	12	localException3	java.lang.Exception
    //   1041	1	12	localException4	java.lang.Exception
    //   1050	1	12	localException5	java.lang.Exception
    //   300	746	13	localObject5	Object
    //   304	683	14	localObject6	Object
    //   256	152	15	localImageAttri	DecodeImageTask.ImageAttri
    //   261	136	16	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   490	495	496	java/io/IOException
    //   306	324	523	java/lang/Exception
    //   340	350	523	java/lang/Exception
    //   371	384	523	java/lang/Exception
    //   514	520	523	java/lang/Exception
    //   640	645	646	java/io/IOException
    //   258	263	659	java/lang/OutOfMemoryError
    //   268	290	659	java/lang/OutOfMemoryError
    //   775	780	781	java/io/IOException
    //   258	263	783	java/lang/Throwable
    //   268	290	783	java/lang/Throwable
    //   899	904	905	java/io/IOException
    //   258	263	907	finally
    //   268	290	907	finally
    //   916	921	923	java/io/IOException
    //   306	324	928	finally
    //   340	350	928	finally
    //   371	384	928	finally
    //   514	520	928	finally
    //   384	403	936	finally
    //   407	414	944	finally
    //   418	423	944	finally
    //   427	432	944	finally
    //   436	442	944	finally
    //   451	469	944	finally
    //   478	485	944	finally
    //   537	544	944	finally
    //   548	561	944	finally
    //   565	576	944	finally
    //   580	585	944	finally
    //   589	609	944	finally
    //   613	635	944	finally
    //   672	679	944	finally
    //   683	696	944	finally
    //   700	711	944	finally
    //   715	720	944	finally
    //   724	744	944	finally
    //   748	770	944	finally
    //   796	803	944	finally
    //   807	820	944	finally
    //   824	835	944	finally
    //   839	844	944	finally
    //   848	868	944	finally
    //   872	894	944	finally
    //   306	324	948	java/lang/Throwable
    //   340	350	948	java/lang/Throwable
    //   371	384	948	java/lang/Throwable
    //   514	520	948	java/lang/Throwable
    //   384	403	961	java/lang/Throwable
    //   407	414	970	java/lang/Throwable
    //   418	423	979	java/lang/Throwable
    //   427	432	979	java/lang/Throwable
    //   436	442	979	java/lang/Throwable
    //   451	469	979	java/lang/Throwable
    //   478	485	979	java/lang/Throwable
    //   306	324	984	java/lang/OutOfMemoryError
    //   340	350	984	java/lang/OutOfMemoryError
    //   371	384	984	java/lang/OutOfMemoryError
    //   514	520	984	java/lang/OutOfMemoryError
    //   384	403	997	java/lang/OutOfMemoryError
    //   407	414	1006	java/lang/OutOfMemoryError
    //   418	423	1015	java/lang/OutOfMemoryError
    //   427	432	1015	java/lang/OutOfMemoryError
    //   436	442	1015	java/lang/OutOfMemoryError
    //   451	469	1015	java/lang/OutOfMemoryError
    //   478	485	1015	java/lang/OutOfMemoryError
    //   258	263	1020	java/lang/Exception
    //   268	290	1020	java/lang/Exception
    //   384	403	1032	java/lang/Exception
    //   407	414	1041	java/lang/Exception
    //   418	423	1050	java/lang/Exception
    //   427	432	1050	java/lang/Exception
    //   436	442	1050	java/lang/Exception
    //   451	469	1050	java/lang/Exception
    //   478	485	1050	java/lang/Exception
  }
  
  private boolean handlerSharpPDecodeMessage(ImageKey paramImageKey)
  {
    int j = paramImageKey.hashCodeEx();
    SharpPDecoderHelper localSharpPDecoderHelper = new SharpPDecoderHelper(paramImageKey.filePath);
    int i = localSharpPDecoderHelper.parseHeader();
    if (i != 0)
    {
      ImageManagerLog.w(TAG, "parseHeader error,status=" + i + "," + paramImageKey.url + ",hashCode=" + paramImageKey.hashCodeEx() + ",filePath=" + paramImageKey.filePath + ", try again");
      return false;
    }
    DecodeImageTask.ImageAttri localImageAttri = (DecodeImageTask.ImageAttri)mImagePath2AttriMap.get(paramImageKey.filePath);
    Object localObject2 = localSharpPDecoderHelper.getFeatureInfo();
    Object localObject1;
    if ((localImageAttri == null) || (localImageAttri.mimeType.equals("unknown")))
    {
      localImageAttri = new DecodeImageTask.ImageAttri();
      localImageAttri.srcHeight = ((SharpPDecoderWrapper.SharpPFeatureWrapper)localObject2).getHeight();
      localImageAttri.srcWidth = ((SharpPDecoderWrapper.SharpPFeatureWrapper)localObject2).getWidth();
      localObject1 = localSharpPDecoderHelper.getMimeType();
      if (localObject1 != null)
      {
        localImageAttri.mimeType = ((String)localObject1);
        mImagePath2AttriMap.put(paramImageKey.filePath, localImageAttri);
      }
    }
    for (;;)
    {
      localObject1 = (Integer)mImageKey2SampleSizeMap.get(Integer.valueOf(j));
      int k = ((SharpPDecoderWrapper.SharpPFeatureWrapper)localObject2).getWidth();
      int m = ((SharpPDecoderWrapper.SharpPFeatureWrapper)localObject2).getHeight();
      if ((paramImageKey.options != null) && (!TextUtils.isEmpty(paramImageKey.filePath)) && (paramImageKey.options.isNeedPieceLoad))
      {
        paramImageKey.options.isNeedPieceLoad = RegionImageUtil.isValidRegionImageFormat(paramImageKey.filePath);
        ImageManagerLog.i(TAG, "handlerSharpPDecodeMessage Region decode file isValidRegionImageFormat with isNeedPieceLoad = " + paramImageKey.options.isNeedPieceLoad);
      }
      if (localObject1 == null)
      {
        i = ImageOptionSampleSize.computeSampleSize(paramImageKey.options, k, m);
        mImageKey2SampleSizeMap.put(Integer.valueOf(j), Integer.valueOf(i));
        label339:
        if ((!isGif(localImageAttri.mimeType)) || (paramImageKey.options == null) || (!paramImageKey.options.needShowGifAnimation)) {
          break label615;
        }
        ImageManagerLog.d(TAG, "handlerSharpPDecodeMessage -- url: " + paramImageKey.url + " --is sharp gif：" + localImageAttri.mimeType);
        localObject2 = new NewGifImage(paramImageKey.filePath, k, m, i, paramImageKey.url);
        if (localObject2 == null) {
          break label967;
        }
      }
      label779:
      label927:
      label944:
      label964:
      label967:
      for (localObject1 = ((NewGifImage)localObject2).getDrawable();; localObject1 = null)
      {
        ImageManagerEnv.g().reportImageDecodingResMTA("gif_collect", "sharp/gif");
        if (localObject1 != null)
        {
          if ((paramImageKey.options.extraProcessor == null) || (!(paramImageKey.options.extraProcessor instanceof NewGifDrawableSpecifiedRegionProcessor))) {
            break label964;
          }
          localObject1 = paramImageKey.options.extraProcessor.doProcess((Drawable)localObject1);
        }
        for (;;)
        {
          ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, j, (Image)localObject2, (Drawable)localObject1, paramImageKey.options);
          setResult(8, new Object[] { localObject1, null, paramImageKey.urlKey, Integer.valueOf(j), localObject2, localObject1 });
          ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
          ImageTracer.endDecode(paramImageKey.url);
          return true;
          localObject1 = "unknown";
          break;
          i = ((Integer)localObject1).intValue();
          break label339;
          if (paramImageKey.options != null) {
            paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 103);
          }
          return false;
          label615:
          localObject1 = Bitmap.Config.ARGB_8888;
          int n;
          int i1;
          if ((paramImageKey.options != null) && (paramImageKey.options.imageConfig != null))
          {
            localObject1 = paramImageKey.options.imageConfig;
            localObject2 = localObject1;
            if (i == 1)
            {
              localObject2 = localObject1;
              if (localObject1 == Bitmap.Config.ARGB_8888)
              {
                float f = m / k;
                if (f <= 2.0F)
                {
                  localObject2 = localObject1;
                  if (f >= 0.5F) {}
                }
                else
                {
                  localObject2 = localObject1;
                  if (m * k > ImageManagerEnv.g().getScreenHeight() * ImageManagerEnv.g().getScreenWidth()) {
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
                  break label890;
                }
                localObject1 = paramImageKey.options.imageConfig;
              }
            }
            n = k / i;
            i1 = m / i;
            if (paramImageKey != null)
            {
              paramImageKey.inSampleSize = i;
              paramImageKey.orgWidth = k;
              paramImageKey.orgHeight = m;
            }
            if (!SharpPUtils.isJpg(localImageAttri.mimeType)) {
              break label927;
            }
          }
          for (localObject1 = localSharpPDecoderHelper.decodeSharpP2JPG(n, i1, (Bitmap.Config)localObject1);; localObject1 = localSharpPDecoderHelper.decodeSharpP2PNG(n, i1, Bitmap.Config.ARGB_8888))
          {
            if (localObject1 != null) {
              break label944;
            }
            if (paramImageKey.options != null) {
              paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 104);
            }
            return false;
            if (SharpPUtils.isJpg(localImageAttri.mimeType))
            {
              localObject1 = Bitmap.Config.RGB_565;
              break;
            }
            localObject1 = Bitmap.Config.ARGB_8888;
            break;
            label890:
            if ((k != 0) && (m != 0) && (k / m == 2.0F))
            {
              localObject1 = Bitmap.Config.RGB_565;
              break label779;
            }
            localObject1 = Bitmap.Config.ARGB_8888;
            break label779;
          }
          processBitmap(BitmapReference.getBitmapReference((Bitmap)localObject1), paramImageKey, j, true, localImageAttri.mimeType);
          return true;
        }
      }
    }
  }
  
  private static boolean isAvatarUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("avatar://");
  }
  
  private static boolean isGif(String paramString)
  {
    return "image/gif".equalsIgnoreCase(paramString);
  }
  
  private static boolean isPng(String paramString)
  {
    return "image/png".equalsIgnoreCase(paramString);
  }
  
  private static boolean needTryScaleDrawable(Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    int k = ImageManagerEnv.g().getScreenWidth() - (int)(ImageManagerEnv.g().getDesity() * 4.0F);
    int m = ImageManagerEnv.g().getScreenHeight() - (int)(ImageManagerEnv.g().getDesity() * 4.0F);
    ImageManagerLog.w(TAG, "super resolution. needTryScaleDrawable: width=" + i + " screenWidth=" + k + " height=" + j + " screenHeight=" + m);
    return (i > k) || (j > m);
  }
  
  public static DecodeImageTask obtain(ImageKey paramImageKey)
  {
    if (needRecycle) {}
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        DecodeImageTask localDecodeImageTask = sPool;
        sPool = sPool.next;
        localDecodeImageTask.next = null;
        mObjectPoolSize -= 1;
        localDecodeImageTask.setImageKey(paramImageKey);
        return localDecodeImageTask;
      }
      return new DecodeImageTask(paramImageKey);
    }
  }
  
  public static DecodeImageTask obtain(ImageTask paramImageTask)
  {
    if (needRecycle) {}
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        DecodeImageTask localDecodeImageTask = sPool;
        sPool = sPool.next;
        localDecodeImageTask.next = null;
        mObjectPoolSize -= 1;
        localDecodeImageTask.setImageTask(paramImageTask);
        return localDecodeImageTask;
      }
      return new DecodeImageTask(paramImageTask);
    }
  }
  
  private void processBitmap(BitmapReference paramBitmapReference, ImageKey paramImageKey, int paramInt, boolean paramBoolean, String paramString)
  {
    Object localObject;
    int j;
    int k;
    int i;
    if (paramBitmapReference != null)
    {
      ImageManager.getInstance().updateLruFile(paramImageKey);
      localObject = paramBitmapReference;
      if (paramBoolean) {
        localObject = BitmapUtils.processExif(paramBitmapReference, paramImageKey.filePath, paramString);
      }
      localObject = processImage((BitmapReference)localObject, paramImageKey.options);
      j = -1;
      k = -1;
      if (paramImageKey.options != null)
      {
        j = paramImageKey.options.clipWidth;
        k = paramImageKey.options.clipHeight;
      }
      if ((!paramImageKey.needSuperResolution) || (!ImageManagerEnv.g().enableSuperResolution()) || (paramImageKey.url == null) || (!paramImageKey.url.contains("sce="))) {
        break label950;
      }
      if ((ImageManagerEnv.g().checkShouldRunSuperResolutionBenchmark()) && (ImageManagerEnv.g().needRerunSuperResolutionBenchmark(paramImageKey.url))) {
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
        paramString = new BitmapImageDrawable((BitmapImage)localObject, j, k);
        paramBitmapReference = paramString;
        if (ImageManagerEnv.g().isHighScaleUrl(paramImageKey.url))
        {
          ImageManagerLog.w(TAG, "super resolution. check high scale not process. url=" + paramImageKey.url);
          paramBitmapReference = paramString;
          if (needTryScaleDrawable(paramString)) {
            paramBitmapReference = scaleLargeDrawable(paramString);
          }
        }
        paramImageKey.options.extraProcessor.setImageKey(paramImageKey);
        paramBitmapReference = paramImageKey.options.extraProcessor.doProcess(paramBitmapReference);
        if ((paramBitmapReference instanceof SpecifiedBitmapDrawable))
        {
          paramString = ((SpecifiedBitmapDrawable)paramBitmapReference).getBitmapRef();
          ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, paramInt, new FeedsBitmapImage(paramString), paramBitmapReference, paramImageKey.options);
          setResult(8, new Object[] { paramBitmapReference, paramString, paramImageKey.urlKey, Integer.valueOf(paramInt), new FeedsBitmapImage(paramString), paramBitmapReference });
          ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
          label367:
          ImageTracer.endDecode(paramImageKey.url);
        }
      }
      for (;;)
      {
        if ((i == 0) && (ImageManagerEnv.g().enableReportNoneSuperResolutionTime()) && (ImageManagerEnv.g().isBigUrl(paramImageKey.url)))
        {
          ImageTracer.reportDecodeTime(paramImageKey.url, false);
          ImageTracer.reportDownloadTime(paramImageKey.url, false);
        }
        return;
        if (!ImageManagerEnv.g().needSuperResolution(paramImageKey.url)) {
          break label950;
        }
        i = ((BitmapImage)localObject).getBitmap().getWidth();
        int m = ((BitmapImage)localObject).getBitmap().getHeight();
        ImageManagerLog.d(TAG, "super resolution. width=" + i + " height=" + m + " url=" + paramImageKey.url);
        if (!ImageManagerEnv.g().canDoSuperResolution(i, m)) {
          break label950;
        }
        paramBitmapReference = ((BitmapImage)localObject).getBitmap().getBitmap();
        ImageTracer.requestSuperResolution(paramImageKey.url);
        ProgressTracer.print(7, paramImageKey.urlKey);
        ImageManager.getSuperResolutionHandler().postAtFrontOfQueue(new DecodeImageTask.1(this, paramImageKey, paramBitmapReference, j, k, paramInt));
        i = 1;
        break;
        if ((paramBitmapReference instanceof RegionDrawable))
        {
          paramString = ((RegionDrawable)paramBitmapReference).getBitmapRef();
          ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, paramInt, (Image)localObject, paramBitmapReference, paramImageKey.options);
          setResult(8, new Object[] { paramBitmapReference, paramString, paramImageKey.urlKey, Integer.valueOf(paramInt), localObject, paramBitmapReference });
          ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
          break label367;
        }
        paramString = ((BitmapImage)localObject).getBitmap();
        ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, paramInt, (Image)localObject, paramBitmapReference, paramImageKey.options);
        setResult(8, new Object[] { paramBitmapReference, paramString, paramImageKey.urlKey, Integer.valueOf(paramInt), localObject, paramBitmapReference });
        ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
        break label367;
        paramBitmapReference = new SpecifiedBitmapDrawable(((BitmapImage)localObject).getBitmap());
        ImageTracer.endDecode(paramImageKey.url);
        ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, paramInt, (Image)localObject, paramBitmapReference, paramImageKey.options);
        setResult(8, new Object[] { paramBitmapReference, ((BitmapImage)localObject).getBitmap(), paramImageKey.urlKey, Integer.valueOf(paramInt), localObject, paramBitmapReference });
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
        ImageManagerLog.w(TAG, "processBitmap, bm is null, url=" + paramImageKey.url + ", file length=" + paramBitmapReference.length());
      }
      ImageTaskTracer.addImageDecodeFailedRecord(paramImageKey.hashCodeEx());
      ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
      return;
      label950:
      i = 0;
    }
  }
  
  private static BitmapImage processImage(BitmapReference paramBitmapReference, ImageLoader.Options paramOptions)
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
  
  public static void putImagePath2Rotation(String paramString, int paramInt)
  {
    mImagePath2RotationMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  private void reset(FileInputStream paramFileInputStream)
  {
    paramFileInputStream = paramFileInputStream.getChannel();
    paramFileInputStream.position();
    paramFileInputStream.position(0L);
  }
  
  private static Drawable scaleLargeDrawable(Drawable paramDrawable)
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
  
  public void excuteTask()
  {
    Object localObject = ImageManager.getInstance().getDrawbleFromCache(this.mImageKey);
    if (localObject != null)
    {
      setResult(11, new Object[] { localObject });
      return;
    }
    ImageManager.getInstance().imageKeyFilePathCheck(this.mImageKey);
    localObject = new File(this.mImageKey.filePath);
    SharpPUtils.deleteSharppCacheFileIfNessary((File)localObject, this.mImageKey.url);
    SharpPUtils.checkNotSharppCacheFileIfNessary((File)localObject, this.mImageKey.url);
    if (((File)localObject).exists())
    {
      ImageManager.getInstance().traceImageFile(true);
      if (!ImageManagerEnv.g().getCurrentLoadingImgStatus())
      {
        ImageTaskManager.getInstance().addWaitToDecodeImageTask(this);
        return;
      }
      startDecodeTask();
      return;
    }
    ImageManager.getInstance().traceImageFile(false);
    if ((this.mImageKey != null) && (this.mImageKey.options != null) && (this.mImageKey.options.mImageType == 2))
    {
      ImageTaskBuilder.stampMap.put(this.mImageKey.url, Long.valueOf(System.currentTimeMillis()));
      ImageManagerLog.w(TAG, "no file hashCodeEx:" + this.mImageKey.hashCodeEx() + " isGifPlayWhileDownloading:" + this.mImageKey.options.isGifPlayWhileDownloading);
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
      ImageManager.getInstance().imageKeyFilePathCheck(this.mImageKey);
      if ((isAvatarUrl(this.mImageKey.url)) && (paramVarArgs[1] != null)) {
        this.mImageKey.filePath = paramVarArgs[1].toString();
      }
      paramVarArgs = new File(this.mImageKey.filePath);
      if (paramVarArgs.exists())
      {
        if (!ImageManagerEnv.g().getCurrentLoadingImgStatus())
        {
          ImageTaskManager.getInstance().addWaitToDecodeImageTask(this);
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
    ImageManagerLog.w(TAG, "onResult, download success, file does not exist!, url=" + this.mImageKey.url + ", file length=" + paramVarArgs.length());
  }
  
  public void recycle()
  {
    if (!needRecycle) {
      return;
    }
    reset();
    synchronized (sPoolSync)
    {
      if (mObjectPoolSize < 50)
      {
        this.next = sPool;
        sPool = this;
        mObjectPoolSize += 1;
      }
      return;
    }
  }
  
  public void startDecodeTask()
  {
    if (this.mImageKey != null) {
      ImageTaskTracer.addImageDecodeThreadPendingRecord(this.mImageKey.hashCodeEx());
    }
    DecodeImageTask.DecodeTask localDecodeTask = new DecodeImageTask.DecodeTask(this, this.mImageKey);
    if ((this.mImageKey != null) && (this.mImageKey.options != null) && (this.mImageKey.options.priority)) {}
    for (boolean bool = true;; bool = false)
    {
      ImageManager.post(localDecodeTask, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.DecodeImageTask
 * JD-Core Version:    0.7.0.1
 */