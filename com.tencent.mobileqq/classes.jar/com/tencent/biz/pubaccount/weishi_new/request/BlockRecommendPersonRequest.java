package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stBlockRecommPersonReq;
import UserGrowth.stBlockRecommPersonRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;

public class BlockRecommendPersonRequest
  extends WeishiRequest<stBlockRecommPersonRsp>
{
  public BlockRecommendPersonRequest(String paramString)
  {
    super("BlockRecommPerson");
    this.c = new stBlockRecommPersonReq(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.BlockRecommendPersonRequest
 * JD-Core Version:    0.7.0.1
 */