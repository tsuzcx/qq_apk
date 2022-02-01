package com.tencent.av.wtogether.view;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class GroupFileSearchDialog$2
  implements AbsListView.OnScrollListener
{
  int a = 0;
  int b = 0;
  
  GroupFileSearchDialog$2(GroupFileSearchDialog paramGroupFileSearchDialog) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt3;
    this.a = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    try
    {
      int i = this.c.x;
      if (i > 0) {
        return;
      }
      if ((paramInt == 0) && (this.c.D != null) && (this.a == this.b - 2)) {
        if (this.c.z)
        {
          this.c.c(true);
        }
        else
        {
          this.c.c(false);
          this.c.a(this.c.l, this.c.C, this.c.w, this.c.y);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.GroupFileSearchDialog.2
 * JD-Core Version:    0.7.0.1
 */