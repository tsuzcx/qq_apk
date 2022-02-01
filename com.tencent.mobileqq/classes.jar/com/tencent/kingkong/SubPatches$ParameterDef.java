package com.tencent.kingkong;

public class SubPatches$ParameterDef
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Index ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(": ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kingkong.SubPatches.ParameterDef
 * JD-Core Version:    0.7.0.1
 */