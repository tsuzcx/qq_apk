package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.database.CommentEntry;

public abstract interface DetailEventCallback
{
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(CommentEntry paramCommentEntry, int paramInt);
  
  public abstract void b();
  
  public abstract void b(CommentEntry paramCommentEntry, int paramInt);
  
  public abstract void bo_();
  
  public abstract void bp_();
  
  public abstract void g();
  
  public abstract void h_(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailEventCallback
 * JD-Core Version:    0.7.0.1
 */