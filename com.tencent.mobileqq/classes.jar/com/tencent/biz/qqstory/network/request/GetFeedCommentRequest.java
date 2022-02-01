package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqFeedCommentList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedCommentList;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetFeedCommentRequest
  extends NetworkRequest
{
  public static final String e = StoryApi.a("StorySvc.feed_comment_list_775");
  public FeedCommentSync f;
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspFeedCommentList localRspFeedCommentList = new qqstory_service.RspFeedCommentList();
    try
    {
      localRspFeedCommentList.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new GetFeedCommentRequest.GetFeedCommentResponse(localRspFeedCommentList);
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqFeedCommentList localReqFeedCommentList = new qqstory_service.ReqFeedCommentList();
    localReqFeedCommentList.feed_id.set(ByteStringMicro.copyFromUtf8(this.f.a));
    if (this.f.b == null) {
      this.f.b = "";
    }
    localReqFeedCommentList.cookie.set(ByteStringMicro.copyFromUtf8(this.f.b));
    localReqFeedCommentList.source.set(this.f.c);
    if (this.f.d != -1) {
      localReqFeedCommentList.type.set(this.f.d);
    }
    return localReqFeedCommentList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetFeedCommentRequest
 * JD-Core Version:    0.7.0.1
 */