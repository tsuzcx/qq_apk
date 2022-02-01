package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommentPresenter$OnFeedCommentElementClickListener$2
  implements View.OnClickListener
{
  CommentPresenter$OnFeedCommentElementClickListener$2(CommentPresenter.OnFeedCommentElementClickListener paramOnFeedCommentElementClickListener, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void onClick(View paramView)
  {
    if (CommentPresenter.k(this.b.a) != null)
    {
      CommentPresenter.a(this.b.a, CommentPresenter.i(this.b.a).b(CommentPresenter.k(this.b.a), this.a));
      CommentPresenter.c(this.b.a, true);
    }
    CommentPresenter.r(this.b.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.OnFeedCommentElementClickListener.2
 * JD-Core Version:    0.7.0.1
 */