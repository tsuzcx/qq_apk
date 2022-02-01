package com.tencent.component.media.image.processor;

import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.RawImageProcessor;

public class CropByPivotRawProcessor
  extends RawImageProcessor
{
  private static final Paint sPaint = new Paint(3);
  private final int mHeight;
  private final float mPivotX;
  private final float mPivotY;
  private final int mWidth;
  
  public CropByPivotRawProcessor(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mPivotX = paramFloat1;
    this.mPivotY = paramFloat2;
  }
  
  public static boolean isGoldenCudgel(int paramInt1, int paramInt2)
  {
    return Math.ceil(paramInt1 * CropByPivotProcessor.GOLDEN_CUDGEL_RATIO) < paramInt2;
  }
  
  public String id()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mWidth);
    localStringBuilder.append("#");
    localStringBuilder.append(this.mHeight);
    localStringBuilder.append("#");
    localStringBuilder.append(this.mPivotX);
    localStringBuilder.append("#");
    localStringBuilder.append(this.mPivotY);
    return localStringBuilder.toString();
  }
  
  public BitmapReference process(BitmapReference paramBitmapReference)
  {
    if (!isGoldenCudgel(paramBitmapReference.getWidth(), paramBitmapReference.getHeight())) {
      return paramBitmapReference;
    }
    int k = paramBitmapReference.getWidth();
    int j = paramBitmapReference.getHeight();
    int i = Math.min(this.mWidth, k);
    float f5 = this.mHeight;
    float f2 = i;
    float f3 = k;
    float f1 = f2 / f3;
    float f4 = j;
    j = (int)Math.min(f5, f1 * f4);
    if (i >= k) {
      f1 = 1.0F;
    }
    k = (int)(f3 * f1);
    int m = (int)(f4 * f1);
    int n = (int)(this.mPivotX * k);
    int i1 = (int)(this.mPivotY * m);
    if (k > i)
    {
      f3 = Math.min(n - f2 * 0.5F, k - i);
      f2 = f3;
      if (f3 >= 0.0F) {}
    }
    else
    {
      f2 = 0.0F;
    }
    if (m > j)
    {
      f4 = Math.min(i1 - j * 0.5F, m - j);
      f3 = f4;
      if (f4 >= 0.0F) {}
    }
    else
    {
      f3 = 0.0F;
    }
    BitmapReference localBitmapReference = ImageManager.getInstance().getBitmap(i, j, Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmapReference.getBitmap());
    localCanvas.translate(-f2, -f3);
    localCanvas.scale(f1, f1);
    localCanvas.drawBitmap(paramBitmapReference.getBitmap(), 0.0F, 0.0F, sPaint);
    return localBitmapReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.processor.CropByPivotRawProcessor
 * JD-Core Version:    0.7.0.1
 */