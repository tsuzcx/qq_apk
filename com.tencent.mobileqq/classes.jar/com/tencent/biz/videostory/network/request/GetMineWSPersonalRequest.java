package com.tencent.biz.videostory.network.request;

import WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageReq;
import WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageRsp;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;

public class GetMineWSPersonalRequest
  extends VSBaseRequest
{
  private final WEISHI.stGetPersonalPageReq req = new WEISHI.stGetPersonalPageReq();
  
  public GetMineWSPersonalRequest(String paramString, int paramInt)
  {
    this.req.person_id.set(paramString);
    this.req.type.set(paramInt);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    WEISHI.stGetPersonalPageRsp localstGetPersonalPageRsp = new WEISHI.stGetPersonalPageRsp();
    localstGetPersonalPageRsp.mergeFrom(paramArrayOfByte);
    return localstGetPersonalPageRsp;
  }
  
  public String getCmdName()
  {
    return "LightAppSvc.ws_qq_feeds.GetPersonalPage";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.network.request.GetMineWSPersonalRequest
 * JD-Core Version:    0.7.0.1
 */