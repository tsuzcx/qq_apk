package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;

public class ReportNoInterestingVideoHandler$ReportNoInterestingVideoEvent
  extends BaseEvent
{
  public final String a;
  
  public ReportNoInterestingVideoHandler$ReportNoInterestingVideoEvent(ErrorMessage paramErrorMessage, String paramString)
  {
    this.g = paramErrorMessage;
    this.a = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReportEvent{vid='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append("} ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent
 * JD-Core Version:    0.7.0.1
 */