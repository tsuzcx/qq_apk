package com.tencent.biz.qqstory.msgTabNode.network;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckActivity;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class MsgTabCheckActiveRequest$MsgTabCheckActiveResponse
  extends BaseResponse
{
  public int a;
  public long b;
  
  public MsgTabCheckActiveRequest$MsgTabCheckActiveResponse(qqstory_service.RspCheckActivity paramRspCheckActivity)
  {
    super(paramRspCheckActivity.result);
    this.a = paramRspCheckActivity.is_activity.get();
    this.b = paramRspCheckActivity.next_check_time.get();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgTabCheckActiveResponse{active=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", nextCheckTime=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabCheckActiveRequest.MsgTabCheckActiveResponse
 * JD-Core Version:    0.7.0.1
 */