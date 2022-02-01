package com.google.android.material.shape;

import android.view.View;
import android.widget.ScrollView;

public class InterpolateOnScrollPositionChangeHelper
{
  private View jdField_a_of_type_AndroidViewView;
  private ScrollView jdField_a_of_type_AndroidWidgetScrollView;
  private MaterialShapeDrawable jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private final int[] b;
  
  public void a()
  {
    ScrollView localScrollView = this.jdField_a_of_type_AndroidWidgetScrollView;
    if (localScrollView == null) {
      return;
    }
    if (localScrollView.getChildCount() != 0)
    {
      this.jdField_a_of_type_AndroidWidgetScrollView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_AndroidWidgetScrollView.getChildAt(0).getLocationInWindow(this.b);
      int k = this.jdField_a_of_type_AndroidViewView.getTop() - this.jdField_a_of_type_ArrayOfInt[1] + this.b[1];
      int i = this.jdField_a_of_type_AndroidViewView.getHeight();
      int j = this.jdField_a_of_type_AndroidWidgetScrollView.getHeight();
      if (k < 0)
      {
        this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.p(Math.max(0.0F, Math.min(1.0F, k / i + 1.0F)));
        this.jdField_a_of_type_AndroidViewView.invalidate();
        return;
      }
      k += i;
      if (k > j)
      {
        this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.p(Math.max(0.0F, Math.min(1.0F, 1.0F - (k - j) / i)));
        this.jdField_a_of_type_AndroidViewView.invalidate();
        return;
      }
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.i() != 1.0F)
      {
        this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.p(1.0F);
        this.jdField_a_of_type_AndroidViewView.invalidate();
      }
      return;
    }
    throw new IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.shape.InterpolateOnScrollPositionChangeHelper
 * JD-Core Version:    0.7.0.1
 */