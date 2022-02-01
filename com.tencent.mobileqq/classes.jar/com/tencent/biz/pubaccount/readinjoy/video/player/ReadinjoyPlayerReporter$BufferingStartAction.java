package com.tencent.biz.pubaccount.readinjoy.video.player;

import android.os.SystemClock;

public class ReadinjoyPlayerReporter$BufferingStartAction
  extends ReadinjoyPlayerReporter.ReportInfoAction
{
  public ReadinjoyPlayerReporter$BufferingStartAction(ReadinjoyPlayerReporter paramReadinjoyPlayerReporter)
  {
    super(paramReadinjoyPlayerReporter);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    this.a.a.e = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter.BufferingStartAction
 * JD-Core Version:    0.7.0.1
 */