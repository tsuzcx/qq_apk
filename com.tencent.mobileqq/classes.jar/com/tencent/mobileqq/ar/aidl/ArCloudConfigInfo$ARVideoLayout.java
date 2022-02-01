package com.tencent.mobileqq.ar.aidl;

public class ArCloudConfigInfo$ARVideoLayout
{
  public float a;
  public int a;
  public float b;
  public int b;
  public float c = 0.0F;
  public float d = 0.0F;
  public float e = 0.0F;
  
  public ArCloudConfigInfo$ARVideoLayout()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Float = 2.0F;
    this.jdField_b_of_type_Float = 2.0F;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARVideoLayout {width: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", height: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", scaleX: ");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", scaleY: ");
    localStringBuilder.append(this.jdField_b_of_type_Float);
    localStringBuilder.append(", transX: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", transY: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", transZ: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.ARVideoLayout
 * JD-Core Version:    0.7.0.1
 */