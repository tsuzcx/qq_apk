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
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof SwipeTrigger)) && ((CommonRefreshLayout.STATUS.a(CommonRefreshLayout.a(this.a))) || (CommonRefreshLayout.STATUS.h(CommonRefreshLayout.a(this.a)))))
    {
      CommonRefreshLayout.a(this.a).setVisibility(0);
      ((SwipeTrigger)CommonRefreshLayout.a(this.a)).a();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof SwipeTrigger)) && (CommonRefreshLayout.STATUS.c(CommonRefreshLayout.a(this.a))))
    {
      if (CommonRefreshLayout.a(this.a).getVisibility() != 0) {
        CommonRefreshLayout.a(this.a).setVisibility(0);
      }
      ((SwipeTrigger)CommonRefreshLayout.a(this.a)).a(paramInt, paramBoolean1, paramBoolean2);
    }
  }
  
  public void b()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof SwipeTrigger)) && (CommonRefreshLayout.STATUS.e(CommonRefreshLayout.a(this.a)))) {
      ((SwipeTrigger)CommonRefreshLayout.a(this.a)).b();
    }
  }
  
  public void c()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && (CommonRefreshLayout.STATUS.b(CommonRefreshLayout.a(this.a))))
    {
      if ((CommonRefreshLayout.a(this.a) instanceof SwipeRefreshTrigger)) {
        ((SwipeRefreshTrigger)CommonRefreshLayout.a(this.a)).c();
      }
      if (CommonRefreshLayout.a(this.a) != null) {
        CommonRefreshLayout.a(this.a).a();
      }
    }
  }
  
  public void d()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof SwipeTrigger)) && ((CommonRefreshLayout.STATUS.a(CommonRefreshLayout.a(this.a))) || (CommonRefreshLayout.STATUS.h(CommonRefreshLayout.a(this.a))))) {
      ((SwipeTrigger)CommonRefreshLayout.a(this.a)).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout.2
 * JD-Core Version:    0.7.0.1
 */