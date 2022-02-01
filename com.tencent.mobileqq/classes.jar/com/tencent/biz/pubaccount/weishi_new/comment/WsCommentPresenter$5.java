package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WsCommentPresenter$5
  implements AbsListView.OnScrollListener
{
  boolean a = false;
  
  WsCommentPresenter$5(WsCommentPresenter paramWsCommentPresenter) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if ((paramInt3 > 0) && (paramAbsListView.getFirstVisiblePosition() + paramInt2 >= paramInt3)) {
      bool = true;
    } else {
      bool = false;
    }
    this.a = bool;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.a) && (paramInt == 0))
    {
      paramAbsListView = new StringBuilder();
      paramAbsListView.append("onScrollStateChanged scrollState:");
      paramAbsListView.append(paramInt);
      WSLog.c("comment", paramAbsListView.toString());
      paramAbsListView = this.b;
      WsCommentPresenter.c(paramAbsListView, paramAbsListView.h().a(this.b.g()));
      if (WsCommentPresenter.b(this.b) != null)
      {
        this.b.h().a(this.b.n(), true, WsCommentPresenter.c(this.b), WsCommentPresenter.d(this.b));
        WsCommentPresenter.a(this.b, true);
        return;
      }
      WSLog.c("comment", "mCommentAttachInfo is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.5
 * JD-Core Version:    0.7.0.1
 */