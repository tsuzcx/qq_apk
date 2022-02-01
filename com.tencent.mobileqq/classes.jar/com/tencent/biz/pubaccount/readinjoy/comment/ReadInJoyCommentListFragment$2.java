package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.guide.GuideHelper;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class ReadInJoyCommentListFragment$2
  implements AbsListView.OnScrollListener
{
  ReadInJoyCommentListFragment$2(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    ((ReadInJoyCommentListView)paramAbsListView).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (ReadInJoyCommentListFragment.a(this.a) != null)
    {
      if (ReadInJoyCommentListFragment.a(this.a).a().a().a()) {
        break label95;
      }
      ((ReadInJoyCommentListView)paramAbsListView).onScrollStateChanged(paramAbsListView, paramInt);
    }
    for (;;)
    {
      if ((ReadInJoyCommentListFragment.a(this.a) != null) && (ReadInJoyCommentListFragment.a(this.a).a() != null)) {
        ReadInJoyCommentListFragment.a(this.a).a().a(ReadInJoyCommentListFragment.a(this.a).getFirstVisiblePosition(), ReadInJoyCommentListFragment.a(this.a).getLastVisiblePosition());
      }
      return;
      label95:
      ((ReadInJoyCommentListView)paramAbsListView).hideFooterView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment.2
 * JD-Core Version:    0.7.0.1
 */