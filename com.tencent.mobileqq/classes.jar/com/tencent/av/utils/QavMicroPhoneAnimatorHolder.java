package com.tencent.av.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

public final class QavMicroPhoneAnimatorHolder
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ClipDrawable jdField_a_of_type_AndroidGraphicsDrawableClipDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayerDrawable jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable;
  
  public QavMicroPhoneAnimatorHolder(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842111);
    this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable = ((ClipDrawable)this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842110));
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable = new LayerDrawable(new Drawable[] { this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable });
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setLayerInset(0, 0, 0, 0, 0);
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setLayerInset(1, 0, 0, 0, 0);
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable.setLevel(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.QavMicroPhoneAnimatorHolder
 * JD-Core Version:    0.7.0.1
 */