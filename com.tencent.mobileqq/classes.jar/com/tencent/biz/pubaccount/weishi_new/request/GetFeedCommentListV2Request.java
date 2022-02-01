package com.tencent.biz.pubaccount.weishi_new.request;

import NS_KING_INTERFACE.stGetFeedCommentListV2Req;
import UserGrowth.stQQGetFeedCommentListV2Req;
import UserGrowth.stQQGetFeedCommentListV2Rsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;

public class GetFeedCommentListV2Request
  extends WeishiRequest<stQQGetFeedCommentListV2Rsp>
{
  public GetFeedCommentListV2Request(String paramString1, String paramString2, int paramInt)
  {
    super("QQGetFeedCommentListV2", 10003);
    this.a = new stQQGetFeedCommentListV2Req(new stGetFeedCommentListV2Req(paramString1, paramString2, "", 0, "", paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.GetFeedCommentListV2Request
 * JD-Core Version:    0.7.0.1
 */