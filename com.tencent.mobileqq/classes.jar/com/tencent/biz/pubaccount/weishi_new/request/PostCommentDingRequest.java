package com.tencent.biz.pubaccount.weishi_new.request;

import NS_KING_INTERFACE.stPostCommentDingReq;
import NS_KING_INTERFACE.stPostCommentDingRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;

public class PostCommentDingRequest
  extends WeishiRequest<stPostCommentDingRsp>
{
  public PostCommentDingRequest(String paramString1, String paramString2, int paramInt)
  {
    super("PostCommentDing", 10003);
    this.a = new stPostCommentDingReq(paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.PostCommentDingRequest
 * JD-Core Version:    0.7.0.1
 */