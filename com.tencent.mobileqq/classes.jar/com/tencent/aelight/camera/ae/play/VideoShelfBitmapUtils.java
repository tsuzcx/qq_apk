package com.tencent.aelight.camera.ae.play;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;

public class VideoShelfBitmapUtils
{
  public static Bitmap resizeImage(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
  }
  
  public static Bitmap rotateWithExif(Bitmap paramBitmap, String paramString)
  {
    if (!BitmapUtils.isLegal(paramBitmap)) {
      return paramBitmap;
    }
    int i = BitmapUtils.getDegreeByExif(paramString) % 360;
    paramString = paramBitmap;
    if (i != 0) {
      paramString = BitmapUtils.rotateBitmap(paramBitmap, i);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.VideoShelfBitmapUtils
 * JD-Core Version:    0.7.0.1
 */