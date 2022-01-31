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
  extends NetworkRequest
{
  protected static final String a = StoryApi.a("StorySvc.get_friend_joined_share_group_status");
  public String b;
  
  public BaseResponse a(byte[] paramArrayOfByte)
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
  
  public String a()
  {
    return a;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetJoinedShareGroupFriList localReqGetJoinedShareGroupFriList = new qqstory_service.ReqGetJoinedShareGroupFriList();
    localReqGetJoinedShareGroupFriList.share_group_unionid.set(ByteStringMicro.copyFromUtf8(this.b));
    return localReqGetJoinedShareGroupFriList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetJoinedShareGroupFriListRequest
 * JD-Core Version:    0.7.0.1
 */