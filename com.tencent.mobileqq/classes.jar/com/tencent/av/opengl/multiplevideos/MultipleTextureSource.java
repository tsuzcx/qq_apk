package com.tencent.av.opengl.multiplevideos;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.av.opengl.multiplevideos.renderbase.ImageSource;
import java.util.LinkedList;
import java.util.List;

public class MultipleTextureSource
  extends ImageSource
{
  private final String jdField_a_of_type_JavaLangString;
  private List<Frame> jdField_a_of_type_JavaUtilList;
  
  public MultipleTextureSource()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MultipleTextureSource-");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.multiplevideos.MultipleTextureSource
 * JD-Core Version:    0.7.0.1
 */