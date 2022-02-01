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
    ScaleTransformer.b(this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsScaleTransformer, this.jdField_a_of_type_Float - ScaleTransformer.a(this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsScaleTransformer));
    return this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsScaleTransformer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.widgets.ScaleTransformer.Builder
 * JD-Core Version:    0.7.0.1
 */