package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;

public class ReportNoInterestingVideoHandler$ReportNoInterestingVideoEvent
  extends BaseEvent
{
  public final String a;
  
  public ReportNoInterestingVideoHandler$ReportNoInterestingVideoEvent(ErrorMessage paramErrorMessage, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    return "ReportEvent{vid='" + this.jdField_a_of_type_JavaLangString + '\'' + "} ";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent
 * JD-Core Version:    0.7.0.1
 */