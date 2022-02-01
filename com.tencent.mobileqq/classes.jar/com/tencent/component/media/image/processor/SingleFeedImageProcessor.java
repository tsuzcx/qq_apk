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
    if ((this.mMaxWidth <= 0) || (this.mMaxHeight <= 0)) {
      return paramDrawable;
    }
    int j = paramDrawable.getIntrinsicWidth();
    int i = paramDrawable.getIntrinsicHeight();
    float f1;
    if (j >= i)
    {
      if (j <= this.mMaxWidth) {
        break label403;
      }
      f1 = this.mMaxWidth / j;
      j = this.mMaxWidth;
      i = (int)(i * f1);
    }
    label403:
    for (;;)
    {
      Object localObject1;
      int k;
      if ((paramDrawable instanceof ImageDrawable))
      {
        localObject1 = (ImageDrawable)paramDrawable;
        int m = ((ImageDrawable)localObject1).getBitmapWidth();
        k = ((ImageDrawable)localObject1).getBitmapHeight();
        if ((m > 0) && (k > 0) && (j / m > this.mMaxScale))
        {
          float f2 = 1.1F;
          f1 = f2;
          if (i >= this.mMaxHeight)
          {
            f1 = this.mMaxHeight / k;
            if (1.1F >= f1) {
              f1 = f2;
            }
          }
          else
          {
            label153:
            i = (int)(m * f1);
            k = (int)(f1 * k);
            j = i;
          }
        }
      }
      for (;;)
      {
        if ((paramDrawable instanceof ImageDrawable))
        {
          try
          {
            BitmapReference localBitmapReference = ((ImageDrawable)paramDrawable).getBitmapRef();
            localObject1 = localBitmapReference.getConfig();
            Object localObject2 = ImageManager.getInstance();
            paramDrawable = (Drawable)localObject1;
            if (localObject1 == null) {
              paramDrawable = Bitmap.Config.ARGB_8888;
            }
            paramDrawable = ((ImageManager)localObject2).getBitmap(j, k, paramDrawable);
            localObject1 = new Canvas(paramDrawable.getBitmap());
            localObject2 = new Matrix();
            ScaleDrawable.getMatrix((Matrix)localObject2, 10, localBitmapReference.getWidth(), localBitmapReference.getHeight(), j, k, this.mPivotXRate, this.mPivotYRate);
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
          if (i <= this.mMaxHeight) {
            break label403;
          }
          f1 = this.mMaxHeight / i;
          i = this.mMaxHeight;
          j = (int)(j * f1);
          break;
          break label153;
        }
        paramDrawable = new ScaleDrawable(paramDrawable, 10);
        paramDrawable.setPivot(this.mPivotXRate, this.mPivotYRate);
        return new SpecifiedDrawable(paramDrawable, j, k);
        k = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.processor.SingleFeedImageProcessor
 * JD-Core Version:    0.7.0.1
 */