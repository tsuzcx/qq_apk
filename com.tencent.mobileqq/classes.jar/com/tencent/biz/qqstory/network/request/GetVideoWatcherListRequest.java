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
  public static final String e = StoryApi.a("StorySvc.feed_visitor_list");
  public String f;
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspGetFeedVisitor();
    try
    {
      ((qqstory_service.RspGetFeedVisitor)localObject).mergeFrom(paramArrayOfByte);
      return new GetVideoWatcherListResponse(this.f, (qqstory_service.RspGetFeedVisitor)localObject);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      SLog.d("Q.qqstory:GetVideoWatcherListRequest", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqGetFeedVisitor localReqGetFeedVisitor = new qqstory_service.ReqGetFeedVisitor();
    localReqGetFeedVisitor.feed_id.set(ByteStringMicro.copyFromUtf8(this.f));
    return localReqGetFeedVisitor.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetVideoWatcherListRequest{, feedId='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetVideoWatcherListRequest
 * JD-Core Version:    0.7.0.1
 */