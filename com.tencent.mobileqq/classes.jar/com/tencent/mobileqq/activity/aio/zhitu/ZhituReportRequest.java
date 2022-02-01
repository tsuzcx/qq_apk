package com.tencent.mobileqq.activity.aio.zhitu;

import com.tencent.mobileqq.util.JSONUtils.GenericType;
import com.tencent.securitysdk.utils.MD5;
import java.util.List;

public class ZhituReportRequest
{
  @JSONUtils.GenericType(a=String.class)
  List<String> a;
  int b;
  String c;
  String d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZhituReportRequest{, type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", md5='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", text='");
    localStringBuilder.append(MD5.b(this.d));
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituReportRequest
 * JD-Core Version:    0.7.0.1
 */