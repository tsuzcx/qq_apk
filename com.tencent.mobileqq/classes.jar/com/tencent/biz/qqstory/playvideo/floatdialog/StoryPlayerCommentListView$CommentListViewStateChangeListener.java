package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;

public abstract interface StoryPlayerCommentListView$CommentListViewStateChangeListener
{
  public abstract void a();
  
  public abstract void a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2);
  
  public abstract void a(@NonNull DetailFeedItem paramDetailFeedItem, ErrorMessage paramErrorMessage);
  
  public abstract boolean a(MotionEvent paramMotionEvent);
  
  public abstract void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView.CommentListViewStateChangeListener
 * JD-Core Version:    0.7.0.1
 */