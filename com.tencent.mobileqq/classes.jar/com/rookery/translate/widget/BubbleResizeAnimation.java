package com.rookery.translate.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout.LayoutParams;

public class BubbleResizeAnimation
  extends Animation
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private int b;
  private int c;
  private int d;
  
  public BubbleResizeAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    setDuration(paramInt1);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)paramView.getLayoutParams());
    this.b = paramView.getMeasuredHeight();
    this.jdField_a_of_type_Int = paramView.getMeasuredWidth();
    this.d = (this.b + paramInt3);
    this.c = (this.jdField_a_of_type_Int + paramInt2);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if (paramFloat < 1.0F)
    {
      paramTransformation = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
      int i = this.b;
      paramTransformation.height = (i + (int)((this.d - i) * paramFloat));
      i = this.jdField_a_of_type_Int;
      paramTransformation.width = (i + (int)((this.c - i) * paramFloat));
      this.jdField_a_of_type_AndroidViewView.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.widget.BubbleResizeAnimation
 * JD-Core Version:    0.7.0.1
 */