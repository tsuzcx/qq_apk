package com.qflutter.tencent_vista_image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;

class TextureRenderer
{
  public static final int FIT_TYPE_CONTAIN = 1;
  public static final int FIT_TYPE_COVER = 2;
  public static final int FIT_TYPE_FILL = 0;
  public static final int FIT_TYPE_FITHEIGHT = 4;
  public static final int FIT_TYPE_FITWIDTH = 3;
  public static final int FIT_TYPE_NONE = 5;
  public static final int FIT_TYPE_SCALEDOWN = 6;
  static Matrix IDENTITY_MATRIX = new Matrix();
  static final String TAG = "TextureRenderer";
  static Paint paint = new Paint();
  
  static
  {
    paint.setAntiAlias(true);
  }
  
  static void render(Canvas paramCanvas, Bitmap paramBitmap, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBoolean)
    {
      paramCanvas.drawBitmap(paramBitmap, IDENTITY_MATRIX, null);
      return;
    }
    if (2 == paramInt1)
    {
      renderCoverType(paramCanvas, paramBitmap, paramInt2, paramInt3);
      return;
    }
    if (paramInt1 == 0)
    {
      renderFillType(paramCanvas, paramBitmap, paramInt2, paramInt3);
      return;
    }
    if (1 == paramInt1)
    {
      renderContainType(paramCanvas, paramBitmap, paramInt2, paramInt3);
      return;
    }
    if (3 == paramInt1)
    {
      renderFitWidthType(paramCanvas, paramBitmap, paramInt2, paramInt3);
      return;
    }
    PLog.e("TextureRenderer", "[render] not supported fitType");
  }
  
  private static void renderContainType(Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if ((i <= paramInt1) && (j <= paramInt2)) {}
    for (float f1 = 1.0F;; f1 = Math.min(paramInt1 / i, paramInt2 / j))
    {
      float f2 = Math.round((paramInt1 - i * f1) * 0.5F);
      float f3 = Math.round((paramInt2 - j * f1) * 0.5F);
      if (PLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[renderContainType] bmpWidth=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", bmpHeight=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", viewWidth=");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(", viewHeight=");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(", scale=");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append(", dx=");
        ((StringBuilder)localObject).append(f2);
        ((StringBuilder)localObject).append(", dy=");
        ((StringBuilder)localObject).append(f3);
        PLog.d("TextureRenderer", ((StringBuilder)localObject).toString());
      }
      Object localObject = new Matrix();
      ((Matrix)localObject).setScale(f1, f1);
      ((Matrix)localObject).postTranslate(f2, f3);
      paramCanvas.drawBitmap(paramBitmap, (Matrix)localObject, paint);
      return;
    }
  }
  
  private static void renderCoverType(Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f2;
    float f1;
    float f3;
    if (i * paramInt2 > paramInt1 * j)
    {
      f2 = paramInt2 * 1.0F / j;
      f1 = (paramInt1 - i * f2) * 0.5F;
      f3 = 0.0F;
    }
    for (;;)
    {
      if (PLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[renderCoverType] bmpWidth=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", bmpHeight=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", viewWidth=");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(", viewHeight=");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(", scale=");
        ((StringBuilder)localObject).append(f2);
        ((StringBuilder)localObject).append(", dx=");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append(", dy=");
        ((StringBuilder)localObject).append(f3);
        PLog.d("TextureRenderer", ((StringBuilder)localObject).toString());
      }
      Object localObject = new Matrix();
      ((Matrix)localObject).setScale(f2, f2);
      ((Matrix)localObject).postTranslate(f1, f3);
      paramCanvas.drawBitmap(paramBitmap, (Matrix)localObject, paint);
      return;
      f2 = paramInt1 * 1.0F / i;
      f3 = (paramInt2 - j * f2) * 0.5F;
      f1 = 0.0F;
    }
  }
  
  private static void renderFillType(Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (PLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[renderFillType] bmpWidth=");
      localStringBuilder.append(i);
      localStringBuilder.append(", bmpHeight=");
      localStringBuilder.append(j);
      localStringBuilder.append(", viewWidth=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", viewHeight=");
      localStringBuilder.append(paramInt2);
      PLog.d("TextureRenderer", localStringBuilder.toString());
    }
    paramCanvas.drawBitmap(paramBitmap, new Rect(0, 0, i, j), new Rect(0, 0, paramInt1, paramInt2), paint);
  }
  
  private static void renderFitWidthType(Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 * 1.0F / i;
    float f2 = Math.round((paramInt2 - j * f1) * 0.5F);
    if (PLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[renderFitWidthType] bmpWidth=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", bmpHeight=");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", viewWidth=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", viewHeight=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", scale=");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(", dx=0, dy=");
      ((StringBuilder)localObject).append(f2);
      PLog.d("TextureRenderer", ((StringBuilder)localObject).toString());
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(f1, f1);
    ((Matrix)localObject).postTranslate(0.0F, f2);
    paramCanvas.drawBitmap(paramBitmap, (Matrix)localObject, paint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.tencent_vista_image.TextureRenderer
 * JD-Core Version:    0.7.0.1
 */