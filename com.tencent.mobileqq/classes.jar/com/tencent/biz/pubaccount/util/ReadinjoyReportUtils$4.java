package com.tencent.biz.pubaccount.util;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.qroute.QRoute;

final class ReadinjoyReportUtils$4
  implements Runnable
{
  ReadinjoyReportUtils$4(RecentItemChatMsgData paramRecentItemChatMsgData) {}
  
  public void run()
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    if (this.a.mUnreadNum > 0) {}
    for (int i = 1;; i = 0)
    {
      localReportR5Builder.b("reddot_position", "" + (this.a.mPosition + 1));
      if (i != 0) {}
      for (String str = "1";; str = "0")
      {
        localReportR5Builder.b("reddot_state", str);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800978E", "0X800978E", 0, 0, "", "", "", localReportR5Builder.a(), false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadinjoyReportUtils.4
 * JD-Core Version:    0.7.0.1
 */