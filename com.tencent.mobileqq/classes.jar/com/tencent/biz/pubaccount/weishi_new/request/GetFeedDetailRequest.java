package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stSimpleGetFeedDetailReq;
import UserGrowth.stSimpleGetFeedDetailRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class GetFeedDetailRequest
  extends WeishiRequest<stSimpleGetFeedDetailRsp>
{
  public GetFeedDetailRequest(String paramString)
  {
    super("SimpleGetFeedDetail", 10002);
    stSimpleGetFeedDetailReq localstSimpleGetFeedDetailReq = new stSimpleGetFeedDetailReq();
    localstSimpleGetFeedDetailReq.feedid = paramString;
    this.c = localstSimpleGetFeedDetailReq;
    paramString = new StringBuilder();
    paramString.append("stSimpleGetFeedDetailReq = ");
    paramString.append(localstSimpleGetFeedDetailReq.toString());
    WSLog.b("SimpleGetFeedDetailRequest", paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.GetFeedDetailRequest
 * JD-Core Version:    0.7.0.1
 */