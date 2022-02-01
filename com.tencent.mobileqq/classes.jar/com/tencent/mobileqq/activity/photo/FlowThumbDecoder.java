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
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class FlowThumbDecoder
  extends BaseThumbDecoder
  implements BitmapDecoder
{
  static final int SCALE_MODE_BY_HEIGHT = 2;
  static final int SCALE_MODE_BY_WIDTH = 1;
  static final int SCALE_MODE_DEFAULT = 0;
  static final int SCALE_MODE_ERROR = -1;
  static final String TAG = "FlowThumbDecoder";
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
    sFlowItemHeight = localResources.getDimension(2131297120);
    sFlowItemMaxWidth = localResources.getDimension(2131297118);
    sFlowItemMinWidth = localResources.getDimension(2131297119);
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
  
  private static Rect getRect(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = null;
    if (paramInt1 == 1) {
      if ((paramInt4 == 90) || (paramInt4 == 270))
      {
        paramInt1 = paramLocalMediaInfo.thumbWidth * paramInt3 / paramLocalMediaInfo.thumbHeight;
        paramInt2 = (paramInt2 - paramInt1) / 2;
        localRect = new Rect(paramInt2, 0, paramInt1 + paramInt2, paramInt3);
      }
    }
    while (paramInt1 != 2)
    {
      return localRect;
      paramInt1 = paramLocalMediaInfo.thumbHeight * paramInt2 / paramLocalMediaInfo.thumbWidth;
      paramInt3 = (paramInt3 - paramInt1) / 2;
      return new Rect(0, paramInt3, paramInt2, paramInt1 + paramInt3);
    }
    if ((paramInt4 == 90) || (paramInt4 == 270))
    {
      paramInt1 = paramLocalMediaInfo.thumbHeight * paramInt2 / paramLocalMediaInfo.thumbWidth;
      paramInt3 = (paramInt3 - paramInt1) / 2;
      return new Rect(0, paramInt3, paramInt2, paramInt1 + paramInt3);
    }
    paramInt1 = paramLocalMediaInfo.thumbWidth * paramInt3 / paramLocalMediaInfo.thumbHeight;
    paramInt2 = (paramInt2 - paramInt1) / 2;
    return new Rect(paramInt2, 0, paramInt1 + paramInt2, paramInt3);
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
    if (paramInt == 1) {
      paramOptions.inSampleSize = calcSampleSizeByShortSide(paramOptions.outWidth, paramLocalMediaInfo.thumbWidth);
    }
    for (;;)
    {
      Object localObject = null;
      try
      {
        paramContext = getThumb(paramContext, paramLocalMediaInfo, paramOptions);
        if (paramContext == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ThumbDecoder", 2, "decode bitmap return null,maybe oom");
          }
          return paramContext;
          if (paramInt == 2)
          {
            paramOptions.inSampleSize = calcSampleSizeByShortSide(paramOptions.outHeight, paramLocalMediaInfo.thumbHeight);
            continue;
          }
          paramOptions.inSampleSize = calcSampleSizeByShortSide(paramOptions.outWidth, paramLocalMediaInfo.thumbWidth);
        }
      }
      catch (OutOfMemoryError paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = localObject;
        }
      }
    }
    return scaleBitmap(paramLocalMediaInfo, paramInt, paramContext);
  }
  
  protected static Bitmap getThumb(Context paramContext, LocalMediaInfo paramLocalMediaInfo, BitmapFactory.Options paramOptions)
  {
    int i = QAlbumUtil.getMediaType(paramLocalMediaInfo);
    Object localObject = null;
    if (i == 0) {
      localObject = realDecodeBitmap(paramLocalMediaInfo, paramOptions, "FlowThumbDecoder");
    }
    while (i != 1) {
      return localObject;
    }
    if (paramLocalMediaInfo.isSystemMeidaStore) {}
    for (paramContext = MediaStore.Video.Thumbnails.getThumbnail(paramContext.getContentResolver(), paramLocalMediaInfo._id, 1, paramOptions);; paramContext = ThumbnailUtils.createVideoThumbnail(paramLocalMediaInfo.path, 1))
    {
      localObject = paramContext;
      if (paramContext == null) {
        break;
      }
      paramOptions.outHeight = paramContext.getHeight();
      paramOptions.outWidth = paramContext.getWidth();
      return paramContext;
    }
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
  
  private static Bitmap scaleBitmap(LocalMediaInfo paramLocalMediaInfo, int paramInt, Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int k = paramLocalMediaInfo.orientation;
    if ((paramInt == 0) && (checkBitmapValid(paramLocalMediaInfo, paramBitmap, k))) {
      return paramBitmap;
    }
    Rect localRect1 = getRect(paramLocalMediaInfo, paramInt, i, j, k);
    Rect localRect2 = new Rect(0, 0, paramLocalMediaInfo.thumbWidth, paramLocalMediaInfo.thumbHeight);
    Bitmap localBitmap = Bitmap.createBitmap(paramLocalMediaInfo.thumbWidth, paramLocalMediaInfo.thumbHeight, Bitmap.Config.RGB_565);
    if (localBitmap != null)
    {
      new Canvas(localBitmap).drawBitmap(paramBitmap, localRect1, localRect2, new Paint(6));
      paramBitmap.recycle();
      paramLocalMediaInfo = localBitmap;
      if (k != 0) {
        paramLocalMediaInfo = rotate(localBitmap, k);
      }
      if (QLog.isColorLevel()) {
        QLog.i("FlowThumbDecoder", 2, "FlowThumbDecoder src " + localRect1 + ", dst " + localRect2);
      }
      return paramLocalMediaInfo;
    }
    return null;
  }
  
  public Bitmap getBitmap(URL paramURL)
  {
    paramURL = this.mContext;
    LocalMediaInfo localLocalMediaInfo = this.mInfo;
    int i = URLDrawableHelper.getExifRotation(localLocalMediaInfo.path);
    if ((i != 0) && (i != localLocalMediaInfo.orientation))
    {
      QLog.w("FlowThumbDecoder", 1, "FlowThumbDecoder rotation not same, rotation:" + i + " info orientation: " + localLocalMediaInfo.orientation);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.FlowThumbDecoder
 * JD-Core Version:    0.7.0.1
 */