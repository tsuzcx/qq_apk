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
    Object localObject1 = paramDrawable;
    if (this.mMaxWidth > 0)
    {
      if (this.mMaxHeight <= 0) {
        return paramDrawable;
      }
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if ((i == this.mMaxWidth) && (j == this.mMaxHeight) && (i * GOLDEN_CUDGEL_RATIO > j)) {
        return paramDrawable;
      }
      float f1 = this.mMaxWidth;
      float f3 = i;
      f1 /= f3;
      float f2 = this.mMaxHeight;
      float f4 = j;
      f2 = Math.min(f1, f2 / f4);
      float f5 = this.mMaxScale;
      f1 = f2;
      if (f5 != -1.0F)
      {
        f1 = f2;
        if (f2 > f5) {
          f1 = Math.min(f2, f5);
        }
      }
      i = (int)(f3 * f1);
      j = (int)Math.min(f4 * f1, i * GOLDEN_CUDGEL_RATIO);
      if ((paramDrawable instanceof ImageDrawable)) {
        try
        {
          BitmapReference localBitmapReference = ((ImageDrawable)paramDrawable).getBitmapRef();
          localObject1 = localBitmapReference.getConfig();
          Object localObject2 = ImageManager.getInstance();
          paramDrawable = (Drawable)localObject1;
          if (localObject1 == null) {
            paramDrawable = Bitmap.Config.ARGB_8888;
          }
          paramDrawable = ((ImageManager)localObject2).getBitmap(i, j, paramDrawable);
          localObject1 = new Canvas(paramDrawable.getBitmap());
          localObject2 = new Matrix();
          ScaleDrawable.getMatrix((Matrix)localObject2, 10, localBitmapReference.getWidth(), localBitmapReference.getHeight(), i, j, this.mPivotXRate, this.mPivotYRate);
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
      localObject1 = new SpecifiedDrawable(paramDrawable, i, j);
    }
    return localObject1;
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