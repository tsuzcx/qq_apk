package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGroupStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGroupStoryFeedIdList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class GetTroopAssistantFeedIdListRequest
  extends NetworkRequest
{
  public String a;
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_group.RspGroupStoryFeedIdList localRspGroupStoryFeedIdList = new qqstory_group.RspGroupStoryFeedIdList();
    try
    {
      localRspGroupStoryFeedIdList.mergeFrom(paramArrayOfByte);
      return new GetTroopAssistantFeedIdListRequest.GetTroopAssistantFeedIdListResponse(localRspGroupStoryFeedIdList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public String a()
  {
    return StoryApi.a("StoryGroupSvc.get_dynamic_group_feedid_list");
  }
  
  public byte[] a()
  {
    qqstory_group.ReqGroupStoryFeedIdList localReqGroupStoryFeedIdList = new qqstory_group.ReqGroupStoryFeedIdList();
    localReqGroupStoryFeedIdList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.a));
    return localReqGroupStoryFeedIdList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetTroopAssistantFeedIdListRequest
 * JD-Core Version:    0.7.0.1
 */