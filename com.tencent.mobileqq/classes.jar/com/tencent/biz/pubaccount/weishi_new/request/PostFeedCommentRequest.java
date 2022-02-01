package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stPostFeedCommentV2Req;
import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;

public class PostFeedCommentRequest
  extends WeishiRequest<stPostFeedCommentV2Rsp>
{
  public PostFeedCommentRequest(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment)
  {
    super("PostFeedCommentV2", 10003);
    this.a = new stPostFeedCommentV2Req(paramstSimpleMetaFeed.id, paramstSimpleMetaComment, new ArrayList(), 0);
    paramstSimpleMetaFeed = new StringBuilder();
    paramstSimpleMetaFeed.append("stPostFeedCommentV2Req:");
    paramstSimpleMetaFeed.append(this.a.toString());
    WSLog.c("WsCommentBusiness", paramstSimpleMetaFeed.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.PostFeedCommentRequest
 * JD-Core Version:    0.7.0.1
 */