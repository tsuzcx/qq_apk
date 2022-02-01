package com.tencent.biz.richframework.network.request;

import NS_QQ_STORY_CLIENT.CLIENT.StPublishStoryFeedReq;
import NS_QQ_STORY_CLIENT.CLIENT.StPublishStoryFeedRsp;
import NS_QQ_STORY_META.META.StStoryFeed;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;

public class PublishVideoFeedRequest
  extends VSBaseRequest
{
  private CLIENT.StPublishStoryFeedReq req = new CLIENT.StPublishStoryFeedReq();
  
  public PublishVideoFeedRequest(META.StStoryFeed paramStStoryFeed)
  {
    this.req.storyFeed.set(paramStStoryFeed);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CLIENT.StPublishStoryFeedRsp localStPublishStoryFeedRsp = new CLIENT.StPublishStoryFeedRsp();
    try
    {
      localStPublishStoryFeedRsp.mergeFrom(paramArrayOfByte);
      return localStPublishStoryFeedRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStPublishStoryFeedRsp;
  }
  
  public String getCmdName()
  {
    return "LightAppSvc.qq_story_client.PublishStoryFeed";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.request.PublishVideoFeedRequest
 * JD-Core Version:    0.7.0.1
 */