package com.tencent.biz.qqstory.support.report;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMonitorValue;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMonitorValue;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class MonitorValueRequest
  extends NetworkRequest
{
  public String e;
  private int f;
  private int g;
  
  public String a()
  {
    return StoryApi.a("StoryMonitorSvc.client_monitor_report");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspMonitorValue localRspMonitorValue = new qqstory_service.RspMonitorValue();
    try
    {
      localRspMonitorValue.mergeFrom(paramArrayOfByte);
      return new MonitorValueResponse(localRspMonitorValue);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label23:
      break label23;
    }
    return null;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqMonitorValue localReqMonitorValue = new qqstory_service.ReqMonitorValue();
    localReqMonitorValue.ID.set(this.f);
    if (this.g > 0) {
      localReqMonitorValue.Value.set(this.g);
    } else {
      localReqMonitorValue.Value.set(1);
    }
    if (this.e != null) {
      localReqMonitorValue.errmsg.set(ByteStringMicro.copyFromUtf8(this.e));
    }
    return localReqMonitorValue.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MonitorValueRequest{ID=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", value=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", msg=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.support.report.MonitorValueRequest
 * JD-Core Version:    0.7.0.1
 */