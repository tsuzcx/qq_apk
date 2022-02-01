package com.tencent.biz.qqstory.playvideo.floatdialog;

import com.tencent.biz.qqstory.storyHome.detail.model.CommentListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailPresenter.DetailFeedPushObserver.OnPushCallback;

class CommentFloatDialogController$1
  implements StoryDetailPresenter.DetailFeedPushObserver.OnPushCallback
{
  CommentFloatDialogController$1(CommentFloatDialogController paramCommentFloatDialogController) {}
  
  public void a(int paramInt)
  {
    if ((paramInt == 1) && (CommentFloatDialogController.a(this.a) != null) && (CommentFloatDialogController.a(this.a).a != null)) {
      if (!CommentFloatDialogController.a(this.a).b())
      {
        if (CommentFloatDialogController.a(this.a).b(true)) {
          CommentFloatDialogController.b(this.a).c();
        }
      }
      else
      {
        if (CommentFloatDialogController.a(this.a).b(false)) {
          CommentFloatDialogController.c(this.a).c();
        }
        if (CommentFloatDialogController.a(this.a).b(true)) {
          CommentFloatDialogController.b(this.a).c();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogController.1
 * JD-Core Version:    0.7.0.1
 */