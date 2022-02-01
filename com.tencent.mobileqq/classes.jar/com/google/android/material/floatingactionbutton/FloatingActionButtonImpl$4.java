package com.google.android.material.floatingactionbutton;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

class FloatingActionButtonImpl$4
  implements TypeEvaluator<Float>
{
  FloatEvaluator jdField_a_of_type_AndroidAnimationFloatEvaluator = new FloatEvaluator();
  
  FloatingActionButtonImpl$4(FloatingActionButtonImpl paramFloatingActionButtonImpl) {}
  
  public Float a(float paramFloat, Float paramFloat1, Float paramFloat2)
  {
    float f = this.jdField_a_of_type_AndroidAnimationFloatEvaluator.evaluate(paramFloat, paramFloat1, paramFloat2).floatValue();
    paramFloat = f;
    if (f < 0.1F) {
      paramFloat = 0.0F;
    }
    return Float.valueOf(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.4
 * JD-Core Version:    0.7.0.1
 */