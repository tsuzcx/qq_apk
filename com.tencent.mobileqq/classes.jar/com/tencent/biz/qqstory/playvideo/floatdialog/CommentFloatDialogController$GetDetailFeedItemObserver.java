package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.reactive.SimpleObserver;

public class CommentFloatDialogController$GetDetailFeedItemObserver
  extends SimpleObserver<DetailFeedItem>
{
  public CommentFloatDialogController$GetDetailFeedItemObserver(CommentFloatDialogController paramCommentFloatDialogController) {}
  
  public void a(DetailFeedItem paramDetailFeedItem)
  {
    super.onNext(paramDetailFeedItem);
    CommentFloatDialogController.a(this.a, paramDetailFeedItem, new ErrorMessage(), true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("Q.qqstory.player.CommentFloatDialogController", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (((ErrorMessage)paramError).errorCode == 2223)
    {
      CommentFloatDialogController.a(this.a, CommentFloatDialogController.a(this.a), new ErrorMessage(), false);
      return;
    }
    CommentFloatDialogController.a(this.a, CommentFloatDialogController.a(this.a), (ErrorMessage)paramError, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogController.GetDetailFeedItemObserver
 * JD-Core Version:    0.7.0.1
 */