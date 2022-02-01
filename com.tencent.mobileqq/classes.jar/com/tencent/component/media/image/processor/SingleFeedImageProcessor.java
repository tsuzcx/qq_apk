package com.tencent.component.media.image.processor;

import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.media.image.drawable.ScaleDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.media.image.drawable.SpecifiedDrawable;

public class SingleFeedImageProcessor
  extends CropByPivotProcessor
{
  private static final float DEFAULT_FEED_SCALE = 1.1F;
  private static final float MAX_WIDTH_SCALE = 2.0F;
  private static final Paint mPaint = new Paint(6);
  private final int mMaxHeight;
  private float mMaxScale;
  private final int mMaxWidth;
  
  public SingleFeedImageProcessor(int paramInt1, int paramInt2)
  {
    this.mMaxWidth = paramInt1;
    this.mMaxHeight = paramInt2;
  }
  
  public SingleFeedImageProcessor(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(paramInt1, paramInt2);
    setPivotRate(paramFloat1, paramFloat2);
    if (paramFloat3 <= 0.0F)
    {
      this.mMaxScale = 2.0F;
      return;
    }
    this.mMaxScale = paramFloat3;
  }
  
  public int getType()
  {
    return 5;
  }
  
  public Drawable process(Drawable paramDrawable)
  {
    Object localObject1 = paramDrawable;
    if (this.mMaxWidth > 0)
    {
      if (this.mMaxHeight <= 0) {
        return paramDrawable;
      }
      int k = paramDrawable.getIntrinsicWidth();
      int m = paramDrawable.getIntrinsicHeight();
      int n;
      int j;
      int i;
      float f1;
      if (k >= m)
      {
        n = this.mMaxWidth;
        j = k;
        i = m;
        if (k > n)
        {
          f1 = n / k;
          i = (int)(m * f1);
          j = n;
        }
      }
      else
      {
        n = this.mMaxHeight;
        j = k;
        i = m;
        if (m > n)
        {
          f1 = n / m;
          j = (int)(k * f1);
          i = n;
        }
      }
      boolean bool = paramDrawable instanceof ImageDrawable;
      if (bool)
      {
        localObject1 = (ImageDrawable)paramDrawable;
        m = ((ImageDrawable)localObject1).getBitmapWidth();
        k = ((ImageDrawable)localObject1).getBitmapHeight();
        if ((m > 0) && (k > 0))
        {
          f1 = j;
          float f3 = m;
          if (f1 / f3 > this.mMaxScale)
          {
            float f2 = 1.1F;
            j = this.mMaxHeight;
            f1 = f2;
            if (i >= j)
            {
              f1 = j / k;
              if (1.1F >= f1) {
                f1 = f2;
              }
            }
            j = (int)(f3 * f1);
            i = (int)(k * f1);
          }
        }
      }
      if (bool) {
        try
        {
          BitmapReference localBitmapReference = ((ImageDrawable)paramDrawable).getBitmapRef();
          localObject1 = localBitmapReference.getConfig();
          Object localObject2 = ImageManager.getInstance();
          paramDrawable = (Drawable)localObject1;
          if (localObject1 == null) {
            paramDrawable = Bitmap.Config.ARGB_8888;
          }
          paramDrawable = ((ImageManager)localObject2).getBitmap(j, i, paramDrawable);
          localObject1 = new Canvas(paramDrawable.getBitmap());
          localObject2 = new Matrix();
          ScaleDrawable.getMatrix((Matrix)localObject2, 10, localBitmapReference.getWidth(), localBitmapReference.getHeight(), j, i, this.mPivotXRate, this.mPivotYRate);
          ((Canvas)localObject1).drawBitmap(localBitmapReference.getBitmap(), (Matrix)localObject2, mPaint);
          if (!localBitmapReference.isRecycled()) {
            localBitmapReference.release();
          }
          paramDrawable = new SpecifiedBitmapDrawable(paramDrawable);
          return paramDrawable;
        }
        catch (OutOfMemoryError paramDrawable)
        {
          paramDrawable.printStackTrace();
          return null;
        }
      }
      paramDrawable = new ScaleDrawable(paramDrawable, 10);
      paramDrawable.setPivot(this.mPivotXRate, this.mPivotYRate);
      localObject1 = new SpecifiedDrawable(paramDrawable, j, i);
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.processor.SingleFeedImageProcessor
 * JD-Core Version:    0.7.0.1
 */