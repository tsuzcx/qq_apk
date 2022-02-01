package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqProfileStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspProfileStoryFeedIdList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class GetProfileFeedIdListRequest
  extends NetworkRequest
{
  public String a;
  public String b;
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspProfileStoryFeedIdList localRspProfileStoryFeedIdList = new qqstory_service.RspProfileStoryFeedIdList();
    try
    {
      localRspProfileStoryFeedIdList.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new GetProfileFeedIdListRequest.GetProfileFeedIdListResponse(localRspProfileStoryFeedIdList);
  }
  
  public String a()
  {
    return StoryApi.a("StorySvc.get_profile_feed_id_list");
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqProfileStoryFeedIdList localReqProfileStoryFeedIdList = new qqstory_service.ReqProfileStoryFeedIdList();
    localReqProfileStoryFeedIdList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.a));
    localReqProfileStoryFeedIdList.union_id.set(ByteStringMicro.copyFromUtf8(this.b));
    return localReqProfileStoryFeedIdList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetProfileFeedIdListRequest
 * JD-Core Version:    0.7.0.1
 */