package com.tencent.aelight.camera.ae.gif.giftext.view;

import android.graphics.drawable.BitmapDrawable;

class GifAnimationDrawable$Frame
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  
  public GifAnimationDrawable$Frame(int paramInt, long paramLong, BitmapDrawable paramBitmapDrawable)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = paramBitmapDrawable;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Frame{index=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", targetTime=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", drawable=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.view.GifAnimationDrawable.Frame
 * JD-Core Version:    0.7.0.1
 */