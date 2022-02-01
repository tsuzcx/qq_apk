package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.animation.OvershootInterpolator;
import com.tencent.mobileqq.portal.SanHuaView;

public class HongbaoShowerActivity$MyOvershotInterpolator
  extends OvershootInterpolator
{
  private boolean jdField_a_of_type_Boolean;
  
  public HongbaoShowerActivity$MyOvershotInterpolator(HongbaoShowerActivity paramHongbaoShowerActivity) {}
  
  public float getInterpolation(float paramFloat)
  {
    if ((!this.jdField_a_of_type_Boolean) && (paramFloat > 0.7D))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityHongbaoShowerActivity.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
      this.jdField_a_of_type_ComTencentMobileqqActivityHongbaoShowerActivity.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_ComTencentMobileqqActivityHongbaoShowerActivity.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      HongbaoShowerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHongbaoShowerActivity).a();
    }
    return (float)(1.0D - Math.pow(2.718281828459045D, -paramFloat * 5.0F) * Math.cos(paramFloat * 8.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HongbaoShowerActivity.MyOvershotInterpolator
 * JD-Core Version:    0.7.0.1
 */