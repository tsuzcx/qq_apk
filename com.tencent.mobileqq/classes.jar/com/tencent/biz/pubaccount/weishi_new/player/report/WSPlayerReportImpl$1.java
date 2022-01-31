package com.tencent.biz.pubaccount.weishi_new.player.report;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.Properties;
import tho;
import thz;
import tia;
import tlo;

public class WSPlayerReportImpl$1
  implements Runnable
{
  public WSPlayerReportImpl$1(tia paramtia, tho paramtho) {}
  
  public void run()
  {
    if (tia.a(this.this$0)) {
      return;
    }
    Properties localProperties = this.a.a().getPlayDetailsTime();
    tia.a(this.this$0).h = Long.valueOf(localProperties.getProperty("httpdnsMS")).longValue();
    tia.a(this.this$0).i = Long.valueOf(localProperties.getProperty("httpredirectMS")).longValue();
    tia.a(this.this$0).m = Long.valueOf(localProperties.getProperty("cacheframeMS")).longValue();
    tia.a(this.this$0).j = Long.valueOf(localProperties.getProperty("httpfirstrecvMS")).longValue();
    tia.a(this.this$0).l = Long.valueOf(localProperties.getProperty("getmp4headerMS")).longValue();
    tia.a(this.this$0).k = Long.valueOf(localProperties.getProperty("httpconnectMS")).longValue();
    tlo.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onVideoPrepared] mHttpDNSTime:" + tia.a(this.this$0).h + ", mHttpRedirectTime:" + tia.a(this.this$0).i + ", mCacheFrameTime:" + tia.a(this.this$0).m + ", mHttpFirstReceiveTime:" + tia.a(this.this$0).j + ", mMp4HeaderParseTime:" + tia.a(this.this$0).l + ", mHttpConnectTime:" + tia.a(this.this$0).k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReportImpl.1
 * JD-Core Version:    0.7.0.1
 */