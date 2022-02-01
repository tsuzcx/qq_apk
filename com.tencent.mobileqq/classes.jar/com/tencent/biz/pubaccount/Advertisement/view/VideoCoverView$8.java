package com.tencent.biz.pubaccount.Advertisement.view;

import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementStatistics;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

class VideoCoverView$8
  implements TVK_IMediaPlayer.OnErrorListener
{
  VideoCoverView$8(VideoCoverView paramVideoCoverView) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.a.f = 7;
    AdvertisementStatistics.a().a(VideoCoverView.b(this.a).g.c, this.a.e);
    this.a.g();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView.8
 * JD-Core Version:    0.7.0.1
 */