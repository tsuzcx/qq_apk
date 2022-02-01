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
    Object localObject = this.a.b().n();
    WSPlayerReportImpl.b(this.this$0).t = WSPlayerUtils.a((Properties)localObject, "httpdnsMS");
    WSPlayerReportImpl.b(this.this$0).u = WSPlayerUtils.a((Properties)localObject, "httpredirectMS");
    WSPlayerReportImpl.b(this.this$0).y = WSPlayerUtils.a((Properties)localObject, "cacheframeMS");
    WSPlayerReportImpl.b(this.this$0).v = WSPlayerUtils.a((Properties)localObject, "httpfirstrecvMS");
    WSPlayerReportImpl.b(this.this$0).x = WSPlayerUtils.a((Properties)localObject, "getmp4headerMS");
    WSPlayerReportImpl.b(this.this$0).w = WSPlayerUtils.a((Properties)localObject, "httpconnectMS");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerReportImpl.java][onVideoPrepared] mHttpDNSTime:");
    ((StringBuilder)localObject).append(WSPlayerReportImpl.b(this.this$0).t);
    ((StringBuilder)localObject).append(", mHttpRedirectTime:");
    ((StringBuilder)localObject).append(WSPlayerReportImpl.b(this.this$0).u);
    ((StringBuilder)localObject).append(", mCacheFrameTime:");
    ((StringBuilder)localObject).append(WSPlayerReportImpl.b(this.this$0).y);
    ((StringBuilder)localObject).append(", mHttpFirstReceiveTime:");
    ((StringBuilder)localObject).append(WSPlayerReportImpl.b(this.this$0).v);
    ((StringBuilder)localObject).append(", mMp4HeaderParseTime:");
    ((StringBuilder)localObject).append(WSPlayerReportImpl.b(this.this$0).x);
    ((StringBuilder)localObject).append(", mHttpConnectTime:");
    ((StringBuilder)localObject).append(WSPlayerReportImpl.b(this.this$0).w);
    WSLog.e("WS_VIDEO_REPORT", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReportImpl.1
 * JD-Core Version:    0.7.0.1
 */