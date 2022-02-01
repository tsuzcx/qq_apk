package com.google.android.material.slider;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.tooltip.TooltipDrawable;

class BaseSlider$1
  implements BaseSlider.TooltipDrawableFactory
{
  BaseSlider$1(BaseSlider paramBaseSlider, AttributeSet paramAttributeSet, int paramInt) {}
  
  public TooltipDrawable a()
  {
    TypedArray localTypedArray = ThemeEnforcement.a(this.jdField_a_of_type_ComGoogleAndroidMaterialSliderBaseSlider.getContext(), this.jdField_a_of_type_AndroidUtilAttributeSet, R.styleable.ar, this.jdField_a_of_type_Int, BaseSlider.jdField_a_of_type_Int, new int[0]);
    TooltipDrawable localTooltipDrawable = BaseSlider.a(this.jdField_a_of_type_ComGoogleAndroidMaterialSliderBaseSlider.getContext(), localTypedArray);
    localTypedArray.recycle();
    return localTooltipDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.slider.BaseSlider.1
 * JD-Core Version:    0.7.0.1
 */