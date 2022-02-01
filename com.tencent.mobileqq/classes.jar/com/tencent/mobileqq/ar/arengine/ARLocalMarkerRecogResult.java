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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARLocalMarkerRecogResult{recogType = ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", frameIdx = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", state = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", markerName = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", markerType = ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", markerWidth = ");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", markerHeight = ");
    localStringBuilder.append(this.jdField_b_of_type_Float);
    localStringBuilder.append(", markerDiameter = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", pose = ");
    localStringBuilder.append(this.jdField_a_of_type_ArrayOfFloat);
    localStringBuilder.append(", arResourceInfo = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalMarkerRecogResult
 * JD-Core Version:    0.7.0.1
 */