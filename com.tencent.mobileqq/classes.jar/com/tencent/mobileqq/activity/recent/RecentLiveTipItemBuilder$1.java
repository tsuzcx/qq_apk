package com.tencent.mobileqq.activity.recent;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.statistics.ReportTask;

class RecentLiveTipItemBuilder$1
  implements Runnable
{
  RecentLiveTipItemBuilder$1(RecentLiveTipItemBuilder paramRecentLiveTipItemBuilder, QQAppInterface paramQQAppInterface, MessageForNearbyLiveTip paramMessageForNearbyLiveTip, INearbyCardManager paramINearbyCardManager) {}
  
  public void run()
  {
    ReportTask localReportTask = new ReportTask(this.a).a("dc00899").b("grp_lbs").c("msg_box");
    if (this.b.isLiving) {
      localObject = "exp_livepush";
    } else {
      localObject = "exp_relivepush";
    }
    Object localObject = localReportTask.d((String)localObject).e(String.valueOf(Long.valueOf(this.b.senderuin).longValue() - AppConstants.NOW_LIVE_TIP_UIN_BASE));
    int i;
    if (this.b.isLiving) {
      i = this.b.startLiveWordingType;
    } else {
      i = this.b.endLiveWordingType;
    }
    ((ReportTask)localObject).a(new String[] { String.valueOf(i), String.valueOf(this.c.c()) }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentLiveTipItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */