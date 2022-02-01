package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class ThumbDecoder
  extends BaseThumbDecoder
  implements BitmapDecoder
{
  static final String TAG = "ThumbDecoder";
  private float mDensity;
  private LocalMediaInfo mInfo;
  
  public ThumbDecoder(Context paramContext, LocalMediaInfo paramLocalMediaInfo)
  {
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
    this.mInfo = paramLocalMediaInfo;
  }
  
  static int calSampleSize(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 1;
    int i;
    if (paramInt1 > paramInt2) {
      i = paramInt2;
    }
    while (i > paramInt3 * 2)
    {
      j *= 2;
      i /= 2;
      continue;
      i = paramInt1;
    }
    return checkSquareLarge(paramInt1, paramInt2, paramInt3, j);
  }
  
  private static int checkSquareLarge(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = paramInt3 * paramInt3 * paramInt4 * paramInt4;
    while (paramInt1 * paramInt2 > paramInt3 * 4)
    {
      paramInt3 *= 4;
      paramInt4 *= 2;
    }
    return paramInt4;
  }
  
  public Bitmap getBitmap(URL paramURL)
  {
    Object localObject = this.mInfo;
    if (localObject != null)
    {
      paramURL = new BitmapFactory.Options();
      paramURL.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(((LocalMediaInfo)localObject).path, paramURL);
      paramURL.inSampleSize = calSampleSize(paramURL.outWidth, paramURL.outHeight, ((LocalMediaInfo)localObject).thumbWidth);
      paramURL.inJustDecodeBounds = false;
      paramURL = realDecodeBitmap((LocalMediaInfo)localObject, paramURL, "ThumbDecoder");
      if (paramURL == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ThumbDecoder", 2, "decode bitmap return null,maybe oom");
        }
        return paramURL;
      }
      int i = URLDrawableHelper.getExifRotation(((LocalMediaInfo)localObject).path);
      if (checkBitmapValid((LocalMediaInfo)localObject, paramURL, i)) {
        return paramURL;
      }
      int j = paramURL.getWidth();
      int k = paramURL.getHeight();
      Rect localRect = new Rect();
      RectF localRectF = new RectF(0.0F, 0.0F, ((LocalMediaInfo)localObject).thumbWidth, ((LocalMediaInfo)localObject).thumbWidth);
      if (j > k)
      {
        j = (j - k) / 2;
        localRect.set(j, 0, j + k, k + 0);
      }
      for (;;)
      {
        localObject = Bitmap.createBitmap(((LocalMediaInfo)localObject).thumbWidth, ((LocalMediaInfo)localObject).thumbWidth, Bitmap.Config.RGB_565);
        if (localObject == null) {
          break label273;
        }
        new Canvas((Bitmap)localObject).drawBitmap(paramURL, localRect, localRectF, new Paint(6));
        paramURL.recycle();
        paramURL = (URL)localObject;
        if (i == 0) {
          break;
        }
        return FlowThumbDecoder.rotate((Bitmap)localObject, i);
        k = (k - j) / 2;
        localRect.set(0, k, 0 + j, j + k);
      }
    }
    label273:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.ThumbDecoder
 * JD-Core Version:    0.7.0.1
 */