package com.tencent.mobileqq.activity.contacts.topentry;

import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class MayknowRecommendsAdapter$1
  implements AbsListView.OnScrollListener
{
  MayknowRecommendsAdapter$1(MayknowRecommendsAdapter paramMayknowRecommendsAdapter) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      paramAbsListView = new StringBuilder();
      paramAbsListView.append("onScrollStateChanged firstVisibleItem: ");
      paramAbsListView.append(paramInt1);
      paramAbsListView.append(" visibleItemCount: ");
      paramAbsListView.append(paramInt2);
      paramAbsListView.append(" totalItemCount: ");
      paramAbsListView.append(paramInt3);
      QLog.d("contacts.RecommendsAdapter", 2, paramAbsListView.toString());
    }
    if (paramInt1 >= 1)
    {
      int i = paramInt1 - 1;
      if ((i >= 0) && (i < this.a.getCount()))
      {
        paramAbsListView = (MayKnowRecommend)this.a.getItem(i);
        if (paramAbsListView != null) {
          this.a.a.b(paramAbsListView, 24, 0, 1);
        }
      }
    }
    paramInt1 += paramInt2;
    if ((paramInt1 < paramInt3) && (paramInt1 >= 0) && (paramInt1 < this.a.getCount()))
    {
      paramAbsListView = (MayKnowRecommend)this.a.getItem(paramInt1);
      if (paramAbsListView != null) {
        this.a.a.b(paramAbsListView, 24, 0, 1);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.MayknowRecommendsAdapter.1
 * JD-Core Version:    0.7.0.1
 */