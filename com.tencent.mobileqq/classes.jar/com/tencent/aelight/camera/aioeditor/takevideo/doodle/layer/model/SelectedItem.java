package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.model;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

public class SelectedItem
{
  public final int a;
  public final Drawable a;
  public final String a;
  public final String b;
  
  public SelectedItem(@NonNull String paramString1, @NonNull String paramString2, Drawable paramDrawable, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SelectedItem{");
    localStringBuilder.append("category='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", drawable=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    localStringBuilder.append(", isDynamic=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.model.SelectedItem
 * JD-Core Version:    0.7.0.1
 */