package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import awmk;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;

class FriendProfileCardActivity$8
  implements Runnable
{
  FriendProfileCardActivity$8(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    try
    {
      if (!TextUtils.isEmpty(this.this$0.a.a.a))
      {
        Object localObject = this.this$0.a.a.a;
        if (this.this$0.a.a.a.startsWith("+")) {
          localObject = this.this$0.a.a.a.substring(1);
        }
        localObject = new LpReportInfo_pf00064(699, 1, Long.valueOf((String)localObject).longValue());
        LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, false);
      }
      return;
    }
    catch (Exception localException)
    {
      QZLog.e("QzoneReport", "LpReportInfoProfile", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.8
 * JD-Core Version:    0.7.0.1
 */