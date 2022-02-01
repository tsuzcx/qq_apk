package com.tencent.mobileqq.activity.contact.recommendtroop;

import android.widget.TextView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class RecommendTroopListWrapper$1
  implements AbsListView.OnScrollListener
{
  RecommendTroopListWrapper$1(RecommendTroopListWrapper paramRecommendTroopListWrapper) {}
  
  private boolean a(AbsListView paramAbsListView)
  {
    return (paramAbsListView.getChildAt(paramAbsListView.getChildCount() - 1) == this.a.a) && (this.a.a.getBottom() == this.a.a.getBottom());
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (a(paramAbsListView))) {
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.recommendtroop.RecommendTroopListWrapper.1
 * JD-Core Version:    0.7.0.1
 */