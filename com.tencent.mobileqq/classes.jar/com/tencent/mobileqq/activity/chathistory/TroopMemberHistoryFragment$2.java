package com.tencent.mobileqq.activity.chathistory;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class TroopMemberHistoryFragment$2
  implements AbsListView.OnScrollListener
{
  private int b;
  private int c;
  
  TroopMemberHistoryFragment$2(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = this.a.k.getCount();
    this.b = (paramInt1 + paramInt2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((!this.a.c) && (!this.a.m))
    {
      int i = this.c;
      if (i <= 0) {
        return;
      }
      if ((paramInt == 0) && (i <= this.b)) {
        this.a.a(21);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment.2
 * JD-Core Version:    0.7.0.1
 */