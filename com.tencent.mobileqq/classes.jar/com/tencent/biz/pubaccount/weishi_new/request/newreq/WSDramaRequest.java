package com.tencent.biz.pubaccount.weishi_new.request.newreq;

import UserGrowth.stGetSimpleRecommendDramaReq;
import UserGrowth.stGetSimpleRecommendDramaRsp;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;

public class WSDramaRequest
  extends WSRequest<stGetSimpleRecommendDramaRsp>
{
  private static final String CMD_STRING = "GetSimpleRecommendDrama";
  
  public WSDramaRequest(String paramString)
  {
    super("GetSimpleRecommendDrama", 10012);
    stGetSimpleRecommendDramaReq localstGetSimpleRecommendDramaReq = new stGetSimpleRecommendDramaReq();
    localstGetSimpleRecommendDramaReq.enterDramaID = paramString;
    this.req = localstGetSimpleRecommendDramaReq;
  }
  
  public Class<stGetSimpleRecommendDramaRsp> getRspClass()
  {
    return stGetSimpleRecommendDramaRsp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.newreq.WSDramaRequest
 * JD-Core Version:    0.7.0.1
 */