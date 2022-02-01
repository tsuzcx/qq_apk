package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.support.annotation.FloatRange;

public class AECircleScaleTransformer$Builder
{
  private float jdField_a_of_type_Float = 1.0F;
  private AECircleScaleTransformer jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAECircleScaleTransformer = new AECircleScaleTransformer();
  
  public Builder a(@FloatRange(from=0.01D) float paramFloat)
  {
    AECircleScaleTransformer.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAECircleScaleTransformer, paramFloat);
    return this;
  }
  
  public AECircleScaleTransformer a()
  {
    AECircleScaleTransformer localAECircleScaleTransformer = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAECircleScaleTransformer;
    AECircleScaleTransformer.b(localAECircleScaleTransformer, this.jdField_a_of_type_Float - AECircleScaleTransformer.a(localAECircleScaleTransformer));
    return this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAECircleScaleTransformer;
  }
  
  public Builder b(@FloatRange(from=0.01D) float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AECircleScaleTransformer.Builder
 * JD-Core Version:    0.7.0.1
 */