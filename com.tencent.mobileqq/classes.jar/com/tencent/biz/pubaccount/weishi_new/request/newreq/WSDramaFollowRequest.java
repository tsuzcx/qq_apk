package com.tencent.biz.pubaccount.weishi_new.request.newreq;

import UserGrowth.stUpdateFollowDramaReq;
import UserGrowth.stUpdateFollowDramaRsp;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;

public class WSDramaFollowRequest
  extends WSRequest<stUpdateFollowDramaRsp>
{
  private static final String CMD_STRING = "UpdateFollowDrama";
  
  public WSDramaFollowRequest(String paramString, int paramInt)
  {
    super("UpdateFollowDrama");
    this.req = new stUpdateFollowDramaReq(paramString, paramInt);
  }
  
  public Class<stUpdateFollowDramaRsp> getRspClass()
  {
    return stUpdateFollowDramaRsp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.newreq.WSDramaFollowRequest
 * JD-Core Version:    0.7.0.1
 */