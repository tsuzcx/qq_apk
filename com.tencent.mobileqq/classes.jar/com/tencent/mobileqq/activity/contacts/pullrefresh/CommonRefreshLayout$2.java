package com.tencent.mobileqq.activity.contacts.pullrefresh;

import android.view.ViewGroup;

class CommonRefreshLayout$2
  extends CommonRefreshLayout.RefreshCallback
{
  CommonRefreshLayout$2(CommonRefreshLayout paramCommonRefreshLayout)
  {
    super(paramCommonRefreshLayout);
  }
  
  public void a()
  {
    if ((CommonRefreshLayout.c(this.a) != null) && ((CommonRefreshLayout.c(this.a) instanceof SwipeTrigger)) && ((CommonRefreshLayout.STATUS.a(CommonRefreshLayout.d(this.a))) || (CommonRefreshLayout.STATUS.h(CommonRefreshLayout.d(this.a)))))
    {
      CommonRefreshLayout.c(this.a).setVisibility(0);
      ((SwipeTrigger)CommonRefreshLayout.c(this.a)).a();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((CommonRefreshLayout.c(this.a) != null) && ((CommonRefreshLayout.c(this.a) instanceof SwipeTrigger)) && (CommonRefreshLayout.STATUS.c(CommonRefreshLayout.d(this.a))))
    {
      if (CommonRefreshLayout.c(this.a).getVisibility() != 0) {
        CommonRefreshLayout.c(this.a).setVisibility(0);
      }
      ((SwipeTrigger)CommonRefreshLayout.c(this.a)).a(paramInt, paramBoolean1, paramBoolean2);
    }
  }
  
  public void b()
  {
    if ((CommonRefreshLayout.c(this.a) != null) && ((CommonRefreshLayout.c(this.a) instanceof SwipeTrigger)) && (CommonRefreshLayout.STATUS.e(CommonRefreshLayout.d(this.a)))) {
      ((SwipeTrigger)CommonRefreshLayout.c(this.a)).b();
    }
  }
  
  public void c()
  {
    if ((CommonRefreshLayout.c(this.a) != null) && (CommonRefreshLayout.STATUS.b(CommonRefreshLayout.d(this.a))))
    {
      if ((CommonRefreshLayout.c(this.a) instanceof SwipeRefreshTrigger)) {
        ((SwipeRefreshTrigger)CommonRefreshLayout.c(this.a)).c();
      }
      if (CommonRefreshLayout.e(this.a) != null) {
        CommonRefreshLayout.e(this.a).a();
      }
    }
  }
  
  public void d()
  {
    if ((CommonRefreshLayout.c(this.a) != null) && ((CommonRefreshLayout.c(this.a) instanceof SwipeTrigger)) && ((CommonRefreshLayout.STATUS.a(CommonRefreshLayout.d(this.a))) || (CommonRefreshLayout.STATUS.h(CommonRefreshLayout.d(this.a))))) {
      ((SwipeTrigger)CommonRefreshLayout.c(this.a)).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout.2
 * JD-Core Version:    0.7.0.1
 */