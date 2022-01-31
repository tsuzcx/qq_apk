package com.tencent.biz.qqstory.support.report;

import com.tencent.biz.qqstory.channel.CmdTaskManger;
import oci;

public class MonitorReport
{
  public static void a(int paramInt, String paramString)
  {
    MonitorValueRequest localMonitorValueRequest = new MonitorValueRequest();
    localMonitorValueRequest.a(paramInt, 1);
    localMonitorValueRequest.a = paramString;
    CmdTaskManger.a().a(localMonitorValueRequest, new oci());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.support.report.MonitorReport
 * JD-Core Version:    0.7.0.1
 */