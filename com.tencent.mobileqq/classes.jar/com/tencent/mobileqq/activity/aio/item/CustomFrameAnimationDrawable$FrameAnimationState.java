package com.tencent.mobileqq.activity.aio.item;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.NonNull;
import java.util.ArrayList;

public final class CustomFrameAnimationDrawable$FrameAnimationState
  extends Drawable.ConstantState
{
  int jdField_a_of_type_Int = -1;
  final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  public ArrayList<CustomFrameAnimationDrawable.OneFrame> a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 160;
  public ArrayList<Bitmap> b;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  boolean jdField_c_of_type_Boolean = true;
  int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean = false;
  
  public CustomFrameAnimationDrawable$FrameAnimationState()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  @NonNull
  public Drawable newDrawable()
  {
    return new CustomFrameAnimationDrawable(this, null, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new CustomFrameAnimationDrawable(this, paramResources, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.FrameAnimationState
 * JD-Core Version:    0.7.0.1
 */