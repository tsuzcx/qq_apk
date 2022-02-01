package com.tencent.biz.pubaccount.weishi_new.report;

import com.google.gson.Gson;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class WSStatisticsReporter$1
  implements Runnable
{
  WSStatisticsReporter$1(WSStatisticsReporter paramWSStatisticsReporter, String paramString) {}
  
  public void run()
  {
    if (WSStatisticsReporter.access$600(this.this$0) == null) {
      return;
    }
    WSStatisticsReporter.access$600(this.this$0).setEventName(WSStatisticsReporter.access$700(this.this$0));
    WSStatisticsReporter.access$1000(this.this$0, WSStatisticsReporter.Builder.access$900(WSStatisticsReporter.access$800(this.this$0)));
    String str = new Gson().toJson(WSStatisticsReporter.Builder.access$900(WSStatisticsReporter.access$800(this.this$0)));
    WSStatisticsReporter.access$600(this.this$0).setExtendInfo(str);
    WSStatisticsReporter.access$1200(this.this$0).putAll(WSStatisticsReporter.Builder.access$1100(WSStatisticsReporter.access$800(this.this$0)));
    WSStatisticsReporter.access$600(this.this$0).setSubSession(this.a);
    WSStatisticsReporter.access$1200(this.this$0).putAll(WSStatisticsReporter.access$600(this.this$0).getBaseParams());
    if (WSStatisticsReporter.access$1300(this.this$0)) {
      UserAction.onUserAction(WSStatisticsReporter.access$700(this.this$0), true, -1L, -1L, WSStatisticsReporter.access$1200(this.this$0), true);
    }
    for (;;)
    {
      if (WSStatisticsReporter.access$1500(this.this$0)) {
        WSStatisticsReporter.access$1600(this.this$0);
      }
      WSLog.b("reportVideoSession", "mEventName :" + WSStatisticsReporter.access$700(this.this$0) + ", position: " + (String)WSStatisticsReporter.access$1200(this.this$0).get("position") + ", sopName: " + (String)WSStatisticsReporter.access$1200(this.this$0).get("sop_name") + ", videoPageSession: " + (String)WSStatisticsReporter.access$1200(this.this$0).get("sub_session_id"));
      WSStatisticsReporter.access$1700(this.this$0);
      return;
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, WSStatisticsReporter.access$700(this.this$0), true, 0L, 0L, WSStatisticsReporter.access$1200(this.this$0), "", WSStatisticsReporter.access$1400(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.1
 * JD-Core Version:    0.7.0.1
 */