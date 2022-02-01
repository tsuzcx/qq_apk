package com.tencent.biz.subscribe.widget.relativevideo;

import aacg;
import android.support.v7.widget.RecyclerView;

public class ServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter$2
  implements Runnable
{
  public ServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter$2(aacg paramaacg) {}
  
  public void run()
  {
    if (aacg.a(this.this$0) != null)
    {
      aacg.a(this.this$0, true);
      if ((!aacg.a(this.this$0).isComputingLayout()) && (aacg.a(this.this$0).getScrollState() == 0))
      {
        aacg.a(this.this$0, false);
        this.this$0.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter.2
 * JD-Core Version:    0.7.0.1
 */