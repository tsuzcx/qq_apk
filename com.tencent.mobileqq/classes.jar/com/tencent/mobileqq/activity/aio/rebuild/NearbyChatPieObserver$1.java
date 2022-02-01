package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.statistics.ReportTask;

class NearbyChatPieObserver$1
  implements Runnable
{
  NearbyChatPieObserver$1(NearbyChatPieObserver paramNearbyChatPieObserver, boolean paramBoolean, String paramString, INearbyCardManager paramINearbyCardManager) {}
  
  public void run()
  {
    ReportTask localReportTask = new ReportTask(NearbyChatPieObserver.a(this.this$0).d).a("dc00899").b("grp_lbs").c("data_card");
    String str;
    if (this.a) {
      str = "msg_suc";
    } else {
      str = "msg_fail";
    }
    localReportTask.d(str).e(NearbyChatPieObserver.a(this.this$0).ah.b).a(new String[] { this.b, String.valueOf(this.c.c()) }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPieObserver.1
 * JD-Core Version:    0.7.0.1
 */