package com.tencent.biz.qqstory.takevideo.doodle.layer.model;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

public class SelectedItem
{
  public final Drawable a;
  public final String a;
  public final String b;
  
  public SelectedItem(@NonNull String paramString1, @NonNull String paramString2, Drawable paramDrawable)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public String toString()
  {
    return "SelectedItem{category='" + this.jdField_a_of_type_JavaLangString + '\'' + ", name='" + this.b + '\'' + ", drawable=" + this.jdField_a_of_type_AndroidGraphicsDrawableDrawable + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.layer.model.SelectedItem
 * JD-Core Version:    0.7.0.1
 */