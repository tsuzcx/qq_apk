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
    paramError = (ErrorMessage)paramError;
    if (paramError.errorCode == 2223)
    {
      paramError = this.a;
      CommentFloatDialogController.a(paramError, CommentFloatDialogController.a(paramError), new ErrorMessage(), false);
      return;
    }
    CommentFloatDialogController localCommentFloatDialogController = this.a;
    CommentFloatDialogController.a(localCommentFloatDialogController, CommentFloatDialogController.a(localCommentFloatDialogController), paramError, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogController.GetDetailFeedItemObserver
 * JD-Core Version:    0.7.0.1
 */