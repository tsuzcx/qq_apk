package com.tencent.biz.pubaccount.weishi_new.request.newreq;

import UserGrowth.stGetAIOFeedDetailReq;
import UserGrowth.stGetAIOFeedDetailRsp;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;

public class GetAIOFeedDetailRequest
  extends WSRequest<stGetAIOFeedDetailRsp>
{
  private static final String CMD = "GetAIOFeedDetail";
  
  public GetAIOFeedDetailRequest()
  {
    super("GetAIOFeedDetail", 10008);
    this.req = new stGetAIOFeedDetailReq();
  }
  
  public Class<stGetAIOFeedDetailRsp> getRspClass()
  {
    return stGetAIOFeedDetailRsp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.newreq.GetAIOFeedDetailRequest
 * JD-Core Version:    0.7.0.1
 */