package com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;

class VideoFeedsSoftAdBarDelegateForAd$3
  extends Handler
{
  VideoFeedsSoftAdBarDelegateForAd$3(VideoFeedsSoftAdBarDelegateForAd paramVideoFeedsSoftAdBarDelegateForAd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what != 1) {
      return;
    }
    VideoFeedsSoftAdBarDelegateForAd.a(this.a).w.setAlpha(1.0F);
    VideoFeedsSoftAdBarDelegateForAd.a(this.a, true);
    VideoFeedsSoftAdBarDelegateForAd.b(this.a).setVisibility(8);
    paramMessage = this.a;
    VideoFeedsSoftAdBarDelegateForAd.a(paramMessage, VideoFeedsSoftAdBarDelegateForAd.a(paramMessage), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdBarDelegateForAd.3
 * JD-Core Version:    0.7.0.1
 */