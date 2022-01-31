package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.graphics.drawable.Drawable;

public class ReadInJoySkinAnimManager$PngWrapper
  implements Comparable
{
  public int a;
  public Drawable a;
  public String a;
  
  ReadInJoySkinAnimManager$PngWrapper(String paramString, int paramInt, Drawable paramDrawable)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public int a(PngWrapper paramPngWrapper)
  {
    if (this.jdField_a_of_type_Int < paramPngWrapper.jdField_a_of_type_Int) {
      return -1;
    }
    if (this.jdField_a_of_type_Int > paramPngWrapper.jdField_a_of_type_Int) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager.PngWrapper
 * JD-Core Version:    0.7.0.1
 */