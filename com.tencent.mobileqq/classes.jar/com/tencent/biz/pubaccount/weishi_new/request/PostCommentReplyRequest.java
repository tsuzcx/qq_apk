package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stPostCommentReplyV2Req;
import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaReply;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;

public class PostCommentReplyRequest
  extends WeishiRequest<stPostCommentReplyV2Rsp>
{
  public PostCommentReplyRequest(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    super("PostCommentReplyV2", 10003);
    this.a = new stPostCommentReplyV2Req(paramstSimpleMetaFeed.id, paramstSimpleMetaComment.id, paramstSimpleMetaReply);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.PostCommentReplyRequest
 * JD-Core Version:    0.7.0.1
 */