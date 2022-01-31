package com.tencent.mobileqq.armap.map;

public class ARGridMapViewDialog$LbsRedBagExtraData
{
  int a;
  public long a;
  public String a;
  public int b;
  long b;
  public long c;
  
  public ARGridMapViewDialog$LbsRedBagExtraData(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString, long paramLong3)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramLong3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("poiId:").append(this.jdField_a_of_type_Long).append(",taskId:").append(this.jdField_b_of_type_Long).append(",taskType:").append(this.jdField_a_of_type_Int).append(",distance:").append(this.jdField_b_of_type_Int).append(",packId:").append(this.jdField_a_of_type_JavaLangString).append(",adcode:").append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.ARGridMapViewDialog.LbsRedBagExtraData
 * JD-Core Version:    0.7.0.1
 */