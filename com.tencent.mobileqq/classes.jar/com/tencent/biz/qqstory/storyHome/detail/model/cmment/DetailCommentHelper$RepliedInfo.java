package com.tencent.biz.qqstory.storyHome.detail.model.cmment;

import com.tencent.biz.qqstory.database.CommentEntry;

class DetailCommentHelper$RepliedInfo
{
  public CommentEntry a;
  public int b = -1;
  private int d = -1;
  
  DetailCommentHelper$RepliedInfo(DetailCommentHelper paramDetailCommentHelper) {}
  
  private void a()
  {
    this.a = null;
    this.b = -1;
    this.d = -1;
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt)
  {
    this.a = paramCommentEntry;
    this.d = paramCommentEntry.commentId;
    this.b = paramInt;
  }
  
  public boolean a(CommentEntry paramCommentEntry)
  {
    return paramCommentEntry.commentId != this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper.RepliedInfo
 * JD-Core Version:    0.7.0.1
 */