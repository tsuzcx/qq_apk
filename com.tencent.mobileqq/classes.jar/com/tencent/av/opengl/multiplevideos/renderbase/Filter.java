package com.tencent.av.opengl.multiplevideos.renderbase;

import android.util.Pair;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public abstract class Filter
  extends RenderObject
{
  private String jdField_a_of_type_JavaLangString;
  private List<Pair<Filter, Integer>> jdField_a_of_type_JavaUtilList;
  private Vector<RefFrame> jdField_a_of_type_JavaUtilVector;
  private boolean jdField_a_of_type_Boolean;
  
  public Filter(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("-");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilVector = new Vector(paramInt);
    this.jdField_a_of_type_JavaUtilVector.setSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.multiplevideos.renderbase.Filter
 * JD-Core Version:    0.7.0.1
 */