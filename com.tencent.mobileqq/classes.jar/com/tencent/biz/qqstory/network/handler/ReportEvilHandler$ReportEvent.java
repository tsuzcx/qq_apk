package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;

public class ReportEvilHandler$ReportEvent
  extends BaseEvent
{
  public final int a;
  public final String a;
  public final String b;
  
  public ReportEvilHandler$ReportEvent(ReportEvilHandler paramReportEvilHandler, ErrorMessage paramErrorMessage, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    this.b = paramString2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    return "ReportEvent{vid='" + this.jdField_a_of_type_JavaLangString + '\'' + ", uin='" + this.b + '\'' + ", impeachType=" + this.jdField_a_of_type_Int + "} " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.ReportEvilHandler.ReportEvent
 * JD-Core Version:    0.7.0.1
 */