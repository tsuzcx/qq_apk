package com.tencent.biz.pubaccount.weishi_new.event;

public class WSCommentSuccessEvent
  extends WSSimpleBaseEvent
{
  private String commentId;
  private boolean isSendArk;
  private boolean isShowCommentPanel;
  private String replyId;
  
  public WSCommentSuccessEvent(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    this.isSendArk = paramBoolean1;
    this.isShowCommentPanel = paramBoolean2;
    this.commentId = paramString1;
    this.replyId = paramString2;
  }
  
  public String getCommentId()
  {
    return this.commentId;
  }
  
  public String getReplyId()
  {
    return this.replyId;
  }
  
  public boolean isSendArk()
  {
    return this.isSendArk;
  }
  
  public boolean isShowCommentPanel()
  {
    return this.isShowCommentPanel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSCommentSuccessEvent
 * JD-Core Version:    0.7.0.1
 */