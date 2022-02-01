package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

public class CropHomingAnimator
  extends ValueAnimator
{
  private CropHomingEvaluator jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationCropHomingEvaluator;
  private boolean jdField_a_of_type_Boolean = false;
  
  public CropHomingAnimator()
  {
    setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  public void a(CropHomeing paramCropHomeing1, CropHomeing paramCropHomeing2)
  {
    setObjectValues(new Object[] { paramCropHomeing1, paramCropHomeing2 });
    this.jdField_a_of_type_Boolean = CropHomeing.a(paramCropHomeing1, paramCropHomeing2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    super.setObjectValues(paramVarArgs);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationCropHomingEvaluator == null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationCropHomingEvaluator = new CropHomingEvaluator();
    }
    setEvaluator(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAnimationCropHomingEvaluator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation.CropHomingAnimator
 * JD-Core Version:    0.7.0.1
 */