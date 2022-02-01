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
    return "materialId = " + this.jdField_a_of_type_Int + " ,repeatedReqFlag=" + this.jdField_b_of_type_Int + " kdPos=" + this.c + ",adPosID=" + this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.data.AdRequestData
 * JD-Core Version:    0.7.0.1
 */