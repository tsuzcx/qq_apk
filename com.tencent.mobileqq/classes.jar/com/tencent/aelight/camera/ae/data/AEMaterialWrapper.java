package com.tencent.aelight.camera.ae.data;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;

public class AEMaterialWrapper
{
  public int a;
  public MetaMaterial a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AEMaterialWrapper{id='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", material=");
    localStringBuilder.append(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
    localStringBuilder.append(", state=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEMaterialWrapper
 * JD-Core Version:    0.7.0.1
 */