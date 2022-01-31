package com.tencent.biz.pubaccount.readinjoy.video.player;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.Properties;
import pqb;
import qhw;
import qmr;

public class ReadinjoyPlayerReporter$3
  implements Runnable
{
  public ReadinjoyPlayerReporter$3(qmr paramqmr, qhw paramqhw) {}
  
  public void run()
  {
    if (qmr.a(this.this$0)) {
      return;
    }
    Properties localProperties = this.a.a().getPlayDetailsTime();
    this.this$0.a.f = Long.valueOf(localProperties.getProperty("httpdnsMS")).longValue();
    this.this$0.a.g = Long.valueOf(localProperties.getProperty("httpredirectMS")).longValue();
    this.this$0.a.h = Long.valueOf(localProperties.getProperty("cacheframeMS")).longValue();
    if (1 == this.this$0.a.a) {
      this.this$0.a.i = Long.valueOf(localProperties.getProperty("vidtourlMS")).longValue();
    }
    this.this$0.a.j = Long.valueOf(localProperties.getProperty("httpfirstrecvMS")).longValue();
    this.this$0.a.k = Long.valueOf(localProperties.getProperty("getmp4headerMS")).longValue();
    this.this$0.a.l = Long.valueOf(localProperties.getProperty("httpconnectMS")).longValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter.3
 * JD-Core Version:    0.7.0.1
 */