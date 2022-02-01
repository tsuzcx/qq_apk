package com.tencent.ad.tangram.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.protocol.link_report.LinkReport.ReportBiz;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.statistics.c;
import java.lang.ref.WeakReference;

class AdAppReceiver$1
  implements Runnable
{
  AdAppReceiver$1(AdAppReceiver paramAdAppReceiver, AdClickUtil.Params paramParams) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.val$params.ad.getAppDeeplink()))
    {
      c.reportAsync(new WeakReference(this.val$params.activity.get()), this.val$params.ad, 297);
      link_report.LinkReport.ReportBiz localReportBiz = new link_report.LinkReport.ReportBiz();
      localReportBiz.deeplink_scene = 1;
      localReportBiz.deeplink_type = 3;
      AdReporterForLinkEvent.reportAsync((Context)this.val$params.activity.get(), 4002014, this.val$params.ad, localReportBiz, null);
      AdClickUtil.handleAppWithDeeplink(this.val$params, true);
      return;
    }
    AdClickUtil.handleApp(this.val$params, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdAppReceiver.1
 * JD-Core Version:    0.7.0.1
 */