package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.view.View;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class MystoryListView$1
  implements AbsListView.OnScrollListener
{
  MystoryListView$1(MystoryListView paramMystoryListView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.a.b != null) && (MystoryListView.a(this.a) != 1) && (paramAbsListView.getCount() != 0))
    {
      if (-MystoryListView.c(this.a) > UIUtils.e(this.a.b) * 3) {
        this.a.a.b(true);
      }
      if (paramInt3 != 0)
      {
        if (!MystoryListView.d(this.a)) {
          return;
        }
        Object localObject = paramAbsListView.getChildAt(0);
        int j = ((View)localObject).getTop();
        int k = ((View)localObject).getBottom();
        int m = ((View)localObject).getHeight();
        int i;
        if (paramInt1 > MystoryListView.e(this.a))
        {
          localObject = this.a;
          MystoryListView.b((MystoryListView)localObject, MystoryListView.f((MystoryListView)localObject) + MystoryListView.g(this.a));
          i = j - MystoryListView.f(this.a);
        }
        else
        {
          if (paramInt1 < MystoryListView.e(this.a))
          {
            localObject = this.a;
            MystoryListView.c((MystoryListView)localObject, MystoryListView.h((MystoryListView)localObject) - MystoryListView.g(this.a));
            i = MystoryListView.h(this.a);
          }
          else
          {
            i = MystoryListView.h(this.a);
          }
          i = k - i;
        }
        localObject = this.a;
        MystoryListView.e((MystoryListView)localObject, MystoryListView.i((MystoryListView)localObject) + i);
        localObject = this.a;
        MystoryListView.f((MystoryListView)localObject, MystoryListView.c((MystoryListView)localObject) + i);
        MystoryListView.b(this.a, j);
        MystoryListView.c(this.a, k);
        MystoryListView.d(this.a, m);
        MystoryListView.a(this.a, paramInt1);
      }
      else
      {
        return;
      }
    }
    if (MystoryListView.b(this.a) != null) {
      MystoryListView.b(this.a).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((MystoryListView.a(this.a) != 1) && (paramAbsListView.getCount() != 0)) {
      if (paramInt != 0)
      {
        if (paramInt == 1)
        {
          View localView = paramAbsListView.getChildAt(0);
          MystoryListView.a(this.a, paramAbsListView.getFirstVisiblePosition());
          if (localView != null)
          {
            MystoryListView.b(this.a, localView.getTop());
            MystoryListView.c(this.a, localView.getBottom());
            MystoryListView.d(this.a, localView.getHeight());
          }
          MystoryListView.a(this.a, true);
          MystoryListView.e(this.a, 0);
        }
      }
      else {
        MystoryListView.a(this.a, false);
      }
    }
    if (MystoryListView.b(this.a) != null) {
      MystoryListView.b(this.a).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView.1
 * JD-Core Version:    0.7.0.1
 */