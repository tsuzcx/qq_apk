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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stSimpleGetFeedDetailReq = ");
    localStringBuilder.append(localstPublisherReq.toString());
    WSLog.b("GetPublisherRequest", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.GetPublisherRequest
 * JD-Core Version:    0.7.0.1
 */