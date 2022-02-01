package com.tencent.mobileqq.activity.contacts.mayknow;

import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class RecommendsAdapter$1
  implements AbsListView.OnScrollListener
{
  RecommendsAdapter$1(RecommendsAdapter paramRecommendsAdapter) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.RecommendsAdapter", 2, "onScrollStateChanged firstVisibleItem: " + paramInt1 + " visibleItemCount: " + paramInt2 + " totalItemCount: " + paramInt3);
    }
    if ((paramInt1 >= 1) && (paramInt1 - 1 >= 0) && (paramInt1 - 1 < this.a.getCount()))
    {
      paramAbsListView = (MayKnowRecommend)this.a.getItem(paramInt1 - 1);
      if (paramAbsListView != null) {
        this.a.a.b(paramAbsListView, 20, 0, 1);
      }
    }
    if ((paramInt1 + paramInt2 < paramInt3) && (paramInt1 + paramInt2 >= 0) && (paramInt1 + paramInt2 < this.a.getCount()))
    {
      paramAbsListView = (MayKnowRecommend)this.a.getItem(paramInt1 + paramInt2);
      if (paramAbsListView != null) {
        this.a.a.b(paramAbsListView, 20, 0, 1);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.RecommendsAdapter.1
 * JD-Core Version:    0.7.0.1
 */