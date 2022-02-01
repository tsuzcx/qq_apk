package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.home_watcher.ReadInJoyAdHomeWatcher.OnHomePressedListener;

class ReadInJoyVideoChannelFragment$2
  implements ReadInJoyAdHomeWatcher.OnHomePressedListener
{
  ReadInJoyVideoChannelFragment$2(ReadInJoyVideoChannelFragment paramReadInJoyVideoChannelFragment) {}
  
  public void a()
  {
    VideoPlayManager localVideoPlayManager = this.a.a();
    if ((localVideoPlayManager != null) && (localVideoPlayManager.a() != null))
    {
      if (localVideoPlayManager.a().a()) {
        localVideoPlayManager.a().j();
      }
      localVideoPlayManager.a().d();
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment.2
 * JD-Core Version:    0.7.0.1
 */