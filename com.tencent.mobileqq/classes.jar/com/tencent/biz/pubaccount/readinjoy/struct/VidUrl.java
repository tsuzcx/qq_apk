package com.tencent.biz.pubaccount.readinjoy.struct;

public class VidUrl
{
  public long a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  
  public boolean a(long paramLong)
  {
    return (paramLong - this.jdField_a_of_type_Long > 0L) && (paramLong - this.jdField_a_of_type_Long < 25200L);
  }
  
  public String toString()
  {
    return "VidUrl {\n vid: " + this.jdField_a_of_type_JavaLangString + "\n url: " + this.b + "\n isH265: " + this.jdField_a_of_type_Boolean + "\n fileBitRate: " + this.c + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.VidUrl
 * JD-Core Version:    0.7.0.1
 */