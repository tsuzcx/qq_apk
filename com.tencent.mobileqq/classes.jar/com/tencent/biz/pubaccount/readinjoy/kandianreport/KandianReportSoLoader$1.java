package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import mqq.os.MqqHandler;

final class KandianReportSoLoader$1
  implements TaskOfflineUtils.OfflineCallBack
{
  KandianReportSoLoader$1(Runnable paramRunnable) {}
  
  public void onStateChange(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      KandianReportSoLoader.access$002(paramInt2);
      ReadInJoyHelper.a("kd_fc_so_download", Boolean.valueOf(true));
      QLog.d("kandianreport.KandianReportSoLoader", 1, "download so success: a new version: " + KandianReportSoLoader.access$000());
      ThreadManager.getFileThreadHandler().post(new KandianReportSoLoader.1.1(this));
    }
    for (;;)
    {
      boolean bool = new File(KandianReportSoLoader.access$400()).exists();
      KandianReportSoLoader.logAndReport("local so file exists: " + bool);
      return;
      if ((paramInt1 != 7) && (paramInt1 != 8) && (paramInt1 != 5) && (!((Boolean)ReadInJoyHelper.a("kd_fc_so_download", Boolean.valueOf(false))).booleanValue())) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009A1C", "0X8009A1C", 0, 0, "", "", "" + paramInt1, "download fail", false);
      }
      QLog.d("kandianreport.KandianReportSoLoader", 1, "download so fail or not update:" + paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.KandianReportSoLoader.1
 * JD-Core Version:    0.7.0.1
 */