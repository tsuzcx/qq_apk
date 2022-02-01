package com.tencent.mobileqq.adapter;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class MayKnowAdapter$4
  extends Animation
{
  MayKnowAdapter$4(MayKnowAdapter paramMayKnowAdapter, View paramView, int paramInt) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    double d1 = paramFloat;
    double d2 = Math.sqrt(d1) / 2.0D;
    Double.isNaN(d1);
    paramFloat = (float)(d1 * (d2 + 0.5D));
    paramTransformation = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    int i = this.jdField_a_of_type_Int;
    paramTransformation.width = (i - (int)(i * paramFloat));
    this.jdField_a_of_type_AndroidViewView.requestLayout();
    if (paramFloat <= 0.4F)
    {
      this.jdField_a_of_type_AndroidViewView.setAlpha((0.4F - Math.min(paramFloat, 0.4F)) / 0.4F);
      return;
    }
    if (paramFloat <= 0.99F)
    {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 4)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
        this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
      }
    }
    else if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 8)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
    }
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.MayKnowAdapter.4
 * JD-Core Version:    0.7.0.1
 */