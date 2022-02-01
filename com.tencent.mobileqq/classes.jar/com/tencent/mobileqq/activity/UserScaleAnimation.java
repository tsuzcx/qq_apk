package com.tencent.mobileqq.activity;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class UserScaleAnimation
  extends Animation
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float c;
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = 1.0F;
    if (paramFloat < 0.1666667F)
    {
      paramFloat = (this.jdField_a_of_type_Float - 0.2F) * paramFloat / 0.1666667F + 0.2F;
      f1 = paramFloat;
    }
    for (;;)
    {
      paramTransformation.getMatrix().setScale(f1, paramFloat, this.jdField_a_of_type_Int * 0.5F, this.jdField_b_of_type_Int * 0.5F);
      return;
      if (paramFloat < 0.1666667F * 2.0F)
      {
        f1 = this.jdField_a_of_type_Float;
        paramFloat = (1.0F - this.jdField_a_of_type_Float) * (paramFloat - 0.1666667F) / 0.1666667F + f1;
        f1 = paramFloat;
      }
      else if (paramFloat < 0.1666667F * 3.0F)
      {
        paramFloat = 1.0F + (this.jdField_b_of_type_Float - 1.0F) * (paramFloat - 0.1666667F * 2.0F) / 0.1666667F;
        f1 = paramFloat;
      }
      else if (paramFloat < 4.0F * 0.1666667F)
      {
        f1 = this.jdField_b_of_type_Float;
        paramFloat = (1.0F - this.jdField_b_of_type_Float) * (paramFloat - 0.1666667F * 3.0F) / 0.1666667F + f1;
        f1 = paramFloat;
      }
      else if (paramFloat < 5.0F * 0.1666667F)
      {
        paramFloat = 1.0F + (this.c - 1.0F) * (paramFloat - 4.0F * 0.1666667F) / 0.1666667F;
        f1 = paramFloat;
      }
      else if (paramFloat < 6.0F * 0.1666667F)
      {
        f1 = this.c;
        paramFloat = (1.0F - this.c) * (paramFloat - 5.0F * 0.1666667F) / 0.1666667F + f1;
        f1 = paramFloat;
      }
      else
      {
        float f2 = 1.0F;
        paramFloat = f1;
        f1 = f2;
      }
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UserScaleAnimation
 * JD-Core Version:    0.7.0.1
 */