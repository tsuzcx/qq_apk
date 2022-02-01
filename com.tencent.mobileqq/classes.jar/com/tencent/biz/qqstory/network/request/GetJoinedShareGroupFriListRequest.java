package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetJoinedShareGroupFriList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetJoinedShareGroupFriList;
import com.tencent.biz.qqstory.network.response.GetJoinedShareGroupFriListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class GetJoinedShareGroupFriListRequest
  extends NetworkRequest<GetJoinedShareGroupFriListResponse>
{
  protected static final String e = StoryApi.a("StorySvc.get_friend_joined_share_group_status");
  public String f;
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetJoinedShareGroupFriList localRspGetJoinedShareGroupFriList = new qqstory_service.RspGetJoinedShareGroupFriList();
    try
    {
      localRspGetJoinedShareGroupFriList.mergeFrom(paramArrayOfByte);
      return new GetJoinedShareGroupFriListResponse(localRspGetJoinedShareGroupFriList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.b("Q.qqstory.shareGroup:get_friend_joined_share_group_status", a(), paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqGetJoinedShareGroupFriList localReqGetJoinedShareGroupFriList = new qqstory_service.ReqGetJoinedShareGroupFriList();
    localReqGetJoinedShareGroupFriList.share_group_unionid.set(ByteStringMicro.copyFromUtf8(this.f));
    return localReqGetJoinedShareGroupFriList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetJoinedShareGroupFriListRequest
 * JD-Core Version:    0.7.0.1
 */