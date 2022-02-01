package com.tencent.mobileqq.ar.keying;

public class KeyingParams
{
  public float a;
  public int a;
  public String a;
  public float b = 0.0F;
  public float c = 0.0F;
  public float d = 0.0F;
  public float e = 0.0F;
  public float f = 1.0F;
  public float g = 0.0F;
  public float h = 1.0F;
  public float i = 0.0F;
  
  public KeyingParams()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public KeyingParams(int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KeyingParams {keyType: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", screenColorR: ");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", screenColorG: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", screenColorB: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", uA: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", uD: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", u_threshold: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", u_clipBlack: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", u_clipWhite: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.keying.KeyingParams
 * JD-Core Version:    0.7.0.1
 */