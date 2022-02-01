package com.tencent.mobileqq.activity.recent.guidebanner;

import android.graphics.drawable.Drawable;

class NewerGuideBannerData
{
  final int jdField_a_of_type_Int;
  final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  final boolean jdField_a_of_type_Boolean;
  final boolean b;
  
  private NewerGuideBannerData(int paramInt, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  static NewerGuideBannerData a()
  {
    return new NewerGuideBannerData(2, null, false, false);
  }
  
  static NewerGuideBannerData a(Drawable paramDrawable, boolean paramBoolean)
  {
    return new NewerGuideBannerData(0, paramDrawable, paramBoolean, false);
  }
  
  static NewerGuideBannerData a(boolean paramBoolean)
  {
    return new NewerGuideBannerData(1, null, false, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerData
 * JD-Core Version:    0.7.0.1
 */