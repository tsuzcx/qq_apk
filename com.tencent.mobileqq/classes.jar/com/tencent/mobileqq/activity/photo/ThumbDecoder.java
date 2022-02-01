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
  static final String TAG = "QQAlbum";
  private float mDensity;
  private LocalMediaInfo mInfo;
  
  public ThumbDecoder(Context paramContext, LocalMediaInfo paramLocalMediaInfo)
  {
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
    this.mInfo = paramLocalMediaInfo;
  }
  
  static int calSampleSize(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (paramInt1 > paramInt2) {
      i = paramInt2;
    } else {
      i = paramInt1;
    }
    int j = 1;
    while (i > paramInt3 * 2)
    {
      j *= 2;
      i /= 2;
    }
    return checkSquareLarge(paramInt1, paramInt2, paramInt3, j);
  }
  
  private static int checkSquareLarge(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = paramInt3 * paramInt3 * paramInt4 * paramInt4;
    for (;;)
    {
      paramInt3 *= 4;
      if (paramInt1 * paramInt2 <= paramInt3) {
        break;
      }
      paramInt4 *= 2;
    }
    return paramInt4;
  }
  
  public Bitmap getBitmap(URL paramURL)
  {
    paramURL = this.mInfo;
    if (paramURL != null)
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramURL.path, (BitmapFactory.Options)localObject);
      ((BitmapFactory.Options)localObject).inSampleSize = calSampleSize(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight, paramURL.thumbWidth);
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      Bitmap localBitmap = realDecodeBitmap(paramURL, (BitmapFactory.Options)localObject, "QQAlbum");
      if (localBitmap == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ThumbDecoder", 2, "decode bitmap return null,maybe oom");
        }
        return localBitmap;
      }
      int i = URLDrawableHelper.getExifRotation(paramURL.path);
      if (checkBitmapValid(paramURL, localBitmap, i)) {
        return localBitmap;
      }
      int j = localBitmap.getWidth();
      int k = localBitmap.getHeight();
      Rect localRect = new Rect();
      RectF localRectF = new RectF(0.0F, 0.0F, paramURL.thumbWidth, paramURL.thumbWidth);
      if (j > k)
      {
        j = (j - k) / 2;
        localRect.set(j, 0, j + k, k + 0);
      }
      else
      {
        k = (k - j) / 2;
        localRect.set(0, k, j + 0, j + k);
      }
      localObject = Bitmap.createBitmap(paramURL.thumbWidth, paramURL.thumbWidth, Bitmap.Config.RGB_565);
      if (localObject != null)
      {
        new Canvas((Bitmap)localObject).drawBitmap(localBitmap, localRect, localRectF, new Paint(6));
        localBitmap.recycle();
        paramURL = (URL)localObject;
        if (i != 0) {
          paramURL = FlowThumbDecoder.rotate((Bitmap)localObject, i);
        }
        return paramURL;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.ThumbDecoder
 * JD-Core Version:    0.7.0.1
 */