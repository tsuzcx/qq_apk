package com.tencent.biz.subscribe.widget.relativevideo;

import aaqh;
import android.support.v7.widget.RecyclerView;

public class ServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter$2
  implements Runnable
{
  public ServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter$2(aaqh paramaaqh) {}
  
  public void run()
  {
    if (aaqh.a(this.this$0) != null)
    {
      aaqh.a(this.this$0, true);
      if ((!aaqh.a(this.this$0).isComputingLayout()) && (aaqh.a(this.this$0).getScrollState() == 0))
      {
        aaqh.a(this.this$0, false);
        this.this$0.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter.2
 * JD-Core Version:    0.7.0.1
 */