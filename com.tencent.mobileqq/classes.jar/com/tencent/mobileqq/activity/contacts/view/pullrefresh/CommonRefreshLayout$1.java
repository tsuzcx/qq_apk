package com.tencent.mobileqq.activity.contacts.view.pullrefresh;

import ahvr;

class CommonRefreshLayout$1
  implements Runnable
{
  CommonRefreshLayout$1(CommonRefreshLayout paramCommonRefreshLayout) {}
  
  public void run()
  {
    if (CommonRefreshLayout.a(this.this$0) != null) {
      CommonRefreshLayout.a(this.this$0).onViewCompleteAfterRefresh(CommonRefreshLayout.a(this.this$0));
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.view.pullrefresh.CommonRefreshLayout.1
 * JD-Core Version:    0.7.0.1
 */