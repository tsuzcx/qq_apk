package com.tencent.mobileqq.activity.aio.anim;

import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;

public class AIOEnterInAni
  extends TranslateAnimation
{
  public static volatile boolean a;
  public int a;
  
  public AIOEnterInAni()
  {
    this(1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
  }
  
  public AIOEnterInAni(int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3, int paramInt4, float paramFloat4)
  {
    super(paramInt1, paramFloat1, paramInt2, paramFloat2, paramInt3, paramFloat3, paramInt4, paramFloat4);
    this.jdField_a_of_type_Int = 0;
    jdField_a_of_type_Boolean = false;
  }
  
  public boolean getTransformation(long paramLong, Transformation paramTransformation)
  {
    this.jdField_a_of_type_Int += 1;
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int <= 2))
    {
      setStartTime(paramLong);
      if (this.jdField_a_of_type_Int == 2) {
        jdField_a_of_type_Boolean = true;
      }
    }
    return super.getTransformation(paramLong, paramTransformation);
  }
  
  public void reset()
  {
    this.jdField_a_of_type_Int = 0;
    jdField_a_of_type_Boolean = false;
    super.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AIOEnterInAni
 * JD-Core Version:    0.7.0.1
 */