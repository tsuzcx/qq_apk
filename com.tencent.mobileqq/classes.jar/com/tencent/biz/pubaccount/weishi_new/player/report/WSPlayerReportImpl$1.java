package com.tencent.biz.pubaccount.weishi_new.player.report;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.Properties;
import uke;
import ukp;
import ukq;
import upe;

public class WSPlayerReportImpl$1
  implements Runnable
{
  public WSPlayerReportImpl$1(ukq paramukq, uke paramuke) {}
  
  public void run()
  {
    if (ukq.a(this.this$0)) {
      return;
    }
    Properties localProperties = this.a.a().getPlayDetailsTime();
    ukq.a(this.this$0).h = Long.valueOf(localProperties.getProperty("httpdnsMS")).longValue();
    ukq.a(this.this$0).i = Long.valueOf(localProperties.getProperty("httpredirectMS")).longValue();
    ukq.a(this.this$0).m = Long.valueOf(localProperties.getProperty("cacheframeMS")).longValue();
    ukq.a(this.this$0).j = Long.valueOf(localProperties.getProperty("httpfirstrecvMS")).longValue();
    ukq.a(this.this$0).l = Long.valueOf(localProperties.getProperty("getmp4headerMS")).longValue();
    ukq.a(this.this$0).k = Long.valueOf(localProperties.getProperty("httpconnectMS")).longValue();
    upe.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onVideoPrepared] mHttpDNSTime:" + ukq.a(this.this$0).h + ", mHttpRedirectTime:" + ukq.a(this.this$0).i + ", mCacheFrameTime:" + ukq.a(this.this$0).m + ", mHttpFirstReceiveTime:" + ukq.a(this.this$0).j + ", mMp4HeaderParseTime:" + ukq.a(this.this$0).l + ", mHttpConnectTime:" + ukq.a(this.this$0).k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReportImpl.1
 * JD-Core Version:    0.7.0.1
 */