package com.tencent.biz.pubaccount.weishi_new.player.report;

import java.util.Properties;
import vgh;
import vgr;
import vgs;
import vgv;
import vmp;

public class WSPlayerReportImpl$1
  implements Runnable
{
  public WSPlayerReportImpl$1(vgs paramvgs, vgh paramvgh) {}
  
  public void run()
  {
    long l2 = 0L;
    if (vgs.a(this.this$0)) {
      return;
    }
    Properties localProperties = this.a.a().a();
    vgr localvgr = vgs.a(this.this$0);
    if (localProperties != null)
    {
      l1 = Long.valueOf(localProperties.getProperty("httpdnsMS")).longValue();
      localvgr.i = l1;
      localvgr = vgs.a(this.this$0);
      if (localProperties == null) {
        break label362;
      }
      l1 = Long.valueOf(localProperties.getProperty("httpredirectMS")).longValue();
      label89:
      localvgr.j = l1;
      localvgr = vgs.a(this.this$0);
      if (localProperties == null) {
        break label367;
      }
      l1 = Long.valueOf(localProperties.getProperty("cacheframeMS")).longValue();
      label123:
      localvgr.n = l1;
      localvgr = vgs.a(this.this$0);
      if (localProperties == null) {
        break label372;
      }
      l1 = Long.valueOf(localProperties.getProperty("httpfirstrecvMS")).longValue();
      label157:
      localvgr.k = l1;
      localvgr = vgs.a(this.this$0);
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
      localvgr.m = l1;
      localvgr = vgs.a(this.this$0);
      l1 = l2;
      if (localProperties != null) {
        l1 = Long.valueOf(localProperties.getProperty("httpconnectMS")).longValue();
      }
      localvgr.l = l1;
      vmp.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onVideoPrepared] mHttpDNSTime:" + vgs.a(this.this$0).i + ", mHttpRedirectTime:" + vgs.a(this.this$0).j + ", mCacheFrameTime:" + vgs.a(this.this$0).n + ", mHttpFirstReceiveTime:" + vgs.a(this.this$0).k + ", mMp4HeaderParseTime:" + vgs.a(this.this$0).m + ", mHttpConnectTime:" + vgs.a(this.this$0).l);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReportImpl.1
 * JD-Core Version:    0.7.0.1
 */