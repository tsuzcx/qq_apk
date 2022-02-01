package com.tencent.biz.pubaccount.weishi_new.request.newreq;

import UserGrowth.stGetCollectionReq;
import UserGrowth.stGetCollectionRsp;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;

public class WSCollectionRequest
  extends WSRequest<stGetCollectionRsp>
{
  private static final String CMD_STRING = "GetCollection";
  
  public WSCollectionRequest(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    super("GetCollection", paramInt1);
    stGetCollectionReq localstGetCollectionReq = new stGetCollectionReq();
    localstGetCollectionReq.cid = paramString1;
    localstGetCollectionReq.attachInfo = paramString3;
    localstGetCollectionReq.scene = paramInt1;
    localstGetCollectionReq.feedId = paramString2;
    localstGetCollectionReq.pageOrder = paramInt2;
    this.req = localstGetCollectionReq;
  }
  
  public Class<stGetCollectionRsp> getRspClass()
  {
    return stGetCollectionRsp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.newreq.WSCollectionRequest
 * JD-Core Version:    0.7.0.1
 */