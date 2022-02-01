package com.tencent.biz.videostory.capture.widgets;

import android.support.annotation.FloatRange;

public class ScaleTransformer$Builder
{
  private float jdField_a_of_type_Float = 1.0F;
  private ScaleTransformer jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsScaleTransformer = new ScaleTransformer();
  
  public Builder a(@FloatRange(from=0.01D) float paramFloat)
  {
    ScaleTransformer.a(this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsScaleTransformer, paramFloat);
    return this;
  }
  
  public ScaleTransformer a()
  {
    ScaleTransformer localScaleTransformer = this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsScaleTransformer;
    ScaleTransformer.b(localScaleTransformer, this.jdField_a_of_type_Float - ScaleTransformer.a(localScaleTransformer));
    return this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsScaleTransformer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.widgets.ScaleTransformer.Builder
 * JD-Core Version:    0.7.0.1
 */