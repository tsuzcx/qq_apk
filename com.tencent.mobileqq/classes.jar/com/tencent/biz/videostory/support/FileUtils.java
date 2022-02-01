package com.tencent.biz.videostory.support;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.pic.Logger;

public class FileUtils
{
  private static float a(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2) {
      return 1.0F;
    }
    return paramInt2 * 1.0F / paramInt1;
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      localObject = paramBitmap;
      if (!paramBitmap.isRecycled())
      {
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        localObject = paramBitmap;
        if (i > 0)
        {
          if (j <= 0) {
            return paramBitmap;
          }
          int k = ((Long)VSConfigManager.a().a("SmartCutPicWidth", Long.valueOf(224L))).intValue();
          float f;
          if (i <= j) {
            f = a(i, k);
          } else {
            f = a(j, k);
          }
          k = (int)f;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(k * i);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(k * j);
          Logger.a("Q.videostory", "Q.videostory.capture", "resizeImage", ((StringBuilder)localObject).toString());
          localObject = new Matrix();
          ((Matrix)localObject).postScale(f, f);
          localObject = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, true);
        }
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.support.FileUtils
 * JD-Core Version:    0.7.0.1
 */