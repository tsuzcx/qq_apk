package com.tencent.biz.subscribe.event;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;

public class CommentReplyEvent
  extends SimpleBaseEvent
{
  public CertifiedAccountMeta.StComment mStComment;
  public CertifiedAccountMeta.StReply mStReply;
  
  public CommentReplyEvent(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    this.mStComment = paramStComment;
    this.mStReply = paramStReply;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.event.CommentReplyEvent
 * JD-Core Version:    0.7.0.1
 */