package com.tencent.mobileqq.apollo.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.qphone.base.util.QLog;

public class ApolloRecordUtil
{
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Paint localPaint = new Paint();
    localPaint.setColor(paramInt);
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawRect(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight(), localPaint);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    paramBitmap.recycle();
    return localBitmap;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt2 * paramInt1 * 4;
    byte[] arrayOfByte = new byte[i];
    if (i <= paramArrayOfByte.length)
    {
      i = paramInt2;
      while (i > 0)
      {
        System.arraycopy(paramArrayOfByte, (i - 1) * paramInt1 * 4, arrayOfByte, (paramInt2 - i) * paramInt1 * 4, paramInt1 * 4);
        i -= 1;
      }
    }
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt3)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("flipVerticalAndCropCenter originWidth < width error");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("<");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.e("[cmshow]ApolloRecordUtil", 1, ((StringBuilder)localObject).toString());
      return paramArrayOfByte;
    }
    Object localObject = new byte[paramInt2 * paramInt3 * 4];
    if (paramInt2 * paramInt1 * 4 <= paramArrayOfByte.length)
    {
      int i = paramInt2;
      while (i > 0)
      {
        System.arraycopy(paramArrayOfByte, (i - 1) * paramInt1 * 4 + (paramInt1 - paramInt3) / 2 * 4, localObject, (paramInt2 - i) * paramInt3 * 4, paramInt3 * 4);
        i -= 1;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloRecordUtil
 * JD-Core Version:    0.7.0.1
 */