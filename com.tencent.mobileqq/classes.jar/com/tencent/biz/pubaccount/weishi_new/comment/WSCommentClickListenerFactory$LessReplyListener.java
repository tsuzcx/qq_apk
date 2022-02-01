package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;

class WSCommentClickListenerFactory$LessReplyListener
  extends WSCommentClickListenerFactory.BaseCommentListener
{
  WSCommentClickListenerFactory$LessReplyListener(WsCommentPresenter paramWsCommentPresenter)
  {
    super(paramWsCommentPresenter);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject.length > 1) && (paramObject[0] != null))
    {
      stSimpleMetaComment localstSimpleMetaComment = (stSimpleMetaComment)paramObject[0];
      if ((this.a.d().b(localstSimpleMetaComment) >= 0) && (paramObject[1] != null)) {
        ((Integer)paramObject[1]).intValue();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentClickListenerFactory.LessReplyListener
 * JD-Core Version:    0.7.0.1
 */