package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;

public class ReportNoInterestingVideoHandler
  implements CmdTaskManger.CommandCallback<ReportNoInterestingVideoHandler.ReportIgnoreVideoRequest, ReportNoInterestingVideoHandler.ReportIgnoreVideoResponse>
{
  public void a(@NonNull ReportNoInterestingVideoHandler.ReportIgnoreVideoRequest paramReportIgnoreVideoRequest, @Nullable ReportNoInterestingVideoHandler.ReportIgnoreVideoResponse paramReportIgnoreVideoResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    new ReportNoInterestingVideoHandler.ReportNoInterestingVideoEvent(paramErrorMessage, paramReportIgnoreVideoRequest.b);
  }
  
  public void a(String paramString)
  {
    paramString = new ReportNoInterestingVideoHandler.ReportIgnoreVideoRequest(this, paramString);
    CmdTaskManger.a().a(paramString, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.ReportNoInterestingVideoHandler
 * JD-Core Version:    0.7.0.1
 */