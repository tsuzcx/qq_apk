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
import java.util.concurrent.TimeUnit;

public class DecodeImageTask
  extends ImageTask
{
  private static final int MAX_CROP_PIC_WIDTH = 500;
  private static final int MAX_CROP_TRY_TIME = 3;
  private static final long MIN_LOG_DECODE_COST = TimeUnit.SECONDS.toNanos(2L);
  private static String TAG = "DecodeImageTask";
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
    if ((paramImageKey != null) && (AnimWebPHelper.isAnimWebpUrl(paramImageKey.url)))
    {
      if (!AnimWebPHelper.isReady()) {
        return false;
      }
      Object localObject = AnimWebPHelper.bytesFromFile(paramImageKey.filePath);
      if (localObject != null)
      {
        if (!AnimWebPHelper.isAnimWebP((byte[])localObject)) {
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
          return true;
        }
        int i = paramImageKey.hashCodeEx();
        ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, i, (Image)localObject, localDrawable, paramImageKey.options);
        setResult(8, new Object[] { localDrawable, null, paramImageKey.urlKey, Integer.valueOf(i), localObject, localDrawable });
        ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
        ImageTracer.endDecode(paramImageKey.url);
        return true;
      }
    }
    return false;
  }
  
  private void decodeBounds(ImageKey paramImageKey, InputStream paramInputStream, DecodeImageTask.ImageAttri paramImageAttri, BitmapFactory.Options paramOptions)
  {
    paramOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, paramOptions);
    if (paramOptions.outMimeType != null) {
      paramInputStream = paramOptions.outMimeType;
    } else {
      paramInputStream = "unknown";
    }
    paramImageAttri.mimeType = paramInputStream;
    paramImageAttri.srcHeight = paramOptions.outHeight;
    paramImageAttri.srcWidth = paramOptions.outWidth;
    mImagePath2AttriMap.put(paramImageKey.filePath, paramImageAttri);
  }
  
  private boolean decodeGif(ImageKey paramImageKey, DecodeImageTask.ImageAttri paramImageAttri)
  {
    if (ImageManagerEnv.g().isForceShutdownGif())
    {
      ImageManagerLog.w(TAG, "[decodeGif] force shutdown gif decode");
      return false;
    }
    if ((isGif(paramImageAttri.mimeType)) && (paramImageKey.options != null) && (paramImageKey.options.needShowGifAnimation))
    {
      int j = paramImageKey.options.clipWidth;
      int k = paramImageKey.options.clipHeight;
      int i;
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
      NewGifImage localNewGifImage = new NewGifImage(paramImageKey, j, i);
      Object localObject = localNewGifImage.getDrawable();
      ImageManagerEnv.g().reportImageDecodingResMTA("gif_collect", "normal/gif");
      if (localObject != null)
      {
        paramImageAttri = (DecodeImageTask.ImageAttri)localObject;
        if (paramImageKey.options != null)
        {
          paramImageAttri = (DecodeImageTask.ImageAttri)localObject;
          if ((paramImageKey.options.extraProcessor instanceof NewGifDrawableSpecifiedRegionProcessor)) {
            paramImageAttri = paramImageKey.options.extraProcessor.doProcess((Drawable)localObject);
          }
        }
        i = paramImageKey.hashCodeEx();
        ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, i, localNewGifImage, paramImageAttri, paramImageKey.options);
        setResult(8, new Object[] { paramImageAttri, null, paramImageKey.urlKey, Integer.valueOf(i), localNewGifImage, paramImageAttri });
        ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
        return true;
      }
      if ((!TextUtils.isEmpty(paramImageKey.filePath)) && (SharpPUtils.isSharpP(new File(paramImageKey.filePath))))
      {
        paramImageAttri = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decodeGif url----");
        ((StringBuilder)localObject).append(paramImageKey.url);
        ((StringBuilder)localObject).append("   is not normal gif picture,try sharpP decode");
        ImageManagerLog.e(paramImageAttri, ((StringBuilder)localObject).toString());
        boolean bool = handlerSharpPDecodeMessage(paramImageKey);
        if (!bool) {
          setResult(9, new Object[0]);
        }
        return bool;
      }
      if (paramImageKey.options != null) {
        paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 107);
      }
      setResult(9, new Object[0]);
      ImageTaskTracer.addImageDecodeFailedRecord(paramImageKey.hashCodeEx());
      ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
      return true;
    }
    return false;
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
        return true;
      }
      if ((paramImageKey != null) && (paramImageKey.options != null)) {
        paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 106);
      }
      setResult(9, new Object[0]);
      localObject = new File(paramImageKey.filePath);
      ImageManagerEnv.g().reportImageDecodingTask("image/photogif", paramImageKey.url, ((File)localObject).length(), 51000, "decode gif failed, gif drawable is null", System.currentTimeMillis());
      return true;
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
    long l = System.nanoTime();
    int j = paramImageKey.hashCodeEx();
    if ((paramImageKey.options != null) && (!TextUtils.isEmpty(paramImageKey.filePath)) && (paramImageKey.options.isNeedPieceLoad))
    {
      paramImageKey.options.isNeedPieceLoad = RegionImageUtil.isValidRegionImageFormat(paramImageKey.filePath);
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("decodeNormalImage Region decode file isValidRegionImageFormat with isNeedPieceLoad = ");
      ((StringBuilder)localObject2).append(paramImageKey.options.isNeedPieceLoad);
      ImageManagerLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = (Integer)mImageKey2SampleSizeMap.get(Integer.valueOf(j));
    int i;
    if (localObject1 == null)
    {
      i = ImageOptionSampleSize.computeSampleSize(paramImageKey.options, paramImageAttri.srcWidth, paramImageAttri.srcHeight);
      mImageKey2SampleSizeMap.put(Integer.valueOf(j), Integer.valueOf(i));
    }
    else
    {
      i = ((Integer)localObject1).intValue();
    }
    if ((paramImageKey.options != null) && (paramImageKey.options.imageConfig != null)) {
      paramOptions.inPreferredConfig = paramImageKey.options.imageConfig;
    } else if (isPng(paramImageAttri.mimeType)) {
      paramOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    } else {
      paramOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    }
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
    if ((paramImageKey.options != null) && ((paramImageKey.options.mImageType == 3) || (paramImageKey.options.mImageType == 4))) {
      if (paramImageKey.options.imageConfig != null) {
        paramOptions.inPreferredConfig = paramImageKey.options.imageConfig;
      } else if ((paramImageAttri.srcWidth != 0) && (paramImageAttri.srcHeight != 0) && (paramImageAttri.srcWidth / paramImageAttri.srcHeight == 2.0F)) {
        paramOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      } else {
        paramOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      }
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
    Object localObject2 = null;
    localObject1 = localObject2;
    if (paramImageKey.options != null)
    {
      localObject1 = localObject2;
      if (paramImageKey.options.cropHead) {
        localObject1 = decodePicCropHead(paramFileInputStream, paramImageKey.options.cropHwRation);
      }
    }
    if (localObject1 == null)
    {
      localObject2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeNormalImage: other mode ");
      if (paramImageKey.options == null)
      {
        localObject1 = "null";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramImageKey.options.cropHead);
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(paramImageKey.options.cropHwRation);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localStringBuilder.append((String)localObject1);
      ImageManagerLog.i((String)localObject2, localStringBuilder.toString());
      paramFileInputStream = decodeImageStream(ImageManager.getInstance().getDecoder(), paramFileInputStream, paramOptions, false);
    }
    else
    {
      paramFileInputStream = (FileInputStream)localObject1;
    }
    if ((paramFileInputStream == null) && (!TextUtils.isEmpty(paramImageKey.filePath)) && (SharpPUtils.isSharpP(new File(paramImageKey.filePath))))
    {
      paramImageAttri = TAG;
      paramFileInputStream = new StringBuilder();
      paramFileInputStream.append("decodeNormalImage --url=");
      paramFileInputStream.append(paramImageKey.url);
      paramFileInputStream.append("  is not normal picture,try sharpP decode");
      ImageManagerLog.e(paramImageAttri, paramFileInputStream.toString());
      boolean bool = handlerSharpPDecodeMessage(paramImageKey);
      if (!bool)
      {
        setResult(9, new Object[0]);
        paramImageAttri = TAG;
        paramFileInputStream = new StringBuilder();
        paramFileInputStream.append("decodeNormalImage -- url=");
        paramFileInputStream.append(paramImageKey.url);
        paramFileInputStream.append("  is not normal picture,try sharpP decode failed");
        ImageManagerLog.e(paramImageAttri, paramFileInputStream.toString());
      }
      return bool;
    }
    if (System.nanoTime() - l > MIN_LOG_DECODE_COST)
    {
      paramOptions = TAG;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decodeNormalImage: decode ");
      ((StringBuilder)localObject1).append(paramImageKey.filePath);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(paramImageKey.url);
      ((StringBuilder)localObject1).append(" cost too much time");
      ImageManagerLog.w(paramOptions, ((StringBuilder)localObject1).toString());
    }
    processBitmap(paramFileInputStream, paramImageKey, j, true, paramImageAttri.mimeType);
    return paramFileInputStream != null;
  }
  
  private BitmapReference decodePicCropHead(InputStream paramInputStream, float paramFloat)
  {
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("decodePicCropHead: ");
    ((StringBuilder)localObject2).append(paramFloat);
    ((StringBuilder)localObject2).append(" ");
    boolean bool;
    if (paramInputStream == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject2).append(bool);
    Log.i((String)localObject1, ((StringBuilder)localObject2).toString());
    if (paramInputStream != null)
    {
      if (paramFloat <= 0.0F) {
        return null;
      }
      int i = 0;
      Object localObject3;
      Object localObject4;
      while (i < 3) {
        try
        {
          localObject1 = BitmapRegionDecoder.newInstance(paramInputStream, false);
          paramInputStream = (InputStream)localObject1;
        }
        catch (IOException localIOException)
        {
          localObject2 = TAG;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("decodePicCropHead: failed to get decoder ");
          ((StringBuilder)localObject3).append(i);
          Log.w((String)localObject2, ((StringBuilder)localObject3).toString(), localIOException);
          localObject2 = ImageManagerEnv.getLogger();
          localObject3 = TAG;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("decodePicCropHead: failed to get decoder ");
          ((StringBuilder)localObject4).append(i);
          ((ILog)localObject2).w((String)localObject3, new Object[] { ((StringBuilder)localObject4).toString(), localIOException });
          i += 1;
        }
      }
      paramInputStream = null;
      if (paramInputStream == null) {
        return null;
      }
      i = paramInputStream.getWidth();
      int j = paramInputStream.getHeight();
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = (i / 500 + 1);
      paramFloat = i * paramFloat;
      if (paramFloat > j) {
        return null;
      }
      localObject2 = new Rect(0, 0, i, (int)paramFloat);
      i = 0;
      while (i < 3)
      {
        if (i == 1) {
          localOptions.inSampleSize *= 2;
        }
        try
        {
          localObject3 = BitmapReference.getBitmapReference(paramInputStream.decodeRegion((Rect)localObject2, localOptions));
          return localObject3;
        }
        catch (Throwable localThrowable)
        {
          localObject4 = TAG;
          Object localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("decodePicCropHead: failed to decode bitmap ");
          ((StringBuilder)localObject5).append(i);
          Log.w((String)localObject4, ((StringBuilder)localObject5).toString(), localThrowable);
          localObject4 = ImageManagerEnv.getLogger();
          localObject5 = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("decodePicCropHead: failed to decode bitmap ");
          localStringBuilder.append(i);
          ((ILog)localObject4).w((String)localObject5, new Object[] { localStringBuilder.toString(), localThrowable });
          i += 1;
        }
      }
    }
    return null;
  }
  
  private boolean decodeSharpP(ImageKey paramImageKey)
  {
    if ((SharpPUtils.isSharpP(paramImageKey.url)) && (paramImageKey.filePath != null))
    {
      Object localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeSharpP -- url: ");
      localStringBuilder.append(paramImageKey.url);
      localStringBuilder.append(" --is SharpP");
      ImageManagerLog.d((String)localObject, localStringBuilder.toString());
      boolean bool = handlerSharpPDecodeMessage(paramImageKey);
      if ((!bool) && (!SharpPUtils.isSharpP(new File(paramImageKey.filePath))))
      {
        localObject = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeSharpP -- url: ");
        localStringBuilder.append(paramImageKey.url);
        localStringBuilder.append(" --is not really SharpP,so try normal decode");
        ImageManagerLog.w((String)localObject, localStringBuilder.toString());
        return false;
      }
      if (!bool)
      {
        ImageManager.getInstance().checkBitmapDecodeFailCount(paramImageKey);
        setResult(9, new Object[0]);
        localObject = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeSharpP -- url: ");
        localStringBuilder.append(paramImageKey.url);
        localStringBuilder.append(" --  decode sharpp failed.");
        ImageManagerLog.e((String)localObject, localStringBuilder.toString());
        ImageTaskTracer.addImageDecodeFailedRecord(paramImageKey.hashCodeEx());
        ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
        ImageTracer.decodeFail(paramImageKey.url);
        localObject = new File(paramImageKey.filePath);
        ImageManagerEnv.g().reportImageDecodingTask("image/sharpp", paramImageKey.url, ((File)localObject).length(), 51000, "decode sharpP image failed", System.currentTimeMillis());
      }
      return true;
    }
    return false;
  }
  
  private boolean decodeVideoThumb(ImageKey paramImageKey)
  {
    if (VideoThumbnail.isVideo(paramImageKey.filePath))
    {
      int i = paramImageKey.hashCodeEx();
      processBitmap(VideoThumbnail.getThumb(ImageManagerEnv.getAppContext(), paramImageKey.filePath), paramImageKey, i, false, "");
      return true;
    }
    return false;
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
    //   0: invokestatic 263	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   3: invokevirtual 608	com/tencent/component/media/ImageManagerEnv:getCurrentLoadingImgStatus	()Z
    //   6: ifne +64 -> 70
    //   9: new 331	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   16: astore 10
    //   18: aload 10
    //   20: ldc_w 610
    //   23: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 10
    //   29: aload_1
    //   30: getfield 122	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   33: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 10
    //   39: ldc_w 612
    //   42: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 10
    //   48: aload_1
    //   49: getfield 135	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   52: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: ldc_w 614
    //   59: aload 10
    //   61: invokevirtual 343	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 569	com/tencent/component/media/utils/ImageManagerLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: goto +61 -> 128
    //   70: new 331	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   77: astore 10
    //   79: aload 10
    //   81: ldc_w 616
    //   84: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 10
    //   90: aload_1
    //   91: getfield 122	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   94: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload 10
    //   100: ldc_w 612
    //   103: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 10
    //   109: aload_1
    //   110: getfield 135	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   113: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: ldc_w 618
    //   120: aload 10
    //   122: invokevirtual 343	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 569	com/tencent/component/media/utils/ImageManagerLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_1
    //   129: getfield 122	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   132: invokestatic 621	com/tencent/component/media/image/ImageTracer:startDecode	(Ljava/lang/String;)V
    //   135: iconst_3
    //   136: aload_1
    //   137: getfield 203	com/tencent/component/media/image/ImageKey:urlKey	Ljava/lang/String;
    //   140: invokestatic 627	com/tencent/component/media/image/ProgressTracer:print	(ILjava/lang/String;)V
    //   143: invokestatic 196	com/tencent/component/media/image/ImageManager:getInstance	()Lcom/tencent/component/media/image/ImageManager;
    //   146: aload_1
    //   147: invokevirtual 630	com/tencent/component/media/image/ImageManager:imageKeyFilePathCheck	(Lcom/tencent/component/media/image/ImageKey;)V
    //   150: invokestatic 370	java/lang/System:currentTimeMillis	()J
    //   153: lstore 5
    //   155: new 321	java/io/File
    //   158: dup
    //   159: aload_1
    //   160: getfield 135	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   163: invokespecial 323	java/io/File:<init>	(Ljava/lang/String;)V
    //   166: astore 10
    //   168: lconst_0
    //   169: lstore_3
    //   170: aload_1
    //   171: getfield 135	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   174: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   177: ifne +9 -> 186
    //   180: aload 10
    //   182: invokevirtual 362	java/io/File:length	()J
    //   185: lstore_3
    //   186: aload_0
    //   187: aload_1
    //   188: invokespecial 632	com/tencent/component/media/image/DecodeImageTask:decodeVideoThumb	(Lcom/tencent/component/media/image/ImageKey;)Z
    //   191: ifeq +4 -> 195
    //   194: return
    //   195: aload_0
    //   196: aload_1
    //   197: invokespecial 634	com/tencent/component/media/image/DecodeImageTask:decodeSharpP	(Lcom/tencent/component/media/image/ImageKey;)Z
    //   200: ifeq +30 -> 230
    //   203: invokestatic 370	java/lang/System:currentTimeMillis	()J
    //   206: lstore 7
    //   208: invokestatic 263	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   211: ldc_w 581
    //   214: aload_1
    //   215: getfield 122	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   218: lload_3
    //   219: iconst_1
    //   220: lload 7
    //   222: lload 5
    //   224: lsub
    //   225: iconst_0
    //   226: invokevirtual 638	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   229: return
    //   230: aload_0
    //   231: aload_1
    //   232: invokespecial 640	com/tencent/component/media/image/DecodeImageTask:decodeImageFrame	(Lcom/tencent/component/media/image/ImageKey;)Z
    //   235: ifeq +30 -> 265
    //   238: invokestatic 370	java/lang/System:currentTimeMillis	()J
    //   241: lstore 7
    //   243: invokestatic 263	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   246: ldc_w 358
    //   249: aload_1
    //   250: getfield 122	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   253: lload_3
    //   254: iconst_1
    //   255: lload 7
    //   257: lload 5
    //   259: lsub
    //   260: iconst_0
    //   261: invokevirtual 638	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   264: return
    //   265: aload_0
    //   266: aload_1
    //   267: invokespecial 642	com/tencent/component/media/image/DecodeImageTask:decodeAnimateWebp	(Lcom/tencent/component/media/image/ImageKey;)Z
    //   270: ifeq +4 -> 274
    //   273: return
    //   274: aconst_null
    //   275: astore 16
    //   277: aconst_null
    //   278: astore 17
    //   280: aconst_null
    //   281: astore 18
    //   283: aconst_null
    //   284: astore 19
    //   286: aconst_null
    //   287: astore 10
    //   289: getstatic 53	com/tencent/component/media/image/DecodeImageTask:mImagePath2AttriMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   292: aload_1
    //   293: getfield 135	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   296: invokevirtual 409	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   299: checkcast 236	com/tencent/component/media/image/DecodeImageTask$ImageAttri
    //   302: astore 20
    //   304: aload 16
    //   306: astore 14
    //   308: aload 17
    //   310: astore 11
    //   312: aload 18
    //   314: astore 12
    //   316: aload 19
    //   318: astore 13
    //   320: invokestatic 648	com/tencent/component/media/utils/BitmapUtils:getOptions	()Landroid/graphics/BitmapFactory$Options;
    //   323: astore 21
    //   325: aload 20
    //   327: astore 15
    //   329: aload 20
    //   331: ifnonnull +113 -> 444
    //   334: aload 16
    //   336: astore 14
    //   338: aload 17
    //   340: astore 11
    //   342: aload 18
    //   344: astore 12
    //   346: aload 19
    //   348: astore 13
    //   350: new 236	com/tencent/component/media/image/DecodeImageTask$ImageAttri
    //   353: dup
    //   354: invokespecial 649	com/tencent/component/media/image/DecodeImageTask$ImageAttri:<init>	()V
    //   357: astore 15
    //   359: aload 16
    //   361: astore 14
    //   363: aload 17
    //   365: astore 11
    //   367: aload 18
    //   369: astore 12
    //   371: aload 19
    //   373: astore 13
    //   375: new 651	java/io/FileInputStream
    //   378: dup
    //   379: aload_1
    //   380: getfield 135	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   383: invokespecial 652	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   386: astore 10
    //   388: aload_0
    //   389: aload_1
    //   390: new 654	java/io/BufferedInputStream
    //   393: dup
    //   394: aload 10
    //   396: invokespecial 657	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   399: aload 15
    //   401: aload 21
    //   403: invokespecial 659	com/tencent/component/media/image/DecodeImageTask:decodeBounds	(Lcom/tencent/component/media/image/ImageKey;Ljava/io/InputStream;Lcom/tencent/component/media/image/DecodeImageTask$ImageAttri;Landroid/graphics/BitmapFactory$Options;)V
    //   406: goto +38 -> 444
    //   409: astore_1
    //   410: aload 10
    //   412: astore 11
    //   414: goto +707 -> 1121
    //   417: astore 12
    //   419: ldc 234
    //   421: astore 13
    //   423: goto +366 -> 789
    //   426: astore 12
    //   428: ldc 234
    //   430: astore 13
    //   432: goto +467 -> 899
    //   435: astore 12
    //   437: ldc 234
    //   439: astore 13
    //   441: goto +568 -> 1009
    //   444: aload 10
    //   446: astore 14
    //   448: aload 10
    //   450: astore 11
    //   452: aload 10
    //   454: astore 12
    //   456: aload 10
    //   458: astore 13
    //   460: aload_0
    //   461: aload_1
    //   462: aload 15
    //   464: invokespecial 661	com/tencent/component/media/image/DecodeImageTask:decodeGif	(Lcom/tencent/component/media/image/ImageKey;Lcom/tencent/component/media/image/DecodeImageTask$ImageAttri;)Z
    //   467: ifne +116 -> 583
    //   470: aload 10
    //   472: ifnonnull +35 -> 507
    //   475: aload 10
    //   477: astore 14
    //   479: aload 10
    //   481: astore 11
    //   483: aload 10
    //   485: astore 12
    //   487: aload 10
    //   489: astore 13
    //   491: new 651	java/io/FileInputStream
    //   494: dup
    //   495: aload_1
    //   496: getfield 135	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   499: invokespecial 652	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   502: astore 10
    //   504: goto +25 -> 529
    //   507: aload 10
    //   509: astore 14
    //   511: aload 10
    //   513: astore 11
    //   515: aload 10
    //   517: astore 12
    //   519: aload 10
    //   521: astore 13
    //   523: aload_0
    //   524: aload 10
    //   526: invokespecial 665	com/tencent/component/media/image/DecodeImageTask:reset	(Ljava/io/FileInputStream;)V
    //   529: aload 10
    //   531: astore 14
    //   533: aload 10
    //   535: astore 11
    //   537: aload 10
    //   539: astore 12
    //   541: aload 10
    //   543: astore 13
    //   545: aload 21
    //   547: iconst_0
    //   548: putfield 223	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   551: aload 10
    //   553: astore 14
    //   555: aload 10
    //   557: astore 11
    //   559: aload 10
    //   561: astore 12
    //   563: aload 10
    //   565: astore 13
    //   567: aload_0
    //   568: aload_1
    //   569: aload 15
    //   571: aload 10
    //   573: aload 21
    //   575: invokespecial 667	com/tencent/component/media/image/DecodeImageTask:decodeNormalImage	(Lcom/tencent/component/media/image/ImageKey;Lcom/tencent/component/media/image/DecodeImageTask$ImageAttri;Ljava/io/FileInputStream;Landroid/graphics/BitmapFactory$Options;)Z
    //   578: istore 9
    //   580: goto +6 -> 586
    //   583: iconst_1
    //   584: istore 9
    //   586: aload 10
    //   588: astore 11
    //   590: aload 15
    //   592: getfield 239	com/tencent/component/media/image/DecodeImageTask$ImageAttri:mimeType	Ljava/lang/String;
    //   595: astore 12
    //   597: aload 10
    //   599: astore 11
    //   601: invokestatic 370	java/lang/System:currentTimeMillis	()J
    //   604: lstore 7
    //   606: aload 10
    //   608: astore 11
    //   610: invokestatic 263	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   613: astore 14
    //   615: aload 10
    //   617: astore 11
    //   619: aload_1
    //   620: getfield 122	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   623: astore 15
    //   625: iload 9
    //   627: ifeq +8 -> 635
    //   630: iconst_0
    //   631: istore_2
    //   632: goto +5 -> 637
    //   635: iconst_1
    //   636: istore_2
    //   637: aload 12
    //   639: astore 13
    //   641: aload 10
    //   643: astore 11
    //   645: aload 14
    //   647: aload 12
    //   649: aload 15
    //   651: lload_3
    //   652: iload 9
    //   654: lload 7
    //   656: lload 5
    //   658: lsub
    //   659: iload_2
    //   660: invokevirtual 638	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   663: iload 9
    //   665: ifne +14 -> 679
    //   668: aload 10
    //   670: astore 11
    //   672: invokestatic 196	com/tencent/component/media/image/ImageManager:getInstance	()Lcom/tencent/component/media/image/ImageManager;
    //   675: aload_1
    //   676: invokevirtual 574	com/tencent/component/media/image/ImageManager:checkBitmapDecodeFailCount	(Lcom/tencent/component/media/image/ImageKey;)V
    //   679: aload 10
    //   681: ifnull +438 -> 1119
    //   684: aload 10
    //   686: invokevirtual 670	java/io/FileInputStream:close	()V
    //   689: return
    //   690: astore 12
    //   692: goto +97 -> 789
    //   695: astore 12
    //   697: goto +202 -> 899
    //   700: astore 12
    //   702: goto +307 -> 1009
    //   705: astore 11
    //   707: aload 12
    //   709: astore 13
    //   711: aload 11
    //   713: astore 12
    //   715: goto +74 -> 789
    //   718: astore 11
    //   720: aload 12
    //   722: astore 13
    //   724: aload 11
    //   726: astore 12
    //   728: goto +171 -> 899
    //   731: astore 11
    //   733: aload 12
    //   735: astore 13
    //   737: aload 11
    //   739: astore 12
    //   741: goto +268 -> 1009
    //   744: astore 12
    //   746: ldc 234
    //   748: astore 13
    //   750: goto +39 -> 789
    //   753: astore 12
    //   755: ldc 234
    //   757: astore 13
    //   759: goto +140 -> 899
    //   762: astore 12
    //   764: ldc 234
    //   766: astore 13
    //   768: goto +241 -> 1009
    //   771: astore_1
    //   772: aload 14
    //   774: astore 11
    //   776: goto +345 -> 1121
    //   779: astore 12
    //   781: ldc 234
    //   783: astore 13
    //   785: aload 11
    //   787: astore 10
    //   789: aload 10
    //   791: astore 11
    //   793: aload_1
    //   794: getfield 164	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   797: ifnull +20 -> 817
    //   800: aload 10
    //   802: astore 11
    //   804: aload_1
    //   805: getfield 164	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   808: aload_1
    //   809: bipush 112
    //   811: invokestatic 170	com/tencent/component/media/image/ImageManager:getErrorString	(Lcom/tencent/component/media/image/ImageKey;I)Ljava/lang/String;
    //   814: putfield 175	com/tencent/component/media/image/ImageLoader$Options:errCode	Ljava/lang/String;
    //   817: aload 10
    //   819: astore 11
    //   821: getstatic 97	com/tencent/component/media/image/DecodeImageTask:TAG	Ljava/lang/String;
    //   824: aload 12
    //   826: invokestatic 674	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   829: invokestatic 160	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   832: aload 10
    //   834: astore 11
    //   836: invokestatic 370	java/lang/System:currentTimeMillis	()J
    //   839: lstore 7
    //   841: aload 10
    //   843: astore 11
    //   845: invokestatic 263	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   848: aload 13
    //   850: aload_1
    //   851: getfield 122	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   854: lload_3
    //   855: iconst_0
    //   856: lload 7
    //   858: lload 5
    //   860: lsub
    //   861: iconst_4
    //   862: invokevirtual 638	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   865: aload 10
    //   867: astore 11
    //   869: invokestatic 263	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   872: aload 13
    //   874: aload_1
    //   875: getfield 122	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   878: lload_3
    //   879: ldc_w 363
    //   882: ldc_w 676
    //   885: invokestatic 370	java/lang/System:currentTimeMillis	()J
    //   888: invokevirtual 374	com/tencent/component/media/ImageManagerEnv:reportImageDecodingTask	(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;J)V
    //   891: aload 10
    //   893: ifnull +226 -> 1119
    //   896: goto -212 -> 684
    //   899: aload 10
    //   901: astore 11
    //   903: aload_1
    //   904: getfield 164	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   907: ifnull +20 -> 927
    //   910: aload 10
    //   912: astore 11
    //   914: aload_1
    //   915: getfield 164	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   918: aload_1
    //   919: bipush 111
    //   921: invokestatic 170	com/tencent/component/media/image/ImageManager:getErrorString	(Lcom/tencent/component/media/image/ImageKey;I)Ljava/lang/String;
    //   924: putfield 175	com/tencent/component/media/image/ImageLoader$Options:errCode	Ljava/lang/String;
    //   927: aload 10
    //   929: astore 11
    //   931: getstatic 97	com/tencent/component/media/image/DecodeImageTask:TAG	Ljava/lang/String;
    //   934: aload 12
    //   936: invokestatic 674	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   939: invokestatic 160	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   942: aload 10
    //   944: astore 11
    //   946: invokestatic 370	java/lang/System:currentTimeMillis	()J
    //   949: lstore 7
    //   951: aload 10
    //   953: astore 11
    //   955: invokestatic 263	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   958: aload 13
    //   960: aload_1
    //   961: getfield 122	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   964: lload_3
    //   965: iconst_0
    //   966: lload 7
    //   968: lload 5
    //   970: lsub
    //   971: iconst_2
    //   972: invokevirtual 638	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   975: aload 10
    //   977: astore 11
    //   979: invokestatic 263	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   982: aload 13
    //   984: aload_1
    //   985: getfield 122	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   988: lload_3
    //   989: ldc_w 363
    //   992: ldc_w 678
    //   995: invokestatic 370	java/lang/System:currentTimeMillis	()J
    //   998: invokevirtual 374	com/tencent/component/media/ImageManagerEnv:reportImageDecodingTask	(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;J)V
    //   1001: aload 10
    //   1003: ifnull +116 -> 1119
    //   1006: goto -322 -> 684
    //   1009: aload 10
    //   1011: astore 11
    //   1013: aload_1
    //   1014: getfield 164	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   1017: ifnull +20 -> 1037
    //   1020: aload 10
    //   1022: astore 11
    //   1024: aload_1
    //   1025: getfield 164	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   1028: aload_1
    //   1029: bipush 110
    //   1031: invokestatic 170	com/tencent/component/media/image/ImageManager:getErrorString	(Lcom/tencent/component/media/image/ImageKey;I)Ljava/lang/String;
    //   1034: putfield 175	com/tencent/component/media/image/ImageLoader$Options:errCode	Ljava/lang/String;
    //   1037: aload 10
    //   1039: astore 11
    //   1041: getstatic 97	com/tencent/component/media/image/DecodeImageTask:TAG	Ljava/lang/String;
    //   1044: aload 12
    //   1046: invokestatic 674	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1049: invokestatic 160	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1052: aload 10
    //   1054: astore 11
    //   1056: invokestatic 370	java/lang/System:currentTimeMillis	()J
    //   1059: lstore 7
    //   1061: aload 10
    //   1063: astore 11
    //   1065: invokestatic 263	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   1068: aload 13
    //   1070: aload_1
    //   1071: getfield 122	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   1074: lload_3
    //   1075: iconst_0
    //   1076: lload 7
    //   1078: lload 5
    //   1080: lsub
    //   1081: iconst_3
    //   1082: invokevirtual 638	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   1085: aload 10
    //   1087: astore 11
    //   1089: invokestatic 263	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   1092: aload 13
    //   1094: aload_1
    //   1095: getfield 122	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   1098: lload_3
    //   1099: ldc_w 363
    //   1102: ldc_w 680
    //   1105: invokestatic 370	java/lang/System:currentTimeMillis	()J
    //   1108: invokevirtual 374	com/tencent/component/media/ImageManagerEnv:reportImageDecodingTask	(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;J)V
    //   1111: aload 10
    //   1113: ifnull +6 -> 1119
    //   1116: goto -432 -> 684
    //   1119: return
    //   1120: astore_1
    //   1121: aload 11
    //   1123: ifnull +8 -> 1131
    //   1126: aload 11
    //   1128: invokevirtual 670	java/io/FileInputStream:close	()V
    //   1131: goto +5 -> 1136
    //   1134: aload_1
    //   1135: athrow
    //   1136: goto -2 -> 1134
    //   1139: astore_1
    //   1140: return
    //   1141: astore 10
    //   1143: goto -12 -> 1131
    //   1146: astore 11
    //   1148: ldc 234
    //   1150: astore 13
    //   1152: aload 12
    //   1154: astore 10
    //   1156: aload 11
    //   1158: astore 12
    //   1160: goto -261 -> 899
    //   1163: astore 12
    //   1165: ldc 234
    //   1167: astore 11
    //   1169: aload 13
    //   1171: astore 10
    //   1173: aload 11
    //   1175: astore 13
    //   1177: goto -168 -> 1009
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1180	0	this	DecodeImageTask
    //   0	1180	1	paramImageKey	ImageKey
    //   631	29	2	i	int
    //   169	930	3	l1	long
    //   153	926	5	l2	long
    //   206	871	7	l3	long
    //   578	86	9	bool	boolean
    //   16	1096	10	localObject1	Object
    //   1141	1	10	localIOException	IOException
    //   1154	18	10	localObject2	Object
    //   310	361	11	localObject3	Object
    //   705	7	11	localThrowable1	Throwable
    //   718	7	11	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   731	7	11	localException1	java.lang.Exception
    //   774	353	11	localObject4	Object
    //   1146	11	11	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1167	7	11	str	String
    //   314	56	12	localObject5	Object
    //   417	1	12	localThrowable2	Throwable
    //   426	1	12	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   435	1	12	localException2	java.lang.Exception
    //   454	194	12	localObject6	Object
    //   690	1	12	localThrowable3	Throwable
    //   695	1	12	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   700	8	12	localException3	java.lang.Exception
    //   713	27	12	localObject7	Object
    //   744	1	12	localThrowable4	Throwable
    //   753	1	12	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   762	1	12	localException4	java.lang.Exception
    //   779	374	12	localThrowable5	Throwable
    //   1158	1	12	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   1163	1	12	localException5	java.lang.Exception
    //   318	858	13	localObject8	Object
    //   306	467	14	localObject9	Object
    //   327	323	15	localObject10	Object
    //   275	85	16	localObject11	Object
    //   278	86	17	localObject12	Object
    //   281	87	18	localObject13	Object
    //   284	88	19	localObject14	Object
    //   302	28	20	localImageAttri	DecodeImageTask.ImageAttri
    //   323	251	21	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   388	406	409	finally
    //   388	406	417	java/lang/Throwable
    //   388	406	426	java/lang/OutOfMemoryError
    //   388	406	435	java/lang/Exception
    //   645	663	690	java/lang/Throwable
    //   672	679	690	java/lang/Throwable
    //   645	663	695	java/lang/OutOfMemoryError
    //   672	679	695	java/lang/OutOfMemoryError
    //   645	663	700	java/lang/Exception
    //   672	679	700	java/lang/Exception
    //   601	606	705	java/lang/Throwable
    //   610	615	705	java/lang/Throwable
    //   619	625	705	java/lang/Throwable
    //   601	606	718	java/lang/OutOfMemoryError
    //   610	615	718	java/lang/OutOfMemoryError
    //   619	625	718	java/lang/OutOfMemoryError
    //   601	606	731	java/lang/Exception
    //   610	615	731	java/lang/Exception
    //   619	625	731	java/lang/Exception
    //   590	597	744	java/lang/Throwable
    //   590	597	753	java/lang/OutOfMemoryError
    //   590	597	762	java/lang/Exception
    //   320	325	771	finally
    //   350	359	771	finally
    //   375	388	771	finally
    //   460	470	771	finally
    //   491	504	771	finally
    //   523	529	771	finally
    //   545	551	771	finally
    //   567	580	771	finally
    //   320	325	779	java/lang/Throwable
    //   350	359	779	java/lang/Throwable
    //   375	388	779	java/lang/Throwable
    //   460	470	779	java/lang/Throwable
    //   491	504	779	java/lang/Throwable
    //   523	529	779	java/lang/Throwable
    //   545	551	779	java/lang/Throwable
    //   567	580	779	java/lang/Throwable
    //   590	597	1120	finally
    //   601	606	1120	finally
    //   610	615	1120	finally
    //   619	625	1120	finally
    //   645	663	1120	finally
    //   672	679	1120	finally
    //   793	800	1120	finally
    //   804	817	1120	finally
    //   821	832	1120	finally
    //   836	841	1120	finally
    //   845	865	1120	finally
    //   869	891	1120	finally
    //   903	910	1120	finally
    //   914	927	1120	finally
    //   931	942	1120	finally
    //   946	951	1120	finally
    //   955	975	1120	finally
    //   979	1001	1120	finally
    //   1013	1020	1120	finally
    //   1024	1037	1120	finally
    //   1041	1052	1120	finally
    //   1056	1061	1120	finally
    //   1065	1085	1120	finally
    //   1089	1111	1120	finally
    //   684	689	1139	java/io/IOException
    //   1126	1131	1141	java/io/IOException
    //   320	325	1146	java/lang/OutOfMemoryError
    //   350	359	1146	java/lang/OutOfMemoryError
    //   375	388	1146	java/lang/OutOfMemoryError
    //   460	470	1146	java/lang/OutOfMemoryError
    //   491	504	1146	java/lang/OutOfMemoryError
    //   523	529	1146	java/lang/OutOfMemoryError
    //   545	551	1146	java/lang/OutOfMemoryError
    //   567	580	1146	java/lang/OutOfMemoryError
    //   320	325	1163	java/lang/Exception
    //   350	359	1163	java/lang/Exception
    //   375	388	1163	java/lang/Exception
    //   460	470	1163	java/lang/Exception
    //   491	504	1163	java/lang/Exception
    //   523	529	1163	java/lang/Exception
    //   545	551	1163	java/lang/Exception
    //   567	580	1163	java/lang/Exception
  }
  
  private boolean handlerSharpPDecodeMessage(ImageKey paramImageKey)
  {
    int j = paramImageKey.hashCodeEx();
    SharpPDecoderHelper localSharpPDecoderHelper = new SharpPDecoderHelper(paramImageKey.filePath);
    int i = localSharpPDecoderHelper.parseHeader();
    if (i != 0)
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parseHeader error,status=");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(paramImageKey.url);
      ((StringBuilder)localObject2).append(",hashCode=");
      ((StringBuilder)localObject2).append(paramImageKey.hashCodeEx());
      ((StringBuilder)localObject2).append(",filePath=");
      ((StringBuilder)localObject2).append(paramImageKey.filePath);
      ((StringBuilder)localObject2).append(", try again");
      ImageManagerLog.w((String)localObject1, ((StringBuilder)localObject2).toString());
      return false;
    }
    Object localObject2 = (DecodeImageTask.ImageAttri)mImagePath2AttriMap.get(paramImageKey.filePath);
    Object localObject4 = localSharpPDecoderHelper.getFeatureInfo();
    Object localObject1 = "unknown";
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = localObject2;
      if (!((DecodeImageTask.ImageAttri)localObject2).mimeType.equals("unknown")) {}
    }
    else
    {
      localObject3 = new DecodeImageTask.ImageAttri();
      ((DecodeImageTask.ImageAttri)localObject3).srcHeight = ((SharpPDecoderWrapper.SharpPFeatureWrapper)localObject4).getHeight();
      ((DecodeImageTask.ImageAttri)localObject3).srcWidth = ((SharpPDecoderWrapper.SharpPFeatureWrapper)localObject4).getWidth();
      localObject2 = localSharpPDecoderHelper.getMimeType();
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
      ((DecodeImageTask.ImageAttri)localObject3).mimeType = ((String)localObject1);
      mImagePath2AttriMap.put(paramImageKey.filePath, localObject3);
    }
    localObject1 = (Integer)mImageKey2SampleSizeMap.get(Integer.valueOf(j));
    int k = ((SharpPDecoderWrapper.SharpPFeatureWrapper)localObject4).getWidth();
    int m = ((SharpPDecoderWrapper.SharpPFeatureWrapper)localObject4).getHeight();
    if ((paramImageKey.options != null) && (!TextUtils.isEmpty(paramImageKey.filePath)) && (paramImageKey.options.isNeedPieceLoad))
    {
      paramImageKey.options.isNeedPieceLoad = RegionImageUtil.isValidRegionImageFormat(paramImageKey.filePath);
      localObject2 = TAG;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("handlerSharpPDecodeMessage Region decode file isValidRegionImageFormat with isNeedPieceLoad = ");
      ((StringBuilder)localObject4).append(paramImageKey.options.isNeedPieceLoad);
      ImageManagerLog.i((String)localObject2, ((StringBuilder)localObject4).toString());
    }
    if (localObject1 == null)
    {
      i = ImageOptionSampleSize.computeSampleSize(paramImageKey.options, k, m);
      mImageKey2SampleSizeMap.put(Integer.valueOf(j), Integer.valueOf(i));
    }
    else
    {
      i = ((Integer)localObject1).intValue();
    }
    if ((isGif(((DecodeImageTask.ImageAttri)localObject3).mimeType)) && (paramImageKey.options != null) && (paramImageKey.options.needShowGifAnimation))
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handlerSharpPDecodeMessage -- url: ");
      ((StringBuilder)localObject2).append(paramImageKey.url);
      ((StringBuilder)localObject2).append(" --is sharp gif：");
      ((StringBuilder)localObject2).append(((DecodeImageTask.ImageAttri)localObject3).mimeType);
      ImageManagerLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
      localObject3 = new NewGifImage(paramImageKey.filePath, k, m, i, paramImageKey.url);
      localObject2 = ((NewGifImage)localObject3).getDrawable();
      ImageManagerEnv.g().reportImageDecodingResMTA("gif_collect", "sharp/gif");
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (paramImageKey.options.extraProcessor != null)
        {
          localObject1 = localObject2;
          if ((paramImageKey.options.extraProcessor instanceof NewGifDrawableSpecifiedRegionProcessor)) {
            localObject1 = paramImageKey.options.extraProcessor.doProcess((Drawable)localObject2);
          }
        }
        ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, j, (Image)localObject3, (Drawable)localObject1, paramImageKey.options);
        setResult(8, new Object[] { localObject1, null, paramImageKey.urlKey, Integer.valueOf(j), localObject3, localObject1 });
        ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
        ImageTracer.endDecode(paramImageKey.url);
        return true;
      }
      if (paramImageKey.options != null) {
        paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 103);
      }
      return false;
    }
    localObject1 = Bitmap.Config.ARGB_8888;
    if ((paramImageKey.options != null) && (paramImageKey.options.imageConfig != null)) {
      localObject1 = paramImageKey.options.imageConfig;
    } else if (SharpPUtils.isJpg(((DecodeImageTask.ImageAttri)localObject3).mimeType)) {
      localObject1 = Bitmap.Config.RGB_565;
    } else {
      localObject1 = Bitmap.Config.ARGB_8888;
    }
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
      else if (paramImageKey.options.imageConfig != null)
      {
        localObject1 = paramImageKey.options.imageConfig;
      }
      else if ((k != 0) && (m != 0) && (k / m == 2.0F))
      {
        localObject1 = Bitmap.Config.RGB_565;
      }
      else
      {
        localObject1 = Bitmap.Config.ARGB_8888;
      }
    }
    int n = k / i;
    int i1 = m / i;
    if (paramImageKey != null)
    {
      paramImageKey.inSampleSize = i;
      paramImageKey.orgWidth = k;
      paramImageKey.orgHeight = m;
    }
    if (SharpPUtils.isJpg(((DecodeImageTask.ImageAttri)localObject3).mimeType)) {
      localObject1 = localSharpPDecoderHelper.decodeSharpP2JPG(n, i1, (Bitmap.Config)localObject1);
    } else {
      localObject1 = localSharpPDecoderHelper.decodeSharpP2PNG(n, i1, Bitmap.Config.ARGB_8888);
    }
    if (localObject1 == null)
    {
      if (paramImageKey.options != null) {
        paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 104);
      }
      return false;
    }
    processBitmap(BitmapReference.getBitmapReference((Bitmap)localObject1), paramImageKey, j, true, ((DecodeImageTask.ImageAttri)localObject3).mimeType);
    return true;
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
    paramDrawable = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("super resolution. needTryScaleDrawable: width=");
    localStringBuilder.append(i);
    localStringBuilder.append(" screenWidth=");
    localStringBuilder.append(k);
    localStringBuilder.append(" height=");
    localStringBuilder.append(j);
    localStringBuilder.append(" screenHeight=");
    localStringBuilder.append(m);
    ImageManagerLog.w(paramDrawable, localStringBuilder.toString());
    return (i > k) || (j > m);
  }
  
  public static DecodeImageTask obtain(ImageKey paramImageKey)
  {
    if (needRecycle) {
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
      }
    }
    return new DecodeImageTask(paramImageKey);
  }
  
  public static DecodeImageTask obtain(ImageTask paramImageTask)
  {
    if (needRecycle) {
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
      }
    }
    return new DecodeImageTask(paramImageTask);
  }
  
  private void processBitmap(BitmapReference paramBitmapReference, ImageKey paramImageKey, int paramInt, boolean paramBoolean, String paramString)
  {
    Object localObject;
    if (paramBitmapReference != null)
    {
      long l = System.nanoTime();
      ImageManager.getInstance().updateLruFile(paramImageKey);
      localObject = paramBitmapReference;
      if (paramBoolean) {
        localObject = BitmapUtils.processExif(paramBitmapReference, paramImageKey.filePath, paramString);
      }
      localObject = processImage((BitmapReference)localObject, paramImageKey.options);
      int i;
      int j;
      if (paramImageKey.options != null)
      {
        i = paramImageKey.options.clipWidth;
        j = paramImageKey.options.clipHeight;
      }
      else
      {
        i = -1;
        j = -1;
      }
      if ((paramImageKey.needSuperResolution) && (ImageManagerEnv.g().enableSuperResolution()) && (paramImageKey.url != null) && (paramImageKey.url.contains("sce=")))
      {
        if ((ImageManagerEnv.g().checkShouldRunSuperResolutionBenchmark()) && (ImageManagerEnv.g().needRerunSuperResolutionBenchmark(paramImageKey.url))) {
          ImageManagerEnv.g().clearSuperResolutionBenchmark();
        }
        if (!ImageManagerEnv.g().isSuperResolutionEnvReady())
        {
          ImageManagerEnv.g().prepareSuperResolutionEnv();
        }
        else if (ImageManagerEnv.g().needSuperResolution(paramImageKey.url))
        {
          k = ((BitmapImage)localObject).getBitmap().getWidth();
          int m = ((BitmapImage)localObject).getBitmap().getHeight();
          paramBitmapReference = TAG;
          paramString = new StringBuilder();
          paramString.append("super resolution. width=");
          paramString.append(k);
          paramString.append(" height=");
          paramString.append(m);
          paramString.append(" url=");
          paramString.append(paramImageKey.url);
          ImageManagerLog.d(paramBitmapReference, paramString.toString());
          if (ImageManagerEnv.g().canDoSuperResolution(k, m))
          {
            paramBitmapReference = ((BitmapImage)localObject).getBitmap().getBitmap();
            ImageTracer.requestSuperResolution(paramImageKey.url);
            ProgressTracer.print(7, paramImageKey.urlKey);
            ImageManager.getSuperResolutionHandler().postAtFrontOfQueue(new DecodeImageTask.1(this, paramImageKey, paramBitmapReference, i, j, paramInt));
            k = 1;
            break label340;
          }
        }
      }
      int k = 0;
      label340:
      if ((paramImageKey.options != null) && (paramImageKey.options.extraProcessor != null))
      {
        paramString = new BitmapImageDrawable((BitmapImage)localObject, i, j);
        paramBitmapReference = paramString;
        if (ImageManagerEnv.g().isHighScaleUrl(paramImageKey.url))
        {
          paramBitmapReference = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("super resolution. check high scale not process. url=");
          localStringBuilder.append(paramImageKey.url);
          ImageManagerLog.w(paramBitmapReference, localStringBuilder.toString());
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
        }
        else if ((paramBitmapReference instanceof RegionDrawable))
        {
          paramString = ((RegionDrawable)paramBitmapReference).getBitmapRef();
          ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, paramInt, (Image)localObject, paramBitmapReference, paramImageKey.options);
          setResult(8, new Object[] { paramBitmapReference, paramString, paramImageKey.urlKey, Integer.valueOf(paramInt), localObject, paramBitmapReference });
          ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
        }
        else
        {
          paramString = ((BitmapImage)localObject).getBitmap();
          ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, paramInt, (Image)localObject, paramBitmapReference, paramImageKey.options);
          setResult(8, new Object[] { paramBitmapReference, paramString, paramImageKey.urlKey, Integer.valueOf(paramInt), localObject, paramBitmapReference });
          ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
        }
        ImageTracer.endDecode(paramImageKey.url);
      }
      else
      {
        paramBitmapReference = new SpecifiedBitmapDrawable(((BitmapImage)localObject).getBitmap());
        ImageTracer.endDecode(paramImageKey.url);
        ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, paramInt, (Image)localObject, paramBitmapReference, paramImageKey.options);
        setResult(8, new Object[] { paramBitmapReference, ((BitmapImage)localObject).getBitmap(), paramImageKey.urlKey, Integer.valueOf(paramInt), localObject, paramBitmapReference });
        ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
      }
      if ((k == 0) && (ImageManagerEnv.g().enableReportNoneSuperResolutionTime()) && (ImageManagerEnv.g().isBigUrl(paramImageKey.url)))
      {
        ImageTracer.reportDecodeTime(paramImageKey.url, false);
        ImageTracer.reportDownloadTime(paramImageKey.url, false);
      }
      if (System.nanoTime() - l > MIN_LOG_DECODE_COST)
      {
        paramBitmapReference = TAG;
        paramString = new StringBuilder();
        paramString.append("processBitmap: ");
        paramString.append(paramImageKey.url);
        paramString.append(" cost too much time");
        ImageManagerLog.w(paramBitmapReference, paramString.toString());
      }
    }
    else
    {
      if ((paramImageKey != null) && (paramImageKey.options != null)) {
        paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 105);
      }
      setResult(9, new Object[0]);
      if (paramImageKey != null)
      {
        paramBitmapReference = new File(paramImageKey.filePath);
        ImageManagerEnv.g().reportImageDecodingTask("unknown", paramImageKey.url, paramBitmapReference.length(), 51000, "processBitmap, bm is null", System.currentTimeMillis());
        paramString = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("processBitmap, bm is null, url=");
        ((StringBuilder)localObject).append(paramImageKey.url);
        ((StringBuilder)localObject).append(", file length=");
        ((StringBuilder)localObject).append(paramBitmapReference.length());
        ImageManagerLog.w(paramString, ((StringBuilder)localObject).toString());
      }
      ImageTaskTracer.addImageDecodeFailedRecord(paramImageKey.hashCodeEx());
      ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
    }
  }
  
  private static BitmapImage processImage(BitmapReference paramBitmapReference, ImageLoader.Options paramOptions)
  {
    Object localObject = null;
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
      }
      catch (Throwable paramOptions)
      {
        paramOptions.printStackTrace();
        paramOptions = localObject;
      }
      if ((paramOptions != null) && (paramOptions != paramBitmapReference))
      {
        paramBitmapReference = new BitmapImage(paramOptions);
        paramBitmapReference.getMetaInfo().width = i;
        paramBitmapReference.getMetaInfo().height = j;
        return paramBitmapReference;
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
    int i = ImageManagerEnv.g().getScreenWidth() - (int)(ImageManagerEnv.g().getDesity() * 4.0F);
    int j = ImageManagerEnv.g().getScreenHeight() - (int)(ImageManagerEnv.g().getDesity() * 4.0F);
    Drawable localDrawable;
    if (k <= i)
    {
      localDrawable = paramDrawable;
      if (m <= j) {}
    }
    else
    {
      double d2 = k;
      double d3 = m;
      Double.isNaN(d2);
      Double.isNaN(d3);
      double d4 = d2 / d3;
      double d1 = i;
      double d5 = j;
      Double.isNaN(d1);
      Double.isNaN(d5);
      if (d4 > d1 / d5)
      {
        Double.isNaN(d3);
        Double.isNaN(d2);
        d2 = d3 / d2;
        Double.isNaN(d1);
        j = (int)(d1 * d2);
      }
      else
      {
        Double.isNaN(d5);
        i = (int)(d5 * d4);
      }
      localDrawable = new ScaleProcessor(i, j, true).process(paramDrawable);
      localDrawable.setBounds(0, 0, i, j);
    }
    return localDrawable;
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
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("no file hashCodeEx:");
      localStringBuilder.append(this.mImageKey.hashCodeEx());
      localStringBuilder.append(" isGifPlayWhileDownloading:");
      localStringBuilder.append(this.mImageKey.options.isGifPlayWhileDownloading);
      ImageManagerLog.w((String)localObject, localStringBuilder.toString());
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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt != 2) && (paramInt != 12))
        {
          setResult(paramInt, paramVarArgs);
          return;
        }
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
        if (this.mImageKey != null)
        {
          ImageManagerEnv.g().reportImageDecodingTask("unknown", this.mImageKey.url, paramVarArgs.length(), 51000, "download success, file does not exist", System.currentTimeMillis());
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onResult, download success, file does not exist!, url=");
          localStringBuilder.append(this.mImageKey.url);
          localStringBuilder.append(", file length=");
          localStringBuilder.append(paramVarArgs.length());
          ImageManagerLog.w(str, localStringBuilder.toString());
        }
      }
      else
      {
        setResult(9, new Object[0]);
      }
    }
    else {
      setResult(9, new Object[0]);
    }
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
    boolean bool;
    if ((this.mImageKey != null) && (this.mImageKey.options != null) && (this.mImageKey.options.priority)) {
      bool = true;
    } else {
      bool = false;
    }
    ImageManager.post(localDecodeTask, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.DecodeImageTask
 * JD-Core Version:    0.7.0.1
 */