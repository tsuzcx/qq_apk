package com.tencent.mobileqq.activity.aio.zhitu;

import com.tencent.securitysdk.utils.MD5;

public class ZhituRequest
{
  public String chat;
  public String os;
  public ZhituReportRequest report;
  public int styles;
  public String text;
  public String uin;
  public String version;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZhituRequest{chat='");
    localStringBuilder.append(this.chat);
    localStringBuilder.append('\'');
    localStringBuilder.append(", styles=");
    localStringBuilder.append(this.styles);
    localStringBuilder.append(", os='");
    localStringBuilder.append(this.os);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uin='");
    localStringBuilder.append(this.uin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", text='");
    localStringBuilder.append(MD5.b(this.text));
    localStringBuilder.append('\'');
    localStringBuilder.append(", report=");
    localStringBuilder.append(this.report);
    localStringBuilder.append(", version='");
    localStringBuilder.append(this.version);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituRequest
 * JD-Core Version:    0.7.0.1
 */