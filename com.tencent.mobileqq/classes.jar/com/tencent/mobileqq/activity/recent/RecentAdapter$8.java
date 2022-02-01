package com.tencent.mobileqq.activity.recent;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.mobileqq.statistics.ReportController;

class RecentAdapter$8
  implements Runnable
{
  RecentAdapter$8(RecentAdapter paramRecentAdapter, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    ReportController.b(this.this$0.d, "dc01160", "Pb_account_lifeservice", "", "0X800687A", "0X800687A", this.a, 0, this.b, this.c, this.d, String.valueOf(ServiceAccountFolderManager.a().d()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAdapter.8
 * JD-Core Version:    0.7.0.1
 */