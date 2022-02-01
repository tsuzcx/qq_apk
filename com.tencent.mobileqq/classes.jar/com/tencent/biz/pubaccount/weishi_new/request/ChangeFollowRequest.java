package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stFollowReq;
import UserGrowth.stFollowRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;

public class ChangeFollowRequest
  extends WeishiRequest<stFollowRsp>
{
  public ChangeFollowRequest(String paramString, int paramInt)
  {
    super("Follow");
    this.c = new stFollowReq(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.ChangeFollowRequest
 * JD-Core Version:    0.7.0.1
 */