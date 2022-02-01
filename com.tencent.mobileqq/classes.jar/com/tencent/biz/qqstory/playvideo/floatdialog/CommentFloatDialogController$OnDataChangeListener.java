package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;

public abstract interface CommentFloatDialogController$OnDataChangeListener
{
  public abstract void a();
  
  public abstract void a(@NonNull DetailFeedItem paramDetailFeedItem, ErrorMessage paramErrorMessage, boolean paramBoolean);
  
  public abstract void a(@NonNull DetailFeedItem paramDetailFeedItem, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogController.OnDataChangeListener
 * JD-Core Version:    0.7.0.1
 */