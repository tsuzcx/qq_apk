package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaPerson;

class WSCommentClickListenerFactory$AvatarListener
  extends WSCommentClickListenerFactory.BaseCommentListener
{
  WSCommentClickListenerFactory$AvatarListener(WsCommentPresenter paramWsCommentPresenter)
  {
    super(paramWsCommentPresenter);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    paramObject = (stSimpleMetaPerson)paramObject;
    a(paramObject, paramObject.avatarSchema, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentClickListenerFactory.AvatarListener
 * JD-Core Version:    0.7.0.1
 */