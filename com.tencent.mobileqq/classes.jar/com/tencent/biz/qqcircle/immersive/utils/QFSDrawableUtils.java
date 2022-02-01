package com.tencent.biz.qqcircle.immersive.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageManager;
import com.tencent.qphone.base.util.QLog;

public class QFSDrawableUtils
{
  public static Drawable a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    paramDrawable = ImageManager.drawableToBitmap(paramDrawable);
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramInt1 / i, paramInt2 / j);
    try
    {
      paramDrawable = new BitmapDrawable(null, Bitmap.createBitmap(paramDrawable, 0, 0, i, j, localMatrix, true));
      return paramDrawable;
    }
    catch (Exception paramDrawable)
    {
      QLog.e("QFSDrawableUtils", 1, paramDrawable.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.utils.QFSDrawableUtils
 * JD-Core Version:    0.7.0.1
 */