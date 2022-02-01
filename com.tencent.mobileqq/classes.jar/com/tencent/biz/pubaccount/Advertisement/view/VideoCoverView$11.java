package com.tencent.biz.pubaccount.Advertisement.view;

import android.os.Handler;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class VideoCoverView$11
  implements Runnable
{
  VideoCoverView$11(VideoCoverView paramVideoCoverView) {}
  
  public void run()
  {
    if ((VideoCoverView.d(this.this$0) != null) && (VideoCoverView.d(this.this$0).isPlaying())) {}
    try
    {
      i = (int)((float)VideoCoverView.d(this.this$0).getCurrentPostion() * 1.0F * 100.0F / (float)this.this$0.g);
      if ((VideoCoverView.a(this.this$0) == 1) && (i < VideoCoverView.g(this.this$0).d) && (VideoCoverView.b(this.this$0) != null) && (VideoCoverView.b(this.this$0).g != null)) {
        ReportController.a(null, "dc00898", "", VideoCoverView.b(this.this$0).g.a, "0X8008F65", "0X8008F65", 0, 0, VideoCoverView.b(this.this$0).g.c, "", this.this$0.e, VideoCoverView.b(this.this$0).g.b);
      }
      if (VideoCoverView.h(this.this$0) != VideoCoverView.g(this.this$0).c) {
        break label249;
      }
      if ((i <= VideoCoverView.g(this.this$0).d) && ((i != 0) || (VideoCoverView.g(this.this$0).d <= 50))) {
        break label278;
      }
      localAdvertisementSplitedProgressBar = VideoCoverView.g(this.this$0);
      j = VideoCoverView.h(this.this$0);
      if (i <= 0) {
        break label298;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AdvertisementSplitedProgressBar localAdvertisementSplitedProgressBar;
        int j;
        continue;
        int i = 0;
        continue;
        i = 0;
      }
    }
    localAdvertisementSplitedProgressBar.setProgress(j, i);
    break label278;
    label249:
    localAdvertisementSplitedProgressBar = VideoCoverView.g(this.this$0);
    j = VideoCoverView.h(this.this$0);
    if (i > 0)
    {
      localAdvertisementSplitedProgressBar.setProgress(j, i);
      label278:
      VideoCoverView.i(this.this$0).postDelayed(this, 50L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView.11
 * JD-Core Version:    0.7.0.1
 */