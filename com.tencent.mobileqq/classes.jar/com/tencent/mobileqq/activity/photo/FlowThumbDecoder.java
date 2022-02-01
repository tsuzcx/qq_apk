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
import android.media.ThumbnailUtils;
import android.provider.MediaStore.Video.Thumbnails;
import android.util.DisplayMetrics;
import bdmc;
import beyq;
import bezb;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.SafeBitmapFactory.SafeDecodeOption;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashMap;

public class FlowThumbDecoder
  implements bezb
{
  static final int SCALE_MODE_BY_HEIGHT = 2;
  static final int SCALE_MODE_BY_WIDTH = 1;
  static final int SCALE_MODE_DEFAULT = 0;
  static final int SCALE_MODE_ERROR = -1;
  private static final String TAG = "FlowThumbDecoder";
  public static float sFlowItemHeight;
  public static float sFlowItemMaxWidth;
  public static float sFlowItemMinWidth;
  public static float sRatioMax;
  public static float sRatioMin;
  private Context mContext;
  private float mDensity;
  LocalMediaInfo mInfo;
  
  public FlowThumbDecoder(Context paramContext, LocalMediaInfo paramLocalMediaInfo)
  {
    Resources localResources = paramContext.getResources();
    this.mDensity = localResources.getDisplayMetrics().density;
    sFlowItemHeight = localResources.getDimension(2131297043);
    sFlowItemMaxWidth = localResources.getDimension(2131297041);
    sFlowItemMinWidth = localResources.getDimension(2131297042);
    sRatioMax = sFlowItemMaxWidth / sFlowItemHeight;
    sRatioMin = sFlowItemMinWidth / sFlowItemHeight;
    if (sFlowItemHeight == 0.0F) {
      throw new RuntimeException("Not init item size...");
    }
    this.mInfo = paramLocalMediaInfo;
    this.mContext = paramContext;
  }
  
  private static int calcSampleSizeByShortSide(int paramInt1, int paramInt2)
  {
    int i = 1;
    while (paramInt1 > 1.2F * paramInt2)
    {
      i *= 2;
      paramInt1 /= 2;
    }
    return i;
  }
  
  public static void determineThumbSize(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2)
  {
    int i = getScaleMode(paramLocalMediaInfo, paramInt1, paramInt2);
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
            paramLocalMediaInfo.thumbWidth = ((int)sFlowItemMinWidth);
            return;
          }
        } while (paramLocalMediaInfo.thumbHeight > 0);
        paramLocalMediaInfo.thumbHeight = ((int)sFlowItemMinWidth);
        return;
      } while (i != 2);
      if (paramLocalMediaInfo.thumbWidth <= 0)
      {
        paramLocalMediaInfo.thumbWidth = ((int)sFlowItemMaxWidth);
        return;
      }
    } while (paramLocalMediaInfo.thumbHeight > 0);
    paramLocalMediaInfo.thumbHeight = ((int)sFlowItemMaxWidth);
  }
  
  public static int getScaleMode(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return -1;
    }
    if ((paramLocalMediaInfo.orientation == 90) || (paramLocalMediaInfo.orientation == 270)) {}
    for (float f = paramInt2 / paramInt1; (Float.compare(f, sRatioMin) != -1) && (Float.compare(f, sRatioMax) != 1); f = paramInt1 / paramInt2) {
      return 0;
    }
    if (Float.compare(f, sRatioMin) == -1) {
      return 1;
    }
    return 2;
  }
  
  public static Bitmap getScaledBitmap(Context paramContext, LocalMediaInfo paramLocalMediaInfo, BitmapFactory.Options paramOptions, int paramInt)
  {
    Object localObject = null;
    if (paramInt == 1) {
      paramOptions.inSampleSize = calcSampleSizeByShortSide(paramOptions.outWidth, paramLocalMediaInfo.thumbWidth);
    }
    int j;
    int k;
    int i;
    try
    {
      for (;;)
      {
        paramOptions = getThumb(paramContext, paramLocalMediaInfo, paramOptions);
        if (paramOptions != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("ThumbDecoder", 2, "decode bitmap return null,maybe oom");
        }
        paramLocalMediaInfo = paramOptions;
        return paramLocalMediaInfo;
        if (paramInt == 2) {
          paramOptions.inSampleSize = calcSampleSizeByShortSide(paramOptions.outHeight, paramLocalMediaInfo.thumbHeight);
        } else {
          paramOptions.inSampleSize = calcSampleSizeByShortSide(paramOptions.outWidth, paramLocalMediaInfo.thumbWidth);
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
      for (paramOptions = rotate(localBitmap, i);; paramOptions = localBitmap)
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
  
  protected static Bitmap getThumb(Context paramContext, LocalMediaInfo paramLocalMediaInfo, BitmapFactory.Options paramOptions)
  {
    int i = QAlbumUtil.getMediaType(paramLocalMediaInfo);
    if (QLog.isColorLevel()) {
      QLog.d("FlowThumbDecoder", 2, "[getThumb] type = " + i);
    }
    if (i == 0) {
      try
      {
        paramContext = new SafeBitmapFactory.SafeDecodeOption();
        paramContext.inOptions = paramOptions;
        paramContext.inNeedFlashBackTest = true;
        paramLocalMediaInfo = SafeBitmapFactory.safeDecode(paramLocalMediaInfo.path, paramContext);
        if (QLog.isColorLevel()) {
          QLog.d("FlowThumbDecoder", 2, "FlowThumbDecoder regionDecodeInfo:" + paramContext.toString());
        }
        if ((!paramContext.isInJustDecodeBounds) && (paramContext.needRegionDecode))
        {
          paramOptions = paramContext.getInfo();
          paramOptions.put("from", "FlowThumbDecoder");
          bdmc localbdmc = bdmc.a(BaseApplication.getContext());
          boolean bool = paramContext.isGetBitmap;
          long l = paramContext.runTime;
          i = paramContext.rawHeight;
          localbdmc.a(null, "safeDecode", bool, l, paramContext.rawWidth * i, paramOptions, "");
        }
        return paramLocalMediaInfo;
      }
      catch (OutOfMemoryError paramContext)
      {
        paramContext = paramContext;
        return null;
      }
      finally {}
    }
    if (i == 1)
    {
      if (paramLocalMediaInfo.isSystemMeidaStore) {}
      for (paramContext = MediaStore.Video.Thumbnails.getThumbnail(paramContext.getContentResolver(), paramLocalMediaInfo._id, 1, paramOptions);; paramContext = ThumbnailUtils.createVideoThumbnail(paramLocalMediaInfo.path, 1))
      {
        paramLocalMediaInfo = paramContext;
        if (paramOptions == null) {
          break;
        }
        paramLocalMediaInfo = paramContext;
        if (paramContext == null) {
          break;
        }
        paramOptions.outHeight = paramContext.getHeight();
        paramOptions.outWidth = paramContext.getWidth();
        return paramContext;
      }
    }
    return null;
  }
  
  public static Bitmap rotate(Bitmap paramBitmap, int paramInt)
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
  
  public Bitmap getBitmap(URL paramURL)
  {
    paramURL = this.mContext;
    LocalMediaInfo localLocalMediaInfo = this.mInfo;
    int i = beyq.a(localLocalMediaInfo.path);
    if ((i != 0) && (i != localLocalMediaInfo.orientation))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FlowThumbDecoder", 2, "FlowThumbDecoder rotation not same, rotation:" + i + " info orientation: " + localLocalMediaInfo.orientation);
      }
      localLocalMediaInfo.orientation = i;
    }
    if ((i == 90) || (i == 270)) {
      localLocalMediaInfo.thumbWidth = ((int)sFlowItemHeight);
    }
    BitmapFactory.Options localOptions;
    for (localLocalMediaInfo.thumbHeight = 0;; localLocalMediaInfo.thumbHeight = ((int)sFlowItemHeight))
    {
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      getThumb(paramURL, localLocalMediaInfo, localOptions);
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
    i = getScaleMode(localLocalMediaInfo, localOptions.outWidth, localOptions.outHeight);
    if ((localLocalMediaInfo.thumbWidth <= 0) || (localLocalMediaInfo.thumbHeight <= 0)) {
      determineThumbSize(localLocalMediaInfo, localOptions.outWidth, localOptions.outHeight);
    }
    return getScaledBitmap(paramURL, localLocalMediaInfo, localOptions, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.FlowThumbDecoder
 * JD-Core Version:    0.7.0.1
 */