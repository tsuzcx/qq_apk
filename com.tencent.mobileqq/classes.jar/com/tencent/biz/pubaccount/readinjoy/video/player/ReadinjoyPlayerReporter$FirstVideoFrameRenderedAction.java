package com.tencent.biz.pubaccount.readinjoy.video.player;

import android.os.SystemClock;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;

public class ReadinjoyPlayerReporter$FirstVideoFrameRenderedAction
  extends ReadinjoyPlayerReporter.ReportInfoAction
{
  public ReadinjoyPlayerReporter$FirstVideoFrameRenderedAction(ReadinjoyPlayerReporter paramReadinjoyPlayerReporter)
  {
    super(paramReadinjoyPlayerReporter);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.a.a.b > 0L)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label75;
      }
    }
    label75:
    for (this.a.a.v = (SystemClock.uptimeMillis() - this.a.a.b);; this.a.a.v = 0L)
    {
      this.a.a.w = (SystemClock.uptimeMillis() - this.a.a.c);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter.FirstVideoFrameRenderedAction
 * JD-Core Version:    0.7.0.1
 */