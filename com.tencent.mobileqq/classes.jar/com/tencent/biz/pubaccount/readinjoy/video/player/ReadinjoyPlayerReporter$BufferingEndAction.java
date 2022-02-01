package com.tencent.biz.pubaccount.readinjoy.video.player;

import android.os.SystemClock;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;

public class ReadinjoyPlayerReporter$BufferingEndAction
  extends ReadinjoyPlayerReporter.ReportInfoAction
{
  public ReadinjoyPlayerReporter$BufferingEndAction(ReadinjoyPlayerReporter paramReadinjoyPlayerReporter)
  {
    super(paramReadinjoyPlayerReporter);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    paramObject = this.a.a;
    paramObject.f += SystemClock.uptimeMillis() - this.a.a.e;
    paramObject = this.a.a;
    paramObject.c += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter.BufferingEndAction
 * JD-Core Version:    0.7.0.1
 */