package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stSimpleMetaReply;

class WSCommentClickListenerFactory$ReplyItemAvatar
  extends WSCommentClickListenerFactory.BaseCommentListener
{
  WSCommentClickListenerFactory$ReplyItemAvatar(WsCommentPresenter paramWsCommentPresenter)
  {
    super(paramWsCommentPresenter);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject.length > 1) && (paramObject[0] != null) && (paramObject[1] != null) && ((paramObject[0] instanceof stSimpleMetaComment)) && ((paramObject[1] instanceof stSimpleMetaReply)))
    {
      paramObject = (stSimpleMetaReply)paramObject[1];
      if (paramObject.poster != null)
      {
        stSchema localstSchema = paramObject.poster.avatarSchema;
        a(paramObject.poster, localstSchema, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentClickListenerFactory.ReplyItemAvatar
 * JD-Core Version:    0.7.0.1
 */