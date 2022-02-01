package com.tencent.av.opengl.multiplevideos.renderbase;

import android.util.Log;
import java.util.LinkedList;
import java.util.List;

public abstract class ImageSource
{
  private String jdField_a_of_type_JavaLangString;
  private List<Filter> jdField_a_of_type_JavaUtilList;
  
  public ImageSource()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("-");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    Log.d(this.jdField_a_of_type_JavaLangString, "ImageSource: ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.multiplevideos.renderbase.ImageSource
 * JD-Core Version:    0.7.0.1
 */