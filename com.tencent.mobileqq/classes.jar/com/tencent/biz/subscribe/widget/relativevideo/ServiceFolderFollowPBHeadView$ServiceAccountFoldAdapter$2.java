package com.tencent.biz.subscribe.widget.relativevideo;

import android.support.v7.widget.RecyclerView;

class ServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter$2
  implements Runnable
{
  ServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter$2(ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter paramServiceAccountFoldAdapter) {}
  
  public void run()
  {
    if (ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter.b(this.this$0) != null)
    {
      ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter.a(this.this$0, true);
      if ((!ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter.b(this.this$0).isComputingLayout()) && (ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter.b(this.this$0).getScrollState() == 0))
      {
        ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter.a(this.this$0, false);
        this.this$0.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter.2
 * JD-Core Version:    0.7.0.1
 */