package com.tencent.biz.pubaccount.Advertisement.fragment;

import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

class VideoCoverFragment$3
  implements TVK_IMediaPlayer.OnCompletionListener
{
  VideoCoverFragment$3(VideoCoverFragment paramVideoCoverFragment) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    VideoCoverFragment.d(this.a);
    int i = this.a.b();
    if ((i > 1) && (VideoCoverFragment.e(this.a) != null)) {
      if (VideoCoverFragment.f(this.a) == i - 1) {
        ThreadManager.getUIHandler().post(new VideoCoverFragment.3.1(this));
      } else {
        ThreadManager.getUIHandler().post(new VideoCoverFragment.3.2(this));
      }
    }
    paramTVK_IMediaPlayer = ((VideoCoverItem)VideoCoverFragment.g(this.a).c.get(VideoCoverFragment.f(this.a))).c;
    ReportController.a(null, "dc00898", "", VideoCoverFragment.g(this.a).g.a, "0X8008F65", "0X8008F65", 0, 0, VideoCoverFragment.g(this.a).g.c, "", paramTVK_IMediaPlayer, VideoCoverFragment.g(this.a).g.b);
    Integer localInteger = (Integer)PublicAccountAdvertisementActivity.d.get(paramTVK_IMediaPlayer);
    i = (int)(((VideoCoverView)((VideoCoverItem)VideoCoverFragment.g(this.a).c.get(VideoCoverFragment.f(this.a))).d).g / 1000L);
    if (localInteger != null)
    {
      PublicAccountAdvertisementActivity.d.put(paramTVK_IMediaPlayer, Integer.valueOf(localInteger.intValue() + i));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverFragment", 2, "current time = null");
    }
    PublicAccountAdvertisementActivity.d.put(paramTVK_IMediaPlayer, Integer.valueOf(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.3
 * JD-Core Version:    0.7.0.1
 */