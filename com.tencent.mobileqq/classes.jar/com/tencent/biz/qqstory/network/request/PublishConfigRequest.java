package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPublishConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPublishConfig;
import com.tencent.biz.qqstory.network.response.PublishConfigResponse;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class PublishConfigRequest
  extends NetworkRequest<PublishConfigResponse>
{
  public static final String e = StoryApi.a("StorySvc.video_publish_config_get");
  
  public PublishConfigResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetPublishConfig localRspGetPublishConfig = new qqstory_service.RspGetPublishConfig();
    try
    {
      localRspGetPublishConfig.mergeFrom(paramArrayOfByte);
      return new PublishConfigResponse(localRspGetPublishConfig);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return e;
  }
  
  protected byte[] c()
  {
    return new qqstory_service.ReqGetPublishConfig().toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.PublishConfigRequest
 * JD-Core Version:    0.7.0.1
 */