package com.tencent.biz.pubaccount.NativeAd.data;

public class AdRequestData
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  
  public AdRequestData()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Int == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("materialId = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" ,repeatedReqFlag=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" kdPos=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",adPosID=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.data.AdRequestData
 * JD-Core Version:    0.7.0.1
 */