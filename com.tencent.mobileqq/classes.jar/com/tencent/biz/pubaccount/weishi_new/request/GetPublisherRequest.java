package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stPublisherReq;
import UserGrowth.stPublisherRsp;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class GetPublisherRequest
  extends WSRequest<stPublisherRsp>
{
  private static final String CMD_STRING = "Publisher";
  private static final String TAG = "GetPublisherRequest";
  
  public GetPublisherRequest()
  {
    super("Publisher", 10004);
    stPublisherReq localstPublisherReq = new stPublisherReq();
    this.req = localstPublisherReq;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stSimpleGetFeedDetailReq = ");
    localStringBuilder.append(localstPublisherReq.toString());
    WSLog.b("GetPublisherRequest", localStringBuilder.toString());
  }
  
  public Class<stPublisherRsp> getRspClass()
  {
    return stPublisherRsp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.GetPublisherRequest
 * JD-Core Version:    0.7.0.1
 */