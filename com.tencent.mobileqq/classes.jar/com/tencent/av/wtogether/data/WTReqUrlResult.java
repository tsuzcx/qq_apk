package com.tencent.av.wtogether.data;

public class WTReqUrlResult
{
  public final int a;
  public final long a;
  public final WTFileInfo a;
  public String a;
  public final boolean a;
  public final int b;
  public String b;
  public boolean b;
  public final int c;
  public String c;
  public boolean c;
  public int d;
  
  public WTReqUrlResult(int paramInt1, long paramLong, int paramInt2, WTFileInfo paramWTFileInfo, int paramInt3, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo = paramWTFileInfo;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.d = -1;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public String toString()
  {
    return "ReqUrlResult{seq: " + this.jdField_b_of_type_Int + ",  fileInfo: " + this.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo + ", retryCnt: " + this.jdField_c_of_type_Int + ", needHttpsUrl: " + this.jdField_a_of_type_Boolean + ", url: " + this.jdField_a_of_type_JavaLangString + ", cookie: " + this.jdField_b_of_type_JavaLangString + ", errCode: " + this.d + ", errMsg: " + this.jdField_c_of_type_JavaLangString + ", isSuccess: " + this.jdField_c_of_type_Boolean + ", retry: " + this.jdField_b_of_type_Boolean + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.data.WTReqUrlResult
 * JD-Core Version:    0.7.0.1
 */