package com.tencent.biz.subscribe.comment;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommentPresenter$4
  implements AbsListView.OnScrollListener
{
  boolean a = false;
  
  CommentPresenter$4(CommentPresenter paramCommentPresenter) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 > 0) && (paramAbsListView.getFirstVisiblePosition() + paramInt2 >= paramInt3))
    {
      this.a = true;
      return;
    }
    this.a = false;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if ((this.a) && (paramInt == 0) && (!CommentPresenter.f(this.b)) && (!CommentPresenter.g(this.b)))
    {
      QLog.i(CommentPresenter.t(), 1, "onLastItemVisible");
      paramAbsListView = this.b;
      CommentPresenter.a(paramAbsListView, CommentPresenter.i(paramAbsListView).a(CommentPresenter.h(this.b)));
      if (CommentPresenter.j(this.b) != null)
      {
        CommentPresenter.i(this.b).a(CommentPresenter.k(this.b), true);
        CommentPresenter.a(this.b, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.4
 * JD-Core Version:    0.7.0.1
 */