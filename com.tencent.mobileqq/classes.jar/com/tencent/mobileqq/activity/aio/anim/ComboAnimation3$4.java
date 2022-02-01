package com.tencent.mobileqq.activity.aio.anim;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class ComboAnimation3$4
  extends Animation
{
  private float jdField_a_of_type_Float = 0.0F;
  private float b = 0.0F;
  
  ComboAnimation3$4(ComboAnimation3 paramComboAnimation3) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimComboAnimation3.jdField_a_of_type_Float;
    float f2 = 1.5F;
    float f1 = 0.0F;
    if (paramFloat < f3 * 5.0F)
    {
      paramFloat = f2;
    }
    else if (paramFloat < this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimComboAnimation3.jdField_a_of_type_Float * 13.0F)
    {
      f1 = (paramFloat - this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimComboAnimation3.jdField_a_of_type_Float * 5.0F) / (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimComboAnimation3.jdField_a_of_type_Float * 8.0F);
      paramFloat = 1.5F + (paramFloat - this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimComboAnimation3.jdField_a_of_type_Float * 5.0F) / (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimComboAnimation3.jdField_a_of_type_Float * 8.0F) * 0.5F;
      f1 = 0.5F - f1 * 0.5F;
    }
    else
    {
      paramFloat = 2.0F;
    }
    paramTransformation.setAlpha(f1);
    paramTransformation.getMatrix().setScale(paramFloat, paramFloat, this.jdField_a_of_type_Float, this.b);
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Float = (paramInt1 * 0.5F);
    this.b = (paramInt2 * 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.ComboAnimation3.4
 * JD-Core Version:    0.7.0.1
 */