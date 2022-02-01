package com.tencent.biz.qqstory.support.report;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMonitorValue;

public class MonitorValueResponse
  extends BaseResponse
{
  public MonitorValueResponse(qqstory_service.RspMonitorValue paramRspMonitorValue)
  {
    super(paramRspMonitorValue.result);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MonitorValueResponse{errorCode=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", errorMsg='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.support.report.MonitorValueResponse
 * JD-Core Version:    0.7.0.1
 */