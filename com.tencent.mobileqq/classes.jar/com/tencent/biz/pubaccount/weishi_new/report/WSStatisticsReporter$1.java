package com.tencent.biz.pubaccount.weishi_new.report;

import com.google.gson.Gson;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.HashMap;

class WSStatisticsReporter$1
  implements Runnable
{
  WSStatisticsReporter$1(WSStatisticsReporter paramWSStatisticsReporter, String paramString) {}
  
  public void run()
  {
    if (WSStatisticsReporter.access$500(this.this$0) == null) {
      return;
    }
    WSStatisticsReporter.access$500(this.this$0).setEventName(WSStatisticsReporter.access$600(this.this$0));
    Object localObject = this.this$0;
    WSStatisticsReporter.access$900((WSStatisticsReporter)localObject, WSStatisticsReporter.Builder.access$800(WSStatisticsReporter.access$700((WSStatisticsReporter)localObject)));
    localObject = new Gson().toJson(WSStatisticsReporter.Builder.access$800(WSStatisticsReporter.access$700(this.this$0)));
    WSStatisticsReporter.access$500(this.this$0).setExtendInfo((String)localObject);
    WSStatisticsReporter.access$1100(this.this$0).putAll(WSStatisticsReporter.Builder.access$1000(WSStatisticsReporter.access$700(this.this$0)));
    WSStatisticsReporter.access$500(this.this$0).setSubSession(this.a);
    WSStatisticsReporter.access$1100(this.this$0).putAll(WSStatisticsReporter.access$500(this.this$0).getBaseParams());
    UserAction.onUserAction(WSStatisticsReporter.access$600(this.this$0), true, -1L, -1L, WSStatisticsReporter.access$1100(this.this$0), true);
    if (WSStatisticsReporter.access$1200(this.this$0)) {
      WSStatisticsReporter.access$1300(this.this$0);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mEventName :");
    ((StringBuilder)localObject).append(WSStatisticsReporter.access$600(this.this$0));
    ((StringBuilder)localObject).append(", position: ");
    ((StringBuilder)localObject).append((String)WSStatisticsReporter.access$1100(this.this$0).get("position"));
    ((StringBuilder)localObject).append(", sopName: ");
    ((StringBuilder)localObject).append((String)WSStatisticsReporter.access$1100(this.this$0).get("sop_name"));
    ((StringBuilder)localObject).append(", videoPageSession: ");
    ((StringBuilder)localObject).append((String)WSStatisticsReporter.access$1100(this.this$0).get("sub_session_id"));
    WSLog.b("reportVideoSession", ((StringBuilder)localObject).toString());
    WSStatisticsReporter.access$1400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.1
 * JD-Core Version:    0.7.0.1
 */