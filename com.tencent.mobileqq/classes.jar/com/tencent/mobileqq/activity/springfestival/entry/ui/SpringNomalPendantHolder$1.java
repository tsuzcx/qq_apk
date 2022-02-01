package com.tencent.mobileqq.activity.springfestival.entry.ui;

import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

class SpringNomalPendantHolder$1
  implements ValueAnimation.AnimationUpdateListener<Float>
{
  SpringNomalPendantHolder$1(SpringNomalPendantHolder paramSpringNomalPendantHolder) {}
  
  public void a(ValueAnimation<Float> paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    this.a.b = paramFloat1.floatValue();
    this.a.jdField_a_of_type_Float = (1.07F - (paramFloat1.floatValue() - 1.0F));
    if (this.a.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.b = paramFloat1.floatValue();
      this.a.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.jdField_a_of_type_Float = this.a.jdField_a_of_type_Float;
    }
    paramValueAnimation = this.a;
    paramValueAnimation.a((int)(paramValueAnimation.d * paramFloat1.floatValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.ui.SpringNomalPendantHolder.1
 * JD-Core Version:    0.7.0.1
 */