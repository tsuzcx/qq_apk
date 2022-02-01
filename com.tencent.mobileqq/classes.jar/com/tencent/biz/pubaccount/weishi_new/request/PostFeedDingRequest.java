package com.tencent.biz.pubaccount.weishi_new.request;

import NS_KING_INTERFACE.stPostFeedDingReq;
import NS_KING_INTERFACE.stPostFeedDingRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;

public class PostFeedDingRequest
  extends WeishiRequest<stPostFeedDingRsp>
{
  public PostFeedDingRequest(String paramString, int paramInt)
  {
    super("PostFeedDing");
    this.c = new stPostFeedDingReq(paramString, null, paramInt);
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.PostFeedDingRequest
 * JD-Core Version:    0.7.0.1
 */