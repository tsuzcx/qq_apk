package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetBlackList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBlackList;
import com.tencent.biz.qqstory.network.response.GetBlackListStatusResponse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class GetBlackStatusRequest
  extends NetworkRequest<GetBlackListStatusResponse>
{
  public static final String a = StoryApi.a("StorySvc.get_user_black_status");
  public String b;
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetBlackList localRspGetBlackList = new qqstory_service.RspGetBlackList();
    try
    {
      localRspGetBlackList.mergeFrom(paramArrayOfByte);
      return new GetBlackListStatusResponse(localRspGetBlackList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return a;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetBlackList localReqGetBlackList = new qqstory_service.ReqGetBlackList();
    localReqGetBlackList.union_id.set(ByteStringMicro.copyFromUtf8(this.b));
    return localReqGetBlackList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetBlackStatusRequest
 * JD-Core Version:    0.7.0.1
 */