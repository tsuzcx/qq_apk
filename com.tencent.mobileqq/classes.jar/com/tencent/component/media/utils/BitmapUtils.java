package com.tencent.component.media.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.annotation.Public;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.DecodeImageTask;
import com.tencent.component.media.image.ImageManager;
import com.tencent.sharpP.SharpPUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

@Public
public final class BitmapUtils
{
  private static final int DEFAULT_QUALITY = 90;
  private static final String[] EXIF_TAGS = { "FNumber", "DateTime", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ISOSpeedRatings", "Make", "Model", "Orientation", "WhiteBalance" };
  public static final String TAG = "BitmapUtils";
  private static BitmapFactory.Options options;
  
  @TargetApi(11)
  public static void addInBitmapOptions(BitmapFactory.Options paramOptions, Bitmap paramBitmap)
  {
    if (paramOptions == null) {
      return;
    }
    paramOptions.inMutable = true;
    if ((paramBitmap != null) && (canUseForInBitmap(paramBitmap, paramOptions))) {
      paramOptions.inBitmap = paramBitmap;
    }
  }
  
  private static boolean canUseForInBitmap(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramOptions != null)
    {
      bool1 = bool3;
      if (paramOptions.inSampleSize >= 1)
      {
        if (paramBitmap == null) {
          return false;
        }
        if (Build.VERSION.SDK_INT < 11) {
          return false;
        }
        if (Build.VERSION.SDK_INT >= 19)
        {
          bool1 = bool2;
          if (paramOptions.outWidth / paramOptions.inSampleSize * (paramOptions.outHeight / paramOptions.inSampleSize) * getBytesPerPixel(paramBitmap.getConfig()) <= paramBitmap.getAllocationByteCount()) {
            bool1 = true;
          }
          return bool1;
        }
        bool1 = bool3;
        if (paramBitmap.getWidth() == paramOptions.outWidth)
        {
          bool1 = bool3;
          if (paramBitmap.getHeight() == paramOptions.outHeight)
          {
            bool1 = bool3;
            if (paramOptions.inSampleSize == 1) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static byte[] compressToBytes(Bitmap paramBitmap)
  {
    Bitmap.CompressFormat localCompressFormat;
    if (paramBitmap.hasAlpha()) {
      localCompressFormat = Bitmap.CompressFormat.PNG;
    } else {
      localCompressFormat = Bitmap.CompressFormat.JPEG;
    }
    return compressToBytes(paramBitmap, 90, localCompressFormat);
  }
  
  public static byte[] compressToBytes(Bitmap paramBitmap, int paramInt, Bitmap.CompressFormat paramCompressFormat)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(65536);
    paramBitmap.compress(paramCompressFormat, paramInt, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] compressToBytes(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat)
  {
    return compressToBytes(paramBitmap, 90, paramCompressFormat);
  }
  
  public static void copyExif(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = new File(paramString1);
      paramString2 = new File(paramString2);
      if ((paramString1.exists()) && (paramString2.exists())) {
        if (SharpPUtils.isSharpP(paramString1))
        {
          ImageManagerEnv.getLogger().w("BitmapUtils", new Object[] { "sharpP image do not support copy exif" });
          return;
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramString1 = new ExifInterface(paramString1.getAbsolutePath());
        paramString2 = new ExifInterface(paramString2.getAbsolutePath());
        localObject = EXIF_TAGS;
        int j = localObject.length;
        i = 0;
        if (i < j)
        {
          String str1 = localObject[i];
          String str2 = paramString1.getAttribute(str1);
          if (str2 == null) {
            break label247;
          }
          paramString2.setAttribute(str1, str2);
          break label247;
        }
        paramString2.saveAttributes();
        return;
      }
      catch (Throwable paramString1)
      {
        paramString2 = ImageManagerEnv.getLogger();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("copyExif failed: ");
        ((StringBuilder)localObject).append(paramString1.getMessage());
        paramString2.e("BitmapUtils", new Object[] { ((StringBuilder)localObject).toString() });
        return;
      }
      ImageManagerEnv.getLogger().e("BitmapUtils", new Object[] { "copyExif: file not exits!" });
      return;
      ImageManagerEnv.getLogger().e("BitmapUtils", new Object[] { "copyExif: path is empty!" });
      return;
      label247:
      i += 1;
    }
  }
  
  /* Error */
  public static BitmapReference drawableToBitmapByCanvas(android.graphics.drawable.Drawable paramDrawable)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 235	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   4: iconst_2
    //   5: invokestatic 241	java/lang/Math:max	(II)I
    //   8: istore_1
    //   9: aload_0
    //   10: invokevirtual 244	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   13: iconst_2
    //   14: invokestatic 241	java/lang/Math:max	(II)I
    //   17: istore_2
    //   18: invokestatic 250	com/tencent/component/media/image/ImageManager:getInstance	()Lcom/tencent/component/media/image/ImageManager;
    //   21: iload_1
    //   22: iload_2
    //   23: getstatic 256	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   26: invokevirtual 260	com/tencent/component/media/image/ImageManager:getBitmap	(IILandroid/graphics/Bitmap$Config;)Lcom/tencent/component/media/image/BitmapReference;
    //   29: astore_3
    //   30: new 262	android/graphics/Canvas
    //   33: dup
    //   34: aload_3
    //   35: invokevirtual 267	com/tencent/component/media/image/BitmapReference:getBitmap	()Landroid/graphics/Bitmap;
    //   38: invokespecial 270	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   41: astore 4
    //   43: aload_0
    //   44: iconst_0
    //   45: iconst_0
    //   46: aload 4
    //   48: invokevirtual 271	android/graphics/Canvas:getWidth	()I
    //   51: aload 4
    //   53: invokevirtual 272	android/graphics/Canvas:getHeight	()I
    //   56: invokevirtual 276	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   59: aload_0
    //   60: aload 4
    //   62: invokevirtual 280	android/graphics/drawable/Drawable:draw	(Landroid/graphics/Canvas;)V
    //   65: aload_3
    //   66: areturn
    //   67: aconst_null
    //   68: astore_0
    //   69: aload_0
    //   70: ifnull +14 -> 84
    //   73: aload_0
    //   74: invokevirtual 283	com/tencent/component/media/image/BitmapReference:isRecycled	()Z
    //   77: ifne +7 -> 84
    //   80: aload_0
    //   81: invokevirtual 286	com/tencent/component/media/image/BitmapReference:release	()V
    //   84: aconst_null
    //   85: areturn
    //   86: astore_0
    //   87: goto -20 -> 67
    //   90: astore_0
    //   91: aload_3
    //   92: astore_0
    //   93: goto -24 -> 69
    //   96: astore_0
    //   97: goto -13 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramDrawable	android.graphics.drawable.Drawable
    //   8	14	1	i	int
    //   17	6	2	j	int
    //   29	63	3	localBitmapReference	BitmapReference
    //   41	20	4	localCanvas	Canvas
    // Exception table:
    //   from	to	target	type
    //   18	30	86	java/lang/Throwable
    //   30	65	90	java/lang/Throwable
    //   73	84	96	java/lang/Throwable
  }
  
  public static int getBitmapAllocSize(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      if (Build.VERSION.SDK_INT >= 19) {
        return paramBitmap.getAllocationByteCount();
      }
      int i = paramBitmap.getRowBytes();
      return paramBitmap.getHeight() * i;
    }
    return 0;
  }
  
  public static int getBytesPerPixel(Bitmap.Config paramConfig)
  {
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      return 4;
    }
    if (paramConfig == Bitmap.Config.RGB_565) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ARGB_4444) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ALPHA_8) {
      return 1;
    }
    ILog localILog = ImageManagerEnv.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getBytePerPixel config is error ");
    localStringBuilder.append(paramConfig);
    localILog.w("BitmapUtils", new Object[] { localStringBuilder.toString() });
    return 4;
  }
  
  public static BitmapFactory.Options getOptions()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if ((Build.VERSION.SDK_INT < 11) && (ImageManagerEnv.g().enableBitmapNativeAlloc())) {
      setBitmapOptionInNativeAlloc(localOptions);
    }
    return localOptions;
  }
  
  @SuppressLint({"InlinedApi"})
  @Public
  public static Bitmap processExif(Bitmap paramBitmap, String paramString)
  {
    Bitmap localBitmap1 = paramBitmap;
    Bitmap localBitmap2;
    if (paramBitmap != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return paramBitmap;
      }
      if (Build.VERSION.SDK_INT < 5) {
        return paramBitmap;
      }
      try
      {
        boolean bool = new File(paramString).exists();
        if (!bool) {
          return paramBitmap;
        }
      }
      catch (Throwable localThrowable)
      {
        ImageManagerEnv.getLogger().e("BitmapUtils", new Object[] { Log.getStackTraceString(localThrowable) });
        localBitmap2 = rotateBitmap(paramBitmap, ImageManagerEnv.g().getRotationDegree(paramString));
      }
    }
    return localBitmap2;
  }
  
  public static BitmapReference processExif(BitmapReference paramBitmapReference, String paramString)
  {
    return processExif(paramBitmapReference, paramString, "");
  }
  
  public static BitmapReference processExif(BitmapReference paramBitmapReference, String paramString1, String paramString2)
  {
    Object localObject = paramBitmapReference;
    BitmapReference localBitmapReference;
    if (paramBitmapReference != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return paramBitmapReference;
      }
      if (Build.VERSION.SDK_INT < 5) {
        return paramBitmapReference;
      }
      localObject = DecodeImageTask.getImagePath2Rotation(paramString1);
      int i;
      if (localObject == null) {
        try
        {
          boolean bool = new File(paramString1).exists();
          if (!bool) {
            return paramBitmapReference;
          }
        }
        catch (Throwable localThrowable)
        {
          ImageManagerEnv.getLogger().e("BitmapUtils", new Object[] { Log.getStackTraceString(localThrowable) });
          if ((!TextUtils.isEmpty(paramString2)) && ("image/heif".equals(paramString2))) {
            i = readOrientation(paramString1);
          } else {
            i = ImageManagerEnv.g().getRotationDegree(paramString1);
          }
          DecodeImageTask.putImagePath2Rotation(paramString1, i);
        }
      } else {
        i = localThrowable.intValue();
      }
      localBitmapReference = rotateBitmap(paramBitmapReference, i);
    }
    return localBitmapReference;
  }
  
  public static int readOrientation(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
    }
    catch (IOException paramString)
    {
      ImageManagerLog.e("BitmapUtils", "readOrientation, IOException");
      paramString.printStackTrace();
      paramString = null;
    }
    int j = 0;
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString != null)
      {
        i = paramString.getAttributeInt("Orientation", 0);
        if (i != 3)
        {
          if (i != 6)
          {
            if (i != 8) {
              return 0;
            }
            return 270;
          }
          return 90;
        }
        i = 180;
      }
    }
    return i;
  }
  
  public static void resize(LruCache paramLruCache, float paramFloat)
  {
    if (paramLruCache == null) {
      return;
    }
    if (paramFloat <= 1.0F)
    {
      if (paramFloat < 0.0F) {
        return;
      }
      int k = paramLruCache.maxSize();
      int j = (int)(k * paramFloat);
      int i = j;
      if (j <= 0) {
        i = 1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resize  oldMaxSize=");
      localStringBuilder.append(k);
      localStringBuilder.append(",newMaxSize=");
      localStringBuilder.append(i);
      localStringBuilder.append(",ration=");
      localStringBuilder.append(paramFloat);
      ImageManagerLog.i("BitmapUtils", localStringBuilder.toString());
      paramLruCache.resize(i);
    }
  }
  
  public static void resize(LruCache paramLruCache, float paramFloat, int paramInt)
  {
    if (paramLruCache == null) {
      return;
    }
    if (paramFloat <= 1.0F)
    {
      if (paramFloat < 0.0F) {
        return;
      }
      int k = paramLruCache.maxSize();
      int j = (int)(k * paramFloat);
      int i = j;
      if (j < paramInt) {
        i = paramInt;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resize  oldMaxSize=");
      localStringBuilder.append(k);
      localStringBuilder.append(",newMaxSize=");
      localStringBuilder.append(i);
      localStringBuilder.append(",ration=");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(", minCacheSize = ");
      localStringBuilder.append(paramInt);
      ImageManagerLog.i("BitmapUtils", localStringBuilder.toString());
      paramLruCache.resize(i);
    }
  }
  
  public static Bitmap rotateBitmap(Bitmap paramBitmap, int paramInt)
  {
    int j = paramInt % 360;
    if (j == 0) {
      return paramBitmap;
    }
    int i;
    if (((j > 45) && (j < 135)) || ((j > 225) && (j < 315))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      paramInt = paramBitmap.getWidth();
    } else {
      paramInt = paramBitmap.getHeight();
    }
    if (i == 0) {
      i = paramBitmap.getHeight();
    } else {
      i = paramBitmap.getWidth();
    }
    try
    {
      localBitmap = Bitmap.createBitmap(paramInt, i, paramBitmap.getConfig());
    }
    catch (Throwable localThrowable)
    {
      Bitmap localBitmap;
      label94:
      Canvas localCanvas;
      break label94;
    }
    localBitmap = null;
    if (localBitmap != null)
    {
      if (localBitmap == paramBitmap) {
        return paramBitmap;
      }
      localCanvas = new Canvas(localBitmap);
      paramInt = (paramInt - paramBitmap.getWidth()) / 2;
      i = (i - paramBitmap.getHeight()) / 2;
      if ((paramInt != 0) || (i != 0)) {
        localCanvas.translate(paramInt, i);
      }
      localCanvas.rotate(j, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2);
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      paramBitmap.recycle();
      return localBitmap;
    }
    return paramBitmap;
  }
  
  public static BitmapReference rotateBitmap(BitmapReference paramBitmapReference, int paramInt)
  {
    int j = paramInt % 360;
    if (j == 0) {
      return paramBitmapReference;
    }
    int i;
    if (((j > 45) && (j < 135)) || ((j > 225) && (j < 315))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      paramInt = paramBitmapReference.getWidth();
    } else {
      paramInt = paramBitmapReference.getHeight();
    }
    if (i == 0) {
      i = paramBitmapReference.getHeight();
    } else {
      i = paramBitmapReference.getWidth();
    }
    try
    {
      localBitmapReference = ImageManager.getInstance().getBitmap(paramInt, i, paramBitmapReference.getConfig());
    }
    catch (Throwable localThrowable)
    {
      BitmapReference localBitmapReference;
      label97:
      Canvas localCanvas;
      break label97;
    }
    localBitmapReference = null;
    if (localBitmapReference != null)
    {
      if (localBitmapReference == paramBitmapReference) {
        return paramBitmapReference;
      }
      localCanvas = new Canvas(localBitmapReference.getBitmap());
      paramInt = (paramInt - paramBitmapReference.getWidth()) / 2;
      i = (i - paramBitmapReference.getHeight()) / 2;
      if ((paramInt != 0) || (i != 0)) {
        localCanvas.translate(paramInt, i);
      }
      localCanvas.rotate(j, paramBitmapReference.getWidth() / 2, paramBitmapReference.getHeight() / 2);
      localCanvas.drawBitmap(paramBitmapReference.getBitmap(), 0.0F, 0.0F, null);
      paramBitmapReference.release();
      return localBitmapReference;
    }
    return paramBitmapReference;
  }
  
  /* Error */
  public static void saveBitmapToFile(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: new 163	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 166	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_1
    //   13: new 441	java/io/BufferedOutputStream
    //   16: dup
    //   17: new 443	java/io/FileOutputStream
    //   20: dup
    //   21: aload_2
    //   22: invokespecial 446	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   25: invokespecial 449	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore_2
    //   29: aload_0
    //   30: getstatic 133	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   33: bipush 100
    //   35: aload_2
    //   36: invokevirtual 146	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   39: pop
    //   40: aload_2
    //   41: invokevirtual 452	java/io/BufferedOutputStream:flush	()V
    //   44: aload_2
    //   45: invokevirtual 455	java/io/BufferedOutputStream:close	()V
    //   48: return
    //   49: astore_0
    //   50: invokestatic 181	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   53: astore_1
    //   54: new 208	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   61: astore_2
    //   62: aload_2
    //   63: ldc_w 457
    //   66: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_2
    //   71: aload_0
    //   72: invokevirtual 458	java/io/IOException:getMessage	()Ljava/lang/String;
    //   75: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_1
    //   80: ldc 14
    //   82: iconst_1
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload_2
    //   89: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: aastore
    //   93: invokeinterface 224 3 0
    //   98: return
    //   99: astore_0
    //   100: aload_2
    //   101: astore_1
    //   102: goto +139 -> 241
    //   105: astore_1
    //   106: aload_2
    //   107: astore_0
    //   108: aload_1
    //   109: astore_2
    //   110: goto +10 -> 120
    //   113: astore_0
    //   114: goto +127 -> 241
    //   117: astore_2
    //   118: aload_3
    //   119: astore_0
    //   120: aload_0
    //   121: astore_1
    //   122: invokestatic 181	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   125: astore_3
    //   126: aload_0
    //   127: astore_1
    //   128: new 208	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   135: astore 4
    //   137: aload_0
    //   138: astore_1
    //   139: aload 4
    //   141: ldc_w 457
    //   144: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_0
    //   149: astore_1
    //   150: aload 4
    //   152: aload_2
    //   153: invokevirtual 459	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   156: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_0
    //   161: astore_1
    //   162: aload_3
    //   163: ldc 14
    //   165: iconst_1
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload 4
    //   173: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: aastore
    //   177: invokeinterface 224 3 0
    //   182: aload_0
    //   183: ifnull +57 -> 240
    //   186: aload_0
    //   187: invokevirtual 455	java/io/BufferedOutputStream:close	()V
    //   190: return
    //   191: astore_0
    //   192: invokestatic 181	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   195: astore_1
    //   196: new 208	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   203: astore_2
    //   204: aload_2
    //   205: ldc_w 457
    //   208: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_2
    //   213: aload_0
    //   214: invokevirtual 458	java/io/IOException:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_1
    //   222: ldc 14
    //   224: iconst_1
    //   225: anewarray 4	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: aload_2
    //   231: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: aastore
    //   235: invokeinterface 224 3 0
    //   240: return
    //   241: aload_1
    //   242: ifnull +59 -> 301
    //   245: aload_1
    //   246: invokevirtual 455	java/io/BufferedOutputStream:close	()V
    //   249: goto +52 -> 301
    //   252: astore_1
    //   253: invokestatic 181	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   256: astore_2
    //   257: new 208	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 209	java/lang/StringBuilder:<init>	()V
    //   264: astore_3
    //   265: aload_3
    //   266: ldc_w 457
    //   269: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload_3
    //   274: aload_1
    //   275: invokevirtual 458	java/io/IOException:getMessage	()Ljava/lang/String;
    //   278: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload_2
    //   283: ldc 14
    //   285: iconst_1
    //   286: anewarray 4	java/lang/Object
    //   289: dup
    //   290: iconst_0
    //   291: aload_3
    //   292: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: aastore
    //   296: invokeinterface 224 3 0
    //   301: aload_0
    //   302: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramBitmap	Bitmap
    //   0	303	1	paramString	String
    //   8	102	2	localObject1	Object
    //   117	36	2	localException	java.lang.Exception
    //   203	80	2	localObject2	Object
    //   10	282	3	localObject3	Object
    //   135	37	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   44	48	49	java/io/IOException
    //   29	44	99	finally
    //   29	44	105	java/lang/Exception
    //   13	29	113	finally
    //   122	126	113	finally
    //   128	137	113	finally
    //   139	148	113	finally
    //   150	160	113	finally
    //   162	182	113	finally
    //   13	29	117	java/lang/Exception
    //   186	190	191	java/io/IOException
    //   245	249	252	java/io/IOException
  }
  
  public static void setBitmapOptionInNativeAlloc(Object paramObject)
  {
    try
    {
      Field localField = paramObject.getClass().getDeclaredField("inNativeAlloc");
      localField.setAccessible(true);
      localField.setBoolean(paramObject, true);
      return;
    }
    catch (Throwable paramObject) {}
  }
  
  public static void trimToSize(LruCache paramLruCache, float paramFloat)
  {
    if (paramLruCache == null) {
      return;
    }
    if (paramFloat <= 1.0F)
    {
      if (paramFloat < 0.0F) {
        return;
      }
      int i = paramLruCache.size();
      int j = (int)(i * paramFloat);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("trimToSize  oldSize=");
      localStringBuilder.append(i);
      localStringBuilder.append(",newSize=");
      localStringBuilder.append(j);
      localStringBuilder.append(",ration=");
      localStringBuilder.append(paramFloat);
      ImageManagerLog.i("BitmapUtils", localStringBuilder.toString());
      paramLruCache.trimToSize(j);
    }
  }
  
  public static void trimToSize(LruCache paramLruCache, float paramFloat, int paramInt)
  {
    if (paramLruCache == null) {
      return;
    }
    if (paramFloat <= 1.0F)
    {
      if (paramFloat < 0.0F) {
        return;
      }
      int j = paramLruCache.size();
      int i = (int)(j * paramFloat);
      if (i >= paramInt) {
        paramInt = i;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("trimToSize  oldSize=");
      localStringBuilder.append(j);
      localStringBuilder.append(",newSize=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",ration=");
      localStringBuilder.append(paramFloat);
      ImageManagerLog.i("BitmapUtils", localStringBuilder.toString());
      paramLruCache.trimToSize(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.utils.BitmapUtils
 * JD-Core Version:    0.7.0.1
 */