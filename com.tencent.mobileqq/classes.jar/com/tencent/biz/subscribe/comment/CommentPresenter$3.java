package com.tencent.biz.subscribe.comment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommentPresenter$3
  implements View.OnClickListener
{
  CommentPresenter$3(CommentPresenter paramCommentPresenter) {}
  
  public void onClick(View paramView)
  {
    CommentPresenter.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.3
 * JD-Core Version:    0.7.0.1
 */