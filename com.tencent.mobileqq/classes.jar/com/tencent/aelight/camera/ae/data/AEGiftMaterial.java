package com.tencent.aelight.camera.ae.data;

public class AEGiftMaterial
{
  long jdField_a_of_type_Long;
  AEARCakeMaterial jdField_a_of_type_ComTencentAelightCameraAeDataAEARCakeMaterial;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public AEARCakeMaterial a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeDataAEARCakeMaterial;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AEGiftMaterial{giftuin=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", materialInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEARCakeMaterial);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEGiftMaterial
 * JD-Core Version:    0.7.0.1
 */