package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;

class WSCommentClickListenerFactory$MoreReplyListener
  extends WSCommentClickListenerFactory.BaseCommentListener
{
  WSCommentClickListenerFactory$MoreReplyListener(WsCommentPresenter paramWsCommentPresenter)
  {
    super(paramWsCommentPresenter);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof stSimpleMetaComment))
    {
      paramObject = (stSimpleMetaComment)paramObject;
      this.a.d().a(paramObject);
      a(1000001, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentClickListenerFactory.MoreReplyListener
 * JD-Core Version:    0.7.0.1
 */