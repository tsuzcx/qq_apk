package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public class ARLocalMarkerRecogResult
  extends ARLocalRecogResultBase
{
  public float a;
  public int a;
  public long a;
  public ArCloudConfigInfo a;
  public String a;
  public float[] a;
  public float b;
  public int b;
  public float c = 0.0F;
  
  public ARLocalMarkerRecogResult()
  {
    this.jdField_b_of_type_Long = 1L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_a_of_type_ArrayOfFloat = null;
    this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
  }
  
  public String toString()
  {
    return "ARLocalMarkerRecogResult{recogType = " + this.jdField_b_of_type_Long + ", frameIdx = " + this.jdField_a_of_type_Long + ", state = " + this.jdField_a_of_type_Int + ", markerName = " + this.jdField_a_of_type_JavaLangString + ", markerType = " + this.jdField_b_of_type_Int + ", markerWidth = " + this.jdField_a_of_type_Float + ", markerHeight = " + this.jdField_b_of_type_Float + ", markerDiameter = " + this.c + ", pose = " + this.jdField_a_of_type_ArrayOfFloat + ", arResourceInfo = " + this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalMarkerRecogResult
 * JD-Core Version:    0.7.0.1
 */