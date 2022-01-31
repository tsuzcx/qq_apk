package com.tencent.biz.pubaccount.weishi_new.report;

import azri;
import com.google.gson.Gson;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import tlo;

class WSStatisticsReporter$1
  implements Runnable
{
  WSStatisticsReporter$1(WSStatisticsReporter paramWSStatisticsReporter) {}
  
  public void run()
  {
    if (WSStatisticsReporter.access$400(this.this$0) == null) {
      return;
    }
    String str = new Gson().toJson(WSStatisticsReporter.Builder.access$600(WSStatisticsReporter.access$500(this.this$0)));
    WSStatisticsReporter.access$400(this.this$0).setExtendInfo(str);
    WSStatisticsReporter.access$800(this.this$0).putAll(WSStatisticsReporter.Builder.access$700(WSStatisticsReporter.access$500(this.this$0)));
    WSStatisticsReporter.access$800(this.this$0).putAll(WSStatisticsReporter.access$400(this.this$0).getBaseParams());
    azri.a(BaseApplication.getContext()).a(null, WSStatisticsReporter.access$900(this.this$0), true, 0L, 0L, WSStatisticsReporter.access$800(this.this$0), "", WSStatisticsReporter.access$1000(this.this$0));
    WSStatisticsReporter.access$1100(this.this$0);
    tlo.b("WSStatisticsReporter", "event report: " + WSStatisticsReporter.access$900(this.this$0) + ", position: " + (String)WSStatisticsReporter.access$800(this.this$0).get("position") + ",params:" + WSStatisticsReporter.access$800(this.this$0).toString() + " isFlush: " + WSStatisticsReporter.access$1000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.1
 * JD-Core Version:    0.7.0.1
 */