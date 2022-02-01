package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;

public class ReportEvilHandler$ReportEvent
  extends BaseEvent
{
  public final String a;
  public final String b;
  public final int c;
  
  public ReportEvilHandler$ReportEvent(ReportEvilHandler paramReportEvilHandler, ErrorMessage paramErrorMessage, String paramString1, String paramString2, int paramInt)
  {
    this.g = paramErrorMessage;
    this.b = paramString2;
    this.a = paramString1;
    this.c = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReportEvent{vid='");
    localStringBuilder.append(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.ReportEvilHandler.ReportEvent
 * JD-Core Version:    0.7.0.1
 */