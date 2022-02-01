package com.tencent.avgame.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.image.RegionDrawable;
import com.tencent.qphone.base.util.QLog;

public class MosaicUtil
{
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt == 0) {
      return paramBitmap;
    }
    return a(paramBitmap, paramInt, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    long l1 = System.currentTimeMillis();
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    if (QLog.isColorLevel()) {
      QLog.i("MosaicUtil", 2, "mosaic function call");
    }
    Bitmap localBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    while (paramInt2 < paramInt4)
    {
      int j;
      for (int i = paramInt3; i < paramInt5; i = j)
      {
        localPaint.setColor(paramBitmap.getPixel(paramInt2, i));
        int n = Math.min(k, paramInt2 + paramInt1);
        j = i + paramInt1;
        int i1 = Math.min(m, j);
        localCanvas.drawRect(paramInt2, i, n, i1, localPaint);
      }
      paramInt2 += paramInt1;
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("DrawTime: ");
      paramBitmap.append(l2 - l1);
      QLog.i("MosaicUtil", 2, paramBitmap.toString());
    }
    return localBitmap;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    Object localObject;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject).getBitmap() != null) {
        return ((BitmapDrawable)localObject).getBitmap();
      }
    }
    if ((paramDrawable instanceof RegionDrawable)) {
      return ((RegionDrawable)paramDrawable).getBitmap();
    }
    if ((paramDrawable.getIntrinsicWidth() > 0) && (paramDrawable.getIntrinsicHeight() > 0)) {
      localObject = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    } else {
      localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.util.MosaicUtil
 * JD-Core Version:    0.7.0.1
 */