package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.support.annotation.FloatRange;

public class AECircleScaleTransformer$Builder
{
  private AECircleScaleTransformer a = new AECircleScaleTransformer();
  private float b = 1.0F;
  
  public Builder a(@FloatRange(from=0.01D) float paramFloat)
  {
    AECircleScaleTransformer.a(this.a, paramFloat);
    return this;
  }
  
  public AECircleScaleTransformer a()
  {
    AECircleScaleTransformer localAECircleScaleTransformer = this.a;
    AECircleScaleTransformer.b(localAECircleScaleTransformer, this.b - AECircleScaleTransformer.a(localAECircleScaleTransformer));
    return this.a;
  }
  
  public Builder b(@FloatRange(from=0.01D) float paramFloat)
  {
    this.b = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AECircleScaleTransformer.Builder
 * JD-Core Version:    0.7.0.1
 */