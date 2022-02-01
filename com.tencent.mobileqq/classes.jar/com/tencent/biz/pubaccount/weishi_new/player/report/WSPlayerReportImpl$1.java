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
    Properties localProperties = this.a.a().a();
    WSPlayerReportImpl.a(this.this$0).i = WSPlayerUtils.a(localProperties, "httpdnsMS");
    WSPlayerReportImpl.a(this.this$0).j = WSPlayerUtils.a(localProperties, "httpredirectMS");
    WSPlayerReportImpl.a(this.this$0).n = WSPlayerUtils.a(localProperties, "cacheframeMS");
    WSPlayerReportImpl.a(this.this$0).k = WSPlayerUtils.a(localProperties, "httpfirstrecvMS");
    WSPlayerReportImpl.a(this.this$0).m = WSPlayerUtils.a(localProperties, "getmp4headerMS");
    WSPlayerReportImpl.a(this.this$0).l = WSPlayerUtils.a(localProperties, "httpconnectMS");
    WSLog.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onVideoPrepared] mHttpDNSTime:" + WSPlayerReportImpl.a(this.this$0).i + ", mHttpRedirectTime:" + WSPlayerReportImpl.a(this.this$0).j + ", mCacheFrameTime:" + WSPlayerReportImpl.a(this.this$0).n + ", mHttpFirstReceiveTime:" + WSPlayerReportImpl.a(this.this$0).k + ", mMp4HeaderParseTime:" + WSPlayerReportImpl.a(this.this$0).m + ", mHttpConnectTime:" + WSPlayerReportImpl.a(this.this$0).l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReportImpl.1
 * JD-Core Version:    0.7.0.1
 */