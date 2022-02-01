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
    if ((this.mWidth <= 0) || (this.mHeight <= 0)) {}
    int i;
    int j;
    do
    {
      return paramDrawable;
      i = paramDrawable.getIntrinsicWidth();
      j = paramDrawable.getIntrinsicHeight();
    } while ((i == this.mWidth) && (j == this.mHeight) && ((paramDrawable instanceof SpecifiedBitmapDrawable)));
    float f;
    if ((this.mKeepOrigScale) && (i != 0) && (j != 0) && (this.mWidth != 0) && (this.mHeight != 0))
    {
      f = i * 1.0F / j;
      if ((Math.abs(f - this.mWidth * 1.0F / this.mHeight) > 0.05D) && (this.mMaxWidth != 0) && (this.mMaxHeight != 0))
      {
        if (f < this.mMaxWidth * 1.0F / this.mMaxHeight) {
          break label323;
        }
        this.mWidth = Math.min(i * 2, this.mMaxWidth);
        this.mHeight = ((int)(this.mWidth / f));
      }
    }
    for (;;)
    {
      if ((i >= j * 2) || (this.hasPivot))
      {
        i = 10;
        label192:
        if (!(paramDrawable instanceof ImageDrawable)) {
          break;
        }
      }
      else
      {
        try
        {
          BitmapReference localBitmapReference = ((ImageDrawable)paramDrawable).getBitmapRef();
          Object localObject1 = localBitmapReference.getConfig();
          Object localObject2 = ImageManager.getInstance();
          j = this.mWidth;
          int k = this.mHeight;
          paramDrawable = (Drawable)localObject1;
          if (localObject1 == null) {
            paramDrawable = Bitmap.Config.ARGB_8888;
          }
          paramDrawable = ((ImageManager)localObject2).getBitmap(j, k, paramDrawable);
          localObject1 = new Canvas(paramDrawable.getBitmap());
          localObject2 = new Matrix();
          ScaleDrawable.getMatrix((Matrix)localObject2, i, localBitmapReference.getWidth(), localBitmapReference.getHeight(), this.mWidth, this.mHeight, this.mPivotXRate, this.mPivotYRate);
          boolean bool = localBitmapReference.isRecycled();
          if (bool)
          {
            return null;
            label323:
            this.mHeight = Math.min(j * 2, this.mMaxHeight);
            this.mWidth = ((int)(f * this.mHeight));
            continue;
            i = this.defaultScaleType;
            break label192;
          }
          else
          {
            ((Canvas)localObject1).drawBitmap(localBitmapReference.getBitmap(), (Matrix)localObject2, mPaint);
            if (!localBitmapReference.isRecycled()) {
              localBitmapReference.release();
            }
            paramDrawable = new SpecifiedBitmapDrawable(paramDrawable);
            return paramDrawable;
          }
        }
        catch (OutOfMemoryError paramDrawable)
        {
          paramDrawable.printStackTrace();
          return null;
        }
      }
    }
    paramDrawable = new ScaleDrawable(paramDrawable, i);
    paramDrawable.setPivot(this.mPivotXRate, this.mPivotYRate);
    return new SpecifiedDrawable(paramDrawable, this.mWidth, this.mHeight);
  }
  
  public void setDefaultScaleType(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    this.defaultScaleType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.processor.NormalFeedImageProcessor
 * JD-Core Version:    0.7.0.1
 */