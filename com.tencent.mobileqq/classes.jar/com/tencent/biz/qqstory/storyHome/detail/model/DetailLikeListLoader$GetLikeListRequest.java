package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqFeedLikeList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedLikeList;
import com.tencent.biz.qqstory.network.response.GetFeedVideoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class DetailLikeListLoader$GetLikeListRequest
  extends NetworkRequest<GetFeedVideoListResponse>
{
  public String a;
  public boolean a;
  public int c = -1;
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspFeedLikeList localRspFeedLikeList = new qqstory_service.RspFeedLikeList();
    try
    {
      localRspFeedLikeList.mergeFrom(paramArrayOfByte);
      return new DetailLikeListLoader.GetLikeListResponse(localRspFeedLikeList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory:GetLikeListRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return StoryApi.a("StorySvc.feed_like_list_715");
  }
  
  public byte[] a()
  {
    qqstory_service.ReqFeedLikeList localReqFeedLikeList = new qqstory_service.ReqFeedLikeList();
    localReqFeedLikeList.feed_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localReqFeedLikeList.source.set(i);
      if (this.c != -1) {
        localReqFeedLikeList.type.set(this.c);
      }
      return localReqFeedLikeList.toByteArray();
    }
  }
  
  public String toString()
  {
    return "GetLikeListRequest{, feedId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", isOpen=" + this.jdField_a_of_type_Boolean + ", type=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.GetLikeListRequest
 * JD-Core Version:    0.7.0.1
 */