package com.tencent.mobileqq.ar.arengine;

public class ARCloudReqFileInfo
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  
  public ARCloudReqFileInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARCloudReqFileInfo{fileName='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileFormat=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", previewPath='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo
 * JD-Core Version:    0.7.0.1
 */