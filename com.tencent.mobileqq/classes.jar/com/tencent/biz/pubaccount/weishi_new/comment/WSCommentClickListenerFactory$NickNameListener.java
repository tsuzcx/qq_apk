package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaPerson;

class WSCommentClickListenerFactory$NickNameListener
  extends WSCommentClickListenerFactory.BaseCommentListener
{
  WSCommentClickListenerFactory$NickNameListener(WsCommentPresenter paramWsCommentPresenter)
  {
    super(paramWsCommentPresenter);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof stSimpleMetaPerson))
    {
      paramObject = (stSimpleMetaPerson)paramObject;
      a(paramObject, paramObject.avatarSchema, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentClickListenerFactory.NickNameListener
 * JD-Core Version:    0.7.0.1
 */