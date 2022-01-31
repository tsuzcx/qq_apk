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
  implements BitmapDecoder
{
  private float jdField_a_of_type_Float;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  
  public ThumbDecoder(Context paramContext, LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3)
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
    return a(paramInt1, paramInt2, paramInt3, j);
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = paramInt3 * paramInt3 * paramInt4 * paramInt4;
    while (paramInt1 * paramInt2 > paramInt3 * 4)
    {
      paramInt3 *= 4;
      paramInt4 *= 2;
    }
    return paramInt4;
  }
  
  public Bitmap a(URL paramURL)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
    if (localObject != null)
    {
      paramURL = new BitmapFactory.Options();
      paramURL.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(((LocalMediaInfo)localObject).path, paramURL);
      paramURL.inSampleSize = a(paramURL.outWidth, paramURL.outHeight, ((LocalMediaInfo)localObject).thumbWidth);
      paramURL.inJustDecodeBounds = false;
      int i;
      int k;
      Rect localRect;
      RectF localRectF;
      try
      {
        paramURL = SafeBitmapFactory.decodeFile(((LocalMediaInfo)localObject).path, paramURL);
        if (paramURL == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ThumbDecoder", 2, "decode bitmap return null,maybe oom");
          }
          return paramURL;
        }
      }
      catch (OutOfMemoryError paramURL)
      {
        for (;;)
        {
          paramURL.printStackTrace();
          paramURL = null;
        }
        i = URLDrawableHelper.a(((LocalMediaInfo)localObject).path);
        if ((i == 0) && (paramURL.getWidth() == ((LocalMediaInfo)localObject).thumbWidth) && (paramURL.getHeight() == ((LocalMediaInfo)localObject).thumbWidth) && (paramURL.getConfig() == Bitmap.Config.RGB_565)) {
          return paramURL;
        }
        j = paramURL.getWidth();
        k = paramURL.getHeight();
        localRect = new Rect();
        localRectF = new RectF(0.0F, 0.0F, ((LocalMediaInfo)localObject).thumbWidth, ((LocalMediaInfo)localObject).thumbWidth);
        if (j <= k) {
          break label286;
        }
      }
      int j = (j - k) / 2;
      localRect.set(j, 0, j + k, k + 0);
      for (;;)
      {
        localObject = Bitmap.createBitmap(((LocalMediaInfo)localObject).thumbWidth, ((LocalMediaInfo)localObject).thumbWidth, Bitmap.Config.RGB_565);
        if (localObject == null) {
          break label312;
        }
        new Canvas((Bitmap)localObject).drawBitmap(paramURL, localRect, localRectF, new Paint(6));
        paramURL.recycle();
        paramURL = (URL)localObject;
        if (i == 0) {
          break;
        }
        return FlowThumbDecoder.a((Bitmap)localObject, i);
        label286:
        k = (k - j) / 2;
        localRect.set(0, k, 0 + j, j + k);
      }
    }
    label312:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.ThumbDecoder
 * JD-Core Version:    0.7.0.1
 */