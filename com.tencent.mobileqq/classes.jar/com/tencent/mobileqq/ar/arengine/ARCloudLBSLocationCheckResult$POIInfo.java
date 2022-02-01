package com.tencent.mobileqq.ar.arengine;

public class ARCloudLBSLocationCheckResult$POIInfo
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c = 0;
  
  public ARCloudLBSLocationCheckResult$POIInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("POIInfo{latitude = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", longitude = ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", name = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", addr = ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", dist = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult.POIInfo
 * JD-Core Version:    0.7.0.1
 */