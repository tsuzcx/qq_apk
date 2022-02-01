package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBlackList;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetBlackListStatusResponse
  extends BaseResponse
{
  public int a;
  public int b;
  
  public GetBlackListStatusResponse(qqstory_service.RspGetBlackList paramRspGetBlackList)
  {
    super(paramRspGetBlackList.result);
    this.a = paramRspGetBlackList.black_status.get();
    this.b = paramRspGetBlackList.update_interval.get();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetBlackListStatusResponse{blackStatus=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", updateInterval=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetBlackListStatusResponse
 * JD-Core Version:    0.7.0.1
 */