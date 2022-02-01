package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaReply;

class WSCommentClickListenerFactory$ReplyItemListener
  extends WSCommentClickListenerFactory.BaseCommentListener
{
  WSCommentClickListenerFactory$ReplyItemListener(WsCommentPresenter paramWsCommentPresenter)
  {
    super(paramWsCommentPresenter);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if (!(paramObject instanceof Object[])) {
      return;
    }
    Object localObject = (Object[])paramObject;
    if ((localObject.length > 1) && (localObject[0] != null) && (localObject[1] != null) && ((localObject[0] instanceof stSimpleMetaComment)) && ((localObject[1] instanceof stSimpleMetaReply)))
    {
      paramObject = (stSimpleMetaComment)localObject[0];
      localObject = (stSimpleMetaReply)localObject[1];
      this.a.a(paramObject, (stSimpleMetaReply)localObject, 0);
      a(1000001, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentClickListenerFactory.ReplyItemListener
 * JD-Core Version:    0.7.0.1
 */