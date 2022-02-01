package com.tencent.mobileqq.activity.aio.pluspanel;

import android.graphics.drawable.Drawable;
import org.jetbrains.annotations.NotNull;

public class PluginData
{
  public int a;
  public Drawable a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PluginData{drawable=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    localStringBuilder.append(", actionId=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", text='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", contentDescription='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isShowNew=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", appid=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", redDotId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", action='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", actionType='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.PluginData
 * JD-Core Version:    0.7.0.1
 */