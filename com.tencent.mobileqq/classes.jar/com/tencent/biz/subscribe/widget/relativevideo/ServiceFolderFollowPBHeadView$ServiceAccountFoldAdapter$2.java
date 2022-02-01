package com.tencent.biz.subscribe.widget.relativevideo;

import android.support.v7.widget.RecyclerView;
import znb;

public class ServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter$2
  implements Runnable
{
  public ServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter$2(znb paramznb) {}
  
  public void run()
  {
    if (znb.a(this.this$0) != null)
    {
      znb.a(this.this$0, true);
      if ((!znb.a(this.this$0).isComputingLayout()) && (znb.a(this.this$0).getScrollState() == 0))
      {
        znb.a(this.this$0, false);
        this.this$0.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter.2
 * JD-Core Version:    0.7.0.1
 */