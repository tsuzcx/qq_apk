package com.tencent.mobileqq.ar.arengine;

import java.util.ArrayList;

public class ARLocalFaceRecogResult
  extends ARLocalRecogResultBase
{
  public long a;
  public ArrayList a;
  public boolean a;
  
  public ARLocalFaceRecogResult()
  {
    this.b = 4L;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("ARLocalFaceRecogResult{recogType = ").append(this.b).append(",isTimeOut = ").append(this.jdField_a_of_type_Boolean).append(",frameIdx = ").append(this.jdField_a_of_type_Long).append(", faceDatas.size = ");
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilArrayList.size();; i = 0) {
      return i + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecogResult
 * JD-Core Version:    0.7.0.1
 */