package com.tencent.biz.subscribe.event;

public class CommentListShowStateEvent
  extends SimpleBaseEvent
{
  public boolean shown;
  
  public CommentListShowStateEvent(boolean paramBoolean)
  {
    this.shown = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.event.CommentListShowStateEvent
 * JD-Core Version:    0.7.0.1
 */