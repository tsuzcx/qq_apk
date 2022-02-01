package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetFeedVisitor;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetFeedVisitor;
import com.tencent.biz.qqstory.network.response.GetVideoWatcherListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class GetVideoWatcherListRequest
  extends NetworkRequest
{
  public static final String a = StoryApi.a("StorySvc.feed_visitor_list");
  public String b;
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetFeedVisitor localRspGetFeedVisitor = new qqstory_service.RspGetFeedVisitor();
    try
    {
      localRspGetFeedVisitor.mergeFrom(paramArrayOfByte);
      return new GetVideoWatcherListResponse(this.b, localRspGetFeedVisitor);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory:GetVideoWatcherListRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return a;
  }
  
  public byte[] a()
  {
    qqstory_service.ReqGetFeedVisitor localReqGetFeedVisitor = new qqstory_service.ReqGetFeedVisitor();
    localReqGetFeedVisitor.feed_id.set(ByteStringMicro.copyFromUtf8(this.b));
    return localReqGetFeedVisitor.toByteArray();
  }
  
  public String toString()
  {
    return "GetVideoWatcherListRequest{, feedId='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetVideoWatcherListRequest
 * JD-Core Version:    0.7.0.1
 */