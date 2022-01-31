package com.tencent.component.media.image.processor;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.ScaleDrawable;
import com.tencent.component.media.image.drawable.SpecifiedDrawable;

public class CropByPivotProcessor
  extends ImageProcessor
{
  public static float GOLDEN_CUDGEL_RATIO = 1.78F;
  private static final float PIVOT_DEFAULT_VALUE = 0.0F;
  protected float mPivotXRate = 0.0F;
  protected float mPivotYRate = 0.0F;
  
  public CropByPivotProcessor() {}
  
  public CropByPivotProcessor(float paramFloat1, float paramFloat2)
  {
    setPivotRate(paramFloat1, paramFloat2);
  }
  
  public Drawable process(Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    paramDrawable = new ScaleDrawable(paramDrawable, 10);
    paramDrawable.setPivot(this.mPivotXRate, this.mPivotYRate);
    return new SpecifiedDrawable(paramDrawable, i, j);
  }
  
  public void setPivotRate(float paramFloat1, float paramFloat2)
  {
    if ((this.mPivotXRate != paramFloat1) || (this.mPivotYRate != paramFloat2))
    {
      this.mPivotXRate = paramFloat1;
      this.mPivotYRate = paramFloat2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.processor.CropByPivotProcessor
 * JD-Core Version:    0.7.0.1
 */