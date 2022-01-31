package com.tencent.mobileqq.armap.map;

public class ARGridMapViewDialog$POIExtarData
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public String c;
  
  public ARGridMapViewDialog$POIExtarData(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("poiId:").append(this.jdField_a_of_type_Long).append(",taskId:").append(this.jdField_b_of_type_Long).append(",taskType:").append(this.jdField_a_of_type_Int).append(",distanse:").append(this.jdField_b_of_type_Int).append(",busiName:").append(this.jdField_a_of_type_JavaLangString).append(",busiJumpUrl:").append(this.jdField_b_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.ARGridMapViewDialog.POIExtarData
 * JD-Core Version:    0.7.0.1
 */