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
    return this.mWidth + "#" + this.mHeight + "#" + this.mPivotX + "#" + this.mPivotY;
  }
  
  public BitmapReference process(BitmapReference paramBitmapReference)
  {
    if (!isGoldenCudgel(paramBitmapReference.getWidth(), paramBitmapReference.getHeight())) {
      return paramBitmapReference;
    }
    int k = paramBitmapReference.getWidth();
    int m = paramBitmapReference.getHeight();
    int i = Math.min(this.mWidth, k);
    int j = (int)Math.min(this.mHeight, i / k * m);
    float f3;
    int i1;
    float f1;
    if (i < k)
    {
      f3 = i / k;
      k = (int)(k * f3);
      m = (int)(m * f3);
      int n = (int)(this.mPivotX * k);
      i1 = (int)(this.mPivotY * m);
      if (k <= i) {
        break label270;
      }
      f1 = Math.min(n - i * 0.5F, k - i);
      if (f1 >= 0.0F) {
        break label267;
      }
      f1 = 0.0F;
    }
    for (;;)
    {
      if (m > j)
      {
        float f4 = Math.min(i1 - j * 0.5F, m - j);
        f2 = f4;
        if (f4 >= 0.0F) {}
      }
      for (float f2 = 0.0F;; f2 = 0.0F)
      {
        BitmapReference localBitmapReference = ImageManager.getInstance().getBitmap(i, j, Bitmap.Config.RGB_565);
        Canvas localCanvas = new Canvas(localBitmapReference.getBitmap());
        localCanvas.translate(-f1, -f2);
        localCanvas.scale(f3, f3);
        localCanvas.drawBitmap(paramBitmapReference.getBitmap(), 0.0F, 0.0F, sPaint);
        return localBitmapReference;
        f3 = 1.0F;
        break;
      }
      label267:
      continue;
      label270:
      f1 = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.processor.CropByPivotRawProcessor
 * JD-Core Version:    0.7.0.1
 */