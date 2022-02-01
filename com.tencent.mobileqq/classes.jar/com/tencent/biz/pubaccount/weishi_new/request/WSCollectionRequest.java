package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stGetCollectionReq;
import UserGrowth.stGetCollectionRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;

public class WSCollectionRequest
  extends WeishiRequest<stGetCollectionRsp>
{
  public WSCollectionRequest(String paramString1, String paramString2, int paramInt)
  {
    super("GetCollection", paramInt);
    stGetCollectionReq localstGetCollectionReq = new stGetCollectionReq();
    localstGetCollectionReq.cid = paramString1;
    localstGetCollectionReq.attachInfo = paramString2;
    localstGetCollectionReq.scene = paramInt;
    this.a = localstGetCollectionReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.WSCollectionRequest
 * JD-Core Version:    0.7.0.1
 */