package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stPostCommentReplyV2Req;
import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaReply;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import java.util.ArrayList;

public class PostCommentReplyRequest
  extends WeishiRequest<stPostCommentReplyV2Rsp>
{
  public PostCommentReplyRequest(stSimpleMetaFeed paramstSimpleMetaFeed, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, ArrayList<String> paramArrayList)
  {
    super("PostCommentReplyV2", 10003);
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList();
    }
    this.c = new stPostCommentReplyV2Req(paramstSimpleMetaFeed.id, paramstSimpleMetaComment.id, paramstSimpleMetaReply, (ArrayList)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.PostCommentReplyRequest
 * JD-Core Version:    0.7.0.1
 */