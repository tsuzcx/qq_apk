package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class CommentFloatDialogController$GetUserInfoReceiver
  extends QQUIEventReceiver<CommentFloatDialogController, GetUserInfoHandler.UpdateUserInfoEvent>
{
  public CommentFloatDialogController$GetUserInfoReceiver(@NonNull CommentFloatDialogController paramCommentFloatDialogController)
  {
    super(paramCommentFloatDialogController);
  }
  
  public void a(@NonNull CommentFloatDialogController paramCommentFloatDialogController, @NonNull GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if (paramUpdateUserInfoEvent.g.isSuccess())
    {
      SLog.a(this.TAG, "receive user info event. %s.", paramUpdateUserInfoEvent.toString());
      paramCommentFloatDialogController = paramCommentFloatDialogController.c();
      if (paramCommentFloatDialogController != null) {
        paramCommentFloatDialogController.a();
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return GetUserInfoHandler.UpdateUserInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogController.GetUserInfoReceiver
 * JD-Core Version:    0.7.0.1
 */