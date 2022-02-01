package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;

public class ReportEvilToXinanHandler$ReportToXinanEvent
  extends BaseEvent
{
  public final String a;
  public final String b;
  public final String c;
  
  public ReportEvilToXinanHandler$ReportToXinanEvent(ErrorMessage paramErrorMessage, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    this.b = paramString2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.c = paramString3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReportEvent{vid='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uin='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", impeachType=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("} ");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.ReportEvilToXinanHandler.ReportToXinanEvent
 * JD-Core Version:    0.7.0.1
 */