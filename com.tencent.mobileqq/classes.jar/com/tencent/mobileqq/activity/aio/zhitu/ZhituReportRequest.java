package com.tencent.mobileqq.activity.aio.zhitu;

import com.tencent.mobileqq.util.JSONUtils.GenericType;
import com.tencent.securitysdk.utils.MD5;
import java.util.List;

public class ZhituReportRequest
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  @JSONUtils.GenericType(a=String.class)
  List jdField_a_of_type_JavaUtilList;
  String b;
  
  public String toString()
  {
    return "ZhituReportRequest{, type=" + this.jdField_a_of_type_Int + ", md5='" + this.jdField_a_of_type_JavaLangString + '\'' + ", text='" + MD5.a(this.b) + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituReportRequest
 * JD-Core Version:    0.7.0.1
 */