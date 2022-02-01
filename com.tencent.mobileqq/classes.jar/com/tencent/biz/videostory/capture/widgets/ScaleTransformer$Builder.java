package com.tencent.biz.videostory.capture.widgets;

import android.support.annotation.FloatRange;

public class ScaleTransformer$Builder
{
  private ScaleTransformer a = new ScaleTransformer();
  private float b = 1.0F;
  
  public Builder a(@FloatRange(from=0.01D) float paramFloat)
  {
    ScaleTransformer.a(this.a, paramFloat);
    return this;
  }
  
  public ScaleTransformer a()
  {
    ScaleTransformer localScaleTransformer = this.a;
    ScaleTransformer.b(localScaleTransformer, this.b - ScaleTransformer.a(localScaleTransformer));
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.widgets.ScaleTransformer.Builder
 * JD-Core Version:    0.7.0.1
 */