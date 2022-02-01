package com.tencent.biz.subscribe.comment;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.qphone.base.util.QLog;

class CommentPresenter$5
  implements View.OnLayoutChangeListener
{
  CommentPresenter$5(CommentPresenter paramCommentPresenter) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    QLog.d(CommentPresenter.a(), 2, "OnLayoutChangeListener scrollToReplyView start mScrollToTargetReply" + CommentPresenter.c(this.a));
    if ((CommentPresenter.a(this.a) != null) && (CommentPresenter.c(this.a))) {
      CommentPresenter.a(this.a, new CommentPresenter.5.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.5
 * JD-Core Version:    0.7.0.1
 */