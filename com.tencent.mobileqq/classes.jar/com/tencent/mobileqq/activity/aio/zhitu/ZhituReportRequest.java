package com.tencent.mobileqq.activity.aio.zhitu;

import com.tencent.mobileqq.util.JSONUtils.GenericType;
import com.tencent.securitysdk.utils.MD5;
import java.util.List;

public class ZhituReportRequest
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  @JSONUtils.GenericType(a=String.class)
  List<String> jdField_a_of_type_JavaUtilList;
  String b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZhituReportRequest{, type=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", md5='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", text='");
    localStringBuilder.append(MD5.a(this.b));
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituReportRequest
 * JD-Core Version:    0.7.0.1
 */