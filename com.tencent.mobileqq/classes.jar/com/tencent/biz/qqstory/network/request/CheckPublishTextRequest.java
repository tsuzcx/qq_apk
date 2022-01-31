package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqCheckText;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckText;
import com.tencent.biz.qqstory.network.response.CheckPublishTextResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class CheckPublishTextRequest
  extends NetworkRequest
{
  public final String a;
  public final String b;
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspCheckText localRspCheckText = new qqstory_service.RspCheckText();
    try
    {
      localRspCheckText.mergeFrom(paramArrayOfByte);
      return new CheckPublishTextResponse(localRspCheckText);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.e("CheckPublishTextRequest", "CheckPublishTextRequest error : " + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return StoryApi.a("StorySvc.video_show_publish_dirty_check");
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqCheckText localReqCheckText = new qqstory_service.ReqCheckText();
    if (this.a != null) {
      localReqCheckText.label.set(ByteStringMicro.copyFromUtf8(this.a));
    }
    if (this.b != null) {
      localReqCheckText.description.set(ByteStringMicro.copyFromUtf8(this.b));
    }
    return localReqCheckText.toByteArray();
  }
  
  public String toString()
  {
    return "CheckPublishTextRequest{videoLabel='" + this.a + '\'' + ", videoDoodleDescription='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.CheckPublishTextRequest
 * JD-Core Version:    0.7.0.1
 */