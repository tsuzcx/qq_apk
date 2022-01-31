package com.tencent.mobileqq.activity;

import abel;
import android.text.TextUtils;
import auuw;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;

public class FriendProfileCardActivity$32$1
  implements Runnable
{
  public FriendProfileCardActivity$32$1(abel paramabel) {}
  
  public void run()
  {
    try
    {
      if (!TextUtils.isEmpty(this.a.a.a.a.a))
      {
        Object localObject = this.a.a.a.a.a;
        if (this.a.a.a.a.a.startsWith("+")) {
          localObject = this.a.a.a.a.a.substring(1);
        }
        localObject = new LpReportInfo_pf00064(699, 3, Long.valueOf((String)localObject).longValue());
        LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, false);
      }
      return;
    }
    catch (Exception localException)
    {
      QZLog.e("QzoneReport", "makeOrRefreshQZone", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.32.1
 * JD-Core Version:    0.7.0.1
 */