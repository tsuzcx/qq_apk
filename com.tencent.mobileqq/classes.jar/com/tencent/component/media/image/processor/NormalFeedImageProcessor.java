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

public class NormalFeedImageProcessor
  extends CropByPivotProcessor
{
  private static final Paint mPaint = new Paint(6);
  private int defaultScaleType = 0;
  private boolean hasPivot = false;
  private int mHeight;
  private boolean mKeepOrigScale = false;
  private int mMaxHeight;
  private int mMaxWidth;
  private int mWidth;
  
  public NormalFeedImageProcessor(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public NormalFeedImageProcessor(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this(paramInt1, paramInt2);
    setPivotRate(paramFloat1, paramFloat2);
    if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F)) {
      this.hasPivot = true;
    }
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getType()
  {
    return 5;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public void keepOrigScale(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.mKeepOrigScale = paramBoolean;
    this.mMaxWidth = paramInt1;
    this.mMaxHeight = paramInt2;
  }
  
  public Drawable process(Drawable paramDrawable)
  {
    Object localObject1 = paramDrawable;
    if (this.mWidth > 0)
    {
      if (this.mHeight <= 0) {
        return paramDrawable;
      }
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if ((i == this.mWidth) && (j == this.mHeight) && ((paramDrawable instanceof SpecifiedBitmapDrawable))) {
        return paramDrawable;
      }
      int k;
      if ((this.mKeepOrigScale) && (i != 0) && (j != 0))
      {
        k = this.mWidth;
        if (k != 0)
        {
          int m = this.mHeight;
          if (m != 0)
          {
            float f = i * 1.0F / j;
            if (Math.abs(f - k * 1.0F / m) > 0.05D)
            {
              k = this.mMaxWidth;
              if (k != 0)
              {
                m = this.mMaxHeight;
                if (m != 0) {
                  if (f >= k * 1.0F / m)
                  {
                    this.mWidth = Math.min(i * 2, k);
                    this.mHeight = ((int)(this.mWidth / f));
                  }
                  else
                  {
                    this.mHeight = Math.min(j * 2, m);
                    this.mWidth = ((int)(this.mHeight * f));
                  }
                }
              }
            }
          }
        }
      }
      if ((i < j * 2) && (!this.hasPivot)) {
        i = this.defaultScaleType;
      } else {
        i = 10;
      }
      if ((paramDrawable instanceof ImageDrawable)) {
        try
        {
          BitmapReference localBitmapReference = ((ImageDrawable)paramDrawable).getBitmapRef();
          localObject1 = localBitmapReference.getConfig();
          Object localObject2 = ImageManager.getInstance();
          j = this.mWidth;
          k = this.mHeight;
          paramDrawable = (Drawable)localObject1;
          if (localObject1 == null) {
            paramDrawable = Bitmap.Config.ARGB_8888;
          }
          paramDrawable = ((ImageManager)localObject2).getBitmap(j, k, paramDrawable);
          localObject1 = new Canvas(paramDrawable.getBitmap());
          localObject2 = new Matrix();
          ScaleDrawable.getMatrix((Matrix)localObject2, i, localBitmapReference.getWidth(), localBitmapReference.getHeight(), this.mWidth, this.mHeight, this.mPivotXRate, this.mPivotYRate);
          if (localBitmapReference.isRecycled()) {
            return null;
          }
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
      paramDrawable = new ScaleDrawable(paramDrawable, i);
      paramDrawable.setPivot(this.mPivotXRate, this.mPivotYRate);
      localObject1 = new SpecifiedDrawable(paramDrawable, this.mWidth, this.mHeight);
    }
    return localObject1;
  }
  
  public void setDefaultScaleType(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    this.defaultScaleType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.processor.NormalFeedImageProcessor
 * JD-Core Version:    0.7.0.1
 */