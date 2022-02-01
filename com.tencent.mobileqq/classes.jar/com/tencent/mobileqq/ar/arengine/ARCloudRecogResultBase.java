package com.tencent.mobileqq.ar.arengine;

public class ARCloudRecogResultBase
{
  public ARCloudLBSLocationCheckResult a;
  public boolean a;
  
  public ARCloudRecogResultBase()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudLBSLocationCheckResult = null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARCloudRecogResultBase{hasLBSLocation = ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", checkResult = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudLBSLocationCheckResult);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudRecogResultBase
 * JD-Core Version:    0.7.0.1
 */