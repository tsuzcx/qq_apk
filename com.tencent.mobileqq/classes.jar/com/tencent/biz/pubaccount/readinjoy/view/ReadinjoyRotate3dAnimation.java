package com.tencent.biz.pubaccount.readinjoy.view;

import android.graphics.drawable.Drawable;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.Rotate3dAnimation;

public class ReadinjoyRotate3dAnimation
  extends Rotate3dAnimation
{
  private final float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final float jdField_b_of_type_Float;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    paramFloat = this.jdField_a_of_type_Float + (this.jdField_b_of_type_Float - this.jdField_a_of_type_Float) * paramFloat;
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      if ((paramFloat <= 90.0F) || (paramFloat >= 270.0F)) {
        break label83;
      }
      if (this.jdField_a_of_type_Int != 1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_Int = 1;
      }
    }
    label83:
    while (this.jdField_a_of_type_Int == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_Int = 0;
  }
  
  public void cancel()
  {
    super.cancel();
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyRotate3dAnimation
 * JD-Core Version:    0.7.0.1
 */