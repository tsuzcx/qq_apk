package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class FlowThumbDecoder
  implements BitmapDecoder
{
  public static float a;
  public static float b;
  public static float c;
  public static float d;
  public static float e;
  private Context jdField_a_of_type_AndroidContentContext;
  LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private float f;
  
  public FlowThumbDecoder(Context paramContext, LocalMediaInfo paramLocalMediaInfo)
  {
    this.f = paramContext.getResources().getDisplayMetrics().density;
    if (jdField_a_of_type_Float == 0.0F) {
      throw new RuntimeException("Not init item size...");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    int i = 1;
    while (paramInt1 > paramInt2)
    {
      i *= 2;
      paramInt1 /= 2;
    }
    return i;
  }
  
  public static int a(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return -1;
    }
    if ((paramLocalMediaInfo.orientation == 90) || (paramLocalMediaInfo.orientation == 270)) {}
    for (float f1 = paramInt2 / paramInt1; (Float.compare(f1, e) != -1) && (Float.compare(f1, d) != 1); f1 = paramInt1 / paramInt2) {
      return 0;
    }
    if (Float.compare(f1, e) == -1) {
      return 1;
    }
    return 2;
  }
  
  /* Error */
  protected static Bitmap a(Context paramContext, LocalMediaInfo paramLocalMediaInfo, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokestatic 79	com/tencent/mobileqq/utils/AlbumUtil:a	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)I
    //   7: istore_3
    //   8: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +28 -> 39
    //   14: ldc 87
    //   16: iconst_2
    //   17: new 89	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   24: ldc 92
    //   26: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload_3
    //   30: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: iload_3
    //   40: ifne +19 -> 59
    //   43: aload_1
    //   44: getfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   47: aload_2
    //   48: invokestatic 115	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   51: astore 4
    //   53: aload 4
    //   55: areturn
    //   56: astore_0
    //   57: aload_0
    //   58: athrow
    //   59: iload_3
    //   60: iconst_1
    //   61: if_icmpne -8 -> 53
    //   64: aload_1
    //   65: getfield 119	com/tencent/mobileqq/activity/photo/LocalMediaInfo:isSystemMeidaStore	Z
    //   68: ifeq +17 -> 85
    //   71: aload_0
    //   72: invokevirtual 123	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   75: aload_1
    //   76: getfield 127	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   79: iconst_1
    //   80: aload_2
    //   81: invokestatic 133	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   84: areturn
    //   85: aload_1
    //   86: getfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   89: iconst_1
    //   90: invokestatic 139	android/media/ThumbnailUtils:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   93: astore_0
    //   94: aload_0
    //   95: astore 4
    //   97: aload_2
    //   98: ifnull -45 -> 53
    //   101: aload_0
    //   102: astore 4
    //   104: aload_0
    //   105: ifnull -52 -> 53
    //   108: aload_2
    //   109: aload_0
    //   110: invokevirtual 145	android/graphics/Bitmap:getHeight	()I
    //   113: putfield 150	android/graphics/BitmapFactory$Options:outHeight	I
    //   116: aload_2
    //   117: aload_0
    //   118: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   121: putfield 156	android/graphics/BitmapFactory$Options:outWidth	I
    //   124: aload_0
    //   125: areturn
    //   126: astore_0
    //   127: aconst_null
    //   128: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramContext	Context
    //   0	129	1	paramLocalMediaInfo	LocalMediaInfo
    //   0	129	2	paramOptions	BitmapFactory.Options
    //   7	55	3	i	int
    //   1	102	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   43	53	56	finally
    //   43	53	126	java/lang/OutOfMemoryError
  }
  
  public static Bitmap a(Context paramContext, LocalMediaInfo paramLocalMediaInfo, BitmapFactory.Options paramOptions, int paramInt)
  {
    Object localObject = null;
    if (paramInt == 1) {
      paramOptions.inSampleSize = a(paramOptions.outWidth, paramLocalMediaInfo.thumbWidth);
    }
    int j;
    int k;
    int i;
    try
    {
      for (;;)
      {
        paramOptions = a(paramContext, paramLocalMediaInfo, paramOptions);
        if (paramOptions != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("ThumbDecoder", 2, "decode bitmap return null,maybe oom");
        }
        paramLocalMediaInfo = paramOptions;
        return paramLocalMediaInfo;
        if (paramInt == 2) {
          paramOptions.inSampleSize = a(paramOptions.outHeight, paramLocalMediaInfo.thumbHeight);
        } else {
          paramOptions.inSampleSize = a(paramOptions.outWidth, paramLocalMediaInfo.thumbWidth);
        }
      }
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramOptions = null;
      }
      j = paramOptions.getWidth();
      k = paramOptions.getHeight();
      i = paramLocalMediaInfo.orientation;
      if ((paramInt == 0) && (i == 0) && (j == paramLocalMediaInfo.thumbWidth) && (k == paramLocalMediaInfo.thumbHeight) && (paramOptions.getConfig() == Bitmap.Config.RGB_565)) {
        return paramOptions;
      }
      if (paramInt != 1) {
        break label389;
      }
    }
    if ((i == 90) || (i == 270))
    {
      paramInt = paramLocalMediaInfo.thumbWidth * k / paramLocalMediaInfo.thumbHeight;
      j = (j - paramInt) / 2;
      paramContext = new Rect(j, 0, paramInt + j, k);
    }
    for (;;)
    {
      label218:
      Rect localRect = new Rect(0, 0, paramLocalMediaInfo.thumbWidth, paramLocalMediaInfo.thumbHeight);
      Bitmap localBitmap = Bitmap.createBitmap(paramLocalMediaInfo.thumbWidth, paramLocalMediaInfo.thumbHeight, Bitmap.Config.RGB_565);
      paramLocalMediaInfo = localObject;
      if (localBitmap == null) {
        break;
      }
      new Canvas(localBitmap).drawBitmap(paramOptions, paramContext, localRect, new Paint(6));
      paramOptions.recycle();
      if (i != 0) {}
      for (paramOptions = a(localBitmap, i);; paramOptions = localBitmap)
      {
        paramLocalMediaInfo = paramOptions;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FlowThumbDecoder", 2, "FlowThumbDecoder src " + paramContext + ", dst " + localRect);
        return paramOptions;
        paramInt = paramLocalMediaInfo.thumbHeight * j / paramLocalMediaInfo.thumbWidth;
        k = (k - paramInt) / 2;
        paramContext = new Rect(0, k, j, paramInt + k);
        break label218;
        label389:
        if (paramInt != 2) {
          break label497;
        }
        if ((i == 90) || (i == 270))
        {
          paramInt = paramLocalMediaInfo.thumbHeight * j / paramLocalMediaInfo.thumbWidth;
          k = (k - paramInt) / 2;
          paramContext = new Rect(0, k, j, paramInt + k);
          break label218;
        }
        paramInt = paramLocalMediaInfo.thumbWidth * k / paramLocalMediaInfo.thumbHeight;
        j = (j - paramInt) / 2;
        paramContext = new Rect(j, 0, paramInt + j, k);
        break label218;
      }
      label497:
      paramContext = null;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Object localObject = paramBitmap;
    if (paramInt != 0)
    {
      localObject = paramBitmap;
      if (paramBitmap != null)
      {
        localObject = paramBitmap;
        if (!paramBitmap.isRecycled())
        {
          localObject = new Matrix();
          ((Matrix)localObject).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
        }
      }
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localObject = paramBitmap;
      if (paramBitmap != localBitmap)
      {
        paramBitmap.recycle();
        localObject = localBitmap;
      }
      return localObject;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      throw paramBitmap;
    }
  }
  
  public static void a(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2)
  {
    int i = a(paramLocalMediaInfo, paramInt1, paramInt2);
    if (i == 0) {
      if (paramLocalMediaInfo.thumbWidth <= 0) {
        paramLocalMediaInfo.thumbWidth = (paramLocalMediaInfo.thumbHeight * paramInt1 / paramInt2);
      }
    }
    label30:
    do
    {
      do
      {
        do
        {
          break label30;
          do
          {
            return;
          } while (paramLocalMediaInfo.thumbHeight > 0);
          paramLocalMediaInfo.thumbHeight = (paramLocalMediaInfo.thumbWidth * paramInt2 / paramInt1);
          return;
          if (i != 1) {
            break;
          }
          if (paramLocalMediaInfo.thumbWidth <= 0)
          {
            paramLocalMediaInfo.thumbWidth = ((int)c);
            return;
          }
        } while (paramLocalMediaInfo.thumbHeight > 0);
        paramLocalMediaInfo.thumbHeight = ((int)c);
        return;
      } while (i != 2);
      if (paramLocalMediaInfo.thumbWidth <= 0)
      {
        paramLocalMediaInfo.thumbWidth = ((int)b);
        return;
      }
    } while (paramLocalMediaInfo.thumbHeight > 0);
    paramLocalMediaInfo.thumbHeight = ((int)b);
  }
  
  public Bitmap a(URL paramURL)
  {
    paramURL = this.jdField_a_of_type_AndroidContentContext;
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
    int i = URLDrawableHelper.a(localLocalMediaInfo.path);
    if ((i == 90) || (i == 270)) {
      localLocalMediaInfo.thumbWidth = ((int)jdField_a_of_type_Float);
    }
    BitmapFactory.Options localOptions;
    for (localLocalMediaInfo.thumbHeight = 0;; localLocalMediaInfo.thumbHeight = ((int)jdField_a_of_type_Float))
    {
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      a(paramURL, localLocalMediaInfo, localOptions);
      if ((localOptions.outWidth != 0) && (localOptions.outHeight != 0)) {
        break;
      }
      return null;
      localLocalMediaInfo.thumbWidth = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FlowThumbDecoder", 2, "FlowThumbDecoder origin w " + localOptions.outWidth + " h " + localOptions.outHeight);
    }
    localOptions.inJustDecodeBounds = false;
    i = a(localLocalMediaInfo, localOptions.outWidth, localOptions.outHeight);
    if ((localLocalMediaInfo.thumbWidth <= 0) || (localLocalMediaInfo.thumbHeight <= 0)) {
      a(localLocalMediaInfo, localOptions.outWidth, localOptions.outHeight);
    }
    return a(paramURL, localLocalMediaInfo, localOptions, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.FlowThumbDecoder
 * JD-Core Version:    0.7.0.1
 */