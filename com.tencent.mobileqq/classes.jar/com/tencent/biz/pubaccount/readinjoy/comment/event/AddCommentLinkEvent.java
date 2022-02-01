package com.tencent.biz.pubaccount.readinjoy.comment.event;

import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class AddCommentLinkEvent
  extends SimpleBaseEvent
{
  private static final long serialVersionUID = -364985398734531148L;
  public final BaseCommentData.CommentLinkData linkData;
  
  public AddCommentLinkEvent(BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    this.linkData = paramCommentLinkData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.event.AddCommentLinkEvent
 * JD-Core Version:    0.7.0.1
 */