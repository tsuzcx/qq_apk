package com.etrump.mixlayout;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import fe;

public class AnimatedImageDrawable
  extends AnimationDrawable
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private fe jdField_a_of_type_Fe;
  
  public int a()
  {
    return getDuration(this.jdField_a_of_type_Int);
  }
  
  public Drawable a()
  {
    return getFrame(this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = ((this.jdField_a_of_type_Int + 1) % getNumberOfFrames());
    if (this.jdField_a_of_type_Fe != null) {
      this.jdField_a_of_type_Fe.a(this.jdField_a_of_type_AndroidViewView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.AnimatedImageDrawable
 * JD-Core Version:    0.7.0.1
 */