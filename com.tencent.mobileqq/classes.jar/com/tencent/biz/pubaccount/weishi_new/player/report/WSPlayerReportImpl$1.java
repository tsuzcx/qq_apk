package com.tencent.biz.pubaccount.weishi_new.player.report;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.Properties;
import ulc;
import uln;
import ulo;
import uqf;

public class WSPlayerReportImpl$1
  implements Runnable
{
  public WSPlayerReportImpl$1(ulo paramulo, ulc paramulc) {}
  
  public void run()
  {
    if (ulo.a(this.this$0)) {
      return;
    }
    Properties localProperties = this.a.a().getPlayDetailsTime();
    ulo.a(this.this$0).h = Long.valueOf(localProperties.getProperty("httpdnsMS")).longValue();
    ulo.a(this.this$0).i = Long.valueOf(localProperties.getProperty("httpredirectMS")).longValue();
    ulo.a(this.this$0).m = Long.valueOf(localProperties.getProperty("cacheframeMS")).longValue();
    ulo.a(this.this$0).j = Long.valueOf(localProperties.getProperty("httpfirstrecvMS")).longValue();
    ulo.a(this.this$0).l = Long.valueOf(localProperties.getProperty("getmp4headerMS")).longValue();
    ulo.a(this.this$0).k = Long.valueOf(localProperties.getProperty("httpconnectMS")).longValue();
    uqf.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onVideoPrepared] mHttpDNSTime:" + ulo.a(this.this$0).h + ", mHttpRedirectTime:" + ulo.a(this.this$0).i + ", mCacheFrameTime:" + ulo.a(this.this$0).m + ", mHttpFirstReceiveTime:" + ulo.a(this.this$0).j + ", mMp4HeaderParseTime:" + ulo.a(this.this$0).l + ", mHttpConnectTime:" + ulo.a(this.this$0).k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReportImpl.1
 * JD-Core Version:    0.7.0.1
 */