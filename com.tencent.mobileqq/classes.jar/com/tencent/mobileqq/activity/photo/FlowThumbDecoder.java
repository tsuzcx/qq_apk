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
  static final String TAG = "QQAlbum";
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
    sFlowItemHeight = localResources.getDimension(2131297483);
    sFlowItemMaxWidth = localResources.getDimension(2131297481);
    sFlowItemMinWidth = localResources.getDimension(2131297482);
    float f1 = sFlowItemMaxWidth;
    float f2 = sFlowItemHeight;
    sRatioMax = f1 / f2;
    sRatioMin = sFlowItemMinWidth / f2;
    if (f2 != 0.0F)
    {
      this.mInfo = paramLocalMediaInfo;
      this.mContext = paramContext;
      return;
    }
    throw new RuntimeException("Not init item size...");
  }
  
  private static int calcSampleSizeByShortSide(int paramInt1, int paramInt2)
  {
    int i = 1;
    while (paramInt1 > paramInt2 * 1.2F)
    {
      i *= 2;
      paramInt1 /= 2;
    }
    return i;
  }
  
  public static void determineThumbSize(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2)
  {
    int i = getScaleMode(paramLocalMediaInfo, paramInt1, paramInt2);
    if (i == 0)
    {
      if (paramLocalMediaInfo.thumbWidth <= 0)
      {
        paramLocalMediaInfo.thumbWidth = (paramLocalMediaInfo.thumbHeight * paramInt1 / paramInt2);
        return;
      }
      if (paramLocalMediaInfo.thumbHeight <= 0) {
        paramLocalMediaInfo.thumbHeight = (paramLocalMediaInfo.thumbWidth * paramInt2 / paramInt1);
      }
    }
    else if (i == 1)
    {
      if (paramLocalMediaInfo.thumbWidth <= 0)
      {
        paramLocalMediaInfo.thumbWidth = ((int)sFlowItemMinWidth);
        return;
      }
      if (paramLocalMediaInfo.thumbHeight <= 0) {
        paramLocalMediaInfo.thumbHeight = ((int)sFlowItemMinWidth);
      }
    }
    else if (i == 2)
    {
      if (paramLocalMediaInfo.thumbWidth <= 0)
      {
        paramLocalMediaInfo.thumbWidth = ((int)sFlowItemMaxWidth);
        return;
      }
      if (paramLocalMediaInfo.thumbHeight <= 0) {
        paramLocalMediaInfo.thumbHeight = ((int)sFlowItemMaxWidth);
      }
    }
  }
  
  private static Rect getRect(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 == 1)
    {
      if ((paramInt4 != 90) && (paramInt4 != 270))
      {
        paramInt1 = paramLocalMediaInfo.thumbHeight * paramInt2 / paramLocalMediaInfo.thumbWidth;
        paramInt3 = (paramInt3 - paramInt1) / 2;
        return new Rect(0, paramInt3, paramInt2, paramInt1 + paramInt3);
      }
      paramInt1 = paramLocalMediaInfo.thumbWidth * paramInt3 / paramLocalMediaInfo.thumbHeight;
      paramInt2 = (paramInt2 - paramInt1) / 2;
      return new Rect(paramInt2, 0, paramInt1 + paramInt2, paramInt3);
    }
    if (paramInt1 == 2)
    {
      if ((paramInt4 != 90) && (paramInt4 != 270))
      {
        paramInt1 = paramLocalMediaInfo.thumbWidth * paramInt3 / paramLocalMediaInfo.thumbHeight;
        paramInt2 = (paramInt2 - paramInt1) / 2;
        return new Rect(paramInt2, 0, paramInt1 + paramInt2, paramInt3);
      }
      paramInt1 = paramLocalMediaInfo.thumbHeight * paramInt2 / paramLocalMediaInfo.thumbWidth;
      paramInt3 = (paramInt3 - paramInt1) / 2;
      return new Rect(0, paramInt3, paramInt2, paramInt1 + paramInt3);
    }
    return null;
  }
  
  public static int getScaleMode(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt2 == 0) {
        return -1;
      }
      float f1;
      float f2;
      if ((paramLocalMediaInfo.orientation != 90) && (paramLocalMediaInfo.orientation != 270))
      {
        f1 = paramInt1;
        f2 = paramInt2;
      }
      else
      {
        f1 = paramInt2;
        f2 = paramInt1;
      }
      f1 /= f2;
      if ((Float.compare(f1, sRatioMin) != -1) && (Float.compare(f1, sRatioMax) != 1)) {
        return 0;
      }
      if (Float.compare(f1, sRatioMin) == -1) {
        return 1;
      }
      return 2;
    }
    return -1;
  }
  
  public static Bitmap getScaledBitmap(Context paramContext, LocalMediaInfo paramLocalMediaInfo, BitmapFactory.Options paramOptions, int paramInt)
  {
    if (paramInt == 1) {
      paramOptions.inSampleSize = calcSampleSizeByShortSide(paramOptions.outWidth, paramLocalMediaInfo.thumbWidth);
    } else if (paramInt == 2) {
      paramOptions.inSampleSize = calcSampleSizeByShortSide(paramOptions.outHeight, paramLocalMediaInfo.thumbHeight);
    } else {
      paramOptions.inSampleSize = calcSampleSizeByShortSide(paramOptions.outWidth, paramLocalMediaInfo.thumbWidth);
    }
    Object localObject = null;
    try
    {
      paramContext = getThumb(paramContext, paramLocalMediaInfo, paramOptions);
    }
    catch (OutOfMemoryError paramContext)
    {
      paramContext.printStackTrace();
      paramContext = localObject;
    }
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQAlbum", 2, "decode bitmap return null,maybe oom");
      }
      return paramContext;
    }
    return scaleBitmap(paramLocalMediaInfo, paramInt, paramContext);
  }
  
  protected static Bitmap getThumb(Context paramContext, LocalMediaInfo paramLocalMediaInfo, BitmapFactory.Options paramOptions)
  {
    int i = QAlbumUtil.getMediaType(paramLocalMediaInfo);
    if (i == 0) {
      return realDecodeBitmap(paramLocalMediaInfo, paramOptions, "QQAlbum");
    }
    if (i == 1)
    {
      if (paramLocalMediaInfo.isSystemMeidaStore) {
        paramContext = MediaStore.Video.Thumbnails.getThumbnail(paramContext.getContentResolver(), paramLocalMediaInfo._id, 1, paramOptions);
      } else {
        paramContext = ThumbnailUtils.createVideoThumbnail(paramLocalMediaInfo.path, 1);
      }
      paramLocalMediaInfo = paramContext;
      if (paramContext != null)
      {
        paramOptions.outHeight = paramContext.getHeight();
        paramOptions.outWidth = paramContext.getWidth();
        return paramContext;
      }
    }
    else
    {
      paramLocalMediaInfo = null;
    }
    return paramLocalMediaInfo;
  }
  
  public static Bitmap rotate(Bitmap paramBitmap, int paramInt)
  {
    if ((paramInt != 0) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Object localObject = new Matrix();
      ((Matrix)localObject).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
      try
      {
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
        if (paramBitmap != localObject)
        {
          paramBitmap.recycle();
          return localObject;
        }
      }
      catch (OutOfMemoryError paramBitmap)
      {
        throw paramBitmap;
      }
    }
    return paramBitmap;
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
      if (QLog.isColorLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("FlowThumbDecoder src ");
        paramBitmap.append(localRect1);
        paramBitmap.append(", dst ");
        paramBitmap.append(localRect2);
        QLog.i("QQAlbum", 2, paramBitmap.toString());
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FlowThumbDecoder rotation not same, rotation:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" info orientation: ");
      ((StringBuilder)localObject).append(localLocalMediaInfo.orientation);
      QLog.w("QQAlbum", 1, ((StringBuilder)localObject).toString());
      localLocalMediaInfo.orientation = i;
    }
    if ((i != 90) && (i != 270))
    {
      localLocalMediaInfo.thumbWidth = 0;
      localLocalMediaInfo.thumbHeight = ((int)sFlowItemHeight);
    }
    else
    {
      localLocalMediaInfo.thumbWidth = ((int)sFlowItemHeight);
      localLocalMediaInfo.thumbHeight = 0;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    getThumb(paramURL, localLocalMediaInfo, (BitmapFactory.Options)localObject);
    if ((((BitmapFactory.Options)localObject).outWidth != 0) && (((BitmapFactory.Options)localObject).outHeight != 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FlowThumbDecoder origin w ");
        localStringBuilder.append(((BitmapFactory.Options)localObject).outWidth);
        localStringBuilder.append(" h ");
        localStringBuilder.append(((BitmapFactory.Options)localObject).outHeight);
        QLog.i("QQAlbum", 2, localStringBuilder.toString());
      }
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      i = getScaleMode(localLocalMediaInfo, ((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight);
      if ((localLocalMediaInfo.thumbWidth <= 0) || (localLocalMediaInfo.thumbHeight <= 0)) {
        determineThumbSize(localLocalMediaInfo, ((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight);
      }
      return getScaledBitmap(paramURL, localLocalMediaInfo, (BitmapFactory.Options)localObject, i);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.FlowThumbDecoder
 * JD-Core Version:    0.7.0.1
 */