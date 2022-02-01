package com.tencent.biz.pubaccount.Advertisement.view;

import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementStatistics;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

class VideoCoverView$6
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  VideoCoverView$6(VideoCoverView paramVideoCoverView) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.i("VideoCoverView", 1, "is prepare");
    if (VideoCoverView.a(this.a) == 1) {
      com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity.b = System.currentTimeMillis();
    }
    ReportController.a(null, "dc00898", "", VideoCoverView.b(this.a).g.a, "0X8008F64", "0X8008F64", 0, 0, VideoCoverView.b(this.a).g.c, "", this.a.e, VideoCoverView.b(this.a).g.b);
    AdvertisementStatistics.a().b(this.a.e, VideoCoverView.c(this.a));
    paramTVK_IMediaPlayer = this.a;
    paramTVK_IMediaPlayer.g = VideoCoverView.d(paramTVK_IMediaPlayer).getDuration();
    if ((this.a.f == 3) || (this.a.f == 4))
    {
      VideoCoverView.d(this.a).start();
      paramTVK_IMediaPlayer = this.a;
      paramTVK_IMediaPlayer.f = 4;
      paramTVK_IMediaPlayer.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView.6
 * JD-Core Version:    0.7.0.1
 */