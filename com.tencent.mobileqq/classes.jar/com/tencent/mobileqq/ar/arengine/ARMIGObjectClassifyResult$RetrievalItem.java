package com.tencent.mobileqq.ar.arengine;

public class ARMIGObjectClassifyResult$RetrievalItem
{
  public double a;
  public int a;
  public ARMIGObjectClassifyResult.LabelSource a;
  public String a;
  public boolean a;
  public byte[] a;
  public int b;
  public String b;
  public boolean b = false;
  public int c = 0;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g = "";
  
  public ARMIGObjectClassifyResult$RetrievalItem()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result:{sclass:");
    Object localObject = this.jdField_a_of_type_JavaLangString;
    String str = "";
    if (localObject == null) {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(",");
    localStringBuilder.append("sItemId:");
    localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$LabelSource;
    if (localObject != null) {
      localObject = ((ARMIGObjectClassifyResult.LabelSource)localObject).jdField_a_of_type_JavaLangString;
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(",");
    localStringBuilder.append("dProb:");
    localStringBuilder.append(this.jdField_a_of_type_Double);
    localStringBuilder.append(",");
    localStringBuilder.append("sTitle:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",");
    localStringBuilder.append("sWiki:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",");
    localStringBuilder.append("sJumpUrl:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",");
    localStringBuilder.append("sCdbRes:");
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localObject = str;
    if (arrayOfByte != null) {
      localObject = new String(arrayOfByte);
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(",");
    localStringBuilder.append("isAutoJump:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",");
    localStringBuilder.append("iNeedCheckLBS:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append("imageId:");
    localStringBuilder.append(this.g);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.RetrievalItem
 * JD-Core Version:    0.7.0.1
 */