package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class EMImage
{
  public static final int IMAGE_FORMAT_BMP = 1;
  public static final int IMAGE_FORMAT_GIF = 4;
  public static final int IMAGE_FORMAT_JPG = 3;
  public static final int IMAGE_FORMAT_PNG = 2;
  public static final int IMAGE_FORMAT_RAW = 0;
  private Bitmap mBitmap = null;
  private byte[] mRawData = null;
  private int mType = 0;
  
  public static void callbackDrawText(int paramInt1, Canvas paramCanvas, Matrix paramMatrix, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2, boolean paramBoolean1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2, int paramInt7, int paramInt8)
  {
    if (paramCanvas == null) {
      return;
    }
    Object localObject = new StringBuilder("");
    ((StringBuilder)localObject).appendCodePoint(paramInt1);
    localObject = ((StringBuilder)localObject).toString();
    Paint localPaint = new Paint();
    localPaint.reset();
    localPaint.setColor(paramInt2);
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setTextSize(paramFloat4);
    paramCanvas.save();
    paramCanvas.setMatrix(paramMatrix);
    if (paramBoolean1) {
      if (paramInt6 != 0) {
        break label174;
      }
    }
    label174:
    for (paramFloat2 = 0.1F;; paramFloat2 = paramInt6)
    {
      localPaint.setShadowLayer(paramFloat2, paramInt4, paramInt5, paramInt3);
      paramCanvas.drawText((String)localObject, 0.0F, paramFloat1, localPaint);
      if (paramBoolean2)
      {
        localPaint.reset();
        localPaint.setStyle(Paint.Style.STROKE);
        localPaint.setColor(paramInt7);
        localPaint.setStrokeWidth(paramInt8);
        localPaint.setTextSize(paramFloat4);
        paramCanvas.drawText((String)localObject, 0.0F, paramFloat1, localPaint);
      }
      paramCanvas.restore();
      return;
    }
  }
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public byte[] getBytes()
  {
    return this.mRawData;
  }
  
  public int getType()
  {
    return this.mType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.EMImage
 * JD-Core Version:    0.7.0.1
 */