package com.tencent.biz.qqstory.support.report;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.support.logging.SLog;

final class MonitorReport$1
  implements CmdTaskManger.CommandCallback<MonitorValueRequest, BaseResponse>
{
  public void a(@NonNull MonitorValueRequest paramMonitorValueRequest, @Nullable BaseResponse paramBaseResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail()) {
      SLog.b("Q.qqstory.MonitorReport", "send monitor fail %s", paramErrorMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.support.report.MonitorReport.1
 * JD-Core Version:    0.7.0.1
 */