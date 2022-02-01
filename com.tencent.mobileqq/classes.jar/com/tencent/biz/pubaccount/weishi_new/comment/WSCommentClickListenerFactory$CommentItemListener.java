package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;

class WSCommentClickListenerFactory$CommentItemListener
  extends WSCommentClickListenerFactory.BaseCommentListener
{
  WSCommentClickListenerFactory$CommentItemListener(WsCommentPresenter paramWsCommentPresenter)
  {
    super(paramWsCommentPresenter);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof stSimpleMetaComment))
    {
      paramObject = (stSimpleMetaComment)paramObject;
      this.a.a(paramObject, null, 0);
      a(1000001, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentClickListenerFactory.CommentItemListener
 * JD-Core Version:    0.7.0.1
 */