package com.tencent.av.core;

public class VcControllerImpl$DeviceCMDTLV
{
  public int a;
  public long a;
  String jdField_a_of_type_JavaLangString;
  public int b;
  
  public VcControllerImpl$DeviceCMDTLV(VcControllerImpl paramVcControllerImpl) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" uin : ");
    localStringBuilder2.append(this.jdField_a_of_type_Long);
    localStringBuilder2.append(" operation : ");
    localStringBuilder2.append(this.jdField_a_of_type_Int);
    localStringBuilder2.append(" opvalue : ");
    localStringBuilder2.append(this.b);
    localStringBuilder2.append(" nickname : ");
    localStringBuilder2.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.core.VcControllerImpl.DeviceCMDTLV
 * JD-Core Version:    0.7.0.1
 */