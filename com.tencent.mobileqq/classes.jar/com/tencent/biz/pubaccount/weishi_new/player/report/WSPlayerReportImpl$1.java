package com.tencent.biz.pubaccount.weishi_new.player.report;

import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayer;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.Properties;

class WSPlayerReportImpl$1
  implements Runnable
{
  WSPlayerReportImpl$1(WSPlayerReportImpl paramWSPlayerReportImpl, WSPlayerWrapper paramWSPlayerWrapper) {}
  
  public void run()
  {
    if (WSPlayerReportImpl.a(this.this$0)) {
      return;
    }
    Object localObject = this.a.a().a();
    WSPlayerReportImpl.a(this.this$0).i = WSPlayerUtils.a((Properties)localObject, "httpdnsMS");
    WSPlayerReportImpl.a(this.this$0).j = WSPlayerUtils.a((Properties)localObject, "httpredirectMS");
    WSPlayerReportImpl.a(this.this$0).n = WSPlayerUtils.a((Properties)localObject, "cacheframeMS");
    WSPlayerReportImpl.a(this.this$0).k = WSPlayerUtils.a((Properties)localObject, "httpfirstrecvMS");
    WSPlayerReportImpl.a(this.this$0).m = WSPlayerUtils.a((Properties)localObject, "getmp4headerMS");
    WSPlayerReportImpl.a(this.this$0).l = WSPlayerUtils.a((Properties)localObject, "httpconnectMS");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerReportImpl.java][onVideoPrepared] mHttpDNSTime:");
    ((StringBuilder)localObject).append(WSPlayerReportImpl.a(this.this$0).i);
    ((StringBuilder)localObject).append(", mHttpRedirectTime:");
    ((StringBuilder)localObject).append(WSPlayerReportImpl.a(this.this$0).j);
    ((StringBuilder)localObject).append(", mCacheFrameTime:");
    ((StringBuilder)localObject).append(WSPlayerReportImpl.a(this.this$0).n);
    ((StringBuilder)localObject).append(", mHttpFirstReceiveTime:");
    ((StringBuilder)localObject).append(WSPlayerReportImpl.a(this.this$0).k);
    ((StringBuilder)localObject).append(", mMp4HeaderParseTime:");
    ((StringBuilder)localObject).append(WSPlayerReportImpl.a(this.this$0).m);
    ((StringBuilder)localObject).append(", mHttpConnectTime:");
    ((StringBuilder)localObject).append(WSPlayerReportImpl.a(this.this$0).l);
    WSLog.e("WS_VIDEO_REPORT", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReportImpl.1
 * JD-Core Version:    0.7.0.1
 */