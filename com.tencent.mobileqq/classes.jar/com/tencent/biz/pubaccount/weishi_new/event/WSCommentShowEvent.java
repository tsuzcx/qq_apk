package com.tencent.biz.pubaccount.weishi_new.event;

public class WSCommentShowEvent
  extends WSSimpleBaseEvent
{
  public boolean isShowingCommentView;
  
  public WSCommentShowEvent(boolean paramBoolean)
  {
    this.isShowingCommentView = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSCommentShowEvent
 * JD-Core Version:    0.7.0.1
 */