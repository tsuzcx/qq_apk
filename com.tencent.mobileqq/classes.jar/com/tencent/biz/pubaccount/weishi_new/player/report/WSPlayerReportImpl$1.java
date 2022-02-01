package com.tencent.biz.pubaccount.weishi_new.player.report;

import java.util.Properties;
import urw;
import usg;
import ush;
import usk;
import uya;

public class WSPlayerReportImpl$1
  implements Runnable
{
  public WSPlayerReportImpl$1(ush paramush, urw paramurw) {}
  
  public void run()
  {
    long l2 = 0L;
    if (ush.a(this.this$0)) {
      return;
    }
    Properties localProperties = this.a.a().a();
    usg localusg = ush.a(this.this$0);
    if (localProperties != null)
    {
      l1 = Long.valueOf(localProperties.getProperty("httpdnsMS")).longValue();
      localusg.i = l1;
      localusg = ush.a(this.this$0);
      if (localProperties == null) {
        break label362;
      }
      l1 = Long.valueOf(localProperties.getProperty("httpredirectMS")).longValue();
      label89:
      localusg.j = l1;
      localusg = ush.a(this.this$0);
      if (localProperties == null) {
        break label367;
      }
      l1 = Long.valueOf(localProperties.getProperty("cacheframeMS")).longValue();
      label123:
      localusg.n = l1;
      localusg = ush.a(this.this$0);
      if (localProperties == null) {
        break label372;
      }
      l1 = Long.valueOf(localProperties.getProperty("httpfirstrecvMS")).longValue();
      label157:
      localusg.k = l1;
      localusg = ush.a(this.this$0);
      if (localProperties == null) {
        break label377;
      }
    }
    label362:
    label367:
    label372:
    label377:
    for (long l1 = Long.valueOf(localProperties.getProperty("getmp4headerMS")).longValue();; l1 = 0L)
    {
      localusg.m = l1;
      localusg = ush.a(this.this$0);
      l1 = l2;
      if (localProperties != null) {
        l1 = Long.valueOf(localProperties.getProperty("httpconnectMS")).longValue();
      }
      localusg.l = l1;
      uya.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onVideoPrepared] mHttpDNSTime:" + ush.a(this.this$0).i + ", mHttpRedirectTime:" + ush.a(this.this$0).j + ", mCacheFrameTime:" + ush.a(this.this$0).n + ", mHttpFirstReceiveTime:" + ush.a(this.this$0).k + ", mMp4HeaderParseTime:" + ush.a(this.this$0).m + ", mHttpConnectTime:" + ush.a(this.this$0).l);
      return;
      l1 = 0L;
      break;
      l1 = 0L;
      break label89;
      l1 = 0L;
      break label123;
      l1 = 0L;
      break label157;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReportImpl.1
 * JD-Core Version:    0.7.0.1
 */