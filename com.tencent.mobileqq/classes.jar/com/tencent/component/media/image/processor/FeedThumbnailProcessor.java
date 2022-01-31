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

public class FeedThumbnailProcessor
  extends CropByPivotProcessor
{
  public static final float INFINITESCALE = -1.0F;
  private final int mMaxHeight;
  private float mMaxScale = -1.0F;
  private final int mMaxWidth;
  
  public FeedThumbnailProcessor(int paramInt1, int paramInt2)
  {
    this.mMaxWidth = paramInt1;
    this.mMaxHeight = paramInt2;
  }
  
  public FeedThumbnailProcessor(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this(paramInt1, paramInt2);
    setPivotRate(paramFloat1, paramFloat2);
  }
  
  public int getType()
  {
    return 5;
  }
  
  public Drawable process(Drawable paramDrawable)
  {
    if ((this.mMaxWidth <= 0) || (this.mMaxHeight <= 0)) {}
    do
    {
      return paramDrawable;
      j = paramDrawable.getIntrinsicWidth();
      i = paramDrawable.getIntrinsicHeight();
    } while ((j == this.mMaxWidth) && (i == this.mMaxHeight) && (j * GOLDEN_CUDGEL_RATIO > i));
    float f2 = Math.min(this.mMaxWidth / j, this.mMaxHeight / i);
    float f1 = f2;
    if (this.mMaxScale != -1.0F)
    {
      f1 = f2;
      if (f2 > this.mMaxScale) {
        f1 = Math.min(f2, this.mMaxScale);
      }
    }
    int j = (int)(j * f1);
    int i = (int)Math.min(f1 * i, j * GOLDEN_CUDGEL_RATIO);
    if ((paramDrawable instanceof ImageDrawable)) {
      try
      {
        BitmapReference localBitmapReference = ((ImageDrawable)paramDrawable).getBitmapRef();
        Object localObject1 = localBitmapReference.getConfig();
        Object localObject2 = ImageManager.getInstance();
        paramDrawable = (Drawable)localObject1;
        if (localObject1 == null) {
          paramDrawable = Bitmap.Config.ARGB_8888;
        }
        paramDrawable = ((ImageManager)localObject2).getBitmap(j, i, paramDrawable);
        localObject1 = new Canvas(paramDrawable.getBitmap());
        localObject2 = new Matrix();
        ScaleDrawable.getMatrix((Matrix)localObject2, 10, localBitmapReference.getWidth(), localBitmapReference.getHeight(), j, i, this.mPivotXRate, this.mPivotYRate);
        ((Canvas)localObject1).drawBitmap(localBitmapReference.getBitmap(), (Matrix)localObject2, new Paint());
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
    return new SpecifiedDrawable(paramDrawable, j, i);
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.mMaxScale = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.processor.FeedThumbnailProcessor
 * JD-Core Version:    0.7.0.1
 */