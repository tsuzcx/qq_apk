package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.comment.FeedInfoChangeEvent;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;

public class CommentFloatDialogController$FeedInfoUpdateReceiver
  extends UIBaseEventReceiver<CommentFloatDialogController, FeedInfoChangeEvent>
{
  public CommentFloatDialogController$FeedInfoUpdateReceiver(CommentFloatDialogController paramCommentFloatDialogController)
  {
    super(paramCommentFloatDialogController);
  }
  
  public void a(@NonNull CommentFloatDialogController paramCommentFloatDialogController, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent)
  {
    if ((paramFeedInfoChangeEvent.a != 2) && (paramFeedInfoChangeEvent.b.equals(CommentFloatDialogController.d(paramCommentFloatDialogController))) && (CommentFloatDialogController.a(paramCommentFloatDialogController) != null) && (CommentFloatDialogController.a(paramCommentFloatDialogController).a != null))
    {
      SLog.a(this.TAG, "receive feed info change event. %s.", paramFeedInfoChangeEvent.toString());
      CommentFloatDialogController.OnDataChangeListener localOnDataChangeListener = paramCommentFloatDialogController.c();
      if (paramFeedInfoChangeEvent.d != 2) {
        return;
      }
      if (paramFeedInfoChangeEvent.c != null)
      {
        CommentFloatDialogController.a(paramCommentFloatDialogController).a.mCommentCount = paramFeedInfoChangeEvent.c.mCommentCount;
        CommentFloatDialogController.a(paramCommentFloatDialogController).a.mFriendCommentCount = paramFeedInfoChangeEvent.c.mFriendCommentCount;
        CommentFloatDialogController.a(paramCommentFloatDialogController).a.mFanCommentCount = paramFeedInfoChangeEvent.c.mFanCommentCount;
      }
      CommentFloatDialogController.a(paramCommentFloatDialogController).a(paramFeedInfoChangeEvent.e);
      if (localOnDataChangeListener != null) {
        localOnDataChangeListener.a(CommentFloatDialogController.a(paramCommentFloatDialogController), paramFeedInfoChangeEvent.g.isSuccess());
      }
      return;
    }
    SLog.b(this.TAG, "ignore this feed info change event. %s.", paramFeedInfoChangeEvent.toString());
  }
  
  public Class acceptEventClass()
  {
    return FeedInfoChangeEvent.class;
  }
  
  public void b(@NonNull CommentFloatDialogController paramCommentFloatDialogController, @NonNull FeedInfoChangeEvent paramFeedInfoChangeEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogController.FeedInfoUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */