package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaReply;

class WSCommentClickListenerFactory$ReplyLikeListener
  extends WSCommentClickListenerFactory.BaseCommentListener
{
  WSCommentClickListenerFactory$ReplyLikeListener(WsCommentPresenter paramWsCommentPresenter)
  {
    super(paramWsCommentPresenter);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject.length > 1) && (paramObject[0] != null) && (paramObject[1] != null))
    {
      stSimpleMetaComment localstSimpleMetaComment = (stSimpleMetaComment)paramObject[0];
      this.a.h().a(this.a.n(), localstSimpleMetaComment, (stSimpleMetaReply)paramObject[1]);
      this.a.a(true);
      a(1000001, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentClickListenerFactory.ReplyLikeListener
 * JD-Core Version:    0.7.0.1
 */