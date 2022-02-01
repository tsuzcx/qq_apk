package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stPublisherReq;
import UserGrowth.stPublisherRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class GetPublisherRequest
  extends WeishiRequest<stPublisherRsp>
{
  public GetPublisherRequest()
  {
    super("Publisher", 10004);
    stPublisherReq localstPublisherReq = new stPublisherReq();
    this.a = localstPublisherReq;
    WSLog.b("GetPublisherRequest", "stSimpleGetFeedDetailReq = " + localstPublisherReq.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.GetPublisherRequest
 * JD-Core Version:    0.7.0.1
 */