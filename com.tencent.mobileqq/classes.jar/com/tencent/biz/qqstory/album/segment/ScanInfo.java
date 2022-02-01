package com.tencent.biz.qqstory.album.segment;

public class ScanInfo
{
  private long jdField_a_of_type_Long = -1L;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private long b;
  public String b;
  
  public ScanInfo()
  {
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScanInfo{lastAlbum=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", lastPic=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", isIncScan=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.segment.ScanInfo
 * JD-Core Version:    0.7.0.1
 */