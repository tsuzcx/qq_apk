package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stGetAIOFeedDetailReq;
import UserGrowth.stGetAIOFeedDetailRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;

public class GetAIOFeedDetailRequest
  extends WeishiRequest<stGetAIOFeedDetailRsp>
{
  public GetAIOFeedDetailRequest()
  {
    super("GetAIOFeedDetail", 10008);
    this.a = new stGetAIOFeedDetailReq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.GetAIOFeedDetailRequest
 * JD-Core Version:    0.7.0.1
 */