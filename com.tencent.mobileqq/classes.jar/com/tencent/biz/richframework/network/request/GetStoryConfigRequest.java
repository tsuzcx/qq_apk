package com.tencent.biz.richframework.network.request;

import NS_QQ_STORY_CONFIG.CONFIG.StGetStoryConfigReq;
import NS_QQ_STORY_CONFIG.CONFIG.StGetStoryConfigRsp;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;

public class GetStoryConfigRequest
  extends VSBaseRequest
{
  private final CONFIG.StGetStoryConfigReq req = new CONFIG.StGetStoryConfigReq();
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CONFIG.StGetStoryConfigRsp localStGetStoryConfigRsp = new CONFIG.StGetStoryConfigRsp();
    try
    {
      localStGetStoryConfigRsp.mergeFrom(paramArrayOfByte);
      return localStGetStoryConfigRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetStoryConfigRsp;
  }
  
  public String getCmdName()
  {
    return "LightAppSvc.qq_story_config.GetStoryConfig";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.request.GetStoryConfigRequest
 * JD-Core Version:    0.7.0.1
 */